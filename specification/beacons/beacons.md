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
 * **modified beacon** : a beacon configured with a `previous` section.
 * **unmodified beacon** : a beacon configured without a `previous` section.
 * **plain beacon** : a beacon configured without any optional `split` or `prefix`
 * **compound beacon** : a beacon configured with the optional `split` or `prefix`
 * **prefix beacon** : a beacon configured with the optional `prefix`
 * **split beacon** : a beacon configured with the optional `split`


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
 * A plain text data key
 * The hash length (number of bits) of the scan beacon.
A number between 1 and 64.
 * An OPTIONAL `version`, an unsigned integer
 * An OPTIONAL `prefix`, a single utf8 character
 * An OPTIONAL `split`, a single utf8 character, or decimal numbers separated by a single utf8 character
 * An OPTIONAL `inner`, a single utf8 character

It is an error to specify an `inner`, but not a `split`.
An implementation MUST fail when constructing a beacon in this case.

It is assumed that there is some sort of configuration file somewhere.
The plain text data key will not be in this file, but be calculated and/or retrieved from somewhere else.

If the `split` is specified as `2:4:6`, that is the same as
a `split` of `:`, except that the first part has a hash length of 2,
the second part a hash length of 4, any additional parts have a hash length
of 6. An implementation MUST fail if the first number in the list is not
equal to the hash length specified for the beacon.

The name of a beacon attribute is typically the concatenation of a fixed prefix (e.g `aws-ddbec-sb-`) and the source field name.


## Beacon Operations

### hashLength
 * this operation MUST take an unsigned integer as input
 * this operation MUST return an unsigned integer in the range 1 to 64 inclusive.
 * If the input is zero, this operation MUST return the beacons's hash length.
 * If no `split` is specified, or the `split` is a single character, this operation MUST return the beacons's hash length.
 * If the input number is less than the number of parts in the split, this
operation MUST return the (zero-based) Nth number in the list;
otherwise, this operation MUST return the last number in the `split`

### plainHash

 * This operation MUST take a sequence of bytes as input.
 * This operation MUST take an unsigned integer `position` as input.
 * This operation MUST produce a valid UTF8 string as output.
 * This operation MUST calculate a hash length by calling `hashLength`
with the supplied `position`.
 * This operation MUST must take the 
[HmacSha384](https://www.ietf.org/rfc/rfc2104.txt)
of the input and the configured key, interpret the first 8 bytes
as a little endian unsigned 64-bit integer, and 
and return the least significant `hash length` bits,
interpreted as an unsigned integer,
and formatted as a decimal integer.

### innerHash

 * this operation MUST take a valid UTF8 string
and an unsigned integer, `position`, as input.
 * this operation MUST produce a valid UTF8 string as output.
 * If the configuration does not specify an `inner`,
this operation MUST return the `plainHash` of the input string
and the supplied position; otherwise,
 * This operation MUST return an error if the input string does not
contain the `inner` character.
 * This operation MUST split the input string into two pieces, on the
first occurrence on the inner character.
 * This operation MUST return the concatenation of
 * * the first part of the input string
 * * the inner character
 * * the `plainHash` of the second part of the string and the supplied position.

### splitHash

 * this operation MUST take a valid UTF8 string as input.
 * this operation MUST produce a valid UTF8 string as output.
 * If the configuration specifies an `inner`, but not a `split`,
this operation MUST fail.
 * If the configuration does not specify a `split`,
this operation MUST return the `plainHash` of the input string and zero; otherwise,
 * This operation MUST split the input string into pieces based on the split character.
 * This operation must return the concatenation of,
 * * the split character
 * * for each part that is not a single underscore character, the `innerHash` of the part and its position, followed by the split character,
 * If the input string does not contain the split character,
splitting the string results in a single piece. This is not an error.

### compoundHash

 * this operation MUST take a valid UTF8 string as input.
 * this operation MUST produce a valid UTF8 string as output.
 * If the configuration does not contain a prefix character,
this operation MUST return the `splitHash` of the input string; otherwise
 * If the input string does not contain the prefix character,
this operation MUST return an error; otherwise
 * This operation MUST split the input string into two pieces,
based on the first occurrence of the prefix character in the input string.
 * If the first part of the string a single underscore character,
this operation MUST return the `splitHash` of the rest of the string; otherwise,
 * This operation MUST return the concatenation of the first part of the split, the prefix character, and the `splitHash` of the rest of the string.





