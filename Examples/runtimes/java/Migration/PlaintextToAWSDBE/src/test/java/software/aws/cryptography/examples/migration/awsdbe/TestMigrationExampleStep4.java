package software.aws.cryptography.examples.migration.awsdbe;

import static org.testng.Assert.assertThrows;

import org.testng.annotations.Test;
import software.amazon.awssdk.core.exception.SdkClientException;
import software.aws.cryptography.examples.awsdbe.MigrationExampleStep1;
import software.aws.cryptography.examples.awsdbe.MigrationExampleStep2;
import software.aws.cryptography.examples.awsdbe.MigrationExampleStep4;
import software.aws.cryptography.examples.migration.plaintext.TestUtils;
import software.aws.cryptography.examples.plaintext.MigrationExampleStep0;

public class TestMigrationExampleStep4 {
    @Test
    public void TestMigrationStep0() {
        // Successfully executes step 4
        MigrationExampleStep4.MigrationStep4(TestUtils.TEST_KMS_KEY_ID, TestUtils.TEST_DDB_TABLE_NAME, 4);

        // Given: Step 0 has succeeded
        MigrationExampleStep0.MigrationStep0(TestUtils.TEST_DDB_TABLE_NAME, 0);
        // When: Execute Step 4 with sortReadValue=0, Then: throws SdkClientException (i.e. cannot read plaintext values)
        assertThrows(SdkClientException.class, () -> {
            MigrationExampleStep4.MigrationStep4(TestUtils.TEST_KMS_KEY_ID, TestUtils.TEST_DDB_TABLE_NAME, 0);
        });

        // Given: Step 1 has succeeded
        MigrationExampleStep1.MigrationStep1(TestUtils.TEST_KMS_KEY_ID, TestUtils.TEST_DDB_TABLE_NAME, 1);
        // When: Execute Step 4 with sortReadValue=1, Then: throws SdkClientException (i.e. cannot read plaintext values)
        assertThrows(SdkClientException.class, () -> {
            MigrationExampleStep4.MigrationStep4(TestUtils.TEST_KMS_KEY_ID, TestUtils.TEST_DDB_TABLE_NAME, 1);
        });

        // Given: Step 2 has succeeded
        MigrationExampleStep2.MigrationStep2(TestUtils.TEST_KMS_KEY_ID, TestUtils.TEST_DDB_TABLE_NAME, 2);
        // When: Execute Step 4 with sortReadValue=2, Then: Success (i.e. can read encrypted values)
        MigrationExampleStep4.MigrationStep4(TestUtils.TEST_KMS_KEY_ID, TestUtils.TEST_DDB_TABLE_NAME, 2);
    }
}
