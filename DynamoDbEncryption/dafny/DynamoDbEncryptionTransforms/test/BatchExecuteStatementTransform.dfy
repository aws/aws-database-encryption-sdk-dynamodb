// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../src/Index.dfy"
include "TestFixtures.dfy"

module BatchExecuteStatementTransformTest {
  import opened Wrappers
  import opened DynamoDbEncryptionTransforms
  import opened TestFixtures
  import DDB = ComAmazonawsDynamodbTypes
  import AwsCryptographyDynamoDbEncryptionTransformsTypes

  method {:test} TestBatchExecuteStatementInputPassthrough() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionTransforms();
    var good_input := DDB.BatchExecuteStatementInput(
      Statements := [
        DDB.BatchStatementRequest(
          Statement := "update \"no_such_table\"",
          Parameters := None(),
          ConsistentRead := None()
        )
      ],
      ReturnConsumedCapacity := None()
    );
    var good_transformed := middlewareUnderTest.BatchExecuteStatementInputTransform(
      AwsCryptographyDynamoDbEncryptionTransformsTypes.BatchExecuteStatementInputTransformInput(
        sdkInput := good_input
      )
    );

    expect_ok("BatchExecuteStatement", good_transformed);
    expect_equal("BatchExecuteStatement", good_transformed.value.transformedInput, good_input);
  }

  method {:test} TestBatchExecuteStatementInputEncrypted() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionTransforms();
    var bad_input := DDB.BatchExecuteStatementInput(
      Statements := [
        DDB.BatchStatementRequest(
          Statement := "update \"foo\"",
          Parameters := None(),
          ConsistentRead := None()
        )
      ],
      ReturnConsumedCapacity := None()
    );
    var bad_transformed := middlewareUnderTest.BatchExecuteStatementInputTransform(
      AwsCryptographyDynamoDbEncryptionTransformsTypes.BatchExecuteStatementInputTransformInput(
        sdkInput := bad_input
      )
    );

    expect bad_transformed.Failure?;
    expect bad_transformed.error.DynamoDbEncryptionTransformsException?;
    expect bad_transformed.error.message == "BatchExecuteStatement not Supported on encrypted tables.";
  }

  method {:test} TestBatchExecuteStatementOutputTransform() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionTransforms();
    var output := DDB.BatchExecuteStatementOutput(
      Responses := None(),
      ConsumedCapacity := None()
    );
    var input := DDB.BatchExecuteStatementInput(
      Statements := [
        DDB.BatchStatementRequest(
          Statement := "foo",
          Parameters := None(),
          ConsistentRead := None()
        )
      ],
      ReturnConsumedCapacity := None()
    );
    var transformed := middlewareUnderTest.BatchExecuteStatementOutputTransform(
      AwsCryptographyDynamoDbEncryptionTransformsTypes.BatchExecuteStatementOutputTransformInput(
        sdkOutput := output,
        originalInput := input
      )
    );

    expect_ok("BatchExecuteStatement", transformed);
    expect_equal("BatchExecuteStatement", transformed.value.transformedOutput, output);
  }
}
