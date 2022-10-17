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

On initialization, the caller MAY provide:

- [DynamoDB Sort Key Name](#dynamodb-sort-key-name)
- [Unauthenticated Attributes](#unauthenticated-attributes)
- [Unauthenticated Attribute Name Prefix](#unauthenticated-attribute-prefix)
- TODO legacy behavior
- TODO allow plaintext behavior

### DynamoDB Table Name

The name of the DyamoDB Table where the
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

## Operation

### EncryptItem

The DynamoDB Item Encryptor MUST provide a function that adheres to [EncryptItem](./encrypt-item.md).

### DecryptItem

The DynamoDB Item Encryptor MUST provide a function that adheres to [DecryptItem](./decrypt-item.md).
