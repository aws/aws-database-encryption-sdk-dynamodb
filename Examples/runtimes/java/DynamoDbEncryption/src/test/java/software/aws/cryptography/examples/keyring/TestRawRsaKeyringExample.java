package software.aws.cryptography.examples.keyring;

import java.io.IOException;
import org.testng.annotations.Test;
import software.aws.cryptography.examples.TestUtils;

public class TestRawRsaKeyringExample {
    @Test
    public void TestRawRsaKeyringExample() throws IOException {
        RawRsaKeyringExample.RawRsaKeyringGetItemPutItem(
                TestUtils.TEST_DDB_TABLE_NAME);
    }
}
