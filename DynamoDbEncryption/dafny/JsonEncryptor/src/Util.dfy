// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "../Model/AwsCryptographyDbEncryptionSdkDynamoDbJsonTypes.dfy"

module JsonEncryptorUtil {
  import opened AwsCryptographyDbEncryptionSdkDynamoDbJsonTypes
  import opened Wrappers
  import opened StandardLibrary
  import opened StandardLibrary.UInt

  const ReservedPrefix := "aws_dbe_"
  const MAX_STRUCTURE_DEPTH := 32
  const MAX_STRUCTURE_DEPTH_STR := "32"

  function method E(msg : string) : Error
  {
    JsonEncryptorException(message := msg)
  }

  predicate method ByteLess(x : uint8, y : uint8)
  {
    x < y
  }

  predicate method CharLess(x : char, y : char)
  {
    x < y
  }
}
