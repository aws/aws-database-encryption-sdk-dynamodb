// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "../Model/AwsCryptographyStructuredEncryptionTypes.dfy"
include "Paths.dfy"

module Header {
  import opened Wrappers
  import opened StandardLibrary
  import opened StandardLibrary.UInt
  import opened AwsCryptographyStructuredEncryptionTypes
  import CMP = AwsCryptographyMaterialProvidersTypes
  import Prim = AwsCryptographyPrimitivesTypes
  import opened Sets
  import opened UTF8
  import opened Paths
  import Random

  const VERSION_LEN := 1
  const FLAVOR_LEN := 1
  const MSGID_LEN := 32
  const COMMITMENT_LEN := 32
  const PREFIX_LEN := VERSION_LEN + FLAVOR_LEN + MSGID_LEN
  const TRUSS_COMMIT_KEY := "TRUSS_COMMIT_KEY";
  const UINT8_LIMIT := 256
  const ENCRYPT_AND_SIGN_LEGEND : uint8 := 0x65;
  const SIGN_ONLY_LEGEND : uint8 := 0x73;

  //= specification/structured-encryption/header.md#format-version
  //= type=implication
  //# The Version MUST be `0x01`.
  type Version = x : uint8 | ValidVersion(x) witness 1

  //= specification/structured-encryption/header.md#format-flavor
  //= type=implication
  //# The flavor MUST be one of these two values.
  // | Value | Meaning |
  // |---|---|
  // | 0x01 | Signatures enabled (default) |
  // | 0x00 | Signatures disabled |
  type Flavor = x : uint8 | ValidFlavor(x)

  //= specification/structured-encryption/header.md#encrypted-data-key-count
  //= type=implication
  //# This value MUST be greater than 0.
  type CMPEncryptedDataKeyList = x : seq<CMPEncryptedDataKey> | 0 < |x| < UINT8_LIMIT witness *

  type MessageID = x: Bytes | |x| == MSGID_LEN witness *
  type Commitment = x: Bytes | |x| == COMMITMENT_LEN witness *
  type CMPEncryptedDataKey = x : CMP.EncryptedDataKey | ValidEncryptedDataKey(x) witness *
  type CMPEncryptionContext  = x : CMP.EncryptionContext | ValidEncryptionContext(x) witness *
  type CMPEncryptedDataKeyListEmptyOK = x : seq<CMPEncryptedDataKey> | |x| < UINT8_LIMIT
  type Legend = x : Bytes | |x| < UINT16_LIMIT
  type CMPUtf8Bytes = x : CMP.Utf8Bytes | |x| < UINT16_LIMIT

  predicate method ValidVersion(x : uint8) {
    x == 1
  }

  predicate method ValidFlavor(x : uint8) {
    x in [0, 1]
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
        //= specification/structured-encryption/header.md#header-format
        //= type=implication
        //# The serialized form of the Header MUST be
        // | Length (bytes) | Meaning |
        // |---|---|
        // | 1 | Format Version |
        // | 1 | Format Flavor |
        // | 32 | Message ID|
        // | Variable | Encrypt Legend |
        // | Variable | Encrypt Context|
        // | Variable | Encrypted Data Keys |
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
  }

  // serialize and add commitment
  function method Serialize(client: Prim.IAwsCryptographicPrimitivesClient, PartialHeader : PartialHeader)
    : (ret : Result<Bytes, Error>)
    requires client.ValidState()
    ensures client.ValidState()

    //= specification/structured-encryption/header.md#header-commitment
    //= type=implication
    //# The Header Commitment MUST be calculated as a 256-bit HmacSha384,
    //# with all preceding Header bytes as the message
    //# and a commitment key of "TRUSS_COMMIT_KEY"
    ensures ret.Success? ==>
      && PREFIX_LEN <= |ret.value|
      && CalculateHeaderCommitment(client, ret.value[..|ret.value|-32]).Success?
      && ret.value[|ret.value|-32..] == CalculateHeaderCommitment(client, ret.value[..|ret.value|-32]).value
  {
    var body := PartialHeader.serialize();
    var commitment :- CalculateHeaderCommitment(client, body);
    Success(body + commitment)
  }

  // deserialize, and check commitment
  function method Deserialize(client: Prim.IAwsCryptographicPrimitivesClient, data : Bytes)
    : (ret : Result<PartialHeader, Error>)
    requires client.ValidState()
    ensures client.ValidState()
    //= specification/structured-encryption/header.md#header-commitment
    //= type=implication
    //# When reading or deserializing a Header, the implementation MUST recalculate the commitment,
    //# and fail if the calculated commitment does not match the stored commitment.
    ensures ret.Success? ==>
      && 32 < |data|
      && var storedCommitment := data[|data|-32..];
      && CalculateHeaderCommitment(client, data[..|data|-32]).Success?
      && var calcCommitment := CalculateHeaderCommitment(client, data[..|data|-32]).value;
      && storedCommitment == calcCommitment
  {
    :- Need(32 < |data|, E("PartialHeader too short"));
    var head :- PartialDeserialize(data[..|data|-32]);
    var storedCommitment := data[|data|-32..];
    var calcCommitment :- CalculateHeaderCommitment(client, data[..|data|-32]);
    :- Need(storedCommitment == calcCommitment, E("Key commitment mismatch."));
    Success(head)
  }

  // config to PartialHeader
  function method Create(
      tableName : string,
      schema : CryptoSchema,
      msgID : MessageID,
      encContext : CMP.EncryptionContext,
      dataKeys : CMP.EncryptedDataKeyList
    )
    : (ret : Result<PartialHeader, Error>)
  {
    :- Need(ValidString(tableName), E("Invalid table name."));
    :- Need(ValidEncryptionContext(encContext), E("Invalid Encryption Context"));
    :- Need(0 < |dataKeys|, E("There must be at least one data key"));
    :- Need(|dataKeys| < UINT8_LIMIT, E("Too many data keys."));
    :- Need(forall x | x in dataKeys :: ValidEncryptedDataKey(x), E("Invalid Data Key"));
    :- Need(schema.content.SchemaMap?, E("Schema must be a Map"));
    :- Need(CryptoSchemaMapIsFlat(schema.content.SchemaMap), E("Schema must be flat."));
    var legend :- MakeLegend(tableName, schema);
    Success(PartialHeader(
      version := 1,
      flavor := 1, // or zero if algorithm suite is TODO?
      msgID := msgID,
      legend := legend,
      encContext := encContext,
      dataKeys := dataKeys
    ))
  }
  
  // bytes to PartialHeader, i.e. does not look at commitment -- Deserialize does that
  function method PartialDeserialize(data : Bytes)
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

    :- Need(|trailingData| == 0, E("Invalid header serialization: unexpected bytes."));
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
    data: Bytes
  ) : (ret : Result<Bytes, Error>)
    requires client.ValidState()
    ensures client.ValidState()
    ensures ret.Success? ==> |ret.value| == 32
  {
    // TODO - Get hashing algorithm from algorithm suite
    var input := Prim.HMacInput (
      digestAlgorithm := Prim.SHA_384,
      key := EncodeAscii(TRUSS_COMMIT_KEY),
      message := data
    );
    var outputR := client.HMac(input);
    var output :- outputR.MapFailure(e => AwsCryptographyPrimitives(e));
    if |output| != 48 then
      Failure(E("SHA_384 did not produce 384 bits"))
    else
      Success(output[..32])
  }

  predicate method ByteLess(x : uint8, y : uint8)
  {
    x < y
  }

  predicate method CharLess(x : char, y : char)
  {
    x < y
  }

  function method ToUInt16(x : nat)
    : (ret : Result<uint16, Error>)
    ensures x < UINT16_LIMIT ==> ret.Success?
  {
    :- Need(x < UINT16_LIMIT, E("Value too big for 16 bits"));
    Success(x as uint16)
  }

  // string to Error
  function method E(s : string) : Error {
    StructuredEncryptionException(message := s)
  }

  // Create a Legend from the Schema
  function method MakeLegend(tableName : GoodString, schema : CryptoSchema)
    : (ret : Result<Legend, Error>)
    requires schema.content.SchemaMap?
    requires CryptoSchemaMapIsFlat(schema.content.SchemaMap)
    ensures ret.Success? ==>
      //= specification/structured-encryption/header.md#encrypt-legend-bytes
      //= type=implication
      //# The length of this serialized value (in bytes) MUST equal the number of authenticated fields indicated
      //# by the caller's [Authenticate Schema](./structures.md#authenticate-schema).
      && |ret.value| == CountAuthAttrs(schema.content.SchemaMap)
  {
    //= specification/structured-encryption/header.md#encrypt-legend-bytes
    //# The Encrypt Legend Bytes MUST be serialized as follows:
    // 1. Order every authenticated attribute in the item lexicographically by the attribute name.
    // 2. For each authenticated terminal, in order,
    // append one of the byte values specified above to indicate whether
    // that field should be encrypted.
    :- Need(forall x <- schema.content.SchemaMap.Keys :: Paths.ValidString(x), E("bad attribute name"));
    Paths.SimpleCanonUnique(tableName);
    var canonSchema := map kv <- schema.content.SchemaMap.Items | true :: Paths.SimpleCanon(tableName, kv.0) := kv.1;
    var attrs := ComputeSetToOrderedSequence2(canonSchema.Keys, ByteLess);
    var legend :- MakeLegend2(attrs, canonSchema);
    :- Need(|legend| == CountAuthAttrs(schema.content.SchemaMap), E("Internal Error."));
    Success(legend)
  }

  // Create a Legend for the given attrs of the Schema
  function method {:tailrecursion} MakeLegend2(
      attrs : seq<Bytes>,
      data : map<Bytes, CryptoSchema>,
      serialized : Legend := []
    )
    : (ret : Result<Legend, Error>)
    requires forall k <- attrs :: k in data
  {
    if |attrs| == 0 then
      Success(serialized)
    else
      if (|serialized| + 1) >= UINT16_LIMIT then
        Failure(E("Legend Too Long."))
      else
        :- Need(data[attrs[0]].content.Action?, E("Scema must be flat"));
        var legendChar := GetActionLegend(data[attrs[0]].content.Action);
        MakeLegend2(attrs[1..], data, serialized + legendChar)
  }

  // CryptoAction to bytes. One byte for signed, zero bytes for unsigned
  function method GetActionLegend(x : CryptoAction)
    : (ret : Bytes)
    //= specification/structured-encryption/header.md#encrypt-legend-bytes
    //= type=implication
    //# Each Crypto Action MUST be encoded as follows
    // - `0x65` (`e` in UTF-8, for "Encrypt and Sign") means that a particular field was encrypted
    //   and included in the signature calculation.
    //   This indicates that this field will be attempted to be decrypted during decryption.
    // - `0x73` (`s` in UTF-8, for "Sign Only") means that a particular field was not encrypted,
    //   but still included in the signature calculation.
    //   This indicates that this field will not be attempted to be decrypted during decryption.
    // - no entry if the attribute is not signed
    ensures match (x) {
      case ENCRYPT_AND_SIGN => ret == [ENCRYPT_AND_SIGN_LEGEND]
      case SIGN_ONLY => ret == [SIGN_ONLY_LEGEND]
      case DO_NOTHING => ret == []
    }
  {
    match (x) {
      case ENCRYPT_AND_SIGN => [ENCRYPT_AND_SIGN_LEGEND]
      case SIGN_ONLY => [SIGN_ONLY_LEGEND]
      case DO_NOTHING => []
    }
  }

  // attibute is "authorized", a.k.a. included in the signature
  function method IsAuthAttr(x : CryptoAction) : nat
  {
    if IsAuthAttr2(x) then
      1
    else
      0
  }

  // attibute is "authorized", a.k.a. included in the signature
  predicate method IsAuthAttr2(x : CryptoAction)
  {
    x.ENCRYPT_AND_SIGN? || x.SIGN_ONLY?
  }

  // Is the CryptoSchemaMap flat, i.e., does it contain only Actions?
  function method CryptoSchemaMapIsFlat(data : CryptoSchemaMap) : (ret : bool)
    ensures ret ==> (forall v <- data.Values :: v.content.Action?)
  {
    forall v <- data.Values :: v.content.Action? 
  }

  // How many elements of Schema are included in the signature?
  function method CountAuthAttrs(data : CryptoSchemaMap)
    : nat
    requires forall x <- data.Values :: x.content.Action?
  {
    |map k <- data.Keys | IsAuthAttr2(data[k].content.Action) :: k := data[k]|
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
    : (ret : Result<(Legend, nat), Error>)
    ensures ret.Success? ==>
      && ret.value.1 <= |data|
      && ret.value.1 == |ret.value.0| + 2
      && ret.value.0 == data[2..ret.value.1]
  {
    :- Need(2 <= |data|, E("Unexpected end of header data."));
    var len := SeqToUInt16(data[0..2]);
    var size := len as nat + 2;
    :- Need(size <= |data|, E("Unexpected end of header data."));
    Success((data[2..size], size))
  }

  // Bytes to Encryption Context
  function method GetContext(data : Bytes)
    : (ret : Result<(CMPEncryptionContext, nat), Error>)
    ensures ret.Success? ==>
      && ret.value.1 <= |data|
    ensures (
      && 2 <= |data|
      && GetContext2(SeqToUInt16(data[0..2]) as nat, data, data[2..], (map[], 2)).Success?
    ) ==> ret.Success?

  {
    :- Need(2 <= |data|, E("Unexpected end of header data."));
    var count := SeqToUInt16(data[0..2]) as nat;
    var context :- GetContext2(count, data, data[2..], (map[], 2));
    Success(context)
  }

  // Bytes to one Key Value pair
  function method GetOneKVPair(data : Bytes)
    : (ret : Result<(CMPUtf8Bytes, CMPUtf8Bytes, nat), Error>)
    ensures ret.Success? ==>
      && ret.value.2 <= |data|
      && SerializeOneKVPair(ret.value.0, ret.value.1) == data[..ret.value.2]
    ensures (
      && 2 <= |data|
      && var keylen := SeqToUInt16(data[0..2]) as nat;
      && keylen + 4 <= |data|
      && ValidUTF8Seq(data[2..keylen+2])
      && var valueLen := SeqToUInt16(data[keylen+2..keylen+4]) as nat;
      && keylen + valueLen + 4 <= |data|
      && ValidUTF8Seq(data[keylen+4..keylen + valueLen + 4])
    ) <==> ret.Success? && SerializeOneKVPair(ret.value.0, ret.value.1) == data[..ret.value.2]
  {
    :- Need(2 <= |data|, E("Unexpected end of header data."));
    var keylen := SeqToUInt16(data[0..2]) as nat;
    :- Need(keylen + 4 <= |data|, E("Unexpected end of header data."));
    var key := data[2..keylen+2];
    :- Need(ValidUTF8Seq(key), E("Invalid UTF8 found in header."));
    var valuelen := SeqToUInt16(data[keylen+2..keylen+4]) as nat;
    var kvLen := 2 + keylen + 2 + valuelen;
    :- Need(kvLen <= |data|, E("Unexpected end of header data."));
    var value := data[keylen+4..kvLen];
    :- Need(ValidUTF8Seq(value), E("Invalid UTF8 found in header."));
    Success((key, value, kvLen))
  }

  predicate method {:tailrecursion} BytesLess(a: Bytes, b : Bytes) {
    if a == b then
      false
    else if |a| == 0 then
      true
    else if |b| == 0 then
      false
    else if a[0] != b[0] then
      a[0] < b[0]
    else
      BytesLess(a[1..], b[1..])
  }

  // For "count" items, Deserialize key value pairs into an Encryption Context
  function method {:tailrecursion} GetContext2(
    count : nat,
    origData : Bytes,
    data : Bytes,
    deserialized : (CMPEncryptionContext, nat),
    prevKey : CMPUtf8Bytes := [])
    : (ret : Result<(CMPEncryptionContext, nat), Error>)
    requires deserialized.1 <= |origData|
    requires deserialized.1 + |data| == |origData|
    requires data == origData[deserialized.1..]
    ensures ret.Success? ==> 
      && ret.value.1 <= |origData|
      && (count > 0 ==> GetOneKVPair(data).Success?)
  {
    if count == 0 then
      Success(deserialized)
    else
      :- Need(|deserialized.0| + 1  < UINT16_LIMIT, E("Too much context"));
      var kv :- GetOneKVPair(data);
      //= specification/structured-encryption/header.md#key-value-pair-entries
      //# This sequence MUST NOT contain duplicate entries.

      //= specification/structured-encryption/header.md#key-value-pair-entries
      //# These entries MUST have entries sorted, by key,
      //# in ascending order according to the UTF-8 encoded binary value.
      :- Need(BytesLess(prevKey, kv.0), E("Context keys out of order."));
      GetContext2(count-1, origData, data[2+|kv.0|+2+|kv.1|..], (deserialized.0[kv.0 := kv.1], deserialized.1 + kv.2), kv.0)
  }

  // Encryption Context to Bytes
  function method {:opaque} SerializeContext(x : CMPEncryptionContext)
    : (ret : Bytes)
    ensures
      && |ret| >= 2
      && var keys := ComputeSetToOrderedSequence2(x.Keys, ByteLess);
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
    var keys := ComputeSetToOrderedSequence2(x.Keys, ByteLess);
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
  function method GetOneDataKey(data : Bytes)
    : (ret : Result<(CMPEncryptedDataKey, nat), Error>)
    ensures ret.Success? ==>
      && ret.value.1 <= |data|
      && |SerializeOneDataKey(ret.value.0)| == ret.value.1
      && SerializeOneDataKey(ret.value.0) == data[0..ret.value.1]
  {
    :- Need(2 < |data|, E("Unexpected end of header data."));
    var provIdSize := SeqToUInt16(data[0..2]) as nat;
    :- Need(provIdSize + 2 < |data|, E("Unexpected end of header data."));
    var provId := data[2..2+provIdSize];
    :- Need(ValidUTF8Seq(provId), E("Invalid UTF8 found in header."));
    var part1Size := 2 + provIdSize;

    :- Need(part1Size+2 <= |data|, E("Unexpected end of header data."));
    var provInfoSize := SeqToUInt16(data[part1Size..part1Size+2]) as nat;
    :- Need(part1Size + provInfoSize + 2 < |data|, E("Unexpected end of header data."));
    var provInfo := data[part1Size+2..part1Size+2+provInfoSize];
    var part2Size := part1Size + 2 + provInfoSize;

    :- Need(part2Size+2 <= |data|, E("Unexpected end of header data."));
    var cipherSize := SeqToUInt16(data[part2Size..part2Size+2]) as nat;
    :- Need(part2Size + cipherSize + 2 <= |data|, E("Unexpected end of header data."));
    var cipher := data[part2Size+2..part2Size+2+cipherSize];
    var part3Size := part2Size + 2 + cipherSize;

    var edk := CMP.EncryptedDataKey(keyProviderId := provId, keyProviderInfo := provInfo, ciphertext := cipher);
    Success((edk, part3Size))
  }

  // for items in "keys", turn Key Value Pairs into Bytes
  function method {:tailrecursion} SerializeContext2(keys : seq<CMPUtf8Bytes>, x : CMPEncryptionContext)
    : (ret : Bytes)
    requires forall k <- keys :: k in x
  {
    if |keys| == 0 then
      []
    else
      SerializeOneKVPair(keys[0], x[keys[0]]) + SerializeContext2(keys[1..], x)
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
  function method {:tailrecursion} SerializeDataKeys2(x : CMPEncryptedDataKeyListEmptyOK)
    : (ret : Bytes)
  {
    if |x| == 0 then
      []
    else
      SerializeOneDataKey(x[0]) + SerializeDataKeys2(x[1..])
  }

  // Bytes to Data Key List
  function method GetDataKeys(data : Bytes)
    : (ret : Result<(CMPEncryptedDataKeyList, nat), Error>)
    ensures ret.Success? ==>
      && ret.value.1 <= |data|
      && 1 <= |data|
      && 1 <= ret.value.1
      && |ret.value.0| == data[0] as nat
      && GetDataKeys2(|ret.value.0|, |ret.value.0|, data, data[1..], ([], 1)).Success?
  {
    :- Need(1 <= |data|, E("Unexpected end of header data."));
    var count := data[0] as nat;
    var keys :- GetDataKeys2(count, count, data, data[1..], ([], 1));
    if |keys.0| == 0 then
      Failure(E("At least one Data Key required"))
    else
      Success(keys)
  }

  // Convert "count" items from Bytes to Data Keys
  function method {:tailrecursion} GetDataKeys2(
    count : nat,
    origCount : nat,
    origData : Bytes,
    data : Bytes,
    deserialized
    : (CMPEncryptedDataKeyListEmptyOK, nat))
    : (ret : Result<(CMPEncryptedDataKeyListEmptyOK, nat), Error>)
    requires deserialized.1 <= |origData|
    requires deserialized.1 + |data| == |origData|
    requires origCount == count + |deserialized.0|
    ensures ret.Success? ==>
      && ret.value.1 <= |origData|
      && ret.value.1 >= deserialized.1
      && (count > 0 ==> GetOneDataKey(data).Success?)
      && |ret.value.0| == origCount
  {
    if count == 0 then
      Success(deserialized)
    else
      if |deserialized.0| >= 255 then
        Failure(E("Too Many Data Keys"))
      else
        var edk :- GetOneDataKey(data);
        assert SerializeOneDataKey(edk.0) == data[..edk.1];
        GetDataKeys2(count-1, origCount, origData, data[edk.1..], (deserialized.0 + [edk.0], deserialized.1+edk.1)) 
  }

// End code, begin proofs

  // SerializeLegend ==> GetLegend
  lemma SerializeLegendRoundTrip(x : Legend)
    ensures GetLegend(SerializeLegend(x)).Success?
    ensures var ret := GetLegend(SerializeLegend(x)).value;
      && ret.0 == x
      && ret.1 == |x| + 2
      && ret.1 == |SerializeLegend(x)|
  {}

  // GetLegend ==> SerializeLegend
  lemma GetLegendRoundTrip(x : Bytes)
    requires GetLegend(x).Success?
    ensures
      && var ret := SerializeLegend(GetLegend(x).value.0);
      && ret == x[..GetLegend(x).value.1]
  {
  }

  // SerializeOneKVPair ==> GetOneKVPair
  lemma SerializeOneKVPairRoundTrip(key : CMPUtf8Bytes, value : CMPUtf8Bytes)
    ensures GetOneKVPair(SerializeOneKVPair(key, value)).Success?
  {
    var data := SerializeOneKVPair(key, value);
    assert 2 <= |data|;
    var keylen := SeqToUInt16(data[0..2]) as nat;
    assert keylen + 4 <= |data|;
    assert data[2..keylen+2] == key;
    assert ValidUTF8Seq(data[2..keylen+2]);
    var valueLen := SeqToUInt16(data[keylen+2..keylen+4]) as nat;
    assert keylen + valueLen + 4 <= |data|;
    assert data[keylen+4..keylen + valueLen + 4] == value;
    assert ValidUTF8Seq(data[keylen+4..keylen + valueLen + 4]);
  }
  
  // GetOneKVPair ==> SerializeOneKVPair
  lemma GetOneKVPairRoundTrip(data : Bytes)
    requires GetOneKVPair(data).Success?
    ensures
      && var cont := GetOneKVPair(data).value;
      && SerializeOneKVPair(cont.0, cont.1) == data[..cont.2]
  {}

  // SerializeOneDataKey ==> GetOneDataKey
  lemma SerializeOneDataKeyRoundTrip(k : CMPEncryptedDataKey)
    ensures
      && var data := SerializeOneDataKey(k);
      && GetOneDataKey(data).Success?
      && GetOneDataKey(data).value.0 == k
      && GetOneDataKey(data).value.1 == |data|
    {
      var data := SerializeOneDataKey(k);
      assert 2 <= |data|;
      var provIdSize := SeqToUInt16(data[0..2]) as nat;
      assert provIdSize + 2 < |data|;
      var provId := data[2..2+provIdSize];
      assert provId == k.keyProviderId;
    }

  // GetOneDataKey ==> SerializeOneDataKey
  lemma GetOneDataKeyRoundTrip(data : Bytes)
    requires GetOneDataKey(data).Success?
    ensures
      && var cont := GetOneDataKey(data).value;
      && SerializeOneDataKey(cont.0) == data[..cont.1]
  {}

  // When deserializing a Key Value Pair with GetOneKVPair
  // the unexamined bytes do not change the result
  lemma GetOneKVPairExt(x : Bytes, y : Bytes)
    requires x <= y
    requires GetOneKVPair(x).Success?
    ensures
      && GetOneKVPair(y).Success?
      && GetOneKVPair(x).value == GetOneKVPair(y).value
    {
      assert 2 <= |y|;
      var keylen := SeqToUInt16(y[0..2]) as nat;
      assert(keylen + 4 <= |y|);
      var key := y[2..keylen+2];
      assert x[2..keylen+2] == y[2..keylen+2];
      assert(ValidUTF8Seq(key));
      var valuelen := SeqToUInt16(y[keylen+2..keylen+4]) as nat;
      var kvLen := 2 + keylen + 2 + valuelen;
      assert kvLen <= |y|;
      var value := y[keylen+4..kvLen];
      assert x[keylen+4..kvLen] == y[keylen+4..kvLen];
      assert ValidUTF8Seq(value);
    }
}
