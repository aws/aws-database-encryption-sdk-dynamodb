// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "DynamoDbMiddlewareSupport.dfy"
include "../../DynamoDbEncryption/src/DDBSupport.dfy"

module QueryTransform {
  import opened DdbMiddlewareConfig
  import opened DynamoDbMiddlewareSupport
  import opened Wrappers
  import DDB = ComAmazonawsDynamodbTypes
  import opened AwsCryptographyDynamoDbEncryptionTransformsTypes
  import EncTypes = AwsCryptographyDynamoDbEncryptionItemEncryptorTypes
  import Seq

  method Input(config: Config, input: QueryInputTransformInput)
    returns (output: Result<QueryInputTransformOutput, Error>)

    //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#modify-before-query
    //= type=implication
    //# If the `TableName` in the request does not refer to an [encrypted-table](#encrypted-table),
    //# the Query request MUST be unchanged.
    ensures input.sdkInput.TableName !in config.tableEncryptionConfigs ==>
      && output.Success?
      && output.value.transformedInput == input.sdkInput

    ensures output.Success? && input.sdkInput.TableName in config.tableEncryptionConfigs ==>
      //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#modify-before-query
      //= type=implication
      //# The Query request MUST NOT refer to any legacy parameters,
      //# specifically AttributesToGet, KeyConditions, QueryFilter and ConditionalOperator MUST NOT be set.
      && input.sdkInput.AttributesToGet.None?
      && input.sdkInput.KeyConditions.None?
      && input.sdkInput.QueryFilter.None?
      && input.sdkInput.ConditionalOperator.None?

      //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#modify-before-query
      //= type=implication
      //# The request MUST be [altered](#queryinputforbeacons)
      //# to transform any references to encrypted attributes into references to beacons.
      && var tableConfig := config.tableEncryptionConfigs[input.sdkInput.TableName];
      && QueryInputForBeacons(tableConfig, input.sdkInput).Success?
      && var finalResult := QueryInputForBeacons(tableConfig, input.sdkInput).value;
      && output.value.transformedInput == finalResult
  {
    if input.sdkInput.TableName !in config.tableEncryptionConfigs {
      return Success(QueryInputTransformOutput(transformedInput := input.sdkInput));
    } else {
      :- Need(input.sdkInput.AttributesToGet.None?, E("Legacy parameter 'AttributesToGet' not supported in UpdateItem with Encryption"));
      :- Need(input.sdkInput.KeyConditions.None?, E("Legacy parameter 'ScanFilter' not supported in UpdateItem with Encryption"));
      :- Need(input.sdkInput.QueryFilter.None?, E("Legacy parameter 'ScanFilter' not supported in UpdateItem with Encryption"));
      :- Need(input.sdkInput.ConditionalOperator.None?, E("Legacy parameter 'ConditionalOperator' not supported in UpdateItem with Encryption"));
      var tableConfig := config.tableEncryptionConfigs[input.sdkInput.TableName];
      var finalResult :- QueryInputForBeacons(tableConfig, input.sdkInput);
      return Success(QueryInputTransformOutput(transformedInput := finalResult));
    }
  }

  method {:vcs_split_on_every_assert} Output(config: Config, input: QueryOutputTransformInput)
    returns (output: Result<QueryOutputTransformOutput, Error>)
    requires ValidConfig?(config)
    ensures ValidConfig?(config)
    modifies ModifiesConfig(config)

    ensures input.originalInput.TableName !in config.tableEncryptionConfigs || input.sdkOutput.Items.None? ==>
      && output.Success?
      && output.value.transformedOutput == input.sdkOutput

    ensures output.Success?  && input.sdkOutput.Items.Some? ==> output.value.transformedOutput.Items.Some?
    ensures output.Success?  && input.sdkOutput.Items.None? ==> output.value.transformedOutput.Items.None?

    ensures output.Success? && input.sdkOutput.Items.Some? && input.originalInput.TableName in config.tableEncryptionConfigs ==>
      var oldHistory := old(config.tableEncryptionConfigs[input.originalInput.TableName].itemEncryptor.History.DecryptItem);
      var newHistory := config.tableEncryptionConfigs[input.originalInput.TableName].itemEncryptor.History.DecryptItem;

      && (|newHistory| == |oldHistory| + |input.sdkOutput.Items.value|)

      && (forall i : nat | |oldHistory| <= i < |input.sdkOutput.Items.value| + |oldHistory| ::

            //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#decrypt-after-query
            //= type=implication
            //# If any [Decrypt Item](./decrypt-item.md) fails,
            //# Query MUST yield an error.
            && newHistory[i].output.Success?

            //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#decrypt-after-query
            //= type=implication
            //# For each list entry in `Items` in the response,
            //# if there exists an Item Encryptor specified within the
            //# [DynamoDB Encryption Client Config](#dynamodb-encryption-client-configuration)
            //# with a [DynamoDB Table Name](./ddb-item-encryptor.md#dynamodb-table-name)
            //# equal to the `TableName` on the request,
            //# the corresponding Item Encryptor MUST perform [Decrypt Item](./decrypt-item.md)
            //# where the input [DynamoDB Item](./decrypt-item.md#dynamodb-item)
            //# is this list entry.
            && newHistory[i].input.encryptedItem == input.sdkOutput.Items.value[i-|oldHistory|]
         )
  {
    var tableName := input.originalInput.TableName;
    if tableName !in config.tableEncryptionConfigs || input.sdkOutput.Items.None? {
      return Success(QueryOutputTransformOutput(transformedOutput := input.sdkOutput));
    }
    var tableConfig := config.tableEncryptionConfigs[tableName];
    var decryptedItems : DDB.ItemList := [];
    var encryptedItems := input.sdkOutput.Items.value;
    ghost var historySize := |tableConfig.itemEncryptor.History.DecryptItem|;
    for x := 0 to |encryptedItems|
      invariant |decryptedItems| == x

      invariant
        && (|tableConfig.itemEncryptor.History.DecryptItem| ==
            |old(tableConfig.itemEncryptor.History.DecryptItem)| + |decryptedItems|)

      invariant (forall i : nat | historySize <= i < |decryptedItems|+historySize ::
        var item := tableConfig.itemEncryptor.History.DecryptItem[i];
        && item.output.Success?
        && item.input.encryptedItem == input.sdkOutput.Items.value[i-historySize]
        && item.output.value.plaintextItem == decryptedItems[i-historySize])
    {
      //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#decrypt-after-query
      //# Each of these entries on the original response MUST be replaced
      //# with the resulting decrypted [DynamoDB Item](./decrypt-item.md#dynamodb-item-1).
      var decryptRes := tableConfig.itemEncryptor.DecryptItem(EncTypes.DecryptItemInput(encryptedItem:=encryptedItems[x]));
      var decrypted :- MapError(decryptRes);
      decryptedItems := decryptedItems + [decrypted.plaintextItem];
    }

    //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#decrypt-after-query
    //# The resulting decrypted response MUST be [filtered](ddb-support.md#queryoutputforbeacons) from the result.
    var decryptedOutput := input.sdkOutput.(Items := Some(decryptedItems));
    var finalResult :- QueryOutputForBeacons(tableConfig, input.originalInput, decryptedOutput);
    return Success(QueryOutputTransformOutput(transformedOutput := finalResult));
  }
}

