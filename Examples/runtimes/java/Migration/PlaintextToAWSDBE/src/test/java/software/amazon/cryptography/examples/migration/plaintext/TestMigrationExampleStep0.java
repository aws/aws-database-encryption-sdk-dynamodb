package software.amazon.cryptography.examples.migration.plaintext;

import static org.testng.Assert.assertThrows;

import org.testng.annotations.Test;
import software.amazon.cryptography.examples.awsdbe.MigrationExampleStep1;
import software.amazon.cryptography.examples.awsdbe.MigrationExampleStep2;
import software.amazon.cryptography.examples.awsdbe.MigrationExampleStep3;
import software.amazon.cryptography.examples.plaintext.MigrationExampleStep0;

public class TestMigrationExampleStep0 {

  @Test
  public void TestMigrationStep0() {
    // Successfully executes step 0
    MigrationExampleStep0.MigrationStep0(TestUtils.TEST_DDB_TABLE_NAME, 0);

    // Given: Step 1 has succeeded
    MigrationExampleStep1.MigrationStep1(
      TestUtils.TEST_KMS_KEY_ID,
      TestUtils.TEST_DDB_TABLE_NAME,
      1
    );
    // When: Execute Step 0 with sortReadValue=1, Then: Success (i.e. can read plaintext values)
    MigrationExampleStep0.MigrationStep0(TestUtils.TEST_DDB_TABLE_NAME, 1);

    // Given: Step 2 has succeeded
    MigrationExampleStep2.MigrationStep2(
      TestUtils.TEST_KMS_KEY_ID,
      TestUtils.TEST_DDB_TABLE_NAME,
      2
    );
    // When: Execute Step 0 with sortReadValue=2, Then: throws AssertionError (i.e. cannot read encrypted values)
    assertThrows(
      AssertionError.class,
      () -> {
        MigrationExampleStep0.MigrationStep0(TestUtils.TEST_DDB_TABLE_NAME, 2);
      }
    );

    // Given: Step 3 has succeeded
    MigrationExampleStep3.MigrationStep3(
      TestUtils.TEST_KMS_KEY_ID,
      TestUtils.TEST_DDB_TABLE_NAME,
      3
    );
    // When: Execute Step 0 with sortReadValue=3, Then: throws AssertionError (i.e. cannot read encrypted values)
    assertThrows(
      AssertionError.class,
      () -> {
        MigrationExampleStep0.MigrationStep0(TestUtils.TEST_DDB_TABLE_NAME, 3);
      }
    );
  }
}
