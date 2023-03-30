// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../../DynamoDbEncryptionTransforms/src/Index.dfy"
include "../../DynamoDbEncryption/test/TestFixtures.dfy"

module TransactGetItemsTransformTest {
  import opened Wrappers
  import opened DynamoDbEncryptionTransforms
  import opened TestFixtures
  import DDB = ComAmazonawsDynamodbTypes
  import AwsCryptographyDynamoDbEncryptionTransformsTypes

  method {:test} TestTransactGetItemsInputPassthrough() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionTransforms();
    var input := DDB.TransactGetItemsInput(
      TransactItems := [
        DDB.TransactGetItem(
          Get := DDB.Get(
            Key := map[],
            TableName := "no_such_table",
            ProjectionExpression := None(),
            ExpressionAttributeNames := None()
          )
        )
      ],
      ReturnConsumedCapacity := None()
    );
    var transformed := middlewareUnderTest.TransactGetItemsInputTransform(
      AwsCryptographyDynamoDbEncryptionTransformsTypes.TransactGetItemsInputTransformInput(
        sdkInput := input
      )
    );

    expect_ok("TransactGetItemsInput", transformed);
    expect_equal("TransactGetItemsInput", transformed.value.transformedInput, input);
  }

  method {:test} TestTransactGetItemsOutputPassthrough() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionTransforms();
    var output := DDB.TransactGetItemsOutput(
      ConsumedCapacity := None(),
      Responses := None()
    );
    var input := DDB.TransactGetItemsInput(
      TransactItems := [
        DDB.TransactGetItem(
          Get := DDB.Get(
            Key := map[],
            TableName := "no_such_table",
            ProjectionExpression := None(),
            ExpressionAttributeNames := None()
          )
        )
      ],
      ReturnConsumedCapacity := None()
    );
    var transformed := middlewareUnderTest.TransactGetItemsOutputTransform(
      AwsCryptographyDynamoDbEncryptionTransformsTypes.TransactGetItemsOutputTransformInput(
        sdkOutput := output,
        originalInput := input
      )
    );

    expect_ok("TransactGetItemsOutput", transformed);
    expect_equal("TransactGetItemsOutput", transformed.value.transformedOutput, output);
  }
}
