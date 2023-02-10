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

- [Structured Data](#structured-data)
- [Crypto Schema](#crypto-schema)
- [Cryptographic Materials Manager (CMM)](#cmm)

The following inputs to this behavior MUST be OPTIONAL:

- [Algorithm Suite](#algorithm-suite)
- [Encryption Context](#encryption-context)

### Structured Data

The [Structured Data](./structures.md#structured-data) to be encrypted.

This Structured Data MUST be a [Structured Data Map](./structures.md#structured-data-map).
This Structured Data MUST NOT already contain the reserved [header](./header.md) and [footer](./footer.md) fields
as keys in it's map. (TODO decide the exact header/footer field names)

### Crypto Schema

The [Crypto Schema](./structures.md#crypto-schema) that describes how [Terminal Data](./structures.md#terminal-data)
within the [input Structured Data](#structured-data) should be treated during encryption.

The Crypto Schema MUST explicitly configure a [Crypto Action](./structures.md#crypto-action) for every
[Terminal Data](./structures.md#terminal-data) that exists on the [input Structured Data](#structured-data),
and MUST NOT describe Crypto Actions for locations within the input Structured Data that either
do not exist, or contain non-Terminal Data structures;
otherwise, this operation operation MUST yield an error.

The Crypto Schema MUST include at least one [ENCRYPT_AND_SIGN Crypto Action](./structures.md#encryptandsign) or
[SIGN_ONLY Crypto Action](./structures.md#signonly);
otherwise, this operation MUST yield an error.

### CMM

A CMM that implements the [CMM interface](https://github.com/awslabs/aws-encryption-sdk-specification/blob/master/framework/cmm-interface.md).

### Algorithm Suite

The [algorithm suite](https://github.com/awslabs/aws-encryption-sdk-specification/blob/master/framework/algorithm-suites.md) that SHOULD be used for encryption.

This algorithm suite MUST be a
[supported suite for DDBEC](https://github.com/awslabs/aws-encryption-sdk-specification/blob/master/framework/algorithm-suites.md#supported-algorithm-suites-enum);
otherwise, this operation MUST yield an error.

### Encryption Context

See [encryption context](./structures.md#encryption-context).

The prefix `aws-crypto-` is reserved for internal use by the AWS Encryption SDK;
see the [the Default CMM spec](default-cmm.md) for one such use.

If the input encryption context contains any entries with a key beginning with this prefix,
the encryption operation MUST yield an error.

## Outputs

### Encrypted Structured Data

An encrypted form of the [input Structured Data](#structured-data),
encrypted according to the [behavior specified below](#behavior).

## Behavior

All inputs MUST adhere to their requirements;
otherwise this operation MUST immediately yield an error.

Given valid inputs,
the Encrypt Structure operation is divided into several distinct steps:

1. [Retrieve Encryption Materials](#retrieve-encryption-materials)
1. [Calculate Intermediate Encrypted Structured Data](#construct-encrypted-structured-data)
1. [Construct Encrypted Structured Data](#construct-encrypted-structured-data)

This operation MUST perform all the above steps,
and it MUST perform them in the above order.

If any of these steps fails, this operation MUST halt and indicate a failure to the caller.

### Retrieve Encryption Materials

This operation MUST obtain a set of encryption materials by calling
[Get Encryption Materials](https://github.com/awslabs/aws-encryption-sdk-specification/blob/master/framework/cmm-interface.md#get-encryption-materials)
on the input [CMM](#cmm).

The call to Get Encryption Materials MUST be constructed as follows:
- Encryption Context: If provided, this MUST be the [input encryption context](#encryption-context);
  otherwise, this is an empty encryption context.
- Commitment Policy: This MUST be
  [REQUIRE_ENCRYPT_REQUIRE_DECRYPT](https://github.com/awslabs/aws-encryption-sdk-specification/blob/master/framework/commitment-policy.md#esdkrequire_encrypt_require_decrypt).
- Algorithm Suite: If provided, this is the [input algorithm suite](#algorithm-suite);
  otherwise, this field MUST be the algorithm suite corresponding to the enum 
  [DDBEC.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_ECDSA_P384_SYMSIG_HMAC_SHA384](https://github.com/awslabs/aws-encryption-sdk-specification/blob/master/framework/algorithm-suites.md#supported-algorithm-suites-enum).
- Max Plaintext Length: This field MUST be the result of the calculation `encryptedTerminalDataNum * 2 + totalEncryptedTerminalValuesSize`
  - `encryptedTerminalDataNum` is the number of [Terminal Data](./structures.md#terminal-data)
    in the [input Structured Data](#structured-data) being encrypted,
    as defined by the [input Crypto Schema](#crypto-schema).
  - `totalEncryptedTerminalValuesSize` is the sum of the length of all [Terminal Values](./structures.md#terminal-value)
    in the [input Structured Data](#structured-data) being encrypted,
    as defined by the [input Crypto Schema](#crypto-schema).

The algorithm suite used in all aspects of this operation MUST be
the algorithm suite in the
[encryption materials](https://github.com/awslabs/aws-encryption-sdk-specification/blob/master/framework/structures.md#encryption-materials)
returned from the Get Encryption Materials call.
Note that the algorithm suite in the retrieved encryption materials MAY be different from the input algorithm suite.
If this algorithm suite is not a
[supported suite for DDBEC](https://github.com/awslabs/aws-encryption-sdk-specification/blob/master/framework/algorithm-suites.md#supported-algorithm-suites-enum),
this operation MUST yield an error.

### Calculate Intermediate Encrypted Structured Data

To construct the final Encrypted Structured Data,
a pre-signature version of this Encrypted Structured Data
must first be calculated.
This will be referred to as the Intermediate Encryption Structured Data.

The calculations below REQUIRE generating a unique [Message ID](./header.md#message-id) for this Encrypted Structured Data.
The process used to generate this identifier MUST use a good source of randomness
to make the chance of duplicate identifiers negligible.

The calculations below also REQUIRE a [Field Root Key](#TODO-truss-key-wraping)
that MUST be derived with the following specifics:
- the KDF used to calculate the Field Root Key MUST be the 
  [Encryption Key KDF](https://github.com/awslabs/aws-encryption-sdk-specification/blob/master/framework/algorithm-suites.md#algorithm-suites-encryption-key-derivation-settings)
  indicated by the algorithm suite.
- the key input to the KDF MUST be the plaintext data key in the encryption materials.
- the Message ID used in this calculation MUST be the Message ID generated for this Encrypted Structured Data
- the calculated Field Root Key MUST have length equal to the
  [algorithm suite's encryption key length](https://github.com/awslabs/aws-encryption-sdk-specification/blob/master/framework/algorithm-suites.md#algorithm-suites-encryption-settings).

The calculations below also REQUIRE a [Commitment Key](#TODO-truss-key-wraping)
that MUST be derived with the following specifics:
- the KDF used to calculate the Commitment Key MUST be the
  [Commit Key KDF](https://github.com/awslabs/aws-encryption-sdk-specification/blob/master/framework/algorithm-suites.md#algorithm-suites-commit-key-derivation-settings)
  indicated by the algorithm suite.
- the key input to the KDF MUST be the plaintext data key in the encryption materials.
- the Message ID used in the Commitment Key derivation MUST be the Message ID generated for this Encrypted Structured Data
- the calculated Commitment Key MUST have length equal to the
  [algorithm suite's encryption key length](https://github.com/awslabs/aws-encryption-sdk-specification/blob/master/framework/algorithm-suites.md#algorithm-suites-encryption-settings).

The Intermediate Encryption Structured Data MUST be calculated with the following specifics:
- for every [input Terminal Data](./structures.md#terminal-data) in the [input Structured Data](#structured-data),
  a Terminal Data MUST exist with the same [canonical path](./header.md#canoncial-path) in Intermediate Encrypted Structured Data.
  Each of these Terminal Data in the Intermediate Encrypted Structured Data MUST:
  - if the [Crypto Schema](#crypto-schema) indicates a [Crypto Action](./structures.md#crypto-action)
    of [SIGN_ONLY](./structures.md#signonly) or [DO_NOTHING](./structures.md#DO_NOTHING) for this Terminal Data,
    this Terminal Data MUST have [Terminal Type ID](./structures.md#terminal-type-id) and
    [Terminal Value](./structures.md#terminal-value) equal to the input Terminal Data's.
  - if the [Crypto Schema](#crypto-schema) indicates a [Crypto Action](./structures.md#crypto-action)
    of [ENCRYPT_AND_SIGN](./structures.md#encryptandsign) for this Terminal Data,
    this Terminal Data MUST be the [encryption](#terminal-data-encryption) of the input's Terminal Data.
    of the input Terminal Data.
- for every [Terminal Data](./structures.md#terminal-data) in the Intermediate Encrypted Structured Data
  (except for the [header](./header.md)),
  a Terminal Data MUST exist with the same [canonical path](./header.md#canoncial-path) in the [input Structured Data](#structured-data),
- a [Terminal Data](./structures.md#terminal-data) with [Terminal Type ID](./structures.md#terminal-type-id) `0xFFFF` and
  with [Terminal Value](./structures.md#terminal-value) equal to the [serialized header](./header.md)
  MUST exist on the Intermediate Encrypted Structured Data, indexed at the top level by `aws:truss-header`.
  The values of this header have the following requirements:
  - Message Format Version MUST be `0x01`
  - Message Format Flavor MUST [correspond to the algorithm suite](./header.md#format-flavor) used in this encryption.
  - Message ID: MUST be the Message ID generated for this Encrypted Structured Data.
  - Encrypt Legend: MUST be the [encrypt legend](./header.md#encrypt-legend) that corresponds to the [input Crypto Schema](#crypto-schema).
  - Encryption Context: MUST be the [encryption context](./structures.md#encryption-context) in the encryption materials.
  - Encrypted Data Keys: MUST be the [serialization of the encrypted data keys](./header.md#encrypted-data-keys)
    in the encryption materials.
  - Header Commitment: MUST be the [calculated](./header.md#header-commitment) using the commitment key calculated above.

#### Terminal Data Encryption

Encryption of [Terminal Data](./structures.md#terminal-data) takes a
Terminal Data as input, and returns an encrypted Terminal Data.

The output encrypted Terminal Data MUST have a [Terminal Type Id](./structures.md#terminal-type-id)
equal `0xFFFF`.

The output encrypted Terminal Data MUST have a [Terminal Value](./structures.md#terminal-value)
with the following serialization:

| Field                      | Length   |
| -------------------------- | -------- |
| Terminal Type Id           | 2        |
| Encrypted Terminal Value   | Variable |

##### Terminal Type Id

Terminal Type Id MUST equal the input Terminal Data's Terminal Type Id.

##### Encrypted Terminal Value

The Encrypted Terminal Value MUST derived according to the following encryption:
- The encryption algorithm used is the
  [encryption algorithm](https://github.com/awslabs/aws-encryption-sdk-specification/blob/master/framework/algorithm-suites.md#algorithm-suites-encryption-settings)
  indicated in the algorithm suite.
- The AAD is the [canonical path](#TODO-truss-canonical-path) for this Terminal Data
- The Nonce is [derived according to the field encryption key derivation scheme](#TODO), using the FieldRootKey as input.
- The Cipherkey is [derived according to the field encryption key derivation scheme](#TODO), using the FieldRootKey as input.
- The plaintext is the [Terminal Value](./structures.md#terminal-value) for this Terminal Data.

### Construct Encrypted Structured Data

Given an Intermediate Encrypted Structured Data,
the signatures over this Structured Data may be calculated,
and the final Encrypted Structured Data outputted.

The calculations below REQUIRE determining a [canonical hash](#TODO-truss-signature-canonicalization)
of the [Structured Data](#structured-data), with the following specifics:
- The header bytes are the [Terminal Value](./structures.md#terminal-value) of the
  [Terminal Data](./structures.md#terminal-data) at string index "aws:truss-header" in the
  [Intermediate Structured Data](#calculate-intermediate-encrypted-structured-data).
- The fields are the set of [Terminal Data](./structures.md#terminal-data)
  on the [Intermediate Structured Data](#calculate-intermediate-encrypted-structured-data)
  that the [Crypto Schema](#crypto-schema) indicates is
  [ENCRYPT_AND_SIGN](./structures.md#encryptandsign) or [SIGN_ONLY](./structures.md#signonly).
- The AAD is the [serialization of the Encryption Context](./header.md#encryption-context)
  in the encryption materials.

The Encrypted Structured Data outputted by this operation MUST be a Structured Data such that:
- for every [Terminal Data](./structures.md#terminal-data) in the
  [Intermediate Structured Data](#calculate-intermediate-encrypted-structured-data),
  a Terminal Data MUST exist with the same [canonical path](./header.md#canoncial-path) in the final Encrypted Structured Data.
- for every [Terminal Data](./structures.md#terminal-data) in the final Encrypted Structured Data
  (except for the [footer](./footer.md)),
  a Terminal Data MUST exist with the same [canonical path](./header.md#canoncial-path) in the
  [Intermediate Structured Data](#calculate-intermediate-encrypted-structured-data),
- a [Terminal Data](./structures.md#terminal-data) with [Terminal Type ID](./structures.md#terminal-type-id) `0xFFFF` and
  with [Terminal Value](./structures.md#terminal-value) equal to the [serialized footer](./header.md)
  MUST exist on the Encrypted Structured Data, indexed at the top level by `aws:truss-footer`.
  The values of this footer have the following requirements:
  - the HMACs MUST be calculated using the
    [symmetric signature algorithm](https://github.com/awslabs/aws-encryption-sdk-specification/blob/master/framework/algorithm-suites.md#algorithm-suites-signature-settings)
    indicated in the algorithm suite.
  - the HMAC values MUST be calculated over the [canonical hash](#TODO-truss-signature-canonicalization),
    using the
    [symmetric signing keys](https://github.com/awslabs/aws-encryption-sdk-specification/blob/master/framework/structures.md#symmetric-signing-keys)
    in the encryption materials.
  - the HMAC values MUST have the same order as the
    [symmetric signing keys](https://github.com/awslabs/aws-encryption-sdk-specification/blob/master/framework/structures.md#symmetric-signing-keys)
    used to calculate them.
  - the footer MUST contain an asymmetric signature if the algorithm suite includes asymmetric signing
  - the asymmetric signature, if it exists, MUST be calculated over the canonical hash,
    using the asymmetric signing key in the encryption materials.
  - the asymmetric signature, if it exists, MUST be calculated using the
    [asymmetric signature algorithm](https://github.com/awslabs/aws-encryption-sdk-specification/blob/master/framework/algorithm-suites.md#algorithm-suites-signature-settings)
    indicated by the algorithm suite.
