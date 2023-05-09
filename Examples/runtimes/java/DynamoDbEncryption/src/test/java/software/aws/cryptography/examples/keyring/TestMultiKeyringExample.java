package software.aws.cryptography.examples.keyring;

import org.testng.annotations.Test;
import software.aws.cryptography.examples.TestUtils;

public class TestMultiKeyringExample {
    @Test
    public void TestMultiKeyringExample() {
        MultiKeyringExample.MultiKeyringGetItemPutItem(
                TestUtils.TEST_DDB_TABLE_NAME,
                TestUtils.TEST_KMS_KEY_ID);
    }
}
