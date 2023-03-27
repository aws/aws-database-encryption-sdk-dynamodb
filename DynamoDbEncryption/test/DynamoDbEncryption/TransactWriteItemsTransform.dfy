// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../../src/DynamoDbEncryption/Index.dfy"
include "../TestFixtures.dfy"

module TransactWriteItemsTransformTest {
  import opened Wrappers
  import opened DynamoDbEncryption
  import opened TestFixtures
  import DDB = ComAmazonawsDynamodbTypes
  import AwsCryptographyDynamoDbEncryptionTypes

  method {:test} TestTransactWriteItemsInputPassthrough() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryption();
    var input := DDB.TransactWriteItemsInput(
      TransactItems := [
        DDB.TransactWriteItem(
          ConditionCheck := None(),
          Put := None(),
          Delete := Some(DDB.Delete(
            Key := map["this" := DDB.AttributeValue.S("that")],
            TableName := "bar",
            ConditionExpression := None,
            ExpressionAttributeNames := None,
            ExpressionAttributeValues := None,
            ReturnValuesOnConditionCheckFailure := None)),
          Update := None()
        )
      ],
      ReturnConsumedCapacity := None(),
      ReturnItemCollectionMetrics := None(),
      ClientRequestToken := None()
    );
    var transformed := middlewareUnderTest.TransactWriteItemsInputTransform(
      AwsCryptographyDynamoDbEncryptionTypes.TransactWriteItemsInputTransformInput(
        sdkInput := input
      )
    );

    expect_ok("TransactWriteItemsInput", transformed);
    expect_equal("TransactWriteItemsInput", transformed.value.transformedInput, input);
  }

  method {:test} TestTransactWriteItemsInputEmpty() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryption();
    var input := DDB.TransactWriteItemsInput(
      TransactItems := [
        DDB.TransactWriteItem(
          ConditionCheck := None,
          Put := None,
          Delete := None,
          Update := None
        )
      ],
      ReturnConsumedCapacity := None(),
      ReturnItemCollectionMetrics := None(),
      ClientRequestToken := None()
    );
    var transformed := middlewareUnderTest.TransactWriteItemsInputTransform(
      AwsCryptographyDynamoDbEncryptionTypes.TransactWriteItemsInputTransformInput(
        sdkInput := input
      )
    );
    ExpectFailure(transformed, "Each item in TransactWriteItems must specify at least one supported operation");
  }

  method {:test} TestTransactWriteItemsOutputTransform() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryption();
    var output := DDB.TransactWriteItemsOutput(
      ConsumedCapacity := None(),
      ItemCollectionMetrics := None()
    );
    var input := DDB.TransactWriteItemsInput(
      TransactItems := [
        DDB.TransactWriteItem(
          ConditionCheck := None(),
          Put := None(),
          Delete := None(),
          Update := None()
        )
      ],
      ReturnConsumedCapacity := None(),
      ReturnItemCollectionMetrics := None(),
      ClientRequestToken := None()
    );
    var transformed := middlewareUnderTest.TransactWriteItemsOutputTransform(
      AwsCryptographyDynamoDbEncryptionTypes.TransactWriteItemsOutputTransformInput(
        sdkOutput := output,
        originalInput := input
      )
    );

    expect_ok("TransactWriteItemsOutput", transformed);
    expect_equal("TransactWriteItemsOutput", transformed.value.transformedOutput, output);
  }
}
