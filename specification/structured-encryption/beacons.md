[//]: # "Copyright Amazon.com Inc. or its affiliates. All Rights Reserved."
[//]: # "SPDX-License-Identifier: CC-BY-SA-4.0"

# Beacons

## Version

1.0.0

### Changelog

## Overview

Beacons use stable hashes of the plaintext values of encrypted fields to allow searches on client-side encrypted records and using truncation to provide some basic privacy protections.

### Definitions

A `virtual field` is a string computed from parts of a record.

A `virtual database field` is a string computed from fields and virtual fields,
from which a [compound beacon](#compound-beacon) is constructed.

A `source field` is a field in a record used to construct a `virtual field` or
a `virtual database field`.

Neither virtual fields nor virtual database fields are ever stored anywhere,
encrypted or plaintext.

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

(See also [Definitions](#definitions))

A compound beacon is assembled from parts of a record,
combining literal plaintext strings and [standard beacons](#standard-beacon)
into a complex string, suitable for complex database operations.

To configure a single compound beacon, you need to provide

 1 A name
 1 A join string
 1 A list of sensitive parts
 1 An optional list of non-sensitive parts
 1 An optional list of constructors

Configuration starts with a name.
This name is used in queries and index creation, as if it were a regular field.
"MyField" in examples below. It is an error if this name is the same as a configured
[virtual field](virtual.md), or to attempt to write a field of this name.

Configuration continues with a `join string` which separates the parts of a compound beacon.
In the examples below, we assume "`.`".

Then there is a list of sensitive parts, each part having a field name,
a prefix and a [beacon length](#beacon-length).
The field name can refer directly to a field in the record,
or to a [virtual field](virtual.md). For example :

| Field Name | Prefix | Length |
|---|---|---|
| social | S- | 23 |
| phone | P- | 25 |
| zipcode | Z- | 15 |
| address | A- | 11 |

The first row should be interpreted as a literal `S-` followed by the 23-bit beacon
of the "social" field.

Next comes a list of non-sensitive parts. 
This is a similar list, but there is no `length` column, because
these fields appear as plain text in the beacon value. For example :

| Field Name | Prefix |
|---|---|
| timestamp | T- |

The first row should be interpreted as a literal `T-` followed by the plaintext
of the "timestamp" field.

It is an error for the configuration of a non-sensitive part to refer to
an encrypted field in any way.

Prefixes can be any valid string, but no prefix string can be a prefix of another prefix string.

That is, you can have both "A-" and AB-" as prefixes,
but you can't have both "AB" and "AB-".

#### Writing Compound Beacons

To write a compound beacon, one constructs the `virtual database field`,
and then turns the sensitive parts into [standard beacons](#standard-beacon).

For writing, one can configure a list of constructors. 

A single constructor is an ordered list of parts.
An example list of constructors might be :

 - timestamp social zipcode
 - address zipcode

A constructor `succeeds` if all of the fields from which it is created exist in the record.

Each constructor is tried, in the order configured, until one succeeds.

If no constructor succeeds, the record cannot be written.

If the list of constructors is omitted, a default constructor is used.
The default constructor creates a `virtual database field` which is
the concatenation of the non-sensitive parts, in the order configured,
followed by the sensitive parts, in the order configured,
skipping any parts for which any `source field` is unavailable.

The default constructor succeeds if at least one sensitive part is included.

Once a constructor is selected, a `virtual database field` is constructed.
For each part, we combine the prefix with the [standard beacon](#standard-beacon)
(for sensitive parts) or plaintext value (for non-sensitive parts) of the field.

These parts are then joined together, in the order given in the constructor,
with parts separated by the `split character`.

For example, the above configuration might result in virtual fields that look like this :

 - T-20221225.S-123-45-6789.Z-12345
 - A-1234 Main Street.Z-23456

These virtual database fields are never written to the database, or even fully assembled.
But this is what the customer must imagine.

Sensitive values are then replaced with the appropriate beacon. For example

 - 20221225.S-abcdef.Z-7abc
 - A-3ab.Z-3456

Which is then stored in the database, with a field name of `aws_dbe_b_MyField`.

#### Querying Compound Beacons

At query time, the customer uses MyField in a query as if it were the full virtual field, for example :

MyField starts_with("A-")
MyField contains("Z-12345")

The onus is on the customer to properly re-create the results of all of the above configuration.

We might provide an API to construct a [virtual field](virtual.md) from a record,
to ease this burden.

#### Indexing Compound Beacons

"MyField" can be used in the definition of an index (other than the primary index),
as if it were any other field.

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
