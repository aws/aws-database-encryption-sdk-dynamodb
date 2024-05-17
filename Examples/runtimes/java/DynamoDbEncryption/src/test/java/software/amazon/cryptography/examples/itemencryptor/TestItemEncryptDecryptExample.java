package software.amazon.cryptography.examples.itemencryptor;

import org.testng.annotations.Test;
import software.amazon.cryptography.examples.TestUtils;

public class TestItemEncryptDecryptExample {

  @Test
  public void TestItemEncryptDecrypt() {
    ItemEncryptDecryptExample.PutItemGetItem(
      TestUtils.TEST_KMS_KEY_ID,
      TestUtils.TEST_DDB_TABLE_NAME
    );
  }
}
