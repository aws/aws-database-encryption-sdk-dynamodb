package software.amazon.cryptography.examples.searchableencryption;

import org.testng.annotations.Test;

public class TestCompoundBeaconSearchableEncryptionExample {

  @Test
  public void TestCompoundItemEncryptDecrypt() {
    CompoundBeaconSearchableEncryptionExample.PutItemQueryItemWithCompoundBeacon(
      SearchableEncryptionTestUtils.UNIT_INSPECTION_TEST_DDB_TABLE_NAME,
      SearchableEncryptionTestUtils.TEST_BRANCH_KEY_ID,
      SearchableEncryptionTestUtils.TEST_BRANCH_KEY_WRAPPING_KMS_KEY_ARN,
      SearchableEncryptionTestUtils.TEST_BRANCH_KEYSTORE_DDB_TABLE_NAME
    );
  }
}
