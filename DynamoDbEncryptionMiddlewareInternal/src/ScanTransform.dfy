// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "DdbMiddlewareConfig.dfy"

module ScanTransform {
  import opened DdbMiddlewareConfig
  import opened Wrappers
  import DDB = ComAmazonawsDynamodbTypes
  import opened AwsCryptographyDynamoDbEncryptionTypes
  import EncTypes = AwsCryptographyDynamoDbItemEncryptorTypes
  import Seq


  method Input(config: Config, input: ScanInputTransformInput)
    returns (output: Result<ScanInputTransformOutput, Error>)
    ensures output.Success? && output.value.transformedInput == input.sdkInput
  {
    return Success(ScanInputTransformOutput(transformedInput := input.sdkInput));
  }

  method Output(config: Config, input: ScanOutputTransformInput)
    returns (output: Result<ScanOutputTransformOutput, Error>)
    requires ValidConfig?(config)
    ensures ValidConfig?(config)
    modifies ModifiesConfig(config)

    ensures input.originalInput.TableName !in config.tableEncryptionConfigs || input.sdkOutput.Items.None? ==>
      && output.Success?
      && output.value.transformedOutput == input.sdkOutput

    ensures output.Success?  && input.sdkOutput.Items.None?  ==> output.value.transformedOutput.Items.None?
    ensures output.Success?  && input.sdkOutput.Items.Some?  ==>
      && output.value.transformedOutput.Items.Some?
      && |output.value.transformedOutput.Items.value| == |input.sdkOutput.Items.value|

    ensures output.Success? && input.sdkOutput.Items.Some? && input.originalInput.TableName in config.tableEncryptionConfigs ==>
      var oldHistory := old(config.tableEncryptionConfigs[input.originalInput.TableName].itemEncryptor.History.DecryptItem);
      var newHistory := config.tableEncryptionConfigs[input.originalInput.TableName].itemEncryptor.History.DecryptItem;
      && (|newHistory| == |oldHistory| + |input.sdkOutput.Items.value|)

      && (forall i : nat | |oldHistory| <= i < |input.sdkOutput.Items.value| + |oldHistory| ::

          //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#decrypt-after-scan
          //= type=implication
          //# If any [Decrypt Item](./decrypt-item.md) operation fails,
          //# Scan MUST yield an error.
          && newHistory[i].output.Success?

          //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#decrypt-after-scan
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

          //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#decrypt-after-scan
          //= type=implication
          //# Each of these entries on the original repsonse MUST be replaced
          //# with the resulting decrypted
          //# [DynamoDB Item](./decrypt-item.md#dynamodb-item-1).
          && newHistory[i].output.value.plaintextItem ==
              output.value.transformedOutput.Items.value[i-|oldHistory|]
        )
  {
    var tableName := input.originalInput.TableName;
    if tableName !in config.tableEncryptionConfigs || input.sdkOutput.Items.None? {
      return Success(ScanOutputTransformOutput(transformedOutput := input.sdkOutput));
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
      var decryptRes := tableConfig.itemEncryptor.DecryptItem(EncTypes.DecryptItemInput(encryptedItem:=encryptedItems[x]));
      var decrypted :- MapError(decryptRes);
      decryptedItems := decryptedItems + [decrypted.plaintextItem];
    }
    var finalResult := decryptedItems; // TODO we need to redeclare this in a "final" var until we upgrade to Dafny 3.10.0
    return Success(ScanOutputTransformOutput(transformedOutput := input.sdkOutput.(Items := Some(finalResult))));
  }
}
