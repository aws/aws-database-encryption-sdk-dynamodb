package software.amazon.cryptography.examples.searchableencryption;

import java.util.UUID;
import org.testng.annotations.Test;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;
import software.amazon.cryptography.examples.CreateKeyStoreKeyExample;

public class TestVirtualBeaconSearchableEncryptionExample {

  /**
   * Creates a DynamoDB table with the same schema as the CFN-provisioned
   * SimpleBeaconTestTable, but with a unique name to avoid collisions
   * when multiple test runs execute in parallel.
   * Includes the GSI required by the VirtualBeacon example.
   */
  private static String createTestTable(DynamoDbClient ddb) {
    String tableName =
      SearchableEncryptionTestUtils.SIMPLE_BEACON_TEST_DDB_TABLE_NAME +
      "-" +
      UUID.randomUUID().toString().substring(0, 8);

    ddb.createTable(
      CreateTableRequest
        .builder()
        .tableName(tableName)
        .attributeDefinitions(
          AttributeDefinition
            .builder()
            .attributeName("customer_id")
            .attributeType(ScalarAttributeType.S)
            .build(),
          AttributeDefinition
            .builder()
            .attributeName("create_time")
            .attributeType(ScalarAttributeType.S)
            .build(),
          AttributeDefinition
            .builder()
            .attributeName("aws_dbe_b_stateAndHasTestResult")
            .attributeType(ScalarAttributeType.S)
            .build()
        )
        .keySchema(
          KeySchemaElement
            .builder()
            .attributeName("customer_id")
            .keyType(KeyType.HASH)
            .build(),
          KeySchemaElement
            .builder()
            .attributeName("create_time")
            .keyType(KeyType.RANGE)
            .build()
        )
        .globalSecondaryIndexes(
          GlobalSecondaryIndex
            .builder()
            .indexName("stateAndHasTestResult-index")
            .keySchema(
              KeySchemaElement
                .builder()
                .attributeName("aws_dbe_b_stateAndHasTestResult")
                .keyType(KeyType.HASH)
                .build()
            )
            .projection(
              Projection.builder().projectionType(ProjectionType.ALL).build()
            )
            .provisionedThroughput(
              ProvisionedThroughput
                .builder()
                .readCapacityUnits(5L)
                .writeCapacityUnits(5L)
                .build()
            )
            .build()
        )
        .provisionedThroughput(
          ProvisionedThroughput
            .builder()
            .readCapacityUnits(5L)
            .writeCapacityUnits(5L)
            .build()
        )
        .build()
    );

    ddb
      .waiter()
      .waitUntilTableExists(
        DescribeTableRequest.builder().tableName(tableName).build()
      );

    return tableName;
  }

  private static void deleteTestTable(DynamoDbClient ddb, String tableName) {
    try {
      ddb.deleteTable(
        DeleteTableRequest.builder().tableName(tableName).build()
      );
    } catch (Exception e) {
      System.err.println(
        "Warning: failed to delete test table " +
        tableName +
        ": " +
        e.getMessage()
      );
    }
  }

  @Test
  public void TestVirtualBeaconExample() throws InterruptedException {
    // Create new branch key for test
    String keyId = CreateKeyStoreKeyExample.KeyStoreCreateKey(
      SearchableEncryptionTestUtils.TEST_BRANCH_KEYSTORE_DDB_TABLE_NAME,
      SearchableEncryptionTestUtils.TEST_LOGICAL_KEYSTORE_NAME,
      SearchableEncryptionTestUtils.TEST_BRANCH_KEY_WRAPPING_KMS_KEY_ARN
    );

    // Key creation is eventually consistent, so wait 5 seconds to decrease the likelihood
    // our test fails due to eventual consistency issues.
    Thread.sleep(5000);

    // Create a unique table for this test run to avoid collisions
    // when multiple tests run in parallel across different GHA runners.
    // Each run uses a different branch key, so items encrypted by one run
    // cannot be decrypted by another — sharing a table causes decryption failures.
    DynamoDbClient plainDdb = DynamoDbClient.create();
    String tableName = createTestTable(plainDdb);

    try {
      VirtualBeaconSearchableEncryptionExample.PutItemQueryItemWithVirtualBeacon(
        tableName,
        keyId,
        SearchableEncryptionTestUtils.TEST_BRANCH_KEY_WRAPPING_KMS_KEY_ARN,
        SearchableEncryptionTestUtils.TEST_BRANCH_KEYSTORE_DDB_TABLE_NAME
      );
    } finally {
      deleteTestTable(plainDdb, tableName);
    }
  }
}
