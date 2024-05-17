package software.amazon.cryptography.examples.searchableencryption;

import org.testng.annotations.Test;
import software.amazon.cryptography.examples.CreateKeyStoreKeyExample;

public class TestBasicSearchableEncryptionExample {

  @Test
  public void TestBasicExample() throws InterruptedException {
    // Create new branch key for test
    String keyId = CreateKeyStoreKeyExample.KeyStoreCreateKey(
      SearchableEncryptionTestUtils.TEST_BRANCH_KEYSTORE_DDB_TABLE_NAME,
      SearchableEncryptionTestUtils.TEST_LOGICAL_KEYSTORE_NAME,
      SearchableEncryptionTestUtils.TEST_BRANCH_KEY_WRAPPING_KMS_KEY_ARN
    );

    // Key creation is eventually consistent, so wait 5 seconds to decrease the likelihood
    // our test fails due to eventual consistency issues.
    Thread.sleep(5000);

    BasicSearchableEncryptionExample.PutItemQueryItemWithBeacon(
      SearchableEncryptionTestUtils.UNIT_INSPECTION_TEST_DDB_TABLE_NAME,
      keyId,
      SearchableEncryptionTestUtils.TEST_BRANCH_KEY_WRAPPING_KMS_KEY_ARN,
      SearchableEncryptionTestUtils.TEST_BRANCH_KEYSTORE_DDB_TABLE_NAME
    );
  }
}
