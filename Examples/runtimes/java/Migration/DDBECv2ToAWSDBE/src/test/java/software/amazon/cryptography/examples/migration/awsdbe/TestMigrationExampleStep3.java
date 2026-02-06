package software.amazon.cryptography.examples.migration.awsdbe;

import static org.testng.Assert.assertThrows;

import java.security.GeneralSecurityException;
import java.util.UUID;

import org.testng.annotations.Test;
import software.amazon.awssdk.core.exception.SdkClientException;
import software.amazon.cryptography.examples.migration.ddbec.MigrationExampleStep0;

public class TestMigrationExampleStep3 {

  @Test
  public void TestMigrationStep3() throws GeneralSecurityException {
    final String partitionKeyValue = "TestMigrationStep3-DDBEC-with-sdk-v2" + UUID.randomUUID();
    // Successfully executes Step 3
    MigrationExampleStep3.MigrationStep3(
      TestUtils.TEST_KMS_KEY_ID,
      TestUtils.TEST_DDB_TABLE_NAME,
      partitionKeyValue,
      3
    );

    // Given: Step 0 has succeeded
    MigrationExampleStep0.MigrationStep0(
      TestUtils.TEST_KMS_KEY_ID,
      TestUtils.TEST_DDB_TABLE_NAME,
      partitionKeyValue,
      0
    );
    // When: Execute Step 3 with sortReadValue=0, Then: throws SdkClientException (i.e. cannot read values in old format)
    assertThrows(
      SdkClientException.class,
      () -> {
        MigrationExampleStep3.MigrationStep3(
          TestUtils.TEST_KMS_KEY_ID,
          TestUtils.TEST_DDB_TABLE_NAME,
          partitionKeyValue,
          0
        );
      }
    );

    // Given: Step 1 has succeeded
    MigrationExampleStep1.MigrationStep1(
      TestUtils.TEST_KMS_KEY_ID,
      TestUtils.TEST_DDB_TABLE_NAME,
      partitionKeyValue,
      1
    );
    // When: Execute Step 3 with sortReadValue=1, Then: throws SdkClientException (i.e. cannot read values in old format)
    assertThrows(
      SdkClientException.class,
      () -> {
        MigrationExampleStep3.MigrationStep3(
          TestUtils.TEST_KMS_KEY_ID,
          TestUtils.TEST_DDB_TABLE_NAME,
          partitionKeyValue,
          1
        );
      }
    );

    // Given: Step 2 has succeeded
    MigrationExampleStep2.MigrationStep2(
      TestUtils.TEST_KMS_KEY_ID,
      TestUtils.TEST_DDB_TABLE_NAME,
      partitionKeyValue,
      2
    );
    // When: Execute Step 3 with sortReadValue=2, Then: Success (i.e. can read values in new format)
    MigrationExampleStep3.MigrationStep3(
      TestUtils.TEST_KMS_KEY_ID,
      TestUtils.TEST_DDB_TABLE_NAME,
      partitionKeyValue,
      2
    );
  }
}
