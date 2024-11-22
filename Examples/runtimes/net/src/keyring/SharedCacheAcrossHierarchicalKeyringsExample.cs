using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Net;
using System.Threading.Tasks;
using Amazon.DynamoDBv2;
using Amazon.DynamoDBv2.Model;
using Amazon.KeyManagementService;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb;
using AWS.Cryptography.DbEncryptionSDK.StructuredEncryption;
using AWS.Cryptography.KeyStore;
using AWS.Cryptography.MaterialProviders;

/*
  This example demonstrates how to use a shared cache across multiple Hierarchical Keyrings.
  With this functionality, users only need to maintain one common shared cache across multiple
  Hierarchical Keyrings with different Key Stores instances/KMS Clients/KMS Keys.

  There are three important parameters that users need to carefully set while providing the shared cache:

  1. Partition ID - Partition ID is an optional parameter provided to the Hierarchical Keyring input,
  which distinguishes Cryptographic Material Providers (i.e: Keyrings) writing to a cache.
  - If the Partition ID is set and is the same for two Hierarchical Keyrings (or another Material Provider),
    they CAN share the same cache entries in the cache.
  - If the Partition ID is set and is different for two Hierarchical Keyrings (or another Material Provider),
    they CANNOT share the same cache entries in the cache.
  - If the Partition ID is not set by the user, it is initialized as a random 16-byte UUID which makes
    it unique for every Hierarchical Keyring, and two Hierarchical Keyrings (or another Material Provider)
    CANNOT share the same cache entries in the cache.

  2. Logical Key Store Name - This parameter is set by the user when configuring the Key Store for
  the Hierarchical Keyring. This is a logical name for the branch key store.
  Suppose you have a physical Key Store (K). You create two instances of K (K1 and K2). Now, you create
  two Hierarchical Keyrings (HK1 and HK2) with these Key Store instances (K1 and K2 respectively).
  - If you want to share cache entries across these two keyrings, you should set the Logical Key Store Names
    for both the Key Store instances (K1 and K2) to be the same.
  - If you set the Logical Key Store Names for K1 and K2 to be different, HK1 (which uses Key Store instance K1)
    and HK2 (which uses Key Store instance K2) will NOT be able to share cache entries.

  3. Branch Key ID - Choose an effective Branch Key ID Schema

  This is demonstrated in the example below.
  Notice that both K1 and K2 are instances of the same physical Key Store (K).
  You MUST NEVER have two different physical Key Stores with the same Logical Key Store Name.

  Important Note: If you have two or more Hierarchy Keyrings with:
  - Same Partition ID
  - Same Logical Key Store Name of the Key Store for the Hierarchical Keyring 
  - Same Branch Key ID
  then they WILL share the cache entries in the Shared Cache.
  Please make sure that you set all of Partition ID, Logical Key Store Name and Branch Key ID
  to be the same for two Hierarchical Keyrings if and only if you want them to share cache entries.

  This example sets up DynamoDb Encryption for the AWS SDK client using the Hierarchical
  Keyring, which establishes a key hierarchy where "branch" keys are persisted in DynamoDb.
  These branch keys are used to protect your data keys, and these branch keys are themselves
  protected by a root KMS Key.

  This example first creates a shared cache that you can use across multiple Hierarchical Keyrings.
  The example then configures a Hierarchical Keyring (HK1 and HK2) with the shared cache,
  a Branch Key ID and two instances (K1 and K2) of the same physical Key Store (K) respectively,
  i.e. HK1 with K1 and HK2 with K2. The example demonstrates that if you set the same Partition ID
  for HK1 and HK2, the two keyrings can share cache entries.
  If you set different Partition ID of the Hierarchical Keyrings, or different
  Logical Key Store Names of the Key Store instances, then the keyrings will NOT
  be able to share cache entries.

  Running this example requires access to the DDB Table whose name
  is provided in CLI arguments.
  This table must be configured with the following
  primary key configuration:
    - Partition key is named "partition_key" with type (S)
    - Sort key is named "sort_key" with type (S)

  This example also requires using a KMS Key whose ARN
  is provided in CLI arguments. You need the following access
  on this key:
    - GenerateDataKeyWithoutPlaintext
    - Decrypt
 */
public class SharedCacheAcrossHierarchicalKeyringsExample
{
    public static async Task SharedCacheAcrossHierarchicalKeyringsGetItemPutItem(String branchKeyId)
    {
        var ddbTableName = TestUtils.TEST_DDB_TABLE_NAME;
        var keyStoreTableName = TestUtils.TEST_KEYSTORE_NAME;
        var logicalKeyStoreName = TestUtils.TEST_LOGICAL_KEYSTORE_NAME;
        var partitionId = TestUtils.TEST_PARTITION_ID;
        var kmsKeyId = TestUtils.TEST_KEYSTORE_KMS_KEY_ID;

        // 1. Create the CryptographicMaterialsCache (CMC) to share across multiple Hierarchical Keyrings
        //    using the Material Providers Library
        //      This CMC takes in:
        //      - CacheType
        var materialProviders = new MaterialProviders(new MaterialProvidersConfig());

        var cache = new CacheType { Default = new DefaultCache { EntryCapacity = 100 } };

        var cryptographicMaterialsCacheInput = new CreateCryptographicMaterialsCacheInput { Cache = cache };

        var sharedCryptographicMaterialsCache = materialProviders.CreateCryptographicMaterialsCache(cryptographicMaterialsCacheInput);

        // 2. Create a CacheType object for the sharedCryptographicMaterialsCache
        //    Note that the `cache` parameter in the Hierarchical Keyring Input takes a `CacheType` as input
        //    Here, we pass a `Shared` CacheType that passes an already initialized shared cache
        var sharedCache = new CacheType { Shared = sharedCryptographicMaterialsCache };

        // Initial KeyStore Setup: This example requires that you have already
        // created your KeyStore, and have populated it with a new branch key.

        // 3. Configure your KeyStore resource keystore1.
        //    This SHOULD be the same configuration that you used
        //    to initially create and populate your KeyStore.
        // Note that keyStoreTableName is the physical Key Store,
        // and keystore1 is instances of this physical Key Store.
        var keystore1 = new KeyStore(new KeyStoreConfig
        {
            DdbClient = new AmazonDynamoDBClient(),
            DdbTableName = keyStoreTableName,
            LogicalKeyStoreName = logicalKeyStoreName,
            KmsClient = new AmazonKeyManagementServiceClient(),
            KmsConfiguration = new KMSConfiguration { KmsKeyArn = kmsKeyId }
        });

        // 4. Create the Hierarchical Keyring HK1 with Key Store instance K1, partitionId,
        //    the shared Cache and the BranchKeyId.
        //    Note that we are now providing an already initialized shared cache instead of just mentioning
        //    the cache type and the Hierarchical Keyring initializing a cache at initialization.

        // This example creates a Hierarchical Keyring for a single BranchKeyId. You can, however, use a
        // BranchKeyIdSupplier as per your use-case. See the HierarchicalKeyringsExample.java for more
        // information.

        // Please make sure that you read the guidance on how to set Partition ID, Logical Key Store Name and
        // Branch Key ID at the top of this example before creating Hierarchical Keyrings with a Shared Cache.
        // partitionId for this example is a random UUID
        var keyringInput1 = new CreateAwsKmsHierarchicalKeyringInput
        {
            KeyStore = keystore1,
            BranchKeyId = branchKeyId,
            TtlSeconds = 600, // This dictates how often we call back to KMS to authorize use of the branch keys
            Cache = sharedCache,
            PartitionId = partitionId
        };
        IKeyring hierarchicalKeyring1 = materialProviders.CreateAwsKmsHierarchicalKeyring(keyringInput1);

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

        // 5. Get the DDB Client for Hierarchical Keyring 1.
        var ddbClient1 = GetDdbClient(
            ddbTableName,
            hierarchicalKeyring1,
            attributeActionsOnEncrypt
        );

        // 6. Encrypt Decrypt roundtrip with ddbClient1
        PutGetItems(ddbTableName, ddbClient1);

        // Through the above encrypt and decrypt roundtrip, the cache will be populated and
        // the cache entries can be used by another Hierarchical Keyring with the
        // - Same Partition ID
        // - Same Logical Key Store Name of the Key Store for the Hierarchical Keyring
        // - Same Branch Key ID

        // 7. Configure your KeyStore resource keystore2.
        //       This SHOULD be the same configuration that you used
        //       to initially create and populate your physical KeyStore.
        //    Note that keyStoreTableName is the physical Key Store,
        //    and keystore2 is instances of this physical Key Store.

        // Note that for this example, keystore2 is identical to keystore1.
        // You can optionally change configurations like KMS Client or KMS Key ID based
        // on your use-case.
        // Make sure you have the required permissions to use different configurations.

        // - If you want to share cache entries across two keyrings HK1 and HK2,
        //   you should set the Logical Key Store Names for both
        //   Key Store instances (K1 and K2) to be the same.
        // - If you set the Logical Key Store Names for K1 and K2 to be different,
        //   HK1 (which uses Key Store instance K1) and HK2 (which uses Key Store
        //   instance K2) will NOT be able to share cache entries.
        var keystore2 = new KeyStore(new KeyStoreConfig
        {
            DdbClient = new AmazonDynamoDBClient(),
            DdbTableName = keyStoreTableName,
            LogicalKeyStoreName = logicalKeyStoreName,
            KmsClient = new AmazonKeyManagementServiceClient(),
            KmsConfiguration = new KMSConfiguration { KmsKeyArn = kmsKeyId }
        });

        // 8. Create the Hierarchical Keyring HK2 with Key Store instance K2, the shared Cache
        //    and the same partitionId and BranchKeyId used in HK1 because we want to share cache entries
        //    (and experience cache HITS).

        // Please make sure that you read the guidance on how to set Partition ID, Logical Key Store Name and
        // Branch Key ID at the top of this example before creating Hierarchical Keyrings with a Shared Cache.
        // partitionId for this example is a random UUID
        var keyringInput2 = new CreateAwsKmsHierarchicalKeyringInput
        {
            KeyStore = keystore2,
            BranchKeyId = branchKeyId,
            TtlSeconds = 600, // This dictates how often we call back to KMS to authorize use of the branch keys
            Cache = sharedCache,
            PartitionId = partitionId
        };
        IKeyring hierarchicalKeyring2 = materialProviders.CreateAwsKmsHierarchicalKeyring(keyringInput2);

        // 9. Get the DDB Client for Hierarchical Keyring 2.
        var ddbClient2 = GetDdbClient(
            ddbTableName,
            hierarchicalKeyring2,
            attributeActionsOnEncrypt
        );

        // 10. Encrypt Decrypt roundtrip with ddbClient2
        PutGetItems(ddbTableName, ddbClient2);
    }

    public static Client.DynamoDbClient GetDdbClient(
        String ddbTableName,
        IKeyring hierarchicalKeyring,
        Dictionary<String, CryptoAction> attributeActionsOnEncrypt
    )
    {
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
                Keyring = hierarchicalKeyring,
                AllowedUnsignedAttributePrefix = unsignAttrPrefix
            }
        };

        // Create a new AWS SDK DynamoDb client using the DynamoDb Encryption Interceptor above
        var ddbClient = new Client.DynamoDbClient(
            new DynamoDbTablesEncryptionConfig { TableEncryptionConfigs = tableConfigs });

        return ddbClient;
    }

    public static async void PutGetItems(
        String ddbTableName,
        Client.DynamoDbClient ddbClient
    )
    {
        // Put an item into our table using the given ddb client.
        // Before the item gets sent to DynamoDb, it will be encrypted
        // client-side, according to our configuration.
        // This example creates a Hierarchical Keyring for a single BranchKeyId. You can, however, use a
        // BranchKeyIdSupplier as per your use-case. See the HierarchicalKeyringsExample.java for more
        // information.
        var item = new Dictionary<String, AttributeValue>
        {
            ["partition_key"] = new AttributeValue("id"),
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

        // Get the item back from our table using the same client.
        // The client will decrypt the item client-side, and return
        // back the original item.
        // This example creates a Hierarchical Keyring for a single BranchKeyId. You can, however, use a
        // BranchKeyIdSupplier as per your use-case. See the HierarchicalKeyringsExample.java for more
        // information.
        var keyToGet = new Dictionary<String, AttributeValue>
        {
            ["partition_key"] = new AttributeValue("id"),
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
}
