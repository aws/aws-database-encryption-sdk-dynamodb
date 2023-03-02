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
  import Materials
  import Crypt = StructuredEncryptionCrypt
  import Paths = StructuredEncryptionPaths
  import SortedSets
  import Seq
  import Digest
  import Defaults
  import HKDF
  import AlgorithmSuites

  datatype Config = Config(
    primitives : Primitives.AtomicPrimitivesClient
  )

  type InternalConfig = Config

  const DBE_COMMITMENT_POLICY := CMP.CommitmentPolicy.DBE(CMP.DBECommitmentPolicy.REQUIRE_ENCRYPT_REQUIRE_DECRYPT)

  predicate ValidInternalConfig?(config: InternalConfig)
  {config.primitives.ValidState()}

  function ModifiesInternalConfig(config: InternalConfig) : set<object>
  {config.primitives.Modifies}

  predicate EncryptStructureEnsuresPublicly(
    input: EncryptStructureInput,
    output: Result<EncryptStructureOutput, Error>) {
      // Input and output types must be the same, and this constraint is useful to Dafny users
    && (output.Success? && input.plaintextStructure.content.DataMap? ==> output.value.encryptedStructure.content.DataMap?)
    && (output.Success? && input.plaintextStructure.content.DataList? ==> output.value.encryptedStructure.content.DataList?)
    && (output.Success? && input.plaintextStructure.content.Terminal? ==> output.value.encryptedStructure.content.Terminal?)
  }

  // given a list of fields, return only those that should be encrypted, according to the legend
  function method {:tailrecursion} {:opaque} FilterEncrypted(fields : seq<CanonicalPath>, legend : Header.Legend)
    : (ret : seq<CanonicalPath>)
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

  // Fail unless the field exists, and is a binary terminal
  function method NeedBinary(data : StructuredDataMap, field : string): (result: Outcome<Error>)
  {
    if field !in data then
      Fail(E("The field name " + field + " is required."))
    else if !data[field].content.Terminal? then
      Fail(E(field + " must be a Terminal."))
    else if data[field].content.Terminal.typeId != BYTES_TYPE_ID then
      Fail(E(field + " must be a binary Terminal."))
    else
      Pass
  }

  // Given a StructuredDataTerminal, return the canonical value for the type, for use in the footer checksum calculations
  function method GetCanonicalType(value : StructuredDataTerminal, isEncrypted : bool)
    : Result<Bytes, Error>
  {
    if isEncrypted then
      :- Need(2 <= |value.value| < UINT64_LIMIT, E("Bad length."));
      Success(UInt64ToSeq((|value.value| - 2) as uint64) + EncodeAscii("ENCRYPTED"))
    else
      :- Need(|value.value| < UINT64_LIMIT, E("Bad length."));
      Success(UInt64ToSeq((|value.value|) as uint64) + EncodeAscii("PLAINTEXT") + value.typeId)
  }

  // Given a key value pair, return the canonical value for use in the footer checksum calculations
  function method GetCanonicalItem(fieldName : CanonicalPath, value : StructuredData, isEncrypted : bool)
    : Result<Bytes, Error>
    requires value.content.Terminal?
  {
    var middle :- GetCanonicalType(value.content.Terminal, isEncrypted);
    Success(fieldName + middle + GetValue(value))
  }

  // return the canonical representation of the StructuredData
  // TODO - implement for real, once we have a spec; but this should still mostly fail at the right times.
  // when looking for the data for a particular key, check encData first
  // if it's not there, fall back to allData
  function method CanonContent (
    fields : seq<CanonicalPath>,      // remaining fields to be canonized
    encFields : seq<CanonicalPath>,   // fields that are encrypted
    encData : StructuredDataCanon,
    allData : StructuredDataCanon,
    canonized : Bytes := []   // output
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

  // Return the sum of the sizes of the given fields
  function method SumValueSize(fields : seq<CanonicalPath>, data : StructuredDataCanon)
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
  // TODO - signatures et al
  method GetFooter(
    client: Primitives.AtomicPrimitivesClient,
    key : Key,
    edks : CMP.EncryptedDataKeyList,
    alg : CMP.AlgorithmSuiteInfo,
    signedFields : seq<CanonicalPath>,
    encFields : seq<CanonicalPath>,
    encData : StructuredDataCanon,
    allData : StructuredDataCanon,
    header : Bytes)
    returns (ret : Result<Bytes, Error>)
    requires ValidSuite(alg)
    requires forall k <- signedFields :: k in allData
    requires forall k <- encFields :: k in allData
    requires forall k <- encData :: encData[k].content.Terminal?
    requires forall k <- allData :: allData[k].content.Terminal?
  {
    var canon :- CanonContent(signedFields, encFields, encData, allData);
    var data := header /* + AAD */ + canon; // TODO - is there an AAD?
    var resultR := Digest.Digest(Prim.DigestInput(digestAlgorithm := Prim.SHA_384, message := data));
    var canonicalHash :- resultR.MapFailure(e => AwsCryptographyPrimitives(e));
    var result : Bytes := [];
    for i := 0 to |edks| {
      var input := Prim.HMacInput (
        digestAlgorithm := alg.symmetricSignature.HMAC,
        key := key, // TODO - mat.symmetricSigningKeys[i]
        message := canonicalHash
      );
      var hashR := client.HMac(input);
      var hash :- hashR.MapFailure(e => AwsCryptographyPrimitives(e));
      :- Need(|hash| == 48, E("Bad hash length"));
      result := result + hash;
    }
    if alg.signature.ECDSA? {
      // TODO - once newer private-dafny is merged
      // and also signatures are implemented
      // then calculate real sig
      result := result + canonicalHash + canonicalHash; // 96 bytes
    }
    return Success(result);
  }

  // return the appropriate EncryptionMaterials
  method {:opaque} GetStructuredEncryptionMaterials(
    cmm : CMP.ICryptographicMaterialsManager,
    encryptionContext : Option<CMP.EncryptionContext>,
    algorithmSuiteId: Option<CMP.DBEAlgorithmSuiteId>,
    encryptedTerminalDataNum : nat,
    totalEncryptedTerminalValuesSize : nat
  )
    returns (ret : Result<CMP.EncryptionMaterials, Error>)
    ensures ret.Success? ==>
      && var mat := ret.value;
      && Materials.EncryptionMaterialsHasPlaintextDataKey(mat)
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
    :- Need(Materials.EncryptionMaterialsHasPlaintextDataKey(mat), E("Encryption material has no key"));
    var alg := mat.algorithmSuite;
    :- Need(ValidSuite(alg), E("Invalid Algorithm Suite"));
    var key : Key := mat.plaintextDataKey.value;
    return Success(mat);
  }

  // for encryption, various canonized things
  datatype EncryptCanon = EncryptCanon (
    encFields_c : seq<CanonicalPath>,   // these fields should be encrypted
    signedFields_c : seq<CanonicalPath>,// these fields should be signed, sorted
    data_c : StructuredDataCanon        // all signed fields with canonized paths
  )

  // for decryption, data fields and schema, both plain field names and canonical path
  datatype DecryptCanon = DecryptCanon (
    signedFields_c : seq<CanonicalPath>,// these fields were signed, sorted
    data_c : StructuredDataCanon        // all signed fields with canonized paths
  )

  // return the subset of "fields" which are ENCRYPT_AND_SIGN 
  function method {:tailrecursion} FilterEncrypt(fields : seq<CanonicalPath>, fieldMap : CanonMap, schema : CryptoSchemaPlain)
    : (ret : seq<CanonicalPath>)
    requires forall k <- fields :: k in fieldMap
    requires forall k <- fieldMap :: fieldMap[k] in schema
    ensures forall k <- ret :: k in fields
  {
    if |fields| == 0 then
      []
    else
      var act := schema[fieldMap[fields[0]]].content.Action;
      if act == ENCRYPT_AND_SIGN then
        [fields[0]] + FilterEncrypt(fields[1..], fieldMap, schema)
      else
        FilterEncrypt(fields[1..], fieldMap, schema)
  }

  // construct the EncryptCanon
  function method {:opaque} CanonizeForEncrypt(tableName : GoodString, data : StructuredDataPlain, schema : CryptoSchemaPlain)
    : (ret : Result<EncryptCanon, Error>)
    requires schema.Keys == data.Keys
    ensures ret.Success? ==>
      && var r := ret.value;
      && (forall k <- r.encFields_c :: k in r.data_c)
      && (forall k <- r.signedFields_c :: k in r.data_c)
      && (forall k <- r.encFields_c :: k in r.signedFields_c)
  {
    Paths.SimpleCanonUnique(tableName);
    var fieldMap := map k <- data.Keys | schema[k].content.Action != DO_NOTHING :: Paths.SimpleCanon(tableName, k) := k;
    var data_c := map k <- fieldMap :: k := data[fieldMap[k]];
    var signedFields_c := SortedSets.ComputeSetToOrderedSequence2(data_c.Keys, ByteLess);
    var encFields_c := FilterEncrypt(signedFields_c, fieldMap, schema);

    Success(EncryptCanon(
      encFields_c,
      signedFields_c,
      data_c
    ))
  }

  // construct the DecryptCanon
  function method {:opaque} CanonizeForDecrypt(tableName : GoodString, data : StructuredDataPlain, schema : AuthSchemaPlain)
    : (ret : Result<DecryptCanon, Error>)
    requires schema.Keys == data.Keys
    ensures ret.Success? ==>
      && var r := ret.value;
      && (forall k <- r.signedFields_c :: k in r.data_c)
  {
    Paths.SimpleCanonUnique(tableName);
    var fieldMap := map k <- data.Keys | schema[k].content.Action == SIGN :: Paths.SimpleCanon(tableName, k) := k;
    var data_c := map k <- fieldMap :: k := data[fieldMap[k]];
    var signedFields_c := SortedSets.ComputeSetToOrderedSequence2(data_c.Keys, ByteLess);

    Success(DecryptCanon(
      signedFields_c,
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
    :- Need(input.plaintextStructure.content.DataMap?, E("Input structure must be a DataMap"));
    :- Need(input.cryptoSchema.content.SchemaMap?, E("Input Crypto Schema must be a SchemaMap"));

    var cryptoSchema := input.cryptoSchema.content.SchemaMap;
    :- Need(CryptoSchemaMapIsFlat(cryptoSchema), E("Schema must be flat."));
    :- Need(forall k <- cryptoSchema :: ValidString(k), E("Schema has bad field name."));

    var plainRecord := input.plaintextStructure.content.DataMap;
    :- Need(DataMapIsFlat(plainRecord), E("Input DataMap must be flat."));
    :- Need(HeaderField !in plainRecord, E("The field name " + HeaderField + " is reserved."));
    :- Need(FooterField !in plainRecord, E("The field name " + FooterField + " is reserved."));
    :- Need(plainRecord.Keys == cryptoSchema.Keys, E("Schema must exactly match record"));

    :- Need(ValidString(input.tableName), E("Bad Table Name"));
    var canonData :- CanonizeForEncrypt(input.tableName, plainRecord, cryptoSchema);

    var mat :- GetStructuredEncryptionMaterials(
                input.cmm,
                input.encryptionContext,
                input.algorithmSuiteId,
                |canonData.encFields_c|,
                SumValueSize(canonData.encFields_c, canonData.data_c));

    var key : Key := mat.plaintextDataKey.value;
    var alg := mat.algorithmSuite;

    //= specification/structured-encryption/header.md#message-id
    //# Implementations MUST generate a fresh 256-bit random MessageID, from a cryptographically secure source, for each record encrypted.
    var randBytes := Random.GenerateBytes(MSGID_LEN as int32);
    var msgID :- randBytes.MapFailure(e => Error.AwsCryptographyPrimitives(e));
    var head :- Header.Create(input.tableName, input.cryptoSchema, msgID, mat);

    var commitKey := Crypt.GetCommitKey(alg, key, head.msgID);
    var headerSerialized :- Header.Serialize(config.primitives, alg, commitKey, head);
    var headerAttribute := ValueToData(headerSerialized, BYTES_TYPE_ID);

    :- Need(|canonData.encFields_c| < (UINT32_LIMIT / 3), E("Too many encrypted fields"));
    var encryptedItems :- Crypt.Encrypt(config.primitives, alg, key, head, canonData.encFields_c, canonData.data_c);

    var result : map<string, StructuredData> := map k | k in plainRecord.Keys :: k :=
      var c := Paths.SimpleCanon(input.tableName, k);
      if c in encryptedItems then
        encryptedItems[c]
      else
        plainRecord[k];

    var footer :- GetFooter(config.primitives, key, mat.encryptedDataKeys, alg,
                  canonData.signedFields_c, canonData.encFields_c, encryptedItems, canonData.data_c, headerSerialized);
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

  const ReservedAuthMap : AuthSchemaPlain := map[
    HeaderField := DoNotSign, // The header field is authenticated in the footer via a separate mechanism
    FooterField := DoNotSign
  ]

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
    :- Need(AuthSchemaIsFlat(input.authenticateSchema.content.SchemaMap), E("Schema must be flat."));
    :- Need(forall k <- input.authenticateSchema.content.SchemaMap :: ValidString(k), E("Schema has bad field name."));
    var authSchema : AuthSchemaPlain := input.authenticateSchema.content.SchemaMap + ReservedAuthMap;

    :- Need(input.encryptedStructure.content.DataMap?, E("Input structure must be a DataMap"));
    :- Need(DataMapIsFlat(input.encryptedStructure.content.DataMap), E("Input DataMap must be flat."));
    :- Need(authSchema.Keys == input.encryptedStructure.content.DataMap.Keys, E("Authenticate schema must match encrypted structure exactly."));
    var encRecord : StructuredDataPlain := input.encryptedStructure.content.DataMap;
    :- NeedBinary(encRecord, HeaderField);
    :- NeedBinary(encRecord, FooterField);

    var headerSerialized := encRecord[HeaderField].content.Terminal.value;
    var footerSerialized := encRecord[FooterField].content.Terminal.value;
    var head :- Header.PartialDeserialize(headerSerialized);
    var algorithmSuite :- head.GetAlgorithmSuite();

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

    :- Need(Materials.DecryptionMaterialsWithPlaintextDataKey(mat), E("Encryption material has no key"));
    :- Need(ValidSuite(mat.algorithmSuite), E("Invalid Algorithm Suite"));
    var alg := mat.algorithmSuite;
    var key : Key := mat.plaintextDataKey.value;
    var commitKey := Crypt.GetCommitKey(alg, key, head.msgID);
    var ok :- head.verifyCommitment(config.primitives, alg, commitKey, headerSerialized);

    :- Need(ValidString(input.tableName), E("Bad Table Name"));
    var canonData :- CanonizeForDecrypt(input.tableName, encRecord, authSchema);

    if |head.legend| < |canonData.signedFields_c| {
      return Failure(E("Schema changed : something that was unsigned is now signed."));
    }
    if |head.legend| > |canonData.signedFields_c| {
      return Failure(E("Schema changed : something that was signed is now unsigned."));
    }
    assert |head.legend| == |canonData.signedFields_c|;

    var encryptedFields := FilterEncrypted(canonData.signedFields_c, head.legend);
    :- Need(|encryptedFields| < (UINT32_LIMIT / 3), E("Too many encrypted fields."));

    var footer :- GetFooter(config.primitives, key, head.dataKeys, alg,
                            canonData.signedFields_c, encryptedFields, map[], canonData.data_c, headerSerialized);
    // TODO - footer checking is more complex than this
    :- Need(footer == footerSerialized, E("Footer mismatch."));
    var decryptedItems :- Crypt.Decrypt(config.primitives, alg, key, head, encryptedFields, canonData.data_c);

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
