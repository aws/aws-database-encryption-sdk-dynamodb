[//]: # "Copyright Amazon.com Inc. or its affiliates. All Rights Reserved."
[//]: # "SPDX-License-Identifier: CC-BY-SA-4.0"

# Beacons

## Version

1.0.0

### Changelog

## Overview

Beacons use stable hashes of the plaintext values of encrypted fields to allow searches on client-side encrypted records and using truncation to provide some basic privacy protections.

### Beacon Length

The `Beacon Length` is the number of bits of the hash value that is kept.

If any given beacon value maps back to a unique plaintext value,
attackers can be given some insight into your plaintext.

An extreme example of this would be a boolean field representing
"this person is over 7 feet tall". The resulting beacon would have value
`X` 99.9% of the time and value `Y` 0.1% of the time, making it trivial
to determine which value maps to which plaintext. With something this
extreme, there's no way to make a safe beacon.

To avoid this, we truncate the hash to ensure some collisions.

For a field with `X` distinct values, you should choose a beacon length `N`
such that `2^N < X/2` to guarantee collisions.

On the other side of the spectrum, if the beacon length is too short,
then there are too many collisions and query performance begins to 
approach a simple scan of all the data. A reasonable lower bound is
ensure that `2^N` is greater than the square root of `X`.

For example, a well distributed 5-digit zip code has 100,000 distinct values.
To properly anonymize this, one would use a beacon length between 9 and 16 bits.

Within that range, the length is chosen based on the threat model.
If you really don't need privacy protection, then choose 24 bits to avoid any performance loss.
With 16 bits, on average, each beacon will map to 1.5 zip codes.
Performance : you will retrieve 15 records for every 10 you actually use.
Privacy : Two records with the same beacon are 66% likely to have the same zip code.
For every bit below 15, you double the performance cost and double the privacy, e.g.
with 14 bits you would need to retrieve 30 records from the server to get the 10 that you need,
and two records with the same beacon are 33% likely to have the same zip code.

A beacon length MUST be an integer between 1 and 63 inclusive,
indicating the number of bits in the resulting beacon. 
The beacon string will be 1/4 this length.

### Standard Beacon

The simplest form of beacon is a standard beacon.
To produce a standard beacon from a sequence of bytes :
1. Compute the HMAC
1. Truncate the HMAC, to the [beacon length](#beacon-length)
1. Turn the result into a hex string, with leading zeros removed.

For example, the beacon for `banana` might be `4f`.

Standard Beacons can only be compared for equality.
It makes no sense to say that one standard beacon is less than another,
or one is a substring of another.

Standard beacons are strings, because compound beacons need to be strings,
and customers need to be able to switch from standard to compound beacons.

### Compound Beacon

Compound beacons are computed from strings,
and consist of [standard beacons](#standard-beacon)
interleaved with plaintext.

The following are the different kinds of compound beacons,
with examples of why customers need this functionality.

### Prefix Beacon

One way to define a compound beacon is with a prefix character.
The text before the first occurrence of the prefix character is unchanged,
and a standard beacon is computed for the rest.

For example, with a prefix character of `:`, the beacon for `2022-11-07:banana` might be `2022-11-07:4f`

Prefix Beacons allow comparisons such as `less than`, `begins with` and `between`
on the nonsensitive prefix.

When using a prefix beacon, the prefix character must always appear in the string.
When writing data, the prefix string must not be empty.

### List Beacon

Another way to define a compound beacon is as a list, by defining a split character.

A string is split on this character, into a list of items,
and a separate standard beacon is generated for each item.

A list beacon is used when all the items in the list have the same semantics.

For example, with a split character of `.`, the beacon for `apple.banana.pear` might be `.a9.4f.42.`

The delimiter is included at the start and end so that you can search for `.4f.` as a substring, no matter its position in the list.

For example, a customer query of `contains("banana")` would be translated into `contains(".4f.")`.

Unlike unencrypted searches, one can only query on whole items,
so `contains("anana")` and `begins_with("app")` would not return any results.

Like unencrypted searches, one can search on multiple items, so
 - `contains("banana.pear")` would return the above item
 - `contains("banana.apple")` would NOT return the above item
 - `contains("banana") AND contains("apple")` would return the above item
 - `begins_with("apple.banana")` would return the above item

Comparison operations like `less than` or `between` make no sense for list beacons.

All the items in the list share the same [beacon length](#beacon-length).

#### List Beacon With Prefix

A list beacon can define a prefix character, and so also be a [prefix beacon](#prefix-beacon).
In this case, the prefix character must always be supplied in the query string, e.g.

`contains(":banana")` would be translated into `contains(".4f.")`, matching "banana" in
the sensitive part.

`contains("banana:")` would be translated into `contains("banana")`, matching "banana" in
the non-sensitive prefix.


#### Map Beacons

A map beacon is similarly a list of parts separated by a split character; however,
each item in the list is semantically distinct.

To configure a map beacon, one configures a list of prefixes, each with its own [beacon length](#beacon-length). Each prefix is also given a name, but this name does not affect the operation.
Each item in the list must begin with one of these prefixes.
The prefixes are treated as non-sensitive data.

For example, one might configure

| Name | Prefix | Length |
|---|---|---|
| social | S- | 23 |
| phone | P- | 25 |
| zipcode | Z- | 15 |

and then write a value of `S-123456789.P-4125551212.Z-98765` which might be stored as
`S-ad651d76.F-123456789.R-beef`.

Then a query of `contains("Z-98765")` would be translated into `contains(".Z-beef.")`.

#### Map Beacons With Prefix

Map beacons do NOT support a prefix character; however,
one can specify a [beacon length](#beacon-length) of zero, 
which indicates that the part is not sensitive data and should be stored as plaintext. 
Thus one could add to the configuration

| prefix | X- | 0 |

and then write a value of `X-20221225.S-123456789.P-4125551212.Z-98765` which might be stored as
`X-20221225.S-ad651d76.F-123456789.R-beef`.

With this addition, a query of `starts_with("X-2022")` would successfully find the record.

## Definitions

### Conventions used in this document

The key words "MUST", "MUST NOT", "REQUIRED", "SHALL", "SHALL NOT", "SHOULD", "SHOULD NOT", "RECOMMENDED", "MAY", and "OPTIONAL"
in this document are to be interpreted as described in [RFC 2119](https://tools.ietf.org/html/rfc2119).


## Beacon Configuration

### Beacon Record 

The following inputs to this configuration are REQUIRED:
 * A name -- a sequence of characters
 * A plaintext HMAC key -- a sequence of bytes
 * A `length` -- a [beacon length](#beacon-length)

The following inputs to this configuration MUST be OPTIONAL:

 * A `prefix` character, defining a [prefix beacon](#prefix-beacon)
 * A [Split Record](#split-record) defining a [split beacon](#split-beacon)
 * An `ignore` character, defining the [ignore character](#ignore-character)

### Split Record

The following inputs to this configuration are REQUIRED:

 * A `split` character, to designate a [split beacon](#split-beacon)
 * [split lengths](#split-lengths), a sequence of [beacon length](#beacon-length),
for use with a [split beacon](#split-beacon)

The following inputs to this configuration MUST be OPTIONAL:

  * An `inner` character to designate an [inner prefix](#inner-prefix)

---

Construction MUST fail if a [Split Record](#split-record) is specified,
and it specifies a non-empty [split lengths](#split-lengths),
and the first element of [split lengths](#split-lengths) is not equal to
the `length` in the beacon record.

Construction MUST fail if any two of the `prefix`, `ignore`, `split` and `inner`
characters are configured and equal to each other.

## Beacon Operations

The three Operations available on a Beacon Record are defined in terms of functionality
in the following section, [Beacon Helpers](#beacon-helpers).

### standardHash
 * standardHash MUST fail if called on a beacon for which [isCompound](#iscompound) returns true.
 * standardHash MUST take a sequence of bytes and an unsigned integer `position` as input.
 * standardHash MUST produce a non-empty string as output.
 * standardHash MUST calculate a hash length by calling [hashLength](#hashlength) with the supplied `position`.
 * standardHash MUST calculate the [HmacSha384](https://www.ietf.org/rfc/rfc2104.txt)
of the input bytes and the configured key, and keep the first 8 bytes.
 * standardHash MUST return the rightmost `hash length` bits of these 8 bytes as a hexadecimal string.
 * the length of the returned string MUST be (`hash length`/4) rounded up.

### isCompound

isCompound MUST return `true` if a [prefix character](#prefix-beacon) or
[Split Record](#split-record) is configured; and false otherwise.

### compoundHash

 * compoundHash MUST take a string as input, and produce a string.
 * The returned string MUST NOT be empty.
 * If the [Beacon Record](#beacon-record) does not contain a [prefix character](#prefix-beacon),
compoundHash MUST return the [splitHash](#splitHash) of the input string.
 * compoundHash MUST fail if the input string does not contain the prefix character.
 * compoundHash MUST split the input string into two pieces,
based on the first occurrence of the prefix character in the input string.
 * If neither part is the ignore character, including when no ignore character is configured,
compoundHash MUST return the concatenation of the first piece, the prefix character,
and the [splitHash](#splitHash) of the second piece.
 * If both pieces are the [ignore character](#ignore-character),
or one piece is the [ignore character](#ignore-character) and the other piece
is the empty string, compoundHash MUST fail.
 * If the first piece is the [ignore character](#ignore-character),
compoundHash MUST return the [splitHash](#splitHash) of the second piece.
 * If the second piece is the [ignore character](#ignore-character),
compoundHash MUST return the concatenation of the first piece and the prefix character.

## Beacon Helpers

### stdHash

stdHash is exactly standardHash, except that is can be called on a compound beacon.
It is expected that standardHash will be implemented in terms of stdHash.
stdHash MUST provide standardHash with the guarantees it requires.

### splitHash

 * splitHash MUST take a string as input and produce a string.
 * The returned string MUST NOT be empty.
 * If the [Beacon Record](#beacon-record) does not specify a [Split Record](#split-record) 
splitHash MUST return the [stdHash](#stdhash) of the input string and zero.
 * splitHash MUST split the input string into pieces based on the [split](#split-beacon) character.
 * splitHash MUST fail if `split-lengths` is not empty and 
the number of pieces in the input string
is not equal to the number of lengths in `split-lengths`.
 * splitHash MUST calculate the concatenation of,
for each part that is not the [ignore](#ignore-character) character,
the split character followed by the [innerHash](#innerhash) of the part and its position.
 * splitHash MUST return the above calculation, followed by the split character.

If the input string does not contain the split character,
splitting the string results in a single piece.
This is not, in and of itself, an error.

### innerHash
 * innerHash MUST take a string and an unsigned integer, `position`, as input and produce a string.
 * The returned string MUST NOT be empty.
 * If the configuration does not specify an [inner](#inner-prefix) character,
innerHash MUST return the [stdHash](#stdhash) of the input string and the supplied position.
 * innerHash MUST fail if the input string does not contain the [inner](#inner-prefix) character.
 * innerHash MUST split the input string into two pieces, on the
first occurrence on the [inner](#inner-prefix) character, returning the concatenation of
 * * the first part of the input string
 * * the inner character
 * * the [stdHash](#standardhash) of the second part of the string and the supplied position.

### hashLength
 * hashLength MUST take an unsigned integer `position` as input and return a [beacon length](#beacon-length).
 This position corresponds to the position of a part of a [split hash](#splithash).
 * If the input is position is zero, hashLength MUST return the beacons's `length`.
 * If `split-lengths` is empty or absent, hashLength MUST return the beacons's `length`.
 * If the input position is less than the number of values in `split-lengths`,
hashLength MUST return the (zero-based) Nth number in the list.
 * If the input position is greater than or equal to the number of values in `split-lengths`,
hashLength MUST fail.
