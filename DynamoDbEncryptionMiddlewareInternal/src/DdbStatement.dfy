// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "../../private-aws-encryption-sdk-dafny-staging/libraries/src/Wrappers.dfy"
include "../../private-aws-encryption-sdk-dafny-staging/StandardLibrary/src/StandardLibrary.dfy"
include "../../private-aws-encryption-sdk-dafny-staging/ComAmazonawsDynamodb/Model/ComAmazonawsDynamodbTypes.dfy"

module DdbStatement {
  import opened Wrappers
  import opened StandardLibrary
  import DDB = ComAmazonawsDynamodbTypes

  function method {:opaque} UnQuote(s : string)
    : string
  {
    var s := if |s| > 0  && s[0] == '"' then s[1..] else s;
    if |s| > 0  && s[|s|-1] == '"' then s[0..|s|-1] else s
  }
  function method {:opaque} GetTableName(s : string)
    : Option<DDB.TableName>
  {
    var s :=  UnQuote(s);
    if DDB.IsValid_TableName(s) then
      Some(s)
    else
      None
  }

  function method {:opaque} TableFromStatement(s : string)
    : (ret : Option<DDB.TableName>)
  {
    var s := StripLeading(s);
    var len := FindTokenLen(s);
    var cmd := AsciiLower(s[..len]);
    if cmd == "select" then
      TableFromSelectStatement(s[len..])
    else if cmd == "update" then
      TableFromUpdateStatement(s[len..])
    else if cmd == "delete" then
      TableFromDeleteStatement(s[len..])
    else if cmd == "insert" then
      TableFromInsertStatement(s[len..])
    else
      None
  }

  function method {:tailrecursion} {:opaque} TableFromSelectStatementInner(s : string)
    : Option<string>
    decreases |s|
  {
    if |s| == 0 then
      None
    else
      var t := StripLeading(s);
      var len := FindTokenLen(t);
      if AsciiLower(t[..len]) == "from" then
        var t := StripLeading(t[len..]);
        var len := FindTokenLen(t);
        Some(t[..len])
      else if len == 0 then
        None
      else
        TableFromSelectStatementInner(t[len..])
  }

  function method {:opaque} TableFromSelectStatement(s : string)
  : Option<DDB.TableName>
  {
    var name :- TableFromSelectStatementInner(s);
    if '.' in name then
      var x := SplitOnce(name, '.');
      GetTableName(x.0)
    else
      GetTableName(name)
  }

  function method {:opaque} TableFromUpdateStatement(s : string)
  : Option<DDB.TableName>
  {
    var s := StripLeading(s);
    var len := FindTokenLen(s);
    if len == 0 then
      None
    else
      GetTableName(s[..len])
  }

  function method {:opaque} TableFromDeleteStatement(s : string)
  : Option<DDB.TableName>
  {
    var s := StripLeading(s);
    var len := FindTokenLen(s);
    if AsciiLower(s[..len]) != "from" then
      None
    else
      var s := StripLeading(s[len..]);
      var len := FindTokenLen(s);
      if len == 0 then
        None
      else
        GetTableName(s[..len])
  }

  function method {:opaque} TableFromInsertStatement(s : string)
  : Option<DDB.TableName>
  {
    var s := StripLeading(s);
    var len := FindTokenLen(s);
    if AsciiLower(s[..len]) != "into" then
      None
    else
      var s := StripLeading(s[len..]);
      var len := FindTokenLen(s);
      if len == 0 then
        None
      else
        GetTableName(s[..len])
  }

  predicate method {:opaque} IsWhitespace(ch : char)
  {
    ch <= ' '
  }

  function method {:tailrecursion} {:opaque} StripLeading(s : string)
    : (ret : string)
    ensures |ret| <= |s|
  {
    if |s| == 0 || !IsWhitespace(s[0]) then
      s
    else
      StripLeading(s[1..])
  }

  function method {:opaque} AsciiLowerChar(ch : char)
    : char
  {
    if 'A' <= ch <= 'Z' then
      ch - 'A' + 'a'
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

  function method {:opaque} FindTokenLen(s : string)
    : (ret : nat)
    ensures ret <= |s|
  {
    if |s| == 0 || IsWhitespace(s[0]) then
      0
    else if s[0] == '"' then
      1 + FindTokenLenQuoted(s[1..])
    else
      FindTokenLenPlain(s)
  }
  function method  {:tailrecursion} {:opaque} FindTokenLenPlain(s : string)
    : (ret : nat)
    ensures ret <= |s|
  {
    if |s| == 0 || IsWhitespace(s[0]) then
      0
    else
      1 + FindTokenLenPlain(s[1..])
  }
  function method  {:tailrecursion} {:opaque} FindTokenLenQuoted(s : string)
    : (ret : nat)
    ensures ret <= |s|
  {
    if |s| == 0 then
      0
    else if s[0] == '"' then
      1
    else
      1 + FindTokenLenQuoted(s[1..])
  }

}