// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../Model/AwsCryptographyDbEncryptionSdkDecryptWithPermuteTypes.dfy"
include "../../../../submodules/MaterialProviders/libraries/src/Collections/Maps/Maps.dfy"
include "../../../../DynamoDbEncryption/dafny/StructuredEncryption/Model/AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.dfy"
include "../../../../DynamoDbEncryption/dafny/StructuredEncryption/src/Footer.dfy"
include "../../../../DynamoDbEncryption/dafny/StructuredEncryption/src/Paths.dfy"
include "../../../../DynamoDbEncryption/dafny/StructuredEncryption/src/Util.dfy"
include "ValidatePermuted.dfy"

module AltDecryptStructure  {
  import opened Wrappers
  import opened StandardLibrary
  import opened StandardLibrary.UInt
  import opened AwsCryptographyDbEncryptionSdkDecryptWithPermuteTypes

  import SEU = StructuredEncryptionUtil
  import Base64
  import CMP = AwsCryptographyMaterialProvidersTypes
  import CSE = AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes
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
  import Maps
  import SEO = AwsCryptographyDbEncryptionSdkStructuredEncryptionOperations
  import ValidatePermuted

  function method E(s : string) : Error {
    DynamoDbPermuteDecryptorException(message := s)
  }

  // given a list of fields, return only those that should be encrypted, according to the legend
  function method {:tailrecursion} {:opaque} FilterEncrypted(fields : seq<SEU.CanonicalPath>, legend : Header.Legend)
    : (ret : seq<SEU.CanonicalPath>)
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
  function method {:opaque} NeedBinary(data : CSE.StructuredDataMap, field : string): (result: Outcome<Error>)
  {
    if field !in data then
      Fail(E("The field name " + field + " is required."))
    else if !data[field].content.Terminal? then
      Fail(E(field + " must be a Terminal."))
    else if data[field].content.Terminal.typeId != SEU.BYTES_TYPE_ID then
      Fail(E(field + " must be a binary Terminal."))
    else
      Pass
  }

  // Return the sum of the sizes of the given fields
  function method {:opaque} SumValueSize(fields : seq<SEU.CanonicalPath>, data : SEU.StructuredDataCanon)
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
    ensures
      && (alg.Some? ==> ret == CMP.AlgorithmSuiteId.DBE(alg.value))
      && (alg.None? ==> ret == CMP.AlgorithmSuiteId.DBE(CMP.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_ECDSA_P384_SYMSIG_HMAC_SHA384))
  {
    if alg.Some? then
      CMP.AlgorithmSuiteId.DBE(alg.value)
    else
      CMP.AlgorithmSuiteId.DBE(CMP.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_ECDSA_P384_SYMSIG_HMAC_SHA384)
  }

  type DecryptCanon = c: DecryptCanonData | ValidDecryptCanon?(c)
  witness *

  // for Decrypt, the data necessary to construct the Intermediate Encrypted Structured Data
  datatype DecryptCanonData = DecryptCanonData (
    encFields_c : seq<SEU.CanonicalPath>,   // These fields were encrypted, sorted.
                                        // i.e. a Crypto Action of ENCRYPT_AND_SIGN
    signedFields_c : seq<SEU.CanonicalPath>,// These fields were signed, sorted
                                        // i.e. an Authenticate Action of SIGN
    data_c : SEU.StructuredDataCanon,       // All signed fields with canonized paths
                                        // i.e. the Intermediate Encrypted Structured Data, properly encrypted
    cryptoSchema : CSE.CryptoSchema         // The crypto schema calculated from the crypto legend.
                                        // This value is returned as part of the Parsed Header.
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
  function method {:tailrecursion} {:opaque} FilterEncrypt(fields : seq<SEU.CanonicalPath>, fieldMap : SEU.CanonMap, schema : SEU.CryptoSchemaPlain)
    : (ret : seq<SEU.CanonicalPath>)
    requires forall k <- fields :: k in fieldMap
    requires forall k <- fieldMap :: fieldMap[k] in schema
    ensures forall k <- ret :: k in fields
  {
    if |fields| == 0 then
      []
    else
      var act := schema[fieldMap[fields[0]]].content.Action;
      if act == CSE.ENCRYPT_AND_SIGN then
        [fields[0]] + FilterEncrypt(fields[1..], fieldMap, schema)
      else
        FilterEncrypt(fields[1..], fieldMap, schema)
  }

  function method GetFieldMap(tableName : SEU.GoodString, data : SEU.StructuredDataPlain, schema : SEU.CryptoSchemaPlain)
    : (ret : map<SEU.Bytes,SEU.GoodString>)
    requires schema.Keys == data.Keys
    ensures forall k <- data :: schema[k].content.Action == CSE.DO_NOTHING || Paths.SimpleCanon(tableName, k) in ret
    ensures Maps.Injective(ret)
  {
    reveal Maps.Injective();
    Paths.SimpleCanonUnique(tableName);
    map k <- data | schema[k].content.Action != CSE.DO_NOTHING :: Paths.SimpleCanon(tableName, k) := k
  }


  // construct the DecryptCanon
  function method {:opaque} {:vcs_split_on_every_assert} CanonizeForDecrypt(
    tableName: SEU.GoodString,
    data: SEU.StructuredDataPlain,
    authSchema: SEU.AuthSchemaPlain,
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
      && SEU.CryptoSchemaMapIsFlat(ret.value.cryptoSchema.content.SchemaMap)
      && SEU.AuthSchemaIsFlat(authSchema)
      && ValidParsedCryptoSchema(ret.value.cryptoSchema.content.SchemaMap, authSchema, tableName)
  {
    reveal Maps.Injective();
    Paths.SimpleCanonUnique(tableName);
    var fieldMap := map k <- data | authSchema[k].content.Action == CSE.SIGN ::
      Paths.SimpleCanon(tableName, k) := k;
    assert Maps.Injective(fieldMap);

    var data_c := map k <- fieldMap :: k := data[fieldMap[k]];
    var signedFields_c := SortedSets.ComputeSetToOrderedSequence2(data_c.Keys, SEU.ByteLess);

    if |legend| < |signedFields_c| then
      Failure(E("Schema changed : something that was unsigned is now signed."))
    else 
    if |legend| > |signedFields_c| then
      Failure(E("Schema changed : something that was signed is now unsigned."))
    else

    var encFields_c : seq<SEU.CanonicalPath> := FilterEncrypted(signedFields_c, legend);
    :- Need(|encFields_c| < (UINT32_LIMIT / 3), E("Too many encrypted fields."));

    var actionMap := map k <- fieldMap ::
      fieldMap[k] := if Paths.SimpleCanon(tableName, fieldMap[k]) in encFields_c then
        CSE.CryptoSchema(
          content := CSE.CryptoSchemaContent.Action(CSE.ENCRYPT_AND_SIGN),
          attributes := None
        )
      else
        CSE.CryptoSchema(
          content := CSE.CryptoSchemaContent.Action(CSE.SIGN_ONLY),
          attributes := None
        );
    var cryptoSchema := CSE.CryptoSchema(
      content := CSE.CryptoSchemaContent.SchemaMap(actionMap),
      attributes := None
    );

    var c := DecryptCanonData(
      encFields_c,
      signedFields_c,
      data_c,
      cryptoSchema
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

  predicate ValidParsedCryptoSchema(cryptoSchema: CSE.CryptoSchemaMap, authSchema: CSE.AuthenticateSchemaMap, tableName: SEU.GoodString)
    requires SEU.AuthSchemaIsFlat(authSchema)
    requires SEU.CryptoSchemaMapIsFlat(cryptoSchema)
  {
    // Every field in the crypto map exists in the auth map as SIGN
    && (forall k <- cryptoSchema.Keys :: k in authSchema && authSchema[k].content.Action.SIGN?)
    // The crypto map is not missing any SIGN fields from the auth map
    && (forall kv <- authSchema.Items | kv.1.content.Action.SIGN? :: kv.0 in cryptoSchema.Keys)
    // Every field in the crypto map is ENCRYPT_AND_SIGN or SIGN_ONLY
    && (forall v <- cryptoSchema.Values :: v.content.Action.SIGN_ONLY? || v.content.Action.ENCRYPT_AND_SIGN?)
  }

  const ReservedAuthMap : SEU.AuthSchemaPlain := map[
    SEU.HeaderField := SEU.DoNotSign, // The header field is authenticated in the footer via a separate mechanism
    SEU.FooterField := SEU.DoNotSign
  ]

  datatype AltDecryptStructureOutput = AltDecryptStructureOutput(
    inner : CSE.DecryptStructureOutput,
    didPermute : bool
  )

  method {:vcs_split_on_every_assert} AltDecryptStructure (config: SEO.InternalConfig, input: CSE.DecryptStructureInput, maxSetSize : nat)
    returns (output: Result<AltDecryptStructureOutput, Error>)
    modifies SEO.ModifiesInternalConfig(config)
    requires SEO.ValidInternalConfig?(config)
    ensures SEO.ValidInternalConfig?(config)
    requires input.cmm.ValidState()
    modifies input.cmm.Modifies
    ensures input.cmm.ValidState()
  {
    :- Need(input.authenticateSchema.content.SchemaMap?, E("Authenticate Schema must be a SchemaMap"));
    :- Need(SEU.AuthSchemaIsFlat(input.authenticateSchema.content.SchemaMap), E("Schema must be flat."));
    :- Need(forall k <- input.authenticateSchema.content.SchemaMap :: SEU.ValidString(k), E("Schema has bad field name."));
    :- Need(forall k <- input.authenticateSchema.content.SchemaMap | k in ReservedAuthMap ::
      input.authenticateSchema.content.SchemaMap[k] == ReservedAuthMap[k], E("Reserved fields in Schema must be DO_NOT_SIGN."));
    var authSchema : SEU.AuthSchemaPlain := input.authenticateSchema.content.SchemaMap + ReservedAuthMap;

    :- Need(input.encryptedStructure.content.DataMap?, E("Input structure must be a DataMap"));
    :- Need(SEU.DataMapIsFlat(input.encryptedStructure.content.DataMap), E("Input DataMap must be flat."));
    :- Need(authSchema.Keys == input.encryptedStructure.content.DataMap.Keys, E("Authenticate schema must match encrypted structure exactly."));
    var encRecord : SEU.StructuredDataPlain := input.encryptedStructure.content.DataMap;
    :- NeedBinary(encRecord, SEU.HeaderField);
    :- NeedBinary(encRecord, SEU.FooterField);
    :- Need(exists x :: (x in input.authenticateSchema.content.SchemaMap && input.authenticateSchema.content.SchemaMap[x].content.Action == CSE.SIGN), E("At least one Authenticate Action must be SIGN"));

    var headerSerialized := encRecord[SEU.HeaderField].content.Terminal.value;
    var footerSerialized := encRecord[SEU.FooterField].content.Terminal.value;
    var head :- Header.PartialDeserialize(headerSerialized).MapFailure(e => AwsCryptographyDbEncryptionSdkStructuredEncryption(e));
    var headerAlgorithmSuiteR := head.GetAlgorithmSuite(config.materialProviders);
    var headerAlgorithmSuite :- headerAlgorithmSuiteR.MapFailure(e => AwsCryptographyDbEncryptionSdkStructuredEncryption(e));

    var matR := input.cmm.DecryptMaterials(
      CMP.DecryptMaterialsInput (
        algorithmSuiteId := headerAlgorithmSuite.id,
        commitmentPolicy := SEO.DBE_COMMITMENT_POLICY,
        encryptedDataKeys := head.dataKeys,
        encryptionContext := head.encContext,
        reproducedEncryptionContext := input.encryptionContext
      )
    );
    var matOutput :- matR.MapFailure(e => AwsCryptographyMaterialProviders(e));
    var mat := matOutput.decryptionMaterials;
    :- Need(Header.ValidEncryptionContext(mat.encryptionContext), E("Bad encryption context"));
    :- Need(Materials.DecryptionMaterialsWithPlaintextDataKey(mat), E("Encryption material has no key"));

    :- Need(SEU.ValidSuite(mat.algorithmSuite), E("Invalid Algorithm Suite"));
    var postCMMAlg := mat.algorithmSuite;
    var key := mat.plaintextDataKey.value;
    var commitKeyR := Crypt.GetCommitKey(config.primitives, postCMMAlg, key, head.msgID);
    var commitKey :- commitKeyR.MapFailure(e => AwsCryptographyDbEncryptionSdkStructuredEncryption(e));
    var okR := head.verifyCommitment(config.primitives, postCMMAlg, commitKey, headerSerialized);
    var ok :- okR.MapFailure(e => AwsCryptographyDbEncryptionSdkStructuredEncryption(e));

    :- Need(SEU.ValidString(input.tableName), E("Bad Table Name"));
    var canonData :- CanonizeForDecrypt(input.tableName, encRecord, authSchema, head.legend);

    assert |head.legend| == |canonData.signedFields_c|;

    var footer :- Footer.DeserializeFooter(footerSerialized, postCMMAlg.signature.ECDSA?).MapFailure(e => AwsCryptographyDbEncryptionSdkStructuredEncryption(e));

    var val := footer.validate(config.primitives, mat, head.dataKeys,
                            canonData.signedFields_c, canonData.encFields_c, map[], canonData.data_c, headerSerialized);
    if val.Success? {
      var innerR := SEO.DecryptStructure(config, input);
      var inner :- innerR.MapFailure(e => AwsCryptographyDbEncryptionSdkStructuredEncryption(e));
      return Success(AltDecryptStructureOutput(inner := inner, didPermute := false));
    }

    var val2 :- ValidatePermuted.Validate(footer, config.primitives, mat, head.dataKeys,
                            canonData.signedFields_c, canonData.encFields_c, map[], canonData.data_c, headerSerialized, maxSetSize);

    var repairedData : SEU.StructuredDataPlain := map k <- encRecord | true :: k :=
      var c := Paths.SimpleCanon(input.tableName, k);
      if c in val2 then
        val2[c]
      else
        encRecord[k];

    var innerR := SEO.DecryptStructure(config, input.(encryptedStructure := CSE.StructuredData(content := CSE.DataMap(repairedData), attributes := None)));
    var inner :- innerR.MapFailure(e => AwsCryptographyDbEncryptionSdkStructuredEncryption(e));
    return Success(AltDecryptStructureOutput(inner := inner, didPermute := true));
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
