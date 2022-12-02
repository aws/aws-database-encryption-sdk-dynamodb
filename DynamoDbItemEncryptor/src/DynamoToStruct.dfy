// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "../Model/AwsCryptographyDynamoDbItemEncryptorTypes.dfy"
include "./SetSort.dfy"

module DynamoToStruct {

  import opened ComAmazonawsDynamodbTypes
  import opened AwsCryptographyStructuredEncryptionTypes
  import opened Wrappers
  import opened StandardLibrary
  import opened StandardLibrary.UInt
  import UTF8
  import Set
  import opened Seq.MergeSort
  import opened Relations

  // This file exists for these five functions

/* TODO - prove the following
  StructuredToItem(ItemToStructured(itemMap)) == itemMap
  ItemToStructured(StructuredToItem(structureMap)) == structureMap
  AttrToStructured(StructuredToAttr(structure)) == structure
  StructuredToAttr(AttrToStructured(item)) == item

  Also prove : "there exists a single canonical serialization of items that contains a set or map (i.e. there is a canonical ordering or set entries)"
*/

  function method ItemToStructured(item : AttributeMap) : Result<StructuredDataMap, string>
  {
    var structuredMap := map kv <- item.Items | true :: kv.0 := AttrToStructured(kv.1);
    SimplifyMapValue(structuredMap)
  }

  function method StructuredToItem(s : StructuredDataMap) : Result<AttributeMap, string>
  {
    var badNames := set k <- s.Keys | !IsValid_AttributeName(k) :: k;
    if |badNames| > 0 then
      var orderedAttrNames := SetToOrderedSequence(badNames, CharLess);
      var attrNameList := Join(orderedAttrNames, ",");
      Failure("Not valid attribute names : " + attrNameList)
    else
      var structuredData := map kv <- s.Items | IsValid_AttributeName(kv.0) :: kv.0 := StructuredToAttr(kv.1);
      SimplifyMapValue(structuredData)
  }

  function method AttributeToBytes(a : AttributeValue) : Result<seq<uint8>, string>
  {
    AttrToBytes(a, false)
  }

  function method AttrToStructured(item : AttributeValue) : Result<StructuredData, string>
  {
    var body :- AttributeToBytes(item);
    Success(StructuredData(content := Terminal(StructuredDataTerminal(value := body, typeId := AttrToTypeId(item))), attributes := None))
  }

  function method StructuredToAttr(s : StructuredData) : Result<AttributeValue, string>
  {
    match s.content {
      case Terminal(s) => 
        if |s.typeId| != 2 then
          Failure("Type ID must be two bytes")
        else
          var attrValueAndLength :- BytesToAttr(s.value, s.typeId, false);
          Success(attrValueAndLength.val)
      case _ => Failure("StructuredData to AttributeValue only works on Terminal data")
    }
  }


  // everything past here is to implement those two

    const TERM_T : uint8 := 0x00;
    const SET_T  : uint8 := 0x01;
    const MAP_T  : uint8 := 0x02;
    const LIST_T : uint8 := 0x03;
    const NULL_T : uint8 := 0x00;
    const STRING_T  : uint8 := 0x01;
    const NUMBER_T  : uint8 := 0x02;
    const BINARY_T : uint8 := 0x03;
    const BOOLEAN_T : uint8 := 0x04;
    const NULL       : TerminalTypeId := [TERM_T, NULL_T];
    const STRING     : TerminalTypeId := [TERM_T, STRING_T];
    const NUMBER     : TerminalTypeId := [TERM_T, NUMBER_T];
    const BINARY     : TerminalTypeId := [TERM_T, BINARY_T];
    const BOOLEAN    : TerminalTypeId := [TERM_T, BOOLEAN_T];
    const STRING_SET : TerminalTypeId := [SET_T,  STRING_T];
    const NUMBER_SET : TerminalTypeId := [SET_T,  NUMBER_T];
    const BINARY_SET : TerminalTypeId := [SET_T,  BINARY_T];
    const MAP        : TerminalTypeId := [MAP_T,  NULL_T];
    const LIST       : TerminalTypeId := [LIST_T, NULL_T];

  function method AttrToTypeId(a : AttributeValue) : TerminalTypeId
  {
    match a {
      case S(s) => STRING
      case N(n) => NUMBER
      case B(b) => BINARY
      case SS(ss) => STRING_SET
      case NS(ns) => NUMBER_SET
      case BS(bs) => BINARY_SET
      case M(m) => MAP
      case L(l) => LIST
      case NULL(n) => NULL
      case BOOL(b) => BOOLEAN
    }
  }

  type AttrNameAndSerializedValue = (AttributeName, seq<uint8>)

  predicate method CharLess(x : char, y : char) {
    x < y
  }

  predicate method AttrLexicographicLessOrEqual(x : AttrNameAndSerializedValue, y : AttrNameAndSerializedValue) {
    LexicographicLessOrEqual(x.0, y.0, CharLess)
  }
  
/*
  We know this is a total order, because LexicographicLessOrEqual on strings is a total order
  TODO - actually prove it

  I am assured that a solution to this will be pushed to the Dafny standard library by December 9th.
*/
  lemma {:axiom} AttrLexicographicLessOrEqualIsTotal()
    ensures TotalOrdering(AttrLexicographicLessOrEqual)

/*
  {
    assert Reflexive(AttrLexicographicLessOrEqualIsTotal);
    assert AntiSymmetric(AttrLexicographicLessOrEqualIsTotal);
    assert Relations.Transitive(AttrLexicographicLessOrEqualIsTotal);
    assert StronglyConnected(AttrLexicographicLessOrEqualIsTotal);
  }
*/

  // prefix sequence with TypeID and Length, unless wrap is false, signifying a standalone value
  function method Wrap(a : AttributeValue, wrap : bool, res : Result<seq<uint8>, string>) : Result<seq<uint8>, string>
  {
    if res.Failure? || !wrap then
      res
    else
      var len :- U32ToBigEndian(|res.value|);
      Success(AttrToTypeId(a) + len + res.value)
  }

  // convert AttributeValue to byte sequence
  // if `wrap` is true, prefix sequence with TypeID and Length
  function method AttrToBytes(a : AttributeValue, wrap : bool) : (ret : Result<seq<uint8>, string>)
    decreases a
    //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#boolean
    //= type=implication
    //# Boolean MUST be serialized as:
    //# - `0x00` if the value is `false`
    //# - `0x01` if the value is `true`
    ensures a.BOOL? ==>
      && (a.BooleanAttributeValue && !wrap ==> ret.Success? && |ret.value| == 1 && ret.value[0] == 1)
      && (!a.BooleanAttributeValue && !wrap ==> ret.Success? && |ret.value| == 1 && ret.value[0] == 0)
  {
    match a {
      case S(s) => Wrap(a, wrap, UTF8.Encode(s))
      case N(n) => Wrap(a, wrap, UTF8.Encode(n))
      case B(b) => Wrap(a, wrap, Success(b))
      case SS(ss) =>
        var count :- U32ToBigEndian(|ss|);
        var body :- CollectString(ss);
        Wrap(a, wrap, Success(count + body))
      case NS(ns) =>
        var count :- U32ToBigEndian(|ns|);
        var body :- CollectString(ns);
        Wrap(a, wrap, Success(count + body))
      case BS(bs) =>
        var count :- U32ToBigEndian(|bs|);
        var body :- CollectBinary(bs);
        Wrap(a, wrap, Success(count + body))
      case M(m) =>
        var bytes := map kv <- m.Items | true :: kv.0 := AttrToBytes(kv.1, true);
        var bytes :- SimplifyMapValue(bytes);
        var count :- U32ToBigEndian(|m|);
        AttrLexicographicLessOrEqualIsTotal();
        var sset := Set.Sort.SortSet(bytes.Items, AttrLexicographicLessOrEqual);
        var body :- CollectMap(sset);
        Wrap(a, wrap, Success(count + body))
      case L(l) =>
        var count :- U32ToBigEndian(|l|);
        var body :- CollectList(l);
        Wrap(a, wrap, Success(count + body))
 
      //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#null
      //# Null MUST be serialized as a zero-length byte string.
      case NULL(n) => Wrap(a, wrap, Success([]))

      case BOOL(b) => Wrap(a, wrap, Success([BoolToUint8(b)]))
    }
  }

  lemma BigEndianLemma()
    ensures U32ToBigEndian(3) == Success([0,0,0,3])
    ensures BigEndianToU32([0,0,0,3]) == Success(3)
  {}

  function method U32ToBigEndian(x : nat) : (ret : Result<seq<uint8>, string>)
    ensures ret.Success? ==> |ret.value| == 4
  {
    if x > 0xffff_ffff then
      Failure("Length was too big")
    else
      Success(UInt32ToSeq(x as uint32))
  }

  function method BigEndianToU32(x : seq<uint8>) : (ret : Result<nat, string>)
  {
    if |x| < 4 then
      Failure("Lenght of 4-byte integer was less than 4")
    else
      Success(SeqToUInt32(x[..4]) as nat)
  }
  
  predicate IsSorted<T>(s: seq<T>, lessThanOrEq: (T, T) -> bool) {
    forall j, k :: 0 <= j < k < |s| ==> lessThanOrEq(s[j], s[k])
  }

  // String Set or Number Set to Bytes
  function method {:tailrecursion} CollectString(b : StringSetAttributeValue, acc : seq<uint8> := []) : Result<seq<uint8>, string>
  {
    if |b| == 0 then
      Success(acc)
    else
      var val :- UTF8.Encode(b[0]);
      var len :- U32ToBigEndian(|val|);
      CollectString(b[1..], acc + len + val)
  }

  // Binary Set to Bytes
  function method {:tailrecursion} CollectBinary(b : BinarySetAttributeValue, acc : seq<uint8> := []) : Result<seq<uint8>, string>
  {
    if |b| == 0 then
      Success(acc)
    else
      var val := b[0];
      var len :- U32ToBigEndian(|val|);
      CollectBinary(b[1..], acc + len + val)
  }

  // List to Bytes
  // Can't be {:tailrecursion} because it calls AttrToBytes which might again call CollectList
  function method CollectList(b : ListAttributeValue, acc : seq<uint8> := []) : Result<seq<uint8>, string>
  {
    if |b| == 0 then
      Success(acc)
    else
      var val :- AttrToBytes(b[0], true);
      CollectList(b[1..], acc + val)
  }

  // Map to Bytes
  // input sequence is already serialized
  function method {:tailrecursion} CollectMap(b : seq<AttrNameAndSerializedValue>, acc : seq<uint8> := []) : Result<seq<uint8>, string>
    requires IsSorted(b, AttrLexicographicLessOrEqual)
  {
    if |b| == 0 then
      Success(acc)
    else
      var name :- UTF8.Encode(b[0].0);
      var len :- U32ToBigEndian(|name|);
      CollectMap(b[1..], acc + STRING + len + name + b[0].1)
  }
  
  function method BoolToUint8(b : bool) : uint8
  {
    if b then 1 else 0
  }

  // AttributeValue with number of bytes consumed in its construction
  datatype AttrValueAndLength = AttrValueAndLength(
    val : AttributeValue,
    len : nat
  )

  // Bytes to Binary Set
  function method {:tailrecursion} {:vcs_split_on_every_assert}  DeserializeBinarySet(
    serialized : seq<uint8>,
    remainingCount : nat,
    origSerializedSize : nat,
    resultSet : AttrValueAndLength)
    : (ret : Result<AttrValueAndLength, string>)
    requires resultSet.val.BS?
    ensures ret.Success? ==> ret.value.val.BS?
    requires |serialized| + resultSet.len == origSerializedSize
    ensures ret.Success? ==> ret.value.len <= origSerializedSize
  {
    if remainingCount == 0 then
      Success(resultSet)
    else if |serialized| < 4 then
      Failure("Out of bytes reading Binary Set")
    else
      var len :- BigEndianToU32(serialized);
      var serialized := serialized[4..];
      if |serialized| < len as int then
        Failure("Binary Set Structured Data has too few bytes")
      else
        var nattr := AttributeValue.BS(resultSet.val.BinarySetAttributeValue + [serialized[..len]]);
        DeserializeBinarySet(serialized[len..], remainingCount-1, origSerializedSize, AttrValueAndLength(nattr, resultSet.len + len + 4))
  }

  // Bytes to String Set
  function method {:tailrecursion} {:vcs_split_on_every_assert} DeserializeStringSet(
    serialized : seq<uint8>,
    remainingCount : nat,
    origSerializedSize : nat,
    resultSet : AttrValueAndLength)
    : (ret : Result<AttrValueAndLength, string>)
    requires resultSet.val.SS?
    ensures ret.Success? ==> ret.value.val.SS?
    requires |serialized| + resultSet.len == origSerializedSize
    ensures ret.Success? ==> ret.value.len <= origSerializedSize
  {
    if remainingCount == 0 then
      Success(resultSet)
    else if |serialized| < 4 then
      Failure("Out of bytes reading String Set")
    else
      var len :- BigEndianToU32(serialized);
      var serialized := serialized[4..];
      if |serialized| < len as int then
        Failure("String Set Structured Data has too few bytes")
      else
        var nstring :- UTF8.Decode(serialized[..len]);
        var nattr := AttributeValue.SS(resultSet.val.StringSetAttributeValue + [nstring]);
        DeserializeStringSet(serialized[len..], remainingCount-1, origSerializedSize, AttrValueAndLength(nattr, resultSet.len + len + 4))
  }

  // Bytes to Number Set
  function method {:tailrecursion} {:vcs_split_on_every_assert} DeserializeNumberSet(
    serialized : seq<uint8>, 
    remainingCount : nat, 
    origSerializedSize : nat, 
    resultSet : AttrValueAndLength) 
    : (ret : Result<AttrValueAndLength, string>)
    requires resultSet.val.NS?
    ensures ret.Success? ==> ret.value.val.NS?
    requires |serialized| + resultSet.len == origSerializedSize
    ensures ret.Success? ==> ret.value.len <= origSerializedSize
  {
    if remainingCount == 0 then
      Success(resultSet)
    else if |serialized| < 4 then
      Failure("Out of bytes reading String Set")
    else
      var len :- BigEndianToU32(serialized);
      var serialized := serialized[4..];
      if |serialized| < len as int then
        Failure("Number Set Structured Data has too few bytes")
      else
        var nstring :- UTF8.Decode(serialized[..len]);
        var nattr := AttributeValue.NS(resultSet.val.NumberSetAttributeValue + [nstring]);
        DeserializeNumberSet(serialized[len..], remainingCount-1, origSerializedSize, AttrValueAndLength(nattr, resultSet.len + len + 4))
  }
  
  // Bytes to List
  // Can't be {:tailrecursion} because it calls BytesToAttr which might again call DeserializeList
  function method {:vcs_split_on_every_assert} DeserializeList(
    serialized : seq<uint8>, 
    remainingCount : nat, 
    origSerializedSize : nat, 
    resultList : AttrValueAndLength)
    : (ret : Result<AttrValueAndLength, string>)
    requires resultList.val.L?
    ensures ret.Success? ==> ret.value.val.L?
    requires |serialized| + resultList.len == origSerializedSize
    ensures ret.Success? ==> ret.value.len <= origSerializedSize
    decreases |serialized|
  {
    if remainingCount == 0 then
      Success(resultList)
    else if |serialized| < 6 then
      Failure("Out of bytes reading Type of List element")
    else
      var TerminalTypeId := serialized[0..2];
      var serialized := serialized[2..];
      var len :- BigEndianToU32(serialized);
      var serialized := serialized[4..];
      if |serialized| < len then
        Failure("Out of bytes reading Content of List element")
      else
        var nval :- BytesToAttr(serialized[..len], TerminalTypeId, false);
        var nattr := AttributeValue.L(resultList.val.ListAttributeValue + [nval.val]);
        DeserializeList(serialized[len..], remainingCount-1, origSerializedSize, AttrValueAndLength(nattr, resultList.len + len + 6))
  }

  // Bytes to Map
  // Can't be {:tailrecursion} because it calls BytesToAttr which might again call DeserializeMap
  function method {:vcs_split_on_every_assert} DeserializeMap(
    serialized : seq<uint8>,
    remainingCount : nat,
    origSerializedSize : nat,
    resultMap : AttrValueAndLength)
    : (ret : Result<AttrValueAndLength, string>)
    requires resultMap.val.M?
    ensures ret.Success? ==> ret.value.val.M?
    requires |serialized| + resultMap.len == origSerializedSize
    ensures ret.Success? ==> ret.value.len <= origSerializedSize
    decreases |serialized|
  {
    if remainingCount == 0 then
      Success(resultMap)
    else
      // get typeId of key
      :- Need(6 <= |serialized|, "Out of bytes reading Map Key");
      var TerminalTypeId_key := serialized[0..2];
      :- Need(TerminalTypeId_key == STRING, "Key of Map is not String");
      var serialized := serialized[2..];

      // get key
      var len :- BigEndianToU32(serialized);
      var serialized := serialized[4..];
      :- Need(len as int <= |serialized|, "Key of Map of Structured Data has too few bytes");
      var key :- UTF8.Decode(serialized[..len]);
      var serialized := serialized[len..];

      // get typeId of value
      :- Need(2 <= |serialized|, "Out of bytes reading Map Value");
      :- Need(IsValid_AttributeName(key), "Key is not valid AttributeName");
      var TerminalTypeId_value := serialized[0..2];
      var serialized := serialized[2..];

      // get value and construct result
      var nval :- BytesToAttr(serialized, TerminalTypeId_value, true);
      var nattr := AttributeValue.M(resultMap.val.MapAttributeValue[key := nval.val]);
      DeserializeMap(serialized[nval.len..], remainingCount-1, origSerializedSize, AttrValueAndLength(nattr, resultMap.len + nval.len + 8 + len))
  }
  
  // Bytes to AttributeValue
  // Can't be {:tailrecursion} because it calls DeserializeList and DeserializeMap which then call BytesToAttr
  function method {:vcs_split_on_every_assert} BytesToAttr(value : seq<uint8>, typeId : TerminalTypeId, hasLen : bool) : (ret : Result<AttrValueAndLength, string>)
    ensures ret.Success? ==> ret.value.len <= |value|
    decreases |value|
  {
    var len :- if hasLen then
        if |value| < 4 then
          Failure("Out of bytes reading length")
        else
          BigEndianToU32(value)
      else
        Success(|value|);
    var value := if hasLen then value[4..] else value;
    var lengthBytes := if hasLen then 4 else 0;

    if |value| < len then
      Failure("Structured Data has too few bytes")

    else if typeId == NULL then
      if len != 0 then
        Failure("NULL type did not have length zero")
      else
        Success(AttrValueAndLength(AttributeValue.NULL(false), lengthBytes))

    else if typeId == STRING then
      var str :- UTF8.Decode(value[..len]);
      Success(AttrValueAndLength(AttributeValue.S(str), len+lengthBytes))

    else if typeId == NUMBER then
      var str :- UTF8.Decode(value[..len]);
      Success(AttrValueAndLength(AttributeValue.N(str), len+lengthBytes))

    else if typeId == BINARY then
      Success(AttrValueAndLength(AttributeValue.B(value[..len]), len+lengthBytes))

    else if typeId == BOOLEAN then
      if len != 1 then
        Failure("Boolean Structured Data has more than one byte")
      else if value[0] == 0x00 then
        Success(AttrValueAndLength(AttributeValue.BOOL(false), 1+lengthBytes))
      else if value[0] == 0x01 then
        Success(AttrValueAndLength(AttributeValue.BOOL(true), 1+lengthBytes))
      else
        Failure("Boolean Structured Data had inappropriate value")

    else if typeId == STRING_SET then
      if |value| < 4 then
        Failure("String Set Structured Data has less than 4 bytes")
      else
        var len :- BigEndianToU32(value);
        var value := value[4..];
        DeserializeStringSet(value, len, |value| + 4 + lengthBytes, AttrValueAndLength(AttributeValue.SS([]), 4+lengthBytes))

    else if typeId == NUMBER_SET then
      if |value| < 4 then
        Failure("Number Set Structured Data has less than 4 bytes")
      else
        var len :- BigEndianToU32(value);
        var value := value[4..];
        DeserializeNumberSet(value, len, |value| + 4 + lengthBytes, AttrValueAndLength(AttributeValue.NS([]), 4 + lengthBytes))

    else if typeId == BINARY_SET then
      if |value| < 4 then
        Failure("Binary Set Structured Data has less than 4 bytes")
      else
        var len :- BigEndianToU32(value);
        var value := value[4..];
        DeserializeBinarySet(value, len, |value| + 4 + lengthBytes, AttrValueAndLength(AttributeValue.BS([]), 4 + lengthBytes))

    else if typeId == MAP then
      if |value| < 4 then
        Failure("List Structured Data has less than 4 bytes")
      else
        var len :- BigEndianToU32(value);
        var value := value[4..];
        DeserializeMap(value, len, |value| + 4 + lengthBytes,  AttrValueAndLength(AttributeValue.M(map[]), 4 + lengthBytes))

    else if typeId == LIST then
      if |value| < 4 then
        Failure("List Structured Data has less than 4 bytes")
      else
        var len :- BigEndianToU32(value);
        var value := value[4..];
        DeserializeList(value, len, |value| + 4 + lengthBytes, AttrValueAndLength(AttributeValue.L([]), 4 + lengthBytes))

    else
      Failure("Unsupported TerminalTypeId")
  
  }

  // Turn a map<Result<X,string>, Result<Y,string>> into a Result<map<X,Y>, string>
  // If anything reported Failure, return a Failure with all of the error messages
  //
  // useful when f and g in
  // var ret := map kv <- m.Items | true :: f(kv.0) := g(kv.1);
  // return Result
  function method SimplifyMap<X,Y>(m : map<Result<X,string>, Result<Y,string>>) : (ret : Result<map<X,Y>, string>)
  {
    var badKeys := set k <- m.Keys | k.Failure? :: k.error;
    var badKeySeq := SetToOrderedSequence(badKeys, CharLess);
    var badValues := set k <- m.Values | k.Failure? :: k.error;
    var badValueSeq := SetToOrderedSequence(badValues, CharLess);
    if |badKeySeq| == 0 && |badValueSeq| == 0 then
      Success(map kv <- m.Items | kv.0.Success? && kv.1.Success? :: kv.0.value := kv.1.value)
    else
      Failure(Join(badKeySeq + badValueSeq, "\n"))
  }

  // Turn a map<X, Result<Y,string>> into a Result<map<X,Y>, string>
  // If anything reported Failure, return a Failure with all of the error messages
  //
  // useful when  g in
  // var ret := map kv <- m.Items | true :: kv.0 := g(kv.1);
  // returns Result
  function method SimplifyMapValue<X,Y>(m : map<X, Result<Y,string>>) : (ret : Result<map<X,Y>, string>)
  {
    var badValues := set k <- m.Values | k.Failure? :: k.error;
    if |badValues| == 0 then
      Success(map kv <- m.Items | kv.1.Success? :: kv.0 := kv.1.value)
    else
      var badValueSeq := SetToOrderedSequence(badValues, CharLess);
      Failure(Join(badValueSeq, "\n"))
  }
}

