package software.aws.cryptography.examples.keyring;

import java.nio.ByteBuffer;
import org.testng.annotations.Test;
import software.aws.cryptography.examples.TestUtils;

public class TestMultiKeyringExample {
    @Test
    public void TestMultiKeyringExample() {
        // Generate a new AES key
        ByteBuffer aesKeyBytes = RawAesKeyringExample.generateAesKeyBytes();

        MultiKeyringExample.MultiKeyringGetItemPutItem(
                TestUtils.TEST_DDB_TABLE_NAME,
                TestUtils.TEST_KMS_KEY_ID,
                aesKeyBytes);
    }
}
