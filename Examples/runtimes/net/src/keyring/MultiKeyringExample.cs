using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Net;
using System.Threading.Tasks;
using Amazon.DynamoDBv2.Model;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb;
using AWS.Cryptography.DbEncryptionSDK.StructuredEncryption;
using AWS.Cryptography.MaterialProviders;

/*
  This example sets up DynamoDb Encryption for the AWS SDK client
  using the multi-keyring. This keyring takes in multiple keyrings
  and uses them to encrypt and decrypt data. Data encrypted with
  a multi-keyring can be decrypted with any of its component keyrings.

  For more information on multi-keyrings, see
  https://docs.aws.amazon.com/encryption-sdk/latest/developer-guide/use-multi-keyring.html

  This example creates a new multi-keyring consisting of an AWS KMS
  keyring (labeled the "generator keyring") and a raw AES keyring
  (labeled as the only "child keyring"). It encrypts a test item
  using the multi-keyring and puts the encrypted item to the provided
  DynamoDb table. Then, it gets the item from the table and decrypts it
  using only the raw AES keyring.

  This example takes in an `aesKeyBytes` parameter. This parameter
  should be a ByteBuffer representing a 256-bit AES key. If this example
  is run through the class' main method, it will create a new key.
  In practice, users of this library should not randomly generate a key,
  and should instead retrieve an existing key from a secure key
  management system (e.g. an HSM).

  Running this example requires access to the DDB Table whose name
  is provided in CLI arguments.
  This table must be configured with the following
  primary key configuration:
    - Partition key is named "partition_key" with type (S)
    - Sort key is named "sort_key" with type (S)
 */
public class MultiKeyringExample
{
    public static async Task MultiKeyringGetItemPutItem()
    {
        var ddbTableName = TestUtils.TEST_DDB_TABLE_NAME;
        var keyArn = TestUtils.TEST_KMS_KEY_ID;
        var aesKeyBytes = RawAesKeyringExample.GenerateAesKeyBytes();

        // 1. Create the raw AES keyring.
        var matProv = new MaterialProviders(new MaterialProvidersConfig());
        var createRawAesKeyringInput = new CreateRawAesKeyringInput
        {
            KeyName = "my-aes-key-name",
            KeyNamespace = "my-key-namespace",
            WrappingKey = aesKeyBytes,
            WrappingAlg = AesWrappingAlg.ALG_AES256_GCM_IV12_TAG16
        };
        var rawAesKeyring = matProv.CreateRawAesKeyring(createRawAesKeyringInput);

        // 2. Create the AWS KMS keyring.
        //    We create a MRK multi keyring, as this interface also supports
        //    single-region KMS keys (standard KMS keys),
        //    and creates the KMS client for us automatically.
        var createAwsKmsMrkMultiKeyringInput = new CreateAwsKmsMrkMultiKeyringInput
        {
            Generator = keyArn
        };
        var awsKmsMrkMultiKeyring = matProv.CreateAwsKmsMrkMultiKeyring(createAwsKmsMrkMultiKeyringInput);

        // 3. Create the multi-keyring.
        //    We will label the AWS KMS keyring as the generator and the raw AES keyring as the
        //        only child keyring.
        //    You must provide a generator keyring to encrypt data.
        //    You may provide additional child keyrings. Each child keyring will be able to
        //        decrypt data encrypted with the multi-keyring on its own. It does not need
        //        knowledge of any other child keyrings or the generator keyring to decrypt.
        var createMultiKeyringInput = new CreateMultiKeyringInput
        {
            Generator = awsKmsMrkMultiKeyring,
            ChildKeyrings = new List<IKeyring> { rawAesKeyring }
        };
        var multiKeyring = matProv.CreateMultiKeyring(createMultiKeyringInput);

        // 4. Configure which attributes are encrypted and/or signed when writing new items.
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

        // 5. Configure which attributes we expect to be included in the signature
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

        // 6. Create the DynamoDb Encryption configuration for the table we will be writing to.
        //    Note that this example creates one config/client combination for PUT, and another
        //        for GET. The PUT config uses the multi-keyring, while the GET config uses the
        //        raw AES keyring. This is solely done to demonstrate that a keyring included as
        //        a child of a multi-keyring can be used to decrypt data on its own.
        var tableConfigs = new Dictionary<String, DynamoDbTableEncryptionConfig>
        {
            [ddbTableName] = new DynamoDbTableEncryptionConfig
            {
                LogicalTableName = ddbTableName,
                PartitionKeyName = "partition_key",
                SortKeyName = "sort_key",
                AttributeActionsOnEncrypt = attributeActionsOnEncrypt,
                // Multi-keyring is added here
                Keyring = multiKeyring,
                AllowedUnsignedAttributePrefix = unsignAttrPrefix
            }
        };

        // 7. Create a new AWS SDK DynamoDb client using the config above
        var ddbClient = new Client.DynamoDbClient(
            new DynamoDbTablesEncryptionConfig { TableEncryptionConfigs = tableConfigs });

        // 9. Put an item into our table using the above client.
        //    Before the item gets sent to DynamoDb, it will be encrypted
        //    client-side using the multi-keyring.
        //    The item will be encrypted with all wrapping keys in the keyring,
        //    so that it can be decrypted with any one of the keys.
        var item = new Dictionary<String, AttributeValue>
        {
            ["partition_key"] = new AttributeValue("multiKeyringItem"),
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

        // 10. Get the item back from our table using the above client.
        //     The client will decrypt the item client-side using the AWS KMS
        //     keyring, and return back the original item.
        //     Since the generator key is the first available key in the keyring,
        //     that is the key that will be used to decrypt this item.
        var keyToGet = new Dictionary<String, AttributeValue>
        {
            ["partition_key"] = new AttributeValue("multiKeyringItem"),
            ["sort_key"] = new AttributeValue { N = "0" }
        };
        var getRequest = new GetItemRequest
        {
            Key = keyToGet,
            TableName = ddbTableName
        };
        var getResponse = await ddbClient.GetItemAsync(getRequest);

        // Demonstrate that GetItem succeeded and returned the decrypted item
        Debug.Assert(putResponse.HttpStatusCode == HttpStatusCode.OK);
        var returnedItem = getResponse.Item;
        Debug.Assert(returnedItem["sensitive_data"].S.Equals("encrypt and sign me!"));

        // 11. Create a new config and client with only the raw AES keyring to GET the item
        //     This is the same setup as above, except the config uses the `rawAesKeyring`.
        var onlyAesKeyringTableConfigs = new Dictionary<String, DynamoDbTableEncryptionConfig>
        {
            [ddbTableName] = new DynamoDbTableEncryptionConfig
            {
                LogicalTableName = ddbTableName,
                PartitionKeyName = "partition_key",
                SortKeyName = "sort_key",
                AttributeActionsOnEncrypt = attributeActionsOnEncrypt,
                // Raw AES keyring is added here
                Keyring = rawAesKeyring,
                AllowedUnsignedAttributePrefix = unsignAttrPrefix
            }
        };

        var onlyAesKeyringDdbClient = new Client.DynamoDbClient(
            new DynamoDbTablesEncryptionConfig { TableEncryptionConfigs = onlyAesKeyringTableConfigs });

        // 12. Get the item back from our table using the client
        //     configured with only the raw AES keyring.
        //     The client will decrypt the item client-side using the raw
        //     AES keyring, and return back the original item.
        var onlyAesKeyringKeyToGet = new Dictionary<String, AttributeValue>
        {
            ["partition_key"] = new AttributeValue("multiKeyringItem"),
            ["sort_key"] = new AttributeValue { N = "0" }
        };
        var onlyAesKeyringGetRequest = new GetItemRequest
        {
            Key = onlyAesKeyringKeyToGet,
            TableName = ddbTableName
        };
        var onlyAesKeyringGetResponse = await onlyAesKeyringDdbClient.GetItemAsync(onlyAesKeyringGetRequest);

        // Demonstrate that GetItem succeeded and returned the decrypted item
        Debug.Assert(onlyAesKeyringGetResponse.HttpStatusCode == HttpStatusCode.OK);
        var onlyAesKeyringReturnedItem = onlyAesKeyringGetResponse.Item;
        Debug.Assert(onlyAesKeyringReturnedItem["sensitive_data"].S.Equals("encrypt and sign me!"));
    }
}