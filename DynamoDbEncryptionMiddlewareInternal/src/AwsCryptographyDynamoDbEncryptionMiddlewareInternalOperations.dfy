// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../../private-aws-encryption-sdk-dafny-staging/ComAmazonawsDynamodb/Model/ComAmazonawsDynamodbTypes.dfy"
include "../../private-aws-encryption-sdk-dafny-staging/libraries/src/Collections/Maps/Maps.dfy"
include "../Model/AwsCryptographyDynamoDbEncryptionMiddlewareInternalTypes.dfy"
include "../../StructuredEncryption/Model/AwsCryptographyStructuredEncryptionTypes.dfy"
include "../../DynamoDbItemEncryptor/Model/AwsCryptographyDynamoDbItemEncryptorTypes.dfy"
include "../../DynamoDbItemEncryptor/src/DynamoToStruct.dfy"
include "DdbStatement.dfy"

// TODO break this into multiple files
module AwsCryptographyDynamoDbEncryptionMiddlewareInternalOperations refines AbstractAwsCryptographyDynamoDbEncryptionMiddlewareInternalOperations {
  import DDB = ComAmazonawsDynamodbTypes
  import AwsCryptographyDynamoDbItemEncryptorTypes
  import DynamoDbItemEncryptor
  import DynamoToStruct
  import ENC = AwsCryptographyDynamoDbItemEncryptorOperations
  import EncTypes = AwsCryptographyDynamoDbItemEncryptorTypes
  import AwsCryptographyStructuredEncryptionTypes
  import Seq
  import DdbStatement

  datatype TableConfig = TableConfig(
    partitionKeyName: string,
    sortKeyName: Option<string>,
    itemEncryptor: DynamoDbItemEncryptor.DynamoDbItemEncryptorClient
    // TODO beacon config
  )

  predicate ValidTableConfig?(config: TableConfig) {
    var encryptoConfig := config.itemEncryptor.config;
    && config.partitionKeyName == encryptoConfig.partitionKeyName
    && config.sortKeyName == encryptoConfig.sortKeyName
  }

  type ValidTableConfig = c: TableConfig | ValidTableConfig?(c) witness *

  datatype Config = Config(
    tableEncryptionConfigs: map<string, ValidTableConfig>
    // TODO allowed passthrough tables
  )

  predicate ValidInternalConfig?(config: InternalConfig)
  {
    && (forall tableName <- config.tableEncryptionConfigs ::
        config.tableEncryptionConfigs[tableName].itemEncryptor.config.tableName == tableName)
    && (forall t :: t in config.tableEncryptionConfigs.Keys ==>
        config.tableEncryptionConfigs[t].itemEncryptor.ValidState())
  }

  function ModifiesInternalConfig(config: InternalConfig) : set<object>
  {
    set t <- config.tableEncryptionConfigs.Keys, o <- config.tableEncryptionConfigs[t].itemEncryptor.Modifies :: o
  }

  type InternalConfig = Config

  function method MapError<T>(r : Result<T, EncTypes.Error>) : Result<T, Error> {
    r.MapFailure(e => AwsCryptographyDynamoDbItemEncryptor(e))
  }

  function method MapString<T>(r : Result<T, string>) : Result<T, Error> {
    r.MapFailure(e => Error.DynamoDbEncryptionMiddlewareInternalException(message := e))
  }

  function method MakeError<X>(s : string) : Result<X, Error>
  {
    Failure(Error.DynamoDbEncryptionMiddlewareInternalException(message := s))
  }

  predicate SameOption<X>(x : Option<X>, y : Option<X>)
  {
    (x.Some? && y.Some?) || (x.None? && y.None?)
  }

  predicate PutItemInputTransformEnsuresPublicly(input: PutItemInputTransformInput, output: Result<PutItemInputTransformOutput, Error>)
  {true}

  method PutItemInputTransform(config: InternalConfig, input: PutItemInputTransformInput)
    returns (output: Result<PutItemInputTransformOutput, Error>)

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

  predicate PutItemOutputTransformEnsuresPublicly(input: PutItemOutputTransformInput, output: Result<PutItemOutputTransformOutput, Error>)
  {true}

  method PutItemOutputTransform(config: InternalConfig, input: PutItemOutputTransformInput)
    returns (output: Result<PutItemOutputTransformOutput, Error>)
    ensures output.Success? && output.value.transformedOutput == input.sdkOutput
  {
    return Success(PutItemOutputTransformOutput(transformedOutput := input.sdkOutput));
  }

  predicate GetItemInputTransformEnsuresPublicly(input: GetItemInputTransformInput, output: Result<GetItemInputTransformOutput, Error>)
  {true}

  method GetItemInputTransform(config: InternalConfig, input: GetItemInputTransformInput)
    returns (output: Result<GetItemInputTransformOutput, Error>)
    ensures output.Success? && output.value.transformedInput == input.sdkInput
  {
    return Success(GetItemInputTransformOutput(transformedInput := input.sdkInput));
  }

  predicate GetItemOutputTransformEnsuresPublicly(input: GetItemOutputTransformInput, output: Result<GetItemOutputTransformOutput, Error>)
  {true}

  method GetItemOutputTransform(config: InternalConfig, input: GetItemOutputTransformInput)
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
  {
    var tablename := input.originalInput.TableName;
    if tablename !in config.tableEncryptionConfigs || input.sdkOutput.Item.None? {
      return Success(GetItemOutputTransformOutput(transformedOutput := input.sdkOutput));
    }
    var tableConfig := config.tableEncryptionConfigs[tablename];
    var decryptRes := tableConfig.itemEncryptor.DecryptItem(
      EncTypes.DecryptItemInput(encryptedItem:=input.sdkOutput.Item.value)
    );
    var decrypted :- MapError(decryptRes);
    return Success(GetItemOutputTransformOutput(transformedOutput := input.sdkOutput.(Item := Some(decrypted.plaintextItem))));
  }

  predicate UpdateItemInputTransformEnsuresPublicly(input: UpdateItemInputTransformInput, output: Result<UpdateItemInputTransformOutput, Error>)
  {true}

  method UpdateItemInputTransform(config: InternalConfig, input: UpdateItemInputTransformInput)
    returns (output: Result<UpdateItemInputTransformOutput, Error>)

    //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#validate-before-updateitem
    //= type=implication
    //# Before a [UpdateItem](https://docs.aws.amazon.com/amazondynamodb/latest/APIReference/API_UpdateItem.html)
    //# call is made to DynamoDB,
    //# the request MUST fail, and the client make no network call to DynamoDB,
    //# if there exists an Item Encryptor
    //# specified within the [DynamoDB Encryption Client Config](#dynamodb-encryption-client-configuration)
    //# with a [DynamoDB Table Name](./ddb-item-encryptor.md#dynamodb-table-name)
    //# equal to `TableName` in the request.
    ensures input.sdkInput.TableName in config.tableEncryptionConfigs ==> output.Failure?

    //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#validate-before-updateitem
    //= type=implication
    //# If no such Item Encryptor exists,
    //# there MUST NOT be any modification
    //# to the UpdateItem request.
    ensures input.sdkInput.TableName !in config.tableEncryptionConfigs ==>
      && output.Success?
      && output.value.transformedInput == input.sdkInput
  {
    if input.sdkInput.TableName in config.tableEncryptionConfigs {
      return MakeError("Updates are not supported on tables configured with encryption.");
    } else {
      return Success(UpdateItemInputTransformOutput(transformedInput := input.sdkInput));
    }
  }

  predicate UpdateItemOutputTransformEnsuresPublicly(input: UpdateItemOutputTransformInput, output: Result<UpdateItemOutputTransformOutput, Error>)
  {true}

  method UpdateItemOutputTransform(config: InternalConfig, input: UpdateItemOutputTransformInput)
    returns (output: Result<UpdateItemOutputTransformOutput, Error>)
    ensures output.Success? && output.value.transformedOutput == input.sdkOutput
  {
    return Success(UpdateItemOutputTransformOutput(transformedOutput := input.sdkOutput));
  }

  predicate BatchWriteItemInputTransformEnsuresPublicly(input: BatchWriteItemInputTransformInput, output: Result<BatchWriteItemInputTransformOutput, Error>)
  {true}

  method BatchWriteItemInputTransform(config: InternalConfig, input: BatchWriteItemInputTransformInput)
    returns (output: Result<BatchWriteItemInputTransformOutput, Error>)
    ensures output.Success? ==>
      && (input.sdkInput.RequestItems.Keys == output.value.transformedInput.RequestItems.Keys)
      && forall k <- input.sdkInput.RequestItems.Keys ::
        |input.sdkInput.RequestItems[k]| == |output.value.transformedInput.RequestItems[k]|
  {
    var tableNames := input.sdkInput.RequestItems.Keys;
    var result : map<DDB.TableName, DDB.WriteRequests> := map[];
    while tableNames != {}
      decreases |tableNames|
      invariant tableNames <= input.sdkInput.RequestItems.Keys
      invariant result.Keys + tableNames == input.sdkInput.RequestItems.Keys
      invariant forall k <- result.Keys ::
        |input.sdkInput.RequestItems[k]| == |result[k]|
    {
      var tableName :| tableName in tableNames;
      tableNames := tableNames - { tableName };
      var writeRequests : DDB.WriteRequests := input.sdkInput.RequestItems[tableName];
      if tableName in config.tableEncryptionConfigs {
        var tableConfig := config.tableEncryptionConfigs[tableName];
        var encryptedItems : seq<DDB.WriteRequest> := [];
        for x := 0 to |writeRequests|
          invariant |encryptedItems| == x
        {
          var req : DDB.WriteRequest := writeRequests[x];
          if req.PutRequest.None? {
            // We only transform PutRequests, so no PutRequest ==> no change
            encryptedItems := encryptedItems + [req];
          } else {
            //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#encrypt-before-batchwriteitem
            //# For each `PutRequest` under each key in `RequestItems`,
            //# if there is an Item Encryptor with [DynamoDB Table Name](./ddb-item-encryptor.md#dynamodb-table-name) equal to the key,
            //# that Item Encryptor MUST perform [Encrypt Item](./encrypt-item.md) where the input
            //# [DynamoDB Item](./encrypt-item.md#dynamodb-item) is the `Item` field in this `PutRequest`
            var encryptRes := tableConfig.itemEncryptor.EncryptItem(EncTypes.EncryptItemInput(plaintextItem:=req.PutRequest.value.Item));

            //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#encrypt-before-batchwriteitem
            //# If any [Encrypt Item](./encrypt-item.md) fails,
            //# the client MUST NOT make a network call to DynamoDB,
            //# and BatchWriteItem MUST yield an error.
            var encrypted :- MapError(encryptRes);

            //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#encrypt-before-batchwriteitem
            //# The `Item` field in this `PutRequest` MUST be replaced
            //# with a value that is equivalent to
            //# the result [Encrypted DynamoDB Item](./encrypt-item.md#encrypted-dynamodb-item).
            // We only transform PutRequests, so leave the rest of original request alone
            encryptedItems := encryptedItems + [req.(PutRequest := Some(DDB.PutRequest(Item := encrypted.encryptedItem)))];
          }
        }
        assert |encryptedItems| == |input.sdkInput.RequestItems[tableName]|;
        result := result[tableName := encryptedItems];
      } else {
        // If table not configured with encryption, do not transform requests for that table
        result := result[tableName := writeRequests];
      }
    }
    var finalResult := result; // TODO we need to redeclare this in a "final" var until we upgrade to Dafny 3.10.0
    return Success(BatchWriteItemInputTransformOutput(transformedInput := input.sdkInput.(RequestItems := finalResult)));
  }

  predicate BatchWriteItemOutputTransformEnsuresPublicly(input: BatchWriteItemOutputTransformInput, output: Result<BatchWriteItemOutputTransformOutput, Error>)
  {true}

  method BatchWriteItemOutputTransform(config: InternalConfig, input: BatchWriteItemOutputTransformInput)
    returns (output: Result<BatchWriteItemOutputTransformOutput, Error>)
    ensures output.Success? && output.value.transformedOutput == input.sdkOutput
  {
    var finalResult := input.sdkOutput; // TODO we need to redeclare this in a "final" var until we upgrade to Dafny 3.10.0
    return Success(BatchWriteItemOutputTransformOutput(transformedOutput := finalResult));
  }

  predicate TransactWriteItemsInputTransformEnsuresPublicly(input: TransactWriteItemsInputTransformInput, output: Result<TransactWriteItemsInputTransformOutput, Error>)
  {true}

  function ExpectedEncryptCount(max : nat, table : string, config: InternalConfig, input: TransactWriteItemsInputTransformInput) : nat
    requires max <= |input.sdkInput.TransactItems|
  {
    |set x <- input.sdkInput.TransactItems[0..max] ::
      (x.Put.Some? && x.Put.value.TableName in config.tableEncryptionConfigs && x.Put.value.TableName == table)|
  }

  method TransactWriteItemsInputTransform(config: InternalConfig, input: TransactWriteItemsInputTransformInput)
    returns (output: Result<TransactWriteItemsInputTransformOutput, Error>)

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

  predicate TransactWriteItemsOutputTransformEnsuresPublicly(input: TransactWriteItemsOutputTransformInput, output: Result<TransactWriteItemsOutputTransformOutput, Error>)
  {true}

  method TransactWriteItemsOutputTransform(config: InternalConfig, input: TransactWriteItemsOutputTransformInput)
    returns (output: Result<TransactWriteItemsOutputTransformOutput, Error>)
    ensures output.Success? && output.value.transformedOutput == input.sdkOutput
  {
    var finalResult := input.sdkOutput;
    return Success(TransactWriteItemsOutputTransformOutput(transformedOutput := finalResult));
  }

  predicate BatchGetItemInputTransformEnsuresPublicly(input: BatchGetItemInputTransformInput, output: Result<BatchGetItemInputTransformOutput, Error>)
  {true}

  method BatchGetItemInputTransform(config: InternalConfig, input: BatchGetItemInputTransformInput)
    returns (output: Result<BatchGetItemInputTransformOutput, Error>)
    ensures output.Success? && output.value.transformedInput == input.sdkInput
  {
    return Success(BatchGetItemInputTransformOutput(transformedInput := input.sdkInput));
  }

  predicate BatchGetItemOutputTransformEnsuresPublicly(input: BatchGetItemOutputTransformInput, output: Result<BatchGetItemOutputTransformOutput, Error>)
  {true}

  method BatchGetItemOutputTransform(config: InternalConfig, input: BatchGetItemOutputTransformInput)
    returns (output: Result<BatchGetItemOutputTransformOutput, Error>)
    ensures output.Success? ==> SameOption(input.sdkOutput.Responses, output.value.transformedOutput.Responses)
    ensures output.Success? && input.sdkOutput.Responses.Some? ==>
      && output.value.transformedOutput.Responses.Some?
      && input.sdkOutput.Responses.value.Keys == output.value.transformedOutput.Responses.value.Keys
  {
    if input.sdkOutput.Responses.None? {
      return Success(BatchGetItemOutputTransformOutput(transformedOutput := input.sdkOutput));
    }
    var tableNames := input.sdkOutput.Responses.value.Keys;
    var result := map[];
    while tableNames != {}
      decreases |tableNames|
      invariant tableNames <= input.sdkOutput.Responses.value.Keys
      invariant result.Keys + tableNames == input.sdkOutput.Responses.value.Keys
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
          //# Each of these items on the original repsonse MUST be replaced
          //# with a value that is equivalent to
          //# the resulting decrypted [DynamoDB Item](./decrypt-item.md#dynamodb-item-1).
          decryptedItem := decryptedItem + [decrypted.plaintextItem];
        }
        result := result + map[tableName := decryptedItem];
      } else {
        result := result + map[tableName := responses];
      }
    }
    var someResponses := Some(result); // TODO this needs to be done on its own line until we upgrade to Dafny 3.10.0
    return Success(BatchGetItemOutputTransformOutput(transformedOutput := input.sdkOutput.(Responses := someResponses)));
  }

  predicate ScanInputTransformEnsuresPublicly(input: ScanInputTransformInput, output: Result<ScanInputTransformOutput, Error>)
  {true}

  method ScanInputTransform(config: InternalConfig, input: ScanInputTransformInput)
    returns (output: Result<ScanInputTransformOutput, Error>)
    ensures output.Success? && output.value.transformedInput == input.sdkInput
  {
    return Success(ScanInputTransformOutput(transformedInput := input.sdkInput));
  }

  predicate ScanOutputTransformEnsuresPublicly(input: ScanOutputTransformInput, output: Result<ScanOutputTransformOutput, Error>)
  {true}

  method ScanOutputTransform(config: InternalConfig, input: ScanOutputTransformInput)
    returns (output: Result<ScanOutputTransformOutput, Error>)

    ensures input.originalInput.TableName !in config.tableEncryptionConfigs || input.sdkOutput.ItemList.None? ==>
      && output.Success?
      && output.value.transformedOutput == input.sdkOutput

    ensures output.Success?  && input.sdkOutput.ItemList.None?  ==> output.value.transformedOutput.ItemList.None?
    ensures output.Success?  && input.sdkOutput.ItemList.Some?  ==>
      && output.value.transformedOutput.ItemList.Some?
      && |output.value.transformedOutput.ItemList.value| == |input.sdkOutput.ItemList.value|

    ensures output.Success? && input.sdkOutput.ItemList.Some? && input.originalInput.TableName in config.tableEncryptionConfigs ==>
      var oldHistory := old(config.tableEncryptionConfigs[input.originalInput.TableName].itemEncryptor.History.DecryptItem);
      var newHistory := config.tableEncryptionConfigs[input.originalInput.TableName].itemEncryptor.History.DecryptItem;
      && (|newHistory| == |oldHistory| + |input.sdkOutput.ItemList.value|)

      && (forall i : nat | |oldHistory| <= i < |input.sdkOutput.ItemList.value| + |oldHistory| ::

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
          && newHistory[i].input.encryptedItem == input.sdkOutput.ItemList.value[i-|oldHistory|]

          //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#decrypt-after-scan
          //= type=implication
          //# Each of these entries on the original repsonse MUST be replaced
          //# with the resulting decrypted
          //# [DynamoDB Item](./decrypt-item.md#dynamodb-item-1).
          && newHistory[i].output.value.plaintextItem ==
              output.value.transformedOutput.ItemList.value[i-|oldHistory|]
        )
  {
    var tableName := input.originalInput.TableName;
    if tableName !in config.tableEncryptionConfigs || input.sdkOutput.ItemList.None? {
      return Success(ScanOutputTransformOutput(transformedOutput := input.sdkOutput));
    }
    var tableConfig := config.tableEncryptionConfigs[tableName];
    var decryptedItems : DDB.ItemList := [];
    var encryptedItems := input.sdkOutput.ItemList.value;
    ghost var historySize := |tableConfig.itemEncryptor.History.DecryptItem|;
    for x := 0 to |encryptedItems|
      invariant |decryptedItems| == x
      invariant
        && (|tableConfig.itemEncryptor.History.DecryptItem| ==
            |old(tableConfig.itemEncryptor.History.DecryptItem)| + |decryptedItems|)

      invariant (forall i : nat | historySize <= i < |decryptedItems|+historySize ::
        var item := tableConfig.itemEncryptor.History.DecryptItem[i];
        && item.output.Success?
        && item.input.encryptedItem == input.sdkOutput.ItemList.value[i-historySize]
        && item.output.value.plaintextItem == decryptedItems[i-historySize])
    {
      var decryptRes := tableConfig.itemEncryptor.DecryptItem(EncTypes.DecryptItemInput(encryptedItem:=encryptedItems[x]));
      var decrypted :- MapError(decryptRes);
      decryptedItems := decryptedItems + [decrypted.plaintextItem];
    }
    var finalResult := decryptedItems; // TODO we need to redeclare this in a "final" var until we upgrade to Dafny 3.10.0
    return Success(ScanOutputTransformOutput(transformedOutput := input.sdkOutput.(ItemList := Some(finalResult))));
  }

  predicate QueryInputTransformEnsuresPublicly(input: QueryInputTransformInput, output: Result<QueryInputTransformOutput, Error>)
  {true}

  method QueryInputTransform(config: InternalConfig, input: QueryInputTransformInput)
    returns (output: Result<QueryInputTransformOutput, Error>)
    ensures output.Success? && output.value.transformedInput == input.sdkInput
  {
    return Success(QueryInputTransformOutput(transformedInput := input.sdkInput));
  }

  predicate QueryOutputTransformEnsuresPublicly(input: QueryOutputTransformInput, output: Result<QueryOutputTransformOutput, Error>)
  {true}

  method QueryOutputTransform(config: InternalConfig, input: QueryOutputTransformInput)
    returns (output: Result<QueryOutputTransformOutput, Error>)

    ensures input.originalInput.TableName !in config.tableEncryptionConfigs || input.sdkOutput.ItemList.None? ==>
      && output.Success?
      && output.value.transformedOutput == input.sdkOutput

    ensures output.Success?  && input.sdkOutput.ItemList.Some?  ==>
      && output.value.transformedOutput.ItemList.Some?
      && |output.value.transformedOutput.ItemList.value| == |input.sdkOutput.ItemList.value|

    ensures output.Success?  && input.sdkOutput.ItemList.None?  ==>
      && output.value.transformedOutput.ItemList.None?

    ensures output.Success? && input.sdkOutput.ItemList.Some? && input.originalInput.TableName in config.tableEncryptionConfigs ==>
      var oldHistory := old(config.tableEncryptionConfigs[input.originalInput.TableName].itemEncryptor.History.DecryptItem);
      var newHistory := config.tableEncryptionConfigs[input.originalInput.TableName].itemEncryptor.History.DecryptItem;

      && (|newHistory| == |oldHistory| + |input.sdkOutput.ItemList.value|)

      && (forall i : nat | |oldHistory| <= i < |input.sdkOutput.ItemList.value| + |oldHistory| ::

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
            && newHistory[i].input.encryptedItem == input.sdkOutput.ItemList.value[i-|oldHistory|]

            //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#decrypt-after-query
            //= type=implication
            //# Each of these entries on the original repsonse MUST be replaced
            //# with the resulting decrypted [DynamoDB Item](./decrypt-item.md#dynamodb-item-1).
            && newHistory[i].output.value.plaintextItem ==
               output.value.transformedOutput.ItemList.value[i-|oldHistory|]
         )
  {
    var tableName := input.originalInput.TableName;
    if tableName !in config.tableEncryptionConfigs || input.sdkOutput.ItemList.None? {
      return Success(QueryOutputTransformOutput(transformedOutput := input.sdkOutput));
    }
    var tableConfig := config.tableEncryptionConfigs[tableName];
    var decryptedItems : DDB.ItemList := [];
    var encryptedItems := input.sdkOutput.ItemList.value;
    ghost var historySize := |tableConfig.itemEncryptor.History.DecryptItem|;
    for x := 0 to |encryptedItems|
      invariant |decryptedItems| == x

      invariant
        && (|tableConfig.itemEncryptor.History.DecryptItem| ==
            |old(tableConfig.itemEncryptor.History.DecryptItem)| + |decryptedItems|)

      invariant (forall i : nat | historySize <= i < |decryptedItems|+historySize ::
        var item := tableConfig.itemEncryptor.History.DecryptItem[i];
        && item.output.Success?
        && item.input.encryptedItem == input.sdkOutput.ItemList.value[i-historySize]
        && item.output.value.plaintextItem == decryptedItems[i-historySize])
    {
      var decryptRes := tableConfig.itemEncryptor.DecryptItem(EncTypes.DecryptItemInput(encryptedItem:=encryptedItems[x]));
      var decrypted :- MapError(decryptRes);
      decryptedItems := decryptedItems + [decrypted.plaintextItem];
    }
    var someItems := Some(decryptedItems); // TODO this needs to be done on its own line until we upgrade to Dafny 3.10.0
    return Success(QueryOutputTransformOutput(transformedOutput := input.sdkOutput.(ItemList := someItems)));
  }

  predicate TransactGetItemsInputTransformEnsuresPublicly(input: TransactGetItemsInputTransformInput, output: Result<TransactGetItemsInputTransformOutput, Error>)
  {true}

  method TransactGetItemsInputTransform(config: InternalConfig, input: TransactGetItemsInputTransformInput)
    returns (output: Result<TransactGetItemsInputTransformOutput, Error>)
    ensures output.Success? && output.value.transformedInput == input.sdkInput
  {
    return Success(TransactGetItemsInputTransformOutput(transformedInput := input.sdkInput));
  }

  predicate TransactGetItemsOutputTransformEnsuresPublicly(input: TransactGetItemsOutputTransformInput, output: Result<TransactGetItemsOutputTransformOutput, Error>)
  {true}

  method TransactGetItemsOutputTransform(config: InternalConfig, input: TransactGetItemsOutputTransformInput)
    returns (output: Result<TransactGetItemsOutputTransformOutput, Error>)

    ensures input.sdkOutput.Responses.None? ==>
      && output.Success?
      && output.value.transformedOutput == input.sdkOutput

    ensures output.Success? && input.sdkOutput.Responses.Some? ==>
      && output.value.transformedOutput.Responses.Some?
      && |output.value.transformedOutput.Responses.value| == |input.originalInput.TransactItems|
  {
    if input.sdkOutput.Responses.None? {
      return Success(TransactGetItemsOutputTransformOutput(transformedOutput := input.sdkOutput));
    }
    if |input.sdkOutput.Responses.value| != |input.originalInput.TransactItems| {
      return MakeError("Invalid TransactGetItems response for original request: Number of items returned must equal number of items requested.");
    }
    var decryptedItems : seq<DDB.ItemResponse> := [];
    var encryptedItems := input.sdkOutput.Responses.value;
    for x := 0 to |encryptedItems|
      invariant |decryptedItems| == x
    {
      var tableName := input.originalInput.TransactItems[x].Get.TableName;
      if tableName !in config.tableEncryptionConfigs {
        decryptedItems := decryptedItems + [encryptedItems[x]];
      } else {
        var tableConfig := config.tableEncryptionConfigs[tableName];
        if encryptedItems[x].Item.None? {
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
          //# [DynamoDB Item](./decrypt-item.md#dynamodb-item) is the `Item` in the original response
          var decryptRes := tableConfig.itemEncryptor.DecryptItem(EncTypes.DecryptItemInput(encryptedItem:=encryptedItems[x].Item.value));

          //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#decrypt-after-transactgetitems
          //# If any [Decrypt Item](./decrypt-item.md) fails,
          //# TransactGetItems MUST yield an error.
          var decrypted :- MapError(decryptRes);

          //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#decrypt-after-transactgetitems
          //# Each of these items on the original repsonse MUST be replaced
          //# with a value that is equivalent to
          //# the result [DynamoDB Item](./decrypt-item.md#dynamodb-item-1).
          decryptedItems := decryptedItems + [DDB.ItemResponse(Item := Some(decrypted.plaintextItem))];
        }
      }
    }
    var someItems := Some(decryptedItems); // TODO this needs to be done on its own line until we upgrade to Dafny 3.10.0
    return Success(TransactGetItemsOutputTransformOutput(transformedOutput := input.sdkOutput.(Responses := someItems)));
  }

  predicate DeleteItemInputTransformEnsuresPublicly(input: DeleteItemInputTransformInput, output: Result<DeleteItemInputTransformOutput, Error>)
  {true}

  method DeleteItemInputTransform(config: InternalConfig, input: DeleteItemInputTransformInput)
    returns (output: Result<DeleteItemInputTransformOutput, Error>)

    //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#validate-before-deleteitem
      //= type=implication
      //# Before a [DeleteItem](https://docs.aws.amazon.com/amazondynamodb/latest/APIReference/API_DeleteItem.html)
      //# call is made to DynamoDB,
      //# the request MUST fail, and the client make no network call to DynamoDB,
      //# if the request specifies a `ConditionExpression`,
      //# and there exists an Item Encryptor specified
      //# within the [DynamoDB Encryption Client Config](#dynamodb-encryption-client-configuration)
      //# with a [DynamoDB Table Name](./ddb-item-encryptor.md#dynamodb-table-name)
      //# equal to `TableName` in the request.
      ensures
        && input.sdkInput.TableName in config.tableEncryptionConfigs
        && (input.sdkInput.ConditionExpression.Some? || input.sdkInput.ConditionalOperator.Some?)
        ==> output.Failure?

      //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#validate-before-deleteitem
      //= type=implication
      //# Otherwise, there MUST NOT be any modification
      //# to the UpdateItem request.
      ensures
        || input.sdkInput.TableName !in config.tableEncryptionConfigs
        || (input.sdkInput.ConditionExpression.None? && input.sdkInput.ConditionalOperator.None?)
        ==>
        && output.Success?
        && output.value.transformedInput == input.sdkInput

  {
    if input.sdkInput.TableName !in config.tableEncryptionConfigs {
      return Success(DeleteItemInputTransformOutput(transformedInput := input.sdkInput));
    }
    if input.sdkInput.ConditionExpression.Some? || input.sdkInput.ConditionalOperator.Some? {
      return MakeError("Condition Expressions not supported in DeleteItem with Encryption.");
    }
    return Success(DeleteItemInputTransformOutput(transformedInput := input.sdkInput));
  }

  predicate DeleteItemOutputTransformEnsuresPublicly(input: DeleteItemOutputTransformInput, output: Result<DeleteItemOutputTransformOutput, Error>)
  {true}

  method DeleteItemOutputTransform(config: InternalConfig, input: DeleteItemOutputTransformInput)
    returns (output: Result<DeleteItemOutputTransformOutput, Error>)
    ensures output.Success? && output.value.transformedOutput == input.sdkOutput
  {
    return Success(DeleteItemOutputTransformOutput(transformedOutput := input.sdkOutput));
  }

  predicate ExecuteStatementInputTransformEnsuresPublicly(input: ExecuteStatementInputTransformInput, output: Result<ExecuteStatementInputTransformOutput, Error>)
  {true}

  method ExecuteStatementInputTransform(config: InternalConfig, input: ExecuteStatementInputTransformInput)
    returns (output: Result<ExecuteStatementInputTransformOutput, Error>)

    //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#validate-before-executestatement
    //= type=implication
    //# The request MUST fail, and the client make no network call to DynamoDB,
    //# if there exists an Item Encryptor
    //# specified within the [DynamoDB Encryption Client Config](#dynamodb-encryption-client-configuration)
    //# with a [DynamoDB Table Name](./ddb-item-encryptor.md#dynamodb-table-name)
    //# equal to table named in the request.
    ensures var statement := DdbStatement.TableFromStatement(input.sdkInput.Statement);
      statement.Failure? || statement.value in config.tableEncryptionConfigs ==> output.Failure?

    //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#validate-before-executestatement
    //= type=implication
    //# If no such Item Encryptor exists,
    //# there MUST NOT be any modification
    //# to the ExecuteStatement request.
    ensures var statement :=  DdbStatement.TableFromStatement(input.sdkInput.Statement);
      statement.Success? && statement.value !in config.tableEncryptionConfigs
        ==> output.Success? && output.value.transformedInput == input.sdkInput
  {
    var tableName :- MapString(DdbStatement.TableFromStatement(input.sdkInput.Statement));
    if tableName in config.tableEncryptionConfigs {
      return MakeError("ExecuteStatement not Supported on encrypted tables.");
    } else {
      return Success(ExecuteStatementInputTransformOutput(transformedInput := input.sdkInput));
    }
  }

  predicate ExecuteStatementOutputTransformEnsuresPublicly(input: ExecuteStatementOutputTransformInput, output: Result<ExecuteStatementOutputTransformOutput, Error>)
  {true}

  method ExecuteStatementOutputTransform(config: InternalConfig, input: ExecuteStatementOutputTransformInput)
    returns (output: Result<ExecuteStatementOutputTransformOutput, Error>)
    ensures output.Success? && output.value.transformedOutput == input.sdkOutput
  {
    return Success(ExecuteStatementOutputTransformOutput(transformedOutput := input.sdkOutput));
  }
  predicate BatchExecuteStatementInputTransformEnsuresPublicly(input: BatchExecuteStatementInputTransformInput, output: Result<BatchExecuteStatementInputTransformOutput, Error>)
  {true}

  method BatchExecuteStatementInputTransform(config: InternalConfig, input: BatchExecuteStatementInputTransformInput)
    returns (output: Result<BatchExecuteStatementInputTransformOutput, Error>)

    //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#validate-before-batchexecutestatement
    //= type=implication
    //# The request MUST fail, and the client make no network call to DynamoDB,
    //# if there exists an Item Encryptor
    //# specified within the [DynamoDB Encryption Client Config](#dynamodb-encryption-client-configuration)
    //# with a [DynamoDB Table Name](./ddb-item-encryptor.md#dynamodb-table-name)
    //# equal to table named in any of the `Statements` of the request.
    ensures output.Success? ==>
      forall i : nat | 0 <= i < |input.sdkInput.Statements| ::
        var statement := DdbStatement.TableFromStatement(input.sdkInput.Statements[i].Statement);
        && statement.Success?
        && statement.value
          !in config.tableEncryptionConfigs

    //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#validate-before-batchexecutestatement
    //= type=implication
    //# If no such Item Encryptor exists,
    //# there MUST NOT be any modification
    //# to the BatchExecuteStatement request.
    ensures output.Success? ==> output.value.transformedInput == input.sdkInput
  {
    for i := 0 to |input.sdkInput.Statements|
      invariant forall x : nat | 0 <= x < i ::
        var statement := DdbStatement.TableFromStatement(input.sdkInput.Statements[x].Statement);
        && statement.Success?
        && statement.value
          !in config.tableEncryptionConfigs;
    {
      var statement := input.sdkInput.Statements[i].Statement;
      var tableName :- MapString(DdbStatement.TableFromStatement(statement));
      if tableName in config.tableEncryptionConfigs {
        return MakeError("BatchExecuteStatement not Supported on encrypted tables.");
      }
    }
    return Success(BatchExecuteStatementInputTransformOutput(transformedInput := input.sdkInput));
  }

  predicate BatchExecuteStatementOutputTransformEnsuresPublicly(input: BatchExecuteStatementOutputTransformInput, output: Result<BatchExecuteStatementOutputTransformOutput, Error>)
  {true}

  method BatchExecuteStatementOutputTransform(config: InternalConfig, input: BatchExecuteStatementOutputTransformInput)
    returns (output: Result<BatchExecuteStatementOutputTransformOutput, Error>)
    ensures output.Success? && output.value.transformedOutput == input.sdkOutput
  {
    return Success(BatchExecuteStatementOutputTransformOutput(transformedOutput := input.sdkOutput));
  }

  predicate ExecuteTransactionInputTransformEnsuresPublicly(input: ExecuteTransactionInputTransformInput, output: Result<ExecuteTransactionInputTransformOutput, Error>)
  {true}

  method ExecuteTransactionInputTransform(config: InternalConfig, input: ExecuteTransactionInputTransformInput)
    returns (output: Result<ExecuteTransactionInputTransformOutput, Error>)

    //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#validate-before-executetransaction
    //= type=implication
    //# The request MUST fail, and the client make no network call to DynamoDB,
    //# if there exists an Item Encryptor
    //# specified within the [DynamoDB Encryption Client Config](#dynamodb-encryption-client-configuration)
    //# with a [DynamoDB Table Name](./ddb-item-encryptor.md#dynamodb-table-name)
    //# equal to table named in any of the `TransactStatements` of the request.
    ensures output.Success? ==>
      forall i : nat | 0 <= i < |input.sdkInput.TransactStatements| ::
        var statement := DdbStatement.TableFromStatement(input.sdkInput.TransactStatements[i].Statement);
        statement.Success? && statement.value !in config.tableEncryptionConfigs

    //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#validate-before-executetransaction
    //= type=implication
    //# If no such Item Encryptor exists,
    //# there MUST NOT be any modification
    //# to the ExecuteTransaction request.
    ensures output.Success? ==> output.value.transformedInput == input.sdkInput
  {
    for i := 0 to |input.sdkInput.TransactStatements|
      invariant forall x : nat | 0 <= x < i ::
        var statement := DdbStatement.TableFromStatement(input.sdkInput.TransactStatements[x].Statement);
        statement.Success? && statement.value !in config.tableEncryptionConfigs;
    {
      var statement := input.sdkInput.TransactStatements[i].Statement;
      var tableName :- MapString(DdbStatement.TableFromStatement(statement));
      if tableName in config.tableEncryptionConfigs {
        return MakeError("ExecuteTransaction not Supported on encrypted tables.");
      }
    }
    return Success(ExecuteTransactionInputTransformOutput(transformedInput := input.sdkInput));
  }

  predicate ExecuteTransactionOutputTransformEnsuresPublicly(input: ExecuteTransactionOutputTransformInput, output: Result<ExecuteTransactionOutputTransformOutput, Error>)
  {true}

  method ExecuteTransactionOutputTransform(config: InternalConfig, input: ExecuteTransactionOutputTransformInput)
    returns (output: Result<ExecuteTransactionOutputTransformOutput, Error>)
    ensures output.Success? && output.value.transformedOutput == input.sdkOutput
  {
    return Success(ExecuteTransactionOutputTransformOutput(transformedOutput := input.sdkOutput));
  }
}
