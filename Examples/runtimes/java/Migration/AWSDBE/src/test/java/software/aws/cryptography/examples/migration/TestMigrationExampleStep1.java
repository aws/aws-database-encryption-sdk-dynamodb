package software.aws.cryptography.examples.migration;

import org.testng.annotations.Test;

public class TestMigrationExampleStep1 {
    @Test
    public void TestMigrationStep1() {
        MigrationExampleStep1.MigrationStep1(TestUtils.TEST_KMS_KEY_ID, TestUtils.TEST_DDB_TABLE_NAME, 0);
        MigrationExampleStep1.MigrationStep1(TestUtils.TEST_KMS_KEY_ID, TestUtils.TEST_DDB_TABLE_NAME, 1);
        MigrationExampleStep1.MigrationStep1(TestUtils.TEST_KMS_KEY_ID, TestUtils.TEST_DDB_TABLE_NAME, 2);
        MigrationExampleStep1.MigrationStep1(TestUtils.TEST_KMS_KEY_ID, TestUtils.TEST_DDB_TABLE_NAME, 3);
    }
}
