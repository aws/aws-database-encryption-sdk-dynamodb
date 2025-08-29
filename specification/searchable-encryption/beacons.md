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

A [terminal location](virtual.md#terminal-location) designates a portion of a structured value.

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
1. Turn the result into a hex string.

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
1. A list of encrypted parts
1. A list of signed parts
1. A list of constructors

The `name` is used in queries and index creation as if it were a regular field.
"MyField" in examples below. It is an error if this name is the same as a configured
field, or [virtual field](virtual.md), or to attempt to write a field of this name.

The `split character` separates the parts of a compound beacon.
In the examples below, we assume "`.`".

Each [encrypted part](#encrypted-part-initialization) has a name and a prefix.
The name MUST be the name of a configured standard beacon.

For example :

| Beacon Name | Prefix |
| ----------- | ------ |
| social      | S-     |
| phone       | P-     |
| zipcode     | Z-     |

The first row should be interpreted as a literal `S-` followed by the "social" standard beacon.

Each [signed part](#signed-part-initialization) has a field name,
a [terminal location](virtual.md#terminal-location) and a prefix.
The values of these fields are stored in plaintext.

| Field Name | Location  | Prefix |
| ---------- | --------- | ------ |
| timestamp  | timestamp | T-     |

The first row should be interpreted as a literal `T-` followed by the plaintext
of the "timestamp" field.

It is an error for the configuration of a signed part to refer to
an encrypted field in any way.

Prefixes can be any valid string, but no prefix string can be a prefix of another prefix string.

That is, you can have both "A-" and AB-" as prefixes,
but you can't have both "A-" and "A--".

#### Writing Compound Beacons

To write a compound beacon, one generates the [virtual database field](#virtual-database-field),
via a `constructor`,
and then combines the encrypted parts from the referenced [standard beacons](#standard-beacon).

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
signed parts followed by encrypted parts, all parts required.

From the first constructor that succeeds,
a [virtual database field](#virtual-database-field) is constructed.
For each part, we combine the prefix with the [standard beacon](#standard-beacon)
(for encrypted parts) or plaintext value (for signed parts) of the field.

These parts are then joined together, in the order given in the constructor,
with parts separated by the `split character`.

For example, the above configuration might result in [virtual database fields](#virtual-database-field) that look like this :

- T-20221225.S-123-45-6789.Z-12345
- A-1234 Main Street.Z-23456

These [virtual database field](#virtual-database-field) are never written to the database, or even fully assembled.
But this is what the customer must imagine.

Encrypted values are then replaced with the appropriate beacon. For example

- T-20221225.S-abcdef.Z-7abc
- A-3ab.Z-edc3

Which is then stored in the database, with a field name of `aws_dbe_b_MyField`.

#### Querying Compound Beacons

At query time, the customer uses MyField in a query as if it were the full
[virtual database field](#virtual-database-field), for example :

- MyField starts_with("A-")
- MyField contains("Z-12345")

The onus is on the customer to properly re-create the results of all of the above configuration.

We might provide an API to construct a [virtual field](virtual.md) from a record,
to ease this burden. Perhaps another to construct the full [virtual database field](#virtual-database-field).

##### LessThanComparable

A value for a compound beacon in a query is `LessThanComparable` if it is composed of
zero or more [signed parts](#signed-part-initialization),
optionally follows by just the prefix of a [encrypted part](#encrypted-part-initialization).

A Query MUST fail if it uses `<`, `<=`, `>`, or `>=` on a value that is not LessThanComparable.

##### BetweenComparable

To determine if two values for a compound beacon in a query are `BetweenComparable`.

1 Remove any leading parts common to both values
1 Check if the remainder is [LessThanComparable](#lessthancomparable)

A Query MUST fail if it uses BETWEEN on values that are not BetweenComparable.

#### Indexing Compound Beacons

"MyField" can be used in the definition of an index (other than the primary index),
as if it were any other field.

#### Signed Beacons

If a compound beacon is configured with no encrypted parts (i.e. with exclusively signed parts)
then it is considered a signed beacon. A signed beacon with name `NAME` follows slightly different rules.

The beacon value MUST be stored as `NAME`, rather than the usual `aws_dbe_b_NAME`.

This has certain implications.

- `NAME` can be used as a primary table key.
- `NAME` will not be stripped out of records returned from Query or GetItem.
- `NAME` is allowed to appear in a record to be written.

Initialization MUST fail if `NAME` is explicitly configured with an
[attribute actions](../dynamodb-encryption-client/ddb-item-encryptor.md#attribute-actions) or
[unauthenticated attributes](../dynamodb-encryption-client/ddb-item-encryptor.md#unauthenticated-attributes),
or begins with the [unauthenticated attribute prefix](../dynamodb-encryption-client/ddb-item-encryptor.md#unauthenticated-attribute-prefix).

`NAME` MUST be automatically configured with an attribute action of SIGN_ONLY.

As mentioned in [ddb support](../dynamodb-encryption-client/ddb-support.md#addsignedbeacons),
If `NAME` appears in an record to be written,
and `NAME` can also be constructed from other parts of the record,
then the write must fail if the constructed and supplied values are not equal.

### Conventions used in this document

The key words "MUST", "MUST NOT", "REQUIRED", "SHALL", "SHALL NOT", "SHOULD", "SHOULD NOT", "RECOMMENDED", "MAY", and "OPTIONAL"
in this document are to be interpreted as described in [RFC 2119](https://tools.ietf.org/html/rfc2119).

### Standard Beacon Initialization

On initialization of a Standard Beacon, the caller MUST provide:

- A name -- a string
- A `length` -- a [beacon length](#beacon-length)

On initialization of a Standard Beacon, the caller MAY provide:

- a [terminal location](virtual.md#terminal-location) -- a string
- a [beacon style](beacon-style-initialization)

If no [terminal location](virtual.md#terminal-location) is provided,
the `name` MUST be used as the [terminal location](virtual.md#terminal-location).

Initialization MUST fail if two standard beacons are configured with the same location.

### Beacon Style Initialization

On initialization of a Beacon Style, the caller MUST provide exactly one of

- a [PartOnly](#partonly-initialization)
- a [Shared](#shared-initialization)
- an [AsSet](#asset-initialization)
- a [SharedSet](#sharedset-initialization)

### PartOnly Initialization

On initialization of a PartOnly, the caller MUST NOT provide any
additional parameters to the PartOnly.

Initialization MUST fail if the configuration does not use a PartOnly in a [compound beacon](#compound-beacon).

The Standard Beacon MUST NOT be stored in the item for a PartOnly beacon.

A query MUST fail if it tries to search on a PartOnly beacon directly.

### AsSet Initialization

On initialization of as AsSet, the caller MUST NOT provide any
additional parameters to the AsSet.

- initialization MUST fail if any compound beacon has an AsSet beacon as a part.
- Writing an item MUST fail if the item contains this beacon's attribute,
  and that attribute is not of type Set.
- The Standard Beacon MUST be stored in the item as a Set,
  comprised of the [beacon values](#beacon-value) of all the elements in the original Set.

### Shared Initialization

On initialization of a Shared, the caller MUST provide:

- other : a beacon name

This name MUST be the name of a previously defined Standard Beacon.

This beacon's [length](#beacon-length) MUST be equal to the `other` beacon's [length](#beacon-length).

This beacon MUST calculate its [value](#beacon-value) as if it were the `other` beacon.

### SharedSet Initialization

On initialization of a SharedSet, the caller MUST provide:

- other : a beacon name

A SharedSet Beacon MUST behave both as [Shared](#shared-initialization) and [AsSet](#asset-initialization).

### Compound Beacon Initialization

On initialization of a Compound Beacon, the caller MUST provide:

- A name -- a string
- A split character -- a character

On initialization of a Compound Beacon, the caller MAY provide:

- A list of [encrypted parts](#encrypted-part-initialization)
- A list of [signed parts](#signed-part-initialization)
- A list of constructors

#### Signed Part Initialization

On initialization of a [signed part](#signed-part-initialization), the caller MUST provide:

- A name -- a string
- A prefix -- a string

On initialization of a [signed parts](#signed-part-initialization), the caller MAY provide:

- A [terminal location](virtual.md#terminal-location) -- a string

If no [terminal location](virtual.md#terminal-location) is provided,
the `name` MUST be used as the [terminal location](virtual.md#terminal-location).

#### Encrypted Part Initialization

On initialization of a [encrypted part](#encrypted-part-initialization), the caller MUST provide:

- A name -- a string, the name of a standard beacon
- A prefix -- a string

#### Constructor Initialization

On initialization of a constructor, the caller MUST provide:

- A non-empty list of [Constructor parts](#constructor-part-initialization)

#### Constructor Part Initialization

On initialization of a constructor part, the caller MUST provide:

- A name -- a string
- A required flag -- a boolean

This name MUST match the name of one of the [encrypted](#encrypted-part-initialization) or [signed](#signed-part-initialization) parts.

These parts may come from these locally defined parts lists, or from the
[Global Parts List](search-config.md#global-parts-list), in any combination.

### Default Construction

- If no constructors are configured, a default constructor MUST be generated.
- This default constructor MUST be all of the signed parts,
  followed by all the encrypted parts, all parts being required.
- Initialization MUST fail if no constructors are configured, and no local parts are configured.

### Part

The word `part` is used to refer to any [encrypted](#encrypted-part-initialization) or [signed](#encrypted-part-initialization) part.

### Initialization Failure

Initialization MUST fail if any `prefix` in any [part](#part) is a prefix of
the `prefix` of any other [part](#part).

Initialization MUST fail if any [signed-part](#signed-part-initialization) contains
anything but SIGN_ONLY fields.

Initialization MUST fail if any [constructor](#constructor-initialization) is configured with a field name
that is not a defined [part](#part).

Initialization MUST fail if any [constructor](#constructor-initialization) is configured without at least one
required part.

Initialization MUST fail if two [constructors](#constructor-initialization) are configured
with the same set of required parts.

### Beacon Value

The value for a beacon is as defined below under
[value for a standard beacon](#value-for-a-standard-beacon)
or [value for a compound beacon](#value-for-a-compound-beacon).

## Beacon Operations

Both standard and compound beacons define two operations

- hash - turn a plaintext record into a beacon
- getPart - turn a plaintext query string into a beacon

### basicHash

- basicHash MUST take an [hmac key](./search-config.md#hmac-key-generation), a [beacon length](#beacon-length) and a sequence of bytes as input.
- basicHash MUST produce a non-empty string as output.
- basicHash MUST calculate the [HmacSha384](https://www.ietf.org/rfc/rfc2104.txt)
  of the input bytes and the [hmac key](./search-config.md#hmac-key-generation), and keep the first 8 bytes.
- basicHash MUST return the rightmost [beacon length](#beacon-length) bits of these 8 bytes as a hexadecimal string.
- the length of the returned string MUST be (`beacon length`/4) rounded up.

### string hash

- string hash MUST take a string and some [key materials](./search-config.md#get-beacon-key-materials)
  as input, and produce a string as output.
- string hash MUST return the [basic hash](#basichash) of the UTF8 representation
  of the input string, the HMAC key from the [key materials](./search-config.md#get-beacon-key-materials)
  associated with this beacon, and the beacon length associated with this beacon.

### value for a standard beacon

- This operation MUST take an [hmac key](./search-config.md#hmac-key-generation), a record as input, and produce an optional [AttributeValue](https://docs.aws.amazon.com/amazondynamodb/latest/APIReference/API_AttributeValue.html).
- This operation MUST return no value if the associated field does not exist in the record
- If this beacon is marked AsSet then this operation MUST return the
  [set value](#value-for-a-set-standard-beacon),
  otherwise it MUST return the [non-set value](#value-for-a-non-set-standard-beacon)

### value for a non-set standard beacon

- This operation MUST convert the attribute value of the associated field to
  a sequence of bytes, as per [attribute serialization](../dynamodb-encryption-client/ddb-attribute-serialization.md).
- This operation MUST return the [basicHash](#basichash) of the resulting bytes and the configured [beacon length](#beacon-length).
- The returned
  [AttributeValue](https://docs.aws.amazon.com/amazondynamodb/latest/APIReference/API_AttributeValue.html)
  MUST be type "S" String.

### value for a set standard beacon

- This operation MUST convert the value of each item in the set to
  a sequence of bytes, as per [attribute serialization](../dynamodb-encryption-client/ddb-attribute-serialization.md).
- This operation MUST return a set containing the [basicHash](#basichash) of the resulting bytes and the configured [beacon length](#beacon-length).
- The resulting set MUST NOT contain duplicates.
- The returned
  [AttributeValue](https://docs.aws.amazon.com/amazondynamodb/latest/APIReference/API_AttributeValue.html)
  MUST be type "SS" StringSet.

### value for a compound beacon

- This operation MUST take a record as input, and produce an optional string.
- If a string is returned, it MUST NOT be empty.
- This operation MUST iterate through all constructors, in order, using the first that succeeds.
- For that constructor, hash MUST join the [part value](#part-value) for each part
  on the `split character`,
  excluding parts that are not required and with a source field that is not available.
- This operation MUST fail if any plaintext value used in the construction contains the split character.
- If no constructor succeeds, this operation MUST return no value.

### getPart for a standard beacon

- getPart MUST take an [hmac key](./search-config.md#hmac-key-generation), a sequence of bytes as input, and produce a string.
- getPart MUST return the [basicHash](#basichash) of the input and the configured [beacon length](#beacon-length).

### getPart for a compound beacon

- getPart MUST take a string as input and produce a string.
- The returned string MUST NOT be empty.
- The string MUST be split on the `split character` into pieces.
- For each piece, a [part](#part) MUST be identified
  by matching the prefix of a [part](#part)
  to the beginning of the piece.
- If no such part exists, this operation MUST fail.
- The [Part Value](#part-value-calculation) MUST be calculated for each piece,
  using the prefix and length from the discovered part.
- The value returned MUST be these part values, joined with the `split character`.

### Part Value

Calculate the `plain string` :
the concatenation of the prefix and the field value.

The `Part Value` is the [part value calculation](#part-value-calculation) of the `plain string` and the part.

### Part Value Calculation

Part Value Calculation MUST take some [key materials](./search-config.md#get-beacon-key-materials),
a string (the value for which the beacon is being calculated)
and a [Part](#part) as input, and return a string as output.

If the part is a [encrypted part](#encrypted-part-initialization),
the part value MUST be the concatenation of the part's prefix
and the [string hash](#string-hash) of the input string.

If the part is a [signed part](#signed-part-initialization),
the part value MUST be the concatenation of the part's prefix and the input string.
