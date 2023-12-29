using Amazon.DynamoDBv2;
using Amazon.KeyManagementService;
using AWS.Cryptography.KeyStore;

/*
  The Hierarchical Keyring Example and Searchable Encryption Examples
  rely on the existence of a DDB-backed key store with pre-existing
  branch key material or beacon key material.

  See the "Create KeyStore Table Example" for how to first set up
  the DDB Table that will back this KeyStore.

  This example demonstrates configuring a KeyStore and then
  using a helper method to create a branch key and beacon key
  that share the same Id, then return that Id.
  We will always create a new beacon key alongside a new branch key,
  even if you are not using searchable encryption.

  This key creation should occur within your control plane.
 */
public class CreateKeyStoreKeyExample
{
    public static string KeyStoreCreateKey()
    {
        string keyStoreTableName = TestUtils.TEST_KEYSTORE_NAME;
        string logicalKeyStoreName = TestUtils.TEST_LOGICAL_KEYSTORE_NAME;
        string kmsKeyArn = TestUtils.TEST_KEYSTORE_KMS_KEY_ID;

        // 1. Configure your KeyStore resource.
        //    This SHOULD be the same configuration that was used to create the DDB table
        //    in the "Create KeyStore Table Example".
        var keystore = new KeyStore(new KeyStoreConfig
        {
            DdbClient = new AmazonDynamoDBClient(),
            DdbTableName = keyStoreTableName,
            LogicalKeyStoreName = logicalKeyStoreName,
            KmsClient = new AmazonKeyManagementServiceClient(),
            KmsConfiguration = new KMSConfiguration { KmsKeyArn = kmsKeyArn }
        });

        // 2. Create a new branch key and beacon key in our KeyStore.
        //    Both the branch key and the beacon key will share an Id.
        //    This creation is eventually consistent.

        string branchKeyId = keystore.CreateKey(new CreateKeyInput()).BranchKeyIdentifier;
        return branchKeyId;
    }
}