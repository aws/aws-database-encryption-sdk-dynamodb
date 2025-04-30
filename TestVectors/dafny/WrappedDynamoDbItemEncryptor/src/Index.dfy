// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Empty stub expected by Smithy-Dafny

include "../../../../DynamoDbEncryption/dafny/DynamoDbItemEncryptor/src/Index.dfy"
include "../Model/AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypesWrapped.dfy"
module {:extern "software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.wrapped" } WrappedItemEncryptor refines WrappedAbstractAwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorService {

  import DynamoDbItemEncryptor

  function method WrappedDefaultDynamoDbItemEncryptorConfig(): DynamoDbItemEncryptorConfig
  {
    DynamoDbItemEncryptor.DefaultDynamoDbItemEncryptorConfig()
  }
}
