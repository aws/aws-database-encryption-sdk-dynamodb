// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../src/Paths.dfy"

module PathsTests {
  import opened Wrappers
  import opened StandardLibrary
  import opened StandardLibrary.UInt
  import opened StructuredEncryptionUtil
  import opened StructuredEncryptionPaths

  // This first part converts strings to TerminalLocations
  // It will be moved to src/Paths when we do Beacons 

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

  method {:test} TestSpecExamples() {
    var tableName : GoodString := "example_table";
    assert(ValidString("example_table"));
    var nameSrc :- expect MakeTerminalLocation("name");
    expect nameSrc.canonicalPath(tableName) == 
         UTF8.EncodeAscii("example_table")
      + [0,0,0,0,0,0,0,1] // depth
      + ['$' as uint8] // map
      + [0,0,0,0,0,0,0,4] // length
      + UTF8.EncodeAscii("name");

    var stampSrc :- expect MakeTerminalLocation("status-history[0].timestamp");
    expect stampSrc.canonicalPath(tableName) == 
        UTF8.EncodeAscii("example_table")
      + [0,0,0,0,0,0,0,3] // depth
      + ['$' as uint8] // map
      + [0,0,0,0,0,0,0,14] // length of "status-history"
      + UTF8.EncodeAscii("status-history")
      + ['#' as uint8] // array
      + [0,0,0,0,0,0,0,0] // index
      + ['$' as uint8] // map
      + [0,0,0,0,0,0,0,9] // length of "timestamp"
      + UTF8.EncodeAscii("timestamp");
  }
}