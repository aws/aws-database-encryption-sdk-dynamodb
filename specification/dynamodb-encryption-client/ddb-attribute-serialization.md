[//]: # "Copyright Amazon.com Inc. or its affiliates. All Rights Reserved."
[//]: # "SPDX-License-Identifier: CC-BY-SA-4.0"

# DynamoDB Attribute Serialization

## Version

1.0.0

### Changelog

- 1.0.0
  - Initial record

## Definitions

### Conventions used in this document

The key words "MUST", "MUST NOT", "REQUIRED", "SHALL", "SHALL NOT", "SHOULD", "SHOULD NOT", "RECOMMENDED", "MAY", and "OPTIONAL"
in this document are to be interpreted as described in [RFC 2119](https://tools.ietf.org/html/rfc2119).

## Overview

This document contains the specification for various serialization and deserialization of DynamoDB Attributes
as performed by the DynamoDB Encryption Client.

## Attribute Value Serialization

### Type ID

Type ID indicates what type a DynamoDB Attribute Value MUST
be serialized and deserialized as.

| Attribute Value Data Type | Terminal Type ID |
| ------------------------- | ---------------- |
| Null (NULL)               | 0x0000           |
| String (S)                | 0x0001           |
| Number (N)                | 0x0002           |
| Binary (B)                | 0xFFFF           |
| Boolean (BOOL)            | 0x0004           |
| String Set (SS)           | 0x0101           |
| Number Set (NS)           | 0x0102           |
| Binary Set (BS)           | 0x01FF           |
| Map (M)                   | 0x0200           |
| List (L)                  | 0x0300           |

### Value

Value is the actual serialization of the data held in the DynamoDB Attribute Value.
The sub-headers in this section specify how each type is serialized.

#### Null

Null MUST be serialized as a zero-length byte string.

#### String

String MUST be serialized as UTF-8 encoded bytes.

#### Number

Note that DynamoDB Number Attribute Values are strings.

This value MUST be normalized in the same way as DynamoDB normalizes numbers.
This normalized value MUST then be serialized as UTF-8 encoded bytes.

#### Binary

Binary MUST be serialized with the identity function;
or more plainly, Binary Attribute Values are used as is.

#### Boolean

Boolean MUST be serialized as:

- `0x00` if the value is `false`
- `0x01` if the value is `true`

#### Set

A Set is a String Set, Number Set, or Binary Set.

A Set MUST be serialized as:

| Field       | Length   |
| ----------- | -------- |
| Set Count   | 4        |
| Set Entries | Variable |

##### Set Count

Set Count MUST be a big-endian unsigned integer
equal to the number of serialized entries in
[Set Entries](#set-entries).

Set Count MAY be `0`,
in which case [Set Entries](#set-entries) is a zero-length byte string.

##### Set Entries

Set Entries is a sequence of serialized entries.
Each of these entries MUST be serialized as:

| Field            | Length                               |
| ---------------- | ------------------------------------ |
| Set Entry Length | 4                                    |
| Set Entry Value  | Variable. Equal to Set Entry Length. |

All [Set Entry Values](#set-entry-value) are the same type.

Binary Sets MUST NOT contain duplicate entries.
Entries in a Binary Set MUST be ordered lexicographically by their underlying bytes in ascending order.

Number Sets MUST NOT contain duplicate entries.
Entries in a Number Set MUST be ordered in ascending [UTF-16 binary order](./string-ordering.md#utf-16-binary-order).
This ordering MUST be applied after normalization of the number value.
Note that because normalized number characters are all in the ASCII range (U+0000 to U+007F),
this ordering is equivalent to the [code point ordering](./string-ordering.md#code-point-order).

String Sets MUST NOT contain duplicate entries.
Entries in a String Set MUST be ordered in ascending [UTF-16 binary order](./string-ordering.md#utf-16-binary-order).
Note that though the entries are sorted by UTF016 binary order,
the values are serialized in the set with UTF-8 encoding.

###### Set Entry Length

Set Entry Length MUST be a big-endian unsigned integer
equal to the length of [Set Entry Value](#set-entry-value).

###### Set Entry Value

In DynamoDB, Set Entry Value can only be a [Value](#value) of the following types:

- [String](#string)
- [Number](#number)
- [Binary](#binary)

#### Map Attribute

Map MUST be serialized as:

| Field                  | Length   |
| ---------------------- | -------- |
| Key Value Pair Count   | 4        |
| Key Value Pair Entries | Variable |

##### Key Value Pair Count

Key Value Pair Count MUST be a big-endian unsigned integer
equal to the number of serialized key-value pairs in
[Key Value Pair Entries](#key-value-pair-entries).

Key Value Pair Count MAY be `0`,
in which case [Key Value Pair Entries](#key-value-pair-entries) is an empty bytestring.

##### Key Value Pair Entries

Key Value Pair Entries are a sequence of
key-value pair serializations.
Each key-value pair MUST be serialized as:

| Field        | Length   |
| ------------ | -------- |
| Key Type     | 2        |
| Key Length   | 4        |
| Map Key      | Variable |
| Value Type   | 2        |
| Value Length | 4        |
| Map Value    | Variable |

This sequence MUST NOT contain duplicate [Map Keys](#map-key).

Entries in a serialized Map MUST be ordered by key value,
ordered in ascending [UTF-16 binary order](./string-ordering.md#utf-16-binary-order).
Note that even though the values are sorted according to UTF-16 binary order,
string values are actually encoded within the map as UTF-8.

###### Key Type

Key Type MUST be the [Type ID](#type-id) for Strings.

###### Key Length

Key Length MUST be a non-zero big-endian unsigned integer
equal to the length of [Map Key](#map-key).

###### Map Key

Map Key MUST be a [String Value](#string).

###### Value Type

Value Type MUST be the [Type ID](#type-id) of the type of [Map Value](#map-value).

###### Value Length

Value Length MUST be a big-endian unsigned integer
equal to the length of [Map Value](#map-value).

###### Map Value

Map Value MUST be a [Value](#value).
A Map MAY hold any DynamoDB Attribute Value data type,
and MAY hold values of different types.

#### List

List MUST be serialized as:

| Field        | Length   |
| ------------ | -------- |
| List Count   | 4        |
| List Entries | Variable |

##### List Count

List Count MUST be a big-endian unsigned integer
equal to the number of serialized list entries in
[List Entries](#list-entries).

List Count MAY be `0`,
in which case [List Entries](#list-entries) is an empty byte string.

##### List Entries

List Entries is a sequence of serialized list entries.
Each list entry in the sequence MUST be serialized as:

| Field             | Length                     |
| ----------------- | -------------------------- |
| List Entry Type   | 2                          |
| List Entry Length | 4                          |
| List Entry Value  | Variable. Equal to Length. |

The order of these serialized list entries MUST match
the order of the entries in the original list.

###### List Entry Type

List Entry Type MUST be the [Type ID](#type-id) of the type of [List Entry Value](#list-entry-value).

###### List Entry Length

List Entry Length MUST be a big-endian unsigned integer
equal to the length of [List Entry Value](#list-entry-value).

###### List Entry Value

List Entry Value is equivalent to [Value](#value).
A List MAY hold any DynamoDB Attribute Value data type,
and MAY hold values of different types.
