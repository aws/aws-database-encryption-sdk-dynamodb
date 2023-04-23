package software.aws.cryptography.examples;

import org.testng.annotations.Test;

public class TestCreateKeyStoreTableExample {
    @Test
    public void TestCreateKeyStoreTableExample() {
        CreateKeyStoreTableExample.KeyStoreCreateTable(
                TestUtils.TEST_KEYSTORE_NAME,
                TestUtils.TEST_KEYSTORE_KMS_KEY_ID);
    }
}
