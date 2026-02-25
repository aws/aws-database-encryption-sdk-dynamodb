package software.amazon.cryptography.examples.itemencryptor;

import java.util.UUID;
import org.testng.annotations.Test;
import software.amazon.cryptography.examples.TestUtils;

public class TestItemEncryptDecryptExample {

  @Test
  public void TestItemEncryptDecrypt() {
    final String partitionKeyValue = "ItemEncryptDecryptExample" + UUID.randomUUID();
    ItemEncryptDecryptExample.PutItemGetItem(
      TestUtils.TEST_KMS_KEY_ID,
      TestUtils.TEST_DDB_TABLE_NAME,
      partitionKeyValue,
      "0"
    );
  }
}
