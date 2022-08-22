// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
namespace aws.cryptography.structuredEncryption

use aws.cryptography.materialProviders#KeyringReference
use aws.cryptography.materialProviders#CryptographicMaterialsManagerReference
use aws.cryptography.materialProviders#EncryptionContext

use aws.polymorph#localService
use aws.polymorph#dafnyUtf8Bytes

@dafnyUtf8Bytes
string Utf8Bytes

@aws.polymorph#localService(
  sdkId: "StructuredEncryption",
  config: StructuredEncryptionConfig,
)
service StructuredEncryption {
    version: "2022-07-08",
    operations: [EncryptStructure, DecryptStructure],
    errors: [StructuredEncryptionException]
}

structure StructuredEncryptionConfig {
}

operation EncryptStructure {
    input: EncryptStructureInput,
    output: EncryptStructureOutput,
}

operation DecryptStructure {
    input: DecryptStructureInput,
    output: DecryptStructureOutput,
}

structure EncryptStructureInput {
    @required
    plaintextStructure: StructuredData,
    @required
    cryptoSchema: CryptoSchema,

    // A Keyring XOR a CMM MUST be specified
    keyring: KeyringReference,
    cmm: CryptographicMaterialsManagerReference,

    encryptionContext: EncryptionContext,
    contextFieldsRequiredOnDecrypt: EncryptionContextFieldList
}

structure EncryptStructureOutput {
    @required
    ciphertextStructure: StructuredData
}

structure DecryptStructureInput {
    @required
    ciphertextStructure: StructuredData,
    @required
    cryptoSchemas: CryptoSchemas,

    // A Keyring XOR a CMM MUST be specified
    keyring: KeyringReference,
    cmm: CryptographicMaterialsManagerReference,

    encryptionContext: EncryptionContext,
}

structure DecryptStructureOutput {
    @required
    plaintextStructure: StructuredData
}

// TODO move to MPL
// TODO this is better represented as a set
list EncryptionContextFieldList {
    member: Utf8Bytes
}

structure StructuredData {
    // Each "node" in our structured data holds either
    // a map of more data, a list of more data, or a terminal value
    @required
    content: StructuredDataContent,
    // Each "node" in our structured data may additionally
    // have a flat map to express something akin to XML attributes
    attributes: StructuredDataAttributes
}

union StructuredDataContent {
    terminal: Terminal,
    dataList: StructuredDataList,
    dataMap: StructuredDataMap
}

// Only handles bytes.
// It is the reponsibility of the caller to
// serialize and deserialize the data they
// encrypt/decrypt with this SDK.
blob Terminal

map StructuredDataMap {
    key: String,
    value: StructuredData
}

list StructuredDataList {
    member: StructuredData
}

map StructuredDataAttributes {
    key: String,
    value: Terminal
}

// This mimics the same structure as StructuredData above,
// only it's "leaves" are CryptoAction instead of Terminal.
structure CryptoSchema {
    @required
    content: CryptoSchemaContent,
    attributes: CryptoSchemaAttributes
}

union CryptoSchemaContent {
    action: CryptoAction,
    mapSchema: CryptoSchemaMap,
    listSchema: CryptoSchemaList
}

@enum([
    {
        "name": "ENCRYPT_AND_SIGN",
        "value": "ENCRYPT_AND_SIGN",
     },
     {
         "name": "SIGN_ONLY",
         "value": "SIGN_ONLY",
      },
      {
          "name": "IGNORE",
          "value": "IGNORE",
      },
])
string CryptoAction

map CryptoSchemaMap {
    key: String,
    value: CryptoSchema
}

list CryptoSchemaList {
    member: CryptoSchema
}

map CryptoSchemaAttributes {
    key: String,
    value: CryptoAction
}

map CryptoSchemas {
    key: CryptoSchemaVersion,
    value: CryptoSchema
}

string CryptoSchemaVersion

/////////////
// Errors

@error("client")
structure StructuredEncryptionException {
  @required
  message: String,
}