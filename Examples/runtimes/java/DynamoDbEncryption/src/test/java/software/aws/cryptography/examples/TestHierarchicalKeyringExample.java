package software.aws.cryptography.examples;

import org.testng.annotations.Test;

public class TestHierarchicalKeyringExample {
    @Test
    public void TestHierarchicalKeyringExample() throws InterruptedException {
        // Create new branch keys for test
        String keyId1 = CreateKeyStoreKeyExample.KeyStoreCreateKey(
                TestUtils.TEST_KEYSTORE_NAME,
                TestUtils.TEST_KEYSTORE_KMS_KEY_ID);
        String keyId2 = CreateKeyStoreKeyExample.KeyStoreCreateKey(
                TestUtils.TEST_KEYSTORE_NAME,
                TestUtils.TEST_KEYSTORE_KMS_KEY_ID);

        // Key creation is eventually consistent, so wait 5 seconds to decrease the likelihood
        // our test fails due to eventual consistency issues.
        // TODO: poll the table, with retries and backoff, to do this more elegantly.
        Thread.sleep(5000);

        HierarchicalKeyringExample.HierarchicalKeyringGetItemPutItem(
                TestUtils.TEST_DDB_TABLE_NAME,
                keyId1,
                keyId2,
                TestUtils.TEST_KEYSTORE_NAME,
                TestUtils.TEST_LOGICAL_KEYSTORE_NAME,
                TestUtils.TEST_KEYSTORE_KMS_KEY_ID);
    }
}
