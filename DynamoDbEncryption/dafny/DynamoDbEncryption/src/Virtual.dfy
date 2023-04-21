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
  import opened AwsCryptographyDynamoDbEncryptionTypes
  import opened DynamoDbEncryptionUtil
  import DDB = ComAmazonawsDynamodbTypes
  import Seq
  import TermLoc


  function method ParseVirtualFieldConfig(vf : VirtualField) : Result<VirtField, Error>
  {
    var parts :- Seq.MapWithResult((p : VirtualPart) => ParseVirtualPartConfig(p), vf.parts);
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
    function method {:opaque} examine(exam: Examiner)
      : (ret : bool)
      ensures !ret ==> forall s <- parts :: !exam(s.loc)
    {
      Examine(parts, exam)
    }

    predicate method ValidState() {true}
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

  function method GetPrefix(s : string, length : int) : string
  {
    if length >= 0 then
      s[..Min(length, |s|)]
    else
      s[..|s| - Min(-length, |s|)]
  }

  function method GetSuffix(s : string, length : int) : string
  {
    if length >= 0 then
      s[|s| - Min(length, |s|)..]
    else
      s[Min(-length, |s|)..]
  }

  // this returns the inclusive value
  function method GetPos(pos : int, limit : nat) : (ret : nat)
    ensures (limit == 0) || (ret < limit)
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

  function method GetSubstring(s : string, low : int, high : int) : string
  {
    if |s| == 0 then
      ""
    else
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
  function method UpperCase(s : string) : string
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
  function method LowerCase(s : string) : string
  {
    Seq.Map(c => LowerChar(c), s)
  }
  function method GetSegment(s : string, split : char, index : int) : string
  {
    var parts := Split(s, split);
    if index >= |parts| || -index > |parts| then
      ""
    else
      parts[GetPos(index, |parts|)]
  }
  function method GetSegments(s : string, split : char, low : int, high : int) : string
  {
    var parts := Split(s, split);
    var lo := GetPos(low, |parts|);
    var hi := GetPos(high, |parts|);
    if lo < hi then
      Join(parts[lo..hi], [split])
    else
      ""
  }
  function method DoTransform(t : VirtualTransform, s : string) : string
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
    : Result<Option<string>, Error>
  {
    if |parts| == 0 then
      Success(Some(acc))
    else
      var value :- TermLoc.TermToString(parts[0].loc, item);
      if value.None? then
        Success(None)
      else
        var trans := FullTransform(parts[0].trans, value.value);
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

  /*
  // return true if item has all of the terminals necessary for field
  predicate method ValueHasNeededAttrs(field : VirtualField, item : DDB.AttributeMap)
  {
    !field.examine(t => LacksAttribute(t, item))
  }
*/
 // convert string to DynamoDB Attribute
  function method DS(s : string)
    : DDB.AttributeValue
  {
    DDB.AttributeValue.S(s)
  }
/*
  // return an AttributeMap containing all of the virtual fields for which we have the appropriate attributes
  function method {:tailrecursion} GetVirtualAttrs (
    fields : seq<VirtualField>,
    item : DDB.AttributeMap,
    acc : DDB.AttributeMap := map[])
    : (ret : Result<DDB.AttributeMap, string>)
    requires AllStrings(acc)
    ensures ret.Success? ==> AllStrings(ret.value)
  {
    if |fields| == 0 then
      Success(acc)
    else
      :- Need(DDB.IsValid_AttributeName(fields[0].name), "Virtual field name '" + fields[0].name + "' is not a valid DynamoDB Attribute Name");
      if ValueHasNeededAttrs(fields[0], item) then
        var value :- fields[0].makeString(t => TermToString(t, item));
        GetVirtualAttrs(fields[1..], item, acc[fields[0].name := DDB.AttributeValue.S(value)])
      else
        GetVirtualAttrs(fields[1..], item, acc)
  }
*/
}
