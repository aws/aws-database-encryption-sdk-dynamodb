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
  using the MRK multi-keyring. This keyring takes in multiple AWS KMS
  MRKs (multi-region keys) or regular AWS KMS keys (single-region keys)
  and uses them to encrypt and decrypt data. Data encrypted using an MRK
  multi-keyring can be decrypted using any of its component keys. If a component
  key is an MRK with a replica in a second region, the replica key can also be
  used to decrypt data.

  For more information on MRKs, see
  https://docs.aws.amazon.com/kms/latest/developerguide/multi-region-keys-overview.html

  For more information on multi-keyrings, see
  https://docs.aws.amazon.com/encryption-sdk/latest/developer-guide/use-multi-keyring.html

  This example creates a new MRK multi-keyring consisting of one MRK
  (labeled as the "generator keyring") and one single-region key (labeled
   as the only "child keyring"). The MRK also has a replica in a second region.

  This example encrypts a test item using the MRK multi-keyring and puts the
  encrypted item to the provided DynamoDb table. Then, it gets the item
  from the table and decrypts it using three different configs:
    1. The MRK multi-keyring, where the MRK key is used to decrypt
    2. Another MRK multi-keyring, where the replica MRK key is used to decrypt
    3. Another MRK multi-keyring, where the single-region key that was present
       in the original MRK multi-keyring is used to decrypt

  Running this example requires access to the DDB Table whose name
  is provided in CLI arguments.
  This table must be configured with the following
  primary key configuration:
    - Partition key is named "partition_key" with type (S)
    - Sort key is named "sort_key" with type (S)

  This example demonstrates multi-region use cases. As a result,
  it requires that you have a default region set in your AWS client.
  You can set a default region through the AWS CLI with
  `aws configure set region [region-name]`
  e.g.
  `aws configure set region us-west-2`
  For more information on using AWS CLI to set config, see
  https://awscli.amazonaws.com/v2/documentation/api/latest/reference/configure/set.html
 */
public class MultiMrkKeyringExample
{
    public static async Task MultiMrkKeyringGetItemPutItem()
    {
        var ddbTableName = TestUtils.TEST_DDB_TABLE_NAME;
        var mrkKeyArn = TestUtils.TEST_MRK_KEY_ID;
        var keyArn = TestUtils.TEST_KMS_KEY_ID;
        var mrkReplicaKeyArn = TestUtils.TEST_MRK_REPLICA_KEY_ID_US_EAST_1;

        // 1. Create a single MRK multi-keyring using the MRK arn and the single-region key arn.
        var matProv = new MaterialProviders(new MaterialProvidersConfig());
        // Create the multi-keyring, using the MRK as the generator key,
        //   and the single-region key as a child key.
        // Note that the generator key will generate and encrypt a plaintext data key
        //   and all child keys will only encrypt that same plaintext data key.
        // As such, you must have permission to call KMS:GenerateDataKey on your generator key
        //   and permission to call KMS:Encrypt on all child keys.
        // For more information, see the AWS docs on multi-keyrings above.
        var createAwsKmsMrkMultiKeyringInput = new CreateAwsKmsMrkMultiKeyringInput
        {
            Generator = mrkKeyArn,
            KmsKeyIds = new List<String> { keyArn }
        };
        var awsKmsMrkMultiKeyring = matProv.CreateAwsKmsMrkMultiKeyring(createAwsKmsMrkMultiKeyringInput);

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
        const string unsignAttrPrefix = ":";

        // 4. Create the DynamoDb Encryption configuration for the table we will be writing to.
        var tableConfigs = new Dictionary<String, DynamoDbTableEncryptionConfig>
        {
            [ddbTableName] = new DynamoDbTableEncryptionConfig
            {
                LogicalTableName = ddbTableName,
                PartitionKeyName = "partition_key",
                SortKeyName = "sort_key",
                AttributeActionsOnEncrypt = attributeActionsOnEncrypt,
                Keyring = awsKmsMrkMultiKeyring,
                AllowedUnsignedAttributePrefix = unsignAttrPrefix
            }
        };

        // 5. Create the DynamoDb Encryption Interceptor
        var ddbClient = new Client.DynamoDbClient(
            new DynamoDbTablesEncryptionConfig { TableEncryptionConfigs = tableConfigs });

        // 6. Put an item into our table using the above client.
        //    Before the item gets sent to DynamoDb, it will be encrypted
        //    client-side using the MRK multi-keyring.
        //    The data key protecting this item will be encrypted
        //    with all the KMS Keys in this keyring, so that it can be
        //    decrypted with any one of those KMS Keys.
        var item = new Dictionary<String, AttributeValue>
        {
            ["partition_key"] = new AttributeValue("awsKmsMrkMultiKeyringItem"),
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

        // 8. Get the item back from our table using the client.
        //    The client will decrypt the item client-side using the MRK
        //    and return back the original item.
        //    Since the generator key is the first available key in the keyring,
        //    that is the KMS Key that will be used to decrypt this item.
        var keyToGet = new Dictionary<String, AttributeValue>
        {
            ["partition_key"] = new AttributeValue("awsKmsMrkMultiKeyringItem"),
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

        // 9. Create a MRK keyring using the replica MRK arn.
        //    We will use this to demonstrate that the replica MRK
        //    can decrypt data created with the original MRK,
        //    even when the replica MRK was not present in the
        //    encrypting multi-keyring.
        var onlyReplicaKeyCreateAwsKmsMrkMultiKeyringInput = new CreateAwsKmsMrkMultiKeyringInput
        {
            KmsKeyIds = new List<String> { mrkReplicaKeyArn }
        };

        var onlyReplicaKeyMrkMultiKeyring =
            matProv.CreateAwsKmsMrkMultiKeyring(onlyReplicaKeyCreateAwsKmsMrkMultiKeyringInput);

        // 10. Create a new config and client using the MRK keyring.
        //     This is the same setup as above, except we provide the MRK keyring to the config.
        var onlyReplicaKeyTableConfigs = new Dictionary<String, DynamoDbTableEncryptionConfig>
        {
            [ddbTableName] = new DynamoDbTableEncryptionConfig
            {
                LogicalTableName = ddbTableName,
                PartitionKeyName = "partition_key",
                SortKeyName = "sort_key",
                AttributeActionsOnEncrypt = attributeActionsOnEncrypt,
                // Only replica keyring added here
                Keyring = onlyReplicaKeyMrkMultiKeyring,
                AllowedUnsignedAttributePrefix = unsignAttrPrefix
            }
        };

        var onlyReplicaKeyDdbClient = new Client.DynamoDbClient(
            new DynamoDbTablesEncryptionConfig { TableEncryptionConfigs = onlyReplicaKeyTableConfigs });

        // 11. Get the item back from our table using the client configured with the replica.
        //    The client will decrypt the item client-side using the replica MRK
        //    and return back the original item.
        var onlyReplicaKeyKeyToGet = new Dictionary<String, AttributeValue>
        {
            ["partition_key"] = new AttributeValue("awsKmsMrkMultiKeyringItem"),
            ["sort_key"] = new AttributeValue { N = "0" }
        };

        var onlyReplicaKeyGetRequest = new GetItemRequest
        {
            Key = onlyReplicaKeyKeyToGet,
            TableName = ddbTableName
        };

        var onlyReplicaKeyGetResponse = await onlyReplicaKeyDdbClient.GetItemAsync(onlyReplicaKeyGetRequest);

        // Demonstrate that GetItem succeeded and returned the decrypted item
        Debug.Assert(onlyReplicaKeyGetResponse.HttpStatusCode == HttpStatusCode.OK);
        var onlyReplicaKeyReturnedItem = onlyReplicaKeyGetResponse.Item;
        Debug.Assert(onlyReplicaKeyReturnedItem["sensitive_data"].S.Equals("encrypt and sign me!"));

        // 12. Create an AWS KMS keyring using the single-region key ARN.
        //     We will use this to demonstrate that the single-region key
        //     can decrypt data created with the MRK multi-keyring,
        //     since it is present in the keyring used to encrypt.
        var onlySrkCreateAwsKmsMrkMultiKeyringInput = new CreateAwsKmsMrkMultiKeyringInput
        {
            KmsKeyIds = new List<String> { keyArn }
        };
        IKeyring onlySrkKeyring = matProv.CreateAwsKmsMrkMultiKeyring(onlySrkCreateAwsKmsMrkMultiKeyringInput);

        // 13. Create a new config and client using the AWS KMS keyring.
        //     This is the same setup as above, except we provide the AWS KMS keyring to the config.
        var onlySrkTableConfigs = new Dictionary<String, DynamoDbTableEncryptionConfig>
        {
            [ddbTableName] = new DynamoDbTableEncryptionConfig
            {
                LogicalTableName = ddbTableName,
                PartitionKeyName = "partition_key",
                SortKeyName = "sort_key",
                AttributeActionsOnEncrypt = attributeActionsOnEncrypt,
                // Only single-region key keyring added here
                Keyring = onlySrkKeyring,
                AllowedUnsignedAttributePrefix = unsignAttrPrefix
            }
        };
        var onlySrkDdbClient = new Client.DynamoDbClient(
            new DynamoDbTablesEncryptionConfig { TableEncryptionConfigs = onlySrkTableConfigs });

        // 14. Get the item back from our table using the client configured with the AWS KMS keyring.
        //     The client will decrypt the item client-side using the single-region key
        //     and return back the original item.
        var onlySrkKeyToGet = new Dictionary<String, AttributeValue>
        {
            ["partition_key"] = new AttributeValue("awsKmsMrkMultiKeyringItem"),
            ["sort_key"] = new AttributeValue { N = "0" }
        };

        var onlySrkGetRequest = new GetItemRequest
        {
            Key = onlySrkKeyToGet,
            TableName = ddbTableName
        };

        var onlySrkGetResponse = await onlySrkDdbClient.GetItemAsync(onlySrkGetRequest);

        // Demonstrate that GetItem succeeded and returned the decrypted item
        Debug.Assert(onlySrkGetResponse.HttpStatusCode == HttpStatusCode.OK);
        var onlySrkReturnedItem = onlySrkGetResponse.Item;
        Debug.Assert(onlySrkReturnedItem["sensitive_data"].S.Equals("encrypt and sign me!"));
    }
}