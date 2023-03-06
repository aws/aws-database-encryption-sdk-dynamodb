// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "DdbMiddlewareConfig.dfy"

module TransactWriteItemsTransform {
  import opened DdbMiddlewareConfig
  import opened Wrappers
  import DDB = ComAmazonawsDynamodbTypes
  import opened AwsCryptographyDynamoDbEncryptionTypes
  import EncTypes = AwsCryptographyDynamoDbItemEncryptorTypes
  import Seq

  method Input(config: Config, input: TransactWriteItemsInputTransformInput)
    returns (output: Result<TransactWriteItemsInputTransformOutput, Error>)
    requires ValidConfig?(config)
    ensures ValidConfig?(config)
    modifies ModifiesConfig(config)

    ensures output.Success? ==> |output.value.transformedInput.TransactItems| == |input.sdkInput.TransactItems|

    //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#encrypt-before-transactwriteitems
    //= type=implication
    //# - The client MUST fail if in the `ConditionCheck` field has a `TableName` which matches
    //# the [DynamoDB Table Name](./ddb-item-encryptor.md#dynamodb-table-name)
    //# of any Item Encryptor specified within the
    //# [DynamoDB Encryption Client Config](#dynamodb-encryption-client-configuration)
    ensures output.Success? ==>
      forall item <- input.sdkInput.TransactItems ::
        (item.ConditionCheck.None? || item.ConditionCheck.value.TableName !in config.tableEncryptionConfigs)

    //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#encrypt-before-transactwriteitems
    //= type=implication
    //# - The client MUST fail if in the `Delete` field has a `TableName` which matches
    //# the [DynamoDB Table Name](./ddb-item-encryptor.md#dynamodb-table-name)
    //# of any Item Encryptor specified within the
    //# [DynamoDB Encryption Client Config](#dynamodb-encryption-client-configuration)
    //# and also has a `ConditionExpression`
    ensures output.Success? ==>
      forall item <- input.sdkInput.TransactItems ::
        || item.Delete.None?
        || item.Delete.value.TableName !in config.tableEncryptionConfigs
        || item.Delete.value.ConditionExpression.None?

    //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#encrypt-before-transactwriteitems
    //= type=implication
    //# - The client MUST fail if in the `Update` field has a `TableName` which matches
    //# the [DynamoDB Table Name](./ddb-item-encryptor.md#dynamodb-table-name)
    //# of any Item Encryptor specified within the
    //# [DynamoDB Encryption Client Config](#dynamodb-encryption-client-configuration)
    ensures output.Success? ==>
      forall item <- input.sdkInput.TransactItems ::
        (item.Update.None? || item.Update.value.TableName !in config.tableEncryptionConfigs)

    //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#encrypt-before-transactwriteitems
    //= type=implication
    //# - The client MUST fail if in the `Put` field has a `TableName` which matches
    //# the [DynamoDB Table Name](./ddb-item-encryptor.md#dynamodb-table-name)
    //# of any Item Encryptor specified within the
    //# [DynamoDB Encryption Client Config](#dynamodb-encryption-client-configuration)
    //# and also has a `ConditionExpression`
    ensures output.Success? ==>
      forall item <- input.sdkInput.TransactItems ::
        || item.Put.None?
        || item.Put.value.TableName !in config.tableEncryptionConfigs
        || item.Put.value.ConditionExpression.None?

    //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#encrypt-before-transactwriteitems
    //= type=implication
    //# - To protect against a possible fifth field being added to the TransactWriteItem structure in the future,
    //# The client MUST fail if the `Update`, `ConditionCheck`, `Delete` and `Put` fields are all `None`.
    ensures output.Success? ==>
      forall item <- input.sdkInput.TransactItems ::
        item.Put.Some? || item.Update.Some? || item.Delete.Some? || item.ConditionCheck.Some?
  {
    var result : seq<DDB.TransactWriteItem> := [];
    for x := 0 to |input.sdkInput.TransactItems|
      invariant |result| == x
      invariant forall i : nat | 0 <= i < |result| ::
        var item := input.sdkInput.TransactItems[i];
        && (|| item.ConditionCheck.None?
            || item.ConditionCheck.value.TableName !in config.tableEncryptionConfigs)
        && (|| item.Delete.None?
            || item.Delete.value.TableName !in config.tableEncryptionConfigs
            || item.Delete.value.ConditionExpression.None?)
        && (|| item.Update.None?
            || item.Update.value.TableName !in config.tableEncryptionConfigs)
        && (|| item.Put.None?
            || item.Put.value.TableName !in config.tableEncryptionConfigs
            || item.Put.value.ConditionExpression.None?)
        && (item.Put.Some? || item.Update.Some? || item.Delete.Some? || item.ConditionCheck.Some?)
    {
      var item := input.sdkInput.TransactItems[x];

      if && item.ConditionCheck.None?
         && item.Delete.None?
         && item.Update.None?
         && item.Put.None?
      {
        return MakeError("Each item in TransactWriteItems must specify at least one operation");
      }
      if item.ConditionCheck.Some? && item.ConditionCheck.value.TableName in config.tableEncryptionConfigs {
        return MakeError("Condition expressions not allowed on encrypted tables (TransactWriteItems ConditionCheck)");
      }
      if item.Delete.Some? && item.Delete.value.TableName in config.tableEncryptionConfigs && item.Delete.value.ConditionExpression.Some? {
        return MakeError("Condition checks not allowed on encrypted tables (TransactWriteItems Delete)");
      }
      if item.Update.Some? && item.Update.value.TableName in config.tableEncryptionConfigs {
          return MakeError("Updates not allowed on encrypted tables (TransactWriteItems Update)");
      }
      if item.Put.Some? && item.Put.value.TableName in config.tableEncryptionConfigs {
        if item.Put.value.ConditionExpression.Some? {
          return MakeError("Condition expressions not allowed on encrypted tables (TransactWriteItems Put)");
        }
        var tableConfig := config.tableEncryptionConfigs[item.Put.value.TableName];

        //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#encrypt-before-transactwriteitems
        //# If the request is valid, for each `Put` in `TransactItems` in the request,
        //# if a corresponding Item Encryptor exists,
        //# it MUST perform [Encrypt Item](./encrypt-item.md) where the input
        //# [DynamoDB Item](./encrypt-item.md#dynamodb-item) is
        //# the `Item` field in this `Put`
        var encryptRes := tableConfig.itemEncryptor.EncryptItem(
          EncTypes.EncryptItemInput(plaintextItem:=item.Put.value.Item)
        );

        //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#encrypt-before-transactwriteitems
        //# If any of the above validation fails, or any [Encrypt Item](./encrypt-item.md) fails,
        //# the client MUST NOT make a network call to DynamoDB and
        //# TransactWriteItems MUST yield an error.
        var encrypted :- MapError(encryptRes);

        //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#encrypt-before-transactwriteitems
        //# The `Item` field in this `Put` MUST be replaced
        //# with a value that is equivalent to
        //# the resulting [Encrypted DynamoDB Item](./encrypt-item.md#encrypted-dynamodb-item).
        var put := Some(item.Put.value.(Item := encrypted.encryptedItem));
        result := result + [item.(Put := put)];
      } else {
        result := result + [item];
      }
    }
    var finalResult := result; // TODO we need to redeclare this in a "final" var until we upgrade to Dafny 3.10.0
    return Success(TransactWriteItemsInputTransformOutput(transformedInput := input.sdkInput.(TransactItems := finalResult)));
  }

  method Output(config: Config, input: TransactWriteItemsOutputTransformInput)
    returns (output: Result<TransactWriteItemsOutputTransformOutput, Error>)
    ensures output.Success? && output.value.transformedOutput == input.sdkOutput
  {
    var finalResult := input.sdkOutput;
    return Success(TransactWriteItemsOutputTransformOutput(transformedOutput := finalResult));
  }

}
