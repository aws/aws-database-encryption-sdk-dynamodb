// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
namespace aws.cryptography.dbEncryptionSdk.dynamoDb.json

use aws.cryptography.dbEncryptionSdk.structuredEncryption#CryptoAction
use aws.cryptography.dbEncryptionSdk.structuredEncryption#StructuredEncryption
use aws.cryptography.materialProviders#AwsCryptographicMaterialProviders
use aws.cryptography.materialProviders#CryptographicMaterialsManagerReference
use aws.cryptography.materialProviders#DBEAlgorithmSuiteId
use aws.cryptography.materialProviders#EncryptedDataKeyList
use aws.cryptography.materialProviders#EncryptionContext
use aws.cryptography.materialProviders#KeyringReference
use aws.cryptography.primitives#AwsCryptographicPrimitives
use aws.polymorph#dafnyUtf8Bytes
use aws.polymorph#javadoc
use aws.polymorph#localService

@localService(
    sdkId: "JsonEncryptor",
    config: JsonEncryptorConfig,
    dependencies: [
        AwsCryptographicPrimitives,
        AwsCryptographicMaterialProviders,
        StructuredEncryption
    ]
)
service JsonEncryptor {
    version: "2024-02-14",
    operations: [EncryptObject, DecryptObject],
    errors: [JsonEncryptorException]
}

@dafnyUtf8Bytes
string Utf8Bytes

// list of member names, JSONPath format
list MemberNameList {
    member: String
}

@enum([
  {
    name: "FORCE_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ",
    value: "FORCE_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ",
  },
  {
    name: "FORBID_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ",
    value: "FORBID_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ",
  },
  {
    name: "FORBID_PLAINTEXT_WRITE_FORBID_PLAINTEXT_READ",
    value: "FORBID_PLAINTEXT_WRITE_FORBID_PLAINTEXT_READ",
  },
])
string PlaintextOverride

// Json structure. One day, we should add `Document` to allow language's JSON format
union Json {
    utf8: Utf8Bytes,
    text: String
}

// Associate a CryptoAction with a member name
map MemberActions {
    key: String,
    value: CryptoAction
}

// if A.B is in MemberEncrypt,
// then we collect all the A.B.* from MemberActions and DecoyMap and make a separate config.
// encrypt the object then replace all the A.B.* with "A.B => SIGN_ONLY"
map MemberEncrypt {
    key: String,
    value: JsonEncrypt
}

// if A.B in DecoyMap then encrypted object has "A.B" : value
// and encrypted bytes are in A.aws_dbe_a_B
map DecoyMap {
    key: String,
    // must refer to something that is ENCRYPT_AND_SIGN
    value: String// Should this be `Json`?
}

structure JsonEncrypt {
    // Requires a Keyring XOR a CMM
    @javadoc("The Keyring that should be used to wrap and unwrap data keys. If specified a Default Cryptographic Materials Manager with this Keyring is used to obtain materials for encryption and decryption. Either a Keyring or a Cryptographic Materials Manager must be specified.")
    keyring: KeyringReference,
    @javadoc("The Cryptographic Materials Manager that is used to obtain materials for encryption and decryption.  Either a Keyring or a Cryptographic Materials Manager must be specified.")
    cmm: CryptographicMaterialsManagerReference,
    @javadoc("An ID for the algorithm suite to use during encryption and decryption.")
    algorithmSuiteId: DBEAlgorithmSuiteId,
    @javadoc("Extra key-value pairs to include in the required encryption context.")
    encryptionContext: aws.cryptography.materialProviders#EncryptionContext
}

@javadoc("The configuration for the client-side encryption of JSON objects.")
structure JsonEncryptorConfig {
    @required
    @javadoc("The is the name that is cryptographically bound with your data.")
    domain: String,

    @required
    @javadoc("A map that describes which members should be encrypted and/or signed on encrypt.")
    memberActionsOnEncrypt: MemberActions,

    @javadoc("A list of member names such that, if encountered during decryption, those members are treated as unsigned.")
    allowedUnsignedMembers: MemberNameList,

    @javadoc("A prefix such that, if during decryption any member has a name with this prefix, it is treated as unsigned.")
    allowedUnsignedMemberPrefix: String,

    @required
    @javadoc("Setting for encryption and decryption.")
    encrypt: JsonEncrypt,

    @javadoc("Encrypt this part separately, with different materials.")
    nestedEncryption: MemberEncrypt,

    @javadoc("These members are replaced by the decoy value, encrypted bytes hidden elsewhere. Member must be same type as decoy value.")
    decoys: DecoyMap,

    @javadoc("A configuration that overrides encryption and/or decryption to instead pass through and write and/or read plaintext. Used to update plaintext processes to fully use client-side encryption.")
    plaintextOverride: PlaintextOverride
}

@javadoc("A parsed version of the header that was written with or read on an encrypted Json object.")
structure ParsedHeader {
    @required
    @javadoc("The non-DO_NOTHING Crypto Actions that were configured when this object was originally encrypted.")
    memberActionsOnEncrypt: MemberActions,

    @required
    @javadoc("The ID of the algorithm suite that was used to encrypt this object.")
    algorithmSuiteId: DBEAlgorithmSuiteId,

    @required
    @javadoc("The encrypted data keys that are stored in the header of this object.")
    encryptedDataKeys: EncryptedDataKeyList,

    @required
    @javadoc("The portion of the encryption context that was stored in the header of this object.")
    storedEncryptionContext: EncryptionContext,

    @required
    @javadoc("The full encryption context.")
    encryptionContext: EncryptionContext
}

@javadoc("Encrypt a Json object.")
operation EncryptObject {
    input: EncryptObjectInput,
    output: EncryptObjectOutput
}

@javadoc("Decrypt a Json object.")
operation DecryptObject {
    input: DecryptObjectInput,
    output: DecryptObjectOutput
}

@javadoc("Inputs for encrypting a JSON object.")
structure EncryptObjectInput {
    @required
    @javadoc("The JSON object to encrypt.")
    plaintextObject: Json
}

@javadoc("Outputs for encrypting a JSON object.")
structure EncryptObjectOutput {
    @required
    @javadoc("The encrypted JSON object.")
    encryptedObject: Json,
    @javadoc("A parsed version of the header written with the encrypted JSON object.")
    parsedHeader: ParsedHeader
}

@javadoc("Inputs for decrypting a JSON object.")
structure DecryptObjectInput {
    @required
    @javadoc("The encrypted JSON object to decrypt.")
    encryptedObject: Json
}

@javadoc("Outputs for decrypting a JSON object.")
structure DecryptObjectOutput {
    @required
    @javadoc("The decrypted JSON object.")
    plaintextObject: Json,
    @javadoc("A parsed version of the header on the encrypted JSON object.")
    parsedHeader: ParsedHeader
}

@aws.polymorph#reference(service: aws.cryptography.primitives#AwsCryptographicPrimitives)
structure AtomicPrimitivesReference {}

@aws.polymorph#reference(
    service: aws.cryptography.dbEncryptionSdk.structuredEncryption#StructuredEncryption
)
structure StructuredEncryptionReference {}

/// //////////
// Errors
@error("client")
structure JsonEncryptorException {
    @required
    message: String
}
