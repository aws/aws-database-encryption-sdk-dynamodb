package software.software.cryptography.examples.enhanced;

import org.testng.annotations.Test;
import software.software.cryptography.examples.TestUtils;

public class TestEnhancedPutGetExample {
    @Test
    public void TestEnhancedPutGet() {
        EnhancedPutGetExample.PutItemGetItem(TestUtils.TEST_KMS_KEY_ID, TestUtils.TEST_DDB_TABLE_NAME);
    }
}
