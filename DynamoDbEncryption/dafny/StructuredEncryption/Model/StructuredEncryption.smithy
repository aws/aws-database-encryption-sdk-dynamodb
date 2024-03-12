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

    //= specification/structured-encryption/encrypt-structure.md#algorithm-suite
    //= type=implication
    //# This algorithm suite MUST be a
    //# [supported suite for Database Encryption (DBE)](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/algorithm-suites.md#supported-algorithm-suites-enum);
    //# otherwise, this operation MUST yield an error.
    algorithmSuiteId: DBEAlgorithmSuiteId,
    encryptionContext: EncryptionContext
}

structure EncryptStructureOutput {
    @required
    encryptedStructure: StructuredDataMap,
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
    encryptedStructure: StructuredDataMap,
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
    plaintextStructure: StructuredDataMap,
    @required
    parsedHeader: ParsedHeader,
}


structure StructureMember {
    key : String
}
structure ListMember {key : Integer}
structure Attribute {key : String}

union StructuredKey {
    member: StructureMember,
    attribute: Attribute,
    list: ListMember
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
    key: StructuredKey,
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

@aws.polymorph#reference(service: aws.cryptography.primitives#AwsCryptographicPrimitives)
structure AtomicPrimitivesReference {}

/////////////
// Errors

@error("client")
structure StructuredEncryptionException {
  @required
  message: String,
}
