// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
namespace aws.cryptography.dbEncryptionSdk.structuredEncryption

use aws.cryptography.materialProviders#CryptographicMaterialsManagerReference
use aws.cryptography.materialProviders#DBEAlgorithmSuiteId
use aws.cryptography.materialProviders#EncryptedDataKeyList
use aws.cryptography.materialProviders#EncryptionContext

use aws.cryptography.primitives#AwsCryptographicPrimitives
use aws.cryptography.materialProviders#AwsCryptographicMaterialProviders

use aws.polymorph#localService

@localService(
  sdkId: "StructuredEncryption",
  config: StructuredEncryptionConfig,
  dependencies: [
    AwsCryptographicPrimitives,
    AwsCryptographicMaterialProviders
  ]
)
service StructuredEncryption {
    version: "2022-07-08",
    operations: [EncryptStructure, DecryptStructure, EncryptStructureFlat, DecryptStructureFlat],
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

operation EncryptStructureFlat {
    input: EncryptStructureFlatInput,
    output: EncryptStructureFlatOutput,
}

operation DecryptStructureFlat {
    input: DecryptStructureFlatInput,
    output: DecryptStructureFlatOutput,
}


//= specification/structured-encryption/decrypt-structure.md#parsed-header
//= type=implication
//# This structure MUST contain the following values,
//# representing the deserialized form of the header of the input encrypted structure:
//#   - [Algorithm Suite ID](./header.md#format-flavor): The Algorithm Suite ID associated with the Format Flavor on the header.
//#   - [Crypto Schema](./header.md#encrypt-legend): The Crypto Schema for each signed Terminal,
//#     calculated using the Crypto Legend in the header, the signature scope used for decryption, and the data in the input structure.
//#   - [Stored Encryption Context](./header.md#encryption-context): The Encryption Context stored in the header.
//#   - [Encrypted Data Keys](./header.md#encrypted-data-keys): The Encrypted Data Keys stored in the header.
//#   - [Encryption Context](#encryption-context): The full Encryption Context used.

structure ParsedHeader {
    @required
    cryptoSchema: CryptoSchemaMap,
    @required
    algorithmSuiteId: DBEAlgorithmSuiteId,
    @required
    encryptedDataKeys: EncryptedDataKeyList,
    @required
    storedEncryptionContext: EncryptionContext,
    @required
    encryptionContext: EncryptionContext
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
    cryptoSchema: CryptoSchemaMap,
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
    //# [supported suite for Database Encryption (DBE)](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/algorithm-suites.md#supported-algorithm-suites-enum);
    //# otherwise, this operation MUST yield an error.
    algorithmSuiteId: DBEAlgorithmSuiteId,
    encryptionContext: EncryptionContext
}

//= specification/structured-encryption/encrypt-structure.md#output
//= type=implication
//# This operation MUST output the following:
//# - [Encrypted Structured Data](#encrypted-structured-data)
//# - [Parsed Header](./decrypt-structure.md#parsed-header)
structure EncryptStructureOutput {
    @required
    encryptedStructure: StructuredData,
    @required
    parsedHeader: ParsedHeader,
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
    authenticateSchema: AuthenticateSchemaMap,
    @required
    cmm: CryptographicMaterialsManagerReference,

    //= specification/structured-encryption/decrypt-structure.md#input
    //= type=implication
    //# The following inputs to this behavior MUST be OPTIONAL:
    //- [Encryption Context](#encryption-context)
    encryptionContext: EncryptionContext,
}

structure DecryptStructureOutput {
    //= specification/structured-encryption/decrypt-structure.md#output
    //= type=implication
    //# This operation MUST output the following:
    //#   - [Structured Data](#structured-data)
    //#   - [Parsed Header](#parsed-header)
    @required
    plaintextStructure: StructuredData,
    @required
    parsedHeader: ParsedHeader,
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
// - [Terminal Data](#terminal-data)
// - [Structured Data Map](#structured-data-map)
// - [Structured Data List](#structured-data-list)
union StructuredDataContent {
    Terminal: StructuredDataTerminal,
    DataList: StructuredDataList,
    DataMap: StructuredDataMap
}

union StructuredKey {
    key: String,
    attribute: String,
    KeyList: StructuredKeyList,
    KeyMap: StructuredKeyMap
}
map StructuredKeyMap {
    key: String,
    value: StructuredKey
}
list StructuredKeyList {
    member: StructuredKey
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

@enum([
    {
        "name": "ENCRYPT_AND_SIGN",
        "value": "ENCRYPT_AND_SIGN",
    },
    {
        "name": "SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT",
        "value": "SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT",
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
    key: StructuredKey,
    value: CryptoAction
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
    key: StructuredKey,
    value: AuthenticateAction
}

structure EncryptStructureFlatInput {
    @required
    plaintextStructure: StructuredDataFlat,
    @required
    cryptoSchema: CryptoSchemaMapFlat,
    @required
    cmm: CryptographicMaterialsManagerReference,
    algorithmSuiteId: DBEAlgorithmSuiteId,
    encryptionContext: EncryptionContext
}

structure EncryptStructureFlatOutput {
    @required
    encryptedStructure: StructuredDataFlat,
    @required
    parsedHeader: ParsedHeader,
}

structure DecryptStructureFlatInput {
    @required
    encryptedStructure: StructuredDataFlat,
    @required
    authenticateSchema: AuthenticateSchemaMap,
    @required
    cmm: CryptographicMaterialsManagerReference,
    encryptionContext: EncryptionContext,
}

structure DecryptStructureFlatOutput {
    @required
    encryptedStructure: StructuredDataFlat,
    @required
    parsedHeader: ParsedHeader,
}


// all attributes in flat interface are signed
@enum([
    {
        "name": "ENCRYPT",
        "value": "ENCRYPT",
    },
    {
        "name": "DO_NOT_ENCRYPT",
        "value": "DO_NOT_ENCRYPT",
    },
])
string AuthenticateActionFlat

// all attributes in flat interface are signed
// encryption context is the responsibility of the caller
@enum([
    {
        "name": "ENCRYPT_AND_SIGN",
        "value": "ENCRYPT_AND_SIGN",
    },
    {
        "name": "SIGN_ONLY",
        "value": "SIGN_ONLY",
    }
])
string CryptoActionFlat


map AuthenticateSchemaMapFlat {
    key: Blob,
    value: AuthenticateActionFlat
}
map CryptoSchemaMapFlat {
    key: Blob,
    value: CryptoActionFlat
}
map StructuredDataFlat {
    key: Blob,
    value: Blob
}

@aws.polymorph#reference(service: aws.cryptography.primitives#AwsCryptographicPrimitives)
structure AtomicPrimitivesReference {}

/////////////
// Errors

@error("client")
structure StructuredEncryptionException {
  @required
  message: String,
}
