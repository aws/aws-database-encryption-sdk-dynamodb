package software.amazon.cryptography.examples.migration.awsdbe;

import java.security.GeneralSecurityException;
import java.util.UUID;

import org.testng.annotations.Test;
import software.amazon.cryptography.examples.migration.ddbec.MigrationExampleStep0;

public class TestMigrationExampleStep1 {

  @Test
  public void TestMigrationStep1() throws GeneralSecurityException {
    final String partitionKeyValue = "TestMigrationStep1-DDBEC-with-sdk-v2" + UUID.randomUUID();
    // Successfully executes step 1
    MigrationExampleStep1.MigrationStep1(
      TestUtils.TEST_KMS_KEY_ID,
      TestUtils.TEST_DDB_TABLE_NAME,
      partitionKeyValue,
      1
    );

    // Given: Step 0 has succeeded
    MigrationExampleStep0.MigrationStep0(
      TestUtils.TEST_KMS_KEY_ID,
      TestUtils.TEST_DDB_TABLE_NAME,
      partitionKeyValue,
      0
    );
    // When: Execute Step 1 with sortReadValue=0, Then: Success (i.e. can read values in old format)
    MigrationExampleStep1.MigrationStep1(
      TestUtils.TEST_KMS_KEY_ID,
      TestUtils.TEST_DDB_TABLE_NAME,
      partitionKeyValue,
      0
    );

    // Given: Step 2 has succeeded
    MigrationExampleStep2.MigrationStep2(
      TestUtils.TEST_KMS_KEY_ID,
      TestUtils.TEST_DDB_TABLE_NAME,
      partitionKeyValue,
      2
    );
    // When: Execute Step 1 with sortReadValue=2, Then: Success (i.e. can read values in new format)
    MigrationExampleStep1.MigrationStep1(
      TestUtils.TEST_KMS_KEY_ID,
      TestUtils.TEST_DDB_TABLE_NAME,
      partitionKeyValue,
      2
    );

    // Given: Step 3 has succeeded
    MigrationExampleStep3.MigrationStep3(
      TestUtils.TEST_KMS_KEY_ID,
      TestUtils.TEST_DDB_TABLE_NAME,
      partitionKeyValue,
      3
    );
    // When: Execute Step 1 with sortReadValue=3, Then: Success (i.e. can read values in new format)
    MigrationExampleStep1.MigrationStep1(
      TestUtils.TEST_KMS_KEY_ID,
      TestUtils.TEST_DDB_TABLE_NAME,
      partitionKeyValue,
      3
    );
  }
}
