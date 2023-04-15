package software.aws.cryptography.examples.migration;

import org.testng.annotations.Test;
import software.amazon.awssdk.core.exception.SdkClientException;

import static org.testng.Assert.assertThrows;

public class TestMigrationExampleStep3 {
    @Test
    public void TestMigrationStep3() {
        MigrationExampleStep3.MigrationStep3(TestUtils.TEST_KMS_KEY_ID, TestUtils.TEST_DDB_TABLE_NAME, 3);
    }
}
