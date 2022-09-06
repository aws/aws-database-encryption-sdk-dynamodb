[//]: # "Copyright Amazon.com Inc. or its affiliates. All Rights Reserved."
[//]: # "SPDX-License-Identifier: CC-BY-SA-4.0"

# Scan Beacons

## Version

0.1.0

### Changelog

## Overview

A Scan Beacon is a stable hash of the unencrypted value of an encrypted field.
This allows a database server to perform some types of searches on client-side encrypted records.

## Definitions

### Conventions used in this document

The key words "MUST", "MUST NOT", "REQUIRED", "SHALL", "SHALL NOT", "SHOULD", "SHOULD NOT", "RECOMMENDED", "MAY", and "OPTIONAL"
in this document are to be interpreted as described in [RFC 2119](https://tools.ietf.org/html/rfc2119).

## Key Indicator

This is the configuration text supplied by the user to allow the library to obtain the appropriate key for creating the HMAC hash.
[More details here](https://quip-amazon.com/3qsyAcXbTxm3/Quick-Note-About-Scan-Beacons)

A Key Indicator MUST consist of exactly one of the following
 * An Encrypted Data Key and the ARN of a KMS symetric encryption key
 * The ARN of a KMS HMAC key

## Scan Beacon Configuration

A Scan Beacon definition MUST provide the following:
 * The source field name
 * The scan beacon field name
 * The Key Indicator
 * The hash length (number of bits) of the scan beacon
 
A Scan Beacon definition MAY provide a "previous" entry consisting on one of :
 * an empty value, indicating that the field was not previously a beacon
 * The previous Key Indicator and the previous hash length (number of bits) of the scan beacon
 
## Scan Beacon Operation

### hash

This operation MUST take the plain text as input.

This operation MUST must take the HmacSha256 or the plain text and the wrapping key and return the most significant length bits of that as an unsigned integer.

## Scan Beacon Set Configuration

A Scan Beacon Set MUST contain
 * A collection of Scan Beacons.
 * The name of the table for which these scan beacons are applicable.

## Scan Beacon Group Configuration

A Scan Beacon Group is a collection of Scan Beacon Sets. This will likely be in the form of a ItemEncryptorConfig object.

### Overview

All Scan Beacon Group operations are a convenience for using the AWS DynamoDB SDK. The user calls the
SDK referring to the encrypted data fields, and these operations transform the Request and Response objects
to use the scan beacons instead.

#### Indexing

When a request is made to create a Index for a source field,
instead the index must be created on the scan beacon field.

#### Writing

Whenever a record is written, if the source field is written then the scan beacon field must also be written,
containing the Scan Beacon Hash of the plain text of the source field.

It is a error to attempt to write a source field with the same name as a scan beacon field.

#### Reading

To retrieve a record based on the value of an encrypted source field,
search instead for the Hash of the value in the scan beacon field.

Note that only exact matches can be supported. No ranged queries or inequalities.
It is an error to attempt such a query.

This might return false positive results.

After retrieving records in this way, you must decrypt the record and compare
the source field value to the query value, and discard any records where they don't match.

## Scan Beacon Group Operations

### transformCreateTableRequest

 * This operation MUST take as input a CreateTableRequest object.
 * This operation MUST return a CreateTableRequest object.
 * If no Global Secondary Index is being created, the CreateTableRequest object MUST be returned unaltered.
 * If the Global Secondary Index being created includes no source fields, the CreateTableRequest object MUST be returned unaltered.
 * If the Global Secondary Index being created includes a source field,
the returned CreateTableRequest object MUST replace the source field names with the corresponding scan beacon field names.

### transformUpdateTableRequest

 * This operation MUST take as input an UpdateTableRequest object.
 * This operation MUST return an UpdateTableRequest object.
 * If no Global Secondary Index is being created, the UpdateTableRequest object MUST be returned unaltered.
 * If the Global Secondary Index being created includes no source fields, the UpdateTableRequest object MUST be returned unaltered.
 * If the Global Secondary Index being created includes a source field,
the returned UpdateTableRequest object MUST replace the source field names with the corresponding scan beacon field names.

### transformPutItemRequest
 * This operation MUST take as input an PutItemRequest object.
 * This operation MUST return an PutItemRequest object.
 * For each source field being written, the returned PutItemRequest must also write the scan beacon field.
 * An error MUST be returned if a scan beacon field is used in the input PutItemRequest.

### transformUpdateItemRequest
 * This operation MUST take as input an UpdateItemRequest object.
 * This operation MUST return an UpdateItemRequest object.
 * For each source field being written, the returned UpdateItemRequest must also write the scan beacon field.
 * An error MUST be returned if a scan beacon field is used in the input UpdateItemRequest.

### transformBatchWriteItemRequest
 * This operation MUST take as input a BatchWriteItemRequest object.
 * This operation MUST return a BatchWriteItemRequest object.
 * For each source field being written, the returned BatchWriteItemRequest must also write the scan beacon field.
 * An error MUST be returned if a scan beacon field is used in the input BatchWriteItemRequest.

### transformTransactWriteItemsRequest
 * This operation MUST take as input a TransactWriteItemRequest object.
 * This operation MUST return a TransactWriteItemRequest object.
 * For each source field being written, the returned TransactWriteItemRequest must also write the scan beacon field.
 * An error MUST be returned if a scan beacon field is used in the input TransactWriteItemRequest.

#### Note : GetItem, BatchGetItem and TransactGetItems work only on Primary Keys, and therefore are not affected by scan beacons

### transformQueryRequest
 * This operation MUST take as input a QueryRequest object.
 * This operation MUST return a QueryRequest object and an optional second QueryRequest object.
 * This operation MUST fail if a source field is compared with anything but equality
 * If no source fields are mentioned, the QueryRequest object MUST be returned unchanged.

 * For beacons in the FilterExpression that have no "previous" entry, this operation MUST replace source fields and values with scan beacon fields and HMACs
 * For beacons in the FilterExpression that do have a "previous" entry, this operation MUST replace (field EQ value) with ((prev_beacon_field EQ prev_beacon_value) OR (beacon_field EQ beacon_value))
 * Doing this will likely require a complete parsing of the FilterExpression, which is sensitive to any upgrades that the DynamoDB tems makes to the expression language.

If there is no "previous" entry in the "key" section
 * This operation must return one QueryRequest object

If there is a "previous" entry in the "key" section
 * This operation MUST return two QueryRequest objects
 * This operation MUST return one QueryRequest with the key's field and value replaced with the current scan beacon settings
 * This operation MUST return one QueryRequest with the key's field and value replaced with the previous scan beacon settings


### transformQueryResponse
 * This operation MUST take as input a QueryResponse object and a QueryRequest object and and optional second QueryResponse object.
 * The QueryResponse objects MUST already be decrypted
 * This operation MUST return an QueryResponse object.
 * If the optional second QueryResponse object is provided, the two QueryResponse objects must be merged into the returned object.
 * This operation MUST remove any records for which the scan beacon matched, but the actual query string does not match.
 * Doing this will likely require a complete parsing of the FilterExpression, which is sensitive to any upgrades that the DynamoDB tems makes to the expression language.
 * Doing this will likely require the creation of an executable parse tree

### transformScanRequest
 * This operation MUST take as input a ScanRequest object.
 * This operation MUST return a ScanRequest object.
 * This operation MUST fail if a source field is compared with anything but equality
 * If no source fields are mentioned, the ScanRequest object MUST be returned unchanged.

 * For beacons in the FilterExpression that have no "previous" entry, this operation MUST replace source fields and values with scan beacon fields and HMACs
 * For beacons in the FilterExpression that do have a "previous" entry, this operation MUST replace (field EQ value) with ((prev_beacon_field EQ prev_beacon_value) OR (beacon_field EQ beacon_value))
 * Doing this will likely require a complete parsing of the FilterExpression, which is sensitive to any upgrades that the DynamoDB tems makes to the expression language.


### transformScanResponse
 * This operation MUST take as input a ScanResponse object and a ScanRequest object.
 * This operation MUST return an ScanResponse object.
 * This operation MUST remove any records for which the scan beacon matched, but the actual query string does not match.
 * Doing this will likely require a complete parsing of the FilterExpression, which is sensitive to any upgrades that the DynamoDB tems makes to the expression language.
 * Doing this will likely require the creation of an executable parse tree


## PartiQL

PartiQL based methods need not be supported, e.g

* executeStatement
* batchExecuteStatement
* executeTransaction
