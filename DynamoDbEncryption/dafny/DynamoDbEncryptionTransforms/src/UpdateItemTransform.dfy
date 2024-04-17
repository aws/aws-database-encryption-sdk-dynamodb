// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "DynamoDbMiddlewareSupport.dfy"

module UpdateItemTransform {
  import opened DdbMiddlewareConfig
  import opened DynamoDbMiddlewareSupport
  import opened Wrappers
  import DDB = ComAmazonawsDynamodbTypes
  import opened AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes
  import EncTypes = AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes
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
              && NoMap(input.sdkInput.Expected)
              && NoMap(input.sdkInput.AttributeUpdates)
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
      :- Need(NoMap(input.sdkInput.Expected), E("Legacy parameter 'Expected' not supported in UpdateItem with Encryption"));
      :- Need(NoMap(input.sdkInput.AttributeUpdates), E("Legacy parameter 'AttributeUpdates' not supported in UpdateItem with Encryption"));
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

    //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#decrypt-after-updateitem
    //= type=implication
    //# After a [UpdateItem](https://docs.aws.amazon.com/amazondynamodb/latest/APIReference/API_UpdateItem.html)
    //# call is made to DynamoDB,
    //# the resulting response MUST be modified before
    //# being returned to the caller if:
    //  - there exists an Item Encryptor specified within the
    //    [DynamoDB Encryption Client Config](#dynamodb-encryption-client-configuration)
    //    with a [DynamoDB Table Name](./ddb-item-encryptor.md#dynamodb-table-name)
    //    equal to the `TableName` on the UpdateItem request.
    //  - the response contains [Attributes](https://docs.aws.amazon.com/amazondynamodb/latest/APIReference/API_UpdateItem.html#DDB-UpdateItem-response-Attributes).
    //  - the original UpdateItem request had a
    //    [ReturnValues](https://docs.aws.amazon.com/amazondynamodb/latest/APIReference/API_UpdateItem.html#DDB-UpdateItem-request-ReturnValues)
    //    with a value of `ALL_OLD` or `ALL_NEW`.
    ensures (
              && output.Success?
              && input.originalInput.TableName in config.tableEncryptionConfigs
              && !NoMap(input.sdkOutput.Attributes)
              && input.originalInput.ReturnValues.Some?
              && (
                   || input.originalInput.ReturnValues.value.ALL_OLD?
                   || input.originalInput.ReturnValues.value.ALL_NEW?
                 )
            ) ==>
              && var tableConfig := config.tableEncryptionConfigs[input.originalInput.TableName];
              && var oldHistory := old(tableConfig.itemEncryptor.History.DecryptItem);
              && var newHistory := tableConfig.itemEncryptor.History.DecryptItem;

              && |newHistory| == |oldHistory|+1
              && Seq.Last(newHistory).output.Success?

              //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#decrypt-after-updateitem
              //= type=implication
              //# In this case, the [Item Encryptor](./ddb-item-encryptor.md) MUST perform
              //# [Decrypt Item](./decrypt-item.md) where the input
              //# [DynamoDB Item](./decrypt-item.md#dynamodb-item)
              //# is the `Attributes` field in the original response
              && Seq.Last(newHistory).input.encryptedItem == input.sdkOutput.Attributes.value

              //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#decrypt-after-updateitem
              //= type=implication
              //# Beacons MUST be [removed](ddb-support.md#removebeacons) from the result.
              && RemoveBeacons(tableConfig, Seq.Last(newHistory).output.value.plaintextItem).Success?
              && var item := RemoveBeacons(tableConfig, Seq.Last(newHistory).output.value.plaintextItem).value;

              //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#decrypt-after-updateitem
              //= type=implication
              //# The UpdateItem response's `Attributes` field MUST be
              //# replaced by the encrypted DynamoDb Item outputted above.
              && output.value.transformedOutput.Attributes.Some?
              && (item == output.value.transformedOutput.Attributes.value)

    //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#decrypt-after-updateitem
    //= type=implication
    //# In all other cases, the UpdateItem response MUST NOT be modified.
    ensures (
              && output.Success?
              && (
                   || input.originalInput.TableName !in config.tableEncryptionConfigs
                   || input.sdkOutput.Attributes.None?
                 )
            ) ==> (
                && output.value.transformedOutput == input.sdkOutput
              )

    ensures (
              && output.Success?
              && input.originalInput.TableName in config.tableEncryptionConfigs
              && input.sdkOutput.Attributes.Some?
              && (input.originalInput.ReturnValues.Some? ==> (
                      || input.originalInput.ReturnValues.value.UPDATED_NEW?
                      || input.originalInput.ReturnValues.value.UPDATED_OLD?
                    )
                 )
            ) ==> (
                && var tableConfig := config.tableEncryptionConfigs[input.originalInput.TableName];
                && output.value.transformedOutput == input.sdkOutput
                && forall k <- input.sdkOutput.Attributes.value.Keys :: !IsSigned(tableConfig, k)
              )

    //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#decrypt-after-updateitem
    //= type=implication
    //# Additionally, if a value of `UPDATED_OLD` or `UPDATED_NEW` was used,
    //# and any Attributes in the response are authenticated
    //# per the [DynamoDB Encryption Client Config](#dynamodb-encryption-client-configuration),
    //# an error MUST be raised.
    ensures (
              && input.originalInput.TableName in config.tableEncryptionConfigs
              && var tableConfig := config.tableEncryptionConfigs[input.originalInput.TableName];
              && input.sdkOutput.Attributes.Some?
              && (input.originalInput.ReturnValues.Some? ==> (
                      || input.originalInput.ReturnValues.value.UPDATED_NEW?
                      || input.originalInput.ReturnValues.value.UPDATED_OLD?
                    )
                 )
              && exists k <- input.sdkOutput.Attributes.value.Keys :: IsSigned(tableConfig, k)
            ) ==>
              output.Failure?

    requires ValidConfig?(config)
    ensures ValidConfig?(config)
    modifies ModifiesConfig(config)
  {
    var tableName := input.originalInput.TableName;

    if
      || tableName !in config.tableEncryptionConfigs
      || NoMap(input.sdkOutput.Attributes)
    {
      return Success(UpdateItemOutputTransformOutput(transformedOutput := input.sdkOutput));
    }

    var tableConfig := config.tableEncryptionConfigs[tableName];
    var attributes := input.sdkOutput.Attributes.value;

    if !(
        && input.originalInput.ReturnValues.Some?
        && (
             || input.originalInput.ReturnValues.value.ALL_NEW?
             || input.originalInput.ReturnValues.value.ALL_OLD?)
      )
    {
      // This error should not be possible to reach if we assume the DDB API contract is correct.
      // We include this runtime check for defensive purposes.
      :- Need(forall k <- attributes.Keys :: !IsSigned(tableConfig, k),
              E("UpdateItems response contains signed attributes, but does not include the entire item which is required for verification."));

      return Success(UpdateItemOutputTransformOutput(transformedOutput := input.sdkOutput));
    }

    var decryptRes := tableConfig.itemEncryptor.DecryptItem(
      EncTypes.DecryptItemInput(encryptedItem:=attributes)
    );
    var decrypted :- MapError(decryptRes);
    var item :- RemoveBeacons(tableConfig, decrypted.plaintextItem);
    return Success(UpdateItemOutputTransformOutput(transformedOutput := input.sdkOutput.(Attributes := Some(item))));
  }
}
