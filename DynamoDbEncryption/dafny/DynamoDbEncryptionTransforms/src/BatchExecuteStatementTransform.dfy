// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "DynamoDbMiddlewareSupport.dfy"
include "DdbStatement.dfy"

module BatchExecuteStatementTransform {
  import opened DdbMiddlewareConfig
  import opened Wrappers
  import DDB = ComAmazonawsDynamodbTypes
  import opened AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes
  import EncTypes = AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes
  import Seq
  import DdbStatement

  method Input(config: Config, input: BatchExecuteStatementInputTransformInput)
    returns (output: Result<BatchExecuteStatementInputTransformOutput, Error>)
    requires ValidConfig?(config)
    ensures ValidConfig?(config)
    modifies ModifiesConfig(config)

    //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#validate-before-batchexecutestatement
    //= type=implication
    //# The request MUST fail, and the client make no network call to DynamoDB,
    //# if there exists an Item Encryptor
    //# specified within the [DynamoDB Encryption Client Config](#dynamodb-encryption-client-configuration)
    //# with a [DynamoDB Table Name](./ddb-item-encryptor.md#dynamodb-table-name)
    //# equal to table named in any of the `Statements` of the request.
    /*
    ensures output.Success? ==>
      forall i : nat | 0 <= i < |input.sdkInput.Statements| ::
        var statement := DdbStatement.TableFromStatement(input.sdkInput.Statements[i].Statement);
        && statement.Success?
        && statement.value
          !in config.tableEncryptionConfigs
*/
    //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#validate-before-batchexecutestatement
    //= type=implication
    //# If no such Item Encryptor exists,
    //# there MUST NOT be any modification
    //# to the BatchExecuteStatement request.
    ensures output.Success? ==> output.value.transformedInput == input.sdkInput
  {
    for i := 0 to |input.sdkInput.Statements|
      /*
        invariant forall x : nat | 0 <= x < i ::
          var statement := DdbStatement.TableFromStatement(input.sdkInput.Statements[x].Statement);
          && statement.Success?
          && statement.value
            !in config.tableEncryptionConfigs;
            */
    {
      var statement := input.sdkInput.Statements[i].Statement;
      var tableName :- MapString(DdbStatement.TableFromStatement(statement));
      if tableName in config.tableEncryptionConfigs {
        return MakeError("BatchExecuteStatement not Supported on encrypted tables.");
      }
    }
    return Success(BatchExecuteStatementInputTransformOutput(transformedInput := input.sdkInput));
  }

  method Output(config: Config, input: BatchExecuteStatementOutputTransformInput)
    returns (output: Result<BatchExecuteStatementOutputTransformOutput, Error>)
    ensures output.Success? && output.value.transformedOutput == input.sdkOutput
  {
    return Success(BatchExecuteStatementOutputTransformOutput(transformedOutput := input.sdkOutput));
  }
}
