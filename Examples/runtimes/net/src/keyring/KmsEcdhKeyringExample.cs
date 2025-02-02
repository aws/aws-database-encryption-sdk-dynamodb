using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using System.Net;
using System.Text;
using System.Threading.Tasks;
using Amazon.DynamoDBv2.Model;
using Amazon.KeyManagementService;
using Amazon.KeyManagementService.Model;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb;
using AWS.Cryptography.DbEncryptionSDK.StructuredEncryption;
using AWS.Cryptography.MaterialProviders;
using AWS.Cryptography.Primitives;
using Org.BouncyCastle.Utilities.IO.Pem;
using PemWriter = Org.BouncyCastle.OpenSsl.PemWriter;

namespace Examples.keyring;

/*
  These examples set up DynamoDb Encryption for the AWS SDK client
  using the AWS KMS ECDH Keyring. This keyring, depending on its KeyAgreement scheme,
  takes in the sender's KMS ECC Key ARN, and the recipient's ECC Public Key to derive a shared secret.
  The keyring uses the shared secret to derive a data key to protect the
  data keys that encrypt and decrypt DynamoDb table items.


  Running these examples require access to the DDB Table whose name
  is provided in CLI arguments.
  This table must be configured with the following
  primary key configuration:
    - Partition key is named "partition_key" with type (S)
    - Sort key is named "sort_key" with type (S)
 */
public class KmsEcdhKeyringExample
{
    private static String EXAMPLE_ECC_PUBLIC_KEY_SENDER_FILENAME =
        "KmsEccKeyringKeyringExamplePublicKeySender.pem";
    private static String EXAMPLE_ECC_PUBLIC_KEY_RECIPIENT_FILENAME =
        "KmsEccKeyringKeyringExamplePublicKeyRecipient.pem";

    //  This example takes in the sender's KMS ECC key ARN, the sender's public key,
    //  the recipient's public key, and the algorithm definition where the ECC keys lie.
    //  Both public keys MUST be UTF8 PEM-encoded X.509 public key, also known as SubjectPublicKeyInfo (SPKI),
    //
    //  This example encrypts a test item using the provided ECC keys and puts the
    //  encrypted item to the provided DynamoDb table. Then, it gets the
    //  item from the table and decrypts it.
    //
    //  Running this example requires access to the DDB Table whose name
    //  is provided through the TestUtils.TEST_DDB_TABLE_NAME variable.
    //  This table must be configured with the following
    //  primary key configuration:
    //    - Partition key is named "partition_key" with type (S)
    //    - Sort key is named "sort_key" with type (S)
    //  This example also requires access to a KMS ECC key.
    //  Our tests provide a KMS ECC Key ARN that anyone can use, but you
    //  can also provide your own KMS ECC key.
    //  To use your own KMS ECC key, you must have either:
    //   - Its public key downloaded in a UTF-8 encoded PEM file
    //   - kms:GetPublicKey permissions on that key.
    //  If you do not have the public key downloaded, running this example
    //  through its main method will download the public key for you
    //  by calling kms:GetPublicKey.
    //  You must also have kms:DeriveSharedSecret permissions on the KMS ECC key.
    //  This example also requires a recipient ECC Public Key that lies on the same
    //  curve as the sender public key. This examples uses another distinct
    //  KMS ECC Public Key, it does not have to be a KMS key; it can be a
    //  valid SubjectPublicKeyInfo (SPKI) Public Key.
    public static async Task KmsEcdhKeyringGetItemPutItem()
    {
        var ddbTableName = TestUtils.TEST_DDB_TABLE_NAME;
        var ecdhKeyArnSender = TestUtils.TEST_KMS_ECDH_KEY_ID_P256_SENDER;


        // Load UTF-8 encoded public key PEM files as DER encoded bytes.
        // You may provide your own PEM files to use here. If you provide this, it MUST
        // be a key on curve P256.
        // If not, the main method in this class will call
        // the KMS ECC key, retrieve its public key, and store it
        // in a PEM file for example use.
        MemoryStream publicKeySenderUtf8EncodedByteBuffer;
        try
        {
            var publicKeyBytes = File.ReadAllText(EXAMPLE_ECC_PUBLIC_KEY_SENDER_FILENAME);
            PemReader pemReader = new PemReader(new StringReader(publicKeyBytes));
            publicKeySenderUtf8EncodedByteBuffer = new MemoryStream(pemReader.ReadPemObject().Content);
        }
        catch (IOException e)
        {
            throw new IOException("Exception while reading private key from file", e);
        }

        MemoryStream publicKeyRecipientUtf8EncodedByteBuffer;
        try
        {
            var publicKeyBytes = File.ReadAllText(EXAMPLE_ECC_PUBLIC_KEY_RECIPIENT_FILENAME);
            PemReader pemReader = new PemReader(new StringReader(publicKeyBytes));
            publicKeyRecipientUtf8EncodedByteBuffer = new MemoryStream(pemReader.ReadPemObject().Content);
        }
        catch (IOException e)
        {
            throw new IOException("Exception while reading public key from file", e);
        }

        // Create a KMS ECDH keyring.
        // This keyring uses the KmsPrivateKeyToStaticPublicKey configuration. This configuration calls for both of
        // the keys to be on the same curve (P256, P384, P521).
        // On encrypt, the keyring calls AWS KMS to derive the shared from the sender's KMS ECC Key ARN and the recipient's public key.
        // For this example, on decrypt, the keyring calls AWS KMS to derive the shared from the sender's KMS ECC Key ARN and the recipient's public key;
        // however, on decrypt the recipient can construct a keyring such that the shared secret is calculated with
        // the recipient's private key and the sender's public key. In both scenarios the shared secret will be the same.
        // For more information on this configuration see:
        // https://docs.aws.amazon.com/encryption-sdk/latest/developer-guide/use-kms-ecdh-keyring.html#kms-ecdh-create
        // The DynamoDb encryption client uses this to encrypt and decrypt items.
        // This keyring takes in:
        //  - kmsClient
        //  - kmsKeyId: Must be an ARN representing a KMS ECC key meant for KeyAgreement
        //  - curveSpec: The curve name where the public keys lie
        //  - senderPublicKey: A ByteBuffer of a UTF-8 encoded public
        //               key for the key passed into kmsKeyId in DER format
        //  - recipientPublicKey: A ByteBuffer of a UTF-8 encoded public
        //               key for the key passed into kmsKeyId in DER format
        var keyringInput = new CreateAwsKmsEcdhKeyringInput
        {
            CurveSpec = ECDHCurveSpec.ECC_NIST_P256,
            KmsClient = new AmazonKeyManagementServiceClient(),
            KeyAgreementScheme = new KmsEcdhStaticConfigurations
            {
                KmsPrivateKeyToStaticPublicKey = new KmsPrivateKeyToStaticPublicKeyInput
                {
                    SenderKmsIdentifier = ecdhKeyArnSender,
                    SenderPublicKey = publicKeySenderUtf8EncodedByteBuffer,
                    RecipientPublicKey = publicKeyRecipientUtf8EncodedByteBuffer
                }
            }
        };
        var matProv = new MaterialProviders(new MaterialProvidersConfig());
        var kmsEcdhKeyring = matProv.CreateAwsKmsEcdhKeyring(keyringInput);

        await PutItemGetItemWithKeyring(kmsEcdhKeyring, ddbTableName);
    }

    // This example takes in the recipient's KMS ECC key ARN,
    // and the algorithm definition where the ECC keys lie.
    //
    // This example attempts to decrypt a test item using the provided eccRecipientKeyArn,
    // it does so by checking if the message header contains the recipient's public key.
    //
    // Running this example requires access to the DDB Table whose name
    // is provided through the TestUtils.TEST_DDB_TABLE_NAME variable.
    //
    // This table must be configured with the following
    // primary key configuration:
    // - Partition key is named "partition_key" with type (S)
    // - Sort key is named "sort_key" with type (S)
    //
    // This example also requires access to a KMS ECC key.
    // Our tests provide a KMS ECC Key ARN that anyone can use, but you
    // can also provide your own KMS ECC key.
    //
    // To use your own KMS ECC key, you must have:
    // - kms:GetPublicKey permissions on that key.
    //
    // This example will call kms:GetPublicKey on keyring creation.
    // You must also have kms:DeriveSharedSecret permissions on the KMS ECC key.
    private static async Task KmsEcdhKeyringDiscoveryGetItem()
    {
        var ddbTableName = TestUtils.TEST_DDB_TABLE_NAME;
        var ecdhKeyArnRecipient = TestUtils.TEST_KMS_ECDH_KEY_ID_P256_RECIPIENT;

        // Create a KMS ECDH keyring.
        // This keyring uses the KmsPublicKeyDiscovery configuration.
        // On encrypt, the keyring will fail as it is not allowed to encrypt data under this configuration.
        // On decrypt, the keyring will check if its corresponding public key is stored in the message header. It
        // will AWS KMS to derive the shared from the recipient's KMS ECC Key ARN and the sender's public key;
        // For more information on this configuration see:
        // https://docs.aws.amazon.com/encryption-sdk/latest/developer-guide/use-kms-ecdh-keyring.html#kms-ecdh-discovery
        // The DynamoDb encryption client uses this to encrypt and decrypt items.
        // This keyring takes in:
        //  - kmsClient
        //  - recipientKmsIdentifier: Must be an ARN representing a KMS ECC key meant for KeyAgreement
        //  - curveSpec: The curve name where the public keys lie
        var keyringInput = new CreateAwsKmsEcdhKeyringInput
        {
            CurveSpec = ECDHCurveSpec.ECC_NIST_P256,
            KmsClient = new AmazonKeyManagementServiceClient(),
            KeyAgreementScheme = new KmsEcdhStaticConfigurations
            {
                KmsPublicKeyDiscovery = new KmsPublicKeyDiscoveryInput
                {
                    RecipientKmsIdentifier = ecdhKeyArnRecipient
                }
            }
        };
        var matProv = new MaterialProviders(new MaterialProvidersConfig());
        var kmsEcdhKeyring = matProv.CreateAwsKmsEcdhKeyring(keyringInput);

        await GetItemWithKeyring(kmsEcdhKeyring, ddbTableName);
    }

    private static async Task GetItemWithKeyring(IKeyring kmsEcdhKeyring, string ddbTableName)
    {
        // Configure which attributes are encrypted and/or signed when writing new items.
        // For each attribute that may exist on the items we plan to write to our DynamoDbTable,
        // we must explicitly configure how they should be treated during item encryption:
        //   - ENCRYPT_AND_SIGN: The attribute is encrypted and included in the signature
        //   - SIGN_ONLY: The attribute not encrypted, but is still included in the signature
        //   - DO_NOTHING: The attribute is not encrypted and not included in the signature
        var attributeActionsOnEncrypt = new Dictionary<String, CryptoAction>
        {
            ["partition_key"] = CryptoAction.SIGN_ONLY, // Our partition attribute must be SIGN_ONLY
            ["sort_key"] = CryptoAction.SIGN_ONLY, // Our sort attribute must be SIGN_ONLY
            ["sensitive_data"] = CryptoAction.ENCRYPT_AND_SIGN
        };

        // Configure which attributes we expect to be included in the signature
        // when reading items. There are two options for configuring this:
        //
        // - (Recommended) Configure `allowedUnsignedAttributesPrefix`:
        //   When defining your DynamoDb schema and deciding on attribute names,
        //   choose a distinguishing prefix (such as ":") for all attributes that
        //   you do not want to include in the signature.
        //   This has two main benefits:
        //   - It is easier to reason about the security and authenticity of data within your item
        //     when all unauthenticated data is easily distinguishable by their attribute name.
        //   - If you need to add new unauthenticated attributes in the future,
        //     you can easily make the corresponding update to your `attributeActionsOnEncrypt`
        //     and immediately start writing to that new attribute, without
        //     any other configuration update needed.
        //   Once you configure this field, it is not safe to update it.
        //
        // - Configure `allowedUnsignedAttributes`: You may also explicitly list
        //   a set of attributes that should be considered unauthenticated when encountered
        //   on read. Be careful if you use this configuration. Do not remove an attribute
        //   name from this configuration, even if you are no longer writing with that attribute,
        //   as old items may still include this attribute, and our configuration needs to know
        //   to continue to exclude this attribute from the signature scope.
        //   If you add new attribute names to this field, you must first deploy the update to this
        //   field to all readers in your host fleet before deploying the update to start writing
        //   with that new attribute.
        //
        //   For this example, we currently authenticate all attributes. To make it easier to
        //   add unauthenticated attributes in the future, we define a prefix ":" for such attributes.
        const String unsignAttrPrefix = ":";

        // Create the DynamoDb Encryption configuration for the table we will be writing to.
        var tableConfigs = new Dictionary<String, DynamoDbTableEncryptionConfig>
        {
            [ddbTableName] = new DynamoDbTableEncryptionConfig
            {
                LogicalTableName = ddbTableName,
                PartitionKeyName = "partition_key",
                SortKeyName = "sort_key",
                AttributeActionsOnEncrypt = attributeActionsOnEncrypt,
                Keyring = kmsEcdhKeyring,
                AllowedUnsignedAttributePrefix = unsignAttrPrefix
            }
        };

        // Create a new AWS SDK DynamoDb client using the config above
        var ddb = new Client.DynamoDbClient(
            new DynamoDbTablesEncryptionConfig { TableEncryptionConfigs = tableConfigs });

        // Get the item back from our table using the same client.
        // The client will decrypt the item client-side, and return
        // back the original item.
        var keyToGet = new Dictionary<String, AttributeValue>
        {
            ["partition_key"] = new AttributeValue("kmsEcdhKeyringItem"),
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

    private static async Task PutItemGetItemWithKeyring(IKeyring kmsEcdhKeyring, string ddbTableName)
    {
        // Configure which attributes are encrypted and/or signed when writing new items.
        // For each attribute that may exist on the items we plan to write to our DynamoDbTable,
        // we must explicitly configure how they should be treated during item encryption:
        //   - ENCRYPT_AND_SIGN: The attribute is encrypted and included in the signature
        //   - SIGN_ONLY: The attribute not encrypted, but is still included in the signature
        //   - DO_NOTHING: The attribute is not encrypted and not included in the signature
        var attributeActionsOnEncrypt = new Dictionary<String, CryptoAction>
        {
            ["partition_key"] = CryptoAction.SIGN_ONLY, // Our partition attribute must be SIGN_ONLY
            ["sort_key"] = CryptoAction.SIGN_ONLY, // Our sort attribute must be SIGN_ONLY
            ["sensitive_data"] = CryptoAction.ENCRYPT_AND_SIGN
        };

        // Configure which attributes we expect to be included in the signature
        // when reading items. There are two options for configuring this:
        //
        // - (Recommended) Configure `allowedUnsignedAttributesPrefix`:
        //   When defining your DynamoDb schema and deciding on attribute names,
        //   choose a distinguishing prefix (such as ":") for all attributes that
        //   you do not want to include in the signature.
        //   This has two main benefits:
        //   - It is easier to reason about the security and authenticity of data within your item
        //     when all unauthenticated data is easily distinguishable by their attribute name.
        //   - If you need to add new unauthenticated attributes in the future,
        //     you can easily make the corresponding update to your `attributeActionsOnEncrypt`
        //     and immediately start writing to that new attribute, without
        //     any other configuration update needed.
        //   Once you configure this field, it is not safe to update it.
        //
        // - Configure `allowedUnsignedAttributes`: You may also explicitly list
        //   a set of attributes that should be considered unauthenticated when encountered
        //   on read. Be careful if you use this configuration. Do not remove an attribute
        //   name from this configuration, even if you are no longer writing with that attribute,
        //   as old items may still include this attribute, and our configuration needs to know
        //   to continue to exclude this attribute from the signature scope.
        //   If you add new attribute names to this field, you must first deploy the update to this
        //   field to all readers in your host fleet before deploying the update to start writing
        //   with that new attribute.
        //
        // For this example, we currently authenticate all attributes. To make it easier to
        // add unauthenticated attributes in the future, we define a prefix ":" for such attributes.
        const String unsignAttrPrefix = ":";

        // Create the DynamoDb Encryption configuration for the table we will be writing to.
        var tableConfigs = new Dictionary<String, DynamoDbTableEncryptionConfig>
        {
            [ddbTableName] = new DynamoDbTableEncryptionConfig
            {
                LogicalTableName = ddbTableName,
                PartitionKeyName = "partition_key",
                SortKeyName = "sort_key",
                AttributeActionsOnEncrypt = attributeActionsOnEncrypt,
                Keyring = kmsEcdhKeyring,
                AllowedUnsignedAttributePrefix = unsignAttrPrefix
            }
        };

        // Create a new AWS SDK DynamoDb client using the config above
        var ddb = new Client.DynamoDbClient(
            new DynamoDbTablesEncryptionConfig { TableEncryptionConfigs = tableConfigs });

        // Put an item into our table using the above client.
        // Before the item gets sent to DynamoDb, it will be encrypted
        // client-side, according to our configuration.
        var item = new Dictionary<String, AttributeValue>
        {
            ["partition_key"] = new AttributeValue("kmsEcdhKeyringItem"),
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

        // Get the item back from our table using the same client.
        // The client will decrypt the item client-side, and return
        // back the original item.
        var keyToGet = new Dictionary<String, AttributeValue>
        {
            ["partition_key"] = new AttributeValue("kmsEcdhKeyringItem"),
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

    public static async Task KmsEcdhKeyringExamples()
    {
        // You may provide your own ECC Keys in the files located at
        // - EXAMPLE_ECC_PUBLIC_KEY_SENDER_FILENAME
        // - EXAMPLE_ECC_PUBLIC_KEY_RECIPIENT_FILENAME
        // If these files are not present, this will get KMS ECC keys for you.
        if (ShouldGetNewEccKeys())
        {
            await WritePublicKeyPemForEccKey(TestUtils.TEST_KMS_ECDH_KEY_ID_P256_SENDER, EXAMPLE_ECC_PUBLIC_KEY_SENDER_FILENAME);
            await WritePublicKeyPemForEccKey(TestUtils.TEST_KMS_ECDH_KEY_ID_P256_RECIPIENT, EXAMPLE_ECC_PUBLIC_KEY_RECIPIENT_FILENAME);
        }

        await KmsEcdhKeyringGetItemPutItem();
        await KmsEcdhKeyringDiscoveryGetItem();
    }

    private static async Task WritePublicKeyPemForEccKey(string kmsEcdhKeyArn, string exampleEccPublicKeySenderFilename)
    {
        // Safety check: Validate file is not present
        if (File.Exists(exampleEccPublicKeySenderFilename))
        {
            throw new ApplicationException("WritePublicKeyPemForEccKey will not overwrite existing PEM files");
        }
        // This code will call KMS to get the public key for the KMS ECC key.
        // You must have kms:GetPublicKey permissions on the key for this to succeed.
        // The public key will be written to the file exampleEccPublicKeySenderFilename.
        var getterForPublicKey = new AmazonKeyManagementServiceClient();
        var response = await getterForPublicKey.GetPublicKeyAsync(
            new GetPublicKeyRequest { KeyId = kmsEcdhKeyArn }
        );
        var publicKeyByteArray = response.PublicKey.ToArray();

        StringWriter publicKeyStringWriter = new StringWriter();
        PemWriter publicKeyPemWriter = new PemWriter(publicKeyStringWriter);
        publicKeyPemWriter.WriteObject(new PemObject("PUBLIC KEY", publicKeyByteArray));

        var publicKeyUtf8EncodedByteBuffer = Encoding.UTF8.GetBytes(publicKeyStringWriter.ToString());
        var fc = new FileStream(exampleEccPublicKeySenderFilename, FileMode.Create, FileAccess.Write);
        fc.Write(publicKeyUtf8EncodedByteBuffer);
        fc.Close();
    }

    private static bool ShouldGetNewEccKeys()
    {
        // If keys already exists; do not overwrite existing keys.
        if (File.Exists(EXAMPLE_ECC_PUBLIC_KEY_SENDER_FILENAME)
            || File.Exists(EXAMPLE_ECC_PUBLIC_KEY_RECIPIENT_FILENAME))
        {
            return false;
        }

        if (!File.Exists(EXAMPLE_ECC_PUBLIC_KEY_SENDER_FILENAME)
            && File.Exists(EXAMPLE_ECC_PUBLIC_KEY_RECIPIENT_FILENAME))
        {
            throw new ApplicationException("Missing public key file at: " + EXAMPLE_ECC_PUBLIC_KEY_SENDER_FILENAME);
        }

        if (File.Exists(EXAMPLE_ECC_PUBLIC_KEY_SENDER_FILENAME)
            && !File.Exists(EXAMPLE_ECC_PUBLIC_KEY_RECIPIENT_FILENAME))
        {
            throw new ApplicationException("Missing public key file at: " + EXAMPLE_ECC_PUBLIC_KEY_RECIPIENT_FILENAME);
        }

        return true;
    }
}
