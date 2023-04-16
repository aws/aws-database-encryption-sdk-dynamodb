package software.aws.cryptography.examples;

import org.testng.annotations.Test;

public class TestHierarchicalKeyringExample {
    @Test
    public void TestHierarchicalKeyringExample() {
        HierarchicalKeyringExample.HierarchicalKeyringGetItemPutItem(
                TestUtils.TEST_DDB_TABLE_NAME,
                TestUtils.TEST_KEYSTORE_NAME,
                TestUtils.TEST_KEYSTORE_KMS_KEY_ID);
    }
}
