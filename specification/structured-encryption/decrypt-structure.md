[//]: # "Copyright Amazon.com Inc. or its affiliates. All Rights Reserved."
[//]: # "SPDX-License-Identifier: CC-BY-SA-4.0"

# Decrypt Structure

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

This document describes the behavior by which a [Structured Data](./structures.md#structured-data)
which has been [encrypted](./encrypt-structure.md) is decrypted.
We define decryption over this [Structured Data](./structures.md#structured-data) to mean that
we obtain back the original Structured Data,
and ensure integrity and authenticity is ensured over a set of [Terminal Data](./structures.md#terminal-data).

## Input

The following inputs to this behavior are REQUIRED:

- [Table Name](#table-name)
- [Authenticate Schema](#authenticate-schema)
- [Cryptographic Materials Manager (CMM)](#cmm)
- [Encrypted Structured Data](#encrypted-structured-data)

The following inputs to this behavior MUST be OPTIONAL:

- [Encryption Context](#encryption-context)

## Output

This operation MUST output the following:

- [Structured Data](#structured-data)
- [Crypto Schema](./structures.md#crypto-schema): The Crypto Schema for each signed Terminal,
  calculated using the Crypto Legend in the header, the signature scope used for decryption, and the data in the input structure.
- [Parsed Header](#parsed-header)

## Behavior

The input [Structured Data](#structured-data) and [Authenticate Schema](#authenticate-schema)
MUST refer to the same set of locations.

The input [Structured Data](#structured-data) and [Authenticate Schema](#authenticate-schema)
MUST be combined into a single [Auth List](#auth-list).

Decrypt Structure MUST then behave as [Decrypt Path Structure](#decrypt-path-structure)

The output [Crypto List](#crypto-list) produced by [Decrypt Path Structure](#decrypt-path-structure)
MUST be split into [Structured Data](#structured-data) and [Crypto Schema](#crypto-schema)
maps.
