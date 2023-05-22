package software.amazon.cryptography.examples.migration;

import org.testng.annotations.Test;
import software.amazon.awssdk.core.exception.SdkClientException;

import static org.testng.Assert.assertThrows;

public class TestMigrationExampleStep3 {
    @Test
    public void TestMigrationStep3() {
        // Does not read items from steps 0 and 1
        assertThrows(SdkClientException.class, () -> {
            MigrationExampleStep3.MigrationStep3(TestUtils.TEST_KMS_KEY_ID, TestUtils.TEST_DDB_TABLE_NAME, 0);
        });
        assertThrows(SdkClientException.class, () -> {
            MigrationExampleStep3.MigrationStep3(TestUtils.TEST_KMS_KEY_ID, TestUtils.TEST_DDB_TABLE_NAME, 1);
        });

        // Successfully reads items from steps 2 and 3
        MigrationExampleStep3.MigrationStep3(TestUtils.TEST_KMS_KEY_ID, TestUtils.TEST_DDB_TABLE_NAME, 2);
        MigrationExampleStep3.MigrationStep3(TestUtils.TEST_KMS_KEY_ID, TestUtils.TEST_DDB_TABLE_NAME, 3);
    }
}
