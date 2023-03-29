// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "../../Model/AwsCryptographyDynamoDbEncryptionTypes.dfy"
//include "../StructuredEncryption/Paths.dfy"

module DynamoDbEncryptionUtil {
  import opened AwsCryptographyDynamoDbEncryptionTypes
  import opened Wrappers
  import opened StandardLibrary
  import opened StandardLibrary.UInt

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
}