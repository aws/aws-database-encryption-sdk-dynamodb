// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../Model/AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.dfy"
include "../../../../submodules/MaterialProviders/libraries/src/Collections/Maps/Maps.dfy"

include "Header.dfy"
include "Footer.dfy"
include "Paths.dfy"
include "Crypt.dfy"
include "Util.dfy"

module AwsCryptographyDbEncryptionSdkStructuredEncryptionOperations refines AbstractAwsCryptographyDbEncryptionSdkStructuredEncryptionOperations {
  import opened StructuredEncryptionUtil

  import Base64
  import CMP = AwsCryptographyMaterialProvidersTypes
  import CSE = AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes
  import Prim = AwsCryptographyPrimitivesTypes
  import StructuredEncryptionHeader
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
  import Maps

  datatype Config = Config(
    primitives : Primitives.AtomicPrimitivesClient,
    materialProviders : MaterialProviders.MaterialProvidersClient
  )

  type InternalConfig = Config

  const DBE_COMMITMENT_POLICY := CMP.CommitmentPolicy.DBE(CMP.DBECommitmentPolicy.REQUIRE_ENCRYPT_REQUIRE_DECRYPT)

  predicate ValidInternalConfig?(config: InternalConfig)
  {
    && config.primitives.ValidState()
    && config.materialProviders.ValidState()
  }

  function ModifiesInternalConfig(config: InternalConfig) : set<object>
  {config.primitives.Modifies + config.materialProviders.Modifies}

  predicate EncryptStructureEnsuresPublicly(
    input: EncryptStructureInput,
    output: Result<EncryptStructureOutput, Error>) {
    // Input and output types must be the same, and this constraint is useful to Dafny users
    && (output.Success? && input.plaintextStructure.content.DataMap? ==> output.value.encryptedStructure.content.DataMap?)
    && (output.Success? && input.plaintextStructure.content.DataList? ==> output.value.encryptedStructure.content.DataList?)
    && (output.Success? && input.plaintextStructure.content.Terminal? ==> output.value.encryptedStructure.content.Terminal?)
       // Ensure the CryptoSchema in the ParsedHeader matches the input crypto Schema, minus any DO_NOTHING terminals
    && (output.Success? ==>
          // For now we only support encrypting flat maps
          && output.value.parsedHeader.cryptoSchema.content.SchemaMap?
          && var headerSchema := output.value.parsedHeader.cryptoSchema.content.SchemaMap;
          && CryptoSchemaMapIsFlat(headerSchema)
          && input.cryptoSchema.content.SchemaMap?
          && var inputSchema := input.cryptoSchema.content.SchemaMap;
          && CryptoSchemaMapIsFlat(inputSchema)
          && (forall k :: k in headerSchema ==> k in inputSchema && inputSchema[k] == headerSchema[k])
          && (forall v :: v in headerSchema.Values ==> IsAuthAttr(v.content.Action))
       )
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

  // given a list of fields, return only those that should be added to the encryption context, according to the legend
  function method {:tailrecursion} {:opaque} FilterContext(fieldMap : CanonMap, fields : seq<CanonicalPath>, legend : Header.Legend, ghost data: StructuredDataPlain)
    : (ret : seq<string>)
    requires |fields| == |legend|
    requires forall k <- fieldMap :: fieldMap[k] in data
    requires forall k <- fields :: k in fieldMap
    ensures forall k <- ret :: k in data
  {
    if |fields| == 0 then
      []
    else if legend[0] == Header.CONTEXT_AND_SIGN_LEGEND then
      [fieldMap[fields[0]]] + FilterContext(fieldMap, fields[1..], legend[1..], data)
    else
      FilterContext(fieldMap, fields[1..], legend[1..], data)
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
    //# [DBE.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_ECDSA_P384_SYMSIG_HMAC_SHA384](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/algorithm-suites.md#supported-algorithm-suites-enum).
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
              //# [Get Encryption Materials](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/cmm-interface.md#get-encryption-materials)
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
              //# [REQUIRE_ENCRYPT_REQUIRE_DECRYPT](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/commitment-policy.md#esdkrequire_encrypt_require_decrypt).
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
        maxPlaintextLength := Some(maxLength as int64),
        requiredEncryptionContextKeys := None
      )
    );

    var matOutput :- matR.MapFailure(e => AwsCryptographyMaterialProviders(e));
    var mat := matOutput.encryptionMaterials;
    :- Need(Materials.EncryptionMaterialsHasPlaintextDataKey(mat), E("Encryption material has no key"));
    var alg := mat.algorithmSuite;
    //= specification/structured-encryption/encrypt-structure.md#retrieve-encryption-materials
    //# If this algorithm suite is not a
    //# [supported suite for Database Encryption (DBE)](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/algorithm-suites.md#supported-algorithm-suites-enum),
    //# this operation MUST yield an error.
    :- Need(ValidSuite(alg), E("Invalid Algorithm Suite"));
    var key : Key := mat.plaintextDataKey.value;
    return Success(mat);
  }

  type EncryptCanon = c: EncryptCanonData | ValidEncryptCanon?(c)
    witness *

  // for Encrypt, the data necessary to construct the Intermediate Encrypted Structured Data
  datatype EncryptCanonData = EncryptCanonData (
    encFields_c : seq<CanonicalPath>,   // these fields should be encrypted, sorted
                                        // i.e. a Crypto Action of ENCRYPT_AND_SIGN
    signedFields_c : seq<CanonicalPath>,// these fields should be signed, sorted
                                        // i.e. a Crypto Action other than DO_NOTHING
    data_c : StructuredDataCanon,       // all signed fields with canonized paths
                                        // i.e. the Intermediate Encrypted Structured Data, but unencrypted
    cryptoSchema : CryptoSchema         // the crypto schema for this structure,
                                        // with all extraneous DO_NOTHING actions removed
  )

  predicate ValidEncryptCanon?(c: EncryptCanonData) {
    && (forall k :: k in c.encFields_c ==> k in c.signedFields_c)
    && (forall k :: k in c.signedFields_c ==> k in c.data_c)
    && (forall k :: k in c.data_c ==> k in c.signedFields_c)
    && c.cryptoSchema.content.SchemaMap?
    && var headerSchema := c.cryptoSchema.content.SchemaMap;
    && |c.data_c| == |headerSchema|
    && (exists tableName :: (forall k :: k in headerSchema ==> Paths.SimpleCanon(tableName, k) in c.data_c))
    && (forall v :: v in headerSchema.Values ==> v.content.Action? && IsAuthAttr(v.content.Action))
  }

  type DecryptCanon = c: DecryptCanonData | ValidDecryptCanon?(c)
    witness *

  // for Decrypt, the data necessary to construct the Intermediate Encrypted Structured Data
  datatype DecryptCanonData = DecryptCanonData (
    encFields_c : seq<CanonicalPath>,   // These fields were encrypted, sorted.
                                        // i.e. a Crypto Action of ENCRYPT_AND_SIGN
    signedFields_c : seq<CanonicalPath>,// These fields were signed, sorted
                                        // i.e. an Authenticate Action of SIGN
    data_c : StructuredDataCanon,       // All signed fields with canonized paths
                                        // i.e. the Intermediate Encrypted Structured Data, properly encrypted
    cryptoSchema : CryptoSchema,        // The crypto schema calculated from the crypto legend.
                                        // This value is returned as part of the Parsed Header.
    contextFields : seq<string>         // These fields have action CONTEXT_AND_SIGN
  )

  predicate ValidDecryptCanon?(c: DecryptCanonData) {
    && (forall k :: k in c.data_c.Keys ==> k in c.signedFields_c)
    && (forall k :: k in c.signedFields_c ==> k in c.data_c.Keys)
    && (forall k :: k in c.encFields_c ==> k in c.signedFields_c)
    && |c.encFields_c| < (UINT32_LIMIT / 3)
    && c.cryptoSchema.content.SchemaMap?
    && var actionMap := c.cryptoSchema.content.SchemaMap;
    && |c.data_c| == |actionMap|
    && (exists tableName :: (forall k :: k in actionMap ==> Paths.SimpleCanon(tableName, k) in c.data_c))
  }

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
    ensures Maps.Injective(ret)
  {
    reveal Maps.Injective();
    Paths.SimpleCanonUnique(tableName);
    map k <- data | schema[k].content.Action != DO_NOTHING :: Paths.SimpleCanon(tableName, k) := k
  }

  // construct the EncryptCanon
  function method {:opaque} {:vcs_split_on_every_assert} CanonizeForEncrypt(tableName : GoodString, data : StructuredDataPlain, schema : CryptoSchemaPlain)
    : (ret : Result<EncryptCanon, Error>)
    requires schema.Keys == data.Keys
    ensures ret.Success? ==>
              && var r := ret.value;

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

              && ret.value.cryptoSchema.content.SchemaMap?
              && var trimmedSchema := ret.value.cryptoSchema.content.SchemaMap;
              && (forall k :: k in trimmedSchema ==> k in schema && trimmedSchema[k] == schema[k])
  {
    var fieldMap := GetFieldMap(tableName, data, schema);

    var data_c : StructuredDataCanon := map k <- fieldMap :: k := data[fieldMap[k]];
    var signedFields_c : seq<CanonicalPath> := SortedSets.ComputeSetToOrderedSequence2(data_c.Keys, ByteLess);
    var encFields_c : seq<CanonicalPath> := FilterEncrypt(signedFields_c, fieldMap, schema);
    var trimmedSchema := map k <- fieldMap :: fieldMap[k] := schema[fieldMap[k]];

    assert |data_c| == |trimmedSchema| by {
      assert data_c.Keys == fieldMap.Keys;
      assert trimmedSchema.Keys == fieldMap.Values;
      LemmaInjectiveImpliesUniqueValues(fieldMap);
    }                                // with all extraneous DO_NOTHING actions removed

    assert forall k :: k in encFields_c ==> k in signedFields_c;
    assert forall k :: k in signedFields_c ==> k in data_c;
    assert forall k :: k in data_c ==> k in signedFields_c;
    var newSchema := CryptoSchemaContent.SchemaMap(trimmedSchema);
    assert |data_c| == |newSchema.SchemaMap|;

    Success(
      EncryptCanonData(
        encFields_c,
        signedFields_c,
        data_c,
        CryptoSchema(
          content := newSchema,
          attributes := None
        )
      )
    )
  }

  // construct the DecryptCanon
  function method {:opaque} {:vcs_split_on_every_assert} CanonizeForDecrypt(
    tableName: GoodString,
    data: StructuredDataPlain,
    authSchema: AuthSchemaPlain,
    legend: Header.Legend
  ) : (ret : Result<DecryptCanon, Error>)
    requires authSchema.Keys == data.Keys
    ensures ret.Success? ==>
              && |ret.value.signedFields_c| == |legend|
    ensures ret.Success? ==>
              && (forall k :: k in data.Keys && authSchema[k].content.Action.SIGN? ==> Paths.SimpleCanon(tableName, k) in ret.value.data_c.Keys)
    ensures ret.Success? ==>
              && (forall v :: v in ret.value.data_c.Values ==> v in data.Values)
    ensures ret.Success? ==>
              && ret.value.cryptoSchema.content.SchemaMap?
              && CryptoSchemaMapIsFlat(ret.value.cryptoSchema.content.SchemaMap)
              && AuthSchemaIsFlat(authSchema)
              && ValidParsedCryptoSchema(ret.value.cryptoSchema.content.SchemaMap, authSchema, tableName)
    ensures ret.Success? ==> forall k <- ret.value.contextFields :: k in data
  {
    //= specification/structured-encryption/decrypt-structure.md#calculate-signed-and-encrypted-field-lists
    //# The `signed field list` MUST be all fields for which
    //# the [Authenticate Schema](#authenticate-schema)
    //# indicates an [Authenticate Action](./structures.md#authenticate-action)
    //# of [SIGN](./structures.md#SIGN) for that field,
    //# sorted by the [Canonical Path](header.md.#canonical-path).

    reveal Maps.Injective();
    Paths.SimpleCanonUnique(tableName);
    var fieldMap := map k <- data | authSchema[k].content.Action == SIGN ::
                      Paths.SimpleCanon(tableName, k) := k;
    assert Maps.Injective(fieldMap);
    assert forall k <- fieldMap :: fieldMap[k] in data;

    var data_c := map k <- fieldMap :: k := data[fieldMap[k]];
    var signedFields_c := SortedSets.ComputeSetToOrderedSequence2(data_c.Keys, ByteLess);

    if |legend| < |signedFields_c| then
      Failure(E("Schema changed : something that was unsigned is now signed."))
    else
    if |legend| > |signedFields_c| then
      Failure(E("Schema changed : something that was signed is now unsigned."))
    else

      //= specification/structured-encryption/decrypt-structure.md#calculate-signed-and-encrypted-field-lists
      //# The `encrypted field list` MUST be all fields in the `signed field list`
      //# for which the corresponding byte in the [Encrypt Legend](header.md.#encrypt-legend)
      //# is `0x65` indicating [Encrypt and Sign](header.md.#encrypt-legend-bytes),
      //# sorted by the field's [canonical path](./header.md#canonical-path).
      var encFields_c : seq<CanonicalPath> := FilterEncrypted(signedFields_c, legend);
      :- Need(|encFields_c| < (UINT32_LIMIT / 3), E("Too many encrypted fields."));

      var contextFields : seq<string> := FilterContext(fieldMap, signedFields_c, legend, data);
      assert forall k <- contextFields :: k in data;

      var actionMap := map k <- fieldMap ::
                         fieldMap[k] := if Paths.SimpleCanon(tableName, fieldMap[k]) in encFields_c then
                                          CryptoSchema(
                                            content := CryptoSchemaContent.Action(ENCRYPT_AND_SIGN),
                                            attributes := None
                                          )
                                        else
                                          CryptoSchema(
                                            content := CryptoSchemaContent.Action(SIGN_ONLY),
                                            attributes := None
                                          );
      var cryptoSchema := CryptoSchema(
                            content := CryptoSchemaContent.SchemaMap(actionMap),
                            attributes := None
                          );

      var c := DecryptCanonData(
                 encFields_c,
                 signedFields_c,
                 data_c,
                 cryptoSchema,
                 contextFields
               );

      assert |data_c| == |actionMap| by {
        assert data_c.Keys == fieldMap.Keys;
        assert actionMap.Keys == fieldMap.Values;
        LemmaInjectiveImpliesUniqueValues(fieldMap);
      }

      assert exists tableName ::
          (forall k :: k in c.cryptoSchema.content.SchemaMap ==> Paths.SimpleCanon(tableName, k) in c.data_c);

      Success(c)
  }

  method GetV2EncryptionContext(schema : FlatSchemaMap, record : FlatDataMap)
    returns (output : Result<CMP.EncryptionContext, Error>)
    requires (forall x <- schema :: x in record)
  {
    var contextAttrs := set k <- schema | schema[k].content.Action == CONTEXT_AND_SIGN :: k;
    var contextFields := SortedSets.ComputeSetToOrderedSequence2(contextAttrs, CharLess);
    output := GetV2EncryptionContext2(contextFields, record);
  }

  method GetV2EncryptionContext2(fields : seq<string>, record : FlatDataMap)
    returns (output : Result<CMP.EncryptionContext, Error>)
    requires forall k <- fields :: k in record
  {
    var fieldMap : map<ValidUTF8Bytes, string> := map[];
    for i := 0 to |fields|
      invariant forall k <- fieldMap :: fieldMap[k] in record
    {
      var utf8Value :- UTF8.Encode(ATTR_PREFIX + fields[i]).MapFailure(e =>E(e));
      fieldMap := fieldMap[utf8Value := fields[i]];
    }
    var keys : seq<UTF8.ValidUTF8Bytes> := SortedSets.ComputeSetToOrderedSequence2(fieldMap.Keys, ByteLess);
    var newContext : CMP.EncryptionContext := map[];
    var legend : string := "";
    for i := 0 to |keys|
      //invariant newContext.Keys == set x:UTF8.ValidUTF8Bytes | x in keys[..i] :: x;
      //invariant |legend| == |newContext|
    {
      var fieldUtf8 := keys[i];
      var fieldStr := fieldMap[fieldUtf8];
      var attr : StructuredDataTerminal := record[fieldStr].content.Terminal;
      var attrStr : ValidUTF8Bytes;
      var legendChar : char;
      if attr.typeId == NULL {
        legendChar := LEGEND_LITERAL;
        attrStr := UTF8.EncodeAscii("null");
      } else if attr.typeId == STRING {
        legendChar := LEGEND_STRING;
        :- Need(ValidUTF8Seq(attr.value), E("Internal Error : string was not UTF8."));
        attrStr := attr.value;
        var yy :- expect UTF8.Decode(attrStr);
      } else if attr.typeId == NUMBER {
        legendChar := LEGEND_NUMBER;
        :- Need(ValidUTF8Seq(attr.value), E("Internal Error : number was not UTF8."));
        attrStr := attr.value;
      } else if attr.typeId == BOOLEAN {
        legendChar := LEGEND_LITERAL;
        :- Need(|attr.value| == 1, E("Internal Error : boolean was not of length 1."));
        attrStr := if attr.value[0] == 0 then UTF8.EncodeAscii("false") else UTF8.EncodeAscii("true");
      } else {
        legendChar := LEGEND_BINARY;
        attrStr := EncodeTerminal(attr);
      }
      //assert fieldUtf8 !in newContext;
      newContext := newContext[fieldUtf8 := attrStr];
      legend := legend + [legendChar];
    }
    var utf8Legend :- UTF8.Encode(legend).MapFailure(e =>E(e));
    newContext := newContext[LEGEND_UTF8 := utf8Legend];

    return Success(newContext);
  }

  method {:vcs_split_on_every_assert} EncryptStructure(config: InternalConfig, input: EncryptStructureInput)
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
    :- Need(exists k <- cryptoSchema :: IsAuthAttr(cryptoSchema[k].content.Action),
            E("At least one field in the Crypto Schema must be ENCRYPT_AND_SIGN, CONTEXT_AND_SIGN or SIGN_ONLY."));

    :- Need(DataMapIsFlat(input.plaintextStructure.content.DataMap), E("Input DataMap must be flat."));
    var plainRecord : FlatDataMap := input.plaintextStructure.content.DataMap;
    :- Need(HeaderField !in plainRecord, E("The field name " + HeaderField + " is reserved."));
    :- Need(FooterField !in plainRecord, E("The field name " + FooterField + " is reserved."));
    :- Need(plainRecord.Keys == cryptoSchema.Keys, E("Schema must exactly match record"));

    :- Need(ValidString(input.tableName), E("Bad Table Name"));
    var canonData :- CanonizeForEncrypt(input.tableName, plainRecord, cryptoSchema);

    var encryptionContext := input.encryptionContext.UnwrapOr(map[]);
    var cmm := input.cmm;
    if exists x <- cryptoSchema :: cryptoSchema[x].content.Action == CONTEXT_AND_SIGN {
      var newEncryptionContext :- GetV2EncryptionContext(cryptoSchema, plainRecord);
      encryptionContext := encryptionContext + newEncryptionContext;
      assert cmm.Modifies !! {config.materialProviders.History};
      var cmmR := config.materialProviders.CreateRequiredEncryptionContextCMM(
        CMP.CreateRequiredEncryptionContextCMMInput(
          underlyingCMM := Some(cmm),
          keyring := None,
          requiredEncryptionContextKeys := SortedSets.ComputeSetToOrderedSequence2(newEncryptionContext.Keys, ByteLess)
        )
      );
      cmm :- cmmR.MapFailure(e => AwsCryptographyMaterialProviders(e));
    }
    var mat :- GetStructuredEncryptionMaterials(
      cmm,
      Some(encryptionContext),
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

    var result : map<string, StructuredData> := map k <- plainRecord | true :: k :=
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

    assert {:split_here} true;

    var footer :- Footer.CreateFooter(config.primitives, mat, canonData.signedFields_c,
                                      canonData.encFields_c, encryptedItems, canonData.data_c, headerSerialized);
    var footerAttribute := footer.makeTerminal();

    result := result[HeaderField := headerAttribute];
    result := result[FooterField := footerAttribute];
    assert HeaderField in result;
    assert FooterField in result;

    var headerAlgorithmSuite :- head.GetAlgorithmSuite(config.materialProviders);
    var parsedHeader := ParsedHeader(
      cryptoSchema := canonData.cryptoSchema,
      algorithmSuiteId := headerAlgorithmSuite.id.DBE,
      encryptedDataKeys := head.dataKeys,
      storedEncryptionContext := head.encContext,
      encryptionContext := mat.encryptionContext
    );

    var encryptOutput := EncryptStructureOutput(
      encryptedStructure := StructuredData(
        content := StructuredDataContent.DataMap(
          DataMap := result
        ),
        attributes := None),
      parsedHeader := parsedHeader
    );

    return Success(encryptOutput);
  }

  predicate DecryptStructureEnsuresPublicly(
    input: DecryptStructureInput,
    output: Result<DecryptStructureOutput, Error>) {
    // Input and output types must be the same, and this constraint is useful to Dafny users
    && (output.Success? && input.encryptedStructure.content.DataMap? ==> output.value.plaintextStructure.content.DataMap?)
    && (output.Success? && input.encryptedStructure.content.DataList? ==> output.value.plaintextStructure.content.DataList?)
    && (output.Success? && input.encryptedStructure.content.Terminal? ==> output.value.plaintextStructure.content.Terminal?)
       // Ensure the CryptoSchema in the ParsedHeader is consistent with the input authenticateSchema
    && (output.Success? ==>
          // For now we only support decrypting flat maps
          && output.value.parsedHeader.cryptoSchema.content.SchemaMap?
          && var cryptoMap := output.value.parsedHeader.cryptoSchema.content.SchemaMap;
          && CryptoSchemaMapIsFlat(cryptoMap)
          && input.authenticateSchema.content.SchemaMap?
          && var authMap := input.authenticateSchema.content.SchemaMap;
          && AuthSchemaIsFlat(authMap)
          && ValidString(input.tableName)
          && ValidParsedCryptoSchema(cryptoMap, authMap + ReservedAuthMap, input.tableName))
  }

  predicate ValidParsedCryptoSchema(cryptoSchema: CryptoSchemaMap, authSchema: AuthenticateSchemaMap, tableName: GoodString)
    requires AuthSchemaIsFlat(authSchema)
    requires CryptoSchemaMapIsFlat(cryptoSchema)
  {
    // Every field in the crypto map exists in the auth map as SIGN
    && (forall k <- cryptoSchema.Keys :: k in authSchema && authSchema[k].content.Action.SIGN?)
       // The crypto map is not missing any SIGN fields from the auth map
    && (forall kv <- authSchema.Items | kv.1.content.Action.SIGN? :: kv.0 in cryptoSchema.Keys)
       // Every field in the crypto map is ENCRYPT_AND_SIGN, CONTEXT_AND_SIGN or SIGN_ONLY
    && (forall v <- cryptoSchema.Values :: IsAuthAttr(v.content.Action))
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
    :- Need(forall k <- input.authenticateSchema.content.SchemaMap | k in ReservedAuthMap ::
              input.authenticateSchema.content.SchemaMap[k] == ReservedAuthMap[k], E("Reserved fields in Schema must be DO_NOT_SIGN."));
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
    var headerAlgorithmSuite :- head.GetAlgorithmSuite(config.materialProviders);

    :- Need(ValidString(input.tableName), E("Bad Table Name"));
    var canonData :- CanonizeForDecrypt(input.tableName, encRecord, authSchema, head.legend);

    var encryptionContext := input.encryptionContext.UnwrapOr(map[]);
    var cmm := input.cmm;
    if head.version == 2 {
      var newEncryptionContext :- GetV2EncryptionContext2(canonData.contextFields, encRecord);
      encryptionContext := encryptionContext + newEncryptionContext;
      assert cmm.Modifies !! {config.materialProviders.History};
      var cmmR := config.materialProviders.CreateRequiredEncryptionContextCMM(
        CMP.CreateRequiredEncryptionContextCMMInput(
          underlyingCMM := Some(cmm),
          keyring := None,
          requiredEncryptionContextKeys := SortedSets.ComputeSetToOrderedSequence2(newEncryptionContext.Keys, ByteLess)
        )
      );
      cmm :- cmmR.MapFailure(e => AwsCryptographyMaterialProviders(e));
    }

    //= specification/structured-encryption/decrypt-structure.md#retrieve-decryption-materials
    //# This operation MUST obtain a set of decryption materials by calling
    //# [Decrypt Materials](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/cmm-interface.md#decrypt-materials)
    //# on the [input CMM](#cmm).

    //= specification/structured-encryption/decrypt-structure.md#retrieve-decryption-materials
    //# The call to the CMM's Decrypt Materials operation MUST be constructed as follows:
    // - Encryption Context: The encryption context containing exactly the union of
    //   key-value pairs in the [input Encryption Context](#encryption-context)
    //   and the key-value pairs in the [Encryption Context parsed from the header](./header.md#encryption-context).
    // - Algorithm Suite ID: The algorithm suite [indicated by the Message Format Flavor](./header.md#format-flavor)
    //   parsed in the header.
    // - Encrypted Data Keys: The [Encrypted Data Keys parsed from the header](./header.md#encrypted-data-keys).

    var matR := cmm.DecryptMaterials(
      CMP.DecryptMaterialsInput (
        algorithmSuiteId := headerAlgorithmSuite.id,
        commitmentPolicy := DBE_COMMITMENT_POLICY,
        encryptedDataKeys := head.dataKeys,
        encryptionContext := head.encContext,
        reproducedEncryptionContext := Some(encryptionContext)
      )
    );
    var matOutput :- matR.MapFailure(e => AwsCryptographyMaterialProviders(e));
    var mat := matOutput.decryptionMaterials;
    :- Need(Header.ValidEncryptionContext(mat.encryptionContext), E("Bad encryption context"));
    :- Need(Materials.DecryptionMaterialsWithPlaintextDataKey(mat), E("Encryption material has no key"));

    //= specification/structured-encryption/decrypt-structure.md#retrieve-decryption-materials
    //# The algorithm suite used in all further aspects of this operation MUST be
    //# the algorithm suite in the
    //# [decryption materials](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/structures.md#decryption-materials)
    //# returned from the Decrypt Materials call.

    //= specification/structured-encryption/decrypt-structure.md#retrieve-decryption-materials
    //# Note that the algorithm suite in the retrieved decryption materials MAY be different from the input algorithm suite.

    //= specification/structured-encryption/decrypt-structure.md#retrieve-decryption-materials
    //# If this algorithm suite is not a
    //# [supported suite for DBE](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/algorithm-suites.md#supported-algorithm-suites-enum)
    //# this operation MUST yield an error.
    :- Need(ValidSuite(mat.algorithmSuite), E("Invalid Algorithm Suite"));
    var postCMMAlg := mat.algorithmSuite;
    var key : Key := mat.plaintextDataKey.value;
    var commitKey :- Crypt.GetCommitKey(config.primitives, postCMMAlg, key, head.msgID);
    //= specification/structured-encryption/decrypt-structure.md#parse-the-header
    //# The header field value MUST be [verified](header.md#commitment-verification)
    var ok :- head.verifyCommitment(config.primitives, postCMMAlg, commitKey, headerSerialized);

    //= specification/structured-encryption/decrypt-structure.md#calculate-signed-and-encrypted-field-lists
    //= type=implication
    //# Decryption MUST fail if the length of this list does not equal the
    //# length of the header's [Encrypt Legend](header.md.#encrypt-legend).
    // this assert can be an implication, because it is explicitly ensuring an intermediate state.
    assert |head.legend| == |canonData.signedFields_c|;

    //= specification/structured-encryption/decrypt-structure.md#verify-signatures
    //# This operation MUST deserialize the bytes in [Terminal Value](./structures.md#terminal-value)
    //# according to the [footer format](./footer.md).
    var footer :- Footer.DeserializeFooter(footerSerialized, postCMMAlg.signature.ECDSA?);

    //= specification/structured-encryption/decrypt-structure.md#verify-signatures
    //# The footer field value MUST be [verified](footer.md#footer-verification).

    //= specification/structured-encryption/decrypt-structure.md#verify-signatures
    //# Decryption MUST fail immediately if verification fails.
    var _ :- footer.validate(config.primitives, mat, head.dataKeys,
                             canonData.signedFields_c, canonData.encFields_c, map[], canonData.data_c, headerSerialized);
    var decryptedItems :- Crypt.Decrypt(config.primitives, postCMMAlg, key, head, canonData.encFields_c, canonData.data_c);

    var result : map<string, StructuredData> := map k <- encRecord | true :: k :=
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

    //= specification/structured-encryption/decrypt-structure.md#construct-decrypted-structured-data
    //= type=implication
    //# The output MUST also include a [Parsed Header](#parsed-header) that contains
    //# data that was serialized into the header included in the output Structured Data.

    //= specification/structured-encryption/decrypt-structure.md#parsed-header
    //# This structure MUST contain the following values,
    //# representing the deserialized form of the header of the input encrypted structure:
    //#   - [Algorithm Suite ID](./header.md#format-flavor): The Algorithm Suite ID associated with the Format Flavor on the header.
    //#   - [Crypto Schema](./header.md#encrypt-legend): The Crypto Schema for each signed Terminal,
    //#     calculated using the Crypto Legend in the header, the signature scope used for decryption, and the data in the input structure.
    //#   - [Stored Encryption Context](./header.md#encryption-context): The Encryption Context stored in the header.
    //#   - [Encrypted Data Keys](./header.md#encrypted-data-keys): The Encrypted Data Keys stored in the header.
    var parsedHeader := ParsedHeader(
      cryptoSchema := canonData.cryptoSchema,
      algorithmSuiteId := headerAlgorithmSuite.id.DBE,
      encryptedDataKeys := head.dataKeys,
      storedEncryptionContext := head.encContext,
      encryptionContext := mat.encryptionContext
    );

    var decryptOutput := DecryptStructureOutput(
      plaintextStructure := StructuredData(
        content := StructuredDataContent.DataMap(
          DataMap := smallResult
        ),
        attributes := None),
      parsedHeader := parsedHeader
    );

    assert forall k <- decryptOutput.plaintextStructure.content.DataMap :: k in encRecord;

    output := Success(decryptOutput);
  }

  // predicates/lemmas like this are not yet provided out of the box in the standard library.
  predicate {:opaque} Contains<X, Y>(big: map<X, Y>, small: map<X, Y>)
  {
    && small.Keys <= big.Keys
    && forall x <- small :: small[x] == big[x]
  }

  lemma LemmaContainsPreservesInjectivity<X, Y>(big: map<X, Y>, small: map<X, Y>)
    requires Contains(big, small)
    requires Maps.Injective(big)
    ensures Maps.Injective(small)
  {
    reveal Contains();
    reveal Maps.Injective();
  }

  lemma LemmaInjectiveImpliesUniqueValues<X(!new), Y>(m: map<X, Y>)
    requires Maps.Injective(m)
    ensures |m.Keys| == |m.Values|
  {
    if |m| > 0 {
      var x: X :| x in m;
      var y := m[x];
      var m' := Maps.Remove(m, x);
      reveal Contains();
      assert Contains(m, m');

      reveal Maps.Injective();
      assert m'.Values == m.Values - {y};
      LemmaContainsPreservesInjectivity(m, m');
      LemmaInjectiveImpliesUniqueValues(m');
    }
  }
}
