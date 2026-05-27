package software.amazon.cryptography.examples;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.kms.KmsClient;
import software.amazon.cryptography.keystore.KeyStore;
import software.amazon.cryptography.keystore.model.CreateKeyStoreInput;
import software.amazon.cryptography.keystore.model.KMSConfiguration;
import software.amazon.cryptography.keystore.model.KeyStoreConfig;

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
public class CreateKeyStoreTableExample {

  // Create KeyStore Table Example
  public static void KeyStoreCreateTable(
    String keyStoreTableName,
    String logicalKeyStoreName,
    String kmsKeyArn
  ) {
    // 1. Configure your KeyStore resource.
    //    `ddbTableName` is the name you want for the DDB table that
    //    will back your keystore.
    //    `kmsKeyArn` is the KMS Key that will protect your branch keys and beacon keys
    //    when they are stored in your DDB table.
    final KeyStore keystore = KeyStore
      .builder()
      .KeyStoreConfig(
        KeyStoreConfig
          .builder()
          .ddbClient(DynamoDbClient.create())
          .ddbTableName(keyStoreTableName)
          .logicalKeyStoreName(logicalKeyStoreName)
          .kmsClient(KmsClient.create())
          .kmsConfiguration(
            KMSConfiguration.builder().kmsKeyArn(kmsKeyArn).build()
          )
          .build()
      )
      .build();

    // 2. Create the DynamoDb table that will store the branch keys and beacon keys.
    //    This checks if the correct table already exists at `ddbTableName`
    //    by using the DescribeTable API. If no table exists,
    //    it will create one. If a table exists, it will verify
    //    the table's configuration and will error if the configuration is incorrect.
    keystore.CreateKeyStore(CreateKeyStoreInput.builder().build());
    // It may take a couple minutes for the table to become ACTIVE,
    // at which point it is ready to store branch and beacon keys.
    // See the Create KeyStore Key Example for how to populate
    // this table.
  }

  public static void main(final String[] args) {
    if (args.length <= 1) {
      throw new IllegalArgumentException(
        "To run this example, include the keyStoreTableName, logicalKeyStoreName, and kmsKeyArn in args"
      );
    }
    final String keyStoreTableName = args[0];
    final String logicalKeyStoreName = args[1];
    final String kmsKeyArn = args[2];
    KeyStoreCreateTable(keyStoreTableName, logicalKeyStoreName, kmsKeyArn);
  }
}
