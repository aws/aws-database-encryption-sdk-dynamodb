package software.amazon.cryptography.examples;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.kms.KmsClient;
import software.amazon.cryptography.keystore.KeyStore;
import software.amazon.cryptography.keystore.model.CreateKeyInput;
import software.amazon.cryptography.keystore.model.KMSConfiguration;
import software.amazon.cryptography.keystore.model.KeyStoreConfig;

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
public class CreateKeyStoreKeyExample {

  public static String KeyStoreCreateKey(
    String keyStoreTableName,
    String logicalKeyStoreName,
    String kmsKeyArn
  ) {
    // 1. Configure your KeyStore resource.
    //    This SHOULD be the same configuration that was used to create the DDB table
    //    in the "Create KeyStore Table Example".
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

    // 2. Create a new branch key and beacon key in our KeyStore.
    //    Both the branch key and the beacon key will share an Id.
    //    This creation is eventually consistent.

    final String branchKeyId = keystore
      .CreateKey(CreateKeyInput.builder().build())
      .branchKeyIdentifier();

    return branchKeyId;
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
    KeyStoreCreateKey(keyStoreTableName, logicalKeyStoreName, kmsKeyArn);
  }
}
