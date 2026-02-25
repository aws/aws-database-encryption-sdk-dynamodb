package software.amazon.cryptography.examples.keyring;

import java.util.UUID;
import org.testng.annotations.Test;
import software.amazon.cryptography.examples.TestUtils;

public class TestRawRsaKeyringExample {

  @Test
  public void TestRawRsaKeyringExample() {
    final String partitionKeyValue = "RawRsaKeyringExample" + UUID.randomUUID();
    // You may provide your own RSA key pair in the files located at
    //  - EXAMPLE_RSA_PRIVATE_KEY_FILENAME
    //  - EXAMPLE_RSA_PUBLIC_KEY_FILENAME
    // If these files are not present, this will generate a pair for you
    if (RawRsaKeyringExample.shouldGenerateNewRsaKeyPair()) {
      RawRsaKeyringExample.generateRsaKeyPair();
    }

    RawRsaKeyringExample.RawRsaKeyringGetItemPutItem(
      TestUtils.TEST_DDB_TABLE_NAME,
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
