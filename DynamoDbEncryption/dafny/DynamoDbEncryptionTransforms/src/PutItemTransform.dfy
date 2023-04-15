// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "DynamoDbMiddlewareSupport.dfy"

module PutItemTransform {
  import opened DdbMiddlewareConfig
  import opened DynamoDbMiddlewareSupport
  import opened Wrappers
  import DDB = ComAmazonawsDynamodbTypes
  import opened AwsCryptographyDynamoDbEncryptionTransformsTypes
  import EncTypes = AwsCryptographyDynamoDbEncryptionItemEncryptorTypes
  import Seq

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

    ensures output.Success? && input.sdkInput.TableName in config.tableEncryptionConfigs ==>
      && var tableConfig := config.tableEncryptionConfigs[input.sdkInput.TableName];
      //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#encrypt-before-putitem
      //= type=implication
      //# The PutItem request MUST NOT refer to any legacy parameters,
      //# specifically Expected and ConditionalOperator MUST NOT be set.
      && input.sdkInput.Expected.None? && input.sdkInput.ConditionalOperator.None?

      // && var oldHistory := old(tableConfig.itemEncryptor.History.EncryptItem);
      // && var newHistory := tableConfig.itemEncryptor.History.EncryptItem;
      // && |newHistory| == |oldHistory|+1
      // && Seq.Last(newHistory).output.Success?
      // && var encryptInput := Seq.Last(newHistory).input;
      // && var encryptOutput := Seq.Last(newHistory).output.value;

      //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#encrypt-before-putitem
      //= type=implication
      //# The PutItem request's `Item` field MUST be replaced
      //# with a value that is equivalent to
      //# the result [Encrypted DynamoDB Item](./encrypt-item.md#encrypted-dynamodb-item)
      //# calculated above.
      //&& encryptOutput.encryptedItem == output.value.transformedInput.Item

      //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#encrypt-before-putitem
      //= type=implication
      //# The Item MUST be [writable](ddb-support.md#writable).
      && IsWriteable(tableConfig, input.sdkInput.Item).Success?

      //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#encrypt-before-putitem
      //= type=implication
      //# The ConditionExpression MUST be [valid](ddb-support.md#testconditionexpression).
      && TestConditionExpression(tableConfig,
          input.sdkInput.ConditionExpression,
          input.sdkInput.ExpressionAttributeNames,
          input.sdkInput.ExpressionAttributeValues).Success?

      //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#encrypt-before-putitem
      //= type=implication
      //# Beacons MUST be [added](ddb-support.md#addbeacons).
      // && AddBeacons(tableConfig, input.sdkInput.Item).Success?
      // && var item := AddBeacons(tableConfig, input.sdkInput.Item).value;

      //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#encrypt-before-putitem
      //= type=implication
      //# If the request is validated,
      //# the [Item Encryptor](./ddb-item-encryptor.md) MUST perform
      //# [Encrypt Item](./encrypt-item.md),
      //# where the input [DynamoDB Item](./encrypt-item.md#dynamodb-item)
      //# is output of the [add beacons](ddb-support.md#addbeacons) operation.
      // && encryptInput.plaintextItem == item
  {
    if input.sdkInput.TableName !in config.tableEncryptionConfigs {
      return Success(PutItemInputTransformOutput(transformedInput := input.sdkInput));
    }
    var tableConfig := config.tableEncryptionConfigs[input.sdkInput.TableName];

    if input.sdkInput.Expected.Some? {
      return MakeError("Legacy parameter 'Expected' not supported in PutItem with Encryption.");
    }
    if input.sdkInput.ConditionalOperator.Some? {
      return MakeError("Legacy parameter 'ConditionalOperator' not supported in PutItem with Encryption.");
    }
    var _ :- IsWriteable(tableConfig, input.sdkInput.Item);
    var _ :- TestConditionExpression(tableConfig,
      input.sdkInput.ConditionExpression,
      input.sdkInput.ExpressionAttributeNames,
      input.sdkInput.ExpressionAttributeValues);
    var item :- AddBeacons(tableConfig, input.sdkInput.Item);
    var encryptRes := tableConfig.itemEncryptor.EncryptItem(
      EncTypes.EncryptItemInput(plaintextItem:=item)
    );
    var encrypted :- MapError(encryptRes);
    return Success(PutItemInputTransformOutput(transformedInput := input.sdkInput.(Item := encrypted.encryptedItem)));
  }

  method Output(config: Config, input: PutItemOutputTransformInput)
    returns (output: Result<PutItemOutputTransformOutput, Error>)
    ensures output.Success? && output.value.transformedOutput == input.sdkOutput
  {
    return Success(PutItemOutputTransformOutput(transformedOutput := input.sdkOutput));
  }
}
