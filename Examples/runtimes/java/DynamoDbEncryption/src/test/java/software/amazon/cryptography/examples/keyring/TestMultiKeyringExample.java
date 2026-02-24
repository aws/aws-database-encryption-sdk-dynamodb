package software.amazon.cryptography.examples.keyring;

import java.nio.ByteBuffer;
import java.util.UUID;
import org.testng.annotations.Test;
import software.amazon.cryptography.examples.TestUtils;

public class TestMultiKeyringExample {

  @Test
  public void TestMultiKeyringExample() {
    final String partitionKeyValue = "MultiKeyringExample" + UUID.randomUUID();
    // Generate a new AES key
    ByteBuffer aesKeyBytes = RawAesKeyringExample.generateAesKeyBytes();

    MultiKeyringExample.MultiKeyringGetItemPutItem(
      TestUtils.TEST_DDB_TABLE_NAME,
      TestUtils.TEST_KMS_KEY_ID,
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
