// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

/*
  Primary entry point of interest :

  ParseVirtualFieldConfig(vf : VirtualField) : VirtField

  // for a given virtual field definition, give its value for this record
  GetVirtField(vf : VirtField, item : DDB.AttributeMap) : string

*/

include "Util.dfy"
include "TermLoc.dfy"

module DdbVirtualFields {
  import opened Wrappers
  import opened StandardLibrary
  import opened StandardLibrary.UInt
  import opened AwsCryptographyDbEncryptionSdkDynamoDbTypes
  import opened DynamoDbEncryptionUtil
  import DDB = ComAmazonawsDynamodbTypes
  import Seq
  import TermLoc
  import StandardLibrary.Sequence


  function method ParseVirtualFieldConfig(vf : VirtualField) : Result<VirtField, Error>
  {
    var parts :- Sequence.MapWithResult((p : VirtualPart) => ParseVirtualPartConfig(p), vf.parts);
    Success(VirtField(vf.name, parts))
  }

  function method ParseVirtualPartConfig(part : VirtualPart) : Result<VirtPart, Error>
  {
    var loc :- TermLoc.MakeTermLoc(part.loc);
    if part.trans.None? then
      Success(VirtPart(loc, []))
    else
      Success(VirtPart(loc, part.trans.value))
  }

  type VirtualFieldMap = x : map<string, ValidVirtualField> | IsValidVirtualFieldMap(x)

  predicate IsValidVirtualFieldMap(m : map<string, VirtField>)
  {
    forall x <- m :: x == m[x].name
  }

  type Examiner = (TermLoc.TermLoc) -> bool

  type ValidVirtualField = x : VirtField | x.ValidState() witness *

  // parsed VirtualField
  datatype VirtField = VirtField (
    name : string,
    parts : seq<VirtPart>
  ) {

    // return true if exam(part) returns true for any part
    function method {:opaque} examine(exam: Examiner)
      : (ret : bool)
      ensures !ret ==> forall s <- parts :: !exam(s.loc)
    {
      Examine(parts, exam)
    }

    predicate ValidState() {true}
    function method GetFields() : seq<string>
    {
      Seq.Map((p : VirtPart) => p.loc[0].key, parts)
    }
    function method GetLocs() : set<TermLoc.TermLoc>
    {
      set p <- parts :: p.loc
    }
    predicate method HasSingleLoc(loc : TermLoc.TermLoc)
    {
      |parts| == 1 && parts[0].loc == loc
    }
  }

  // return true if exam(part) returns true for any part
  function method {:opaque} Examine(parts : seq<VirtPart>, exam : Examiner)
    : (ret : bool)
    ensures !ret ==> forall s <- parts :: !exam(s.loc)
  {
    if |parts| == 0 then
      false
    else if exam(parts[0].loc) then
      true
    else
      Examine(parts[1..], exam)
  }


  // parsed VirtualPart
  datatype VirtPart = VirtPart (
    loc : TermLoc.TermLoc,
    trans : seq<VirtualTransform>
  )

  function method Min(x : nat, y : nat) : (ret : nat)
    ensures ret <= y
  {
    if y < x then
      y
    else
      x
  }

  function method GetPrefix(s : string, length : int) : (ret : string)
    //= specification/searchable-encryption/virtual.md#getprefix-transform-initialization
    //= type=implication
    //# If length is non-negative, the GetPrefix transform MUST return the first `length` characters of the input.
    ensures 0 <= length <= |s| ==> ret == s[..length]
    //= specification/searchable-encryption/virtual.md#getprefix-transform-initialization
    //= type=implication
    //# If length is non-negative, and length exceeds the length of the string, the input string MUST be returned.
    ensures |s| < length ==> ret == s
    //= specification/searchable-encryption/virtual.md#getprefix-transform-initialization
    //= type=implication
    //# If length is negative, then the GetPrefix transform MUST return
    //# all but the last `-length` character of the input.
    ensures length < 0 && 0 <= -length <= |s| ==> ret == s[..|s| + length]
    //= specification/searchable-encryption/virtual.md#getprefix-transform-initialization
    //= type=implication
    //# If length is negative and -length exceeds the length on the input,
    //# the empty string MUST be returned.
    ensures length < 0 && |s| < -length ==> ret == ""
  {
    if length >= 0 then
      s[..Min(length, |s|)]
    else
      s[..|s| - Min(-length, |s|)]
  }

  function method GetSuffix(s : string, length : int) : (ret : string)
    //= specification/searchable-encryption/virtual.md#getsuffix-transform-initialization
    //= type=implication
    //# If length is non-negative, the GetSuffix transform MUST return the last `length` characters of the input.
    ensures 0 <= length <= |s| ==> ret == s[|s|-length..]
    //= specification/searchable-encryption/virtual.md#getsuffix-transform-initialization
    //= type=implication
    //# If length is non-negative, and length exceeds the length of the string, the input string MUST be returned.
    ensures |s| < length ==> ret == s
    //= specification/searchable-encryption/virtual.md#getsuffix-transform-initialization
    //= type=implication
    //# If length is negative, then the GetSuffix transform MUST return
    //# all but the first `-length` character of the input.
    ensures length < 0 && 0 <= -length <= |s| ==> ret == s[-length..]
    //= specification/searchable-encryption/virtual.md#getsuffix-transform-initialization
    //= type=implication
    //# If length is negative and -length exceeds the length on the input,
    //# the empty string MUST be returned.
    ensures length < 0 && |s| < -length ==> ret == ""
  {
    if length >= 0 then
      s[|s| - Min(length, |s|)..]
    else
      s[Min(-length, |s|)..]
  }

  // this returns the inclusive value
  function method GetPos(pos : int, limit : nat) : (ret : nat)
    ensures (limit == 0) || (ret < limit)
    ensures limit == 0 ==> ret == 0
    ensures 0 < limit ==>
              //= specification/searchable-encryption/virtual.md#position-definition
              //= type=implication
              //# If the position provided is positive, it MUST be the zero-based index from the start of the list.
              && (0 <= pos < limit ==> ret == pos)
              && (limit <= pos ==> ret == limit-1)
                 //= specification/searchable-encryption/virtual.md#position-definition
                 //= type=implication
                 //# If the position provided is negative, it's absolute value MUST be the
                 //# one-based index from the end of the list, that is, -1 refers to the last item in the list.
              && (0 < -pos < limit ==> ret == limit + pos)
              && (limit <= -pos ==> ret == 0)
  {
    if limit == 0 then
      0
    else if pos >= 0 then
      Min(pos, limit-1)
    else if limit + pos < 0 then
      0
    else
      limit + pos
  }

  lemma GetPosTest()
    ensures GetPos(0,5) == 0
    ensures GetPos(1,5) == 1
    ensures GetPos(2,5) == 2
    ensures GetPos(3,5) == 3
    ensures GetPos(4,5) == 4
    ensures GetPos(5,5) == 4
    ensures GetPos(-1,5) == 4
    ensures GetPos(-2,5) == 3
    ensures GetPos(-3,5) == 2
    ensures GetPos(-4,5) == 1
    ensures GetPos(-5,5) == 0
    ensures GetPos(-6,5) == 0
  {}

  function method GetSubstring(s : string, low : int, high : int) : (ret : string)
    //= specification/searchable-encryption/virtual.md#getsubstring-transform-initialization
    //= type=implication
    //# The GetSubstring transform MUST return the range of characters
    //# from low (inclusive) to high (exclusive)
    ensures
      && var lo := GetPos(low, |s|);
      && var hi := GetPos(high, |s|);
      && (lo < hi ==> ret == s[lo..hi])
      && (lo >= hi ==> ret == "")
  {
    var lo := GetPos(low, |s|);
    var hi := GetPos(high, |s|);
    if lo < hi then
      s[lo..hi]
    else
      ""
  }
  function method UpperChar(ch : char) : char
  {
    if 'a' <= ch <= 'z' then
      ch - 'a' + 'A'
    else
      ch
  }
  function method UpperCase(s : string) : (ret : string)
    //= specification/searchable-encryption/virtual.md#upper-transform-initialization
    //= type=implication
    //# The Upper transform MUST convert all ascii lowercase characters into their uppercase equivalents.
    ensures  ret == Seq.Map(c => UpperChar(c), s)
  {
    Seq.Map(c => UpperChar(c), s)
  }
  function method LowerChar(ch : char) : char
  {
    if 'A' <= ch <= 'Z' then
      ch - 'A' + 'a'
    else
      ch
  }
  function method LowerCase(s : string) : (ret : string)
    //= specification/searchable-encryption/virtual.md#lower-transform-initialization
    //= type=implication
    //# The Lower transform MUST convert all ascii uppercase characters into their lowercase equivalents.
    ensures  ret == Seq.Map(c => LowerChar(c), s)
  {
    Seq.Map(c => LowerChar(c), s)
  }

  function method GetSegment(s : string, split : char, index : int) : (ret : string)
    ensures
      && var parts := Split(s, split);
      //= specification/searchable-encryption/virtual.md#getsegment-transform-initialization
      //= type=implication
      //# If index is greater than the number of items in the list, an empty string MUST be returned.
      && (index >= |parts| || -index > |parts| ==> ret == "")
         //= specification/searchable-encryption/virtual.md#getsegment-transform-initialization
         //= type=implication
         //# The GetSegment transform MUST split the input string on the given character,
         //# and return the item in the resulting list the corresponds to the given position.
      && (index < |parts| && -index <= |parts| ==> ret == parts[GetPos(index, |parts|)])
  {
    var parts := Split(s, split);
    if index >= |parts| || -index > |parts| then
      ""
    else
      parts[GetPos(index, |parts|)]
  }

  function method GetSegments(s : string, split : char, low : int, high : int) : (ret : string)
    ensures
      //= specification/searchable-encryption/virtual.md#getsegments-transform-initialization
      //= type=implication
      //# The GetSegments transform MUST split the input string on the `split` character.
      && var parts := Split(s, split);
      && var lo := GetPos(low, |parts|);
      && var hi := GetPos(high, |parts|);
      //= specification/searchable-encryption/virtual.md#getsegments-transform-initialization
      //= type=implication
      //# GetSegments MUST return the range of parts from low (inclusive) to high (exclusive),
      //# joined on the `split` character.
      && (lo < hi ==> ret == Join(parts[lo..hi], [split]))
         //= specification/searchable-encryption/virtual.md#getsegments-transform-initialization
         //= type=implication
         //# If high is less than or equal to low, an empty string MUST be returned.
      && (lo >= hi ==> ret == "")
  {
    var parts := Split(s, split);
    var lo := GetPos(low, |parts|);
    var hi := GetPos(high, |parts|);
    if lo < hi then
      Join(parts[lo..hi], [split])
    else
      ""
  }
  function method DoTransform(t : VirtualTransform, s : string) : (ret : string)
    //= specification/searchable-encryption/virtual.md#insert-transform-initialization
    //= type=implication
    //# The Insert transform MUST append this string to its input
    ensures t.insert? ==> ret == s + t.insert.literal
  {
    match t {
      case upper(up) => UpperCase(s)
      case lower(lo) => LowerCase(s)
      case insert(ins) => s + ins.literal
      case prefix(pre) => GetPrefix(s, pre.length as int)
      case suffix(suf) => GetSuffix(s, suf.length as int)
      case substring(sub) => GetSubstring(s, sub.low as int, sub.high as int)
      case segment(seg) => GetSegment(s, seg.split[0], seg.index as int)
      case segments(seg) => GetSegments(s, seg.split[0], seg.low as int, seg.high as int)
    }
  }

  function method FullTransform(t : seq<VirtualTransform>, s : string) : string
  {
    if |t| == 0 then
      s
    else
      FullTransform(t[1..], DoTransform(t[0], s))
  }
  function method GetVirtField(vf : VirtField, item : DDB.AttributeMap) : Result<Option<string>, Error>
  {
    GetVirtField2(vf.parts, item)
  }
  function method {:tailrecursion} GetVirtField2(
    parts : seq<VirtPart>,
    item : DDB.AttributeMap,
    acc : string := ""
  )
    : (ret : Result<Option<string>, Error>)
    //= specification/searchable-encryption/virtual.md#virtual-part-initialization
    //= type=implication
    //# Evaluation MUST return no value if the location does not exist,
    //# or is not a plain string value.
    ensures ret.Success? && 0 < |parts| ==>
              && TermLoc.TermToString(parts[0].loc, item).Success?
              && (TermLoc.TermToString(parts[0].loc, item).value.None? ==> ret.value.None?)

  {
    if |parts| == 0 then
      Success(Some(acc))
    else
      var value :- TermLoc.TermToString(parts[0].loc, item);
      if value.None? then
        Success(None)
      else
        //= specification/searchable-encryption/virtual.md#virtual-part-initialization
        //# The evaluation of a Virtual Part MUST be the value of its location,
        //# which is then transformed by each Virtual Transform,
        //# in the order they are configured.
        var trans := FullTransform(parts[0].trans, value.value);
        //= specification/searchable-encryption/virtual.md#virtual-field-initialization
        //# The evaluation of a Virtual Field MUST be the concatenation of all of its parts,
        //# in the order they are configured.
        GetVirtField2(parts[1..], item, acc + trans)
  }

  function method VirtToAttr(loc : TermLoc.TermLoc, item : DDB.AttributeMap, vf : VirtualFieldMap) : Result<Option<DDB.AttributeValue>, Error>
  {
    if |loc| == 1 && loc[0].key in vf then
      var str :- GetVirtField(vf[loc[0].key], item);
      if str.None? then
        Success(None)
      else
        Success(Some(DS(str.value)))
    else
      Success(TermLoc.TermToAttr(loc, item, None))
  }

  function method VirtToBytes(loc : TermLoc.TermLoc, item : DDB.AttributeMap, vf : VirtualFieldMap) : Result<Option<Bytes>, Error>
  {
    if |loc| == 1 && loc[0].key in vf then
      var str :- GetVirtField(vf[loc[0].key], item);
      if str.None? then
        Success(None)
      else
        var ustr :- UTF8.Encode(str.value).MapFailure(e => E(e));
        Success(Some(ustr))
    else
      TermLoc.TermToBytes(loc, item)
  }

  function method VirtToString(loc : TermLoc.TermLoc, item : DDB.AttributeMap, vf : VirtualFieldMap) : Result<Option<string>, Error>
  {
    if |loc| == 1 && loc[0].key in vf then
      GetVirtField(vf[loc[0].key], item)
    else
      TermLoc.TermToString(loc, item)
  }

  // convert string to DynamoDB Attribute
  function method DS(s : string)
    : DDB.AttributeValue
  {
    DDB.AttributeValue.S(s)
  }
}
