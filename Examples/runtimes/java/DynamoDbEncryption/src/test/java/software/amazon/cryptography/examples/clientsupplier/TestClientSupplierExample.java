package software.amazon.cryptography.examples.clientsupplier;

import java.util.Collections;
import java.util.List;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import software.amazon.awssdk.regions.Region;
import software.amazon.cryptography.examples.TestUtils;
import software.amazon.cryptography.examples.keyring.MultiMrkKeyringExample;

public class TestClientSupplierExample {

  @Test
  public void TestClientSupplierExample() {
    List<String> accounts = Collections.singletonList(
      TestUtils.TEST_AWS_ACCOUNT_ID
    );
    List<String> regions = Collections.singletonList(Region.EU_WEST_1.id());

    // ClientSupplierExample reads an item written by MultiMrkKeyringExample
    // (partition_key = "awsKmsMrkMultiKeyringItem") to demonstrate discovery
    // decryption with a client supplier. Ensure that item exists first.
    MultiMrkKeyringExample.MultiMrkKeyringGetItemPutItem(
      TestUtils.TEST_DDB_TABLE_NAME,
      TestUtils.TEST_MRK_KEY_ID,
      TestUtils.TEST_KMS_KEY_ID,
      TestUtils.TEST_MRK_REPLICA_KEY_ID_US_EAST_1
    );

    ClientSupplierExample.ClientSupplierPutItemGetItem(
      TestUtils.TEST_DDB_TABLE_NAME,
      // Note that we pass in an MRK in us-east-1...
      TestUtils.TEST_MRK_REPLICA_KEY_ID_US_EAST_1,
      accounts,
      // ...and access its replica in eu-west-1
      regions
    );
  }

  @AfterTest
  public void cleanup() {
    TestUtils.cleanUpExampleItem("clientSupplierItem");
    TestUtils.cleanUpExampleItem("awsKmsMrkMultiKeyringItem");
  }
}
