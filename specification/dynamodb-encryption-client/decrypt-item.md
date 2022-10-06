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
- Either a [Keyring](https://github.com/awslabs/aws-encryption-sdk-specification/blob/master/framework/keyring-interface.md)
  or a [CMM](https://github.com/awslabs/aws-encryption-sdk-specification/blob/master/framework/cmm-interface.md)
 
The following input to this behavior MUST be OPTIONAL:

- Encryption Context

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

### CMM

A CMM that implements the [CMM interface](https://github.com/awslabs/aws-encryption-sdk-specification/blob/master/framework/cmm-interface.md).

### Keyring

A Keyring that implements the [keyring interface](https://github.com/awslabs/aws-encryption-sdk-specification/blob/master/framework/keyring-interface.md).

### Encryption Context

See [encryption context](https://github.com/awslabs/aws-encryption-sdk-specification/blob/master/framework/structures.md#encryption-context).
TODO: Make above MPL definition more generic.

TODO: This should move into the MPL definition of Encryption Context
The prefix `aws-crypto-` is reserved for internal use by the AWS Encryption SDK;
see the [the Default CMM spec](default-cmm.md) for one such use.

If the input encryption context contains any entries with a key beginning with this prefix,
the encryption operation MUST yield an error.

## Output

### DynamoDB Item

The DynamoDB Item is the decryption of the [input DynamoBD Item](#dynamodb-item).

## Behavior

All inputs MUST adhere to their requirements;
otherwise this operation MUST immediately yield an error.

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
- Encryption Context MUST have the following requirements:
  - includes all key-value pairs in the [input Encryption Context](#encryption-context).
  - includes the key `TODO:aws-crypto-table-name` with a value equal to the [DynamoDB Table Key Name](#dynamodb-sort-key-name). 
  - includes the key `TODO:aws-crypto-partition-name` with a value equal to the [DynamoDB Partition Key Name](#dynamodb-partition-key-name). 
  - includes the key `TODO:aws-crypto-sort-name` with a value equal to the [DynamoDB Sort Key Name](#dynamodb-sort-key-name). 
  - does not include any key-value pair not specified above.
- CMM MUST be the [input CMM](#cmm), if supplied.
  Otherwise, this MUST be a
  [default CMM](https://github.com/awslabs/aws-encryption-sdk-specification/blob/master/framework/default-cmm.md)
  constructed using the [caller-supplied keyring](#keyring) as input.

The output to this behavior is the [conversion](./ddb-item-conversion.md)
of the decrypted Structured Data determined above
into the [output DynamoDB Item](#encrypted-dynamodb-item).

### Signature Scope

An Attribute on a DynamoDB Item MUST NOT be considered as within the signature scope
if it's Attribute Name is included in [Unauthenticated Attributes](./ddb-item-encryptor.md#unauthenticated-attributes)
or if it's Attribute Name begins with the prefix specified in
[Unauthenticated Attribute Prefix](./ddb-item-encryptor.md#unauthenticated-attribute-prefix).
Otherwise, Attributes MUST be considered as within the signature scope.
