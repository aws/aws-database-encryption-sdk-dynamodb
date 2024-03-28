// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "DynamoDbMiddlewareSupport.dfy"

module TransactGetItemsTransform {
  import opened DdbMiddlewareConfig
  import opened DynamoDbMiddlewareSupport
  import opened Wrappers
  import DDB = ComAmazonawsDynamodbTypes
  import opened AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes
  import EncTypes = AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes
  import Seq

  method Input(config: Config, input: TransactGetItemsInputTransformInput)
    returns (output: Result<TransactGetItemsInputTransformOutput, Error>)
    ensures output.Success? && output.value.transformedInput == input.sdkInput
  {
    return Success(TransactGetItemsInputTransformOutput(transformedInput := input.sdkInput));
  }

  method {:vcs_split_on_every_assert} Output(config: Config, input: TransactGetItemsOutputTransformInput)
    returns (output: Result<TransactGetItemsOutputTransformOutput, Error>)
    requires ValidConfig?(config)
    ensures ValidConfig?(config)
    modifies ModifiesConfig(config)

    ensures NoList(input.sdkOutput.Responses) ==>
              && output.Success?
              && output.value.transformedOutput == input.sdkOutput

    ensures output.Success? && input.sdkOutput.Responses.Some? ==>
              && output.value.transformedOutput.Responses.Some?
              && |output.value.transformedOutput.Responses.value| == |input.originalInput.TransactItems|
  {
    if NoList(input.sdkOutput.Responses) {
      return Success(TransactGetItemsOutputTransformOutput(transformedOutput := input.sdkOutput));
    }
    if |input.sdkOutput.Responses.value| != |input.originalInput.TransactItems| {
      return MakeError("Invalid TransactGetItems response for original request: Number of items returned must equal number of items requested.");
    }
    var decryptedItems : seq<DDB.ItemResponse> := [];
    var encryptedItems := input.sdkOutput.Responses.value;
    for x := 0 to |encryptedItems|
      invariant |decryptedItems| == x
      invariant ValidConfig?(config)
    {
      var tableName := input.originalInput.TransactItems[x].Get.TableName;
      if tableName !in config.tableEncryptionConfigs {
        decryptedItems := decryptedItems + [encryptedItems[x]];
      } else {
        var tableConfig := config.tableEncryptionConfigs[tableName];
        if NoMap(encryptedItems[x].Item) {
          decryptedItems := decryptedItems + [DDB.ItemResponse(Item := None)];
        } else {
          //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#decrypt-after-transactgetitems
          //# For each list item under each key in `Responses`,
          //# if there exists an Item Encryptor specified within
          //# the [DynamoDB Encryption Client Config](#dynamodb-encryption-client-configuration)
          //# with a [DynamoDB Table Name](./ddb-item-encryptor.md#dynamodb-table-name)
          //# equal to the key,
          //# the Item Encryptor that corresponds to the key in the request
          //# MUST perform [Decrypt Item](./decrypt-item.md) where the input
          //# [DynamoDB Item](./decrypt-item.md#dynamodb-item) is the `Item` in the original response.
          var decryptRes := tableConfig.itemEncryptor.DecryptItem(EncTypes.DecryptItemInput(encryptedItem:=encryptedItems[x].Item.value));

          //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#decrypt-after-transactgetitems
          //# If any [Decrypt Item](./decrypt-item.md) fails,
          //# TransactGetItems MUST yield an error.
          var decrypted :- MapError(decryptRes);

          //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#decrypt-after-transactgetitems
          //# Beacons MUST be [removed](ddb-support.md#removebeacons) from the result.
          var item :- RemoveBeacons(tableConfig, decrypted.plaintextItem);

          //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#decrypt-after-transactgetitems
          //# Each of these items on the original response MUST be replaced
          //# with a value that is equivalent to
          //# the resulting item.
          decryptedItems := decryptedItems + [DDB.ItemResponse(Item := Some(item))];
        }
      }
    }
    return Success(TransactGetItemsOutputTransformOutput(transformedOutput := input.sdkOutput.(Responses := Some(decryptedItems))));
  }
}
