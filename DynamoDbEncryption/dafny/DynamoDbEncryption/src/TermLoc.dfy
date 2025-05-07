// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

/*
  type TermLoc is the parsed form of a TerminalLocation.

  Three entry points of interest

  // convert string to TermLoc
  MakeTermLoc(s : string) : TermLoc

  // get string from TermLoc and Item
  TermToString(t : TermLoc, item : DDB.AttributeMap) : string

  // get Bytes from TermLoc and Item
  TermToBytes(t : TermLoc, item : DDB.AttributeMap) : Bytes

*/

include "Util.dfy"
include "DynamoToStruct.dfy"

module TermLoc {
  import opened Wrappers
  import opened StandardLibrary
  import opened StandardLibrary.UInt
  import opened AwsCryptographyDbEncryptionSdkDynamoDbTypes
  import opened DynamoDbEncryptionUtil
  import opened StandardLibrary.MemoryMath
  import StandardLibrary.String
  import DDB = ComAmazonawsDynamodbTypes
  import Seq
  import DynamoToStruct

  datatype Selector =
    | List(pos : uint64)
    | Map(key : string)

  type Bytes = seq<uint8>
  type SelectorList = seq<Selector>
  //= specification/searchable-encryption/virtual.md#terminal-location
  //= type=implication
  //# A Terminal Location specification MUST be a list of one more [Segments](#segments),
  //# the first one of which must be a string index.
  type TermLoc = x : seq<Selector> | ValidTermLoc(x) witness *
  predicate method ValidTermLoc(s : seq<Selector>)
  {
    SequenceIsSafeBecauseItIsInMemory(s);
    && 0 < |s| as uint64
    && s[0 as uint32].Map?
  }

  function method TermLocToString(t : TermLoc) : string
  {
    t[0 as uint32].key + SelectorListToString(t[1 as uint32..])
  }
  function method SelectorListToString(s : SelectorList) : string
  {
    SequenceIsSafeBecauseItIsInMemory(s);
    if |s| as uint64 == 0 then
      ""
    else if s[0 as uint32].Map? then
      "." + s[0 as uint32].key + SelectorListToString(s[1 as uint32..])
    else
      "[" + String.Base10Int2String(s[0 as uint32].pos as int) + "]" + SelectorListToString(s[1 as uint32..])
  }

  // return true if item does not have the given terminal
  predicate method LacksAttribute(t : TermLoc, item : DDB.AttributeMap)
  {
    t[0 as uint32].key !in item
  }

  // return the AttributeValue for the given terminal in the given item
  function method TermToAttr(t : TermLoc, item : DDB.AttributeMap, names : Option<DDB.ExpressionAttributeNameMap>)
    : Option<DDB.AttributeValue>
  {
    if t[0 as uint32].key !in item then
      None
    else
      var res := GetTerminal(item[t[0 as uint32].key], t[1 as uint32..], names);
      if res.Success? then
        Some(res.value)
      else
        None
  }

  // return the string value for the given terminal in the given item
  function method TermToString(t : TermLoc, item : DDB.AttributeMap)
    : Result<Option<string>, Error>
  {
    var part := TermToAttr(t, item, None);
    if part.None? then
      Success(None)
    else
      var res :- AttrValueToString(part.value);
      Success(Some(res))
  }

  // return the string value for the given terminal in the given item
  function method TermToBytes(t : TermLoc, item : DDB.AttributeMap)
    : Result<Option<Bytes>, Error>
  {
    var part := TermToAttr(t, item, None);
    if part.None? then
      Success(None)
    else
      var res :- DynamoToStruct.TopLevelAttributeToBytes(part.value).MapFailure(e => E(e));
      Success(Some(res))
  }

  // return the string value for the given terminal in the given value
  function method {:tailrecursion} {:opaque} GetTerminal(
    v : DDB.AttributeValue,
    parts : seq<Selector>,
    names : Option<DDB.ExpressionAttributeNameMap>
  )
    : Result<DDB.AttributeValue, Error>
  {
    SequenceIsSafeBecauseItIsInMemory(parts);
    if |parts| as uint64 == 0 then
      Success(v)
    else
      match v {
        case S(s) => Failure(E("Found string with parts left over."))
        case N(s) => Failure(E("Found number with parts left over."))
        case B(b) => Failure(E("Found binary with parts left over."))
        case SS(s) => Failure(E("Found string set with parts left over."))
        case NS(s) => Failure(E("Found number set with parts left over."))
        case BS(s) => Failure(E("Found binary set with parts left over."))
        case BOOL(b) => Failure(E("Found boolean with parts left over."))
        case NULL(n) => Failure(E("Found null with parts left over."))
        case L(l) =>
          SequenceIsSafeBecauseItIsInMemory(l);
          if !parts[0 as uint32].List? then
            Failure(E("Tried to access list with key"))
          else if |l| as uint64 <= parts[0 as uint32].pos then
            Failure(E("Tried to access beyond the end of the list"))
          else
            GetTerminal(l[parts[0 as uint32].pos], parts[1 as uint32..], names)
        case M(m) =>
          if !parts[0 as uint32].Map? then
            Failure(E("Tried to access map with index"))
          else if parts[0 as uint32].key !in m then
            if names.Some? && parts[0 as uint32].key in names.value && names.value[parts[0 as uint32].key] in m then
              GetTerminal(m[names.value[parts[0 as uint32].key]], parts[1 as uint32..], names)
            else
              Failure(E("Tried to access " + parts[0 as uint32].key + " which is not in the map."))
          else
            GetTerminal(m[parts[0 as uint32].key], parts[1 as uint32..], names)
      }
  }

  // return the string value for the given terminal in the given value
  function method {:opaque} AttrValueToString(v : DDB.AttributeValue)
    : Result<string, Error>
  {
    match v {
      case S(s) => Success(s)
      case N(s) => Success(s)
      case B(b) => Failure(E("Can't convert Binary to string"))
      case SS(s) => Failure(E("Can't convert String Set to string."))
      case NS(s) => Failure(E("Can't convert Number Set to string."))
      case BS(s) => Failure(E("Can't convert Binary Set to string."))
      case BOOL(b) => Success(if b then "true" else "false")
      case NULL(n) => Success("null")
      case L(l) => Failure(E("Can't convert List to string."))
      case M(m) => Failure(E("Can't convert Map to string."))
    }
  }

  // return true if everything in the AttributeMap is of type string
  predicate AllStrings(item : DDB.AttributeMap) {
    forall x <- item :: item[x].S?
  }


  // return the number of characters until the next part begins
  // that is, '[' or '.'
  function method  {:opaque} FindStartOfNext(s : string)
    : (index : Option<uint64>)
    ensures index.Some? ==>
              && index.value as nat < |s|
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

  // read an unsigned decimal number, return value and length
  // error if value exceeds 2^64
  function method {:opaque} GetNumber(s : string, acc : uint64 := 0, pos : uint64 := 0)
    : Result<uint64, Error>
    requires pos as nat <= |s|
    decreases |s| - pos as nat
  {
    SequenceIsSafeBecauseItIsInMemory(s);
    if |s| as uint64 == pos then
      Success(acc)
    else if '0' <= s[0 as uint32] <= '9' then
      if acc < 0xfff_ffff_ffff_ffff then
        GetNumber(s, acc * 10 + s[0 as uint32] as uint64 - '0' as uint64, Add(pos, 1))
      else
        Failure(E("Number is too big for list index : " + s))
    else
      Failure(E("Unexpected character in number : " + [s[0 as uint32]]))
  }

  // convert string to Selector
  function method {:opaque} GetSelector(s : string)
    : (ret : Result<Selector, Error>)
    requires |s| > 0 && (s[0] == '.' || s[0] == '[')

    //= specification/searchable-encryption/virtual.md#segments
    //= type=implication
    //# A Segment MUST be one of
    //# - A literal "." followed by a field name, indicating a lookup into a Structured Data Map.
    //# - A literal "[" followed by a decimal integer followed by a literal "]",
    //# indicating an index into a  Structured Data List.
    ensures ret.Success? ==>
              && (s[0] == '.' ==> ret.value.Map?)
              && (s[0] == '[' ==> ret.value.List?)
  {
    SequenceIsSafeBecauseItIsInMemory(s);
    if s[0 as uint32] == '.' then
      Success(Map(s[1 as uint32..]))
    else
    if s[|s| as uint64 - 1] != ']' then
      Failure(E("List index must end with ]"))
    else
      var num :- GetNumber(s[1 as uint32..|s| as uint64 - 1]);
      Success(List(num))
  }

  // convert string to SelectorList
  function method {:tailrecursion} {:opaque} GetSelectors(s : string, acc : SelectorList := [])
    : Result<SelectorList, Error>
    requires |s| > 0 && (s[0] == '.' || s[0] == '[')
  {
    SequenceIsSafeBecauseItIsInMemory(s);
    var pos := FindStartOfNext(s[1 as uint32..]);
    var end := if pos.None? then |s| as uint64 else Add(pos.value, 1);
    var sel : Selector :- GetSelector(s[..end]);
    if pos.None? then
      Success(acc + [sel])
    else
      GetSelectors(s[end..], acc + [sel])
  }

  // convert string to TermLoc
  function method {:opaque} MakeTermLoc(s : string)
    : (ret : Result<TermLoc, Error>)
    ensures ret.Success? ==> 0 < |ret.value|
  {
    SequenceIsSafeBecauseItIsInMemory(s);
    :- Need(0 < |s| as uint64, E("Path specification must not be empty."));
    var pos := FindStartOfNext(s);
    if pos.None? then
      var m := Map(s);
      Success([Map(s)])
    else
      var name := s[..pos.value];
      var selectors :- GetSelectors(s[pos.value..]);
      Success([Map(name)] + selectors)
  }

  function method TermLocMap(attr : string) : TermLoc
  {
    [Map(attr)]
  }
}
