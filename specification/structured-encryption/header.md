[//]: # "Copyright Amazon.com Inc. or its affiliates. All Rights Reserved."
[//]: # "SPDX-License-Identifier: CC-BY-SA-4.0"

# Structured Encryption Header

## Overview

The header is a special [Terminal Data](./structures.md#terminal-data)
that exists on encrypted [Structured Data](./structures.md#structured-data)
in order to store metadata on its encryption.

## Header Value

### Partial Header

The Partial Header MUST be

| Length (bytes) | Meaning                                     |
| -------------- | ------------------------------------------- |
| 1              | [Format Version](#format-version)           |
| 1              | [Format Flavor](#format-flavor)             |
| 32             | [Message ID](#message-id)                   |
| Variable       | [Encrypt Legend](#encrypt-legend)           |
| Variable       | [Encryption Context](#encryption-context)   |
| Variable       | [Encrypted Data Keys](#encrypted-data-keys) |

### Full Header Value

The value of the header MUST be

| Length (bytes) | Meaning                                 |
| -------------- | --------------------------------------- |
| Variable       | [Partial Header](#partial-header)       |
| 32             | [Header Commitment](#header-commitment) |

### Format Version

The message format version dictates the cryptographic algorithms supported
as well as the specific serialized header and footer format.

The Version MUST be `0x01` or `0x02`.

If any [Crypto Action](./structures.md#crypto-action) is configured as
[SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT Crypto Action](./structures.md#sign_and_include_in_encryption_context)
the Version MUST be 0x02; otherwise, Version MUST be 0x01.

### Format Flavor

The flavor dictates the
[algorithm suite](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/algorithm-suites.md)
this message is written under.
Specifically, the flavor is stored as a single byte, representing the second byte of the
Algorithm Suite ID; with the first byte assumed to be 0x67.
The algorithm suite indicated by the flavor MUST be a
[DBE supported algorithm suite](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/algorithm-suites.md#supported-algorithm-suites-enum).

| Value | Algorithm Suite ID | Algorithm Suite Enum                                                 |
| ----- | ------------------ | -------------------------------------------------------------------- |
| 0x00  | 0x67 0x00          | ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_SYMSIG_HMAC_SHA384            |
| 0x01  | 0x67 0x01          | ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_ECDSA_P384_SYMSIG_HMAC_SHA384 |

### Message ID

The Message ID is a random 256-bit value.

Implementations MUST generate a fresh 256-bit random MessageID, from a cryptographically secure source, for each record encrypted.

### Encrypt Legend

The Encrypt Legend is a serialized description of which authenticated fields in the record were encrypted.

The Encrypt Legend MUST be serialized as

| Field                                         | Length (bytes)                                                                          | Interpreted as    |
| --------------------------------------------- | --------------------------------------------------------------------------------------- | ----------------- |
| Encrypt Legend Length                         | 2                                                                                       | big endian UInt16 |
| [Encrypt Legend Bytes](#encrypt-legend-bytes) | Variable. Equal to the value specified in the previous 2 bytes (Encrypt Legend Length). | Bytes             |

#### Encrypt Legend Bytes

Each Crypto Action MUST be encoded as follows

- `0x65` (`e` in UTF-8, for "Encrypt and Sign") means that a particular field was encrypted
  and included in the signature calculation.
  This indicates that this field MUST be attempted to be decrypted during decryption.
- `0x73` (`s` in UTF-8, for "Sign Only") means that a particular field was not encrypted,
  but still included in the signature calculation.
  This indicates that this field MUST NOT be attempted to be decrypted during decryption.
- `0x63` (`c` in UTF-8, for "Context") means that a particular field was not encrypted,
  but still included in the signature calculation,
  as well as being included in the encryption context.
  This indicates that this field MUST NOT be attempted to be decrypted during decryption.
- no entry if the attribute is not signed

The Encrypt Legend Bytes MUST be serialized as follows:

1. Order every authenticated attribute in the item by the [Canonical Path](#canonical-path)
2. For each authenticated terminal, in order,
   append one of the byte values specified above to indicate whether
   that field should be encrypted.

The length of this serialized value (in bytes) MUST equal the number of authenticated fields indicated
by the caller's [Authenticate Schema](./structures.md#authenticate-schema).

#### Canonical Path

The canonical path is a unique byte sequence indicating a Terminal within Structured Data.

All numbers are encoded as a big endian 8 byte values.

The canonical path MUST start with the UTF8 encoded table name.

This MUST be followed by the depth of the Terminal within Structured Data.

This MUST be followed by the encoding for each Structured Data in the path, including the Terminal itself.

For Structured Data in Structured Data Lists, this MUST be a 0x23 byte (# in UTF-8),
followed by the numerical index.

For Structured Data in Structured Data Maps, this MUST be a 0x24 byte ($ in UTF-8),
followed by the length of the key, followed by the key as a UTF8 string.

### Encryption Context

The Encryption Context MUST be serialized as follows

| Field                                             | Length (bytes)                                                       | Interpreted as                                    |
| ------------------------------------------------- | -------------------------------------------------------------------- | ------------------------------------------------- |
| [Key Value Pair Count](#key-value-pair-count)     | 2                                                                    | big endian UInt16                                 |
| [Key Value Pair Entries](#key-value-pair-entries) | Variable. Determined by the count and length of each key-value pair. | [Key Value Pair Entries](#key-value-pair-entries) |

#### Key Value Pair Count

The number of key-value pairs within the [Key Value Pair Entries](#key-value-pair-entries) field.

#### Key Value Pair Entries

A sequence of one or more key-value pair entries.

This sequence MUST NOT contain duplicate entries.

These entries MUST have entries sorted, by key,
in ascending order according to the UTF-8 encoded binary value.

Each Key Value Pair MUST be serialized as follows

| Field        | Length (bytes)                                                                 | Interpreted as      |
| ------------ | ------------------------------------------------------------------------------ | ------------------- |
| Key Length   | 2                                                                              | big endian UInt16   |
| Key          | Variable. Equal to the value specified in the previous 2 bytes (Key Length).   | UTF-8 encoded bytes |
| Value Length | 2                                                                              | big endian UInt16   |
| Value        | Variable. Equal to the value specified in the previous 2 bytes (Value Length). | UTF-8 encoded bytes |

### Encrypted Data Keys

The Encrypted Data Keys MUST be serialized as follows

| Field                                                     | Length (bytes)                                                       | Interpreted as                                            |
| --------------------------------------------------------- | -------------------------------------------------------------------- | --------------------------------------------------------- |
| [Encrypted Data Key Count](#encrypted-data-key-count)     | 1                                                                    | unsigned 8 bit number                                     |
| [Encrypted Data Key Entries](#encrypted-data-key-entries) | Variable. Determined by the count and length of each key-value pair. | [Encrypted Data Key Entries](#encrypted-data-key-entries) |

#### Encrypted Data Key Count

The number of encrypted data keys.
This value MUST be greater than 0.

#### Encrypted Data Key Entries

Each Encrypted Data Key MUST be serialized as follows

| Field                                                               | Length (bytes)                                                                                    | Interpreted as      |
| ------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------- | ------------------- |
| [Key Provider ID Length](#key-provider-id-length)                   | 2                                                                                                 | big endian UInt16   |
| [Key Provider ID](#key-provider-id)                                 | Variable. Equal to the value specified in the previous 2 bytes (Key Provider ID Length).          | UTF-8 encoded bytes |
| [Key Provider Information Length](#key-provider-information-length) | 2                                                                                                 | big endian UInt16   |
| [Key Provider Information](#key-provider-information)               | Variable. Equal to the value specified in the previous 2 bytes (Key Provider Information Length). | Bytes               |
| [Encrypted Data Key Length](#encrypted-data-key-length)             | 2                                                                                                 | big endian UInt16   |
| [Encrypted Data Key](#encrypted-data-key)                           | Variable. Equal to the value specified in the previous 2 bytes (Encrypted Data Key Length).       | Bytes               |

##### Key Provider ID Length

The length of the key provider ID.

##### Key Provider ID

The key provider ID.

##### Key Provider Information Length

The length of the key provider information.

##### Key Provider Information

The key provider information.

##### Encrypted Data Key Length

The length of the encrypted data key.

##### Encrypted Data Key

The encrypted data key.
It is the data key encrypted by the key provider.

### Header Commitment

#### Commit Key

The HKDF used to calculate the Commitment Key MUST be the
[Commit Key KDF](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/algorithm-suites.md#algorithm-suites-commit-key-derivation-settings)
indicated by the algorithm suite.

The calculated Commitment Key MUST have length equal to the
[algorithm suite's encryption key length](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/algorithm-suites.md#algorithm-suites-encryption-settings).

The `info` used for the HKDF function MUST be
| Field | Length |
| -------------------- | -------- |
| "AWS_DBE_COMMIT_KEY" | 18 |
| Message ID | 32 |

The HKDF calculation MUST use a supplied key, no salt, and an `info` as described above.

The commit key calculation described above MUST be performed with the record's plaintext data key
and the header's message id.

#### Commitment Calculation

The Header Commitment MUST be calculated as a the first 32 bytes of an HmacSha384,
with the serialized partial header as the message, and the Commit Key as the key.
For example

```python
def GetHeaderCommitment(Header, CommitKey):
    # Truncate to 256 bits (32 bytes; returning only the leftmost bits)
    return HmacSha384(Header, CommitKey)[0:32]

def CheckHeaderCommitment(Header, CommitKey):
    Commitment = Header[-32:32]  # Last 32 bytes of the header
    Preceding = Header[:-32]     # Everything before the Header Commitment
    return ConstantTimeEquals(Commitment, GetHeaderCommitment(Preceding, CommitKey)
```

#### Commitment Verification

To verify a header, recalculate the [Header Commitment](#header-commitment) and
compare it to the stored [Header Commitment](#header-commitment).

Header commitment comparisons MUST be constant time operations.

## Notes

While the Header Commitment does
produce a distinct 256-bit hash output per header and commitment key,
it does not provide any integrity guarantees over the encrypted attributes.
Integrity over the encrypted attributes is ensured by the signatures in the
[footer](footer.md).
