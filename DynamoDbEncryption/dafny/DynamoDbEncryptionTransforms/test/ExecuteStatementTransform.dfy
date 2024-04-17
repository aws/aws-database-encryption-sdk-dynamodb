// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../src/Index.dfy"
include "TestFixtures.dfy"

module ExecuteStatementTransformTest {
  import opened Wrappers
  import opened DynamoDbEncryptionTransforms
  import opened TestFixtures
  import DDB = ComAmazonawsDynamodbTypes
  import AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes

  method {:test} TestExecuteStatementInputPassthrough() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionTransforms();
    var statement := GetStatement("update \"no_such_table\"");
    var good_input := DDB.ExecuteStatementInput(
      Statement := statement,
      Parameters := None(),
      ConsistentRead := None(),
      NextToken := None(),
      ReturnConsumedCapacity := None(),
      Limit := None()
    );
    var good_transformed := middlewareUnderTest.ExecuteStatementInputTransform(
      AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.ExecuteStatementInputTransformInput(
        sdkInput := good_input
      )
    );

    expect_ok("ExecuteStatement", good_transformed);
    expect_equal("ExecuteStatement", good_transformed.value.transformedInput, good_input);
  }

  method {:test} TestExecuteStatementInputEncrypted() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionTransforms();
    var statement := GetStatement("update \"foo\"");
    var bad_input := DDB.ExecuteStatementInput(
      Statement := statement,
      Parameters := None(),
      ConsistentRead := None(),
      NextToken := None(),
      ReturnConsumedCapacity := None(),
      Limit := None()
    );
    var bad_transformed := middlewareUnderTest.ExecuteStatementInputTransform(
      AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.ExecuteStatementInputTransformInput(
        sdkInput := bad_input
      )
    );

    expect bad_transformed.Failure?;
    expect bad_transformed.error.DynamoDbEncryptionTransformsException?;
    expect bad_transformed.error.message == "ExecuteStatement not Supported on encrypted tables.";
  }

  method {:test} TestExecuteStatementOutput() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionTransforms();
    var output := DDB.ExecuteStatementOutput(
      Items := None(),
      NextToken := None(),
      ConsumedCapacity := None(),
      LastEvaluatedKey := None()
    );
    var statement := GetStatement("foo");
    var input := DDB.ExecuteStatementInput(
      Statement := statement,
      Parameters := None(),
      ConsistentRead := None(),
      NextToken := None(),
      ReturnConsumedCapacity := None(),
      Limit := None()
    );
    var transformed := middlewareUnderTest.ExecuteStatementOutputTransform(
      AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.ExecuteStatementOutputTransformInput(
        sdkOutput := output,
        originalInput := input
      )
    );

    expect_ok("ExecuteStatement", transformed);
    expect_equal("ExecuteStatement", transformed.value.transformedOutput, output);
  }
}
