// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "Util.dfy"

module DynamoDbUpdateExpr {
  import opened Wrappers
  import opened StandardLibrary
  import opened ComAmazonawsDynamodbTypes

  // return the names of all the attributes mentioned in the given update expression
  function method ExtractAttributes(s : string, ex : Option<ExpressionAttributeNameMap>) : seq<string>
  {
    var x := ExtractAttrs(s);
    if ex.None? then
      x
    else
      Resolve(x, ex.value)
  }

  // return true if s seems like an attribute name, but isn't
  predicate method IgnoreAttr(s : string)
  {
    s in ["SET", "REMOVE", "ADD", "DELETE", "list_append", "if_not_exists"]
  }

  // for any names that appear in the ExpressionAttributeNameMap, look them up
  function method {:tailrecursion} Resolve(names : seq<string>, ex : ExpressionAttributeNameMap) : seq<string>
  {
    if |names| == 0 then
      []
    else if names[0] in ex then
      [ex[names[0]]] + Resolve(names[1..], ex)
    else
      [names[0]] + Resolve(names[1..], ex)
  }

  // if ch exists in s, return the part of s up to ch; otherwise return s unchanged
  function method ChopOne(s : string, ch : char) : string
  {
    if ch in s then
      SplitOnce(s, ch).0
    else
      s
  }

  // Given a Terminal Location string, return the root attribute
  function method Chop(s : string) : string
  {
    var s := ChopOne(s, '.');
    ChopOne(s, '[')
  }

  // Given an update expression, return a list of all the attribute names mentioned
  function method  {:tailrecursion} {:opaque} ExtractAttrs(s : string) : seq<string>
  {
    if |s| == 0 then
      []
    else
      var ret := FindToken(s);
      if ret.0 == 0 then
        []
      else if ret.1.None? then
        ExtractAttrs(s[ret.0..])
      else if IgnoreAttr(ret.1.value) then
        ExtractAttrs(s[ret.0..])
      else
        [Chop(ret.1.value)] + ExtractAttrs(s[ret.0..])
  }

  // character that starts a token that is not an attribute name
  predicate method BadStart(ch : char)
  {
    ch == ':' || '0' <= ch <= '9'
  }

  // valid character to start and attribute name
  predicate method AttrStart(ch : char)
  {
    if 'a' <= ch <= 'z'  then
      true
    else if 'A'  <= ch <= 'Z' then
      true
    else if ch == '#' || ch == '_' then
      true
    else
      false
  }

  // valid attribute character
  predicate method AttrChar(ch : char)
  {
    if AttrStart(ch) then
      true
    else if '0'  <= ch <= '9' then
      true
    else if ch in ['[' ,']' ,'.'] then
      true
    else
      false
  }

  // length of the prefix of s that is an attribute name
  function method  {:tailrecursion} AttrLen(s : string): (res : nat)
    ensures res <= |s|
  {
    if 0 == |s| then
      0
    else if AttrChar(s[0]) then
      AttrLen(s[1..]) + 1
    else
      0
  }

  // return the next token in the stream
  // res.1 is the next token and res.0 is the number of characters consumed
  function method FindToken(s: string): (res: (nat, Option<string>))
    ensures res.0 <= |s|
  {
    if 0 == |s| then
      (0, None)
    else
      var ch := s[0];
      if ch == '#' then
        var x := AttrLen(s[1..]) + 1;
        (x, Some(s[0..x]))
      else if BadStart(ch) then
        var x := AttrLen(s[1..]) + 1;
        (x, None)
      else if AttrStart(ch) then
        var x := AttrLen(s[1..]) + 1;
        (x, Some(s[0..x]))
      else
        (1, None)
  }
}
