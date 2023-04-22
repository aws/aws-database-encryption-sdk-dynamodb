// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../src/Index.dfy"
include "TestFixtures.dfy"

module ExecuteTransactionTransformTest {
  import opened Wrappers
  import opened DynamoDbEncryptionTransforms
  import opened TestFixtures
  import DDB = ComAmazonawsDynamodbTypes
  import AwsCryptographyDynamoDbEncryptionTransformsTypes


  method {:test} TestExecuteTransactionInputPassthrough() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryptionTransforms();
    var statement := GetStatement("update \"no_such_table\"");
    var pstatement := DDB.ParameterizedStatement (
      Statement := statement,
      Parameters := None()
    );
    var pstatements := GetPStatements([pstatement]);

    var good_input := DDB.ExecuteTransactionInput(
      TransactStatements := pstatements,
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
    var statement := GetStatement("update foo");
    var pstatement := DDB.ParameterizedStatement (
      Statement := statement,
      Parameters := None()
    );
    var pstatements := GetPStatements([pstatement]);
    var bad_input := DDB.ExecuteTransactionInput(
      TransactStatements :=  pstatements,
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
    var statement := GetStatement("foo");
    var pstatement := DDB.ParameterizedStatement (
      Statement := statement,
      Parameters := None()
    );
    var pstatements := GetPStatements([pstatement]);
    var input := DDB.ExecuteTransactionInput(
      TransactStatements := pstatements,
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
