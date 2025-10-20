[//]: # "Copyright Amazon.com Inc. or its affiliates. All Rights Reserved."
[//]: # "SPDX-License-Identifier: CC-BY-SA-4.0"

# Encrypt Structure

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

This document describes the behavior by which a [Structured Data](./structures.md#structured-data) is encrypted.
We define encryption over this [Structured Data](./structures.md#structured-data) to mean that
authenticity is ensured over a non-empty set of [Terminal Data](./structures.md#terminal-data),
and confidentiality is ensured over a (possibly empty) subset of that Terminal Data.

## Input

The following inputs to this behavior are REQUIRED:

- [Table Name](encrypt-path-structure.md#table-name)
- [Structured Data](encrypt-path-structure.md#structured-data)
- [Crypto Schema](encrypt-path-structure.md#crypto-schema)
- [Cryptographic Materials Manager (CMM)](encrypt-path-structure.md#cmm)

The following inputs to this behavior MUST be OPTIONAL:

- [Algorithm Suite](encrypt-path-structure.md#algorithm-suite)
- [Encryption Context](encrypt-path-structure.md#encryption-context)

## Output

This operation MUST output the following:

- [Encrypted Structured Data](encrypt-path-structure.md#encrypted-structured-data)
- [Crypto Schema](./structures.md#crypto-schema): The Crypto Schema for each signed Terminal
- [Parsed Header](./decrypt-structure.md#parsed-header)

## Behavior

The input [Structured Data](encrypt-path-structure.md#structured-data) and [Crypto Schema](encrypt-path-structure.md#crypto-schema)
MUST refer to the same set of locations.

The input [Structured Data](encrypt-path-structure.md#structured-data) and [Crypto Schema](encrypt-path-structure.md#crypto-schema)
MUST be combined into a single [Crypto List](encrypt-path-structure.md#crypto-list).

Encrypt Structure MUST then behave as [Encrypt Path Structure](encrypt-path-structure.md)

The output [Crypto List](encrypt-path-structure.md#crypto-list) produced by [Encrypt Path Structure](encrypt-path-structure.md)
MUST be split into [Structured Data](encrypt-path-structure.md#structured-data) and [Crypto Schema](encrypt-path-structure.md#crypto-schema)
maps.
