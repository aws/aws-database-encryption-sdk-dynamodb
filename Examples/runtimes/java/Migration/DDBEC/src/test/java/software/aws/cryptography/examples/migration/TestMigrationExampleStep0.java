package software.software.cryptography.examples.migration;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMappingException;
import org.testng.annotations.Test;

import static org.testng.Assert.assertThrows;

public class TestMigrationExampleStep0 {
    @Test
    public void TestMigrationStep0() {
        // Successfully reads items from steps 0 and 1
        MigrationExampleStep0.MigrationStep0(TestUtils.TEST_KMS_KEY_ID, TestUtils.TEST_DDB_TABLE_NAME, 0);
        MigrationExampleStep0.MigrationStep0(TestUtils.TEST_KMS_KEY_ID, TestUtils.TEST_DDB_TABLE_NAME, 1);

        // Does not read items from steps 2 and 3
        assertThrows(DynamoDBMappingException.class, () -> {
            MigrationExampleStep0.MigrationStep0(TestUtils.TEST_KMS_KEY_ID, TestUtils.TEST_DDB_TABLE_NAME, 2);
        });
        assertThrows(DynamoDBMappingException.class, () -> {
            MigrationExampleStep0.MigrationStep0(TestUtils.TEST_KMS_KEY_ID, TestUtils.TEST_DDB_TABLE_NAME, 3);
        });
    }
}
