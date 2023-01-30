
# Structured Encryption Footer

## Footer Format

The serialized form of the footer MUST be

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
