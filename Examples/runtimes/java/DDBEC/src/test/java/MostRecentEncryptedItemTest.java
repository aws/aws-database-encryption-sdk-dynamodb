// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

import java.util.UUID;
import org.testng.annotations.Test;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.kms.KmsClient;

public class MostRecentEncryptedItemTest {

  private static final String KEY_TABLE_NAME = "v2MostRecentKeyProviderPerfTestKeys";
  private static final String MATERIAL_NAME = "testMaterial";

  @Test
  public void testMostRecentEncryption() throws Exception {
    final String partitionKeyValue = "MostRecentExample-" + UUID.randomUUID();
    final String sortKeyValue = "0";

    try (final DynamoDbClient ddbClient = DynamoDbClient.create()) {
      MostRecentEncryptedItem.encryptRecord(
          ddbClient,
              KmsClient.create(),
          TestUtils.TEST_DDB_TABLE_NAME,
          KEY_TABLE_NAME,
          TestUtils.TEST_KMS_KEY_ID,
          MATERIAL_NAME,
          "partition_key",
          "sort_key",
          partitionKeyValue,
          sortKeyValue);
    }
  }
}
