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
  import Digest
  import Defaults
  import HKDF

  datatype Config = Config(
    primatives : Primitives.AtomicPrimitivesClient
  )

  type InternalConfig = Config

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
  function method {:tailrecursion} {:opaque} FilterSchema(orig : seq<Bytes>, canonSchema : map<Bytes, CryptoSchema>, f : (CryptoAction) -> bool)
    : (ret : seq<Bytes>)
    requires forall k <- orig :: k in canonSchema && canonSchema[k].content.Action?
    ensures forall k <- ret :: k in orig
  {
    if |orig| == 0 then
      []
    else if f(canonSchema[orig[0]].content.Action) then
      [orig[0]] + FilterSchema(orig[1..], canonSchema, f)
    else
      FilterSchema(orig[1..], canonSchema, f)
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
    canonized : Bytes := []
  ) : Result<Bytes, Error>
    requires forall k <- fields :: k in encData
    requires forall k <- encFields :: k in encData
    requires forall k <- encData :: encData[k].content.Terminal?
  {
    if |fields| == 0 then
      Success(canonized)
    else
      var newPart :- GetCanonicalItem(fields[0], encData[fields[0]], fields[0] in encFields);
      CanonContent(fields[1..], encFields, encData, canonized + newPart)
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
    header : Bytes)
    returns (ret : Result<Bytes, Error>)
    requires ValidSuite(alg)
    requires forall k <- signedFields :: k in encData
    requires forall k <- encFields :: k in encData
    requires forall k <- encData :: encData[k].content.Terminal?
  {
    var canon :- CanonContent(signedFields, encFields, encData);
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

  method EncryptStructure(config: InternalConfig, input: EncryptStructureInput)
    returns (output: Result<EncryptStructureOutput, Error>)
  {
    var matR := input.cmm.GetEncryptionMaterials(
      CMP.GetEncryptionMaterialsInput(
        encryptionContext := input.encryptionContext.UnwrapOr(map[]),
        commitmentPolicy := CMP.CommitmentPolicy.ESDK(CMP.REQUIRE_ENCRYPT_REQUIRE_DECRYPT),
        algorithmSuiteId := None,
        maxPlaintextLength := None
      )
    );
    var matOutput :- matR.MapFailure(e => AwsCryptographyMaterialProviders(e));
    var mat := matOutput.encryptionMaterials;
    :- Need(mat.plaintextDataKey.Some?, E("Encryption material has no key"));
    :- Need(|mat.plaintextDataKey.value| == 32, E("Key wrong size."));
    var key : Key := mat.plaintextDataKey.value;
    var alg := mat.algorithmSuite;
    :- Need(ValidSuite(alg), E("Invlid Algorithm Suite"));

    //= specification/structured-encryption/header.md#message-id
    //# Implementations MUST generate a fresh 256-bit random MessageID, from a cryptographically secure source, for each record encrypted.
    var randBytes := Random.GenerateBytes(32);
    var msgID :- randBytes.MapFailure(e => Error.AwsCryptographyPrimitives(e));
    var head :- Header.Create(input.tableName, input.cryptoSchema, msgID, mat);

    :- Need(input.plaintextStructure.content.DataMap?, E("Input struture must be a DataMap"));
    :- Need(input.cryptoSchema.content.SchemaMap?, E("Input Crypto Schema must be a SchemaMap"));
    
    var cryptoSchema := input.cryptoSchema.content.SchemaMap;
    :- Need(CryptoSchemaMapIsFlat(cryptoSchema), E("Schema must be flat."));

    var plainRecord := input.plaintextStructure.content.DataMap;
    :- Need(DataMapIsFlat(plainRecord), E("Input DataMap must be flat."));
    :- Need(HeaderField !in plainRecord, E("The attribute name " + HeaderField + " is reserved."));
    :- Need(FooterField !in plainRecord, E("The attribute name " + FooterField + " is reserved."));
    :- Need(plainRecord.Keys == cryptoSchema.Keys, E("Schema must exactly match record"));
    :- Need(ValidString(input.tableName), E("Bad Table Name"));
    Paths.SimpleCanonUnique(input.tableName);
    var canonSchema : map<Bytes, CryptoSchema> := map k | k in cryptoSchema.Keys :: Paths.SimpleCanon(input.tableName, k) := cryptoSchema[k];
    var canonRecord : map<Bytes, StructuredData> := map k | k in plainRecord.Keys :: Paths.SimpleCanon(input.tableName, k) := plainRecord[k];
    var dataFields := Sets.ComputeSetToOrderedSequence2(canonRecord.Keys, Header.ByteLess);
    assert forall k <- dataFields :: k in canonRecord;
    :- Need(forall k <- canonRecord :: canonRecord[k].content.Terminal?, E("Internal Error"));
    :- Need(forall k <- canonSchema :: canonSchema[k].content.Action?, E("Internal Error"));

    var signedFields := FilterSchema(dataFields, canonSchema, a => a != DO_NOTHING);
    var encryptedFields := FilterSchema(dataFields, canonSchema, a => a == ENCRYPT_AND_SIGN);    
    :- Need(|encryptedFields| < (UINT32_LIMIT / 3), E("Too many encrypted fields"));

    var encryptedItems :- Crypt.Crypt(Crypt.Encrypt, config.primatives, alg, key, head, encryptedFields, canonRecord);
    var commitKey := Crypt.GetCommitKey(alg, key, head.msgID);
    var headerSerialized :- Header.Serialize(config.primatives, alg, commitKey, head);
    var headerAttribute := ValueToData(headerSerialized, BYTES_TYPE_ID);

    var result : map<string, StructuredData> := map k | k in plainRecord.Keys :: k :=
      var c := Paths.SimpleCanon(input.tableName, k);
      if c in encryptedItems then
        encryptedItems[c]
      else
        plainRecord[k];

    var footer :- GetFooter(config.primatives, key, mat.encryptedDataKeys, alg,
                  signedFields, encryptedFields, canonRecord, headerSerialized);
    var footerAttribute := ValueToData(footer, BYTES_TYPE_ID);

    result := result[HeaderField := headerAttribute];
    result := result[FooterField := footerAttribute];
    
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
    ensures
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

    var matR := input.cmm.DecryptMaterials(
      CMP.DecryptMaterialsInput (
        // algorithmSuiteId := GetAlgorithmSuiteInfo([0x67, head.flavor]),
        algorithmSuiteId := Defaults.GetAlgorithmSuiteForCommitmentPolicy(CMP.CommitmentPolicy.ESDK(CMP.REQUIRE_ENCRYPT_REQUIRE_DECRYPT)),
        commitmentPolicy := CMP.CommitmentPolicy.ESDK(CMP.REQUIRE_ENCRYPT_REQUIRE_DECRYPT),
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
    var dataFields := Sets.ComputeSetToOrderedSequence2(canonRecord.Keys, Header.ByteLess);
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
                            signedFields, encryptedFields, canonRecord, headerSerialized);
    //:- Need(footer == footerSerialized, E("Footer mismatch."));

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
