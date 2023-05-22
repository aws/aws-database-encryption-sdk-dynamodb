package software.amazon.cryptography.examples.migration.awsdbe;

import org.testng.annotations.Test;
import software.amazon.cryptography.examples.awsdbe.MigrationExampleStep1;
import software.amazon.cryptography.examples.awsdbe.MigrationExampleStep2;
import software.amazon.cryptography.examples.awsdbe.MigrationExampleStep3;
import software.amazon.cryptography.examples.plaintext.MigrationExampleStep0;

import static org.testng.Assert.assertThrows;

public class TestMigrationExampleStep3 {
    @Test
    public void TestMigrationStep3() {
        // Given: All the previous migration steps have been run.
        MigrationExampleStep0.MigrationStep0(TestUtils.TEST_DDB_TABLE_NAME, 0);
        MigrationExampleStep1.MigrationStep1(TestUtils.TEST_KMS_KEY_ID, TestUtils.TEST_DDB_TABLE_NAME, 1);
        MigrationExampleStep2.MigrationStep2(TestUtils.TEST_KMS_KEY_ID, TestUtils.TEST_DDB_TABLE_NAME, 2);
        // When: Execute Step 3, Then: Success (i.e. encrypts 2 plaintext values)
        MigrationExampleStep3.MigrationStep3(TestUtils.TEST_KMS_KEY_ID, TestUtils.TEST_DDB_TABLE_NAME);
    }
}
