package software.aws.cryptography.examples.searchableencryption.complexexample;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

public class ComplexSearchableEncryptionExample {

  public static void RunExample(String ddbTableName, String branchKeyWrappingKmsKeyArn, String branchKeyDdbTableName) {
    DynamoDbClient ddb = BeaconConfig.SetupBeaconConfig(ddbTableName, branchKeyWrappingKmsKeyArn, branchKeyDdbTableName);
    PutRequests.putAllItemsToTable(ddbTableName, ddb);
    QueryRequests.runQueries(ddbTableName, ddb);
  }

  public static void main(final String[] args) {
//    if (args.length != 3) {
//      throw new IllegalArgumentException("To run this example, include ddbTableName as args[0], branchKeyWrappingKmsKeyId as args[1], and branchKeyDdbTableName as args[2]");
//    }
    final String ddbTableName = "ComplexBeaconTestTable";
    final String branchKeyWrappingKmsKeyId = "arn:aws:kms:us-west-2:370957321024:key/9d989aa2-2f9c-438c-a745-cc57d3ad0126";
    final String branchKeyDdbTableName = "CiKeystoreTestTable";
    RunExample(ddbTableName, branchKeyWrappingKmsKeyId, branchKeyDdbTableName);

  }


}
