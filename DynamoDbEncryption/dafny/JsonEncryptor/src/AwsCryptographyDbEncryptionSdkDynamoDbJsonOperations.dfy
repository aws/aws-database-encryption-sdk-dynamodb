// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../../../../submodules/MaterialProviders/AwsCryptographicMaterialProviders/dafny/AwsCryptographicMaterialProviders/src/CMMs/RequiredEncryptionContextCMM.dfy"
include "JsonToStruct.dfy"
include "Util.dfy"
include "../../DynamoDbEncryption/src/Util.dfy"
include "../../StructuredEncryption/src/Util.dfy"

module AwsCryptographyDbEncryptionSdkJsonEncryptorOperations refines AbstractAwsCryptographyDbEncryptionSdkDynamoDbJsonOperations {
  import opened JsonEncryptorUtil
  import CMP = AwsCryptographyMaterialProvidersTypes
  import StructuredEncryption
  import JsonToStruct
  import SortedSets
  import Base64
  import opened StandardLibrary
  import Seq
  import CSE = AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes
  import SE =  StructuredEncryptionUtil
  import MaterialProviders
  import RequiredEncryptionContextCMM
  import SET = AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes
  import DDBE = AwsCryptographyDbEncryptionSdkDynamoDbTypes
  import DynamoDbEncryptionUtil
  import StructuredEncryptionUtil
  import StandardLibrary.String
  import opened AwsCryptographyDbEncryptionSdkDynamoDbJsonTypes

  datatype Config = Config(
    nameonly logicalTableName : string,
    nameonly cmpClient : MaterialProviders.MaterialProvidersClient,
    nameonly cmm: CMP.ICryptographicMaterialsManager,
    nameonly attributeActionsOnEncrypt: DDBE.AttributeActions,
    nameonly allowedUnsignedAttributes: Option<seq<string>>,
    nameonly allowedUnsignedAttributePrefix: Option<string>,
    nameonly algorithmSuiteId: Option<CMP.DBEAlgorithmSuiteId>,
    nameonly structuredEncryption: StructuredEncryption.StructuredEncryptionClient
  )

  type InternalConfig = Config
  type ValidConfig = x : Config | ValidInternalConfig?(x) witness *

  const DoNotSign :=
    CSE.AuthenticateSchema(content := CSE.AuthenticateSchemaContent.Action(CSE.AuthenticateAction.DO_NOT_SIGN), attributes := None)
  const DoSign :=
    CSE.AuthenticateSchema(content := CSE.AuthenticateSchemaContent.Action(CSE.AuthenticateAction.SIGN), attributes := None)

  // Is the attribute name an allowed unauthenticated name?
  predicate method AllowedUnsigned(
    unauthenticatedAttributes: Option<seq<string>>,
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

  predicate method ForwardCompatibleAttributeAction(
    attribute: string,
    action: CSE.CryptoAction,
    unauthenticatedAttributes: Option<seq<string>>,
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
    match action {
      case DO_NOTHING => "DO_NOTHING"
      case SIGN_ONLY => "SIGN_ONLY"
      case ENCRYPT_AND_SIGN => "ENCRYPT_AND_SIGN"
      case SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT => "SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT"
    }
  }

  function method ExplainNotForwardCompatible(
    attr: string,
    action: CSE.CryptoAction,
    unauthenticatedAttributes: Option<seq<string>>,
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
  predicate method UnknownAttribute(config : InternalConfig, attr : string)
  {
    && InSignatureScope(config, attr)
    && attr !in config.attributeActionsOnEncrypt
       // Attributes in signature scope MUST be configured in attributeActionsOnEncrypt
       // so these two lines are saying "in scope && not in scope"
       // and that's why it's an error
  }

  // Is the attribute SIGN_ONLY?
  predicate method IsSignOnly(config : InternalConfig, attr : string)
  {
    attr in config.attributeActionsOnEncrypt && config.attributeActionsOnEncrypt[attr] == CSE.SIGN_ONLY
  }

  // Is the attribute name in signature scope?
  predicate method InSignatureScope(config : InternalConfig, attr : string)
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

  function method EncodeValue(t : SET.StructuredDataTerminal) : (ret : UTF8.ValidUTF8Bytes)
    ensures ret == EncodeAscii(Base64.Encode(t.typeId + t.value))
  {
    EncodeAscii(Base64.Encode(t.typeId + t.value))
  }

  const TABLE_NAME : UTF8.ValidUTF8Bytes := UTF8.EncodeAscii("aws-crypto-table-name")
  function method {:opaque} {:vcs_split_on_every_assert} MakeEncryptionContext(
    config : InternalConfig,
    item : JsonToStruct.TerminalDataMap)
    : (ret : Result<CMP.EncryptionContext, Error>)
  {
    var logicalTableName : ValidUTF8Bytes :- DDBEncode(config.logicalTableName);
      var ec : CMP.EncryptionContext :=
        map[
          TABLE_NAME := logicalTableName
        ];
      assert TABLE_NAME in ec;
      Success(ec)
  }

  // string to Error
  function method DDBError(s : string) : Error {
    Error.JsonEncryptorException(message := s)
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
    && (forall attribute <- config.attributeActionsOnEncrypt.Keys
          :: ForwardCompatibleAttributeAction(
               attribute,
               config.attributeActionsOnEncrypt[attribute],
               config.allowedUnsignedAttributes,
               config.allowedUnsignedAttributePrefix))

    // It is forbidden to explicitly configure an attribute with the reserved prefix
    && (forall attribute <- config.attributeActionsOnEncrypt.Keys ::
          !(ReservedPrefix <= attribute))
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
    attr : string)
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
    attr : string)
    : (ret : Result<CSE.CryptoSchema, string>)
    ensures (attr !in config.attributeActionsOnEncrypt && InSignatureScope(config, attr)) ==> ret.Failure?
  {
    var action :- GetCryptoSchemaActionInner(config, attr);
    var newElement := CSE.CryptoSchemaContent.Action(action);
    Success(CSE.CryptoSchema(content := newElement, attributes := None))
  }

  // return proper Authenticate Action by name
  function method GetAuthenticateSchemaAction(
    config : InternalConfig,
    attr : string)
    : (ret : CSE.AuthenticateSchema)
    requires ValidInternalConfig?(config)
    ensures (ret == DoNotSign) <==> !InSignatureScope(config, attr)
  {
    if InSignatureScope(config, attr) then
      DoSign
    else
      DoNotSign
  }

  // get CryptoSchema for this item
  function method ConfigToCryptoSchema(
    config : InternalConfig,
    item : JsonToStruct.TerminalDataMap)
    : (ret : Result<CSE.CryptoSchema, Error>)

    ensures forall k <- item.Keys ::
              (k !in config.attributeActionsOnEncrypt && InSignatureScope(config, k)) ==> ret.Failure?

    ensures ret.Success? ==> ret.value.content.SchemaMap? && item.Keys == ret.value.content.SchemaMap.Keys

    ensures ret.Success? ==> forall k <-item.Keys ::
                && GetCryptoSchemaAction(config, k).Success?
                && ret.value.content.SchemaMap[k] == GetCryptoSchemaAction(config, k).value
                && (k in config.attributeActionsOnEncrypt ==>
                      ret.value.content.SchemaMap[k].content ==
                      CSE.CryptoSchemaContent.Action(config.attributeActionsOnEncrypt[k]))
  {
    var schema := map k <- item :: k := GetCryptoSchemaAction(config, k);
    JsonToStruct.MapKeysMatchItems(item);
    JsonToStruct.SimplifyMapValueSuccess(schema);
    var actionMapRes := JsonToStruct.SimplifyMapValue(schema);
    assert actionMapRes.Failure? ==> exists kv <- item.Items :: GetCryptoSchemaAction(config, kv.0).Failure?;
    assert actionMapRes.Failure? <==> exists k <- item.Keys :: schema[k].Failure?;
    assert actionMapRes.Failure? <==> exists k <- item.Keys :: GetCryptoSchemaAction(config, k).Failure?;

    var actionMap :- JsonToStruct.MapError(actionMapRes);
    var schemaContent := CSE.CryptoSchemaContent.SchemaMap(actionMap);
    var finalSchema := CSE.CryptoSchema(content := schemaContent, attributes := None);
    Success(finalSchema)
  }

  // get AuthenticateSchema for this item
  function method ConfigToAuthenticateSchema(
    config : InternalConfig,
    item : JsonToStruct.TerminalDataMap)
    : (ret : CSE.AuthenticateSchema)
    requires ValidInternalConfig?(config)
    ensures ret.content.SchemaMap? && item.Keys == ret.content.SchemaMap.Keys
    ensures forall k <-item.Keys ::
              !InSignatureScope(config, k) ==>
                ret.content.SchemaMap[k].content ==
                CSE.AuthenticateSchemaContent.Action(CSE.AuthenticateAction.DO_NOT_SIGN)
    ensures forall k <-item.Keys ::
              && InSignatureScope(config, k) ==>
                ret.content.SchemaMap[k].content ==
                CSE.AuthenticateSchemaContent.Action(CSE.AuthenticateAction.SIGN)
  {
    var authMap := map k <- item | true :: k := GetAuthenticateSchemaAction(config, k);
    var schemaContent := CSE.AuthenticateSchemaContent.SchemaMap(authMap);
    var finalSchema := CSE.AuthenticateSchema(content := schemaContent, attributes := None);
    finalSchema
  }

  predicate method IsPlaintextItem(ddbItem: JsonToStruct.TerminalDataMap) {
    && StructuredEncryptionUtil.HeaderField !in ddbItem
    && StructuredEncryptionUtil.FooterField !in ddbItem
  }

  function method ConvertCryptoSchemaToAttributeActions(config: ValidConfig, schema: CSE.CryptoSchema)
    : (ret: Result<map<string, CSE.CryptoAction>, Error>)
    requires schema.content.SchemaMap?
    requires forall k <- schema.content.SchemaMap :: schema.content.SchemaMap[k].content.Action?
    requires forall v <- schema.content.SchemaMap.Values :: v.content.Action.SIGN_ONLY? || v.content.Action.ENCRYPT_AND_SIGN?
    ensures ret.Success? ==> forall k <- ret.value.Keys :: InSignatureScope(config, k)
    ensures ret.Success? ==> forall k <- ret.value.Keys :: !ret.value[k].DO_NOTHING?
  {
    // We can formally verify these properties, but it is too resource intensive
    :- Need(forall k <- schema.content.SchemaMap :: InSignatureScope(config, k),
            JsonEncryptorException( message := "Received unexpected Crypto Schema: mismatch with signature scope"));
    Success(map k <- schema.content.SchemaMap :: k := schema.content.SchemaMap[k].content.Action)
  }

  predicate EncryptObjectEnsuresPublicly(input: EncryptObjectInput, output: Result<EncryptObjectOutput, Error>)
  {true}

  // public Encrypt method
  method {:vcs_split_on_every_assert} EncryptObject(config: InternalConfig, input: EncryptObjectInput)
    returns (output: Result<EncryptObjectOutput, Error>)
    ensures
      output.Success? ==>
        && (|config.structuredEncryption.History.EncryptStructure| == |old(config.structuredEncryption.History.EncryptStructure)| + 1)
        && (Seq.Last(config.structuredEncryption.History.EncryptStructure).output.Success?)

        // && ConfigToCryptoSchema(config, input.plaintextObject).Success?
        // && Seq.Last(config.structuredEncryption.History.EncryptStructure).input.cryptoSchema
        //    == ConfigToCryptoSchema(config, input.plaintextObject).value

        // && JsonToStruct.ObjectToStructured(input.plaintextObject).Success?
        // && var plaintextStructure := JsonToStruct.ObjectToStructured(input.plaintextObject).value;
        // && Seq.Last(config.structuredEncryption.History.EncryptStructure).input.plaintextStructure
        //    == CSE.StructuredData(
        //         content := CSE.StructuredDataContent.DataMap(plaintextStructure),
        //         attributes := None)

        // && MakeEncryptionContext(config, plaintextStructure).Success?
        // && Seq.Last(config.structuredEncryption.History.EncryptStructure).input.encryptionContext
        //    == Some(MakeEncryptionContext(config, plaintextStructure).value)

        // && output.value.parsedHeader.Some?
        // && var structuredEncParsed := Seq.Last(config.structuredEncryption.History.EncryptStructure).output.value.parsedHeader;
        // && structuredEncParsed.cryptoSchema.content.SchemaMap?
        // && var parsedHeaderMap := structuredEncParsed.cryptoSchema.content.SchemaMap;
        // && (forall k <- parsedHeaderMap ::
        //       && parsedHeaderMap[k].content.Action?
        //       && (parsedHeaderMap[k].content.Action.ENCRYPT_AND_SIGN? || parsedHeaderMap[k].content.Action.SIGN_ONLY?))
        // && var maybeCryptoSchema := ConvertCryptoSchemaToAttributeActions(config, structuredEncParsed.cryptoSchema);
        // && maybeCryptoSchema.Success?
        // && output.value.parsedHeader.value == ParsedHeader(
        //                                         attributeActionsOnEncrypt := maybeCryptoSchema.value,
        //                                         algorithmSuiteId := structuredEncParsed.algorithmSuiteId,
        //                                         storedEncryptionContext := structuredEncParsed.storedEncryptionContext,
        //                                         encryptedDataKeys := structuredEncParsed.encryptedDataKeys
        //                                       )

  {
    var plaintextStructureR := JsonToStruct.ObjectToStructured(input.plaintextObject);
    var plaintextStructure :- plaintextStructureR.MapFailure(e => E(e));
    var context :- MakeEncryptionContext(config, plaintextStructure);
    var cryptoSchema :- ConfigToCryptoSchema(config, plaintextStructure);
    var wrappedStruct := CSE.StructuredData(
      content := CSE.StructuredDataContent.DataMap(plaintextStructure),
      attributes := None);

    var reqCMMR := config.cmpClient.CreateRequiredEncryptionContextCMM(
      CMP.CreateRequiredEncryptionContextCMMInput(
        underlyingCMM := Some(config.cmm),
        keyring := None,
        requiredEncryptionContextKeys := SortedSets.ComputeSetToOrderedSequence2(context.Keys, ByteLess)
      )
    );
    var reqCMM :- reqCMMR.MapFailure(e => AwsCryptographyMaterialProviders(e));
    var encryptRes := config.structuredEncryption.EncryptStructure(
      CSE.EncryptStructureInput(
        tableName := config.logicalTableName,
        plaintextStructure:=wrappedStruct,
        cryptoSchema:=cryptoSchema,
        cmm:= reqCMM,
        algorithmSuiteId:=config.algorithmSuiteId,
        encryptionContext:=Some(context)
      )
    );

    var encryptVal :- encryptRes.MapFailure(e => Error.AwsCryptographyDbEncryptionSdkStructuredEncryption(e));
    var encryptedData := encryptVal.encryptedStructure;
    var ddbKeyR := JsonToStruct.StructuredToObject(encryptedData.content.DataMap);
    var ddbKey :- ddbKeyR.MapFailure(e => E(e));

    var parsedActions :- ConvertCryptoSchemaToAttributeActions(config, encryptVal.parsedHeader.cryptoSchema);
    var parsedHeader := ParsedHeader(
      attributeActionsOnEncrypt := parsedActions,
      algorithmSuiteId := encryptVal.parsedHeader.algorithmSuiteId,
      storedEncryptionContext := encryptVal.parsedHeader.storedEncryptionContext,
      encryptedDataKeys := encryptVal.parsedHeader.encryptedDataKeys
    );

    output := Success(EncryptObjectOutput(
                        encryptedObject := ddbKey,
                        parsedHeader := Some(parsedHeader)
                      ));
  }

  predicate DecryptObjectEnsuresPublicly(input: DecryptObjectInput, output: Result<DecryptObjectOutput, Error>)
  {true}

  // public Decrypt method
  method {:vcs_split_on_every_assert} DecryptObject(config: InternalConfig, input: DecryptObjectInput)
    returns (output: Result<DecryptObjectOutput, Error>)

    ensures
      output.Success? ==>
        && (|config.structuredEncryption.History.DecryptStructure| == |old(config.structuredEncryption.History.DecryptStructure)| + 1)
        && (Seq.Last(config.structuredEncryption.History.DecryptStructure).output.Success?)

        // && Seq.Last(config.structuredEncryption.History.DecryptStructure).input.authenticateSchema
        //    == ConfigToAuthenticateSchema(config, input.encryptedObject)

        // && JsonToStruct.ObjectToStructured(input.encryptedObject).Success?
        // && var plaintextStructure := JsonToStruct.ObjectToStructured(input.encryptedObject).value;
        // && Seq.Last(config.structuredEncryption.History.DecryptStructure).input.encryptedStructure
        //    == CSE.StructuredData(
        //         content := CSE.StructuredDataContent.DataMap(plaintextStructure),
        //         attributes := None)

        // && MakeEncryptionContext(config, plaintextStructure).Success?
        // && Seq.Last(config.structuredEncryption.History.DecryptStructure).input.encryptionContext
        //    == Some(MakeEncryptionContext(config, plaintextStructure).value)

        // && output.value.parsedHeader.Some?
        // && var structuredEncParsed := Seq.Last(config.structuredEncryption.History.DecryptStructure).output.value.parsedHeader;
        // && structuredEncParsed.cryptoSchema.content.SchemaMap?
        // && (forall k <- structuredEncParsed.cryptoSchema.content.SchemaMap ::
        //       && structuredEncParsed.cryptoSchema.content.SchemaMap[k].content.Action?
        //       && (structuredEncParsed.cryptoSchema.content.SchemaMap[k].content.Action.ENCRYPT_AND_SIGN? || structuredEncParsed.cryptoSchema.content.SchemaMap[k].content.Action.SIGN_ONLY?))
        // && var maybeCryptoSchema := ConvertCryptoSchemaToAttributeActions(config, structuredEncParsed.cryptoSchema);
        // && maybeCryptoSchema.Success?
        // && output.value.parsedHeader.value == ParsedHeader(
        //                                         attributeActionsOnEncrypt := maybeCryptoSchema.value,
        //                                         algorithmSuiteId := structuredEncParsed.algorithmSuiteId,
        //                                         storedEncryptionContext := structuredEncParsed.storedEncryptionContext,
        //                                         encryptedDataKeys := structuredEncParsed.encryptedDataKeys
        //                                       )
  {
    var encryptedStructureR := JsonToStruct.ObjectToStructured(input.encryptedObject, Some(config.attributeActionsOnEncrypt));
    var encryptedStructure :- encryptedStructureR.MapFailure(e => E(e));
    :- Need(!IsPlaintextItem(encryptedStructure),
            JsonEncryptorException(
              message := "Encrypted item missing expected header and footer attributes"));

    var context :- MakeEncryptionContext(config, encryptedStructure);
    var authenticateSchema := ConfigToAuthenticateSchema(config, encryptedStructure);
    var wrappedStruct := CSE.StructuredData(
      content := CSE.StructuredDataContent.DataMap(encryptedStructure),
      attributes := None);

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
        encryptedStructure := wrappedStruct,
        authenticateSchema := authenticateSchema,
        cmm:=reqCMM,
        encryptionContext:=Some(context)
      )
    );

    var decryptVal :- decryptRes.MapFailure(
      e => Error.AwsCryptographyDbEncryptionSdkStructuredEncryption(e));
    var decryptedData := decryptVal.plaintextStructure;
    var ddbObjectR := JsonToStruct.StructuredToObject(decryptedData.content.DataMap);
    var ddbObject :- ddbObjectR.MapFailure(e => E(e));

    var schemaToConvert := decryptVal.parsedHeader.cryptoSchema;

    var parsedAuthActions :- ConvertCryptoSchemaToAttributeActions(config, schemaToConvert);

    var parsedHeader := ParsedHeader(
      attributeActionsOnEncrypt := parsedAuthActions,
      algorithmSuiteId := decryptVal.parsedHeader.algorithmSuiteId,
      storedEncryptionContext := decryptVal.parsedHeader.storedEncryptionContext,
      encryptedDataKeys := decryptVal.parsedHeader.encryptedDataKeys
    );

    output := Success(
      DecryptObjectOutput(
        plaintextObject := ddbObject,
        parsedHeader := Some(parsedHeader)
      ));
  }
}
