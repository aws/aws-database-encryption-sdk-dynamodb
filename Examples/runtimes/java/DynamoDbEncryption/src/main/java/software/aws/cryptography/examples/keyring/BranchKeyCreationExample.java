package software.aws.cryptography.examples.keyring;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.kms.KmsClient;
import software.amazon.cryptography.keyStore.KeyStore;
import software.amazon.cryptography.keyStore.model.CreateKeyStoreInput;
import software.amazon.cryptography.keyStore.model.KMSConfiguration;
import software.amazon.cryptography.keyStore.model.KeyStoreConfig;

public class BranchKeyCreationExample {

  static KeyStore keystore;

  public static void setupKeystore(String keyStoreTableName, String logicalKeyStoreName, String kmsKeyId) {
    // Initial KeyStore Setup: Configure a keystore resource to create the table
    // that will persist your branch keys, then create two new branch keys.
    // This process should occur in your control plane, and returns
    // Branch Key IDs that you will need to configure for use in your data plane.

    // 1. Configure your KeyStore resource
    keystore = KeyStore.builder().KeyStoreConfig(
        KeyStoreConfig.builder()
            .ddbClient(DynamoDbClient.create())
            .ddbTableName(keyStoreTableName)
            .logicalKeyStoreName(logicalKeyStoreName)
            .kmsClient(KmsClient.create())
            .kmsConfiguration(KMSConfiguration.builder()
                .kmsKeyArn(kmsKeyId)
                .build())
            .build()).build();

    // 2. Create the DynamoDb table to store the branch keys
    keystore.CreateKeyStore(CreateKeyStoreInput.builder().build());
  }

  /**
   * Creates a new branch key in the keystore and returns the branch key ID.
   * @return
   */
  public static String createBranchKey() {
    String branchKeyId = keystore.CreateKey().branchKeyIdentifier();
    // DEBUG: Uncomment this line to see the branch key ID for the new branch key
    //System.out.println(branchKeyId);
    return branchKeyId;
  }

}
