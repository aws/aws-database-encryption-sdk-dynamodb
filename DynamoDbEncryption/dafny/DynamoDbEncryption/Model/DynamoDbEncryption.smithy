// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
namespace aws.cryptography.dbEncryptionSdk.dynamoDb

// The top level namespace for this project.
// Contains an entry-point for helper methods,
// and common structures used throughout this project.

use aws.polymorph#localService
use aws.polymorph#reference
use aws.polymorph#extendable
use aws.polymorph#javadoc

use aws.cryptography.materialProviders#BranchKeyIdSupplierReference
use aws.cryptography.materialProviders#KeyringReference
use aws.cryptography.materialProviders#CryptographicMaterialsManagerReference
use aws.cryptography.materialProviders#DBEAlgorithmSuiteId
use aws.cryptography.materialProviders#CacheType
use aws.cryptography.keyStore#KeyStore
use aws.cryptography.dbEncryptionSdk.structuredEncryption#CryptoAction

use com.amazonaws.dynamodb#DynamoDB_20120810
use com.amazonaws.dynamodb#AttributeMap
use com.amazonaws.dynamodb#TableName
use com.amazonaws.dynamodb#AttributeName
use com.amazonaws.dynamodb#Key
use com.amazonaws.dynamodb#AttributeNameList
use com.amazonaws.dynamodb#KeySchemaAttributeName

use aws.cryptography.primitives#AwsCryptographicPrimitives
use aws.cryptography.dbEncryptionSdk.structuredEncryption#StructuredEncryption
use aws.cryptography.materialProviders#AwsCryptographicMaterialProviders

// A config-less entry-point for DynamoDb Encryption helper/factory methods
@localService(
  sdkId: "DynamoDbEncryption",
  config: DynamoDbEncryptionConfig,
  dependencies: [
    AwsCryptographicPrimitives,
    DynamoDB_20120810,
    AwsCryptographicMaterialProviders,
    StructuredEncryption,
    KeyStore
  ]
)
service DynamoDbEncryption {
    version: "2024-04-02",
    operations: [ CreateDynamoDbEncryptionBranchKeyIdSupplier, GetEncryptedDataKeyDescription],
    errors: [ DynamoDbEncryptionException ]
}

resource PartitionSelector {
  operations: [GetPartitionNumber]
}

@reference(resource: PartitionSelector)
structure PartitionSelectorReference {}

operation GetPartitionNumber {
  input: GetPartitionNumberInput,
  output: GetPartitionNumberOutput,
}

//= specification/searchable-encryption/search-config.md#partition-selector
//= type=implication
//# GetPartitionNumber MUST take as input
//#
//# - A DynamoDB Item (i.e an AttributeMap)
//# - The [number of partitions](#max-partitions) defined in the associated [beacon version](#beacon-version-initialization).
//# - The logical table name for this defined in the associated [table config](../dynamodb-encryption-client/ddb-table-encryption-config.md#structure).

structure GetPartitionNumberInput {
  @required
  item: AttributeMap,
  @required
  numberOfPartitions : PartitionCount,
  @required
  logicalTableName: String,
}

//= specification/searchable-encryption/search-config.md#partition-selector
//= type=implication
//# GetPartitionNumber MUST return
//#
//# - The number of the partition to use for this item

structure GetPartitionNumberOutput {
  @required
  partitionNumber: PartitionNumber
}

@javadoc("Returns encrypted data key description.")
operation GetEncryptedDataKeyDescription {
    input: GetEncryptedDataKeyDescriptionInput,
    output: GetEncryptedDataKeyDescriptionOutput,
}

@javadoc("Input for getting encrypted data key description.")
structure GetEncryptedDataKeyDescriptionInput {
    @required
    input: GetEncryptedDataKeyDescriptionUnion
}

//= specification/dynamodb-encryption-client/ddb-get-encrypted-data-key-description.md#input
//= type=implication
//# This operation MUST take in either of the following:
//# - A binary [header](https://github.com/aws/aws-database-encryption-sdk-dynamodb/blob/main/specification/structured-encryption/header.md)
//# - A [encrypted DynamoDB item](https://github.com/aws/aws-database-encryption-sdk-dynamodb/blob/ff9f08a355a20c81540e4ca652e09aaeffe90c4b/specification/dynamodb-encryption-client/encrypt-item.md#encrypted-dynamodb-item)

union GetEncryptedDataKeyDescriptionUnion {
  @javadoc("A binary header value.")
  header: Blob,
  @javadoc("A DynamoDB item.")
  item: AttributeMap,
}

@javadoc("Output for getting encrypted data key description.")
structure GetEncryptedDataKeyDescriptionOutput {
    @required
    @javadoc("A list of encrypted data key description.")
    EncryptedDataKeyDescriptionOutput: EncryptedDataKeyDescriptionList
}

list EncryptedDataKeyDescriptionList {
  member: EncryptedDataKeyDescription
}

//= specification/dynamodb-encryption-client/ddb-get-encrypted-data-key-description.md#output
//= type=implication
//# This operation MUST return the following:
//# - [keyProviderId](https://github.com/aws/aws-database-encryption-sdk-dynamodb/blob/main/specification/structured-encryption/header.md#key-provider-id)
//#- [keyProviderInfo](https://github.com/aws/aws-database-encryption-sdk-dynamodb/blob/main/specification/structured-encryption/header.md#key-provider-information) (only for AWS Cryptographic Materials Provider Keyring)
//#- [branchKeyId](https://github.com/aws/aws-database-encryption-sdk-dynamodb/blob/main/specification/structured-encryption/header.md#key-provider-information) (only for hierarchy keyring)
//#- [branchKeyVersion](https://github.com/aws/aws-database-encryption-sdk-dynamodb/blob/main/specification/structured-encryption/header.md#key-provider-information) (only for hierarchy keyring)

structure EncryptedDataKeyDescription {
  @required
  @javadoc("Key provider id of the encrypted data key.")
  keyProviderId: String,

  @javadoc("Key provider information of the encrypted data key.")
  keyProviderInfo: String,

  @javadoc("Branch key id of the encrypted data key.")
  branchKeyId: String,

  @javadoc("Branch key version of the encrypted data key.")
  branchKeyVersion: String
}
// The top level DynamoDbEncryption local service takes in no config
structure DynamoDbEncryptionConfig {
}

// The top level configuration for using DDB with client side encryption over multiple DDB tables.
// Used to configure the internal DynamoDbEncryptionTransforms, and by native implementations
// of integrations with higher level DDB APIs.
@javadoc("The configuration for client-side encryption with multiple DynamoDB table.")
structure DynamoDbTablesEncryptionConfig {
    //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#dynamodb-encryption-client-configuration
    //= type=implication
    //# The client configuration consists of the following REQUIRED field:
    //# - [DynamoDb Table Encryption Configs](#dynamodb-tables-encryption-configs)
    @required
    @javadoc("A map of DynamoDB table name to its configuration for client-side encryption.")
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

@javadoc("The configuration for client-side encryption for a particular DynamoDB table.")
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
    @javadoc("The logical table name for this table. This is the name that is cryptographically bound with your data. This can be the same as the actual DynamoDB table name. It's purpose is to be distinct from the DynamoDB table name so that the data may still be authenticated if being read from different (but logically similar) tables, such as a backup table.")
    logicalTableName: String,

    @required
    @javadoc("The name of the partition key on this table.")
    partitionKeyName: KeySchemaAttributeName,
    @javadoc("If this table contains a sort key, the name of the sort key on this table.")
    sortKeyName: KeySchemaAttributeName,

    //= specification/searchable-encryption/search-config.md#overview
    //= type=implication
    //# The search config MUST be an optional part of the [item encryptor config](../dynamodb-encryption-client/ddb-item-encryptor.md).
    @javadoc("The configuration for searchable encryption.")
    search: SearchConfig,
    
    @required
    @javadoc("A map that describes what attributes should be encrypted and/or signed on encrypt. This map must contain all attributes that might be encountered during encryption.")
    attributeActionsOnEncrypt: AttributeActions,
    @javadoc("A list of attribute names such that, if encountered during decryption, those attributes are treated as unsigned.")
    allowedUnsignedAttributes: AttributeNameList,
    @javadoc("A prefix such that, if during decryption any attribute has a name with this prefix, it is treated as unsigned.")
    allowedUnsignedAttributePrefix: String,
    //= specification/dynamodb-encryption-client/ddb-table-encryption-config.md#algorithm-suite
    //= type=implication
    //# This algorithm suite MUST be a [Structured Encryption Library Supported algorithm suite](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/algorithm-suites.md).
    @javadoc("An ID for the algorithm suite to use during encryption and decryption.")
    algorithmSuiteId: DBEAlgorithmSuiteId,

    // Requires a Keyring XOR a CMM
    @javadoc("The Keyring that should be used to wrap and unwrap data keys. If specified a Default Cryptographic Materials Manager with this Keyring is used to obtain materials for encryption and decryption. Either a Keyring or a Cryptographic Materials Manager must be specified.")
    keyring: KeyringReference,
    @javadoc("The Cryptographic Materials Manager that is used to obtain materials for encryption and decryption.  Either a Keyring or a Cryptographic Materials Manager must be specified.")
    cmm: CryptographicMaterialsManagerReference,

    @javadoc("A configuration that override encryption and/or decryption to instead perform legacy encryption and/or decryption. Used as part of migration from version 2.x to version 3.x.")
    legacyOverride: LegacyOverride,
    @javadoc("A configuration that override encryption and/or decryption to instead passthrough and write and/or read plaintext. Used to update plaintext tables to fully use client-side encryption.")
    plaintextOverride: PlaintextOverride,
}

map AttributeActions {
    key: AttributeName,
    value: CryptoAction,
}

@enum([
  {
    name: "FORCE_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT",
    value: "FORCE_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT",
  },
  {
    name: "FORBID_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT",
    value: "FORBID_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT",
  },
  {
    name: "FORBID_LEGACY_ENCRYPT_FORBID_LEGACY_DECRYPT",
    value: "FORBID_LEGACY_ENCRYPT_FORBID_LEGACY_DECRYPT",
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
@javadoc("A configuration for overriding encryption and/or decryption to instead perform legacy encryption and decryption.")
structure LegacyOverride {
    @required
    @javadoc("A policy which configures whether legacy behavior overrides encryption and/or decryption.")
    policy: LegacyPolicy,
    @required
    @javadoc("A configuration for the legacy DynamoDB Encryption Client's Encryptor.")
    encryptor: LegacyDynamoDbEncryptorReference,

    //= specification/dynamodb-encryption-client/ddb-table-encryption-config.md#attribute-flags
    //= type=implication
    //# This map MAY be different from the top level [Attribute Actions](#attribute-actions).
    @required
    @javadoc("Overrides which attributes are encrypted and/or signed for any items read or written with legacy behavior.")
    attributeActionsOnEncrypt: AttributeActions,

    @javadoc("This input is not used in the Java Client and should not be specified.")
    defaultAttributeFlag: CryptoAction,
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

@range(min: 1, max: 63)
integer BeaconBitLength

@range(min: 1)
integer VersionNumber

@range(min: 1, max: 255)
integer PartitionCount

@range(min: 0, max: 254)
integer PartitionNumber

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
list EncryptedPartsList {
  member: EncryptedPart
}

@length(min: 1)
list SignedPartsList {
  member: SignedPart
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
//# - A name -- a string
//# - A list of [Virtual Parts](#virtual-part-initialization)

@javadoc("The configuration for a Virtual Field. A Virtual Field is a field constructed from parts of other fields for use with beacons, but never itself stored on items.")
structure VirtualField {
  @required
  @javadoc("The name of the Virtual Field.")
  name : String,
  @required
  @javadoc("The list of ordered parts that make up a Virtual Field.")
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

@javadoc("A Virtual Part is the configuration of a transformation on an existing field in an item.")
structure VirtualPart {
  @required
  @javadoc("The DynamoDB document path to the value for this part.")
  loc : TerminalLocation,
  @javadoc("A list of transformations performed on the value for this part.")
  trans : VirtualTransformList,
}

//= specification/searchable-encryption/virtual.md#upper-transform-initialization
//= type=implication
//# On initialization of an Upper Transform, the caller MUST NOT provide any
//# additional parameters to the Upper Transform.

@javadoc("The Virtual Part Transformation that converts ASCII characters to upper case.")
structure Upper {}

//= specification/searchable-encryption/virtual.md#lower-transform-initialization
//= type=implication
//# On initialization of a Lower Transform, the caller MUST NOT provide any
//# additional parameters to the Lower Transform.

@javadoc("The Virtual Part Transformation that converts ASCII characters to lower case.")
structure Lower {}

//= specification/searchable-encryption/virtual.md#insert-transform-initialization
//= type=implication
//# On initialization of an Insert Transform, the caller MUST provide:
//# * a literal string

@javadoc("The Virtual Part Transformation that appends a literal string.")
structure Insert {
  @required
  @javadoc("The literal string to append.")
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
@javadoc("The Virtual Part Transformation that gets the prefix of a string.")
structure GetPrefix {
  @required
  @javadoc("If positive, the number of characters to return from the front. If negative, the absolute number of characters to exclude from the end. e.g. GetPrefix(-1) returns all but the last character.")
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
@javadoc("The Virtual Part Transformation that gets the suffix of a string.")
structure GetSuffix {
  @required
  @javadoc("If positive, the number of characters to return from the end. If negative, the absolute number of characters to exclude from the front. e.g. GetSuffix(-1) returns all but the first character.")
  length : Integer
}

//= specification/searchable-encryption/virtual.md#getsubstring-transform-initialization
//= type=implication
//# On initialization of a GetSubstring Transform, the caller MUST provide:
//# - low : an integer [position](#position-definition)
//# - high : an integer [position](#position-definition)

// return range of characters, 0-based counting
// low is inclusive, high is exclusive
// negative numbers count from the end, -1 is the end of string
// i.e. the whole string is GetSubstring(0, -1)
// e.g. for "123456789"
// GetSubstring(2, 6) == GetSubstring(2, -4) == "3456"
@javadoc("The Virtual Part Transformation that gets a substring from a string.")
structure GetSubstring {
  @required
  @javadoc("The index to start the substring from, inclusive. Negative numbers count from the end. -1 is the last character of a string.")
  low : Integer,
  @required
  @javadoc("The index to stop the substring at, exclusive. Negative numbers count from the end. -1 is the last character of a string.")
  high : Integer,
}

//= specification/searchable-encryption/virtual.md#getsegment-transform-initialization
//= type=implication
//# On initialization of a GetSegment Transform, the caller MUST provide:
//# - split : an character
//# - index : an integer [position](#position-definition)

// split string on character, then return one piece.
// 'index' has the same semantics as 'low' in GetSubstring
@javadoc("The Virtual Part Transformation that splits a string and gets a particular segment of that split.")
structure GetSegment {
  @required
  @javadoc("The characters to split on.")
  split : Char,
  @required
  @javadoc("The index of the split string result to return. 0 represents the segment before the first split character. -1 represents the segment after the last split character.")
  index : Integer
}

//= specification/searchable-encryption/virtual.md#getsegments-transform-initialization
//= type=implication
//# On initialization of a GetSegments Transform, the caller MUST provide:
//# - split : an character
//# - low : an integer [position](#position-definition)
//# - high : an integer [position](#position-definition)

// split string on character, then return range of pieces.
// 'low' and 'high' have the same semantics as GetSubstring
@javadoc("The Virtual Part Transformation that splits a string and gets a range of segments of that split.")
structure GetSegments {
  @required
  @javadoc("The characters to split on.")
  split : Char,
  @required
  @javadoc("The index to start the segments from, inclusive. Negative numbers count from the end. -1 is the last segment.")
  low : Integer,
  @required
  @javadoc("The index to stop the segments at, exclusive. Negative numbers count from the end. -1 is the last segment.")
  high : Integer,
}

//= specification/searchable-encryption/virtual.md#virtual-transform-initialization
//= type=implication
//# On initialization of a Virtual Transform, the caller MUST provide exactly one of
//# - an [Upper](#upper-transform-initialization) transform
//# - a [Lower](#lower-transform-initialization) transform
//# - an [Insert](#insert-transform-initialization) transform
//# - a [GetPrefix](#getprefix-transform-initialization) transform
//# - a [GetSuffix](#getsuffix-transform-initialization) transform
//# - a [GetSubstring](#getsubstring-transform-initialization) transform
//# - a [GetSegment](#getsegment-transform-initialization) transform
//# - a [GetSegments](#getsegments-transform-initialization) transform

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

//= specification/searchable-encryption/beacons.md#partonly-initialization
//= type=implication
//# On initialization of a PartOnly, the caller MUST NOT provide any
//# additional parameters to the PartOnly.
@javadoc("Attribute must be used as part of a Compound Beacon, never alone.")
structure PartOnly {}

//= specification/searchable-encryption/beacons.md#asset-initialization
//= type=implication
//# On initialization of as AsSet, the caller MUST NOT provide any
//# additional parameters to the AsSet.
@javadoc("Attribute must be a Set. Beacon value will also be a Set.")
structure AsSet {}

//= specification/searchable-encryption/beacons.md#shared-initialization
//= type=implication
//# On initialization of a Shared, the caller MUST provide:
//#
//# * other : a beacon name
@javadoc("This beacon should calculate values like another beacon, so they can be compared.")
structure Shared {
  @required
  @javadoc("Calculate beacon values as for this beacon.")
  other : String,
}

//= specification/searchable-encryption/beacons.md#sharedset-initialization
//= type=implication
//# On initialization of a SharedSet, the caller MUST provide:
//#
//# * other : a beacon name
@javadoc("Both Shared and AsSet.")
structure SharedSet {
  @required
  @javadoc("Calculate beacon values as for this beacon.")
  other : String,
}

//= specification/searchable-encryption/beacons.md#beacon-style-initialization
//= type=implication
//# On initialization of a Beacon Style, the caller MUST provide exactly one of
//# 
//# - a [PartOnly](#partonly-initialization)
//# - a [Shared](#shared-initialization)
//# - an [AsSet](#asset-initialization)
//# - a [SharedSet](#sharedset-initialization)

union BeaconStyle {
  partOnly: PartOnly,
  shared: Shared,
  asSet: AsSet,
  sharedSet: SharedSet,
}

//= specification/searchable-encryption/beacons.md#encrypted-part-initialization
//= type=implication
//# On initialization of a [encrypted part](#encrypted-part-initialization), the caller MUST provide:
//# - A name -- a string, the name of a standard beacon
//# - A prefix -- a string

@javadoc("A part of a Compound Beacon that contains a beacon over encrypted data.")
structure EncryptedPart {
  @required
  @javadoc("The name of the Standard Beacon, whose value this Part will hold.")
  name : String,
  @required
  @javadoc("The prefix that is written with this Encrypted Part.")
  prefix : Prefix
}

//= specification/searchable-encryption/beacons.md#signed-part-initialization
//= type=implication
//# On initialization of a [signed part](#signed-part-initialization), the caller MUST provide:
//# - A name -- a string
//# - A prefix -- a string

//= specification/searchable-encryption/beacons.md#signed-part-initialization
//= type=implication
//# On initialization of a [signed parts](#signed-part-initialization), the caller MAY provide:
//# * A [terminal location](virtual.md#terminal-location) -- a string

@javadoc("A part of a Compound Beacon that contains signed plaintext data.")
structure SignedPart {
  @required
  @javadoc("The name for this Signed Part.")
  name : String,
  @required
  @javadoc("The prefix that is written with this Signed Part.")
  prefix : Prefix,
  @javadoc("The DynamoDB document path to the value for this Signed Part. If not provided, the 'name' is used for the location.")
  loc : TerminalLocation
}

//= specification/searchable-encryption/beacons.md#constructor-initialization
//= type=implication
//# On initialization of a constructor, the caller MUST provide:
//# - A non-empty list of [Constructor parts](#constructor-part-initialization)

@javadoc("The configuration for a particular Compound Beacon construction.")
structure Constructor {
  @required
  @javadoc("The ordered list of parts for a particular Compound Beacon construction. If the item contains all required Parts, a Compound beacon will be written using each Part that exists on the item, in the order specified.")
  parts : ConstructorPartList
}

//= specification/searchable-encryption/beacons.md#constructor-part-initialization
//= type=implication
//# On initialization of a constructor part, the caller MUST provide:
//# - A name -- a string
//# - A required flag -- a boolean

@javadoc("A part of a Compound Beacon Construction.")
structure ConstructorPart {
  @required
  @javadoc("The name of the Encrypted Part or Signed Part for which this constructor part gets a value.")
  name : String,
  @required
  @javadoc("Whether this Encrypted Part or Signed Part is required for this construction to succeed.")
  required : Boolean,
}

//= specification/searchable-encryption/beacons.md#standard-beacon-initialization
//= type=implication
//# On initialization of a Standard Beacon, the caller MUST provide:
//# - A name -- a string
//# - A `length` -- a [beacon length](#beacon-length)

//= specification/searchable-encryption/beacons.md#standard-beacon-initialization
//= type=implication
//# On initialization of a Standard Beacon, the caller MAY provide:
//# - a [terminal location](virtual.md#terminal-location) -- a string

@javadoc("The configuration for a Standard Beacon.")
structure StandardBeacon {
  @required
  @javadoc("The name for this Standard Beacon.")
  name : String,
  @required
  @javadoc("The length of the calculated beacon.")
  length : BeaconBitLength,
  @javadoc("The DynamoDB document path to the value this beacon will calculate over. If not specified, the beacon will calculate values for the attribute with the name specified in 'name'.")
  loc : TerminalLocation,
  @javadoc("Optional augmented behavior.")
  style : BeaconStyle,
  @javadoc("The number of separate partitions across which this particular beacon should be divided. Ths must be no greater than the global numberOfPartitions, and can never be changed once an item containing this beacon has been written.")
  numberOfPartitions : PartitionCount
}

//= specification/searchable-encryption/beacons.md#compound-beacon-initialization
//= type=implication
//# On initialization of a Compound Beacon, the caller MUST provide:
//# - A name -- a string
//# - A split character -- a character

//= specification/searchable-encryption/beacons.md#compound-beacon-initialization
//= type=implication
//# On initialization of a Compound Beacon, the caller MAY provide:
//# - A list of [encrypted parts](#encrypted-part-initialization)
//# - A list of [signed parts](#signed-part-initialization)
//# - A list of constructors

@javadoc("The configuration for a Compound Beacon.")
structure CompoundBeacon {
  @required
  @javadoc("The name of the Compound Beacon.")
  name : String,
  @required
  @javadoc("The characters used to split parts of a compound beacon. The split character should be a character that does not appear in any Signed Part or Prefix used by the Compound Beacon.")
  split : Char,
  @javadoc("The list of Encrypted Parts that may be included in the compound beacon.")
  encrypted : EncryptedPartsList,
  @javadoc("The list of Signed Parts that may be included in the compound beacon.")
  signed : SignedPartsList,
  @javadoc("The ordered list of constructors that may be used to create the Compound Beacon. Each constructor is checked, in order, to see if it can construct the beacon. The first constructor that can construct the beacon is used. If no constructor can construct the beacon, the Compound Beacon is not written to the item.")
  constructors : ConstructorList
}

@aws.polymorph#reference(service: aws.cryptography.keyStore#KeyStore)
structure KeyStoreReference {}

//= specification/searchable-encryption/search-config.md#single-key-store-initialization
//= type=implication
//# On initialization of a Single Key Store, the caller MUST provide:
//#  - [Beacon Key Id](#beacon-key-id)
//#  - [cacheTTL](#cachettl)
//#  - [cache](#key-store-cache)
//#  - [partition-id](#partition-id)

@javadoc("The configuration for using a single Beacon Key.")
structure SingleKeyStore {
  @required
  @javadoc("The Beacon Key ID.")
  keyId : String,
  @required
  @javadoc("How long (in seconds) the beacon key material is cached locally before it is re-retrieved from DynamoDB and re-authed with AWS KMS.")
  cacheTTL: Integer,
  @documentation("Which type of local cache to use. Please see the [spec](https://github.com/aws/aws-database-encryption-sdk-dynamodb/blob/main/specification/searchable-encryption/search-config.md#key-store-cache) on how to provide a cache for a SingleKeyStore.")
  cache : CacheType,
  @documentation("Partition ID to distinguish Beacon Key Sources writing to a Shared cache. If the Partition ID is the same for two Beacon Key Sources, they can share the same cache entries in the Shared cache.")
  partitionId: String
}

//= specification/searchable-encryption/search-config.md#multi-key-store-initialization
//= type=implication
//# On initialization of a Multi Key Store, the caller MUST provide:
//#  - [Beacon Key Field Name](#beacon-key-field-name)
//#  - [cacheTTL](#cachettl)
//#  - [cache](#key-store-cache)
//#  - [partition-id](#partition-id)

@javadoc("The configuration for using multiple Beacon Keys.")
structure MultiKeyStore {
  @required
  @javadoc("The name of the field that stores the Beacon Key. This may be a Virtual Field.")
  keyFieldName : String,
  @required
  @javadoc("How long (in seconds) the beacon key material is cached locally before it is re-retrieved from DynamoDB and re-authed with AWS KMS.")
  cacheTTL: Integer,
  @javadoc("Which type of local cache to use.")
  cache : CacheType,
  @documentation("Partition ID to distinguish Beacon Key Sources writing to a Shared cache. If the Partition ID is the same for two Beacon Key Sources, they can share the same cache entries in the Shared cache.")
  partitionId: String
}

//= specification/searchable-encryption/search-config.md#beacon-key-source
//= type=implication
//# On initialization of a Beacon Key Source, the caller MUST provide exactly one of
//# - a [Single Key Store](#single-key-store-initialization)
//# - a [Multi Key Store](#multi-key-store-initialization)

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

@javadoc("The configuration for a particular version of searchable encryption. Currently the only supported version is '1'.")
structure BeaconVersion {
  @required
  @javadoc("The version of searchable encryption configured. This must be '1'.")
  version : VersionNumber,
  @required
  @javadoc("The Key Store that contains the Beacon Keys to use with searchable encryption.")
  keyStore : KeyStoreReference,
  @required
  @javadoc("The configuration for what beacon key(s) to use.")
  keySource: BeaconKeySource,
  @required
  @javadoc("The Standard Beacons to be written with items.")
  standardBeacons : StandardBeaconList,

  @javadoc("The Compound Beacons to be written with items.")
  compoundBeacons : CompoundBeaconList,
  @javadoc("The Virtual Fields to be calculated, supporting other searchable encryption configurations.")
  virtualFields : VirtualFieldList,

  @javadoc("The list of Encrypted Parts that may be included in any compound beacon.")
  encryptedParts : EncryptedPartsList,
  @javadoc("The list of Signed Parts that may be included in any compound beacon.")
  signedParts : SignedPartsList,

  @javadoc("The number of separate partitions across which beacons should be divided.")
  maximumNumberOfPartitions : PartitionCount,

  @javadoc("The number of partitions for any beacon that doesn't specify a numberOfPartitions")
  defaultNumberOfPartitions : PartitionCount,

  @javadoc("How to choose the partition for an item. Default behavior is a random between 0 and maximumNumberOfPartitions.")
  partitionSelector: PartitionSelectorReference,
}

//= specification/searchable-encryption/search-config.md#initialization
//= type=implication
//# On initialization of the Search Config, the caller MUST provide:
//# - A list of [beacon versions](#beacon-version-initialization)
//# - The [version number](#version-number) of the [beacon versions](#beacon-version-initialization) to be used for writing.

@javadoc("The configuration for searchable encryption.")
structure SearchConfig {
  @required
  @javadoc("The versions of searchable encryption to support reading. Currently must contain a single configuration with version '1'.")
  versions: BeaconVersionList,
  @required
  @javadoc("The searchable encryption version to use when writing new items. Must be '1'.")
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

@javadoc("Get the Branch Key that should be used for wrapping and unwrapping data keys based on the primary key of the item being read or written, along with the values of any attributes configured as SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT.")
operation GetBranchKeyIdFromDdbKey {
  input: GetBranchKeyIdFromDdbKeyInput,
  output: GetBranchKeyIdFromDdbKeyOutput
}

//= specification/dynamodb-encryption-client/ddb-encryption-branch-key-id-supplier.md#dynamodbkeybranchkeyidsupplier
//= type=implication
//# This operation MUST take in a DDB `Key` structure
//# (an attribute map containing the partition and sort attributes,
//# along with the values of any attributes configured as SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT)
//# as input.
@javadoc("Inputs for getting the Branch Key that should be used for wrapping and unwrapping data keys.")
structure GetBranchKeyIdFromDdbKeyInput {
  @required
  @javadoc("The partition and sort (if it exists) attributes on the item being read or written, along with the values of any attributes configured as SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT.")
  ddbKey: Key
}

//= specification/dynamodb-encryption-client/ddb-encryption-branch-key-id-supplier.md#dynamodbkeybranchkeyidsupplier
//= type=implication
//# This operation MUST return a branch key id (string) as output.
@javadoc("Outputs for getting the Branch Key that should be used for wrapping and unwrapping data keys.")
structure GetBranchKeyIdFromDdbKeyOutput {
  @required
  @javadoc("The ID of the Branch Key that should be used to wrap and unwrap data keys for this item.")
  branchKeyId: String
}

//= specification/dynamodb-encryption-client/ddb-encryption-branch-key-id-supplier.md#operation
//= type=implication
//# The `CreateDynamoDbEncryptionBranchKeyIdSupplier` is an operation that MUST be vended alongside the DynamoDb Item Encryptor.
@javadoc("Create a Branch Key Supplier for use with the Hierarchical Keyring that decides what Branch Key to use based on the primary key of the DynamoDB item being read or written.")
operation CreateDynamoDbEncryptionBranchKeyIdSupplier {
  input: CreateDynamoDbEncryptionBranchKeyIdSupplierInput,
  output: CreateDynamoDbEncryptionBranchKeyIdSupplierOutput
}

//= specification/dynamodb-encryption-client/ddb-encryption-branch-key-id-supplier.md#input
//= type=implication
//# This operation MUST take in a [DynamoDbKeyBranchKeyIdSupplier](#dynamodbkeybranchkeyidsupplier) as input.
@javadoc("Inputs for creating a Branch Key Supplier from a DynamoDB Key Branch Key Id Supplier")
structure CreateDynamoDbEncryptionBranchKeyIdSupplierInput {
  @required
  @javadoc("An implementation of the DynamoDbKeyBranchKeyIdSupplier interface, which determines what Branch Key to use for data key wrapping/unwrapping based on the DynamoDB item being written/read.")
  ddbKeyBranchKeyIdSupplier: DynamoDbKeyBranchKeyIdSupplierReference,
}

//= specification/dynamodb-encryption-client/ddb-encryption-branch-key-id-supplier.md#output
//= type=implication
//# This operation MUST output a BranchKeyIdSupplierReference.
@javadoc("Outputs for creating a Branch Key Supplier from a DynamoDB Key Branch Key Id Supplier")
structure CreateDynamoDbEncryptionBranchKeyIdSupplierOutput {
  @required
  @javadoc("The Branch Key Supplier for use with the Hierarchical Keyring.")
  branchKeyIdSupplier: BranchKeyIdSupplierReference 
}

// Errors

@error("client")
structure DynamoDbEncryptionException {
  @required
  message: String,
}
