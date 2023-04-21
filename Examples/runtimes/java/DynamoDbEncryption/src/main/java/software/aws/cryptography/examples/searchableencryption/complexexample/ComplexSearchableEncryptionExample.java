package software.aws.cryptography.examples.searchableencryption.complexexample;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

public class ComplexSearchableEncryptionExample {

  public static void runExample(String ddbTableName, String branchKeyWrappingKmsKeyArn, String branchKeyDdbTableName) {
    DynamoDbClient ddb = BeaconConfig.SetupBeaconConfig(ddbTableName, branchKeyWrappingKmsKeyArn, branchKeyDdbTableName);
    PutRequests.putAllItemsToTable(ddbTableName, ddb);
    QueryRequests.runQueries(ddbTableName, ddb);
  }

  public static void main(final String[] args) {
    if (args.length != 3) {
      throw new IllegalArgumentException("To run this example, include ddbTableName as args[0], branchKeyWrappingKmsKeyId as args[1], and branchKeyDdbTableName as args[2]");
    }
    final String ddbTableName = args[0];
    final String branchKeyWrappingKmsKeyId = args[1];
    final String branchKeyDdbTableName = args[2];
    runExample(ddbTableName, branchKeyWrappingKmsKeyId, branchKeyDdbTableName);

  }
}
