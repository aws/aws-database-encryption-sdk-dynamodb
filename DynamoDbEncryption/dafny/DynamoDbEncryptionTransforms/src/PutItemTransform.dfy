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

    ensures output.Success? && input.sdkInput.TableName in config.tableEncryptionConfigs ==>
      && var tableConfig := config.tableEncryptionConfigs[input.sdkInput.TableName];
      //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#encrypt-before-putitem
      //= type=implication
      //# The PutItem request MUST NOT refer to any legacy parameters,
      //# specifically Expected and ConditionalOperator MUST NOT be set.
      && NoMap(input.sdkInput.Expected) && input.sdkInput.ConditionalOperator.None?

      // && var oldHistory := old(tableConfig.itemEncryptor.History.EncryptItem);
      // && var newHistory := tableConfig.itemEncryptor.History.EncryptItem;
      // && |newHistory| == |oldHistory|+1
      // && Seq.Last(newHistory).output.Success?
      // && var encryptInput := Seq.Last(newHistory).input;
      // && var encryptOutput := Seq.Last(newHistory).output.value;

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

  {
    if input.sdkInput.TableName !in config.tableEncryptionConfigs {
      return Success(PutItemInputTransformOutput(transformedInput := input.sdkInput));
    }
    var tableConfig := config.tableEncryptionConfigs[input.sdkInput.TableName];

    :- Need(NoMap(input.sdkInput.Expected), E("Legacy parameter 'Expected' not supported in PutItem with Encryption."));
    :- Need(input.sdkInput.ConditionalOperator.None?, E("Legacy parameter 'ConditionalOperator' not supported in PutItem with Encryption."));

    var _ :- IsWriteable(tableConfig, input.sdkInput.Item);
    var _ :- TestConditionExpression(tableConfig,
      input.sdkInput.ConditionExpression,
      input.sdkInput.ExpressionAttributeNames,
      input.sdkInput.ExpressionAttributeValues);
    var item :- AddSignedBeacons(tableConfig, input.sdkInput.Item);
    var encryptRes := tableConfig.itemEncryptor.EncryptItem(
      EncTypes.EncryptItemInput(plaintextItem:=item)
    );
    var encrypted :- MapError(encryptRes);
    var keyId :- GetKeyIdFromHeader(tableConfig, encrypted);
    var beacons :- GetEncryptedBeacons(tableConfig, input.sdkInput.Item, Util.MaybeFromOptionKeyId(keyId));
    return Success(PutItemInputTransformOutput(transformedInput := input.sdkInput.(Item := encrypted.encryptedItem + beacons)));
  }

  method Output(config: Config, input: PutItemOutputTransformInput)
    returns (output: Result<PutItemOutputTransformOutput, Error>)
    ensures output.Success? && output.value.transformedOutput == input.sdkOutput
  {
    return Success(PutItemOutputTransformOutput(transformedOutput := input.sdkOutput));
  }
}
