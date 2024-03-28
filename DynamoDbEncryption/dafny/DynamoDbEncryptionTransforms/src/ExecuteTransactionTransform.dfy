// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "DynamoDbMiddlewareSupport.dfy"
include "DdbStatement.dfy"

module ExecuteTransactionTransform {
  import opened DdbMiddlewareConfig
  import opened DynamoDbMiddlewareSupport
  import opened Wrappers
  import DDB = ComAmazonawsDynamodbTypes
  import opened AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes
  import EncTypes = AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes
  import Seq
  import DdbStatement

  method Input(config: Config, input: ExecuteTransactionInputTransformInput)
    returns (output: Result<ExecuteTransactionInputTransformOutput, Error>)
    requires ValidConfig?(config)
    ensures ValidConfig?(config)
    modifies ModifiesConfig(config)

    //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#validate-before-executetransaction
    //= type=implication
    //# The request MUST fail, and the client make no network call to DynamoDB,
    //# if there exists an Item Encryptor
    //# specified within the [DynamoDB Encryption Client Config](#dynamodb-encryption-client-configuration)
    //# with a [DynamoDB Table Name](./ddb-item-encryptor.md#dynamodb-table-name)
    //# equal to table named in any of the `TransactStatements` of the request.
    ensures output.Success? ==>
              forall i : nat | 0 <= i < |input.sdkInput.TransactStatements| ::
                var statement := DdbStatement.TableFromStatement(input.sdkInput.TransactStatements[i].Statement);
                statement.Success? && statement.value !in config.tableEncryptionConfigs

    //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#validate-before-executetransaction
    //= type=implication
    //# If no such Item Encryptor exists,
    //# there MUST NOT be any modification
    //# to the ExecuteTransaction request.
    ensures output.Success? ==> output.value.transformedInput == input.sdkInput
  {
    for i := 0 to |input.sdkInput.TransactStatements|
      invariant forall x : nat | 0 <= x < i ::
          var tableName := DdbStatement.TableFromStatement(input.sdkInput.TransactStatements[x].Statement);
          tableName.Success? && tableName.value !in config.tableEncryptionConfigs
    {
      var statement := input.sdkInput.TransactStatements[i].Statement;
      var tableName := DdbStatement.TableFromStatement(statement);
      if tableName.Failure? {
        return Failure(Error.DynamoDbEncryptionTransformsException(message := tableName.error));
      }
      if tableName.value in config.tableEncryptionConfigs {
        return MakeError("ExecuteTransaction not Supported on encrypted tables.");
      }
    }
    return Success(ExecuteTransactionInputTransformOutput(transformedInput := input.sdkInput));
  }

  method Output(config: Config, input: ExecuteTransactionOutputTransformInput)
    returns (output: Result<ExecuteTransactionOutputTransformOutput, Error>)
    ensures output.Success? && output.value.transformedOutput == input.sdkOutput
  {
    return Success(ExecuteTransactionOutputTransformOutput(transformedOutput := input.sdkOutput));
  }
}
