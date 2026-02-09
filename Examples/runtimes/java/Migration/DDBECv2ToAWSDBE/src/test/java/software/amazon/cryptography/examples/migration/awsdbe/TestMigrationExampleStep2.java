package software.amazon.cryptography.examples.migration.awsdbe;

import java.security.GeneralSecurityException;
import java.util.UUID;

import org.testng.annotations.Test;
import software.amazon.cryptography.examples.migration.ddbec.MigrationExampleStep0;

public class TestMigrationExampleStep2 {

  @Test
  public void TestMigrationStep2() throws GeneralSecurityException {
    final String partitionKeyValue = "TestMigrationStep2-DDBEC-with-sdk-v2" + UUID.randomUUID();
    // Successfully executes step 2
    MigrationExampleStep2.MigrationStep2(
      TestUtils.TEST_KMS_KEY_ID,
      TestUtils.TEST_DDB_TABLE_NAME,
      partitionKeyValue,
      2
    );

    // Given: Step 0 has succeeded
    MigrationExampleStep0.MigrationStep0(
      TestUtils.TEST_KMS_KEY_ID,
      TestUtils.TEST_DDB_TABLE_NAME,
      partitionKeyValue,
      0
    );
    // When: Execute Step 2 with sortReadValue=0, Then: Success (i.e. can read values in old format)
    MigrationExampleStep2.MigrationStep2(
      TestUtils.TEST_KMS_KEY_ID,
      TestUtils.TEST_DDB_TABLE_NAME,
      partitionKeyValue,
      0
    );

    // Given: Step 1 has succeeded
    MigrationExampleStep1.MigrationStep1(
      TestUtils.TEST_KMS_KEY_ID,
      TestUtils.TEST_DDB_TABLE_NAME,
      partitionKeyValue,
      1
    );
    // When: Execute Step 2 with sortReadValue=1, Then: Success (i.e. can read values in old format)
    MigrationExampleStep2.MigrationStep2(
      TestUtils.TEST_KMS_KEY_ID,
      TestUtils.TEST_DDB_TABLE_NAME,
      partitionKeyValue,
      1
    );

    // Given: Step 3 has succeeded
    MigrationExampleStep3.MigrationStep3(
      TestUtils.TEST_KMS_KEY_ID,
      TestUtils.TEST_DDB_TABLE_NAME,
      partitionKeyValue,
      3
    );
    // When: Execute Step 2 with sortReadValue=3, Then: Success (i.e. can read values in new format)
    MigrationExampleStep2.MigrationStep2(
      TestUtils.TEST_KMS_KEY_ID,
      TestUtils.TEST_DDB_TABLE_NAME,
      partitionKeyValue,
      3
    );
  }
}
