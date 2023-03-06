// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "DdbMiddlewareConfig.dfy"

module DeleteItemTransform {
  import opened DdbMiddlewareConfig
  import opened Wrappers
  import DDB = ComAmazonawsDynamodbTypes
  import opened AwsCryptographyDynamoDbEncryptionTypes
  import EncTypes = AwsCryptographyDynamoDbItemEncryptorTypes
  import Seq


  method Input(config: Config, input: DeleteItemInputTransformInput)
    returns (output: Result<DeleteItemInputTransformOutput, Error>)
    requires ValidConfig?(config)
    ensures ValidConfig?(config)
    modifies ModifiesConfig(config)

    //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#validate-before-deleteitem
      //= type=implication
      //# Before a [DeleteItem](https://docs.aws.amazon.com/amazondynamodb/latest/APIReference/API_DeleteItem.html)
      //# call is made to DynamoDB,
      //# the request MUST fail, and the client make no network call to DynamoDB,
      //# if the request specifies a `ConditionExpression`,
      //# and there exists an Item Encryptor specified
      //# within the [DynamoDB Encryption Client Config](#dynamodb-encryption-client-configuration)
      //# with a [DynamoDB Table Name](./ddb-item-encryptor.md#dynamodb-table-name)
      //# equal to `TableName` in the request.
      ensures
        && input.sdkInput.TableName in config.tableEncryptionConfigs
        && (input.sdkInput.ConditionExpression.Some? || input.sdkInput.ConditionalOperator.Some?)
        ==> output.Failure?

      //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#validate-before-deleteitem
      //= type=implication
      //# Otherwise, there MUST NOT be any modification
      //# to the UpdateItem request.
      ensures
        || input.sdkInput.TableName !in config.tableEncryptionConfigs
        || (input.sdkInput.ConditionExpression.None? && input.sdkInput.ConditionalOperator.None?)
        ==>
        && output.Success?
        && output.value.transformedInput == input.sdkInput

  {
    if input.sdkInput.TableName !in config.tableEncryptionConfigs {
      return Success(DeleteItemInputTransformOutput(transformedInput := input.sdkInput));
    }
    if input.sdkInput.ConditionExpression.Some? || input.sdkInput.ConditionalOperator.Some? {
      return MakeError("Condition Expressions not supported in DeleteItem with Encryption.");
    }
    return Success(DeleteItemInputTransformOutput(transformedInput := input.sdkInput));
  }

  method Output(config: Config, input: DeleteItemOutputTransformInput)
    returns (output: Result<DeleteItemOutputTransformOutput, Error>)
    ensures output.Success? && output.value.transformedOutput == input.sdkOutput
  {
    return Success(DeleteItemOutputTransformOutput(transformedOutput := input.sdkOutput));
  }
}
