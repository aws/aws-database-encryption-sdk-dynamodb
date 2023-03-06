// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../src/Index.dfy"
include "TestFixtures.dfy"

module ExecuteStatementTransformTest {
  import opened Wrappers
  import opened DynamoDbEncryption
  import opened TestFixtures
  import DDB = ComAmazonawsDynamodbTypes
  import AwsCryptographyDynamoDbEncryptionTypes

  method {:test} TestExecuteStatementInputPassthrough() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryption();
    var good_input := DDB.ExecuteStatementInput(
      Statement := "update \"no_such_table\"",
      Parameters := None(),
      ConsistentRead := None(),
      NextToken := None(),
      ReturnConsumedCapacity := None(),
      Limit := None()
    );
    var good_transformed := middlewareUnderTest.ExecuteStatementInputTransform(
      AwsCryptographyDynamoDbEncryptionTypes.ExecuteStatementInputTransformInput(
        sdkInput := good_input
      )
    );

    expect_ok("ExecuteStatement", good_transformed);
    expect_equal("ExecuteStatement", good_transformed.value.transformedInput, good_input);
  }

  method {:test} TestExecuteStatementInputEncrypted() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryption();
    var bad_input := DDB.ExecuteStatementInput(
      Statement := "update \"foo\"",
      Parameters := None(),
      ConsistentRead := None(),
      NextToken := None(),
      ReturnConsumedCapacity := None(),
      Limit := None()
    );
    var bad_transformed := middlewareUnderTest.ExecuteStatementInputTransform(
      AwsCryptographyDynamoDbEncryptionTypes.ExecuteStatementInputTransformInput(
        sdkInput := bad_input
      )
    );

    expect bad_transformed.Failure?;
    expect bad_transformed.error.DynamoDbEncryptionException?;
    expect bad_transformed.error.message == "ExecuteStatement not Supported on encrypted tables.";
  }

  method {:test} TestExecuteStatementOutput() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryption();
    var output := DDB.ExecuteStatementOutput(
      Items := None(),
      NextToken := None(),
      ConsumedCapacity := None(),
      LastEvaluatedKey := None()
    );
    var input := DDB.ExecuteStatementInput(
      Statement := "foo",
      Parameters := None(),
      ConsistentRead := None(),
      NextToken := None(),
      ReturnConsumedCapacity := None(),
      Limit := None()
    );
    var transformed := middlewareUnderTest.ExecuteStatementOutputTransform(
      AwsCryptographyDynamoDbEncryptionTypes.ExecuteStatementOutputTransformInput(
        sdkOutput := output,
        originalInput := input
      )
    );

    expect_ok("ExecuteStatement", transformed);
    expect_equal("ExecuteStatement", transformed.value.transformedOutput, output);
  }
}
