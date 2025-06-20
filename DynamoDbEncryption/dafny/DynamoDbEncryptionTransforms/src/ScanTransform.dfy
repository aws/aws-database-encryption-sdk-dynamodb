// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "DynamoDbMiddlewareSupport.dfy"

module ScanTransform {
  import opened DdbMiddlewareConfig
  import opened DynamoDbMiddlewareSupport
  import opened Wrappers
  import DDB = ComAmazonawsDynamodbTypes
  import opened AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes
  import EncTypes = AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes
  import EncOps = AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations

  method Input(config: Config, input: ScanInputTransformInput)
    returns (output: Result<ScanInputTransformOutput, Error>)
    requires ValidConfig?(config)
    ensures ValidConfig?(config)
    modifies ModifiesConfig(config)

    //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#modify-before-scan
    //= type=implication
    //# If the `TableName` in the request does not refer to an [encrypted-table](#encrypted-table),
    //# the Scan request MUST be unchanged.
    ensures input.sdkInput.TableName !in config.tableEncryptionConfigs ==>
              && output.Success?
              && output.value.transformedInput == input.sdkInput

    //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#modify-before-scan
    //= type=implication
    //# The Scan request MUST NOT refer to any legacy parameters,
    //# specifically AttributesToGet, ScanFilter and ConditionalOperator MUST NOT be set.
    ensures output.Success? && input.sdkInput.TableName in config.tableEncryptionConfigs ==>
              && NoList(input.sdkInput.AttributesToGet)
              && NoMap(input.sdkInput.ScanFilter)
              && input.sdkInput.ConditionalOperator.None?
  {
    if input.sdkInput.TableName !in config.tableEncryptionConfigs {
      return Success(ScanInputTransformOutput(transformedInput := input.sdkInput));
    } else {
      :- Need(NoList(input.sdkInput.AttributesToGet), E("Legacy parameter 'AttributesToGet' not supported in UpdateItem with Encryption"));
      :- Need(NoMap(input.sdkInput.ScanFilter), E("Legacy parameter 'ScanFilter' not supported in UpdateItem with Encryption"));
      :- Need(input.sdkInput.ConditionalOperator.None?, E("Legacy parameter 'ConditionalOperator' not supported in UpdateItem with Encryption"));
      var tableConfig := config.tableEncryptionConfigs[input.sdkInput.TableName];

      var bucket := []; // TODO
      var finalResult :- ScanInputForBeacons(tableConfig, input.sdkInput, bucket);
      return Success(ScanInputTransformOutput(transformedInput := finalResult));
    }
  }

  function Diff(x : nat, y : nat) : nat
    requires x >= y
  {
    x - y
  }

  method {:vcs_split_on_every_assert} Output(config: Config, input: ScanOutputTransformInput)
    returns (output: Result<ScanOutputTransformOutput, Error>)
    requires ValidConfig?(config)
    ensures ValidConfig?(config)
    modifies ModifiesConfig(config)

    ensures input.originalInput.TableName !in config.tableEncryptionConfigs || NoList(input.sdkOutput.Items) ==>
              && output.Success?
              && output.value.transformedOutput == input.sdkOutput

    ensures output.Success?  && NoList(input.sdkOutput.Items)  ==> NoList(output.value.transformedOutput.Items)
    ensures output.Success?  && input.sdkOutput.Items.Some?  ==> output.value.transformedOutput.Items.Some?
  {
    var tableName := input.originalInput.TableName;
    if tableName !in config.tableEncryptionConfigs || NoList(input.sdkOutput.Items) {
      return Success(ScanOutputTransformOutput(transformedOutput := input.sdkOutput));
    }
    var tableConfig := config.tableEncryptionConfigs[tableName];
    var decryptedItems : DDB.ItemList := [];
    var encryptedItems := input.sdkOutput.Items.value;
    var keyId :- GetBeaconKeyId(tableConfig, None, input.originalInput.FilterExpression, input.originalInput.ExpressionAttributeValues, input.originalInput.ExpressionAttributeNames);
    var keyIdUtf8 := [];
    if keyId.KeyId? {
      keyIdUtf8 :- UTF8.Encode(keyId.value).MapFailure(e => E(e));
    }
    for x := 0 to |encryptedItems|
    {
      //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#decrypt-after-scan
      //# Each of these entries on the original response MUST be replaced
      //# with the resulting decrypted
      //# [DynamoDB Item](./decrypt-item.md#dynamodb-item-1).

      var decryptInput := EncTypes.DecryptItemInput(encryptedItem := encryptedItems[x]);
      var decryptRes := tableConfig.itemEncryptor.DecryptItem(decryptInput);
      var decrypted :- MapError(decryptRes);

      if keyId.KeyId? && decrypted.parsedHeader.Some? {
        :- Need(|decrypted.parsedHeader.value.encryptedDataKeys| == 1, E("Scan result has more than one Encrypted Data Key"));
        if decrypted.parsedHeader.value.encryptedDataKeys[0].keyProviderInfo == keyIdUtf8 {
          decryptedItems := decryptedItems + [decrypted.plaintextItem];
        }
      } else {
        decryptedItems := decryptedItems + [decrypted.plaintextItem];
      }
    }

    //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#decrypt-after-scan
    //# The resulting decrypted response MUST be [filtered](ddb-support.md#scanoutputforbeacons) from the result.
    var decryptedOutput := input.sdkOutput.(Items := Some(decryptedItems));
    var bucket := []; // Not used
    var finalResult :- ScanOutputForBeacons(tableConfig, input.originalInput, decryptedOutput, bucket);
    return Success(ScanOutputTransformOutput(transformedOutput := finalResult));
  }
}
