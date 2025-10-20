[//]: # "Copyright Amazon.com Inc. or its affiliates. All Rights Reserved."
[//]: # "SPDX-License-Identifier: CC-BY-SA-4.0"

# Decrypt Path Structure

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
- [Cryptographic Materials Manager (CMM)](#cmm)
- [Auth List](#auth-list)

The following inputs to this behavior MUST be OPTIONAL:

- [Encryption Context](#encryption-context)

### Table Name

The logical name for the structure.
This can be the same as the physical name.
For example the name of the table to hold the encrypted record.

### Auth List

The [Auth List](./structures.md#auth-list) to be decrypted.

This Auth List MUST contain data located at the [header index](./header.md#header-index)
and the [footer index](./footer.md#footer-index).

The Auth List describes how each [Terminal Data](./structures.md#terminal-data) should be treated during decryption.

The Auth List MUST include at least one [SIGN Authenticate Action](./structures.md#sign);
otherwise, this operation MUST yield an error.

The Auth List MUST NOT contain duplicate Paths.

### CMM

A CMM that implements the [CMM interface](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/cmm-interface.md).

### Encryption Context

See [encryption context](./structures.md#encryption-context).

In order for decryption to succeed:

- This MUST include any key-values pairs that were used during the original [encryption](./encrypt-path-structure.md)
  of the [input data](#auth-list),
  but not stored in the [input Structured Data's header](./header.md#encryption-context).
- This MAY include any key-values pairs that are stored
  in the [input Structured Data's header](./header.md#encryption-context).
- This MUST NOT include any key-values pairs that were not
  used during the original [encryption](./encrypt-structure.md) of the [input data](#auth-list).

## Output

This operation MUST output the following:

- [Crypto List](./structures.md#crypto-list): Decrypted Terminals and the Crypto Schema for each Terminal,
  calculated using the Crypto Legend in the header, the signature scope used for decryption, and the data in the input structure.
- [Parsed Header](#parsed-header)

### Parsed Header

This structure MUST contain the following values,
representing the deserialized form of the header of the input encrypted structure:

- [Algorithm Suite ID](./header.md#format-flavor): The Algorithm Suite ID associated with the Format Flavor on the header.
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

Given the [input data](#auth-list),
this operation MUST access the [Terminal Data](./structures.md#terminal-data)
at "aws_dbe_head".

The [Terminal Type Id](./structures.md#terminal-type-id) on this Terminal Data MUST be `0xFFFF`.
We refer to the [Terminal Value](./structures.md#terminal-value)
on this Terminal Data as the header bytes.

This operation MUST deserialize the header bytes
according to the [header format](./header.md).

The header field value MUST be [verified](header.md#commitment-verification)

The below calculations REQUIRE a [Crypto Schema](./structures.md#crypto-schema),
which is determined based on the input [Authentication Schema](#auth-list) and the
parsed [Encrypt Legend](./header.md#encrypt-legend) in the header,
such that for each [Terminal Data](./structures.md#terminal-data)
in the [input Structured Data](#auth-list):

- The Crypto Action is [DO_NOTHING](./structures.md#DO_NOTHING) if
  the Authentication Schema indicates [DO_NOT_SIGN](./structures.md#donotsign) for this Terminal Data.
- The Crypto Action is [SIGN_ONLY](./structures.md#signonly) if
  the Authentication Schema indicates [SIGN](./structures.md#sign) for this Terminal Data
  and the Encrypt Legend byte corresponding to this Terminal Data is `0x73`.
- The Crypto Action is [SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT](./structures.md#sign_and_include_in_encryption_context) if
  the Authentication Schema indicates [SIGN](./structures.md#sign) for this Terminal Data
  and the Encrypt Legend byte corresponding to this Terminal Data is `0x63`.
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

The Cipherkey and Nonce must be calculated as for [encryption](encrypt-structure.md#calculate-cipherkey-and-nonce).

### Construct Decrypted Structured Data

In the output [Crypto List](./structures.md#crypto-list):

- An entry MUST NOT exist with the key "aws_dbe_head" or "aws_dbe_foot".
- For every entry in the [input Auth List](#auth-list), other than the header and footer,
  an entry MUST exist with the same key in the output Crypto List.
- For every entry in the output Crypto List
  an entry MUST exist with the same key in the [input Auth List](#auth-list).
  Put plainly, the output does not add or drop any entries during decryption, other than the header and footer.

For each entry in the output Crypto List:

If the action is [ENCRYPT_AND_SIGN](./structures.md#encryptandsign)
this Terminal Data MUST have [Terminal Type ID](./structures.md#terminal-type-id)
equal to the first two bytes of the input Terminal Data's value,
and a value equal to the [decryption](#terminal-data-decryption) of the input Terminal Data's value.

Otherwise, this Terminal Data MUST have [Terminal Type ID](./structures.md#terminal-type-id) and
[Terminal Value](./structures.md#terminal-value) equal to the input Terminal Data.

The output MUST also include a [Parsed Header](#parsed-header) that contains
data that was serialized into the header included in the output Structured Data.

#### Terminal Data Decryption

Decryption of [Terminal Data](./structures.md#terminal-data) takes a
encrypted Terminal Data as input, and returns a Terminal Data.

The input [Terminal Value](./structures.md#terminal-value) MUST be deserialized as follows:

| Field                    | Length   |
| ------------------------ | -------- |
| Terminal Type Id         | 2        |
| Encrypted Terminal Value | Variable |

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
