[//]: # "Copyright Amazon.com Inc. or its affiliates. All Rights Reserved."
[//]: # "SPDX-License-Identifier: CC-BY-SA-4.0"

# DynamoDB Item Encryptor

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

This document describes the behavior for the
DynamoDB Item Encryptor.
It is responsible for
the encryption and decryption of [DynamoDB Items](#TODO-link-to-docs)
for a particular DynamoDB Table.
The DynamoDB Item Encryptor is publicly exposed and
is used to directly encrypt or decrypt
DynamoDB Items outside of DynamoDB API calls.

## Initialization

On initialization of the DynamoDB Item Encryptor, the caller MUST provide:

- [DynamoDB Table Name](#dynamodb-table-name)
- [DynamoDB Partition Key Name](#dynamodb-partition-key-name)
- [Attribute Actions](#attribute-actions)
- A [CMM](#cmm) or [Keyring](#keyring)

On initialization, the caller MAY provide:

- [DynamoDB Sort Key Name](#dynamodb-sort-key-name)
- [Unauthenticated Attributes](#unauthenticated-attributes)
- [Unauthenticated Attribute Name Prefix](#unauthenticated-attribute-prefix)
- [Algorithm Suite](#algorithm-suite)
- TODO legacy behavior
- TODO allow plaintext behavior

### DynamoDB Table Name

The name of the DynamoDB Table where the
DynamoDB Items to be decrypted or encrypted
are stored or intended to be stored.

This name MUST be a UTF-8 encoded string.

### DynamoDB Partition Key Name

The DynamoDB Partition Key Name is the attribute name of the partiton key of the DynamoDB Table
identified by the [input DynamoDB Table Name](#dynamodb-table-name).

This name MUST be a UTF-8 encoded string.

### DynamoDB Sort Key Name

The DynamoDB Sort Key Name is the attribute name of the sort key
of the DynamoDB Table identified by the [input DynamoDB Table Name](#dynamodb-table-name).

This name MUST be a UTF-8 encoded string.

### Attribute Actions

Attribute Actions is a map of attribute names to
[Crypto Actions](../structured-encryption/structures.md#crypto-action)
that describes what Crypto Action MUST apply to a particular attribute 
(if it exists) during encryption.

The [SIGN_ONLY](../structured-encryption/structures.md#signonly) Crypto Action
MUST be configured to the partition attribute and, if present, sort attribute.

### CMM

A CMM that implements the [CMM interface](https://github.com/awslabs/aws-encryption-sdk-specification/blob/master/framework/cmm-interface.md)
that is responsible for obtaining materials for encryption and decryption.

If not supplied during initialization,
the CMM considered "configured" to this
Item Encryptor MUST be a
[default CMM](https://github.com/awslabs/aws-encryption-sdk-specification/blob/master/framework/default-cmm.md)
constructed using the [supplied keyring](#keyring) as input.

### Keyring

A Keyring that implements the [keyring interface](https://github.com/awslabs/aws-encryption-sdk-specification/blob/master/framework/keyring-interface.md).

### Unauthenticated Attributes

Unauthenticated Attributes MUST be a set of Attribute Names.
With [Unauthenticated Attribute Prefix](#unauthenticated-attribute-prefix),
This identifies Attributes within this table
that are not authenticated during decryption.

### Unauthenticated Attribute Prefix

Unauthenticated Attribute Prefix MUST be a string.
With [Unauthenticated Attributes](#unauthenticated-attributes),
This identifies Attributes within this table
that are not authenticated during decryption.

### Algorithm Suite

The [algorithm suite](https://github.com/awslabs/aws-encryption-sdk-specification/blob/master/framework/algorithm-suites.md) that SHOULD be used for encryption.

This algorithm suite MUST be a [Structured Encryption Library Supported algorithm suite](#TODO-mpl-alg-suites).

## Operation

### EncryptItem

The DynamoDB Item Encryptor MUST provide a function that adheres to [EncryptItem](./encrypt-item.md).

### DecryptItem

The DynamoDB Item Encryptor MUST provide a function that adheres to [DecryptItem](./decrypt-item.md).
