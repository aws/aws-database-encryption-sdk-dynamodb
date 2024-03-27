// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "DynamoDbMiddlewareSupport.dfy"
include "DdbStatement.dfy"

module ExecuteStatementTransform {
  import opened DdbMiddlewareConfig
  import opened DynamoDbMiddlewareSupport
  import opened Wrappers
  import DDB = ComAmazonawsDynamodbTypes
  import opened AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes
  import EncTypes = AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes
  import Seq
  import DdbStatement

  method Input(config: Config, input: ExecuteStatementInputTransformInput)
    returns (output: Result<ExecuteStatementInputTransformOutput, Error>)
    requires ValidConfig?(config)
    ensures ValidConfig?(config)
    modifies ModifiesConfig(config)

    //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#validate-before-executestatement
    //= type=implication
    //# The request MUST fail, and the client make no network call to DynamoDB,
    //# if there exists an Item Encryptor
    //# specified within the [DynamoDB Encryption Client Config](#dynamodb-encryption-client-configuration)
    //# with a [DynamoDB Table Name](./ddb-item-encryptor.md#dynamodb-table-name)
    //# equal to table named in the request.
    ensures var statement := DdbStatement.TableFromStatement(input.sdkInput.Statement);
            statement.Failure? || statement.value in config.tableEncryptionConfigs ==> output.Failure?

    //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#validate-before-executestatement
    //= type=implication
    //# If no such Item Encryptor exists,
    //# there MUST NOT be any modification
    //# to the ExecuteStatement request.
    ensures var statement :=  DdbStatement.TableFromStatement(input.sdkInput.Statement);
            (statement.Success? && statement.value !in config.tableEncryptionConfigs)
            ==> (output.Success? && output.value.transformedInput == input.sdkInput)
  {
    var tableName :- MapString(DdbStatement.TableFromStatement(input.sdkInput.Statement));
    if tableName in config.tableEncryptionConfigs {
      return MakeError("ExecuteStatement not Supported on encrypted tables.");
    } else {
      return Success(ExecuteStatementInputTransformOutput(transformedInput := input.sdkInput));
    }
  }

  method Output(config: Config, input: ExecuteStatementOutputTransformInput)
    returns (output: Result<ExecuteStatementOutputTransformOutput, Error>)
    ensures output.Success? && output.value.transformedOutput == input.sdkOutput
  {
    return Success(ExecuteStatementOutputTransformOutput(transformedOutput := input.sdkOutput));
  }
}
