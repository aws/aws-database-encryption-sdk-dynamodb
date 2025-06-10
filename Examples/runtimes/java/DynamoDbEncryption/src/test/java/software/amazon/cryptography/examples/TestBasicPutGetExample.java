package software.amazon.cryptography.examples;

import java.util.UUID;
import org.testng.annotations.Test;

public class TestBasicPutGetExample {

  @Test
  public void TestPutGet() {
    final String partitionKeyValue = "BasicPutGetExample" + UUID.randomUUID();
    BasicPutGetExample.PutItemGetItem(
      TestUtils.TEST_KMS_KEY_ID,
      TestUtils.TEST_DDB_TABLE_NAME,
      "partition_key",
      "sort_key",
      partitionKeyValue,
      "0"
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
