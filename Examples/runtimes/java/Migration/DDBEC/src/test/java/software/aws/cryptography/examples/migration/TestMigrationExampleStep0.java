package software.aws.cryptography.examples.migration;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMappingException;
import org.testng.annotations.Test;

import static org.testng.Assert.assertThrows;

public class TestMigrationExampleStep0 {
    @Test
    public void TestMigrationStep0() {
        MigrationExampleStep0.MigrationStep0(TestUtils.TEST_KMS_KEY_ID, TestUtils.TEST_DDB_TABLE_NAME, 0);
    }
}
