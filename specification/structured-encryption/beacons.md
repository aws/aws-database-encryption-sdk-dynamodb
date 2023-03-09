[//]: # "Copyright Amazon.com Inc. or its affiliates. All Rights Reserved."
[//]: # "SPDX-License-Identifier: CC-BY-SA-4.0"

# Beacons

## Version

1.0.0

### Changelog

## Overview

Beacons use stable hashes of the plaintext values of encrypted fields to allow searches on client-side encrypted records and using truncation to provide some basic privacy protections.

### Definitions

#### virtual field
A [virtual field](virtual.md) is a string computed from parts of a record.

#### virtual database field
A `virtual database field` is a string computed from fields and virtual fields,
from which a [compound beacon](#compound-beacon) is constructed.

#### Real Field
A `real field` is a field that was placed in the record by the customer,
rather than being generated.

#### Source Field
A `source field` is a [real field](#real-field) used to construct
a [virtual field](#virtual-field) or [virtual database field](#virtual-database-field).

Neither virtual fields nor virtual database fields are ever stored anywhere,
neither encrypted nor in plaintext.

### Beacon Length

The `Beacon Length` is the number of bits of the hash value that is kept.

If any given beacon value maps back to a unique plaintext value,
attackers can be given some insight into your plaintext.

An extreme example of this would be a boolean field representing
"this person is over 7 feet tall". The resulting beacon would have value
`X` 99.9% of the time and value `Y` 0.1% of the time, making it trivial
to determine which value maps to which plaintext. With something this
extreme, there's no way to make a safe beacon; but it can be combined
with something else in a [virtual field](#virtual-field).

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

To configure a single standard beacon, you need to provide

 1. A name
 1. A [beacon length](#beacon-length)

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

A compound beacon is assembled from parts of a record,
combining literal plaintext strings and [standard beacons](#standard-beacon)
into a complex string, suitable for complex database operations.

To configure a single compound beacon, you need to provide

 1. A name
 1. A join string
 1. A list of sensitive parts
 1. An optional list of non-sensitive parts
 1. An optional list of constructors

The `name` is used in queries and index creation as if it were a regular field.
"MyField" in examples below. It is an error if this name is the same as a configured
[virtual field](virtual.md), or to attempt to write a field of this name.

The `join string` separates the parts of a compound beacon.
In the examples below, we assume "`.`".

Each [sensitive part](#sensitive-part) has a field name,
a prefix and a [beacon length](#beacon-length).
The field name can refer directly to a field in the record,
or to a [virtual field](virtual.md).
The values of these fields are stored a hashes, not plaintext.
For example :

| Field Name | Prefix | Length |
|---|---|---|
| social | S- | 23 |
| phone | P- | 25 |
| zipcode | Z- | 15 |
| address | A- | 11 |

The first row should be interpreted as a literal `S-` followed by the 23-bit beacon
of the "social" field.

Each [nonsensitive part](#non-sensitive-part) has a field name and a prefix.
The values of these fields are stored in plaintext.

| Field Name | Prefix |
|---|---|
| timestamp | T- |

The first row should be interpreted as a literal `T-` followed by the plaintext
of the "timestamp" field.

It is an error for the configuration of a non-sensitive part to refer to
an encrypted field in any way.

NOTE - the way this is set up, you can't have two different parts built from the same field.
That is, you can't say

| Field Name | Prefix | Length |
|---|---|---|
| phone | T- | 25 |
| phone | P- | 25 |

I think that's ok, since one could always make a [virtual field](#virtual.md)
with the same content but a different name.

Prefixes can be any valid string, but no prefix string can be a prefix of another prefix string.

That is, you can have both "A-" and AB-" as prefixes,
but you can't have both "AB" and "AB-".

#### Writing Compound Beacons

To write a compound beacon, one constructs the [virtual database field](#virtual-database-field),
and then turns the sensitive parts into [standard beacons](#standard-beacon).

For writing, one can configure a list of [constructors](#constructor).

A single constructor is an ordered list of parts.
An example list of constructors might be :

 - timestamp social zipcode
 - address zipcode

A constructor `succeeds` if all its [source fields](#source-field) exist in the record.

Each constructor is tried, in the order configured, until one succeeds.

If no constructor succeeds, the record cannot be written.

If no constructors are configured, a default constructor is generated.
The default constructor creates a [virtual database field](#virtual-database-field) which is
the concatenation of the non-sensitive parts, in the order configured,
followed by the sensitive parts, in the order configured,
skipping any parts for which any [source fields](#source-field) is unavailable.

The default constructor succeeds if at least one sensitive part is included.

Once a constructor is selected, a [virtual database field](#virtual-database-field) is constructed.
For each part, we combine the prefix with the [standard beacon](#standard-beacon)
(for sensitive parts) or plaintext value (for non-sensitive parts) of the field.

These parts are then joined together, in the order given in the constructor,
with parts separated by the `join string`.

For example, the above configuration might result in [virtual database fields](#virtual-database-field) that look like this :

 - T-20221225.S-123-45-6789.Z-12345
 - A-1234 Main Street.Z-23456

These [virtual database field](#virtual-database-field) are never written to the database, or even fully assembled.
But this is what the customer must imagine.

Sensitive values are then replaced with the appropriate beacon. For example

 - T-20221225.S-abcdef.Z-7abc
 - A-3ab.Z-3456

Which is then stored in the database, with a field name of `aws_dbe_b_MyField`.

#### Querying Compound Beacons

At query time, the customer uses MyField in a query as if it were the full
[virtual database field](#virtual-database-field), for example :

 * MyField starts_with("A-")
 * MyField contains("Z-12345")

The onus is on the customer to properly re-create the results of all of the above configuration.

We might provide an API to construct a [virtual field](virtual.md) from a record,
to ease this burden. Perhaps another to construct the full [virtual database field](#virtual-database-field).

#### Indexing Compound Beacons

"MyField" can be used in the definition of an index (other than the primary index),
as if it were any other field.

## Definitions

### Conventions used in this document

The key words "MUST", "MUST NOT", "REQUIRED", "SHALL", "SHALL NOT", "SHOULD", "SHOULD NOT", "RECOMMENDED", "MAY", and "OPTIONAL"
in this document are to be interpreted as described in [RFC 2119](https://tools.ietf.org/html/rfc2119).

## Beacon Configuration

The following inputs to this configuration are REQUIRED:
 * A name -- a sequence of characters
 * A plaintext HMAC key -- a sequence of bytes
 * A [standard beacon config](#standard-beaconconfig)
or a [compound beacon config](#compound-beacon-config).

### Standard Beacon Config

A standard beacon config MUST have
 * A `length` -- a [beacon length](#beacon-length)

### Compound Beacon Config

A compound beacon config MUST have the following inputs:

 * A join string
 * A list of sensitive parts

The following inputs to a compound beacon config MUST be OPTIONAL:

 * A list of non-sensitive parts
 * A list of constructors

#### Sensitive Part

A sensitive part config MUST have the following inputs:

 * A field name -- a string
 * A Prefix -- a string
 * A `length` -- a [beacon length](#beacon-length)

#### Non-Sensitive Part

A non-sensitive part config MUST have the following inputs:

 * A field name -- a string
 * A Prefix -- a string

#### Part

`Part` is defined as a [sensitive part](#sensitive-part)
  or a [non-sensitive-part](#non-sensitive-part).

#### Constructor

  A Constructor MUST be a list of field names, each corresponding to a field name in a [part](#part).

---

Construction MUST fail if any beacon's name matches the name of a [virtual field](virtual.md),
any other beacon's name, or the name of a configured [real field](#real-field).

Construction MUST fail if any `prefix` in any [part](#part) is a prefix of
the `prefix` of any other [part](#part).

Construction MUST fail if any [part](#part) has the same name as any other [part](#part).

Construction MUST fail if any [non-sensitive-part](#non-sensitive-part) contains
any part of an encrypted field.

## Beacon Operations

There are three beacon operations available.

 * [isCompound](#iscompound)
 * [standardHash](#standardhash)
 * [compoundHash](#compoundhash)

### isCompound

isCompound MUST return `true` if the beacon is a [compound beacon](#compound-beacon),
and false if the beacon is a [standard beacon](#standard-beacon).

### standardHash
 * standardHash MUST fail if called on a beacon configured as a [compound beacon](#compound-beacon).
 * standardHash MUST take a sequence of bytes as input.
 * standardHash MUST produce a non-empty string as output.
 * standardHash MUST calculate the [HmacSha384](https://www.ietf.org/rfc/rfc2104.txt)
of the input bytes and the configured key, and keep the first 8 bytes.
 * standardHash MUST return the rightmost [beacon length](#beacon-length) bits of these 8 bytes as a hexadecimal string.
 * the length of the returned string MUST be (`hash length`/4) rounded up.

### compoundHash

 * compoundHash MUST fail if called on a beacon for which [isCompound](#iscompound) returns false.
 * compoundHash MUST take a record as input, and produce a string.
 * The returned string MUST NOT be empty.
 * A constructor must be [selected](#constructor-selection).
 * compoundHash MUST return the concatenation of the [value](#part-value)
of each part in the constructor,
in the same order as they exist in the constructor.
 * The parts MUST be delimited by the join string.

### Constructor Selection

If no constructors are configured, a [default constructor](#default-constructor)
MUST be generated.

Otherwise, the first configured constructor for which all [source fields](#source-field) are available
will be selected.

### Default Constructor

The default constructor MUST be generated by iterating through all the
[non-sensitive-parts](#non-sensitive-part) followed by the [sensitive-parts](#sensitive-part),
in the order of their configuration, discarding those for which any [source field](#source-field)
is unavailable.

This operation MUST fail if the resulting constructor does not contain at least one
[sensitive-part](#sensitive-part).

### Part Value

For a [sensitive part](#sensitive-part), the part value MUST be the concatenation
of the prefix and the [standardHash](#standardhash) of the field value and the
configured [beacon length](#beacon-length).

For a [non-sensitive part](#non-sensitive-part), the part value MUST be the concatenation
of the prefix and the field value.