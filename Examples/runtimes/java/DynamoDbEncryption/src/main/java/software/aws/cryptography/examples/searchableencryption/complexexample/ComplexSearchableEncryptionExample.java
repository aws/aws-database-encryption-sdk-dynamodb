package software.aws.cryptography.examples.searchableencryption.complexexample;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

public class ComplexSearchableEncryptionExample {

  public static void runExample(String ddbTableName, String branchKeyId, String branchKeyWrappingKmsKeyArn, String branchKeyDdbTableName) {
    DynamoDbClient ddb = BeaconConfig.SetupBeaconConfig(ddbTableName, branchKeyId, branchKeyWrappingKmsKeyArn, branchKeyDdbTableName);
    PutRequests.putAllItemsToTable(ddbTableName, ddb);
    QueryRequests.runQueries(ddbTableName, ddb);
  }

  public static void main(final String[] args) {
    if (args.length <= 1) {
      throw new IllegalArgumentException("To run this example, include ddbTableName as args[0], "
              + "branchKeyId as args[1], branchKeyWrappingKmsKeyId as args[2], and branchKeyDdbTableName as args[3]");
    }
    final String ddbTableName = args[0];
    final String branchKeyId = args[1];
    final String branchKeyWrappingKmsKeyId = args[2];
    final String branchKeyDdbTableName = args[3];
    runExample(ddbTableName, branchKeyId, branchKeyWrappingKmsKeyId, branchKeyDdbTableName);

  }
}
