// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "../../Model/AwsCryptographyStructuredEncryptionTypes.dfy"
include "Util.dfy"

// The only entry point currently used is SimpleCanon
// which converts a top level terminal to its canonical form

module StructuredEncryptionPaths {
  import opened Wrappers
  import opened StandardLibrary
  import opened StandardLibrary.UInt
  import opened StructuredEncryptionUtil
  import opened AwsCryptographyStructuredEncryptionTypes

  datatype Selector =
    | List(pos : uint64)
    | Map(key : GoodString)

  type SelectorList = x : seq<Selector> | |x| < UINT64_LIMIT
  type TerminalSelector = x : seq<Selector> | ValidTerminalSelector(x) witness *

  predicate method ValidTerminalSelector(s : seq<Selector>)
  {
    && 0 < |s| < UINT64_LIMIT
    && s[0].Map?
  }

  //= specification/structured-encryption/virtual-field.md#stringify
  //= type=implication
  //# Stringify MUST be a a callback function that takes a Terminal Location and returns a string.
  type Stringify = (TerminalLocation) -> Result<string,string>
  type Byteify = (TerminalLocation) -> Result<Bytes,string>

  function method StringifyMap(t : TerminalLocation, m : map<string, string>) : Result<string,string>
  {
    if |t.parts| != 1 then
      Failure("Structured TerminalLocation on plain string")
    else if t.parts[0].key !in m then
      Failure(t.parts[0].key + " not in map")
    else
      Success(m[t.parts[0].key])
  }

  // a specific part of a structure
  datatype TerminalLocation = TerminalLocation (
    parts : TerminalSelector
  )
  {
    // Return the Canonical Path for this part of an item in this table
    function method canonicalPath(table : GoodString)
      : (ret : CanonicalPath)
      ensures ret ==
          //= specification/structured-encryption/header.md#canonical-path
          //= type=implication
          //# The canonical path MUST start with the UTF8 encoded table name.
          UTF8.Encode(table).value
          //= specification/structured-encryption/header.md#canonical-path
          //= type=implication
          //# This MUST be followed by the depth of the Terminal within Structured Data.
        + UInt64ToSeq(|parts| as uint64)
          //= specification/structured-encryption/header.md#canonical-path
          //= type=implication
          //# This MUST be followed by the encoding for each Structured Data in the path, including the Terminal itself.
        + MakeCanonicalPath(parts)
    {
      var tableName := UTF8.Encode(table).value;
      var depth := UInt64ToSeq(|parts| as uint64);
      var path := MakeCanonicalPath(parts);
      tableName + depth + path
    }

    predicate method isRoot()
    {
      |parts| == 1
    }
    function method getRoot() : GoodString
    {
      assert ValidTerminalSelector(parts);
      parts[0].key
    }
  }

  function method TermLocMap?(attr : string) : Result<TerminalLocation, Error>
  {
    :- Need(ValidString(attr), E("invalid string : " + attr));
    Success(TermLocMap(attr))
  }

  function method TermLocMap(attr : GoodString) : TerminalLocation
  {
    TerminalLocation([Map(attr)])
  }
  
  function method SimpleCanon(table : GoodString, attr : GoodString)
    : CanonicalPath
  {
    TermLocMap(attr).canonicalPath(table)
  }

  const ARRAY_TAG : uint8 := '#' as uint8
  const MAP_TAG   : uint8 := '$' as uint8

  // get the Canonical Path fragment for this Selector
  function method CanonicalPart(s : Selector)
    : (ret : Bytes)
    //= specification/structured-encryption/header.md#canonical-path
    //= type=implication
    //# For Structured Data in Structured Data Maps, this MUST be a 0x24 byte ($ in UTF-8),
    //# followed by the length of the key, followed by the key as a UTF8 string.
    ensures s.Map? ==> ret == [MAP_TAG] + UInt64ToSeq(|s.key| as uint64) + UTF8.Encode(s.key).value
    //= specification/structured-encryption/header.md#canonical-path
    //= type=implication
    //# For Structured Data in Structured Data Lists, this MUST be a 0x23 byte (# in UTF-8), followed by the numerical index.
    ensures s.List? ==> ret == [ARRAY_TAG] + UInt64ToSeq(s.pos as uint64)
  {
    match s {
      case Map(key) => [MAP_TAG] + UInt64ToSeq(|key| as uint64) + UTF8.Encode(key).value
      case List(pos) => [ARRAY_TAG] + UInt64ToSeq(pos)
    }
  }

  // get the Canonical Path for these Selectors
  function method {:tailrecursion} MakeCanonicalPath(src : SelectorList)
   : CanonicalPath
  {
    if |src| == 0 then
      []
    else
      CanonicalPart(src[0]) + MakeCanonicalPath(src[1..])
  }

// End code, begin lemmas. 
// The only useful one is SimpleCanonUnique
// The others are here to prove that

  lemma CanonicalPartMapUnique(x : Selector, y : Selector)
    requires x.Map?
    requires y.Map?
    requires x != y
    ensures CanonicalPart(x) != CanonicalPart(y)
  {
    assert x.key != y.key;
    assert CanonicalPart(x) == [MAP_TAG] + UInt64ToSeq(|x.key| as uint64) + UTF8.Encode(x.key).value;
    assert CanonicalPart(y) == [MAP_TAG] + UInt64ToSeq(|y.key| as uint64) + UTF8.Encode(y.key).value;
    assert UTF8.Encode(x.key).value != UTF8.Encode(y.key).value;
    if |x.key| == |y.key| {
      var prefix := [MAP_TAG] + UInt64ToSeq(|y.key| as uint64);
      assert CanonicalPart(x) == prefix + UTF8.Encode(x.key).value;
      assert CanonicalPart(y) == prefix + UTF8.Encode(y.key).value;
      OnePlusOne(prefix, UTF8.Encode(x.key).value, UTF8.Encode(y.key).value);
      assert CanonicalPart(x) != CanonicalPart(y);
    } else {
      assert UInt64ToSeq(|x.key| as uint64) != UInt64ToSeq(|y.key| as uint64);
      assert CanonicalPart(x)[1..9] == UInt64ToSeq(|x.key| as uint64);
      assert CanonicalPart(y)[1..9] == UInt64ToSeq(|y.key| as uint64);
    }
  }

  lemma OnePart(src : SelectorList)
    requires |src| == 1
    ensures MakeCanonicalPath(src) == CanonicalPart(src[0])
  {}

  lemma SubstrNE<T>(x : seq<T>, y : seq<T>, len : nat)
    requires len <= |x|
    requires len <= |y|
    requires x[len..] != y[len..]
    ensures x != y
  {}

  lemma OnePlusOne<T>(x : seq<T>, y : seq<T>, z : seq<T>)
    requires y != z
    ensures x + y != x + z
  {
    var newY := x + y;
    var newZ := x + z;
    SubstrNE(newY, newZ, |x|);
  }

  // x != y ==> SimpleCanon(x) != SimpleCanon(y), so we can map with it
  lemma SimpleCanonUnique2(table : GoodString, x : GoodString, y : GoodString)
    requires x != y
    ensures SimpleCanon(table, x) != SimpleCanon(table, y)
  {
    assert SimpleCanon(table, x) != SimpleCanon(table, y) by {
      assert TerminalLocation([Map(x)]).canonicalPath(table) != TerminalLocation([Map(y)]).canonicalPath(table) by {
        OnePart([Map(x)]);
        OnePart([Map(y)]);
        CanonicalPartMapUnique(Map(x), Map(y));
        var prefix := UTF8.Encode(table).value + UInt64ToSeq(1 as uint64);
        assert TerminalLocation([Map(x)]).canonicalPath(table) == prefix + CanonicalPart(Map(x));
        assert TerminalLocation([Map(y)]).canonicalPath(table) == prefix + CanonicalPart(Map(y));
        assert CanonicalPart(Map(x)) != CanonicalPart(Map(y));
        OnePlusOne(prefix, CanonicalPart(Map(x)), CanonicalPart(Map(y)));
        assert TerminalLocation([Map(x)]).canonicalPath(table) != TerminalLocation([Map(y)]).canonicalPath(table);
      }
    }
  }

  // x != y ==> SimpleCanon(x) != SimpleCanon(y), so we can map with it
  lemma SimpleCanonUnique(table : GoodString)
    ensures forall x : GoodString, y : GoodString :: x != y ==> SimpleCanon(table, x) != SimpleCanon(table, y)
  {
    forall x : GoodString, y : GoodString ensures x != y ==> SimpleCanon(table, x) != SimpleCanon(table, y) {
      if x != y {
        SimpleCanonUnique2(table, x, y);
      }
    }
  }
}
