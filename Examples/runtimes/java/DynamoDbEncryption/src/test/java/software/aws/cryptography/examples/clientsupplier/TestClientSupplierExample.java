package software.aws.cryptography.examples.clientsupplier;

import java.util.Collections;
import java.util.List;
import org.testng.annotations.Test;
import software.aws.cryptography.examples.TestUtils;

public class TestClientSupplierExample {
    @Test
    public void TestClientSupplierExample() {
        List<String> accounts = Collections.singletonList(TestUtils.TEST_AWS_ACCOUNT_ID);
        List<String> regions = Collections.singletonList("us-east-1");

        ClientSupplierExample.ClientSupplierPutItemGetItem(
                TestUtils.TEST_DDB_TABLE_NAME,
                TestUtils.TEST_MRK_REPLICA_KEY_ID_US_EAST_1,
                accounts,
                regions);
    }
}
