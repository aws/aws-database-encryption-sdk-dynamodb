// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "../Model/AwsCryptographyDbEncryptionSdkDynamoDbTypes.dfy"

module DynamoDbEncryptionUtil {
  import opened AwsCryptographyDbEncryptionSdkDynamoDbTypes
  import opened Wrappers
  import opened StandardLibrary
  import opened StandardLibrary.UInt
  import opened StandardLibrary.MemoryMath
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

  const MAX_PARTITION_COUNT : nat := 255

  type PartitionBytes = x: seq<uint8> | Valid_PartitionBytes(x) witness []
  newtype OptPartitionCount  = x: int | 0 <= x <= MAX_PARTITION_COUNT

  function method PartitionBytesToNumber(x : PartitionBytes) : PartitionNumber
  {
    if |x| == 0 then
      0
    else
      x[0] as PartitionNumber
  }

  function method PartitionNumberToBytes(x : PartitionNumber) : PartitionBytes
  {
    //= specification/searchable-encryption/beacons.md#partition-beacon-encoding
    //# If this number is zero, then the input sequence of bytes MUST be returned unchanged.
    if x == 0 then
      []
    //= specification/searchable-encryption/beacons.md#partition-beacon-encoding
    //# Otherwise, a single byte with a value equal to this calculated partition number, MUST be appended to the input sequence of bytes.
    else
      [x as uint8]
  }

  // Java is broken, None becomes Some(0)
  predicate method PartitionCountNone(x : Option<PartitionCount>)
  {
    x.None? || x.value == 0
  }

  predicate method Valid_PartitionBytes(x : seq<uint8>)
  {
    && |x| <= 1
    && (|x| == 1 ==> (0 < x[0] < (MAX_PARTITION_COUNT as uint8)))
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

  function method bmin(a : PartitionCount, b : PartitionCount) : (output : PartitionCount)
    ensures output <= a
    ensures output <= b
  {
    if a <= b then
      a
    else
      b
  }

  function method lcmPartition(a : PartitionCount, b : PartitionCount, max : PartitionCount) : PartitionCount
    requires 0 < a && 0 < b
    ensures 0 < lcmPartition(a, b, max) <= max
  {
    if a == 1 || b == max || a == b then
      bmin(b, max)
    else if b == 1 || a == max then
      bmin(a, max)
    else
      var result := lcm(a as nat, b as nat);
      if result < max as nat then
        result as PartitionCount
      else
        max
  }

  method lcmSeq(values : seq<PartitionCount>, max : PartitionCount) returns (output : PartitionCount)
    // requires forall i <- values :: i <= max
    ensures output <= max
  {
    var result : PartitionCount := 1;
    SequenceIsSafeBecauseItIsInMemory(values);
    for i : uint64 := 0 to |values| as uint64
      invariant result <= max
    {
      var partitions := values[i];
      if partitions == 1 || partitions == result {
        continue;
      }
      result := lcmPartition(result, partitions, max);
    }
    return result;
  }
}
