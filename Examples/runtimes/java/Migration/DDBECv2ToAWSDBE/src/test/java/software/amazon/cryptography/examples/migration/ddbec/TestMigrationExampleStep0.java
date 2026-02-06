package software.amazon.cryptography.examples.migration.ddbec;

import static org.testng.Assert.assertThrows;

import java.security.GeneralSecurityException;
import java.util.UUID;

import org.testng.annotations.Test;
import software.amazon.cryptography.examples.migration.awsdbe.MigrationExampleStep1;
import software.amazon.cryptography.examples.migration.awsdbe.MigrationExampleStep2;
import software.amazon.cryptography.examples.migration.awsdbe.MigrationExampleStep3;
import software.amazon.cryptools.dynamodbencryptionclientsdk2.encryption.exceptions.DynamoDbEncryptionException;

public class TestMigrationExampleStep0 {

  @Test
  public void TestMigrationStep0() throws GeneralSecurityException {
    final String partitionKeyValue = "TestMigrationStep0-DDBEC-with-sdk-v2" + UUID.randomUUID();
    // Successfully executes Step 0
    MigrationExampleStep0.MigrationStep0(
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
    // When: Execute Step 0 with sortReadValue=1, Then: Success (i.e. can read values in old format)
    MigrationExampleStep0.MigrationStep0(
      TestUtils.TEST_KMS_KEY_ID,
      TestUtils.TEST_DDB_TABLE_NAME,
            partitionKeyValue,
      1
    );

    // Given: Step 2 has succeeded
    MigrationExampleStep2.MigrationStep2(
      TestUtils.TEST_KMS_KEY_ID,
      TestUtils.TEST_DDB_TABLE_NAME,
            partitionKeyValue,
      2
    );
    // When: Execute Step 0 with sortReadValue=2, Then: throws exception (i.e. cannot read values in new format)
    assertThrows(
      DynamoDbEncryptionException.class,
      () -> {
        MigrationExampleStep0.MigrationStep0(
          TestUtils.TEST_KMS_KEY_ID,
          TestUtils.TEST_DDB_TABLE_NAME,
                partitionKeyValue,
          2
        );
      }
    );

    // Given: Step 3 has succeeded
    MigrationExampleStep3.MigrationStep3(
      TestUtils.TEST_KMS_KEY_ID,
      TestUtils.TEST_DDB_TABLE_NAME,
            partitionKeyValue,
      3
    );
    // When: Execute Step 0 with sortReadValue=3, Then: throws exception (i.e. cannot read values in new format)
    assertThrows(
      DynamoDbEncryptionException.class,
      () -> {
        MigrationExampleStep0.MigrationStep0(
          TestUtils.TEST_KMS_KEY_ID,
          TestUtils.TEST_DDB_TABLE_NAME,
                partitionKeyValue,
          3
        );
      }
    );
  }
}
