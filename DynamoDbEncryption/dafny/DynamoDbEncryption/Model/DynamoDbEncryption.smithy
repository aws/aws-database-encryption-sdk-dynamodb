// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
namespace aws.cryptography.dbEncryptionSdk.dynamoDb

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
use aws.cryptography.dbEncryptionSdk.structuredEncryption#CryptoAction

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
}

//= specification/dynamodb-encryption-client/ddb-sdk-integration.md#dynamodb-table-encryption-configs
//= type=implication
//# A map of DynamoDb table names to a structure that MUST contain
//# data as described by [DynamoDb Table Encryption Config](./ddb-table-encryption-config.md).
map DynamoDbTableEncryptionConfigList {
    //= specification/dynamodb-encryption-client/ddb-table-encryption-config.md#structure
    //= type=implication
    //# The physical [DynamoDB Table Name](#dynamodb-table-name) is REQUIRED
    //# to be associated with the DynamoDb Table Encryption Configuration.

    //= specification/dynamodb-encryption-client/ddb-table-encryption-config.md#dynamodb-table-name
    //= type=implication
    //# This Table Name MUST be a valid DynamoDB Table Name.
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
    //# - [Logical Table Name](#logical-table-name)
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
    logicalTableName: String,

    @required
    partitionKeyName: KeySchemaAttributeName,
    sortKeyName: KeySchemaAttributeName,

    //= specification/searchable-encryption/search-config.md#overview
    //= type=implication
    //# The search config MUST be an optional part of the [item encryptor config](../dynamodb-encryption-client/ddb-item-encryptor.md).
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

//= specification/searchable-encryption/virtual.md#virtual-field-initialization
//= type=implication
//# On initialization of a Virtual Field, the caller MUST provide:
//#  * A name -- a string
//#  * A list of [Virtual Parts](#virtual-part-initialization)

structure VirtualField {
  @required
  name : String,
  @required
  parts : VirtualPartList,
}

//= specification/searchable-encryption/virtual.md#virtual-part-initialization
//= type=implication
//# On initialization of a Virtual Part, the caller MUST provide:
//# * A location -- a [Terminal Location](#terminal-location)

//= specification/searchable-encryption/virtual.md#virtual-part-initialization
//= type=implication
//# On initialization of a Virtual Part, the caller MAY provide:
//# * A list of [Virtual Transforms](#virtual-transform-initialization)

structure VirtualPart {
  @required
  loc : TerminalLocation,
  trans : VirtualTransformList,
}

//= specification/searchable-encryption/virtual.md#upper-transform-initialization
//= type=implication
//# On initialization of an Upper Transform, the caller MUST NOT provide any
//# additional parameters to the Upper Transform.

// Convert ASCII characters to upper case
structure Upper {}

//= specification/searchable-encryption/virtual.md#lower-transform-initialization
//= type=implication
//# On initialization of a Lower Transform, the caller MUST NOT provide any
//# additional parameters to the Lower Transform.

// Convert ASCII characters to lower case
structure Lower {}

//= specification/searchable-encryption/virtual.md#insert-transform-initialization
//= type=implication
//# On initialization of an Insert Transform, the caller MUST provide:
//# * a literal string

// Append this literal string
structure Insert {
  @required
  literal : String
}

//= specification/searchable-encryption/virtual.md#getprefix-transform-initialization
//= type=implication
//# On initialization of a GetPrefix Transform, the caller MUST provide:
//#  * length : an integer

// return the first part of the string
// Positive length : return that many characters from the front
// Negative length : exclude -length characters from the end
// e.g. GetPrefix(-1) returns all but the last character
structure GetPrefix {
  @required
  length : Integer
}

//= specification/searchable-encryption/virtual.md#getsuffix-transform-initialization
//= type=implication
//# On initialization of a GetSuffix Transform, the caller MUST provide:
//# * length : an integer

// return the last part of the string
// Positive length : return that many characters from the end
// Negative length : exclude -length characters from the front
// e.g. GetSuffix(-1) returns all but the first character
structure GetSuffix {
  @required
  length : Integer
}

//= specification/searchable-encryption/virtual.md#getsubstring-transform-initialization
//= type=implication
//# On initialization of a GetSubstring Transform, the caller MUST provide:
//#  * low : an integer [position](#position-definition)
//#  * high : an integer [position](#position-definition)

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

//= specification/searchable-encryption/virtual.md#getsegment-transform-initialization
//= type=implication
//# On initialization of a GetSegment Transform, the caller MUST provide:
//#  * split : an character
//#  * index : an integer [position](#position-definition)

// split string on character, then return one piece.
// 'index' has the same semantics as 'low' in GetSubstring
structure GetSegment {
  @required
  split : Char,
  @required
  index : Integer
}

//= specification/searchable-encryption/virtual.md#getsegments-transform-initialization
//= type=implication
//# On initialization of a GetSegments Transform, the caller MUST provide:
//#  * split : an character
//#  * low : an integer [position](#position-definition)
//#  * high : an integer [position](#position-definition)

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

//= specification/searchable-encryption/virtual.md#virtual-transform-initialization
//= type=implication
//# On initialization of a Virtual Transform, the caller MUST provide exactly one of
//#  * an [Upper](#upper-transform-initialization) transform
//#  * a [Lower](#lower-transform-initialization) transform
//#  * an [Insert](#insert-transform-initialization) transform
//#  * a [GetPrefix](#getprefix-transform-initialization) transform
//#  * a [GetSuffix](#getsuffix-transform-initialization) transform
//#  * a [GetSubstring](#getsubstring-transform-initialization) transform
//#  * a [GetSegment](#getsegment-transform-initialization) transform
//#  * a [GetSegments](#getsegments-transform-initialization) transform

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

//= specification/searchable-encryption/beacons.md#sensitive-part-initialization
//= type=implication
//# On initialization of a [sensitive part](#sensitive-part-initialization), the caller MUST provide:
//#  * A name -- a string, the name of a standard beacon
//#  * A prefix -- a string

structure SensitivePart {
  @required
  name : String,
  @required
  prefix : Prefix
}

//= specification/searchable-encryption/beacons.md#non-sensitive-part-initialization
//= type=implication
//# On initialization of a [non-sensitive part](#non-sensitive-part-initialization), the caller MUST provide:
//#  * A name -- a string
//#  * A prefix -- a string

//= specification/searchable-encryption/beacons.md#non-sensitive-part-initialization
//= type=implication
//# On initialization of a [non-sensitive parts](#non-sensitive-part-initialization), the caller MAY provide:
//# * A [terminal location](virtual.md#terminal-location) -- a string

structure NonSensitivePart {
  @required
  name : String,
  @required
  prefix : Prefix,
  loc : TerminalLocation
}

//= specification/searchable-encryption/beacons.md#constructor-initialization
//= type=implication
//# On initialization of a constructor, the caller MUST provide:
//# * A non-empty list of [Constructor parts](#constructor-part-initialization)

structure Constructor {
  @required
  parts : ConstructorPartList
}

//= specification/searchable-encryption/beacons.md#constructor-part-initialization
//= type=implication
//# On initialization of a constructor part, the caller MUST provide:
//#  * A name -- a string
//#  * A required flag -- a boolean

structure ConstructorPart {
  @required
  name : String,
  @required
  required : Boolean,
}

//= specification/searchable-encryption/beacons.md#standard-beacon-initialization
//= type=implication
//# On initialization of a Standard Beacon, the caller MUST provide:
//#  * A name -- a string
//#  * A `length` -- a [beacon length](#beacon-length)

//= specification/searchable-encryption/beacons.md#standard-beacon-initialization
//= type=implication
//# On initialization of a Standard Beacon, the caller MAY provide:
//# * a [terminal location](virtual.md#terminal-location) -- a string

structure StandardBeacon {
  @required
  name : String,
  @required
  length : BeaconBitLength,
  loc : TerminalLocation
}

//= specification/searchable-encryption/beacons.md#compound-beacon-initialization
//= type=implication
//# On initialization of a Compound Beacon, the caller MUST provide:
//#  * A name -- a string
//#  * A split character -- a character

//= specification/searchable-encryption/beacons.md#compound-beacon-initialization
//= type=implication
//# On initialization of a Compound Beacon, the caller MAY provide:
//#  * A list of [sensitive parts](#sensitive-part-initialization)
//#  * A list of [non-sensitive parts](#non-sensitive-part-initialization)
//#  * A list of constructors

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

//= specification/searchable-encryption/search-config.md#single-key-store-initialization
//= type=implication
//# On initialization of a Single Key Store, the caller MUST provide:
//#  - [Beacon Key Id](#beacon-key-id)
//#  - [cacheTTL](#cachettl)

structure SingleKeyStore {
  @required
  keyId : String,
  @required
  cacheTTL: Integer,
}

//= specification/searchable-encryption/search-config.md#multi-key-store-initialization
//= type=implication
//# On initialization of a Multi Key Store, the caller MUST provide:
//#  - [Beacon Key Field Name](#beacon-key-field-name)
//#  - [cacheTTL](#cachettl)
//#  - [max cache size](#max-cache-size)

structure MultiKeyStore {
  @required
  keyFieldName : String,
  @required
  cacheTTL: Integer,
  @required
  maxCacheSize: Integer
}

//= specification/searchable-encryption/search-config.md#beacon-key-source
//= type=implication
//# On initialization of a Beacon Key Source, the caller MUST provide exactly one of
//#  * a [Single Key Store](#single-key-store-initialization)
//#  * a [Multi Key Store](#multi-key-store-initialization)

union BeaconKeySource {
  single : SingleKeyStore,
  multi : MultiKeyStore
}

//= specification/searchable-encryption/search-config.md#beacon-version-initialization
//= type=implication
//# On initialization of a Beacon Version, the caller MUST provide:
//#  - A [version number](#version number)
//#  - A [Beacon Key Source](#beacon-key-source)
//#  - A [Keystore](#keystore)
//#  - A list of [standard beacons](beacons.md#standard-beacon-initialization)

//= specification/searchable-encryption/search-config.md#beacon-version-initialization
//= type=implication
//# On initialization of the Beacon Version, the caller MAY provide:
//#  - A list of [compound beacons](beacons.md#compound-beacon-initialization)
//#  - A list of [virtual fields](virtual.md#virtual-field-initialization)

structure BeaconVersion {
  @required
  version : VersionNumber,
  @required
  keyStore : KeyStoreReference,
  @required
  keySource: BeaconKeySource,
  @required
  standardBeacons : StandardBeaconList,

  compoundBeacons : CompoundBeaconList,
  virtualFields : VirtualFieldList,
}

//= specification/searchable-encryption/search-config.md#initialization
//= type=implication
//# On initialization of the Search Config, the caller MUST provide:
//#  - A list of [beacon versions](#beacon-version-initialization)
//#  - The [version number](#version-number) of the [beacon versions](#beacon-version) to be used for writing.

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
