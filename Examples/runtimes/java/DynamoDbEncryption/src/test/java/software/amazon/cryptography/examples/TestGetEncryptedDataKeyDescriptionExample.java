package software.amazon.cryptography.examples;

import java.util.UUID;
import org.testng.annotations.Test;

public class TestGetEncryptedDataKeyDescriptionExample {

  @Test
  public void TestGetEncryptedDataKeyDescription() {
    final String partitionKeyValue =
      "GetEncryptedDataKeyDescriptionExample" + UUID.randomUUID();
    final String partitionKeyName = "partition_key";
    final String sortKeyValue = "0";
    final String sortKeyName = "sort_key";
    // `getEncryptedDataKeyDescription` assumes that there is already existing item in dynamodb.
    // So, we need to run `PutItemGetItem` before `getEncryptedDataKeyDescription`
    BasicPutGetExample.PutItemGetItem(
      TestUtils.TEST_KMS_KEY_ID,
      TestUtils.TEST_DDB_TABLE_NAME,
      partitionKeyName,
      sortKeyName,
      partitionKeyValue,
      sortKeyValue
    );
    GetEncryptedDataKeyDescriptionExample.getEncryptedDataKeyDescription(
      TestUtils.TEST_DDB_TABLE_NAME,
      partitionKeyName,
      partitionKeyValue,
      sortKeyName,
      sortKeyValue,
      "aws-kms",
      TestUtils.TEST_KMS_KEY_ID,
      null,
      null
    );
    TestUtils.cleanUpDDBItem(
      TestUtils.TEST_DDB_TABLE_NAME,
      partitionKeyName,
      sortKeyName,
      partitionKeyValue,
      sortKeyValue
    );
  }
}
