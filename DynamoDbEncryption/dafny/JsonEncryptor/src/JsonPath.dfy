// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "AwsCryptographyDbEncryptionSdkDynamoDbJsonOperations.dfy"
include "Util.dfy"

module {:options "-functionSyntax:4"} JsonPathMod {
  export
    provides
      Wrappers,
      ValidPath,
      PrettyString,
      StandardString,
      Parse
    reveals
      JsonPath,
      JsonPathBase

  import opened Wrappers
  import opened StandardLibrary

  datatype JsonPathBase = JsonPathBase (path : seq<string>)
  type JsonPath = x : JsonPathBase | ValidPath(x.path) witness *

  predicate NonEmpty(path : seq<string>)
  {
    forall x <- path :: 0 < |x|
  }

  predicate ValidPath(path : seq<string>)
  {
    && 0 < |path|
    && NonEmpty(path)
  }

  predicate Alpha(ch : char)
  {
    || 'a' <= ch <= 'z'
    || 'A' <= ch <= 'Z'
  }

  predicate AlphaNumeric(ch : char)
  {
    || '0' <= ch <= '9'
    || Alpha(ch)
  }


  predicate IsPlain(member : string)
  {
    if |member| == 0 then
      false
    else if !Alpha(member[0]) then
      false
    else
      forall k <- member :: AlphaNumeric(k)
  }

  function {:tailrecursion} StandardString4(path : string) : string
  {
    if |path| == 0 then
      ""
    else if path[0] == '\'' then
      "\\\'" + StandardString4(path[1..])
    else if path[0] == '\\' then
      "\\\\" + StandardString4(path[1..])
    else
      [path[0]] + StandardString4(path[1..])
  }

  function StandardString3(path : string) : string
  {
    "['" + StandardString4(path) + "']"
  }

  function PrettyString3(path : string) : string
  {
    if IsPlain(path) then
      path
    else
      StandardString3(path)
  }

  function {:tailrecursion} PrettyString2(path : seq<string>) : string
  {
    if |path| == 0 then
      ""
    else
      "." + PrettyString3(path[0]) + PrettyString2(path[1..])
  }

  function {:tailrecursion} StandardString2(path : seq<string>) : string
  {
    if |path| == 0 then
      ""
    else
      "." + StandardString3(path[0]) + StandardString2(path[1..])
  }

  function PrettyString(path : JsonPath) : string
  {
    if |path.path| == 0 then
      ""
    else if |path.path| == 1 && IsPlain(path.path[0]) then
      path.path[0]
    else
      "$" + PrettyString2(path.path)
  }

  function StandardString(path : JsonPath) : string
  {
    if |path.path| == 0 then
      ""
    else
      "$" + StandardString2(path.path)
  }

  function {:tailrecursion} GetString(input : string, delim : char, acc : nat := 0, accStr : string := "", orig : string := input) : (ret : Result<(nat,string), string>)
    requires |input| + acc == |orig|
    ensures ret.Success? ==> ret.value.0 <= |orig|
  {
    if |input| == 0 then
      Success((acc, accStr))
    else if input[0] == delim then
      Success((acc, accStr))
    else if input[0] == '\\' then
      if |input| == 1 then
        Failure("Trailing backslash : " + orig)
      else if input[1] == '\\' then
        GetString(input[2..], delim, acc+2, accStr + "\\", orig)
      else if input[1] == '"' then
        GetString(input[2..], delim, acc+2, accStr + "\"", orig)
      else if input[1] == '\'' then
        GetString(input[2..], delim, acc+2, accStr + "'", orig)
      else
        Failure("Backslash must only be followed by another backslash or a quote : " + orig)
    else
      GetString(input[1..], delim, acc+1, accStr + [input[0]], orig)
  }

  // return (nextPart, theRest)
  function Parse3(input : string, acc : seq<string> := []) : (ret : Result<(string, string), string>)
    requires 1 < |input|
    requires input[0] == '.'
    ensures ret.Success? ==>
              && 0 < |ret.value.0|
              && |ret.value.1| < |input|
  {
    if input[1] == '[' then
      if |input| == 2 then
        Failure("Malformed JSONPath segment : .[")
      else if input[2] != '\'' && input[2] != '"' then
        Failure("Malformed JSONPath segment started '.[' but not followed by a quote : " + input)
      else if |input| == 3 then
        Failure("Malformed JSONPath segment : " + input)
      else
        var (len,val) :- GetString(input[3..], input[2]);
        :- Need(0 < |val|, "Bad1");
        :- Need(4+len < |input|, "Bad2");
        :- Need(input[3+len] == input[2], "No close quote");
        :- Need(input[4+len] == ']', "Bad3");
        Success((val, input[5+len..]))
    else
      var (len,val) :- GetString(input[1..], '.');
      :- Need(0 < |val|, "Bad4");
      Success((val, input[1+len..]))

  }

  function {:tailrecursion} Parse2(input : string, acc : seq<string> := []) : (ret : Result<seq<string>, string>)
    requires NonEmpty(acc)
    requires 0 < |input| || 0 < |acc|
    ensures ret.Success? ==> ValidPath(ret.value)
    decreases |input|
  {
    if |input| == 0 then
      Success(acc)
    else if input[0] != '.' then
      Failure("JSONPath segment did not start with '.'")
    else if |input| == 1 then
      Failure("JSONPath segment was just a '.'")
    else
      var parts :- Parse3(input);
      Parse2(parts.1, acc + [parts.0])
  }

  function Parse(input : string) : Result<JsonPath, string>
  {
    if |input| == 0 then
      Failure("JSONPath cannot be an empty string.")
    else if input[0] == '$' then
      :- Need(1 < |input| && input[1] == '.', "JSONPath must start '$.'");
      var parts :- Parse2(input[1..]);
      Success(JsonPathBase(path := parts))
    else if IsPlain(input) then
      Success(JsonPathBase(path := [input]))
    else
      Failure("JSONPath '" + input + "' did not start with a '$', and yet contained special characters.")

  }
}
