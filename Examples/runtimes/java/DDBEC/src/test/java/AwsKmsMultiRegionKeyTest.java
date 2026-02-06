// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

public class AwsKmsMultiRegionKeyTest {

  // Multi-region KMS keys (MRKs) - same key replicated across regions
  private static final String MRK_US_EAST_1 =
    "arn:aws:kms:us-east-1:658956600833:key/mrk-80bd8ecdcd4342aebd84b7dc9da498a7";
  private static final String MRK_EU_WEST_1 =
    "arn:aws:kms:eu-west-1:658956600833:key/mrk-80bd8ecdcd4342aebd84b7dc9da498a7";

  @Test
  public void testMultiRegionEncryption() throws Exception {
    // Encrypt with us-east-1 MRK, decrypt with eu-west-1 replica MRK
    // This demonstrates MRK capability without needing a Global Table
    final String tableName = TestUtils.TEST_DDB_TABLE_NAME;
    try (final DynamoDbClient ddbClient = DynamoDbClient.create()) {
      AwsKmsMultiRegionKey.encryptRecord(
        ddbClient,
        tableName,
        MRK_US_EAST_1,
        MRK_EU_WEST_1
      );
    }
  }

  @AfterMethod
  public void cleanup() {
    TestUtils.cleanUpDDBItem(
      TestUtils.TEST_DDB_TABLE_NAME,
      "partition_key",
      "sort_key",
      "is this",
      "42"
    );
  }
}
