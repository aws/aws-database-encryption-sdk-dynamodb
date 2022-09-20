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
and ensure integrity and authenticity is ensured over a set of of [Terminal Data](./structures.md#terminal-data).

## Input

The following inputs to this behavior are REQUIRED:

- [Encrypted Structured Data](#encrypted-structured-data)
- Either a [Cryptographic Materials Manager (CMM)](#cmm) or a [Keyring](#keyring)

The following inputs to this behavior MUST be OPTIONAL:

- [Encryption Context](#encryption-context)


### Encrypted Structured Data

The [Structured Data](./structures.md#structured-data) to be decrypted.

### CMM

A CMM that implements the [CMM interface](https://github.com/awslabs/aws-encryption-sdk-specification/blob/master/framework/cmm-interface.md).

### Keyring

A Keyring that implements the [keyring interface](https://github.com/awslabs/aws-encryption-sdk-specification/blob/master/framework/keyring-interface.md).

### Encryption Context

See [encryption context](./structures.md#encryption-context).

If encryption of the original Structured Data included a non-empty [Required Context Fields On Decrypt](./encrypt-structure.md#required-context-fields-on-decrypt),
then those fields and their corresponding values supplied in the [Encryption Context](./encrypt-structure.md#encryption-context)
MUST be included in this input in order for Decryption to succeed.

This input MAY include field-value pairs which were included in the input Encryption Context during encryption,
but not included in [Required Context Fields On Decrypt](./encrypt-structure.md#required-context-fields-on-decrypt).

This input MUST NOT include field-value pairs which were not originally supplied in the [Encryption Context] during encryption(./encrypt-structure.md#encryption-context),
otherwise decryption MUST fail.

## Output

### Structured Data

The decrypted form of the [input Encrypted Structured Data](#encrypted-structured-data),
decrypted according to the [behavior specified below](#behavior).

### Parsed Header

A structure containing information derived from the header of the [output Encrypted Structured Data](#encrypted-structured-data).
This structure MUST include:
- The [Message Format Version](#TODO-truss-header)
- The [Message ID](#TODO-truss-header)
- The [Algorithm Suite](#TODO-truss-header)
- The [Crypto Schema](#TODO-truss-header)
- The stored [Encryption Context](#TODO-truss-header)
- The [Encrypted Data Keys](#TODO-truss-header)

## Behavior

All inputs MUST adhere to their requirements;
otherwise this operation MUST immediately yield an error.

The Decrypt Structure operation is divided into several distinct steps:

- [Retrieve Decryption Materials](#retrieve-decryption-materials)
- [Verify Signatures](#verify-signatures)
- [Construct Decrypted Structured Data](#construct-decrypted-structured-data)

This operation MUST perform all the above steps unless otherwise specified,
and it MUST perform them in the above order.

If any of these steps fails, this operation MUST halt and indicate a failure to the caller.

### Retrieve Decryption Materials

TODO

### Verify Signatures

TODO

### Construct Decrypted Structured Data

TODO
