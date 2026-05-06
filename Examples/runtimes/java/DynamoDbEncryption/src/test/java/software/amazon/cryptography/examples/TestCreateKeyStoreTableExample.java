package software.amazon.cryptography.examples;

import org.junitpioneer.jupiter.RetryingTest;

public class TestCreateKeyStoreTableExample {

  @RetryingTest(3)
  public void TestCreateKeyStoreTableExample() {
    CreateKeyStoreTableExample.KeyStoreCreateTable(
      TestUtils.TEST_KEYSTORE_NAME,
      TestUtils.TEST_LOGICAL_KEYSTORE_NAME,
      TestUtils.TEST_KEYSTORE_KMS_KEY_ID
    );
  }
}
