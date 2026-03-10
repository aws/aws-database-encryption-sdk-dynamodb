package software.amazon.cryptography.examples.searchableencryption.complexexample;

import org.testng.annotations.Test;
import software.amazon.cryptography.examples.searchableencryption.SearchableEncryptionTestUtils;

public class TestComplexSearchableEncryptionExample {

  @Test
  public void TestComplexExample() {
    ComplexSearchableEncryptionExample.runExample(
      ComplexSearchableEncryptionTestUtils.TEST_DDB_TABLE_NAME,
      SearchableEncryptionTestUtils.TEST_BRANCH_KEY_ID,
      SearchableEncryptionTestUtils.TEST_BRANCH_KEY_WRAPPING_KMS_KEY_ARN,
      SearchableEncryptionTestUtils.TEST_BRANCH_KEYSTORE_DDB_TABLE_NAME
    );
  }
}
