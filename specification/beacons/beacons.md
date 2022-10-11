[//]: # "Copyright Amazon.com Inc. or its affiliates. All Rights Reserved."
[//]: # "SPDX-License-Identifier: CC-BY-SA-4.0"

# Beacons

## Version

1.0.0

### Changelog

## Overview

Beacons use stable hashes of the plaintext values of encrypted fields to allow searches on client-side encrypted records.

## Definitions

 * **beacon** : A string value. Either a plain beacon constructed from a byte sequence, or a compound beacon constructed from a string.
 * **beaconed field** : an encrypted field with an associated beacon
 * **non-beaconed field** : an encrypted field without an associated beacon
 * **modified beacon** : a beacon configured with a "previously" section.
 * **unmodified beacon** : a beacon configured without a "previously" section.
 * **plain beacon** : a beacon configured with none of the optional characters
 * **compound beacon** : a beacon configured with any of the optional characters
 * **prefix beacon** : a beacon configured with the optional prefix character
 * **split beacon** : a beacon configured with the optional split character


### Conventions used in this document

The key words "MUST", "MUST NOT", "REQUIRED", "SHALL", "SHALL NOT", "SHOULD", "SHOULD NOT", "RECOMMENDED", "MAY", and "OPTIONAL"
in this document are to be interpreted as described in [RFC 2119](https://tools.ietf.org/html/rfc2119).

## Key Indicator

This is the configuration text supplied by the user to designate the appropriate key for creating the HMAC hash.

A key indicator MUST consist of the [ARN](https://github.com/awslabs/aws-encryption-sdk-specification/blob/master/framework/aws-kms/aws-kms-key-arn.md#a-valid-aws-kms-arn) of a KMS HMAC key. The KMS `GenerateMac` method will be called for every HMAC calculation.

In the future, it is anticipated that other types of key indicators will
be supported; for example, the encrypted form of a data key,
as returned by the KMS `GenerateDataKey` operation, along with
the associated [Key ID](https://github.com/awslabs/aws-encryption-sdk-specification/blob/master/framework/aws-kms/aws-kms-key-arn.md#a-valid-aws-kms-identifier).
The library will call AWS KMS to decrypt the key.
Then the library will cache the plaintext key and calculate the HMAC locally.
More complex configuration than the HMAC Key, but faster execution if cached
over multiple records.

## Scan Beacon Configuration

A beacon definition MUST provide the following:
 * The source field name; e.g. the name of the DynamoDB attribute for which you want to generate a scan beacon
 * The key indicator
 * The hash length (number of bits) of the scan beacon.
A number between 1 and 64.
 * An OPTIONAL version number
 * An OPTIONAL prefix character
 * An OPTIONAL split character
 * An OPTIONAL inner character
 * An OPTIONAL "previous" entry, consisting of all of the above,
except for source field name, indicating the previous state of this beacon.

It is an error to specify an inner character, but not a split character.
An implementation MUST return an error when constructing a beacon in this case.

The name of a beacon attribute is typically the concatenation of a fixed prefix (e.g `aws-ddbec-sb-`) and the source field name.

#### Note : An individual scan beacon can have no more than one "previous" entry.

This optional previous values allows the library to support changes in the configuration over time.
If the configuration for a scan beacon changes,
the library can search for both the beacon as calculated with the current configuration
and also the beacon as calculated with the previous configuration,
and return the union of the two.

### Version Number
 * The version number in a beacon configuration is an unsigned integer.
 * It is compared with the version numbers of other beacons, and
designate the ordering of beacon modifications.
 * If two beacons have the same version number, then they were modified
at the same time. That is, some records may have been written with the 
current version of both beacons, and some records may have been written
with the previous version of both beacons, but no records were ever
written with the current version of one and the previous version of the other.
 * If two beacons have different version numbers, then the one with the
lower number was modified first, and the one with the higher number was modified
second. Thus no records were ever written with the previous version of the 
first beacon and the current version of the second beacon.
 * If either or both of two beacons lack a version number, then records
may have been written with any combination of the current and previous
versions of the two beacons.
 * If a query is made involving multiple modified beacons, some optimizations
can be made if version numbers are provided; otherwise, these version
numbers can be safely ignored.


## Beacon Operations

### plainHash

 * A beacon configuration with none of the optional characters MUST use this operation.
 * This operation MUST take a sequence of bytes as input.
 * This operation MUST produce a valid UTF8 string as output.
 * This operation MUST must take the 
[HmacSha384](https://www.ietf.org/rfc/rfc2104.txt)
of the input and the configured key
and return the most significant `hash length` bits,
interpreted as an unsigned integer,
and formatted as a decimal integer.

### innerHash

 * this operation MUST take a valid UTF8 string as input.
 * this operation MUST produce a valid UTF8 string as output.
 * If the configuration does not specify an inner character,
this operation MUST return the `plainHash` of the input string; otherwise,
 * This operation MUST return an error if the input string does not
contain the inner character.
 * This operation MUST split the input string into two pieces, on the
first occurrence on the inner character.
 * This operation MUST return the concatenation of
 * * the first part of the input string
 * * the inner character
 * * the `plainHash` of the second part of the string.

### splitHash

 * this operation MUST take a valid UTF8 string as input.
 * this operation MUST produce a valid UTF8 string as output.
 * If the configuration specifies an inner character, but not a split character,
this operation MUST return an error.
 * If the configuration does not specify a split character,
this operation MUST return the `plainHash` of the input string; otherwise,
 * This operation MUST split the input string into pieces based on the split character.
 * This operation must return the concatenation of the
 * * the split character
 * * the `innerHash` of each part, in order, separated by the split character,
 * * the split character
 * If the input string does not contain the split character,
splitting the string results in a single piece, and no error is produced.

### compoundHash

 * A beacon configuration that includes one or more of the optional characters MUST use this operation.
 * this operation MUST take a valid UTF8 string as input.
 * this operation MUST produce a valid UTF8 string as output.
 * If the configuration does not contain a prefix character,
this operation MUST return the `tailHash` of the input string; otherwise
 * If the configuration does contain the prefix character,
this operation MUST return an error; otherwise
 * This operation MUST split the input string into two pieces,
based on the first occurrence of the prefix character in the input string.
 * This operation MUST return the concatenation of the first part of the split, the prefix character, and the `splitHash` of the rest of the string.
