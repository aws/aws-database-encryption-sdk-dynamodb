package software.amazon.cryptography.examples;

import org.testng.annotations.Test;
import software.amazon.cryptography.examples.hierarchy.regionBuild.CreateKeyStoreTableExample;

public class TestCreateKeyStoreTableExample {

  @Test
  public void TestCreateKeyStoreTableExample() {
    CreateKeyStoreTableExample.KeyStoreCreateTable(
      TestUtils.TEST_KEYSTORE_NAME,
      TestUtils.TEST_LOGICAL_KEYSTORE_NAME,
      TestUtils.TEST_KEYSTORE_KMS_KEY_ID
    );
  }
}
