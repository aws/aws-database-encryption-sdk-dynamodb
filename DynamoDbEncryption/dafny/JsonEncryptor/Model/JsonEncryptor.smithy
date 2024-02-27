// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
namespace aws.cryptography.dbEncryptionSdk.dynamoDb.json

// use smithy.api#Unit

use aws.polymorph#localService
use aws.polymorph#javadoc
use aws.polymorph#dafnyUtf8Bytes

use aws.cryptography.materialProviders#KeyringReference
use aws.cryptography.materialProviders#CryptographicMaterialsManagerReference
use aws.cryptography.materialProviders#DBEAlgorithmSuiteId
use aws.cryptography.materialProviders#EncryptedDataKeyList
use aws.cryptography.materialProviders#EncryptionContext

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

// list of member names
list AttributeNameList {
  member: String
}

// Json structure. One day, we should add `Document`
union Json {
  utf8 : Utf8Bytes,
  text : String
}


// Associate a CryptoAction with a member name
map AttributeActions {
    key: String,
    value: CryptoAction,
}

// FIXME - import from ESDK
@range(min: 1, max: 4294967296)
long FrameLength

structure EsdkEncrypt {
  // Pretty sure we don't want custom EC, right?
  // encryptionContext: aws.cryptography.materialProviders#EncryptionContext,

  // One of keyring or CMM are required
  materialsManager: aws.cryptography.materialProviders#CryptographicMaterialsManagerReference,
  keyring: aws.cryptography.materialProviders#KeyringReference,

  algorithmSuiteId: aws.cryptography.materialProviders#ESDKAlgorithmSuiteId,

  frameLength: FrameLength
}

structure DbesdkEncrypt {

  // Requires a Keyring XOR a CMM
  @javadoc("The Keyring that should be used to wrap and unwrap data keys. If specified a Default Cryptographic Materials Manager with this Keyring is used to obtain materials for encryption and decryption. Either a Keyring or a Cryptographic Materials Manager must be specified.")
  keyring: KeyringReference,
  @javadoc("The Cryptographic Materials Manager that is used to obtain materials for encryption and decryption.  Either a Keyring or a Cryptographic Materials Manager must be specified.")
  cmm: CryptographicMaterialsManagerReference,

  @javadoc("An ID for the algorithm suite to use during encryption and decryption.")
  algorithmSuiteId: DBEAlgorithmSuiteId,
}

// Associate a keyring with a member name, also says :
// encrypt this separately with the ESDK and sign the encrypted bytes
map ESDKActions {
    key: String,
    value: EsdkEncrypt
}

// key must refer to an Object
// Apply actions to members of that object
map NestedActions {
    key: String,
    value: Actions,
}

// key must refer to an Object
// Separately encrypt that object, with header and footer and all
map NestedEncryptors {
    key: String,
    value: JsonEncryptorConfig
}

// Every member must have an action
// further, and DO_NOTHING action must also appear here
structure ExplicitUnsigned {
  @javadoc("A list of attribute names such that, if encountered during decryption, those attributes are treated as unsigned.")
  allowedUnsignedAttributes: AttributeNameList,

  @javadoc("A prefix such that, if during decryption any attribute has a name with this prefix, it is treated as unsigned.")
  allowedUnsignedAttributePrefix: String,
}

// What to do with members that have no explicit action?
union DefaultAction {
    explicitUnsigned : ExplicitUnsigned,
    action : CryptoAction
}

// For each member, what do we do with it?
// it is an error for any member to be mentioned in more than one of these maps
structure Actions {
  @required
  @javadoc("A map that describes which members should be encrypted and/or signed on encrypt.")
  attributeActionsOnEncrypt: AttributeActions,

  @javadoc("A map that provides Actions for sub-objects.")
  nestedActionsOnEncrypt: NestedActions,

  // @javadoc("Separate encryption of sub-objects, each getting their own header and footer.")
  // nestedEncryptors: NestedEncryptors,

  // @javadoc("A map that allows separate encryption of individual values.")
  // eSDKActions: ESDKActions,

  @javadoc("What to do with actions not explicitly mentioned in attributeActionsOnEncrypt.")
  defaultAction: DefaultAction
}

@javadoc("The configuration for the client-side encryption of JSON objects.")
structure JsonEncryptorConfig {
    @required
    @javadoc("The logical table name for this table. This is the name that is cryptographically bound with your data.")
    logicalTableName: String,

    @required
    @javadoc("A full description of the cryptographic actions that should be applied to each attributes.")
    actions: Actions,

    @javadoc("Setting for encryption and decryption.")
    encrypt: DbesdkEncrypt,
}

@javadoc("A parsed version of the header that was written with or read on an encrypted Json object.")
structure ParsedHeader {
    @required
    @javadoc("The non-DO_NOTHING Crypto Actions that were configured when this object was originally encrypted.")
    attributeActionsOnEncrypt: AttributeActions,
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
