[//]: # "Copyright Amazon.com Inc. or its affiliates. All Rights Reserved."
[//]: # "SPDX-License-Identifier: CC-BY-SA-4.0"

# Encrypt Item

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
produces an encrypted form of a DynamoDB Item for a particular DynamoDB Table.

## Input

The following inputs to this behavior are REQUIRED:

- DynamoDB Item
- Attribute Actions
- Either a [Keyring](https://github.com/awslabs/aws-encryption-sdk-specification/blob/master/framework/keyring-interface.md)
  or a [CMM](https://github.com/awslabs/aws-encryption-sdk-specification/blob/master/framework/cmm-interface.md)
 
The following inputs to this behavior MUST be OPTIONAL:

- Algorithm Suite
- Encryption Context

### DynamoDB Item

The DynamoDB Item is the plaintext item to be encrypted by this behavior.

This item MUST include an Attribute with a name that matches the
[DynamoDB Partition Key Name](./ddb-item-encryptor.md#dynamodb-partition-key-name)
configured on the [DynamoDB Item Encryptor](./ddb-item-encryptor.md).
Otherwise this operation MUST yield an error.

If the [DynamoDB Item Encryptor](./ddb-item-encryptor.md)
has a [DynamoDB Sort Key Name](./ddb-item-encryptor.md#dynamodb-sort-key-name) configured,
this item MUST include an Attribute with that name.
Otherwise this operation MUST yield an error.

### Attribute Actions

Attribute Actions is a map of attribute names to
[Crypto Actions](../structured-encryption/structures.md#crypto-action)
that describes what Crypto Action MUST apply to a particular attribute during this behavior.

Attributes Actions MUST specify a Crypto Action
for every attribute in the [input DynamoDB Item](#dynamodb-item).
Attribute Actions MAY specify a Crypto Action for an attribute not
in the input DynamoDB Item, in which case that Crypto Action does
not have any effect on the behavior.

The [Crypto Action](../structured-encryption/structures.md#crypto-action) configured
to the partition attribute and sort attribute (if present)
MUST be [SIGN_ONLY](../structured-encryption/structures.md#signonly).

### CMM

A CMM that implements the [CMM interface](https://github.com/awslabs/aws-encryption-sdk-specification/blob/master/framework/cmm-interface.md).

### Keyring

A Keyring that implements the [keyring interface](https://github.com/awslabs/aws-encryption-sdk-specification/blob/master/framework/keyring-interface.md).

### Algorithm Suite

The [algorithm suite](https://github.com/awslabs/aws-encryption-sdk-specification/blob/master/framework/algorithm-suites.md) that SHOULD be used for encryption.

This algorithm suite MUST be a [Structured Encryption Library Supported algorithm suite](#TODO-mpl-alg-suites).

### Encryption Context

See [encryption context](https://github.com/awslabs/aws-encryption-sdk-specification/blob/master/framework/structures.md#encryption-context).
TODO: Make above MPL definition more generic.

TODO: This should move into the MPL definition of Encryption Context
The prefix `aws-crypto-` is reserved for internal use by the AWS Encryption SDK;
see the [the Default CMM spec](default-cmm.md) for one such use.

If the input encryption context contains any entries with a key beginning with this prefix,
the encryption operation MUST yield an error.

## Output

### Encrypted DynamoDB Item

The Encrypted DynamoDB Item is a DynamoBD Item that is
the encrypted form of the [input DynamoDB Item](#dynamodb-item).

## Behavior

All inputs MUST adhere to their requirements;
otherwise this operation MUST immediately yield an error.

This behavior REQUIRES a [Structured Data](../structured-encryption/structures.md#structured-data)
which is [converted](./ddb-item-conversion.md) from the [input DynamoDB Item](#dynamodb-item).

Given the converted [Structured Data](../structured-encryption/structures.md#structured-data),
this operation MUST delegate encryption of this data to
Structured Encryption Client's [Encrypt Structure](../structured-encryption/encrypt-structure.md),
with the following inputs:
- Structured Data MUST be the Structured Data converted above.
- Crypto Schema MUST be a [Crypto Schema](../structured-encryption/structures.md#crypto-schema)
  analogous to the [input Attribute Actions](#attribute-actions).
  More specifically:
  - For every attribute on the input Item,
    there MUST exist a Crypto Action in the Crypto Schema
    such that the Crypto Action indexed by that attribute name in the Crypto Schema
    equals the Crypto Action indexed by that attribute name in the input Attribute Actions.
  - The Crypto Schema MUST NOT contain more Crypto Actions than those specified by the previous point.
- If specified on input, the Algorithm Suite MUST be the [input ALgorithm Suite](#algorithm-suite).
  If not specified on input, Algorithm Suite MUST NOT be specified.
- Encryption Context MUST have the following requirements:
  - includes all key-value pairs in the [input Encryption Context](#encryption-context).
  - includes all key-values pairs in this input Item's [DynamoDB Item Base Context](#dynamodb-item-base-context).
  - does not include any key-value pair not specified above.
  - TODO: Instead of DDB Table Name, do we want an option to use the Table ARN?
- TODO: CMM depends on MPL changes that should be spec'd out first
  (specifically configuring EC keys that are required on Decrypt)

The output to this behavior is the [conversion](./ddb-item-conversion.md)
of the Encrypted Structured Data determined above
into the [Encrypted DynamoDB Item](#encrypted-dynamodb-item).

### DynamoDB Item Base Context

A DynamoDB Item Base Context is a map of string key-values pairs
that contains information related to a particular DynamoDB Item.
The DynamoDB Item Base Context MUST contain:
  - the key `TODO:aws-crypto-table-name` with a value equal to the DynamoDB Table Name of the DynamoDB Table
    this item is stored in (or will be stored in).
  - the key `TODO:aws-crypto-partition-name` with a value equal to the name of the Partition Key on this item.
  - the key `TODO:aws-crypto-partition-value` with a value equal to this item's partition attribute,
    serialized according to [Attribute Value Serialization](./ddb-attribute-serialization.md#attribute-value-serialization)
    and [Base 64 encoded](https://www.rfc-editor.org/rfc/rfc4648).
  - If this item has a sort key attribute,
    the key `TODO:aws-crypto-sort-name` with a value equal to the [DynamoDB Sort Key Name](#dynamodb-sort-key-name).
  - If this item has a sort key attribute,
    the key `TODO:aws-crypto-sort-value` with a value equal to this item's sort attribute,
    serialized according to [Attribute Value Serialization](./ddb-attribute-serialization.md#attribute-value-serialization)
    and [Base 64 encoded](https://www.rfc-editor.org/rfc/rfc4648).
  - TODO: Instead of DDB Table Name, do we want an option to use the Table ARN in the EC?

If this item does not have a sort key attribute,
the DynamoDB Item Context MUST NOT contain the keys
`TODO:aws-crypto-sort-name` or
`TODO:aws-crypto-sort-value`.
