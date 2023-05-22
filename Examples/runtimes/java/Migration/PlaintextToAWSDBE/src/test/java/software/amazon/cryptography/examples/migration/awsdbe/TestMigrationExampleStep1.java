package software.amazon.cryptography.examples.migration.awsdbe;

import org.testng.annotations.Test;
import software.amazon.cryptography.examples.plaintext.MigrationExampleStep0;
import software.amazon.cryptography.examples.awsdbe.MigrationExampleStep1;
import software.amazon.cryptography.examples.awsdbe.MigrationExampleStep2;
import software.amazon.cryptography.examples.awsdbe.MigrationExampleStep4;

public class TestMigrationExampleStep1 {
    @Test
    public void TestMigrationStep1() {
        // Successfully executes Step 1
        MigrationExampleStep1.MigrationStep1(TestUtils.TEST_KMS_KEY_ID, TestUtils.TEST_DDB_TABLE_NAME, 1);

        // Given: Step 0 has succeeded
        MigrationExampleStep0.MigrationStep0(TestUtils.TEST_DDB_TABLE_NAME, 0);
        // When: Execute Step 1 with sortReadValue=0, Then: Success (i.e. can read plaintext values)
        MigrationExampleStep1.MigrationStep1(TestUtils.TEST_KMS_KEY_ID, TestUtils.TEST_DDB_TABLE_NAME, 0);

        // Given: Step 2 has succeeded
        MigrationExampleStep2.MigrationStep2(TestUtils.TEST_KMS_KEY_ID, TestUtils.TEST_DDB_TABLE_NAME, 2);
        // When: Execute Step 1 with sortReadValue=2, Then: Success (i.e. can read encrypted values)
        MigrationExampleStep1.MigrationStep1(TestUtils.TEST_KMS_KEY_ID, TestUtils.TEST_DDB_TABLE_NAME, 2);

        // Given: Step 4 has succeeded
        MigrationExampleStep4.MigrationStep4(TestUtils.TEST_KMS_KEY_ID, TestUtils.TEST_DDB_TABLE_NAME, 4);
        // When: Execute Step 1 with sortReadValue=4, Then: Success (i.e. can read encrypted values)
        MigrationExampleStep1.MigrationStep1(TestUtils.TEST_KMS_KEY_ID, TestUtils.TEST_DDB_TABLE_NAME, 4);
    }
}
