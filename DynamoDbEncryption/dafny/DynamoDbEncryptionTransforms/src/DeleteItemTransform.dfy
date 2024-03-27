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

    //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#decrypt-after-deleteitem
    //= type=implication
    //# After a [DeleteItem](https://docs.aws.amazon.com/amazondynamodb/latest/APIReference/API_DeleteItem.html)
    //# call is made to DynamoDB,
    //# the resulting response MUST be modified before
    //# being returned to the caller if:
    //  - there exists an Item Encryptor specified within the
    //    [DynamoDB Encryption Client Config](#dynamodb-encryption-client-configuration)
    //    with a [DynamoDB Table Name](./ddb-item-encryptor.md#dynamodb-table-name)
    //    equal to the `TableName` on the DeleteItem request.
    //  - the response contains [Attributes](https://docs.aws.amazon.com/amazondynamodb/latest/APIReference/API_DeleteItem.html#DDB-DeleteItem-response-Attributes).
    //    The response will contain Attributes if the related DeleteItem request's
    //    [ReturnValues](https://docs.aws.amazon.com/amazondynamodb/latest/APIReference/API_DeleteItem.html#DDB-DeleteItem-request-ReturnValues)
    //    had a value of `ALL_OLD` and an item was deleted.
    ensures (
              && output.Success?
              && input.originalInput.TableName in config.tableEncryptionConfigs
              && !NoMap(input.sdkOutput.Attributes)
            ) ==>
              && var tableConfig := config.tableEncryptionConfigs[input.originalInput.TableName];
              && var oldHistory := old(tableConfig.itemEncryptor.History.DecryptItem);
              && var newHistory := tableConfig.itemEncryptor.History.DecryptItem;

              && |newHistory| == |oldHistory|+1
              && Seq.Last(newHistory).output.Success?

              //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#decrypt-after-deleteitem
              //= type=implication
              //# In this case, the [Item Encryptor](./ddb-item-encryptor.md) MUST perform
              //# [Decrypt Item](./decrypt-item.md) where the input
              //# [DynamoDB Item](./decrypt-item.md#dynamodb-item)
              //# is the `Attributes` field in the original response
              && Seq.Last(newHistory).input.encryptedItem == input.sdkOutput.Attributes.value

              //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#decrypt-after-deleteitem
              //= type=implication
              //# Beacons MUST be [removed](ddb-support.md#removebeacons) from the result.
              && RemoveBeacons(tableConfig, Seq.Last(newHistory).output.value.plaintextItem).Success?
              && var item := RemoveBeacons(tableConfig, Seq.Last(newHistory).output.value.plaintextItem).value;

              //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#decrypt-after-deleteitem
              //= type=implication
              //# The DeleteItem response's `Attributes` field MUST be
              //# replaced by the encrypted DynamoDb Item outputted above.
              && output.value.transformedOutput.Attributes.Some?
              && (item == output.value.transformedOutput.Attributes.value)

    // Passthrough the response if the above specification is not met
    ensures (
              && output.Success?
              && (
                   || input.originalInput.TableName !in config.tableEncryptionConfigs
                   || input.sdkOutput.Attributes.None?
                 )
            ) ==>
              output.value.transformedOutput == input.sdkOutput

    requires ValidConfig?(config)
    ensures ValidConfig?(config)
    modifies ModifiesConfig(config)
  {
    var tableName := input.originalInput.TableName;
    if tableName !in config.tableEncryptionConfigs || NoMap(input.sdkOutput.Attributes)
    {
      return Success(DeleteItemOutputTransformOutput(transformedOutput := input.sdkOutput));
    }
    var tableConfig := config.tableEncryptionConfigs[tableName];
    var decryptRes := tableConfig.itemEncryptor.DecryptItem(
      EncTypes.DecryptItemInput(encryptedItem:=input.sdkOutput.Attributes.value)
    );
    var decrypted :- MapError(decryptRes);
    var item :- RemoveBeacons(tableConfig, decrypted.plaintextItem);
    return Success(DeleteItemOutputTransformOutput(transformedOutput := input.sdkOutput.(Attributes := Some(item))));
  }
}
