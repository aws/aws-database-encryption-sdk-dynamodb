
# Structured Encryption Footer

## Footer Format

The serialized form of the footer MUST be

| Field | Length (bytes) | Interpreted as |
| ----- | -------------- | -------------- |
| [HMACs](#hmacs) | Variable. Equal to 48 times the value specified in the previous 2 bytes (HMAC Count). | [HMAC Count](#hmac-count) individual HMACs |
| [Signature](#signature) | 0 or 96 | Signature, if signatures are enabled |

### HMACs

There MUST be one HMAC for each Encrypted Data Keys in the [header](./header.md#encrypted-data-keys)

Each HMAC for each Encrypted Data Key MUST be calculated as follows:

1. Order every authenticated attribute in the item lexicographically by the attribute name.
2. Initialize a SHA384 for streaming. For each authenticated attribute, in order,
append the following bytes
 * the attribute name
 * the 8-byte big endian length of the attribute value
 * "ENCRYPTED" if the value is encrypted; "PLAINTEXT" otherwise.
 * the attribute value
3. Calculate the HmacSha384 of the hash caluculated in step 2 with some key or other

## Signature

The signature MUST be included in the footer if the flavor
in the [header](./header.md#format-flavor) is 0x01
and MUST NOT be included in the footer if the flavor
in the [header](./header.md#format-flavor) is 0x00.

If the signature is included, it MUST be calculated as follows:

1. Calculate a hash as per steps 1 and 2 in [HMACs](#hmacs) above.
2. Calculate the EcdsaP384Sha384 of that hash with the Plaintext Data Key

