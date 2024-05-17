package software.amazon.cryptography.examples;

import org.testng.annotations.Test;

public class TestGetEncryptedDataKeyDescriptionExample {

  @Test
  public void TestGetEncryptedDataKeyDescription() {
    GetEncryptedDataKeyDescriptionExample.getEncryptedDataKeyDescription(
      TestUtils.TEST_DDB_TABLE_NAME,
      "partition_key",
      "BasicPutGetExample",
      "sort_key",
      "0",
      "aws-kms",
      TestUtils.TEST_KMS_KEY_ID,
      null,
      null
    );
  }
}
