// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "DynamoDbMiddlewareSupport.dfy"

module QueryTransform {
  import opened DdbMiddlewareConfig
  import opened DynamoDbMiddlewareSupport
  import opened Wrappers
  import DDB = ComAmazonawsDynamodbTypes
  import opened AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes
  import EncTypes = AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes
  import EncOps = AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations

  method Input(config: Config, input: QueryInputTransformInput)
    returns (output: Result<QueryInputTransformOutput, Error>)
    requires ValidConfig?(config)
    ensures ValidConfig?(config)
    modifies ModifiesConfig(config)

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
              && NoList(input.sdkInput.AttributesToGet)
              && NoMap(input.sdkInput.KeyConditions)
              && NoMap(input.sdkInput.QueryFilter)
              && input.sdkInput.ConditionalOperator.None?
  {
    if input.sdkInput.TableName !in config.tableEncryptionConfigs {
      return Success(QueryInputTransformOutput(transformedInput := input.sdkInput));
    } else {
      :- Need(NoList(input.sdkInput.AttributesToGet), E("Legacy parameter 'AttributesToGet' not supported in Query with Encryption"));
      :- Need(NoMap(input.sdkInput.KeyConditions), E("Legacy parameter 'KeyConditions' not supported in Query with Encryption"));
      :- Need(NoMap(input.sdkInput.QueryFilter), E("Legacy parameter 'QueryFilter' not supported in Query with Encryption"));
      :- Need(input.sdkInput.ConditionalOperator.None?, E("Legacy parameter 'ConditionalOperator' not supported in Query with Encryption"));
      var tableConfig := config.tableEncryptionConfigs[input.sdkInput.TableName];

      var bucket := []; // TODO
      var finalResult :- QueryInputForBeacons(tableConfig, input.sdkInput, bucket);
      return Success(QueryInputTransformOutput(transformedInput := finalResult));
    }
  }

  function Diff(x : nat, y : nat) : nat
    requires x >= y
  {
    x - y
  }

  method {:vcs_split_on_every_assert} Output(config: Config, input: QueryOutputTransformInput)
    returns (output: Result<QueryOutputTransformOutput, Error>)
    requires ValidConfig?(config)
    ensures ValidConfig?(config)
    modifies ModifiesConfig(config)

    ensures input.originalInput.TableName !in config.tableEncryptionConfigs || NoList(input.sdkOutput.Items) ==>
              && output.Success?
              && output.value.transformedOutput == input.sdkOutput

    ensures output.Success?  && input.sdkOutput.Items.Some? ==> output.value.transformedOutput.Items.Some?
    ensures output.Success?  && NoList(input.sdkOutput.Items) ==> NoList(output.value.transformedOutput.Items)
  {
    var tableName := input.originalInput.TableName;
    if tableName !in config.tableEncryptionConfigs || NoList(input.sdkOutput.Items) {
      return Success(QueryOutputTransformOutput(transformedOutput := input.sdkOutput));
    }
    var tableConfig := config.tableEncryptionConfigs[tableName];
    var decryptedItems : DDB.ItemList := [];
    var encryptedItems := input.sdkOutput.Items.value;
    var keyId :- GetBeaconKeyId(tableConfig, input.originalInput.KeyConditionExpression, input.originalInput.FilterExpression, input.originalInput.ExpressionAttributeValues, input.originalInput.ExpressionAttributeNames);
    var keyIdUtf8 := [];
    if keyId.KeyId? {
      keyIdUtf8 :- UTF8.Encode(keyId.value).MapFailure(e => E(e));
    }
    ghost var originalHistory := tableConfig.itemEncryptor.History.DecryptItem;
    ghost var historySize := |originalHistory|;
    for x := 0 to |encryptedItems|
    {
      //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#decrypt-after-query
      //# Each of these entries on the original response MUST be replaced
      //# with the resulting decrypted [DynamoDB Item](./decrypt-item.md#dynamodb-item-1).
      var decryptInput := EncTypes.DecryptItemInput(encryptedItem := encryptedItems[x]);
      var decryptRes := tableConfig.itemEncryptor.DecryptItem(decryptInput);
      var decrypted :- MapError(decryptRes);

      if keyId.KeyId? && decrypted.parsedHeader.Some? {
        :- Need(|decrypted.parsedHeader.value.encryptedDataKeys| == 1, E("Query result has more than one Encrypted Data Key"));
        if decrypted.parsedHeader.value.encryptedDataKeys[0].keyProviderInfo == keyIdUtf8 {
          decryptedItems := decryptedItems + [decrypted.plaintextItem];
        }
      } else {
        decryptedItems := decryptedItems + [decrypted.plaintextItem];
      }
    }

    //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#decrypt-after-query
    //# The resulting decrypted response MUST be [filtered](ddb-support.md#queryoutputforbeacons) from the result.
    var decryptedOutput := input.sdkOutput.(Items := Some(decryptedItems));
    var bucket := []; // Not used
    var finalResult :- QueryOutputForBeacons(tableConfig, input.originalInput, decryptedOutput, bucket);
    return Success(QueryOutputTransformOutput(transformedOutput := finalResult));
  }
}
