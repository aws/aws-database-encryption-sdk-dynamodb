import java.util.UUID;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

public class AsymmetricEncryptedItemTest {

  @Test
  public void testAsymmetricEncryption() throws Exception {
    final String partitionKeyValue = "AsymmetricExample-" + UUID.randomUUID();
    final String sortKeyValue = "0";

    try (final DynamoDbClient ddbClient = DynamoDbClient.create()) {
      AsymmetricEncryptedItem.encryptRecord(
          ddbClient,
          TestUtils.TEST_DDB_TABLE_NAME,
          "partition_key",
          "sort_key",
          partitionKeyValue,
          sortKeyValue);
    }
  }
}
