package software.amazon.cryptography.examples.migration.ddbec;

import static org.testng.Assert.assertThrows;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMappingException;
import org.testng.annotations.Test;
import software.amazon.cryptography.examples.migration.awsdbe.MigrationExampleStep1;
import software.amazon.cryptography.examples.migration.awsdbe.MigrationExampleStep2;
import software.amazon.cryptography.examples.migration.awsdbe.MigrationExampleStep3;

import java.security.GeneralSecurityException;

public class TestMigrationExampleStep0 {

  @Test
  public void TestMigrationStep0() throws GeneralSecurityException {
    // Successfully executes Step 0
    MigrationExampleStep0.MigrationStep0(
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
    // When: Execute Step 0 with sortReadValue=1, Then: Success (i.e. can read values in old format)
    MigrationExampleStep0.MigrationStep0(
      TestUtils.TEST_KMS_KEY_ID,
      TestUtils.TEST_DDB_TABLE_NAME,
      1
    );

    // Given: Step 2 has succeeded
    MigrationExampleStep2.MigrationStep2(
      TestUtils.TEST_KMS_KEY_ID,
      TestUtils.TEST_DDB_TABLE_NAME,
      2
    );
    // When: Execute Step 0 with sortReadValue=2, Then: throws DynamoDBMappingException (i.e. cannot read values in new format)
    assertThrows(
      // TODO: make specific exception
      Exception.class,
      () -> {
        MigrationExampleStep0.MigrationStep0(
          TestUtils.TEST_KMS_KEY_ID,
          TestUtils.TEST_DDB_TABLE_NAME,
          2
        );
      }
    );

    // Given: Step 3 has succeeded
    MigrationExampleStep3.MigrationStep3(
      TestUtils.TEST_KMS_KEY_ID,
      TestUtils.TEST_DDB_TABLE_NAME,
      3
    );
    // When: Execute Step 0 with sortReadValue=3, Then: throws DynamoDBMappingException (i.e. cannot read values in new format)
    assertThrows(
      // TODO: make specific exception
      Exception.class,
      () -> {
        MigrationExampleStep0.MigrationStep0(
          TestUtils.TEST_KMS_KEY_ID,
          TestUtils.TEST_DDB_TABLE_NAME,
          3
        );
      }
    );
  }
}
