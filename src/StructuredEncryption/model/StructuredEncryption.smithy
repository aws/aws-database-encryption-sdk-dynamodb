// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
namespace aws.cryptography.structuredEncryption

use aws.polymorph#localService

// TODO: Bikeshed on name "StructuredEncryption"
@aws.polymorph#localService(
  sdkId: "StructuredEncryption",
  config: StructuredEncryptionConfig,
)
service StructuredEncryption {
    version: "2022-07-08",
    operations: [EncryptStructure, DecryptStructure]
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
    cryptoSchema: CryptoSchema
    // CMM/Keyring
    // EncryptionContext (stored and not stored)
}

structure EncryptStructureOutput {
    @required
    ciphertextStructure: StructuredData
}

structure DecryptStructureInput {
    @required
    ciphertextStructure: StructuredData,
    // TODO the below should be a map
    @required
    cryptoSchema: CryptoSchema
    // CMM/Keyring
    // EncryptionContext (stored and not stored)
}

structure DecryptStructureOutput {
    @required
    plaintextStructure: StructuredData
}

structure StructuredData {
    // Each "node" in our structured data hold either
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