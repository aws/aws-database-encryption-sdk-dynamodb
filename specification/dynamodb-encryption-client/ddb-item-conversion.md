[//]: # "Copyright Amazon.com Inc. or its affiliates. All Rights Reserved."
[//]: # "SPDX-License-Identifier: CC-BY-SA-4.0"

# DynamoDB Item Conversion

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

This document describes how a DynamoDB Item is converted
to the Structured Encryption Library's [Structured Data](../structured-encryption/structures.md#structured-data),
and vice versa.

Round Trip conversion between DDB Item and Structured Data is technically lossless, but it is not identity.
The conversion normalizes some values, the same way that
DynamoDB PuItem followed by GetItem normalizes some values.
The sets still have the same members, and the numbers still have the same values,
but the members of the set might appear in a different order,
and the numeric value might be formatted differently.

## Convert DDB Item to Structured Data

A [Structured Data](../structured-encryption/structures.md#structured-data)
converted from a DynamoDB Item has the following requirements:

- MUST contain a [Structured Data Terminal](../structured-encryption/structures.md#structured-data-terminal)
  for each attribute on the DynamoDB Item, and no others.

- The [Terminal Type ID](../structured-encryption/structures.md#terminal-type-id) for each attribute MUST
  be the [Type ID](./ddb-attribute-serialization.md#type-id) of the [serialization](./ddb-attribute-serialization.md) of this Attribute Value.
- The [Terminal Value](../structured-encryption/structures.md#terminal-value) for each attribute MUST
  be the [Value](./ddb-attribute-serialization.md#type-id) of the [serialization](./ddb-attribute-serialization.md) of this Attribute Value.
- The Structured Data Terminal MUST be located at the top level of the Structured Data,
  string indexed by the Attribute Name.

## Convert Structured Data to DDB Item

In order to convert to a DynamoDB Item,
[Structured Data](../structured-encryption/structures.md#structured-data)
adheres to the following:

- This [Structured Data Map](../structured-encryption/structures.md#structured-data-map),
  if not empty,
- MUST NOT have any `Key` strings that are invalid DynamoDB AttributeNames, that is, with more than 65535 characters.

A DynamoDB Item converted from a
[Structured Data](../structured-encryption/structures.md#structured-data)
has the following requirements:

- MUST contain an Attribute for every [Structured Data Terminal](../structured-encryption/structures.md#structured-data-terminal)
  on the Structured Data, and no other Attributes.

- Each Attribute MUST be deserializable
  according to [the serialization scheme](./ddb-attribute-serialization.md#value).

### Duplicates

- Conversion from a Structured Data Map MUST fail if it has duplicate keys
- Conversion from a Structured Data Number Set MUST fail if it has duplicate values
- Conversion from a Structured Data String Set MUST fail if it has duplicate values
- Conversion from a Structured Data Binary Set MUST fail if it has duplicate values
