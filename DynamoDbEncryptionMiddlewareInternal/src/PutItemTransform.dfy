// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "DdbMiddlewareConfig.dfy"

module PutItemTransform {
  import opened DdbMiddlewareConfig
  import opened Wrappers
  import DDB = ComAmazonawsDynamodbTypes
  import opened AwsCryptographyDynamoDbEncryptionTypes
  import EncTypes = AwsCryptographyDynamoDbItemEncryptorTypes
  import Seq

  method Input(config: Config, input: PutItemInputTransformInput)
    returns (output: Result<PutItemInputTransformOutput, Error>)
    requires ValidConfig?(config)
    ensures ValidConfig?(config)
    modifies ModifiesConfig(config)

    //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#encrypt-before-putitem
    //= type=implication
    //# If there exists an Item Encryptor specified within the
    //# [DynamoDB Encryption Client Config](#dynamodb-encryption-client-configuration)
    //# with a [DynamoDB Table Name](./ddb-item-encryptor.md#dynamodb-table-name)
    //# equal to `TableName` in the request,
    //# this PutItem request MUST NOT contain a `ConditionExpression`.

    //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#encrypt-before-putitem
    //= type=implication
    //# If the above validation fails,
    //# the client MUST NOT make a network call to DynamoDB,
    //# and PutItem MUST yield an error.
    ensures
      && input.sdkInput.TableName in config.tableEncryptionConfigs
      && (input.sdkInput.ConditionExpression.Some? || input.sdkInput.ConditionalOperator.Some?)
      ==> output.Failure?

    ensures output.Success? && input.sdkInput.TableName !in config.tableEncryptionConfigs ==>
            output.value.transformedInput == input.sdkInput

    //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#encrypt-before-putitem
    //= type=implication
    //# If the request is validated,
    //# it MUST be modified before a network call is made to DynamoDB
    //# if there exists an Item Encryptor specified within the
    //# [DynamoDB Encryption Client Config](#dynamodb-encryption-client-configuration)
    //# with a [DynamoDB Table Name](./ddb-item-encryptor.md#dynamodb-table-name)
    //# equal to `TableName` in the request.
    ensures output.Success? && input.sdkInput.TableName in config.tableEncryptionConfigs ==>
      var oldHistory := old(config.tableEncryptionConfigs[input.sdkInput.TableName].itemEncryptor.History.EncryptItem);
      var newHistory := config.tableEncryptionConfigs[input.sdkInput.TableName].itemEncryptor.History.EncryptItem;
      && |newHistory| == |oldHistory|+1
      && Seq.Last(newHistory).output.Success?

      //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#encrypt-before-putitem
      //= type=implication
      //# This [Item Encryptor](./ddb-item-encryptor.md) MUST perform
      //# [Encrypt Item](./encrypt-item.md),
      //# where the input [DynamoDB Item](./encrypt-item.md#dynamodb-item)
      //# is the `Item` field in the original request.
      && Seq.Last(newHistory).input.plaintextItem == input.sdkInput.Item

      //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#encrypt-before-putitem
      //= type=implication
      //# The PutItem request's `Item` field MUST be replaced
      //# with a value that is equivalent to
      //# the result [Encrypted DynamoDB Item](./encrypt-item.md#encrypted-dynamodb-item)
      //# calculated above.
      && Seq.Last(newHistory).output.value.encryptedItem == output.value.transformedInput.Item
  {
    if input.sdkInput.TableName !in config.tableEncryptionConfigs {
      return Success(PutItemInputTransformOutput(transformedInput := input.sdkInput));
    }
    if input.sdkInput.ConditionExpression.Some? || input.sdkInput.ConditionalOperator.Some? {
      return MakeError("Condition Expressions not supported in PutItem with Encryption.");
    }
    var tableConfig := config.tableEncryptionConfigs[input.sdkInput.TableName];
    var encryptRes := tableConfig.itemEncryptor.EncryptItem(
      EncTypes.EncryptItemInput(plaintextItem:=input.sdkInput.Item)
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