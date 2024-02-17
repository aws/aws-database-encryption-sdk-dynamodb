// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "../Model/AwsCryptographyDbEncryptionSdkDynamoDbJsonTypes.dfy"
include "Util.dfy"

module JsonToStruct {

  import JT = AwsCryptographyDbEncryptionSdkDynamoDbJsonTypes
  import opened AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes
  import opened Wrappers
  import opened StandardLibrary
  import opened StandardLibrary.UInt
  import opened JsonEncryptorUtil
  import SE = StructuredEncryptionUtil
  import UTF8
  import SortedSets
  import Seq
  import Base64

  import JSON.Utils.Cursors
  import JSON.Grammar
  import JSON.API
  import opened JSON.Values
  import JSON.Errors
  import JSON.Spec
  import JSON.Serializer
  import JSON.ZeroCopy
  import JSON.Deserializer

  type Error = JT.Error

  type StructuredDataTerminalType = x : StructuredData | x.content.Terminal? witness *
  type TerminalDataMap = map<string, StructuredDataTerminalType>

  // This file exists for these two functions : ObjectToStructured and StructuredToObject
  // which provide conversion between an JSON object and a StructuredDataMap

  method ObjectToStructured(item : string, actions : Option<JT.AttributeActions> := None) returns (ret : Result<TerminalDataMap, string>)

    ensures ret.Success? ==> forall v <- ret.value.Values :: v.content.Terminal?
    ensures ret.Success? ==> forall kv <- ret.value.Items :: kv.0 in ret.value.Keys && ret.value[kv.0].content.Terminal?
  {
    var obj :- UTF8.Encode(item);
    var json :- API.Deserialize(obj).MapFailure(e => "Bad JSON Deserialize");
    :- Need(json.Object?, "JSON to encrypt must be an Object : " + item);
    var result : TerminalDataMap := map[];
    for i := 0 to |json.obj| {
      var struct :- AttrToStructured(json.obj[i].1, IsEncrypted(actions, json.obj[i].0));
      result := result[json.obj[i].0 := struct];
    }
    print "ObjectToStructured : ", result, "\n";
    return Success(result);
  }

  method StructuredToObject(s : StructuredDataMap) returns (ret : Result<string, string>)
  {
    print "StructuredToObject : ", s, "\n";
    var keys := SortedSets.ComputeSetToOrderedSequence2(s.Keys, CharLess);
    var result : seq<(string, JSON)> := [];
    for i := 0 to |keys| {
      var j :- StructuredToAttr(s[keys[i]]);
      result := result + [(keys[i], j)];
    }
    var final := Object(result);
    var jsonBytes :- API.Serialize(final).MapFailure(e => "Bad JSON Serialize");
    return UTF8.Decode(jsonBytes);
  }

  // everything past here is to implement those two

  predicate method IsEncrypted(actions : Option<JT.AttributeActions>, name : string)
  {
    actions.Some? && name in actions.value && actions.value[name] == ENCRYPT_AND_SIGN
  }

  function method MakeError<T>(s : string) : Result<T, Error> {
    Failure(Error.JsonEncryptorException(message := s))
  }

  function method MapError<T>(r : Result<T, string>) : Result<T, Error> {
    if r.Success? then
      Success(r.value)
    else
      MakeError(r.error)
  }

  function method ObjectToMap(obj : seq<(string, JSON)>, ghost parent : JSON, acc : map<string, JSON> := map[])
    : (ret : map<string, JSON>)
    requires forall k <- obj :: k.1 < parent
    requires forall k <- acc :: acc[k] < parent
    ensures forall k <- ret :: ret[k] < parent
  {
    if |obj| == 0 then
      acc
    else
      ObjectToMap(obj[1..], parent, acc[obj[0].0 := obj[0].1])
  }


  predicate method ArrayEqual(x : seq<JSON>, y : seq<JSON>)
    requires |x| == |y|
  {
    if |x| == 0 then
      true
    else
      JsonEqual(x[0], y[0]) && ArrayEqual(x[1..], y[1..])
  }

  function method {:tailrecursion} GetJsonValue(y : seq<(string, JSON)>, x : string) : Option<JSON>
  {
    if |y| == 0 then
      None
    else if y[0].0 == x then
      Some(y[0].1)
    else
      GetJsonValue(y[1..], x)
  }

  predicate method ObjectValuesEqual(x : seq<(string, JSON)>, y : seq<(string, JSON)>)
  {
    if |x| == 0 then
      true
    else
      var yVal := GetJsonValue(y, x[0].0);
      if yVal.None? then
        false
      else
        JsonEqual(x[0].1, yVal.value)
  }

  predicate method JsonEqual(x : JSON, y : JSON)
  {
    match x {
      case Null =>  y.Null?
      case Bool(b) => y.Bool? && y.b == b
      case String(str) => y.String? && y.str == str
      case Number(num) => y.Number? && y.num == num // FIXME -- Decimals can be equal but not equal
      case Object(obj) =>
        && y.Object?
        && |obj| == |y.obj|
        && (set k <- obj :: k.0) == (set k <- y.obj :: k.0)
        && ObjectValuesEqual(obj, y.obj)
      case Array(arr) => y.Array? && |arr| == |y.arr| && ArrayEqual(arr, y.arr)
    }
  }

  method  TopLevelAttributeToBytes(a : JSON) returns (ret : Result<seq<uint8>, string>)
    // We never need to prefix at the top level.
    // The Type ID is serialized separately,
    // and the Length is not needed since we are
    // working with the exact set of bytes when we
    // need to deserialize.
  {
    ret := AttrToBytes(a, false);
  }

  method  AttrToStructured(item : JSON, isEncrypted : bool) returns (ret : Result<StructuredData, string>)
    ensures ret.Success? ==> ret.value.content.Terminal?
  {
    if isEncrypted {
      :- Need(item.String?, "Encrypted attribute's value was not of type String.");
      var data : seq<uint8> :- Base64.Decode(item.str);
      return Success(StructuredData(content := Terminal(StructuredDataTerminal(value := data, typeId := SE.BINARY)), attributes := None));
    } else {
      var body :- TopLevelAttributeToBytes(item);
      return Success(StructuredData(content := Terminal(StructuredDataTerminal(value := body, typeId := AttrToTypeId(item))), attributes := None));
    }
  }

  method StructuredToAttr(s : StructuredData) returns (ret : Result<JSON, string>)
    ensures ret.Success? ==> s.content.Terminal?
    ensures ret.Success? ==> s.attributes.None?
  {
    :- Need(s.attributes.None?, "attributes must be None");
    :- Need(s.content.Terminal?, "StructuredData to JSON only works on Terminal data");

    var Terminal(s) := s.content;
    :- Need(|s.typeId| == 2, "Type ID must be two bytes");
    var attrValueAndLength :- BytesToAttr(s.value, s.typeId, false);
    print "returned length=", attrValueAndLength.len, " expected length=", |s.value|, "\n";
    :- Need(attrValueAndLength.len == |s.value|, "Mismatch between length of encoded data and length of data");
    return Success(attrValueAndLength.val);
  }

  const BOOL_LEN : nat := 1   // number of bytes in an encoded boolean
  const TYPEID_LEN : nat := 2   // number of bytes in a TerminalTypeId
  const LENGTH_LEN : nat := 4 // number of bytes in an encoded count or length
  const PREFIX_LEN : nat := 6 // number of bytes in a prefix, i.e. 2-byte type and 4-byte length


  function method AttrToTypeId(a : JSON) : TerminalTypeId
  {
    match a {
      case String(s) => SE.STRING
      case Number(n) => SE.NUMBER
      case Object(o) => SE.MAP
      case Array(a) => SE.LIST
      case Null => SE.NULL
      case Bool(b) => SE.BOOLEAN
    }
  }

  function method NumberToString(num : Decimal) : Result<string, string>
  {
    var utf8 :- Spec.Number(num).MapFailure((e : Errors.SerializationError) => e.ToString());
    UTF8.Decode(utf8)
  }

  function method StringToNumber(str : string) : Result<Decimal, string>
  {
    var utf8 :- UTF8.Encode(str);
    :- Need(|utf8| < BoundedInts.TWO_TO_THE_32, "String too long");
    var cursor : Cursors.FreshCursor := Cursors.Cursor(utf8, 0, 0, |utf8| as uint32);
    var num : Cursors.Split<Grammar.jnumber> :- ZeroCopy.Deserializer.Numbers.Number(cursor)
                                                .MapFailure((e : Cursors.CursorError<Errors.DeserializationError>) => e.ToString(
                                                                (f : Errors.DeserializationError) => f.ToString()
                                                              ));
    Deserializer.Number(num.t).MapFailure((e : Errors.DeserializationError) => e.ToString())
  }

  // convert JSON to byte sequence
  // if `prefix` is true, prefix sequence with TypeID and Length
  method {:vcs_split_on_every_assert} AttrToBytes(a : JSON, prefix : bool, depth : nat := 1) returns (ret : Result<seq<uint8>, string>)
    decreases a
    // ensures ret.Success? && prefix ==> 6 <= |ret.value|
    // ensures MAX_STRUCTURE_DEPTH < depth ==> ret.Failure?

    // ensures a.Bool? && !prefix && depth <= MAX_STRUCTURE_DEPTH ==>
    //           && (a.b  ==> ret.Success? && |ret.value| == BOOL_LEN && ret.value[0] == 1)
    //           && (!a.b ==> ret.Success? && |ret.value| == BOOL_LEN && ret.value[0] == 0)
    // ensures a.Bool? && prefix && depth <= MAX_STRUCTURE_DEPTH ==>
    //           && (a.b  ==> (ret.Success? && |ret.value| == PREFIX_LEN+BOOL_LEN && ret.value[PREFIX_LEN] == 1
    //                         && ret.value[0..TYPEID_LEN] == BOOLEAN && ret.value[TYPEID_LEN..PREFIX_LEN] == [0,0,0,1]))
    //           && (!a.b ==> (ret.Success? && |ret.value| == PREFIX_LEN+BOOL_LEN && ret.value[PREFIX_LEN] == 0
    //                         && ret.value[0..TYPEID_LEN] == BOOLEAN && ret.value[TYPEID_LEN..PREFIX_LEN] == [0,0,0,1]))

    // ensures a.Null? && !prefix && depth <= MAX_STRUCTURE_DEPTH ==> ret.Success? && |ret.value| == 0
    // ensures a.Null? &&  prefix && depth <= MAX_STRUCTURE_DEPTH ==> ret.Success? && |ret.value| == PREFIX_LEN && ret.value[0..TYPEID_LEN] == NULL && ret.value[TYPEID_LEN..PREFIX_LEN] == [0,0,0,0]

    // ensures a.String? && ret.Success? && !prefix ==>
    //           UTF8.Decode(ret.value).Success? && UTF8.Decode(ret.value).value == a.str
    // ensures a.String? && ret.Success? && prefix ==>
    //           && UTF8.Decode(ret.value[PREFIX_LEN..]).Success?
    //           && UTF8.Decode(ret.value[PREFIX_LEN..]).value == a.str
    //           && ret.value[0..TYPEID_LEN] == STRING
    //           && UTF8.Encode(a.str).Success?
    //           && U32ToBigEndian(|UTF8.Encode(a.str).value|).Success?
    //           && ret.value[TYPEID_LEN..PREFIX_LEN] == U32ToBigEndian(|UTF8.Encode(a.str).value|).value

    //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#number
    //= type=implication
    //# This value MUST be normalized in the same way as DynamoDB normalizes numbers.

    // ensures a.Number? && ret.Success? && !prefix ==>
    //           && NumberToString(a.num).Success?
    //           && var nn := NumberToString(a.num).value;
    //           && UTF8.Decode(ret.value).Success? && UTF8.Decode(ret.value).value == nn
    // ensures a.Number? && ret.Success? && prefix ==>
    //           && NumberToString(a.num).Success?
    //           && var nn := NumberToString(a.num).value;
    //           && UTF8.Decode(ret.value[PREFIX_LEN..]).Success?
    //           && UTF8.Decode(ret.value[PREFIX_LEN..]).value == nn
    //           && ret.value[0..TYPEID_LEN] == NUMBER
    //           && UTF8.Encode(nn).Success?
    //           && U32ToBigEndian(|UTF8.Encode(nn).value|).Success?
    //           && ret.value[TYPEID_LEN..PREFIX_LEN] == U32ToBigEndian(|UTF8.Encode(nn).value|).value

    // ensures a.Array? && ret.Success? && !prefix ==>
    //           && U32ToBigEndian(|a.arr|).Success?
    //           && |ret.value| >= LENGTH_LEN
    //           && ret.value[0..LENGTH_LEN] == U32ToBigEndian(|a.arr|).value
    //           && BigEndianToU32(ret.value[0..LENGTH_LEN]).value == |a.arr|

    //           && (|a.arr| == 0 ==> |ret.value| == LENGTH_LEN)

    // ensures a.Array? && ret.Success? && prefix ==>
    //           && U32ToBigEndian(|a.arr|).Success?
    //           && |ret.value| >= PREFIX_LEN + LENGTH_LEN
    //           && ret.value[0..TYPEID_LEN] == LIST
    //           && ret.value[PREFIX_LEN..PREFIX_LEN+LENGTH_LEN] == U32ToBigEndian(|a.arr|).value
    //           && (|a.arr| == 0 ==> |ret.value| == PREFIX_LEN + LENGTH_LEN)

    // ensures a.Object? && ret.Success? && !prefix ==>
    //           && U32ToBigEndian(|a.obj|).Success?
    //           && |ret.value| >= LENGTH_LEN

    //           && ret.value[0..LENGTH_LEN] == U32ToBigEndian(|a.obj|).value
    //           && BigEndianToU32(ret.value[0..LENGTH_LEN]).value == |a.obj|

    //           && (|a.obj| == 0 ==> |ret.value| == LENGTH_LEN)

    // ensures a.Object? && ret.Success? && prefix ==>
    //           && U32ToBigEndian(|a.arr|).Success?
    //           && |ret.value| >= PREFIX_LEN + LENGTH_LEN
    //           && ret.value[0..TYPEID_LEN] == AttrToTypeId(a)
    //           && (|a.arr| == 0 ==> |ret.value| == PREFIX_LEN + LENGTH_LEN)

  {
    //:- Need(depth <= MAX_STRUCTURE_DEPTH, "Depth of attribute structure to serialize exceeds limit of " + MAX_STRUCTURE_DEPTH_STR);
    var baseBytes : seq<uint8> := [];
    if a.String? {
      baseBytes :- UTF8.Encode(a.str);
    } else if a.Number? {
      var nn :- NumberToString(a.num);
      baseBytes :- UTF8.Encode(nn);
    } else if a.Object? {
      assert forall k <- a.obj :: k.1 < a;
      var keyMap : map<string, JSON> := ObjectToMap(a.obj, a);
      assert forall k <- keyMap :: keyMap[k] < a;
      var keySeq := SortedSets.ComputeSetToOrderedSequence2(keyMap.Keys, CharLess);
      baseBytes :- U32ToBigEndian(|keySeq|);
      for i := 0  to |keySeq| {
        var one :- AttrToBytes(keyMap[keySeq[i]], true, depth+1);
        var data :- SerializeMapObject(keySeq[i], one);
        baseBytes := baseBytes + data;
      }
      print "Serialized object  : ", |baseBytes|, "\n";
    } else if a.Array? {
      baseBytes :- U32ToBigEndian(|a.arr|);
      var body : seq<uint8> := [];
      for i := 0 to |a.arr| {
        var val :- AttrToBytes(a.arr[i], true, depth+1);
        baseBytes := baseBytes + val;
      }
      print "Serialized array  : ", |baseBytes|, "\n";
    } else if a.Bool? {
      baseBytes := [BoolToUint8(a.b)];
    } else if a.Null? {
      baseBytes := [];
    }
    if prefix {
      var len :- U32ToBigEndian(|baseBytes|);
      print "Serialized sub-thing with ", |AttrToTypeId(a) + len + baseBytes|, "bytes\n";
      return Success(AttrToTypeId(a) + len + baseBytes);
    } else {
      print "Serialized thing with ", |baseBytes|, "bytes\n";
      return Success(baseBytes);
    }
  }

  // lemma BigEndianLemma()
  //   ensures U32ToBigEndian(3) == Success([0,0,0,3])
  //   ensures BigEndianToU32([0,0,0,3]) == Success(3)
  // {}

  lemma U32ToBigEndianRoundTrip(x : nat)
    ensures U32ToBigEndian(x).Success? ==>
              && BigEndianToU32(U32ToBigEndian(x).value).Success?
              && BigEndianToU32(U32ToBigEndian(x).value).value == x
  {}

  lemma BigEndianToU32RoundTrip(x : seq<uint8>)
    requires |x| == 4
    ensures BigEndianToU32(x).Success? ==>
              && U32ToBigEndian(BigEndianToU32(x).value).Success?
              && U32ToBigEndian(BigEndianToU32(x).value).value == x
  {}

  function method U32ToBigEndian(x : nat) : (ret : Result<seq<uint8>, string>)
    ensures ret.Success? ==> |ret.value| == LENGTH_LEN
  {
    if x > 0xffff_ffff then
      Failure("Length was too big")
    else
      Success(UInt32ToSeq(x as uint32))
  }

  function method BigEndianToU32(x : seq<uint8>) : (ret : Result<nat, string>)
  {
    if |x| < LENGTH_LEN then
      Failure("Length of 4-byte integer was less than 4")
    else
      Success(SeqToUInt32(x[..LENGTH_LEN]) as nat)
  }

  predicate IsSorted<T>(s: seq<T>, lessThanOrEq: (T, T) -> bool) {
    forall j, k :: 0 <= j < k < |s| ==> lessThanOrEq(s[j], s[k])
  }

  function method EncodeString(s : string) : (ret : Result<seq<uint8>, string>)
    // The Duvet implications set-entries and set-entry-length mentioned in SerializeBinaryValue
    // are also implied here for String Sets and Number Sets
    ensures ret.Success? ==>
              && UTF8.Encode(s).Success?
              && U32ToBigEndian(|UTF8.Encode(s).value|).Success?
              && |ret.value| == LENGTH_LEN + |UTF8.Encode(s).value|
              && ret.value[0..LENGTH_LEN] == U32ToBigEndian(|UTF8.Encode(s).value|).value
              && ret.value[LENGTH_LEN..] == UTF8.Encode(s).value
  {
    var val :- UTF8.Encode(s);
    var len :- U32ToBigEndian(|val|);
    Success(len + val)
  }

  function method SerializeMapObject(key : string, value : seq<uint8>) : (ret : Result<seq<uint8>, string>)
    // ensures ret.Success? ==>
    //           && |ret.value| >= TYPEID_LEN
    //           && ret.value[0..TYPEID_LEN] == STRING
    //           && UTF8.Encode(key).Success?
    //           && |ret.value| == TYPEID_LEN + LENGTH_LEN + |UTF8.Encode(key).value| + |value|
    //           && UTF8.Decode(ret.value[TYPEID_LEN+LENGTH_LEN..TYPEID_LEN+LENGTH_LEN+|UTF8.Encode(key).value|]).Success?
    //           && UTF8.Decode(ret.value[TYPEID_LEN+LENGTH_LEN..TYPEID_LEN+LENGTH_LEN+|UTF8.Encode(key).value|]).value == key

    // ensures ret.Success? ==>
    //           && UTF8.Encode(key).Success?
    //           && U32ToBigEndian(|UTF8.Encode(key).value|).Success?
    //           && |ret.value| >= TYPEID_LEN+LENGTH_LEN
    //           && ret.value[TYPEID_LEN..TYPEID_LEN+LENGTH_LEN] == U32ToBigEndian(|UTF8.Encode(key).value|).value
  {
    var name :- UTF8.Encode(key);
    assert UTF8.Decode(name).Success?;
    var len :- U32ToBigEndian(|name|);

    var serialized := SE.STRING + len + name + value;
    assert |serialized| == TYPEID_LEN + LENGTH_LEN + |name| + |value|;
    Success(serialized)
  }

  function method BoolToUint8(b : bool) : uint8
  {
    if b then 1 else 0
  }

  // JSON with number of bytes consumed in its construction
  datatype AttrValueAndLength = AttrValueAndLength(
    val : JSON,
    len : nat
  )

  method {:vcs_split_on_every_assert} BytesToAttrSimple(
    value : seq<uint8>,
    typeId : TerminalTypeId,
    startPos : nat,
    len : nat
  )
    returns (ret : Result<AttrValueAndLength, string>)
    requires startPos <= |value|
    requires |value| >= (startPos+len)

    ensures ret.Success? ==> ret.value.len <= |value|
{
    ghost var origLength := |value|;
    ghost var origValue := value;
    var currPos : nat := startPos;
    var retVal : JSON;
    if typeId == SE.NULL {
      if len != 0 {
        return Failure("NULL type did not have length zero");
      }
      retVal := JSON.Null;
      assert currPos <= origLength;
    }
    else if typeId == SE.STRING {
      var newLen := currPos + len;
      var str :- UTF8.Decode(value[currPos..newLen]);
      currPos := newLen;
      retVal := JSON.String(str);
      assert currPos <= origLength;
    }
    else if typeId == SE.NUMBER {
      var newLen := currPos + len;
      var str :- UTF8.Decode(value[currPos..newLen]);
      currPos := newLen;
      var num :- StringToNumber(str);
      retVal := JSON.Number(num);
      assert currPos <= origLength;
    }
    else if typeId == SE.BINARY {
      var newLen := currPos + len;
      var str := Base64.Encode(value[currPos..newLen]);
      currPos := newLen;
      retVal := JSON.String(str);
      assert currPos <= origLength;
    }
    else if typeId == SE.BOOLEAN {
      if len != BOOL_LEN {
        return Failure("Boolean Structured Data has more than one byte");
      } else if value[currPos] == 0x00 {
        currPos := currPos + BOOL_LEN;
        assert currPos <= origLength;
        retVal := JSON.Bool(false);
      } else if value[currPos] == 0x01 {
        currPos := currPos + BOOL_LEN;
        assert currPos <= origLength;
        retVal := JSON.Bool(true);
      } else {
        return Failure("Boolean Structured Data had inappropriate value");
      }
      assert currPos <= origLength;
    } else {
      print "type id ", typeId, "\n";
      return Failure("Unsupported TerminalTypeId");
    }
    assert currPos <= origLength;
    assert value == origValue;
    assert origLength == |value|;
    assert currPos <= |value|;
    var returnVal := AttrValueAndLength(retVal, currPos);
    assert returnVal.len <= origLength;
    return Success(returnVal);
}

  // Bytes to JSON
  method {:vcs_split_on_every_assert} BytesToAttr(
    value : seq<uint8>,
    typeId : TerminalTypeId,
    hasLen : bool,
    depth : nat := 1
  )
    returns (ret : Result<AttrValueAndLength, string>)
    ensures ret.Success? ==> ret.value.len <= |value|
    ensures MAX_STRUCTURE_DEPTH < depth ==> ret.Failure?
    decreases |value|
  {
    ghost var origLength := |value|;
    ghost var origValue := value;
    :- Need(depth <= MAX_STRUCTURE_DEPTH, "Depth of attribute structure to deserialize exceeds limit of " + MAX_STRUCTURE_DEPTH_STR);
    var len : nat :- if hasLen then
      if |value| < LENGTH_LEN then
        Failure("Out of bytes reading length")
      else
        BigEndianToU32(value)
    else
      Success(|value|);
    var currPos : nat := if hasLen then LENGTH_LEN else 0;
    var retVal : JSON := JSON.Null;

    if |value| < (currPos+len) {
      return Failure("Structured Data has too few bytes");
    }
    else if typeId == SE.MAP {
      var newLen := currPos + LENGTH_LEN;
      :- Need(newLen <= |value|, "Map Structured Data has less than 4 bytes.");
      var count :- BigEndianToU32(value[currPos..]);
      currPos := newLen;

      var resultList : seq<(string, JSON)> := [];
      for i := 0 to count
        invariant currPos <= origLength
      {
        // get typeId of key
        var newLen := currPos + TYPEID_LEN;
        :- Need(newLen <= |value|, "Out of bytes reading Map Key");
        var TerminalTypeId_key := value[currPos..newLen];
        :- Need(TerminalTypeId_key == SE.STRING, "Key of Map is not String");
        currPos := newLen;

        // get key
        newLen := currPos + LENGTH_LEN;
        :- Need(newLen <= |value|, "Out of bytes reading Map Key");
        var keyLen :- BigEndianToU32(value[currPos..]);
        currPos := newLen;

        newLen := currPos + keyLen;
        :- Need(newLen <= |value|, "Key of Map of Structured Data has too few bytes");
        var key :- UTF8.Decode(value[currPos..newLen]);
        currPos := newLen;

        // get typeId of value
        newLen := currPos + TYPEID_LEN;
        :- Need(newLen <= |value|, "Out of bytes reading Map Value");
        var TerminalTypeId_value : TerminalTypeId := value[currPos..newLen];
        currPos := newLen;

        // get value and construct result
        assert currPos > 0;
        assert |value[currPos..]| < origLength;
        var nval :- BytesToAttr(value[currPos..], TerminalTypeId_value, true, depth+1);
        currPos := currPos + nval.len;

        // FIXME      :- Need(key !in resultMap.val.M, "Duplicate key in map.");
        resultList := resultList + [(key, nval.val)];
      }
      assert currPos <= origLength;
      retVal := JSON.Object(resultList);
    } else if typeId == SE.LIST {
      var newLen := currPos + LENGTH_LEN;
      :- Need(newLen <= |value|, "List Structured Data has less than 4 bytes.");
      var count :- BigEndianToU32(value[currPos..]);
      currPos := newLen;

      var resultList : seq<JSON> := [];
      print "List has ", count, " items\n";
      for i := 0 to count
        invariant currPos <= |value|
      {
        newLen := currPos + TYPEID_LEN;
        :- Need(newLen <= |value|, "Out of bytes reading List Value");
        var terminalTypeId : TerminalTypeId := value[currPos..newLen];
        currPos := newLen;

        newLen := currPos + LENGTH_LEN;
        :- Need(newLen <= |value|, "Out of bytes reading List Value");
        var valueLen :- BigEndianToU32(value[currPos..]);
        currPos := newLen;

        newLen := currPos + valueLen;
        :- Need(newLen <= |value|, "Out of bytes reading List Value");
        assert currPos > 0;
        assert newLen <= origLength;
        assert (newLen-currPos) < origLength;
        assert |value[currPos..newLen]| < origLength;
        print "currPos=", currPos, " valueLen=", valueLen, " newLen=", newLen, "\n";
        var nval :- BytesToAttr(value[currPos..newLen], terminalTypeId, false, depth+1);
        currPos := newLen;
        if nval.len != valueLen {
          print " *** Andy Is Confused *** ", nval.len, " ", len, "\n";
        }
        resultList := resultList + [nval.val];
      }
      assert currPos <= origLength;
      retVal := JSON.Array(resultList);
    } else {
      ret := BytesToAttrSimple(value, typeId, currPos, len);
      return;
    }
    assert origLength == |value|;
    assert origValue == value;
    assert currPos <= |value|;
    assert currPos <= origLength;
    var returnVal := AttrValueAndLength(retVal, currPos);
    assert returnVal.len <= origLength;
    assert returnVal.len <= |value|;
    return Success(returnVal);
  }


  function method FlattenValueMap<X,Y>(m : map<X, Result<Y,string>>): map<X,Y> {
    map k <- m | m[k].Success? :: k := m[k].value
  }

  function method FlattenErrors<X,Y>(m : map<X, Result<Y,string>>): set<string> {
    set k <- m | m[k].Failure? :: m[k].error
  }

  lemma OneBadResult<X,Y>(m : map<X, Result<Y,string>>)
    requires ! forall k <- m :: m[k].Success?
    ensures exists k <- m :: m[k].Failure?
    ensures |FlattenErrors(m)| > 0
  {
    assert exists k <- m :: m[k].Failure?;
    var errors := FlattenErrors(m);
    assert exists k :: k in m && m[k].Failure? && (m[k].error in errors);
  }

  lemma MapKeysMatchItems<X,Y>(m : map<X,Y>)
    ensures forall k :: k in m.Keys ==> (k, m[k]) in m.Items
  {}

  lemma OneBadKey<X,Y>(s : map<X,Y>, bad : set<X>, f : X -> bool)
    requires !forall k <- s.Keys :: f(k)
    requires bad == set k <- s.Keys | !f(k) :: k
    ensures exists k <- s.Keys :: !f(k)
    ensures |bad| > 0
  {
    assert exists v :: v in bad && !f(v) && (v in bad);
  }

  lemma SimplifyMapValueSuccess<X,Y>(m : map<X, Result<Y,string>>)
    ensures SimplifyMapValue(m).Success? <==> forall k <- m :: m[k].Success?
    ensures SimplifyMapValue(m).Success? ==> forall kv <- m.Items :: kv.1.Success?
    ensures SimplifyMapValue(m).Failure? <==> exists k : X | k in m.Keys :: m[k].Failure?
  {}

  // Turn a map<X, Result<Y,string>> into a Result<map<X,Y>, string>
  // If anything reported Failure, return a Failure with all of the error messages
  //
  // useful when  g in
  // var ret := map kv <- m.Items | true :: kv.0 := g(kv.1);
  // returns Result
  function method SimplifyMapValue<X,Y>(m : map<X, Result<Y,string>>) : (ret : Result<map<X,Y>, string>)
    ensures ret.Success? ==> ret.value.Keys == m.Keys
    ensures ret.Success? ==> |ret.value.Keys| == |m.Keys|
    ensures ret.Success? ==> |ret.value| == |m|
  {
    if forall k <- m :: m[k].Success? then
      var result := FlattenValueMap(m);
      MapKeysMatchItems(m);
      Success(result)
    else
      OneBadResult(m);
      var badValues := FlattenErrors(m);
      assert(|badValues| > 0);
      // We happen to order these values, but this ordering MUST NOT be relied upon.
      var badValueSeq := SetToOrderedSequence(badValues, CharLess);
      Failure(Join(badValueSeq, "\n"))
  }
}
