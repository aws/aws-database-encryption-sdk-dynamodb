// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "DynamoDbMiddlewareSupport.dfy"

module UpdateItemTransform {
  import opened DdbMiddlewareConfig
  import opened DynamoDbMiddlewareSupport
  import opened Wrappers
  import DDB = ComAmazonawsDynamodbTypes
  import opened AwsCryptographyDynamoDbEncryptionTransformsTypes
  import EncTypes = AwsCryptographyDynamoDbEncryptionItemEncryptorTypes
  import Seq

  method Input(config: Config, input: UpdateItemInputTransformInput)
    returns (output: Result<UpdateItemInputTransformOutput, Error>)
    requires ValidConfig?(config)
    ensures ValidConfig?(config)
    modifies ModifiesConfig(config)

    ensures output.Success? && input.sdkInput.TableName in config.tableEncryptionConfigs ==>
      //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#validate-before-updateitem
      //= type=implication
      //# The UpdateItem request MUST NOT refer to any legacy parameters,
      //# specifically Expected, AttributeUpdates and ConditionalOperator MUST NOT be set.
      && input.sdkInput.Expected.None?
      && input.sdkInput.AttributeUpdates.None?
      && input.sdkInput.ConditionalOperator.None?
      && var tableConfig := config.tableEncryptionConfigs[input.sdkInput.TableName];

      //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#validate-before-updateitem
      //= type=implication
      //# The UpdateExpression MUST be [valid](ddb-support.md#testupdateexpression).
      && TestUpdateExpression(tableConfig,
          input.sdkInput.UpdateExpression,
          input.sdkInput.ExpressionAttributeNames,
          input.sdkInput.ExpressionAttributeValues).Success?

      //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#validate-before-updateitem
      //= type=implication
      //# If all of the above validation succeeds, the UpdateItem request MUST be unchanged.
      && output.value.transformedInput == input.sdkInput

    //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#validate-before-updateitem
    //= type=implication
    //# If the `TableName` in the request does not refer to an [encrypted-table](#encrypted-table),
    //# the UpdateItem request MUST be unchanged.
    ensures input.sdkInput.TableName !in config.tableEncryptionConfigs ==>
      && output.Success?
      && output.value.transformedInput == input.sdkInput
  {
    if input.sdkInput.TableName in config.tableEncryptionConfigs {
      :- Need(input.sdkInput.Expected.None?, E("Legacy parameter 'Expected' not supported in UpdateItem with Encryption"));
      :- Need(input.sdkInput.AttributeUpdates.None?, E("Legacy parameter 'AttributeUpdates' not supported in UpdateItem with Encryption"));
      :- Need(input.sdkInput.ConditionalOperator.None?, E("Legacy parameter 'ConditionalOperator' not supported in UpdateItem with Encryption"));

      var tableConfig := config.tableEncryptionConfigs[input.sdkInput.TableName];
      var _ :- TestUpdateExpression(tableConfig,
        input.sdkInput.UpdateExpression,
        input.sdkInput.ExpressionAttributeNames,
        input.sdkInput.ExpressionAttributeValues);
    }
    return Success(UpdateItemInputTransformOutput(transformedInput := input.sdkInput));
  }

  method Output(config: Config, input: UpdateItemOutputTransformInput)
    returns (output: Result<UpdateItemOutputTransformOutput, Error>)
    ensures output.Success? && output.value.transformedOutput == input.sdkOutput
  {
    return Success(UpdateItemOutputTransformOutput(transformedOutput := input.sdkOutput));
  }
}
