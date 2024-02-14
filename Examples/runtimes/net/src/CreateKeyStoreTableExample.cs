using Amazon.DynamoDBv2;
using Amazon.KeyManagementService;
using AWS.Cryptography.KeyStore;

/*
  The Hierarchical Keyring Example and Searchable Encryption Examples
  rely on the existence of a DDB-backed key store with pre-existing
  branch key material or beacon key material.

  This example demonstrates configuring a KeyStore and then
  using a helper method to create the DDB table that will be
  used to persist branch keys and beacons keys for this KeyStore.

  This table creation should occur within your control plane. This
  only needs to occur once. While not demonstrated in this example,
  you should additionally use the `VersionKey` API on the KeyStore
  to periodically rotate your branch key material.
 */
public class CreateKeyStoreTableExample
{
    // Create KeyStore Table Example
    public static void KeyStoreCreateTable()
    {
        string keyStoreTableName = TestUtils.TEST_KEYSTORE_NAME;
        string logicalKeyStoreName = TestUtils.TEST_LOGICAL_KEYSTORE_NAME;
        string kmsKeyArn = TestUtils.TEST_KEYSTORE_KMS_KEY_ID;

        // 1. Configure your KeyStore resource.
        //    `ddbTableName` is the name you want for the DDB table that
        //    will back your keystore.
        //    `kmsKeyArn` is the KMS Key that will protect your branch keys and beacon keys
        //    when they are stored in your DDB table.
        var keystore = new KeyStore(new KeyStoreConfig
        {
            DdbClient = new AmazonDynamoDBClient(),
            DdbTableName = keyStoreTableName,
            LogicalKeyStoreName = logicalKeyStoreName,
            KmsClient = new AmazonKeyManagementServiceClient(),
            KmsConfiguration = new KMSConfiguration { KmsKeyArn = kmsKeyArn }
        });

        // 2. Create the DynamoDb table that will store the branch keys and beacon keys.
        //    This checks if the correct table already exists at `ddbTableName`
        //    by using the DescribeTable API. If no table exists,
        //    it will create one. If a table exists, it will verify
        //    the table's configuration and will error if the configuration is incorrect.
        keystore.CreateKeyStore(new CreateKeyStoreInput());

        // It may take a couple minutes for the table to become ACTIVE,
        // at which point it is ready to store branch and beacon keys.
        // See the Create KeyStore Key Example for how to populate
        // this table.
    }
}