// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../src/Index.dfy"
include "TestFixtures.dfy"

module QueryTransformTest {
  import opened Wrappers
  import opened DynamoDbEncryptionTransforms
  import opened TestFixtures
  import DDB = ComAmazonawsDynamodbTypes
  import AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes

  method {:test} TestQueryInputPassthrough() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionTransforms();
    var tableName := GetTableName("no_such_table");
    var input := DDB.QueryInput(
      TableName := tableName,
      IndexName := None(),
      Select := None(),
      AttributesToGet := None(),
      Limit := None(),
      ConsistentRead := None(),
      KeyConditions := None(),
      QueryFilter := None(),
      ConditionalOperator := None(),
      ScanIndexForward := None(),
      ExclusiveStartKey := None(),
      ReturnConsumedCapacity := None(),
      ProjectionExpression := None(),
      FilterExpression := None(),
      KeyConditionExpression := None(),
      ExpressionAttributeNames := None(),
      ExpressionAttributeValues := None()
    );
    var transformed := middlewareUnderTest.QueryInputTransform(
      AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.QueryInputTransformInput(
        sdkInput := input
      )
    );

    expect_ok("QueryInput", transformed);
    expect_equal("QueryInput", transformed.value.transformedInput, input);
  }

  method {:test} TestQueryOutputPassthrough() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionTransforms();
    var output := DDB.QueryOutput(
      Items := None(),
      Count := None(),
      ScannedCount := None(),
      LastEvaluatedKey := None(),
      ConsumedCapacity := None()
    );
    var tableName := GetTableName("no_such_table");
    var input := DDB.QueryInput(
      TableName := tableName,
      IndexName := None(),
      Select := None(),
      AttributesToGet := None(),
      Limit := None(),
      ConsistentRead := None(),
      KeyConditions := None(),
      QueryFilter := None(),
      ConditionalOperator := None(),
      ScanIndexForward := None(),
      ExclusiveStartKey := None(),
      ReturnConsumedCapacity := None(),
      ProjectionExpression := None(),
      FilterExpression := None(),
      KeyConditionExpression := None(),
      ExpressionAttributeNames := None(),
      ExpressionAttributeValues := None()
    );
    var transformed := middlewareUnderTest.QueryOutputTransform(
      AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.QueryOutputTransformInput(
        sdkOutput := output,
        originalInput := input
      )
    );

    expect_ok("QueryOutput", transformed);
    expect_equal("QueryOutput", transformed.value.transformedOutput, output);
  }
}
