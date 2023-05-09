package software.aws.cryptography.examples.keyring;

import org.testng.annotations.Test;
import software.aws.cryptography.examples.TestUtils;

public class TestRawAesKeyringExample {
    @Test
    public void TestRawAesKeyringExample() {
        RawAesKeyringExample.RawAesKeyringGetItemPutItem(
                TestUtils.TEST_DDB_TABLE_NAME);
    }
}
