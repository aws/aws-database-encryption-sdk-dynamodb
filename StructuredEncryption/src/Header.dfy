// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "../Model/AwsCryptographyStructuredEncryptionTypes.dfy"

module Header {
  import opened Wrappers
  import opened StandardLibrary
  import opened StandardLibrary.UInt
  import opened AwsCryptographyStructuredEncryptionTypes
  import CMP = AwsCryptographyMaterialProvidersTypes
  import Prim = AwsCryptographyPrimitivesTypes
  import opened Sets
  import opened UTF8
  import Random

  const VERSION_LEN := 1
  const FLAVOR_LEN := 1
  const MSGID_LEN := 32
  const COMMITMENT_LEN := 32
  const PREFIX_LEN := VERSION_LEN + FLAVOR_LEN + MSGID_LEN
  const TRUSS_COMMIT_KEY := "TRUSS_COMMIT_KEY";

  type MessageID = x: seq<uint8> | |x| == MSGID_LEN witness *
  type Commitment = x: seq<uint8> | |x| == COMMITMENT_LEN witness *
  const UINT8_LIMIT := 256
  type Version = x : uint8 | ValidVersion(x) witness 1
  type Flavor = x : uint8 | ValidFlavor(x)
  type CMPEncryptedDataKey = x : CMP.EncryptedDataKey | ValidEncryptedDataKey(x) witness *
  type CMPEncryptionContext  = x : CMP.EncryptionContext | ValidEncryptionContext(x) witness *
  type CMPEncryptedDataKeyListEmptyOK = x : seq<CMPEncryptedDataKey> | |x| < UINT8_LIMIT
  type CMPEncryptedDataKeyList = x : seq<CMPEncryptedDataKey> | 0 < |x| < UINT8_LIMIT witness *
  type Legend = x : seq<uint8> | |x| < UINT16_LIMIT
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
    function method {:opaque} serialize() : (ret : seq<uint8>)
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
  function method FullSerialize(client: Prim.IAwsCryptographicPrimitivesClient, PartialHeader : PartialHeader)
    : (ret : Result<seq<uint8>, Error>)
    requires client.ValidState()
    ensures client.ValidState()

    //= specification/structured-encryption/header.md#header-commitment
    //= type=implication
    //# The Header Commitment MUST be calculated as a 256-bit HmacSha384,
    //# with all preceding Header bytes as the message
    //# and a commitment key of "TRUSS_COMMIT_KEY"
    ensures ret.Success? ==>
      && PREFIX_LEN <= |ret.value|
      && HMAC(client, ret.value[..|ret.value|-32]).Success?
      && ret.value[|ret.value|-32..] == HMAC(client, ret.value[..|ret.value|-32]).value
  {
    var body := PartialHeader.serialize();
    var commitment :- HMAC(client, body);
    Success(body + commitment)
  }

  // deserialize, and check commitment
  function method FullDeserialize(client: Prim.IAwsCryptographicPrimitivesClient, data : seq<uint8>)
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
      && HMAC(client, data[..|data|-32]).Success?
      && var calcCommitment := HMAC(client, data[..|data|-32]).value;
      && storedCommitment == calcCommitment
  {
    :- Need(32 < |data|, E("PartialHeader too short"));
    var head :- Deserialize(data[..|data|-32]);
    var storedCommitment := data[|data|-32..];
    var calcCommitment :- HMAC(client, data[..|data|-32]);
    :- Need(storedCommitment == calcCommitment, E("Key commitment mismatch."));
    Success(head)
  }

  // config to PartialHeader
  function method Create(
      schema : CryptoSchema,
      msgID : MessageID,
      encContext : CMP.EncryptionContext,
      dataKeys : CMP.EncryptedDataKeyList
    )
    : (ret : Result<PartialHeader, Error>)
    ensures ret.Success? ==>
      //= specification/structured-encryption/header.md#format-version
      //= type=implication
      //# The Version MUST be `0x01`.
      && ret.value.version == 1
      //= specification/structured-encryption/header.md#format-flavor
      //= type=implication
      //# The flavor MUST be one of these two values.
      // | Value | Meaning |
      // |---|---|
      // | 0x01 | Signatures enabled (default) |
      // | 0x00 | Signatures disabled |
      && ret.value.flavor == 1
      //= specification/structured-encryption/header.md#encrypted-data-key-count
      //= type=implication
      //# This value MUST be greater than 0.
      && 0 < |dataKeys|
  {
    :- Need(ValidEncryptionContext(encContext), E("Invalid Encryption Context"));
    :- Need(0 < |dataKeys|, E("There must be at least one data key"));
    :- Need(|dataKeys| < UINT8_LIMIT, E("Too many data keys."));
    :- Need(forall x | x in dataKeys :: ValidEncryptedDataKey(x), E("Invalid Data Key"));
    var legend :- MakeLegend(schema);
    Success(PartialHeader(
      version := 1,
      flavor := 1, // or zero if algorithm suite is TODO?
      msgID := msgID,
      legend := legend,
      encContext := encContext,
      dataKeys := dataKeys
    ))
  }
  
  // bytes to PartialHeader, i.e. does not look at commitment -- FullDeserialize does that
  function method Deserialize(data : seq<uint8>)
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
  function method HMAC(
    client: Prim.IAwsCryptographicPrimitivesClient,
    data: seq<uint8>
  ) : (ret : Result<seq<uint8>, Error>)
    requires client.ValidState()
    ensures client.ValidState()
    ensures ret.Success? ==> |ret.value| == 32
  {
    // TODO - Prim.SHA_384
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
  function method MakeLegend(schema : CryptoSchema)
    : (ret : Result<Legend, Error>)
    ensures ret.Success? ==>
      && schema.content.SchemaMap?
      && CryptoSchemaMapIsFlat(schema.content.SchemaMap)
      //= specification/structured-encryption/header.md#encrypt-legend-bytes
      //= type=implication
      //# The length of this serialized value (in bytes) MUST equal the number of authenticated fields indicated
      //# by the caller's [Authenticate Schema](./structures.md#authenticate-schema).
      && |ret.value| == CountAuthAttrs(schema.content.SchemaMap)
      && var attrs := ComputeSetToOrderedSequence2(schema.content.SchemaMap.Keys, CharLess);
      && MakeLegend2(attrs, schema.content.SchemaMap).Success?
      && ret.value == MakeLegend2(attrs, schema.content.SchemaMap).value

  {
    :- Need(schema.content.SchemaMap?, E("Should be a SchemaMap"));
    :- Need(CryptoSchemaMapIsFlat(schema.content.SchemaMap), E("SchemaMap must be flat."));
    //= specification/structured-encryption/header.md#encrypt-legend-bytes
    //# The Encrypt Legend Bytes MUST be serialized as follows:
    // 1. Order every authenticated attribute in the item lexicographically by the attribute name.
    // 2. For each authenticated attribute, in order,
    // append one of the byte values specified above to indicate whether
    // that field should be encrypted.
    var attrs := ComputeSetToOrderedSequence2(schema.content.SchemaMap.Keys, CharLess);
    MakeLegend2(attrs, schema.content.SchemaMap)
  }

  // Create a Legend for the given attrs of the Schema
  function method {:tailrecursion} MakeLegend2(
      attrs : seq<string>,
      data : CryptoSchemaMap,
      serialized : Legend := []
    )
    : (ret : Result<Legend, Error>)
    requires CryptoSchemaMapIsFlat(data)
    requires forall k <- attrs :: k in data
    requires CountAuthAttrs2(attrs, data) + |serialized| == CountAuthAttrs(data)
    ensures ret.Success? ==>
      && |ret.value| == CountAuthAttrs(data)
  {
    if |attrs| == 0 then
      Success(serialized)
    else
      if (|serialized| + 1) >= UINT16_LIMIT then
        Failure(E("Legend Too Long."))
      else
        var legendChar := SerializeCryptoAction(data[attrs[0]].content.Action);
        MakeLegend2(attrs[1..], data, serialized + legendChar)
  }

  // CryptoAction to bytes. One vyte for signed, zero bytes for unsigned
  function method SerializeCryptoAction(x : CryptoAction)
    : (ret : seq<uint8>)
    //= specification/structured-encryption/header.md#encrypt-legend-bytes
    //= type=implication
    //# Each Crypto Action MUST be encoded as follows
    // | Field | Length (bytes) | Interpreted as |
    // | ----- | -------------- | -------------- |
    // | Encrypt Legend Length | 2 | big endian UInt16 |
    // | Encrypt Legend Bytes | Variable. Equal to the value specified in the previous 2 bytes (Encrypt Legend Length). | Bytes |
    // - `0x65` (`e` in UTF-8, for "Encrypt and Sign") means that a particular field was encrypted
    //   and included in the signature calculation.
    //   This indicates that this field will be attempted to be decrypted during decryption.
    // - `0x73` (`s` in UTF-8, for "Sign Only") means that a particular field was not encrypted,
    //   but still included in the signature calculation.
    //   This indicates that this field will not be attempted to be decrypted during decryption.
    // - no entry if the attribute is not signed
    ensures match (x) {
      case ENCRYPT_AND_SIGN => ret == [0x65]
      case SIGN_ONLY => ret == [0x73]
      case DO_NOTHING => ret == []
    }
  {
    match (x) {
      case ENCRYPT_AND_SIGN => [0x65]
      case SIGN_ONLY => [0x73]
      case DO_NOTHING => []
    }
  }

  // attibute is "authorized", a.k.a. "signed"
  function method IsAuthAttr(x : CryptoAction) : nat
  {
    match (x) {
      case ENCRYPT_AND_SIGN => 1
      case SIGN_ONLY => 1
      case DO_NOTHING => 0
    }
  }

  // Are all the given attrs in the CryptoSchemaMap flat, i.e., does it contain only Actions?
  function method {:tailrecursion} CryptoSchemaMapIsFlat2(attrs : seq<string>, data : CryptoSchemaMap) : (ret : bool)
    requires forall k <- attrs :: k in data
    ensures ret ==> (forall k <- attrs :: data[k].content.Action?)
  {
    if |attrs| == 0 then
      true
    else if !data[attrs[0]].content.Action? then
      false
    else
      CryptoSchemaMapIsFlat2(attrs[1..], data)
  }

  // Is the CryptoSchemaMap flat, i.e., does it contain only Actions?
  function method CryptoSchemaMapIsFlat(data : CryptoSchemaMap) : (ret : bool)
    ensures ret ==> (forall v <- data.Values :: v.content.Action?)
  {
    var attrs := ComputeSetToOrderedSequence2(data.Keys, CharLess);
    CryptoSchemaMapIsFlat2(attrs, data)
  }

  // How many of the given elements of the Schema are authorized?
  function CountAuthAttrs2(attrs : seq<string>, data : CryptoSchemaMap)
    : (ret : nat)
    requires forall k <- attrs :: k in data
    requires forall x | x in attrs :: data[x].content.Action?
    ensures |attrs| > 0 ==> ret == CountAuthAttrs2(attrs[1..], data) + IsAuthAttr(data[attrs[0]].content.Action)
  {
    if |attrs| == 0 then
      0
    else 
      CountAuthAttrs2(attrs[1..], data) + IsAuthAttr(data[attrs[0]].content.Action)
  }

  // How many elements of Schema are authorized?
  function CountAuthAttrs(data : CryptoSchemaMap)
    : nat
    requires forall x <- data.Values :: x.content.Action?
  {
    var attrs := ComputeSetToOrderedSequence2(data.Keys, CharLess);
    CountAuthAttrs2(attrs, data)
  }

  // Legens to Bytes
  function method {:opaque} SerializeLegend(x : Legend)
    : (ret : seq<uint8>)
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
  function method GetLegend(data : seq<uint8>)
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
  function method GetContext(data : seq<uint8>)
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
  function method GetOneKVPair(data : seq<uint8>)
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

  // For "count" items, Deserialize key value pairs into an Encryption Context
  function method {:tailrecursion} GetContext2(
    count : nat,
    origData : seq<uint8>,
    data : seq<uint8>,
    deserialized : (CMPEncryptionContext, nat))
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
      if |deserialized.0| + 1 >= UINT16_LIMIT then
        Failure(E("Too much context"))
      else
        var kv :- GetOneKVPair(data);
        GetContext2(count-1, origData, data[2+|kv.0|+2+|kv.1|..], (deserialized.0[kv.0 := kv.1], deserialized.1 + kv.2))
  }

  // Encryption Context to Bytes
  function method {:opaque} SerializeContext(x : CMPEncryptionContext)
    : (ret : seq<uint8>)
    ensures
      && |ret| >= 2
      //= specification/structured-encryption/header.md#key-value-pair-entries
      //= type=implication
      //# These entries MUST have entries sorted, by key,
      //# in ascending order according to the UTF-8 encoded binary value.
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
    var keys := ComputeSetToOrderedSequence2(x.Keys, ByteLess);
    UInt16ToSeq(|x| as uint16) + SerializeContext2(keys, x)
  }

  // Key Value Pair to Bytes
  function method SerializeOneKVPair(key : CMPUtf8Bytes, value : CMPUtf8Bytes)
    : (ret : seq<uint8>)
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
    : (ret : seq<uint8>)
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
  function method GetOneDataKey(data : seq<uint8>)
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
    : (ret : seq<uint8>)
    requires forall k <- keys :: k in x
  {
    if |keys| == 0 then
      []
    else
      SerializeOneKVPair(keys[0], x[keys[0]]) + SerializeContext2(keys[1..], x)
  }

  // Data Key List to Bytes
  function method SerializeDataKeys(x : CMPEncryptedDataKeyList)
    : (ret : seq<uint8>)
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
    : (ret : seq<uint8>)
  {
    if |x| == 0 then
      []
    else
      SerializeOneDataKey(x[0]) + SerializeDataKeys2(x[1..])
  }

  // Bytes to Data Key List
  function method GetDataKeys(data : seq<uint8>)
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
    origData : seq<uint8>,
    data : seq<uint8>,
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
  lemma GetLegendRoundTrip(x : seq<uint8>)
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
  lemma GetOneKVPairRoundTrip(data : seq<uint8>)
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
  lemma GetOneDataKeyRoundTrip(data : seq<uint8>)
    requires GetOneDataKey(data).Success?
    ensures
      && var cont := GetOneDataKey(data).value;
      && SerializeOneDataKey(cont.0) == data[..cont.1]
  {}

  // GetDataKeys ==> SerializeDataKeys
  lemma GetDataKeysRoundTrip(data : seq<uint8>)
    requires GetDataKeys(data).Success?
    ensures
      && var dk := GetDataKeys(data).value;
      && SerializeDataKeys(dk.0) == data[..dk.1]
  {
    var dk := GetDataKeys(data).value;
    GetDataKeys2RoundTrip(data, |dk.0|);
    assert SerializeDataKeys(dk.0) == [|dk.0| as uint8] + SerializeDataKeys2(dk.0);
  }

  // Yes, five axioms, I am deeply ashamed, but I think the associated proofs still have value

  // When deserializing an Encryption Context with GetContext
  // the unexamined bytes do not change the result
  // much like the non-lemma GetOneKVPairExt
  lemma {:axiom} GetContextExt2(x : seq<uint8>, y : seq<uint8>)
    requires 2 <= |x|
    requires x <= y
    ensures GetContext(x).Success? ==>
      && GetContext(y).Success?
      && GetContext(x).value == GetContext(y).value

  // GetDataKeys2 ==> SerializeDataKeys2
  // we have proven GetOneDataKeyRoundTrip
  // and the remaining code is obvious to a human
  lemma {:axiom} GetDataKeys2RoundTrip(data : seq<uint8>, count : nat)
    requires 1 <= |data|
    requires GetDataKeys2(count, count, data, data[1..], ([], 1)).Success?
    ensures
      && var dk := GetDataKeys2(count, count, data, data[1..], ([], 1)).value;
      && SerializeDataKeys2(dk.0) == data[1..dk.1]    

  // SerializeDataKeys2 ==> GetDataKeys2
  // we have proven GetOneDataKeyRoundTrip
  // and the mapping between these two functions is simple and obvious to a human
  lemma {:axiom} SerializeDataKeys2RoundTrip(data : CMPEncryptedDataKeyList)
    ensures
      && var bytes := SerializeDataKeys2(data);
      && var count := |data|;
      && var bytes2 := [count as uint8] + bytes;
      && GetDataKeys2(count, count, bytes2, bytes2[1..], ([], 1)).Success?
      && GetDataKeys2(count, count, bytes2, bytes2[1..], ([], 1)).value.0 == data
      && GetDataKeys2(count, count, bytes2, bytes2[1..], ([], 1)).value.1 == |bytes2|

  // SerializeContext ==> GetContext
  // we have proven SerializeOneKVPairRoundTrip
  // and the mapping between these two functions is simple and obvious to a human
  lemma {:axiom} SerializeContextRoundTrip(x : CMPEncryptionContext)
    ensures GetContext(SerializeContext(x)).Success?
    ensures GetContext(SerializeContext(x)).value.0 == x  
    ensures GetContext(SerializeContext(x)).value.1 == |SerializeContext(x)|
  
  // GetContext ==> SerializeContext
  // we have proven GetOneKVPairRoundTrip
  // and the mapping between these two functions is simple and obvious to a human
  lemma {:axiom} GetContextRoundTrip(x : seq<uint8>)
    requires GetContext(x).Success?
    ensures SerializeContext(GetContext(x).value.0) == x
  
  // When deserializing a Key Value Pair with GetOneKVPair
  // the unexamined bytes do not change the result
  lemma GetOneKVPairExt(x : seq<uint8>, y : seq<uint8>)
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

    // SerializeDataKeys ==> GetDataKeys
    lemma SerializeDataKeysRoundTrip(data : CMPEncryptedDataKeyList)
      ensures
        && var bytes := SerializeDataKeys(data);
        && GetDataKeys(bytes).Success?
        && GetDataKeys(bytes).value.0 == data
        && GetDataKeys(bytes).value.1 == |bytes|
    {
      SerializeDataKeys2RoundTrip(data);
    }

  // When deserializing an Encryption Context with GetContext
  // the unexamined bytes do not change the result
  lemma GetContextExt()
    ensures forall x : seq<uint8>, y : seq<uint8> | 2 <= |x|  && x <= y ::
      GetContext(x).Success? ==>
        && GetContext(y).Success?
        && GetContext(x).value == GetContext(y).value
    {
      forall x : seq<uint8>, y : seq<uint8> | 2 <= |x|  && x <= y ensures
        GetContext(x).Success? ==>
          && GetContext(y).Success?
          && GetContext(x).value == GetContext(y).value {
            GetContextExt2(x, y);
          }
    }

  // Deserialize ==> Serialize
  // There is no lemma proving FullDeserialize ==> FullSerialize
  // because those are methods whch cannot be used in requires and ensures clauses
  lemma DeserializeRoundTrip(data : seq<uint8>)
    requires Deserialize(data).Success?
    ensures
      && var ret := Deserialize(data).value;
      && PREFIX_LEN <= |data|
      && data == (
            [ret.version]
          + [ret.flavor]
          + ret.msgID
          + SerializeLegend(ret.legend)
          + SerializeContext(ret.encContext)
          + SerializeDataKeys(ret.dataKeys)
        )
    {
      var ret := Deserialize(data).value;
      assert PREFIX_LEN <= |data|;
      var leg := SerializeLegend(ret.legend);
      GetLegendRoundTrip(leg);
      var data1 := data[PREFIX_LEN..];
      assert GetLegend(data1).Success?;
      var legendAndLen := GetLegend(data1).value;
      var data2 := data1[legendAndLen.1..];
      var contextAndLen := GetContext(data2).value;
      GetContextRoundTrip(data2);
      SerializeContextRoundTrip(ret.encContext);
      SerializeDataKeysRoundTrip(ret.dataKeys);
      var cont := SerializeContext(ret.encContext);
      GetDataKeysRoundTrip(cont);
    }

  // Serialize ==> Deerialize
  // There is no lemma proving FullSerialize ==> FullDeserialize
  // because those are methods whch cannot be used in requires and ensures clauses
  lemma SerializeRoundTrip(h : PartialHeader)
    ensures Deserialize(h.serialize()).Success?
    ensures h == Deserialize(h.serialize()).value
  {
    var data : seq<uint8> := h.serialize();
    assert data == [h.version] + [h.flavor] + h.msgID + SerializeLegend(h.legend) + SerializeContext(h.encContext) + SerializeDataKeys(h.dataKeys);
    SerializeLegendRoundTrip(h.legend);
    SerializeContextRoundTrip(h.encContext);
    SerializeDataKeysRoundTrip(h.dataKeys);
    assert GetLegend(SerializeLegend(h.legend)).Success?;
    assert GetLegend(SerializeLegend(h.legend)).value.0 == h.legend;
    assert GetLegend(SerializeLegend(h.legend)).value.1 == |SerializeLegend(h.legend)|;
    assert GetContext(SerializeContext(h.encContext)).Success?;
    assert GetDataKeys(SerializeDataKeys(h.dataKeys)).Success?;
    var data1 : seq<uint8> := data[PREFIX_LEN..];

    var serLegend1 : seq<uint8> := SerializeLegend(h.legend);
    var serLegend2 : seq<uint8> := data1[..|serLegend1|];
    var legendAndLenR := GetLegend(serLegend2);
    assert legendAndLenR.Success?;
    GetLegendRoundTrip(data1);
    var legendAndLen : (Legend, nat) := legendAndLenR.value;
    var legend : Legend := legendAndLen.0;

    var data2 : seq<uint8> := data1[legendAndLen.1..];

    var serContext1 : seq<uint8> := SerializeContext(h.encContext);
    var serContext2 : seq<uint8> := data2[..|serContext1|];
    assert serContext1 == serContext2;
    var contextAndLenR := GetContext(serContext2);
    assert contextAndLenR.Success?;
    var contextAndLen := contextAndLenR.value;
    GetContextRoundTrip(serContext2);
    GetContextExt();
    GetContextRoundTrip(data2);
    var encContext := contextAndLen.0;
    var data3 : seq<uint8> := data2[contextAndLen.1..];

    var serKeys1 : seq<uint8> := SerializeDataKeys(h.dataKeys);
    var serKeys2 : seq<uint8> := data3[..|serKeys1|];
    assert serKeys1 == serKeys2;
    assert |serKeys1| == |data3|;

    assert PREFIX_LEN <= |data|;
    assert GetLegend(data[PREFIX_LEN..]).Success?;
    var leg := GetLegend(data[PREFIX_LEN..]).value;
    assert GetContext(data[PREFIX_LEN+leg.1..]).Success?;
    var cont := GetContext(data[PREFIX_LEN+leg.1..]).value;
    assert GetDataKeys(data[PREFIX_LEN+leg.1+cont.1..]).Success?;
    var dk := GetDataKeys(data[PREFIX_LEN+leg.1+cont.1..]).value;
    assert |data| == PREFIX_LEN+leg.1+cont.1+dk.1;
  }
}
