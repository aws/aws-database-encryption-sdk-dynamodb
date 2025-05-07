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
  import opened DafnyLibraries

  datatype Selector =
    | List(pos : uint64)
    | Map(key : GoodString)

  type SelectorList = x : seq<Selector> | HasUint64Len(x)
  type TerminalSelector = x : seq<Selector> | ValidTerminalSelector(x) witness *

  predicate method ValidTerminalSelector(s : seq<Selector>)
  {
    && 0 < |s|
    && HasUint64Len(s)
    && s[0].Map?
  }

  function method StringToUniPath(x : string) : (ret : Path)
    ensures |ret| == 1
  {
    [member(StructureSegment(key := x))]
  }

  lemma StringToUniPathUnique()
    ensures forall x : string, y : string
              :: x != y ==> StringToUniPath(x) != StringToUniPath(y)
  {
  }

  function method UniPathToString(x : Path) : Result<string, Error>
    requires |x| == 1
  {
    Success(x[0].member.key)
  }

  predicate method ValidPath(path : Path)
  {
    && HasUint64Len(path)
    && forall x <- path :: ValidString(x.member.key)
  }

  function method CanonPath(table : GoodString, path : Path)
    : (ret : CanonicalPath)
    requires ValidPath(path)
    ensures ret ==
            //= specification/structured-encryption/header.md#canonical-path
            //= type=implication
            //# The canonical path MUST start with the UTF8 encoded table name.
            UTF8.Encode(table).value
            //= specification/structured-encryption/header.md#canonical-path
            //= type=implication
            //# This MUST be followed by the depth of the Terminal within Structured Data.
            + UInt64ToSeq(|path| as uint64)
            //= specification/structured-encryption/header.md#canonical-path
            //= type=implication
            //# This MUST be followed by the encoding for each Structured Data in the path, including the Terminal itself.
            + MakeCanonicalPath(path)
  {
    var tableName := UTF8.Encode(table).value;
    var depth := UInt64ToSeq(|path| as uint64);
    var path := MakeCanonicalPath(path);
    tableName + depth + path
  }

  function method TermLocMap?(attr : string) : Result<Path, Error>
  {
    :- Need(ValidString(attr), E("invalid string : " + attr));
    Success([member(StructureSegment(key := attr))])
  }

  function method TermLocMap(attr : GoodString) : Path
  {
    [member(StructureSegment(key := attr))]
  }

  function method {:opaque} SimpleCanon(table : GoodString, attr : GoodString)
    : CanonicalPath
  {
    CanonPath(table, TermLocMap(attr))
  }

  const ARRAY_TAG : uint8 := '#' as uint8
  const MAP_TAG   : uint8 := '$' as uint8

  // get the Canonical Path fragment for this Selector
  function method CanonicalPart(s : PathSegment)
    : (ret : Bytes)
    requires ValidString(s.member.key)
    //= specification/structured-encryption/header.md#canonical-path
    //= type=implication
    //# For Structured Data in Structured Data Maps, this MUST be a 0x24 byte ($ in UTF-8),
    //# followed by the length of the key, followed by the key as a UTF8 string.
    ensures ret == [MAP_TAG] + UInt64ToSeq(|s.member.key| as uint64) + UTF8.Encode(s.member.key).value
    ensures |ret| == 9 + |UTF8.Encode(s.member.key).value|
  {
    [MAP_TAG] + UInt64ToSeq(|s.member.key| as uint64) + UTF8.Encode(s.member.key).value
  }

  // get the Canonical Path for these Selectors
  function MakeCanonicalPath(path : Path)
    : (ret : CanonicalPath)
    requires ValidPath(path)
    ensures |path| == 0 ==> ret == []
    ensures |path| == 1 ==> ret == CanonicalPart(path[0])
  {
    if |path| == 0 then
      []
    else
      CanonicalPart(path[0]) + MakeCanonicalPath(path[1..])
  } by method {
    var result : CanonicalPath := [];
    for i := |path| downto 0
      invariant result == MakeCanonicalPath(path[i..])
    {
      result := CanonicalPart(path[i]) + result;
    }
    return result;
  }

  // get the Canonical Path for these Selectors
  // function method {:tailrecursion} MakeCanonicalPath(path : Path, pos : nat := 0, acc : CanonicalPath := [])
  //   : (ret : CanonicalPath)
  //   requires ValidPath(path)
  //   requires pos <= |path|
  //   requires pos == 0 ==> |acc| == 0
  //   requires pos == 1 ==> acc == CanonicalPart(path[0])
  //   requires acc == MakeCanonicalPathGhost(path[..pos])
  //   ensures |path| == 0 && pos == 0 ==> ret == []
  //   ensures |path| == 1 ==> ret == CanonicalPart(path[0])
  //   ensures ret == MakeCanonicalPathGhost(path)
  //   decreases |path| - pos
  // {
  //   if |path| == pos then
  //     acc
  //   else
  //     MakeCanonicalPath(path, pos+1, acc + CanonicalPart(path[pos]))
  // }

  // Does NOT guarantee a unique output for every unique input
  // e.g. ['a.b'] and ['a','b'] both return 'a.b'.
  function method PathToString(path : Path) : string
  {
    if |path| == 0 then
      ""
    else if |path| == 1 then
      path[0].member.key
    else
      path[0].member.key + "." + PathToString(path[1..])
  }

  // End code, begin lemmas.
  // The only useful ones are SimpleCanonUnique and FullPathUnique
  // The others are here to prove those
  // SimpleCanon and SimpleCanonUnique should be retired


  // x != y ==> x.canonicalPath != y.canonicalPath, so we can map with it
  lemma CanonPathUnique(table : GoodString)
    ensures forall x : Path, y : Path | ValidPath(x) && ValidPath(y)
              :: x != y ==> CanonPath(table, x) != CanonPath(table, y)
  {
    forall x : Path, y : Path | ValidPath(x) && ValidPath(y)
      ensures x != y ==> CanonPath(table, x) != CanonPath(table, y) {
      if x != y {
        CanonPathUnique2(table, x, y);
      }
    }
  }

  lemma CanonPathUnique2(table : GoodString, x : Path, y : Path)
    requires x != y
    requires ValidPath(x) && ValidPath(y)
    ensures CanonPath(table, x) != CanonPath(table, y)
  {
    PathUnique2(x, y);
    var cpX := CanonPath(table, x);
    var cpY := CanonPath(table, y);
    var tableName := UTF8.Encode(table).value;
    assert tableName < cpX;
    assert tableName < cpY;
    if |x| == |y| {
      var prefix := tableName + UInt64ToSeq(|x| as uint64);
      assert cpX == prefix + MakeCanonicalPath(x);
      assert cpY == prefix + MakeCanonicalPath(y);
      PathUnique2(x, y);
      OnePlusOne(prefix, MakeCanonicalPath(x), MakeCanonicalPath(y));
      assert cpX != cpY;
    } else {
      assert UInt64ToSeq(|x| as uint64) != UInt64ToSeq(|y| as uint64);
      assert (tableName + UInt64ToSeq(|x| as uint64)) <= cpX;
      assert (tableName + UInt64ToSeq(|y| as uint64)) <= cpY;
      OnePlusOne(tableName, UInt64ToSeq(|x| as uint64), UInt64ToSeq(|y| as uint64));
      assert (tableName + UInt64ToSeq(|x| as uint64)) != (tableName + UInt64ToSeq(|y| as uint64));
      assert cpX != cpY;
    }
  }

  // x != y ==> MakeCanonicalPath(x) != MakeCanonicalPath(y), so we can map with it
  lemma PathUnique()
    ensures forall x : Path, y : Path | ValidPath(x) && ValidPath(y)
              :: x != y ==> MakeCanonicalPath(x) != MakeCanonicalPath(y)
  {
    forall x : Path, y : Path | ValidPath(x) && ValidPath(y)
      ensures x != y ==> MakeCanonicalPath(x) != MakeCanonicalPath(y) {
      if x != y {
        PathUnique2(x, y);
      }
    }
  }

  lemma PathUnique2(x : Path, y : Path)
    requires ValidPath(x) && ValidPath(y)
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

  // must be true for any correct UTF8 implementation
  lemma {:axiom} Utf8EncodeUnique(x : string, y : string)
    requires UTF8.Encode(x).Success?
    requires UTF8.Encode(y).Success?
    ensures !(x <= y) ==> !(UTF8.Encode(x).value <= UTF8.Encode(y).value)

  lemma SelectorNeverPrefixMap(x : PathSegment, y : PathSegment)
    requires x != y
    requires ValidString(x.member.key) && ValidString(y.member.key)
    ensures !(CanonicalPart(x) <= CanonicalPart(y))
    ensures !(CanonicalPart(y) <= CanonicalPart(x))
  {
    if |x.member.key| != |y.member.key| {
      assert CanonicalPart(x)[1..9] != CanonicalPart(y)[1..9];
    } else {
      assert |x.member.key| == |y.member.key|;
      assert x.member.key != y.member.key;
      assert !(x.member.key <= y.member.key);
      assert !(y.member.key <= x.member.key);
      Utf8EncodeUnique(x.member.key, y.member.key);
      Utf8EncodeUnique(y.member.key, x.member.key);
      assert !(UTF8.Encode(x.member.key).value <= UTF8.Encode(y.member.key).value);
      assert !(UTF8.Encode(y.member.key).value <= UTF8.Encode(x.member.key).value);
      assert CanonicalPart(x) == [MAP_TAG] + UInt64ToSeq(|x.member.key| as uint64) + UTF8.Encode(x.member.key).value;
      assert CanonicalPart(y) == [MAP_TAG] + UInt64ToSeq(|y.member.key| as uint64) + UTF8.Encode(y.member.key).value;
      assert CanonicalPart(x)[0..9] == CanonicalPart(y)[0..9];
    }
  }

  lemma SelectorNeverPrefix(x : PathSegment, y : PathSegment)
    requires x != y
    requires ValidString(x.member.key) && ValidString(y.member.key)
    ensures !(CanonicalPart(x) <= CanonicalPart(y))
    ensures !(CanonicalPart(y) <= CanonicalPart(x))
  {
    SelectorNeverPrefixMap(x, y);
  }

  lemma CanonicalPartMapUnique(x : PathSegment, y : PathSegment)
    requires x != y
    requires ValidString(x.member.key) && ValidString(y.member.key)
    ensures CanonicalPart(x) != CanonicalPart(y)
  {
    SelectorNeverPrefix(x, y);
  }

  lemma OnePart(src : Path)
    requires |src| == 1
    requires ValidPath(src)
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
    CanonPathUnique(table);
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
