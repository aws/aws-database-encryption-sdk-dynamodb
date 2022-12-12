// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../Model/AwsCryptographyDynamoDbItemEncryptorTypes.dfy"
include "DynamoToStruct.dfy"

module AwsCryptographyDynamoDbItemEncryptorOperations refines AbstractAwsCryptographyDynamoDbItemEncryptorOperations {
  import ComAmazonawsDynamodbTypes
  import AwsCryptographyMaterialProvidersTypes
  import StructuredEncryption
  import DynamoToStruct
  import Base64
  import opened StandardLibrary
  import Seq

  datatype Config = Config(
    nameonly tableName: ComAmazonawsDynamodbTypes.TableName,
    nameonly partitionKeyName: ComAmazonawsDynamodbTypes.KeySchemaAttributeName,
    nameonly sortKeyName: Option<ComAmazonawsDynamodbTypes.KeySchemaAttributeName>,
    nameonly cmm: AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsManager,
    nameonly attributeActions: AttributeActions,
    nameonly allowedUnauthenticatedAttributes: Option<ComAmazonawsDynamodbTypes.AttributeNameList>,
    nameonly allowedUnauthenticatedAttributePrefix: Option<string>,
    nameonly structuredEncryption: StructuredEncryption.StructuredEncryptionClient
    // TODO algorithmSuite
    // TODO legacy encryptor
    // TODO legacy schema
  )

  type InternalConfig = Config

  // Encode ASCII as UTF8 in a function, to allow use in ensures clause
  function method {:opaque} EncodeAscii(s : string) : (ret : ValidUTF8Bytes)
    requires IsASCIIString(s)
    ensures |s| == |ret|
    ensures forall i | 0 <= i < |s| :: s[i] as uint8 == ret[i]
  {
    if |s| == 0 then
      []
    else
      var x := [s[0] as uint8];
      assert ValidUTF8Seq(x);
      ValidUTF8Concat(x, EncodeAscii(s[1..]));
      x + EncodeAscii(s[1..])
  }

  // if ascii strings are different, their encoding is also unique
  lemma EncodeAsciiUnique2(x : string, y : string)
    requires IsASCIIString(x) && IsASCIIString(y)
    requires x != y
    ensures EncodeAscii(x) != EncodeAscii(y)
  {
    reveal EncodeAscii();
    if EncodeAscii(x) == EncodeAscii(y) {
      if |EncodeAscii(x)| == 0 && |EncodeAscii(y)| == 0 {
      } else if EncodeAscii(x)[0] == EncodeAscii(y)[0] {
        assert EncodeAscii(x)[1..] != EncodeAscii(y)[1..] by {
          EncodeAsciiUnique2(x[1..], y[1..]);
        }
      } else {
      }
    }
  }

  // if ascii strings are different, their encoding is also unique
  lemma {:opaque} EncodeAsciiUnique()
    ensures forall x : string, y : string :: IsASCIIString(x) && IsASCIIString(y) && x != y ==> EncodeAscii(x) != EncodeAscii(y)
  {
    forall x : string, y : string ensures IsASCIIString(x) && IsASCIIString(y) && x != y ==> EncodeAscii(x) != EncodeAscii(y) {
        if IsASCIIString(x) && IsASCIIString(y) && x != y {
            EncodeAsciiUnique2(x, y);
        }
    }
  }

  // constant attribute names for the encryption context
  const TABLE_NAME : seq<uint8> := EncodeAscii("aws-crypto-table-name");
  const PARTITION_NAME : seq<uint8> := EncodeAscii("aws-crypto-partition-name");
  const PARTITION_VALUE : seq<uint8> := EncodeAscii("aws-crypto-partition-value");
  const SORT_NAME : seq<uint8> := EncodeAscii("aws-crypto-sort-name");
  const SORT_VALUE : seq<uint8> := EncodeAscii("aws-crypto-sort-value");

  // Convince Dafny that a map with these three values does not have other values.
  lemma NoSortKeys(m : map<ValidUTF8Bytes,ValidUTF8Bytes>)
    requires |m| == 3
    requires m.Keys == {TABLE_NAME, PARTITION_NAME, PARTITION_VALUE}
    ensures SORT_NAME !in m
    ensures SORT_VALUE !in m
  {
      EncodeAsciiUnique();
      assert SORT_NAME != TABLE_NAME;
      assert SORT_NAME != PARTITION_NAME;
      assert SORT_NAME != PARTITION_VALUE;
      assert SORT_NAME !in m;
      assert SORT_VALUE != TABLE_NAME;
      assert SORT_VALUE != PARTITION_NAME;
      assert SORT_VALUE != PARTITION_VALUE;
      assert SORT_VALUE !in m;
  }

  // trandform AttributeValue into encoded encryption context value
  function method {:opaque} EncodeValue(val : ComAmazonawsDynamodbTypes.AttributeValue) : Result<ValidUTF8Bytes, string>
  {
    var nValue :- DynamoToStruct.TopLevelAttributeToBytes(val);
    var val64 := Base64.Encode(nValue);
    Success(EncodeAscii(val64))
  }

  // create encryption content from DynamoDB item
  function method {:opaque} MakeEncryptionContextInner(
    config : InternalConfig,
    item : ComAmazonawsDynamodbTypes.AttributeMap)
    : (ret : Result<AwsCryptographyMaterialProvidersTypes.EncryptionContext, string>)

    //= specification/dynamodb-encryption-client/encrypt-item.md#dynamodb-item-base-context
    //= type=implication
    //# The DynamoDB Item Base Context MUST contain:
    //# - the key `TODO:aws-crypto-table-name` with a value equal to the DynamoDB Table Name of the DynamoDB Table
    //#   this item is stored in (or will be stored in).
    //# - the key `TODO:aws-crypto-partition-name` with a value equal to the name of the Partition Key on this item.
    //# - the key `TODO:aws-crypto-partition-value` with a value equal to this item's partition attribute,
    //#   serialized according to [Attribute Value Serialization](./ddb-attribute-serialization.md#attribute-value-serialization)
    //#   and [Base 64 encoded](https://www.rfc-editor.org/rfc/rfc4648).
    //# - If this item has a sort key attribute,
    //#   the key `TODO:aws-crypto-sort-name` with a value equal to the [DynamoDB Sort Key Name](#dynamodb-sort-key-name).
    //# - If this item has a sort key attribute,
    //#   the key `TODO:aws-crypto-sort-value` with a value equal to this item's sort attribute,
    //#   serialized according to [Attribute Value Serialization](./ddb-attribute-serialization.md#attribute-value-serialization)
    //#   and [Base 64 encoded](https://www.rfc-editor.org/rfc/rfc4648).
    ensures ret.Success? ==>
      && TABLE_NAME in ret.value
      && PARTITION_NAME in ret.value
      && PARTITION_VALUE in ret.value

    //= specification/dynamodb-encryption-client/encrypt-item.md#dynamodb-item-base-context
    //= type=implication
    //# If this item does not have a sort key attribute,
    //# the DynamoDB Item Context MUST NOT contain the keys
    //# `TODO:aws-crypto-sort-name` or
    //# `TODO:aws-crypto-sort-value`.
    ensures ret.Success? && config.sortKeyName.None? ==>
      && SORT_NAME !in ret.value
      && SORT_VALUE !in ret.value

    ensures ret.Success? ==> config.sortKeyName.Some? && config.sortKeyName.value !in item ==> ret.Failure?
    ensures ret.Success? ==> config.sortKeyName.None? || (config.sortKeyName.value in item)
    ensures ret.Success? ==> config.partitionKeyName in item
  {
    :- Need(config.partitionKeyName in item, "Partition key " + config.partitionKeyName + " not found in Item to be encrypted or decrypted");
    var tableName :- UTF8.Encode(config.tableName);
    var partitionName :- UTF8.Encode(config.partitionKeyName);
    var partitionValue :- EncodeValue(item[config.partitionKeyName]);
    var retval := map[TABLE_NAME := tableName, PARTITION_NAME := partitionName, PARTITION_VALUE := partitionValue];
    if config.sortKeyName.None? then
      NoSortKeys(retval);
      Success(retval)
    else
      :- Need(config.sortKeyName.value in item, "Sort key " + config.sortKeyName.value + " not found in Item to be encrypted or decrypted");
      var sortName :- UTF8.Encode(config.sortKeyName.value);
      var sortValue :- EncodeValue(item[config.sortKeyName.value]);
      Success(retval + map[SORT_NAME := sortName, SORT_VALUE := sortValue])
  }

  // translate to Error type
  function method MakeEncryptionContext(
    config : InternalConfig,
    item : ComAmazonawsDynamodbTypes.AttributeMap)
    : (ret : Result<AwsCryptographyMaterialProvidersTypes.EncryptionContext, Error>)
    ensures ret.Success? ==> config.sortKeyName.Some? && config.sortKeyName.value !in item ==> ret.Failure?
    ensures ret.Success? ==> config.sortKeyName.None? || config.sortKeyName.value in item
  {
    DynamoToStruct.MapError(MakeEncryptionContextInner(config, item))
  }

  predicate ValidInternalConfig?(config: InternalConfig)
  {
    && config.cmm.ValidState()
    && config.structuredEncryption.ValidState()
    && config.cmm.Modifies !! config.structuredEncryption.Modifies
  }

  function ModifiesInternalConfig(config: InternalConfig) : set<object>
  {
    config.cmm.Modifies
    + config.structuredEncryption.Modifies
  }

  // return proper Crypto Action by name
  function method GetCryptoSchemaActionInner(
    config : InternalConfig,
    attr : ComAmazonawsDynamodbTypes.AttributeName)
    : Result<AwsCryptographyStructuredEncryptionTypes.CryptoAction, string>
  {
    if attr in config.attributeActions then
      Success(config.attributeActions[attr])
    else if config.allowedUnauthenticatedAttributes.Some? && attr in config.allowedUnauthenticatedAttributes.value then
      Success(AwsCryptographyStructuredEncryptionTypes.CryptoAction.DO_NOTHING)
    else if config.allowedUnauthenticatedAttributePrefix.Some? && config.allowedUnauthenticatedAttributePrefix.value <= attr then
      Success(AwsCryptographyStructuredEncryptionTypes.CryptoAction.DO_NOTHING)
    else
      Failure("No Crypto Action configured for attribute " + attr)
  }

  // get Crypto Action and wrap in CryptoSchema
  function method GetCryptoSchemaAction(
    config : InternalConfig,
    attr : ComAmazonawsDynamodbTypes.AttributeName)
    : Result<AwsCryptographyStructuredEncryptionTypes.CryptoSchema, string>
  {
    var action :- GetCryptoSchemaActionInner(config, attr);
    var newElement := AwsCryptographyStructuredEncryptionTypes.CryptoSchemaContent.Action(action);
    Success(AwsCryptographyStructuredEncryptionTypes.CryptoSchema(content := newElement, attributes := None))
  }

  predicate method DoNotSign(config : InternalConfig, attr : ComAmazonawsDynamodbTypes.AttributeName)
  {
    || (config.allowedUnauthenticatedAttributes.Some? && attr in config.allowedUnauthenticatedAttributes.value)
    || (config.allowedUnauthenticatedAttributePrefix.Some? && config.allowedUnauthenticatedAttributePrefix.value <= attr)
  }

  // return proper Authenticate Action by name
  function method GetAuthenticateSchemaActionInner(
    config : InternalConfig,
    attr : ComAmazonawsDynamodbTypes.AttributeName)
    : (ret : Result<AwsCryptographyStructuredEncryptionTypes.AuthenticateAction, string>)

    //= specification/dynamodb-encryption-client/decrypt-item.md#signature-scope
    //= type=implication
    //# An Attribute on a DynamoDB Item MUST NOT be considered as within the signature scope
    //# if it's Attribute Name is included in [Unauthenticated Attributes](./ddb-item-encryptor.md#unauthenticated-attributes)
    //# or if it's Attribute Name begins with the prefix specified in
    //# [Unauthenticated Attribute Prefix](./ddb-item-encryptor.md#unauthenticated-attribute-prefix).

    //= specification/dynamodb-encryption-client/decrypt-item.md#signature-scope
    //= type=implication
    //# Otherwise, Attributes MUST be considered as within the signature scope.
    ensures ret.Success? ==>
      ret.value == AwsCryptographyStructuredEncryptionTypes.AuthenticateAction.DO_NOT_SIGN <==> DoNotSign(config, attr)

    //= specification/dynamodb-encryption-client/decrypt-item.md#signature-scope
    //= type=implication
    //# If an Authenticate Action is configured for an attribute name included in [Unauthenticated Attributes](./ddb-item-encryptor.md#unauthenticated-attributes)
    //# or beginning with the prefix specified in [Unauthenticated Attribute Prefix](./ddb-item-encryptor.md#unauthenticated-attribute-prefix),
    //# this operation MUST yield an error.
    ensures attr in config.attributeActions && DoNotSign(config, attr) ==> ret.Failure?
  {
    if DoNotSign(config, attr) then
      if attr in config.attributeActions then
        Failure("Attribute " + attr + " configured as both SIGN and DO_NOT_SIGN")
      else
        Success(AwsCryptographyStructuredEncryptionTypes.AuthenticateAction.DO_NOT_SIGN)
    else
      Success(AwsCryptographyStructuredEncryptionTypes.AuthenticateAction.SIGN)
  }

  // get Authenticate Action and wrap in AuthenticateSchema
  function method GetAuthenticateSchemaAction(
    config : InternalConfig,
    attr : ComAmazonawsDynamodbTypes.AttributeName)
    : Result<AwsCryptographyStructuredEncryptionTypes.AuthenticateSchema, string>
  {
    var newElement :- GetAuthenticateSchemaActionInner(config, attr);
    var newElement := AwsCryptographyStructuredEncryptionTypes.AuthenticateSchemaContent.Action(newElement);
    Success(AwsCryptographyStructuredEncryptionTypes.AuthenticateSchema(content := newElement, attributes := None))
  }

  // get CryptoSchema for this item
  function method ConfigToCryptoSchema(
    config : InternalConfig,
    item : ComAmazonawsDynamodbTypes.AttributeMap)
    : (ret : Result<AwsCryptographyStructuredEncryptionTypes.CryptoSchema, Error>)

    //= specification/dynamodb-encryption-client/encrypt-item.md#behavior
    //= type=implication
    //# The [Attributes Actions](./ddb-item-encryptor.md#attribute-actions)
    //# configured on this Item Encryptor MUST specify a Crypto Action
    //# for every attribute in the [input DynamoDB Item](#dynamodb-item)
    //# (Attribute Actions MAY specify a Crypto Action for an attribute not
    //# in the input DynamoDB Item).

    //= specification/dynamodb-encryption-client/encrypt-item.md#behavior
    //= type=implication
    //# - For every attribute on the input Item,
    //# there MUST exist a Crypto Action in the Crypto Schema
    //# such that the Crypto Action indexed by that attribute name in the Crypto Schema
    //# equals the Crypto Action indexed by that attribute name in the configured Attribute Actions.

    //= specification/dynamodb-encryption-client/encrypt-item.md#behavior
    //= type=implication
    //# - The Crypto Schema MUST NOT contain more Crypto Actions than those specified by the previous point.

    ensures ret.Success? ==> ret.value.content.SchemaMap? && item.Keys == ret.value.content.CryptoSchemaMap.Keys
  {
    var schema := map kv <- item.Items | true :: kv.0 := GetCryptoSchemaAction(config, kv.0);
    DynamoToStruct.MapKeysMatchItems(item);
    var theMap :- DynamoToStruct.MapError(DynamoToStruct.SimplifyMapValue(schema));
    var theMap := AwsCryptographyStructuredEncryptionTypes.CryptoSchemaContent.SchemaMap(theMap);
    var theMap := AwsCryptographyStructuredEncryptionTypes.CryptoSchema(content := theMap, attributes := None);
    Success(theMap)
  }

  // get AuthenticateSchema for this item
  function method ConfigToAuthenticateSchema(
    config : InternalConfig,
    item : ComAmazonawsDynamodbTypes.AttributeMap)
    : (ret : Result<AwsCryptographyStructuredEncryptionTypes.AuthenticateSchema, Error>)

    //= specification/dynamodb-encryption-client/decrypt-item.md#behavior
    //= type=implication
    //# - For every Attribute in the [input DynamoDB Item](#dynamodb-item)
    //# that is in the [signature scope](#signature-scope),
    //# there MUST exist a [SIGN Authenticate Action](../structured-encryption/structures.md#sign)
    //# in the Authenticate Schema,
    //# string indexed at the top level by that attribute name.

    //= specification/dynamodb-encryption-client/decrypt-item.md#behavior
    //= type=implication
    //# - For every Attribute in the [input DynamoDB Item](#dynamodb-item)
    //# that is not in the [signature scope](#signature-scope),
    //# there MUST exist a [DO_NOT_SIGN Authenticate Action](../structured-encryption/structures.md#do_not_sign)
    //# in the Authenticate Schema,
    //# string indexed at the top level by that attribute name.

    //= specification/dynamodb-encryption-client/decrypt-item.md#behavior
    //= type=implication
    //# - The number of Authenticate Actions in the Authenticate Schema
    //# MUST EQUAL the number of Attributes on the [input DynamoDB Item](#dynamodb-item).
    ensures ret.Success? ==> ret.value.content.SchemaMap? && item.Keys == ret.value.content.AuthenticateSchemaMap.Keys
  {
    var schema := map kv <- item.Items | true :: kv.0 := GetAuthenticateSchemaAction(config, kv.0);
    DynamoToStruct.MapKeysMatchItems(item);
    var theMap :- DynamoToStruct.MapError(DynamoToStruct.SimplifyMapValue(schema));
    var theMap := AwsCryptographyStructuredEncryptionTypes.AuthenticateSchemaContent.SchemaMap(theMap);
    var theMap := AwsCryptographyStructuredEncryptionTypes.AuthenticateSchema(content := theMap, attributes := None);
    Success(theMap)
  }

  function method GetMessage(err : AwsCryptographyStructuredEncryptionTypes.Error) : string {
    match err {
      case StructuredEncryptionException(m) => m
      case _ => "Encryption Error"
    }
  }

  predicate EncryptItemEnsuresPublicly(input: EncryptItemInput, output: Result<EncryptItemOutput, Error>)
  {true}

  // public Encrypt method
  method EncryptItem(config: InternalConfig, input: EncryptItemInput)
    returns (output: Result<EncryptItemOutput, Error>)
    //= specification/dynamodb-encryption-client/encrypt-item.md#dynamodb-item
    //= type=implication
    //# This item MUST include an Attribute with a name that matches the
    //# [DynamoDB Partition Key Name](./ddb-item-encryptor.md#dynamodb-partition-key-name)
    //# configured on the [DynamoDB Item Encryptor](./ddb-item-encryptor.md).
    ensures output.Success? ==> config.partitionKeyName in input.plaintextItem

    //= specification/dynamodb-encryption-client/encrypt-item.md#dynamodb-item
    //= type=implication
    //# Otherwise this operation MUST yield an error.
    ensures config.partitionKeyName !in input.plaintextItem ==> output.Failure?

    //= specification/dynamodb-encryption-client/encrypt-item.md#dynamodb-item
    //= type=implication
    //# If the [DynamoDB Item Encryptor](./ddb-item-encryptor.md)
    //# has a [DynamoDB Sort Key Name](./ddb-item-encryptor.md#dynamodb-sort-key-name) configured,
    //# this item MUST include an Attribute with that name.
    ensures output.Success? ==> (config.sortKeyName.None? || config.sortKeyName.value in input.plaintextItem)

    // Otherwise this operation MUST yield an error.
    ensures config.sortKeyName.Some? && config.sortKeyName.value !in input.plaintextItem ==> output.Failure?

    ensures output.Success? ==>
      //= specification/dynamodb-encryption-client/encrypt-item.md#behavior
      //= type=implication
      //# Given the converted [Structured Data](../structured-encryption/structures.md#structured-data),
      //# this operation MUST delegate encryption of this data to
      //# Structured Encryption Client's [Encrypt Structure](../structured-encryption/encrypt-structure.md),
      //# with the following inputs:
      && (|config.structuredEncryption.History.EncryptStructure| == |old(config.structuredEncryption.History.EncryptStructure)| + 1)
      && (Seq.Last(config.structuredEncryption.History.EncryptStructure).output.Success?)

      //= specification/dynamodb-encryption-client/encrypt-item.md#behavior
      //= type=implication
      //# - Crypto Schema MUST be a [Crypto Schema](../structured-encryption/structures.md#crypto-schema)
      //# analogous to the [configured Attribute Actions](./ddb-item-encryptor.md#attribute-actions).
      && ConfigToCryptoSchema(config, input.plaintextItem).Success?
      && Seq.Last(config.structuredEncryption.History.EncryptStructure).input.cryptoSchema
        == ConfigToCryptoSchema(config, input.plaintextItem).value
      && DynamoToStruct.ItemToStructured(input.plaintextItem).Success?

      //= specification/dynamodb-encryption-client/encrypt-item.md#behavior
      //= type=implication
      //# - Structured Data MUST be the Structured Data converted above.
      && Seq.Last(config.structuredEncryption.History.EncryptStructure).input.plaintextStructure
        == AwsCryptographyStructuredEncryptionTypes.StructuredData(
          content := AwsCryptographyStructuredEncryptionTypes.StructuredDataContent.DataMap(DynamoToStruct.ItemToStructured(input.plaintextItem).value),
          attributes := None)

      //= specification/dynamodb-encryption-client/encrypt-item.md#behavior
      //= type=implication
      //# - Encryption Context MUST be this input Item's [DynamoDB Item Base Context](#dynamodb-item-base-context).
      && MakeEncryptionContext(config, input.plaintextItem).Success?
      && Seq.Last(config.structuredEncryption.History.EncryptStructure).input.encryptionContext
        == Some(MakeEncryptionContext(config, input.plaintextItem).value)
  {
    var context :- MakeEncryptionContext(config, input.plaintextItem);
    var plaintextStructure :- DynamoToStruct.ItemToStructured(input.plaintextItem);
    var cryptoSchema :- ConfigToCryptoSchema(config, input.plaintextItem);
    var wrappedStruct := AwsCryptographyStructuredEncryptionTypes.StructuredData(content := AwsCryptographyStructuredEncryptionTypes.StructuredDataContent.DataMap(plaintextStructure), attributes := None);

    var encryptRes := config.structuredEncryption.EncryptStructure(
      AwsCryptographyStructuredEncryptionTypes.EncryptStructureInput(
        plaintextStructure:=wrappedStruct,
        cryptoSchema:=cryptoSchema,
        cmm:=config.cmm,
        encryptionContext:=Some(context)
      )
    );
    var encryptVal :- encryptRes.MapFailure(e => Error.AwsCryptographyStructuredEncryption(e));
    var encryptedData := encryptVal.encryptedStructure;
    var ddbItem :- DynamoToStruct.StructuredToItem(encryptedData.content.StructuredDataMap);
    output := Success(EncryptItemOutput(encryptedItem := ddbItem));
  }

  predicate DecryptItemEnsuresPublicly(input: DecryptItemInput, output: Result<DecryptItemOutput, Error>)
  {true}

  // public Decrypt method
  method DecryptItem(config: InternalConfig, input: DecryptItemInput)
    returns (output: Result<DecryptItemOutput, Error>)

    //= specification/dynamodb-encryption-client/decrypt-item.md#dynamodb-item
    //= type=implication
    //# This item MUST include an Attribute with a name that matches the
    //# [DynamoDB Partition Key Name](./ddb-item-encryptor.md#dynamodb-partition-key-name)
    //# configured on the [DynamoDB Item Encryptor](./ddb-item-encryptor.md).
    ensures output.Success? ==> config.partitionKeyName in input.encryptedItem

    //= specification/dynamodb-encryption-client/decrypt-item.md#dynamodb-item
    //= type=implication
    //# Otherwise this operation MUST yield an error.
    ensures config.partitionKeyName !in input.encryptedItem ==> output.Failure?

    //= specification/dynamodb-encryption-client/decrypt-item.md#dynamodb-item
    //= type=implication
    //# If the [DynamoDB Item Encryptor](./ddb-item-encryptor.md)
    //# has a [DynamoDB Sort Key Name](./ddb-item-encryptor.md#dynamodb-sort-key-name) configured,
    //# this item MUST include an Attribute with that name.
    ensures output.Success? ==> config.sortKeyName.None? || config.sortKeyName.value in input.encryptedItem

    // Otherwise this operation MUST yield an error.
    ensures config.sortKeyName.Some? && config.sortKeyName.value !in input.encryptedItem ==> output.Failure?

    ensures output.Success? ==>
      //= specification/dynamodb-encryption-client/decrypt-item.md#behavior
      //= type=implication
      //# Given the converted [Structured Data](../structured-encryption/structures.md#structured-data),
      //# this operation MUST delegate decryption of this data to
      //# Structured Encryption Client's [Decrypt Structure](../structured-encryption/encrypt-structure.md),
      //# with the following inputs:
      && (|config.structuredEncryption.History.DecryptStructure| == |old(config.structuredEncryption.History.DecryptStructure)| + 1)
      && (Seq.Last(config.structuredEncryption.History.DecryptStructure).output.Success?)

      //= specification/dynamodb-encryption-client/decrypt-item.md#behavior
      //= type=implication
      //# - Authenticate Schema MUST be a [Authenticate Schema](../structured-encryption/structures.md#crypto-schema)
      //# built with the following requirements:
      && ConfigToAuthenticateSchema(config, input.encryptedItem).Success?
      && Seq.Last(config.structuredEncryption.History.DecryptStructure).input.authenticateSchema
        == ConfigToAuthenticateSchema(config, input.encryptedItem).value

      //= specification/dynamodb-encryption-client/decrypt-item.md#behavior
      //= type=implication
      //# - CMM MUST be the [CMM configured on this Item Encryptor](./ddb-item-encryptor.md#cmm).
      && Seq.Last(config.structuredEncryption.History.DecryptStructure).input.cmm == config.cmm

      //= specification/dynamodb-encryption-client/decrypt-item.md#behavior
      //= type=implication
      //# - Encryption Context MUST be the input Item's [DynamoDB Item Base Context](./encrypt-item.md#dynamodb-item-base-context).
      && MakeEncryptionContext(config, input.encryptedItem).Success?
      && Seq.Last(config.structuredEncryption.History.DecryptStructure).input.encryptionContext
        == Some(MakeEncryptionContext(config, input.encryptedItem).value)

      //= specification/dynamodb-encryption-client/decrypt-item.md#behavior
      //= type=implication
      //# - Encrypted Structured Data MUST be the Structured Data converted above.
      && DynamoToStruct.ItemToStructured(input.encryptedItem).Success?
      && Seq.Last(config.structuredEncryption.History.DecryptStructure).input.encryptedStructure
        == AwsCryptographyStructuredEncryptionTypes.StructuredData(
          content := AwsCryptographyStructuredEncryptionTypes.StructuredDataContent.DataMap(DynamoToStruct.ItemToStructured(input.encryptedItem).value),
          attributes := None)
  {
    var context :- MakeEncryptionContext(config, input.encryptedItem);
    var encryptedStructure :- DynamoToStruct.ItemToStructured(input.encryptedItem);
    var authenticateSchema :- ConfigToAuthenticateSchema(config, input.encryptedItem);
    var wrappedStruct := AwsCryptographyStructuredEncryptionTypes.StructuredData(content := AwsCryptographyStructuredEncryptionTypes.StructuredDataContent.DataMap(encryptedStructure), attributes := None);

    var decryptRes := config.structuredEncryption.DecryptStructure(
      AwsCryptographyStructuredEncryptionTypes.DecryptStructureInput(
        encryptedStructure:=wrappedStruct,
        authenticateSchema:=authenticateSchema,
        cmm:=config.cmm,
        encryptionContext:=Some(context)
      )
    );
    var decryptVal :- decryptRes.MapFailure(e => Error.AwsCryptographyStructuredEncryption(e));
    var decryptedData := decryptVal.plaintextStructure;
    var ddbItem :- DynamoToStruct.StructuredToItem(decryptedData.content.StructuredDataMap);
    output := Success(DecryptItemOutput(plaintextItem := ddbItem));
  }
}
