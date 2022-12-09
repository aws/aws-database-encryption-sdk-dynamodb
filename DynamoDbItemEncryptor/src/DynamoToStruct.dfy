// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "../Model/AwsCryptographyDynamoDbItemEncryptorTypes.dfy"
include "./SetSort.dfy"

module DynamoToStruct {

  import AwsCryptographyDynamoDbItemEncryptorTypes
  import opened ComAmazonawsDynamodbTypes
  import opened AwsCryptographyStructuredEncryptionTypes
  import opened Wrappers
  import opened StandardLibrary
  import opened StandardLibrary.UInt
  import UTF8
  import Set
  import opened Seq.MergeSort
  import opened Relations

  type Error = AwsCryptographyDynamoDbItemEncryptorTypes.Error

  // This file exists for these two functions

/* TODO - prove the following
  StructuredToItem(ItemToStructured(itemMap)) == itemMap
  ItemToStructured(StructuredToItem(structureMap)) == structureMap
  AttrToStructured(StructuredToAttr(structure)) == structure
  StructuredToAttr(AttrToStructured(item)) == item

  Also prove : "there exists a single canonical serialization of items that contains a set or map (i.e. there is a canonical ordering or set entries)"
*/


  function method {:opaque} ItemToStructured(item : AttributeMap) : (ret : Result<StructuredDataMap, Error>)
    ensures ret.Success? ==> ret.value.Keys == item.Keys;
  {
    var structuredMap := map kv <- item.Items | true :: kv.0 := AttrToStructured(kv.1);
    MapKeysMatchItems(item);
    MapError(SimplifyMapValue(structuredMap))
  }

  function method {:opaque} StructuredToItem(s : StructuredDataMap) : (ret : Result<AttributeMap, Error>)
      ensures ret.Success? ==> ret.value.Keys == s.Keys;
  {
    if forall k <- s.Keys :: IsValid_AttributeName(k) then
      var structuredData := map kv <- s.Items | true :: kv.0 := StructuredToAttr(kv.1);
      MapKeysMatchItems(s);
      MapError(SimplifyMapValue(structuredData))
    else
      var badNames := set k <- s.Keys | !IsValid_AttributeName(k) :: k;
      OneBadKey(s, badNames, IsValid_AttributeName);
      var orderedAttrNames := SetToOrderedSequence(badNames, CharLess);
      var attrNameList := Join(orderedAttrNames, ",");
      MakeError("Not valid attribute names : " + attrNameList)
  }

  // everything past here is to implement those two

  function method MakeError<T>(s : string) : Result<T, Error> {
    Failure(Error.DynamoDbItemEncryptorException(message := s))
  }

  function method MapError<T>(r : Result<T, string>) : Result<T, Error> {
    if r.Success? then
      Success(r.value)
    else
      MakeError(r.error)
  }

  function method  {:opaque} TopLevelAttributeToBytes(a : AttributeValue) : Result<seq<uint8>, string>
    // We never need to prefix at the top level.
    // The Type ID is serialized separately,
    // and the Length is not needed since we are
    // working with the exact set of bytes when we
    // need to deserialize.
  {
    AttrToBytes(a, false)
  }

  function method  {:opaque} AttrToStructured(item : AttributeValue) : Result<StructuredData, string>
  {
    var body :- TopLevelAttributeToBytes(item);
    Success(StructuredData(content := Terminal(StructuredDataTerminal(value := body, typeId := AttrToTypeId(item))), attributes := None))
  }

  function method  {:opaque} StructuredToAttr(s : StructuredData) : Result<AttributeValue, string>
  {
    match s.content {
      case Terminal(s) => 
        :- Need(|s.typeId| == 2, "Type ID must be two bytes");
        var attrValueAndLength :- BytesToAttr(s.value, s.typeId, false);
        :- Need(attrValueAndLength.len == |s.value|, "Mismatch between length of encoded data and length of data");
        Success(attrValueAndLength.val)
      case _ => Failure("StructuredData to AttributeValue only works on Terminal data")
    }
  }

    const BOOL_LEN : nat := 1;   // number of bytes in an encoded boolean
    const TYPEID_LEN : nat := 2;   // number of bytes in a TerminalTypeId
    const LENGTH_LEN : nat := 4; // number of bytes in an encoded count or length
    const PREFIX_LEN : nat := 6; // number of bytes in a prefix, i.e. 2-byte type and 4-byte length

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

  // convert AttributeValue to byte sequence
  // if `prefix` is true, prefix sequence with TypeID and Length
  function method AttrToBytes(a : AttributeValue, prefix : bool) : (ret : Result<seq<uint8>, string>)
    decreases a
    ensures ret.Success? && prefix ==> 6 <= |ret.value|

    //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#boolean
    //= type=implication
    //# Boolean MUST be serialized as:
    //# - `0x00` if the value is `false`
    //# - `0x01` if the value is `true`
    ensures a.BOOL? && !prefix ==>
      && (a.BooleanAttributeValue  ==> ret.Success? && |ret.value| == BOOL_LEN && ret.value[0] == 1)
      && (!a.BooleanAttributeValue ==> ret.Success? && |ret.value| == BOOL_LEN && ret.value[0] == 0)
    ensures a.BOOL? && prefix ==>
      && (a.BooleanAttributeValue  ==> ret.Success? && |ret.value| == PREFIX_LEN+BOOL_LEN && ret.value[PREFIX_LEN] == 1
          && ret.value[0..TYPEID_LEN] == BOOLEAN && ret.value[TYPEID_LEN..PREFIX_LEN] == [0,0,0,1])
      && (!a.BooleanAttributeValue ==> ret.Success? && |ret.value| == PREFIX_LEN+BOOL_LEN && ret.value[PREFIX_LEN] == 0
          && ret.value[0..TYPEID_LEN] == BOOLEAN && ret.value[TYPEID_LEN..PREFIX_LEN] == [0,0,0,1])

    //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#binary
    //= type=implication
    //# Binary MUST be serialized with the identity function;
    //# or more plainly, Binary Attribute Values are used as is.
    ensures a.B? && !prefix ==> ret.Success? && ret.value == a.BinaryAttributeValue
    ensures a.B? && prefix && ret.Success? ==>
      && ret.value[PREFIX_LEN..] == a.BinaryAttributeValue
      && ret.value[0..TYPEID_LEN] == BINARY
      && U32ToBigEndian(|a.BinaryAttributeValue|).Success?
      && ret.value[TYPEID_LEN..PREFIX_LEN] == U32ToBigEndian(|a.BinaryAttributeValue|).value

    //= specification/dynamodb-encryption-client/ddb-attribute-serialization.md#null
    //= type=implication
    //# Null MUST be serialized as a zero-length byte string.
    ensures a.NULL? && !prefix ==> ret.Success? && |ret.value| == 0
    ensures a.NULL? &&  prefix ==> ret.Success? && |ret.value| == PREFIX_LEN && ret.value[0..TYPEID_LEN] == NULL && ret.value[TYPEID_LEN..PREFIX_LEN] == [0,0,0,0]
  
    ensures a.S? && ret.Success? && !prefix ==> 
        UTF8.Decode(ret.value).Success? && UTF8.Decode(ret.value).value == a.StringAttributeValue
    ensures a.S? && ret.Success? && prefix ==> 
        && UTF8.Decode(ret.value[PREFIX_LEN..]).Success?
        && UTF8.Decode(ret.value[PREFIX_LEN..]).value == a.StringAttributeValue
        && ret.value[0..TYPEID_LEN] == STRING
        && UTF8.Encode(a.StringAttributeValue).Success?
        && U32ToBigEndian(|UTF8.Encode(a.StringAttributeValue).value|).Success?
        && ret.value[TYPEID_LEN..PREFIX_LEN] == U32ToBigEndian(|UTF8.Encode(a.StringAttributeValue).value|).value

    ensures a.N? && ret.Success? && !prefix ==> 
        UTF8.Decode(ret.value).Success? && UTF8.Decode(ret.value).value == a.NumberAttributeValue
    ensures a.N? && ret.Success? && prefix ==> 
        && UTF8.Decode(ret.value[PREFIX_LEN..]).Success?
        && UTF8.Decode(ret.value[PREFIX_LEN..]).value == a.NumberAttributeValue
        && ret.value[0..TYPEID_LEN] == NUMBER
        && UTF8.Encode(a.NumberAttributeValue).Success?
        && U32ToBigEndian(|UTF8.Encode(a.NumberAttributeValue).value|).Success?
        && ret.value[TYPEID_LEN..PREFIX_LEN] == U32ToBigEndian(|UTF8.Encode(a.NumberAttributeValue).value|).value

    ensures a.BS? && ret.Success? && !prefix ==>
        && U32ToBigEndian(|a.BinarySetAttributeValue|).Success?
        && |ret.value| >= LENGTH_LEN
        && ret.value[0..LENGTH_LEN] == U32ToBigEndian(|a.BinarySetAttributeValue|).value
    ensures a.BS? && ret.Success? && prefix ==>
        && U32ToBigEndian(|a.BinarySetAttributeValue|).Success?
        && |ret.value| >= PREFIX_LEN + LENGTH_LEN
        && ret.value[0..TYPEID_LEN] == BINARY_SET
        && ret.value[PREFIX_LEN..PREFIX_LEN+LENGTH_LEN] == U32ToBigEndian(|a.BinarySetAttributeValue|).value

    ensures a.SS? && ret.Success? && !prefix ==>
        && U32ToBigEndian(|a.StringSetAttributeValue|).Success?
        && |ret.value| >= LENGTH_LEN
        && ret.value[0..LENGTH_LEN] == U32ToBigEndian(|a.StringSetAttributeValue|).value
    ensures a.SS? && ret.Success? && prefix ==>
        && U32ToBigEndian(|a.StringSetAttributeValue|).Success?
        && |ret.value| >= PREFIX_LEN + LENGTH_LEN
        && ret.value[0..TYPEID_LEN] == STRING_SET
        && ret.value[PREFIX_LEN..PREFIX_LEN+LENGTH_LEN] == U32ToBigEndian(|a.StringSetAttributeValue|).value

    ensures a.NS? && ret.Success? && !prefix ==>
        && U32ToBigEndian(|a.NumberSetAttributeValue|).Success?
        && |ret.value| >= LENGTH_LEN
        && ret.value[0..LENGTH_LEN] == U32ToBigEndian(|a.NumberSetAttributeValue|).value
    ensures a.NS? && ret.Success? && prefix ==>
        && U32ToBigEndian(|a.NumberSetAttributeValue|).Success?
        && |ret.value| >= PREFIX_LEN + LENGTH_LEN
        && ret.value[0..TYPEID_LEN] == NUMBER_SET
        && ret.value[PREFIX_LEN..PREFIX_LEN+LENGTH_LEN] == U32ToBigEndian(|a.NumberSetAttributeValue|).value

    ensures a.L? && ret.Success? && !prefix ==>
        && U32ToBigEndian(|a.ListAttributeValue|).Success?
        && |ret.value| >= LENGTH_LEN
        && ret.value[0..LENGTH_LEN] == U32ToBigEndian(|a.ListAttributeValue|).value
    ensures a.L? && ret.Success? && prefix ==>
        && U32ToBigEndian(|a.ListAttributeValue|).Success?
        && |ret.value| >= PREFIX_LEN + LENGTH_LEN
        && ret.value[0..TYPEID_LEN] == LIST
        && ret.value[PREFIX_LEN..PREFIX_LEN+LENGTH_LEN] == U32ToBigEndian(|a.ListAttributeValue|).value

    ensures a.M? && ret.Success? && !prefix ==>
        && U32ToBigEndian(|a.MapAttributeValue|).Success?
        && |ret.value| >= LENGTH_LEN
        && ret.value[0..LENGTH_LEN] == U32ToBigEndian(|a.MapAttributeValue|).value
    ensures a.M? && ret.Success? && prefix ==>
        && U32ToBigEndian(|a.MapAttributeValue|).Success?
        && |ret.value| >= PREFIX_LEN + LENGTH_LEN
        && ret.value[0..TYPEID_LEN] == MAP
        && ret.value[PREFIX_LEN..PREFIX_LEN+LENGTH_LEN] == U32ToBigEndian(|a.MapAttributeValue|).value
  {
    var baseBytes :- match a {
      case S(s) => UTF8.Encode(s)
      case N(n) => UTF8.Encode(n)
      case B(b) => Success(b)
      case SS(ss) =>
        var count :- U32ToBigEndian(|ss|);
        var body :- CollectString(ss);
        Success(count + body)
      case NS(ns) =>
        var count :- U32ToBigEndian(|ns|);
        var body :- CollectString(ns);
        Success(count + body)
      case BS(bs) =>
        var count :- U32ToBigEndian(|bs|);
        var body :- CollectBinary(bs);
        Success(count + body)
      case M(m) =>
        var bytes := map kv <- m.Items | true :: kv.0 := AttrToBytes(kv.1, true);
        var bytes :- SimplifyMapValue(bytes);
        AttrLexicographicLessOrEqualIsTotal();
        var sset := Set.Sort.SortSet(bytes.Items, AttrLexicographicLessOrEqual);
        var count :- U32ToBigEndian(|m|);
        var body :- CollectMap(sset);
        Success(count + body)
     case L(l) =>
        var count :- U32ToBigEndian(|l|);
        var body :- CollectList(l);
        Success(count + body)
 
      case NULL(n) => Success([])
      case BOOL(b) => Success([BoolToUint8(b)])
    };
    if prefix then
      var len :- U32ToBigEndian(|baseBytes|);
      Success(AttrToTypeId(a) + len + baseBytes)
    else
      Success(baseBytes)
  }

  lemma BigEndianLemma()
    ensures U32ToBigEndian(3) == Success([0,0,0,3])
    ensures BigEndianToU32([0,0,0,3]) == Success(3)
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
      Failure("Lenght of 4-byte integer was less than 4")
    else
      Success(SeqToUInt32(x[..LENGTH_LEN]) as nat)
  }
  
  predicate IsSorted<T>(s: seq<T>, lessThanOrEq: (T, T) -> bool) {
    forall j, k :: 0 <= j < k < |s| ==> lessThanOrEq(s[j], s[k])
  }

  // String Set or Number Set to Bytes
  function method {:tailrecursion} CollectString(setToSerialize : StringSetAttributeValue, serialized : seq<uint8> := []) : Result<seq<uint8>, string>
  {
    if |setToSerialize| == 0 then
      Success(serialized)
    else
      var val :- UTF8.Encode(setToSerialize[0]);
      var len :- U32ToBigEndian(|val|);
      CollectString(setToSerialize[1..], serialized + len + val)
  }

  // Binary Set to Bytes
  function method {:tailrecursion} CollectBinary(setToSerialize : BinarySetAttributeValue, serialized : seq<uint8> := []) : Result<seq<uint8>, string>
  {
    if |setToSerialize| == 0 then
      Success(serialized)
    else
      var val := setToSerialize[0];
      var len :- U32ToBigEndian(|val|);
      CollectBinary(setToSerialize[1..], serialized + len + val)
  }

  // List to Bytes
  // Can't be {:tailrecursion} because it calls AttrToBytes which might again call CollectList
  function method CollectList(listToSerialize : ListAttributeValue, serialized : seq<uint8> := []) : Result<seq<uint8>, string>
  {
    if |listToSerialize| == 0 then
      Success(serialized)
    else
      var val :- AttrToBytes(listToSerialize[0], true);
      CollectList(listToSerialize[1..], serialized + val)
  }

  // Map to Bytes
  // input sequence is already serialized
  function method {:tailrecursion} CollectMap(mapToSerialize : seq<AttrNameAndSerializedValue>, serialized : seq<uint8> := []) : Result<seq<uint8>, string>
    requires IsSorted(mapToSerialize, AttrLexicographicLessOrEqual)
  {
    if |mapToSerialize| == 0 then
      Success(serialized)
    else
      var name :- UTF8.Encode(mapToSerialize[0].0);
      var len :- U32ToBigEndian(|name|);
      CollectMap(mapToSerialize[1..], serialized + STRING + len + name + mapToSerialize[0].1)
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
  function method {:tailrecursion} {:vcs_split_on_every_assert}  {:opaque} DeserializeBinarySet(
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
    else if |serialized| < LENGTH_LEN then
      Failure("Out of bytes reading Binary Set")
    else
      var len :- BigEndianToU32(serialized);
      var serialized := serialized[LENGTH_LEN..];
      if |serialized| < len as int then
        Failure("Binary Set Structured Data has too few bytes")
      else
        var nattr := AttributeValue.BS(resultSet.val.BinarySetAttributeValue + [serialized[..len]]);
        DeserializeBinarySet(serialized[len..], remainingCount-1, origSerializedSize, AttrValueAndLength(nattr, resultSet.len + len + LENGTH_LEN))
  }

  // Bytes to String Set
  function method {:tailrecursion} {:vcs_split_on_every_assert} {:opaque} DeserializeStringSet(
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
    else if |serialized| < LENGTH_LEN then
      Failure("Out of bytes reading String Set")
    else
      var len :- BigEndianToU32(serialized);
      var serialized := serialized[LENGTH_LEN..];
      if |serialized| < len as int then
        Failure("String Set Structured Data has too few bytes")
      else
        var nstring :- UTF8.Decode(serialized[..len]);
        var nattr := AttributeValue.SS(resultSet.val.StringSetAttributeValue + [nstring]);
        DeserializeStringSet(serialized[len..], remainingCount-1, origSerializedSize, AttrValueAndLength(nattr, resultSet.len + len + LENGTH_LEN))
  }

  // Bytes to Number Set
  function method {:tailrecursion} {:vcs_split_on_every_assert} {:opaque} DeserializeNumberSet(
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
    else if |serialized| < LENGTH_LEN then
      Failure("Out of bytes reading String Set")
    else
      var len :- BigEndianToU32(serialized);
      var serialized := serialized[LENGTH_LEN..];
      if |serialized| < len as int then
        Failure("Number Set Structured Data has too few bytes")
      else
        var nstring :- UTF8.Decode(serialized[..len]);
        var nattr := AttributeValue.NS(resultSet.val.NumberSetAttributeValue + [nstring]);
        DeserializeNumberSet(serialized[len..], remainingCount-1, origSerializedSize, AttrValueAndLength(nattr, resultSet.len + len + LENGTH_LEN))
  }
  
  // Bytes to List
  // Can't be {:tailrecursion} because it calls BytesToAttr which might again call DeserializeList
  function method {:vcs_split_on_every_assert} {:opaque} DeserializeList(
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
      var serialized := serialized[LENGTH_LEN..];
      if |serialized| < len then
        Failure("Out of bytes reading Content of List element")
      else
        var nval :- BytesToAttr(serialized[..len], TerminalTypeId, false);
        var nattr := AttributeValue.L(resultList.val.ListAttributeValue + [nval.val]);
        DeserializeList(serialized[len..], remainingCount-1, origSerializedSize, AttrValueAndLength(nattr, resultList.len + len + 6))
  }

  // Bytes to Map
  // Can't be {:tailrecursion} because it calls BytesToAttr which might again call DeserializeMap
  function method {:vcs_split_on_every_assert} {:opaque} DeserializeMap(
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
      var serialized := serialized[LENGTH_LEN..];
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
  function method {:vcs_split_on_every_assert} {:opaque} BytesToAttr(value : seq<uint8>, typeId : TerminalTypeId, hasLen : bool) : (ret : Result<AttrValueAndLength, string>)
    ensures ret.Success? ==> ret.value.len <= |value|
    decreases |value|
  {
    var len :- if hasLen then
        if |value| < LENGTH_LEN then
          Failure("Out of bytes reading length")
        else
          BigEndianToU32(value)
      else
        Success(|value|);
    var value := if hasLen then value[LENGTH_LEN..] else value;
    var lengthBytes := if hasLen then LENGTH_LEN else 0;

    if |value| < len then
      Failure("Structured Data has too few bytes")

    else if typeId == NULL then
      if len != 0 then
        Failure("NULL type did not have length zero")
      else
        // DynamoDB includes a boolean with the NULL
        // We arbitrarily pick false
        // NOTE : if you start with NULL(true), Decode(Encode()) will produce NULL(true)
        // and so round-trip identity is NOT preserved
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
      if len != BOOL_LEN then
        Failure("Boolean Structured Data has more than one byte")
      else if value[0] == 0x00 then
        Success(AttrValueAndLength(AttributeValue.BOOL(false), BOOL_LEN+lengthBytes))
      else if value[0] == 0x01 then
        Success(AttrValueAndLength(AttributeValue.BOOL(true), BOOL_LEN+lengthBytes))
      else
        Failure("Boolean Structured Data had inappropriate value")

    else if typeId == STRING_SET then
      if |value| < LENGTH_LEN then
        Failure("String Set Structured Data has less than LENGTH_LEN bytes")
      else
        var len :- BigEndianToU32(value);
        var value := value[LENGTH_LEN..];
        DeserializeStringSet(value, len, |value| + LENGTH_LEN + lengthBytes, AttrValueAndLength(AttributeValue.SS([]), LENGTH_LEN+lengthBytes))

    else if typeId == NUMBER_SET then
      if |value| < LENGTH_LEN then
        Failure("Number Set Structured Data has less than 4 bytes")
      else
        var len :- BigEndianToU32(value);
        var value := value[LENGTH_LEN..];
        DeserializeNumberSet(value, len, |value| + LENGTH_LEN + lengthBytes, AttrValueAndLength(AttributeValue.NS([]), LENGTH_LEN + lengthBytes))

    else if typeId == BINARY_SET then
      if |value| < LENGTH_LEN then
        Failure("Binary Set Structured Data has less than LENGTH_LEN bytes")
      else
        var len :- BigEndianToU32(value);
        var value := value[LENGTH_LEN..];
        DeserializeBinarySet(value, len, |value| + LENGTH_LEN + lengthBytes, AttrValueAndLength(AttributeValue.BS([]), LENGTH_LEN + lengthBytes))

    else if typeId == MAP then
      if |value| < LENGTH_LEN then
        Failure("List Structured Data has less than 4 bytes")
      else
        var len :- BigEndianToU32(value);
        var value := value[LENGTH_LEN..];
        DeserializeMap(value, len, |value| + LENGTH_LEN + lengthBytes,  AttrValueAndLength(AttributeValue.M(map[]), LENGTH_LEN + lengthBytes))

    else if typeId == LIST then
      if |value| < LENGTH_LEN then
        Failure("List Structured Data has less than 4 bytes")
      else
        var len :- BigEndianToU32(value);
        var value := value[LENGTH_LEN..];
        DeserializeList(value, len, |value| + LENGTH_LEN + lengthBytes, AttrValueAndLength(AttributeValue.L([]), LENGTH_LEN + lengthBytes))

    else
      Failure("Unsupported TerminalTypeId")
  
  }

  function method FlattenValueMap<X,Y>(m : map<X, Result<Y,string>>): map<X,Y> {
    map kv <- m.Items | kv.1.Success? :: kv.0 := kv.1.value
  }

  function method FlattenErrors<X,Y>(m : map<X, Result<Y,string>>): set<string> {
    set k <- m.Values | k.Failure? :: k.error
  }

  lemma OneBadReult<X,Y>(m : map<X, Result<Y,string>>)
    requires ! forall v <- m.Values :: v.Success?
    ensures exists v <- m.Values :: v.Failure?
    ensures |FlattenErrors(m)| > 0
  {
    assert exists v <- m.Values :: v.Failure?;
    var errors := FlattenErrors(m);
    assert exists v :: v in m.Values && v.Failure? && (v.error in errors);
  }

  lemma MapKeysMatchItems<X,Y>(m : map<X,Y>)
    ensures forall k :: k in m.Keys ==> (k, m[k]) in m.Items
  {}

  lemma OneBadKey<X,Y>(s : map<X,Y>, bad : set<X>, f : X -> bool)
    requires !forall k <- s.Keys :: f(k)
    requires bad == set k <- s.Keys | !f(k) :: k;
    ensures exists k <- s.Keys :: !f(k)
    ensures |bad| > 0
  {
    assert exists v :: v in bad && !f(v) && (v in bad);
  }

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
    if forall v <- m.Values :: v.Success? then
      var result := FlattenValueMap(m);
      MapKeysMatchItems(m);
      Success(result)
    else
      OneBadReult(m);
      var badValues := FlattenErrors(m);
      assert(|badValues| > 0);
      var badValueSeq := SetToOrderedSequence(badValues, CharLess);
      Failure(Join(badValueSeq, "\n"))
  }
}

