[//]: # "Copyright Amazon.com Inc. or its affiliates. All Rights Reserved."
[//]: # "SPDX-License-Identifier: CC-BY-SA-4.0"

# String Ordering

## Version

1.0.0

### Changelog

- 1.0.0
  - Initial record

## Definitions

### Conventions used in this document

The key words "MUST", "MUST NOT", "REQUIRED", "SHALL", "SHALL NOT", "SHOULD", "SHOULD NOT", "RECOMMENDED", "MAY", and "OPTIONAL"
in this document are to be interpreted as described in [RFC 2119](https://tools.ietf.org/html/rfc2119).

### Unicode

For the latest version see:
https://www.unicode.org/versions/latest/

For Version 15.0 see:
https://www.unicode.org/versions/Unicode15.0.0/

### Unicode scalar value

Any Unicode code point except [surrogate](#surrogates) code points.

See [section 3.9 Unicode Encoding Forms](https://www.unicode.org/versions/Unicode15.0.0/ch03.pdf) of the Unicode specification.

### UTF-16 code unit

A 16-bit value representing a Unicode code point in a UTF-16 encoding.
Includes [surrogate](#surrogates) code points.

See [section 3.9 Unicode Encoding Forms](https://www.unicode.org/versions/Unicode15.0.0/ch03.pdf) of the Unicode specification.

### Surrogates

Unicode code points in the range U+D800 to U+DFFF.
These code points are only used in UTF-16 encodings
to represent Unicode values above U+FFFF.

See [section 3.8 Surrogates](https://www.unicode.org/versions/Unicode15.0.0/ch03.pdf) of the Unicode specification.

## Overview

There are several instances throughout this specification where an order must be
imposed on an unordered data structure during serialization for the purposes of canonicalization.
This means that we must clearly specify the canonical ordering wherever
such serialization is required.
This is especially importing when ordering strings,
as different encodings may lend themselves to slightly different orderings.

Wherever strings need to be ordered,
this specification will require either a [code point order](#code-point-order)
or a [UTF-16 binary order](#utf-16-binary-order).

## UTF-16 Binary Order

When ordering strings,
these strings MUST be compared according to their UTF-16 encoding,
lexicographically per [UTF-16 code unit](#utf-16-code-unit).
UTF-16 code units for [high or low surrogates](#surrogates) MUST be compared individually,
and the [Unicode scalar value](#unicode-scalar-value) represented by a surrogate pair
MUST NOT be compared.

Note that this is not equivalent to the [code point order](#code-point-order).
Specifically, the range of characters with Unicode code point U+E000 to U+0xFFFF
(code points representable by 16 bits, but after the surrogate range)
MUST be considered "greater than" any character with a Unicode code point of U+10000 to U+10FFFF.

As an example, consider the following two characters:

| char | Unicode code point | UTF-16 encoding |
| ---- | ------------------ | --------------- |
| `｡`  | U+FF61             | 0xFF61          |
| `𐀂`  | U+10002            | 0xD800 0xDC02   |

This ordering will order `｡` _after_ `𐀂`, despite `𐀂` having a higher Unicode code point.

## Code Point Order

This is the ordering referred to in the Unicode specification as a [code point order](https://www.unicode.org/versions/Unicode15.0.0/ch05.pdf).

When ordering strings,
these strings are compared lexicographically per [Unicode scalar value](#unicode-scalar-value) represented by the string.
This means that if a string is UTF-16 encoded,
higher order Unicode characters, encoded as a surrogate pair,
must be handled as the Unicode scalar value represented by that surrogate pair,
instead of each surrogate code point being handled individually.

Note that this is equivalent to lexicographically comparing a UTF-8 encoded string per byte.
This is also equivalent to lexicographically comparing a UTF-32 encoded string per 32-bit code unit.

Currently, this specification does not directly use code point order for sorting string values,
but may use this ordering for new behaviors in the future.
