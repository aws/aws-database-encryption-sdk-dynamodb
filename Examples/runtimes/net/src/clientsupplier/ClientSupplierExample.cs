using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Net;
using System.Threading.Tasks;
using Amazon;
using Amazon.DynamoDBv2.Model;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb;
using AWS.Cryptography.DbEncryptionSDK.StructuredEncryption;
using AWS.Cryptography.MaterialProviders;

/*
  This example sets up an MRK multi-keyring and an MRK discovery
  multi-keyring using a custom client supplier.
  A custom client supplier grants users access to more granular
  configuration aspects of their authentication details and KMS
  client. In this example, we create a simple custom client supplier
  that authenticates with a different IAM role based on the
  region of the KMS key.

  This example creates a MRK multi-keyring configured with a custom
  client supplier using a single MRK and puts an encrypted item to the
  table. Then, it creates a MRK discovery multi-keyring to decrypt the item
  and retrieves the item from the table.

  Running this example requires access to the DDB Table whose name
  is provided in CLI arguments.
  This table must be configured with the following
  primary key configuration:
    - Partition key is named "partition_key" with type (S)
    - Sort key is named "sort_key" with type (S)
 */
public class ClientSupplierExample
{
    public static async Task ClientSupplierPutItemGetItem()
    {
        //     List<String> accountIds, List<String> regions) {
        //  List<String> accounts = Collections.singletonList();
        //  List<String> regions = Collections.singletonList(Region.EU_WEST_1.id());

        var ddbTableName = TestUtils.TEST_DDB_TABLE_NAME;
        // Note that we pass in an MRK in us-east-1...
        var keyArn = TestUtils.TEST_MRK_REPLICA_KEY_ID_US_EAST_1;
        var accountIds = new List<String> { TestUtils.TEST_AWS_ACCOUNT_ID };
        // ...and access its replica in eu-west-1
        var regions = new List<String> { RegionEndpoint.EUWest1.SystemName };

        // 1. Create a single MRK multi-keyring.
        //    This can be either a single-region KMS key or an MRK.
        //    For this example to succeed, the key's region must either
        //    1) be in the regions list, or
        //    2) the key must be an MRK with a replica defined
        //    in a region in the regions list, and the client
        //    must have the correct permissions to access the replica.
        var matProv = new MaterialProviders(new MaterialProvidersConfig());

        // Create the multi-keyring using our custom client supplier
        // defined in the RegionalRoleClientSupplier class in this directory.
        var createAwsKmsMrkMultiKeyringInput = new CreateAwsKmsMrkMultiKeyringInput
        {
            // Note: RegionalRoleClientSupplier will internally use the keyArn's region
            // to retrieve the correct IAM role.
            ClientSupplier = new RegionalRoleClientSupplier(),
            Generator = keyArn
        };
        IKeyring mrkKeyringWithClientSupplier = matProv.CreateAwsKmsMrkMultiKeyring(createAwsKmsMrkMultiKeyringInput);

        // 2. Configure which attributes are encrypted and/or signed when writing new items.
        //    For each attribute that may exist on the items we plan to write to our DynamoDbTable,
        //    we must explicitly configure how they should be treated during item encryption:
        //      - ENCRYPT_AND_SIGN: The attribute is encrypted and included in the signature
        //      - SIGN_ONLY: The attribute is not encrypted, but is still included in the signature
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
                Keyring = mrkKeyringWithClientSupplier,
                AllowedUnsignedAttributePrefix = unsignAttrPrefix
            }
        };

        // 5. Create a new AWS SDK DynamoDb client using the DynamoDb Config above
        var ddbClient = new Client.DynamoDbClient(
            new DynamoDbTablesEncryptionConfig { TableEncryptionConfigs = tableConfigs });

        // 7. Put an item into our table using the above client.
        //    Before the item gets sent to DynamoDb, it will be encrypted
        //    client-side using the MRK multi-keyring.
        //    The data key protecting this item will be encrypted
        //    with all the KMS Keys in this keyring, so that it can be
        //    decrypted with any one of those KMS Keys.
        var item = new Dictionary<String, AttributeValue>
        {
            ["partition_key"] = new AttributeValue("clientSupplierItem"),
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

        // 8. Get the item back from our table using the same keyring.
        //    The client will decrypt the item client-side using the MRK
        //    and return the original item.
        var keyToGet = new Dictionary<String, AttributeValue>
        {
            ["partition_key"] = new AttributeValue("clientSupplierItem"),
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

        // 9. Create a MRK discovery multi-keyring with a custom client supplier.
        //    A discovery MRK multi-keyring will be composed of
        //    multiple discovery MRK keyrings, one for each region.
        //    Each component keyring has its own KMS client in a particular region.
        //    When we provide a client supplier to the multi-keyring, all component
        //    keyrings will use that client supplier configuration.
        //    In our tests, we make `keyArn` an MRK with a replica, and
        //    provide only the replica region in our discovery filter.
        var discoveryFilter = new DiscoveryFilter
        {
            Partition = "aws",
            AccountIds = accountIds
        };
        var mrkDiscoveryClientSupplierInput = new CreateAwsKmsMrkDiscoveryMultiKeyringInput
        {
            ClientSupplier = new RegionalRoleClientSupplier(),
            DiscoveryFilter = discoveryFilter,
            Regions = regions
        };
        var mrkDiscoveryClientSupplierKeyring = matProv.CreateAwsKmsMrkDiscoveryMultiKeyring(
            mrkDiscoveryClientSupplierInput);

        // 10. Create a new config and client using the discovery keyring.
        //     This is the same setup as above, except we provide the discovery keyring to the config.
        var onlyReplicaKeyTableConfigs = new Dictionary<String, DynamoDbTableEncryptionConfig>
        {
            [ddbTableName] = new DynamoDbTableEncryptionConfig
            {
                LogicalTableName = ddbTableName,
                PartitionKeyName = "partition_key",
                SortKeyName = "sort_key",
                AttributeActionsOnEncrypt = attributeActionsOnEncrypt,
                // Provide discovery keyring here
                Keyring = mrkDiscoveryClientSupplierKeyring,
                AllowedUnsignedAttributePrefix = unsignAttrPrefix
            }
        };
        var onlyReplicaKeyDdbClient = new Client.DynamoDbClient(
            new DynamoDbTablesEncryptionConfig { TableEncryptionConfigs = onlyReplicaKeyTableConfigs });

        // 11. Get the item back from our table using the discovery keyring client.
        //     The client will decrypt the item client-side using the keyring,
        //     and return the original item.
        //     The discovery keyring will only use KMS keys in the provided regions and
        //     AWS accounts. Since we have provided it with a custom client supplier
        //     which uses different IAM roles based on the key region,
        //     the discovery keyring will use a particular IAM role to decrypt
        //     based on the region of the KMS key it uses to decrypt.
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
    }
}