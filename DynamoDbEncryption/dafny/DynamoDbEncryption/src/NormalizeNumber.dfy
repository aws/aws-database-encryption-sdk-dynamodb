// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "../Model/AwsCryptographyDynamoDbEncryptionTypes.dfy"
include "Util.dfy"

module DynamoDbNormalizeNumber {
  import opened StandardLibrary
  import opened Wrappers
  import opened StandardLibrary.UInt
  import opened DynamoDbEncryptionUtil
  import Seq

  // return the input string with unnecessary leading zeros removed
  function method {:tailrecursion} SkipLeadingZeros(val : string) : (ret : string)
  {
    if 1 < |val| && val[0] == '0' && val[1] != '.' then
      SkipLeadingZeros(val[1..])
    else
      val
  }

  // return the input string with trailing zeros removed
  function method {:tailrecursion} SkipTrailingZeros(val : string) : (ret : string)
    requires '.' in val
  {
    if 1 < |val| && val[|val|-1] == '0' then
      if val[|val|-2] == '.' then
        val[..|val|-2]
      else
        SkipTrailingZeros(val[..|val|-1])
    else
      val
  }

  // return the input string with trailing zeros removed
  function method {:tailrecursion} SkipAllTrailingZeros(val : string) : (ret : string)
    ensures |ret| == 0 || ret[|ret|-1] != '0'
  {
    if 0 < |val| && val[|val|-1] == '0' then
      SkipAllTrailingZeros(val[..|val|-1])
    else
      val
  }

  predicate method IsDecimalDigit(ch : char)
  {
    '0' <= ch <= '9'
  }

  predicate AllDecimalDigits(s : string)
  {
    forall k <- s :: IsDecimalDigit(k)
  }

  // unsigned base 10 string to integer
  function method {:tailrecursion} StrToIntInner(s : string, acc : nat := 0) : Result<nat, string>
  {
    if |s| == 0 then
      Success(acc)
    else if IsDecimalDigit(s[0]) then
      StrToIntInner(s[1..], acc * 10 + s[0] as int - '0' as int)
    else
      Failure("The character '" + s[..1] + "' is not a valid decimal digit.")
  }

  // signed base 10 string to integer
  function method {:tailrecursion} StrToInt(s : string) : Result<int, string>
  {
    if |s| == 0 then
      Failure("An empty string is not a valid number.")
    else if s[0] == '-' then
      var x :- StrToIntInner(s[1..]);
      Success(-(x as int))
    else if s[0] == '+' then
      StrToIntInner(s[1..])
    else
      StrToIntInner(s)
  }

  // Return a string of this many zeros
  function method Zeros(n : nat) : string
  {
    seq(n, i => '0')
  }

  function method CountDigits(s : string) : (ret : nat)
    ensures ret <= |s|
    ensures forall k <- s[..ret] :: IsDecimalDigit(k)
  {
    if |s| == 0 then
      0
    else if IsDecimalDigit(s[0]) then
      1 + CountDigits(s[1..])
    else
      0
  }

  predicate method IsE(ch : char)
  {
    ch == 'e' || ch == 'E'
  }

  // for AAA.BBBeCCC
  // ret.0 is AAABBB
  // ret.1 is 3 (the position of the decimal point in AAABBB)
  // re2.2 is CCC as a number
  function method ParseNumber(n : string) : (ret : Result<(string, nat, int), string>)
    ensures ret.Success? ==>
              && ret.value.1 <= |ret.value.0|
              && forall k <- ret.value.0 :: IsDecimalDigit(k)
  {
    var preDot := CountDigits(n);
    if |n| == preDot then // e.g. 123
      Success((n, |n|, 0))
    else if n[preDot] == '.' then
      var postDot := CountDigits(n[preDot+1..]);
      :- Need(0 < (preDot + postDot), "Number needs digits either before or after the decimal point.");
      var len := preDot + postDot + 1;
      if len == |n| then // e.g. 123.456
        Success((n[0..preDot] + n[preDot+1..], preDot, 0))
      else if IsE(n[len]) then // e.g. 123.456e7
        var exp :- StrToInt(n[len+1..]);
        Success((n[0..preDot] + n[preDot+1..len], preDot, exp))
      else
        Failure("Invalid Character in number at '" + n[len..] + "'.")
    else if preDot == 0 then // e.g. e99
      Failure("Number needs digits either before or after the decimal point.")
    else if IsE(n[preDot]) then // e.g. 123e99
      var exp :- StrToInt(n[preDot+1..]);
      Success((n[..preDot], preDot, exp))
    else
      Failure("Invalid Character in number at '" + n[preDot..] + "'.")
  }

  function method CountZeros(value : string) : (ret : nat)
    ensures ret <= |value|
    ensures Zeros(ret) <= value
    ensures ret == |value| || value[ret] != '0'
  {
    if |value| == 0 || value[0] != '0' then
      0
    else
      1 + CountZeros(value[1..])
  }

  // remove leading zeros before pos and trailing zeros after pos
  function method NormalizeValue(value : string, pos : nat) : (ret : (string, nat))
    requires pos <= |value| 
    requires AllDecimalDigits(value)
    ensures ret.1 <= |ret.0|
    ensures AllDecimalDigits(ret.0)
  {
    if |value| == 0 then
      (value, pos)
    else if value[0] == '0' && pos > 0 then
      NormalizeValue(value[1..], pos-1)
    else if value[|value|-1] == '0' && pos < |value| then
      NormalizeValue(value[..|value|-1], pos)
    else
      (value, pos)
  }

  // Normalize a non-negative numeric string, DynamoDB style
  function method NormalizePositive(n : string) : (ret : Result<string, string>)
    requires 0 < |n|
    ensures ret.Success? ==>
              && 0 < |ret.value|
              && IsDecimalDigit(ret.value[0])
  {
    var (value, pos, exp) :- ParseNumber(n);
    var (value, pos) := NormalizeValue(value, pos);
    var newValue := SkipAllTrailingZeros(SkipLeadingZeros(value));
    :- Need(|newValue| <= 38, "Attempting to store more than 38 significant digits in a Number.");
    var newPos := pos + exp;
    if |newValue| == 0 then
      Success("0")
    else if newPos <= 0 then
      :- Need(newPos - CountZeros(value) >= -129, "Attempting to store a number with magnitude smaller than supported range.");
      Success("0." + Zeros(-newPos) + value)
    else if newPos >= |value| then
      :- Need(newPos - CountZeros(value) <= 126, "Attempting to store a number with magnitude larger than supported range.");
      Success(value + Zeros(newPos - |value|))
    else
      Success(value[..newPos] + "." + value[newPos..])
  }

  // remove leading and trailing zeros as necessary
  function method TrimNumber(n : string) : string
  {
    var n := SkipLeadingZeros(n);
    if '.' in n then
      SkipTrailingZeros(n)
    else
      n
  }

  // Normalize a numeric string, DynamoDB style
  function method NormalizeNumber2(n : string) : Result<string, string>
  {
    :- Need(0 < |n|, "An empty string is not a valid number.");
    var (neg, n) := if n[0] == '-' then
                      (true, n[1..])
                    else if n[0] == '+' then
                      (false, n[1..])
                    else
                      (false, n);
    :- Need(0 < |n|, "An empty string is not a valid number.");
    var n :- NormalizePositive(n);
    var n := TrimNumber(n);
    if neg && n != "0" then
      Success(['-'] + n)
    else
      Success(n)
  }

  // Normalize a numeric string, DynamoDB style
  function method NormalizeNumber(n : string) : Result<string, string>
  {
    var ret := NormalizeNumber2(n);
    if ret.Success? then
      ret
    else
      Failure(ret.error + " when parsing '" + n + "'.")
  }

}