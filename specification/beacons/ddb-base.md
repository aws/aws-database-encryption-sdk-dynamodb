[//]: # "Copyright Amazon.com Inc. or its affiliates. All Rights Reserved."
[//]: # "SPDX-License-Identifier: CC-BY-SA-4.0"

# DynamoDB Beacons

## Version

1.0.0

### Changelog

## Overview

This document assumes familiarity with [beacons](./beacons.md),
and specifies their use with DynamoDB.

For additional functionality, see
 * [versions](./ddb-versions.md)
 * [primary keys](./ddb-primary.md)
 * [partiql](./ddb-partiql.md)

Everything above [Conventions used in this document](#conventions-used-in-this-document)
is background information, and is not technically part of the specification,
and therefore any use of the word `must` is strictly colloquial. 

The basic user experience is this 
 *  Customer constructs a client object with [DDBEC magic](../dynamodb-encryption-client/ddb-sdk-integration.md).
 * Customer calls client methods as normal

For each client operation, the workflow looks something like this

1. Customer makes a request
1. DDBEC calls one of the below functions to transform the request
1. DDBEC encrypts the request, if necessary
1. DDBEC calls the underlying DynamoDB client method
1. DDBEC decrypts the response, if necessary
1. DDBEC calls one of the below functions to transform the response
1. Customer receives the response.

### Beacon Searches

Beacons exist because you can't search on encrypted fields.

In the general case, a customer writes a query as if the
table were not encrypted, and we re-write the query
to search against the beacon instead. 

For example, if a customer search for `field = abc` it might
be rewritten as `gZ_b_field = 4a7`. Because beacon values
are truncated, `gZ_b_field = 4a7` will likely retrieve items
for which `field` is not `abc`, and so a post-processing step
is required, after the item is decrypted, to filter out
the false matches.

### Supported Operations

DynamoDB has many ways of searching, and different kinds of beacon
can support them in various ways.

Beacons are just strings, and so DynamoDB is happy to let you
query them like any other string; however, semantically, some
of these searches make no sense, and so Query and Scan should 
fail if these are used in inappropriate ways.

`attribute_exists`, `attribute_not_exists` and `size` can be used
directly on encrypted attributes, since they don't reference the
underlying value.

`attribute_type` can't be used with encrypted attributes, with or without
beacons, because type information is not available.

A [standard beacon](./beacons.md#standard-beacon) is an opaque token.
It can be tested for equality, but not compared to other beacons or
to literal values. Thus a [standard beacon](./beacons.md#standard-beacon)
allows an encrypted attribute to be used with the `=` operator or the `IN` function.

[split beacons](./beacons.md#split-beacon) produce an
ordered list of opaque tokens. Thus is make no sense to compare
for anything but equality, and so comparisons like `less than` and 
`between` are still forbidden.
However, `begins_with` is ok, as it simply matches a prefix for equality.
Similarly, `contains` is ok, as it matches a run of opaque tokens for equality.

A [prefix beacon](./beacons.md#prefix-beacon) starts with some plain text,
making it suitable for all the comparison operations.

Operations supported on encrypted attributes. Each row inherits
all of the options from the rows above.

 * no beacon : `attribute_exists`, `attribute_not_exists` and `size`
 * [standard beacon](./beacons.md#standard-beacon) : `=` and `IN`
 * [split beacon](./beacons.md#split-beacon) : `contains` and `begins_with `
 * [prefix beacon](./beacons.md#prefix-beacon) : `between` and comparisons such as `<`

a [combined beacon](./beacons.md#combined-beacon) has a prefix, and thus
can handle all operations, like a [prefix beacon](./beacons.md#prefix-beacon).

There are still plenty of inappropriate ways for a customer to search on beacons,
but these are all we will preemptively forbid.

All operations MUST fail if used with an unsupported operation.


### Definitions
 * **source field** : an encrypted attribute with an associated beacon
 * **non-beaconed field** : an encrypted attribute without an associated beacon
 * **beacon field** : the attribute holding the beacon value associated with a source field

### Reserved Prefix

#### DDBEC Prefix
DDBEC already reserves all attribute names starting with `gZ_` (actual prefix up for debate)

#### Beacon Prefix
All beacon values are written as attributes beginning with the [DDBEC Prefix](#ddbec-prefix) followed by `b_`, i.e. `gZ_b_`. 

For the [source field](#source-field) `foo` the associated 
[beacon field](#beacon-field) would be `gZ_b_foo`

Customers are not allowed to read or write any attribute beginning
with the [DDBEC Prefix](#ddbec-prefix).

### Beacon Calculation

To calculate the beacon value for an attribute

1. If the attribute is type "S" string, then call [compoundHash](./beacons.md#compoundHash) on the string value.
1. If the attribute is not a string,
and the beacon is [compound](./beacons.md#IsCompound),
then the beacon calculation fails.
1. otherwise, [serialize](../dynamodb-encryption-client/ddb-attribute-serialization.md)
the attribute, and call [plainHash](./beacons.md#plainHash) on the result.

### Beacon Keys

A single non-rotating branch key will be stored in the hierarchy keyring
for each table.
For each individual beacon, we will call the hierarchy keyring's
HKDF function, using a SHA256 of the beacon name as the salt
to generate a consistent HMAC key for each beacon.
Details to be firmed up once there is a hierarchy keyring spec.

Beacon keys don't rotate, because if they did all of the beacon values
would change and you wouldn't be able to find any of your data.

[TODO: add link to hierarchy keyring spec in private-aws-encryption-sdk-specification-staging]

### Writing

Whenever an item is written, if a [source field](#definitions) is written
then the [beacon field](#definitions) must also be written, which is
of type "S" string and holds the [calculated](#beacon-calculation) value.

It is an error for a customer to attempt to write an attribute starting with the [ddbec prefix](#ddbec-prefix).

For an item with 10 attributes, 6 of which have beacons,
a total of 19 or 20 attributes will be written
 * the original 10 (at least 6 of which are encrypted)
 * 6 beacons
 * 1 [version marker](#version-marker)
 * 1 encryption header
 * 1 encryption footer
 * 1 auto-generated [primary key](#primary-key-generation), if configured

## Conventions used in this document

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

### BeaconVersion

The BeaconVersion object MUST contain

 * beacons -- a list of [Beacon Record](./beacons.md#beacon-record)
 * key -- a [Beacon Key](#beacon-key)

## Operations

The object types below are referred to by the Dafny names generated by Polymorph

When the text below says "alter the input" this should be read as
"the output should be equal to the input, but altered in this way".

These operations are defined in terms of functionality
defined in the following section, [Helpers](#beacon-helpers).

These operations MUST have access to a [DynamoDBEncryption](#dynamodbencryption).


### TransformCreateTableInput

The signature of TransformCreateTableInput MUST be
 * A CreateTableInput object as input.
 * A CreateTableInput object as output.

In Dafny: 
`TransformCreateTableInput(config : DynamoDBEncryption, input : CreateTableInput) : Result<CreateTableInput, string>`

 * If no beacons are configured for TableName, the input MUST be returned unaltered.
 * KeySchema MUST be transformed by [TransformKeySchema](#transformkeyschema)
 * GlobalSecondaryIndexes MUST be transformed by [transformGSI](#transformgsi)
 * LocalSecondaryIndexes MUST be transformed by [transformLSI](#transformlsi)
 * TransformCreateTableInput MUST fail if any AttributeDefinition is not
a ReadableAttribute.
 * AttributeDefinitions MUST be the input AttributeDefinitions plus any beacon
fields used in the KeySchema, GlobalSecondaryIndexes or LocalSecondaryIndexes.

The result MUST contain these changes and no others.

### TransformUpdateTableInput

The signature of TransformCreateTableInput MUST be
 * A UpdateTableInput object as input.
 * A UpdateTableInput object as output.

In Dafny: 
`TransformUpdateTableInput(config : DynamoDBEncryption, input : UpdateTableInput) : Result<UpdateTableInput, string>`

 * If no beacons are configured for TableName, the input MUST be returned unaltered.
 * GlobalSecondaryIndexes MUST be transformed by [transformGSI](#transformgsi).
 * TransformUpdateTableInput MUST fail if any AttributeDefinition is not
a ReadableAttribute.
 * All beacon fields used in the GlobalSecondaryIndexes MUST
be added to the AttributeDefinitions.

The result MUST contain these changes and no others.


### TransformPutItemInput

The signature of TransformPutItemInput MUST be
 * A PutItemInput object as input.
 * A PutItemInput object as output.

In Dafny: 
`TransformPutItemInput(config : DynamoDBEncryption, input : PutItemInput) : Result<PutItemInput, string>`

 * The input ConditionExpression MUST be tested with [testConditionExpression](#testconditionexpression)
 * TransformPutItemInput MUST fail if the name of any input `Item`
is not a [Writable Attribute](#writableattribute)
 * For each element in the `Item` map that specifies a [source field](#definitions),
 the returned `Item` map MUST also include the [beacon field](#definitions).
 * The name of this attribute MUST be the concatenation of the [beacon prefix](#beacon-prefix) and the [source field](#definitions) name.
 * The value of this attribute MUST be the defined [beacon calculation](#beacon-calculation)

### TransformUpdateItemInput

The signature of TransformUpdateItemInput MUST be
 * A UpdateItemInput object as input.
 * A UpdateItemInput object as output.

In Dafny: 
`TransformUpdateItemInput(config : DynamoDBEncryption, input : UpdateItemInput) : Result<UpdateItemInput, string>`


 * TransformUpdateItemInput MUST fail if the ConditionExpression
mentions an attribute name that is not a [Writable Attribute](#writableattribute)
 * TransformUpdateItemInput MUST fail if the UpdateExpression attempts to modify a signed attribute.
 * TransformUpdateItemInput MUST fail if [testConditionExpression](#testconditionexpression) fails

### TransformBatchWriteItemInput

The signature of TransformBatchWriteItemInput MUST be
 * A BatchWriteItemInput object as input.
 * A BatchWriteItemInput object as output.

In Dafny: 
`TransformUpdateItemInput(config : DynamoDBEncryption, input : BatchWriteItemInput) : Result<BatchWriteItemInput, string>`

Each PutRequest MUST be handled as outlined above in [TransformPutItemInput](#transformputiteminput)

### TransformTransactWriteItemsInput

The signature of TransformTransactWriteItemsInput MUST be
 * A TransactWriteItemsInput object as input.
 * A TransactWriteItemsInput object as output.

In Dafny: 
`TransformTransactWriteItemsInput(config : DynamoDBEncryption, input : TransactWriteItemsInput) : Result<TransactWriteItemsInput, string>`

 * Each `Put` MUST be handled as outlined above in [TransformPutItemInput](#transformputiteminput)
 * Each ConditionExpression must be tested with [testConditionExpression](#testconditionexpression)
 * Each Update must be handled as outlined above in [TransformUpdateItemInput](#transformupdateiteminput)
 

### TransformQueryInput

The signature of TransformQueryInput MUST be
 * A QueryInput object as input.
 * A QueryInput object as output.

In Dafny: 
`TransformQueryInput(config : DynamoDBEncryption, input : QueryInput) : Result<QueryInput, string>`

 * TransformQueryInput MUST fail if an attribute name is mentioned
that is not a [Readable Attribute](#readableattribute).
 * If no encrypted attribute is mentioned, TransformQueryInput MUST return the unmodified input object.
 * The KeyConditionExpression must be transformed with [transformKeyConditionExpression](#transformkeyconditionexpression).
 * The FilterExpression must be transformed with [tranformationFilterExpression](#transformationfilterexpression).

### transformQueryOutput

The signature of TransformQueryInput MUST be
 * A QueryOutput object as input.
 * A QueryInput object as input.
 * A QueryOutput object as output.

In Dafny: 
`TransformQueryOutput(config : DynamoDBEncryption, input : QueryOutput, query : QueryInput) : Result<QueryOutput, string>`


transformQueryOutput needs the original QueryInput object,
because we need to check the result items against the values searched in the QueryInput object, which are not available in the QueryOutput object.

 * The QueryInput object MUST be assumed to be the original query, not the result of a [TransformQueryInput](#transformqueryinput) call.
 * transformQueryOutput MUST remove any items for which the original QueryInput does not match, that is,
if the original FilterExpression included `Src EQ "foo"` (where `Src` is a [source field](#definitions))
then this operation must remove any item in which the `Src` attribute contains something other than "foo".
 * This operation MUST return all items that match the original QueryInput.
 * Count must be updated to reflect the number of ites returned.


### TransformScanInput

The signature of TransformScanInput MUST be
 * A ScanInput object as input.
 * A ScanInput object as output.

In Dafny: 
`TransformScanInput(config : DynamoDBEncryption, input : ScanInput) : Result<ScanInput, string>`

 * TransformScanInput MUST fail if an attribute name is mentioned
that is not a [Readable Attribute](#readableattribute).
 * If no encrypted attribute is mentioned, TransformScanInput MUST return the unmodified input object.
 * The FilterExpression must be transformed with [tranformationFilterExpression](#transformationfilterexpression).


### TransformScanOutput

The signature of TransformScanOutput MUST be
 * A ScanOutput object as input.
 * A ScanInput object as input.
 * A ScanOutput object as output.

In Dafny: 
`TransformScanOutput(config : DynamoDBEncryption, input : ScanOutput, query : ScanInput) : Result<ScanOutput, string>`


TransformScanOutput needs the original ScanInput object,
because we need to check the result items against the values searched in the ScanInput object, which are not available in the ScanOutput object.

 * The ScanInput object MUST be assumed to be the original query, not the result of a [TransformScanInput](#transformscaninput) call.
 * TransformScanOutput MUST remove any items for which the original ScanInput does not match, that is,
if the original FilterExpression included `Src EQ "foo"` (where `Src` is a [source field](#definitions))
then this operation must remove any item in which the `Src` attribute contains something other than "foo".
 * This operation MUST return all items that match the original ScanInput.
 * Count must be updated to reflect the number of ites returned.


## Helpers

### readableAttribute

readableAttribute test an AttributeName, and returns `true`
if a customer is allowed to read that attribute.

 * readableAttribute MUST return false if the AttributeName starts
with the [ddbec Prefix](#ddbec-prefix), and true otherwise.

### writableAttribute

writableAttribute test an AttributeName, and returns `true`
if a customer is allowed to write that attribute.

 * writableAttribute MUST return false if the AttributeName starts
with the [ddbec Prefix](#ddbec-prefix), and true otherwise.



### transformKeySchemaElement

transformKeySchemaElement transforms a KeySchemaElement

 * transformKeySchemaElement MUST fail if the input AttributeName
is not a [Readable Attribute](#readableattribute).
 * transformKeySchemaElement MUST fail if the input AttributeName refers to a [non-beaconed field](#definitions).
 * If the input AttributeName refers to a [source field](#definitions), the AttributeName 
of the returned KeySchemaElement must be the name of the associated [beacon field](#definitions).
 * Otherwise, the returned KeySchemaElement MUST be returned unchanged.

### transformGSI

transformGSI transforms a GlobalSecondaryIndex

 * The KeySchema MUST be transformed by [transformKeySchemaElement](#transformkeyschemaelement)

If the Projection is INCLUDE

 * transformGSI MUST fail if the NonKeyAttributes includes a name which
is not a [Readable Attribute](#readableattribute).
 * transformGSI MUST add to NonKeyAttributes
the [beacon field](#definitions) associated with
any [source field](#definitions) in the NonKeyAttributes.

### transformLSI

transformLSI transforms a LocalSecondaryIndex

 * The KeySchema MUST be transformed by [transformKeySchemaElement](#transformkeyschemaelement)

If the Projection is INCLUDE

 * transformLSI MUST fail if the NonKeyAttributes includes a name which
is not a [Readable Attribute](#readableattribute).
 * transformLSI MUST add to NonKeyAttributes
the [beacon field](#definitions) associated with
any [source field](#definitions) in the NonKeyAttributes.

### testConditionExpression

testConditionExpression looks at a ConditionExpression and its
asociated ExpressionAttributeNameMap, and fails if
something is amiss.

* testConditionExpression MUST fail if the ConditionExpression refers to an encrypted attribute.
 * testConditionExpression MUST fail if the ConditionExpression refers to
a name that is not a [Readable Attribute](#readableattribute)

### transformationFilterExpression

transformationFilterExpression alters a (ConditionExpression,
ExpressionAttributeNameMap, ExpressionAttributeValueMap)
triplet, for use with beacons.

 * transformationFilterExpression MUST fail if any [source field](#definitions) is used with a document path.
 * transformationFilterExpression MUST fail if any 
non-[Readable Attribute](#readableattribute) is mentioned.
 * If no encrypted attribute is mentioned, the input MUST be returned unaltered.
 * transformationFilterExpression  MUST fail if any encrypted attribute
is used with an operation that is not [supported](#supported-operation)
 * Each reference to a attribute with a beacon must be replaced by the associated beacon.
For example, `field < value` would be replaced by `gZ_b_field < beacon_value`

### transformKeyConditionExpression

transformKeyConditionExpression transforms a keyConditionExpression,
in exactly the same way as [transformationFilterExpression](#transformationfilterexpression)

## Operational Considerations
Fully supporting FilterExpressions, will require a complete parsing of the FilterExpression,
which is sensitive to any updates that the DynamoDB team makes to the expression language, and is dependent upon the rather sketchy documentation of the semantics
of filter expressions.
