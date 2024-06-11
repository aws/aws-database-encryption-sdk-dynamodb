package software.amazon.cryptography.examples;

import static org.testng.Assert.assertNotNull;

import org.testng.annotations.Test;
import software.amazon.cryptography.examples.hierarchy.controlPlane.CreateBranchKeyExample;

public class TestCreateKeyStoreKeyExample {

  @Test
  public void TestCreateKeyStoreKeyExample() {
    String branchKeyId = CreateBranchKeyExample.KeyStoreCreateKey(
      TestUtils.TEST_KEYSTORE_NAME,
      TestUtils.TEST_LOGICAL_KEYSTORE_NAME,
      TestUtils.TEST_KEYSTORE_KMS_KEY_ID,
      TestUtils.keystoreAdminDDBClient,
      TestUtils.kmsHttpClient,
      TestUtils.defaultCreds
    );

    assertNotNull(branchKeyId);
  }
}
