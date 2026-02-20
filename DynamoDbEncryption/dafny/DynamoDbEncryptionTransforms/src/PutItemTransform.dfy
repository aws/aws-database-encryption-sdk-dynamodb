// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "DynamoDbMiddlewareSupport.dfy"

module PutItemTransform {
  import opened DdbMiddlewareConfig
  import opened DynamoDbMiddlewareSupport
  import opened Wrappers
  import DDB = ComAmazonawsDynamodbTypes
  import opened AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes
  import EncTypes = AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes
  import Seq
  import Util = DynamoDbEncryptionUtil

  method Input(config: Config, input: PutItemInputTransformInput)
    returns (output: Result<PutItemInputTransformOutput, Error>)
    requires ValidConfig?(config)
    ensures ValidConfig?(config)
    modifies ModifiesConfig(config)

    //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#encrypt-before-putitem
    //= type=implication
    //# If the `TableName` in the request does not refer to an [encrypted-table](#encrypted-table),
    //# the PutItem request MUST be unchanged.
    ensures output.Success? && input.sdkInput.TableName !in config.tableEncryptionConfigs ==>
              output.value.transformedInput == input.sdkInput

    ensures output.Success? && !IsPlainWrite(config, input.sdkInput.TableName) ==>
              && var tableConfig := config.tableEncryptionConfigs[input.sdkInput.TableName];
              //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#encrypt-before-putitem
              //= type=implication
              //# The PutItem request MUST NOT refer to any legacy parameters,
              //# specifically Expected and ConditionalOperator MUST NOT be set.
              && NoMap(input.sdkInput.Expected) && input.sdkInput.ConditionalOperator.None?

              //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#encrypt-before-putitem
              //= type=implication
              //# The ConditionExpression MUST be [valid](ddb-support.md#testconditionexpression).
              && TestConditionExpression(tableConfig,
                                         input.sdkInput.ConditionExpression,
                                         input.sdkInput.ExpressionAttributeNames,
                                         input.sdkInput.ExpressionAttributeValues).Success?

  {
    if IsPlainWrite(config, input.sdkInput.TableName) {
      return Success(PutItemInputTransformOutput(transformedInput := input.sdkInput));
    }
    var tableConfig := config.tableEncryptionConfigs[input.sdkInput.TableName];

    :- Need(NoMap(input.sdkInput.Expected), E("Legacy parameter 'Expected' not supported in PutItem with Encryption."));
    :- Need(input.sdkInput.ConditionalOperator.None?, E("Legacy parameter 'ConditionalOperator' not supported in PutItem with Encryption."));

    //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#encrypt-before-putitem
    //# The Item MUST be [writable](ddb-support.md#writable).
    var _ :- IsWriteable(tableConfig, input.sdkInput.Item);
    var _ :- TestConditionExpression(tableConfig,
                                     input.sdkInput.ConditionExpression,
                                     input.sdkInput.ExpressionAttributeNames,
                                     input.sdkInput.ExpressionAttributeValues);
    assume {:axiom} fresh(if tableConfig.search.Some? then tableConfig.search.value.curr().partitionSelector.Modifies else {});
    var partition :- GetRandomPartition(tableConfig, input.sdkInput.Item);
    var item :- AddSignedBeacons(tableConfig, input.sdkInput.Item, partition);
    var encryptRes := tableConfig.itemEncryptor.EncryptItem(
      EncTypes.EncryptItemInput(plaintextItem:=item)
    );
    var encrypted :- MapError(encryptRes);
    var keyId :- GetKeyIdFromHeader(tableConfig, encrypted);
    var beacons :- GetEncryptedBeacons(tableConfig, input.sdkInput.Item, Util.MaybeFromOptionKeyId(keyId), partition);
    return Success(PutItemInputTransformOutput(transformedInput := input.sdkInput.(Item := encrypted.encryptedItem + beacons)));
  }

  method Output(config: Config, input: PutItemOutputTransformInput)
    returns (output: Result<PutItemOutputTransformOutput, Error>)

    //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#decrypt-after-putitem
    //= type=implication
    //# After a [PutItem](https://docs.aws.amazon.com/amazondynamodb/latest/APIReference/API_PutItem.html)
    //# call is made to DynamoDB,
    //# the resulting response MUST be modified before
    //# being returned to the caller if:
    //  - there exists an Item Encryptor specified within the
    //    [DynamoDB Encryption Client Config](#dynamodb-encryption-client-configuration)
    //    with a [DynamoDB Table Name](./ddb-item-encryptor.md#dynamodb-table-name)
    //    equal to the `TableName` on the PutItem request.
    //  - the response contains [Attributes](https://docs.aws.amazon.com/amazondynamodb/latest/APIReference/API_PutItem.html#DDB-PutItem-response-Attributes).
    //    The response will contain Attributes if the related PutItem request's
    //    [ReturnValues](https://docs.aws.amazon.com/amazondynamodb/latest/APIReference/API_PutItem.html#DDB-PutItem-request-ReturnValues)
    //    had a value of `ALL_OLD` and the PutItem call replaced a pre-existing item.
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

              //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#decrypt-after-putitem
              //= type=implication
              //# In this case, the [Item Encryptor](./ddb-item-encryptor.md) MUST perform
              //# [Decrypt Item](./decrypt-item.md) where the input
              //# [DynamoDB Item](./decrypt-item.md#dynamodb-item)
              //# is the `Attributes` field in the original response
              && Seq.Last(newHistory).input.encryptedItem == input.sdkOutput.Attributes.value

              //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#decrypt-after-putitem
              //= type=implication
              //# Beacons MUST be [removed](ddb-support.md#removebeacons) from the result.
              && RemoveBeacons(tableConfig, Seq.Last(newHistory).output.value.plaintextItem).Success?
              && var item := RemoveBeacons(tableConfig, Seq.Last(newHistory).output.value.plaintextItem).value;

              //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#decrypt-after-putitem
              //= type=implication
              //# The PutItem response's `Attributes` field MUST be
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
      return Success(PutItemOutputTransformOutput(transformedOutput := input.sdkOutput));
    }
    var tableConfig := config.tableEncryptionConfigs[tableName];
    var decryptRes := tableConfig.itemEncryptor.DecryptItem(
      EncTypes.DecryptItemInput(encryptedItem:=input.sdkOutput.Attributes.value)
    );
    var decrypted :- MapError(decryptRes);
    var item :- RemoveBeacons(tableConfig, decrypted.plaintextItem);
    return Success(PutItemOutputTransformOutput(transformedOutput := input.sdkOutput.(Attributes := Some(item))));
  }
}
