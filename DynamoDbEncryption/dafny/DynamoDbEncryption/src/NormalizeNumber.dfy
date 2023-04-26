// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "../Model/AwsCryptographyDynamoDbEncryptionTypes.dfy"
include "Util.dfy"

module DynamoDbNormalizeNumber {
  import opened FloatCompare
  import opened StandardLibrary
  import opened Wrappers
  import opened StandardLibrary.UInt
  import opened DynamoDbEncryptionUtil
  import Seq


  // Split A.B into A and B
  function method SplitDecimal(n : string, exp : int) : (ret : (string, string, int))
  {
    if '.' in n then
      var (whole, frac) := SplitOnce(n, '.');
      (whole, SkipTrailingZeros(frac), exp)
    else
      (n, "", exp)
  }

  // Split A.BeC into A and B and C
  function method SplitNumber(n : string) : (ret : (string, string, int))
  {
    if 'e' in n then
      var (num, exp) := SplitOnce(n, 'e');
      SplitDecimal(num, StrToInt(exp))
    else if 'E' in n then
      var (num, exp) := SplitOnce(n, 'E');
      SplitDecimal(num, StrToInt(exp))
    else
      SplitDecimal(n, 0)
  }

  // Return a string of this many zeros
  function method Zeros(n : nat) : string
  {
    seq(n, i => '0')
  }

  // Normalize a non-negative numeric string, DynamoDB style
  function method NormalizePositive(n : string) : Result<string, string>
  {
    var (whole, frac, exp) := SplitNumber(n);
    if exp < -200 || 200 < exp then
      // The 200 limit is to a) not crash on extra large numbers and b) always succeed if DDB succeeds
      // we're ok succeeding where DDB fails
      Failure("Exponent out of range.")
    else if |whole| == 0 && |frac| == 0 then
      Success("0")
    else if |frac| == 0 && exp >= 0 then
      Success(whole + Zeros(exp))
    else if |whole| == 0 && exp < 0 then
      Success("0." + Zeros(-exp) + frac)
    else if exp >= 0 && |frac| <= exp then
      Success(whole + frac + Zeros(exp - |frac|))
    else if exp < 0 && |whole| <= -exp then
      Success("0." + Zeros(-exp - |whole|) + whole + frac)
    else if exp == 0 && |whole| == 0 then
      Success("0." + frac[exp..])
    else if exp >= 0 then
      Success(whole + frac[..exp] + "." + frac[exp..])
    else
      var N := |whole| + exp;
      Success(whole[..N] + "." + whole[N..] + frac)
  }

  // Normalize a numeric string, DynamoDB style
  function method NormalizeNumber(n : string) : Result<string, string>
  {
    var n := SkipLeadingSpace(n);
    var n := SkipLeadingZeros(n);
    if |n| == 0 then
      Success("0")
    else
      var (neg, n) := if n[0] == '-' then
                        (true, n[1..])
                      else
                        (false, n);
      var n :- NormalizePositive(n);
      if neg then
        Success(['-'] + n)
      else
        Success(n)
  }
}