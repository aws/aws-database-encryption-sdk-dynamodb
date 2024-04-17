// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "DynamoDbMiddlewareSupport.dfy"

module BatchGetItemTransform {
  import opened DdbMiddlewareConfig
  import opened DynamoDbMiddlewareSupport
  import opened Wrappers
  import DDB = ComAmazonawsDynamodbTypes
  import opened AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes
  import EncTypes = AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes
  import Seq

  method Input(config: Config, input: BatchGetItemInputTransformInput)
    returns (output: Result<BatchGetItemInputTransformOutput, Error>)
    ensures output.Success? && output.value.transformedInput == input.sdkInput
  {
    return Success(BatchGetItemInputTransformOutput(transformedInput := input.sdkInput));
  }

  method {:vcs_split_on_every_assert} Output(config: Config, input: BatchGetItemOutputTransformInput)
    returns (output: Result<BatchGetItemOutputTransformOutput, Error>)
    requires ValidConfig?(config)
    ensures ValidConfig?(config)
    modifies ModifiesConfig(config)

    ensures output.Success? ==> SameOption(input.sdkOutput.Responses, output.value.transformedOutput.Responses)
    ensures output.Success? && input.sdkOutput.Responses.Some? ==>
              && output.value.transformedOutput.Responses.Some?
    // true but expensive -- input.sdkOutput.Responses.value.Keys == output.value.transformedOutput.Responses.value.Keys
  {
    if NoMap(input.sdkOutput.Responses) {
      return Success(BatchGetItemOutputTransformOutput(transformedOutput := input.sdkOutput));
    }
    var tableNames := input.sdkOutput.Responses.value.Keys;
    var result := map[];
    while tableNames != {}
      decreases |tableNames|
      invariant tableNames <= input.sdkOutput.Responses.value.Keys
      // true but expensive -- invariant result.Keys + tableNames == input.sdkOutput.Responses.value.Keys
    {
      var tableName :| tableName in tableNames;
      tableNames := tableNames - { tableName };
      var responses := input.sdkOutput.Responses.value[tableName];
      if tableName in config.tableEncryptionConfigs {
        var tableConfig := config.tableEncryptionConfigs[tableName];
        var decryptedItem : DDB.ItemList := [];
        for x := 0 to |responses| {
          //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#decrypt-after-batchgetitem
          //# For each list item under each key in `Responses`,
          //# if there is a configured Item Encryptor with  [DynamoDB Table Name](./ddb-item-encryptor.md#dynamodb-table-name) equal to the key,
          //# that Item Encryptor MUST perform [Decrypt Item](./decrypt-item.md) where the input
          //# [DynamoDB Item](./decrypt-item.md#dynamodb-item)
          //# is the `Item` field in the original response.
          var decryptRes := tableConfig.itemEncryptor.DecryptItem(EncTypes.DecryptItemInput(encryptedItem:=responses[x]));

          //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#decrypt-after-batchgetitem
          //# If any [Decrypt Item](./decrypt-item.md) operation fails,
          //# BatchGetItem MUST yield an error.
          var decrypted :- MapError(decryptRes);

          //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#decrypt-after-batchgetitem
          //# Beacons MUST be [removed](ddb-support.md#removebeacons) from the result.
          var item :- RemoveBeacons(tableConfig, decrypted.plaintextItem);

          //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#decrypt-after-batchgetitem
          //# Each of these items on the original response MUST be replaced
          //# with a value that is equivalent to
          //# this result.
          decryptedItem := decryptedItem + [item];
        }
        result := result + map[tableName := decryptedItem];
      } else {
        result := result + map[tableName := responses];
      }
    }
    return Success(BatchGetItemOutputTransformOutput(transformedOutput := input.sdkOutput.(Responses := Some(result))));
  }

}
