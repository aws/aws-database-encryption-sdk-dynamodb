// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "JsonToStruct.dfy"
include "Util.dfy"

module AwsCryptographyDbEncryptionSdkJsonEncryptorOperations refines AbstractAwsCryptographyDbEncryptionSdkDynamoDbJsonOperations {
  import opened StandardLibrary
  import opened JsonEncryptorUtil
  import opened AwsCryptographyDbEncryptionSdkDynamoDbJsonTypes
  import StructuredEncryption
  import MaterialProviders

  import SortedSets
  import Base64
  import Seq
  import StandardLibrary.String
  import Maps
  import opened JSON.Values

  import JsonToStruct

  import CMP = AwsCryptographyMaterialProvidersTypes
  import CSE = AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes
    // FIXME - this is temporary until GetEncryptedFields is in CSE.
  import XXXSEO = AwsCryptographyDbEncryptionSdkStructuredEncryptionOperations

  datatype Config = Config(
    nameonly domain : string,
    nameonly cmpClient : MaterialProviders.MaterialProvidersClient,
    nameonly cmm: CMP.ICryptographicMaterialsManager,
    nameonly memberActionsOnEncrypt: MemberActions,
    nameonly allowedUnsignedMembers: Option<seq<string>>,
    nameonly allowedUnsignedMemberPrefix: Option<string>,
    nameonly algorithmSuiteId: Option<CMP.DBEAlgorithmSuiteId>,
    nameonly structuredEncryption: StructuredEncryption.StructuredEncryptionClient
  )

  type InternalConfig = Config
  type ValidConfig = x : Config | ValidInternalConfig?(x) witness *

  const DoNotSign :=
    CSE.AuthenticateSchema(content := CSE.AuthenticateSchemaContent.Action(CSE.AuthenticateAction.DO_NOT_SIGN), attributes := None)
  const DoSign :=
    CSE.AuthenticateSchema(content := CSE.AuthenticateSchemaContent.Action(CSE.AuthenticateAction.SIGN), attributes := None)

  // Is the member name an allowed unauthenticated name?
  predicate method AllowedUnsigned(
    unauthenticatedMembers: Option<seq<string>>,
    unauthenticatedPrefix: Option<string>,
    attr : string)
  {
    || (unauthenticatedMembers.Some? && attr in unauthenticatedMembers.value)
    || (unauthenticatedPrefix.Some? && unauthenticatedPrefix.value <= attr)
    || ReservedPrefix <= attr
       // Members with the reserved prefix are "allowed unauthenticated" in that
       // they are not specified as signed within memberActionsOnEncrypt.
       // These members MAY still be authenticated via other methods,
       // such as "aws_dbe_head" which is explicitly added to the canonical hash
       // used in signing.
  }

  predicate method ForwardCompatibleMemberAction(
    member: string,
    action: CSE.CryptoAction,
    unauthenticatedMembers: Option<seq<string>>,
    unauthenticatedPrefix: Option<string>
  )
  {
    if action == CSE.DO_NOTHING then
      AllowedUnsigned(unauthenticatedMembers, unauthenticatedPrefix, member)
    else
      !AllowedUnsigned(unauthenticatedMembers, unauthenticatedPrefix, member)
  }

  function method  {:opaque} CryptoActionString(action: CSE.CryptoAction) : string
  {
    match action {
      case DO_NOTHING => "DO_NOTHING"
      case SIGN_ONLY => "SIGN_ONLY"
      case ENCRYPT_AND_SIGN => "ENCRYPT_AND_SIGN"
      case SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT => "SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT"
    }
  }

  function method  {:opaque} ExplainNotForwardCompatible(
    attr: string,
    action: CSE.CryptoAction,
    unauthenticatedMembers: Option<seq<string>>,
    unauthenticatedPrefix: Option<string>
  )
    : string
    requires !ForwardCompatibleMemberAction(attr, action, unauthenticatedMembers, unauthenticatedPrefix)
  {
    "Member " + attr + " is configured as " + CryptoActionString(action) + " but " +
    if action == CSE.DO_NOTHING then
      "it must also be in unauthenticatedMembers or begin with the unauthenticatedPrefix."
    else if unauthenticatedMembers.Some? && attr in unauthenticatedMembers.value then
      "it is also in unauthenticatedMembers."
    else if unauthenticatedPrefix.Some? && unauthenticatedPrefix.value <= attr then
      "it also begins with the unauthenticatedPrefix."
    else
      assert ReservedPrefix <= attr;
      "it also begins with the reserved prefix."
  }


  // Is this member unknown to the config?
  predicate method UnknownMember(config : ValidConfig, attr : string)
  {
    && InSignatureScope(config, attr)
    && attr !in config.memberActionsOnEncrypt
       // Members in signature scope MUST be configured in memberActionsOnEncrypt
       // so these two lines are saying "in scope && not in scope"
       // and that's why it's an error
  }

  // Is the member SIGN_ONLY?
  predicate method IsSignOnly(config : ValidConfig, attr : string)
  {
    attr in config.memberActionsOnEncrypt && config.memberActionsOnEncrypt[attr].crypto == CSE.SIGN_ONLY
  }

  // Is the member name in signature scope?
  predicate method InSignatureScope(config : ValidConfig, attr : string)
  {
    !AllowedUnsigned(
      config.allowedUnsignedMembers,
      config.allowedUnsignedMemberPrefix,
      attr)
  }

  const TABLE_NAME : UTF8.ValidUTF8Bytes := UTF8.EncodeAscii("aws-crypto-table-name")
  function method {:opaque} MakeEncryptionContext(
    config : ValidConfig,
    item : JsonToStruct.TerminalDataMap)
    : (ret : Result<CMP.EncryptionContext, Error>)
  {
    var domain : ValidUTF8Bytes :- DDBEncode(config.domain);
    var ec : CMP.EncryptionContext :=
      map[
        TABLE_NAME := domain
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
    && (forall k <- config.memberActionsOnEncrypt :: config.memberActionsOnEncrypt[k].crypto?)

    // memberActionsOnEncrypt only apply on Encrypt.
    // The config on Encrypt MAY NOT be the same as the config on Decrypt.
    // This means that Encrypt MUST be "forward compatible" with Decrypt.
    // Every current and *past* CSE.DO_NOTHING action
    // MUST be derivable from allowedUnsigned information
    // otherwise Decrypt will attempt to authenticate an member that was unauthenticated on Encrypt.
    // Also, every current and *past* CSE.ENCRYPT_AND_SIGN or CSE.SIGN_ONLY action
    // MUST NOT overlap with allowedUnsigned information
    // otherwise Decrypt will not authenticate at member that was authenticate on Encrypt.
    // For this to work the scope of allowedUnsigned information MUST only increase.
    // This means that an member that is added to allowedUnsignedMembers
    // MUST NOT ever be removed.
    // This means that is a allowedUnsignedMemberPrefix is added
    // allowedUnsignedMemberPrefix <= old(allowedUnsignedMemberPrefix).
    // The simple case is do not change allowedUnsignedMemberPrefix.
    // But allowedUnsignedMemberPrefix MAY get shorter,
    // however this is a dangerous operation as it may impact other members.
    && (forall member <- config.memberActionsOnEncrypt.Keys
          :: ForwardCompatibleMemberAction(
               member,
               config.memberActionsOnEncrypt[member].crypto,
               config.allowedUnsignedMembers,
               config.allowedUnsignedMemberPrefix))

    // It is forbidden to explicitly configure an member with the reserved prefix
    && (forall member <- config.memberActionsOnEncrypt.Keys ::
          !(ReservedPrefix <= member))
  }

  function ModifiesInternalConfig(config: InternalConfig) : set<object>
  {
    config.cmm.Modifies
    + config.structuredEncryption.Modifies
    + config.cmpClient.Modifies
  }

  // return proper Crypto Action by name
  function method GetCryptoSchemaActionInner(
    config : ValidConfig,
    attr : string)
    : (ret : Result<CSE.CryptoAction, string>)
    ensures (attr !in config.memberActionsOnEncrypt && InSignatureScope(config, attr)) ==> ret.Failure?
  {
    if attr in config.memberActionsOnEncrypt then
      Success(config.memberActionsOnEncrypt[attr].crypto)
    else if !InSignatureScope(config, attr) then
      Success(CSE.CryptoAction.DO_NOTHING)
    else
      Failure("No Crypto Action configured for member " + attr)
  }

  // get Crypto Action and wrap in CryptoSchema
  function method GetCryptoSchemaAction(
    config : ValidConfig,
    attr : string)
    : (ret : Result<CSE.CryptoSchema, string>)
    ensures (attr !in config.memberActionsOnEncrypt && InSignatureScope(config, attr)) ==> ret.Failure?
  {
    var action :- GetCryptoSchemaActionInner(config, attr);
    var newElement := CSE.CryptoSchemaContent.Action(action);
    Success(CSE.CryptoSchema(content := newElement, attributes := None))
  }

  // return proper Authenticate Action by name
  function method GetAuthenticateSchemaAction(
    config : ValidConfig,
    attr : string)
    : (ret : CSE.AuthenticateSchema)
    ensures (ret == DoNotSign) <==> !InSignatureScope(config, attr)
  {
    if InSignatureScope(config, attr) then
      DoSign
    else
      DoNotSign
  }

  // get CryptoSchema for this item
  function method {:opaque} ConfigToCryptoSchema(
    config : ValidConfig,
    item : JsonToStruct.TerminalDataMap)
    : (ret : Result<CSE.CryptoSchema, Error>)

    ensures forall k <- item.Keys ::
              (k !in config.memberActionsOnEncrypt && InSignatureScope(config, k)) ==> ret.Failure?

    ensures ret.Success? ==> ret.value.content.SchemaMap? && item.Keys == ret.value.content.SchemaMap.Keys

    ensures ret.Success? ==> forall k <-item.Keys ::
                && GetCryptoSchemaAction(config, k).Success?
                && ret.value.content.SchemaMap[k] == GetCryptoSchemaAction(config, k).value
                && (k in config.memberActionsOnEncrypt ==>
                      ret.value.content.SchemaMap[k].content ==
                      CSE.CryptoSchemaContent.Action(config.memberActionsOnEncrypt[k].crypto))
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
  function method  {:opaque} ConfigToAuthenticateSchema(
    config : ValidConfig,
    item : JsonToStruct.TerminalDataMap)
    : (ret : CSE.AuthenticateSchema)
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

  predicate method IsAuthAttr(x : CSE.CryptoAction)
  {
    x.ENCRYPT_AND_SIGN? || x.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT? || x.SIGN_ONLY?
  }

  predicate method IsValidCryptoSchema(schema : CSE.CryptoSchema)
    ensures IsValidCryptoSchema(schema) ==> schema.content.SchemaMap?
    ensures IsValidCryptoSchema(schema) ==> forall k <- schema.content.SchemaMap :: schema.content.SchemaMap[k].content.Action?
    ensures IsValidCryptoSchema(schema) ==> forall v <- schema.content.SchemaMap.Values :: IsAuthAttr(v.content.Action)
  {
    && schema.content.SchemaMap?
    && (forall k <- schema.content.SchemaMap :: schema.content.SchemaMap[k].content.Action?)
    && (forall v <- schema.content.SchemaMap.Values :: IsAuthAttr(v.content.Action))
  }

  function method  {:opaque} CryptoSchemaToMemberActions(config: ValidConfig, schema: CSE.CryptoSchema)
    : (ret: Result<MemberActions, Error>)
    requires IsValidCryptoSchema(schema)
    ensures ret.Success? ==> 
      && (forall k <- ret.value.Keys :: InSignatureScope(config, k))
      && (forall k <- ret.value.Keys :: ret.value[k].crypto?)
      && (ret.Success? ==> forall k <- ret.value.Keys :: !ret.value[k].crypto.DO_NOTHING?)
  {
    // We can formally verify these properties, but it is too resource intensive
    :- Need(forall k <- schema.content.SchemaMap :: InSignatureScope(config, k),
            E("Received unexpected Crypto Schema: mismatch with signature scope"));
    Success(map k <- schema.content.SchemaMap :: k := crypto(schema.content.SchemaMap[k].content.Action))
  }

  predicate EncryptObjectEnsuresPublicly(input: EncryptObjectInput, output: Result<EncryptObjectOutput, Error>)
  {true}

  const EmptyStringSet : set<string> := {}

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
    //         members := None)

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
    // && var maybeCryptoSchema := ConvertCryptoSchemaToMemberActions(config, structuredEncParsed.cryptoSchema);
    // && maybeCryptoSchema.Success?
    // && output.value.parsedHeader.value == ParsedHeader(
    //                                         memberActionsOnEncrypt := maybeCryptoSchema.value,
    //                                         algorithmSuiteId := structuredEncParsed.algorithmSuiteId,
    //                                         storedEncryptionContext := structuredEncParsed.storedEncryptionContext,
    //                                         encryptedDataKeys := structuredEncParsed.encryptedDataKeys
    //                                       )

  {
    var origJsonR := JsonToStruct.SmithyJsonToObject(input.plaintextObject);
    var origJson :- origJsonR.MapFailure(e => E(e));
    var isSigned : set<string> := set x <- config.memberActionsOnEncrypt | config.memberActionsOnEncrypt[x].crypto != CSE.DO_NOTHING :: x;
    assert EmptyStringSet <= isSigned;
    assert origJson.Object?;
    var plaintextStructureR := JsonToStruct.ObjectToStructured(origJson, isSigned, EmptyStringSet);
    var plaintextStructure :- plaintextStructureR.MapFailure(e => E(e));
    var context : CMP.EncryptionContext :- MakeEncryptionContext(config, plaintextStructure);
    var cryptoSchema :- ConfigToCryptoSchema(config, plaintextStructure);
    var wrappedStruct := CSE.StructuredData(
      content := CSE.StructuredDataContent.DataMap(plaintextStructure),
      attributes := None);
    var contextKeysSet : set<ValidUTF8Bytes> := context.Keys;
    var contextKeys : seq<ValidUTF8Bytes> := SortedSets.ComputeSetToOrderedSequence2(contextKeysSet, ByteLess);

    var reqCMMR := config.cmpClient.CreateRequiredEncryptionContextCMM(
      CMP.CreateRequiredEncryptionContextCMMInput(
        underlyingCMM := Some(config.cmm),
        keyring := None,
        requiredEncryptionContextKeys := contextKeys
      )
    );
    var reqCMM :- reqCMMR.MapFailure(e => AwsCryptographyMaterialProviders(e));

    assert |config.structuredEncryption.History.EncryptStructure| == |old(config.structuredEncryption.History.EncryptStructure)|;
    var encryptRes := config.structuredEncryption.EncryptStructure(
      CSE.EncryptStructureInput(
        tableName := config.domain,
        plaintextStructure:=wrappedStruct,
        cryptoSchema:=cryptoSchema,
        cmm:= reqCMM,
        algorithmSuiteId:=config.algorithmSuiteId,
        encryptionContext:=Some(context)
      )
    );
    var encryptVal :- encryptRes.MapFailure(e => Error.AwsCryptographyDbEncryptionSdkStructuredEncryption(e));
    assert
      && (|config.structuredEncryption.History.EncryptStructure| == |old(config.structuredEncryption.History.EncryptStructure)| + 1)
      && (Seq.Last(config.structuredEncryption.History.EncryptStructure).output.Success?);

    var encryptedData := encryptVal.encryptedStructure;
    var parsedActions :- CryptoSchemaToMemberActions(config, encryptVal.parsedHeader.cryptoSchema);
    var isEncrypted : set<string> := set x <- parsedActions | parsedActions[x].crypto == CSE.ENCRYPT_AND_SIGN :: x;
    var ddbKeyR := JsonToStruct.StructuredToObject(encryptedData.content.DataMap, origJson, isEncrypted);
    var ddbKey :- ddbKeyR.MapFailure(e => E(e));
    var jsonStrR := JsonToStruct.JsonToSmithyJson(ddbKey, input.plaintextObject);
    var jsonStr :- jsonStrR.MapFailure(e => E(e));

    var parsedHeader := ParsedHeader(
      memberActionsOnEncrypt := parsedActions,
      algorithmSuiteId := encryptVal.parsedHeader.algorithmSuiteId,
      storedEncryptionContext := encryptVal.parsedHeader.storedEncryptionContext,
      encryptedDataKeys := encryptVal.parsedHeader.encryptedDataKeys,
      encryptionContext := encryptVal.parsedHeader.encryptionContext
    );

    output := Success(EncryptObjectOutput(
                        encryptedObject := jsonStr,
                        parsedHeader := Some(parsedHeader)
                      ));
  }

  predicate DecryptObjectEnsuresPublicly(input: DecryptObjectInput, output: Result<DecryptObjectOutput, Error>)
  {true}

  method GetEncryptedFields(json : JSON, tableName : string, isSigned : set<string>) returns (ret : Result<set<string>, Error>)
    requires json.Object?
    ensures ret.Success? ==> ret.value <= isSigned
  {
    var header := JsonToStruct.FindItem(json.obj, "aws_dbe_head");
    :- Need(header.Some?, E("header value was missing."));
    :- Need(header.value.String?, E("header value was not of type String."));
    var headerSerialized : seq<uint8> :- Base64.Decode(header.value.str).MapFailure(e => E(e));
    var isEncrypted :- XXXSEO.GetEncryptedFields(tableName, isSigned, headerSerialized)
    .MapFailure(e => Error.AwsCryptographyDbEncryptionSdkStructuredEncryption(e));
    :- Need(isEncrypted <= isSigned, E("foo"));
    return Success(isEncrypted);
  }
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
    //         members := None)

    // && MakeEncryptionContext(config, plaintextStructure).Success?
    // && Seq.Last(config.structuredEncryption.History.DecryptStructure).input.encryptionContext
    //    == Some(MakeEncryptionContext(config, plaintextStructure).value)

    // && output.value.parsedHeader.Some?
    // && var structuredEncParsed := Seq.Last(config.structuredEncryption.History.DecryptStructure).output.value.parsedHeader;
    // && structuredEncParsed.cryptoSchema.content.SchemaMap?
    // && (forall k <- structuredEncParsed.cryptoSchema.content.SchemaMap ::
    //       && structuredEncParsed.cryptoSchema.content.SchemaMap[k].content.Action?
    //       && (structuredEncParsed.cryptoSchema.content.SchemaMap[k].content.Action.ENCRYPT_AND_SIGN? || structuredEncParsed.cryptoSchema.content.SchemaMap[k].content.Action.SIGN_ONLY?))
    // && var maybeCryptoSchema := ConvertCryptoSchemaToMemberActions(config, structuredEncParsed.cryptoSchema);
    // && maybeCryptoSchema.Success?
    // && output.value.parsedHeader.value == ParsedHeader(
    //                                         memberActionsOnEncrypt := maybeCryptoSchema.value,
    //                                         algorithmSuiteId := structuredEncParsed.algorithmSuiteId,
    //                                         storedEncryptionContext := structuredEncParsed.storedEncryptionContext,
    //                                         encryptedDataKeys := structuredEncParsed.encryptedDataKeys
    //                                       )
  {
    var origJsonR := JsonToStruct.SmithyJsonToObject(input.encryptedObject);
    var origJson :- origJsonR.MapFailure(e => E(e));
    var isSigned1 : set<string> := set x <- config.memberActionsOnEncrypt | config.memberActionsOnEncrypt[x].crypto != CSE.DO_NOTHING :: x;
    var isSigned2 : set<string> := set x <- origJson.obj :: x.0;
    var isSigned := isSigned1 * isSigned2;

    var isEncrypted :- GetEncryptedFields(origJson, config.domain, isSigned);

    var encryptedStructureR := JsonToStruct.ObjectToStructured(origJson, isSigned, isEncrypted);
    var encryptedStructure :- encryptedStructureR.MapFailure(e => E(e));

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

    assert |config.structuredEncryption.History.DecryptStructure| == |old(config.structuredEncryption.History.DecryptStructure)|;
    var decryptRes := config.structuredEncryption.DecryptStructure(
      CSE.DecryptStructureInput(
        tableName := config.domain,
        encryptedStructure := wrappedStruct,
        authenticateSchema := authenticateSchema,
        cmm:=reqCMM,
        encryptionContext:=Some(context)
      )
    );

    var decryptVal :- decryptRes.MapFailure(
      e => Error.AwsCryptographyDbEncryptionSdkStructuredEncryption(e));

    assert
      && (|config.structuredEncryption.History.DecryptStructure| == |old(config.structuredEncryption.History.DecryptStructure)| + 1)
      && (Seq.Last(config.structuredEncryption.History.DecryptStructure).output.Success?);

    var decryptedData := decryptVal.plaintextStructure;
    var schemaToConvert := decryptVal.parsedHeader.cryptoSchema;
    var parsedAuthActions :- CryptoSchemaToMemberActions(config, schemaToConvert);

    var isEncrypted2 : set<string> := set x <- parsedAuthActions | parsedAuthActions[x].crypto == CSE.ENCRYPT_AND_SIGN :: x;
    :- Need(isEncrypted == isEncrypted2, E("Andy got isEncrypted wrong."));
    var ddbObjectR := JsonToStruct.StructuredToObject(decryptedData.content.DataMap, origJson, isEncrypted);
    var ddbObject :- ddbObjectR.MapFailure(e => E(e));
    var jsonStrR := JsonToStruct.JsonToSmithyJson(ddbObject, input.encryptedObject);
    var jsonStr :- jsonStrR.MapFailure(e => E(e));

    var parsedHeader := ParsedHeader(
      memberActionsOnEncrypt := parsedAuthActions,
      algorithmSuiteId := decryptVal.parsedHeader.algorithmSuiteId,
      storedEncryptionContext := decryptVal.parsedHeader.storedEncryptionContext,
      encryptedDataKeys := decryptVal.parsedHeader.encryptedDataKeys,
      encryptionContext := decryptVal.parsedHeader.encryptionContext
    );

    output := Success(
      DecryptObjectOutput(
        plaintextObject := jsonStr,
        parsedHeader := Some(parsedHeader)
      ));
  }
}