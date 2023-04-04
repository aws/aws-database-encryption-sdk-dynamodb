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
the encryption and decryption of [DynamoDB Items](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/WorkingWithItems.html)
for a particular DynamoDB Table.
The DynamoDB Item Encryptor is publicly exposed and
is used to directly encrypt or decrypt
DynamoDB Items outside of DynamoDB API calls.

## Initialization

On initialization of the DynamoDB Item Encryptor,
the caller MUST provide all REQUIRED fields specified in
[dynamodb encryption table config](./ddb-encryption-table-config.md).
and the caller MAY provide any OPTIONAL field specified in
[dynamodb encryption table config](./ddb-encryption-table-config.md).

## Operation

### EncryptItem

The DynamoDB Item Encryptor MUST provide a function that adheres to [EncryptItem](./encrypt-item.md).

### DecryptItem

The DynamoDB Item Encryptor MUST provide a function that adheres to [DecryptItem](./decrypt-item.md).
