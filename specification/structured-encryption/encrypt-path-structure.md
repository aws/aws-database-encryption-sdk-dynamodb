[//]: # "Copyright Amazon.com Inc. or its affiliates. All Rights Reserved."
[//]: # "SPDX-License-Identifier: CC-BY-SA-4.0"

# Encrypt Path Structure

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
- [Crypto List](#crypto-list)
- [Cryptographic Materials Manager (CMM)](#cmm)

The following inputs to this behavior MUST be OPTIONAL:

- [Algorithm Suite](#algorithm-suite)
- [Encryption Context](#encryption-context)

### Table Name

The logical name for the structure.
This can be the same as the physical name.
For example the name of the table to hold the encrypted record.

### Crypto List

The [Crypto List](./structures.md#crypto-list) to be encrypted.

The [paths](./structures.md#path) in the input [Crypto List](./structures.md#crypto-list) MUST be unique.

This Crypto List MUST NOT already contain data located at the [header index](./header.md#header-index)
or the [footer index](./footer.md#footer-index).

The Crypto List describes how each [Terminal Data](./structures.md#terminal-data) should be treated during encryption.

The Crypto List MUST include at least one [Crypto Action](./structures.md#crypto-action)
that is not [DO_NOTHING](./structures.md#do_nothing).

### CMM

A CMM that implements the [CMM interface](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/cmm-interface.md).

### Algorithm Suite

The [algorithm suite](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/algorithm-suites.md) that SHOULD be used for encryption.

This algorithm suite MUST be a
[supported suite for Database Encryption (DBE)](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/algorithm-suites.md#supported-algorithm-suites-enum);
otherwise, this operation MUST yield an error.

### Encryption Context

See [encryption context](./structures.md#encryption-context).

The prefix `aws-crypto-` is reserved for internal use by the AWS Encryption SDK; see the
[the Default CMM spec](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/default-cmm.md)
for one such use.
The operation MUST fail if an encryption context is provided which contains a key with the prefix `aws-crypto-`.

## Output

This operation MUST output the following:

- [Encrypted Crypto List](#encrypted-crypto-list)
- [Parsed Header](./decrypt-structure.md#parsed-header)

### Encrypted Crypto List

An encrypted form of the [input Crypto List](#crypto-list),
encrypted according to the [behavior specified below](#behavior).

## Behavior

All inputs MUST adhere to their requirements;
otherwise this operation MUST immediately yield an error.

Given valid inputs,
the Encrypt Structure operation is divided into several distinct steps:

1. [Retrieve Encryption Materials](#retrieve-encryption-materials)
1. [Calculate Intermediate Encrypted Structured Data](#calculate-intermediate-encrypted-structured-data)
1. [Construct Encrypted Structured Data](#construct-encrypted-structured-data)

This operation MUST perform all the above steps,
and it MUST perform them in the above order.

If any of these steps fails, this operation MUST halt and indicate a failure to the caller.

### Retrieve Encryption Materials

This operation MUST [calculate the appropriate CMM and encryption context](#create-new-encryption-context-and-cmm).

This operation MUST obtain a set of encryption materials by calling
[Get Encryption Materials](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/cmm-interface.md#get-encryption-materials)
on the [CMM](#cmm) calculated above.

This operation MUST call Get Encryption Materials on the CMM as follows.

- Encryption Context: This MUST be the encryption context calculated above.
- Commitment Policy: This MUST be
  [REQUIRE_ENCRYPT_REQUIRE_DECRYPT](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/commitment-policy.md#esdkrequire_encrypt_require_decrypt).
- Algorithm Suite: If provided, this is the [input algorithm suite](#algorithm-suite);
  otherwise, this field MUST be the algorithm suite corresponding to the enum
  [DBE.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_ECDSA_P384_SYMSIG_HMAC_SHA384](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/algorithm-suites.md#supported-algorithm-suites-enum).
- Max Plaintext Length: This field MUST be the result of the calculation `encryptedTerminalDataNum * 2 + totalEncryptedTerminalValuesSize`
  - `encryptedTerminalDataNum` is the number of [Terminal Data](./structures.md#terminal-data)
    in the [input data](#crypto-list) being encrypted,
    as defined by the [input Crypto Schema](#crypto-list).
  - `totalEncryptedTerminalValuesSize` is the sum of the length of all [Terminal Values](./structures.md#terminal-value)
    in the [input data](#crypto-list) being encrypted,
    as defined by the [input Crypto Schema](#crypto-list).

The algorithm suite used in all aspects of this operation MUST be
the algorithm suite in the
[encryption materials](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/structures.md#encryption-materials)
returned from the Get Encryption Materials call.

Note that the algorithm suite in the retrieved encryption materials MAY be different from the input algorithm suite.
If this algorithm suite is not a
[supported suite for Database Encryption (DBE)](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/algorithm-suites.md#supported-algorithm-suites-enum),
this operation MUST yield an error.

#### Create New Encryption Context and CMM

If no [Crypto Action](./structures.md#crypto-action) is configured to be
[SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT Crypto Action](./structures.md#sign_and_include_in_encryption_context)
then the input cmm and encryption context MUST be used unchanged.

Otherwise, this operation MUST add an [entry](../dynamodb-encryption-client/encrypt-item.md#base-context-value-version-2) to the encryption context for every
[SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT Crypto Action](./structures.md#sign_and_include_in_encryption_context)
[Terminal Data](./structures.md#terminal-data)
in the input record, plus the Legend.

An error MUST be returned if any of the entries added to the encryption context in this step
have the same key as any entry already in the encryption context.

The Legend MUST be named "aws-crypto-legend" and be a string with one character per attribute added above,
with a one-to-one correspondence with the attributes sorted by their UTF8 encoding,
each character designating the original type of the attribute,
to allow reversing of the [encoding](../dynamodb-encryption-client/encrypt-item.md#base-context-value-version-2).

- 'S' if the attribute was of type String
- 'N' if the attribute was of type Number
- 'L' if the attribute was of type Null or Boolean
- 'B' otherwise

Then, this operation MUST create a [Required Encryption Context CMM](https://github.com/awslabs/private-aws-encryption-sdk-specification-staging/blob/dafny-verified/framework/required-encryption-context-cmm.md)
with the following inputs:

- This input [CMM](./ddb-table-encryption-config.md#cmm) as the underlying CMM.
- The name of every entry added above.

#### Encryption Context Naming

When a key-value pair is added to the encryption context,
the key MUST be the concatenation of the literal
"aws-crypto-attr." and the member strings of the
path joined by the '.' character.

This mapping does not produce a unique output for every unique input.
For example ['a.b'] and ['a', 'b'] both produce "a.b".

An error MUST be returned if an attempt is made to add two
different attributes that produce the same encryption context key.

### Calculate Intermediate Encrypted Structured Data

To construct the final Encrypted Structured Data,
a pre-signature version of this Encrypted Structured Data
must first be calculated.
This will be referred to as the Intermediate Encryption Structured Data.

The calculations below REQUIRE generating a unique [Message ID](./header.md#message-id) for this Encrypted Structured Data.
The process used to generate this identifier MUST use a good source of randomness
to make the chance of duplicate identifiers negligible.

The Intermediate Encryption Structured Data has the following specifics:

For every entry
in the input [Crypto List](#crypto-list)
there MUST be an entry with the same [canonical path](./header.md#canonical-path)
in Intermediate Encrypted Structured Data.

There MUST be no other entries in the Intermediate Encrypted Structured Data.

### Calculate Info

The `info` used for the HKDF function MUST be
| Field | Length |
| -------------------- | -------- |
| "AWS_DBE_DERIVE_KEY" | 18 |
| Message ID | 32 |

### Calculate Cipherkey and Nonce

The HKDF algorithm used to calculate the Field Root Key MUST be the
[Encryption Key KDF](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/algorithm-suites.md#algorithm-suites-encryption-key-derivation-settings)
indicated by the algorithm suite, using a provided plaintext data key, no salt,
and an info as calculated [above](#calculate-info)

The `FieldRootKey` MUST be generated with the plaintext data key in the encryption materials
and the Message ID generated for this Encrypted Structured Data.

The `FieldRootKey` is combined with the ordinal position of a field within a record
to generate a unique `FieldKey` for encrypting that field.

The ordinal position is calculated by sorting the
[canonical path](./header.md#canonical-path)
of all of the [ENCRYPT_AND_SIGN](./structures.md#encryptandsign) fields,
sorting those paths in ascending order,
and taking the zero-based position of the field in that sorted list.

The calculated Field Root MUST have length equal to the
[algorithm suite's encryption key length](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/algorithm-suites.md#algorithm-suites-encryption-settings).

The `FieldKeyNonce` for a given offset MUST be 16 bytes comprised of
| Field | Length | Interpretation |
| ------------- | -------- | -------------- |
| "AwsDbeField" | 11 | Literal Ascii String |
| 0x2c | 1 | 44, the length of the eventual FieldKey |
| offset | 4 | 32 bit integer representation of offset |

The `FieldKey` for a given key and offset MUST be the first 44 bytes
of the aes256ctr_stream
of the `FieldRootKey` and the `FieldKeyNonce` of three times the given offset.
The `FieldKey` is used to derive a specific Cipherkey for each specific TerminalData to be encrypted, and the nonces that are used for that encryption"

The `Cipherkey` MUST be the first 32 bytes of the `FieldKey`

The `Nonce` MUST be the remaining 12 bytes of the `FieldKey`

#### Terminal Data Encryption

Encryption of [Terminal Data](./structures.md#terminal-data) takes a
Terminal Data as input, and returns an encrypted Terminal Data.

The output encrypted Terminal Data MUST have a [Terminal Type Id](./structures.md#terminal-type-id)
equal `0xFFFF`.

The output encrypted Terminal Data MUST have a [Terminal Value](./structures.md#terminal-value)
with the following serialization:

| Field                    | Length   |
| ------------------------ | -------- |
| Terminal Type Id         | 2        |
| Encrypted Terminal Value | Variable |

##### Terminal Type Id

Terminal Type Id MUST equal the input Terminal Data's Terminal Type Id.

##### Encrypted Terminal Value

The Encrypted Terminal Value MUST be derived according to the following encryption:

- The encryption algorithm used is the
  [encryption algorithm](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/algorithm-suites.md#algorithm-suites-encryption-settings)
  indicated in the algorithm suite.
- The AAD is the [canonical path](./header.md#canonical-path) for this Terminal Data.
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

The encryption context field serialized in the header MUST contain all key-value
pairs of the encryption context in the [encryption materials](#retrieve-encryption-materials)
that are not included in the
[required encryption context keys](../framework/structures.md#required-encryption-context-keys) list.

#### Footer Field

The Footer Field name MUST be `aws_dbe_foot`

The Footer Field TypeID MUST be 0xFFFF

The Footer Field Value MUST be the serialized [footer](footer.md).

#### Encrypted Structured Data

- For every entry in the input [Crypto List](#crypto-list)
  an entry MUST exist with the same [path](./structures.md#path) in the final Encrypted Structured Data.
- The [Header Field](#header-field) MUST exist in the final Encrypted Structured Data
- The [Footer Field](#footer-field) MUST exist in the final Encrypted Structured Data
- For every entry in the final Encrypted Structured Data, other than the header and footer,
  an entry MUST exist with the same [path](./structures.md#path) in the input [Crypto List](#crypto-list).

For each entry in the final Encrypted Structured Data:

If the [Crypto Schema](#crypto-list)
indicates a [Crypto Action](./structures.md#crypto-action)
of [ENCRYPT_AND_SIGN](./structures.md#encryptandsign),
the Terminal Data MUST have [Terminal Type ID](./structures.md#terminal-type-id)
equal to 0xffff and the value MUST be
the [encryption](#terminal-data-encryption)
of the input's Terminal Data.

Otherwise, this Terminal Data MUST have [Terminal Type ID](./structures.md#terminal-type-id)
and [Terminal Value](./structures.md#terminal-value) equal to the input Terminal Data's.
