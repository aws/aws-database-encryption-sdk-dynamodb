package software.aws.cryptography.examples.keyring;

import org.testng.annotations.Test;
import software.amazon.cryptography.keyStore.KeyStore;
import software.aws.cryptography.examples.TestUtils;

public class TestHierarchicalKeyringExample {
    @Test
    public void TestHierarchicalKeyringExample() {
        // Control plane: Configure keystore and create branch key IDs to use in the test
        KeystoreExample.configureKeystore(
            TestUtils.TEST_KEYSTORE_NAME,
            TestUtils.TEST_LOGICAL_KEYSTORE_NAME,
            TestUtils.TEST_KEYSTORE_KMS_KEY_ID
        );

        String tenant1BranchKeyId = KeystoreExample.createBranchKey();
        String tenant2BranchKeyId = KeystoreExample.createBranchKey();

        // Sleep for 1 second so keys are replicated across DDB table.
        // In practice, branch key creation SHOULD happen in a separate process from branch key usage,
        //   and a sleep will not be needed.
        // However, this test creates and uses the branch key in the same process. Since the keystore
        //   read is eventually consistent, we should sleep for a short time for the branch key to replicate.
        // The expected use case is that the branch key will be replicated before it is used.
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException("Interrupted while waiting for branch key creation", e);
        }

        // Data plane: Test example with branch key IDs
        KeyStore keystore = KeystoreExample.getConfiguredKeystore();
        HierarchicalKeyringExample.HierarchicalKeyringGetItemPutItem(
                TestUtils.TEST_DDB_TABLE_NAME,
                keystore,
                tenant1BranchKeyId,
                tenant2BranchKeyId);
    }
}
