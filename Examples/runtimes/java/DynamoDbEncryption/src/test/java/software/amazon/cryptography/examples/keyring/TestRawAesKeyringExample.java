package software.amazon.cryptography.examples.keyring;

import java.nio.ByteBuffer;
import java.util.UUID;
import org.testng.annotations.Test;
import software.amazon.cryptography.examples.TestUtils;

public class TestRawAesKeyringExample {

  @Test
  public void TestRawAesKeyringExample() {
    final String partitionKeyValue = "RawAesKeyringExample" + UUID.randomUUID();
    // Generate a new AES key
    ByteBuffer aesKeyBytes = RawAesKeyringExample.generateAesKeyBytes();

    RawAesKeyringExample.RawAesKeyringGetItemPutItem(
      TestUtils.TEST_DDB_TABLE_NAME,
      aesKeyBytes,
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
