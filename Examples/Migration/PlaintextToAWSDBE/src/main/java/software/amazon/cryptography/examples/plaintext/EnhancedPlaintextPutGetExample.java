// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.examples.plaintext;

import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

/**
 * This class is referenced by the README.
 */
@SuppressWarnings("unused")
public class EnhancedPlaintextPutGetExample {

  public static void PutItemGetItem(DynamoDbClient ddb, String ddbTableName) {
    DynamoDbEnhancedClient enhancedClient = DynamoDbEnhancedClient
      .builder()
      .dynamoDbClient(ddb)
      .build();

    final TableSchema<SimpleClass> tableSchema = TableSchema.fromBean(
      SimpleClass.class
    );
    final DynamoDbTable<SimpleClass> table = enhancedClient.table(
      ddbTableName,
      tableSchema
    );

    SimpleClass itemToPut = new SimpleClass();
    itemToPut.setPartitionKey("anyKey");
    itemToPut.setSortKey(0);
    itemToPut.setAttribute1("this is not encrypted");
    table.putItem(itemToPut);

    // Load the item back from DynamoDB
    SimpleClass itemToGet = new SimpleClass();
    itemToGet.setPartitionKey("anyKey");
    itemToGet.setSortKey(0);
    SimpleClass returnedItem = table.getItem(itemToGet);
  }
}
