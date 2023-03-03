// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../Model/AwsCryptographyStructuredEncryptionTypes.dfy"

include "Header.dfy"
include "Footer.dfy"
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
  import Footer = StructuredEncryptionFooter
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
  function method {:opaque} NeedBinary(data : StructuredDataMap, field : string): (result: Outcome<Error>)
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

  // Return the sum of the sizes of the given fields
  function method {:opaque} SumValueSize(fields : seq<CanonicalPath>, data : StructuredDataCanon)
    : nat
    requires forall k <- fields :: k in data
  {
    if |fields| == 0 then
      0
    else
      |data[fields[0]].content.Terminal.value| + SumValueSize(fields[1..], data)
  }

  function method {:opaque} GetAlgorithmSuiteId(alg : Option<CMP.DBEAlgorithmSuiteId>)
    : (ret : CMP.AlgorithmSuiteId)
    //= specification/structured-encryption/encrypt-structure.md#retrieve-encryption-materials
    //= type=implication
    //# - Algorithm Suite: If provided, this is the [input algorithm suite](#algorithm-suite);
    //# otherwise, this field MUST be the algorithm suite corresponding to the enum
    //# [DBE.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_ECDSA_P384_SYMSIG_HMAC_SHA384](../../private-aws-encryption-sdk-dafny-staging/aws-encryption-sdk-specification/framework/algorithm-suites.md#supported-algorithm-suites-enum).
    ensures
      && (alg.Some? ==> ret == CMP.AlgorithmSuiteId.DBE(alg.value))
      && (alg.None? ==> ret == CMP.AlgorithmSuiteId.DBE(CMP.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_ECDSA_P384_SYMSIG_HMAC_SHA384))
  {
    if alg.Some? then
      CMP.AlgorithmSuiteId.DBE(alg.value)
    else
      CMP.AlgorithmSuiteId.DBE(CMP.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_ECDSA_P384_SYMSIG_HMAC_SHA384)
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
      //# [Get Encryption Materials](../../private-aws-encryption-sdk-dafny-staging/aws-encryption-sdk-specification/framework/cmm-interface.md#get-encryption-materials)
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
      //# [REQUIRE_ENCRYPT_REQUIRE_DECRYPT](../../private-aws-encryption-sdk-dafny-staging/aws-encryption-sdk-specification/framework/commitment-policy.md#esdkrequire_encrypt_require_decrypt).
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

    var algId := GetAlgorithmSuiteId(algorithmSuiteId);

    var matR := cmm.GetEncryptionMaterials(
      CMP.GetEncryptionMaterialsInput(
        encryptionContext := encryptionContext.UnwrapOr(map[]),
        commitmentPolicy := DBE_COMMITMENT_POLICY,
        algorithmSuiteId := Some(algId),
        maxPlaintextLength := Some(maxLength as int64)
      )
    );

    var matOutput :- matR.MapFailure(e => AwsCryptographyMaterialProviders(e));
    var mat := matOutput.encryptionMaterials;
    :- Need(Materials.EncryptionMaterialsHasPlaintextDataKey(mat), E("Encryption material has no key"));
    var alg := mat.algorithmSuite;
    //= specification/structured-encryption/encrypt-structure.md#retrieve-encryption-materials
    //# If this algorithm suite is not a
    //# [supported suite for Database Encryption (DBE)](../../private-aws-encryption-sdk-dafny-staging/aws-encryption-sdk-specification/framework/algorithm-suites.md#supported-algorithm-suites-enum),
    //# this operation MUST yield an error.
    :- Need(ValidSuite(alg), E("Invalid Algorithm Suite"));
    var key : Key := mat.plaintextDataKey.value;
    return Success(mat);
  }

  // for Encrypt, the data necessary to construct the Intermediate Encrypted Structured Data
  datatype EncryptCanon = EncryptCanon (
    encFields_c : seq<CanonicalPath>,   // these fields should be encrypted, sorted
                                        // i.e. a Crypto Action of ENCRYPT_AND_SIGN
    signedFields_c : seq<CanonicalPath>,// these fields should be signed, sorted
                                        // i.e. a Crypto Action other than DO_NOTHING
    data_c : StructuredDataCanon        // all signed fields with canonized paths
                                        // i.e. the Intermediate Encrypted Structured Data, but unencrypted
  )

  // for Decrypt, the data necessary to construct the Intermediate Encrypted Structured Data
  datatype DecryptCanon = DecryptCanon (
    signedFields_c : seq<CanonicalPath>,// these fields were signed, sorted
                                        // i.e. an Authenticate Action of SIGN
    data_c : StructuredDataCanon        // all signed fields with canonized paths
                                        // i.e. the Intermediate Encrypted Structured Data, properly encrypted
  )

  // return the subset of "fields" which are ENCRYPT_AND_SIGN
  function method {:tailrecursion} {:opaque} FilterEncrypt(fields : seq<CanonicalPath>, fieldMap : CanonMap, schema : CryptoSchemaPlain)
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

  function method GetFieldMap(tableName : GoodString, data : StructuredDataPlain, schema : CryptoSchemaPlain)
    : (ret : map<Bytes,GoodString>)
    requires schema.Keys == data.Keys
    ensures forall k <- data :: schema[k].content.Action == DO_NOTHING || Paths.SimpleCanon(tableName, k) in ret
  {
    Paths.SimpleCanonUnique(tableName);
    map k <- data.Keys | schema[k].content.Action != DO_NOTHING :: Paths.SimpleCanon(tableName, k) := k
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

      //= specification/structured-encryption/encrypt-structure.md#calculate-intermediate-encrypted-structured-data
      //= type=implication
      //# For every [input Terminal Data](./structures.md#terminal-data)
      //# in the [input Structured Data](#structured-data),
      //# a Terminal Data MUST exist with the same [canonical path](./header.md#canonical-path)
      //# in Intermediate Encrypted Structured Data,
      //# if the [Crypto Schema](#crypto-schema)
      //# indicates a [Crypto Action](./structures.md#crypto-action)
      //# other than [DO_NOTHING](./structures.md#DO_NOTHING).
      && (forall k <- data :: schema[k].content.Action == DO_NOTHING || Paths.SimpleCanon(tableName, k) in ret.value.data_c)

      //= specification/structured-encryption/encrypt-structure.md#calculate-intermediate-encrypted-structured-data
      //= type=implication
      //# For every [Terminal Data](./structures.md#terminal-data)
      //# in the Intermediate Encrypted Structured Data
      //# a Terminal Data MUST exist with the same [canonical path](./header.md#canonical-path)
      //# in the [input Structured Data](#structured-data).
      && (forall k <- ret.value.data_c :: (exists x :: x in data && k == Paths.SimpleCanon(tableName, x)))
  {
    var fieldMap := GetFieldMap(tableName, data, schema);
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
    //= specification/structured-encryption/decrypt-structure.md#calculate-signed-and-encrypted-field-lists
    //# The `signed field list` MUST be all fields for which
    //# the [Authenticate Schema](#authenticate-schema)
    //# indicates an [Authenticate Action](./structures.md#authenticate-action)
    //# of [SIGN](./structures.md#SIGN) for that field,
    //# sorted by the [Canonical Path](header.md.#canonical-path).

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

      //= specification/structured-encryption/encrypt-structure.md#crypto-schema
      //= type=implication
      //# The Crypto Schema MUST include at least one [ENCRYPT_AND_SIGN Crypto Action](./structures.md#encryptandsign) or
      //# [SIGN_ONLY Crypto Action](./structures.md#signonly);
      //# otherwise, this operation MUST yield an error.
      && (exists k <- cryptoSchema :: cryptoSchema[k].content.Action != DO_NOTHING)

      //= specification/structured-encryption/encrypt-structure.md#encryption-context
      //= type=implication
      //# If the input encryption context contains any entries with a key beginning with this prefix,
      //# the encryption operation MUST yield an error.
      && (
        || input.encryptionContext.None?
        || !exists k <- input.encryptionContext.value :: ReservedCryptoContextPrefixUTF8 <= input.encryptionContext.value[k]
      )

      //= specification/structured-encryption/encrypt-structure.md#encrypted-structured-data-1
      //= type=implication
      //# - The [Header Field](#header-field) MUST exist in the Encrypted Structured Data
      && HeaderField in output.value.encryptedStructure.content.DataMap

      //= specification/structured-encryption/encrypt-structure.md#encrypted-structured-data-1
      //= type=implication
      //# - The [Footer Field](#footer-field) MUST exist in the Encrypted Structured Data
      && FooterField in output.value.encryptedStructure.content.DataMap

  {
    :- Need(input.plaintextStructure.content.DataMap?, E("Input structure must be a DataMap"));
    :- Need(input.cryptoSchema.content.SchemaMap?, E("Input Crypto Schema must be a SchemaMap"));
    :- Need(
      || input.encryptionContext.None?
      || !exists k <- input.encryptionContext.value :: ReservedCryptoContextPrefixUTF8 <= input.encryptionContext.value[k],
      E("Encryption Context must not contain members beginning with " + ReservedCryptoContextPrefixString));

    var cryptoSchema := input.cryptoSchema.content.SchemaMap;
    :- Need(CryptoSchemaMapIsFlat(cryptoSchema), E("Schema must be flat."));
    :- Need(forall k <- cryptoSchema :: ValidString(k), E("Schema has bad field name."));
    :- Need(exists k <- cryptoSchema :: cryptoSchema[k].content.Action == ENCRYPT_AND_SIGN, E("Schema has bad field name."));

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
    :- Need(Header.ValidEncryptionContext(mat.encryptionContext), E("Bad encryption context"));

    //= specification/structured-encryption/header.md#message-id
    //# Implementations MUST generate a fresh 256-bit random MessageID, from a cryptographically secure source, for each record encrypted.

    //= specification/structured-encryption/encrypt-structure.md#calculate-intermediate-encrypted-structured-data
    //# The process used to generate this identifier MUST use a good source of randomness
    //# to make the chance of duplicate identifiers negligible.
    var randBytes := Random.GenerateBytes(MSGID_LEN as int32);
    var msgID :- randBytes.MapFailure(e => Error.AwsCryptographyPrimitives(e));
    var head :- Header.Create(input.tableName, input.cryptoSchema, msgID, mat);
    //= specification/structured-encryption/header.md#commit-key
    //# The commit key calculation described above MUST be performed with the record's plaintext data key
    //# and the header's message id.
    var commitKey :- Crypt.GetCommitKey(config.primitives, alg, key, head.msgID);
    var headerSerialized :- Header.Serialize(config.primitives, alg, commitKey, head);

    //= specification/structured-encryption/encrypt-structure.md#header-field
    //# The Header Field TypeID MUST be 0xFFFF

    //= specification/structured-encryption/encrypt-structure.md#header-field
    //# The Header Field Value MUST be the full serialized [header](header.md) with commitment.
    var headerAttribute := ValueToData(headerSerialized, BYTES_TYPE_ID);

    :- Need(|canonData.encFields_c| < (UINT32_LIMIT / 3), E("Too many encrypted fields"));
    var encryptedItems :- Crypt.Encrypt(config.primitives, alg, key, head, canonData.encFields_c, canonData.data_c);

    var result : map<string, StructuredData> := map k | k in plainRecord.Keys :: k :=
      var c := Paths.SimpleCanon(input.tableName, k);
      if c in encryptedItems then
        encryptedItems[c]
      else
        plainRecord[k];

    //= specification/structured-encryption/encrypt-structure.md#encrypted-structured-data-1
    //= type=implication
    //# The Encrypted Structured Data created by this operation MUST be a Structured Data such that:

    //= specification/structured-encryption/encrypt-structure.md#encrypted-structured-data-1
    //= type=implication
    //# - for every [Terminal Data](./structures.md#terminal-data) in the
    //# [Intermediate Structured Data](#calculate-intermediate-encrypted-structured-data),
    //# a Terminal Data MUST exist with the same [canonical path](./header.md#canonical-path) in the final Encrypted Structured Data.
    // this assert can be an implication, because it is explicitly ensuring an intermediate state.
    assert forall k <- canonData.data_c :: (exists m :: k == Paths.SimpleCanon(input.tableName, m) && m in result.Keys);

    //= specification/structured-encryption/encrypt-structure.md#encrypted-structured-data-1
    //= type=implication
    //# - for every [Terminal Data](./structures.md#terminal-data) in the final Encrypted Structured Data
    //# if the [Crypto Schema](#crypto-schema)
    //# indicates a [Crypto Action](./structures.md#crypto-action)
    //# other than [DO_NOTHING](./structures.md#DO_NOTHING),
    //# a Terminal Data MUST exist with the same [canonical path](./header.md#canonical-path) in the
    //# [Intermediate Structured Data](#calculate-intermediate-encrypted-structured-data).
    // this assert can be an implication, because it is explicitly ensuring an intermediate state.
    assert forall k <- result.Keys :: cryptoSchema[k].content.Action == DO_NOTHING || Paths.SimpleCanon(input.tableName, k) in canonData.data_c;

    var footer :- Footer.CreateFooter(config.primitives, mat, canonData.signedFields_c,
                canonData.encFields_c, encryptedItems, canonData.data_c, headerSerialized);
    var footerAttribute := footer.makeTerminal();

    result := result[HeaderField := headerAttribute];
    result := result[FooterField := footerAttribute];
    assert HeaderField in result;
    assert FooterField in result;

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

  function method SafeDecode(data : CMP.Utf8Bytes) : string
  {
    var x := UTF8.Decode(data);
    if x.Success? then
      x.value
    else
      "[corrupt value]"
  }

  function method {:tailrecursion} DescribeMismatch(inputFields : seq<Bytes>, inputContext : CMP.EncryptionContext, headContext : Header.CMP.EncryptionContext)
    : string
    requires forall k <- inputFields :: k in inputContext
  {
    if |inputFields| == 0 then
      ""
    else
      var key := inputFields[0];
      if key in headContext && headContext[key] != inputContext[key] then
        var keyStr := SafeDecode(key);
        var headStr := SafeDecode(headContext[key]);
        var inputStr := SafeDecode(inputContext[key]);
        var msg := "input context for " + keyStr + " was " + inputStr + " but stored context had " + headStr + "\n";
        msg + DescribeMismatch(inputFields[1..], inputContext, headContext)
      else
        DescribeMismatch(inputFields[1..], inputContext, headContext)
  }

  function method DetectMismatch(inputContext : CMP.EncryptionContext, headContext : CMP.EncryptionContext)
    : Outcome<Error>
  {
    var inputFields := SortedSets.ComputeSetToOrderedSequence2(inputContext.Keys, ByteLess);
    var str := DescribeMismatch(inputFields, inputContext, headContext);
    if |str| == 0 then
      Pass
    else
      Fail(E("Encryption Context Mismatch\n" + str))
  }

  method {:vcs_split_on_every_assert} DecryptStructure (config: InternalConfig, input: DecryptStructureInput)
    //= specification/structured-encryption/decrypt-structure.md#construct-decrypted-structured-data
    //= type=implication
    //# This operation MUST output a [Structured Data](#structured-data) with the following specifics:
    returns (output: Result<DecryptStructureOutput, Error>)
    ensures output.Success? ==>
      && input.encryptedStructure.content.DataMap?
      && DataMapIsFlat(input.encryptedStructure.content.DataMap)
      && var encRecord := input.encryptedStructure.content.DataMap;

      //= specification/structured-encryption/decrypt-structure.md#parse-the-header
      //= type=implication
      //# Given the [input Structured Data](#structured-data),
      //# this operation MUST access the [Terminal Data](./structures.md#terminal-data)
      //# at the "aws_dbe_head"

      //= specification/structured-encryption/decrypt-structure.md#parse-the-header
      //= type=implication
      //# The [Terminal Type Id](./structures.md#terminal-type-id) on this Terminal Data MUST be `0xFFFF`.
      && NeedBinary(encRecord, HeaderField).Pass?

      //= specification/structured-encryption/decrypt-structure.md#verify-signatures
      //= type=implication
      //# A footer field MUST exist with the name `aws_dbe_foot`

      //= specification/structured-encryption/decrypt-structure.md#verify-signatures
      //= type=implication
      //# The footer field TypeID MUST be 0xFFFF
      && NeedBinary(encRecord, FooterField).Pass?

      //= specification/structured-encryption/decrypt-structure.md#authenticate-schema
      //= type=implication
      //# The Authenticate Schema MUST explicitly configure a [Authenticate Action](./structures.md#authenticate-action) for every
      //# [Terminal Data](./structures.md#terminal-data) that exists on the [input Structured Data](#structured-data),
      //# and MUST NOT describe Authenticate Actions for locations within the input Structured Data that either
      //# do not exist, or contain non-Terminal Data structures;
      //# otherwise, this operation operation MUST yield an error.
      && input.authenticateSchema.content.SchemaMap?
      && input.authenticateSchema.content.SchemaMap.Keys + ReservedAuthMap.Keys == input.encryptedStructure.content.DataMap.Keys

      //= specification/structured-encryption/decrypt-structure.md#authenticate-schema
      //= type=implication
      //# The Authenticate Schema MUST include at least one [SIGN Authenticate Action](./structures.md#sign);
      //# otherwise, this operation MUST yield an error.
      && AuthSchemaIsFlat(input.authenticateSchema.content.SchemaMap)
      && (exists x :: (x in input.authenticateSchema.content.SchemaMap && input.authenticateSchema.content.SchemaMap[x].content.Action == SIGN))

      && var headerSerialized := encRecord[HeaderField].content.Terminal.value;
      //= specification/structured-encryption/decrypt-structure.md#parse-the-header
      //= type=implication
      //# This operation MUST deserialize the header bytes
      //# according to the [header format](./header.md).
      && Header.PartialDeserialize(headerSerialized).Success?
      && var head := Header.PartialDeserialize(headerSerialized).value;
      && var inputContext := input.encryptionContext.UnwrapOr(map[]);
      //= specification/structured-encryption/decrypt-structure.md#parse-the-header
      //= type=implication
      //# If the parsed [Encryption Context](./header.md#encryption-context) contains fields that exist in the
      //# [input Encryption Context](#encryption-context),
      //# and the corresponding values do not match,
      //# this operation MUST yield an error.
      && DetectMismatch(inputContext, head.encContext).Pass?

      //= specification/structured-encryption/decrypt-structure.md#construct-decrypted-structured-data
      //= type=implication
      //# - [Terminal Data](./structures.md#terminal-data) MUST NOT exist at the "aws_dbe_head"
      //# or "aws_dbe_foot".
      && HeaderField !in output.value.plaintextStructure.content.DataMap
      && FooterField !in output.value.plaintextStructure.content.DataMap
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
    :- Need(exists x :: (x in input.authenticateSchema.content.SchemaMap && input.authenticateSchema.content.SchemaMap[x].content.Action == SIGN), E("At least one Authenticate Action must be SIGN"));

    var headerSerialized := encRecord[HeaderField].content.Terminal.value;
    var footerSerialized := encRecord[FooterField].content.Terminal.value;
    //= specification/structured-encryption/decrypt-structure.md#parse-the-header
    //# This operation MUST deserialize the header bytes
    //# according to the [header format](./header.md).
    var head :- Header.PartialDeserialize(headerSerialized);
    var algorithmSuite :- head.GetAlgorithmSuite();
    var inputContext := input.encryptionContext.UnwrapOr(map[]);
    :- DetectMismatch(inputContext, head.encContext);

    //= specification/structured-encryption/decrypt-structure.md#retrieve-decryption-materials
    //# This operation MUST obtain a set of decryption materials by calling
    //# [Decrypt Materials](../../private-aws-encryption-sdk-dafny-staging/aws-encryption-sdk-specification/framework/cmm-interface.md#decrypt-materials)
    //# on the [input CMM](#cmm).

    //= specification/structured-encryption/decrypt-structure.md#retrieve-decryption-materials
    //# The call to the CMM's Decrypt Materials operation MUST be constructed as follows:
    // - Encryption Context: The encryption context containing exactly the union of
    //   key-value pairs in the [input Encryption Context](#encryption-context)
    //   and the key-value pairs in the [Encryption Context parsed from the header](./header.md#encryption-context).
    // - Algorithm Suite ID: The algorithm suite [indicated by the Message Format Flavor](./header.md#format-flavor)
    //   parsed in the header.
    // - Encrypted Data Keys: The [Encrypted Data Keys parsed from the header](./header.md#encrypted-data-keys).

    var matR := input.cmm.DecryptMaterials(
      CMP.DecryptMaterialsInput (
        algorithmSuiteId := algorithmSuite.id,
        commitmentPolicy := DBE_COMMITMENT_POLICY,
        encryptedDataKeys := head.dataKeys,
        encryptionContext := inputContext + head.encContext
      )
    );
    var matOutput :- matR.MapFailure(e => AwsCryptographyMaterialProviders(e));
    var mat := matOutput.decryptionMaterials;
    :- Need(Header.ValidEncryptionContext(mat.encryptionContext), E("Bad encryption context"));
    :- Need(Materials.DecryptionMaterialsWithPlaintextDataKey(mat), E("Encryption material has no key"));

    //= specification/structured-encryption/decrypt-structure.md#retrieve-decryption-materials
    //# The algorithm suite used in all further aspects of this operation MUST be
    //# the algorithm suite in the
    //# [decryption materials](../../private-aws-encryption-sdk-dafny-staging/aws-encryption-sdk-specification/framework/structures.md#decryption-materials)
    //# returned from the Decrypt Materials call.

    //= specification/structured-encryption/decrypt-structure.md#retrieve-decryption-materials
    //# Note that the algorithm suite in the retrieved decryption materials MAY be different from the input algorithm suite.

    //= specification/structured-encryption/decrypt-structure.md#retrieve-decryption-materials
    //# If this algorithm suite is not a
    //# [supported suite for DBE](../../private-aws-encryption-sdk-dafny-staging/aws-encryption-sdk-specification/framework/algorithm-suites.md#supported-algorithm-suites-enum)
    //# this operation MUST yield an error.
    :- Need(ValidSuite(mat.algorithmSuite), E("Invalid Algorithm Suite"));
    var alg := mat.algorithmSuite;
    var key : Key := mat.plaintextDataKey.value;
    var commitKey :- Crypt.GetCommitKey(config.primitives, alg, key, head.msgID);
    //= specification/structured-encryption/decrypt-structure.md#parse-the-header
    //# The header field value MUST be [verified](header.md#commitment-verification)
    var ok :- head.verifyCommitment(config.primitives, alg, commitKey, headerSerialized);

    :- Need(ValidString(input.tableName), E("Bad Table Name"));
    var canonData :- CanonizeForDecrypt(input.tableName, encRecord, authSchema);

    if |head.legend| < |canonData.signedFields_c| {
      return Failure(E("Schema changed : something that was unsigned is now signed."));
    }
    if |head.legend| > |canonData.signedFields_c| {
      return Failure(E("Schema changed : something that was signed is now unsigned."));
    }
    //= specification/structured-encryption/decrypt-structure.md#calculate-signed-and-encrypted-field-lists
    //= type=implication
    //# Decryption MUST fail if the length of this list does not equal the
    //# length of the header's [Encrypt Legend](header.md.#encrypt-legend).
    // this assert can be an implication, because it is explicitly ensuring an intermediate state.
    assert |head.legend| == |canonData.signedFields_c|;

    //= specification/structured-encryption/decrypt-structure.md#calculate-signed-and-encrypted-field-lists
    //# The `encrypted field list` MUST be all fields in the `signed field list`
    //# for which the corresponding byte in the [Encrypt Legend](header.md.#encrypt-legend)
    //# is `0x65` indicating [Encrypt and Sign](header.md.#encrypt-legend-bytes),
    //# sorted by the field's [canonical path](./header.md#canonical-path).
    var encryptedFields : seq<CanonicalPath> := FilterEncrypted(canonData.signedFields_c, head.legend);
    :- Need(|encryptedFields| < (UINT32_LIMIT / 3), E("Too many encrypted fields."));

    //= specification/structured-encryption/decrypt-structure.md#verify-signatures
    //# This operation MUST deserialize the bytes in [Terminal Value](./structures.md#terminal-value)
    //# according to the [footer format](./footer.md).
    var footer :- Footer.DeserializeFooter(footerSerialized, alg.signature.ECDSA?);

    //= specification/structured-encryption/decrypt-structure.md#verify-signatures
    //# The footer field value MUST be [verified](footer.md#footer-verification).

    //= specification/structured-encryption/decrypt-structure.md#verify-signatures
    //# Decryption MUST fail immediately if verification fails.
    var _ :- footer.validate(config.primitives, mat, head.dataKeys,
                            canonData.signedFields_c, encryptedFields, map[], canonData.data_c, headerSerialized);
    var decryptedItems :- Crypt.Decrypt(config.primitives, alg, key, head, encryptedFields, canonData.data_c);

    var result : map<string, StructuredData> := map k | k in encRecord.Keys :: k :=
      var c := Paths.SimpleCanon(input.tableName, k);
      if c in decryptedItems then
        decryptedItems[c]
      else
        encRecord[k];

    //= specification/structured-encryption/decrypt-structure.md#construct-decrypted-structured-data
    //# - For every [input Terminal Data](./structures.md#terminal-data) in the [input Structured Data](#structured-data)
    //# (aside from the header and footer),
    //# a Terminal Data MUST exist with the same [canonical path](./header.md#canonical-path) in the output Structured Data.
    // at this point both result and encRecord have header and footer
    assert forall k <- encRecord :: k in result;

    //= specification/structured-encryption/decrypt-structure.md#construct-decrypted-structured-data
    //# - for every [Terminal Data](./structures.md#terminal-data) in the output Structured Data,
    //# a Terminal Data MUST exist with the same [canonical path](./header.md#canonical-path) in the [input Structured Data](#structured-data).
    assert forall k <- result :: k in encRecord;

    var smallResult := result - {HeaderField, FooterField};
    // If I could prove this, I could move the above to an ensures clause
    //assert forall k <- encRecord :: (k == HeaderField || k == FooterField || k in smallResult);

    // this actually verifies, but takes too long
    // forall k <- output.value.plaintextStructure.content.DataMap :: k in encRecord



    var decryptOutput := DecryptStructureOutput(plaintextStructure := StructuredData(
      content := StructuredDataContent.DataMap(
        DataMap := smallResult
      ),
      attributes := None
    ));
    assert forall k <- decryptOutput.plaintextStructure.content.DataMap :: k in encRecord;

    output := Success(decryptOutput);
  }
}
