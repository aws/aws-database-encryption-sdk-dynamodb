// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "../Model/AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.dfy"
include "Paths.dfy"
include "Util.dfy"
include "../../../../submodules/MaterialProviders/libraries/src/Functions.dfy"
include "../../../../submodules/MaterialProviders/libraries/src/Collections/Sets/Sets.dfy"

module StructuredEncryptionHeader {
  import opened Wrappers
  import opened StandardLibrary
  import opened StandardLibrary.UInt
  import opened AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes
  import opened StructuredEncryptionUtil
  import opened StandardLibrary.MemoryMath

  import CMP = AwsCryptographyMaterialProvidersTypes
  import Prim = AwsCryptographyPrimitivesTypes
  import SortedSets
  import Sets
  import Seq
  import UTF8
  import Paths = StructuredEncryptionPaths
  import Random
  import Functions
  import MaterialProviders

  const VERSION_LEN := 1
  const FLAVOR_LEN := 1
  const COMMITMENT_LEN := 32
  const PREFIX_LEN := VERSION_LEN + FLAVOR_LEN + MSGID_LEN
  const UINT8_LIMIT := 256
  const ENCRYPT_AND_SIGN_LEGEND : uint8 := 0x65
  const SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT_LEGEND : uint8 := 0x63
  const SIGN_ONLY_LEGEND : uint8 := 0x73

  //= specification/structured-encryption/header.md#format-version
  //= type=implication
  //# The Version MUST be `0x01` or `0x02`.
  type Version = x : uint8 | ValidVersion(x) witness 1
  predicate method ValidVersion(x : uint8) {
    x == 1 || x == 2
  }

  type Flavor = x : uint8 | ValidFlavor(x)

  //= specification/structured-encryption/header.md#encrypted-data-key-count
  //= type=implication
  //# This value MUST be greater than 0.
  type CMPEncryptedDataKeyList = x : seq<CMPEncryptedDataKey> | 0 < |x| < UINT8_LIMIT witness *

  type Commitment = x: Bytes | |x| == COMMITMENT_LEN witness *
  type CMPEncryptedDataKey = x : CMP.EncryptedDataKey | ValidEncryptedDataKey(x) witness *
  type CMPEncryptionContext  = x : CMP.EncryptionContext | ValidEncryptionContext(x) witness *
  type CMPEncryptedDataKeyListEmptyOK = x : seq<CMPEncryptedDataKey> | |x| < UINT8_LIMIT
  type LegendByte = x : uint8 | ValidLegendByte(x) witness SIGN_ONLY_LEGEND
  type Legend = x : seq<LegendByte> | |x| < UINT16_LIMIT
  type CMPUtf8Bytes = x : CMP.Utf8Bytes | |x| < UINT16_LIMIT

  predicate method {:tailrecursion} IsVersion2Schema(data : CanonCryptoList, pos : uint32 := 0) : (ret : bool)
    requires |data| < UINT32_LIMIT
    requires pos <= |data| as uint32
    requires forall i | 0 <= i < pos :: data[i].action != SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT
    decreases |data| as uint32 - pos
    ensures ret <==> (exists x <- data :: x.action == SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT)
  {
    if pos == |data| as uint32 then
      false
    else if data[pos].action == SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT then
      true
    else
      IsVersion2Schema(data, pos+1)
  }

  function method VersionFromSchema(data : CanonCryptoList) : (ret : Version)
    requires |data| < UINT32_LIMIT
    ensures (exists x <- data :: x.action == SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT) <==> (ret == 2)
    ensures !(exists x <- data :: x.action == SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT) <==> (ret == 1)
  {
    if IsVersion2Schema(data) then
      2
    else
      1
  }

  //= specification/structured-encryption/header.md#format-flavor
  //= type=implication
  //# The algorithm suite indicated by the flavor MUST be a
  //# [DBE supported algorithm suite](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/algorithm-suites.md#supported-algorithm-suites-enum).
  // | Value | Algorithm Suite ID | Algorithm Suite Enum |
  // |---|---|---|
  // | 0x00 | 0x67 0x00 | ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_SYMSIG_HMAC_SHA384 |
  // | 0x01 | 0x67 0x01 | ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_ECDSA_P384_SYMSIG_HMAC_SHA384 |
  predicate method ValidFlavor(x : uint8) {
    x in [0, 1]
  }

  predicate method ValidLegendByte(x : uint8) {
    x in [ENCRYPT_AND_SIGN_LEGEND, SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT_LEGEND, SIGN_ONLY_LEGEND]
  }

  predicate method ValidEncryptionContext(x : CMP.EncryptionContext) {
    && |x| < UINT16_LIMIT
    && (forall k <- x :: |k| < UINT16_LIMIT && |x[k]| < UINT16_LIMIT)
  }

  predicate method ValidEncryptedDataKey(x : CMP.EncryptedDataKey)
  {
    && |x.keyProviderId| < UINT16_LIMIT
    && |x.keyProviderInfo| < UINT16_LIMIT
    && |x.ciphertext| < UINT16_LIMIT
  }

  // header without commitment
  datatype PartialHeader = PartialHeader (
    nameonly version : Version,
    nameonly flavor : Flavor,
    nameonly msgID : MessageID,
    nameonly legend : Legend,
    nameonly encContext : CMPEncryptionContext,
    nameonly dataKeys : CMPEncryptedDataKeyList
  )
  {
    // PartialHeader to Bytes
    function method {:opaque} serialize() : (ret : Bytes)
      ensures
        && PREFIX_LEN <= |ret|
           //= specification/structured-encryption/header.md#partial-header
           //= type=implication
           //# The Partial Header MUST be
           // | Length (bytes) | Meaning |
           // |---|---|
           // | 1 | [Format Version](#format-version) |
           // | 1 | [Format Flavor](#format-flavor) |
           // | 32 | [Message ID](#message-id) |
           // | Variable | [Encrypt Legend](#encrypt-legend) |
           // | Variable | [Encryption Context](#encryption-context) |
           // | Variable | [Encrypted Data Keys](#encrypted-data-keys) |
        && ret == (
                    [version]
                    + [flavor]
                    + msgID
                    + SerializeLegend(legend)
                    + SerializeContext(encContext)
                    + SerializeDataKeys(dataKeys)
                  )
    {
      var context := SerializeContext(encContext);
      var keys := SerializeDataKeys(dataKeys);
      var leg := SerializeLegend(legend);
      [version] + [flavor] + msgID + leg + context + keys
    }

    // Calculate key commitment. Fail if it doesn't match the stored one.
    function method verifyCommitment(
      client: Prim.IAwsCryptographicPrimitivesClient,
      alg : CMP.AlgorithmSuiteInfo,
      commitKey : Bytes,
      data : Bytes
    )
      : (ret : Result<bool, Error>)
      requires ValidSuite(alg)

      requires client.ValidState()
      ensures client.ValidState()
      ensures ret.Success? ==>
                && COMMITMENT_LEN < |data|
                && var storedCommitment := data[|data|-COMMITMENT_LEN..];
                && CalculateHeaderCommitment(client, alg, commitKey, data[..|data|-COMMITMENT_LEN]).Success?
                && var calcCommitment := CalculateHeaderCommitment(client, alg, commitKey, data[..|data|-COMMITMENT_LEN]).value;
                //= specification/structured-encryption/header.md#commitment-verification
                //= type=implication
                //# Header commitment comparisons MUST be constant time operations.
                && ConstantTimeEquals(storedCommitment, calcCommitment)
    {
      :- Need(COMMITMENT_LEN < |data|, E("Serialized header too short"));
      var storedCommitment := data[|data|-COMMITMENT_LEN..];
      var calcCommitment :- CalculateHeaderCommitment(client, alg, commitKey, data[..|data|-COMMITMENT_LEN]);
      :- Need(ConstantTimeEquals(storedCommitment, calcCommitment), E("Key commitment mismatch."));
      Success(true)
    }

    method GetAlgorithmSuite(matProv: MaterialProviders.MaterialProvidersClient) returns (ret: Result<CMP.AlgorithmSuiteInfo, Error>)
      ensures ret.Success? ==>
                ValidSuite(ret.value)
    {
      var algorithmSuiteR := matProv.GetAlgorithmSuiteInfo([DbeAlgorithmFamily, flavor as uint8]);
      if algorithmSuiteR.Success? {
        :- Need(ValidSuite(algorithmSuiteR.value), E("Invalid Algorithm Suite"));
        return Success(algorithmSuiteR.value);
      } else {
        return algorithmSuiteR.MapFailure(e => AwsCryptographyMaterialProviders(e));
      }
    }
  }

  // serialize and add commitment
  function method Serialize(
    client: Prim.IAwsCryptographicPrimitivesClient,
    alg : CMP.AlgorithmSuiteInfo,
    commitKey : Bytes,
    PartialHeader : PartialHeader
  )
    : (ret : Result<Bytes, Error>)
    requires ValidSuite(alg)

    ensures ret.Success? ==>
              && PREFIX_LEN <= |ret.value|
              && CalculateHeaderCommitment(client, alg, commitKey, ret.value[..|ret.value|-COMMITMENT_LEN]).Success?
              && ret.value[|ret.value|-COMMITMENT_LEN..] == CalculateHeaderCommitment(client, alg, commitKey, ret.value[..|ret.value|-COMMITMENT_LEN]).value

              //= specification/structured-encryption/header.md#full-header-value
              //= type=implication
              //# The value of the header MUST be
              // | Length (bytes) | Meaning |
              // |---|---|
              // | Variable | [Partial Header](#partial-header) |
              // | 32 | [Header Commitment](#header-commitment) |
              && ret.value == PartialHeader.serialize() + CalculateHeaderCommitment(client, alg, commitKey, ret.value[..|ret.value|-COMMITMENT_LEN]).value

    requires client.ValidState()
    ensures client.ValidState()
  {
    var body := PartialHeader.serialize();
    var commitment :- CalculateHeaderCommitment(client, alg, commitKey, body);
    Success(body + commitment)
  }

  // config to PartialHeader
  function method Create(
    tableName : string,
    schema : CanonCryptoList,
    msgID : MessageID,
    mat : CMP.EncryptionMaterials
  )
    : (ret : Result<PartialHeader, Error>)

    //= specification/structured-encryption/header.md#format-version
    //= type=implication
    //# If any [Crypto Action](./structures.md#crypto-action) is configured as
    //# [SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT Crypto Action](./structures.md#sign_and_include_in_encryption_context)
    //# the Version MUST be 0x02; otherwise, Version MUST be 0x01.
    ensures ret.Success? ==> |schema| < UINT32_LIMIT && ret.value.version == VersionFromSchema(schema)
  {
    :- Need(|schema| < UINT32_LIMIT, E("Unexpected large schema"));
    :- Need(ValidEncryptionContext(mat.encryptionContext), E("Invalid Encryption Context"));
    :- Need(0 < |mat.encryptedDataKeys|, E("There must be at least one data key"));
    :- Need(|mat.encryptedDataKeys| < UINT8_LIMIT, E("Too many data keys."));
    :- Need(forall x | x in mat.encryptedDataKeys :: ValidEncryptedDataKey(x), E("Invalid Data Key"));
    :- Need(|mat.algorithmSuite.binaryId| == 2, E("Invalid Algorithm Suite Binary ID"));
    :- Need(mat.algorithmSuite.binaryId[0] == DbeAlgorithmFamily, E("Algorithm Suite not suitable for structured encryption."));
    :- Need(ValidFlavor(mat.algorithmSuite.binaryId[1]), E("Algorithm Suite has unexpected flavor."));
    var legend :- MakeLegend(schema);

    //= specification/structured-encryption/encrypt-path-structure.md#header-field
    //# The encryption context field serialized in the header MUST contain all key-value
    //# pairs of the encryption context in the [encryption materials](#retrieve-encryption-materials)
    //# that are not included in the
    //# [required encryption context keys](../framework/structures.md#required-encryption-context-keys) list.
    var storedEC := map k <- mat.encryptionContext | k !in mat.requiredEncryptionContextKeys :: k := mat.encryptionContext[k];
    // It is difficult for dafny to prove ValidEncryptionContext here, so perform a runtime check instead
    :- Need(ValidEncryptionContext(storedEC), E("Invalid Encryption Context"));
    Success(PartialHeader(
              version := VersionFromSchema(schema),
              flavor := mat.algorithmSuite.binaryId[1],
              msgID := msgID,
              legend := legend,
              encContext := storedEC,
              dataKeys := mat.encryptedDataKeys
            ))
  }

  // bytes to PartialHeader, i.e. does not look at commitment -- Deserialize does that
  function method {:opaque} PartialDeserialize(data : Bytes)
    : (ret : Result<PartialHeader, Error>)
    ensures ret.Success? ==>
              && PREFIX_LEN <= |data|
              && var v := ret.value;
              && v.version == data[0]
              && ValidVersion(v.version)
              && v.flavor == data[1]
              && ValidFlavor(v.flavor)
              && v.msgID == data[VERSION_LEN+FLAVOR_LEN..PREFIX_LEN]
              && var legendData := data[PREFIX_LEN..];
              && GetLegend(legendData).Success?
              && var legendAndLen := GetLegend(legendData).value;
              && v.legend == legendAndLen.0
              && var contextData := legendData[legendAndLen.1..];
              && GetContext(contextData).Success?
              && var contextAndLen := GetContext(contextData).value;
              && v.encContext == contextAndLen.0
  {
    :- Need(PREFIX_LEN <= |data|, E("Serialized PartialHeader too short."));
    var version := data[0];
    :- Need(ValidVersion(version), E("Invalid Version Number"));
    var flavor := data[1];
    :- Need(ValidFlavor(flavor), E("Invalid Flavor"));
    var msgID := data[2..PREFIX_LEN];
    var legendData := data[PREFIX_LEN..];

    var legendAndLen :- GetLegend(legendData);
    var legend := legendAndLen.0;
    var contextData := legendData[legendAndLen.1..];

    var contextAndLen :- GetContext(contextData);
    var encContext := contextAndLen.0;
    var keysData := contextData[contextAndLen.1..];

    var keysAndLen :- GetDataKeys(keysData);
    var dataKeys := keysAndLen.0;
    var trailingData := keysData[keysAndLen.1..];

    :- Need(|trailingData| >= COMMITMENT_LEN, E("Invalid header serialization: unexpected end of data."));
    :- Need(|trailingData| <= COMMITMENT_LEN, E("Invalid header serialization: unexpected bytes."));
    assert |trailingData| == COMMITMENT_LEN;
    Success(PartialHeader(
              version := version,
              flavor := flavor,
              msgID := msgID,
              legend := legend,
              encContext := encContext,
              dataKeys := dataKeys
            ))
  }

  // calculate Hmac384 for header commitment
  function method CalculateHeaderCommitment(
    client: Prim.IAwsCryptographicPrimitivesClient,
    alg : CMP.AlgorithmSuiteInfo,
    commitKey : Bytes,
    data: Bytes
  ) : (ret : Result<Bytes, Error>)
    requires ValidSuite(alg)
    ensures ret.Success? ==>
              && |ret.value| == COMMITMENT_LEN
                 //= specification/structured-encryption/header.md#commitment-calculation
                 //= type=implication
                 //# The Header Commitment MUST be calculated as a the first 32 bytes of an HmacSha384,
                 //# with the serialized partial header as the message, and the Commit Key as the key.
              && var input := Prim.HMacInput(
                                digestAlgorithm := alg.commitment.HKDF.hmac,
                                key := commitKey,
                                message := data
                              );
              && client.HMac(input).Success?
              && |client.HMac(input).value| >= 32
              && ret.value == client.HMac(input).value[0..32]
    requires client.ValidState()
    ensures client.ValidState()
  {
    var input := Prim.HMacInput (
                   digestAlgorithm := alg.commitment.HKDF.hmac,
                   key := commitKey,
                   message := data
                 );
    var outputR := client.HMac(input);
    var output :- outputR.MapFailure(e => AwsCryptographyPrimitives(e));
    if |output| < COMMITMENT_LEN then
      Failure(E("HMAC did not produce enough bits"))
    else
      Success(output[..COMMITMENT_LEN])
  }

  function method ToUInt16(x : nat)
    : (ret : Result<uint16, Error>)
    ensures x < UINT16_LIMIT ==> ret.Success?
  {
    :- Need(x < UINT16_LIMIT, E("Value too big for 16 bits"));
    Success(x as uint16)
  }

  function method MyMap<X, Y, Z>(f: X -> Y, m: map<X, Z>): map<Y, Z>
    requires forall a, b | a in m && b in m :: a != b ==> f(a) != f(b)
  {
    map k | k in m :: f(k) := m[k]
  }

  // Create a Legend from the Schema
  function method MakeLegend(schema : CanonCryptoList)
    : (ret : Result<Legend, Error>)
    ensures ret.Success? ==>
              //= specification/structured-encryption/header.md#encrypt-legend-bytes
              //= type=implication
              //# The length of this serialized value (in bytes) MUST equal the number of authenticated fields indicated
              //# by the caller's [Authenticate Schema](./structures.md#authenticate-schema).
              && |ret.value| == CountAuthAttrs(schema) as nat
  {
    var legend :- MakeLegend2(schema);
    var authCount := CountAuthAttrs(schema);
    SequenceIsSafeBecauseItIsInMemory(legend);
    :- Need(authCount == |legend| as uint64, E("Internal Error : bad legend calculation."));
    Success(legend)
  }

  // because if the parameter below is
  // serialized : Legend := []
  // then Dafny take 14 million units to verify it.
  const EmptyLegend : Legend := []

  // Create a Legend for the given attrs of the Schema
  function method {:tailrecursion} MakeLegend2(
    data : CanonCryptoList,
    pos : uint64 := 0,
    serialized : Legend := EmptyLegend
  )
    : (ret : Result<Legend, Error>)
    requires 0 <= pos as nat <= |data|
    decreases |data| - pos as nat
  {
    SequenceIsSafeBecauseItIsInMemory(data);
    if |data| as uint64 == pos then
      Success(serialized)
    else if IsAuthAttr(data[pos].action) then
      :- Need((|serialized| + 1) < UINT16_LIMIT, E("Legend Too Long."));
      var legendChar := GetActionLegend(data[pos].action);
      MakeLegend2(data, pos+1, serialized + [legendChar])
    else
      MakeLegend2(data, pos+1, serialized)
  }

  // CryptoAction to bytes. One byte for signed, zero bytes for unsigned
  function method GetActionLegend(x : CryptoAction)
    : (ret : uint8)
    requires IsAuthAttr(x)
    //= specification/structured-encryption/header.md#encrypt-legend-bytes
    //= type=implication
    //# Each Crypto Action MUST be encoded as follows
    // - `0x65` (`e` in UTF-8, for "Encrypt and Sign") means that a particular field was encrypted
    //   and included in the signature calculation.
    //   This indicates that this field will be attempted to be decrypted during decryption.
    // - `0x73` (`s` in UTF-8, for "Sign Only") means that a particular field was not encrypted,
    //   but still included in the signature calculation.
    //   This indicates that this field will not be attempted to be decrypted during decryption.
    // - `0x63` (`c` in UTF-8, for "Context") means that a particular field was not encrypted,
    //   but still included in the signature calculation,
    //   as well as being included in the encryption context.
    //   This indicates that this field MUST NOT be attempted to be decrypted during decryption.    // - no entry if the attribute is not signed
    ensures match (x) {
              case ENCRYPT_AND_SIGN() => ret == ENCRYPT_AND_SIGN_LEGEND
              case SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT() => ret == SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT_LEGEND
              case SIGN_ONLY() => ret == SIGN_ONLY_LEGEND
            }
  {
    match (x) {
      case ENCRYPT_AND_SIGN() => ENCRYPT_AND_SIGN_LEGEND
      case SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT() => SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT_LEGEND
      case SIGN_ONLY() => SIGN_ONLY_LEGEND
    }
  }

  // How many elements of Schema are included in the signature?
  function method CountAuthAttrs(data : CanonCryptoList, pos : uint64 := 0, acc : uint64 := 0)
    : uint64
    requires 0 <= pos as nat <= |data|
    decreases |data| - pos as nat
  {
    SequenceIsSafeBecauseItIsInMemory(data);
    if |data| as uint64 == pos then
      acc
    else if IsAuthAttr(data[pos].action) then
      CountAuthAttrs(data, pos+1, Add(acc, 1))
    else
      CountAuthAttrs(data, pos+1, acc)
  }

  // Legend to Bytes
  function method {:opaque} SerializeLegend(x : Legend)
    : (ret : Bytes)
    //= specification/structured-encryption/header.md#encrypt-legend
    //= type=implication
    //# The Encrypt Legend MUST be serialized as
    // | Field | Length (bytes) | Interpreted as |
    // | ----- | -------------- | -------------- |
    // | Encrypt Legend Length | 2 | big endian UInt16 |
    // | Encrypt Legend Bytes | Variable. Equal to the value specified in the previous 2 bytes | Bytes |
    ensures
      && |ret| == 2 + |x|
      && SeqToUInt16(ret[0..2]) == |x| as uint16
      && ret[2..] == x
  {
    UInt16ToSeq(|x| as uint16) + x
  }

  // Bytes to Legend
  function method GetLegend(data : Bytes)
    : (ret : Result<(Legend, uint64), Error>)
    ensures ret.Success? ==>
              && ret.value.1 as nat <= |data|
              && ret.value.1 as nat == |ret.value.0| + 2
              && ret.value.0 == data[2..ret.value.1]
  {
    SequenceIsSafeBecauseItIsInMemory(data);
    var data_size : uint64 := |data| as uint64;
    :- Need(2 <= data_size, E("Unexpected end of header data."));
    var len := SeqPosToUInt16(data, 0) as uint64;
    var size := Add(len, 2);
    :- Need(size <= data_size, E("Unexpected end of header data."));
    var legend := data[2..size];
    :- Need(forall x <- legend :: ValidLegendByte(x), E("Invalid byte in stored legend"));
    Success((legend, size))
  }

  // Bytes to Encryption Context
  function method GetContext(data : Bytes)
    : (ret : Result<(CMPEncryptionContext, uint64), Error>)
    ensures ret.Success? ==>
              && ret.value.1 as nat <= |data|
    ensures (
              && HasUint64Len(data)
              && 2 <= |data|
              && GetContext2(SeqPosToUInt16(data, 0) as uint64, data, (map[], 2)).Success?
            ) ==> ret.Success?
  {
    SequenceIsSafeBecauseItIsInMemory(data);
    var data_size : uint64 := |data| as uint64;
    :- Need(2 <= data_size, E("Unexpected end of header data."));
    var count := SeqPosToUInt16(data, 0) as uint64;
    var context :- GetContext2(count, data, (map[], 2));
    Success(context)
  }

  // Bytes to one Key Value pair
  function method GetOneKVPair(data : Bytes, pos : uint64)
    : (ret : Result<(CMPUtf8Bytes, CMPUtf8Bytes, uint64), Error>)
    ensures ret.Success? ==>
              && HasUint64Len(data)
              && Add(ret.value.2, pos) <= |data| as uint64
    ensures (
              && HasUint64Len(data)
              && var data_size : uint64 := |data| as uint64;
              && Add(2, pos) <= data_size
              && var keyLen := SeqPosToUInt16(data, pos) as uint64;
              && Add3(keyLen, 4, pos) <= data_size
              && var key := data[2+pos..Add3(keyLen, 2, pos)];
              && UTF8.ValidUTF8Seq(key)
              && var valueLen := SeqPosToUInt16(data, keyLen+2+pos) as uint64;
              && var kvLen := 2 + keyLen + 2 + valueLen;
              && Add(kvLen, pos) <= data_size
              && var value := data[keyLen+4+pos..kvLen+pos];
              && UTF8.ValidUTF8Seq(value)
            ) <==> ret.Success? && SerializeOneKVPair(ret.value.0, ret.value.1) == data[pos..pos+ret.value.2]
  {
    SequenceIsSafeBecauseItIsInMemory(data);
    var data_size : uint64 := |data| as uint64;
    :- Need(Add(2, pos) <= data_size, E("Unexpected end of header data."));
    var keyLen := SeqPosToUInt16(data, pos) as uint64;
    :- Need(Add3(keyLen, 4, pos) <= data_size, E("Unexpected end of header data."));
    var key := data[2+pos..Add3(keyLen, 2, pos)];
    :- Need(UTF8.ValidUTF8Seq(key), E("Invalid UTF8 found in header."));
    var valueLen := SeqPosToUInt16(data, Add3(keyLen, 2, pos)) as uint64;
    var kvLen := 2 + keyLen + 2 + valueLen;
    :- Need(Add(kvLen, pos) <= data_size as uint64, E("Unexpected end of header data."));
    var value := data[keyLen+4+pos..kvLen+pos];
    :- Need(UTF8.ValidUTF8Seq(value), E("Invalid UTF8 found in header."));
    Success((key, value, kvLen))
  }

  predicate method {:tailrecursion} BytesLess(a: Bytes, b : Bytes, pos : uint64 := 0)
    requires 0 <= pos as nat <= |a|
    requires 0 <= pos as nat <= |b|
    decreases |a| - pos as nat
  {
    SequenceIsSafeBecauseItIsInMemory(a);
    SequenceIsSafeBecauseItIsInMemory(b);
    if a == b then
      false
    else if |a| as uint64 == pos then
      true
    else if |b| as uint64 == pos then
      false
    else if a[pos] != b[pos] then
      a[pos] < b[pos]
    else
      BytesLess(a, b, pos+1)
  }

  // For "count" items, Deserialize key value pairs into an Encryption Context
  function method {:tailrecursion} GetContext2(
    count : uint64,
    data : Bytes,
    deserialized : (CMPEncryptionContext, uint64),
    prevKey : CMPUtf8Bytes := [])
    : (ret : Result<(CMPEncryptionContext, uint64), Error>)
    requires deserialized.1 as nat <= |data|
    ensures ret.Success? ==>
              && ret.value.1 as nat <= |data|
              && (count > 0 ==> GetOneKVPair(data, deserialized.1 as uint64).Success?)
  {
    if count == 0 then
      Success(deserialized)
    else
      :- Need(|deserialized.0| + 1  < UINT16_LIMIT, E("Too much context"));
      var kv :- GetOneKVPair(data, deserialized.1 as uint64);
      //= specification/structured-encryption/header.md#key-value-pair-entries
      //# This sequence MUST NOT contain duplicate entries.
      // if the previous key is always less than the current key, there can be no duplicates

      //= specification/structured-encryption/header.md#key-value-pair-entries
      //# These entries MUST have entries sorted, by key,
      //# in ascending order according to the UTF-8 encoded binary value.
      :- Need(BytesLess(prevKey, kv.0), E("Context keys out of order."));
      GetContext2(count-1, data, (deserialized.0[kv.0 := kv.1], Add(deserialized.1, kv.2)), kv.0)
  }

  // Encryption Context to Bytes
  function method {:opaque} SerializeContext(x : CMPEncryptionContext)
    : (ret : Bytes)
    ensures
      && |ret| >= 2
      && var keys := SortedSets.ComputeSetToOrderedSequence2(x.Keys, ByteLess);
      //= specification/structured-encryption/header.md#encryption-context
      //= type=implication
      //# The Encryption Context MUST be serialized as follows
      // | Field | Length (bytes) | Interpreted as |
      // | ----- | -------------- | -------------- |
      // | Key Value Pair Count | 2 | big endian UInt16 |
      // | Key Value Pair Entries | Variable. Determined by the count and length of each key-value pair. | Key Value Pair Entries |
      && ret == UInt16ToSeq(|x| as uint16) + SerializeContext2(keys, x)
  {
    //= specification/structured-encryption/header.md#key-value-pair-entries
    //# These entries MUST have entries sorted, by key,
    //# in ascending order according to the UTF-8 encoded binary value.
    var keys := SortedSets.ComputeSetToOrderedSequence2(x.Keys, ByteLess);
    UInt16ToSeq(|x| as uint16) + SerializeContext2(keys, x)
  }

  // Key Value Pair to Bytes
  function method SerializeOneKVPair(key : CMPUtf8Bytes, value : CMPUtf8Bytes)
    : (ret : Bytes)
    //= specification/structured-encryption/header.md#key-value-pair-entries
    //= type=implication
    //# Each Key Value Pair MUST be serialized as follows
    // | Field | Length (bytes) | Interpreted as |
    // | ----- | -------------- | -------------- |
    // | Key Length | 2 | big endian UInt16 |
    // | Key | Variable. Equal to the value specified in the previous 2 bytes (Key Length). | UTF-8 encoded bytes |
    // | Value Length | 2 | big endian UInt16 |
    // | Value | Variable. Equal to the value specified in the previous 2 bytes (Value Length). | UTF-8 encoded bytes |
    ensures ret == UInt16ToSeq(|key| as uint16) + key + UInt16ToSeq(|value| as uint16) + value
  {
    UInt16ToSeq(|key| as uint16) + key + UInt16ToSeq(|value| as uint16) + value
  }

  // Data Key to Bytes
  function method SerializeOneDataKey(k : CMPEncryptedDataKey)
    : (ret : Bytes)
    //= specification/structured-encryption/header.md#encrypted-data-key-entries
    //= type=implication
    //# Each Encrypted Data Key MUST be serialized as follows
    // | Field | Length (bytes) | Interpreted as |
    // | ----- | -------------- | -------------- |
    // | Key Provider ID Length  | 2 | big endian UInt16 |
    // | Key Provider ID | Variable. Equal to the value specified in the previous 2 bytes (Key Provider ID Length). | UTF-8 encoded bytes |
    // | Key Provider Information Length | 2 | big endian UInt16 |
    // | Key Provider Information | Variable. Equal to the value specified in the previous 2 bytes (Key Provider Information Length). | Bytes |
    // | Encrypted Data Key Length | 2 | big endian UInt16 |
    // | Encrypted Data Key | Variable. Equal to the value specified in the previous 2 bytes (Encrypted Data Key Length). | Bytes |
    ensures
      && var provIdSize := ToUInt16(|k.keyProviderId|).value;
      && var provInfoSize := ToUInt16(|k.keyProviderInfo|).value;
      && var cipherSize := ToUInt16(|k.ciphertext|).value;
      && ret == (
                  UInt16ToSeq(provIdSize)
                  + k.keyProviderId
                  + UInt16ToSeq(provInfoSize)
                  + k.keyProviderInfo
                  + UInt16ToSeq(cipherSize)
                  + k.ciphertext
                )
  {
    UInt16ToSeq(|k.keyProviderId| as uint16)
    + k.keyProviderId
    + UInt16ToSeq(|k.keyProviderInfo| as uint16)
    + k.keyProviderInfo
    + UInt16ToSeq(|k.ciphertext| as uint16)
    + k.ciphertext
  }

  // Bytes to Data Key
  function method {:vcs_split_on_every_assert} GetOneDataKey(data : Bytes, pos : uint64)
    : (ret : Result<(CMPEncryptedDataKey, uint64), Error>)
    ensures ret.Success? ==>
              && HasUint64Len(data)
              && var data_size : uint64 := |data| as uint64;
              && Add(ret.value.1, pos) <= |data| as uint64
              && |SerializeOneDataKey(ret.value.0)| == ret.value.1 as nat
              && SerializeOneDataKey(ret.value.0) == data[pos..Add(pos, ret.value.1 as uint64)]
  {
    SequenceIsSafeBecauseItIsInMemory(data);
    var data_size : uint64 := |data| as uint64;

    :- Need(Add(2, pos) < data_size, E("Unexpected end of header data."));
    var provIdSize := SeqPosToUInt16(data, pos) as uint64;
    :- Need(Add3(provIdSize, 2, pos) < data_size, E("Unexpected end of header data."));
    var provId := data[pos+2..pos+2+provIdSize];
    :- Need(UTF8.ValidUTF8Seq(provId), E("Invalid UTF8 found in header."));
    var part1Size := 2 + provIdSize;

    :- Need(Add3(part1Size, 2, pos) <= data_size, E("Unexpected end of header data."));
    var provInfoSize := SeqPosToUInt16(data, pos+part1Size) as uint64;
    var part2Size := part1Size + 2 + provInfoSize;
    :- Need(Add(part2Size, pos) < data_size, E("Unexpected end of header data."));
    var provInfo := data[pos+part1Size+2..pos+part1Size+2+provInfoSize];

    :- Need(Add3(part2Size, 2, pos) <= data_size, E("Unexpected end of header data."));
    var cipherSize := SeqPosToUInt16(data, pos+part2Size) as uint64;
    var part3Size := part2Size + 2 + cipherSize;
    :- Need(Add(part3Size, pos) <= data_size, E("Unexpected end of header data."));
    var cipher := data[pos+part2Size+2..pos+part2Size+2+cipherSize];

    var edk : CMPEncryptedDataKey := CMP.EncryptedDataKey(keyProviderId := provId, keyProviderInfo := provInfo, ciphertext := cipher);
    Success((edk, part3Size))
  }

  // for items in "keys", turn Key Value Pairs into Bytes
  function method {:tailrecursion} SerializeContext2(
    keys : seq<CMPUtf8Bytes>,
    x : CMPEncryptionContext,
    pos : uint64 := 0,
    acc : Bytes := []
  )
    : (ret : Bytes)
    requires forall k <- keys :: k in x
    requires 0 <= pos as nat <= |keys|
    decreases |keys| - pos as nat
  {
    SequenceIsSafeBecauseItIsInMemory(keys);
    if |keys| as uint64 == pos then
      acc
    else
      SerializeContext2(keys, x, pos+1, acc + SerializeOneKVPair(keys[pos], x[keys[pos]]))
  }

  // Data Key List to Bytes
  function method SerializeDataKeys(x : CMPEncryptedDataKeyList)
    : (ret : Bytes)
    //= specification/structured-encryption/header.md#encrypted-data-keys
    //= type=implication
    //# The Encrypted Data Keys MUST be serialized as follows
    // | Field | Length (bytes) | Interpreted as |
    // | ----- | -------------- | -------------- |
    // | Encrypted Data Key Count | 1 | big endian UInt16 |
    // | [Encrypted Data Key Entries | Variable. Determined by the count and length of each key-value pair. | Encrypted Data Key Entries |
    ensures
      && 1 <= |ret|
      && ret[0] as nat == |x|
      && ret == [|x| as uint8] + SerializeDataKeys2(x)
  {
    var body := SerializeDataKeys2(x);
    [|x| as uint8] + body
  }

  // Data Keys to Bytes
  function method {:tailrecursion} SerializeDataKeys2(
    x : CMPEncryptedDataKeyListEmptyOK,
    pos : uint64 := 0,
    acc : Bytes := []
  )
    : (ret : Bytes)
    requires 0 <= pos as nat <= |x|
    decreases |x| - pos as nat
  {
    SequenceIsSafeBecauseItIsInMemory(x);
    if |x| as uint64 == pos then
      acc
    else
      SerializeDataKeys2(x, pos+1, acc + SerializeOneDataKey(x[pos]))
  }

  // Bytes to Data Key List
  function method GetDataKeys(data : Bytes)
    : (ret : Result<(CMPEncryptedDataKeyList, uint64), Error>)
    ensures ret.Success? ==>
              && ret.value.1 as nat <= |data|
              && 1 <= |data|
              && 1 <= ret.value.1
              && |ret.value.0| == data[0] as nat
              && GetDataKeys2(|ret.value.0| as uint64, |ret.value.0| as uint64, data, ([], 1)).Success?
  {
    :- Need(1 <= |data|, E("Unexpected end of header data."));
    var count := data[0] as uint64;
    var keys :- GetDataKeys2(count, count, data, ([], 1));
    if |keys.0| == 0 then
      Failure(E("At least one Data Key required"))
    else
      Success(keys)
  }

  // Convert "count" items from Bytes to Data Keys
  function method {:tailrecursion} GetDataKeys2(
    count : uint64,
    origCount : uint64,
    data : Bytes,
    deserialized : (CMPEncryptedDataKeyListEmptyOK, uint64))
    : (ret : Result<(CMPEncryptedDataKeyListEmptyOK, uint64), Error>)
    requires deserialized.1 as nat <= |data|
    requires origCount as nat == count as nat + |deserialized.0|
    ensures ret.Success? ==>
              && ret.value.1 as nat <= |data|
              && ret.value.1 >= deserialized.1
              && (count > 0 ==> GetOneDataKey(data, deserialized.1 as uint64).Success?)
              && |ret.value.0| == origCount as nat
  {
    if count == 0 then
      Success(deserialized)
    else
    if |deserialized.0| >= 255 then
      Failure(E("Too Many Data Keys"))
    else
      var edk :- GetOneDataKey(data, deserialized.1 as uint64);
      assert SerializeOneDataKey(edk.0) == data[deserialized.1..deserialized.1+edk.1];
      GetDataKeys2(count-1, origCount, data, (deserialized.0 + [edk.0], deserialized.1+edk.1))
  }

  // End code, begin proofs

  // mapping with no filter does not change map size
  lemma MapKeepsCount<Y,Z>(m : map<Path,Y>, f : (Path) -> Z)
    requires forall a : Path, b : Path :: a != b ==> f(a) != f(b)
    requires Functions.Injective(f)
    ensures |m.Keys| == |MyMap(f, m).Keys|
    ensures |m| == |MyMap(f, m)|
  {
    Sets.LemmaMapSize(m.Keys, MyMap(f, m).Keys, f);
  }

  // SerializeLegend ==> GetLegend
  lemma SerializeLegendRoundTrip(x : Legend)
    ensures GetLegend(SerializeLegend(x)).Success?
    ensures var ret := GetLegend(SerializeLegend(x)).value;
            && ret.0 == x
            && ret.1 as nat == |x| + 2
            && ret.1 as nat == |SerializeLegend(x)|
  {}

  // GetLegend ==> SerializeLegend
  lemma GetLegendRoundTrip(x : Bytes)
    requires GetLegend(x).Success?
    ensures
      && var ret := SerializeLegend(GetLegend(x).value.0);
      && ret == x[..GetLegend(x).value.1]
  {}

  // SerializeOneKVPair ==> GetOneKVPair
  lemma SerializeOneKVPairRoundTrip(key : CMPUtf8Bytes, value : CMPUtf8Bytes)
    ensures GetOneKVPair(SerializeOneKVPair(key, value), 0).Success?
  {
    var data := SerializeOneKVPair(key, value);
    assert 2 <= |data|;
    var keyLen := SeqToUInt16(data[0..2]) as nat;
    assert keyLen + 4 <= |data|;
    assert data[2..keyLen+2] == key;
    assert UTF8.ValidUTF8Seq(data[2..keyLen+2]);
    var valueLen := SeqToUInt16(data[keyLen+2..keyLen+4]) as nat;
    assert keyLen + valueLen + 4 <= |data|;
    assert data[keyLen+4..keyLen + valueLen + 4] == value;
    assert UTF8.ValidUTF8Seq(data[keyLen+4..keyLen + valueLen + 4]);
  }

  // GetOneKVPair ==> SerializeOneKVPair
  lemma GetOneKVPairRoundTrip(data : Bytes, pos : uint64)
    requires GetOneKVPair(data, pos).Success?
    ensures
      && var cont := GetOneKVPair(data, pos).value;
      && SerializeOneKVPair(cont.0, cont.1) == data[pos..cont.2+pos]
  {}

  // SerializeOneDataKey ==> GetOneDataKey
  lemma SerializeOneDataKeyRoundTrip(k : CMPEncryptedDataKey)
    ensures
      && var data := SerializeOneDataKey(k);
      && GetOneDataKey(data, 0).Success?
      && GetOneDataKey(data, 0).value.0 == k
      && GetOneDataKey(data, 0).value.1 as nat == |data|
  {
    var data := SerializeOneDataKey(k);
    assert 2 <= |data|;
    var provIdSize := SeqToUInt16(data[0..2]) as nat;
    assert provIdSize + 2 < |data|;
    var provId := data[2..2+provIdSize];
    assert provId == k.keyProviderId;

    var part1Size := 2 + provIdSize;
    assert part1Size+2 <= |data|;
    var provInfoSize := SeqToUInt16(data[part1Size..part1Size+2]) as nat;
    assert part1Size + provInfoSize + 2 < |data|;
    var provInfo := data[part1Size+2..part1Size+2+provInfoSize];
    assert provInfo == k.keyProviderInfo;
  }

  // GetOneDataKey ==> SerializeOneDataKey
  lemma GetOneDataKeyRoundTrip(data : Bytes)
    requires GetOneDataKey(data, 0).Success?
    ensures
      && var cont := GetOneDataKey(data, 0).value;
      && SerializeOneDataKey(cont.0) == data[..cont.1]
  {}

  // When deserializing a Key Value Pair with GetOneKVPair
  // the unexamined bytes do not change the result
  lemma GetOneKVPairExt(x : Bytes, y : Bytes)
    requires x <= y
    requires GetOneKVPair(x, 0).Success?
    ensures
      && GetOneKVPair(y, 0).Success?
      && GetOneKVPair(x, 0).value == GetOneKVPair(y, 0).value
  {
    assert 2 <= |y|;
    var keyLen := SeqToUInt16(y[0..2]) as nat;
    assert(keyLen + 4 <= |y|);
    var key := y[2..keyLen+2];
    assert x[2..keyLen+2] == y[2..keyLen+2];
    assert(UTF8.ValidUTF8Seq(key));
    var valueLen := SeqToUInt16(y[keyLen+2..keyLen+4]) as nat;
    var kvLen := 2 + keyLen + 2 + valueLen;
    assert kvLen <= |y|;
    var value := y[keyLen+4..kvLen];
    assert keyLen+4 <= kvLen;
    assert x[keyLen+4..kvLen] == y[keyLen+4..kvLen];
    assert UTF8.ValidUTF8Seq(value);
  }
}
