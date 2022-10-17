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

This conversion MUST be lossless.

## Convert DDB Item to Structured Data

A [Structured Data](../structured-encryption/structures.md#structured-data)
converted from a DynamoDB Item has the following requirements:
- MUST be a [Structured Data Map](../structured-encryption/structures.md#structured-data-map).
- MUST NOT have [Structured Data Attributes](../structured-encryption/structures.md#structured-data-attributes).
- MUST contain a [Structured Data Terminal](../structured-encryption/structures.md#structured-data-terminal)
  for each attribute on the DynamoDB Item,
  such that:
  - the [Terminal Type ID](../structured-encryption/structures.md#terminal-type-id)
    is the [Type ID](./ddb-attribute-serialization.md#type-id) of the [serialization](./ddb-attribute-serialization.md) of this Attribute Value.
  - the [Terminal Value](../structured-encryption/structures.md#termin-value)
    is the [Value](./ddb-attribute-serialization.md#type-id) of the [serialization](./ddb-attribute-serialization.md) of this Attribute Value.
  - The Structured Data Terminal is located at the top level of the Structured Data,
    string indexed by the Attribute Name.
- MUST NOT contain any additional [Structured Data](../structured-encryption/structures.md#structured-data)
  than those specified above.

## Convert Structured Data to DDB Item

In order to convert to a DynamoDB Item,
[Structured Data](../structured-encryption/structures.md#structured-data)
adheres to the following:
- MUST be a [Structured Data Map](../structured-encryption/structures.md#structured-data-map).
- This [Structured Data Map](../structured-encryption/structures.md#structured-data-map),
  if not empty,
  MUST only contain [Structured Data Terminals](../structured-encryption/structures.md#structured-data-terminal).
- MUST NOT have [Structured Data Attributes](../structured-encryption/structures.md#structured-data-attributes).

A DynamoDB Item converted from a
[Structured Data](../structured-encryption/structures.md#structured-data)
has the following requirements:
- MUST contain an Attribute for every [Structured Data Terminal](../structured-encryption/structures.md#structured-data-terminal)
  on the Structured Data,
  such that:
  - The Attribute is the deserialization of the concatenation of
    `Terminal Type ID | Terminal Value`,
    according to [the serialization scheme](./ddb-attribute-serialization.md).
- MUST contain a Binary Attribute with Attribute Name "TODO:header".
- MUST contain a Binary Attribute with Attribute Name "TODO:footer".
- MUST NOT contain any Attribute not specified above.
