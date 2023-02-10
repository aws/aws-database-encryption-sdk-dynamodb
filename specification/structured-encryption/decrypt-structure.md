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
but not stored in the [input Structured Data's header](./header.md#encryption-context).
- This MAY include any key-values pairs that are stored
in the [input Structured Data's header](./header.md#encryption-context).
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

1. [Parse the Header](#parse-the-header)
1. [Retrieve Decryption Materials](#retrieve-decryption-materials)
1. [Verify Signatures](#verify-signatures)
1. [Construct Decrypted Structured Data](#construct-decrypted-structured-data)

This operation MUST perform all the above steps,
and it MUST perform them in the above order.

If any of these steps fails, this operation MUST halt and indicate a failure to the caller.

### Parse the Header

Given the [input Structured Data](#structured-data),
this operation MUST access the [Terminal Data](./structures.md#terminal-data)
at the [header index](./header.md#header-index).

The [Terminal Type Id](./structures.md#terminal-type-id) on this Terminal Data MUST be `0xFFFF`.
We refer to the [Terminal Value](./structures.md#terminal-value)
on this Terminal Data as the header bytes.

This operation MUST deserialize the header bytes
according to the [header format](./header.md).

The below calculations REQUIRE a [Crypto Schema](./structures.md#crypto-schema),
which is determined based on the input [Authentication Schema](#authenticate-schema) and the
parsed [Encrypt Legend](./header.md#encrypt-legend) in the header,
such that for each [Terminal Data](./structures.md#terminal-data)
in the [input Structed Data](#structured-data):
- The Crypto Action is [DO_NOTHING](./structures.md#DO_NOTHING) if
  the Authentication Schema indicates [DO_NOT_SIGN](./structures.md#donotsign) for this Terminal Data.
- The Crypto Action is [SIGN_ONLY](./structures.md#signonly) if
  the Authentication Schema indicates [SIGN](./structures.md#sign) for this Terminal Data
  and the Encrypt Legend byte corresponding to this Terminal Data is `0x73`.
- The Crypto Action is [ENCRYPT_AND_SIGN](./structures.md#encryptandsign) if
  the Authentication Schema indicates [SIGN](./structures.md#sign) for this Terminal Data
  and the Encrypt Legend byte corresponding to this Terminal Data is `0x65`.

If the parsed [Encryption Context](./header.md#encryption-context) contains fields that exist in the
[input Encryption Context](#encryption-context),
and the corresponding values do not match,
this operation MUST yield an error.

### Retrieve Decryption Materials

This operation MUST obtain a set of decryption materials by calling
[Decrypt Materials](https://github.com/awslabs/aws-encryption-sdk-specification/blob/master/framework/cmm-interface.md#decrypt-materials)
on the [input CMM](#cmm).

The call to the CMM's Decrypt Materials operation MUST be constructed as follows:
- Encryption Context: The encryption context containing exactly the union of
  key-value pairs in the [input Encryption Context](#encryption-context)
  and the key-value pairs in the [Encryption Context parsed from the header](./header.md#encryption-context).
- Algorithm Suite ID: The algorithm suite [indicated by the Message Format Flavor](./header.md#format-flavor)
  parsed in the header.
- Encrypted Data Keys: The [Encrypted Data Keys parsed from the header](./header.md#encrypted-data-keys).

The algorithm suite used in all further aspects of this operation MUST be
the algorithm suite in the
[decryption materials](https://github.com/awslabs/aws-encryption-sdk-specification/blob/master/framework/structures.md#decryption-materials)
returned from the Decrypt Materials call.
Note that the algorithm suite in the retrieved decryption materials MAY be different from the input algorithm suite.
If this algorithm suite is not a
[supported suite for DDBEC](https://github.com/awslabs/aws-encryption-sdk-specification/blob/master/framework/algorithm-suites.md#supported-algorithm-suites-enum)
this operation MUST yield an error.

This operation MUST derive a [Commitment Key](#TODO-truss-key-wrapping)
with the following specifics:
- the KDF used to calculate the Commitment Key MUST be the
  [Commit Key KDF](https://github.com/awslabs/aws-encryption-sdk-specification/blob/master/framework/algorithm-suites.md#algorithm-suites-commit-key-derivation-settings)
  indicated by the algorithm suite.
- the key input to the KDF MUST be the plaintext data key in the decryption materials.
- the Message ID used in the Commitment Key derivation MUST be the [Message ID parsed from the header](./header.md#message-id).
- the calculated Commitment Key MUST have length equal to the
  [algorithm suite's encryption key length](https://github.com/awslabs/aws-encryption-sdk-specification/blob/master/framework/algorithm-suites.md#algorithm-suites-encryption-settings).

The parsed [Header Commitment MUST be checked](./header.md#header-commitment)
using this Commitment Key and the header.

### Verify Signatures

The calculations below REQUIRE determining a [canonical hash](#TODO-truss-signature-canonicalization)
of the [Structured Data](#structured-data), with the following specifics:
- The header bytes are the [header bytes determined above](#parse-the-header).
- The fields are the set of [Terminal Data](./structures.md#terminal-data)
  on the [Structured Data](#structured-data) that the [Authenticate Schema](#authenticate-schema)
  configues as [SIGN](./structures.md#sign).
- The AAD is the [serialization of the Encryption Context](./header.md#encryption-context)
  in the decryption materials.

Given the [input Structured Data](#structured-data),
this operation MUST access the [Terminal Data](./structures.md#terminal-data)
at the [footer index](./footer.md#footer-index).

The [Terminal Type Id](./structures.md#terminal-type-id) MUST be `0xFFFF`.

This operation MUST deserialize the bytes in [Terminal Value](./structures.md#terminal-value)
according to the [footer format](./footer.md).

The number of [HMACs in the footer](./footer.md#hmacs) 
MUST be the number of [Encrypted Data Keys in the header](./header.md#encrypted-data-keys).

This operations MUST generate a new symmetric signature over the encrypted structure,
with the following specifics:
- this HMAC MUST be calculated using the
  [symmetric signature algorithm](https://github.com/awslabs/aws-encryption-sdk-specification/blob/master/framework/algorithm-suites.md#algorithm-suites-signature-settings)
  indicated in the algorithm suite.
- this HMAC MUST be calculated over the [canonical hash](#TODO-truss-signature-canonicalization),
  using the
  [symmetric signing key](https://github.com/awslabs/aws-encryption-sdk-specification/blob/master/framework/structures.md#symmetric-signing-keys)
  in the decryption materials.

This operation MUST verify that one of the [footer HMACs](./footer.md#hmacs)
equals the HMAC generated above, in a constant time operation.
TODO: tie the signature key more strongly to a particular HMAC/EDK,
that way we aren't forced to just try verifying each HMAC in the list.

If this algorithm suite includes signing,
this operation MUST [verify](#TODO-truss-signature-canonicalization)
the [asymmetric signature](./footer.md#signature)
with the following specifics:
- The key is the asymmetric signing key in the decryption materials.
- The canonical hash is as calculated above.
- the asymmetric signature is calculated using the
  [asymmetric signature algorithm](https://github.com/awslabs/aws-encryption-sdk-specification/blob/master/framework/algorithm-suites.md#algorithm-suites-signature-settings)
  indicated by the algorithm suite.

If either verification fails, this operation MUST NOT continue
and MUST yield an error.

### Construct Decrypted Structured Data

The calculations below REQUIRE a [Field Root Key](#TODO-truss-key-wraping)
that MUST be derived with the following specifics:
- the KDF used to calculate the Field Root Key MUST be the 
  [Encryption Key KDF](https://github.com/awslabs/aws-encryption-sdk-specification/blob/master/framework/algorithm-suites.md#algorithm-suites-encryption-key-derivation-settings)
  indicated by the algorithm suite.
- the key input to the KDF MUST be the plaintext data key in the decryption materials.
- the Message ID used in this calculation MUST be the Message ID parsed from the header.
- the calculated Field Root Key MUST have length equal to the
  [algorithm suite's encryption key length](https://github.com/awslabs/aws-encryption-sdk-specification/blob/master/framework/algorithm-suites.md#algorithm-suites-encryption-settings).

This operation MUST output a [Structured Data](#structured-data) with the following specifics:
- [Terminal Data](./structures.md#terminal-data) MUST NOT exist at the [header index](./header.md#header-index)
  or [footer index](./footer.md#footer-index).
- for every [input Terminal Data](./structures.md#terminal-data) in the [input Structured Data](#structured-data)
  (aside from the header and footer),
  a Terminal Data MUST exist with the same [canonical path](./header.md#canoncial-path) in the output Structured Data.
  Put plainly, the output Structured Data does not drop any Terminal Data during decryption, other than
  the header or footer.
  Each of these Terminal Data in the output Structured Data MUST:
  - if the [Crypto Schema](#crypto-schema) indicates a [Crypto Action](./structures.md#crypto-action)
    of [SIGN_ONLY](./structures.md#signonly) or [DO_NOTHING](./structures.md#DO_NOTHING) for this Terminal Data,
    this Terminal Data MUST have [Terminal Type ID](./structures.md#terminal-type-id) and
    [Terminal Value](./structures.md#terminal-value) equal to the input Terminal Data's.
  - if the [Crypto Schema](#crypto-schema) indicates a [Crypto Action](./structures.md#crypto-action)
    of [ENCRYPT_AND_SIGN](./structures.md#encryptandsign) for this Terminal Data,
    this Terminal Data is the [decryption](#terminal-data-decryption) of
    the input Terminal Data.
- for every [Terminal Data](./structures.md#terminal-data) in the output Structured Data,
  a Terminal Data MUST exist with the same [canonical path](./header.md#canoncial-path) in the [input Structured Data](#structured-data).
  Put plainly, the output Structured Data does not add any extra Structured Data during decryption.

#### Terminal Data Decryption

Decryption of [Terminal Data](./structures.md#terminal-data) takes a
encrypted Terminal Data as input, and returns a Terminal Data.

The input [Terminal Value](./structures.md#terminal-value) MUST be deserialized as follows:

| Field                      | Length   |
| -------------------------- | -------- |
| Terminal Type Id           | 2        |
| Encrypted Terminal Value   | Variable |

The output Terminal Data MUST have a [Terminal Type Id](./structures.md#terminal-type-id)
equal to the deserialized Terminal Type Id.

The output Terminal Data MUST have a [Terminal Value](./structures.md#terminal-type-id)
equal to the following decryption:
- The decryption algorithm used is the
  [encryption algorithm](https://github.com/awslabs/aws-encryption-sdk-specification/blob/master/framework/algorithm-suites.md#algorithm-suites-encryption-settings)
  indicated in the algorithm suite.
- The AAD is the [canonical path](./header.md#canoncial-path) for this Terminal Data
- The Nonce is [derived according to the field encryption key derivation scheme](#TODO-truss-key-derivation),
  using the FieldRootKey as input.
- The Cipherkey is [derived according to the field encryption key derivation scheme](#TODO-truss-key-derivation),
  using the FieldRootKey as input.
- The ciphertext is the deserialized Encrypted Terminal Value.
