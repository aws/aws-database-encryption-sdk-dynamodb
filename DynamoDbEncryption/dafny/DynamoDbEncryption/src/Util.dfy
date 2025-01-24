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

  const MAX_STRUCTURE_DEPTH := 32
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

  function printFromFunction<T>(x: T): () {
    ()
  } by method {
    print x,"\n";
    return ();
  }
}
