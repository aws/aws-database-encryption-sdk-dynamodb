
# Structured Encryption Footer

## Overview

The footer is a special [Terminal Data](./structures.md#terminal-data)
that exists on encrypted [Structured Data](./structures.md#structured-data)
in order to store signatures over signed values in that structured data.

## Footer Index

The header MUST exist at string index "aws-dbe-foot" for
encrypted [Structured Data](./structures.md#structured-data).

## Footer Format

The [Terminal Type ID](./structures.md#terminal-type-id) MUST be `0xFF 0xFF`.

The [Terminal Value](./structures.md#terminal-value) of the footer MUST be

| Field | Length (bytes) | Interpreted as |
| ----- | -------------- | -------------- |
| [HMACs](#hmacs) | Variable. Equal to 48 times the value specified in the previous 2 bytes (HMAC Count). | [HMAC Count](#hmac-count) individual HMACs |
| [Signature](#signature) | 0 or 96 | Signature, if signatures are enabled |

### HMACs

There MUST be one HMAC for each Encrypted Data Keys in the [header](./header.md#encrypted-data-keys)

Each HMAC for each Encrypted Data Key MUST be calculated as follows :

TODO - HMAC of the name and contents and such

## Signature

The signature MUST be included in the footer if the flavor
in the [header](./header.md#format-flavor) is 0x01
and MUST NOT be included in the footer if the flavor
in the [header](./header.md#format-flavor) is 0x00.

If the signature is included, it MUST be calculated as follows:

TODO - more elaborate signature function over the same data as the HMACs above
