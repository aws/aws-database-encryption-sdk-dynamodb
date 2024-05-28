package software.amazon.cryptography.examples.keyring;

import org.testng.annotations.Test;
import software.amazon.cryptography.examples.TestUtils;
import software.amazon.cryptography.examples.hierarchy.controlPlane.CreateBranchKeyExample;

public class TestHierarchicalKeyringExample {

  @Test
  public void TestHierarchicalKeyringExample() throws InterruptedException {
    // Create new branch keys for test
    String branchKeyId1 = CreateBranchKeyExample.KeyStoreCreateKey(
      TestUtils.TEST_KEYSTORE_NAME,
      TestUtils.TEST_LOGICAL_KEYSTORE_NAME,
      TestUtils.TEST_KEYSTORE_KMS_KEY_ID,
      TestUtils.keystoreAdminDDBClient,
      TestUtils.kmsHttpClient,
      TestUtils.defaultCreds
    );
    String branchKeyId2 = CreateBranchKeyExample.KeyStoreCreateKey(
      TestUtils.TEST_KEYSTORE_NAME,
      TestUtils.TEST_LOGICAL_KEYSTORE_NAME,
      TestUtils.TEST_KEYSTORE_KMS_KEY_ID,
      TestUtils.keystoreAdminDDBClient,
      TestUtils.kmsHttpClient,
      TestUtils.defaultCreds
    );

    // Key creation is eventually consistent, so wait 5 seconds to decrease the likelihood
    // our test fails due to eventual consistency issues.
    Thread.sleep(5000);

    HierarchicalKeyringExample.HierarchicalKeyringGetItemPutItem(
      TestUtils.TEST_DDB_TABLE_NAME,
      branchKeyId1,
      branchKeyId2,
      TestUtils.TEST_KEYSTORE_NAME,
      TestUtils.TEST_LOGICAL_KEYSTORE_NAME,
      TestUtils.TEST_KEYSTORE_KMS_KEY_ID
    );
  }
}
