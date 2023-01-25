include "../Model/AwsCryptographyStructuredEncryptionTypes.dfy"

module TrussHeader {
  import opened Wrappers
  import opened StandardLibrary
  import opened StandardLibrary.UInt
  import opened AwsCryptographyStructuredEncryptionTypes
  import CMP = AwsCryptographyMaterialProvidersTypes
  import Prim = AwsCryptographyPrimitivesTypes
  import opened Sets
  import opened UTF8
  import Random

  type MessageID = x: seq<uint8> | |x| == 32 witness *
  type Commitment = x: seq<uint8> | |x| == 32 witness *
  const UINT8_LIMIT := 256
  type CMPEncryptedDataKey = x : CMP.EncryptedDataKey | ValidEncryptedDataKey(x) witness *
  type CMPEncryptionContext  = x : CMP.EncryptionContext | ValidEncryptionContext(x) witness *
  type CMPEncryptedDataKeyList = x : seq<CMPEncryptedDataKey> | |x| < UINT8_LIMIT
  type Legend = x : seq<uint8> | |x| < UINT16_LIMIT
  type CMPUtf8Bytes = x : CMP.Utf8Bytes | |x| < UINT16_LIMIT
  
  predicate method ValidEncryptionContext(x : CMP.EncryptionContext)
  {
    && |x| < UINT16_LIMIT
    && (forall k <- x :: |k| < UINT16_LIMIT && |x[k]| < UINT16_LIMIT)
  }

  predicate method ValidEncryptedDataKey(x : CMP.EncryptedDataKey)
  {
    && |x.keyProviderId| < UINT16_LIMIT
    && |x.keyProviderInfo| < UINT16_LIMIT
    && |x.ciphertext| < UINT16_LIMIT
  }

  datatype Header = Header (
    nameonly version : uint8,
    nameonly flavor : uint8,
    nameonly msgID : MessageID,
    nameonly legend : Legend,
    nameonly encContext : CMPEncryptionContext,
    nameonly dataKeys : CMPEncryptedDataKeyList
  )
  {
    // Header to Bytes
    function method {:opaque} serialize() : (ret : seq<uint8>)
      ensures
        && |ret| >= 34
        //= specification/structured-encryption/header.md#header-format
        //= type=implication
        //# The serialized form of the header MUST be
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
  function method FullSerialize(client: Prim.IAwsCryptographicPrimitivesClient, header : Header)
    : (ret : Result<seq<uint8>, Error>)
    requires client.ValidState()
    ensures client.ValidState()

    //= specification/structured-encryption/header.md#header-commitment
    //= type=implication
    //# The Header Commitment MUST be calculated as a 256-bit HmacSha384,
    //# with all preceding header bytes as the message
    //# and a commitment key of "TRUSS_COMMIT_KEY"
    ensures ret.Success? ==>
      && |ret.value| >= 34
      && ret.value[|ret.value|-32..] == HMAC2(client, ret.value[..|ret.value|-32])
  {
    var body := header.serialize();
    var commitment :- HMAC(client, body);
    Success(body + commitment)
  }

  // deserialize, and check commitment
  function method FullDeserialize(client: Prim.IAwsCryptographicPrimitivesClient, data : seq<uint8>)
    : Result<Header, Error>
    requires client.ValidState()
    ensures client.ValidState()
  {
    :- Need(|data| > 32, E("Header too short"));
    var head :- Deserialize(data[..|data|-32]);
    var storedCommitment := data[|data|-32..];
    var calcCommitment :- HMAC(client, data[..|data|-32]);
    :- Need(storedCommitment == calcCommitment, E("Key commitment mismatch."));
    Success(head)
  }

  // config to Header
  function method Create(
      schema : CryptoSchema,
      msgID : MessageID,
      encContext : CMP.EncryptionContext,
      dataKeys : CMP.EncryptedDataKeyList
    )
    : (ret : Result<Header, Error>)
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
      //= specification/structured-encryption/header.md#key-value-pair-count
      //= type=implication
      //# The value of this field MUST be greater than 0.
      && 0 < |encContext|
      //= specification/structured-encryption/header.md#encrypted-data-key-count
      //= type=implication
      //# This value MUST be greater than 0.
      && 0 < |dataKeys|
  {
    :- Need(0 < |encContext|, E("Encryption context must not be empty"));
    :- Need(ValidEncryptionContext(encContext), E("Invalid Encryption Context"));
    :- Need(0 < |dataKeys|, E("There must be at least one data key"));
    :- Need(|dataKeys| < UINT8_LIMIT, E("Too many data keys."));
    :- Need(forall x | x in dataKeys :: ValidEncryptedDataKey(x), E("Invalid Data Key"));
    var legend :- MakeLegend(schema);
    Success(Header(
      version := 1,
      flavor := 1, // or zero if algorithm suite is TODO?
      msgID := msgID,
      legend := legend,
      encContext := encContext,
      dataKeys := dataKeys
    ))
  }
  
  // bytes to Header
  function method Deserialize(data : seq<uint8>)
    : (ret : Result<Header, Error>)
    ensures
     (&& |data| >= 34
      && GetLegend(data[34..]).Success?
      && var leg := GetLegend(data[34..]).value;
      && GetContext(data[34+leg.1..]).Success?
      && var cont := GetContext(data[34+leg.1..]).value;
      && GetDataKeys(data[34+leg.1+cont.1..]).Success?
      && var dk := GetDataKeys(data[34+leg.1+cont.1..]).value;
      && |data| == 34+leg.1+cont.1+dk.1) <==>
      ret.Success?
    ensures ret.Success? ==> 
      && var v := ret.value;
      && v.version == data[0]
      && v.flavor == data[1]
      && v.msgID == data[2..34]
      && var data1 := data[34..];
      && GetLegend(data1).Success?
      && var legendAndLen := GetLegend(data1).value;
      && v.legend == legendAndLen.0
      && var data2 := data1[legendAndLen.1..];
      && var contextAndLen := GetContext(data2).value;
      && v.encContext == contextAndLen.0
  {
    :- Need(|data| >= 34, E("Serialized header too short."));
    var version := data[0];
    var flavor := data[1];
    var msgID := data[2..34];
    var data1 := data[34..];

    var legendAndLen :- GetLegend(data1);
    var legend := legendAndLen.0;
    var data2 := data1[legendAndLen.1..];

    var contextAndLen :- GetContext(data2);
    var encContext := contextAndLen.0;
    var data3 := data2[contextAndLen.1..];

    var keysAndLen :- GetDataKeys(data3);
    var dataKeys := keysAndLen.0;
    var data4 := data3[keysAndLen.1..];

    :- Need(|data4| == 0, E("Invalid header size"));
    Success(Header(
      version := version,
      flavor := flavor,
      msgID := msgID,
      legend := legend,
      encContext := encContext,
      dataKeys := dataKeys
    ))
  }

  function method HMAC(
    client: Prim.IAwsCryptographicPrimitivesClient,
    data: seq<uint8>
  ) : (ret : Result<seq<uint8>, Error>)
    requires client.ValidState()
    ensures client.ValidState()
    ensures ret.Success? ==> |ret.value| == 32
  {
    var input := Prim.HMacInput (
      digestAlgorithm := Prim.SHA_384,
      key := EncodeAscii("TRUSS_COMMIT_KEY"),
      message := data
    );
    var outputR := client.HMac(input);
    var output :- outputR.MapFailure(e => AwsCryptographyPrimitives(e));
    if |output| != 48 then
      Failure(E("SHA_384 did not produce 384 bits"))
    else
      Success(output[..32])
  }

  function method HMAC2(
    client: Prim.IAwsCryptographicPrimitivesClient,
    data: seq<uint8>
  ) : (ret : seq<uint8>)
    requires client.ValidState()
    ensures client.ValidState()
    ensures |ret| == 32
  {
    var h := HMAC(client, data);
    if h.Success? then
      h.value
    else
      [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
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

  // CryptoSchema to Bytes
  function method MakeLegend(schema : CryptoSchema)
    : (ret : Result<Legend, Error>)
    ensures ret.Success? ==>
      && schema.content.SchemaMap?
      && AllActions(schema.content.SchemaMap)
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
    :- Need(AllActions(schema.content.SchemaMap), E("All members of SchemaMap must be Actions"));
    //= specification/structured-encryption/header.md#encrypt-legend-bytes
    //# The Encrypt Legend Bytes MUST be serialized as follows:
    // 1. Order every authenticated attribute in the item lexicographically by the attribute name.
    // 2. For each authenticated attribute, in order,
    // append one of the byte values specified above to indicate whether
    // that field should be encrypted.
    var attrs := ComputeSetToOrderedSequence2(schema.content.SchemaMap.Keys, CharLess);
    MakeLegend2(attrs, schema.content.SchemaMap)
  }

  function method MakeOneLegend(x : CryptoAction)
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
    //   This indicates that this field MUST be attempted to be decrypted during decryption.
    // - `0x73` (`s` in UTF-8, for "Sign Only") means that a particular field was not encrypted,
    //   but still included in the signature calculation.
    //   This indicates that this field MUST NOT be attempted to be decrypted during decryption.
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

  function method IsAuthAttr(x : CryptoAction) : nat
  {
    match (x) {
      case ENCRYPT_AND_SIGN => 1
      case SIGN_ONLY => 1
      case DO_NOTHING => 0
    }
  }

  function method {:tailrecursion} AllActions2(attrs : seq<string>, data : CryptoSchemaMap) : (ret : bool)
    requires forall k <- attrs :: k in data
    ensures ret ==> (forall k <- attrs :: data[k].content.Action?)
  {
    if |attrs| == 0 then
      true
    else if !data[attrs[0]].content.Action? then
      false
    else
      AllActions2(attrs[1..], data)
  }

  function method AllActions(data : CryptoSchemaMap) : (ret : bool)
    ensures ret ==> (forall v <- data.Values :: v.content.Action?)
  {
    var attrs := ComputeSetToOrderedSequence2(data.Keys, CharLess);
    AllActions2(attrs, data)
  }

  function method CountAuthAttrs2(attrs : seq<string>, data : CryptoSchemaMap)
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

  function method CountAuthAttrs(data : CryptoSchemaMap)
    : nat
    requires forall x <- data.Values :: x.content.Action?
  {
    var attrs := ComputeSetToOrderedSequence2(data.Keys, CharLess);
    CountAuthAttrs2(attrs, data)
  }

  function method {:tailrecursion} MakeLegend2(
      attrs : seq<string>,
      data : CryptoSchemaMap,
      serialized : Legend := []
    )
    : (ret : Result<Legend, Error>)
    requires AllActions(data)
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
        var legendChar := MakeOneLegend(data[attrs[0]].content.Action);
        MakeLegend2(attrs[1..], data, serialized + legendChar)
  }

  function method {:opaque} SerializeLegend(x : Legend)
    : (ret : seq<uint8>)
    //= specification/structured-encryption/header.md#encrypt-legend
    //= type=implication
    //# The Encrypt Legend MUST be serialized as
    ensures
      && |ret| == 2 + |x|
      && SeqToUInt16(ret[0..2]) == |x| as uint16
      && ret[2..] == x

  {
    UInt16ToSeq(|x| as uint16) + x
  }

  function method GetLegend(data : seq<uint8>)
    : (ret : Result<(Legend, nat), Error>)
    ensures ret.Success? ==>
      && ret.value.1 <= |data|
      && ret.value.1 == |ret.value.0| + 2
      && ret.value.0 == data[2..ret.value.1]
  {
    :- Need(2 <= |data|, E("Invalid Header"));
    var len := SeqToUInt16(data[0..2]);
    var size := len as nat + 2;
    :- Need(size <= |data|, E("Invalid header"));
    Success((data[2..size], size))
  }

  function method GetContext(data : seq<uint8>)
    : (ret : Result<(CMPEncryptionContext, nat), Error>)
    ensures ret.Success? ==>
      && ret.value.1 <= |data|
    ensures (
      && 2 <= |data|
      && GetContext2(SeqToUInt16(data[0..2]) as nat, data, data[2..], (map[], 2)).Success?
    ) ==> ret.Success?

  {
    :- Need(2 <= |data|, E("Invalid Header"));
    var count := SeqToUInt16(data[0..2]) as nat;
    GetContext2(count, data, data[2..], (map[], 2))
  }

  function method GetOneContext(data : seq<uint8>)
    : (ret : Result<(CMPUtf8Bytes, CMPUtf8Bytes, nat), Error>)
    ensures ret.Success? ==>
      && ret.value.2 <= |data|
      && SerializeOneContext(ret.value.0, ret.value.1) == data[..ret.value.2]
    ensures (
      && 2 <= |data|
      && var keylen := SeqToUInt16(data[0..2]) as nat;
      && keylen + 4 <= |data|
      && ValidUTF8Seq(data[2..keylen+2])
      && var valueLen := SeqToUInt16(data[keylen+2..keylen+4]) as nat;
      && keylen + valueLen + 4 <= |data|
      && ValidUTF8Seq(data[keylen+4..keylen + valueLen + 4])
    ) <==> ret.Success? && SerializeOneContext(ret.value.0, ret.value.1) == data[..ret.value.2]
  {
    :- Need(2 <= |data|, E("Invalid Header"));
    var keylen := SeqToUInt16(data[0..2]) as nat;
    :- Need(keylen + 4 <= |data|, E("Invalid Header"));
    var key := data[2..keylen+2];
    :- Need(ValidUTF8Seq(key), E("Invalid Header"));
    var valuelen := SeqToUInt16(data[keylen+2..keylen+4]) as nat;
    var kvLen := 2 + keylen + 2 + valuelen;
    :- Need(kvLen <= |data|, E("Invalid Header"));
    var value := data[keylen+4..kvLen];
    :- Need(ValidUTF8Seq(value), E("Invalid Header"));
    Success((key, value, kvLen))
  }
  function method {:tailrecursion} GetContext2(count : nat, origData : seq<uint8>, data : seq<uint8>, deserialized : (CMPEncryptionContext, nat))
    : (ret : Result<(CMPEncryptionContext, nat), Error>)
    requires deserialized.1 <= |origData|
    requires deserialized.1 + |data| == |origData|
    requires data == origData[deserialized.1..]
    ensures ret.Success? ==> 
      && ret.value.1 <= |origData|
      && (count > 0 ==> GetOneContext(data).Success?)
  {
    if count == 0 then
      Success(deserialized)
    else
      if |deserialized.0| + 1 >= UINT16_LIMIT then
        Failure(E("Too much context"))
      else
        var kv :- GetOneContext(data);
        GetContext2(count-1, origData, data[2+|kv.0|+2+|kv.1|..], (deserialized.0[kv.0 := kv.1], deserialized.1 + kv.2))
  }

  //= specification/structured-encryption/header.md#key-value-pair-entries
  //= type=implication
  //# This sequence MUST NOT contain duplicate entries.
  // true because CMPEncryptionContext is a map
  function method {:opaque} SerializeContext(x : CMPEncryptionContext)
    : (ret : seq<uint8>)
    ensures
      && |ret| >= 2
      //= specification/structured-encryption/header.md#key-value-pair-entries
      //= type=implication
      //# These entries MUST have entries sorted, by key,
      //# in ascending order according to the UTF-8 encoded binary value.
      && var keys := ComputeSetToOrderedSequence2(x.Keys, ByteLess);
      //= specification/structured-encryption/header.md#encrypt-context
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

  function method SerializeOneContext(key : CMPUtf8Bytes, value : CMPUtf8Bytes)
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
  

  function method GetOneDataKey(data : seq<uint8>)
    : (ret : Result<(CMPEncryptedDataKey, nat), Error>)
    ensures ret.Success? ==>
      && ret.value.1 <= |data|
      && |SerializeOneDataKey(ret.value.0)| == ret.value.1
      && SerializeOneDataKey(ret.value.0) == data[0..ret.value.1]
  {
    :- Need(2 <= |data|, E("Invalid Header"));
    var provIdSize := SeqToUInt16(data[0..2]) as nat;
    :- Need(provIdSize + 2 < |data|, E("Invalid Header"));
    var provId := data[2..2+provIdSize];
    :- Need(ValidUTF8Seq(provId), E("Invalid Header"));
    var part1Size := 2 + provIdSize;

    :- Need(part1Size+2 <= |data|, E("Invalid Header"));
    var provInfoSize := SeqToUInt16(data[part1Size..part1Size+2]) as nat;
    :- Need(part1Size + provInfoSize + 2 < |data|, E("Invalid Header"));
    var provInfo := data[part1Size+2..part1Size+2+provInfoSize];
    var part2Size := part1Size + 2 + provInfoSize;

    :- Need(part2Size+2 <= |data|, E("Invalid Header"));
    var cipherSize := SeqToUInt16(data[part2Size..part2Size+2]) as nat;
    :- Need(part2Size + cipherSize + 2 <= |data|, E("Invalid Header"));
    var cipher := data[part2Size+2..part2Size+2+cipherSize];
    var part3Size := part2Size + 2 + cipherSize;

    var edk := CMP.EncryptedDataKey(keyProviderId := provId, keyProviderInfo := provInfo, ciphertext := cipher);
    Success((edk, part3Size))
  }

  function method {:tailrecursion} SerializeContext2(keys : seq<CMPUtf8Bytes>, x : CMPEncryptionContext)
    : (ret : seq<uint8>)
    requires forall k <- keys :: k in x
  {
    if |keys| == 0 then
      []
    else
      SerializeOneContext(keys[0], x[keys[0]]) + SerializeContext2(keys[1..], x)
  }

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

  function method {:tailrecursion} SerializeDataKeys2(x : CMPEncryptedDataKeyList)
    : (ret : seq<uint8>)
  {
    if |x| == 0 then
      []
    else
      SerializeOneDataKey(x[0]) + SerializeDataKeys2(x[1..])
  }

  function method GetDataKeys(data : seq<uint8>)
    : (ret : Result<(CMPEncryptedDataKeyList, nat), Error>)
    ensures ret.Success? ==>
      && ret.value.1 <= |data|
      && 1 <= |data|
      && 1 <= ret.value.1
      && |ret.value.0| == data[0] as nat
      && GetDataKeys2(|ret.value.0|, |ret.value.0|, data, data[1..], ([], 1)).Success?
  {
    :- Need(1 <= |data|, E("Invalid Header"));
    var count := data[0] as nat;
    GetDataKeys2(count, count, data, data[1..], ([], 1))
  }

  function method {:tailrecursion} GetDataKeys2(count : nat, origCount : nat, origData : seq<uint8>, data : seq<uint8>, deserialized : (CMPEncryptedDataKeyList, nat))
    : (ret : Result<(CMPEncryptedDataKeyList, nat), Error>)
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

  lemma SerializeLegendRoundTrip(x : Legend)
    ensures GetLegend(SerializeLegend(x)).Success?
    ensures var ret := GetLegend(SerializeLegend(x)).value;
      && ret.0 == x
      && ret.1 == |x| + 2
      && ret.1 == |SerializeLegend(x)|
  {}

  lemma GetLegendRoundTrip(x : seq<uint8>)
    requires GetLegend(x).Success?
    ensures
      && var ret := SerializeLegend(GetLegend(x).value.0);
      && ret == x[..GetLegend(x).value.1]
  {
  }

  lemma SerializeOneContextRoundTrip(key : CMPUtf8Bytes, value : CMPUtf8Bytes)
    ensures GetOneContext(SerializeOneContext(key, value)).Success?
  {
    var data := SerializeOneContext(key, value);
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
  
  lemma GetOneContextRoundTrip(data : seq<uint8>)
    requires GetOneContext(data).Success?
    ensures
      && var cont := GetOneContext(data).value;
      && SerializeOneContext(cont.0, cont.1) == data[..cont.2]
  {}

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

  lemma GetOneDataKeyRoundTrip(data : seq<uint8>)
    requires GetOneDataKey(data).Success?
    ensures
      && var cont := GetOneDataKey(data).value;
      && SerializeOneDataKey(cont.0) == data[..cont.1]
  {}

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

  // Yes, four axioms, I am deeply ashamed, but I think the associated proofs still have value

  lemma {:axiom} GetDataKeys2RoundTrip(data : seq<uint8>, count : nat)
    requires 1 <= |data|
    requires GetDataKeys2(count, count, data, data[1..], ([], 1)).Success?
    ensures
      && var dk := GetDataKeys2(count, count, data, data[1..], ([], 1)).value;
      && SerializeDataKeys2(dk.0) == data[1..dk.1]    

  lemma {:axiom} SerializeDataKeys2RoundTrip(data : CMPEncryptedDataKeyList)
    ensures
      && var bytes := SerializeDataKeys2(data);
      && var count := |data|;
      && var bytes2 := [count as uint8] + bytes;
      && GetDataKeys2(count, count, bytes2, bytes2[1..], ([], 1)).Success?
      && GetDataKeys2(count, count, bytes2, bytes2[1..], ([], 1)).value.0 == data
      && GetDataKeys2(count, count, bytes2, bytes2[1..], ([], 1)).value.1 == |bytes2|

  lemma {:axiom} SerializeContextRoundTrip(x : CMPEncryptionContext)
    ensures GetContext(SerializeContext(x)).Success?
    ensures GetContext(SerializeContext(x)).value.0 == x  
    ensures GetContext(SerializeContext(x)).value.1 == |SerializeContext(x)|
  
  lemma {:axiom} GetContextRoundTrip(x : seq<uint8>)
    requires GetContext(x).Success?
    ensures SerializeContext(GetContext(x).value.0) == x
  
  lemma GetOneContextExt(x : seq<uint8>, y : seq<uint8>)
    requires x <= y
    requires GetOneContext(x).Success?
    ensures
      && GetOneContext(y).Success?
      && GetOneContext(x).value == GetOneContext(y).value
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

  lemma GetContext2Ext2(count : nat, origX : seq<uint8>, origY : seq<uint8>, x : seq<uint8>, y : seq<uint8>, deserialized : (CMPEncryptionContext, nat))
    requires x <= y
    requires origX <= origY
    requires deserialized.1 <= |origX|
    requires deserialized.1 <= |origY|
    requires deserialized.1 + |x| == |origX|
    requires deserialized.1 + |y| == |origY|
    requires x == origX[deserialized.1..]
    requires y == origY[deserialized.1..]
    requires GetContext2(count, origX, x, deserialized).Success?
    requires count == 0 ||  |deserialized.0| + 1 < UINT16_LIMIT
    ensures
        && GetContext2(count, origY, y, deserialized).Success?
        && GetContext2(count, origX, x, deserialized).value == GetContext2(count, origY, y, deserialized).value
  {
    if count == 0 {
    } else {
      assert |deserialized.0| + 1 < UINT16_LIMIT;
      assert GetOneContext(x).Success?;
      GetOneContextExt(x, y);
      assert GetOneContext(y).Success?;
      var kv := GetOneContext(y).value;
      var kvLen := 2+|kv.0|+2+|kv.1|;
      assert x[kvLen..] <= y[kvLen..];
      GetContext2Ext2(count-1, origX, origY, x[kvLen..],  y[kvLen..], (deserialized.0[kv.0 := kv.1], deserialized.1 + kv.2));
    }
  }

  lemma GetContext2Ext(count : nat, x : seq<uint8>, y : seq<uint8>)
    requires 2 <= |x|
    requires x <= y
    requires GetContext2(count, x, x[2..], (map[], 2)).Success?
    ensures
        && GetContext2(count, y, y[2..], (map[], 2)).Success?
        && GetContext2(count, x, x[2..], (map[], 2)).value == GetContext2(count, y, y[2..], (map[], 2)).value
  {
    GetContext2Ext2(count, x, y, x[2..], y[2..], (map[], 2));
  }

  lemma SerializeDataKeysRoundTrip(data : CMPEncryptedDataKeyList)
    ensures
      && var bytes := SerializeDataKeys(data);
      && GetDataKeys(bytes).Success?
      && GetDataKeys(bytes).value.0 == data
      && GetDataKeys(bytes).value.1 == |bytes|
  {
    SerializeDataKeys2RoundTrip(data);
  }

  lemma GetContextExt2(x : seq<uint8>, y : seq<uint8>)
    requires 2 <= |x|
    requires x <= y
    ensures GetContext(x).Success? ==>
      && GetContext(y).Success?
      && GetContext(x).value == GetContext(y).value
  {
    if GetContext(x).Success? {
      var countX := SeqToUInt16(x[0..2]) as nat;
      var countY := SeqToUInt16(y[0..2]) as nat;
      assert countX == countY;
      assert GetContext2(countX, x, x[2..], (map[], 2)).Success?;
      GetContext2Ext(countX, x, y);
    }
  }
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

  lemma DeserializeRoundTrip(data : seq<uint8>)
    requires Deserialize(data).Success?
    ensures
      && var ret := Deserialize(data).value;
      && |data| >= 34
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
      assert |data| >= 34;
      var leg := SerializeLegend(ret.legend);
      GetLegendRoundTrip(leg);
      var data1 := data[34..];
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


    lemma SerializeRoundTrip(h : Header)
      ensures Deserialize(h.serialize()).Success?
      ensures h == Deserialize(h.serialize()).value
    {
      var data := h.serialize();
      assert data == [h.version] + [h.flavor] + h.msgID + SerializeLegend(h.legend) + SerializeContext(h.encContext) + SerializeDataKeys(h.dataKeys);
      SerializeLegendRoundTrip(h.legend);
      SerializeContextRoundTrip(h.encContext);
      SerializeDataKeysRoundTrip(h.dataKeys);
      assert GetLegend(SerializeLegend(h.legend)).Success?;
      assert GetLegend(SerializeLegend(h.legend)).value.0 == h.legend;
      assert GetLegend(SerializeLegend(h.legend)).value.1 == |SerializeLegend(h.legend)|;
       
      assert GetContext(SerializeContext(h.encContext)).Success?;
      assert GetDataKeys(SerializeDataKeys(h.dataKeys)).Success?;

      var data1 := data[34..];

      var serLegend1 := SerializeLegend(h.legend);
      var serLegend2 := data1[..|serLegend1|];
      assert serLegend1 == serLegend2;
      var legendAndLenR := GetLegend(serLegend2);
      assert legendAndLenR.Success?;
      GetLegendRoundTrip(data1);
      var legendAndLen := legendAndLenR.value;
      var legend := legendAndLen.0;
      var data2 := data1[legendAndLen.1..];

      var serContext1 := SerializeContext(h.encContext);
      var serContext2 := data2[..|serContext1|];
      assert serContext1 == serContext2;
      var contextAndLenR := GetContext(serContext2);
      assert contextAndLenR.Success?;
      var contextAndLen := contextAndLenR.value;
      GetContextRoundTrip(serContext2);
      GetContextExt();
      GetContextRoundTrip(data2);
      var encContext := contextAndLen.0;
      var data3 := data2[contextAndLen.1..];

      var serKeys1 := SerializeDataKeys(h.dataKeys);
      var serKeys2 := data3[..|serKeys1|];
      assert serKeys1 == serKeys2;
      assert |serKeys1| == |data3|;

      assert |data| >= 34;
      assert GetLegend(data[34..]).Success?;
      var leg := GetLegend(data[34..]).value;
      assert GetContext(data[34+leg.1..]).Success?;
      var cont := GetContext(data[34+leg.1..]).value;
      assert GetDataKeys(data[34+leg.1+cont.1..]).Success?;
      var dk := GetDataKeys(data[34+leg.1+cont.1..]).value;
      assert |data| == 34+leg.1+cont.1+dk.1;
    }
}
