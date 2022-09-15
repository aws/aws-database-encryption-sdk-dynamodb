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
confidentiality is ensured over a set of [Terminal Values](./structures.md#terminal-data) within that structure,
and integrity and authenticity is ensured over a larger set of of [Terminal Data](./structures.md#terminal-data).

## Input

The following inputs to this behavior are REQUIRED:

- [Structured Data](#structured-data)
- [Crypto Schema](#crypto-schema)
- Either a [Cryptographic Materials Manager (CMM)](#cmm) or a [Keyring](#keyring)

The following inputs to this behavior MUST be OPTIONAL:

- [Algorithm Suite](#algorithm-suite)
- [Encryption Context](#encryption-context)
- [Required Context Fields On Decrypt](#required-context-fields-on-decrypt)

### Structured Data

The [Structured Data](./structures.md#structured-data) to be encrypted.

### Crypto Schema

The [Crypto Schema](./structures.md#crypto-schema) that describes how [Terminal Data](./structures.md#terminal-data)
within the [input Structured Data](#structured-data) should be treated during encryption.

The Crypto Schema MUST explicitly configure a [Crypto Action](./structures.md#crypto-action) to every
[Terminal Data](./structures.md#terminal-data) that exists on the [input Structured Data](#structured-data),
and MUST NOT describe Crypto Actions for locations within the input Structured Data that either
do not exist, or contain non-Terminal Data structures.
Otherwise, this operation operation MUST fail.

### CMM

A CMM that implements the [CMM interface](https://github.com/awslabs/aws-encryption-sdk-specification/blob/master/framework/cmm-interface.md).

### Keyring

A Keyring that implements the [keyring interface](https://github.com/awslabs/aws-encryption-sdk-specification/blob/master/framework/keyring-interface.md).

### Algorithm Suite

The [algorithm suite](https://github.com/awslabs/aws-encryption-sdk-specification/blob/master/framework/algorithm-suites.md) that SHOULD be used for encryption.

This algorithm suite MUST be a [Structured Encryption Library Supported algorithm suite](#TODO).

### Encryption Context

See [encryption context](./structures.md#encryption-context).

The prefix `aws-crypto-` is reserved for internal use by the AWS Encryption SDK;
see the [the Default CMM spec](default-cmm.md) for one such use.

If the input encryption context contains any entries with a key beginning with this prefix,
the encryption operation MUST fail.

### Required Context Fields On Decrypt

A list of strings that indicates which fields within the [input encryption context](#encryption-context)
will not be included as metadata within the [output Encrypted Structured Data](#encrypted-structured-data)
and MUST be supplied during [Decrypt Structure](./decrypt-structure.md) in order for decryption of the
output Encrypted Structured Data to succeed.

Every item in this list MUST exist as a key in the [input encryption context](#encryption-context).
Otherwise, this operation MUST fail.

## Outputs

### Encrypted Structured Data

An encrypted form of the [input Structured Data](#structured-data),
encrypted according to the [behavior specified below](#behavior).

## Behavior


