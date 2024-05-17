package software.amazon.cryptography.examples.migration.awsdbe;

import static org.testng.Assert.assertThrows;

import org.testng.annotations.Test;
import software.amazon.awssdk.core.exception.SdkClientException;
import software.amazon.cryptography.examples.awsdbe.MigrationExampleStep1;
import software.amazon.cryptography.examples.awsdbe.MigrationExampleStep2;
import software.amazon.cryptography.examples.awsdbe.MigrationExampleStep3;
import software.amazon.cryptography.examples.migration.plaintext.TestUtils;
import software.amazon.cryptography.examples.plaintext.MigrationExampleStep0;

public class TestMigrationExampleStep3 {

  @Test
  public void TestMigrationStep0() {
    // Successfully executes step 3
    MigrationExampleStep3.MigrationStep3(
      software.amazon.cryptography.examples.migration.plaintext.TestUtils.TEST_KMS_KEY_ID,
      software.amazon.cryptography.examples.migration.plaintext.TestUtils.TEST_DDB_TABLE_NAME,
      3
    );

    // Given: Step 0 has succeeded
    MigrationExampleStep0.MigrationStep0(
      software.amazon.cryptography.examples.migration.plaintext.TestUtils.TEST_DDB_TABLE_NAME,
      0
    );
    // When: Execute Step 3 with sortReadValue=0, Then: throws SdkClientException (i.e. cannot read plaintext values)
    assertThrows(
      SdkClientException.class,
      () -> {
        MigrationExampleStep3.MigrationStep3(
          software.amazon.cryptography.examples.migration.plaintext.TestUtils.TEST_KMS_KEY_ID,
          software.amazon.cryptography.examples.migration.plaintext.TestUtils.TEST_DDB_TABLE_NAME,
          0
        );
      }
    );

    // Given: Step 1 has succeeded
    MigrationExampleStep1.MigrationStep1(
      software.amazon.cryptography.examples.migration.plaintext.TestUtils.TEST_KMS_KEY_ID,
      software.amazon.cryptography.examples.migration.plaintext.TestUtils.TEST_DDB_TABLE_NAME,
      1
    );
    // When: Execute Step 3 with sortReadValue=1, Then: throws SdkClientException (i.e. cannot read plaintext values)
    assertThrows(
      SdkClientException.class,
      () -> {
        MigrationExampleStep3.MigrationStep3(
          software.amazon.cryptography.examples.migration.plaintext.TestUtils.TEST_KMS_KEY_ID,
          software.amazon.cryptography.examples.migration.plaintext.TestUtils.TEST_DDB_TABLE_NAME,
          1
        );
      }
    );

    // Given: Step 2 has succeeded
    MigrationExampleStep2.MigrationStep2(
      software.amazon.cryptography.examples.migration.plaintext.TestUtils.TEST_KMS_KEY_ID,
      software.amazon.cryptography.examples.migration.plaintext.TestUtils.TEST_DDB_TABLE_NAME,
      2
    );
    // When: Execute Step 3 with sortReadValue=2, Then: Success (i.e. can read encrypted values)
    MigrationExampleStep3.MigrationStep3(
      software.amazon.cryptography.examples.migration.plaintext.TestUtils.TEST_KMS_KEY_ID,
      TestUtils.TEST_DDB_TABLE_NAME,
      2
    );
  }
}
