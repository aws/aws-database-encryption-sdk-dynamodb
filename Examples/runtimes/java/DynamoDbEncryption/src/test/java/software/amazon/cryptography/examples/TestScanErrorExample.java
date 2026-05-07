package software.amazon.cryptography.examples;

import org.testng.annotations.Test;

public class TestScanErrorExample {

  @Test
  public void ScanError() {
    ScanErrorExample.ScanError(
      TestUtils.TEST_KMS_KEY_ID,
      TestUtils.TEST_DDB_TABLE_NAME
    );
  }
}
