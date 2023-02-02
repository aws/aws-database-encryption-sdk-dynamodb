// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "../Model/AwsCryptographyStructuredEncryptionTypes.dfy"

// The only entry point currently used is SimpleCanon
// which converts a top level terminal to its canonical form

module Paths {
  import opened Wrappers
  import opened StandardLibrary
  import opened StandardLibrary.UInt
  import UTF8

  type Bytes = seq<uint8>
  type GoodString = x : string | ValidString(x)
  predicate method ValidString(x : string)
  {
    && |x| <  UINT64_LIMIT
    && UTF8.Encode(x).Success?
  }

  datatype Selector =
    | List(pos : uint64)
    | Map(key : GoodString)
    | Attr(key : GoodString)

  type SelectorList = x : seq<Selector> | |x| < UINT64_LIMIT

  // a specific part of a structure
  datatype TerminalLocation = TerminalLocation (
    parts : SelectorList
  )
  {
    // Return the Canonical Path for this part of an item in this table
    function method canonicalPath(table : GoodString)
      : (ret : Bytes)
      requires 0 < |parts|
      ensures ret ==
          //= specification/structured-encryption/header.md#canoncial-path
          //= type=implication
          //# The canoncial path MUST start with the UTF8 encoded table name.
          UTF8.Encode(table).value
          //= specification/structured-encryption/header.md#canoncial-path
          //= type=implication
          //# This MUST be followed by the depth of the Terminal within Structured Data.
        + UInt64ToSeq(|parts| as uint64)
          //= specification/structured-encryption/header.md#canoncial-path
          //= type=implication
          //# This MUST be followed by the encoding for each Structured Data in the path, including the Terminal itself.
        + CanonicalPath(parts)
    {
      var tableName := UTF8.Encode(table).value;
      var depth := UInt64ToSeq(|parts| as uint64);
      var path := CanonicalPath(parts);
      tableName + depth + path
    }
  }

  // return the number of characters until the next part begins
  // that is, '[' or '.'
  function method  {:opaque} FindStartOfNext(s : string)
    : (index : Option<nat>)
    ensures index.Some? ==> 
      && index.value < |s|
      && (s[index.value] == '.' || s[index.value] == '[')
      && '.' !in s[..index.value]
      && '[' !in s[..index.value]
    ensures index.None? ==> '.' !in s && '[' !in s
  {
    var dot := FindIndexMatching(s, '.', 0);
    var bracket := FindIndexMatching(s, '[', 0);
    if dot.None? && bracket.None? then
      None
    else if dot.Some? && bracket.Some? then
      if dot.value < bracket.value then
        dot
      else
        bracket
    else if dot.Some? then
      dot
    else
      bracket
  }

  // read an unsigned decomal number, return value and length
  function method {:tailrecursion} {:opaque} GetNumber(s : string, acc : nat := 0)
    : Result<nat, string>
  {
    if |s| == 0 then
      Success(acc)
    else if '0' <= s[0] <= '9' then
      GetNumber(s[1..], acc * 10 + s[0] as nat - '0' as nat)
    else
      Failure("Unexpected character in number : " + [s[0]])
  }

  // make Map from string
  function method  {:opaque} MakeMap(s : string) : (ret : Result<Selector, string>)
    ensures ret.Success? ==> ret.value.Map?
  {
    :- Need(ValidString(s), "Key string invalid.");
    Success(Map(s))
  }

  // convert string to Selector
  function method {:opaque} GetSelector(s : string)
    : Result<Selector, string>
    requires |s| > 0 && (s[0] == '.' || s[0] == '[')
  {
    if s[0] == '.' then
      var m :- MakeMap(s[1..]);
      Success(m)
    else
      if s[|s|-1] != ']' then
        Failure("List index must end with ]")
      else
        var num :- GetNumber(s[1..|s|-1]);
        :- Need(num < UINT64_LIMIT, "Array selector exceeds maximum.");
        Success(List(num as uint64))
  }

  // convert string to SelectorList
  function method {:tailrecusrion} {:opaque} GetSelectors(s : string, acc : SelectorList := [])
    : Result<SelectorList, string>
    requires |s| > 0 && (s[0] == '.' || s[0] == '[')
  {
    var pos := FindStartOfNext(s[1..]);
    var end := if pos.None? then |s| else pos.value + 1;
    var sel : Selector :- GetSelector(s[..end]);
    :- Need(|acc|+1 < UINT64_LIMIT, "Selector Overflow");
    if pos.None? then
      Success(acc + [sel])
    else
      GetSelectors(s[end..], acc + [sel])
  }

  // convert string to TerminalLocation
  function method {:opaque} MakeTerminalLocation(s : string)
    : (ret : Result<TerminalLocation, string>)
    ensures ret.Success? ==> 0 < |ret.value.parts|
  {
    :- Need(0 < |s|, "Path specification must not be empty.");
    var pos := FindStartOfNext(s);
    if pos.None? then
      var m :- MakeMap(s);
      Success(TerminalLocation([m]))
    else
      var name := s[..pos.value];
      var selectors :- GetSelectors(s[pos.value..]);
      var m :- MakeMap(name);
      :- Need(|selectors|+1 < UINT64_LIMIT, "Selector Overflow");
      Success(TerminalLocation([m] + selectors))
  }

  // make TerminalLocation from single top level attribute
  function method SimpleTerminalLocation(s : string)
    : (ret : Result<TerminalLocation, string>)
    ensures ret.Success? ==> 0 < |ret.value.parts|
  {
    var m :- MakeMap(s);
    Success(TerminalLocation([m]))
  }

  function method SimpleCanon(table : GoodString, attr : GoodString)
    : Bytes
  {
    TerminalLocation([Map(attr)]).canonicalPath(table)
  }

  const ARRAY_TAG : uint8 := '#' as uint8
  const MAP_TAG   : uint8 := '$' as uint8
  const ATTR_TAG  : uint8 := '@' as uint8

  // get the Canonical Path fragment for this Selector
  function method CanonicalPart(s : Selector)
    : (ret : Bytes)
    //= specification/structured-encryption/header.md#canoncial-path
    //= type=implication
    //# For Structured Data in Structured Data Maps, this MUST be a 0x24 byte ($ in UTF-8),
    //# followed by the length of the key, followed by the key as a UTF8 string.
    ensures s.Map? ==> ret == [MAP_TAG] + UInt64ToSeq(|s.key| as uint64) + UTF8.Encode(s.key).value
    //= specification/structured-encryption/header.md#canoncial-path
    //= type=implication
    //# For Attributes on Structured Data, this MUST be a 0x40 byte (@ in UTF-8),
    //# followed by the length of the key, followed by the key as a UTF8 string.
    ensures s.Attr? ==> ret == [ATTR_TAG] + UInt64ToSeq(|s.key| as uint64) + UTF8.Encode(s.key).value
    //= specification/structured-encryption/header.md#canoncial-path
    //= type=implication
    //# For Structured Data in Structured Data Lists, this MUST be a 0x23 byte (# in UTF-8), followed by the numerical index.
    ensures s.List? ==> ret == [ARRAY_TAG] + UInt64ToSeq(s.pos as uint64)
  {
    match s {
      case Map(key) => [MAP_TAG] + UInt64ToSeq(|key| as uint64) + UTF8.Encode(key).value
      case Attr(key) => [ATTR_TAG] + UInt64ToSeq(|key| as uint64) + UTF8.Encode(key).value
      case List(pos) => [ARRAY_TAG] + UInt64ToSeq(pos)
    }
  }

  // get the Canonical Path for these Selectors
  function method {:tailrecursion} CanonicalPath(src : SelectorList)
   : Bytes
  {
    if |src| == 0 then
      []
    else
      CanonicalPart(src[0]) + CanonicalPath(src[1..])
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
    ensures CanonicalPath(src) == CanonicalPart(src[0])
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