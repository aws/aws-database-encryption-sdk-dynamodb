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

- [Authenticate Schema](#authenticate-schema)
- [Cryptographic Materials Manager (CMM)](#cmm)
- [Encrypted Structured Data](#encrypted-structured-data)

The following inputs to this behavior MUST be OPTIONAL:

- [Encryption Context](#encryption-context)

### Authenticate Schema

The [Authenticate Schema](./structures.md#authenticate-schema) that indicates
which [Terminal Data](./structures.md#terminal-data) in the
[Encrypted Structured Data](#encrypted-structured-data) MUST
be included in the signature scope.

The Authenticate Schema MUST explicitly configure a [Authenticate Action](./structures.md#authenticate-action) for every
[Terminal Data](./structures.md#terminal-data) that exists on the [input Structured Data](#structured-data),
and MUST NOT describe Authenticate Actions for locations within the input Structured Data that either
do not exist, or contain non-Terminal Data structures;
otherwise, this operation operation MUST yield an error.

The Authenticate Schema MUST include at least one [SIGN Authenticate Action](./structures.md#sign);
otherwise, this operation MUST yield an error.

### CMM

A CMM that implements the [CMM interface](https://github.com/awslabs/aws-encryption-sdk-specification/blob/master/framework/cmm-interface.md).

### Encrypted Structured Data

The [Structured Data](./structures.md#structured-data) to be decrypted.

### Encryption Context

See [encryption context](./structures.md#encryption-context).

In order for decryption to succeed:
- This MUST include any key-values pairs that were used during the original [encryption](./encrypt-structure.md)
of the [input Structured Data](#structured-data),
but not stored in the [input Structured Data's header](#TODO-truss-header).
- This MAY include any key-values pairs that are stored
in the [input Structured Data's header](#TODO-truss-header).
- This MUST NOT include any key-values pairs that were not
used during the original [encryption](./encrypt-structure.md) of the [input Structured Data](#structured-data).

## Output

### Structured Data

The decrypted form of the [input Encrypted Structured Data](#encrypted-structured-data),
decrypted according to the [behavior specified below](#behavior).

## Behavior

All inputs MUST adhere to their requirements;
otherwise this operation MUST immediately yield an error.

The Decrypt Structure operation is divided into several distinct steps:

- [Parse the Header](#parse-the-header)
- [Retrieve Decryption Materials](#retrieve-decryption-materials)
- [Verify Signatures](#verify-signatures)
- [Construct Decrypted Structured Data](#construct-decrypted-structured-data)

This operation MUST perform all the above steps,
and it MUST perform them in the above order.

If any of these steps fails, this operation MUST halt and indicate a failure to the caller.

### Parse the Header

Given the [input Structured Data](#structured-data),
this operation MUST access the [Terminal Data](./structures.md#terminal-data)
at string index "aws:truss-header"(TODO).

The [Terminal Type Id](./structures.md#terminal-type-id) on this Terminal Data MUST be `0xFFFF`.
We refer to the [Terminal Value](./structures.md#terminal-value)
on this Terminal Data as the header bytes.

This operation MUST deserialize the header bytes
according to the [header format](#TODO-truss-header).

The below calculations REQUIRE a [Crypto Schema](./structures.md#crypto-schema),
which is determined based on the input [Authentication Schema](#authenticate-schema) and the
parsed [Encrypt Legend](#TODO-truss-header) in the header,
such that for each [Terminal Data](./structures.md#terminal-data)
in the [input Structed Data](#structured-data):
- The Crypto Action is [IGNORE](./structures.md#ignore) if
  the Authentication Schema indicates [DO_NOT_SIGN](./structures.md#donotsign) for this Terminal Data.
- The Crypto Action is [SIGN_ONLY](./structures.md#signonly) if
  the Authentication Schema indicates [SIGN](./structures.md#sign) for this Terminal Data
  and the Encrypt Legend byte corresponding to this Terminal Data is `0x73`.
- The Crypto Action is [ENCRYPT_AND_SIGN](./structures.md#encryptandsign) if
  the Authentication Schema indicates [SIGN](./structures.md#sign) for this Terminal Data
  and the Encrypt Legend byte corresponding to this Terminal Data is `0x65`.

If the parsed [Encryption Context](#TODO-truss-header) contains fields that exist in the
[input Encryption Context](#encryption-context),
and the corresponding values do not match,
this operation MUST yield an error.

The parsed [Encrypted Data Keys](#TODO-truss-header)
MUST be non-empty.
(TODO move to truss header spec)

### Retrieve Decryption Materials

Based on the [Message Format Version](#TODO-truss-header)
and [Message Format Flavor](#TODO-truss-header) parsed in the header,
the following [algorithm suite](#TODO-mpl-alg-suites) MUST be used:

| Message Format Version (hex) | Message Format Flavor (hex) | Algorithm Suite ID (hex) |
| ---------------------------- | --------------------------- | ------------------------ |
| 00 01                        | 00 00                       | TODO                     |
| 00 01                        | 00 01                       | TODO                     |

This operation MUST obtain a set of decryption materials by calling
[Decrypt Materials](https://github.com/awslabs/aws-encryption-sdk-specification/blob/master/framework/cmm-interface.md#decrypt-materials)
on the [input CMM](#cmm).

The call to the CMM's Decrypt Materials operation MUST be constructed as follows:
- Encryption Context: The encryption context containing exactly the union of
  key-value pairs in the [input Encryption Context](#encryption-context)
  and the key-value pairs in the [Encryption Context parsed from the header](#TODO-truss-header).
- Algorithm Suite ID: The algorithm suite ID as determined above.
- Encrypted Data Keys: The [Encrypted Data Keys](#TODO-truss-header) parsed from the header.

The algorithm suite used in all further aspects of this operation MUST be
the algorithm suite in the
[decryption materials](https://github.com/awslabs/aws-encryption-sdk-specification/blob/master/framework/structures.md#decryption-materials)
returned from the Decrypt Materials call.
Note that the algorithm suite in the retrieved decryption materials MAY be different from the input algorithm suite.
If this algorithm suite is not a [Structured Encryption Library Supported suite](#TODO-mpl-alg-suites) this operation MUST yield an error.

This operation MUST derive a [Commitment Key](#TODO-truss-key-wrapping)
with the following specifics:
- the KDF used to calculate the Commitment Key MUST be the KDF indicated by the algorithm suite.
- the key input to the KDF MUST be the plaintext data key in the decryption materials.
- the Message ID used in this KDF calculation MUST be the Message ID parsed from the header
- the calculated Commitment Key MUST have length equal to the algorithm suite's encryption key length.

The parsed [Header Commitment](#TODO-truss-header) MUST be [checked](#TODO-truss-header)
using this Commitment Key and the header.
TODO: the HMAC used here is SHA-384, so can't easily tie to Alg Suite

### Verify Signatures

The calculations below REQUIRE determining a [canonical hash](#TODO-truss-signature-canonicalization)
of the [Structured Data](#structured-data), with the following specifics:
- The header bytes are the [header bytes determined above](#parse-the-header).
- The fields are the set of [Terminal Data](./structures.md#terminal-data)
  on the [Structured Data](#structured-data) that the [Authenticate Schema](#authenticate-schema)
  configues as [SIGN](./structures.md#sign).
- The AAD is the [serialization of the Encryption Context](#TODO-mpl-structures)
  in the decryption materials.

Given the [input Structured Data](#structured-data),
this operation MUST access the [Terminal Data](./structures.md#terminal-data)
at string index "aws:truss-footer"(TODO).

The [Terminal Type Id](./structures.md#terminal-type-id) MUST be `0xFFFF`.

This operation MUST deserialize the bytes in [Terminal Value](./structures.md#terminal-value)
according to the [footer format](#TODO-truss-footer).

The number of [HMACs in the footer](#TODO-truss-footer) 
MUST be the number of [Encrypted Data Keys in the header](#TODO-truss-header).

For every [HMAC](#TODO-truss-footer) in the footer,
this operation MUST [verify](#TODO-truss-signature-canonicalization)
with the following specifics:
- The key is the symmetric key in the decryption materials that
  [corresponds to the Encrypted Data Key](#TODO-mpl-structures) that shares this
  HMAC's index in the deserialized footer. 
- The canonical hash is as calculated above.
- TODO: the HMAC used here is SHA-384, so can't easily tie to Alg Suite

If this algorithm suite includes signing,
this operation MUST [verify](#TODO-truss-signature-canonicalization)
the [asymmetric signature](#TODO-truss-footer)
with the following specifics:
- The key is the asymmetric signing key in the decryption materials.
- The canonical hash is as calculated above.
- The asymmetric algorithm used is the asymmetric algorithm indicated by the
  algorithm suite.

If either verification fails, this operation MUST NOT continue
and MUST yield an error.

### Construct Decrypted Structured Data

The calculations below REQUIRE a [Field Root Key](#TODO-truss-key-wraping)
that MUST be derived with the following specifics:
- the KDF used to calculate the Field Root Key MUST be the KDF indicated by the algorithm suite.
- the key input to the KDF MUST be the plaintext data key in the decryption materials.
- the Message ID used in this KDF calculation MUST be the Message ID parsed from the header.
- the calculated Field Root Key MUST have length equal to the algorithm suite's encryption key length.

This operation MUST output a [Structured Data](#structured-data) with the following specifics:
- [Terminal Data](./structures.md#terminal-data) MUST NOT exist at the indexes for the [header](#TODO-truss-header)
  and [footer](#TODO-truss-footer).
- for every [input Terminal Data](./structures.md#terminal-data) in the [input Structured Data](#structured-data)
  (aside from the header and footer),
  a Terminal Data MUST exist with the same [canonical path](#TODO-truss) in the output Structured Data.
  Each of these Terminal Data in the output Structured Data MUST:
  - if the [Crypto Schema](#crypto-schema) indicates a [Crypto Action](./structures.md#crypto-action)
    of [SIGN_ONLY](./structures.md#signonly) or [IGNORE](./structures.md#ignore) for this Terminal Data,
    this Terminal Data MUST have [Terminal Type ID](./structures.md#terminal-type-id) and
    [Terminal Value](./structures.md#terminal-value) equal to the input Terminal Data's.
  - if the [Crypto Schema](#crypto-schema) indicates a [Crypto Action](./structures.md#crypto-action)
    of [ENCRYPT_AND_SIGN](./structures.md#encryptandsign) for this Terminal Data,
    this Terminal Data is the [decryption](#terminal-data-decryption) of
    the input Terminal Data's [Terminal Value](./structures.md#terminal-value).
- for every [Terminal Data](./structures.md#terminal-data) in the output Structured Data,
  a Terminal Data MUST exist with the same [canonical path](#TODO-truss) in the [input Structured Data](#structured-data),

#### Terminal Data Decryption

Decryption of [Terminal Data](./structures.md#terminal-data) takes a
[Terminal Value](./structures.md#terminal-value) as input, and returns a Terminal Data.

The decryption algorithm used MUST be the encryption algorithm indicated in the algorithm suite.
This decryption MUST be performed with the followings specifics:
- The AAD is the [canonical path](#TODO-truss-canonical-path) for this Terminal Data
- The Nonce is [derived according to the field encryption key derivation scheme](#TODO-truss-key-derivation),
  using the FieldRootKey as input.
- The Cipherkey is [derived according to the field encryption key derivation scheme](#TODO-truss-key-derivation),
  using the FieldRootKey as input.
- The plaintext is the input Terminal Value.

The plaintext result MUST be deserialized into a Terminal Data as:

| Field            | Length   |
| ---------------- | -------- |
| Terminal Type Id | 2        |
| Terminal Value   | Variable |

