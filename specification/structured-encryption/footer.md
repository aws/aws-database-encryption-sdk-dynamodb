
# Structured Encryption Footer

## Overview

The footer is a special [Terminal Data](./structures.md#terminal-data)
that exists on encrypted [Structured Data](./structures.md#structured-data)
in order to store signatures over signed fields in that structured data.

## Signed Fields

When encrypting, `signed fields` refers to all fields for which the
[Crypto Schema](./structures.md#crypto-schema) indicates `ENCRYPT_AND_SIGN` or `SIGN_ONLY`.

When decrypting `signed fields` refers to all fields for which the
the [Authenticate Schema](#authenticate-schema) indicates `SIGN`

## Footer Format

The [Terminal Value](./structures.md#terminal-value) of the footer MUST be

| Field | Length (bytes) | Interpreted as |
| ----- | -------------- | -------------- |
| [Recipient Tags](#recipient-tags) | Variable. 48 bytes per Encrypted Data Key in the header | Bytes |
| [Signature](#signature) | 0 or 96 | Signature, if signatures are enabled |

### Canonical Hash

A canonical hash is calculated for the encrypted form of a record.
This hash is used to calculate the HMACs and Signature.

#### Canonical Field

The canonical form of a field MUST be the concatenation of
 - the canonical path of the field
 - if the field is encrypted, the original data length as an 8-byte integer, followed by the literal "ENCRYPTED"
 - otherwise, the data length as an 8-byte integer, followed by the literal "PLAINTEXT", followed by the 2-byte data type
 - the value of the field

The original data length of an encrypted field will be two less than its encrypted form
because the encrypted form starts with the two byte unencrypted data type.

#### Canonical Record

The canonical form of a record MUST be the concatenation of
 - the full header with commitment
 - the 8-byte length of the AAD followed by the AAD value, or just a zero length if no AAD is used. The AAD value is the serialization of the Encryption Context from the Encryption MAterials.
 - for each [signed field](#signed-fields), ordered lexicographically by canonical path, the canonical field

#### Hash Calculation

The canonical hash of a record MUST be the SHA384 of the canonical form of the record.

### Recipient Tags

There MUST be one Recipient Tag for each Encrypted Data Key in the [header](./header.md#encrypted-data-keys)

The encryption materials provide a list of encrypted data keys,
and an associated list of symmetricSigningKeys,
representing authorize recipients.

the Recipient Tag MUST be MUST be calculated over the [Canonical Hash](#canonical-hash)
using the [symmetric signature algorithm](../../private-aws-encryption-sdk-dafny-staging/aws-encryption-sdk-specification/framework/algorithm-suites.md#algorithm-suites-signature-settings)
indicated in the algorithm suite,
and the
[symmetric signing keys](../../private-aws-encryption-sdk-dafny-staging/aws-encryption-sdk-specification/framework/structures.md#symmetric-signing-keys)
in the encryption materials.

the HMAC values MUST have the same order as the
[symmetric signing keys](../../private-aws-encryption-sdk-dafny-staging/aws-encryption-sdk-specification/framework/structures.md#symmetric-signing-keys)
used to calculate them.

## Signature

The signature MUST be included in the footer if the flavor
in the [header](./header.md#format-flavor) is 0x01
and MUST NOT be included in the footer if the flavor
in the [header](./header.md#format-flavor) is 0x00.

The `signature`, if it exists, MUST be calculated over the [Canonical Hash](#canonical-hash),
using the asymmetric signing key in the encryption materials.

The `signature`, if it exists, MUST be calculated using the
[asymmetric signature algorithm](../../private-aws-encryption-sdk-dafny-staging/aws-encryption-sdk-specification/framework/algorithm-suites.md#algorithm-suites-signature-settings)
indicated by the algorithm suite.

## Footer Verification

The footer is verified before it's record is decrypted. 

### Recipient Tag Verification

Verification MUST fail unless at least one of the [Recipient Tags](#recipient-tags)
matches a calculated recipient tag using the provided symmetricSigningKey.

### Signature Verification

If the footer contains a signature, this signature MUST be verified using the
[asymmetric signature algorithm](../../private-aws-encryption-sdk-dafny-staging/aws-encryption-sdk-specification/framework/algorithm-suites.md#algorithm-suites-signature-settings)
indicated by the algorithm suite.

