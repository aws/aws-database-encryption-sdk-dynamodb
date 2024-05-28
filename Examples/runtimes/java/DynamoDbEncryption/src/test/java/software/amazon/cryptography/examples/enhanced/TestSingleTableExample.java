package software.amazon.cryptography.examples.enhanced;

import org.testng.annotations.Test;
import software.amazon.cryptography.examples.TestUtils;

public class TestSingleTableExample {

  @Test
  public void TestEnhancedSingleTable() {
    SingleTableExample.TransactWriteItems(
      TestUtils.TEST_KMS_KEY_ID,
      TestUtils.TEST_DDB_TABLE_NAME
    );
  }
}
