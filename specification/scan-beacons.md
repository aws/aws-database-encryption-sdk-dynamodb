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
 * An Encrypted Data Key and a KeyID
 * A KMS Key ARN

## Scan Beacon Configuration

A Scan Beacon definition MUST provide the following:
 * The source field name
 * The scan beacon field name
 * The Key Indicator
 * The hash length (number of bits) of the scan beacon
 
A Scan Beacon definition MAY provide the following:
 * The previous Key Indicator, or the literal "NULL" indicating no previous beacon
 * The previous hash length (number of bits) of the scan beacon
 
## Scan Beacon Operation

### hash

This operation MUST take the plain text as input.

This operation MUST must take the HmacSha256 or the plain text and the wrapping key and return the most significant length bits of that as an unsigned integer.

## Scan Beacon Set Configuration

A Scan Beacon Set MUST contain
 * A collection of Scan Beacons.
 * The name of the table for which these scan beacons are applicable.

## Scan Beacon Group Configuration

A Scan Beacon Group is a collection of Scan Beacon Sets.

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

It is a error to attempt to write a source field with the same name as a scan becon field.

#### Reading

To retrieve a record based on the value of an encrypted source field,
search instead for the Hash of the value in the scan beacon field.

Note that only exact matches can be supported. No ranged queries or inequalities.
It is an error to attepmt such a query.

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
 * This operation MUST return a QueryRequest object.

 * Replace source/value with beacon/hash
 * fail if not using equality
 * maybe make two requests
 * if multiple beacons are used that have 'previous' entries, do we deal with the exponential explosion or can we call it an error?

### transformQueryResponse
 * This operation MUST take as input a QueryResponse object and a QueryRequest object.
 * This operation MUST return an QueryResponse object.

* filter out records that didn't really match. This could involve arbitrarily complex FilterExpressions
* maybe take two QueryResponses, or an array thereof, to deal with multiple queries
* how much of the complexity of adding two responses together do we need to deal with?

### transformScanRequest
 * This operation MUST take as input a ScanRequest object.
 * This operation MUST return a ScanRequest object.

### transformScanResponse
 * This operation MUST take as input a ScanResponse object and a ScanRequest object.
 * This operation MUST return an ScanResponse object.

## PartiQL

PartiQL based methods need not be supported, e.g

* executeStatement
* batchExecuteStatement
* executeTransaction
