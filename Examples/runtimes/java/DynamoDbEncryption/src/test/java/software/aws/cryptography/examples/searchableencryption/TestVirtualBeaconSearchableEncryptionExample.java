package software.aws.cryptography.examples.searchableencryption;

import org.testng.annotations.Test;

public class TestVirtualBeaconSearchableEncryptionExample {

  @Test
  public void TestVirtualBeaconExample() {
    // TODO rename method
    VirtualBeaconSearchableEncryptionExample.PutItemQueryItemWithBeacon(
        SearchableEncryptionTestUtils.TEST_DDB_TABLE_NAME,
        SearchableEncryptionTestUtils.TEST_BRANCH_KEY_WRAPPING_KMS_KEY_ARN,
        SearchableEncryptionTestUtils.TEST_BRANCH_KEYSTORE_DDB_TABLE_NAME);
  }

}
