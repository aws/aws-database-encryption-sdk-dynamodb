// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "../Model/AwsCryptographyDbEncryptionSdkDynamoDbTypes.dfy"

module DynamoDbEncryptionUtil {
  import opened AwsCryptographyDbEncryptionSdkDynamoDbTypes
  import opened Wrappers
  import opened StandardLibrary
  import opened StandardLibrary.UInt
  import DDB = ComAmazonawsDynamodbTypes

  const ReservedPrefix := "aws_dbe_"
  const BeaconPrefix := "aws_dbe_b_"
  const VersionPrefix := "aws_dbe_v_"

  const MAX_STRUCTURE_DEPTH : uint64 := 32
  const MAX_STRUCTURE_DEPTH_STR := "32"

  type HmacKeyMap = map<string, Bytes>

  // For Multi-Tenant Queries, it's OK to have no KeyId in the query
  // as long as nothing in the query needs a key
  // The two "ShouldHave" enums below indicate that case
  // The query MUST fail if the mode is "ShouldHave" and a standard beacon is used
  //
  // Counterintuitively, DontUseKeys and DontUseKeyId are very different things.
  // DontUseKeyId is the usual thing for single tenant, meaning to use the pre-configured
  // KeyId, rather than find a new one from somewhere.
  // DontUseKeys means to not hash the values into beacons,
  // but to leave them plaintext, which is necessary for the post-query filtering.
  datatype MaybeKeyMap =
    | DontUseKeys
    | ShouldHaveKeys
    | Keys(value : HmacKeyMap)

  datatype MaybeKeyId =
    | DontUseKeyId
    | ShouldHaveKeyId
    | KeyId(value : string)
  function method MaybeFromOptionKeyId(x : Option<string>) : MaybeKeyId
  {
    if x.Some? then
      KeyId(x.value)
    else
      DontUseKeyId
  }

  // string to Error
  function method E(s : string) : Error {
    DynamoDbEncryptionException(message := s)
  }

  predicate method CharLess(x : char, y : char)
  {
    x < y
  }

  predicate method ByteLess(x : uint8, y : uint8)
  {
    x < y
  }

  type Bytes = seq<uint8>

  // return type of value
  function method AttrTypeToStr(attr : DDB.AttributeValue) : string
  {
    match attr {
      case S(s) => "S"
      case N(n) => "N"
      case B(n) => "B"
      case SS(n) => "SS"
      case NS(n) => "NS"
      case BS(n) => "BS"
      case M(n) => "M"
      case L(n) => "L"
      case NULL(n) => "NULL"
      case BOOL(n) => "BOOL"
    }
  }

  const MAX_BUCKET_COUNT : nat := 255

  type BucketBytes = x: seq<uint8> | Valid_BucketBytes(x) witness []
  newtype OptBucketCount  = x: int | 0 <= x <= MAX_BUCKET_COUNT

  function method BucketBytesToNumber(x : BucketBytes) : BucketNumber
  {
    if |x| == 0 then
      0
    else
      x[0] as BucketNumber
  }

  function method BucketNumberToBytes(x : BucketNumber) : BucketBytes
  {
    if x == 0 then
      []
    else
      [x as uint8]
  }

  // Java is broken, None becomes Some(0)
  predicate method BucketCountNone(x : Option<BucketCount>)
  {
    x.None? || x.value == 0
  }

  predicate method Valid_BucketBytes(x : seq<uint8>)
  {
    && |x| <= 1
    && (|x| == 1 ==> (0 < x[0] < (MAX_BUCKET_COUNT as uint8)))
  }

  function printFromFunction<T>(x: T): () {
    ()
  } by method {
    print x,"\n";
    return ();
  }
  function printFromFunction2<T, U>(x: T, y : U): () {
    ()
  } by method {
    print x, " ", y, "\n";
    return ();
  }
  function printFromFunction3<T, U, V>(x: T, y : U, z : V): () {
    ()
  } by method {
    print x, " ", y, " ", z, "\n";
    return ();
  }

  function method gcd(a : nat, b : nat) : nat
    requires 0 < a || 0 < b
    ensures 0 < gcd(a, b)
    ensures 0 < b ==> gcd(a, b) <= b
    decreases b
  {
    if b == 0 then
      a
    else
      gcd(b, a % b)
  }

  function method lcm(a : nat, b : nat) : nat
    requires 0 < a && 0 < b
    ensures 0 < lcm(a, b)
  {
    (a / gcd(a, b)) * b
  }

  function method lcmBucket(a : BucketCount, b : BucketCount, max : BucketCount) : BucketCount
    requires 0 < a && 0 < b
    ensures 0 < lcmBucket(a, b, max)
  {
    if a == 1 || b == max then
      b
    else if b == 1 || a == max then
      a
    else
      var result := lcm(a as nat, b as nat);
      if result < max as nat then
        result as BucketCount
      else
        max
  }

  function method lcmSeq(values : seq<BucketCount>, max : BucketCount) : BucketCount
    // requires forall i <- values :: i <= max
    decreases |values|
  {
    if |values| == 0 then
      1
    else if |values| == 1 then
      values[0]
    else
      var res := lcmBucket(values[0], values[1], max);
      if |values| == 2 then
        res as BucketCount
      else
        lcmSeq([res as BucketCount] + values[2..], max)
  }

}
