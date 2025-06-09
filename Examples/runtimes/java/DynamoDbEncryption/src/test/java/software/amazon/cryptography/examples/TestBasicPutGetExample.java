package software.amazon.cryptography.examples;

import java.util.UUID;
import org.testng.annotations.Test;

public class TestBasicPutGetExample {

  @Test
  public void TestPutGet() {
    BasicPutGetExample.PutItemGetItem(
      TestUtils.TEST_KMS_KEY_ID,
      TestUtils.TEST_DDB_TABLE_NAME,
      "BasicPutGetExample" + UUID.randomUUID()
    );
  }
}
