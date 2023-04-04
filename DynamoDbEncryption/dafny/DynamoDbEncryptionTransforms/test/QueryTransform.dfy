// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../../DynamoDbEncryptionTransforms/src/Index.dfy"
include "../../DynamoDbEncryption/test/TestFixtures.dfy"

module QueryTransformTest {
  import opened Wrappers
  import opened DynamoDbEncryptionTransforms
  import opened TestFixtures
  import DDB = ComAmazonawsDynamodbTypes
  import AwsCryptographyDynamoDbEncryptionTransformsTypes

  method {:test} TestQueryInputPassthrough() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionTransforms();
    var input := DDB.QueryInput(
      TableName := "no_such_table",
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
      AwsCryptographyDynamoDbEncryptionTransformsTypes.QueryInputTransformInput(
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
    var input := DDB.QueryInput(
      TableName := "no_such_table",
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
      AwsCryptographyDynamoDbEncryptionTransformsTypes.QueryOutputTransformInput(
        sdkOutput := output,
        originalInput := input
      )
    );

    expect_ok("QueryOutput", transformed);
    expect_equal("QueryOutput", transformed.value.transformedOutput, output);
  }
}
