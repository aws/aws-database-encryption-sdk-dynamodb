// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
namespace aws.cryptography.dbEncryptionSdk.dynamoDb.json

use aws.polymorph#localService
use aws.polymorph#javadoc
use aws.polymorph#dafnyUtf8Bytes

use aws.cryptography.materialProviders#KeyringReference
use aws.cryptography.materialProviders#CryptographicMaterialsManagerReference
use aws.cryptography.materialProviders#DBEAlgorithmSuiteId
use aws.cryptography.materialProviders#EncryptedDataKeyList
use aws.cryptography.materialProviders#EncryptionContext
// use aws.cryptography.encryptionSdk#FrameLength

use aws.cryptography.materialProviders#AwsCryptographicMaterialProviders
use aws.cryptography.primitives#AwsCryptographicPrimitives
use aws.cryptography.dbEncryptionSdk.structuredEncryption#StructuredEncryption
use aws.cryptography.dbEncryptionSdk.structuredEncryption#CryptoAction

@localService(
  sdkId: "JsonEncryptor",
  config: JsonEncryptorConfig,
  dependencies: [
    AwsCryptographicPrimitives,
    AwsCryptographicMaterialProviders,
    StructuredEncryption,
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

// Json structure. One day, we should add `Document` to allow language's JSON format
union Json {
  utf8 : Utf8Bytes,
  text : String
}

// Associate a CryptoAction with a member name
map MemberActions {
    key: String,
    value: Action,
}

union Action {
  crypto : CryptoAction,
  dbesdk : JsonEncrypt
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
  encryptionContext: aws.cryptography.materialProviders#EncryptionContext,
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
    output: EncryptObjectOutput,
}

@javadoc("Decrypt a Json object.")
operation DecryptObject {
    input: DecryptObjectInput,
    output: DecryptObjectOutput,
}

@javadoc("Inputs for encrypting a JSON object.")
structure EncryptObjectInput {
    @required
    @javadoc("The JSON object to encrypt.")
    plaintextObject: Json,
}

@javadoc("Outputs for encrypting a JSON object.")
structure EncryptObjectOutput {
    @required
    @javadoc("The encrypted JSON object.")
    encryptedObject: Json,

    @javadoc("A parsed version of the header written with the encrypted JSON object.")
    parsedHeader: ParsedHeader,
}

@javadoc("Inputs for decrypting a JSON object.")
structure DecryptObjectInput {
    @required
    @javadoc("The encrypted JSON object to decrypt.")
    encryptedObject: Json,
}

@javadoc("Outputs for decrypting a JSON object.")
structure DecryptObjectOutput {
    @required
    @javadoc("The decrypted JSON object.")
    plaintextObject: Json,

    @javadoc("A parsed version of the header on the encrypted JSON object.")
    parsedHeader: ParsedHeader,
}

@aws.polymorph#reference(service: aws.cryptography.primitives#AwsCryptographicPrimitives)
structure AtomicPrimitivesReference {}
@aws.polymorph#reference(service: aws.cryptography.dbEncryptionSdk.structuredEncryption#StructuredEncryption)
structure StructuredEncryptionReference {}

/////////////
// Errors

@error("client")
structure JsonEncryptorException {
  @required
  message: String,
}
