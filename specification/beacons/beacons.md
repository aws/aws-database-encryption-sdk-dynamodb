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
 * **beacon length** : an integer between 1 and 64 inclusive


### Conventions used in this document

The key words "MUST", "MUST NOT", "REQUIRED", "SHALL", "SHALL NOT", "SHOULD", "SHOULD NOT", "RECOMMENDED", "MAY", and "OPTIONAL"
in this document are to be interpreted as described in [RFC 2119](https://tools.ietf.org/html/rfc2119).


## Beacon Configuration

A beacon definition MUST provide the following:
 * The source field name; e.g. the name of the DynamoDB attribute for which you want to generate a scan beacon
 * A plain text data key
 * A `length`, a `beacon length`, the number of bits for the scan beacon.
 * An OPTIONAL `prefix`, a single character
 * An OPTIONAL `split`, a single character
 * An OPTIONAL `split-lengths`, a sequence of `beacon length`
 * An OPTIONAL `inner`, a single character
 * An OPTIONAL `ignore`, a single character

.

 * Construction MUST fail if `inner` is specified, but not `split`
 * Construction MUST fail if a non-empty `split-lengths` is specified, but not `split`
 * Construction MUST fail the first element of `split-lengths` is not equal to the 
`length` of the beacon.

It is assumed that there is some sort of configuration file somewhere.
The plain text data key will not be in this file, but be calculated and/or retrieved from somewhere else.

If the `split-lengths` is specified as `2,4,6`, it means that the first part has a hash length of 2,
the second part a hash length of 4, any additional parts have a hash length of 6.

The name of a beacon attribute is typically the concatenation of a fixed prefix (e.g `gZ_b_`) and the source field name.

If none of the optional characters are specified, then `plainHash` is
used on any attribute type to calculate the beacon;
otherwise compoundHash must be used, which can only be used with String attributes.


## Beacon Operations

### baseHash
 * baseHash MUST take a sequence of bytes as input.
 * baseHash MUST take a `beacon length` as input
 * baseHash MUST return a 64 bit integer
 * baseHash MUST must take the 
[HmacSha384](https://www.ietf.org/rfc/rfc2104.txt)
of the input and the configured key, interpret the first 8 bytes
as a big endian unsigned 64-bit integer, and 
and return the least significant `beacon length` bits.


### hashLength
 * hashLength MUST take an unsigned integer position as input
 * hashLength MUST return a `beacon length`.
 * If the input is zero, hashLength MUST return the beacons's hash length.
 * If no `split-lengths` is empty, hashLength MUST return the beacons's hash length.
 * If the input number is less than the number of values in `split`,
hashLength MUST return the (zero-based) Nth number in the list;
otherwise, hashLength MUST return the last number in `split`

### plainHash
 * plainHash MUST take a sequence of bytes as input.
 * plainHash MUST take an unsigned integer `position` as input.
 * plainHash MUST produce a non-empty string as output.
 * plainHash MUST calculate a hash length by calling `hashLength` with the supplied `position`.
 * plainHash MUST must calculate the `baseHash` of the input bytes and this length.
 * plainHash MUST return this value formatted as lowercase hexadecimal,
with leading zeros removed, except that 0 is returned as "0".

### innerHash
 * innerHash MUST take a string and an unsigned integer, `position`, as input.
 * innerHash MUST produce a non-empty string as output.
 * If the configuration does not specify an `inner`,
innerHash MUST return the `plainHash` of the input string and the supplied position
 * innerHash MUST fail if the input string does not contain the `inner` character.
 * innerHash MUST split the input string into two pieces, on the
first occurrence on the inner character.
 * innerHash MUST return the concatenation of
 * * the first part of the input string
 * * the inner character
 * * the `plainHash` of the second part of the string and the supplied position.

### splitHash

 * splitHash MUST take a string as input.
 * splitHash MUST produce a non-empty string as output.
 * If the configuration does not specify a `split`,
splitHash MUST return the `plainHash` of the input string and zero
 * splitHash MUST split the input string into pieces based on the split character.
 * splitHash must return the concatenation of,
 * * the split character
 * * for each part that is not the `ignore` character,
 the `innerHash` of the part and its position, followed by the split character,
 * If the input string does not contain the split character,
splitting the string results in a single piece. This is not an error.

### compoundHash

 * compoundHash MUST take a string as input.
 * compoundHash MUST produce a non-empty string as output.
 * If the configuration does not contain a prefix character,
compoundHash MUST return the `splitHash` of the input string
 * compoundHash MUST fail if the input string does not contain the prefix character.
 * compoundHash MUST split the input string into two pieces,
based on the first occurrence of the prefix character in the input string.
 * If the first part of the split is `ignore` character,
compoundHash MUST return the `splitHash` of the rest of the string
 * compoundHash MUST return the concatenation of the first part of the split, the prefix character, and the `splitHash` of the rest of the split.
