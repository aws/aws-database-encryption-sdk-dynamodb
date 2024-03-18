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

### Table Name

The logical name for the structure.
This can be the same as the physical name.
For example the name of the table to hold the encrypted record.

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

A CMM that implements the [CMM interface](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/cmm-interface.md).

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

This operation MUST output the following:

- [Structured Data](#structured-data)
- [Parsed Header](#parsed-header)

### Structured Data

The decrypted form of the [input Encrypted Structured Data](#encrypted-structured-data),
decrypted according to the [behavior specified below](#behavior).

### Parsed Header

This structure MUST contain the following values,
representing the deserialized form of the header of the input encrypted structure:

- [Algorithm Suite ID](./header.md#format-flavor): The Algorithm Suite ID associated with the Format Flavor on the header.
- [Crypto Schema](./header.md#encrypt-legend): The Crypto Schema for each signed Terminal,
  calculated using the Crypto Legend in the header, the signature scope used for decryption, and the data in the input structure.
- [Stored Encryption Context](./header.md#encryption-context): The Encryption Context stored in the header.
- [Encrypted Data Keys](./header.md#encrypted-data-keys): The Encrypted Data Keys stored in the header.
- [Encryption Context](#encryption-context): The full Encryption Context used.

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
at the "aws_dbe_head"

The [Terminal Type Id](./structures.md#terminal-type-id) on this Terminal Data MUST be `0xFFFF`.
We refer to the [Terminal Value](./structures.md#terminal-value)
on this Terminal Data as the header bytes.

This operation MUST deserialize the header bytes
according to the [header format](./header.md).

The header field value MUST be [verified](header.md#commitment-verification)

The below calculations REQUIRE a [Crypto Schema](./structures.md#crypto-schema),
which is determined based on the input [Authentication Schema](#authenticate-schema) and the
parsed [Encrypt Legend](./header.md#encrypt-legend) in the header,
such that for each [Terminal Data](./structures.md#terminal-data)
in the [input Structured Data](#structured-data):
- The Crypto Action is [DO_NOTHING](./structures.md#DO_NOTHING) if
  the Authentication Schema indicates [DO_NOT_SIGN](./structures.md#donotsign) for this Terminal Data.
- The Crypto Action is [SIGN_ONLY](./structures.md#signonly) if
  the Authentication Schema indicates [SIGN](./structures.md#sign) for this Terminal Data
  and the Encrypt Legend byte corresponding to this Terminal Data is `0x73`.
- The Crypto Action is [ENCRYPT_AND_SIGN](./structures.md#encryptandsign) if
  the Authentication Schema indicates [SIGN](./structures.md#sign) for this Terminal Data
  and the Encrypt Legend byte corresponding to this Terminal Data is `0x65`.

### Retrieve Decryption Materials

This operation MUST [calculate the appropriate CMM and encryption context](#create-new-encryption-context-and-cmm).

This operation MUST obtain a set of decryption materials by calling
[Decrypt Materials](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/cmm-interface.md#decrypt-materials)
on the [CMM](#cmm) calculated above.

The call to the CMM's Decrypt Materials operation MUST be constructed as follows:
- Encryption Context: The [Encryption Context parsed from the header](./header.md#encryption-context).
- Algorithm Suite ID: The algorithm suite [indicated by the Message Format Flavor](./header.md#format-flavor)
  parsed in the header.
- Commitment Policy: DBE_COMMITMENT_POLICY
- Encrypted Data Keys: The [Encrypted Data Keys parsed from the header](./header.md#encrypted-data-keys).
- Reproduced Encryption Context: This is the encryption context calculated above.

The algorithm suite used in all further aspects of this operation MUST be
the algorithm suite in the
[decryption materials](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/structures.md#decryption-materials)
returned from the Decrypt Materials call.
Note that the algorithm suite in the retrieved decryption materials MAY be different from the input algorithm suite.
If this algorithm suite is not a
[supported suite for DBE](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/algorithm-suites.md#supported-algorithm-suites-enum)
this operation MUST yield an error.

#### Create New Encryption Context and CMM

If the version stored in the header is 1,
then the input cmm and encryption context MUST be used unchanged.

Otherwise, this operation MUST add an [entry](../dynamodb-encryption-client/encrypt-item.md#base-context-value-version-2) to the encryption context for every
[SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT Crypto Action](./structures.md#sign_and_include_in_encryption_context)
[Terminal Data](./structures.md#terminal-data)
in the input record, plus the Legend.

An error MUST be returned if any of the entries added to the encryption context in this step
have the same key as any entry already in the encryption context.

Then, this operation MUST create a [Required Encryption Context CMM](https://github.com/awslabs/private-aws-encryption-sdk-specification-staging/blob/dafny-verified/framework/required-encryption-context-cmm.md)
with the following inputs:
- This input [CMM](./ddb-table-encryption-config.md#cmm) as the underlying CMM.
- The name of every entry added above.


### Verify Signatures

A footer field MUST exist with the name `aws_dbe_foot`

The footer field TypeID MUST be 0xFFFF

The footer field value MUST be [verified](footer.md#footer-verification).

Decryption MUST fail immediately if verification fails.

This operation MUST deserialize the bytes in [Terminal Value](./structures.md#terminal-value)
according to the [footer format](./footer.md).

The number of [HMACs in the footer](./footer.md#hmacs) 
MUST be the number of [Encrypted Data Keys in the header](./header.md#encrypted-data-keys).

### Calculate Cipherkey and Nonce

The Cipherkey and Nonce must be calculated for [encryption](encrypt-structure.md#calculate-cipherkey-and-nonce).

### Calculate Signed and Encrypted Field Lists

The `signed field list` MUST be all fields for which 
the [Authenticate Schema](#authenticate-schema)
indicates an [Authenticate Action](./structures.md#authenticate-action)
of [SIGN](./structures.md#SIGN) for that field,
sorted by the [Canonical Path](header.md.#canonical-path).

Decryption MUST fail if the length of this list does not equal the 
length of the header's [Encrypt Legend](header.md.#encrypt-legend).

The `encrypted field list` MUST be all fields in the `signed field list`
for which the corresponding byte in the [Encrypt Legend](header.md.#encrypt-legend)
is `0x65` indicating [Encrypt and Sign](header.md.#encrypt-legend-bytes),
sorted by the field's [canonical path](./header.md#canonical-path).

### Construct Decrypted Structured Data

This operation MUST output a [Structured Data](#structured-data) with the following specifics:
- [Terminal Data](./structures.md#terminal-data) MUST NOT exist at the "aws_dbe_head"
  or "aws_dbe_foot".
- For every [input Terminal Data](./structures.md#terminal-data) in the [input Structured Data](#structured-data)
  (aside from the header and footer),
  a Terminal Data MUST exist with the same [canonical path](./header.md#canonical-path) in the output Structured Data.
  Put plainly, the output Structured Data does not drop any Terminal Data during decryption,
  other than the header and footer.

 - For each Terminal Data in the output Structured Data,
if the field name is not in the [Encrypted Field Lists](#calculate-signed-and-encrypted-field-lists)
this Terminal Data MUST have [Terminal Type ID](./structures.md#terminal-type-id) and
[Terminal Value](./structures.md#terminal-value) equal to the input Terminal Data's,
otherwise this Terminal Data MUST have [Terminal Type ID](./structures.md#terminal-type-id)
equal to the first two bytes of the input Terminal Data's value,
and a value equal to the [decryption](#terminal-data-decryption) of the input Terminal Data's value.

- for every [Terminal Data](./structures.md#terminal-data) in the output Structured Data,
  a Terminal Data MUST exist with the same [canonical path](./header.md#canonical-path) in the [input Structured Data](#structured-data).
  Put plainly, the output Structured Data does not add any extra Structured Data during decryption.

The output MUST also include a [Parsed Header](#parsed-header) that contains
data that was serialized into the header included in the output Structured Data.

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
  [encryption algorithm](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/algorithm-suites.md#algorithm-suites-encryption-settings)
  indicated in the algorithm suite.
- The AAD is the [canonical path](./header.md#canonical-path) for this Terminal Data.
- The Cipherkey and Nonce are as calculate [above](#calculate-cipherkey-and-nonce).
- The ciphertext is the deserialized Encrypted Terminal Value.
