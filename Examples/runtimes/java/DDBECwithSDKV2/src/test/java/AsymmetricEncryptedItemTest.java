// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

import java.util.UUID;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

public class AsymmetricEncryptedItemTest {

  final String partitionKeyName = "partition_key";
  final String sortKeyName = "sort_key";
  final String partitionKeyValue = "AsymmetricExample-" + UUID.randomUUID();
  final String sortKeyValue = "0";

  @Test
  public void testAsymmetricEncryption() throws Exception {
    try (final DynamoDbClient ddbClient = DynamoDbClient.create()) {
      AsymmetricEncryptedItem.encryptRecord(
        ddbClient,
        TestUtils.TEST_DDB_TABLE_NAME,
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
      "0"
    );
  }
}
