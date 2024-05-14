// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "../Model/AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.dfy"
include "Util.dfy"

// The only entry point currently used is SimpleCanon
// which converts a top level terminal to its canonical form

module StructuredEncryptionPaths {
  import opened Wrappers
  import opened StandardLibrary
  import opened StandardLibrary.UInt
  import opened StructuredEncryptionUtil
  import opened AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes

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

  function method {:opaque} SimpleCanon(table : GoodString, attr : GoodString)
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
    ensures s.Map? ==> |ret| == 9 + |UTF8.Encode(s.key).value|
    //= specification/structured-encryption/header.md#canonical-path
    //= type=implication
    //# For Structured Data in Structured Data Lists, this MUST be a 0x23 byte (# in UTF-8), followed by the numerical index.
    ensures s.List? ==> ret == [ARRAY_TAG] + UInt64ToSeq(s.pos as uint64)
    ensures s.List? ==> |ret| == 9
  {
    match s {
      case Map(key) => [MAP_TAG] + UInt64ToSeq(|key| as uint64) + UTF8.Encode(key).value
      case List(pos) => [ARRAY_TAG] + UInt64ToSeq(pos)
    }
  }

  // get the Canonical Path for these Selectors
  function method {:tailrecursion} MakeCanonicalPath(src : SelectorList)
    : (ret : CanonicalPath)
    ensures |src| == 0 ==> ret == []
    ensures |src| == 1 ==> ret == CanonicalPart(src[0])
  {
    if |src| == 0 then
      []
    else
      CanonicalPart(src[0]) + MakeCanonicalPath(src[1..])
  }

  // End code, begin lemmas.
  // The only useful ones are SimpleCanonUnique and FullPathUnique
  // The others are here to prove those
  // SimpleCanon and SimpleCanonUnique should be retired


  // x != y ==> x.canonicalPath != y.canonicalPath, so we can map with it
  lemma FullPathUnique(table : GoodString)
    ensures forall x : TerminalLocation, y : TerminalLocation
              :: x != y ==> x.canonicalPath(table) != y.canonicalPath(table)
  {
    forall x : TerminalLocation, y : TerminalLocation
      ensures x != y ==> x.canonicalPath(table) != y.canonicalPath(table) {
      if x != y {
        FullPathUnique2(table, x, y);
      }
    }
  }

  lemma FullPathUnique2(table : GoodString, x : TerminalLocation, y : TerminalLocation)
    requires x != y
    ensures x.canonicalPath(table) != y.canonicalPath(table)
  {
    PathUnique2(x.parts, y.parts);
    var cpX := x.canonicalPath(table);
    var cpY := y.canonicalPath(table);
    var tableName := UTF8.Encode(table).value;
    assert tableName < cpX;
    assert tableName < cpY;
    if |x.parts| == |y.parts| {
      var prefix := tableName + UInt64ToSeq(|x.parts| as uint64);
      assert cpX == prefix + MakeCanonicalPath(x.parts);
      assert cpY == prefix + MakeCanonicalPath(y.parts);
      PathUnique2(x.parts, y.parts);
      OnePlusOne(prefix, MakeCanonicalPath(x.parts), MakeCanonicalPath(y.parts));
      assert cpX != cpY;
    } else {
      assert UInt64ToSeq(|x.parts| as uint64) != UInt64ToSeq(|y.parts| as uint64);
      assert (tableName + UInt64ToSeq(|x.parts| as uint64)) < cpX;
      assert (tableName + UInt64ToSeq(|y.parts| as uint64)) < cpY;
      OnePlusOne(tableName, UInt64ToSeq(|x.parts| as uint64), UInt64ToSeq(|y.parts| as uint64));
      assert (tableName + UInt64ToSeq(|x.parts| as uint64)) != (tableName + UInt64ToSeq(|y.parts| as uint64));
      assert cpX != cpY;
    }
  }

  // x != y ==> MakeCanonicalPath(x) != MakeCanonicalPath(y), so we can map with it
  lemma PathUnique()
    ensures forall x : SelectorList, y : SelectorList
              :: x != y ==> MakeCanonicalPath(x) != MakeCanonicalPath(y)
  {
    forall x : SelectorList, y : SelectorList
      ensures x != y ==> MakeCanonicalPath(x) != MakeCanonicalPath(y) {
      if x != y {
        PathUnique2(x, y);
      }
    }
  }

  lemma PathUnique2(x : SelectorList, y : SelectorList)
    requires x != y
    ensures MakeCanonicalPath(x) != MakeCanonicalPath(y)
  {
    if |x| == 0 || |y| == 0 {

    } else if x[0] != y[0] {
      CanonicalPartMapUnique(x[0], y[0]);
      assert CanonicalPart(x[0]) != CanonicalPart(y[0]);
      SelectorNeverPrefix(x[0], y[0]);
      assert CanonicalPart(x[0]) <= MakeCanonicalPath(x);
      assert CanonicalPart(y[0]) <= MakeCanonicalPath(y);
      assert MakeCanonicalPath(x) == CanonicalPart(x[0]) + MakeCanonicalPath(x[1..]);
      assert MakeCanonicalPath(y) == CanonicalPart(y[0]) + MakeCanonicalPath(y[1..]);
      assert MakeCanonicalPath(x) != MakeCanonicalPath(y);
    } else {
      assert(x[1..] != y[1..]);
      PathUnique2(x[1..], y[1..]);
      assert CanonicalPart(x[0]) == CanonicalPart(y[0]);
      assert MakeCanonicalPath(x[1..]) != MakeCanonicalPath(y[1..]);
      OnePlusOne(CanonicalPart(x[0]), MakeCanonicalPath(x[1..]), MakeCanonicalPath(y[1..]));
      assert CanonicalPart(x[0]) + MakeCanonicalPath(x[1..]) != CanonicalPart(x[0]) + MakeCanonicalPath(y[1..]);
      assert CanonicalPart(x[0]) + MakeCanonicalPath(x[1..]) != CanonicalPart(y[0]) + MakeCanonicalPath(y[1..]);
      assert MakeCanonicalPath(x) != MakeCanonicalPath(y);
    }
  }

lemma {:axiom} Utf8EncodeIsDistributive(x: string)
    requires UTF8.Encode(x).Success?
    ensures forall head, tail | head + tail == x
      :: UTF8.Encode(head).Success?
          ==>
            && UTF8.Encode(tail).Success?
            && UTF8.Encode(head).value + UTF8.Encode(tail).value == UTF8.Encode(x).value

  // must be true for any correct UTF8 implementation
  lemma /*{:axiom}*/ Utf8EncodeUnique(x : string, y : string)
    requires UTF8.Encode(x).Success?
    requires UTF8.Encode(y).Success?
    // ensures x == y ==> UTF8.Encode(x).value == UTF8.Encode(y).value
    // ensures x != y ==> UTF8.Encode(x).value != UTF8.Encode(y).value
    // ensures x <= y ==> UTF8.Encode(x).value <= UTF8.Encode(y).value
    // ensures x <  y ==> UTF8.Encode(x).value <  UTF8.Encode(y).value
    // ensures y <= x ==> UTF8.Encode(y).value <= UTF8.Encode(x).value
    // ensures y <  x ==> UTF8.Encode(y).value <  UTF8.Encode(x).value
    ensures !(x <= y) ==> !(UTF8.Encode(x).value <= UTF8.Encode(y).value)
    // ensures !(x <  y) ==> !(UTF8.Encode(x).value <  UTF8.Encode(y).value)
    // ensures !(y <= x) ==> !(UTF8.Encode(y).value <= UTF8.Encode(x).value)
    // ensures !(y <  x) ==> !(UTF8.Encode(y).value <  UTF8.Encode(x).value)
  {
    Utf8EncodeIsDistributive(x);
    Utf8EncodeIsDistributive(y);
  }

  // // must be true for any correct UTF8 implementation
  // lemma {:axiom} Utf8DecodeUnique(x : seq<uint8>, y : seq<uint8>)
  //   requires UTF8.Decode(x).Success?
  //   requires UTF8.Decode(y).Success?
  //   ensures x == y ==> UTF8.Decode(x).value == UTF8.Decode(y).value
  //   ensures x != y ==> UTF8.Decode(x).value != UTF8.Decode(y).value
  //   ensures x <= y ==> UTF8.Decode(x).value <= UTF8.Decode(y).value
  //   ensures x <  y ==> UTF8.Decode(x).value <  UTF8.Decode(y).value
  //   ensures y <= x ==> UTF8.Decode(y).value <= UTF8.Decode(x).value
  //   ensures y <  x ==> UTF8.Decode(y).value <  UTF8.Decode(x).value
  //   ensures !(x <= y) ==> !(UTF8.Decode(x).value <= UTF8.Decode(y).value)
  //   ensures !(x <  y) ==> !(UTF8.Decode(x).value <  UTF8.Decode(y).value)
  //   ensures !(y <= x) ==> !(UTF8.Decode(y).value <= UTF8.Decode(x).value)
  //   ensures !(y <  x) ==> !(UTF8.Decode(y).value <  UTF8.Decode(x).value)

  lemma SelectorNeverPrefixMap(x : Selector, y : Selector)
    requires x != y
    requires x.Map?
    requires y.Map?
    ensures !(CanonicalPart(x) <= CanonicalPart(y))
    ensures !(CanonicalPart(y) <= CanonicalPart(x))
  {
    if |x.key| != |y.key| {
      assert CanonicalPart(x)[1..9] != CanonicalPart(y)[1..9];
    } else {
      assert |x.key| == |y.key|;
      assert x.key != y.key;
      assert !(x.key <= y.key);
      assert !(y.key <= x.key);
      Utf8EncodeUnique(x.key, y.key);
      assert !(UTF8.Encode(x.key).value <= UTF8.Encode(y.key).value);
      assert !(UTF8.Encode(y.key).value <= UTF8.Encode(x.key).value);
      assert CanonicalPart(x) == [MAP_TAG] + UInt64ToSeq(|x.key| as uint64) + UTF8.Encode(x.key).value;
      assert CanonicalPart(y) == [MAP_TAG] + UInt64ToSeq(|y.key| as uint64) + UTF8.Encode(y.key).value;
      assert CanonicalPart(x)[0..9] == CanonicalPart(y)[0..9];
    }
  }

  lemma SelectorNeverPrefixList(x : Selector, y : Selector)
    requires x != y
    requires x.List?
    requires y.List?
    ensures !(CanonicalPart(x) <= CanonicalPart(y))
    ensures !(CanonicalPart(y) <= CanonicalPart(x))
  {
    assert x.pos != y.pos;
    var cpX := CanonicalPart(x);
    var cpY := CanonicalPart(y);
    assert cpX == [ARRAY_TAG] + UInt64ToSeq(x.pos as uint64);
    assert cpY == [ARRAY_TAG] + UInt64ToSeq(y.pos as uint64);
    assert UInt64ToSeq(x.pos as uint64) != UInt64ToSeq(y.pos as uint64);
    OnePlusOne([ARRAY_TAG], UInt64ToSeq(x.pos as uint64), UInt64ToSeq(y.pos as uint64));
    assert cpX != cpY;
    assert !(cpY <= cpX);
    assert !(cpX <= cpY);
  }

  lemma SelectorNeverPrefix(x : Selector, y : Selector)
    requires x != y
    ensures !(CanonicalPart(x) <= CanonicalPart(y))
    ensures !(CanonicalPart(y) <= CanonicalPart(x))
  {
    if x.Map? && y.Map? {
      SelectorNeverPrefixMap(x, y);
    } else if x.List? && y.List? {
      SelectorNeverPrefixList(x, y);
    } else {
      assert CanonicalPart(x)[0] != CanonicalPart(y)[0];
      assert !(CanonicalPart(x) <= CanonicalPart(y));
      assert !(CanonicalPart(y) <= CanonicalPart(x));
    }
  }

  lemma CanonicalPartMapUnique(x : Selector, y : Selector)
    requires x != y
    ensures CanonicalPart(x) != CanonicalPart(y)
  {
    SelectorNeverPrefix(x, y);
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
    reveal SimpleCanon();
    FullPathUnique(table);
  }

  // x != y ==> SimpleCanon(x) != SimpleCanon(y), so we can map with it
  lemma SimpleCanonUnique(table : GoodString)
    ensures forall x : GoodString, y : GoodString :: x != y ==> SimpleCanon(table, x) != SimpleCanon(table, y)
  {
    reveal SimpleCanon();
    forall x : GoodString, y : GoodString ensures x != y ==> SimpleCanon(table, x) != SimpleCanon(table, y) {
      if x != y {
        SimpleCanonUnique2(table, x, y);
      }
    }
  }
}
