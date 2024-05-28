package software.amazon.cryptography.examples.keyring;

import org.testng.annotations.Test;
import software.amazon.cryptography.examples.TestUtils;

public class TestMrkMultiKeyringExample {

  @Test
  public void TestMrkMultiKeyringExample() {
    MultiMrkKeyringExample.MultiMrkKeyringGetItemPutItem(
      TestUtils.TEST_DDB_TABLE_NAME,
      TestUtils.TEST_MRK_KEY_ID,
      TestUtils.TEST_KMS_KEY_ID,
      TestUtils.TEST_MRK_REPLICA_KEY_ID_US_EAST_1
    );
  }
}
