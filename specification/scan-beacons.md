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

