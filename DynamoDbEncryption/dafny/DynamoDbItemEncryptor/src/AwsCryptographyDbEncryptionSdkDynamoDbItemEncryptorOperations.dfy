// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "../../DynamoDbEncryption/src/DynamoToStruct.dfy"
include "Util.dfy"
include "InternalLegacyOverride.dfy"
include "../../StructuredEncryption/src/Util.dfy"

module AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations refines AbstractAwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations {
  import ComAmazonawsDynamodbTypes
  import opened DynamoDbItemEncryptorUtil
  import CMP = AwsCryptographyMaterialProvidersTypes
  import StructuredEncryption
  import DynamoToStruct
  import SortedSets
  import Base64
  import opened StandardLibrary
  import Seq
  import CSE = AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes
  import SE =  StructuredEncryptionUtil
  import InternalLegacyOverride
  import MaterialProviders
  import RequiredEncryptionContextCMM
  import SET = AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes
  import DDBE = AwsCryptographyDbEncryptionSdkDynamoDbTypes
  import StandardLibrary.String
  import StructuredEncryptionHeader

  datatype Config = Config(
    nameonly version : StructuredEncryptionHeader.Version,
    nameonly cmpClient : MaterialProviders.MaterialProvidersClient,
    nameonly logicalTableName: string,
    nameonly partitionKeyName: ComAmazonawsDynamodbTypes.KeySchemaAttributeName,
    nameonly sortKeyName: Option<ComAmazonawsDynamodbTypes.KeySchemaAttributeName>,
    nameonly cmm: CMP.ICryptographicMaterialsManager,
    nameonly attributeActionsOnEncrypt: DDBE.AttributeActions,
    nameonly allowedUnsignedAttributes: Option<ComAmazonawsDynamodbTypes.AttributeNameList>,
    nameonly allowedUnsignedAttributePrefix: Option<string>,
    nameonly algorithmSuiteId: Option<CMP.DBEAlgorithmSuiteId>,
    nameonly structuredEncryption: StructuredEncryption.StructuredEncryptionClient,
    nameonly plaintextOverride: DDBE.PlaintextOverride,
    nameonly internalLegacyOverride: Option<InternalLegacyOverride.InternalLegacyOverride> := None
  )

  type InternalConfig = Config
  type ValidConfig = x : Config | ValidInternalConfig?(x) witness *

  // Is the attribute name an allowed unauthenticated name?
  predicate method AllowedUnsigned(
    unauthenticatedAttributes: Option<ComAmazonawsDynamodbTypes.AttributeNameList>,
    unauthenticatedPrefix: Option<string>,
    attr : string)
  {
    || (unauthenticatedAttributes.Some? && attr in unauthenticatedAttributes.value)
    || (unauthenticatedPrefix.Some? && unauthenticatedPrefix.value <= attr)
    || ReservedPrefix <= attr
       // Attributes with the reserved prefix are "allowed unauthenticated" in that
       // they are not specified as signed within attributeActionsOnEncrypt.
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
      AllowedUnsigned(unauthenticatedAttributes, unauthenticatedPrefix, attribute)
    else
      !AllowedUnsigned(unauthenticatedAttributes, unauthenticatedPrefix, attribute)
  }

  function method CryptoActionString(action: CSE.CryptoAction) : string
  {
    if action == CSE.DO_NOTHING then
      "DO_NOTHING"
    else if action == CSE.SIGN_ONLY then
      "SIGN_ONLY"
    else if action == CSE.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT then
      "SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT"
    else if action == CSE.ENCRYPT_AND_SIGN then
      "ENCRYPT_AND_SIGN"
    else
      assert false by {
        assert action != CSE.DO_NOTHING;
        assert action != CSE.SIGN_ONLY;
        assert action != CSE.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT;
        assert action != CSE.ENCRYPT_AND_SIGN;
      }
      "internal error"
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
    && attr !in config.attributeActionsOnEncrypt
       // Attributes in signature scope MUST be configured in attributeActionsOnEncrypt
       // so these two lines are saying "in scope && not in scope"
       // and that's why it's an error
  }

  // Is the attribute name in signature scope?
  predicate method InSignatureScope(config : InternalConfig, attr : ComAmazonawsDynamodbTypes.AttributeName)
  {
    !AllowedUnsigned(
      config.allowedUnsignedAttributes,
      config.allowedUnsignedAttributePrefix,
      attr)
  }

  function method EncodeName(k : string) : (ret : Result<UTF8.ValidUTF8Bytes, Error>)
    ensures ret == DDBEncode(SE.ATTR_PREFIX + k)
  {
    DDBEncode(SE.ATTR_PREFIX + k)
  }

  function method MakeEncryptionContextForEncrypt(
    config : InternalConfig,
    item : DynamoToStruct.TerminalDataMap)
    : (ret : Result<CMP.EncryptionContext, Error>)
    //= specification/dynamodb-encryption-client/encrypt-item.md#dynamodb-item-base-context
    //= type=implication
    //# If the [Configuration Version](./ddb-table-encryption-config.md#configuration-version) is 2,
    //# then the base context MUST be the [version 2](#dynamodb-item-base-context-version-2) context;
    //# otherwise, the base context MUST be the [version 1](#dynamodb-item-base-context-version-1) context.
    ensures config.version == 2 ==> ret == MakeEncryptionContextV2(config, item)
    ensures config.version == 1 ==> ret == MakeEncryptionContextV1(config, item)
    ensures (config.version == 1) || (config.version == 2)
  {
    if config.version == 2 then
      MakeEncryptionContextV2(config, item)
    else
      MakeEncryptionContextV1(config, item)
  }

  function method MakeEncryptionContextForDecrypt(
    config : InternalConfig,
    header : seq<uint8>,
    item : DynamoToStruct.TerminalDataMap)
    : (ret : Result<CMP.EncryptionContext, Error>)
    requires 0 < |header|
    ensures ret.Success? ==>
              //= specification/dynamodb-encryption-client/decrypt-item.md#dynamodb-item-base-context
              //= type=implication
              //# If the Version Number is 2, then the base context MUST be the [version 2](./encrypt-item.md#dynamodb-item-base-context-version-2) context.
              && (header[0] == 2 ==> ret == MakeEncryptionContextV2(config, item))
                 //= specification/dynamodb-encryption-client/decrypt-item.md#dynamodb-item-base-context
                 //= type=implication
                 //# If the Version Number is 1, the base context MUST be the [version 1](./encrypt-item.md#dynamodb-item-base-context-version-1) context.
              && (header[0] == 1 ==> ret == MakeEncryptionContextV1(config, item))
              && ((header[0] == 1) || (header[0] == 2))

    //= specification/dynamodb-encryption-client/decrypt-item.md#dynamodb-item-base-context
    //= type=implication
    //# If the Version Number is not 1 or 2, the operation MUST return an error.
    ensures ((header[0] != 1) && (header[0] != 2)) ==> ret.Failure?
  {
    if header[0] == 2 then
      MakeEncryptionContextV2(config, item)
    else if header[0] == 1 then
      MakeEncryptionContextV1(config, item)
    else
      Failure(E("Header attribute has unexpected version number"))
  }

  function method {:opaque} {:vcs_split_on_every_assert} MakeEncryptionContextV1(
    config : InternalConfig,
    item : DynamoToStruct.TerminalDataMap)
    : (ret : Result<CMP.EncryptionContext, Error>)

    //= specification/dynamodb-encryption-client/encrypt-item.md#dynamodb-item-base-context-version-1
    //= type=implication
    //# The DynamoDB Item Base Context MUST contain:
    //# - the key "aws-crypto-table-name" with a value equal to the configured
    //# [logical table name](./ddb-table-encryption-config.md#logical-table-name).
    //# - the key "aws-crypto-partition-name" with a value equal to the name of the Partition Key on this item.
    //# - the [value](#base-context-value-version-1) of the Partition Key.
    ensures ret.Success? ==>
              && config.partitionKeyName in item
              && TABLE_NAME in ret.value
              && DDBEncode(config.logicalTableName).Success?
              && var logicalTableName : ValidUTF8Bytes := DDBEncode(config.logicalTableName).value;
              && ret.value[TABLE_NAME] == logicalTableName

              && PARTITION_NAME in ret.value
              && DDBEncode(config.partitionKeyName).Success?
              && var partitionName : ValidUTF8Bytes := DDBEncode(config.partitionKeyName).value;
              && ret.value[PARTITION_NAME] == partitionName

              && EncodeName(config.partitionKeyName).Success?
              && var partitionKeyName : ValidUTF8Bytes := EncodeName(config.partitionKeyName).value;
              && var partitionKeyValue : ValidUTF8Bytes := SE.EncodeTerminal(item[config.partitionKeyName]);
              && partitionKeyName in ret.value
              && ret.value[partitionKeyName] == partitionKeyValue

    //= specification/dynamodb-encryption-client/encrypt-item.md#dynamodb-item-base-context-version-1
    //= type=implication
    //# If this item has a Sort Key attribute, the DynamoDB Item Base Context MUST contain:
    //# - the key "aws-crypto-sort-name" with a value equal to the [DynamoDB Sort Key Name](./ddb-table-encryption-config.md#dynamodb-sort-key-name).
    //# - the [value](#base-context-value-version-1) of the Sort Key.
    ensures ret.Success? && config.sortKeyName.Some? ==>
              && config.sortKeyName.value in item
              && SORT_NAME in ret.value
              && DDBEncode(config.sortKeyName.value).Success?
              && var sortName := DDBEncode(config.sortKeyName.value).value;
              && ret.value[SORT_NAME] == sortName

              && EncodeName(config.sortKeyName.value).Success?
              && var sortKeyName : ValidUTF8Bytes := EncodeName(config.sortKeyName.value).value;
              && sortKeyName in ret.value
              && var sortKeyValue : ValidUTF8Bytes := SE.EncodeTerminal(item[config.sortKeyName.value]);
              && ret.value[sortKeyName] == sortKeyValue

    //= specification/dynamodb-encryption-client/encrypt-item.md#dynamodb-item-base-context-version-1
    //= type=implication
    //# If this item does not have a sort key attribute,
    //# the DynamoDB Item Context MUST NOT contain the key `aws-crypto-sort-name`.
    ensures ret.Success? && config.sortKeyName.None? ==>
              SORT_NAME !in ret.value
  {
    UTF8.EncodeAsciiUnique();
    :- FNeed(config.partitionKeyName in item, () => DDBError("Partition key " + config.partitionKeyName + " not found in Item to be encrypted or decrypted"));
    var logicalTableName : ValidUTF8Bytes :- DDBEncode(config.logicalTableName);
    var partitionName : ValidUTF8Bytes :- DDBEncode(config.partitionKeyName);
    var partitionKeyName : ValidUTF8Bytes :- EncodeName(config.partitionKeyName);
    var partitionKeyValue : ValidUTF8Bytes := SE.EncodeTerminal(item[config.partitionKeyName]);
    if (config.sortKeyName.None?) then
      :- Need(|{TABLE_NAME, PARTITION_NAME, SORT_NAME, partitionKeyName}| == 4, E("Internal Error"));
      var ec : CMP.EncryptionContext :=
        map[
          TABLE_NAME := logicalTableName,
          PARTITION_NAME := partitionName,
          partitionKeyName := partitionKeyValue
        ];
      assert TABLE_NAME in ec;
      assert PARTITION_NAME in ec;
      assert partitionKeyName in ec;
      assert SORT_NAME !in ec;
      assert ec[TABLE_NAME] == logicalTableName;
      assert ec[PARTITION_NAME] == partitionName;
      assert ec[partitionKeyName] == partitionKeyValue;
      Success(ec)
    else
      :- Need(config.sortKeyName.value in item, DDBError("Sort key " + config.sortKeyName.value + " not found in Item to be encrypted or decrypted"));
      var sortName :- DDBEncode(config.sortKeyName.value);
      var sortKeyName : ValidUTF8Bytes :- EncodeName(config.sortKeyName.value);
      var sortKeyValue : ValidUTF8Bytes := SE.EncodeTerminal(item[config.sortKeyName.value]);
      :- Need(|{TABLE_NAME, PARTITION_NAME, partitionKeyName, SORT_NAME, sortKeyName}| == 5, E("Internal Error"));
      var ec : CMP.EncryptionContext :=
        map[
          TABLE_NAME := logicalTableName,
          PARTITION_NAME := partitionName,
          partitionKeyName := partitionKeyValue,
          SORT_NAME := sortName,
          sortKeyName := sortKeyValue
        ];
      assert TABLE_NAME in ec;
      assert PARTITION_NAME in ec;
      assert partitionKeyName in ec;
      assert SORT_NAME in ec;
      assert sortKeyName in ec;
      assert ec[TABLE_NAME] == logicalTableName;
      assert ec[PARTITION_NAME] == partitionName;
      assert ec[partitionKeyName] == partitionKeyValue;
      assert ec[SORT_NAME] == sortName;
      assert ec[sortKeyName] == sortKeyValue;
      Success(ec)
  }

  function method {:opaque} {:vcs_split_on_every_assert} MakeEncryptionContextV2(
    config : InternalConfig,
    item : DynamoToStruct.TerminalDataMap)
    : (ret : Result<CMP.EncryptionContext, Error>)

    //= specification/dynamodb-encryption-client/encrypt-item.md#dynamodb-item-base-context-version-2
    //= type=implication
    //# The DynamoDB Item Base Context MUST contain:
    //#  - the key "aws-crypto-table-name" with a value equal to the DynamoDB Table Name of the DynamoDB Table
    //#    this item is stored in (or will be stored in).
    //#  - the key "aws-crypto-partition-name" with a value equal to the name of the Partition Key on this item.
    ensures ret.Success? ==>
              && config.partitionKeyName in item
              && TABLE_NAME in ret.value
              && DDBEncode(config.logicalTableName).Success?
              && var logicalTableName : ValidUTF8Bytes := DDBEncode(config.logicalTableName).value;
              && ret.value[TABLE_NAME] == logicalTableName

              && PARTITION_NAME in ret.value
              && DDBEncode(config.partitionKeyName).Success?
              && var partitionName : ValidUTF8Bytes := DDBEncode(config.partitionKeyName).value;
              && ret.value[PARTITION_NAME] == partitionName

    //= specification/dynamodb-encryption-client/encrypt-item.md#dynamodb-item-base-context-version-2
    //= type=implication
    //# If this item has a Sort Key attribute, the DynamoDB Item Base Context MUST contain:
    //#  - the key "aws-crypto-sort-name" with a value equal to the [DynamoDB Sort Key Name](./ddb-table-encryption-config.md#dynamodb-sort-key-name).
    ensures ret.Success? && config.sortKeyName.Some? ==>
              && config.sortKeyName.value in item
              && SORT_NAME in ret.value
              && DDBEncode(config.sortKeyName.value).Success?
              && var sortName := DDBEncode(config.sortKeyName.value).value;
              && ret.value[SORT_NAME] == sortName

    //= specification/dynamodb-encryption-client/encrypt-item.md#dynamodb-item-base-context-version-2
    //= type=implication
    //# If this item does not have a sort key attribute,
    //# the DynamoDB Item Context MUST NOT contain the key `aws-crypto-sort-name`.
    ensures ret.Success? && config.sortKeyName.None? ==>
              SORT_NAME !in ret.value
  {
    UTF8.EncodeAsciiUnique();
    :- Need(config.partitionKeyName in item, DDBError("Partition key " + config.partitionKeyName + " not found in Item to be encrypted or decrypted"));
    var logicalTableName : ValidUTF8Bytes :- DDBEncode(config.logicalTableName);
    var partitionName : ValidUTF8Bytes :- DDBEncode(config.partitionKeyName);
    var partitionKeyName : ValidUTF8Bytes :- EncodeName(config.partitionKeyName);
    if (config.sortKeyName.None?) then
      assert |{TABLE_NAME, PARTITION_NAME, SORT_NAME}| == 3;
      var ec : CMP.EncryptionContext :=
        map[
          TABLE_NAME := logicalTableName,
          PARTITION_NAME := partitionName
        ];
      assert TABLE_NAME in ec;
      assert PARTITION_NAME in ec;
      assert SORT_NAME !in ec;
      assert ec[TABLE_NAME] == logicalTableName;
      assert ec[PARTITION_NAME] == partitionName;
      Success(ec)
    else
      :- Need(config.sortKeyName.value in item, DDBError("Sort key " + config.sortKeyName.value + " not found in Item to be encrypted or decrypted"));
      var sortName :- DDBEncode(config.sortKeyName.value);
      var sortKeyName : ValidUTF8Bytes :- EncodeName(config.sortKeyName.value);
      assert |{TABLE_NAME, PARTITION_NAME, SORT_NAME}| == 3;
      var ec : CMP.EncryptionContext :=
        map[
          TABLE_NAME := logicalTableName,
          PARTITION_NAME := partitionName,
          SORT_NAME := sortName
        ];
      assert TABLE_NAME in ec;
      assert PARTITION_NAME in ec;
      assert SORT_NAME in ec;
      assert ec[TABLE_NAME] == logicalTableName;
      assert ec[PARTITION_NAME] == partitionName;
      assert ec[SORT_NAME] == sortName;
      Success(ec)
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

  predicate method IsVersion2Schema(actions : DDBE.AttributeActions)
  {
    exists x <- actions :: actions[x] == CSE.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT
  }
  function method VersionFromActions(actions : DDBE.AttributeActions) : (ret : StructuredEncryptionHeader.Version)
    //= specification/dynamodb-encryption-client/ddb-table-encryption-config.md#configuration-version
    //= type=implication
    //# If any of the [Attribute Actions](#attribute-actions) are configured as
    //# [SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT](../structured-encryption/structures.md#contextandsign)
    //# then the configuration version MUST be 2; otherwise,
    //# the configuration version MUST be 1.
    ensures (exists x <- actions :: actions[x] == CSE.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT) <==> ret == 2
    ensures !(exists x <- actions :: actions[x] == CSE.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT) <==> ret == 1
  {
    if IsVersion2Schema(actions) then
      2
    else
      1
  }
  function method KeyActionFromVersion(version : StructuredEncryptionHeader.Version) : (ret : CSE.CryptoAction)
    //= specification/dynamodb-encryption-client/ddb-table-encryption-config.md#key-action
    //= type=implication
    //# if the [configuration version](#configuration-version) is 2, then
    //# the key action MUST be [SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT](../structured-encryption/structures.md#contextandsign);
    //# otherwise, the key action MUST be [SIGN_ONLY](../structured-encryption/structures.md#signonly).
    ensures version == 1 <==> ret == CSE.SIGN_ONLY
    ensures version == 2 <==> ret == CSE.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT
  {
    assert StructuredEncryptionHeader.ValidVersion(version);
    assert version == 1 || version == 2;
    if version == 2 then
      CSE.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT
    else
      CSE.SIGN_ONLY
  }
  function method KeyActionStringFromVersion(version : StructuredEncryptionHeader.Version) : string
  {
    if version == 2 then
      "SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT"
    else
      "SIGN_ONLY"
  }

  predicate ValidInternalConfig?(config: InternalConfig)
  {
    && config.cmm.ValidState()
    && config.cmpClient.ValidState()
    && config.cmm.Modifies !! {config.cmpClient.History}
    && config.structuredEncryption.ValidState()
    && (config.cmm.Modifies !! config.structuredEncryption.Modifies)

    // The partition key MUST be CSE.SIGN_ONLY
    && config.partitionKeyName in config.attributeActionsOnEncrypt
    && config.attributeActionsOnEncrypt[config.partitionKeyName] == KeyActionFromVersion(config.version)
       // The sort key MUST be CSE.SIGN_ONLY
    && (config.sortKeyName.Some? ==>
          && config.sortKeyName.value in config.attributeActionsOnEncrypt
          && config.attributeActionsOnEncrypt[config.sortKeyName.value] == KeyActionFromVersion(config.version))

    // attributeActionsOnEncrypt only apply on Encrypt.
    // The config on Encrypt MAY NOT be the same as the config on Decrypt.
    // This means that Encrypt MUST be "forward compatible" with Decrypt.
    // Every current and *past* CSE.DO_NOTHING action
    // MUST be derivable from allowedUnsigned information
    // otherwise Decrypt will attempt to authenticate an attribute that was unauthenticated on Encrypt.
    // Also, every current and *past* CSE.ENCRYPT_AND_SIGN or CSE.SIGN_ONLY action
    // MUST NOT overlap with allowedUnsigned information
    // otherwise Decrypt will not authenticate at attribute that was authenticate on Encrypt.
    // For this to work the scope of allowedUnsigned information MUST only increase.
    // This means that an attribute that is added to allowedUnsignedAttributes
    // MUST NOT ever be removed.
    // This means that is a allowedUnsignedAttributePrefix is added
    // allowedUnsignedAttributePrefix <= old(allowedUnsignedAttributePrefix).
    // The simple case is do not change allowedUnsignedAttributePrefix.
    // But allowedUnsignedAttributePrefix MAY get shorter,
    // however this is a dangerous operation as it may impact other attributes.
    //= specification/dynamodb-encryption-client/decrypt-item.md#signature-scope
    //# If an Authenticate Action other than DO_NOTHING is configured for an attribute name included in [Unauthenticated Attributes](./ddb-table-encryption-config.md#unauthenticated-attributes)
    //# or beginning with the prefix specified in [Unauthenticated Attribute Prefix](./ddb-table-encryption-config.md#unauthenticated-attribute-prefix),
    //# this operation MUST yield an error.
    && (forall attribute <- config.attributeActionsOnEncrypt.Keys
          :: ForwardCompatibleAttributeAction(
               attribute,
               config.attributeActionsOnEncrypt[attribute],
               config.allowedUnsignedAttributes,
               config.allowedUnsignedAttributePrefix))

    // It is forbidden to explicitly configure an attribute with the reserved prefix
    && (forall attribute <- config.attributeActionsOnEncrypt.Keys ::
          !(ReservedPrefix <= attribute))

    && (config.internalLegacyOverride.Some? ==> config.plaintextOverride.FORBID_PLAINTEXT_WRITE_FORBID_PLAINTEXT_READ?)
    && (
         (|| config.plaintextOverride.FORBID_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ?
          || config.plaintextOverride.FORCE_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ?)
         ==>
           config.internalLegacyOverride.None?)
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
    ensures (attr !in config.attributeActionsOnEncrypt && InSignatureScope(config, attr)) ==> ret.Failure?
  {
    if attr in config.attributeActionsOnEncrypt then
      Success(config.attributeActionsOnEncrypt[attr])
    else if !InSignatureScope(config, attr) then
      Success(CSE.CryptoAction.DO_NOTHING)
    else
      Failure("No Crypto Action configured for attribute " + attr)
  }

  // get Crypto Action and wrap in CryptoSchema
  function method GetCryptoSchemaAction(
    config : InternalConfig,
    attr : ComAmazonawsDynamodbTypes.AttributeName)
    : (ret : Result<CSE.CryptoAction, string>)
    ensures (attr !in config.attributeActionsOnEncrypt && InSignatureScope(config, attr)) ==> ret.Failure?
  {
    GetCryptoSchemaActionInner(config, attr)
  }

  // return proper Authenticate Action by name
  function method GetAuthenticateSchemaAction(
    config : InternalConfig,
    attr : ComAmazonawsDynamodbTypes.AttributeName)
    : (ret : CSE.AuthenticateAction)
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
    ensures (ret == CSE.DO_NOT_SIGN) <==> !InSignatureScope(config, attr)
  {
    if InSignatureScope(config, attr) then
      CSE.SIGN
    else
      CSE.DO_NOT_SIGN
  }

  // get CryptoSchema for this item
  function method ConfigToCryptoSchema(
    config : InternalConfig,
    item : DynamoToStruct.TerminalDataMap)
    : (ret : Result<CSE.CryptoSchemaMap, DDBE.Error>)

    //= specification/dynamodb-encryption-client/encrypt-item.md#behavior
    //= type=implication
    //# The [Attributes Actions](./ddb-table-encryption-config.md#attribute-actions)
    //# configured on this Item Encryptor MUST specify a Crypto Action
    //# for every attribute in the [input DynamoDB Item](#dynamodb-item)
    //# (Attribute Actions MAY specify a Crypto Action for an attribute not
    //# in the input DynamoDB Item).
    ensures forall k <- item.Keys ::
              (k !in config.attributeActionsOnEncrypt && InSignatureScope(config, k)) ==> ret.Failure?

    //= specification/dynamodb-encryption-client/encrypt-item.md#behavior
    //= type=implication
    //# - The Crypto Schema MUST NOT contain more Crypto Actions than those specified by the previous point.
    ensures ret.Success? ==> item.Keys == ret.value.Keys

    //= specification/dynamodb-encryption-client/encrypt-item.md#behavior
    //= type=implication
    //# - For every attribute on the input Item,
    //# there MUST exist a Crypto Action in the Crypto Schema
    //# such that the Crypto Action indexed by that attribute name in the Crypto Schema
    //# equals the Crypto Action indexed by that attribute name in the configured Attribute Actions.
    ensures ret.Success? ==> forall k <-item.Keys ::
                && GetCryptoSchemaAction(config, k).Success?
                && ret.value[k] == GetCryptoSchemaAction(config, k).value
                && (k in config.attributeActionsOnEncrypt ==>
                      ret.value[k] == config.attributeActionsOnEncrypt[k])
  {
    var schema := map k <- item :: k := GetCryptoSchemaAction(config, k);
    DynamoToStruct.MapKeysMatchItems(item);
    DynamoToStruct.SimplifyMapValueSuccess(schema);
    var actionMapRes := DynamoToStruct.SimplifyMapValue(schema);
    assert actionMapRes.Failure? ==> exists kv <- item.Items :: GetCryptoSchemaAction(config, kv.0).Failure?;
    assert actionMapRes.Failure? <==> exists k <- item.Keys :: schema[k].Failure?;
    assert actionMapRes.Failure? <==> exists k <- item.Keys :: GetCryptoSchemaAction(config, k).Failure?;

    DynamoToStruct.MapError(actionMapRes)
  }

  // get AuthenticateSchema for this item
  function method ConfigToAuthenticateSchema(
    config : InternalConfig,
    item : DynamoToStruct.TerminalDataMap)
    : (ret : CSE.AuthenticateSchemaMap)
    requires ValidInternalConfig?(config)

    //= specification/dynamodb-encryption-client/decrypt-item.md#behavior
    //= type=implication
    //# - The number of Authenticate Actions in the Authenticate Schema
    //# MUST EQUAL the number of Attributes on the [input DynamoDB Item](#input-dynamodb-item).
    ensures item.Keys == ret.Keys

    //= specification/dynamodb-encryption-client/decrypt-item.md#behavior
    //= type=implication
    //# - For every Attribute in the [input DynamoDB Item](#input-dynamodb-item)
    //# that is not in the [signature scope](#signature-scope),
    //# there MUST exist a [DO_NOT_SIGN Authenticate Action](../structured-encryption/structures.md#do_not_sign)
    //# in the Authenticate Schema,
    //# string indexed at the top level by that attribute name.
    ensures forall k <-item.Keys :: !InSignatureScope(config, k) ==> ret[k] == CSE.DO_NOT_SIGN

    //= specification/dynamodb-encryption-client/decrypt-item.md#behavior
    //= type=implication
    //# - For every Attribute in the [input DynamoDB Item](#input-dynamodb-item)
    //# that is in the [signature scope](#signature-scope),
    //# there MUST exist a [SIGN Authenticate Action](../structured-encryption/structures.md#sign)
    //# in the Authenticate Schema,
    //# string indexed at the top level by that attribute name.
    ensures forall k <-item.Keys :: InSignatureScope(config, k) ==> ret[k] == CSE.SIGN
  {
    map k <- item | true :: k := GetAuthenticateSchemaAction(config, k)
  }

  //= specification/dynamodb-encryption-client/decrypt-item.md#determining-plaintext-items
  //= type=implication
  //# An item MUST be determined to be plaintext if it does not contain
  //# attributes with the names "aws_dbe_head" and "aws_dbe_foot".
  predicate method IsPlaintextItem(ddbItem: ComAmazonawsDynamodbTypes.AttributeMap) {
    && SE.HeaderField !in ddbItem
    && SE.FooterField !in ddbItem
  }

  function method ConvertCryptoSchemaToAttributeActions(config: ValidConfig, schema: CSE.CryptoSchemaMap)
    : (ret: Result<map<ComAmazonawsDynamodbTypes.AttributeName, CSE.CryptoAction>, Error>)
    requires forall k <- schema :: SE.IsAuthAttr(schema[k])
    ensures ret.Success? ==> forall k <- ret.value.Keys :: InSignatureScope(config, k)
    ensures ret.Success? ==> forall k <- ret.value.Keys :: !ret.value[k].DO_NOTHING?
  {
    assert forall k <- schema :: SE.IsAuthAttr(schema[k]);
    assert forall k <- schema :: !schema[k].DO_NOTHING?;
    :- Need(forall k <- schema :: InSignatureScope(config, k),
            DynamoDbItemEncryptorException( message := "Received unexpected Crypto Schema: mismatch with signature scope"));
    :- Need(forall k <- schema :: ComAmazonawsDynamodbTypes.IsValid_AttributeName(k),
            DynamoDbItemEncryptorException( message := "Received unexpected Crypto Schema: Invalid attribute names"));
    Success(schema)
  }

  predicate EncryptItemEnsuresPublicly(input: EncryptItemInput, output: Result<EncryptItemOutput, Error>)
  {true}

  function method GetItemNames(item : ComAmazonawsDynamodbTypes.AttributeMap) : string
  {
    // We happen to order these values, but this ordering MUST NOT be relied upon.
    var keys := SortedSets.ComputeSetToOrderedSequence2(item.Keys, CharLess);
    if |keys| == 0 then
      "item is empty"
    else
      Join(keys, " ")
  }

  function method KeyMissingMsg(
    config: InternalConfig,
    item : ComAmazonawsDynamodbTypes.AttributeMap,
    tag : string)
    : string
  {
    "On " + tag + " : "
    +
    (if config.partitionKeyName !in item then
       "Partition key '" + config.partitionKeyName + "' does not exist in item. "
     else
       "")

    +
    (if config.sortKeyName.Some? &&  config.sortKeyName.value !in item then
       "Sort key '" + config.sortKeyName.value + "' does not exist in item. "
     else
       "")

    + "Item contains these attributes : "
    + GetItemNames(item) + "."
  }

  predicate method ContextAttrsExist(actions : DDBE.AttributeActions, item : DDB.AttributeMap)
  {
    forall k <- actions :: (actions[k] == CSE.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT) ==> (k in item)
  }
  function method ContextMissingMsg(actions : DDBE.AttributeActions, item : DDB.AttributeMap) : string
  {
    var s := set k <- actions |
                 && actions[k] == CSE.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT
                 && k !in item;
    var missing := SortedSets.ComputeSetToOrderedSequence2(s, CharLess);
    if |missing| == 0 then
      "No missing SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT attributes."
    else if |missing| == 1 then
      "Attribute " + missing[0] + " was configured with SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT but was not present in item to be encrypted."
    else
      "These attributes were configured with SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT but were not present in item to be encrypted."
      + Join(missing, ",")
  }

  // public Encrypt method
  method {:vcs_split_on_every_assert} EncryptItem(config: InternalConfig, input: EncryptItemInput)
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

    //= specification/dynamodb-encryption-client/encrypt-item.md#dynamodb-item
    //= type=implication
    //# If the [DynamoDB Item Encryptor](./ddb-item-encryptor.md)
    //# has any attribute configured as
    //# [SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT](../structured-encryption/structures.md#contextandsign)
    //# then this item MUST include an Attribute with that name.
    ensures output.Success? ==>
              forall k <- config.attributeActionsOnEncrypt :: (config.attributeActionsOnEncrypt[k] == CSE.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT) ==> (k in input.plaintextItem)
    // ContextAttrsExist(config.attributeActionsOnEncrypt, input.plaintextItem)

    ensures
      && output.Success?
      && !(config.internalLegacyOverride.Some? && config.internalLegacyOverride.value.policy.FORCE_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT?)
      && !(config.plaintextOverride.FORCE_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ?)
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
        //# - Structured Data MUST be the Structured Data converted above.
        && DynamoToStruct.ItemToStructured2(input.plaintextItem, config.attributeActionsOnEncrypt).Success?
        && var plaintextStructure := DynamoToStruct.ItemToStructured2(input.plaintextItem, config.attributeActionsOnEncrypt).value;
        && Seq.Last(config.structuredEncryption.History.EncryptStructure).input.plaintextStructure
           == plaintextStructure

        //= specification/dynamodb-encryption-client/encrypt-item.md#behavior
        //= type=implication
        //# - Crypto Schema MUST be a [Crypto Schema](../structured-encryption/structures.md#crypto-schema)
        //# analogous to the [configured Attribute Actions](./ddb-table-encryption-config.md#attribute-actions).
        && ConfigToCryptoSchema(config, plaintextStructure).Success?
        && Seq.Last(config.structuredEncryption.History.EncryptStructure).input.cryptoSchema
           == ConfigToCryptoSchema(config, plaintextStructure).value

        //= specification/dynamodb-encryption-client/encrypt-item.md#behavior
        //= type=implication
        //# - Encryption Context MUST be this input Item's [DynamoDB Item Base Context](#dynamodb-item-base-context).
        && MakeEncryptionContextForEncrypt(config, plaintextStructure).Success?
        && Seq.Last(config.structuredEncryption.History.EncryptStructure).input.encryptionContext
           == Some(MakeEncryptionContextForEncrypt(config, plaintextStructure).value)

        && output.value.parsedHeader.Some?
        && var structuredEncOut := Seq.Last(config.structuredEncryption.History.EncryptStructure).output.value;
        && var parsedHeaderMap := structuredEncOut.cryptoSchema;
        && (forall k <- parsedHeaderMap ::
              && SE.IsAuthAttr(parsedHeaderMap[k]))
        && var maybeCryptoSchema := ConvertCryptoSchemaToAttributeActions(config, structuredEncOut.cryptoSchema);
        && maybeCryptoSchema.Success?
        && ConvertContextForSelector(structuredEncOut.parsedHeader.encryptionContext).Success?
        && var selectorContext := ConvertContextForSelector(structuredEncOut.parsedHeader.encryptionContext).value;
        && output.value.parsedHeader.value == ParsedHeader(
                                                attributeActionsOnEncrypt := maybeCryptoSchema.value,
                                                algorithmSuiteId := structuredEncOut.parsedHeader.algorithmSuiteId,
                                                storedEncryptionContext := structuredEncOut.parsedHeader.storedEncryptionContext,
                                                encryptedDataKeys := structuredEncOut.parsedHeader.encryptedDataKeys,
                                                encryptionContext := structuredEncOut.parsedHeader.encryptionContext,
                                                selectorContext := selectorContext
                                              )

    //= specification/dynamodb-encryption-client/encrypt-item.md#behavior
    //= type=implication
    //# If a [Plaintext Policy](./ddb-table-encryption-config.md#plaintext-policy) of
    //# `FORCE_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ` is specified,
    //# this operation MUST NOT encrypt the input item,
    //# and MUST passthrough that item as the output.
    ensures
      && config.plaintextOverride.FORCE_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ?
      && output.Success?
      ==>
        && output.value.encryptedItem == input.plaintextItem
        && output.value.parsedHeader == None
  {
    :- Need(
      && config.partitionKeyName in input.plaintextItem
      && (config.sortKeyName.None? || config.sortKeyName.value in input.plaintextItem)
    , E(KeyMissingMsg(config, input.plaintextItem, "Encrypt")));

    :- Need(ContextAttrsExist(config.attributeActionsOnEncrypt, input.plaintextItem),
            E(ContextMissingMsg(config.attributeActionsOnEncrypt, input.plaintextItem)));

    //= specification/dynamodb-encryption-client/encrypt-item.md#behavior
    //# If a [Legacy Policy](./ddb-table-encryption-config.md#legacy-policy) of
    //# `FORCE_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT` is specified,
    //# this operation MUST delegate encryption of this item to the
    //# [Legacy Encryptor](./ddb-table-encryption-config.md#legacy-encryptor),
    //# using the configured [Attribute Flags](./ddb-table-encryption-config.md) as input.
    if config.internalLegacyOverride.Some? && config.internalLegacyOverride.value.policy.FORCE_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT? {
      var encryptItemOutput :- config.internalLegacyOverride.value.EncryptItem(input);
      //= specification/dynamodb-encryption-client/encrypt-item.md#behavior
      //# The item returned by this operation MUST be the item outputted by the
      //# [Legacy Encryptor](./ddb-table-encryption-config.md#legacy-encryptor).
      return Success(encryptItemOutput);
    }

    if (config.plaintextOverride.FORCE_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ?) {
      var passthroughOutput := EncryptItemOutput(
        encryptedItem := input.plaintextItem,
        parsedHeader := None
      );
      return Success(passthroughOutput);
    }

    var plaintextStructure :- DynamoToStruct.ItemToStructured2(input.plaintextItem, config.attributeActionsOnEncrypt)
    .MapFailure(e => Error.AwsCryptographyDbEncryptionSdkDynamoDb(e));
    var context :- MakeEncryptionContextForEncrypt(config, plaintextStructure);
    var cryptoSchema :- ConfigToCryptoSchema(config, plaintextStructure)
    .MapFailure(e => Error.AwsCryptographyDbEncryptionSdkDynamoDb(e));

    //= specification/dynamodb-encryption-client/encrypt-item.md#behavior
    //# This operation MUST create a
    //# [Required Encryption Context CMM](https://github.com/awslabs/private-aws-encryption-sdk-specification-staging/blob/dafny-verified/framework/required-encryption-context-cmm.md)
    //# with the following inputs:
    //# - This item encryptor's [CMM](./ddb-table-encryption-config.md#cmm) as the underlying CMM.
    //# - The keys from the [DynamoDB Item Base Context](#dynamodb-item-base-context)

    var contextKeysX : seq<seq<uint8>> := SortedSets.ComputeSetToOrderedSequence2(context.Keys, ByteLess);
    assert forall k <- contextKeysX :: ValidUTF8Seq(k) by {
      assert forall k <- contextKeysX :: k in context.Keys;
      assert forall k <- context.Keys :: ValidUTF8Seq(k);
    }

    var contextKeys : seq<CMP.Utf8Bytes> := contextKeysX;
    var reqCMMR := config.cmpClient.CreateRequiredEncryptionContextCMM(
      CMP.CreateRequiredEncryptionContextCMMInput(
        underlyingCMM := Some(config.cmm),
        keyring := None,
        requiredEncryptionContextKeys := contextKeys
      )
    );
    var reqCMM :- reqCMMR.MapFailure(e => AwsCryptographyMaterialProviders(e));
    var encryptRes := config.structuredEncryption.EncryptStructure(
      CSE.EncryptStructureInput(
        tableName := config.logicalTableName,
        plaintextStructure:=plaintextStructure,
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

    assert {:split_here} true;

    var encryptVal :- encryptRes.MapFailure(
      e => Error.AwsCryptographyDbEncryptionSdkDynamoDb(DDBE.AwsCryptographyDbEncryptionSdkStructuredEncryption(e)));
    var encryptedData := encryptVal.encryptedStructure;
    :- Need(forall k <- encryptedData :: DDB.IsValid_AttributeName(k), E(""));
    var ddbKey :- DynamoToStruct.StructuredToItemEncrypt(encryptedData, input.plaintextItem, config.attributeActionsOnEncrypt)
    .MapFailure(e => Error.AwsCryptographyDbEncryptionSdkDynamoDb(e));

    var parsedActions :- ConvertCryptoSchemaToAttributeActions(config, encryptVal.cryptoSchema);
    var selectorContextR := ConvertContextForSelector(encryptVal.parsedHeader.encryptionContext);
    var selectorContext :- selectorContextR.MapFailure(e => E(e));
    var parsedHeader := ParsedHeader(
      attributeActionsOnEncrypt := parsedActions,
      algorithmSuiteId := encryptVal.parsedHeader.algorithmSuiteId,
      storedEncryptionContext := encryptVal.parsedHeader.storedEncryptionContext,
      encryptedDataKeys := encryptVal.parsedHeader.encryptedDataKeys,
      encryptionContext := encryptVal.parsedHeader.encryptionContext,
      selectorContext := selectorContext
    );

    output := Success(EncryptItemOutput(
                        encryptedItem := ddbKey,
                        parsedHeader := Some(parsedHeader)
                      ));
  }

  predicate DecryptItemEnsuresPublicly(input: DecryptItemInput, output: Result<DecryptItemOutput, Error>)
  {true}

  // public Decrypt method
  method {:vcs_split_on_every_assert} DecryptItem(config: InternalConfig, input: DecryptItemInput)
    returns (output: Result<DecryptItemOutput, Error>)

    //= specification/dynamodb-encryption-client/decrypt-item.md#input-dynamodb-item
    //= type=implication
    //# This item MUST include an Attribute with a name that matches the
    //# [DynamoDB Partition Key Name](./ddb-table-encryption-config.md#dynamodb-partition-key-name)
    //# configured on the [DynamoDB Item Encryptor](./ddb-item-encryptor.md).
    ensures output.Success? ==> config.partitionKeyName in input.encryptedItem

    //= specification/dynamodb-encryption-client/decrypt-item.md#input-dynamodb-item
    //= type=implication
    //# Otherwise this operation MUST yield an error.
    ensures config.partitionKeyName !in input.encryptedItem ==> output.Failure?

    //= specification/dynamodb-encryption-client/decrypt-item.md#input-dynamodb-item
    //= type=implication
    //# If the [DynamoDB Item Encryptor](./ddb-item-encryptor.md)
    //# has a [DynamoDB Sort Key Name](./ddb-table-encryption-config.md#dynamodb-sort-key-name) configured,
    //# this item MUST include an Attribute with that name.
    ensures output.Success? ==> config.sortKeyName.None? || config.sortKeyName.value in input.encryptedItem

    // Otherwise this operation MUST yield an error.
    ensures config.sortKeyName.Some? && config.sortKeyName.value !in input.encryptedItem ==> output.Failure?

    ensures
      && output.Success?
      && !(config.internalLegacyOverride.Some? && config.internalLegacyOverride.value.IsLegacyInput(input))
      && (config.plaintextOverride.FORBID_PLAINTEXT_WRITE_FORBID_PLAINTEXT_READ? || !IsPlaintextItem(input.encryptedItem))
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
        //# - Encrypted Structured Data MUST be the Structured Data converted above.
        && DynamoToStruct.ItemToStructured2(input.encryptedItem, config.attributeActionsOnEncrypt).Success?
        && var plaintextStructure := DynamoToStruct.ItemToStructured2(input.encryptedItem, config.attributeActionsOnEncrypt).value;
        && Seq.Last(config.structuredEncryption.History.DecryptStructure).input.encryptedStructure
           == plaintextStructure

        //= specification/dynamodb-encryption-client/decrypt-item.md#behavior
        //= type=implication
        //# - Authenticate Schema MUST be a [Authenticate Schema](../structured-encryption/structures.md#crypto-schema)
        //# built with the following requirements:
        && Seq.Last(config.structuredEncryption.History.DecryptStructure).input.authenticateSchema
           == ConfigToAuthenticateSchema(config, plaintextStructure)

        //= specification/dynamodb-encryption-client/decrypt-item.md#dynamodb-item-base-context
        //= type=implication
        //# The item to be encrypted MUST have an attribute named `aws_dbe_head`.
        && SE.HeaderField in input.encryptedItem
        && var header := input.encryptedItem[SE.HeaderField];

        //= specification/dynamodb-encryption-client/decrypt-item.md#dynamodb-item-base-context
        //= type=implication
        //# The attribute named `aws_dbe_head` MUST be of type `B` Binary.
        && header.B?
        && 0 < |header.B|

        //= specification/dynamodb-encryption-client/decrypt-item.md#behavior
        //= type=implication
        //# - Encryption Context MUST be the input Item's [DynamoDB Item Base Context](./encrypt-item.md#dynamodb-item-base-context).
        && MakeEncryptionContextForDecrypt(config, header.B, plaintextStructure).Success?

        && Seq.Last(config.structuredEncryption.History.DecryptStructure).input.encryptionContext
           == Some(MakeEncryptionContextForDecrypt(config, header.B, plaintextStructure).value)

        //= specification/dynamodb-encryption-client/decrypt-item.md#output
        //= type=implication
        //# This operation MUST also output a [Parsed Header](#parsed-header) if the following is true:
        //# - The operation is not using a [Legacy Policy](./ddb-table-encryption-config.md#legacy-policy) that allows legacy decrypts,
        //#   and the input item is a [legacy item](#determining-legacy-items).
        //# - The operation is not using a [Plaintext Policy](./ddb-table-encryption-config.md#plaintext-policy) that allows plaintext reads,
        //#   and the input item is a [plaintext item](#determining-plaintext-items).

        //= specification/dynamodb-encryption-client/decrypt-item.md#behavior
        //= type=implication
        //# The output MUST also include a [Parsed Header](#parsed-header) that contains
        //# data that was serialized into the header included in the output DynamoDb Item.
        && output.value.parsedHeader.Some?
        && var structuredEncOut := Seq.Last(config.structuredEncryption.History.DecryptStructure).output.value;
        && (forall k <- structuredEncOut.cryptoSchema ::
              && SE.IsAuthAttr(structuredEncOut.cryptoSchema[k]))
        && var maybeCryptoSchema := ConvertCryptoSchemaToAttributeActions(config, structuredEncOut.cryptoSchema);
        && maybeCryptoSchema.Success?
        && ConvertContextForSelector(structuredEncOut.parsedHeader.encryptionContext).Success?
        && var selectorContext := ConvertContextForSelector(structuredEncOut.parsedHeader.encryptionContext).value;
        && output.value.parsedHeader.value == ParsedHeader(
                                                attributeActionsOnEncrypt := maybeCryptoSchema.value,
                                                algorithmSuiteId := structuredEncOut.parsedHeader.algorithmSuiteId,
                                                storedEncryptionContext := structuredEncOut.parsedHeader.storedEncryptionContext,
                                                encryptedDataKeys := structuredEncOut.parsedHeader.encryptedDataKeys,
                                                encryptionContext := structuredEncOut.parsedHeader.encryptionContext,
                                                selectorContext := selectorContext
                                              )

    //= specification/dynamodb-encryption-client/decrypt-item.md#behavior
    //= type=implication
    //# If a [Plaintext Policy](./ddb-table-encryption-config.md#plaintext-policy) of
    //# `FORCE_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ` or `FORBID_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ` is specified,
    //# and the input item [is a plaintext item](#determining-plaintext-items)
    //# this operation MUST NOT decrypt the input item,
    //# and MUST passthrough that item as the output.
    ensures
      && (|| config.plaintextOverride.FORCE_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ?
          || config.plaintextOverride.FORBID_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ?)
      && IsPlaintextItem(input.encryptedItem)
      && output.Success?
      ==>
        && output.value.plaintextItem == input.encryptedItem
        && output.value.parsedHeader == None
  {
    :- Need(
      && config.partitionKeyName in input.encryptedItem
      && (config.sortKeyName.None? || config.sortKeyName.value in input.encryptedItem)
    , DynamoDbItemEncryptorException( message := KeyMissingMsg(config, input.encryptedItem, "Decrypt")));

    //= specification/dynamodb-encryption-client/decrypt-item.md#behavior
    //# If a [Legacy Policy](./ddb-table-encryption-config.md#legacy-policy) of
    //# `FORCE_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT` or `FORBID_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT` is configured,
    //# and the input item [is an item written in the legacy format](#determining-legacy-items),
    //# this operation MUST delegate decryption of this item to the
    //# [Legacy Encryptor](./ddb-table-encryption-config.md#legacy-encryptor),
    //# using the configured [Attribute Flags](./ddb-table-encryption-config.md) as input.
    // Note: InternalLegacyOverride.DecryptItem checks that the legacy policy is correct.
    if config.internalLegacyOverride.Some? && config.internalLegacyOverride.value.IsLegacyInput(input) {
      var decryptItemOutput :- config.internalLegacyOverride.value.DecryptItem(input);
      //= specification/dynamodb-encryption-client/decrypt-item.md#behavior
      //# The item returned by this operation MUST be the item outputted by the
      //# [Legacy Encryptor](./ddb-table-encryption-config.md#legacy-encryptor).
      return Success(decryptItemOutput);
    }

    if (
        && (|| config.plaintextOverride.FORCE_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ?
            || config.plaintextOverride.FORBID_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ?)
        && IsPlaintextItem(input.encryptedItem)
      ) {
      var passthroughOutput := DecryptItemOutput(
        plaintextItem := input.encryptedItem,
        parsedHeader := None
      );
      return Success(passthroughOutput);
    }

    :- Need(!IsPlaintextItem(input.encryptedItem),
            DynamoDbItemEncryptorException(
              message := "Encrypted item missing expected header and footer attributes"));

    var encryptedStructure :- DynamoToStruct.ItemToStructured2(input.encryptedItem, config.attributeActionsOnEncrypt)
    .MapFailure(e => Error.AwsCryptographyDbEncryptionSdkDynamoDb(e));
    :- Need(SE.HeaderField in input.encryptedItem, E("Header field, \"aws_dbe_head\", not in item."));
    var header := input.encryptedItem[SE.HeaderField];
    :- Need(header.B?, E("Header field, \"aws_dbe_head\", not binary"));
    assert header.B?;
    :- Need(0 < |header.B|, E("Unexpected empty header field."));
    var context :- MakeEncryptionContextForDecrypt(config, header.B, encryptedStructure);
    var authenticateSchema := ConfigToAuthenticateSchema(config, encryptedStructure);

    //= specification/dynamodb-encryption-client/decrypt-item.md#behavior
    //# This operation MUST create a
    //# [Required Encryption Context CMM](https://github.com/awslabs/private-aws-encryption-sdk-specification-staging/blob/dafny-verified/framework/required-encryption-context-cmm.md)
    //# with the following inputs:
    //# - This item encryptor's [CMM](./ddb-table-encryption-config.md#cmm) as the underlying CMM.
    //# - The keys from the [DynamoDB Item Base Context](#dynamodb-item-base-context).

    var reqCMMR := config.cmpClient.CreateRequiredEncryptionContextCMM(
      CMP.CreateRequiredEncryptionContextCMMInput(
        underlyingCMM := Some(config.cmm),
        keyring := None,
        requiredEncryptionContextKeys := SortedSets.ComputeSetToOrderedSequence2(context.Keys, ByteLess)
      )
    );
    var reqCMM :- reqCMMR.MapFailure(e => AwsCryptographyMaterialProviders(e));

    var decryptRes := config.structuredEncryption.DecryptStructure(
      CSE.DecryptStructureInput(
        tableName := config.logicalTableName,
        encryptedStructure := encryptedStructure,
        authenticateSchema := authenticateSchema,
        //= specification/dynamodb-encryption-client/decrypt-item.md#behavior
        //# - CMM MUST be the CMM constructed above.
        cmm:=reqCMM,
        encryptionContext:=Some(context)
      )
    );

    var decryptVal :- decryptRes.MapFailure(
      e => Error.AwsCryptographyDbEncryptionSdkDynamoDb(DDBE.AwsCryptographyDbEncryptionSdkStructuredEncryption(e)));
    var decryptedData := decryptVal.plaintextStructure;
    :- Need(forall k <- decryptedData :: DDB.IsValid_AttributeName(k), E(""));
    var ddbItem :- DynamoToStruct.StructuredToItemDecrypt(decryptedData, input.encryptedItem, decryptVal.cryptoSchema)
    .MapFailure(e => Error.AwsCryptographyDbEncryptionSdkDynamoDb(e));

    var schemaToConvert := decryptVal.cryptoSchema;

    var parsedAuthActions :- ConvertCryptoSchemaToAttributeActions(config, schemaToConvert);
    var selectorContextR := ConvertContextForSelector(decryptVal.parsedHeader.encryptionContext);
    var selectorContext :- selectorContextR.MapFailure(e => E(e));

    var parsedHeader := ParsedHeader(
      attributeActionsOnEncrypt := parsedAuthActions,
      algorithmSuiteId := decryptVal.parsedHeader.algorithmSuiteId,
      storedEncryptionContext := decryptVal.parsedHeader.storedEncryptionContext,
      encryptedDataKeys := decryptVal.parsedHeader.encryptedDataKeys,
      encryptionContext := decryptVal.parsedHeader.encryptionContext,
      selectorContext := selectorContext
    );

    output := Success(
      DecryptItemOutput(
        plaintextItem := ddbItem,
        parsedHeader := Some(parsedHeader)
      ));
  }
}
