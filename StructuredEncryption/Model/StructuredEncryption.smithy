// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
namespace aws.cryptography.structuredEncryption

use aws.cryptography.materialProviders#CryptographicMaterialsManagerReference
use aws.cryptography.materialProviders#EncryptionContext

use aws.polymorph#localService

@localService(
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
    @required
    cmm: CryptographicMaterialsManagerReference,

    // TODO Truss-compatible Algorithm Suite.

    encryptionContext: EncryptionContext,
}

structure EncryptStructureOutput {
    @required
    encryptedStructure: StructuredData
}

structure DecryptStructureInput {
    @required
    encryptedStructure: StructuredData,
    @required
    authenticateSchema: AuthenticateSchema,
    @required
    cmm: CryptographicMaterialsManagerReference,

    encryptionContext: EncryptionContext,
}

structure DecryptStructureOutput {
    @required
    plaintextStructure: StructuredData
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
    Terminal: StructuredDataTerminal,
    DataList: StructuredDataList,
    DataMap: StructuredDataMap
}

// Only handles bytes.
// It is the reponsibility of the caller to
// serialize and deserialize the data they
// encrypt/decrypt with this Library.
structure StructuredDataTerminal {
    @required
    value: TerminalValue,
    // Type information is treated specially
    // during authentication, so this MUST
    // be encoded as part of `typeId`,
    // and SHOULD NOT be serialized as part
    // of `value`
    @required
    typeId: TerminalTypeId
}

blob TerminalValue

@length(min: 2, max: 2)
blob TerminalTypeId

map StructuredDataMap {
    key: String,
    value: StructuredData
}

list StructuredDataList {
    member: StructuredData
}

map StructuredDataAttributes {
    key: String,
    value: StructuredDataTerminal
}

// This mimics the same structure as StructuredData above,
// only it's "leaves" are AuthenticateAction instead of Terminal.
structure CryptoSchema {
    @required
    content: CryptoSchemaContent,
    attributes: CryptoSchemaAttributes
}

union CryptoSchemaContent {
    Action: CryptoAction,
    SchemaMap: CryptoSchemaMap,
    SchemaList: CryptoSchemaList
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
        "name": "DO_NOTHING",
        "value": "DO_NOTHING",
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
    value: AuthenticateAction
}

// This mimics the same structure as StructuredData above,
// only it's "leaves" are AuthenticateAction instead of Terminal.
structure AuthenticateSchema {
    @required
    content: AuthenticateSchemaContent,
    attributes: AuthenticateSchemaAttributes
}

union AuthenticateSchemaContent {
    Action: AuthenticateAction,
    SchemaMap: AuthenticateSchemaMap,
    SchemaList: AuthenticateSchemaList
}

@enum([
    {
        "name": "SIGN",
        "value": "SIGN",
    },
    {
        "name": "DO_NOT_SIGN",
        "value": "DO_NOT_SIGN",
    },
])
string AuthenticateAction

map AuthenticateSchemaMap {
    key: String,
    value: AuthenticateSchema
}

list AuthenticateSchemaList {
    member: AuthenticateSchema
}

map AuthenticateSchemaAttributes {
    key: String,
    value: AuthenticateAction
}

// TODO: Is there a way in smithy we can ensure that the
// StructuredData/CryptoSchema/AuthenticateSchema all
// express the same complex shape?

/////////////
// Errors

@error("client")
structure StructuredEncryptionException {
  @required
  message: String,
}
