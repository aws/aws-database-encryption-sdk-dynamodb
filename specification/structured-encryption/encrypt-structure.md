[//]: # "Copyright Amazon.com Inc. or its affiliates. All Rights Reserved."
[//]: # "SPDX-License-Identifier: CC-BY-SA-4.0"

# Encrypt Structure

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

This document describes the behavior by which a [Structured Data](./structures.md#structured-data) is encrypted.
We define encryption over this [Structured Data](./structures.md#structured-data) to mean that
authenticity is ensured over a non-empty set of [Terminal Data](./structures.md#terminal-data),
and confidentiality is ensured over a (possibly empty) subset of that Terminal Data.

## Input

The following inputs to this behavior are REQUIRED:

- [Table Name](#table-name)
- [Structured Data](#structured-data)
- [Crypto Schema](#crypto-schema)
- [Cryptographic Materials Manager (CMM)](#cmm)

The following inputs to this behavior MUST be OPTIONAL:

- [Algorithm Suite](#algorithm-suite)
- [Encryption Context](#encryption-context)

## Output

This operation MUST output the following:
- [Encrypted Structured Data](#encrypted-structured-data)
- [Crypto Schema](./header.md#encrypt-legend): The Crypto Schema for each signed Terminal
- [Parsed Header](./decrypt-structure.md#parsed-header)


## Behavior

The input [Structured Data](#structured-data) and [Crypto Schema](#crypto-schema)
MUST refer to the same set of locations.

The input [Structured Data](#structured-data) and [Crypto Schema](#crypto-schema)
MUST be combined into a single [Crypto List](#crypto-list).

Encrypt Structure MUST then behave as [Encrypt Path Structure](#encrypt-path-structure)

The output [Crypto List](#crypto-list) produced by [Encrypt Path Structure](#decrypt-path-structure)
MUST be split into [Structured Data](#structured-data) and [Crypto Schema](#crypto-schema)
maps.