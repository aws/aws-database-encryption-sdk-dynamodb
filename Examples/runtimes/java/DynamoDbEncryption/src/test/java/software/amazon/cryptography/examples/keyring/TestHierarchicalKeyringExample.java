package software.amazon.cryptography.examples.keyring;

import org.testng.annotations.Test;
import software.amazon.cryptography.examples.CreateKeyStoreKeyExample;
import software.amazon.cryptography.examples.TestUtils;

public class TestHierarchicalKeyringExample {

  @Test
  public void TestHierarchicalKeyringExample() throws InterruptedException {
    // Create new branch keys for test
    String keyId1 = CreateKeyStoreKeyExample.KeyStoreCreateKey(
      TestUtils.TEST_KEYSTORE_NAME,
      TestUtils.TEST_LOGICAL_KEYSTORE_NAME,
      "arn:aws:kms:us-west-2:370957321024:key/e20ac7b8-3d95-46ee-b3d5-f5dca6393945"
    );
    String keyId2 = CreateKeyStoreKeyExample.KeyStoreCreateKey(
      TestUtils.TEST_KEYSTORE_NAME,
      TestUtils.TEST_LOGICAL_KEYSTORE_NAME,
      TestUtils.TEST_KEYSTORE_KMS_KEY_ID
    );

    // Key creation is eventually consistent, so wait 5 seconds to decrease the likelihood
    // our test fails due to eventual consistency issues.
    Thread.sleep(5000);

    HierarchicalKeyringExample.HierarchicalKeyringGetItemPutItem(
      TestUtils.TEST_DDB_TABLE_NAME,
      keyId1,
      keyId2,
      TestUtils.TEST_KEYSTORE_NAME,
      TestUtils.TEST_LOGICAL_KEYSTORE_NAME,
      TestUtils.TEST_KEYSTORE_KMS_KEY_ID
    );
  }
}
