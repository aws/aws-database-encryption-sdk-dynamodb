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

## Configuration

A Scan Beacon definition MUST provide the following:
 * The plaintext field name
 * The scan beacon field name
 * The XXX of the secret key to be used for hashing
 * The hash length (number of bits) of the scan beacon
 
A Scan Beacon definition MAY provide the following:
 * The previous scan beacon field name
 * The presious XXX of the secret key to be used for hashing
 * The previous hash length (number of bits) of the scan beacon
 
## Interface

### Hash

This interface MUST take the plain text as input

This interface MUST must take the HmacSha256(PlainText, Key) and return the most significant length bits of that as an unsigned integer.

## Indexing

When a request is made to create a Index for a source field,
instead the index must be created on the scan beacon field.

## Writing

Whenever a record is written, if the source field is written then the scan beacon field must also be written,
holding the Scan Beacon Hash of the unencrypted source field.

It is a error to write a field with the same name as a scan becon field.

## Reading

To retrieve a record based on the value of an encrypted source field,
search instead for the scan beacon hash in the scan beacon field.

Note that only exact matches can be supported. No ranged queries or inequalities.
It is an error to attepmt such a query.

This may return false positive results.
After retrieving records in this way, you must decrypt the record and compare
the source field value to the query value, and discard any records where they don't match.

# DynamoDB Support

To support the DynamoDB SDK, we need to be able to take Request objects
which refer to unencrypted values in source fields and transform them
to refer to the associated hashes in scan beacon fields.

## Indexing

When creating a Global Secondary Index on a source field, use the scan beacon field instead.

 * CreateTableRequest 
 * UpdateTableRequest

## Writing

Write scan beacon fields for associated source fields

 * PutItemRequest
 * UpdateItemRequest
 * BatchWriteItemRequest
 * TransactWriteItemsRequest

## Reading

Search scan beacon fields instead of source fields. Filter results as necessary.

 * GetItemRequest / GetItemResponse
 * BatchGetItemRequest / BatchGetItemResponse
 * TransactGetItemsRequest / TransactGetItemsResponse
 * QueryRequest / QueryResponse
 * ScanRequest / ScanResponse

## PartiQL

PartiQL based methods need not be supported.

* executeStatement
* batchExecuteStatement
* executeTransaction
