[//]: # "Copyright Amazon.com Inc. or its affiliates. All Rights Reserved."
[//]: # "SPDX-License-Identifier: CC-BY-SA-4.0"

# Structures

## Version

1.1.0

### Changelog

- 1.1.0
  - Update for simplified structured encryption

- 1.0.0
  - Initial record

## Definitions

### Conventions used in this document

The key words "MUST", "MUST NOT", "REQUIRED", "SHALL", "SHALL NOT", "SHOULD", "SHOULD NOT", "RECOMMENDED", "MAY", and "OPTIONAL"
in this document are to be interpreted as described in [RFC 2119](https://tools.ietf.org/html/rfc2119).

## Overview

This document includes the specifications for common structures referenced throughout the
Structured Encryption Library specification.
These structures define a group of related fields that MUST hold certain properties.
Wherever these structures are referenced in this specification,
implementations MUST ensure that all properties of a structure's fields are upheld.

Note that this specification does not specify how these structures should be represented or passed
throughout the Structured Encryption Library.
While these structures will usually be represented as objects, lower level languages MAY represent
these fields in a less strictly defined way as long as all field properties are still upheld.

Structures defined in this document:

- [Authenticate Action](#authenticate-action)
- [Authenticate Schema](#authenticate-schema)
- [Crypto Action](#crypto-action)
- [Crypto Schema](#crypto-schema)
- [Encrypt Action](#encrypt-action)
- [Encryption Context](#encryption-context)
- [Structured Data](#structured-data)
- [Terminal Data](#terminal-data)
- [Path Segment](#path-segment)
- [Path](#path)
- [Crypto Item](#crypto-item)
- [Crypto List](#crypto-list)
- [Auth Item](#auth-item)
- [Auth List](#auth-list)

### Authenticate Action

An Authenticate Action describes whether a particular [Terminal Data](#terminal-data)
is or is not authenticated during the Encrypt Structure and Decrypt Structure operations.

#### Supported Authenticate Actions

##### SIGN

During [Encrypt Structure](./encrypt-structure.md),
SIGN signifies that the [Terminal Data](#terminal-data) MUST be included in the signature calculations
on the footer.

During [Decrypt Structure](./decrypt-structure.md),
SIGN signifies that the [Terminal Data](#terminal-data) MUST be authenticated,
and thus be included in the verification of the signatures on the footer.

##### DO_NOT_SIGN

During [Encrypt Structure](./encrypt-structure.md),
DO_NOT_SIGN signifies that the [Terminal Data](#terminal-data) MUST NOT be included in the signature calculations
on the footer.

During [Decrypt Structure](./decrypt-structure.md),
DO_NOT_SIGN signifies that the [Terminal Data](#terminal-data) MUST NOT be authenticated,
and thus not be included in the verification of the signatures on the footer.

### Authenticate Schema

The Authentication Schema maps a [Authenticate Action](#authenticate-action) to each [Terminal Data](#terminal-data)
within a [Structured Data](#structured-data),
based on that Terminal Data's location within the Structured Data.

### Crypto Action

A Crypto Action is a supported [Authenticate Action](#authenticate-action) and [Encrypt Action](#encrypt-action) pair.

#### Supported Crypto Actions

##### ENCRYPT_AND_SIGN

ENCRYPT_AND_SIGN indicates that the following actions apply to a [Terminal Data](#terminal-data):

- [ENCRYPT](#encrypt)
- [SIGN](#sign)

##### SIGN_ONLY

SIGN_ONLY indicates that the following actions apply to a [Terminal Data](#terminal-data):

- [DO_NOT_ENCRYPT](#do_not_encrypt)
- [SIGN](#sign)

##### SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT

SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT indicates that the following actions apply to a [Terminal Data](#terminal-data):

- [DO_NOT_ENCRYPT](#do_not_encrypt)
- [SIGN](#sign)

and further that the [Terminal Data](#terminal-data) MUST be included in the encryption context.

##### DO_NOTHING

DO_NOTHING indicates that the following actions apply to a [Terminal Data](#terminal-data):

- [DO_NOT_ENCRYPT](#do_not_encrypt)
- [DO_NOT_SIGN](#do_not_sign)

### Crypto Schema

The Crypto Schema maps a [Crypto Action](#authenticate-action) to each [Terminal Data](#terminal-data)
within a [Structured Data](#structured-data),
based on that Terminal Data's location within the Structured Data.

### Encrypt Action

An Encrypt Action describes whether a particular [Terminal Data](#terminal-data)
is or is not encrypted and decrypted during the Encrypt Structure and Decrypt Structure operations.

#### Supported Encrypt Actions

##### ENCRYPT

During [Encrypt Structure](encrypt-structure.md#encrypt-structure),
ENCRYPT signifies that the [Terminal Value](#terminal-value) in the [Terminal Data](#terminal-data)
MUST be encrypted in the resulting encrypted [Structured Data](#structured-data).

During [Decrypt Structure](decrypt-structure.md#decrypt-structure),
ENCRYPT signifies that the [Terminal Value](#terminal-value) in the [Terminal Data](#terminal-data)
MUST be attempted to be decrypted.

##### DO_NOT_ENCRYPT

During [Encrypt Structure](encrypt-structure.md#encrypt-structure)
and [Decrypt Structure](decrypt-structure.md#decrypt-structure),
DO_NOT_ENCRYPT signifies that the [Terminal Data](#terminal-data)
MUST have an equal [Terminal Value](#terminal-value) and
[Terminal Type Id](#terminal-type-id) as the the Terminal Data
in the same location in the resulting encrypted [Structured Data](#structured-data).
No encryption or decryption is performed on the Terminal Data.

### Encryption Context

[The Encryption Context as defined by the Material Providers Library specification.](https://github.com/awslabs/private-aws-encryption-sdk-specification-staging/blob/master/framework/structures.md#encryption-context)

### Structured Data

Structured Data is intended to support
the expression of most [JSON](https://datatracker.ietf.org/doc/html/rfc7159) and [XML](https://www.w3.org/TR/xml/) data.

Structured Data is expressed as a [Structured Data Map](#structured-data-map)

#### Structured Data Map

A Structured Data Map MUST consist of:

- A map strings to [Terminal Data](#terminal-data)
  - This map MUST NOT allow duplicate key values

### Terminal Data

Terminal Data is a structure that contains:

- Terminal Type ID
- Terminal Value

#### Terminal Type ID

A Terminal Type ID MUST be a 2 byte value that is used to identify how callers interpret [Terminal Value](#terminal-value).

If [Terminal Value](#terminal-value) is to be interpreted as raw bytes,
the Terminal Type ID MUST be 0xFFFF.
Any other value prefixed by 0xFF is reserved and MUST NOT be used.

It is the responsibility of the caller to define and maintain a mapping of Terminal Type IDs (including 0xFFFF) to specific types
and how those types should be serialized and deserialized.

#### Terminal Value

Terminal Value MUST be a sequence of bytes, and MAY be empty (zero-length).

If these bytes are to be deserialized, these bytes MUST be interpreted as the type indicated in this Terminal Data's [Terminal Type ID](#terminal-type-id).D

### Path Segment

A path segment MUST be a string, designating the name of a member of a structure.

In the future, a path segment might also refer to an index into a list, or to an attribute name.

### Path

A path is a sequence of [path segments](#path-segment) that refer to a location within a structure.

### Crypto Item

A crypto item MUST consist of

- a [Path](#path)
- a [Crypto Action](#crypto-action)
- a [Terminal Data](#terminal-data)

and indicates that this data exists at this location, and should be handled with this action.

### Crypto List

A crypto list MUST be a sequence of [crypto item](#crypto-item)

### Auth Item

An auth item MUST consist of

- a [Path](#path)
- an [Authenticate Action](#authenticate-action)
- a [Terminal Data](#terminal-data)

and indicates that this data exists at this location, and should be handled with this action.

### Auth List

An auth list MUST be a sequence of [auth item](#auth-item)
