package software.amazon.cryptography.examples;

import org.junitpioneer.jupiter.RetryingTest;

public class TestScanErrorExample {

  @RetryingTest(3)
  public void ScanError() {
    ScanErrorExample.ScanError(
      TestUtils.TEST_KMS_KEY_ID,
      TestUtils.TEST_DDB_TABLE_NAME
    );
  }
}
