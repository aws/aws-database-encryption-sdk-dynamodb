package software.amazon.cryptography.examples.migration.awsdbe;

import org.testng.annotations.Test;
import software.amazon.cryptography.examples.awsdbe.MigrationExampleStep1;
import software.amazon.cryptography.examples.awsdbe.MigrationExampleStep2;
import software.amazon.cryptography.examples.awsdbe.MigrationExampleStep3;
import software.amazon.cryptography.examples.plaintext.MigrationExampleStep0;

public class TestMigrationExampleStep2 {

  @Test
  public void TestMigrationStep2() {
    // Successfully executes Step 2
    MigrationExampleStep2.MigrationStep2(
      TestUtils.TEST_KMS_KEY_ID,
      TestUtils.TEST_DDB_TABLE_NAME,
      2
    );

    // Given: Step 0 has succeeded
    MigrationExampleStep0.MigrationStep0(TestUtils.TEST_DDB_TABLE_NAME, 0);
    // When: Execute Step 2 with sortReadValue=0, Then: Success (i.e. can read plaintext values)
    MigrationExampleStep2.MigrationStep2(
      TestUtils.TEST_KMS_KEY_ID,
      TestUtils.TEST_DDB_TABLE_NAME,
      0
    );

    // Given: Step 1 has succeeded
    MigrationExampleStep1.MigrationStep1(
      TestUtils.TEST_KMS_KEY_ID,
      TestUtils.TEST_DDB_TABLE_NAME,
      1
    );
    // When: Execute Step 2 with sortReadValue=1, Then: Success (i.e. can read encrypted values)
    MigrationExampleStep2.MigrationStep2(
      TestUtils.TEST_KMS_KEY_ID,
      TestUtils.TEST_DDB_TABLE_NAME,
      1
    );

    // Given: Step 3 has succeeded
    MigrationExampleStep3.MigrationStep3(
      TestUtils.TEST_KMS_KEY_ID,
      TestUtils.TEST_DDB_TABLE_NAME,
      3
    );
    // When: Execute Step 2 with sortReadValue=3, Then: Success (i.e. can read encrypted values)
    MigrationExampleStep2.MigrationStep2(
      TestUtils.TEST_KMS_KEY_ID,
      TestUtils.TEST_DDB_TABLE_NAME,
      3
    );
  }
}
