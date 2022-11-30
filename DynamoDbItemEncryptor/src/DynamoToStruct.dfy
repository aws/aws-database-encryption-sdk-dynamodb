// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "../../private-aws-encryption-sdk-dafny-staging/libraries/src/Wrappers.dfy"
include "../../private-aws-encryption-sdk-dafny-staging/StandardLibrary/src/StandardLibrary.dfy"
include "../../StructuredEncryption/Model/AwsCryptographyStructuredEncryptionTypes.dfy"
include "../../private-aws-encryption-sdk-dafny-staging/ComAmazonawsDynamodb/Model/ComAmazonawsDynamodbTypes.dfy"
include "../../private-aws-encryption-sdk-dafny-staging/StandardLibrary/src/UTF8.dfy"
include "./SetSort.dfy"

module DynamoToStruct {

  import opened ComAmazonawsDynamodbTypes
  import opened AwsCryptographyStructuredEncryptionTypes
  import opened Wrappers
  import opened StandardLibrary
  import opened StandardLibrary.UInt
  import UTF8
  import Set
  import opened Relations

/*
If you enable this code, you can remove the dependency on AwsCryptographyStructuredEncryptionTypes.dfy
And therefore have no external dependencies except UTF8.cs

 datatype StructuredData = | StructuredData (
 nameonly content: StructuredDataContent ,
 nameonly attributes: Option<StructuredDataAttributes>
 )
 type StructuredDataAttributes = map<string, StructuredDataTerminal>
 datatype StructuredDataContent =
 | Terminal(StructuredDataTerminal: StructuredDataTerminal)
 | DataList(StructuredDataList: StructuredDataList)
 | DataMap(StructuredDataMap: StructuredDataMap)
 type StructuredDataList = seq<StructuredData>
 type StructuredDataMap = map<string, StructuredData>
 datatype StructuredDataTerminal = | StructuredDataTerminal (
 nameonly value: TerminalValue ,
 nameonly typeId: TerminalTypeId
 )
 type TerminalValue = seq<uint8>
 type TerminalTypeId = x: seq<uint8> | IsValid_TerminalTerminalTypeId(x) witness *
 predicate method IsValid_TerminalTerminalTypeId(x: seq<uint8>) {
 ( 2 <= |x| <= 2 )
}
*/

  // This file exists for these five functions

/* TODO - prove the following
  StructuredToItem(ItemToStructured(itemMap)) == itemMap
  ItemToStructured(StructuredToItem(structureMap)) == structureMap
  AttrToStructured(StructuredToAttr(structure)) == structure
  StructuredToAttr(AttrToStructured(item)) == item
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
          var ret :- BytesToAttr(s.value, s.typeId, false);
          Success(ret.val)
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

  type SingleAttr = (AttributeName, seq<uint8>)

  predicate method AttrLexicographicLessOrEqual(x : SingleAttr, y : SingleAttr)
  {
    LexicographicLessOrEqual(x.0, y.0, CharLess)
  }

/*
  We know this is a total order, because LexicographicLessOrEqual on strings is a total order
  TODO - actually prove it
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
  function method AttrToBytes(a : AttributeValue, wrap : bool) : Result<seq<uint8>, string>
    decreases a
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
      case NULL(n) => Wrap(a, wrap, Success([]))
      case BOOL(b) => Wrap(a, wrap, Success([BoolToUint8(b)]))
    }
  }

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
  function method /*{:tailrecursion}*/ CollectList(b : ListAttributeValue, acc : seq<uint8> := []) : Result<seq<uint8>, string>
  {
    if |b| == 0 then
      Success(acc)
    else
      var val :- AttrToBytes(b[0], true);
      CollectList(b[1..], acc + val)
  }

  // Map to Bytes
  function method {:tailrecursion} CollectMap(b : seq<SingleAttr>, acc : seq<uint8> := []) : Result<seq<uint8>, string>
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
    if b then
      1
    else
      0
  }

  // AttributeValue with number of bytes consumed in its construction
  datatype AttrValueAndLength = AttrValueAndLength(
    val : AttributeValue,
    len : nat
  )

  // Bytes to Binary Set
  function method {:tailrecursion} {:vcs_split_on_every_assert}  GetBinarySet(value : seq<uint8>, items : nat, orig : nat, extra : nat, acc : AttrValueAndLength := AttrValueAndLength(AttributeValue.BS([]), extra)) : (ret : Result<AttrValueAndLength, string>)
    requires acc.val.BS?
    ensures ret.Success? ==> ret.value.val.BS?
    requires |value| + acc.len == orig + extra
    ensures ret.Success? ==> ret.value.len <= orig + extra
  {
    if items == 0 then
      Success(acc)
    else if |value| < 4 then
      Failure("Out of bytes reading Binary Set")
    else
      var len :- BigEndianToU32(value);
      var value := value[4..];
      if |value| < len as int then
        Failure("Binary Set Structured Data has too few bytes")
      else
        var nattr := AttributeValue.BS(acc.val.BinarySetAttributeValue + [value[..len]]);
        GetBinarySet(value[len..], items-1, orig, extra, AttrValueAndLength(nattr, acc.len + len + 4))
  }

  // Bytes to String Set
  function method {:tailrecursion} {:vcs_split_on_every_assert} GetStringSet(value : seq<uint8>, items : nat, orig : nat, extra : nat, acc : AttrValueAndLength := AttrValueAndLength(AttributeValue.SS([]), extra)) : (ret : Result<AttrValueAndLength, string>)
    requires acc.val.SS?
    ensures ret.Success? ==> ret.value.val.SS?
    requires |value| + acc.len == orig + extra
    ensures ret.Success? ==> ret.value.len <= orig + extra
  {
    if items == 0 then
      Success(acc)
    else if |value| < 4 then
      Failure("Out of bytes reading String Set")
    else
      var len :- BigEndianToU32(value);
      var value := value[4..];
      if |value| < len as int then
        Failure("String Set Structured Data has too few bytes")
      else
        var nstring :- UTF8.Decode(value[..len]);
        //var nstring := "";
        var nattr := AttributeValue.SS(acc.val.StringSetAttributeValue + [nstring]);
        GetStringSet(value[len..], items-1, orig, extra, AttrValueAndLength(nattr, acc.len + len + 4))
  }

  // Bytes to Number Set
  function method {:tailrecursion} {:vcs_split_on_every_assert} GetNumberSet(value : seq<uint8>, items : nat, orig : nat, extra : nat, acc : AttrValueAndLength := AttrValueAndLength(AttributeValue.NS([]), extra)) : (ret : Result<AttrValueAndLength, string>)
    requires acc.val.NS?
    ensures ret.Success? ==> ret.value.val.NS?
    requires |value| + acc.len == orig + extra
    ensures ret.Success? ==> ret.value.len <= orig + extra
  {
    if items == 0 then
      Success(acc)
    else if |value| < 4 then
      Failure("Out of bytes reading String Set")
    else
      var len :- BigEndianToU32(value);
      var value := value[4..];
      if |value| < len as int then
        Failure("Number Set Structured Data has too few bytes")
      else
        var nstring :- UTF8.Decode(value[..len]);
        //var nstring := "";
        var nattr := AttributeValue.NS(acc.val.NumberSetAttributeValue + [nstring]);
        GetNumberSet(value[len..], items-1, orig, extra, AttrValueAndLength(nattr, acc.len + len + 4))
  }
  
  // Bytes to List
  function method {:vcs_split_on_every_assert} GetList(value : seq<uint8>, items : nat, orig : nat, extra : nat, acc : AttrValueAndLength := AttrValueAndLength(AttributeValue.L([]), extra)) : (ret : Result<AttrValueAndLength, string>)
    requires acc.val.L?
    ensures ret.Success? ==> ret.value.val.L?
    requires |value| + acc.len == orig + extra
    ensures ret.Success? ==> ret.value.len <= orig + extra
    decreases |value|
  {
    if items == 0 then
      Success(acc)
    else if |value| < 6 then
      Failure("Out of bytes reading Type of List element")
    else
      var TerminalTypeId := value[0..2];
      var value := value[2..];
      var len :- BigEndianToU32(value);
      var value := value[4..];
      if |value| < len then
        Failure("Out of bytes reading Content of List element")
      else
        var nval :- BytesToAttr(value[..len], TerminalTypeId, false);
        var nattr := AttributeValue.L(acc.val.ListAttributeValue + [nval.val]);
        GetList(value[len..], items-1, orig, extra, AttrValueAndLength(nattr, acc.len + len + 6))
  }

  // Bytes to Map
  function method /*{:tailrecursion}*/ {:vcs_split_on_every_assert} GetMap(value : seq<uint8>, items : nat, orig : nat, extra : nat, acc : AttrValueAndLength := AttrValueAndLength(AttributeValue.M(map[]), extra)) : (ret : Result<AttrValueAndLength, string>)
    requires acc.val.M?
    ensures ret.Success? ==> ret.value.val.M?
    requires |value| + acc.len == orig + extra
    ensures ret.Success? ==> ret.value.len <= orig + extra
    decreases |value|
  {
    if items == 0 then
      Success(acc)
    else if |value| < 2 then
      Failure("Out of bytes reading Map Key")
    else
      var TerminalTypeId_key := value[0..2];
      if TerminalTypeId_key != STRING then
        Failure("Key of Map is not String")
      else
        var value := value[2..];
        if |value| < 4 then
          Failure("Key of Map of Structured Data has too few bytes")
        else
          var len :- BigEndianToU32(value);
          var value := value[4..];
          if |value| < len as int then
            Failure("Key of Map of Structured Data has too few bytes")
          else
            var nkey :- UTF8.Decode(value[..len]);
            var value := value[len..];
            if |value| < 2 then
              Failure("Out of bytes reading Map Value")
            else if !IsValid_AttributeName(nkey) then
              Failure("Key is not valid AttributeName")
            else
              var TerminalTypeId_value := value[0..2];
              var value := value[2..];
              var nval :- BytesToAttr(value, TerminalTypeId_value, true);
              var nattr := AttributeValue.M(acc.val.MapAttributeValue[nkey := nval.val]);
              GetMap(value[nval.len..], items-1, orig, extra, AttrValueAndLength(nattr, acc.len + nval.len + 8 + len))
  }
  
  // Bytes to AttributeValue
  function method {:vcs_split_on_every_assert} BytesToAttr(value : seq<uint8>, TerminalTypeId : TerminalTypeId, hasLen : bool) : (ret : Result<AttrValueAndLength, string>)
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
    var value := if hasLen then
        value[4..]
      else
        value;
    var lengthBytes := if hasLen then
        4
      else
        0;

    if |value| < len then
      Failure("Structured Data has too few bytes")

    else if TerminalTypeId == NULL then
      if len != 0 then
        Failure("NULL type did not have length zero")
      else
        Success(AttrValueAndLength(AttributeValue.NULL(false), lengthBytes))

    else if TerminalTypeId == STRING then
      var str :- UTF8.Decode(value[..len]);
      Success(AttrValueAndLength(AttributeValue.S(str), len+lengthBytes))

    else if TerminalTypeId == NUMBER then
      var str :- UTF8.Decode(value[..len]);
      Success(AttrValueAndLength(AttributeValue.N(str), len+lengthBytes))

    else if TerminalTypeId == BINARY then
      Success(AttrValueAndLength(AttributeValue.B(value[..len]), len+lengthBytes))

    else if TerminalTypeId == BOOLEAN then
      if len != 1 then
        Failure("Boolean Structured Data has more than one byte")
      else if value[0] == 0x00 then
        Success(AttrValueAndLength(AttributeValue.BOOL(false), 1+lengthBytes))
      else if value[0] == 0x01 then
        Success(AttrValueAndLength(AttributeValue.BOOL(true), 1+lengthBytes))
      else
        Failure("Boolean Structured Data had inappropriate value")

    else if TerminalTypeId == STRING_SET then
      if |value| < 4 then
        Failure("String Set Structured Data has less than 4 bytes")
      else
        var len :- BigEndianToU32(value);
        var value := value[4..];
        GetStringSet(value, len, |value|, 4+lengthBytes)

    else if TerminalTypeId == NUMBER_SET then
      if |value| < 4 then
        Failure("Number Set Structured Data has less than 4 bytes")
      else
        var len :- BigEndianToU32(value);
        var value := value[4..];
        GetNumberSet(value, len, |value|, 4+lengthBytes)

    else if TerminalTypeId == BINARY_SET then
      if |value| < 4 then
        Failure("Binary Set Structured Data has less than 4 bytes")
      else
        var len :- BigEndianToU32(value);
        var value := value[4..];
        GetBinarySet(value, len, |value|, 4+lengthBytes)

    else if TerminalTypeId == MAP then
      if |value| < 4 then
        Failure("List Structured Data has less than 4 bytes")
      else
        var len :- BigEndianToU32(value);
        var value := value[4..];
        GetMap(value, len, |value|, 4 + lengthBytes)

    else if TerminalTypeId == LIST then
      if |value| < 4 then
        Failure("List Structured Data has less than 4 bytes")
      else
        var len :- BigEndianToU32(value);
        var value := value[4..];
        GetList(value, len, |value|, 4 + lengthBytes)

    else
      Failure("Unsupported TerminalTypeId")
  }
  
  predicate method CharLess(x : char, y : char)
  {
    x < y
  }

  // Turn a map<Result<X,string>, Result<Y,string>> into a Result<map<X,Y>, string>
  // If anything reported Failure, return a Failure with all of the error messages
  //
  // useful when f and g in
  // var ret := map kv <- m.Items | true :: f(kv.0) := g(kv.1);
  // return Result
  function method SimplifyMap<X,Y>(m : map<Result<X,string>, Result<Y,string>>) : Result<map<X,Y>, string>
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
  function method SimplifyMapValue<X,Y>(m : map<X, Result<Y,string>>) : Result<map<X,Y>, string>
  {
    var badValues := set k <- m.Values | k.Failure? :: k.error;
    var badValueSeq := SetToOrderedSequence(badValues, CharLess);
    if |badValueSeq| == 0 then
      Success(map kv <- m.Items | kv.1.Success? :: kv.0 := kv.1.value)
    else
      Failure(Join(badValueSeq, "\n"))
  }
}

