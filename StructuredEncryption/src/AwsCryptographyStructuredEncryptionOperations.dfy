// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../Model/AwsCryptographyStructuredEncryptionTypes.dfy"
include "Header.dfy"
include "Paths.dfy"
include "Crypt.dfy"
include "Util.dfy"

module AwsCryptographyStructuredEncryptionOperations refines AbstractAwsCryptographyStructuredEncryptionOperations {
  import opened StructuredEncryptionUtil

  import Base64
  import CMP = AwsCryptographyMaterialProvidersTypes
  import CSE = AwsCryptographyStructuredEncryptionTypes
  import Prim = AwsCryptographyPrimitivesTypes
  import Random
  import Aws.Cryptography.Primitives
  import Header = StructuredEncryptionHeader
  import MaterialProviders
  import Crypt = StructuredEncryptionCrypt
  import Paths = StructuredEncryptionPaths
  import Sets
  import Seq
  import Digest
  import Defaults
  import HKDF
  import AlgorithmSuites

  datatype Config = Config(
    primatives : Primitives.AtomicPrimitivesClient
  )

  type InternalConfig = Config

  const DBE_COMMITMENT_POLICY := CMP.CommitmentPolicy.DBE(CMP.DBECommitmentPolicy.REQUIRE_ENCRYPT_REQUIRE_DECRYPT)

  predicate ValidInternalConfig?(config: InternalConfig)
  {config.primatives.ValidState()}

  function ModifiesInternalConfig(config: InternalConfig) : set<object>
  {config.primatives.Modifies}

  predicate EncryptStructureEnsuresPublicly(
    input: EncryptStructureInput,
    output: Result<EncryptStructureOutput, Error>) {
      // Input and output types must be the same, and this constraint is useful to Dafny users
    && (output.Success? && input.plaintextStructure.content.DataMap? ==> output.value.encryptedStructure.content.DataMap?)
    && (output.Success? && input.plaintextStructure.content.DataList? ==> output.value.encryptedStructure.content.DataList?)
    && (output.Success? && input.plaintextStructure.content.Terminal? ==> output.value.encryptedStructure.content.Terminal?)
  }

  // given a list of CryptoSchema, return only the ones with an Action matching the supplied function
  function method {:tailrecursion} {:opaque} FilterSchemaC(orig : seq<Bytes>, canonSchema : map<Bytes, CryptoSchema>, f : (CryptoAction) -> bool)
    : (ret : seq<Bytes>)
    requires forall k <- orig :: k in canonSchema && canonSchema[k].content.Action?
    ensures forall k <- ret :: k in orig
  {
    if |orig| == 0 then
      []
    else if f(canonSchema[orig[0]].content.Action) then
      [orig[0]] + FilterSchemaC(orig[1..], canonSchema, f)
    else
      FilterSchemaC(orig[1..], canonSchema, f)
  }

  // given a list of CryptoSchema, return only the ones with an Action matching the supplied function
  function method {:tailrecursion} {:opaque} FilterSchema(orig : seq<string>, schema : map<string, CryptoSchema>, f : (CryptoAction) -> bool)
    : (ret : seq<string>)
    requires forall k <- orig :: k in schema && schema[k].content.Action?
    ensures forall k <- ret :: k in orig
  {
    if |orig| == 0 then
      []
    else if f(schema[orig[0]].content.Action) then
      [orig[0]] + FilterSchema(orig[1..], schema, f)
    else
      FilterSchema(orig[1..], schema, f)
  }

  // given a list of AuthenticateSchema, return only the ones with an Action matching the supplied value
  function method {:tailrecursion} {:opaque} FilterAuth(orig : seq<Bytes>, canonSchema : map<Bytes, AuthenticateSchema>, action : AuthenticateAction)
    : (ret : seq<Bytes>)
    requires forall k <- orig :: k in canonSchema && canonSchema[k].content.Action?
    ensures forall k <- ret :: k in orig
  {
    if |orig| == 0 then
      []
    else if canonSchema[orig[0]].content.Action == action then
      [orig[0]] + FilterAuth(orig[1..], canonSchema, action)
    else
      FilterAuth(orig[1..], canonSchema, action)
  }

  // given a list of fields, return only those that should be encrypted, according to the legend
  function method {:tailrecursion} {:opaque} FilterEncrypted(fields : seq<Bytes>, legend : Header.Legend)
    : (ret : seq<Bytes>)
    requires |fields| == |legend|
    ensures forall k <- ret :: k in fields
  {
    if |fields| == 0 then
      []
    else if legend[0] == Header.ENCRYPT_AND_SIGN_LEGEND then
      [fields[0]] + FilterEncrypted(fields[1..], legend[1..])
    else
      FilterEncrypted(fields[1..], legend[1..])
  }

  // Fail unless the attribute exists, and is a binary terminal
  function method NeedBinary(data : StructuredDataMap, attr : string): (result: Outcome<Error>)
  {
    if attr !in data then
      Fail(E("The attribute name " + attr + " is required."))
    else if !data[attr].content.Terminal? then
      Fail(E(attr + " must be a Terminal."))
    else if data[attr].content.Terminal.typeId != BYTES_TYPE_ID then
      Fail(E(attr + " must be a binary Terminal."))
    else
      Pass
  }

  function method GetCanonicalTerminal(value : StructuredDataTerminal, isEncrypted : bool)
    : Result<Bytes, Error>
  {
    if isEncrypted then
      :- Need(2 <= |value.value| < UINT64_LIMIT, E("Bad length."));
      Success(UInt64ToSeq((|value.value| - 2) as uint64) + EncodeAscii("ENCRYPTED"))
    else
      :- Need(|value.value| < UINT64_LIMIT, E("Bad length."));
      Success(UInt64ToSeq((|value.value|) as uint64) + EncodeAscii("PLAINTEXT") + value.typeId)
  }

  function method GetCanonicalItem(field : Bytes, value : StructuredData, isEncrypted : bool)
    : Result<Bytes, Error>
    requires value.content.Terminal?
  {
    var middle :- GetCanonicalTerminal(value.content.Terminal, isEncrypted);
    Success(field + middle + GetValue(value))
  }

  // return the canonical representation of the StructuredData
  // TODO - implement for real, once we have a spec; but this should still mostly fail at the right times.
  // fields : remaining fields to be canonized
  // encFields : fields that are encrypted
  function method CanonContent (
    fields : seq<Bytes>,
    encFields : seq<Bytes>,
    encData : map<Bytes, StructuredData>,
    allData : map<Bytes, StructuredData>,
    canonized : Bytes := []
  ) : Result<Bytes, Error>
    requires forall k <- fields :: k in allData
    requires forall k <- encFields :: k in allData
    requires forall k <- encData :: encData[k].content.Terminal?
    requires forall k <- allData :: allData[k].content.Terminal?
  {
    if |fields| == 0 then
      Success(canonized)
    else
      var data := if fields[0] in encData then encData[fields[0]] else allData[fields[0]];
      var newPart :- GetCanonicalItem(fields[0], data, fields[0] in encFields);
      CanonContent(fields[1..], encFields, encData, allData, canonized + newPart)
  }

  function method SumValueSize(fields : seq<string>, data : map<string, StructuredData>)
    : nat
    requires forall k <- fields :: k in data
    requires forall k <- data :: data[k].content.Terminal?
  {
    if |fields| == 0 then
      0
    else
      |data[fields[0]].content.Terminal.value| + SumValueSize(fields[1..], data)
  }

  // return the footer value for the StructuredData
  method GetFooter(
    client: Primitives.AtomicPrimitivesClient,
    key : Key,
    edks : CMP.EncryptedDataKeyList,
    alg : CMP.AlgorithmSuiteInfo,
    signedFields : seq<Bytes>,
    encFields : seq<Bytes>,
    encData : map<Bytes, StructuredData>,
    allData : map<Bytes, StructuredData>,
    header : Bytes)
    returns (ret : Result<Bytes, Error>)
    requires ValidSuite(alg)
    requires forall k <- signedFields :: k in allData
    requires forall k <- encFields :: k in allData
    requires forall k <- encData :: encData[k].content.Terminal?
    requires forall k <- allData :: allData[k].content.Terminal?
  {
    var canon :- CanonContent(signedFields, encFields, encData, allData);
    var data := header /* + AAD */ + canon;
    var resultR := Digest.Digest(Prim.DigestInput(digestAlgorithm := Prim.SHA_384, message := data));
    var sha :- resultR.MapFailure(e => AwsCryptographyPrimitives(e));
    var result : seq<uint8> := [];
    for i := 0 to |edks| {
      var hash := HKDF.Hkdf(
        alg.commitment.HKDF.hmac,
        None, // salt
        key,
        [], // edks[i].hmac, // info
        alg.commitment.HKDF.outputKeyLength as int
      );
     // :- Need(|hash| == 48, E("Bad hash length"));
     :- Need(|hash| >= 32, E("Bad hash length"));
      result := result + (hash+hash)[..48];
    }
    // if flavor == signed
    result := result + sha + sha; // 96 bytes
    return Success(result);
  }

  method {:opaque} GetStructuredEncryptionMaterials(
    cmm : AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsManager,
    encryptionContext : Option<AwsCryptographyMaterialProvidersTypes.EncryptionContext>,
    algorithmSuiteId: Option<CMP.DBEAlgorithmSuiteId>,
    encryptedTerminalDataNum : nat,
    totalEncryptedTerminalValuesSize : nat
  )
    returns (ret : Result<CMP.EncryptionMaterials, Error>)
    ensures ret.Success? ==>
      && var mat := ret.value;
      && mat.plaintextDataKey.Some?
      && |mat.plaintextDataKey.value| == 32
      && ValidSuite(mat.algorithmSuite)

      //= specification/structured-encryption/encrypt-structure.md#retrieve-encryption-materials
      //= type=implication
      //# This operation MUST obtain a set of encryption materials by calling
      //# [Get Encryption Materials](https://github.com/awslabs/aws-encryption-sdk-specification/blob/master/framework/cmm-interface.md#get-encryption-materials)
      //# on the input [CMM](#cmm).
      && (|cmm.History.GetEncryptionMaterials| == |old(cmm.History.GetEncryptionMaterials)| + 1)
      && Seq.Last(cmm.History.GetEncryptionMaterials).output.Success?
      && var getEncIn := Seq.Last(cmm.History.GetEncryptionMaterials).input;
      //= specification/structured-encryption/encrypt-structure.md#retrieve-encryption-materials
      //= type=implication
      //# - Encryption Context: If provided, this MUST be the [input encryption context](#encryption-context);
      //# otherwise, this is an empty encryption context.
      && (|| (encryptionContext.None? && getEncIn.encryptionContext == map[])
          || (encryptionContext.Some? && getEncIn.encryptionContext == encryptionContext.value))

      //= specification/structured-encryption/encrypt-structure.md#retrieve-encryption-materials
      //= type=implication
      //# - Commitment Policy: This MUST be
      //# [REQUIRE_ENCRYPT_REQUIRE_DECRYPT](https://github.com/awslabs/aws-encryption-sdk-specification/blob/master/framework/commitment-policy.md#esdkrequire_encrypt_require_decrypt).
      && getEncIn.commitmentPolicy == DBE_COMMITMENT_POLICY

      //= specification/structured-encryption/encrypt-structure.md#retrieve-encryption-materials
      //= type=implication
      //# - Max Plaintext Length: This field MUST be the result of the calculation `encryptedTerminalDataNum * 2 + totalEncryptedTerminalValuesSize`
      // - `encryptedTerminalDataNum` is the number of [Terminal Data](./structures.md#terminal-data)
      //   in the [input Structured Data](#structured-data) being encrypted,
      //   as defined by the [input Crypto Schema](#crypto-schema).
      // - `totalEncryptedTerminalValuesSize` is the sum of the length of all [Terminal Values](./structures.md#terminal-value)
      //   in the [input Structured Data](#structured-data) being encrypted,
      //   as defined by the [input Crypto Schema](#crypto-schema).
      && var maxLength :=  encryptedTerminalDataNum * 2 + totalEncryptedTerminalValuesSize;
      && maxLength < INT64_MAX_LIMIT
      && (getEncIn.maxPlaintextLength == Some(maxLength as int64))

    modifies cmm.Modifies
    requires cmm.ValidState()
    ensures cmm.ValidState()
  {
    var maxLength :=  encryptedTerminalDataNum * 2 + totalEncryptedTerminalValuesSize;
    :- Need(maxLength < INT64_MAX_LIMIT, E("Encrypted Size too long."));

    var algorithmSuiteId := if algorithmSuiteId.Some? then
      Some(CMP.AlgorithmSuiteId.DBE(algorithmSuiteId.value))
    else
      None;

    var matR := cmm.GetEncryptionMaterials(
      CMP.GetEncryptionMaterialsInput(
        encryptionContext := encryptionContext.UnwrapOr(map[]),
        commitmentPolicy := DBE_COMMITMENT_POLICY,
        algorithmSuiteId := algorithmSuiteId,
        maxPlaintextLength := Some(maxLength as int64)
      )
    );

    var matOutput :- matR.MapFailure(e => AwsCryptographyMaterialProviders(e));
    var mat := matOutput.encryptionMaterials;
    :- Need(mat.plaintextDataKey.Some?, E("Encryption material has no key"));
    :- Need(|mat.plaintextDataKey.value| == 32, E("Key wrong size."));
    var key : Key := mat.plaintextDataKey.value;
    var alg := mat.algorithmSuite;
    :- Need(ValidSuite(alg), E("Invlid Algorithm Suite"));
    return Success(mat);
  }



  datatype EncryptCanon = EncryptCanon (
    allFields : seq<string>,
    allFields_c : seq<Bytes>,
    encFields : seq<string>,
    encFields_c : seq<Bytes>,
    signedFields : seq<string>,
    signedFields_c : seq<Bytes>,
    schema : CryptoSchemaPlain,
    schema_c : CryptoSchemaCanon,
    data : StructuredDataPlain,
    data_c : StructuredDataCanon
  )

  function method {:opaque} CanonizeEncrypt(tableName : GoodString, data : StructuredDataPlain, schema : CryptoSchemaPlain)
    : (ret : Result<EncryptCanon, Error>)
    requires schema.Keys == data.Keys
    ensures ret.Success? ==>
      && var r := ret.value;
      && r.data == data
      && r.schema == schema
      && r.data_c.Keys == r.schema_c.Keys
      && |r.encFields| == |r.encFields_c|
      && |r.signedFields| == |r.signedFields_c|
      && |r.schema| == |r.schema_c|
      && |r.data| == |r.data_c|
      && (forall k <- r.encFields :: k in r.data)
      && (forall k <- r.signedFields :: k in r.data)
      && (forall k <- r.encFields_c :: k in r.data_c)
      && (forall k <- r.signedFields_c :: k in r.data_c)
    {
      var allFields := Sets.ComputeSetToOrderedSequence2(data.Keys, CharLess);

      var encFields := FilterSchema(allFields, schema, a => a == ENCRYPT_AND_SIGN);
      var signedFields := FilterSchema(allFields, schema, a => a != DO_NOTHING);

      Paths.SimpleCanonUnique(tableName);
      var schema_c : map<Bytes, CryptoSchema> := map k | k in schema.Keys :: Paths.SimpleCanon(tableName, k) := schema[k];
      var data_c : map<Bytes, StructuredData> := map k | k in data.Keys :: Paths.SimpleCanon(tableName, k) := data[k];

      :- Need(data_c.Keys == schema_c.Keys, E("Internal Error C1."));
      :- Need(|schema| == |schema_c|, E("Internal Error C2."));

      var allFields_c := Sets.ComputeSetToOrderedSequence2(data_c.Keys, ByteLess);
      var encFields_c := FilterSchemaC(allFields_c, schema_c, a => a == ENCRYPT_AND_SIGN);
      var signedFields_c := FilterSchemaC(allFields_c, schema_c, a => a != DO_NOTHING);

      :- Need(|encFields| == |encFields_c|, E("Internal Error C3."));
      :- Need(|signedFields| == |signedFields_c|, E("Internal Error C4."));

      Success(EncryptCanon(
        allFields,
        allFields_c,
        encFields,
        encFields_c,
        signedFields,
        signedFields_c,
        schema,
        schema_c,
        data,
        data_c
      ))
    }

  method EncryptStructure(config: InternalConfig, input: EncryptStructureInput)
    returns (output: Result<EncryptStructureOutput, Error>)
    ensures output.Success? ==>
      //= specification/structured-encryption/encrypt-structure.md#structured-data
      //= type=implication
      //# This Structured Data MUST be a [Structured Data Map](./structures.md#structured-data-map).
      && input.plaintextStructure.content.DataMap?

      //= specification/structured-encryption/encrypt-structure.md#structured-data
      //= type=implication
      //# This Structured Data MUST NOT already contain data located at the [header index](./header.md#header-index)
      //# or the [footer index](./footer.md#footer-index).
      && var plainRecord := input.plaintextStructure.content.DataMap;
      && DataMapIsFlat(plainRecord)
      && HeaderField !in plainRecord
      && FooterField !in plainRecord

      //= specification/structured-encryption/encrypt-structure.md#crypto-schema
      //= type=implication
      //# The Crypto Schema MUST explicitly configure a [Crypto Action](./structures.md#crypto-action) for every
      //# [Terminal Data](./structures.md#terminal-data) that exists on the [input Structured Data](#structured-data),
      //# and MUST NOT describe Crypto Actions for locations within the input Structured Data that either
      //# do not exist, or contain non-Terminal Data structures;
      //# otherwise, this operation operation MUST yield an error.
      && input.cryptoSchema.content.SchemaMap?
      && var cryptoSchema := input.cryptoSchema.content.SchemaMap;
      && CryptoSchemaMapIsFlat(cryptoSchema)
      && plainRecord.Keys == cryptoSchema.Keys
  {
    :- Need(input.plaintextStructure.content.DataMap?, E("Input struture must be a DataMap"));
    :- Need(input.cryptoSchema.content.SchemaMap?, E("Input Crypto Schema must be a SchemaMap"));

    var cryptoSchema := input.cryptoSchema.content.SchemaMap;
    :- Need(CryptoSchemaMapIsFlat(cryptoSchema), E("Schema must be flat."));
    :- Need(forall k <- cryptoSchema :: ValidString(k), E("Schema has bad attribute name."));

    var plainRecord := input.plaintextStructure.content.DataMap;
    :- Need(DataMapIsFlat(plainRecord), E("Input DataMap must be flat."));
    :- Need(HeaderField !in plainRecord, E("The attribute name " + HeaderField + " is reserved."));
    :- Need(FooterField !in plainRecord, E("The attribute name " + FooterField + " is reserved."));
    :- Need(plainRecord.Keys == cryptoSchema.Keys, E("Schema must exactly match record"));

    :- Need(ValidString(input.tableName), E("Bad Table Name"));
    var context :- CanonizeEncrypt(input.tableName, plainRecord, cryptoSchema);

    var mat :- GetStructuredEncryptionMaterials(
                input.cmm,
                input.encryptionContext,
                input.algorithmSuiteId,
                |context.encFields|,
                SumValueSize(context.encFields, context.data));

    var key : Key := mat.plaintextDataKey.value;
    var alg := mat.algorithmSuite;

    //= specification/structured-encryption/header.md#message-id
    //# Implementations MUST generate a fresh 256-bit random MessageID, from a cryptographically secure source, for each record encrypted.
    var randBytes := Random.GenerateBytes(32);
    var msgID :- randBytes.MapFailure(e => Error.AwsCryptographyPrimitives(e));
    var head :- Header.Create(input.tableName, input.cryptoSchema, msgID, mat);

    var commitKey := Crypt.GetCommitKey(alg, key, head.msgID);
    var headerSerialized :- Header.Serialize(config.primatives, alg, commitKey, head);
    var headerAttribute := ValueToData(headerSerialized, BYTES_TYPE_ID);

    :- Need(|context.encFields_c| < (UINT32_LIMIT / 3), E("Too many encrypted fields"));
    var encryptedItems :- Crypt.Crypt(Crypt.Encrypt, config.primatives, alg, key, head, context.encFields_c, context.data_c);

    var result : map<string, StructuredData> := map k | k in context.data.Keys :: k :=
      var c := Paths.SimpleCanon(input.tableName, k);
      if c in encryptedItems then
        encryptedItems[c]
      else
        context.data[k];

    var footer :- GetFooter(config.primatives, key, mat.encryptedDataKeys, alg,
                  context.signedFields_c, context.encFields_c, encryptedItems, context.data_c, headerSerialized);
    var footerAttribute := ValueToData(footer, BYTES_TYPE_ID);

    result := result + map[HeaderField := headerAttribute, FooterField := footerAttribute];

    var encryptOutput := EncryptStructureOutput(encryptedStructure := StructuredData(
      content := StructuredDataContent.DataMap(
        DataMap := result
      ),
      attributes := None
    ));
    return Success(encryptOutput);
  }

  predicate DecryptStructureEnsuresPublicly(
    input: DecryptStructureInput,
    output: Result<DecryptStructureOutput, Error>) {
      // Input and output types must be the same, and this constraint is useful to Dafny users
    && (output.Success? && input.encryptedStructure.content.DataMap? ==> output.value.plaintextStructure.content.DataMap?)
    && (output.Success? && input.encryptedStructure.content.DataList? ==> output.value.plaintextStructure.content.DataList?)
    && (output.Success? && input.encryptedStructure.content.Terminal? ==> output.value.plaintextStructure.content.Terminal?)
  }

  method DecryptStructure(config: InternalConfig, input: DecryptStructureInput)
    returns (output: Result<DecryptStructureOutput, Error>)
    ensures output.Success? ==>
      && input.encryptedStructure.content.DataMap?
      && var encRecord := input.encryptedStructure.content.DataMap;

      //= specification/structured-encryption/header.md#header-index
      //= type=implication
      //# The header MUST exist at string index "aws_dbe_head" for
      //# encrypted [Structured Data](./structures.md#structured-data).
      && NeedBinary(encRecord, HeaderField).Pass?

      //= specification/structured-encryption/footer.md#footer-index
      //= type=implication
      //# The header MUST exist at string index "aws_dbe_foot" for
      //# encrypted [Structured Data](./structures.md#structured-data).
      && NeedBinary(encRecord, FooterField).Pass?
  {
    :- Need(input.authenticateSchema.content.SchemaMap?, E("Authenticate Schema must be a SchemaMap"));
    var authSchema := input.authenticateSchema.content.SchemaMap;
    :- Need(AuthSchemaIsFlat(authSchema), E("Schema must be flat."));

    :- Need(input.encryptedStructure.content.DataMap?, E("Input struture must be a DataMap"));
    var encRecord := input.encryptedStructure.content.DataMap;
    :- Need(DataMapIsFlat(encRecord), E("Input DataMap must be flat."));
    :- Need(authSchema.Keys == encRecord.Keys, E("Authenticate schema must match encrypted structure exactly."));
    :- NeedBinary(encRecord, HeaderField);
    :- NeedBinary(encRecord, FooterField);

    var headerSerialized := encRecord[HeaderField].content.Terminal.value;
    var footerSerialized := encRecord[FooterField].content.Terminal.value;
    var head :- Header.PartialDeserialize(headerSerialized);
    var algorithmSuiteR := AlgorithmSuites.GetAlgorithmSuiteInfo([0x67, head.flavor as uint8]);
    var algorithmSuite :- algorithmSuiteR.MapFailure(e => AwsCryptographyMaterialProviders(e));

    var matR := input.cmm.DecryptMaterials(
      CMP.DecryptMaterialsInput (
        algorithmSuiteId := algorithmSuite.id,
        commitmentPolicy := DBE_COMMITMENT_POLICY,
        encryptedDataKeys := head.dataKeys,
        encryptionContext := head.encContext
      )
    );

    var matOutput :- matR.MapFailure(e => AwsCryptographyMaterialProviders(e));
    var mat := matOutput.decryptionMaterials;
    :- Need(mat.plaintextDataKey.Some?, E("Encryption material has no key"));
    :- Need(|mat.plaintextDataKey.value| == 32, E("Key Wrong Size"));
    var key : Key := mat.plaintextDataKey.value;
    var alg := mat.algorithmSuite;
    :- Need(ValidSuite(alg), E("Invlid Algorithm Suite"));
    var commitKey := Crypt.GetCommitKey(alg, key, head.msgID);
    var ok :- head.check(config.primatives, alg, commitKey, headerSerialized);

    :- Need(ValidString(input.tableName), E("Bad Table Name"));
    Paths.SimpleCanonUnique(input.tableName);

    var canonSchema : map<Bytes, AuthenticateSchema> := map k <- authSchema :: Paths.SimpleCanon(input.tableName, k) := authSchema[k];
    var canonRecord : map<Bytes, StructuredData> := map k <- encRecord :: Paths.SimpleCanon(input.tableName, k) := encRecord[k];
    var dataFields := Sets.ComputeSetToOrderedSequence2(canonRecord.Keys, ByteLess);
    :- Need(forall k <- canonRecord :: canonRecord[k].content.Terminal?, E("Internal Error"));
    :- Need(forall k <- canonSchema :: canonSchema[k].content.Action?, E("Internal Error"));

    var signedFields := FilterAuth(dataFields, canonSchema, SIGN);
    if |head.legend| < |signedFields| {
      return Failure(E("Schema changed : something that was unsigned is now signed."));
    }
    if |head.legend| > |signedFields| {
      return Failure(E("Schema changed : something that was signed is now unsigned."));
    }
    assert |head.legend| == |signedFields|;

    var encryptedFields := FilterEncrypted(signedFields, head.legend);
    :- Need(|encryptedFields| < (UINT32_LIMIT / 3), E("Too many encrypted fields."));

    var footer :- GetFooter(config.primatives, key, head.dataKeys, alg,
                            signedFields, encryptedFields, map[], canonRecord, headerSerialized);
    :- Need(footer == footerSerialized, E("Footer mismatch."));

    var decryptedItems :- Crypt.Crypt(Crypt.Decrypt, config.primatives, alg, key, head, encryptedFields, canonRecord);

    var result : map<string, StructuredData> := map k | k in encRecord.Keys :: k :=
      var c := Paths.SimpleCanon(input.tableName, k);
      if c in decryptedItems then
        decryptedItems[c]
      else
        encRecord[k];

    var decryptOutput := DecryptStructureOutput(plaintextStructure := StructuredData(
      content := StructuredDataContent.DataMap(
        DataMap := result - {HeaderField, FooterField}
      ),
      attributes := None
    ));

    output := Success(decryptOutput);
  }
}
