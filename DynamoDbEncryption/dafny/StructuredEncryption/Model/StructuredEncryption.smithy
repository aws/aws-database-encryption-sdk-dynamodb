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
    operations: [EncryptStructure, DecryptStructure, EncryptPathStructure, DecryptPathStructure, ResolveAuthActions],
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

operation EncryptPathStructure {
    input: EncryptPathStructureInput,
    output: EncryptPathStructureOutput,
}

operation DecryptPathStructure {
    input: DecryptPathStructureInput,
    output: DecryptPathStructureOutput,
}

operation ResolveAuthActions {
    input: ResolveAuthActionsInput,
    output: ResolveAuthActionsOutput,
}

//= specification/structured-encryption/decrypt-path-structure.md#parsed-header
//= type=implication
//# This structure MUST contain the following values,
//# representing the deserialized form of the header of the input encrypted structure:
//#   - [Algorithm Suite ID](./header.md#format-flavor): The Algorithm Suite ID associated with the Format Flavor on the header.
//#   - [Stored Encryption Context](./header.md#encryption-context): The Encryption Context stored in the header.
//#   - [Encrypted Data Keys](./header.md#encrypted-data-keys): The Encrypted Data Keys stored in the header.
//#   - [Encryption Context](#encryption-context): The full Encryption Context used.

structure ParsedHeader {
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
    plaintextStructure: StructuredDataMap,
    @required
    cryptoSchema: CryptoSchemaMap,
    @required
    cmm: CryptographicMaterialsManagerReference,

    //= specification/structured-encryption/encrypt-structure.md#input
    //= type=implication
    //# The following inputs to this behavior MUST be OPTIONAL:
    // - [Algorithm Suite](#algorithm-suite)
    // - [Encryption Context](#encryption-context)

    //= specification/structured-encryption/encrypt-path-structure.md#algorithm-suite
    //= type=implication
    //# This algorithm suite MUST be a
    //# [supported suite for Database Encryption (DBE)](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/algorithm-suites.md#supported-algorithm-suites-enum);
    //# otherwise, this operation MUST yield an error.
    algorithmSuiteId: DBEAlgorithmSuiteId,
    encryptionContext: EncryptionContext
}

//= specification/structured-encryption/encrypt-path-structure.md#input
//= type=implication
//# The following inputs to this behavior are REQUIRED:
//# - [Table Name](#table-name)
//# - [Crypto List](#crypto-list)
//# - [Cryptographic Materials Manager (CMM)](#cmm)

//= specification/structured-encryption/encrypt-path-structure.md#input
//= type=implication
//# The following inputs to this behavior MUST be OPTIONAL:
//# - [Algorithm Suite](#algorithm-suite)
//# - [Encryption Context](#encryption-context)
structure EncryptPathStructureInput {
    @required
    tableName: String,
    @required
    plaintextStructure: CryptoList,
    @required
    cmm: CryptographicMaterialsManagerReference,
    algorithmSuiteId: DBEAlgorithmSuiteId,
    encryptionContext: EncryptionContext
}

//= specification/structured-encryption/encrypt-structure.md#output
//= type=implication
//# This operation MUST output the following:
//# - [Encrypted Structured Data](encrypt-path-structure.md#encrypted-structured-data)
//# - [Crypto Schema](./structures.md#crypto-schema): The Crypto Schema for each signed Terminal
//# - [Parsed Header](./decrypt-structure.md#parsed-header)
structure EncryptStructureOutput {
    @required
    encryptedStructure: StructuredDataMap,
    @required
    cryptoSchema: CryptoSchemaMap,
    @required
    parsedHeader: ParsedHeader,
}

//= specification/structured-encryption/encrypt-path-structure.md#output
//= type=implication
//# This operation MUST output the following:
//# - [Encrypted Crypto List](#encrypted-crypto-list)
//# - [Parsed Header](./decrypt-structure.md#parsed-header)
structure EncryptPathStructureOutput {
    @required
    encryptedStructure: CryptoList,
    @required
    parsedHeader: ParsedHeader,
}

//= specification/structured-encryption/decrypt-structure.md#input
//= type=implication
//# The following inputs to this behavior are REQUIRED:
// - [Table Name](#table-name)
// - [Authenticate Schema](#authenticate-schema)
// - [Cryptographic Materials Manager (CMM)](#cmm)
// - [Encrypted Structured Data](#encrypted-structured-data)

//= specification/structured-encryption/decrypt-structure.md#input
//= type=implication
//# The following inputs to this behavior MUST be OPTIONAL:
//- [Encryption Context](#encryption-context)
structure DecryptStructureInput {
    @required
    tableName: String,
    @required
    encryptedStructure: StructuredDataMap,
    @required
    authenticateSchema: AuthenticateSchemaMap,
    @required
    cmm: CryptographicMaterialsManagerReference,

    encryptionContext: EncryptionContext,
}

//= specification/structured-encryption/decrypt-path-structure.md#input
//= type=implication
//# The following inputs to this behavior are REQUIRED:
//# - [Table Name](#table-name)
//# - [Cryptographic Materials Manager (CMM)](#cmm)
//# - [Auth List](#auth-list)

//= specification/structured-encryption/decrypt-path-structure.md#input
//= type=implication
//# The following inputs to this behavior MUST be OPTIONAL:
//# - [Encryption Context](#encryption-context)
structure DecryptPathStructureInput {
    @required
    tableName: String,
    @required
    encryptedStructure: AuthList,
    @required
    cmm: CryptographicMaterialsManagerReference,
    encryptionContext: EncryptionContext,
}

//= specification/structured-encryption/decrypt-structure.md#output
//= type=implication
//# This operation MUST output the following:
//# - [Structured Data](decrypt-path-structure.md#structured-data)
//# - [Crypto Schema](./structures.md#crypto-schema): The Crypto Schema for each signed Terminal,
//#   calculated using the Crypto Legend in the header, the signature scope used for decryption, and the data in the input structure.
//# - [Parsed Header](decrypt-path-structure.md#parsed-header)
structure DecryptStructureOutput {
    @required
    plaintextStructure: StructuredDataMap,
    @required
    cryptoSchema: CryptoSchemaMap,
    @required
    parsedHeader: ParsedHeader,
}

//= specification/structured-encryption/decrypt-path-structure.md#output
//= type=implication
//# This operation MUST output the following:
//# - [Crypto List](./structures.md#crypto-list): Decrypted Terminals and the Crypto Schema for each Terminal,
//#   calculated using the Crypto Legend in the header, the signature scope used for decryption, and the data in the input structure.
//# - [Parsed Header](#parsed-header)
structure DecryptPathStructureOutput {
    @required
    plaintextStructure: CryptoList,
    @required
    parsedHeader: ParsedHeader,
}

//= specification/structured-encryption/resolve-auth-actions.md#input
//= type=implication
//# The following inputs to this behavior are REQUIRED:
//# - [Table Name](#table-name)
//# - [Auth List](#auth-list)
//# - [Header Bytes](#header-bytes)
structure ResolveAuthActionsInput {
    @required
    tableName: String,
    @required
    authActions: AuthList,
    @required
    headerBytes: Blob
}

//= specification/structured-encryption/resolve-auth-actions.md#output
//= type=implication
//# This operation MUST output the following:
//# [Crypto List](./structures.md#crypto-list): Input terminal data and the Crypto Schema for each Terminal,
//#   calculated using the Crypto Legend in the header, the signature scope used for decryption, and the data in the input structure.
structure ResolveAuthActionsOutput {
    @required
    cryptoActions: CryptoList,
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
    key: String,
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
    key: String,
    value: AuthenticateAction
}

structure StructureSegment {@required key : String}
// Not needed now, but easy to add later
// @range(min:0)
// integer Position
// structure ListSegment {@required key : Position}
// structure AttributeSegment {@required key : String}

//= specification/structured-encryption/structures.md#path-segment
//= type=implication
//# A path segment MUST be a string, designating the name of a member of a structure.
union PathSegment {
    member: StructureSegment,
    // Not needed now, but easy to add later
    // list: ListSegment,
    // attribute: AttributeSegment,
}
list Path {
    member: PathSegment
}

//= specification/structured-encryption/structures.md#crypto-item
//= type=implication
//# A crypto item MUST consist of
//# - a [Path](#path)
//# - a [Crypto Action](#crypto-action)
//# - a [Terminal Data](#terminal-data)
structure CryptoItem {
    @required
    key : Path,
    @required
    data: StructuredDataTerminal,
    @required
    action: CryptoAction,
}

//= specification/structured-encryption/structures.md#crypto-list
//= type=implication
//# A crypto list MUST be a sequence of [crypto item](#crypto-item)
list CryptoList {
    member: CryptoItem,
}

//= specification/structured-encryption/structures.md#auth-item
//= type=implication
//# An auth item MUST consist of
//# - a [Path](#path)
//# - an [Authenticate Action](#authenticate-action)
//# - a [Terminal Data](#terminal-data)
structure AuthItem {
    @required
    key : Path,
    @required
    data: StructuredDataTerminal,
    @required
    action: AuthenticateAction,
}

//= specification/structured-encryption/structures.md#auth-list
//= type=implication
//# An auth list MUST be a sequence of [auth item](#auth-item)
list AuthList {
    member: AuthItem,
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
