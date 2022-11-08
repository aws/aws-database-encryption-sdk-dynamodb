[//]: # "Copyright Amazon.com Inc. or its affiliates. All Rights Reserved."
[//]: # "SPDX-License-Identifier: CC-BY-SA-4.0"

# Decrypt Item

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

This document describes the behavior by which the [DynamoDB Item Encryptor](./ddb-item-encryptor.md)
decrypts a DynamoDB Item originally encrypted via the [Encrypt Item](./encrypt-item.md) operation.

## Input

The following inputs to this behavior are REQUIRED:

- DynamoDB Item

### DynamoDB Item

The DynamoDB Item is the item to be decrypted by this behavior.

This item MUST include an Attribute with a name that matches the
[DynamoDB Partition Key Name](./ddb-item-encryptor.md#dynamodb-partition-key-name)
configured on the [DynamoDB Item Encryptor](./ddb-item-encryptor.md).
Otherwise this operation MUST yield an error.

If the [DynamoDB Item Encryptor](./ddb-item-encryptor.md)
has a [DynamoDB Sort Key Name](./ddb-item-encryptor.md#dynamodb-sort-key-name) configured,
this item MUST include an Attribute with that name.
Otherwise this operation MUST yield an error.

## Output

### DynamoDB Item

The DynamoDB Item is the decryption of the [input DynamoBD Item](#dynamodb-item).

## Behavior

This behavior REQUIRES a [Structured Data](../structured-encryption/structures.md#structured-data)
which is [converted](./ddb-item-conversion.md) from the [input DynamoDB Item](#dynamodb-item).

Given the converted [Structured Data](../structured-encryption/structures.md#structured-data),
this operation MUST delegate decryption of this data to
Structured Encryption Client's [Decrypt Structure](../structured-encryption/encrypt-structure.md),
with the following inputs:
- Encrypted Structured Data MUST be the Structured Data converted above.
- Authenticate Schema MUST be a [Authenticate Schema](../structured-encryption/structures.md#crypto-schema)
  built with the following requirements:
  - For every Attribute in the [input DynamoDB Item](#dynamodb-item)
    that is in the [signature scope](#signature-scope),
    there MUST exist a [SIGN Authenticate Action](../structured-encryption/structures.md#sign)
    in the Authenticate Schema,
    string indexed at the top level by that attribute name.
  - For every Attribute in the [input DynamoDB Item](#dynamodb-item)
    that is not in the [signature scope](#signature-scope),
    there MUST exist a [DO_NOT_SIGN Authenticate Action](../structured-encryption/structures.md#do_not_sign)
    in the Authenticate Schema,
    string indexed at the top level by that attribute name.
  - The number of Authenticate Actions in the Authenticate Schema
    MUST EQUAL the number of Attributes on the [input DynamoDB Item](#dynamodb-item).
- Encryption Context MUST be the input Item's [DynamoDB Item Base Context](./encrypt-item.md#dynamodb-item-base-context).
- CMM MUST be the [CMM configured on this Item Encryptor](./ddb-item-encryptor.md#cmm).

The output to this behavior is the [conversion](./ddb-item-conversion.md)
of the decrypted Structured Data determined above
into the [output DynamoDB Item](#encrypted-dynamodb-item).

### Signature Scope

An Attribute on a DynamoDB Item MUST NOT be considered as within the signature scope
if it's Attribute Name is included in [Unauthenticated Attributes](./ddb-item-encryptor.md#unauthenticated-attributes)
or if it's Attribute Name begins with the prefix specified in
[Unauthenticated Attribute Prefix](./ddb-item-encryptor.md#unauthenticated-attribute-prefix).
Otherwise, Attributes MUST be considered as within the signature scope.
