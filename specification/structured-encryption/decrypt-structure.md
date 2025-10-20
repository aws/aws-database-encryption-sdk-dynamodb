[//]: # "Copyright Amazon.com Inc. or its affiliates. All Rights Reserved."
[//]: # "SPDX-License-Identifier: CC-BY-SA-4.0"

# Decrypt Structure

## Version

1.1.0

### Changelog

- 1.1.0
  - Update for simplified structured encryption

- 1.0.0
  - Initial record

## Definitions

### Conventions used in this document

The key words "MUST", "MUST NOT", "REQUIRED", "SHALL", "SHALL NOT", "SHOULD", "SHOULD NOT", "RECOMMENDED", "MAY", and "OPTIONAL"
in this document are to be interpreted as described in [RFC 2119](https://tools.ietf.org/html/rfc2119).

## Overview

This document describes the behavior by which a [Structured Data](./structures.md#structured-data)
which has been [encrypted](./encrypt-structure.md) is decrypted.
We define decryption over this [Structured Data](./structures.md#structured-data) to mean that
we obtain back the original Structured Data,
and ensure integrity and authenticity is ensured over a set of [Terminal Data](./structures.md#terminal-data).

## Input

The following inputs to this behavior are REQUIRED:

- [Table Name](decrypt-path-structure.md#table-name)
- [Authenticate Schema](decrypt-path-structure.md#authenticate-schema)
- [Cryptographic Materials Manager (CMM)](decrypt-path-structure.md#cmm)
- [Encrypted Structured Data](decrypt-path-structure.md#encrypted-structured-data)

The following inputs to this behavior MUST be OPTIONAL:

- [Encryption Context](decrypt-path-structure.md#encryption-context)

## Output

This operation MUST output the following:

- [Structured Data](decrypt-path-structure.md#structured-data)
- [Crypto Schema](./structures.md#crypto-schema): The Crypto Schema for each signed Terminal,
  calculated using the Crypto Legend in the header, the signature scope used for decryption, and the data in the input structure.
- [Parsed Header](decrypt-path-structure.md#parsed-header)

## Behavior

The input [Structured Data](decrypt-path-structure.md#structured-data) and [Authenticate Schema](decrypt-path-structure.md#authenticate-schema)
MUST refer to the same set of locations.

The input [Structured Data](decrypt-path-structure.md#structured-data) and [Authenticate Schema](decrypt-path-structure.md#authenticate-schema)
MUST be combined into a single [Auth List](decrypt-path-structure.md#auth-list).

Decrypt Structure MUST then behave as [Decrypt Path Structure](decrypt-path-structure.md)

The output [Crypto List](decrypt-path-structure.md#crypto-list) produced by [Decrypt Path Structure](decrypt-path-structure.md)
MUST be split into [Structured Data](decrypt-path-structure.md#structured-data) and [Crypto Schema](decrypt-path-structure.md#crypto-schema)
maps.
