// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
namespace aws.cryptography.structuredEncryption

use aws.cryptography.materialProviders#CryptographicMaterialsManagerReference
use aws.cryptography.materialProviders#DBEAlgorithmSuiteId
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
    //= specification/structured-encryption/encrypt-structure.md#input
    //= type=implication
    //# The following inputs to this behavior are REQUIRED:
    // - [Table Name](#table-name)
    // - [Structured Data](#structured-data)
    // - [Crypto Schema](#crypto-schema)
    // - [Cryptographic Materials Manager (CMM)](#cmm)
    @required
    tableName: String,
    @required
    plaintextStructure: StructuredData,
    @required
    cryptoSchema: CryptoSchema,
    @required
    cmm: CryptographicMaterialsManagerReference,

    //= specification/structured-encryption/encrypt-structure.md#input
    //= type=implication
    //# The following inputs to this behavior MUST be OPTIONAL:
    // - [Algorithm Suite](#algorithm-suite)
    // - [Encryption Context](#encryption-context)

    //= specification/structured-encryption/encrypt-structure.md#algorithm-suite
    //= type=implication
    //# This algorithm suite MUST be a
    //# [supported suite for Database Encryption (DBE)](../../private-aws-encryption-sdk-dafny-staging/aws-encryption-sdk-specification/framework/algorithm-suites.md#supported-algorithm-suites-enum);
    //# otherwise, this operation MUST yield an error.
    algorithmSuiteId: DBEAlgorithmSuiteId,
    encryptionContext: EncryptionContext
}

structure EncryptStructureOutput {
    @required
    encryptedStructure: StructuredData
}

structure DecryptStructureInput {
    //= specification/structured-encryption/decrypt-structure.md#input
    //= type=implication
    //# The following inputs to this behavior are REQUIRED:
    // - [Table Name](#table-name)
    // - [Authenticate Schema](#authenticate-schema)
    // - [Cryptographic Materials Manager (CMM)](#cmm)
    // - [Encrypted Structured Data](#encrypted-structured-data)
    @required
    tableName: String,
    @required
    encryptedStructure: StructuredData,
    @required
    authenticateSchema: AuthenticateSchema,
    @required
    cmm: CryptographicMaterialsManagerReference,

    //= specification/structured-encryption/decrypt-structure.md#input
    //= type=implication
    //# The following inputs to this behavior MUST be OPTIONAL:
    //- [Encryption Context](#encryption-context)
    encryptionContext: EncryptionContext,
}

structure DecryptStructureOutput {
    @required
    plaintextStructure: StructuredData
}


structure StructuredData {
    // Each "node" in our structured data holds either
    // a map of more data, a list of more data, or a terminal value
    //= specification/structured-encryption/structures.md#structured-data
    //= type=implication
    //# A Structured Data MUST consist of:
    // - a [Structured Data Content](#structured-data-content)
    @required
    content: StructuredDataContent,

    // Each "node" in our structured data may additionally
    // have a flat map to express something akin to XML attributes
    //= specification/structured-encryption/structures.md#structured-data
    //= type=implication
    //# - an OPTIONAL map of [Attributes](#structured-data-attributes)
    attributes: StructuredDataAttributes
}

//= specification/structured-encryption/structures.md#structured-data-content
//= type=implication
//# Structured Data Content is a union of one of three separate structures;
//# Structured Data Content MUST be one of:
// - [Structured Data Terminal](#structured-data-terminal)
// - [Structured Data Map](#structured-data-map)
// - [Structured Data List](#structured-data-list)
union StructuredDataContent {
    Terminal: StructuredDataTerminal,
    DataList: StructuredDataList,
    DataMap: StructuredDataMap
}

// Only handles bytes.
// It is the responsibility of the caller to
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

//= specification/structured-encryption/structures.md#terminal-value
//= type=implication
//# Terminal Value MUST be a sequence of bytes, and MAY be empty (zero-length).
blob TerminalValue

//= specification/structured-encryption/structures.md#terminal-type-id
//= type=implication
//# A Terminal Type ID MUST be a 2 byte value that is used to identify how callers interpret [Terminal Value](#terminal-value).
@length(min: 2, max: 2)
blob TerminalTypeId

//= specification/structured-encryption/structures.md#structured-data-map
//= type=implication
//# A Structured Data Map MUST consist of:
// - A map strings to [Structured Data](#structured-data)

//= specification/structured-encryption/structures.md#structured-data-map
//= type=implication
//# - This map MUST NOT allow duplicate key values
map StructuredDataMap {
    key: String,
    value: StructuredData
}

//= specification/structured-encryption/structures.md#structured-data-list
//= type=implication
//# A Structured Data List MUST consist of:
// - A numerical-indexed array of [Structured Data](#structured-data).
list StructuredDataList {
    member: StructuredData
}

//= specification/structured-encryption/structures.md#structured-data-attributes
//= type=implication
//# Structured Data Attributes MUST be map of strings to [Terminal Data](#terminal-data).
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

@aws.polymorph#reference(service: aws.cryptography.primitives#AwsCryptographicPrimitives)
structure AtomicPrimitivesReference {}

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
