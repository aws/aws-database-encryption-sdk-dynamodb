// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

/*
  The only entry points of interest are

  // parse a string, create a VirtualField
  GetVirtualField(name : string, spec : string) : VirtualField

  // Does any part of the VirtualField have the quality?
  VirtualField.examine(Examiner) -> bool

  // Calculate a virtual field value
  VirtualField.makeString(stringify: Stringify) : string

  // a callback function, to convert a TerminalLocation to a string
  type Stringify = (TerminalLocation) -> Result<string,string>

  // a callback function, does a TerminalLocation have a quality?
  type Examiner = (TerminalLocation) -> bool
*/

include "../../Model/AwsCryptographyStructuredEncryptionTypes.dfy"
include "Paths.dfy"

module VirtualFields {
  import opened StandardLibrary
  import opened Wrappers
  import Base64
  import opened StandardLibrary.UInt
  import opened StructuredEncryptionUtil
  import opened StructuredEncryptionPaths

  datatype BaseRange = BaseRange(lo : nat, hi : nat)
  type Range = x: BaseRange  | x.lo <= x.hi witness BaseRange(0,0)

  //= specification/structured-encryption/virtual-field.md#field-modifications
  //= type=implication
  //# The following functions MUST be provided to modify strings
  //# * "Prefix" N - the first N characters (not bytes). The unmodified string if N > length.
  //# * "Suffix" N - the last N characters (not bytes). The unmodified string if N > length.
  //# * "Lower" - any ascii letters replaced with their lowercase equivalent.
  //# * "Upper" - any ascii letters replaced with their uppercase equivalent.
  //# * "Parts" Char Low High - Split the string on Char, keep only the parts Low..High inclusive.
  //# Both Low and High reduced to total parts. High is optional, and defaults to Low.
  datatype Mod = 
    | Prefix(n : nat)
    | Suffix(n : nat)
    | Lower
    | Upper
    | Parts(ch : char, range : Range)
  {
    function method {:opaque} makeString(base : string) : string
    {
      match this {
        case Prefix(n) => if |base| > n then base[0..n] else base
        case Suffix(n) => if |base| > n then base[|base|-n..] else base
        case Lower => AsciiLower(base)
        case Upper => AsciiUpper(base)
        case Parts(ch, range) =>
          var parts := Split(base, ch);
          if |parts| <= range.lo then
            ""
          else if range.lo == range.hi then
            parts[range.lo]
          else if |parts| <= range.hi then
            Join(parts[range.lo..], [ch])
          else
            Join(parts[range.lo..range.hi+1], [ch])
      }
    }
  }

  //= specification/structured-encryption/virtual-field.md#examiner
  //= type=implication
  //# Examiner MUST be a a callback function that takes a Terminal Location and returns a boolean.
  type Examiner = (TerminalLocation) -> bool

  //= specification/structured-encryption/virtual-field.md#virtual-segment
  //= type=implication
  //# A virtual segment MUST be one of
  //# - a [literal value](#literal-value)
  //# - a [value calculation](#value-calculation)
  datatype Segment =
    | Literal(val : string)
    | Calc(src : TerminalLocation, mods : seq<Mod>
  ) {
    function method {:opaque} makeString(stringify : Stringify)
      : Result<string, string>
    {
      if Literal? then
        Success(val)
      else
        var str :- stringify(src);
        Success(CalcString(str, mods))
    }

    //= specification/structured-encryption/virtual-field.md#virtualfield-examine
    //= type=implication
    //# A VirtualField MUST provide the method examine,
    //# which takes a [Examiner](#examiner) and returns a boolean.
    function method {:opaque} examine(exam : Examiner)
      : (ret : bool)
      ensures Calc? && exam(src) <==> ret
    {
      if Literal? then
        false
      else
        exam(src)
    }
  }

  datatype VirtualField = VirtualField (
    name : string,
    segments : seq<Segment>
  ) {

    //= specification/structured-encryption/virtual-field.md#virtualfield-makestring
    //= type=implication
    //# A VirtualField MUST provide the method makeString,
    //# which takes a [Stringify](#stringify) and returns a string.
    function method {:opaque} makeString(stringify: Stringify)
      : Result<string, string>
    {
      //= specification/structured-encryption/virtual-field.md#virtualfield-makestring
      //# makeString MUST calculate the virtual field as defined above,
      //# translating [terminal locations](#terminal-location) into strings
      //# with the provided [Stringify](#stringify).
      MakeString(segments, stringify)
    }
    function method {:opaque} examine(exam: Examiner)
      : (ret : bool)
      //= specification/structured-encryption/virtual-field.md#virtualfield-examine
      //= type=implication
      //# examine MUST return `true` if the [Examiner](#examiner) returns `true`
      //# for any [terminal locations](#terminal-location)] in the virtual field,
      //# and `false` otherwise.
      ensures !ret ==> forall s <- segments :: s.Literal? || !exam(s.src)
    {
      Examine(segments, exam)
    }
  }
  function method {:opaque} MakeString(segments : seq<Segment>, stringify : Stringify, acc : string := "")
    : Result<string, string>
  {
    if |segments| == 0 then
      Success(acc)
    else
      var seg :- segments[0].makeString(stringify);
      MakeString(segments[1..], stringify, acc + seg)
  }
  function method {:opaque} Examine(segments : seq<Segment>, exam : Examiner)
    : (ret : bool)
    ensures !ret ==> forall s <- segments :: s.Literal? || !exam(s.src)
  {
    if |segments| == 0 then
      false
    else if segments[0].examine(exam) then
      true
    else
      Examine(segments[1..], exam)
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

  // convert string to Selector
  function method {:opaque} GetSelector(s : string)
    : (ret : Result<Selector, string>)
    requires |s| > 0 && (s[0] == '.' || s[0] == '[')

    //= specification/structured-encryption/virtual-field.md#segments
    //= type=implication
    //# A Segment MUST be one of
    //# - A literal "." followed by a field name, indicating a lookup into a Structured Data Map.
    //# - A literal "[" followed by a decimal integer followed by a literal "]",
    //# indicating an index into a  Structured Data List.
    ensures ret.Success? ==>
      && (s[0] == '.' ==> ret.value.Map?)
      && (s[0] == '[' ==> ret.value.List?)
  {
    if s[0] == '.' then
      var m :- MakeMapSelector(s[1..]);
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
  function method {:tailrecursion} {:opaque} GetSelectors(s : string, acc : SelectorList := [])
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

  // make Map from string
  function method  {:opaque} MakeMapSelector(s : string) : (ret : Result<Selector, string>)
    ensures ret.Success? ==> ret.value.Map?
  {
    :- Need(ValidString(s), "Key string invalid.");
    Success(Map(s))
  }

  // convert string to TerminalLocation
  function method {:opaque} MakeTerminalLocation(s : string)
    : (ret : Result<TerminalLocation, string>)
    ensures ret.Success? ==> 0 < |ret.value.parts|
  {
    :- Need(0 < |s|, "Path specification must not be empty.");
    var pos := FindStartOfNext(s);
    if pos.None? then
      var m :- MakeMapSelector(s);
      Success(TerminalLocation([m]))
    else
      var name := s[..pos.value];
      var selectors :- GetSelectors(s[pos.value..]);
      var m :- MakeMapSelector(name);
      :- Need(|selectors|+1 < UINT64_LIMIT, "Selector Overflow");
      //= specification/structured-encryption/virtual-field.md#terminal-location
      //# A terminal location MUST be a field name followed by zero or more [Segments](#segments)
      Success(TerminalLocation([m] + selectors))
  }

  function method {:opaque} NeedEmpty<T>(s : T, parts : seq<Selector>)
    : Result<T, string>
  {
    if |parts| == 0 then
      Success(s)
    else
      Failure("Parts left over.")
  }


  function method {:opaque} CalcString(base : string, mods : seq<Mod>)
    : string
    decreases |mods|
  {
    if |mods| == 0 then
      base
    else
      CalcString(mods[0].makeString(base), mods[1..])
  }

  predicate method {:opaque} ValidSegments(s : seq<Segment>, prev : Option<string> := None)
  {
    if |s| == 0 then
      false
    else if s[0].Calc? then
      if |s[0].src.parts| == 1 then
        if prev.Some? && prev.value != s[0].src.parts[0].key then
          true
        else
          ValidSegments(s[1..], Some(s[0].src.parts[0].key))
      else
        true
    else
      ValidSegments(s[1..], prev)
  }

  predicate method {:opaque} ValidVirtualField(v : VirtualField)
  {
    ValidSegments(v.segments)
  }

  // read an unsigned decimal number, return value and length
  function method {:opaque} GetNumber(s : string, acc : nat := 0)
    : Result<nat, string>
  {
    if |s| == 0 then
      Success(acc)
    else if '0' <= s[0] <= '9' then
      GetNumber(s[1..], acc * 10 + s[0] as nat - '0' as nat)
    else
      Failure("Unexpected character in number : " + [s[0]])
  }

  function method {:opaque} GetOneMod(tokens : seq<string>)
    : (ret : Result<(Mod, nat), string>)
    requires |tokens| > 0
    ensures ret.Success? ==> 0 < ret.value.1 <= |tokens|
  {
    if tokens[0] == "Prefix" then
      if |tokens| < 2 then
        Failure("Prefix needs a number")
      else
        var num :- GetNumber(tokens[1]);
        Success((Prefix(num), 2))
    else if tokens[0] == "Suffix" then
      if |tokens| < 2 then
        Failure("Suffix needs a number")
      else
        var num :- GetNumber(tokens[1]);
        Success((Suffix(num), 2))
    else if tokens[0] == "Lower" then
        Success((Lower, 1))
    else if tokens[0] == "Parts" then
      if |tokens| < 3 then
        Failure("Parts needs a Char Low [High]")
      else
        :- Need(|tokens[1]| == 1, "Char in Parts must be exactly one character.");
        var lo :- GetNumber(tokens[2]);
        :- Need(lo > 0, "Low in Parts must be at least 1.");
        var hasHi := |tokens| > 3 && tokens[3] != "+" && tokens[3] != "|";
        if hasHi then
          var hi :- GetNumber(tokens[3]);
          :- Need(hi > 0, "High in Parts must be at least 1.");
          :- Need(lo <= hi, "In Parts, Low must be less than or equal to High.");
          Success((Parts(tokens[1][0], BaseRange(lo-1, hi-1)), 4))
        else
          Success((Parts(tokens[1][0], BaseRange(lo-1, lo-1)), 3))
    else
      Failure("Unexpected virtual mod : " + tokens[0])
  }

  function method {:tailrecursion} {:opaque} GetModList(tokens : seq<string>, orig : nat, segment : Segment, count : nat)
    : (ret : Result<(Segment, nat), string>)
    requires segment.Calc?
    requires |tokens| > 0
    requires count + |tokens| == orig
    ensures ret.Success? ==> 0 < ret.value.1
    ensures ret.Success? ==> ret.value.1 <= orig
  {
    if |tokens| == 0 then
      Success((segment, count))
    else
      var mod :- GetOneMod(tokens);
      var seg := Calc(segment.src, segment.mods + [mod.0]);
      if |tokens| == mod.1 then
        Success((seg, count + mod.1))
      else if tokens[mod.1] == "+" then
        Success((seg, count + mod.1 + 1))
      else if tokens[mod.1] != "|" then
        Failure("virtual segment name must be followed by | or +")
      else
        GetModList(tokens[mod.1..], orig, seg, count + mod.1)
  }

  //= specification/structured-encryption/virtual-field.md#getvirtualfield
  //= type=implication
  //# The function GetVirtualField MUST be provided, taking a name and a [virtual field definition](#virtual-field-definition) and returning a VirtualField.
  function method {:opaque} GetVirtualField(name : string, s : string)
    : Result<VirtualField, string>
  {
    var tokens := Tokenize(s);
    :- Need(0 < |tokens|, "Virtual value spec must not be empty.");
    var segments :- GetSegments(tokens);
    Success(VirtualField(name := name, segments := segments))
  }

  function method {:opaque} GetSegments(tokens : seq<string>, acc : seq<Segment> := [])
    : (ret : Result<seq<Segment>, string>)
    ensures ret.Success? ==>
      ((0 < |tokens| || 0 < |acc|) ==> 0 < |ret.value|)
  { 
    if |tokens| == 0 then
      Success(acc)
    else
      var segment :- GetSegment(tokens);
      GetSegments(tokens[segment.1..], acc + [segment.0])
  }

  function method {:opaque} GetSegment(tokens : seq<string>)
    : (ret : Result<(Segment, nat), string>)
    ensures ret.Success? ==> 0 < ret.value.1
    ensures ret.Success? ==> ret.value.1 <= |tokens|
  {
    :- Need(|tokens| > 0, "Invalid empty virtual segment.");
    :- Need(tokens[0] != "+", "virtual segment can't begin with +");
    :- Need(tokens[0] != "|", "virtual segment can't begin with |");

    if tokens[0] == "Literal" then
      :- Need(|tokens| > 1, "Literal segment needs a value");
      if |tokens| == 2 then
        Success((Literal(tokens[1]), 2))
      else
        if tokens[2] != "+" then
          Failure("Literal must be followed by +")
        else
        Success((Literal(tokens[1]), 3))
    else
      var name := tokens[0];
      if |tokens| == 1 then
        var src :- MakeTerminalLocation(name);
        Success((Calc(src, []), 1))
      else if tokens[1] == "+" then
        var src :- MakeTerminalLocation(name);
        Success((Calc(src, []), 2))
      else if tokens[1] != "|" then
        Failure("virtual segment name must be followed by |")
      else if |tokens| == 2 then
        Failure("virtual value spec must not end with a |")
      else
        var src :- MakeTerminalLocation(name);
        //= specification/structured-encryption/virtual-field.md#value-calculation
        //# A value calculation MUST be a [terminal location](#terminal-location) followed by zero or more
        //# " | " delimited Field Modifications.
        GetModList(tokens[2..], |tokens|, Calc(src, []), 2)
  }

  function method {:tailrecursion} {:opaque} Tokenize(s : string)
    : seq<string>
    decreases |s|
  {
    var s := StripLeadingWhitespace(s);
    if |s| == 0 then
      []
    else
      var len := FindTokenLenPlain(s);
      [s[..len]] + Tokenize(s[len..])
  }


  predicate method {:opaque} IsWhitespace(ch : char)
  {
    // everything from zero through space, including tabs, newlines, carriage returns, nulls etc.
    ch <= ' '
  }

  function method {:tailrecursion} {:opaque} StripLeadingWhitespace(s : string)
    : (ret : string)
    ensures |ret| <= |s|
    ensures |ret| == 0 || !IsWhitespace(ret[0])
  {
    if |s| == 0 || !IsWhitespace(s[0]) then
      s
    else
      StripLeadingWhitespace(s[1..])
  }

  function method {:opaque} AsciiLowerChar(ch : char)
    : char
  {
    if 'A' <= ch <= 'Z' then
      ch - 'A' + 'a'
    else
      ch
  }

  function method {:opaque} AsciiUpperChar(ch : char)
    : char
  {
    if 'a' <= ch <= 'z' then
      ch + 'A' - 'a'
    else
      ch
  }

  function method {:tailrecursion} {:opaque} AsciiLower(s : string)
    : string
  {
    if |s| == 0 then
      s
    else
      [AsciiLowerChar(s[0])] + AsciiLower(s[1..])
  }

  function method {:tailrecursion} {:opaque} AsciiUpper(s : string)
    : string
  {
    if |s| == 0 then
      s
    else
      [AsciiUpperChar(s[0])] + AsciiUpper(s[1..])
  }

  function method  {:tailrecursion} {:opaque} FindTokenLenPlain(s : string)
    : (ret : nat)
    requires |s| > 0
    requires !IsWhitespace(s[0])
    ensures ret <= |s|
    ensures ret > 0
  {
    if |s| == 1 || IsWhitespace(s[1]) then
      1
    else
      1 + FindTokenLenPlain(s[1..])
  }
}
