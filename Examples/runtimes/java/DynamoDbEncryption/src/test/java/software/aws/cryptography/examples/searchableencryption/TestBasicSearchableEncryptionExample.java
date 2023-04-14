package software.aws.cryptography.examples.searchableencryption;

import org.testng.annotations.Test;

public class TestBasicSearchableEncryptionExample {

  @Test
  public void TestItemEncryptDecrypt() {
    BasicSearchableEncryptionExample.PutItemQueryItemWithBeacon(
        SearchableEncryptionTestUtils.TEST_DDB_TABLE_NAME,
        SearchableEncryptionTestUtils.TEST_BRANCH_KEY_ID,
        SearchableEncryptionTestUtils.TEST_BRANCH_KEY_WRAPPING_KMS_KEY_ID,
        SearchableEncryptionTestUtils.TEST_BRANCH_KEYSTORE_DDB_TABLE_NAME);
  }

}
