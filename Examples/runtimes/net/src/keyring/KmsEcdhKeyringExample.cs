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

public class KmsEcdhKeyringExample
{
    private static String EXAMPLE_ECC_PUBLIC_KEY_SENDER_FILENAME =
        "KmsEccKeyringKeyringExamplePublicKeySender.pem";
    private static String EXAMPLE_ECC_PUBLIC_KEY_RECIPIENT_FILENAME =
        "KmsEccKeyringKeyringExamplePublicKeyRecipient.pem";

    public static async Task KmsEcdhKeyringGetItemPutItem()
    {
        var ddbTableName = TestUtils.TEST_DDB_TABLE_NAME;
        var ecdhKeyArnSender = TestUtils.TEST_KMS_ECDH_KEY_ID_P256_SENDER;
        
        
        // 1. Load public keys from UTF-8 encoded PEM files.
        //    You may provide your own PEM files to use here.
        //    If you do not, the main method in this class will generate PEM
        //    files for example use. Do not use these files for any other purpose.
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
        
        // 2. Create the keyring.
        //    The DynamoDb encryption client uses this to encrypt and decrypt items.
        var keyringInput = new CreateAwsKmsEcdhKeyringInput
        {
            // 2. Create a KMS ECDH keyring.
            //    This keyring takes in:
            //     - kmsClient
            //     - kmsKeyId: Must be an ARN representing a KMS ECC key meant for KeyAgreement
            //     - curveSpec: The curve name where the public keys lie
            //     - senderPublicKey: A ByteBuffer of a UTF-8 encoded public
            //                  key for the key passed into kmsKeyId in DER format
            //     - recipientPublicKey: A ByteBuffer of a UTF-8 encoded public key
            //                  for the recipient public key.
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
    
    private static async Task KmsEcdhKeyringDiscoveryGetItem()
    {
        var ddbTableName = TestUtils.TEST_DDB_TABLE_NAME;
        var ecdhKeyArnRecipient = TestUtils.TEST_KMS_ECDH_KEY_ID_P256_RECIPIENT;
        
        // 1. Create a KMS ECDH keyring.
        //    This keyring takes in:
        //     - kmsClient
        //     - recipientKmsIdentifier: Must be an ARN representing a KMS ECC key meant for KeyAgreement
        //     - curveSpec: The curve name where the public keys lie
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
        // 2. Configure which attributes are encrypted and/or signed when writing new items.
        //    For each attribute that may exist on the items we plan to write to our DynamoDbTable,
        //    we must explicitly configure how they should be treated during item encryption:
        //      - ENCRYPT_AND_SIGN: The attribute is encrypted and included in the signature
        //      - SIGN_ONLY: The attribute not encrypted, but is still included in the signature
        //      - DO_NOTHING: The attribute is not encrypted and not included in the signature
        var attributeActionsOnEncrypt = new Dictionary<String, CryptoAction>
        {
            ["partition_key"] = CryptoAction.SIGN_ONLY, // Our partition attribute must be SIGN_ONLY
            ["sort_key"] = CryptoAction.SIGN_ONLY, // Our sort attribute must be SIGN_ONLY
            ["sensitive_data"] = CryptoAction.ENCRYPT_AND_SIGN
        };

        // 3. Configure which attributes we expect to be included in the signature
        //    when reading items. There are two options for configuring this:
        //
        //    - (Recommended) Configure `allowedUnsignedAttributesPrefix`:
        //      When defining your DynamoDb schema and deciding on attribute names,
        //      choose a distinguishing prefix (such as ":") for all attributes that
        //      you do not want to include in the signature.
        //      This has two main benefits:
        //      - It is easier to reason about the security and authenticity of data within your item
        //        when all unauthenticated data is easily distinguishable by their attribute name.
        //      - If you need to add new unauthenticated attributes in the future,
        //        you can easily make the corresponding update to your `attributeActionsOnEncrypt`
        //        and immediately start writing to that new attribute, without
        //        any other configuration update needed.
        //      Once you configure this field, it is not safe to update it.
        //
        //    - Configure `allowedUnsignedAttributes`: You may also explicitly list
        //      a set of attributes that should be considered unauthenticated when encountered
        //      on read. Be careful if you use this configuration. Do not remove an attribute
        //      name from this configuration, even if you are no longer writing with that attribute,
        //      as old items may still include this attribute, and our configuration needs to know
        //      to continue to exclude this attribute from the signature scope.
        //      If you add new attribute names to this field, you must first deploy the update to this
        //      field to all readers in your host fleet before deploying the update to start writing
        //      with that new attribute.
        //
        //   For this example, we currently authenticate all attributes. To make it easier to
        //   add unauthenticated attributes in the future, we define a prefix ":" for such attributes.
        const String unsignAttrPrefix = ":";

        // 4. Create the DynamoDb Encryption configuration for the table we will be writing to.
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

        // 5. Create a new AWS SDK DynamoDb client using the config above
        var ddb = new Client.DynamoDbClient(
            new DynamoDbTablesEncryptionConfig { TableEncryptionConfigs = tableConfigs });

        // 6. Get the item back from our table using the same client.
        //    The client will decrypt the item client-side, and return
        //    back the original item.
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
        // 3. Configure which attributes are encrypted and/or signed when writing new items.
        //    For each attribute that may exist on the items we plan to write to our DynamoDbTable,
        //    we must explicitly configure how they should be treated during item encryption:
        //      - ENCRYPT_AND_SIGN: The attribute is encrypted and included in the signature
        //      - SIGN_ONLY: The attribute not encrypted, but is still included in the signature
        //      - DO_NOTHING: The attribute is not encrypted and not included in the signature
        var attributeActionsOnEncrypt = new Dictionary<String, CryptoAction>
        {
            ["partition_key"] = CryptoAction.SIGN_ONLY, // Our partition attribute must be SIGN_ONLY
            ["sort_key"] = CryptoAction.SIGN_ONLY, // Our sort attribute must be SIGN_ONLY
            ["sensitive_data"] = CryptoAction.ENCRYPT_AND_SIGN
        };

        // 4. Configure which attributes we expect to be included in the signature
        //    when reading items. There are two options for configuring this:
        //
        //    - (Recommended) Configure `allowedUnsignedAttributesPrefix`:
        //      When defining your DynamoDb schema and deciding on attribute names,
        //      choose a distinguishing prefix (such as ":") for all attributes that
        //      you do not want to include in the signature.
        //      This has two main benefits:
        //      - It is easier to reason about the security and authenticity of data within your item
        //        when all unauthenticated data is easily distinguishable by their attribute name.
        //      - If you need to add new unauthenticated attributes in the future,
        //        you can easily make the corresponding update to your `attributeActionsOnEncrypt`
        //        and immediately start writing to that new attribute, without
        //        any other configuration update needed.
        //      Once you configure this field, it is not safe to update it.
        //
        //    - Configure `allowedUnsignedAttributes`: You may also explicitly list
        //      a set of attributes that should be considered unauthenticated when encountered
        //      on read. Be careful if you use this configuration. Do not remove an attribute
        //      name from this configuration, even if you are no longer writing with that attribute,
        //      as old items may still include this attribute, and our configuration needs to know
        //      to continue to exclude this attribute from the signature scope.
        //      If you add new attribute names to this field, you must first deploy the update to this
        //      field to all readers in your host fleet before deploying the update to start writing
        //      with that new attribute.
        //
        //   For this example, we currently authenticate all attributes. To make it easier to
        //   add unauthenticated attributes in the future, we define a prefix ":" for such attributes.
        const String unsignAttrPrefix = ":";

        // 5. Create the DynamoDb Encryption configuration for the table we will be writing to.
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

        // 6. Create a new AWS SDK DynamoDb client using the config above
        var ddb = new Client.DynamoDbClient(
            new DynamoDbTablesEncryptionConfig { TableEncryptionConfigs = tableConfigs });

        // 7. Put an item into our table using the above client.
        //    Before the item gets sent to DynamoDb, it will be encrypted
        //    client-side, according to our configuration.
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

        // 8. Get the item back from our table using the same client.
        //    The client will decrypt the item client-side, and return
        //    back the original item.
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
