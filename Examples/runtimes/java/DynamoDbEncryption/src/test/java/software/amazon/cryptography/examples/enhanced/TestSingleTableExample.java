package software.amazon.cryptography.examples.enhanced;

import java.util.UUID;
import org.testng.annotations.Test;
import software.amazon.cryptography.examples.TestUtils;

public class TestSingleTableExample {

  @Test
  public void TestEnhancedSingleTable() {
    final String partitionKeyPrefix = "SingleTableExample" + UUID.randomUUID();
    SingleTableExample.TransactWriteItems(
      TestUtils.TEST_KMS_KEY_ID,
      TestUtils.TEST_DDB_TABLE_NAME,
      partitionKeyPrefix,
      0
    );
    TestUtils.cleanUpDDBItem(
      TestUtils.TEST_DDB_TABLE_NAME,
      "partition_key",
      "sort_key",
      partitionKeyPrefix + "1",
      "0"
    );
    TestUtils.cleanUpDDBItem(
      TestUtils.TEST_DDB_TABLE_NAME,
      "partition_key",
      "sort_key",
      partitionKeyPrefix + "2",
      "0"
    );
    TestUtils.cleanUpDDBItem(
      TestUtils.TEST_DDB_TABLE_NAME,
      "partition_key",
      "sort_key",
      partitionKeyPrefix + "3",
      "0"
    );
  }
}
