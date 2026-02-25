package software.amazon.cryptography.examples.clientsupplier;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import org.testng.annotations.Test;
import software.amazon.awssdk.regions.Region;
import software.amazon.cryptography.examples.TestUtils;

public class TestClientSupplierExample {

  @Test
  public void TestClientSupplierExample() {
    final String partitionKeyValue = "ClientSupplierExample" + UUID.randomUUID();
    List<String> accounts = Collections.singletonList(
      TestUtils.TEST_AWS_ACCOUNT_ID
    );
    List<String> regions = Collections.singletonList(Region.EU_WEST_1.id());

    ClientSupplierExample.ClientSupplierPutItemGetItem(
      TestUtils.TEST_DDB_TABLE_NAME,
      // Note that we pass in an MRK in us-east-1...
      TestUtils.TEST_MRK_REPLICA_KEY_ID_US_EAST_1,
      accounts,
      // ...and access its replica in eu-west-1
      regions,
      partitionKeyValue,
      "0"
    );
    
    TestUtils.cleanUpDDBItem(
      TestUtils.TEST_DDB_TABLE_NAME,
      "partition_key",
      "sort_key",
      partitionKeyValue,
      "0"
    );
  }
}
