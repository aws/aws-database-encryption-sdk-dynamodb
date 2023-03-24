// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
namespace aws.cryptography.dynamoDbEncryption

use aws.polymorph#localService

use aws.cryptography.dynamoDbItemEncryptor#AttributeActions
use aws.cryptography.materialProviders#KeyringReference
use aws.cryptography.materialProviders#CryptographicMaterialsManagerReference
use aws.cryptography.materialProviders#DBEAlgorithmSuiteId
use com.amazonaws.dynamodb#DynamoDB_20120810
use com.amazonaws.dynamodb#TableName
use com.amazonaws.dynamodb#AttributeNameList
use com.amazonaws.dynamodb#KeySchemaAttributeName

// TODO "hide" the below APIs from customers, but keep the config structures "public"

// TODO The middleware trait is not yet implemented,
// Ideally, this trait will:
//     1. Be syntactic sugar to represent the verbose Transform operation smithy models.
//     2. Additionally implement all the Transform operations in Dafny as passthrough,
//        with an ability to easily add more specific impl via specific Transform*' methods.
//     3. Generate the language-idiomatic way to integrate with the SDK
//        (e.g. the Java SDK Interceptor)
//        that takes in DynamoDbEncryptionConfig as input.
// 
// @middleware(
//     awsService: DynamoDB_20120810,
//     config: DynamoDbEncryptionConfig,
//     errors: [DynamoDbEncryptionException]
//     name: "DynamoDbEncryptionMiddlewareInternal"
// )
@localService(
  sdkId: "DynamoDbEncryption",
  config: DynamoDbEncryptionConfig,
)
service DynamoDbEncryption {
    version: "2022-11-21",
    operations: [
      PutItemInputTransform,
      PutItemOutputTransform,
      GetItemInputTransform,
      GetItemOutputTransform,
      BatchWriteItemInputTransform,
      BatchWriteItemOutputTransform,
      BatchGetItemInputTransform,
      BatchGetItemOutputTransform,
      ScanInputTransform,
      ScanOutputTransform,
      QueryInputTransform,
      QueryOutputTransform,
      TransactWriteItemsInputTransform,
      TransactWriteItemsOutputTransform,
      UpdateItemInputTransform,
      UpdateItemOutputTransform,
      DeleteItemInputTransform,
      DeleteItemOutputTransform,
      TransactGetItemsInputTransform,
      TransactGetItemsOutputTransform,
      ExecuteStatementInputTransform,
      ExecuteStatementOutputTransform,
      BatchExecuteStatementInputTransform,
      BatchExecuteStatementOutputTransform,
      ExecuteTransactionInputTransform,
      ExecuteTransactionOutputTransform,
      CreateTableInputTransform,
      CreateTableOutputTransform,
      UpdateTableInputTransform,
      UpdateTableOutputTransform,
      DescribeTableInputTransform,
      DescribeTableOutputTransform,
    ],
    errors: [ DynamoDbEncryptionException ]
}

structure DynamoDbEncryptionConfig {
    @required
    tableEncryptionConfigs: DynamoDbTableEncryptionConfigs
    // TODO allowed passthrough tables
}

map DynamoDbTableEncryptionConfigs {
    key: TableName,
    value: DynamoDbTableEncryptionConfig
}

structure DynamoDbTableEncryptionConfig {
    @required
    partitionKeyName: KeySchemaAttributeName,
    sortKeyName: KeySchemaAttributeName,
    search: SearchConfig,
    
    @required
    attributeActions: AttributeActions,
    allowedUnauthenticatedAttributes: AttributeNameList,
    allowedUnauthenticatedAttributePrefix: String,
    algorithmSuiteId: DBEAlgorithmSuiteId,

    // Requires a Keyring XOR a CMM
    keyring: KeyringReference,
    cmm: CryptographicMaterialsManagerReference,

    // TODO legacy encryptor
    // TODO legacy schema
}

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

structure SensitivePart {
  @required
  name : String,
  @required
  prefix : Prefix,
  @required
  length : BeaconBitLength,
  loc : TerminalLocation
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
  @required
  sensitive : SensitivePartsList,
  nonSensitive : NonSensitivePartsList,
  constructors : ConstructorList
}

structure BeaconVersion {
  @required
  version : VersionNumber,
  @required
  keyring: KeyringReference, // Must be Hierarchy Keyring
  standardBeacons : StandardBeaconList,
  compoundBeacons : CompoundBeaconList,
}

structure SearchConfig {
  @required
  versions: BeaconVersionList,
  @required
  writeVersion: VersionNumber
}

@aws.polymorph#reference(service: aws.cryptography.primitives#AwsCryptographicPrimitives)
structure AtomicPrimitivesReference {}

/////////////
// Errors

@error("client")
structure DynamoDbEncryptionException {
  @required
  message: String,
}
