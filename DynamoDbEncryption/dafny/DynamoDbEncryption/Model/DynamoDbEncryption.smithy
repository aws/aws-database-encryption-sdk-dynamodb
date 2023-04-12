// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
namespace aws.cryptography.dynamoDbEncryption

// The top level namespace for this project.
// Contains an entry-point for helper methods,
// and common structures used throughout this project.

use aws.polymorph#localService
use aws.polymorph#reference
use aws.polymorph#extendable

use aws.cryptography.materialProviders#BranchKeyIdSupplierReference
use aws.cryptography.materialProviders#KeyringReference
use aws.cryptography.materialProviders#CryptographicMaterialsManagerReference
use aws.cryptography.materialProviders#DBEAlgorithmSuiteId
use aws.cryptography.keyStore#KeyStore
use aws.cryptography.structuredEncryption#CryptoAction

use com.amazonaws.dynamodb#DynamoDB_20120810
use com.amazonaws.dynamodb#TableName
use com.amazonaws.dynamodb#AttributeName
use com.amazonaws.dynamodb#Key
use com.amazonaws.dynamodb#AttributeNameList
use com.amazonaws.dynamodb#KeySchemaAttributeName

// A config-less entry-point for DynamoDb Encryption helper/factory methods
@localService(
  sdkId: "DynamoDbEncryption",
  config: DynamoDbEncryptionConfig,
)
service DynamoDbEncryption {
    version: "2022-11-21",
    operations: [ CreateDynamoDbEncryptionBranchKeyIdSupplier ],
    errors: [ DynamoDbEncryptionException ]
}

// The top level DynamoDbEncryption local service takes in no config
structure DynamoDbEncryptionConfig {
}

// The top level configuration for using DDB with client side encryption over multiple DDB tables.
// Used to configure the internal DynamoDbEncryptionTransforms, and by native implementations
// of integrations with higher level DDB APIs.
structure DynamoDbTablesEncryptionConfig {
    //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#dynamodb-encryption-client-configuration
    //= type=implication
    //# The client configuration consists of the following REQUIRED field:
    //# - [DynamoDb Table Encryption Configs](#dynamodb-tables-encryption-configs)
    @required
    tableEncryptionConfigs: DynamoDbTableEncryptionConfigList

    //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#dynamodb-encryption-client-configuration
    //= type=TODO
    //# The client configuration MAY include the following field:
    //# - TODO Searchable Encryption Config

    // TODO allowed passthrough tables
}

//= specification/dynamodb-encryption-client/ddb-sdk-integration.md#dynamodb-table-encryption-configs
//= type=implication
//# A map of DynamoDb table names to a structure that MUST contain
//# data as described by [DynamoDb Table Encryption Config](./ddb-table-encryption-config.md).
map DynamoDbTableEncryptionConfigList {
    key: TableName,
    value: DynamoDbTableEncryptionConfig
}

structure DynamoDbTableEncryptionConfig {
    //= specification/dynamodb-encryption-client/ddb-table-encryption-config.md#dynamodb-table-name
    //= type=implication
    //# If this config is being organized with other table configs in a map,
    //# this value MAY exist as a key value to identify other data in this config,
    //# instead of existing alongside this data in the same object.

    //= specification/dynamodb-encryption-client/ddb-table-encryption-config.md#structure
    //= type=implication
    //# The following are REQUIRED for DynamoDb Table Encryption Configuration:
    //# - [DynamoDB Table Name](#dynamodb-table-name)
    //# - [DynamoDB Partition Key Name](#dynamodb-partition-key-name)
    //# - [Attribute Actions](#attribute-actions)
    //# - A [CMM](#cmm) or [Keyring](#keyring)

    //= specification/dynamodb-encryption-client/ddb-table-encryption-config.md#structure
    //= type=implication
    //# The following are OPTIONAL for DynamoDb Table Encryption Configuration:
    //# - [DynamoDB Sort Key Name](#dynamodb-sort-key-name)
    //# - [Unauthenticated Attributes](#unauthenticated-attributes)
    //# - [Unauthenticated Attribute Name Prefix](#unauthenticated-attribute-prefix)
    //# - [Algorithm Suite](#algorithm-suite)
    //# - [Legacy Config](#legacy-config)
    //# - [Plaintext Policy](#plaintext-policy)

    @required
    partitionKeyName: KeySchemaAttributeName,
    sortKeyName: KeySchemaAttributeName,
    search: SearchConfig,
    
    @required
    attributeActions: AttributeActions,
    allowedUnauthenticatedAttributes: AttributeNameList,
    allowedUnauthenticatedAttributePrefix: String,
    //= specification/dynamodb-encryption-client/ddb-table-encryption-config.md#algorithm-suite
    //= type=implication
    //# This algorithm suite MUST be a [Structured Encryption Library Supported algorithm suite](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/algorithm-suites.md).
    algorithmSuiteId: DBEAlgorithmSuiteId,

    // Requires a Keyring XOR a CMM
    keyring: KeyringReference,
    cmm: CryptographicMaterialsManagerReference,

    legacyConfig: LegacyConfig,
    plaintextPolicy: PlaintextPolicy
}

map AttributeActions {
    key: AttributeName,
    value: CryptoAction,
}

@enum([
  {
    name: "REQUIRE_ENCRYPT_ALLOW_DECRYPT",
    value: "REQUIRE_ENCRYPT_ALLOW_DECRYPT",
  },
  {
    name: "FORBID_ENCRYPT_ALLOW_DECRYPT",
    value: "FORBID_ENCRYPT_ALLOW_DECRYPT",
  },
  {
    name: "FORBID_ENCRYPT_FORBID_DECRYPT",
    value: "FORBID_ENCRYPT_FORBID_DECRYPT",
  },
])
string LegacyPolicy

@aws.polymorph#extendable
resource LegacyDynamoDbEncryptor {
    operations: []
}

@aws.polymorph#reference(resource: LegacyDynamoDbEncryptor)
structure LegacyDynamoDbEncryptorReference {}

//= specification/dynamodb-encryption-client/ddb-table-encryption-config.md#legacy-config
//= type=implication
//# This config MUST contain:
//# - [Legacy Encryptor](#legacy-encryptor)
//# - [Attributes Flags](#attribute-flags)
//# - [Legacy Policy](#legacy-policy)
structure LegacyConfig {
    @required
    policy: LegacyPolicy,
    @required
    encryptor: LegacyDynamoDbEncryptorReference,

    //= specification/dynamodb-encryption-client/ddb-table-encryption-config.md#attribute-flags
    //= type=implication
    //# This map MAY be different from the top level [Attribute Actions](#attribute-actions).
    @required
    attributeFlags: AttributeActions,

    defaultAttributeFlag: CryptoAction,
}

@enum([
  {
    name: "REQUIRE_WRITE_ALLOW_READ",
    value: "REQUIRE_WRITE_ALLOW_READ",
  },
  {
    name: "FORBID_WRITE_ALLOW_READ",
    value: "FORBID_WRITE_ALLOW_READ",
  },
  {
    name: "FORBID_WRITE_FORBID_READ",
    value: "FORBID_WRITE_FORBID_READ",
  },
])
string PlaintextPolicy

@range(min: 1, max: 63)
integer BeaconBitLength

@range(min: 1)
integer VersionNumber

@length(min: 1, max: 1)
string Char

@length(min: 1)
string Prefix

@length(min: 1)
string TerminalLocation

@length(min: 1, max : 1)
list BeaconVersionList {
  member: BeaconVersion
}

@length(min: 1)
list VirtualFieldList {
  member: VirtualField
}

@length(min: 1)
list VirtualPartList {
  member: VirtualPart
}

@length(min: 1)
list VirtualTransformList {
  member: VirtualTransform
}

@length(min: 1)
list StandardBeaconList {
  member: StandardBeacon
}

@length(min: 1)
list CompoundBeaconList {
  member: CompoundBeacon
}

@length(min: 1)
list SensitivePartsList {
  member: SensitivePart
}

@length(min: 1)
list NonSensitivePartsList {
  member: NonSensitivePart
}

@length(min: 1)
list ConstructorList {
  member: Constructor
}

@length(min: 1)
list ConstructorPartList {
  member: ConstructorPart
}

structure VirtualField {
  @required
  name : String,
  @required
  parts : VirtualPartList,
}

structure VirtualPart {
  @required
  loc : TerminalLocation,
  trans : VirtualTransformList,
}

// Convert ASCII characters to upper case
structure Upper {}

// Convert ASCII characters to lower case
structure Lower {}

// Append this literal string
structure Insert {
  @required
  literal : String
}

// return the first part of the string
// Positive length : return that many characters from the front
// Negative length : exclude -length characters from the end
// e.g. GetPrefix(-1) returns all but the last character
structure GetPrefix {
  @required
  length : Integer
}

// return the last part of the string
// Positive length : return that many characters from the end
// Negative length : exclude -length characters from the front
// e.g. GetSuffix(-1) returns all but the first character
structure GetSuffix {
  @required
  length : Integer
}

// return range of characters, 0-based counting
// low is inclusive, high is exclusive
// negative numbers count from the end, -1 is the end of string
// i.e. the whole string is GetSubstring(0, -1)
// e.g. for "123456789"
// GetSubstring(2, 6) == GetSubstring(2, -4) == "3456"
structure GetSubstring {
  @required
  low : Integer,
  @required
  high : Integer,
}

// split string on character, then return one piece.
// 'index' has the same semantics as 'low' in GetSubstring
structure GetSegment {
  @required
  split : Char,
  @required
  index : Integer
}

// split string on character, then return range of pieces.
// 'low' and 'high' have the same semantics as GetSubstring
structure GetSegments {
  @required
  split : Char,
  @required
  low : Integer,
  @required
  high : Integer,
}

union VirtualTransform {
  upper: Upper,
  lower: Lower,
  insert: Insert,
  prefix: GetPrefix,
  suffix: GetSuffix,
  substring : GetSubstring,
  segment : GetSegment,
  segments : GetSegments
}

structure SensitivePart {
  @required
  name : String,
  @required
  prefix : Prefix
}

structure NonSensitivePart {
  @required
  name : String,
  @required
  prefix : Prefix,
  loc : TerminalLocation
}

structure Constructor {
  @required
  parts : ConstructorPartList
}

structure ConstructorPart {
  @required
  name : String,
  @required
  required : Boolean,
}

structure StandardBeacon {
  @required
  name : String,
  @required
  length : BeaconBitLength,
  loc : TerminalLocation
}

structure CompoundBeacon {
  @required
  name : String,
  @required
  split : Char,
  sensitive : SensitivePartsList,
  nonSensitive : NonSensitivePartsList,
  constructors : ConstructorList
}

@aws.polymorph#reference(service: aws.cryptography.keyStore#KeyStore)
structure KeyStoreReference {}

structure SingleKeyStore {
  keyStore : KeyStoreReference,
  keyId : String,
  cacheTTL: Integer,
}

structure MultiKeyStore {
  keyStore : KeyStoreReference,
  keyFieldName : String,
  cacheTTL: Integer,
  maxCacheSize: Integer
}

union BeaconKeySource {
  single : SingleKeyStore,
  multi : MultiKeyStore
}

structure BeaconVersion {
  @required
  version : VersionNumber,
  @required
  keySource: BeaconKeySource,
  @required
  standardBeacons : StandardBeaconList,
  compoundBeacons : CompoundBeaconList,
  virtualFields : VirtualFieldList,
}

structure SearchConfig {
  @required
  versions: BeaconVersionList,
  @required
  writeVersion: VersionNumber
}

@aws.polymorph#reference(service: aws.cryptography.primitives#AwsCryptographicPrimitives)
structure AtomicPrimitivesReference {}

@extendable
resource DynamoDbKeyBranchKeyIdSupplier{
  operations: [GetBranchKeyIdFromDdbKey]
}

@reference(resource: DynamoDbKeyBranchKeyIdSupplier)
structure DynamoDbKeyBranchKeyIdSupplierReference {}

operation GetBranchKeyIdFromDdbKey {
  input: GetBranchKeyIdFromDdbKeyInput,
  output: GetBranchKeyIdFromDdbKeyOutput
}

structure GetBranchKeyIdFromDdbKeyInput {
  @required
  ddbKey: Key
}

structure GetBranchKeyIdFromDdbKeyOutput {
  @required
  branchKeyId: String
}

operation CreateDynamoDbEncryptionBranchKeyIdSupplier {
  input: CreateDynamoDbEncryptionBranchKeyIdSupplierInput,
  output: CreateDynamoDbEncryptionBranchKeyIdSupplierOutput
}

structure CreateDynamoDbEncryptionBranchKeyIdSupplierInput {
  @required
  ddbKeyBranchKeyIdSupplier: DynamoDbKeyBranchKeyIdSupplierReference,
}

structure CreateDynamoDbEncryptionBranchKeyIdSupplierOutput {
  @required
  branchKeyIdSupplier: BranchKeyIdSupplierReference 
}

/////////////
// Errors

@error("client")
structure DynamoDbEncryptionException {
  @required
  message: String,
}
