package software.aws.cryptography.examples.keyring;

import org.testng.annotations.Test;
import software.aws.cryptography.examples.TestUtils;

public class TestHierarchicalKeyringExample {
    @Test
    public void TestHierarchicalKeyringExample() {
        HierarchicalKeyringExample.HierarchicalKeyringGetItemPutItem(
                TestUtils.TEST_DDB_TABLE_NAME,
                TestUtils.TEST_KEYSTORE_NAME,
                TestUtils.TEST_LOGICAL_KEYSTORE_NAME,
                TestUtils.TEST_KEYSTORE_KMS_KEY_ID);
    }
}
