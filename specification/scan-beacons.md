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

A Scan Beacon is defined by
 * The name of the source field
 * The name of the scan beacon field to be created
 * The XXX of the secret key to be used for hashing
 * The length (number of bits) of the scan beacon
 
## Hashing

A Scan Beacon Hash is an unsigned integer, defined as the first 'length' bits of HmacSha256(PlainText, Key),
where the most significant bit of each byte is first.

## Writing

Whenever a record is written, if the source field is written then the scan beacon field must also be written,
holding the Scan Beacon Hash of the unencrypted source field.

## Reading

To retrieve a record based on the value of an encrypted source field,
search instead for the scan beacon hash in the scan beacon field.

Note that only exact matches can be supported. No ranged queries or inequalities.

This may return false positive results.
After retrieving records in this way, you must decrypt the record and compare
the source field value to the query value, and discard any records where they don't match.

### DynamoDB Support
To make life easier, formulate requests that search the original attribute, and transform them into requests that search the new hash. 

 * CreateTableRequest 
 * UpdateTableRequest
 * PutItemRequest
 * BatchWriteItemRequest
 * TransactWriteItemsRequest
 * GetItemRequest
 * BatchGetItemRequest
 * TransactGetItemsRequest
 * QueryRequest
 * ScanRequest


Filter Results From
 * GetItemResponse
 * BatchGetItemResponse
 * TransactGetItemsResponse
 * QueryResponse
 * ScanResponse
