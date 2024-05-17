// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.examples.plaintext;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeDefinition;
import software.amazon.awssdk.services.dynamodb.model.CreateTableRequest;
import software.amazon.awssdk.services.dynamodb.model.CreateTableResponse;
import software.amazon.awssdk.services.dynamodb.model.KeySchemaElement;
import software.amazon.awssdk.services.dynamodb.model.KeyType;
import software.amazon.awssdk.services.dynamodb.model.ScalarAttributeType;

/**
 * This class is referenced by the README.
 */
@SuppressWarnings("unused")
public class CreateSimpleTable {

  public static void Create(DynamoDbClient ddbClient, String ddbTableName) {
    CreateTableRequest request = CreateTableRequest
      .builder()
      .tableName(ddbTableName)
      .keySchema(
        KeySchemaElement
          .builder()
          .keyType(KeyType.HASH)
          .attributeName("partition_key")
          .build(),
        KeySchemaElement
          .builder()
          .keyType(KeyType.RANGE)
          .attributeName("sort_key")
          .build()
      )
      .attributeDefinitions(
        AttributeDefinition
          .builder()
          .attributeName("partition_key")
          .attributeType(ScalarAttributeType.S)
          .build(),
        AttributeDefinition
          .builder()
          .attributeName("sort_key")
          .attributeType(ScalarAttributeType.N)
          .build()
      )
      .build();
    CreateTableResponse response = ddbClient.createTable(request);
    if (!response.sdkHttpResponse().isSuccessful()) {
      throw new RuntimeException(
        String.format(
          "Create Table Failed. HTTP response: %s",
          response.sdkHttpResponse()
        )
      );
    }
  }
}
