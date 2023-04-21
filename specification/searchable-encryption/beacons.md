[//]: # "Copyright Amazon.com Inc. or its affiliates. All Rights Reserved."
[//]: # "SPDX-License-Identifier: CC-BY-SA-4.0"

# Beacons

## Version

1.0.0

### Changelog

## Overview

Beacons use stable hashes of plaintext values of encrypted fields
to allow searches on client-side encrypted records
using truncation to provide some basic privacy protections.

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

With more evenly distributed values, such as zip code,
a unique hash can still reveal that two records have the same zip code as each other,
even if the exact zip code is still a mystery.
To avoid being able to distinguish unique values, we truncate the hash to ensure some collisions.

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

### Terminal Location

A terminal location designates a portion of a structured value. Defined [here](virtual.md#terminal-location).

### Standard Beacon

The simplest form of beacon is a standard beacon.

To configure a single standard beacon, you need to provide

 1. A name
 1. A [terminal location](virtual.md#terminal-location)
 1. A [beacon length](#beacon-length)

A hash is made from the value at the terminal location, and stored at
at the top level of the structure with the name `aws_dbe_b_` followed by the configured name.
The configured name is used as a field name in queries.

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
 1. A split character
 1. A list of sensitive parts
 1. A list of non-sensitive parts
 1. A list of constructors

The `name` is used in queries and index creation as if it were a regular field.
"MyField" in examples below. It is an error if this name is the same as a configured
field, or [virtual field](virtual.md), or to attempt to write a field of this name.

The `split character` separates the parts of a compound beacon.
In the examples below, we assume "`.`".

Each [sensitive part](#sensitive-part-initialization) has a name and a prefix.
The name MUST be the name of a configured standard beacon.

For example :

| Beacon Name | Prefix |
|-------------|--------|
| social      | S-     |
| phone       | P-     |
| zipcode     | Z-     |

The first row should be interpreted as a literal `S-` followed by the "social" standard beacon.

Each [nonsensitive part](#non-sensitive-part-initialization) has a field name,
a [terminal location](virtual.md#terminal-location) and a prefix.
The values of these fields are stored in plaintext.

| Field Name | Location  | Prefix |
|------------|-----------|--------|
| timestamp  | timestamp | T-     |

The first row should be interpreted as a literal `T-` followed by the plaintext
of the "timestamp" field.

It is an error for the configuration of a non-sensitive part to refer to
an encrypted field in any way.

Prefixes can be any valid string, but no prefix string can be a prefix of another prefix string.

That is, you can have both "A-" and AB-" as prefixes,
but you can't have both "A-" and "A--".

#### Writing Compound Beacons

To write a compound beacon, one generates the [virtual database field](#virtual-database-field),
via a `constructor`,
and then combines the sensitive parts from the referenced [standard beacons](#standard-beacon).

A single constructor has a name and an ordered list of parts.
Each part can be required or optional.
Every constructor must contain at least one required field.

An example list of constructors might be :

 - Person : timestamp(required) social(optional) zipcode(required)
 - Location : address(required) zipcode(required)

A constructor `succeeds` if all its required [source fields](#source-field) exist in the record.

Each constructor is tried, in the order configured, until one succeeds.

If no constructor succeeds, the beacon is not included in the record.

If no constructors are configured, a default constructor is generated,
which is all of the configured parts, in their configured order,
non-sensitive parts followed by sensitive parts, all parts required.

From the first constructor that succeeds,
a [virtual database field](#virtual-database-field) is constructed.
For each part, we combine the prefix with the [standard beacon](#standard-beacon)
(for sensitive parts) or plaintext value (for non-sensitive parts) of the field.

These parts are then joined together, in the order given in the constructor,
with parts separated by the `split character`.

For example, the above configuration might result in [virtual database fields](#virtual-database-field) that look like this :

 - T-20221225.S-123-45-6789.Z-12345
 - A-1234 Main Street.Z-23456

These [virtual database field](#virtual-database-field) are never written to the database, or even fully assembled.
But this is what the customer must imagine.

Sensitive values are then replaced with the appropriate beacon. For example

 - T-20221225.S-abcdef.Z-7abc
 - A-3ab.Z-edc3

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


### Standard Beacon Initialization

On initialization of a Standard Beacon, the caller MUST provide:

 * A name -- a string
 * A `length` -- a [beacon length](#beacon-length)

 On initialization of a Standard Beacon, the caller MAY provide:

 * a [terminal location](virtual.md#terminal-location) -- a string

If no [terminal location](virtual.md#terminal-location) is provided,
the `name` MUST be used as the [terminal location](virtual.md#terminal-location).

Initialization MUST fail if two standard beacons are configured with the same location.


### Compound Beacon Initialization

On initialization of a Compound Beacon, the caller MUST provide:

 * A name -- a string
 * A split character -- a character
 
 On initialization of a Compound Beacon, the caller MAY provide:

 * A list of [sensitive parts](#sensitive-part-initialization)
 * A list of [non-sensitive parts](#non-sensitive-part-initialization)
 * A list of constructors

#### Non Sensitive Part Initialization

On initialization of a [non-sensitive part](#non-sensitive-part-initialization), the caller MUST provide:

 * A name -- a string
 * A prefix -- a string

On initialization of a [non-sensitive parts](#non-sensitive-part-initialization), the caller MAY provide:

 * A [terminal location](virtual.md#terminal-location) -- a string

If no [terminal location](virtual.md#terminal-location) is provided,
the `name` MUST be used as the [terminal location](virtual.md#terminal-location).

#### Sensitive Part Initialization

On initialization of a [sensitive part](#sensitive-part-initialization), the caller MUST provide:

 * A name -- a string, the name of a standard beacon
 * A prefix -- a string

#### Constructor Initialization

On initialization of a constructor, the caller MUST provide:

 * A non-empty list of [Constructor parts](#constructor-part-initialization)

#### Constructor Part Initialization

On initialization of a constructor part, the caller MUST provide:

 * A name -- a string
 * A required flag -- a boolean

This name MUST match the name of one of the [sensitive](#sensitive-part-initialization) or [non-sensitive](#non-sensitive-part-initialization) parts.

### Default Construction

* If no constructors are configured, a default constructor MUST be generated.
* This default constructor MUST be all of the non-sensitive parts,
followed by all the sensitive part, all parts being required.

### Part

The word `part` is used to refer to any [sensitive](#sensitive-part-initialization) or [non-sensitive](#sensitive-part-initialization) part.

### Initialization Failure

Initialization MUST fail if any `prefix` in any [part](#part) is a prefix of
the `prefix` of any other [part](#part).

Initialization MUST fail if any [non-sensitive-part](#non-sensitive-part-initialization) contains
any part of an encrypted field, or any [sensitive-part](#sensitive-part-initialization) fails to contain
some part of an encrypted field.

Initialization MUST fail if any [constructor](#constructor) is configured with a field name
that is not a defined [part](#part).

Initialization MUST fail if any [constructor](#constructor) is configured without at least one
required part.

Initialization MUST fail if two [constructors](#constructor) are configured
with the same set of required parts.

### Beacon Value

The value for a beacon is as defined below under
[value for a standard beacon](#value-for-a-standard-beacon)
or [value for a compound beacon](#value-for-a-compound-beacon).

## Beacon Operations

Both standard and compound beacons define two operations
 * [hash](#hash) - turn a plaintext record into a beacon
 * [getPart](#getpart) - turn a plaintext query string into a beacon

### basicHash
 * basicHash MUST take an [hmac key](./search-config.md#hmac-key-generation), a [beacon length](#beacon-length) and a sequence of bytes as input.
 * basicHash MUST produce a non-empty string as output.
 * basicHash MUST calculate the [HmacSha384](https://www.ietf.org/rfc/rfc2104.txt)
of the input bytes and the [hmac key](./search-config.md#hmac-key-generation), and keep the first 8 bytes.
 * basicHash MUST return the rightmost [beacon length](#beacon-length) bits of these 8 bytes as a hexadecimal string.
 * the length of the returned string MUST be (`beacon length`/4) rounded up.

### value for a standard beacon
 * This operation MUST take an [hmac key](./search-config.md#hmac-key-generation), a record as input, and produce an optional string.
 * This operation MUST return no value if the associated field does not exist in the record
 * This operation MUST convert the attribute value of the associated field to
a sequence of bytes, as per [attribute serialization](../dynamodb-encryption-client/ddb-attribute-serialization.md).
 * This operation MUST return the [basicHash](#basichash) of the input and the configured [beacon length](#beacon-length).

### value for a compound beacon

 * This operation MUST take a record as input, and produce an optional string.
 * If a string is returned, it MUST NOT be empty.
 * This operation MUST iterate through all constructors, in order, using the first that succeeds.
 * For that constructor, hash MUST join the [part value](#part-value) for each part
on the `split character`,
excluding parts that are not required and with a source field that is not available.
 * This operation MUST fail if any plaintext value used in the construction contains the split character.
 * If no constructor, this operation must return no value.

### getPart for a standard beacon

 * getPart MUST take an [hmac key](./search-config.md#hmac-key-generation), a sequence of bytes as input, and produce a string.
 * getPart MUST return the [basicHash](#basichash) of the input and the configured [beacon length](#beacon-length).

### getPart for a compound beacon

 * getPart MUST take a string as input and produce a string.
 * The returned string MUST NOT be empty.
 * The string MUST be split on the `split character` into pieces.
 * For each piece, a [part](#part) MUST be identified 
 by matching the prefix of a [part](#part)
to the beginning of the piece.
 * If no such part exists, this operation MUST fail.
 * The [Part Value](#part-value-calculation) MUST be calculated for each piece,
using the prefix and length from the discovered part.
 * The value returned MUST be these part values, joined with the `split character`.

### Part Value

Calculate the `plain string` :
the concatenation of the prefix and the field value.

The `Part Value` is the [part value calculation](#part-value-calculation) of the `plain string`, the part's prefix, and the [beacon length](#beacon-length), if any.

### Part Value Calculation

Part Value Calculation MUST take an [hmac key](./search-config.md#hmac-key-generation), a string, a prefix,
and an optional [beacon length](#beacon-length) as input, and return a string as output.

The input string MUST begin with the provided prefix.

If the [beacon length](#beacon-length) is provided, 
the part value MUST be the concatenation of the prefix
and the [basicHash](#basichash) of the input string with the configured [beacon length](#beacon-length).

If the [beacon length](#beacon-length) is not provided, the part value MUST be the input string.
