// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../src/Index.dfy"
include "TestFixtures.dfy"

module UpdateItemTransformTest {
  import opened Wrappers
  import opened DynamoDbEncryption
  import opened TestFixtures
  import DDB = ComAmazonawsDynamodbTypes
  import AwsCryptographyDynamoDbEncryptionTypes

  method {:test} TestUpdateItemInputPassthrough() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryption();
    var input := DDB.UpdateItemInput(
      TableName := "no_such_table",
      Key := map[],
      AttributeUpdates := None(),
      Expected := None(),
      ConditionalOperator := None(),
      ReturnValues := None(),
      ReturnConsumedCapacity := None(),
      ReturnItemCollectionMetrics := None(),
      UpdateExpression := None(),
      ConditionExpression := None(),
      ExpressionAttributeNames := None(),
      ExpressionAttributeValues := None()
    );
    var transformed := middlewareUnderTest.UpdateItemInputTransform(
      AwsCryptographyDynamoDbEncryptionTypes.UpdateItemInputTransformInput(
        sdkInput := input
      )
    );

    expect_ok("UpdateItemInput", transformed);
    expect_equal("UpdateItemInput", transformed.value.transformedInput, input);
  }

    method {:test} TestUpdateItemInputUpdateExpression() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryption();
    var input := DDB.UpdateItemInput(
      TableName := "foo",
      Key := map[],
      AttributeUpdates := None(),
      Expected := None(),
      ConditionalOperator := None(),
      ReturnValues := None(),
      ReturnConsumedCapacity := None(),
      ReturnItemCollectionMetrics := None(),
      UpdateExpression := Some("foo"),
      ConditionExpression := None(),
      ExpressionAttributeNames := None(),
      ExpressionAttributeValues := None()
    );
    var transformed := middlewareUnderTest.UpdateItemInputTransform(
      AwsCryptographyDynamoDbEncryptionTypes.UpdateItemInputTransformInput(
        sdkInput := input
      )
    );

    ExpectFailure(transformed, "Update Expressions forbidden on encrypted tables");
  }

  method {:test} TestUpdateItemOutputPassthrough() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryption();
    var output := DDB.UpdateItemOutput(
      Attributes := None(),
      ConsumedCapacity := None(),
      ItemCollectionMetrics := None()
    );
    var input := DDB.UpdateItemInput(
      TableName := "no_such_table",
      Key := map[],
      AttributeUpdates := None(),
      Expected := None(),
      ConditionalOperator := None(),
      ReturnValues := None(),
      ReturnConsumedCapacity := None(),
      ReturnItemCollectionMetrics := None(),
      UpdateExpression := None(),
      ConditionExpression := None(),
      ExpressionAttributeNames := None(),
      ExpressionAttributeValues := None()
    );
    var transformed := middlewareUnderTest.UpdateItemOutputTransform(
      AwsCryptographyDynamoDbEncryptionTypes.UpdateItemOutputTransformInput(
        sdkOutput := output,
        originalInput := input
      )
    );

    expect_ok("UpdateItemOutput", transformed);
    expect_equal("UpdateItemOutput", transformed.value.transformedOutput, output);
  }
}
