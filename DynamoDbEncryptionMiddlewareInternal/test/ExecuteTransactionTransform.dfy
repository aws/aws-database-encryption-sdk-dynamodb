// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../src/Index.dfy"
include "TestFixtures.dfy"

module ExecuteTransactionTransformTest {
  import opened Wrappers
  import opened DynamoDbEncryption
  import opened TestFixtures
  import DDB = ComAmazonawsDynamodbTypes
  import AwsCryptographyDynamoDbEncryptionTypes


  method {:test} TestExecuteTransactionInputPassthrough() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryption();
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
      AwsCryptographyDynamoDbEncryptionTypes.ExecuteTransactionInputTransformInput(
        sdkInput := good_input
      )
    );

    expect_ok("ExecuteTransaction", good_transformed);
    expect_equal("ExecuteTransaction", good_transformed.value.transformedInput, good_input);
  }

  method {:test} TestExecuteTransactionInput() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryption();
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
      AwsCryptographyDynamoDbEncryptionTypes.ExecuteTransactionInputTransformInput(
        sdkInput := bad_input
      )
    );

    ExpectFailure(bad_transformed, "ExecuteTransaction not Supported on encrypted tables.");
  }

  method {:test} TestExecuteTransactionOutputTransform() {
    var middlewareUnderTest := TestFixtures.GetDynamoDbEncryption();
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
      AwsCryptographyDynamoDbEncryptionTypes.ExecuteTransactionOutputTransformInput(
        sdkOutput := output,
        originalInput := input
      )
    );

    expect_ok("ExecuteTransactionOutput", transformed);
    expect_equal("ExecuteTransactionOutput", transformed.value.transformedOutput, output);
  }
}
