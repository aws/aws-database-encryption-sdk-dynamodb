package software.aws.cryptography.examples.keyring;

import java.nio.ByteBuffer;
import org.testng.annotations.Test;
import software.aws.cryptography.examples.TestUtils;

public class TestRawAesKeyringExample {
    @Test
    public void TestRawAesKeyringExample() {
        // Generate a new AES key
        ByteBuffer aesKeyBytes = RawAesKeyringExample.generateAesKeyBytes();

        RawAesKeyringExample.RawAesKeyringGetItemPutItem(
                TestUtils.TEST_DDB_TABLE_NAME,
                aesKeyBytes);
    }
}
