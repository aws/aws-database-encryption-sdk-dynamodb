// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../src/Index.dfy"
include "TestFixtures.dfy"

module TransactGetItemsTransformTest {
  import opened Wrappers
  import opened DynamoDbEncryption
  import opened TestFixtures
  import DDB = ComAmazonawsDynamodbTypes
  import AwsCryptographyDynamoDbEncryptionTypes

  method {:test} TestTransactGetItemsInputPassthrough() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryption();
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
      AwsCryptographyDynamoDbEncryptionTypes.TransactGetItemsInputTransformInput(
        sdkInput := input
      )
    );

    expect_ok("TransactGetItemsInput", transformed);
    expect_equal("TransactGetItemsInput", transformed.value.transformedInput, input);
  }

  method {:test} TestTransactGetItemsOutputPassthrough() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryption();
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
      AwsCryptographyDynamoDbEncryptionTypes.TransactGetItemsOutputTransformInput(
        sdkOutput := output,
        originalInput := input
      )
    );

    expect_ok("TransactGetItemsOutput", transformed);
    expect_equal("TransactGetItemsOutput", transformed.value.transformedOutput, output);
  }
}
