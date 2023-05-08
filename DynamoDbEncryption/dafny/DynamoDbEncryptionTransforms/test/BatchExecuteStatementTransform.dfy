// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../src/Index.dfy"
include "TestFixtures.dfy"

module BatchExecuteStatementTransformTest {
  import opened Wrappers
  import opened DynamoDbEncryptionTransforms
  import opened TestFixtures
  import DDB = ComAmazonawsDynamodbTypes
  import AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes

  method {:test} TestBatchExecuteStatementInputPassthrough() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionTransforms();
    var statement := GetStatement("update \"no_such_table\"");
    var request := DDB.BatchStatementRequest(
      Statement := statement,
      Parameters := None,
      ConsistentRead := None
    );
    var requests := GetPartiQLBatchRequest([request]);
    var good_input := DDB.BatchExecuteStatementInput(
      Statements := requests,
      ReturnConsumedCapacity := None
    );
    var good_transformed := middlewareUnderTest.BatchExecuteStatementInputTransform(
      AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.BatchExecuteStatementInputTransformInput(
        sdkInput := good_input
      )
    );

    expect_ok("BatchExecuteStatement", good_transformed);
    expect_equal("BatchExecuteStatement", good_transformed.value.transformedInput, good_input);
  }

  method {:test} TestBatchExecuteStatementInputEncrypted() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionTransforms();
    var statement := GetStatement("update \"foo\"");
    var request := DDB.BatchStatementRequest(
      Statement := statement,
      Parameters := None,
      ConsistentRead := None
    );
    var requests := GetPartiQLBatchRequest([request]);
    var bad_input := DDB.BatchExecuteStatementInput(
      Statements := requests,
      ReturnConsumedCapacity := None
    );
    var bad_transformed := middlewareUnderTest.BatchExecuteStatementInputTransform(
      AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.BatchExecuteStatementInputTransformInput(
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
      Responses := None,
      ConsumedCapacity := None
    );
    var statement := GetStatement("foo");
    var request := DDB.BatchStatementRequest(
      Statement := statement,
      Parameters := None,
      ConsistentRead := None
    );
    var requests := GetPartiQLBatchRequest([request]);
    var input := DDB.BatchExecuteStatementInput(
      Statements := requests,
      ReturnConsumedCapacity := None
    );
    var transformed := middlewareUnderTest.BatchExecuteStatementOutputTransform(
      AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.BatchExecuteStatementOutputTransformInput(
        sdkOutput := output,
        originalInput := input
      )
    );

    expect_ok("BatchExecuteStatement", transformed);
    expect_equal("BatchExecuteStatement", transformed.value.transformedOutput, output);
  }
}
