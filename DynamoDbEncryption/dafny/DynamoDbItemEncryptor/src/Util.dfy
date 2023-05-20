// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "../Model/AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.dfy"

module DynamoDbItemEncryptorUtil {
  import opened AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes
  import opened Wrappers
  import opened StandardLibrary
  import opened StandardLibrary.UInt

  const ReservedPrefix := "aws_dbe_"
  const BeaconPrefix := ReservedPrefix + "b_"
  const VersionPrefix := ReservedPrefix + "v_"
  const MAX_ATTRIBUTE_COUNT := 100

  function method E(msg : string) : Error
  {
    DynamoDbItemEncryptorException(message := msg)
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
