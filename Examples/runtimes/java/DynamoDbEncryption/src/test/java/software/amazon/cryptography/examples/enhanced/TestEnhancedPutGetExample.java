package software.amazon.cryptography.examples.enhanced;

import java.util.UUID;
import org.testng.annotations.Test;
import software.amazon.cryptography.examples.TestUtils;

public class TestEnhancedPutGetExample {

  @Test
  public void TestEnhancedPutGet() {
    final String partitionKeyValue = "EnhancedPutGetExample" + UUID.randomUUID();
    EnhancedPutGetExample.PutItemGetItem(
      TestUtils.TEST_KMS_KEY_ID,
      TestUtils.TEST_DDB_TABLE_NAME,
      partitionKeyValue,
      0
    );
    TestUtils.cleanUpDDBItem(
      TestUtils.TEST_DDB_TABLE_NAME,
      "partition_key",
      "sort_key",
      partitionKeyValue,
      "0"
    );
  }

  @Test
  public void TestLombokPutGet() {
    final String partitionKeyValue = "LombokPutGetExample" + UUID.randomUUID();
    LombokPutGetExample.PutItemGetItem(
      TestUtils.TEST_KMS_KEY_ID,
      TestUtils.TEST_DDB_TABLE_NAME,
      partitionKeyValue,
      0
    );
    TestUtils.cleanUpDDBItem(
      TestUtils.TEST_DDB_TABLE_NAME,
      "partition_key",
      "sort_key",
      partitionKeyValue,
      "0"
    );
  }

  @Test
  public void TestTableSchemaBuilderPutGet() {
    final String partitionKeyValue = "TableSchemaBuilderPutGetExample" + UUID.randomUUID();
    TableSchemaBuilderPutGetExample.PutItemGetItem(
      TestUtils.TEST_KMS_KEY_ID,
      TestUtils.TEST_DDB_TABLE_NAME,
      partitionKeyValue,
      0
    );
    TestUtils.cleanUpDDBItem(
      TestUtils.TEST_DDB_TABLE_NAME,
      "partition_key",
      "sort_key",
      partitionKeyValue,
      "0"
    );
  }
}
