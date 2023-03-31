// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "../Model/AwsCryptographyDynamoDbEncryptionTypes.dfy"

module DynamoDbEncryptionUtil {
  import opened AwsCryptographyDynamoDbEncryptionTypes
  import opened Wrappers
  import opened StandardLibrary
  import opened StandardLibrary.UInt
  import DDB = ComAmazonawsDynamodbTypes

  const ReservedPrefix := "aws_dbe_"
  const BeaconPrefix := "aws_dbe_b_"
  const VersionPrefix := "aws_dbe_v_"

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
}