import java.net.URI;
import java.util.HashMap;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.DeleteItemRequest;

public class TestUtils {

  // These are public KMS Keys that MUST only be used for testing, and MUST NOT be used for any production data
  public static final String TEST_KMS_KEY_ID =
      "arn:aws:kms:us-west-2:658956600833:key/b3537ef1-d8dc-4780-9f5a-55776cbb2f7f";

  // Our tests require access to DDB Table with this name
  public static final String TEST_DDB_TABLE_NAME = "DynamoDbEncryptionInterceptorTestTable";

  /**
   * Deletes an item from a DynamoDB table.
   *
   * @param tableName The name of the DynamoDB table
   * @param partitionKeyName The name of partition key
   * @param sortKeyName The name of sort key
   * @param partitionKeyValue The value of the partition key
   * @param sortKeyValue The value of the sort key (can be null if table doesn't have a sort key)
   */
  public static void cleanUpDDBItem(
      final String tableName,
      final String partitionKeyName,
      final String sortKeyName,
      final String partitionKeyValue,
      final String sortKeyValue) {
    final DynamoDbClient ddb = DynamoDbClient.builder().build();
    final HashMap<String, AttributeValue> keyToDelete = new HashMap<>();
    keyToDelete.put(partitionKeyName, AttributeValue.builder().s(partitionKeyValue).build());
    if (sortKeyValue != null) {
      keyToDelete.put(sortKeyName, AttributeValue.builder().n(sortKeyValue).build());
    }
    final DeleteItemRequest deleteRequest =
        DeleteItemRequest.builder().tableName(tableName).key(keyToDelete).build();
    ddb.deleteItem(deleteRequest);
  }
}
