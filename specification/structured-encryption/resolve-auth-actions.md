[//]: # "Copyright Amazon.com Inc. or its affiliates. All Rights Reserved."
[//]: # "SPDX-License-Identifier: CC-BY-SA-4.0"

# Resolve Auth Actions

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

ResolveAuthActions takes an encrypted record and determines the CryptoActions originally used for encryption.

It makes no network calls and does no encryption nor decryption.

## Input

The following inputs to this behavior are REQUIRED:

- [Table Name](#table-name)
- [Auth List](#auth-list)
- [Header Bytes](#header-bytes)

### Table Name

The logical name for the structure.
This can be the same as the physical name.
For example the name of the table to hold the encrypted record.

### Auth List

The [Auth List](./structures.md#auth-list) describes how each [Terminal Data](./structures.md#terminal-data) would be treated during decryption.

The header and footer fields (aws_dbe_head and aws_dbe_foot) can be present, but they need not be present.

Data members need not contain any particular values.

### Header Bytes

The sequence of bytes representing the serialized header, as is usually found in the `aws_dbe_head` attribute.

## Output

This operation MUST output the following:

[Crypto List](./structures.md#crypto-list): Input terminal data and the Crypto Schema for each Terminal,
calculated using the Crypto Legend in the header, the signature scope used for decryption, and the data in the input structure.

## Behavior

Resolve Auth Actions examines the configuration and the provided header to determine
the [Crypto Actions](structures.md#crypto-action) originally use for encryption.

The data members are returned unchanged and unexamined.
