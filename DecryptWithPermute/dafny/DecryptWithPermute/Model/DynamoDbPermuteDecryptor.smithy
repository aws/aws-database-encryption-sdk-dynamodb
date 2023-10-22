// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
namespace aws.cryptography.dbEncryptionSdk.decryptWithPermute

use aws.polymorph#localService
use aws.polymorph#javadoc
use aws.polymorph#reference

use aws.cryptography.dbEncryptionSdk.dynamoDb.itemEncryptor#DynamoDbItemEncryptorConfig
use aws.cryptography.dbEncryptionSdk.dynamoDb.itemEncryptor#DecryptItemInput
use aws.cryptography.dbEncryptionSdk.dynamoDb.itemEncryptor#DecryptItemOutput

use aws.cryptography.dbEncryptionSdk.structuredEncryption#StructuredEncryption
use aws.cryptography.dbEncryptionSdk.dynamoDb.itemEncryptor#DynamoDbItemEncryptor
use aws.cryptography.dbEncryptionSdk.dynamoDb#DynamoDbEncryption
use aws.cryptography.materialProviders#AwsCryptographicMaterialProviders


@localService(
  sdkId: "DynamoDbPermuteDecryptor",
  config: DynamoDbPermuteDecryptorConfig,
  dependencies: [
    AwsCryptographicMaterialProviders,
    StructuredEncryption,
    DynamoDbItemEncryptor,
    DynamoDbEncryption
  ]
)
service DynamoDbPermuteDecryptor {
    version: "2022-08-26",
    operations: [PermuteDecrypt],
    errors: [DynamoDbPermuteDecryptorException],
}

@javadoc("The configuration for the client-side encryption of DynamoDB items.")
structure DynamoDbPermuteDecryptorConfig {
    @required
    inner: DynamoDbItemEncryptorConfig
}


@javadoc("Decrypt a DynamoDB Item, permute sets as necessary to match signature.")
operation PermuteDecrypt {
    input: PermuteDecryptInput,
    output: PermuteDecryptOutput
}

structure PermuteDecryptInput {
    @required
    inner: DecryptItemInput,
    @required
    @range(min: 0)
    maxSetSize: Integer 
}

@javadoc("Outputs for decrypting a DynamoDB Item.")
structure PermuteDecryptOutput {
    @required
    inner: DecryptItemOutput,
    @required
    didPermute: Boolean
}

@aws.polymorph#reference(service: aws.cryptography.dbEncryptionSdk.dynamoDb#DynamoDbEncryption)
structure DynamoDbEncryptionReference {}

@aws.polymorph#reference(service: aws.cryptography.materialProviders#AwsCryptographicMaterialProviders)
structure AwsCryptographicMaterialProvidersReference {}

@aws.polymorph#reference(service: aws.cryptography.dbEncryptionSdk.structuredEncryption#StructuredEncryption)
structure StructuredEncryptionReference {}

/////////////
// Errors

@error("client")
structure DynamoDbPermuteDecryptorException {
  @required
  message: String,
}

