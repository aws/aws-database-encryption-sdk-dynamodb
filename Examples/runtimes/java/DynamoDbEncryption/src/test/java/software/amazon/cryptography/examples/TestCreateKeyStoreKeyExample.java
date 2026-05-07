package software.amazon.cryptography.examples;

import static org.testng.Assert.assertNotNull;

import org.testng.annotations.Test;

public class TestCreateKeyStoreKeyExample {

  @Test
  public void TestCreateKeyStoreKeyExample() {
    String keyId = CreateKeyStoreKeyExample.KeyStoreCreateKey(
      TestUtils.TEST_KEYSTORE_NAME,
      TestUtils.TEST_LOGICAL_KEYSTORE_NAME,
      TestUtils.TEST_KEYSTORE_KMS_KEY_ID
    );

    assertNotNull(keyId);
  }
}
