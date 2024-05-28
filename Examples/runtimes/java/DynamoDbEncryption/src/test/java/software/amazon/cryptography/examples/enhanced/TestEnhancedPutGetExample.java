package software.amazon.cryptography.examples.enhanced;

import org.testng.annotations.Test;
import software.amazon.cryptography.examples.TestUtils;

public class TestEnhancedPutGetExample {

  @Test
  public void TestEnhancedPutGet() {
    EnhancedPutGetExample.PutItemGetItem(
      TestUtils.TEST_KMS_KEY_ID,
      TestUtils.TEST_DDB_TABLE_NAME
    );
  }

  @Test
  public void TestLombokPutGet() {
    LombokPutGetExample.PutItemGetItem(
      TestUtils.TEST_KMS_KEY_ID,
      TestUtils.TEST_DDB_TABLE_NAME
    );
  }

  @Test
  public void TestTableSchemaBuilderPutGet() {
    TableSchemaBuilderPutGetExample.PutItemGetItem(
      TestUtils.TEST_KMS_KEY_ID,
      TestUtils.TEST_DDB_TABLE_NAME
    );
  }
}
