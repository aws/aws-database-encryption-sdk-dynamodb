// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "../Model/AwsCryptographyDynamoDbEncryptionTypesWrapped.dfy"

module {:extern "software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.wrapped"} WrappedDynamoDbEncryption refines WrappedAbstractAwsCryptographyDynamoDbEncryptionService
{

  import WrappedService = DynamoDbEncryption

  function method WrappedDefaultDynamoDbEncryptionConfig(): DynamoDbEncryptionConfig
  {
    DynamoDbEncryptionConfig
  }

}
