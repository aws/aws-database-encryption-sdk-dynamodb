[//]: # "Copyright Amazon.com Inc. or its affiliates. All Rights Reserved."
[//]: # "SPDX-License-Identifier: CC-BY-SA-4.0"

# Scan Beacons

## Version

0.1.0

### Changelog

## Overview

A scan beacon is a stable HMAC of the unencrypted value of an encrypted field.
This allows a database server to perform some types of searches on client-side encrypted records.
It can be optionally truncated to better avoid creating distinguishers of the plaintext.

It should be noted that primary keys cannot be scan beacons,
both because primary keys are not encrypted
and because scan becaons are designed to create false duplicates.

## Definitions

### Conventions used in this document

The key words "MUST", "MUST NOT", "REQUIRED", "SHALL", "SHALL NOT", "SHOULD", "SHOULD NOT", "RECOMMENDED", "MAY", and "OPTIONAL"
in this document are to be interpreted as described in [RFC 2119](https://tools.ietf.org/html/rfc2119).

## Key Indicator

This is the configuration text supplied by the user to designate the appropriate key for creating the HMAC hash.

A key indicator MUST consist of exactly one of the following
 * The encrypted form of a data key, as returned by the KMS `GenerateDataKey` operation,
the associated [Key ID](https://github.com/awslabs/aws-encryption-sdk-specification/blob/master/framework/aws-kms/aws-kms-key-arn.md#a-valid-aws-kms-identifier).
The library will call AWS KMS to decrypt the key.
Then the library caches the plaintext key and calculates the HMAC locally.
More complex configuration, faster execution time.
 * The [ARN](https://github.com/awslabs/aws-encryption-sdk-specification/blob/master/framework/aws-kms/aws-kms-key-arn.md#a-valid-aws-kms-arn) of a KMS HMAC key. The KMS `GenerateMac` method will be called for every HMAC
calculation. Easier configuration, slower execution time.

## Scan Beacon Configuration

A scan beacon definition MUST provide the following:
 * The source field name; i.e. the name of the DynamoDB attribute for which you want to generate a scan beacon
 * The scan beacon field name; i.e. the name of the DynamoDB attribute to hold the resulting scan beacon value
 * The key indicator
 * The hash length (number of bits) of the scan beacon
 
A scan beacon definition MUST accept an optional parameter to provide a "previous" entry consisting on one of :
 * an empty value, indicating that the field was not previously a beacon
 * The previous key indicator and the previous hash length (number of bits) of the scan beacon

#### Note : Any individual scan becaon can have no more than one "previous" entry.

This optional previous values allows the library to support changes in the configuration over time.
If the configuration for a scan beacon changes,
the library can search for both the scan beacon as calculated with the current configuration
and also the scan beacon as calculated with the previous configuration,
and return the union of the two.

#### Note : All the handling of "previous" entries must be considered tentative, as SDK support for intercepting query calls varies among languages, and the support we need might not be available everywhere, e.g. in Java.
 
## Scan Beacon Operation

### hash

This operation MUST take the plain text of the source field as input.

This operation MUST must take the [HmacSha384](https://www.ietf.org/rfc/rfc2104.txt) of the plain text and the specified key
and return the most significant `hash length` bits as an unsigned integer.

## Item Encryptor Behavior

Here is the specification for how the item encryptor specifically behaves with configured scan beacons.

A `DynamoDBTableEncryptionConfig` object provides the list of Scan Beacons for the table associated with an operation.
Various Request and Response objects are transformed, based on these Scan Beacons.

### Overview

All Scan Beacon Group operations are a convenience for using the DynamoDB Encryption Client.
The user calls the SDK referring to the encrypted data fields,
and these operations transform the Request and Response objects to use the scan beacons instead.

#### Indexing

When a request is made to create a Index for a source field,
instead the index must be created on the scan beacon field.

#### Writing

Whenever a record is written, if the source field is written then the scan beacon field must also be written,
containing the Scan Beacon Hash of the plain text of the source field.

It is a error to attempt to write a source field with the same name as a scan beacon field.

#### Reading

To retrieve a record based on the value of an encrypted source field,
search instead for the hash of the value in the scan beacon field.

Note that only exact matches can be supported. No ranged queries or inequalities.
It is an error to attempt such a query.

This might return false positive results. After retrieving records in this way,
you must decrypt the record and compare the source field value to the query value,
and discard any records where they don't match.

## Operations

#### Note : The object types below are referred to by the Dafny names generated by Polymorph

### transformCreateTableInput

 * This operation MUST take a CreateTableInput object as input.
 * This operation MUST return a CreateTableInput object.
 * If no Global Secondary Index is being created, the CreateTableInput object MUST be returned unaltered.
 * If the Global Secondary Index being created includes no source fields, that is,
if the KeySchema does not mention a source field, the CreateTableInput object MUST be returned unaltered.
 * If the Global Secondary Index being created includes a source field,
the returned CreateTableInput object MUST replace the source field names
with the corresponding scan beacon field names in the KeySchema.

### transformUpdateTableInput

 * This operation MUST take as input an UpdateTableInput object.
 * This operation MUST return an UpdateTableInput object.
 * If no Global Secondary Index is being created, the UpdateTableInput object MUST be returned unaltered.
 * If the Global Secondary Index being created includes no source fields, that is,
if the KeySchema does not mention a source field, the UpdateTableInput object MUST be returned unaltered.
 * If the Global Secondary Index being created includes a source field,
the returned UpdateTableInput object MUST replace the source field names with the corresponding scan beacon field names in the KeySchema.

### transformPutItemInput
 * This operation MUST take as input an PutItemInput object.
 * This operation MUST return an PutItemInput object.
 * For each source field being written, the returned PutItemInput MUST also write the scan beacon field.
 * An error MUST be returned if a scan beacon field is used in the input PutItemInput.

### transformBatchWriteItemInput
 * This operation MUST take as input a BatchWriteItemInput object.
 * This operation MUST return a BatchWriteItemInput object.
 * For each source field being written, the returned BatchWriteItemInput MUST also write the scan beacon field.
 * An error MUST be returned if a scan beacon field is used in the input BatchWriteItemInput.

### transformTransactWriteItemsInput
 * This operation MUST take as input a TransactWriteItemsInput object.
 * This operation MUST return a TransactWriteItemsInput object.
 * For each source field being written, the returned TransactWriteItemsInput MUST also write the scan beacon field.
 * An error MUST be returned if a scan beacon field is used in the input TransactWriteItemsInput.

#### Note : GetItem, BatchGetItem and TransactGetItems work only on Primary Keys, and therefore are not affected by scan beacons

#### Note : UpdateItem is not allowed in the encryption client, and so can be ignored for scan beacons

### transformQueryInput
 * This operation MUST take as input a QueryInput object.
 * This operation MUST return a QueryInput object and an optional second QueryInput object.
 * This operation MUST fail if a source field is compared with anything but equality, that is,
if the FilterExpressions uses a source field with anything but `EQ`.
 * This operation MUST fail if the input FilterExpression or KeyExpression directly mentions a scan beacon field.
 * If no source fields are mentioned, the QueryInput object MUST be returned unchanged.

 * For source fields in the Filter Expression that have no "previous" entry, this operation MUST replace source fields and values with scan beacon fields and HMACs
 * For source fields in the FilterExpression that do have a "previous" entry, this operation MUST replace `(field EQ value)` with `((prev_beacon_field EQ prev_beacon_value) OR (beacon_field EQ beacon_value))`

If there is no "previous" entry in the `keyConditionExpression`
 * This operation MUST return one QueryInput object

If there is a "previous" entry in the `keyConditionExpression`
 * This operation MUST return two QueryInput objects
 * This operation MUST return one QueryInput with the keyConditionExpression's field and value replaced with the current scan beacon settings
 * This operation MUST return one QueryInput with the keyConditionExpression's field and value replaced with the previous scan beacon settings

#### Note : transformQueryOutput needs a QueryInput object, becase we need to check the result records against the values searched in the QueryInput object, which are not directly available in the QueryOutput object.

### transformQueryOutput
 * This operation MUST take as input a QueryOutput object and a QueryInput object and and optional second QueryOutput object.
 * This operation MUST return an QueryOutput object.
 * If the optional second QueryOutput object is provided, the two QueryOutput objects must be merged into the returned object,
removing any duplicate results.
 * This operation MUST remove any records for which the original QueryInput does not match, that is,
if the original FilterExpression included `Src EQ "foo"` (where `Src` is a source field)
then we might get results where the `Src` field contains something other than "foo" (because false positives are expected).

### transformScanInput
 * This operation MUST take as input a ScanInput object.
 * This operation MUST return a ScanInput object.
 * This operation MUST fail if a source field is compared with anything but equality
 * If no source fields are mentioned in the FilterExpression, the ScanInput object MUST be returned unchanged.

 * For beacons in the FilterExpression that have no "previous" entry,
this operation MUST replace source fields and values with scan beacon fields and HMACs
 * For beacons in the FilterExpression that do have a "previous" entry,
this operation MUST replace `field EQ value` with `(prev_beacon_field EQ prev_beacon_value) OR (beacon_field EQ beacon_value)`

#### Note : transformScanOutput needs a ScanInput object, becase we need to check the result records against the values searched in the ScanInput object, which are not directly available in the QueryOutput object.

### transformScanOutput
 * This operation MUST take as input a ScanOutput object and a ScanInput object.
 * This operation MUST return an ScanOutput object.
 * This operation MUST remove any records for which the original QueryInput does not match, that is,
if the original FilterExpression included `Src EQ "foo"` (where `Src` is a source field)
then we might get results where the `Src` field contains something other than "foo" (because false positives are expected).
Those results must be removed. 

## PartiQL

PartiQL based methods need not be supported, e.g

* executeStatement
* batchExecuteStatement
* executeTransaction

## Operational Considerations
Fully supporting FilterExpressions, will require a complete parsing of the FilterExpression,
which is sensitive to any updates that the DynamoDB team makes to the expression language.
