[//]: # "Copyright Amazon.com Inc. or its affiliates. All Rights Reserved."
[//]: # "SPDX-License-Identifier: CC-BY-SA-4.0"

# DynamoDB Beacons

## Version

1.0.0

### Changelog

../dynamodb-encryption-client/ddb-attribute-serialization.md

## Overview

A `DynamoDBEncryption` object provides information about
how records are encrypted and stored, including any
associated [beacons](./beacons.md).

Various Request and Response objects are transformed, based on this configuration.

Primary keys cannot be beacons,
both because primary keys cannot be encrypted
and because beacons are designed to create false duplicates.

The basic user experience is this 
 *  Customer constructs a client object with [Gazelle magic](../dynamodb-encryption-client/ddb-sdk-integration.md).
 * Customer calls client methods as normal

For each client operation, the workflow looks something like this

1. Customer makes a request
1. Gazelle calls one of the below functions to transform the request
1. Gazelle encrypts the request
1. Gazelle calls the underlying DynamoDB client method
1. Gazelle decrypts the response
1. Gazelle calls one of the below functions to transform the response
1. Customer receives the response.

### Definitions
 * **source field** : an encrypted attribute with an associated beacon
 * **non-beaconed field** : an encrypted attribute without an associated beacon
 * **beacon field** : the attribute holding the beacon value associated with a source field

### Reserved Prefixes

#### Gazelle Prefix
Gazelle reserves all attribute names starting with `gZ_` (actual prefix up for debate)

#### Beacon Prefix
All beacon values are written as attributes beginning with the [Gazelle Prefix](#gazelle-prefix) followed by `b_`, i.e. `gZ_b_`. 

For the [source field](#source-field) `foo` the associated 
[beacon field](#beacon-field) would be `gZ_b_foo`

#### Version Prefix

[Version markers](#version-markers) are written as attributes beginning with the [Gazelle Prefix](#gazelle-prefix) followed by `v_`, i.e. `gZ_v_`. 

For version 12 the [Version marker](#version-markers) would be `gZ_v_12`

### Forbidden Fields

No customer request should ever refer directly to any attribute
with a name starting with the [Gazelle Prefix](#gazelle-prefix)

The only exception is that customer may read attributes beginning
with the [version prefix](#version-prefix), but still may not write
such an attribute.

All operations below will fail if a forbidden field is used.

### Beacon Calculation

To calculate the beacon value for an attribute

1. If the attribute is type "S" string, then call [compoundHash](./beacons.md#compoundHash) on the string value.
1. If the attribute is not a string,
and the beacon is [compound](./beacons.md#IsCompound),
then the beacon calculation must fail.
1. otherwise, [serialize](../dynamodb-encryption-client/ddb-attribute-serialization.md)
the attribute, and call [plainHash](./beacons.md#plainHash) on the result.

### Beacon Keys

A single non-rotating branch key will be stored in the hierarchy keyring.
For each individual beacon, we will call the hierarchy keyring's
HKDF function, using a SHA256 of the beacon name as the nonce, 
to generate a consistent data key for each beacon.

[TODO: add link to hierarchy keyring spec in private-aws-encryption-sdk-specification-staging]

### Version Number

There exists a version number (integer greater than zero) associated
with the current configuration being used to write items. 

### Version Marker

When a record is written, a special attribute called a version marker is also written.

The name of this attribute is the concatenation of the `gazelle prefix`, `v_`, and the [version number](#version-number) of the [beacon version](#beacon-version)
currently being used to write new records.
The value has type "S" string, and the
string value is a single space. 

For example, version 12 would write the attribute `gZ_v_12`

When a customer wants to retire version 12, they can

 * scan the database for any records where attr_exists("gZ_v_12") and re-write them
 * create a temporary GSI, with a partition key of `gZ_v_12`, scan that table and
re-write the items. When the index is empty, the customer can be certain that
no records remain that were written with version 12.

### Primary Key Generation

A customer might have a table design, where the primary index contains
encrypted attributes.

This is impossible, as the primary keys cannot be encrypted,
but we can make it easy for them.

The customer needs to do two things
1. Create a GSI with the same partition and sort keys used in the original design.
1. Configure `Primary Key Generation` with a new primary key name, and
the partition and sort keys used in the original design.

When the customer writes an item, Gazelle will generate a new primary key
by concatenating the original partition and sort keys, and using the [beacon key](#beacon-keys) for the primary key to generate a 48-byte HMAC.
The primary key is this 48-byte binary value.

A customer can call GetItem using the original partition and sort keys,
and Gazelle will translate that into a call with the new computed primary key.

A customer can also call getItem using this generated key,
if they got it as the result of a previous query.


### Projections

In DynamoDB, Projections are the list of attributes stored in an index.

We strongly encourage customers to use `ALL`, which includes all
attributes in the index and always works.

If they choose to specify a list of attributes to include,
then for any [source field](#definitions) in the list
we must also include the associated [beacon field](#definitions)
so that querying can work.

For Global Secondary Indexes, this is the only option, because
attributes not included in the projection are simply not available.

For Local Secondary Indexes, all attributes are available, but
those not in the projection are slower to retrieve.
This opens the door to a NARROW projection.
In a NARROW projection, any [source field](#definitions) in the projection
must be **replaced** by its associated [beacon field](#definitions).
This allows for a smaller index, and so the server side
filtering can be faster and cheaper; however, retrieval of the records
that make it through the filtering will be slower.

### Writing

Whenever a record is written, if a [source field](#definitions) is written
then the [beacon field](#definitions) must also be written, which is
of type "S" string and holds the [calculated](#beacon-calculation) value.

It is an error to attempt to write an attribute starting with the [gazelle prefix](#gazelle-prefix).

For a record with 10 attributes, 6 of which have beacons,
a total of 19 or 20 attributes will be written
 * the original 10 (at least 6 of which are encrypted)
 * 6 beacons
 * 1 version tag
 * 1 encryption header
 * 1 encryption footer
 * 1 auto-generated [primary key](#primary-key-generation), if configured

### Reading

To retrieve a record based on the value of an encrypted [source field](#definitions),
search instead for the [beacon value](#beacon-calculation) in the [beacon field](#definitions).

 * With no beacon, an encrypted attribute cannot be searched.
 * With plain beacons, only exact matches can be supported.
 * compound beacons with a prefix can support ranged queries such as `<`, `between` and `begins_with`.
 * compound beacons with a split can support these ranged queries as well as `contains`

It is an error to attempt a query with an unsupported operation.

Because beacons might be truncated, these queries are expected to return false positive results.
After retrieving records in this way,
the decrypted records must be examined,
comparing the [source field](#definitions) values to the query values,
and non-matching items discarded.


### Indexing

When a request is made to create a Index for a [source field](#definitions),
instead the index must be created on the [beacon field](#definitions).

When the [projection](#projections) contains a [source field](#definitions), the [beacon field](#definitions) is also included in the projection.

Users might create tables and/or indexes in the console. In this case,
they must be well educated to perform these same transformations by hand.


### Conventions used in this document

The key words "MUST", "MUST NOT", "REQUIRED", "SHALL", "SHALL NOT", "SHOULD", "SHOULD NOT", "RECOMMENDED", "MAY", and "OPTIONAL"
in this document are to be interpreted as described in [RFC 2119](https://tools.ietf.org/html/rfc2119).


## Configuration

### DynamoDBEncryption

The DynamoDBEncryption object MUST contain

 * A map of TableName to [DynamoDBTableEncryption](#dynamodbtableencryption)

### DynamoDBTableEncryption

The DynamoDBTableEncryption object MUST contain

 * A map of Attribute Name to [EncryptionType](#encryptiontype)
 * The Attribute Name of the primary Partition Key
 * The Attribute Name of the primary Sort Key, if a sort key exists
 * A [BeaconContext](#beaconcontext)

### EncryptionType

An EncryptionType is one of

 * ENCRYPT_AND_SIGN
 * SIGN_ONLY
 * DO_NOTHING

### BeaconContext

The BeaconContext object MUST contain

 * A list of [BeaconVersion](#beaconversion)
 * The [version number](#version-number) of the [BeaconVersion](#beaconversion) to be used for writing

#### Current Version

The [BeaconVersion](#beaconversion) with the [version number](#version-number)
specified in the [BeaconContext](#beaconcontext) is known as the 
`current version`

### BeaconVersion

The BeaconVersion object MUST contain

 * version -- a [version number](#version-number)
 * beacons -- a list of [Beacon Record](./beacons.md#beacon-record)
 * key -- a [Beacon Key](#beacon-key)
 * primary -- an optional [primary key](#primary-key-generation),
 * narrowLSIs -- A list of LSI's that should be treated as NARROW,
as discussed in [Projections](#projections)

### PrimaryKey

The [PrimaryKey](#primary-key-generation) object MUST contain

 * primary -- the name of the constructed primary key
 * partition -- the name of the partition key used to construct primary
 * sort -- the name of the sort key used to construct primary, if any

## Operations

*Note* : The object types below are referred to by the Dafny names generated by Polymorph

*Note* : When the text below says "alter the input" this should be read as
"the output should be equal to the input, but altered in this way".

These operations MUST have access to a [DynamoDBEncryption](#dynamodbencryption).


### transformCreateTableInput

 * transformCreateTableInput MUST take a CreateTableInput object as input.
 * transformCreateTableInput MUST return a CreateTableInput object.
 * if a [generated primary key](#primary-key-generation) is configured, the returned value
MUST have a KeySchema equal to the result of calling
transformPrimaryKeySchema on the input KeySchema
 * if a [generated primary key](#primary-key-generation) is configured, transformCreateTableInput MUST fail
if the input KeySchema is not a single entry, with the
configured name and type `HASH`.
 * if a [generated primary key](#primary-key-generation) is configured, the returned AttributeDefinitions
must include an attribute with the name of the primary, and type "B" binary.
 * The returned GlobalSecondaryIndexes MUST be a sequence generated by
mapping each element of the input GlobalSecondaryIndexes through [transformGSI](#transformgsi)
 * The returned LocalSecondaryIndexes MUST be a sequence generated by
mapping each element of the input LocalSecondaryIndexes through [transformLSI](#transformlsi)
 * The returned AttributeDefinitions MUST be equal to the input AttributeDefinitions,
plus, for each [beacon field](#definitions) used in an index, an AttributeDefinition with the
AttributeName equal to the [beacon field](#definitions) and the AttributeType equal to "S" String.


### transformPutItemInput
 * transformPutItemInput MUST take as input an PutItemInput object.
 * transformPutItemInput MUST return an PutItemInput object.
 * The input conditionExpression MUST be tested with [testConditionExpression](#testconditionexpression)
 * transformPutItemInput MUST fail if the name of any input `Item` begins
with the [gazelle prefix](#gazelle-prefix). 
 * transformPutItemInput MUST use the [current version](#current-version)
 * The returned `Item` must include the current [version marker](#version-marker)
 * For each element in the `Item` map that specifies a [source field](#definitions),
 the returned `Item` map MUST also include the [beacon field](#definitions).
 * The name of this field MUST be the concatenation of the [beacon prefix](#beacon-prefix) and the [source field](#definitions) name.
 * The value of this field MUST be the defined [beacon](./beacons.md)
 * If a [generated primary key](#primary-key-generation) is configured, and the primary key name
already exists in `Item`, transformPutItemInput MUST fail.
 * If a [generated primary key](#primary-key-generation) is configured, an additional `Item` MUST be returned
with the configured name, type "B" Binary, and a value as calculated with [calculatePrimaryKeyValue](#calculateprimarykeyvalue). 

### transformUpdateItemInput
 * transformUpdateItemInput MUST take as input an UpdateItemInput
 * transformUpdateItemInput MUST return the unmodified input object
 * transformUpdateItemInput MUST fail if any part of the input
object mentions an attribute name starting with the [gazelle prefix](#gazelle-prefix).
 * transformUpdateItemInput MUST fail if the input object attempts to modify a signed attribute.
 * transformUpdateItemInput MUST fail if [testConditionExpression](#testconditionexpression) fails

### transformBatchWriteItemInput
 * transformBatchWriteItemInput MUST take as input a BatchWriteItemInput object.
 * transformBatchWriteItemInput MUST return a BatchWriteItemInput object.
 * Each PutRequest MUST be handled as outlined above in [transformPutItemInput](#transformputiteminput)

### transformTransactWriteItemsInput
 * transformTransactWriteItemsInput MUST take as input a TransactWriteItemsInput object.
 * transformTransactWriteItemsInput MUST return a TransactWriteItemsInput object.
 * Each `Put` MUST be handled as outlined above in [transformPutItemInput](#transformputiteminput)
 * Each Condition Expression must be tested with [testConditionExpression](#testconditionexpression)
 * Each Update must be handled as outlined above in [transformUpdateItemInput](#transformupdateiteminput)
 * The ConditionExpression of each Delete must be tested with [testConditionExpression](#testconditionexpression)
 

### transformGetItemInput

 * transformGetItemInput MUST take as input a GetItemInput object
 * transformGetItemInput MUST return GetItemInput object
 * If the table being updated has no [generated primary key](#primary-key-generation)  configured,
transformGetItemInput MUST return the input unmodified.
 * If the primary key name already exists in `Key`,
transformPutItemInput MUST return the input unmodified,
 * If the partition and sort keys do not exists in `Key`,
then transformGetItemInput MUST fail.
 * The returned `Key` must be the configured name, type "B" Binary,
and a value as calculated with [calculatePrimaryKeyValue](#calculateprimarykeyvalue). 

### transformBatchGetItemInput

 * transformBatchGetItemInput MUST take as input a BatchGetItemInput object
 * transformBatchGetItemInput MUST return BatchGetItemInput object
 * each request in the input must be transformed as for [transformGetItemInput](#transformGetItemInput)

### transformTransactGetItemsInput

 * transformBatchGetItemsInput MUST take as input a TransactGetItemsInput object
 * transformBatchGetItemsInput MUST return TransactGetItemsInput object
 * each request in the input must be transformed as for [transformGetItemInput](#transformGetItemInput)

### transformExecuteStatementInput
 * transformExecuteStatementInput MUST take as input a ExecuteStatementInput object
 * transformExecuteStatementInput MUST return a ExecuteStatementInput object
 * transformExecuteStatementInput MUST fail if the input object refers to 
a table which has any encrypted attributes configured.
 * transformExecuteStatementInput MUST return the unmodified input object

### transformBatchExecuteStatementInput
 * transformBatchExecuteStatementInput MUST take as input a BatchExecuteStatementInput object
 * transformBatchExecuteStatementInput MUST return a BatchExecuteStatementInput object
 * transformBatchExecuteStatementInput MUST fail if the input object refers to 
a table which has any encrypted attributes configured.
 * transformBatchExecuteStatementInput MUST return the unmodified input object

### transformExecuteTransactionInput
 * transformExecuteTransactionInput MUST take as input a ExecuteTransactionInput object
 * transformExecuteTransactionInput MUST return a ExecuteTransactionInput object
 * transformExecuteTransactionInput MUST fail if the input object refers to 
a table which has any encrypted attributes configured.
 * transformExecuteTransactionInput MUST return the unmodified input object


### transformQueryInput
 * transformQueryInput MUST take as input a QueryInput object.
 * transformQueryInput MUST return a QueryInput object.
 * transformQueryInput MUST fail if an attribute name that starts with the [gazelle prefix](#gazelle-prefix) is mentioned.
 * If no encrypted field is mentioned, transformQueryInput MUST return the unmodified input object.
 * The output object's `Filter Expression` must be derived from the input `Filter Expression` according to [transformationFilterExpression](#transformationfilterexpression).
 * If the `keyConditionExpression` refers to no encrypted attributes,
then the result MUST be returned after only the above operations.

The final step is to find the proper [BeaconVersion](#beaconversion) for
this query, and the associated keyConditionExpression and exclusiveStartKey.

 * transformQueryInput MUST call [createKeyConditionList](#createkeyconditionlist) to create `KeyConditionList`
 * transformQueryInput MUST call [findVersion](#findversion) to create `currentVersion` and `hadContent`
 * transformQueryInput MUST fail if [findVersion](#findversion) returned (None, true)
 * if [findVersion](#findversion) returned (None, false) then transformQueryInput MUST return
the `keyConditionExpression` with the lowest version and no exclusiveStartKey
 * if [findVersion](#findversion) returned (Some(currentVersion), false), then transformQueryInput MUST return
the keyConditionExpression with lowest version greater than currentVersion,
and no exclusiveStartKey
 * if [findVersion](#findversion) returned (Some(currentVersion), true), then transformQueryInput MUST return
 * * the keyConditionExpression that matches currentVersion, and the exclusiveStartKey with the  gZ_version` field removed, if such a keyConditionExpression exists.
 * * the keyConditionExpression with the lowest version greater than currentVersion, with no exclusiveStartKey if such a keyConditionExpression exists
 * * failure if all available versions are less than the returned version.

### transformQueryOutput
transformQueryOutput needs the original QueryInput object,
because we need to check the result records against the values searched in the QueryInput object, which are not directly available in the QueryOutput object.

 * transformQueryOutput MUST take as input a QueryOutput object and a QueryInput object
 * The QueryInput object MUST be assumed to be the original query, not the result of a [transformQueryInput](#transformqueryinput) call.
 * transformQueryOutput MUST return a QueryOutput object.
 * transformQueryOutput MUST remove any records for which the original QueryInput does not match, that is,
if the original FilterExpression included `Src EQ "foo"` (where `Src` is a [source field](#definitions))
then this operation must remove any record in which the `Src` field contains something other than "foo".
 * This operation MUST return all records that match the original QueryInput.

The final step is to tag the LastEvaluatedKey

 * transformQueryOutput MUST call [createKeyConditionList](#createkeyconditionlist) to create a `keyConditionList`
 * transformQueryOutput MUST use [findVersion](#findversion) to retrieve the `currentVersion`
 * if `currentVersion` is None, replace it with the lowest version in keyConditionList
 * If the input object has a LastEvaluatedKey, transformQueryOutput must return a LastEvaluatedKey equal to the input LastEvaluatedKey with the addition of a number field `gZ_version=currentVersion`
 * If the input object has no LastEvaluatedKey, and `currentVersion` is greater than or equal to the highest version in the keyConditionList, then transformQueryOutput must return an object with no LastEvaluatedKey
 * Otherwise, transformQueryOutput must return a LastEvaluatedKey containing only a number field `gZ_version` set to the lowest version in keyConditionList greater than `currentVersion`


### transformScanInput
 * transformScanInput MUST take as input a ScanInput object.
 * transformScanInput MUST return a ScanInput object.
 * The object's filterExpression it must be modified according to
[transformationFilterExpressionMulti](#transformationfilterexpressionmulti).


### transformScanOutput
 * transformScanOutput MUST take as input a ScanOutput object and a ScanInput object.
 * transformScanOutput MUST return an ScanOutput object.
 * The ScanInput object MUST be assumed to be the original ScanInput object,
and not the result of a [transformScanInput](#transformscaninput) call.
 * transformScanOutput MUST remove any records for which the original QueryInput does not match, that is,
if the original FilterExpression included `Src EQ "foo"` (where `Src` is a [source field](#definitions))
then this operation must remove any record in which the  `Src` field contains something other than "foo".
 * transformScanOutput MUST return all records that match the original ScanInput.


## Helpers


### forbiddenField

forbiddenField  return true if the input  one of the
[Forbidden Fields](#forbidden-fields)

 * forbiddenField MUST take a string as input
 * forbiddenField MUST return a boolean
 * if the input string begins with gZ_v_ forbiddenField MUST return false
 * if the input string begins with gZ_ forbiddenField MUST return true
 * forbiddenField MUST return false

### transformPrimaryKeySchema
 * transformPrimaryKeySchema MUST take a KeySchema as input
 * transformPrimaryKeySchema MUST return a KeySchema
 * if no [generated primary key](#primary-key-generation) is configured, transformKeySchema MUST return the unaltered input
 * transformPrimaryKeySchema  MUST fail if the input KeySchema is not empty.
 * transformPrimaryKeySchema MUST return a KeySchema
with the name given in the [generated primary key](#primary-key-generation)  and type `HASH`

### calculatePrimaryKeyValue
 * calculatePrimaryKeyValue MUST take a PutItemInputAttributeMap as input
 * calculatePrimaryKeyValue MUST return `seq<uint8>` of length 48.
 * calculatePrimaryKeyValue MUST fail if no [generated primary key](#primary-key-generation) is configured
 * calculatePrimaryKeyValue MUST fail if the partition key is missing from the input attributes.
 * calculatePrimaryKeyValue MUST fail if the sort key is specified, yet missing from the input attributes.
 * The data key used for the HMACs below MUST be the [beacon key](#beacon-keys) for the primary key name.
 * If only a partition key is specified, then an HMAC384 must be generated from
the [serialization](../dynamodb-encryption-client/ddb-attribute-serialization.md)
of that attribute.
 * Otherwise, an HMAC384 must be generated from the concatenation of the [serialization](../dynamodb-encryption-client/ddb-attribute-serialization.md) of the partition key attribute,
a literal `_` character, and the [serialization](../dynamodb-encryption-client/ddb-attribute-serialization.md) of the sort key attribute.


### transformKeySchemaElement
 * transformKeySchemaElement MUST take a KeySchemaElement as input
 * transformKeySchemaElement MUST return a KeySchemaElement
 * transformKeySchemaElement MUST fail if the input AttributeName
is a [forbiddenField](#forbiddenfield)
 * transformKeySchemaElement MUST fail if the input AttributeName refers to a [non-beaconed field](#definitions).
 * If the input AttributeName refers to a [source field](#definitions), the AttributeName 
of the returned KeySchemaElement must be the name of the associated [beacon field](#definitions).
 * Otherwise, the returned KeySchemaElement MUST be returned unchanged.

### transformGSI
 * transformGSI MUST take a GlobalSecondaryIndex as input
 * transformGSI MUST return a GlobalSecondaryIndex
 * The returned GlobalSecondaryIndex MUST have a KeySchema generated by
mapping each element of the input KeySchema through [transformKeySchemaElement](#transformkeyschemaelement)
 * transformGSI MUST fail if the projection includes a name which
is a [forbiddenField](#forbiddenfield).
 * transformGSI MUST return a Projection with NonKeyAttributes equal to
all input NonKeyAttributes, plus the associated [beacon field](#definitions)
for any [source field](#definitions) in the NonKeyAttributes.

### transformLSI
 * transformGSI MUST take a LocalSecondaryIndex as input
 * transformGSI MUST return a LocalSecondaryIndex
 * The returned LocalSecondaryIndex MUST have a KeySchema generated by
mapping each element of the input KeySchema through [transformKeySchemaElement](#transformkeyschemaelement)
 * transformGSI MUST fail if the Projection includes a name which is a 
[forbiddenField](#forbiddenfield).
 * If this index is configured as NARROW, transformLSI MUST return
a Projection with NonKeyAttributes equal to the input NonKeyAttributes,
with any [source field](#definitions) replaced with its associated [beacon field](#definitions).
 * If this index is not configured as NARROW,
transformLSI MUST return a Projection with NonKeyAttributes equal to
all input NonKeyAttributes, plus the associated [beacon field](#definitions)
for any [source field](#definitions) in the NonKeyAttributes.

### testConditionExpression
 * testConditionExpression MUST take as input
an `Option<ConditionExpression>`,
and an `Option<ExpressionAttributeNameMap>`
 * testConditionExpression MUST return a boolean
 * testConditionExpression MUST fail if the ConditionExpression refers to an encrypted field.
 * testConditionExpression MUST fail if the ConditionExpression refers to a
[forbiddenField](#forbiddenfield).
 * testConditionExpression MUST return true

### transformationFilterExpression
 * transformationFilterExpression MUST take as input
a [BeaconVersion](#beaconversion),
an `Option<ConditionExpression>`,
an `Option<ExpressionAttributeNameMap>`,
and an `Option<ExpressionAttributeValueMap>`
 * transformationFilterExpression MUST return
an `Option<ConditionExpression>`,
an `Option<ExpressionAttributeNameMap>`,
and an `Option<ExpressionAttributeValueMap>`
 * This operation MUST fail if an attribute name is a [forbiddenField](#forbiddenfield)
 * This operation MUST fail if any [source field](#definitions) is used with a document path.
 * If no encrypted field is mentioned, the Expression MUST be returned unmodified.
 * The operations `attribute_exists`, `attribute_not_exists` and `size` are permitted on any field, and their arguments MUST not be modified.
 * All operations are permitted on unencrypted fields.
 * The operations `=`, `IN`, `attribute_exists`, `attribute_not_exists` and `size`;
as well as the boolean `AND`, `OR` and `NOT` are permitted for any type of beacon.
 * All comparators, and the `BETWEEN` and `begins_with` operations are permitted on
beacons configured with `prefix` or `split`.
 * The operation `contains` is permitted on beacons configured with `split`.
 * This operation MUST fail if a field is used with an operation that is not permitted.
 * Each reference to a field with a beacon must be replaced by the associated beacon.
For example, `field < value` would be replaced by `gZ_b_field < beacon_value`

### transformationFilterExpressionMulti
 * transformationFilterExpression MUST take as input
a list of [BeaconVersions](#beaconversion),
an `Option<ConditionExpression>`,
an `Option<ExpressionAttributeNameMap>`,
and an `Option<ExpressionAttributeValueMap>`
 * transformationFilterExpression MUST return
an `Option<ConditionExpression>`,
an `Option<ExpressionAttributeNameMap>`,
and an `Option<ExpressionAttributeValueMap>`
 * If no [BeaconVersion](#beaconversion) is provided, transformationFilterExpressionMulti
MUST return the input arguments unchanged.
 * If one [BeaconVersion](#beaconversion) is provided, transformationFilterExpressionMulti
MUST return the results of [transformationFilterExpression]
(#transformationfilterexpression) with that beacon version.
 * transformationFilterExpressionMulti MUST create a list of results by calling
[transformationFilterExpression](#transformationfilterexpression)
with each provided Beacon Version.
 * transformationFilterExpressionMulti MUST remove duplicates from this list.
 * transformationFilterExpressionMulti MUST join the remaining ones, individually parenthesized, with `OR`.
For example, if E1 and E2 are created and unique, return `(E1) OR (E2)`

### findVersion
findVersion looks at the exclusiveStartKey in a QueryInput
and returns the [version number](#version-number) held therein.

 * findVersion MUST take as input a QueryInput object
 * findVersion MUST return both an optional version number and a boolean `hadContent` flag.
 * If the input object has no exclusiveStartKey, then findVersion MUST return (None, false)
 * If the exclusiveStartKey has a `gZ_version` field which holds a number,
the first value returned by findVersion MUST be that number, and None otherwise
 * If the exclusiveStartKey has fields other than `gZ_version`,
the second value returned by findVersion MUST be true, and false otherwise

### createKeyCondition
 * createKeyCondition MUST take as input a keyConditionExpression and a single [beacon version](#beaconversion).
 * createKeyCondition MUST return a keyConditionExpression
 * createKeyCondition MUST replace each reference to a [source field](#definitions) with the associated beacon and value. For example, `field < value` would be replaced by `gZ_b_field < beacon_value`
 * createKeyCondition MUST fail if and operator other than `=` is used with
a beacon configured with neither `prefix` nor `split`
 * createKeyCondition MUST fail if and operator other than `=` or `begins_with` is used with a beacon not configured with `prefix`


### createKeyConditionList
 * createKeyConditionList MUST take as input a QueryInput object
 * createKeyConditionList MUST return a list of keyConditionExpression,
each with an associated [beacon version](#beaconversion).
 * For each [beacon version](#beacon-version) in the
[BeaconContext](#beaconcontext),
create keyConditionExpression with [createKeyCondition](#createkeycondition)
 * remove any duplicate keyConditionExpressions, keeping the ones with the highest version number.

## Operational Considerations
Fully supporting FilterExpressions, will require a complete parsing of the FilterExpression,
which is sensitive to any updates that the DynamoDB team makes to the expression language, and is dependent upon the rather sketchy documentation of the semantics
of filter expressions.


