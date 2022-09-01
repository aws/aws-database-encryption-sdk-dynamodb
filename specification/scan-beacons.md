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

## Scan Beacon Configuration

A Scan Beacon definition MUST provide the following:
 * The source field name
 * The scan beacon field name
 * The XXX of the secret key to be used for hashing
 * The hash length (number of bits) of the scan beacon
 
A Scan Beacon definition MAY provide the following:
 * The previous scan beacon field name
 * The previous XXX of the secret key to be used for hashing
 * The previous hash length (number of bits) of the scan beacon
 
## Scan Beacon Operation

### hash

This operation MUST take the plain text as input.

This operation MUST must take the HmacSha256 or the plain text and the wrapping key and return the most significant length bits of that as an unsigned integer.

## Scan Beacon Set Configuration

A Scan Beacon Set MUST contain a collection of Scan Beacons.

### Overview

All Scan Beacon Set operations are a convenience for using the AWS DynamoDB SDK. The user calls the
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

## Scan Beacon Set Operations

### transformCreateTableRequest

 * This operation MUST take as input a CreateTableRequest object.
 * This operation MUST return a CreateTableRequest object.
 * If no Global Secondary Index is being created, the CreateTableRequest object MUST be returned unaltered.
 * If no Global Secondary Index is being created for a source field, the CreateTableRequest object MUST be returned unaltered.
 * If a Global Secondary Index is being created for a source field,
the returned CreateTableRequest object MUST instead create the Global Secondary Index for the scan beacon field.

### transformUpdateTableRequest

 * This operation MUST take as input an UpdateTableRequest object.
 * This operation MUST return an UpdateTableRequest object.
 * If no Global Secondary Index is being created, the UpdateTableRequest object MUST be returned unaltered.
 * If no Global Secondary Index is being created for a source field, the UpdateTableRequest object MUST be returned unaltered.
 * If a Global Secondary Index is being created for a source field,
the returned UpdateTableRequest object MUST instead create the Global Secondary Index for the scan beacon field.

### transformPutItemRequest
### transformUpdateItemRequest
### transformBatchWriteItemRequest
### transformTransactWriteItemsRequest

### transformGetItemRequest
### transformGetItemResponse
### transformBatchGetItemRequest
### transformBatchGetItemResponse
### transformTransactGetItemsRequest
### transformTransactGetItemsResponse
### transformQueryRequest
### transformQueryResponse
### transformScanRequest
### transformScanResponse

## PartiQL

PartiQL based methods need not be supported, e.g

* executeStatement
* batchExecuteStatement
* executeTransaction
