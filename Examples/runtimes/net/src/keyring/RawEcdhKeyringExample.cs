using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using System.Net;
using System.Security.Cryptography.X509Certificates;
using System.Text;
using System.Threading.Tasks;
using Amazon.DynamoDBv2.Model;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb;
using AWS.Cryptography.DbEncryptionSDK.StructuredEncryption;
using AWS.Cryptography.MaterialProviders;
using ECDH;
using Org.BouncyCastle.Asn1;
using Org.BouncyCastle.Asn1.X509;
using Org.BouncyCastle.Asn1.X9;
using Org.BouncyCastle.Crypto;
using Org.BouncyCastle.Crypto.Generators;
using Org.BouncyCastle.Crypto.Parameters;
using Org.BouncyCastle.Security;
using Org.BouncyCastle.Utilities.IO.Pem;
using Org.BouncyCastle.X509;
using software.amazon.cryptography.primitives.internaldafny.types;
using CreateRawEcdhKeyringInput = AWS.Cryptography.MaterialProviders.CreateRawEcdhKeyringInput;
using ECDHCurveSpec = AWS.Cryptography.Primitives.ECDHCurveSpec;
using PemWriter = Org.BouncyCastle.OpenSsl.PemWriter;
using RawEcdhStaticConfigurations = AWS.Cryptography.MaterialProviders.RawEcdhStaticConfigurations;

namespace Examples.keyring;

// These examples set up DynamoDb Encryption for the AWS SDK client
// using the raw ECDH Keyring. This keyring, depending on its KeyAgreement scheme,
// takes in the sender's ECC private key, and the recipient's ECC Public Key to derive a shared secret.
// The keyring uses the shared secret to derive a data key to protect the
// data keys that encrypt and decrypt DynamoDb table items.
//
//
// Running these examples require access to the DDB Table whose name
// is provided in CLI arguments.
// This table must be configured with the following
// primary key configuration:
//   - Partition key is named "partition_key" with type (S)
//   - Sort key is named "sort_key" with type (S)
public class RawEcdhKeyringExample
{
    private static readonly String EXAMPLE_ECC_PRIVATE_KEY_FILENAME_SENDER = "RawEcdhKeyringExamplePrivateKeySender.pem";
    private static readonly String EXAMPLE_ECC_PRIVATE_KEY_FILENAME_RECIPIENT = "RawEcdhKeyringExamplePrivateKeyRecipient.pem";
    private static readonly String EXAMPLE_ECC_PUBLIC_KEY_FILENAME_RECIPIENT = "RawEcdhKeyringExamplePublicKeyRecipient.pem";

    // This example takes in the sender's private key as a
    // UTF8 PEM-encoded (PKCS #8 PrivateKeyInfo structures)
    // located at the file location defined in EXAMPLE_ECC_PRIVATE_KEY_FILENAME_SENDER,
    // the recipient's public key as a UTF8 PEM-encoded X.509 public key, also known as SubjectPublicKeyInfo (SPKI),
    // located at the file location defined in EXAMPLE_ECC_PUBLIC_KEY_FILENAME_RECIPIENT,
    // and the Curve Specification where the keys lie.
    //
    // This example encrypts a test item using the provided ECC keys and puts the
    // encrypted item to the provided DynamoDb table. Then, it gets the
    // item from the table and decrypts it.
    //
    // This examples creates a RawECDH keyring with the RawPrivateKeyToStaticPublicKey key agreement scheme.
    // For more information on this configuration see:
    // https://docs.aws.amazon.com/encryption-sdk/latest/developer-guide/use-raw-ecdh-keyring.html#raw-ecdh-RawPrivateKeyToStaticPublicKey
    //
    // On encrypt, the shared secret is derived from the sender's private key and the recipient's public key.
    // On decrypt, the shared secret is derived from the sender's private key and the recipient's public key;
    // however, on decrypt the recipient can construct a keyring such that the shared secret is calculated with
    // the recipient's private key and the sender's public key. In both scenarios the shared secret will be the same.
    private static async Task RawEcdhKeyringExampleGetItemPutItem()
    {
        var ddbTableName = TestUtils.TEST_DDB_TABLE_NAME;

        // Load key pair from UTF-8 encoded PEM files.
        // You may provide your own PEM files to use here. If you provide this, it MUST
        // be a key on curve P256.
        // If you do not, the main method in this class will generate PEM
        // files for example use. Do not use these files for any other purpose.
        MemoryStream privateKeySenderUtf8EncodedByteBuffer;
        try
        {
            privateKeySenderUtf8EncodedByteBuffer = new MemoryStream(
                File.ReadAllBytes(EXAMPLE_ECC_PRIVATE_KEY_FILENAME_SENDER));
        }
        catch (IOException e)
        {
            throw new IOException("Exception while reading private key from file", e);
        }

        MemoryStream publicKeyRecipientUtf8EncodedByteBuffer;
        try
        {
            var publicKeyBytes = File.ReadAllText(EXAMPLE_ECC_PUBLIC_KEY_FILENAME_RECIPIENT);
            PemReader pemReader = new PemReader(new StringReader(publicKeyBytes));
            publicKeyRecipientUtf8EncodedByteBuffer = new MemoryStream(pemReader.ReadPemObject().Content);
        }
        catch (IOException e)
        {
            throw new IOException("Exception while reading public key from file", e);
        }

        // Create the keyring.
        // This keyring uses static sender and recipient keys. This configuration calls for both of
        // the keys to be on the same curve (P256, P384, P521).
        // On encrypt, the shared secret is derived from the sender's private key and the recipient's public key.
        // For this example, on decrypt, the shared secret is derived from the sender's private key and the recipient's public key;
        // however, on decrypt the recipient can construct a keyring such that the shared secret is calculated with
        // the recipient's private key and the sender's public key. In both scenarios the shared secret will be the same.
        // The DynamoDb encryption client uses this to encrypt and decrypt items.
        var keyringInput = new CreateRawEcdhKeyringInput
        {
            CurveSpec = ECDHCurveSpec.ECC_NIST_P256,
            KeyAgreementScheme = new RawEcdhStaticConfigurations
            {
                // This keyring is configured with a RawPrivateKeyToStaticPublicKey
                // key agreement scheme. This means that both the sender's and recipient's
                // keys are stored somewhere in memory. The recipient's public key MAY be 
                // a public key whose origin is an HSM like AWS KMS.
                RawPrivateKeyToStaticPublicKey = new RawPrivateKeyToStaticPublicKeyInput
                {
                    // Must be a UTF8 PEM-encoded private key
                    SenderStaticPrivateKey = privateKeySenderUtf8EncodedByteBuffer,
                    // Must be a UTF8 DER-encoded X.509 public key also known as SubjectPublicKeyInfo.
                    RecipientPublicKey = publicKeyRecipientUtf8EncodedByteBuffer
                }
            }
        };
        var matProv = new MaterialProviders(new MaterialProvidersConfig());
        var rawEcdhKeyring = matProv.CreateRawEcdhKeyring(keyringInput);

        await PutGetExampleWithKeyring(rawEcdhKeyring, ddbTableName);
    }

    //  This example takes in the recipient's public key located at EXAMPLE_ECC_PUBLIC_KEY_FILENAME_RECIPIENT
    //  as a UTF8 PEM-encoded (PKCS #8 PrivateKeyInfo structures), and the Curve Specification where the key lies.
    //  This examples creates a RawECDH keyring with the EphemeralPrivateKeyToStaticPublicKey key agreement scheme.
    //  This configuration will always create a new key pair as the sender key pair for the key agreement operation.
    //  The ephemeral configuration can only encrypt data and CANNOT decrypt messages.
    //  For more information on this configuration see:
    //  https://docs.aws.amazon.com/encryption-sdk/latest/developer-guide/use-raw-ecdh-keyring.html#raw-ecdh-EphemeralPrivateKeyToStaticPublicKey
    //
    private static async Task EphemeralRawEcdhKeyringPutItem()
    {
        var ddbTableName = TestUtils.TEST_DDB_TABLE_NAME;

        // Load public key from UTF-8 encoded PEM files into a DER encoded public key.
        // You may provide your own PEM files to use here. If you provide this, it MUST
        // be a key on curve P256.
        // If you do not, the main method in this class will generate PEM
        // files for example use. Do not use these files for any other purpose.
        MemoryStream publicKeyRecipientUtf8EncodedByteBuffer;
        try
        {
            var publicKeyBytes = File.ReadAllText(EXAMPLE_ECC_PUBLIC_KEY_FILENAME_RECIPIENT);
            PemReader pemReader = new PemReader(new StringReader(publicKeyBytes));
            publicKeyRecipientUtf8EncodedByteBuffer = new MemoryStream(pemReader.ReadPemObject().Content);
        }
        catch (IOException e)
        {
            throw new IOException("Exception while reading public key from file", e);
        }

        // Create the keyring.
        // This keyring uses an ephemeral configuration. This configuration will always create a new
        // key pair as the sender key pair for the key agreement operation. The ephemeral configuration can only
        // encrypt data and CANNOT decrypt messages.
        // The DynamoDb encryption client uses this to encrypt and decrypt items.
        var keyringInput = new CreateRawEcdhKeyringInput
        {
            // This example uses keys that lie on the ECC Curve P256.
            // The keyring supports curves P256, P384, and P521.
            // On creation, the keyring verifies that all configured keys lie on the provided curve spec.
            CurveSpec = ECDHCurveSpec.ECC_NIST_P256,
            KeyAgreementScheme = new RawEcdhStaticConfigurations
            {
                EphemeralPrivateKeyToStaticPublicKey = new EphemeralPrivateKeyToStaticPublicKeyInput
                {
                    RecipientPublicKey = publicKeyRecipientUtf8EncodedByteBuffer
                }
            }
        };
        var matProv = new MaterialProviders(new MaterialProvidersConfig());
        var rawEcdhKeyring = matProv.CreateRawEcdhKeyring(keyringInput);

        // A raw ecdh keyring with Ephemeral configuration cannot decrypt data since the key pair
        // used as the sender is ephemeral. This means that at decrypt time it does not have
        // the private key that corresponds to the public key that is stored on the message. 
        await PutExampleWithKeyring(rawEcdhKeyring, ddbTableName);
    }

    // This example takes in the recipient's private key located at EXAMPLE_ECC_PRIVATE_KEY_FILENAME_RECIPIENT
    // as a UTF8 PEM-encoded X.509 public key, also known as SubjectPublicKeyInfo (SPKI),
    // and the Curve Specification where the key lies.
    // This examples creates a RawECDH keyring with the PublicKeyDiscovery key agreement scheme.
    // This scheme is only available on decrypt.
    // For more information on this configuration see:
    // https://docs.aws.amazon.com/encryption-sdk/latest/developer-guide/use-raw-ecdh-keyring.html#raw-ecdh-PublicKeyDiscovery
    private static async Task DiscoveryRawEcdhKeyringGetItem()
    {
        var ddbTableName = TestUtils.TEST_DDB_TABLE_NAME;

        // Load key pair from UTF-8 encoded PEM files.
        // You may provide your own PEM files to use here. If you provide this, it MUST
        // be a key on curve P256.
        // If you do not, the main method in this class will generate PEM
        // files for example use. Do not use these files for any other purpose.
        MemoryStream privateKeyRecipientUtf8EncodedByteBuffer;
        try
        {
            privateKeyRecipientUtf8EncodedByteBuffer = new MemoryStream(
                File.ReadAllBytes(EXAMPLE_ECC_PRIVATE_KEY_FILENAME_RECIPIENT));
        }
        catch (IOException e)
        {
            throw new IOException("Exception while reading private key from file", e);
        }

        // Create the keyring.
        // This keyring uses a discovery configuration. This configuration will check on decrypt
        // if it is meant to decrypt the message by checking if the configured public key is stored on the message.
        // The discovery configuration can only decrypt messages and CANNOT encrypt messages.
        // The DynamoDb encryption client uses this to encrypt and decrypt items.
        var keyringInput = new CreateRawEcdhKeyringInput
        {
            // This example uses keys that lie on the ECC Curve P256.
            // The keyring supports curves P256, P384, and P521.
            // On creation, the keyring verifies that all configured keys lie on the provided curve spec.
            CurveSpec = ECDHCurveSpec.ECC_NIST_P256,
            KeyAgreementScheme = new RawEcdhStaticConfigurations
            {
                PublicKeyDiscovery = new PublicKeyDiscoveryInput
                {
                    // Must be a UTF8 PEM-encoded private key
                    RecipientStaticPrivateKey = privateKeyRecipientUtf8EncodedByteBuffer
                }
            }
        };
        var matProv = new MaterialProviders(new MaterialProvidersConfig());
        var rawEcdhKeyring = matProv.CreateRawEcdhKeyring(keyringInput);

        await GetExampleWithKeyring(rawEcdhKeyring, ddbTableName);
    }

    private static async Task PutGetExampleWithKeyring(IKeyring rawEcdhKeyring, string ddbTableName)
    {
        //  Configure which attributes are encrypted and/or signed when writing new items.
        //  For each attribute that may exist on the items we plan to write to our DynamoDbTable,
        //  we must explicitly configure how they should be treated during item encryption:
        //    - ENCRYPT_AND_SIGN: The attribute is encrypted and included in the signature
        //    - SIGN_ONLY: The attribute not encrypted, but is still included in the signature
        //    - DO_NOTHING: The attribute is not encrypted and not included in the signature
        var attributeActionsOnEncrypt = new Dictionary<String, CryptoAction>
        {
            ["partition_key"] = CryptoAction.SIGN_ONLY, // Our partition attribute must be SIGN_ONLY
            ["sort_key"] = CryptoAction.SIGN_ONLY, // Our sort attribute must be SIGN_ONLY
            ["sensitive_data"] = CryptoAction.ENCRYPT_AND_SIGN
        };

        //  Configure which attributes we expect to be included in the signature
        //  when reading items. There are two options for configuring this:
        //
        //  - (Recommended) Configure `allowedUnsignedAttributesPrefix`:
        //    When defining your DynamoDb schema and deciding on attribute names,
        //    choose a distinguishing prefix (such as ":") for all attributes that
        //    you do not want to include in the signature.
        //    This has two main benefits:
        //    - It is easier to reason about the security and authenticity of data within your item
        //      when all unauthenticated data is easily distinguishable by their attribute name.
        //    - If you need to add new unauthenticated attributes in the future,
        //      you can easily make the corresponding update to your `attributeActionsOnEncrypt`
        //      and immediately start writing to that new attribute, without
        //      any other configuration update needed.
        //    Once you configure this field, it is not safe to update it.
        //
        //  - Configure `allowedUnsignedAttributes`: You may also explicitly list
        //    a set of attributes that should be considered unauthenticated when encountered
        //    on read. Be careful if you use this configuration. Do not remove an attribute
        //    name from this configuration, even if you are no longer writing with that attribute,
        //    as old items may still include this attribute, and our configuration needs to know
        //    to continue to exclude this attribute from the signature scope.
        //    If you add new attribute names to this field, you must first deploy the update to this
        //    field to all readers in your host fleet before deploying the update to start writing
        //    with that new attribute.
        //
        //   For this example, we currently authenticate all attributes. To make it easier to
        //   add unauthenticated attributes in the future, we define a prefix ":" for such attributes.
        const String unsignAttrPrefix = ":";

        //  Create the DynamoDb Encryption configuration for the table we will be writing to.
        var tableConfigs = new Dictionary<String, DynamoDbTableEncryptionConfig>
        {
            [ddbTableName] = new DynamoDbTableEncryptionConfig
            {
                LogicalTableName = ddbTableName,
                PartitionKeyName = "partition_key",
                SortKeyName = "sort_key",
                AttributeActionsOnEncrypt = attributeActionsOnEncrypt,
                Keyring = rawEcdhKeyring,
                AllowedUnsignedAttributePrefix = unsignAttrPrefix
            }
        };

        //  Create a new AWS SDK DynamoDb client using the config above
        var ddb = new Client.DynamoDbClient(
            new DynamoDbTablesEncryptionConfig { TableEncryptionConfigs = tableConfigs });

        //  Put an item into our table using the above client.
        //  Before the item gets sent to DynamoDb, it will be encrypted
        //  client-side, according to our configuration.
        var item = new Dictionary<String, AttributeValue>
        {
            ["partition_key"] = new AttributeValue("rawEcdhKeyringItem"),
            ["sort_key"] = new AttributeValue { N = "0" },
            ["sensitive_data"] = new AttributeValue("encrypt and sign me!")
        };

        var putRequest = new PutItemRequest
        {
            TableName = ddbTableName,
            Item = item
        };

        var putResponse = await ddb.PutItemAsync(putRequest);

        // Demonstrate that PutItem succeeded
        Debug.Assert(putResponse.HttpStatusCode == HttpStatusCode.OK);

        //  Get the item back from our table using the same client.
        //  The client will decrypt the item client-side, and return
        //  back the original item.
        var keyToGet = new Dictionary<String, AttributeValue>
        {
            ["partition_key"] = new AttributeValue("rawEcdhKeyringItem"),
            ["sort_key"] = new AttributeValue { N = "0" }
        };

        var getRequest = new GetItemRequest
        {
            Key = keyToGet,
            TableName = ddbTableName
        };

        var getResponse = await ddb.GetItemAsync(getRequest);

        // Demonstrate that GetItem succeeded and returned the decrypted item
        Debug.Assert(getResponse.HttpStatusCode == HttpStatusCode.OK);
        var returnedItem = getResponse.Item;
        Debug.Assert(returnedItem["sensitive_data"].S.Equals("encrypt and sign me!"));
    }
    private static async Task PutExampleWithKeyring(IKeyring rawEcdhKeyring, string ddbTableName)
    {
        //  Configure which attributes are encrypted and/or signed when writing new items.
        //  For each attribute that may exist on the items we plan to write to our DynamoDbTable,
        //  we must explicitly configure how they should be treated during item encryption:
        //    - ENCRYPT_AND_SIGN: The attribute is encrypted and included in the signature
        //    - SIGN_ONLY: The attribute not encrypted, but is still included in the signature
        //    - DO_NOTHING: The attribute is not encrypted and not included in the signature
        var attributeActionsOnEncrypt = new Dictionary<String, CryptoAction>
        {
            ["partition_key"] = CryptoAction.SIGN_ONLY, // Our partition attribute must be SIGN_ONLY
            ["sort_key"] = CryptoAction.SIGN_ONLY, // Our sort attribute must be SIGN_ONLY
            ["sensitive_data"] = CryptoAction.ENCRYPT_AND_SIGN
        };

        //  Configure which attributes we expect to be included in the signature
        //  when reading items. There are two options for configuring this:
        //
        //  - (Recommended) Configure `allowedUnsignedAttributesPrefix`:
        //    When defining your DynamoDb schema and deciding on attribute names,
        //    choose a distinguishing prefix (such as ":") for all attributes that
        //    you do not want to include in the signature.
        //    This has two main benefits:
        //    - It is easier to reason about the security and authenticity of data within your item
        //      when all unauthenticated data is easily distinguishable by their attribute name.
        //    - If you need to add new unauthenticated attributes in the future,
        //      you can easily make the corresponding update to your `attributeActionsOnEncrypt`
        //      and immediately start writing to that new attribute, without
        //      any other configuration update needed.
        //    Once you configure this field, it is not safe to update it.
        //
        //  - Configure `allowedUnsignedAttributes`: You may also explicitly list
        //    a set of attributes that should be considered unauthenticated when encountered
        //    on read. Be careful if you use this configuration. Do not remove an attribute
        //    name from this configuration, even if you are no longer writing with that attribute,
        //    as old items may still include this attribute, and our configuration needs to know
        //    to continue to exclude this attribute from the signature scope.
        //    If you add new attribute names to this field, you must first deploy the update to this
        //    field to all readers in your host fleet before deploying the update to start writing
        //    with that new attribute.
        //
        //   For this example, we currently authenticate all attributes. To make it easier to
        //   add unauthenticated attributes in the future, we define a prefix ":" for such attributes.
        const String unsignAttrPrefix = ":";

        //  Create the DynamoDb Encryption configuration for the table we will be writing to.
        var tableConfigs = new Dictionary<String, DynamoDbTableEncryptionConfig>
        {
            [ddbTableName] = new DynamoDbTableEncryptionConfig
            {
                LogicalTableName = ddbTableName,
                PartitionKeyName = "partition_key",
                SortKeyName = "sort_key",
                AttributeActionsOnEncrypt = attributeActionsOnEncrypt,
                Keyring = rawEcdhKeyring,
                AllowedUnsignedAttributePrefix = unsignAttrPrefix
            }
        };

        //  Create a new AWS SDK DynamoDb client using the config above
        var ddb = new Client.DynamoDbClient(
            new DynamoDbTablesEncryptionConfig { TableEncryptionConfigs = tableConfigs });

        //  Put an item into our table using the above client.
        //    Before the item gets sent to DynamoDb, it will be encrypted
        //    client-side, according to our configuration.
        var item = new Dictionary<String, AttributeValue>
        {
            ["partition_key"] = new AttributeValue("rawEcdhKeyringItem"),
            ["sort_key"] = new AttributeValue { N = "0" },
            ["sensitive_data"] = new AttributeValue("encrypt and sign me!")
        };

        var putRequest = new PutItemRequest
        {
            TableName = ddbTableName,
            Item = item
        };

        var putResponse = await ddb.PutItemAsync(putRequest);

        // Demonstrate that PutItem succeeded
        Debug.Assert(putResponse.HttpStatusCode == HttpStatusCode.OK);

        //  Try to get the item and assert that the ephemeral keyring configuration
        // cannot decrypt data.
        var keyToGet = new Dictionary<String, AttributeValue>
        {
            ["partition_key"] = new AttributeValue("rawEcdhKeyringItem"),
            ["sort_key"] = new AttributeValue { N = "0" }
        };

        var getRequest = new GetItemRequest
        {
            Key = keyToGet,
            TableName = ddbTableName
        };

        try
        {
            await ddb.GetItemAsync(getRequest);
        }
        catch (AwsCryptographicMaterialProvidersException e)
        {
            Debug.Assert(e.Message.Contains("EphemeralPrivateKeyToStaticPublicKey Key Agreement Scheme is forbidden on decrypt."));
        }

    }

    private static async Task GetExampleWithKeyring(IKeyring rawEcdhKeyring, string ddbTableName)
    {
        //  Configure which attributes are encrypted and/or signed when writing new items.
        //  For each attribute that may exist on the items we plan to write to our DynamoDbTable,
        //  we must explicitly configure how they should be treated during item encryption:
        //    - ENCRYPT_AND_SIGN: The attribute is encrypted and included in the signature
        //    - SIGN_ONLY: The attribute not encrypted, but is still included in the signature
        //    - DO_NOTHING: The attribute is not encrypted and not included in the signature
        var attributeActionsOnEncrypt = new Dictionary<String, CryptoAction>
        {
            ["partition_key"] = CryptoAction.SIGN_ONLY, // Our partition attribute must be SIGN_ONLY
            ["sort_key"] = CryptoAction.SIGN_ONLY, // Our sort attribute must be SIGN_ONLY
            ["sensitive_data"] = CryptoAction.ENCRYPT_AND_SIGN
        };

        //  Configure which attributes we expect to be included in the signature
        //  when reading items. There are two options for configuring this:
        //
        //  - (Recommended) Configure `allowedUnsignedAttributesPrefix`:
        //    When defining your DynamoDb schema and deciding on attribute names,
        //    choose a distinguishing prefix (such as ":") for all attributes that
        //    you do not want to include in the signature.
        //    This has two main benefits:
        //    - It is easier to reason about the security and authenticity of data within your item
        //      when all unauthenticated data is easily distinguishable by their attribute name.
        //    - If you need to add new unauthenticated attributes in the future,
        //      you can easily make the corresponding update to your `attributeActionsOnEncrypt`
        //      and immediately start writing to that new attribute, without
        //      any other configuration update needed.
        //    Once you configure this field, it is not safe to update it.
        //
        //  - Configure `allowedUnsignedAttributes`: You may also explicitly list
        //    a set of attributes that should be considered unauthenticated when encountered
        //    on read. Be careful if you use this configuration. Do not remove an attribute
        //    name from this configuration, even if you are no longer writing with that attribute,
        //    as old items may still include this attribute, and our configuration needs to know
        //    to continue to exclude this attribute from the signature scope.
        //    If you add new attribute names to this field, you must first deploy the update to this
        //    field to all readers in your host fleet before deploying the update to start writing
        //    with that new attribute.
        //
        //   For this example, we currently authenticate all attributes. To make it easier to
        //   add unauthenticated attributes in the future, we define a prefix ":" for such attributes.
        const String unsignAttrPrefix = ":";

        //  Create the DynamoDb Encryption configuration for the table we will be writing to.
        var tableConfigs = new Dictionary<String, DynamoDbTableEncryptionConfig>
        {
            [ddbTableName] = new DynamoDbTableEncryptionConfig
            {
                LogicalTableName = ddbTableName,
                PartitionKeyName = "partition_key",
                SortKeyName = "sort_key",
                AttributeActionsOnEncrypt = attributeActionsOnEncrypt,
                Keyring = rawEcdhKeyring,
                AllowedUnsignedAttributePrefix = unsignAttrPrefix
            }
        };

        //  Create a new AWS SDK DynamoDb client using the config above
        var ddb = new Client.DynamoDbClient(
            new DynamoDbTablesEncryptionConfig { TableEncryptionConfigs = tableConfigs });

        //  Attempt to put an item into our table using the above client.
        //  Assert that Discovery configuration cannot encrypt data 
        var item = new Dictionary<String, AttributeValue>
        {
            ["partition_key"] = new AttributeValue("rawEcdhKeyringItem"),
            ["sort_key"] = new AttributeValue { N = "0" },
            ["sensitive_data"] = new AttributeValue("encrypt and sign me!")
        };

        var putRequest = new PutItemRequest
        {
            TableName = ddbTableName,
            Item = item
        };

        try
        {
            await ddb.PutItemAsync(putRequest);
        }
        catch (AwsCryptographicMaterialProvidersException e)
        {
            Debug.Assert(e.Message.Contains("PublicKeyDiscovery Key Agreement Scheme is forbidden on encrypt."));
        }

        //  Get the item back from our table using the same client.
        //  The client will decrypt the item client-side, and return
        //  back the original item.
        var keyToGet = new Dictionary<String, AttributeValue>
        {
            ["partition_key"] = new AttributeValue("rawEcdhKeyringItem"),
            ["sort_key"] = new AttributeValue { N = "0" }
        };

        var getRequest = new GetItemRequest
        {
            Key = keyToGet,
            TableName = ddbTableName
        };

        var getResponse = await ddb.GetItemAsync(getRequest);

        // Demonstrate that GetItem succeeded and returned the decrypted item
        Debug.Assert(getResponse.HttpStatusCode == HttpStatusCode.OK);
        var returnedItem = getResponse.Item;
        Debug.Assert(returnedItem["sensitive_data"].S.Equals("encrypt and sign me!"));
    }

    public static async Task RawEcdhKeyringExamples()
    {
        // You may provide your own ECC Keys in the files located at
        // - EXAMPLE_ECC_PRIVATE_KEY_FILENAME_SENDER
        // - EXAMPLE_ECC_PRIVATE_KEY_FILENAME_RECIPIENT
        // - EXAMPLE_ECC_PUBLIC_KEY_FILENAME_RECIPIENT
        // If these files are not present, this will generate keys for you.
        if (ShouldGenerateNewEccKeys())
        {
            GenerateEccKeyPairs();
        }

        await RawEcdhKeyringExampleGetItemPutItem();
        await EphemeralRawEcdhKeyringPutItem();
        await DiscoveryRawEcdhKeyringGetItem();
    }


    private static bool ShouldGenerateNewEccKeys()
    {
        // If keys already exists; do not overwrite existing keys.
        return !File.Exists(EXAMPLE_ECC_PRIVATE_KEY_FILENAME_SENDER)
               || !File.Exists(EXAMPLE_ECC_PUBLIC_KEY_FILENAME_RECIPIENT)
               || !File.Exists(EXAMPLE_ECC_PRIVATE_KEY_FILENAME_RECIPIENT);
    }

    private static void GenerateEccKeyPairs()
    {
        // Safety check; Validate neither file is present
        if (File.Exists(EXAMPLE_ECC_PRIVATE_KEY_FILENAME_SENDER)
            || File.Exists(EXAMPLE_ECC_PUBLIC_KEY_FILENAME_RECIPIENT)
            || File.Exists(EXAMPLE_ECC_PRIVATE_KEY_FILENAME_RECIPIENT))
        {
            throw new ApplicationException("generateEccKeyPairs will not overwrite existing PEM files.");
        }
        // This code will generate new ECC Keys for example use.
        // The keys will be written to the files:
        // - private sender: EXAMPLE_ECC_PRIVATE_KEY_FILENAME_SENDER 
        // - private recipient: EXAMPLE_ECC_PRIVATE_KEY_FILENAME_RECIPIENT
        // - public recipient: EXAMPLE_ECC_PUBLIC_KEY_FILENAME_RECIPIENT
        // This example uses BouncyCastle's KeyPairGenerator to generate the key pair.
        // In practice, you should not generate this in your code, and should instead
        // retrieve this key from a secure key management system (e.g. HSM)
        // These examples only demonstrate using the P256 curve while the keyring accepts
        // P256, P384, or P521.
        // These keys are created here for example purposes only.
        ECKeyPairGenerator generator;
        try
        {
            generator = new ECKeyPairGenerator();
            SecureRandom rng = new SecureRandom();
            X9ECParameters p = ECNamedCurveTable.GetByName("secp256r1");

            var domainParameters = new ECDomainParameters(p.Curve, p.G, p.N, p.H);
            generator.Init(new ECKeyGenerationParameters(domainParameters, rng));

        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            throw;
        }

        AsymmetricCipherKeyPair senderKeyPair = generator.GenerateKeyPair();
        AsymmetricCipherKeyPair recipientKeyPair = generator.GenerateKeyPair();

        WritePrivateKey(senderKeyPair.Private, EXAMPLE_ECC_PRIVATE_KEY_FILENAME_SENDER);
        WritePrivateKey(recipientKeyPair.Private, EXAMPLE_ECC_PRIVATE_KEY_FILENAME_RECIPIENT);
        WritePublicKey(recipientKeyPair, "secp256r1", EXAMPLE_ECC_PUBLIC_KEY_FILENAME_RECIPIENT);
    }

    private static void WritePrivateKey(AsymmetricKeyParameter privateKey, string fileName)
    {
        var privateKeyStringWriter = new StringWriter();
        var pemWriter = new PemWriter(privateKeyStringWriter);
        pemWriter.WriteObject(privateKey);

        var privateKeyUtf8EncodedBytes = Encoding.UTF8.GetBytes(privateKeyStringWriter.ToString());
        var fc = new FileStream(fileName, FileMode.Create, FileAccess.Write);
        fc.Write(privateKeyUtf8EncodedBytes);
        fc.Close();
    }

    private static void WritePublicKey(AsymmetricCipherKeyPair publicKey, string curveName, string fileName)
    {
        var ecdhCurveSpecFromCurveName = ToEcdhCurveSpec(curveName);
        var spki = KeyGeneration.SerializePublicKey(publicKey, ecdhCurveSpecFromCurveName).CloneAsArray();

        var publicKeyStringWriter = new StringWriter();
        var publicKeyPemWriter = new PemWriter(publicKeyStringWriter);
        publicKeyPemWriter.WriteObject(new PemObject("PUBLIC KEY", spki));
        var publicKeyUtf8EncodedBytes = Encoding.UTF8.GetBytes(publicKeyStringWriter.ToString());
        var fc = new FileStream(fileName, FileMode.Create, FileAccess.Write);
        fc.Write(publicKeyUtf8EncodedBytes);
        fc.Close();
    }

    private static _IECDHCurveSpec ToEcdhCurveSpec(string curveName)
    {
        switch (curveName)
        {
            case "secp256r1": return new ECDHCurveSpec_ECC__NIST__P256();
            case "secp384r1": return new ECDHCurveSpec_ECC__NIST__P384();
            case "secp521r1": return new ECDHCurveSpec_ECC__NIST__P521();
        }
        throw new ApplicationException("Unknown curve: " + curveName);
    }
}
