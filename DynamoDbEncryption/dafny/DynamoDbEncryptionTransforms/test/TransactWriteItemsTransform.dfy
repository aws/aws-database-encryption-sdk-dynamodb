// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../src/Index.dfy"
include "TestFixtures.dfy"

module TransactWriteItemsTransformTest {
  import opened Wrappers
  import opened DynamoDbEncryptionTransforms
  import opened TestFixtures
  import DDB = ComAmazonawsDynamodbTypes
  import AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes

  method {:test} TestTransactWriteItemsInputPassthrough() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionTransforms();
    var tableName := GetTableName("bar");
    var thisAttr := GetAttrName("this");
    var item := DDB.TransactWriteItem(
      ConditionCheck := None(),
      Put := None(),
      Delete := Some(DDB.Delete(
                       Key := map[thisAttr := DDB.AttributeValue.S("that")],
                       TableName := tableName,
                       ConditionExpression := None,
                       ExpressionAttributeNames := None,
                       ExpressionAttributeValues := None,
                       ReturnValuesOnConditionCheckFailure := None)),
      Update := None()
    );
    var items := GetTransactWriteItemList([item]);
    var input := DDB.TransactWriteItemsInput(
      TransactItems := items,
      ReturnConsumedCapacity := None(),
      ReturnItemCollectionMetrics := None(),
      ClientRequestToken := None()
    );
    var transformed := middlewareUnderTest.TransactWriteItemsInputTransform(
      AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.TransactWriteItemsInputTransformInput(
        sdkInput := input
      )
    );

    expect_ok("TransactWriteItemsInput", transformed);
    expect_equal("TransactWriteItemsInput", transformed.value.transformedInput, input);
  }

  method {:test} TestTransactWriteItemsInputEmpty() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionTransforms();
    var item := DDB.TransactWriteItem(
      ConditionCheck := None,
      Put := None,
      Delete := None,
      Update := None
    );
    var items := GetTransactWriteItemList([item]);
    var input := DDB.TransactWriteItemsInput(
      TransactItems := items,
      ReturnConsumedCapacity := None(),
      ReturnItemCollectionMetrics := None(),
      ClientRequestToken := None()
    );
    var transformed := middlewareUnderTest.TransactWriteItemsInputTransform(
      AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.TransactWriteItemsInputTransformInput(
        sdkInput := input
      )
    );
    ExpectFailure(transformed, "Each item in TransactWriteItems must specify at least one supported operation");
  }

  method {:test} TestTransactWriteItemsOutputTransform() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionTransforms();
    var output := DDB.TransactWriteItemsOutput(
      ConsumedCapacity := None(),
      ItemCollectionMetrics := None()
    );
    var item := DDB.TransactWriteItem(
      ConditionCheck := None,
      Put := None,
      Delete := None,
      Update := None
    );
    var items := GetTransactWriteItemList([item]);
    var input := DDB.TransactWriteItemsInput(
      TransactItems := items,
      ReturnConsumedCapacity := None(),
      ReturnItemCollectionMetrics := None(),
      ClientRequestToken := None()
    );
    var transformed := middlewareUnderTest.TransactWriteItemsOutputTransform(
      AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.TransactWriteItemsOutputTransformInput(
        sdkOutput := output,
        originalInput := input
      )
    );

    expect_ok("TransactWriteItemsOutput", transformed);
    expect_equal("TransactWriteItemsOutput", transformed.value.transformedOutput, output);
  }
}
