// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "../Model/AwsCryptographyDynamoDbItemEncryptorTypes.dfy"

module DynamoDbItemEncryptorUtil {
  import opened AwsCryptographyDynamoDbItemEncryptorTypes
  
  function method E(msg : string) : Error
  {
    DynamoDbItemEncryptorException(message := msg)
  }
}
