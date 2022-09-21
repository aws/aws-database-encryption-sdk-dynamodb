[//]: # "Copyright Amazon.com Inc. or its affiliates. All Rights Reserved."
[//]: # "SPDX-License-Identifier: CC-BY-SA-4.0"

# Structures

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

- [Crypto Action](#crypto-action)
- [Crypto Schema](#crypto-schema)
- [Encryption Context](#encryption-context)
- [Structured Data](#structured-data)
- [Structured Data Attributes](#structured-data-attributes)
- [Terminal Data](#terminal-data)

### Crypto Action

A Crypto Action describes how a particular [Terminal Data](#terminal-data) should be treated
during the Encrypt Structure and Decrypt Structure operations.

#### Supported Crypto Actions

##### ENCRYPT_AND_SIGN

During [Encrypt Structure](encrypt-structure.md#encrypt-structure),
ENCRYPT_AND_SIGN signifies that the [Terminal Value](#terminal-value) in the [Terminal Data](#terminal-data)
MUST be encrypted in the resulting encrypted [Structured Data](#structured-data),
and the [Terminal Data](#terminal-data) included as part of the signature calculation.

During [Decrypt Structure](decrypt-structure.md#decrypt-structure),
ENCRYPT_AND_SIGN  signifies that the [Terminal Value](#terminal-value) in the [Terminal Data](#terminal-data)
MUST be attempted to be decrypted, and the Terminal Data included as part of the signature verification calculation.

##### SIGN_ONLY

During Encrypt Structure,
signifies that the [Terminal Data](#terminal-data) MUST be included as part of the signature calculation.

During Decrypt Structure,
signifies that the [Terminal Data](#terminal-data) MUST be included as part of the signature verification calculation.

##### IGNORE

Signifies that the [Terminal Data](#terminal-data) MUST NOT be included in any signature calculation as part of
Encrypt Structure or Decrypt Structure.

Additionally signifies that the [Terminal Data](#terminal-data) on output MUST equal that Terminal Data on input for
Encrypt Structure and Decrypt Structure.

### Crypto Schema

The Crypto Schema maps what [Crypto Action](#crypto-action) MUST be performed on what [Terminal Data](#terminal-data)
during encryption and decryption, based on that Terminal Data's location within the [Structured Data](#structured-data).

### Encryption Context

The Encryption Context is a key-value mapping of arbitrary, non-secret, UTF-8 encoded strings.
It is used during encryption and decryption to provide additional authenticated data (AAD).

Users SHOULD use the encryption context to store:

- Non-secret data that MUST remain associated with the encrypted [Structured Data](#structured-data).
- Data that is useful in logging and tracking, such as data about the file type, purpose, or ownership.

Users MUST NOT use the encryption context to store secret data.

### Structured Data

Structured Data is a recursively defined structure that is intended to support
the expression of most [JSON](https://datatracker.ietf.org/doc/html/rfc7159) and [XML](https://www.w3.org/TR/xml/) data.

Structured Data is a union of one of three separate structures;
Structured Data MUST be one of:
- [Structured Data Terminal](#structured-data-terminal)
- [Structured Data Map](#structured-data-map)
- [Structured Data List](#structured-data-list)

#### Structured Data Terminal

A Structured Data Terminal MUST consist of:
- a [Terminal Data](#terminal-data)
- an OPTIONAL map of [Attributes](#structured-data-attributes)

#### Structured Data Map

A Structured Data Map MUST consist of:
- A map of UTF8-encoded strings to [Structured Data](#structured-data)
  - This map MUST NOT allow duplicate key values 
- an OPTIONAL map of [Attributes](#structured-data-attributes)

#### Structured Data List

A Structured Data List MUST consist of:

- A numerical-indexed array of [Structured Data](#structured-data).
  - The max length of this list MUST be 2^64 - 1
- an OPTIONAL map of [Attributes](#structured-data-attributes)

### Structured Data Attributes

Structured Data Attributes MUST be map of UTF8-encoded strings to [Terminal Data](#terminal-data).
This data is intended to be an equivalent to XML-like attributes.

### Terminal Data

Terminal Data is a structure that contains:

- Terminal Type ID
- Terminal Value

#### Terminal Type ID

A 2 byte value that is used to identify what type callers MUST interpret [Terminal Value](#terminal-value) as.

If [Terminal Value](#terminal-value) is to be interpreted as raw bytes,
the Terminal Type ID MUST be 0xFFFF.
Any other value prefixed by 0xFF is reserved and MUST NOT be used.

It is the responsiblity of the caller to define and maintain a mapping of Terminal Type IDs (including 0xFFFF) to specific types
and how those types should be serialized and deserialized.

#### Terminal Value

Terminal Value MUST be a sequence of bytes, and MAY be empty (zero-length).

If these bytes are to be deserialized, these bytes MUST be interpreted as the type indicated in this Terminal Data's [Terminal Type ID](#terminal-type-id).D
