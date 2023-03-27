// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../../src/DynamoDbEncryption/Index.dfy"
include "../TestFixtures.dfy"

module PutItemTransformTest {
  import opened Wrappers
  import opened DynamoDbEncryption
  import opened TestFixtures
  import DDB = ComAmazonawsDynamodbTypes
  import AwsCryptographyDynamoDbEncryptionTypes

  method {:test} TestPutItemInputPassthrough() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryption();
    var input := DDB.PutItemInput(
      TableName := "no_such_table",
      Item := map[],
      Expected := None(),
      ReturnValues := None(),
      ReturnConsumedCapacity := None(),
      ReturnItemCollectionMetrics := None(),
      ConditionalOperator := None(),
      ConditionExpression := None(),
      ExpressionAttributeNames := None(),
      ExpressionAttributeValues := None()
    );
    var transformed := middlewareUnderTest.PutItemInputTransform(
      AwsCryptographyDynamoDbEncryptionTypes.PutItemInputTransformInput(
        sdkInput := input
      )
    );

    expect_ok("PutItemInput", transformed);
    expect_equal("PutItemInput", transformed.value.transformedInput, input);
  }

  method {:test} TestPutItemOutputPassthrough() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryption();
    var output := DDB.PutItemOutput(
      Attributes := None(),
      ConsumedCapacity := None(),
      ItemCollectionMetrics := None()
    );
    var input := DDB.PutItemInput(
      TableName := "no_such_table",
      Item := map[],
      Expected := None(),
      ReturnValues := None(),
      ReturnConsumedCapacity := None(),
      ReturnItemCollectionMetrics := None(),
      ConditionalOperator := None(),
      ConditionExpression := None(),
      ExpressionAttributeNames := None(),
      ExpressionAttributeValues := None()
    );
    var transformed := middlewareUnderTest.PutItemOutputTransform(
      AwsCryptographyDynamoDbEncryptionTypes.PutItemOutputTransformInput(
        sdkOutput := output,
        originalInput := input
      )
    );

    expect_ok("PutItemOutput", transformed);
    expect_equal("PutItemOutput", transformed.value.transformedOutput, output);
  }
}
