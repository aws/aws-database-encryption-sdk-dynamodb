package software.amazon.cryptography.examples.motica1;

import org.testng.annotations.Test;
import software.amazon.cryptography.examples.TestUtils;

public class TestPocDemoAppUtils {
  @Test
  public void TestEncryptNewValid() {
    PocDemoAppUtils.encryptNew(TestUtils.TEST_MRK_KEY_ID, TestUtils.TEST_MRK_ALIAS_ID, TestUtils.TEST_DDB_TABLE_NAME);
  }

  @Test(expectedExceptions = software.amazon.awssdk.core.exception.SdkClientException.class)
  public void TestEncryptNewInValid() {
    PocDemoAppUtils.encryptNew(TestUtils.TEST_MRK_ALIAS_ID, TestUtils.TEST_MRK_ALIAS_ID, TestUtils.TEST_DDB_TABLE_NAME);
  }
}
