package software.amazon.cryptography.examples.keyring;

import org.testng.annotations.Test;
import software.amazon.cryptography.examples.CreateKeyStoreKeyExample;
import software.amazon.cryptography.examples.TestUtils;

public class TestSharedCacheAcrossHierarchicalKeyringsExample {

  @Test
  public void TestSharedCacheAcrossHierarchicalKeyringsExample()
    throws InterruptedException {
    // Create new branch key for test
    String keyId = CreateKeyStoreKeyExample.KeyStoreCreateKey(
      TestUtils.TEST_KEYSTORE_NAME,
      TestUtils.TEST_LOGICAL_KEYSTORE_NAME,
      TestUtils.TEST_KEYSTORE_KMS_KEY_ID
    );

    // Key creation is eventually consistent, so wait 5 seconds to decrease the likelihood
    // our test fails due to eventual consistency issues.
    Thread.sleep(5000);

    SharedCacheAcrossHierarchicalKeyringsExample.SharedCacheAcrossHierarchicalKeyringsGetItemPutItem(
      TestUtils.TEST_DDB_TABLE_NAME,
      keyId,
      TestUtils.TEST_KEYSTORE_NAME,
      TestUtils.TEST_LOGICAL_KEYSTORE_NAME,
      TestUtils.TEST_PARTITION_ID,
      TestUtils.TEST_KEYSTORE_KMS_KEY_ID
    );
  }
}
