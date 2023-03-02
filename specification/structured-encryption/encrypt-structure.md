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

### Table Name

The name of the table to hold the encrypted record

### Structured Data

The [Structured Data](./structures.md#structured-data) to be encrypted.

This Structured Data MUST be a [Structured Data Map](./structures.md#structured-data-map).
This Structured Data MUST NOT already contain data located at the [header index](./header.md#header-index)
or the [footer index](./footer.md#footer-index).

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

A CMM that implements the [CMM interface](../../private-aws-encryption-sdk-dafny-staging/aws-encryption-sdk-specification/framework/cmm-interface.md).

### Algorithm Suite

The [algorithm suite](../../private-aws-encryption-sdk-dafny-staging/aws-encryption-sdk-specification/framework/algorithm-suites.md) that SHOULD be used for encryption.

This algorithm suite MUST be a
[supported suite for Database Encryption (DBE)](../../private-aws-encryption-sdk-dafny-staging/aws-encryption-sdk-specification/framework/algorithm-suites.md#supported-algorithm-suites-enum);
otherwise, this operation MUST yield an error.

### Encryption Context

See [encryption context](./structures.md#encryption-context).

The prefix `aws-crypto-` is reserved for internal use by the AWS Encryption SDK; see the
[the Default CMM spec](../../private-aws-encryption-sdk-dafny-staging/aws-encryption-sdk-specification/framework/default-cmm.md)
for one such use.

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
[Get Encryption Materials](../../private-aws-encryption-sdk-dafny-staging/aws-encryption-sdk-specification/framework/cmm-interface.md#get-encryption-materials)
on the input [CMM](#cmm).

The call to Get Encryption Materials is constructed as follows:
- Encryption Context: If provided, this MUST be the [input encryption context](#encryption-context);
  otherwise, this is an empty encryption context.
- Commitment Policy: This MUST be
  [REQUIRE_ENCRYPT_REQUIRE_DECRYPT](../../private-aws-encryption-sdk-dafny-staging/aws-encryption-sdk-specification/framework/commitment-policy.md#esdkrequire_encrypt_require_decrypt).
- Algorithm Suite: If provided, this is the [input algorithm suite](#algorithm-suite);
  otherwise, this field MUST be the algorithm suite corresponding to the enum 
  [DBE.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_ECDSA_P384_SYMSIG_HMAC_SHA384](../../private-aws-encryption-sdk-dafny-staging/aws-encryption-sdk-specification/framework/algorithm-suites.md#supported-algorithm-suites-enum).
- Max Plaintext Length: This field MUST be the result of the calculation `encryptedTerminalDataNum * 2 + totalEncryptedTerminalValuesSize`
  - `encryptedTerminalDataNum` is the number of [Terminal Data](./structures.md#terminal-data)
    in the [input Structured Data](#structured-data) being encrypted,
    as defined by the [input Crypto Schema](#crypto-schema).
  - `totalEncryptedTerminalValuesSize` is the sum of the length of all [Terminal Values](./structures.md#terminal-value)
    in the [input Structured Data](#structured-data) being encrypted,
    as defined by the [input Crypto Schema](#crypto-schema).
../../private-aws-encryption-sdk-dafny-staging/aws-encryption-sdk-specification/framework/structures.md
The algorithm suite used in all aspects of this operation MUST be
the algorithm suite in the
[encryption materials](../../private-aws-encryption-sdk-dafny-staging/aws-encryption-sdk-specification/framework/structures.md#encryption-materials)
returned from the Get Encryption Materials call.
Note that the algorithm suite in the retrieved encryption materials MAY be different from the input algorithm suite.
If this algorithm suite is not a
[supported suite for Database Encryption (DBE)](../../private-aws-encryption-sdk-dafny-staging/aws-encryption-sdk-specification/framework/algorithm-suites.md#supported-algorithm-suites-enum),
this operation MUST yield an error.

### Calculate Intermediate Encrypted Structured Data

To construct the final Encrypted Structured Data,
a pre-signature version of this Encrypted Structured Data
must first be calculated.
This will be referred to as the Intermediate Encryption Structured Data.

The calculations below REQUIRE generating a unique [Message ID](./header.md#message-id) for this Encrypted Structured Data.
The process used to generate this identifier MUST use a good source of randomness
to make the chance of duplicate identifiers negligible.

The Intermediate Encryption Structured Data has the following specifics:

For every [input Terminal Data](./structures.md#terminal-data)
in the [input Structured Data](#structured-data),
a Terminal Data MUST exist with the same [canonical path](./header.md#canonical-path)
in Intermediate Encrypted Structured Data,
if the [Crypto Schema](#crypto-schema)
indicates a [Crypto Action](./structures.md#crypto-action)
other than [DO_NOTHING](./structures.md#DO_NOTHING).

For each of these Terminal Data in the Intermediate Encrypted Structured Data:

If the [Crypto Schema](#crypto-schema)
indicates a [Crypto Action](./structures.md#crypto-action)
of [SIGN_ONLY](./structures.md#signonly) for this Terminal Data,
this Terminal Data MUST have [Terminal Type ID](./structures.md#terminal-type-id)
and [Terminal Value](./structures.md#terminal-value) equal to the input Terminal Data's.

If the [Crypto Schema](#crypto-schema)
indicates a [Crypto Action](./structures.md#crypto-action)
of [ENCRYPT_AND_SIGN](./structures.md#encryptandsign) for this Terminal Data,
this Terminal Data MUST be the [encryption](#terminal-data-encryption)
of the input's Terminal Data.

For every [Terminal Data](./structures.md#terminal-data)
in the Intermediate Encrypted Structured Data
a Terminal Data MUST exist with the same [canonical path](./header.md#canonical-path)
in the [input Structured Data](#structured-data).

### Calculate Cipherkey and Nonce

The KDF used to calculate the Field Root Key MUST be the 
[Encryption Key KDF](../../private-aws-encryption-sdk-dafny-staging/aws-encryption-sdk-specification/framework/algorithm-suites.md#algorithm-suites-encryption-key-derivation-settings)
indicated by the algorithm suite, using a provided plaintext data key,
no salt, and an info of "AWS_DBE_DERIVE_KEY" concatenated with a provided message id.

The `FieldRootKey` MUST be generated with the plaintext data key in the encryption materials
and the Message ID generated for this Encrypted Structured Data

The calculated Field Root MUST have length equal to the
  [algorithm suite's encryption key length](../../private-aws-encryption-sdk-dafny-staging/aws-encryption-sdk-specification/framework/algorithm-suites.md#algorithm-suites-encryption-settings).


The `FieldKeyNonce` for a given offset MUST be 16 bytes comprised of
 - the ASCII encoding of "AwsDbeField"
 - the byte 0x2c (aka 44, the length of the eventual FieldKey)
 - the offset as a 4-byte integer

The `FieldKey` for a given key and offset MUST be the first 44 bytes
of the aes256ctr_stream
of the given key and the `FieldKeyNonce` of three times the given offset

The `Cipherkey` MUST be the first 32 bytes of the `FieldKey`

The `Nonce` MUST be the remaining 12 bytes of the `FieldKey`

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

The Encrypted Terminal Value MUST be derived according to the following encryption:
- The encryption algorithm used is the
  [encryption algorithm](../../private-aws-encryption-sdk-dafny-staging/aws-encryption-sdk-specification/framework/algorithm-suites.md#algorithm-suites-encryption-settings)
  indicated in the algorithm suite.
- The AAD is the [canonical path](./header.md#canonical-path) for this Terminal Data
- The [Cipherkey and Nonce](#calculate-cipherkey-and-nonce) are as calculated above.
- The plaintext is the [Terminal Value](./structures.md#terminal-value) for this Terminal Data.

### Construct Encrypted Structured Data

Given an Intermediate Encrypted Structured Data,
the signatures over this Structured Data may be calculated,
and the final Encrypted Structured Data outputted.

#### Header Field

The Header Field name MUST be `aws_dbe_head`

The Header Field TypeID MUST be 0xFFFF

The Header Field Value MUST be the full serialized [header](header.md) with commitment.

#### Footer Field

The Footer Field name MUST be `aws_dbe_foot`

The Footer Field TypeID MUST be 0xFFFF

The Footer Field Value MUST be the serialized [footer](footer.md).

#### Encrypted Structured Data
The Encrypted Structured Data created by this operation MUST be a Structured Data such that:
- for every [Terminal Data](./structures.md#terminal-data) in the
  [Intermediate Structured Data](#calculate-intermediate-encrypted-structured-data),
  a Terminal Data MUST exist with the same [canonical path](./header.md#canonical-path) in the final Encrypted Structured Data.
- for every [Terminal Data](./structures.md#terminal-data) in the final Encrypted Structured Data
  (except for the [header](#header-field) and [footer](#footer-field)),
  a Terminal Data MUST exist with the same [canonical path](./header.md#canonical-path) in the
  [Intermediate Structured Data](#calculate-intermediate-encrypted-structured-data),
- The [Header Field](#header-field) MUST exist in the Encrypted Structured Data
- The [Footer Field](#footer-field) MUST exist in the Encrypted Structured Data
