// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../Model/AwsCryptographyDynamoDbEncryptionItemEncryptorTypes.dfy"
include "../../../../submodules/MaterialProviders/AwsCryptographicMaterialProviders/src/CMMs/ExpectedEncryptionContextCMM.dfy"
include "../../DynamoDbEncryption/src/DynamoToStruct.dfy"
include "../../DynamoDbEncryption/src/SearchInfo.dfy"
include "Util.dfy"
include "InternalLegacyConfig.dfy"
include "../../DynamoDbEncryption/src/Util.dfy"
include "../../StructuredEncryption/src/Util.dfy"

module AwsCryptographyDynamoDbEncryptionItemEncryptorOperations refines AbstractAwsCryptographyDynamoDbEncryptionItemEncryptorOperations {
  import ComAmazonawsDynamodbTypes
  import opened DynamoDbItemEncryptorUtil
  import CMP = AwsCryptographyMaterialProvidersTypes
  import StructuredEncryption
  import DynamoToStruct
  import SortedSets
  import Base64
  import opened StandardLibrary
  import Seq
  import CSE = AwsCryptographyStructuredEncryptionTypes
  import SE =  StructuredEncryptionUtil
  import InternalLegacyConfig
  import MaterialProviders
  import ExpectedEncryptionContextCMM
  import SET = AwsCryptographyStructuredEncryptionTypes
  import DDBE = AwsCryptographyDynamoDbEncryptionTypes
  import DynamoDbEncryptionUtil
  import StructuredEncryptionUtil

  datatype Config = Config(
    nameonly cmpClient : MaterialProviders.MaterialProvidersClient,
    nameonly tableName: ComAmazonawsDynamodbTypes.TableName,
    nameonly partitionKeyName: ComAmazonawsDynamodbTypes.KeySchemaAttributeName,
    nameonly sortKeyName: Option<ComAmazonawsDynamodbTypes.KeySchemaAttributeName>,
    nameonly cmm: CMP.ICryptographicMaterialsManager,
    nameonly attributeActions: DDBE.AttributeActions,
    nameonly allowedUnauthenticatedAttributes: Option<ComAmazonawsDynamodbTypes.AttributeNameList>,
    nameonly allowedUnauthenticatedAttributePrefix: Option<string>,
    nameonly algorithmSuiteId: Option<CMP.DBEAlgorithmSuiteId>,
    nameonly structuredEncryption: StructuredEncryption.StructuredEncryptionClient,
    nameonly plaintextPolicy: DDBE.PlaintextPolicy,
    nameonly internalLegacyConfig: Option<InternalLegacyConfig.InternalLegacyConfig> := None
  )

  type InternalConfig = Config
  type ValidConfig = x : Config | ValidInternalConfig?(x) witness *

  predicate method IsEncrypted(config : ValidConfig, attr : string)
  {
    && attr in config.attributeActions
    && config.attributeActions[attr] == SET.ENCRYPT_AND_SIGN
  }

  predicate method IsSigned(config : ValidConfig, attr : string)
  {
    && attr in config.attributeActions
    && config.attributeActions[attr] != SET.DO_NOTHING
  }

  const DoNotSign :=
    CSE.AuthenticateSchema(content := CSE.AuthenticateSchemaContent.Action(CSE.AuthenticateAction.DO_NOT_SIGN), attributes := None)
  const DoSign :=
    CSE.AuthenticateSchema(content := CSE.AuthenticateSchemaContent.Action(CSE.AuthenticateAction.SIGN), attributes := None)

  // constant attribute names for the encryption context
  const TABLE_NAME : seq<uint8> := UTF8.EncodeAscii("aws-crypto-table-name");
  const PARTITION_NAME : seq<uint8> := UTF8.EncodeAscii("aws-crypto-partition-name");
  const SORT_NAME : seq<uint8> := UTF8.EncodeAscii("aws-crypto-sort-name");

  // Is the attribute name an allowed unauthenticated name?
  predicate method AllowedUnauthenticated(
    unauthenticatedAttributes: Option<ComAmazonawsDynamodbTypes.AttributeNameList>,
    unauthenticatedPrefix: Option<string>,
    attr : string)
  {
    || (unauthenticatedAttributes.Some? && attr in unauthenticatedAttributes.value)
    || (unauthenticatedPrefix.Some? && unauthenticatedPrefix.value <= attr)
    || ReservedPrefix <= attr
    // Attributes with the reserved prefix are "allowed unauthenticated" in that
    // they are not specified as signed within attributeActions.
    // These attributes MAY still be authenticated via other methods,
    // such as "aws_dbe_head" which is explicitly added to the canonical hash
    // used in signing.
  }

  //= specification/dynamodb-encryption-client/decrypt-item.md#signature-scope
  //= type=implication
  //# If an Authenticate Action other than DO_NOTHING is configured for an attribute name included in [Unauthenticated Attributes](./ddb-table-encryption-config.md#unauthenticated-attributes)
  //# or beginning with the prefix specified in [Unauthenticated Attribute Prefix](./ddb-table-encryption-config.md#unauthenticated-attribute-prefix),
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

  function method CryptoActionString(action: CSE.CryptoAction) : string
  {
    match action {
      case DO_NOTHING => "DO_NOTHING"
      case SIGN_ONLY => "SIGN_ONLY"
      case ENCRYPT_AND_SIGN => "ENCRYPT_AND_SIGN"
    }
  }

  function method ExplainNotForwardCompatible(
    attr: string,
    action: CSE.CryptoAction,
    unauthenticatedAttributes: Option<ComAmazonawsDynamodbTypes.AttributeNameList>,
    unauthenticatedPrefix: Option<string>
  )
    : string
    requires !ForwardCompatibleAttributeAction(attr, action, unauthenticatedAttributes, unauthenticatedPrefix)
  {
    "Attribute " + attr + " is configured as " + CryptoActionString(action) + " but " +
    if action == CSE.DO_NOTHING then
      "it must also be in unauthenticatedAttributes or begin with the unauthenticatedPrefix."
    else if unauthenticatedAttributes.Some? && attr in unauthenticatedAttributes.value then
      "it is also in unauthenticatedAttributes."
    else if unauthenticatedPrefix.Some? && unauthenticatedPrefix.value <= attr then
      "it also begins with the unauthenticatedPrefix."
    else
      assert ReservedPrefix <= attr;
      "it also begins with the reserved prefix."
  }


  // Is this attribute unknown to the config?
  predicate method UnknownAttribute(config : InternalConfig, attr : ComAmazonawsDynamodbTypes.AttributeName)
  {
    && InSignatureScope(config, attr)
    && attr !in config.attributeActions
    // Attributes in signature scope MUST be configured in attributeActions
    // so these two lines are saying "in scope && not in scope"
    // and that's why it's an error
  }

  // Is the attribute SIGN_ONLY?
  predicate method IsSignOnly(config : InternalConfig, attr : ComAmazonawsDynamodbTypes.AttributeName)
  {
      attr in config.attributeActions && config.attributeActions[attr] == CSE.SIGN_ONLY
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

  // get the encryption context component of the sort key, if any
  function method {:opaque} MakeSortContext(
    config : InternalConfig,
    item : DynamoToStruct.TerminalDataMap)
    : (ret : Result<CMP.EncryptionContext, Error>)
    ensures ret.Success? && config.sortKeyName.None? ==>
      && SORT_NAME !in ret.value
    ensures ret.Success? && config.sortKeyName.Some? ==>
      && SORT_NAME in ret.value && DDBEncode(config.sortKeyName.value).Success? && ret.value[SORT_NAME] == DDBEncode(config.sortKeyName.value).value
      && config.sortKeyName.value in item
    ensures ret.Success? ==> ret.value.Keys == {} || ret.value.Keys == {SORT_NAME}
  {
    if config.sortKeyName.None? then
      Success(map[])
    else
      :- Need(config.sortKeyName.value in item, DDBError("Sort key " + config.sortKeyName.value + " not found in Item to be encrypted or decrypted"));
      var sortName :- DDBEncode(config.sortKeyName.value);
      Success(map[SORT_NAME := sortName])
  }

  function method ECName(k : string) : string
  {
    DynamoDbEncryptionUtil.DDBEC_ATTR_PREFIX + k
  }

  lemma ECNameUnique2(x : string, y : string)
    requires x != y
    ensures ECName(x) != ECName(y)
  {
    assert ECName(x)[16..] == x;
  }

  lemma ECNameUnique()
    ensures forall x : string, y : string | x != y :: ECName(x) != ECName(y)
  {
    forall x : string, y : string ensures (x != y ==> ECName(x) != ECName(y)) {
      if x != y {
        ECNameUnique2(x, y);
      }
    }
  }

  // create encryption content from DynamoDB item
  //= specification/dynamodb-encryption-client/encrypt-item.md#dynamodb-item-base-context
  //# The DynamoDB Item Base Context MUST contain:
  //# - the key "aws-crypto-table-name" with a value equal to the DynamoDB Table Name of the DynamoDB Table
  //#   this item is stored in (or will be stored in).
  //# - the key "aws-crypto-partition-name" with a value equal to the name of the Partition Key on this item.
  //# - If this item has a sort key attribute,
  //#   the key "aws-crypto-sort-name" with a value equal to the [DynamoDB Sort Key Name](#dynamodb-sort-key-name).
  //#  - For every [SIGN_ONLY](../structured-encryption/structures.md#signonly) attribute on the item,
  //#     the following key-value pair:
  //#   - the key is the following concatenation,
  //#     where `attributeName` is the name of the attribute:
  //#       "aws-crypto-attr." + `attributeName`
  //#   - the value is the concatenation of the bytes `typeID + serializedValue`
  //#     [Base 64 encoded](https://www.rfc-editor.org/rfc/rfc4648),
  //#     where `typeId` is the attribute's [type ID](./ddb-attribute-serialization.md#type-id)
  //#     and `serializedValue` is the attribute's value serialized according to
  //#     [Attribute Value Serialization](./ddb-attribute-serialization.md#attribute-value-serialization)

  function method {:opaque} MakeEncryptionContext(
    config : InternalConfig,
    item : DynamoToStruct.TerminalDataMap)
    : (ret : Result<CMP.EncryptionContext, Error>)

    ensures ret.Success? ==>
      && config.partitionKeyName in item
      && |ret.value| > 0
    ensures ret.Success? && config.sortKeyName.Some? ==>
      && config.sortKeyName.value in item

    ensures ret.Success? ==> config.sortKeyName.None? || (config.sortKeyName.value in item)
    ensures ret.Success? ==> config.partitionKeyName in item
  {
    UTF8.EncodeAsciiUnique();
    :- Need(config.partitionKeyName in item, DDBError("Partition key " + config.partitionKeyName + " not found in Item to be encrypted or decrypted"));
    var tableName :- DDBEncode(config.tableName);
    var partitionName :- DDBEncode(config.partitionKeyName);
    var sortContext :- MakeSortContext(config, item);
    var base : CMP.EncryptionContext := map[TABLE_NAME := tableName, PARTITION_NAME := partitionName] + sortContext;
    assert TABLE_NAME in base && DDBEncode(config.tableName).Success? && base[TABLE_NAME] == DDBEncode(config.tableName).value;
    assert PARTITION_NAME in base && DDBEncode(config.partitionKeyName).Success? && base[PARTITION_NAME] == DDBEncode(config.partitionKeyName).value;
    //= specification/dynamodb-encryption-client/encrypt-item.md#dynamodb-item-base-context
    //# If this item does not have a sort key attribute,
    //# the DynamoDB Item Context MUST NOT contain the key `aws-crypto-sort-name`.
    assert config.sortKeyName.None? ==> SORT_NAME !in base;
    assert config.sortKeyName.Some? ==> SORT_NAME in base && DDBEncode(config.sortKeyName.value).Success? && base[SORT_NAME] == DDBEncode(config.sortKeyName.value).value;
    // we don't `ensure` these things, because we return "base + signedMap"
    // at which point Dafny forgets everything it ever knew.

    ECNameUnique();
    :- Need(forall k <- item :: DDBEncode(ECName(k)).Success?, DDBError("Invalid attribute names"));
    var signedMap : CMP.EncryptionContext :=
      map k <- item | IsSignOnly(config, k) ::
        DDBEncode(ECName(k)).value := EncodeAscii(Base64.Encode(item[k].content.Terminal.typeId + item[k].content.Terminal.value));

    Success(base + signedMap)
  }

  // string to Error
  function method DDBError(s : string) : Error {
    Error.DynamoDbItemEncryptorException(message := s)
  }

  // UTF8.Encode, but return Error
  function method DDBEncode(s : string) : Result<UTF8.ValidUTF8Bytes, Error>
  {
    UTF8.Encode(s).MapFailure(e => DDBError(e))
  }

  predicate ValidInternalConfig?(config: InternalConfig)
  {
    && config.cmm.ValidState()
    && config.cmpClient.ValidState()
    && config.cmm.Modifies !! {config.cmpClient.History}
    && config.structuredEncryption.ValidState()
    && (config.cmm.Modifies !! config.structuredEncryption.Modifies)

    // The partition key MUST be CSE.SIGN_ONLY
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
    // however this is a dangerous operation as it may impact other attributes.
    //= specification/dynamodb-encryption-client/decrypt-item.md#signature-scope
    //# If an Authenticate Action other than DO_NOTHING is configured for an attribute name included in [Unauthenticated Attributes](./ddb-table-encryption-config.md#unauthenticated-attributes)
    //# or beginning with the prefix specified in [Unauthenticated Attribute Prefix](./ddb-table-encryption-config.md#unauthenticated-attribute-prefix),
    //# this operation MUST yield an error.
    && (forall attribute <- config.attributeActions.Keys
      :: ForwardCompatibleAttributeAction(
          attribute,
          config.attributeActions[attribute],
          config.allowedUnauthenticatedAttributes,
          config.allowedUnauthenticatedAttributePrefix))

    // It is forbidden to explicitly configure an attribute with the reserved prefix
    && (forall attribute <- config.attributeActions.Keys ::
          !(ReservedPrefix <= attribute))
    
    && (config.internalLegacyConfig.Some? ==> config.plaintextPolicy.FORBID_WRITE_FORBID_READ?)
    && (
        (|| config.plaintextPolicy.FORBID_WRITE_ALLOW_READ?
        || config.plaintextPolicy.REQUIRE_WRITE_ALLOW_READ?)
      ==>
        config.internalLegacyConfig.None?)
  }

  function ModifiesInternalConfig(config: InternalConfig) : set<object>
  {
    config.cmm.Modifies
    + config.structuredEncryption.Modifies
    + config.cmpClient.Modifies
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
    //# if it's Attribute Name is included in [Unauthenticated Attributes](./ddb-table-encryption-config.md#unauthenticated-attributes)
    //# or if it's Attribute Name begins with the prefix specified in
    //# [Unauthenticated Attribute Prefix](./ddb-table-encryption-config.md#unauthenticated-attribute-prefix).

    //= specification/dynamodb-encryption-client/decrypt-item.md#signature-scope
    //= type=implication
    //# Otherwise, Attributes MUST be considered as within the signature scope.
    ensures ret.Success? ==>
      ((ret.value == DoNotSign) <==> !InSignatureScope(config, attr))
  {
    :- Need(!UnknownAttribute(config, attr), "Attribute " + attr + " is not configured");
    if InSignatureScope(config, attr) then
      Success(DoSign)
    else
      Success(DoNotSign)
  }

  // get CryptoSchema for this item
  function method ConfigToCryptoSchema(
    config : InternalConfig,
    item : ComAmazonawsDynamodbTypes.AttributeMap)
    : (ret : Result<CSE.CryptoSchema, DDBE.Error>)

    //= specification/dynamodb-encryption-client/encrypt-item.md#behavior
    //= type=implication
    //# The [Attributes Actions](./ddb-table-encryption-config.md#attribute-actions)
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
    : (ret : Result<CSE.AuthenticateSchema, DDBE.Error>)
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

  function method IsPlaintextItem(ddbItem: ComAmazonawsDynamodbTypes.AttributeMap) : (ret: bool) {
    !( && StructuredEncryptionUtil.HeaderField in ddbItem.Keys
       && StructuredEncryptionUtil.FooterField in ddbItem.Keys)
  }

  predicate EncryptItemEnsuresPublicly(input: EncryptItemInput, output: Result<EncryptItemOutput, Error>)
  {true}

  // public Encrypt method
  method EncryptItem(config: InternalConfig, input: EncryptItemInput)
    returns (output: Result<EncryptItemOutput, Error>)
    //= specification/dynamodb-encryption-client/encrypt-item.md#dynamodb-item
    //= type=implication
    //# This item MUST include an Attribute with a name that matches the
    //# [DynamoDB Partition Key Name](./ddb-table-encryption-config.md#dynamodb-partition-key-name)
    //# configured on the [DynamoDB Item Encryptor](./ddb-item-encryptor.md).
    ensures output.Success? ==> config.partitionKeyName in input.plaintextItem

    //= specification/dynamodb-encryption-client/encrypt-item.md#dynamodb-item
    //= type=implication
    //# Otherwise this operation MUST yield an error.
    ensures config.partitionKeyName !in input.plaintextItem ==> output.Failure?

    //= specification/dynamodb-encryption-client/encrypt-item.md#dynamodb-item
    //= type=implication
    //# If the [DynamoDB Item Encryptor](./ddb-item-encryptor.md)
    //# has a [DynamoDB Sort Key Name](./ddb-table-encryption-config.md#dynamodb-sort-key-name) configured,
    //# this item MUST include an Attribute with that name.
    ensures output.Success? ==> (config.sortKeyName.None? || config.sortKeyName.value in input.plaintextItem)

    // Otherwise this operation MUST yield an error.
    ensures config.sortKeyName.Some? && config.sortKeyName.value !in input.plaintextItem ==> output.Failure?

    ensures 
      && output.Success? 
      && !(config.internalLegacyConfig.Some? && config.internalLegacyConfig.value.policy.REQUIRE_ENCRYPT_ALLOW_DECRYPT?)
      && !(config.plaintextPolicy.REQUIRE_WRITE_ALLOW_READ?)
    ==>
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
      //# analogous to the [configured Attribute Actions](./ddb-table-encryption-config.md#attribute-actions).
      && ConfigToCryptoSchema(config, input.plaintextItem).Success?
      && Seq.Last(config.structuredEncryption.History.EncryptStructure).input.cryptoSchema
        == ConfigToCryptoSchema(config, input.plaintextItem).value

      //= specification/dynamodb-encryption-client/encrypt-item.md#behavior
      //= type=implication
      //# - Structured Data MUST be the Structured Data converted above.
      && DynamoToStruct.ItemToStructured(input.plaintextItem).Success?
      && var plaintextStructure := DynamoToStruct.ItemToStructured(input.plaintextItem).value;
      && Seq.Last(config.structuredEncryption.History.EncryptStructure).input.plaintextStructure
        == CSE.StructuredData(
          content := CSE.StructuredDataContent.DataMap(plaintextStructure),
          attributes := None)

      //= specification/dynamodb-encryption-client/encrypt-item.md#behavior
      //= type=implication
      //# - Encryption Context MUST be this input Item's [DynamoDB Item Base Context](#dynamodb-item-base-context).
      && MakeEncryptionContext(config, plaintextStructure).Success?
      && Seq.Last(config.structuredEncryption.History.EncryptStructure).input.encryptionContext
        == Some(MakeEncryptionContext(config, plaintextStructure).value)

    //= specification/dynamodb-encryption-client/encrypt-item.md#behavior
    //= type=implication
    //# If a [Plaintext Policy](./ddb-encryption-table-config.md#plaintext-policy) of
    //# `REQUIRE_WRITE_ALLOW_READ` is specified,
    //# this operation MUST NOT encrypt the input item,
    //# and MUST passthrough that item as the output.
    ensures
        && config.plaintextPolicy.REQUIRE_WRITE_ALLOW_READ?
        && output.Success?
      ==>
        && output.value.encryptedItem == input.plaintextItem
  {
    :- Need(
      && config.partitionKeyName in input.plaintextItem
      && (config.sortKeyName.None? || config.sortKeyName.value in input.plaintextItem)
      , DynamoDbItemEncryptorException( message := "Configuration missmatch partition or sort key does not exist in item."));

    //= specification/dynamodb-encryption-client/encrypt-item.md#behavior
    //# If a [Legacy Policy](./ddb-encryption-table-config.md#legacy-policy) of
    //# `REQUIRE_ENCRYPT_ALLOW_DECRYPT` is specified,
    //# this operation MUST delegate encryption of this item to the
    //# [Legacy Encryptor](./ddb-encryption-table-config.md#legacy-encryptor),
    //# using the configured [Attribute Flags](./ddb-encryption-table-config.md) as input.
    if config.internalLegacyConfig.Some? && config.internalLegacyConfig.value.policy.REQUIRE_ENCRYPT_ALLOW_DECRYPT? {
      var encryptItemOutput :- config.internalLegacyConfig.value.EncryptItem(input);
      //= specification/dynamodb-encryption-client/encrypt-item.md#behavior
      //# The item returned by this operation MUST be the item outputted by the
      //# [Legacy Encryptor](./ddb-encryption-table-config.md#legacy-encryptor).
      return Success(encryptItemOutput);
    }

    if (config.plaintextPolicy.REQUIRE_WRITE_ALLOW_READ?) {
      var passthroughOutput := EncryptItemOutput(encryptedItem := input.plaintextItem);
      return Success(passthroughOutput);
    }

    // This is to help Dafny with the above complex ensures
    assert {:split_here} true;

    var plaintextStructure :- DynamoToStruct.ItemToStructured(input.plaintextItem)
        .MapFailure(e => Error.AwsCryptographyDynamoDbEncryption(e));
    var context :- MakeEncryptionContext(config, plaintextStructure);
    var cryptoSchema :- ConfigToCryptoSchema(config, input.plaintextItem)
        .MapFailure(e => Error.AwsCryptographyDynamoDbEncryption(e));
    var wrappedStruct := CSE.StructuredData(
      content := CSE.StructuredDataContent.DataMap(plaintextStructure),
      attributes := None);

    //= specification/dynamodb-encryption-client/encrypt-item.md#behavior
    //# This operation MUST create a
    //# [Required Encryption Context CMM](https://github.com/awslabs/private-aws-encryption-sdk-specification-staging/blob/dafny-verified/framework/required-encryption-context-cmm.md)
    //# with the following inputs:
    //# - This item encryptor's [CMM](./ddb-table-encryption-config.md#cmm) as the underlying CMM.
    //# - The keys from the [DynamoDB Item Base Context](#dynamodb-item-base-context)

    var reqCMMR := config.cmpClient.CreateExpectedEncryptionContextCMM(
      CMP.CreateExpectedEncryptionContextCMMInput(
        underlyingCMM := Some(config.cmm),
        keyring := None,
        requiredEncryptionContextKeys := SortedSets.ComputeSetToOrderedSequence2(context.Keys, ByteLess)
      )
    );
    var reqCMM :- reqCMMR.MapFailure(e => AwsCryptographyMaterialProviders(e));
    var encryptRes := config.structuredEncryption.EncryptStructure(
      CSE.EncryptStructureInput(
        tableName := config.tableName,
        plaintextStructure:=wrappedStruct,
        cryptoSchema:=cryptoSchema,
        //= specification/dynamodb-encryption-client/encrypt-item.md#behavior
        //# - The CMM MUST be the CMM created above.
        cmm:= reqCMM,
        //= specification/dynamodb-encryption-client/encrypt-item.md#behavior
        //# - If configured, the Algorithm Suite MUST be the
        //# [Algorithm Suite configured on this Item Encryptor](./ddb-table-encryption-config.md#algorithm-suite).
        
        //= specification/dynamodb-encryption-client/encrypt-item.md#behavior
        //# If not configured on the Item Encryptor, Algorithm Suite MUST NOT be specified.
        // If not specified on input, the algorithm suite exists as None on the config
        algorithmSuiteId:=config.algorithmSuiteId,
        encryptionContext:=Some(context)
      )
    );
    var encryptVal :- encryptRes.MapFailure(
        e => Error.AwsCryptographyDynamoDbEncryption(DDBE.AwsCryptographyStructuredEncryption(e)));
    var encryptedData := encryptVal.encryptedStructure;
    var ddbKey :- DynamoToStruct.StructuredToItem(encryptedData.content.DataMap)
        .MapFailure(e => Error.AwsCryptographyDynamoDbEncryption(e));
    output := Success(EncryptItemOutput(encryptedItem := ddbKey));
  }

  predicate DecryptItemEnsuresPublicly(input: DecryptItemInput, output: Result<DecryptItemOutput, Error>)
  {true}

  // public Decrypt method
  method DecryptItem(config: InternalConfig, input: DecryptItemInput)
    returns (output: Result<DecryptItemOutput, Error>)

    //= specification/dynamodb-encryption-client/decrypt-item.md#dynamodb-item
    //= type=implication
    //# This item MUST include an Attribute with a name that matches the
    //# [DynamoDB Partition Key Name](./ddb-table-encryption-config.md#dynamodb-partition-key-name)
    //# configured on the [DynamoDB Item Encryptor](./ddb-item-encryptor.md).
    ensures output.Success? ==> config.partitionKeyName in input.encryptedItem

    //= specification/dynamodb-encryption-client/decrypt-item.md#dynamodb-item
    //= type=implication
    //# Otherwise this operation MUST yield an error.
    ensures config.partitionKeyName !in input.encryptedItem ==> output.Failure?

    //= specification/dynamodb-encryption-client/decrypt-item.md#dynamodb-item
    //= type=implication
    //# If the [DynamoDB Item Encryptor](./ddb-item-encryptor.md)
    //# has a [DynamoDB Sort Key Name](./ddb-table-encryption-config.md#dynamodb-sort-key-name) configured,
    //# this item MUST include an Attribute with that name.
    ensures output.Success? ==> config.sortKeyName.None? || config.sortKeyName.value in input.encryptedItem

    // Otherwise this operation MUST yield an error.
    ensures config.sortKeyName.Some? && config.sortKeyName.value !in input.encryptedItem ==> output.Failure?

    ensures 
      && output.Success?
      && !(config.internalLegacyConfig.Some? && config.internalLegacyConfig.value.IsLegacyInput(input))
      && (config.plaintextPolicy.FORBID_WRITE_FORBID_READ? || !IsPlaintextItem(input.encryptedItem))
    ==>
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
      //# - Encrypted Structured Data MUST be the Structured Data converted above.
      && DynamoToStruct.ItemToStructured(input.encryptedItem).Success?
      && var plaintextStructure := DynamoToStruct.ItemToStructured(input.encryptedItem).value;
      && Seq.Last(config.structuredEncryption.History.DecryptStructure).input.encryptedStructure
        == CSE.StructuredData(
          content := CSE.StructuredDataContent.DataMap(plaintextStructure),
          attributes := None)

      //= specification/dynamodb-encryption-client/decrypt-item.md#behavior
      //= type=implication
      //# - Encryption Context MUST be the input Item's [DynamoDB Item Base Context](./encrypt-item.md#dynamodb-item-base-context).
      && MakeEncryptionContext(config, plaintextStructure).Success?
      && Seq.Last(config.structuredEncryption.History.DecryptStructure).input.encryptionContext
        == Some(MakeEncryptionContext(config, plaintextStructure).value)

    //= specification/dynamodb-encryption-client/decrypt-item.md#behavior
    //= type=implication
    //# If a [Plaintext Policy](./ddb-encryption-table-config.md#plaintext-policy) of
    //# `REQUIRE_WRITE_ALLOW_READ` or `FORBID_WRITE_ALLOW_READ` is specified,
    //# and the input item [is a plaintext item](#determining-plaintext-items)
    //# this operation MUST NOT decrypt the input item,
    //# and MUST passthrough that item as the output.
    ensures
        && (|| config.plaintextPolicy.REQUIRE_WRITE_ALLOW_READ?
            || config.plaintextPolicy.FORBID_WRITE_ALLOW_READ?)
        && IsPlaintextItem(input.encryptedItem)
        && output.Success?
      ==>
        && output.value.plaintextItem == input.encryptedItem
  {
    :- Need(
      && config.partitionKeyName in input.encryptedItem
      && (config.sortKeyName.None? || config.sortKeyName.value in input.encryptedItem)
      , DynamoDbItemEncryptorException( message := "Configuration missmatch partition or sort key does not exist in item."));

    //= specification/dynamodb-encryption-client/decrypt-item.md#behavior
    //# If a [Legacy Policy](./ddb-encryption-table-config.md#legacy-policy) of
    //# `REQUIRE_ENCRYPT_ALLOW_DECRYPT` or `FORBID_ENCRYPT_ALLOW_DECRYPT` is configured,
    //# and the input item [is an item written in the legacy format](#determining-legacy-items),
    //# this operation MUST delegate decryption of this item to the
    //# [Legacy Encryptor](./ddb-encryption-table-config.md#legacy-encryptor),
    //# using the configured [Attribute Flags](./ddb-encryption-table-config.md) as input.
    // Note: InternalLegacyConfig.DecryptItem checks that the legacy policy is correct.
    if config.internalLegacyConfig.Some? && config.internalLegacyConfig.value.IsLegacyInput(input) {
      var decryptItemOutput :- config.internalLegacyConfig.value.DecryptItem(input);
      //= specification/dynamodb-encryption-client/decrypt-item.md#behavior
      //# The item returned by this operation MUST be the item outputted by the
      //# [Legacy Encryptor](./ddb-encryption-table-config.md#legacy-encryptor).
      return Success(decryptItemOutput);
    }

    if (
      && (|| config.plaintextPolicy.REQUIRE_WRITE_ALLOW_READ?
          || config.plaintextPolicy.FORBID_WRITE_ALLOW_READ?)
      && IsPlaintextItem(input.encryptedItem)
    ) {
      var passthroughOutput := DecryptItemOutput(plaintextItem := input.encryptedItem);
      return Success(passthroughOutput);
    }

    :- Need(!IsPlaintextItem(input.encryptedItem),
        DynamoDbItemEncryptorException(
            message := "Encrypted item missing expected header and footer attributes"));

    var encryptedStructure :- DynamoToStruct.ItemToStructured(input.encryptedItem)
        .MapFailure(e => Error.AwsCryptographyDynamoDbEncryption(e));
    var context :- MakeEncryptionContext(config, encryptedStructure);
    var authenticateSchema :- ConfigToAuthenticateSchema(config, input.encryptedItem)
        .MapFailure(e => Error.AwsCryptographyDynamoDbEncryption(e));
    var wrappedStruct := CSE.StructuredData(
      content := CSE.StructuredDataContent.DataMap(encryptedStructure),
      attributes := None);

    //= specification/dynamodb-encryption-client/decrypt-item.md#behavior
    //# This operation MUST create a
    //# [Required Encryption Context CMM](https://github.com/awslabs/private-aws-encryption-sdk-specification-staging/blob/dafny-verified/framework/required-encryption-context-cmm.md)
    //# with the following inputs:
    //# - This item encryptor's [CMM](./ddb-table-encryption-config.md#cmm) as the underlying CMM.
    //# - The keys from the [DynamoDB Item Base Context](./encrypt-item.md#dynamodb-item-base-context).

    var reqCMMR := config.cmpClient.CreateExpectedEncryptionContextCMM(
      CMP.CreateExpectedEncryptionContextCMMInput(
        underlyingCMM := Some(config.cmm),
        keyring := None,
        requiredEncryptionContextKeys := SortedSets.ComputeSetToOrderedSequence2(context.Keys, ByteLess)
      )
    );
    var reqCMM :- reqCMMR.MapFailure(e => AwsCryptographyMaterialProviders(e));

    var decryptRes := config.structuredEncryption.DecryptStructure(
      CSE.DecryptStructureInput(
        tableName := config.tableName,
        encryptedStructure := wrappedStruct,
        authenticateSchema := authenticateSchema,
        //= specification/dynamodb-encryption-client/decrypt-item.md#behavior
        //# - CMM MUST be the CMM constructed above.
        cmm:=reqCMM,
        encryptionContext:=Some(context)
      )
    );
    var decryptVal :- decryptRes.MapFailure(
        e => Error.AwsCryptographyDynamoDbEncryption(DDBE.AwsCryptographyStructuredEncryption(e)));
    var decryptedData := decryptVal.plaintextStructure;
    var ddbKey :- DynamoToStruct.StructuredToItem(decryptedData.content.DataMap)
        .MapFailure(e => Error.AwsCryptographyDynamoDbEncryption(e));
    output := Success(DecryptItemOutput(plaintextItem := ddbKey));
  }

  //= specification/dynamodb-encryption-client/decrypt-item.md#determining-plaintext-items
  //= type=TODO
  //# An item MUST be determined to be plaintext if it does not contain
  //# attributes with the names "aws_dbe_header" and "aws_dbe_footer".
}
