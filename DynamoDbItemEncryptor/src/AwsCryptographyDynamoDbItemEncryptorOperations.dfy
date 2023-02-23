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
  import CSE = AwsCryptographyStructuredEncryptionTypes
  import SE =  StructuredEncryptionUtil

  datatype Config = Config(
    nameonly tableName: ComAmazonawsDynamodbTypes.TableName,
    nameonly partitionKeyName: ComAmazonawsDynamodbTypes.KeySchemaAttributeName,
    nameonly sortKeyName: Option<ComAmazonawsDynamodbTypes.KeySchemaAttributeName>,
    nameonly cmm: AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsManager,
    nameonly attributeActions: AttributeActions,
    nameonly allowedUnauthenticatedAttributes: Option<ComAmazonawsDynamodbTypes.AttributeNameList>,
    nameonly allowedUnauthenticatedAttributePrefix: Option<string>,
    nameonly algorithmSuiteId: Option<AwsCryptographyMaterialProvidersTypes.DBEAlgorithmSuiteId>,
    nameonly structuredEncryption: StructuredEncryption.StructuredEncryptionClient
    // TODO legacy encryptor
    // TODO legacy schema
  )

  type InternalConfig = Config

  // constant attribute names for the encryption context
  const TABLE_NAME : seq<uint8> := UTF8.EncodeAscii("aws-crypto-table-name");
  const PARTITION_NAME : seq<uint8> := UTF8.EncodeAscii("aws-crypto-partition-name");
  const PARTITION_VALUE : seq<uint8> := UTF8.EncodeAscii("aws-crypto-partition-value");
  const SORT_NAME : seq<uint8> := UTF8.EncodeAscii("aws-crypto-sort-name");
  const SORT_VALUE : seq<uint8> := UTF8.EncodeAscii("aws-crypto-sort-value");

  // Is the attribute name an allowed unauthenticated name?
  predicate method AllowedUnauthenticated(
    unauthenticatedAttributes: Option<ComAmazonawsDynamodbTypes.AttributeNameList>,
    unauthenticatedPrefix: Option<string>,
    attr : string)
  {
    || (unauthenticatedAttributes.Some? && attr in unauthenticatedAttributes.value)
    || (unauthenticatedPrefix.Some? && unauthenticatedPrefix.value <= attr)
    || SE.ReservedPrefix <= attr
  }

  //= specification/dynamodb-encryption-client/decrypt-item.md#signature-scope
  //= type=implication
  //# If an Authenticate Action other than DO_NOTHING is configured for an attribute name included in [Unauthenticated Attributes](./ddb-item-encryptor.md#unauthenticated-attributes)
  //# or beginning with the prefix specified in [Unauthenticated Attribute Prefix](./ddb-item-encryptor.md#unauthenticated-attribute-prefix),
  //# this operation MUST yield an error.
  // This is used only in ValidInternalConfig?
  predicate method ForwardCompatibleAttributeAction(
    attribute: string,
    action: CSE.CryptoAction,
    unauthenticatedAttributes: Option<ComAmazonawsDynamodbTypes.AttributeNameList>,
    unauthenticatedPrefix: Option<string>
  )
  {
    if action == CSE.DO_NOTHING then
      AllowedUnauthenticated(unauthenticatedAttributes, unauthenticatedPrefix, attribute)
    else
      !AllowedUnauthenticated(unauthenticatedAttributes, unauthenticatedPrefix, attribute)
  }

  // Is this attribute unknown to the config?
  predicate method UnknownAttibute(config : InternalConfig, attr : ComAmazonawsDynamodbTypes.AttributeName)
  {
    && attr !in config.attributeActions // i.e. not in signature scope
    && InSignatureScope(config, attr)
  }

  // Is the attribute name in signature scope?
  predicate method InSignatureScope(config : InternalConfig, attr : ComAmazonawsDynamodbTypes.AttributeName)
  {
	  !AllowedUnauthenticated(
      config.allowedUnauthenticatedAttributes,
      config.allowedUnauthenticatedAttributePrefix,
      attr)
  }

  // transform AttributeValue into encoded encryption context value
  function method {:opaque} EncodeValue(val : ComAmazonawsDynamodbTypes.AttributeValue) : Result<ValidUTF8Bytes, string>
  {
    var nValue :- DynamoToStruct.TopLevelAttributeToBytes(val);
    var val64 := Base64.Encode(nValue);
    Success(UTF8.EncodeAscii(val64))
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
      && TABLE_NAME in ret.value && UTF8.Encode(config.tableName).Success? && ret.value[TABLE_NAME] == UTF8.Encode(config.tableName).value
      && PARTITION_NAME in ret.value && UTF8.Encode(config.partitionKeyName).Success? && ret.value[PARTITION_NAME] == UTF8.Encode(config.partitionKeyName).value
      && config.partitionKeyName in item
      && PARTITION_VALUE in ret.value && EncodeValue(item[config.partitionKeyName]).Success? && ret.value[PARTITION_VALUE] == EncodeValue(item[config.partitionKeyName]).value
    ensures ret.Success? && config.sortKeyName.Some? ==>
      && SORT_NAME in ret.value && UTF8.Encode(config.sortKeyName.value).Success? && ret.value[SORT_NAME] == UTF8.Encode(config.sortKeyName.value).value
      && config.sortKeyName.value in item
      && SORT_VALUE in ret.value && EncodeValue(item[config.sortKeyName.value]).Success? && ret.value[SORT_VALUE] == EncodeValue(item[config.sortKeyName.value]).value

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
    UTF8.EncodeAsciiUnique();
    :- Need(config.partitionKeyName in item, "Partition key " + config.partitionKeyName + " not found in Item to be encrypted or decrypted");
    var tableName :- UTF8.Encode(config.tableName);
    var partitionName :- UTF8.Encode(config.partitionKeyName);
    var partitionValue :- EncodeValue(item[config.partitionKeyName]);
    var retval := map[TABLE_NAME := tableName, PARTITION_NAME := partitionName, PARTITION_VALUE := partitionValue];
    if config.sortKeyName.None? then
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
    && (config.cmm.Modifies !! config.structuredEncryption.Modifies)

    // The parition key MUST be CSE.SIGN_ONLY
    && config.partitionKeyName in config.attributeActions
    && config.attributeActions[config.partitionKeyName] == CSE.SIGN_ONLY
    // The sort key MUST be CSE.SIGN_ONLY
    && (config.sortKeyName.Some? ==>
      && config.sortKeyName.value in config.attributeActions
      && config.attributeActions[config.sortKeyName.value] == CSE.SIGN_ONLY)

    // attributeActions only apply on Encrypt.
    // The config on Encrypt MAY NOT be the same as the config on Decrypt.
    // This means that Encrypt MUST be "forward compatible" with Decrypt.
    // Every current and *past* CSE.DO_NOTHING action
    // MUST be derivable from allowedUnauthenticated information
    // otherwise Decrypt will attempt to authenticate an attribute that was unauthenticated on Encrypt.
    // Also, every current and *past* CSE.ENCRYPT_AND_SIGN or CSE.SIGN_ONLY action
    // MUST NOT overlap with allowedUnauthenticated information
    // otherwise Decrypt will not authenticate at attribute that was authenticate on Encrypt.
    // For this to work the scope of allowedUnauthenticated information MUST only increase.
    // This means that an attribute that is added to allowedUnauthenticatedAttributes
    // MUST NOT ever be removed.
    // This means that is a allowedUnauthenticatedAttributePrefix is added
    // allowedUnauthenticatedAttributePrefix <= old(allowedUnauthenticatedAttributePrefix).
    // The simple case is do not change allowedUnauthenticatedAttributePrefix.
    // But allowedUnauthenticatedAttributePrefix MAY get shorter,
    // however this is a dangrous operation as it may impact other attributes.
    && (forall attribute <- config.attributeActions.Keys
      :: ForwardCompatibleAttributeAction(
          attribute,
          config.attributeActions[attribute],
          config.allowedUnauthenticatedAttributes,
          config.allowedUnauthenticatedAttributePrefix))
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
    : (ret : Result<CSE.CryptoAction, string>)
    ensures (attr !in config.attributeActions && InSignatureScope(config, attr)) ==> ret.Failure?
  {
    if attr in config.attributeActions then
      Success(config.attributeActions[attr])
    else if !InSignatureScope(config, attr) then
      Success(CSE.CryptoAction.DO_NOTHING)
    else
      Failure("No Crypto Action configured for attribute " + attr)
  }

  // get Crypto Action and wrap in CryptoSchema
  function method GetCryptoSchemaAction(
    config : InternalConfig,
    attr : ComAmazonawsDynamodbTypes.AttributeName)
    : (ret : Result<CSE.CryptoSchema, string>)
    ensures (attr !in config.attributeActions && InSignatureScope(config, attr)) ==> ret.Failure?
  {
    var action :- GetCryptoSchemaActionInner(config, attr);
    var newElement := CSE.CryptoSchemaContent.Action(action);
    Success(CSE.CryptoSchema(content := newElement, attributes := None))
  }

  // return proper Authenticate Action by name
  function method GetAuthenticateSchemaAction(
    config : InternalConfig,
    attr : ComAmazonawsDynamodbTypes.AttributeName)
    : (ret : Result<CSE.AuthenticateSchema, string>)
    requires ValidInternalConfig?(config)

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
      ((ret.value == SE.DoNotSign) <==> !InSignatureScope(config, attr))
  {
    :- Need(!UnknownAttibute(config, attr), "Attribute " + attr + " is not configured");
    if InSignatureScope(config, attr) then
      Success(SE.DoSign)
    else
      Success(SE.DoNotSign)
  }

  // get CryptoSchema for this item
  function method ConfigToCryptoSchema(
    config : InternalConfig,
    item : ComAmazonawsDynamodbTypes.AttributeMap)
    : (ret : Result<CSE.CryptoSchema, Error>)

    //= specification/dynamodb-encryption-client/encrypt-item.md#behavior
    //= type=implication
    //# The [Attributes Actions](./ddb-item-encryptor.md#attribute-actions)
    //# configured on this Item Encryptor MUST specify a Crypto Action
    //# for every attribute in the [input DynamoDB Item](#dynamodb-item)
    //# (Attribute Actions MAY specify a Crypto Action for an attribute not
    //# in the input DynamoDB Item).
    ensures forall k <- item.Keys ::
      (k !in config.attributeActions && InSignatureScope(config, k)) ==> ret.Failure?

    //= specification/dynamodb-encryption-client/encrypt-item.md#behavior
    //= type=implication
    //# - The Crypto Schema MUST NOT contain more Crypto Actions than those specified by the previous point.
    ensures ret.Success? ==> ret.value.content.SchemaMap? && item.Keys == ret.value.content.SchemaMap.Keys

    //= specification/dynamodb-encryption-client/encrypt-item.md#behavior
    //= type=implication
    //# - For every attribute on the input Item,
    //# there MUST exist a Crypto Action in the Crypto Schema
    //# such that the Crypto Action indexed by that attribute name in the Crypto Schema
    //# equals the Crypto Action indexed by that attribute name in the configured Attribute Actions.
    ensures ret.Success? ==> forall k <-item.Keys ::
      && GetCryptoSchemaAction(config, k).Success?
      && ret.value.content.SchemaMap[k] == GetCryptoSchemaAction(config, k).value
      && (k in config.attributeActions ==>
        ret.value.content.SchemaMap[k].content ==
        CSE.CryptoSchemaContent.Action(config.attributeActions[k]))
  {
    var schema := map kv <- item.Items | true :: kv.0 := GetCryptoSchemaAction(config, kv.0);
    DynamoToStruct.MapKeysMatchItems(item);
    DynamoToStruct.SimplifyMapValueSuccess(schema);
    var actionMapRes := DynamoToStruct.SimplifyMapValue(schema);
    assert actionMapRes.Failure? ==> exists kv <- item.Items :: GetCryptoSchemaAction(config, kv.0).Failure?;
    assert actionMapRes.Failure? <==> exists k <- item.Keys :: schema[k].Failure?;
    assert actionMapRes.Failure? <==> exists k <- item.Keys :: GetCryptoSchemaAction(config, k).Failure?;

    var actionMap :- DynamoToStruct.MapError(actionMapRes);
    var schemaContent := CSE.CryptoSchemaContent.SchemaMap(actionMap);
    var finalSchema := CSE.CryptoSchema(content := schemaContent, attributes := None);
    Success(finalSchema)
  }

  // get AuthenticateSchema for this item
  function method ConfigToAuthenticateSchema(
    config : InternalConfig,
    item : ComAmazonawsDynamodbTypes.AttributeMap)
    : (ret : Result<CSE.AuthenticateSchema, Error>)
    requires ValidInternalConfig?(config)

    //= specification/dynamodb-encryption-client/decrypt-item.md#behavior
    //= type=implication
    //# - The number of Authenticate Actions in the Authenticate Schema
    //# MUST EQUAL the number of Attributes on the [input DynamoDB Item](#dynamodb-item).
    ensures ret.Success? ==> ret.value.content.SchemaMap? && item.Keys == ret.value.content.SchemaMap.Keys

    //= specification/dynamodb-encryption-client/decrypt-item.md#behavior
    //= type=implication
    //# - For every Attribute in the [input DynamoDB Item](#dynamodb-item)
    //# that is not in the [signature scope](#signature-scope),
    //# there MUST exist a [DO_NOT_SIGN Authenticate Action](../structured-encryption/structures.md#do_not_sign)
    //# in the Authenticate Schema,
    //# string indexed at the top level by that attribute name.
    ensures ret.Success? ==> forall k <-item.Keys ::
      !InSignatureScope(config, k) ==>
      ret.value.content.SchemaMap[k].content ==
      CSE.AuthenticateSchemaContent.Action(CSE.AuthenticateAction.DO_NOT_SIGN)

    //= specification/dynamodb-encryption-client/decrypt-item.md#behavior
    //= type=implication
    //# - For every Attribute in the [input DynamoDB Item](#dynamodb-item)
    //# that is in the [signature scope](#signature-scope),
    //# there MUST exist a [SIGN Authenticate Action](../structured-encryption/structures.md#sign)
    //# in the Authenticate Schema,
    //# string indexed at the top level by that attribute name.
    ensures ret.Success? ==> forall k <-item.Keys ::
      && GetAuthenticateSchemaAction(config, k).Success?
      && InSignatureScope(config, k) ==>
        ret.value.content.SchemaMap[k].content ==
        CSE.AuthenticateSchemaContent.Action(CSE.AuthenticateAction.SIGN)
  {
    var schema := map kv <- item.Items | true :: kv.0 := GetAuthenticateSchemaAction(config, kv.0);
    DynamoToStruct.MapKeysMatchItems(item);
    var authMap :- DynamoToStruct.MapError(DynamoToStruct.SimplifyMapValue(schema));
    var schemaContent := CSE.AuthenticateSchemaContent.SchemaMap(authMap);
    var finalSchema := CSE.AuthenticateSchema(content := schemaContent, attributes := None);
    Success(finalSchema)
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

      //= specification/dynamodb-encryption-client/encrypt-item.md#behavior
      //= type=implication
      //# - Structured Data MUST be the Structured Data converted above.
      && DynamoToStruct.ItemToStructured(input.plaintextItem).Success?
      && Seq.Last(config.structuredEncryption.History.EncryptStructure).input.plaintextStructure
        == CSE.StructuredData(
          content := CSE.StructuredDataContent.DataMap(DynamoToStruct.ItemToStructured(input.plaintextItem).value),
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
    var wrappedStruct := CSE.StructuredData(
      content := CSE.StructuredDataContent.DataMap(plaintextStructure),
      attributes := None);

    var encryptRes := config.structuredEncryption.EncryptStructure(
      CSE.EncryptStructureInput(
        tableName := config.tableName,
        plaintextStructure:=wrappedStruct,
        cryptoSchema:=cryptoSchema,
        cmm:=config.cmm,
        algorithmSuiteId:=config.algorithmSuiteId,
        encryptionContext:=Some(context)
      )
    );
    var encryptVal :- encryptRes.MapFailure(e => Error.AwsCryptographyStructuredEncryption(e));
    var encryptedData := encryptVal.encryptedStructure;
    var ddbItem :- DynamoToStruct.StructuredToItem(encryptedData.content.DataMap);
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
        == CSE.StructuredData(
          content := CSE.StructuredDataContent.DataMap(DynamoToStruct.ItemToStructured(input.encryptedItem).value),
          attributes := None)
  {
    var context :- MakeEncryptionContext(config, input.encryptedItem);
    var encryptedStructure :- DynamoToStruct.ItemToStructured(input.encryptedItem);
    var authenticateSchema :- ConfigToAuthenticateSchema(config, input.encryptedItem);
    var wrappedStruct := CSE.StructuredData(
      content := CSE.StructuredDataContent.DataMap(encryptedStructure),
      attributes := None);

    var decryptRes := config.structuredEncryption.DecryptStructure(
      CSE.DecryptStructureInput(
        tableName := config.tableName,
        encryptedStructure:=wrappedStruct,
        authenticateSchema:=authenticateSchema,
        cmm:=config.cmm,
        encryptionContext:=Some(context)
      )
    );
    var decryptVal :- decryptRes.MapFailure(e => Error.AwsCryptographyStructuredEncryption(e));
    var decryptedData := decryptVal.plaintextStructure;
    var ddbItem :- DynamoToStruct.StructuredToItem(decryptedData.content.DataMap);
    output := Success(DecryptItemOutput(plaintextItem := ddbItem));
  }
}
