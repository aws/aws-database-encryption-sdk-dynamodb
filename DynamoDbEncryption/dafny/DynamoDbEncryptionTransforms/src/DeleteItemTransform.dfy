// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "DynamoDbMiddlewareSupport.dfy"

module DeleteItemTransform {
  import opened DdbMiddlewareConfig
  import opened DynamoDbMiddlewareSupport
  import opened Wrappers
  import DDB = ComAmazonawsDynamodbTypes
  import opened AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes
  import EncTypes = AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes
  import Seq


  method Input(config: Config, input: DeleteItemInputTransformInput)
    returns (output: Result<DeleteItemInputTransformOutput, Error>)
    requires ValidConfig?(config)
    ensures ValidConfig?(config)
    modifies ModifiesConfig(config)

    ensures output.Success? && input.sdkInput.TableName in config.tableEncryptionConfigs ==>

      //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#validate-before-deleteitem
      //= type=implication
      //# The DeleteItem request MUST NOT refer to any legacy parameters,
      //# specifically Expected and ConditionalOperator MUST NOT be set.
      && NoMap(input.sdkInput.Expected)
      && input.sdkInput.ConditionalOperator.None?

      //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#validate-before-deleteitem
      //= type=implication
      //# The ConditionExpression MUST be [valid](ddb-support.md#testconditionexpression).
      && var tableConfig := config.tableEncryptionConfigs[input.sdkInput.TableName];
      && TestConditionExpression(tableConfig,
          input.sdkInput.ConditionExpression,
          input.sdkInput.ExpressionAttributeNames,
          input.sdkInput.ExpressionAttributeValues).Success?

      //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#validate-before-deleteitem
      //= type=implication
      //# If all of the above validation succeeds, the DeleteItem request MUST be unchanged.
      && output.value.transformedInput == input.sdkInput

    //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#validate-before-deleteitem
    //= type=implication
    //# If the `TableName` in the request does not refer to an [encrypted-table](#encrypted-table),
    //# the DeleteItem request MUST be unchanged.
    ensures input.sdkInput.TableName !in config.tableEncryptionConfigs ==>
      && output.Success?
      && output.value.transformedInput == input.sdkInput

  {
    if input.sdkInput.TableName in config.tableEncryptionConfigs {
      :- Need(NoMap(input.sdkInput.Expected), E("Legacy parameter 'Expected' not supported in UpdateItem with Encryption"));
      :- Need(input.sdkInput.ConditionalOperator.None?, E("Legacy parameter 'ConditionalOperator' not supported in UpdateItem with Encryption"));

      var tableConfig := config.tableEncryptionConfigs[input.sdkInput.TableName];
      var _ :- TestConditionExpression(tableConfig,
        input.sdkInput.ConditionExpression,
        input.sdkInput.ExpressionAttributeNames,
        input.sdkInput.ExpressionAttributeValues);
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
