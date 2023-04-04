// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../../DynamoDbEncryptionTransforms/src/Index.dfy"
include "../../DynamoDbEncryption/test/TestFixtures.dfy"

module ExecuteTransactionTransformTest {
  import opened Wrappers
  import opened DynamoDbEncryptionTransforms
  import opened TestFixtures
  import DDB = ComAmazonawsDynamodbTypes
  import AwsCryptographyDynamoDbEncryptionTransformsTypes


  method {:test} TestExecuteTransactionInputPassthrough() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionTransforms();
    var good_input := DDB.ExecuteTransactionInput(
      TransactStatements :=  [
        DDB.ParameterizedStatement (
          Statement := "update \"no_such_table\"",
          Parameters := None()
        )
      ],
      ClientRequestToken := None(),
      ReturnConsumedCapacity := None()
    );
    var good_transformed := middlewareUnderTest.ExecuteTransactionInputTransform(
      AwsCryptographyDynamoDbEncryptionTransformsTypes.ExecuteTransactionInputTransformInput(
        sdkInput := good_input
      )
    );

    expect_ok("ExecuteTransaction", good_transformed);
    expect_equal("ExecuteTransaction", good_transformed.value.transformedInput, good_input);
  }

  method {:test} TestExecuteTransactionInput() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionTransforms();
    var bad_input := DDB.ExecuteTransactionInput(
      TransactStatements :=  [
        DDB.ParameterizedStatement (
          Statement := "update foo",
          Parameters := None()
        )
      ],
      ClientRequestToken := None(),
      ReturnConsumedCapacity := None()
    );
    var bad_transformed := middlewareUnderTest.ExecuteTransactionInputTransform(
      AwsCryptographyDynamoDbEncryptionTransformsTypes.ExecuteTransactionInputTransformInput(
        sdkInput := bad_input
      )
    );

    ExpectFailure(bad_transformed, "ExecuteTransaction not Supported on encrypted tables.");
  }

  method {:test} TestExecuteTransactionOutputTransform() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionTransforms();
    var output := DDB.ExecuteTransactionOutput(
      Responses := None(),
      ConsumedCapacity := None()
    );
    var input := DDB.ExecuteTransactionInput(
      TransactStatements :=  [
        DDB.ParameterizedStatement (
          Statement := "foo",
          Parameters := None()
        )
      ],
      ClientRequestToken := None(),
      ReturnConsumedCapacity := None()
    );
    var transformed := middlewareUnderTest.ExecuteTransactionOutputTransform(
      AwsCryptographyDynamoDbEncryptionTransformsTypes.ExecuteTransactionOutputTransformInput(
        sdkOutput := output,
        originalInput := input
      )
    );

    expect_ok("ExecuteTransactionOutput", transformed);
    expect_equal("ExecuteTransactionOutput", transformed.value.transformedOutput, output);
  }
}
