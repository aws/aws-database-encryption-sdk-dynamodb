using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using System.Net;
using System.Text;
using System.Threading.Tasks;
using Amazon.DynamoDBv2.Model;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb;
using AWS.Cryptography.DbEncryptionSDK.StructuredEncryption;
using AWS.Cryptography.MaterialProviders;
using Amazon.KeyManagementService;
using Amazon.KeyManagementService.Model;
using Org.BouncyCastle.Utilities.IO.Pem;
using PemWriter = Org.BouncyCastle.OpenSsl.PemWriter;

/*
  This example sets up DynamoDb Encryption for the AWS SDK client
  using the KMS RSA Keyring. This keyring uses a KMS RSA key pair to
  encrypt and decrypt records. The client uses the downloaded public key
  to encrypt items it adds to the table.
  The keyring uses the private key to decrypt existing table items it retrieves,
  by calling KMS' decrypt API.

  Running this example requires access to the DDB Table whose name
  is provided in CLI arguments.
  This table must be configured with the following
  primary key configuration:
    - Partition key is named "partition_key" with type (S)
    - Sort key is named "sort_key" with type (S)
  This example also requires access to a KMS RSA key.
  Our tests provide a KMS RSA ARN that anyone can use, but you
  can also provide your own KMS RSA key.
  To use your own KMS RSA key, you must have either:
   - Its public key downloaded in a UTF-8 encoded PEM file
   - kms:GetPublicKey permissions on that key
  If you do not have the public key downloaded, running this example
  through its main method will download the public key for you
  by calling kms:GetPublicKey.
  You must also have kms:Decrypt permissions on the KMS RSA key.
 */
public class KmsRsaKeyringExample
{
    private static String DEFAULT_EXAMPLE_RSA_PUBLIC_KEY_FILENAME = "KmsRsaKeyringExamplePublicKey.pem";

    public static async Task KmsRsaKeyringGetItemPutItem()
    {
        var ddbTableName = TestUtils.TEST_DDB_TABLE_NAME;
        var rsaKeyArn = TestUtils.TEST_KMS_RSA_KEY_ID;

        // You may provide your own RSA public key at EXAMPLE_RSA_PUBLIC_KEY_FILENAME.
        // This must be the public key for the RSA key represented at rsaKeyArn.
        // If this file is not present, this will write a UTF-8 encoded PEM file for you.
        if (ShouldGetNewPublicKey(DEFAULT_EXAMPLE_RSA_PUBLIC_KEY_FILENAME))
        {
            await WritePublicKeyPemForRsaKey(TestUtils.TEST_KMS_RSA_KEY_ID, DEFAULT_EXAMPLE_RSA_PUBLIC_KEY_FILENAME);
        }

        // 1. Load UTF-8 encoded public key PEM file.
        //    You may have an RSA public key file already defined.
        //    If not, the main method in this class will call
        //    the KMS RSA key, retrieve its public key, and store it
        //    in a PEM file for example use.
        MemoryStream publicKeyUtf8EncodedByteBuffer;
        publicKeyUtf8EncodedByteBuffer = new MemoryStream(File.ReadAllBytes(DEFAULT_EXAMPLE_RSA_PUBLIC_KEY_FILENAME));

        // 2. Create a KMS RSA keyring.
        //    This keyring takes in:
        //     - kmsClient
        //     - kmsKeyId: Must be an ARN representing a KMS RSA key
        //     - publicKey: A ByteBuffer of a UTF-8 encoded PEM file representing the public
        //                  key for the key passed into kmsKeyId
        //     - encryptionAlgorithm: Must be either RSAES_OAEP_SHA_256 or RSAES_OAEP_SHA_1
        var matProv = new MaterialProviders(new MaterialProvidersConfig());
        var createAwsKmsRsaKeyringInput = new CreateAwsKmsRsaKeyringInput
        {
            KmsClient = new AmazonKeyManagementServiceClient(),
            KmsKeyId = rsaKeyArn,
            PublicKey = publicKeyUtf8EncodedByteBuffer,
            EncryptionAlgorithm = EncryptionAlgorithmSpec.RSAES_OAEP_SHA_256
        };
        IKeyring awsKmsRsaKeyring = matProv.CreateAwsKmsRsaKeyring(createAwsKmsRsaKeyringInput);

        // 3. Configure which attributes are encrypted and/or signed when writing new items.
        //    For each attribute that may exist on the items we plan to write to our DynamoDbTable,
        //    we must explicitly configure how they should be treated during item encryption:
        //      - ENCRYPT_AND_SIGN: The attribute is encrypted and included in the signature
        //      - SIGN_ONLY: The attribute not encrypted, but is still included in the signature
        //      - DO_NOTHING: The attribute is not encrypted and not included in the signature
        var attributeActions = new Dictionary<String, CryptoAction>
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
        //        you can easily make the corresponding update to your `attributeActions`
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
        //    Note: To use the KMS RSA keyring, your table config must specify an algorithmSuite
        //    that does not use asymmetric signing.
        var tableConfigs = new Dictionary<String, DynamoDbTableEncryptionConfig>
        {
            [ddbTableName] = new DynamoDbTableEncryptionConfig
            {
                LogicalTableName = ddbTableName,
                PartitionKeyName = "partition_key",
                SortKeyName = "sort_key",
                AttributeActionsOnEncrypt = attributeActions,
                Keyring = awsKmsRsaKeyring,
                AllowedUnsignedAttributePrefix = unsignAttrPrefix,
                // Specify algorithmSuite without asymmetric signing here
                // As of v3.0.0, the only supported algorithmSuite without asymmetric signing is
                // ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_SYMSIG_HMAC_SHA384.
                AlgorithmSuiteId = DBEAlgorithmSuiteId.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_SYMSIG_HMAC_SHA384
            }
        };

        // 6. Create a new AWS SDK DynamoDb client using the DynamoDb Encryption Interceptor above
        var ddbClient = new Client.DynamoDbClient(
            new DynamoDbTablesEncryptionConfig { TableEncryptionConfigs = tableConfigs });

        // 7. Put an item into our table using the above client.
        //    Before the item gets sent to DynamoDb, it will be encrypted
        //    client-side, according to our configuration.
        var item = new Dictionary<String, AttributeValue>
        {
            ["partition_key"] = new AttributeValue("awsKmsRsaKeyringItem"),
            ["sort_key"] = new AttributeValue { N = "0" },
            ["sensitive_data"] = new AttributeValue("encrypt and sign me!")
        };

        var putRequest = new PutItemRequest
        {
            TableName = ddbTableName,
            Item = item
        };

        var putResponse = await ddbClient.PutItemAsync(putRequest);

        // Demonstrate that PutItem succeeded
        Debug.Assert(putResponse.HttpStatusCode == HttpStatusCode.OK);

        // 9. Get the item back from our table using the client.
        //    The client will decrypt the item client-side using the RSA keyring
        //    and return the original item.
        var keyToGet = new Dictionary<String, AttributeValue>
        {
            ["partition_key"] = new AttributeValue("awsKmsRsaKeyringItem"),
            ["sort_key"] = new AttributeValue { N = "0" }
        };

        var getRequest = new GetItemRequest
        {
            Key = keyToGet,
            TableName = ddbTableName
        };

        var getResponse = await ddbClient.GetItemAsync(getRequest);

        // Demonstrate that GetItem succeeded and returned the decrypted item
        Debug.Assert(getResponse.HttpStatusCode == HttpStatusCode.OK);
        var returnedItem = getResponse.Item;
        Debug.Assert(returnedItem["sensitive_data"].S.Equals("encrypt and sign me!"));
    }

    static bool ShouldGetNewPublicKey(String rsaPublicKeyFilename)
    {
        // Check if a public key file already exists
        return !File.Exists(rsaPublicKeyFilename);
    }

    static async Task WritePublicKeyPemForRsaKey(String rsaKeyArn, String rsaPublicKeyFilename)
    {
        // Safety check: Validate file is not present
        if (File.Exists(rsaPublicKeyFilename))
        {
            throw new ApplicationException("getRsaPublicKey will not overwrite existing PEM files");
        }

        // This code will call KMS to get the public key for the KMS RSA key.
        // You must have kms:GetPublicKey permissions on the key for this to succeed.
        // The public key will be written to the file EXAMPLE_RSA_PUBLIC_KEY_FILENAME.
        var getterForPublicKey = new AmazonKeyManagementServiceClient();
        var response = await getterForPublicKey.GetPublicKeyAsync(
            new GetPublicKeyRequest { KeyId = rsaKeyArn }
        );
        var publicKeyByteArray = response.PublicKey.ToArray();

        StringWriter publicKeyStringWriter = new StringWriter();
        PemWriter publicKeyPemWriter = new PemWriter(publicKeyStringWriter);
        publicKeyPemWriter.WriteObject(new PemObject("PUBLIC KEY", publicKeyByteArray));

        var privateKeyUtf8EncodedByteBuffer = Encoding.UTF8.GetBytes(publicKeyStringWriter.ToString());
        var fc = new FileStream(rsaPublicKeyFilename, FileMode.Create, FileAccess.Write);
        fc.Write(privateKeyUtf8EncodedByteBuffer);
        fc.Close();
    }
}