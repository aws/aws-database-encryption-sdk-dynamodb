// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

// Extract table name from PartiQL statements, as per
// https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ql-reference.statements.html
// for ExecuteStatement, BatchExecuteStatement and ExecuteTransaction

include "../../../../submodules/MaterialProviders/StandardLibrary/src/Index.dfy"
include "../../../../submodules/MaterialProviders/ComAmazonawsDynamodb/Model/ComAmazonawsDynamodbTypes.dfy"

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
    : Result<DDB.TableName, string>
  {
    var ret := TableFromStatementInner(s);
    if ret.Some? then
      Success(ret.value)
    else
      Failure("Unable to extract table name from PartiQL statement.")
  }

  function method {:opaque} TableFromStatementInner(s : string)
    : Option<DDB.TableName>
  {
    var s := StripLeadingWhitespace(s);
    if |s| > 6 && AsciiLower(s[0..6]) == "exists" then
      TableFromExistsStatement(s[6..])
    else
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

  // Find the first naked "from". i.e. a "from" that is not quoted or part of a larger
  // construct without spaces.
  // Expressions will not contain such a "from" so this is correct:
  // https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ql-reference.select.html#ql-reference.select.syntax
  function method {:tailrecursion} {:opaque} TableFromSelectStatementInner(s : string)
    : Option<string>
    decreases |s|
  {
    if |s| == 0 then
      None
    else
      var t := StripLeadingWhitespace(s);
      var len := FindTokenLen(t);
      if AsciiLower(t[..len]) == "from" then
        var t := StripLeadingWhitespace(t[len..]);
        var len := FindTokenLen(t);
        Some(t[..len])
      else if len == 0 then
        None
      else
        TableFromSelectStatementInner(t[len..])
  }

  // https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ql-functions.exists.html
  function method {:tailrecursion} {:opaque} TableFromExistsStatement(s : string)
    : Option<DDB.TableName>
  {
    var s := StripLeadingWhitespace(s);
    if |s| == 0 || s[0] != '(' then
      None
    else
      var s := StripLeadingWhitespace(s[1..]);
      var len := FindTokenLen(s);
      if AsciiLower(s[..len]) == "select" then
        TableFromSelectStatement(s[len..])
      else
        None
  }

  // https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ql-reference.select.html
  // states that the target of the select is either "Table" or "Table.Index"
  // In either case, we want just the Table
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

  // https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ql-reference.update.html
  function method {:opaque} TableFromUpdateStatement(s : string)
    : Option<DDB.TableName>
  {
    var s := StripLeadingWhitespace(s);
    var len := FindTokenLen(s);
    if len == 0 then
      None
    else
      GetTableName(s[..len])
  }

  // https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ql-reference.delete.html
  function method {:opaque} TableFromDeleteStatement(s : string)
    : Option<DDB.TableName>
  {
    var s := StripLeadingWhitespace(s);
    var len := FindTokenLen(s);
    if AsciiLower(s[..len]) != "from" then
      None
    else
      var s := StripLeadingWhitespace(s[len..]);
      var len := FindTokenLen(s);
      if len == 0 then
        None
      else
        GetTableName(s[..len])
  }

  // https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ql-reference.insert.html
  function method {:opaque} TableFromInsertStatement(s : string)
    : Option<DDB.TableName>
  {
    var s := StripLeadingWhitespace(s);
    var len := FindTokenLen(s);
    if AsciiLower(s[..len]) != "into" then
      None
    else
      var s := StripLeadingWhitespace(s[len..]);
      var len := FindTokenLen(s);
      if len == 0 then
        None
      else
        GetTableName(s[..len])
  }

  predicate method {:opaque} IsWhitespace(ch : char)
  {
    // everything from zero through space, including tabs, newlines, carriage returns, nulls etc.
    ch <= ' '
  }

  function method {:tailrecursion} {:opaque} StripLeadingWhitespace(s : string)
    : (ret : string)
    ensures |ret| <= |s|
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

  function method {:tailrecursion} {:opaque} AsciiLower(s : string)
    : string
  {
    if |s| == 0 then
      s
    else
      [AsciiLowerChar(s[0])] + AsciiLower(s[1..])
  }

  // if s starts with a quote ("), return number of characters until after the next quote
  // else return number of characters until next whitespace
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
