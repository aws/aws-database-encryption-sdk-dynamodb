// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

import java.util.UUID;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.kms.KmsClient;

public class AwsKmsEncryptedItemTest {

  final String partitionKeyValue = "AwsKmsExample-" + UUID.randomUUID();
  final String sortKeyValue = "0";
  final String partitionKeyName = "partition_key";
  final String sortKeyName = "sort_key";

  @Test
  public void testAwsKmsEncryption() throws Exception {
    try (final DynamoDbClient ddbClient = DynamoDbClient.create()) {
      AwsKmsEncryptedItem.encryptRecord(
        ddbClient,
        KmsClient.create(),
        TestUtils.TEST_DDB_TABLE_NAME,
        TestUtils.TEST_KMS_KEY_ID,
        partitionKeyName,
        sortKeyName,
        partitionKeyValue,
        sortKeyValue
      );
    }
  }

  @AfterMethod
  public void cleanup() {
    TestUtils.cleanUpDDBItem(
      TestUtils.TEST_DDB_TABLE_NAME,
      partitionKeyName,
      sortKeyName,
      partitionKeyValue,
      sortKeyValue
    );
  }
}
