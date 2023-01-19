include "../Model/AwsCryptographyStructuredEncryptionTypes.dfy"

module TrussHeader {
  import opened Wrappers
  import opened StandardLibrary
  import opened StandardLibrary.UInt
  import opened AwsCryptographyStructuredEncryptionTypes
  import CMP = AwsCryptographyMaterialProvidersTypes
  import opened Sets
  import opened UTF8
  import Random

  type MessageID = x: seq<uint8> | |x| == 32 witness *

  datatype Header = Header (
    nameonly version : uint8,
    nameonly flavor : uint8,
    nameonly msgID : MessageID,
    nameonly legend : seq<uint8>,
    nameonly encContext : CMP.EncryptionContext,
    nameonly dataKeys : CMP.EncryptedDataKeyList
  )
  {
    function method serialize() : (ret : Result<seq<uint8>, Error>)
      ensures 
       (&& SerializeLegend(legend).Success?
        && SerializeContext(encContext).Success?
        && SerializeDataKeys(dataKeys).Success?) ==> ret.Success?

      ensures ret.Success? ==>
        && |ret.value| > 66
        && ret.value[|ret.value|-32..] == HmacSha384(ret.value[..|ret.value|-32], EncodeAscii("TRUSS_COMMIT_KEY"))
        && SerializeLegend(legend).Success?
        && SerializeContext(encContext).Success?
        && SerializeDataKeys(dataKeys).Success?
        && ret.value == (
            [version]
          + [flavor]
          + msgID
          + SerializeLegend(legend).value
          + SerializeContext(encContext).value
          + SerializeDataKeys(dataKeys).value
          + HmacSha384(ret.value[..|ret.value|-32], EncodeAscii("TRUSS_COMMIT_KEY"))
        )
      ensures ret.Success? ==>
        && GetLegend(ret.value[34..]).Success?
        //&& var leg := GetLegend(ret.value[34..]).value; GetContext(ret.value[34+leg.1..]).Success?
        /*
              && var leg := GetLegend(data[34..]).value; GetContext(data[34+leg.1..]).Success?
      && var cont := GetContext(data[34+leg.1..]).value; GetDataKeys(data[34+leg.1+cont.1..]).Success?
      && var dk := GetDataKeys(data[34+leg.1+cont.1..]).value; |data| == 34+leg.1+cont.1+dk.1+32) ==>
*/
    {
      var context :- SerializeContext(encContext);
      var keys :- SerializeDataKeys(dataKeys);
      var leg :- SerializeLegend(legend);
      var baseHeader :=
          [version]
        + [flavor]
        + msgID
        + leg
        + context
        + keys
      ;
      var commitment := HmacSha384(baseHeader, EncodeAscii("TRUSS_COMMIT_KEY"));
       Success(baseHeader + commitment)
    }
  }

  function method Create(
      schema : CryptoSchema,
      msgID : MessageID,
      encContext : CMP.EncryptionContext,
      dataKeys : CMP.EncryptedDataKeyList
    )
    : (ret : Result<Header, Error>)
  {
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
  
  function method Deserialize(data : seq<uint8>)
    : (ret : Result<Header, Error>)
    ensures
     (&& |data| > 66
      && data[|data|-32..] == HmacSha384(data[..|data|-32], EncodeAscii("TRUSS_COMMIT_KEY"))
      && GetLegend(data[34..]).Success?
      && var leg := GetLegend(data[34..]).value;
      && GetContext(data[34+leg.1..]).Success?
      && var cont := GetContext(data[34+leg.1..]).value;
      && GetDataKeys(data[34+leg.1+cont.1..]).Success?
      && var dk := GetDataKeys(data[34+leg.1+cont.1..]).value;
      && |data| == 34+leg.1+cont.1+dk.1+32) <==>
      ret.Success?
/*
    ensures ret.Success? ==> 
      && |data| > 66
      && data[|data|-32..] == HmacSha384(data[..|data|-32], EncodeAscii("TRUSS_COMMIT_KEY"))
      && SerializeLegend(ret.value.legend).Success?
      && SerializeContext(ret.value.encContext).Success?
      && SerializeDataKeys(ret.value.dataKeys).Success?
      && var v := ret.value;
        data == (
            [v.version]
          + [v.flavor]
          + v.msgID
          + SerializeLegend(v.legend).value
          + SerializeContext(v.encContext).value
          + SerializeDataKeys(v.dataKeys).value
          + HmacSha384(data[..|data|-32], EncodeAscii("TRUSS_COMMIT_KEY"))
        )
        */
  {
    :- Need(|data| > 66, E("Serialized header too short."));
    var storedCommitment := data[|data|-32..];
    var calcCommitment := HmacSha384(data[..|data|-32], EncodeAscii("TRUSS_COMMIT_KEY"));
    :- Need(storedCommitment == calcCommitment, E("Key commitment mismatch."));
    var version := data[0];
    var flavor := data[1];
    var msgID := data[2..34];
    var data1 := data[34..];

    // legend needs schema
    var legendAndLen :- GetLegend(data1);
    var legend := legendAndLen.0;
    var data2 := data1[legendAndLen.1..];

    var contextAndLen :- GetContext(data2);
    var encContext := contextAndLen.0;
    var data3 := data2[contextAndLen.1..];

    var keysAndLen :- GetDataKeys(data3);
    var dataKeys := keysAndLen.0;
    var data4 := data3[keysAndLen.1..];

    :- Need(|data4| == 32, E("Invalid header size"));
    Success(Header(
      version := version,
      flavor := flavor,
      msgID := msgID,
      legend := legend,
      encContext := encContext,
      dataKeys := dataKeys
    ))
  }
/*
    lemma RoundTrip2(h : seq<uint8>)
      requires Deserialize(h).Success?
      ensures Deserialize(h).value.serialize().Success?
      ensures h == Deserialize(h).value.serialize().value
    {
    }
    */
/*
    lemma RoundTrip(h : Header)
      requires h.serialize().Success?
      ensures deserialize(h.serialize().value).Success?
      ensures h == deserialize(h.serialize().value).value
    {
      assert deserialize(h.serialize().value).Success?;
      RoundTrip2(h.serialize().value);
      var n := deserialize(h.serialize().value).value;
      LegendRoundTrip(h.legend);
      DataKeysRoundTrip(h.dataKeys);
      ContextRoundTrip(h.encContext);
      assert h.version == n.version;
      assert h.flavor == n.flavor;
      assert h.msgID == n.msgID;
      assert h.legend == n.legend;
      assert h.encContext == n.encContext;
      assert h.dataKeys == n.dataKeys;
    }
  */

  function method E(s : string) : Error {
    StructuredEncryptionException(message := s)
  }
  function method MakeLegend(schema : CryptoSchema) : Result<seq<uint8>, Error>
  {
    :- Need(schema.content.SchemaMap?, E("Should be a SchemaMap"));
    var attrs := ComputeSetToOrderedSequence2(schema.content.SchemaMap.Keys, CharLess);
    MakeLegend2(attrs, schema.content.SchemaMap)
  }



  function method MakeLegend2(attrs : seq<string>, data : CryptoSchemaMap, acc : seq<uint8> := [])
    : Result<seq<uint8>, Error>
    requires forall k <- attrs :: k in data
  {
    if |attrs| == 0 then
      Success(acc)
    else
      :- Need(data[attrs[0]].content.Action?, E("Must be map of actions"));
      var legendChar := match data[attrs[0]].content.Action {
        case ENCRYPT_AND_SIGN => [0x65]
        case SIGN_ONLY => [0x73]
        case DO_NOTHING => []
      };
      MakeLegend2(attrs[1..], data, acc + legendChar)
  }

  function method GetContext(data : seq<uint8>)
    : (ret : Result<(CMP.EncryptionContext, nat), Error>)
    ensures ret.Success? ==>
      && ret.value.1 <= |data|
      //&& SerializeContext(ret.value.0).Success?
  {
    :- Need(2 <= |data|, E("Invalid Header"));
    var count := SeqToUInt16(data[0..2]);
    GetContext2(count, data, data[2..], (map[], 2))
  }

  function method GetOneContext(data : seq<uint8>)
    : (ret : Result<(CMP.Utf8Bytes,CMP.Utf8Bytes,nat), Error>)
    ensures ret.Success? ==>
      && ret.value.2 <= |data|
      && SerializeOneContext(ret.value.0, ret.value.1).Success?
      && SerializeOneContext(ret.value.0, ret.value.1).value == data[..ret.value.2]
    ensures (
      && 2 <= |data|
      && var keylen := SeqToUInt16(data[0..2]) as nat;
      && keylen + 4 <= |data|
      && ValidUTF8Seq(data[2..keylen+2])
      && var valueLen := SeqToUInt16(data[keylen+2..keylen+4]) as nat;
      && keylen + valueLen + 4 <= |data|
      && ValidUTF8Seq(data[keylen+4..keylen + valueLen + 4])
    ) <==> ret.Success? && SerializeOneContext(ret.value.0, ret.value.1).value == data[..ret.value.2]
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
  function method {:tailrecursion} GetContext2(count : uint16, origData : seq<uint8>, data : seq<uint8>, acc : (CMP.EncryptionContext, nat))
    : (ret : Result<(CMP.EncryptionContext, nat), Error>)
    requires acc.1 <= |origData|
    requires acc.1 + |data| == |origData|
    ensures ret.Success? ==> 
      && ret.value.1 <= |origData|
  {
    if count == 0 then
      Success(acc)
    else
      var kv :- GetOneContext(data);
      GetContext2(count-1, origData, data[2+|kv.0|+2+|kv.1|..], (acc.0[kv.0 := kv.1], acc.1 + kv.2))
  }

  function method HmacSha384(data : seq<uint8>, key : seq<uint8>) : (ret : seq<uint8>)
    ensures |ret| == 32
  {
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
  function method {:opaque} SerializeLegend(x : seq<uint8>)
    : (ret : Result<seq<uint8>, Error>)
    ensures |x| < UINT16_LIMIT <==> ret.Success?
    ensures ret.Success? ==>
      && |ret.value| == 2 + |x|
      && SeqToUInt16(ret.value[0..2]) == |x| as uint16
      && ret.value[2..] == x
  {
    var legSize :- ToUInt16(|x|);
    Success(UInt16ToSeq(legSize) + x)
  }

  function method GetLegend(data : seq<uint8>)
    : (ret : Result<(seq<uint8>, nat), Error>)
    ensures ret.Success? ==>
      && ret.value.1 <= |data|
      && ret.value.1 == |ret.value.0| + 2
      && ret.value.0 == data[2..ret.value.1]
      && SerializeLegend(ret.value.0).Success?
  {
    :- Need(2 <= |data|, E("Invalid Header"));
    var len := SeqToUInt16(data[0..2]);
    var size := len as nat + 2;
    :- Need(size <= |data|, E("Invalid header"));
    Success((data[2..size], size))
  }

  lemma LegendRoundTrip(x : seq<uint8>)
    requires |x| < UINT16_LIMIT
    ensures SerializeLegend(x).Success?
    ensures GetLegend(SerializeLegend(x).value).Success?
    ensures var ret := GetLegend(SerializeLegend(x).value).value;
      && ret.0 == x
      && ret.1 == |x| + 2
      && ret.1 == |SerializeLegend(x).value|
  {}

  function method {:opaque} SerializeContext(x : CMP.EncryptionContext)
    : (ret : Result<seq<uint8>, Error>)
    ensures ret.Success? ==>
      && |ret.value| >= 2
      && var keys := ComputeSetToOrderedSequence2(x.Keys, ByteLess); SerializeContext2(keys, x).Success?
  {
    var mapSize :- ToUInt16(|x|);
    var keys := ComputeSetToOrderedSequence2(x.Keys, ByteLess);
    var body :- SerializeContext2(keys, x);
    Success(UInt16ToSeq(mapSize) + body)
  }

  function GOC(key : CMP.Utf8Bytes, value : CMP.Utf8Bytes) : (ret : bool)
    requires SerializeOneContext(key, value).Success?
    ensures ret == true
  {
    SerializeOneContextRoundTrip(key, value);
    assert GetOneContext(SerializeOneContext(key, value).value).Success?;
    GetOneContext(SerializeOneContext(key, value).value).Success?
  }
/*
  lemma SerializeContextRoundTrip(x : CMP.EncryptionContext)
    requires SerializeContext(x).Success?
    {
      var keys := ComputeSetToOrderedSequence2(x.Keys, ByteLess);
      assert SerializeContext2(keys, x).Success?;
      assert forall k <- keys :: SerializeOneContext(k, x[k]).Success?;
      //assert forall k <- keys :: GetOneContext(SerializeOneContext(k, x[k]).value).Success?;
      assert forall k <- keys :: GOC(k, x[k]);
      assert GetContext(SerializeContext(x).value).Success?;
      //&& GetContext(SerializeContext(x).value).value.0 == x

    }
*/
  function method SerializeOneContext(key : CMP.Utf8Bytes, value : CMP.Utf8Bytes)
    : (ret : Result<seq<uint8>, Error>)
    //ensures ret.Success? ==> GetOneContext(ret.value).Success? -- must be a lemma or circular dependency
  {
    var keySize :- ToUInt16(|key|);
    var valSize :- ToUInt16(|value|);
    Success(UInt16ToSeq(keySize) + key + UInt16ToSeq(valSize) + value)
  }

  lemma SerializeOneContextRoundTrip(key : CMP.Utf8Bytes, value : CMP.Utf8Bytes)
    requires SerializeOneContext(key, value).Success?
    ensures GetOneContext(SerializeOneContext(key, value).value).Success?
  {
    var data := SerializeOneContext(key, value).value;
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
  function method {:tailrecursion} SerializeContext2(keys : seq<CMP.Utf8Bytes>, x : CMP.EncryptionContext, acc : seq<uint8> := [])
    : (ret : Result<seq<uint8>, Error>)
    requires forall k <- keys :: k in x
    ensures ret.Success? ==>
      && forall k <- keys :: SerializeOneContext(k, x[k]).Success?
  {
    if |keys| == 0 then
      Success(acc)
    else
      var kv :- SerializeOneContext(keys[0], x[keys[0]]);
      SerializeOneContextRoundTrip(keys[0], x[keys[0]]);
      SerializeContext2(keys[1..], x, acc + kv)
  }

  function method SerializeDataKeys(x : CMP.EncryptedDataKeyList)
    : Result<seq<uint8>, Error>
  {
    var listSize :- ToUInt16(|x|);
    var body :- SerializeDataKeys2(x);
    Success(UInt16ToSeq(listSize) + body)
  }
  function method SerializeOneDataKey(k : CMP.EncryptedDataKey)
    : (ret : Result<seq<uint8>, Error>)
    //ensures ret.Success? ==> GetOneDataKey(ret.value).Success?
  {
    var provIdSize :- ToUInt16(|k.keyProviderId|);
    var provInfoSize :- ToUInt16(|k.keyProviderInfo|);
    var cipherSize :- ToUInt16(|k.ciphertext|);
      Success(
        UInt16ToSeq(provIdSize)
      + k.keyProviderId
      + UInt16ToSeq(provInfoSize)
      + k.keyProviderInfo
      + UInt16ToSeq(cipherSize)
      + k.ciphertext)
  }
  function method {:tailrecursion} SerializeDataKeys2(x : CMP.EncryptedDataKeyList, acc : seq<uint8> := [])
    : Result<seq<uint8>, Error>
  {
    if |x| == 0 then
      Success(acc)
    else
      var k :- SerializeOneDataKey(x[0]);
      SerializeDataKeys2(x[1..], acc + k)
  }

  function method GetDataKeys(data : seq<uint8>)
    : (ret : Result<(CMP.EncryptedDataKeyList, nat), Error>)
    ensures ret.Success? ==>
      && ret.value.1 <= |data|
      // && SerializeDataKeys(ret.value.0).Success?
  {
    :- Need(2 <= |data|, E("Invalid Header"));
    var count := SeqToUInt16(data[0..2]);
    GetDataKeys2(count, data, data[2..], ([], 2))
  }
  function method GetOneDataKey(data : seq<uint8>)
    : (ret : Result<(CMP.EncryptedDataKey, nat), Error>)
    ensures ret.Success? ==> SerializeOneDataKey(ret.value.0).Success?
  {
    :- Need(2 <= |data|, E("Invalid Header"));
    var provIdSize := SeqToUInt16(data[0..2]) as nat;
    :- Need(provIdSize + 4 < |data|, E("Invalid Header"));
    var provId := data[2..2+provIdSize];
    :- Need(ValidUTF8Seq(provId), E("Invalid Header"));
    var part1Size := 2 + provIdSize;

    :- Need(part1Size+2 <= |data|, E("Invalid Header"));
    var provInfoSize := SeqToUInt16(data[part1Size..part1Size+2]) as nat;
    :- Need(part1Size + provInfoSize + 4 < |data|, E("Invalid Header"));
    var provInfo := data[part1Size+2..part1Size+2+provInfoSize];
    var part2Size := part1Size + 2 + provInfoSize;

    :- Need(part2Size+2 <= |data|, E("Invalid Header"));
    var cipherSize := SeqToUInt16(data[part2Size..part2Size+2]) as nat;
    :- Need(part2Size + cipherSize + 2 < |data|, E("Invalid Header"));
    var cipher := data[part2Size+2..part2Size+2+cipherSize];
    var part3Size := part2Size + 2 + cipherSize;

    var edk := CMP.EncryptedDataKey(keyProviderId := provId, keyProviderInfo := provInfo, ciphertext := cipher);
    Success((edk, part3Size))
  }
  function method {:tailrecursion} GetDataKeys2(count : uint16, origData : seq<uint8>, data : seq<uint8>, acc : (CMP.EncryptedDataKeyList, nat))
    : (ret : Result<(CMP.EncryptedDataKeyList, nat), Error>)
    requires acc.1 <= |origData|
    requires acc.1 + |data| == |origData|
    ensures ret.Success? ==>
      && ret.value.1 <= |origData|
      && (count > 0 ==> GetOneDataKey(data).Success?)
  {
    if count == 0 then
      Success(acc)
    else
      var edk :- GetOneDataKey(data);
      GetDataKeys2(count-1, origData, data[edk.1..], (acc.0 + [edk.0], acc.1+edk.1)) 
  }
/*
  lemma DataKeysRoundTrip(x : CMP.EncryptedDataKeyList)
    requires SerializeDataKeys(x).Success?
    ensures GetDataKeys(SerializeDataKeys(x).value).Success?
    ensures GetDataKeys(SerializeDataKeys(x).value).value.0 == x  
    ensures GetDataKeys(SerializeDataKeys(x).value).value.1 == |SerializeDataKeys(x).value|
  
  lemma ContextRoundTrip(x : CMP.EncryptionContext)
    requires SerializeContext(x).Success?
    ensures GetContext(SerializeContext(x).value).Success?
    ensures GetContext(SerializeContext(x).value).value.0 == x  
    ensures GetContext(SerializeContext(x).value).value.1 == |SerializeContext(x).value|
  
  lemma ContextRoundTrip2(x : seq<uint8>)
    requires GetContext(x).Success?
    ensures SerializeContext(GetContext(x).value.0).Success?
    ensures SerializeContext(GetContext(x).value.0).value == x
    */
}
