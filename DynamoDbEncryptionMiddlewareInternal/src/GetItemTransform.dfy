// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "DdbMiddlewareConfig.dfy"

module GetItemTransform {
  import opened DdbMiddlewareConfig
  import opened Wrappers
  import DDB = ComAmazonawsDynamodbTypes
  import opened AwsCryptographyDynamoDbEncryptionTypes
  import EncTypes = AwsCryptographyDynamoDbItemEncryptorTypes
  import Seq


  method Input(config: Config, input: GetItemInputTransformInput)
    returns (output: Result<GetItemInputTransformOutput, Error>)
    ensures output.Success? && output.value.transformedInput == input.sdkInput
  {
    return Success(GetItemInputTransformOutput(transformedInput := input.sdkInput));
  }

  method Output(config: Config, input: GetItemOutputTransformInput)
    returns (output: Result<GetItemOutputTransformOutput, Error>)

    //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#decrypt-after-getitem
    //= type=implication
    //# After a [GetItem](https://docs.aws.amazon.com/amazondynamodb/latest/APIReference/API_GetItem.html)
    //# call is made to DynamoDB,
    //# the resulting response MUST be modified before
    //# being returned to the caller if there exists
    //# an Item Encryptor specified within the [DynamoDB Encryption Client Config](#dynamodb-encryption-client-configuration)
    //# with a [DynamoDB Table Name](./ddb-item-encryptor.md#dynamodb-table-name)
    //# equal to the `TableName` on the GetItem request.
    ensures output.Success? && input.originalInput.TableName !in config.tableEncryptionConfigs ==> output.value.transformedOutput == input.sdkOutput
    ensures output.Success? && input.sdkOutput.Item.None? ==> output.value.transformedOutput.Item.None?
    ensures output.Success? && input.originalInput.TableName in config.tableEncryptionConfigs && input.sdkOutput.Item.Some? ==>
      var oldHistory := old(config.tableEncryptionConfigs[input.originalInput.TableName].itemEncryptor.History.DecryptItem);
      var newHistory := config.tableEncryptionConfigs[input.originalInput.TableName].itemEncryptor.History.DecryptItem;

      && |newHistory| == |oldHistory|+1
      && Seq.Last(newHistory).output.Success?

      //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#decrypt-after-getitem
      //= type=implication
      //# The [Item Encryptor](./ddb-item-encryptor.md) MUST perform
      //# [Decrypt Item](./decrypt-item.md) where the input
      //# [DynamoDB Item](./decrypt-item.md#dynamodb-item)
      //# is the `Item` field in the original response
      && Seq.Last(newHistory).input.encryptedItem == input.sdkOutput.Item.value

      //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#decrypt-after-getitem
      //= type=implication
      //# The GetItem request's `Item` field MUST be replaced
      //# with a value that is equivalent to
      //# the resulting decrypted [DynamoDB Item](./decrypt-item.md#dynamodb-item-1).
      && output.value.transformedOutput.Item.Some?
      && (Seq.Last(newHistory).output.value.plaintextItem == output.value.transformedOutput.Item.value)

    requires ValidConfig?(config)
    ensures ValidConfig?(config)
    modifies ModifiesConfig(config)
  {
    var tableName := input.originalInput.TableName;
    if tableName !in config.tableEncryptionConfigs || input.sdkOutput.Item.None? {
      return Success(GetItemOutputTransformOutput(transformedOutput := input.sdkOutput));
    }
    var tableConfig := config.tableEncryptionConfigs[tableName];
    var decryptRes := tableConfig.itemEncryptor.DecryptItem(
      EncTypes.DecryptItemInput(encryptedItem:=input.sdkOutput.Item.value)
    );
    var decrypted :- MapError(decryptRes);
    return Success(GetItemOutputTransformOutput(transformedOutput := input.sdkOutput.(Item := Some(decrypted.plaintextItem))));
  }


}
