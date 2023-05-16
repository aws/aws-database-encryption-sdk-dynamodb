package software.aws.cryptography.examples.searchableencryption;

import org.testng.annotations.Test;
import software.aws.cryptography.examples.CreateKeyStoreKeyExample;

public class TestVirtualBeaconSearchableEncryptionExample {

  @Test
  public void TestVirtualBeaconExample() throws InterruptedException {
    // Create new branch key for test
    String keyId = CreateKeyStoreKeyExample.KeyStoreCreateKey(
        SearchableEncryptionTestUtils.TEST_BRANCH_KEYSTORE_DDB_TABLE_NAME,
        SearchableEncryptionTestUtils.TEST_LOGICAL_KEYSTORE_NAME,
        SearchableEncryptionTestUtils.TEST_BRANCH_KEY_WRAPPING_KMS_KEY_ARN);

    // Key creation is eventually consistent, so wait 5 seconds to decrease the likelihood
    // our test fails due to eventual consistency issues.
    // TODO: poll the table, with retries and backoff, to do this more elegantly.
    Thread.sleep(5000);

    // TODO rename method
    VirtualBeaconSearchableEncryptionExample.PutItemQueryItemWithVirtualBeacon(
        SearchableEncryptionTestUtils.TEST_DDB_TABLE_NAME,
        keyId,
        SearchableEncryptionTestUtils.TEST_BRANCH_KEY_WRAPPING_KMS_KEY_ARN,
        SearchableEncryptionTestUtils.TEST_BRANCH_KEYSTORE_DDB_TABLE_NAME);
  }

}
