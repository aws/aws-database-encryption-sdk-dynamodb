[//]: # "Copyright Amazon.com Inc. or its affiliates. All Rights Reserved."
[//]: # "SPDX-License-Identifier: CC-BY-SA-4.0"

# Simplify Structure Encryption

The smithy model for Structure Encryption has changed.

This is considered a non-breaking change,
because Structure Encryption is not supposed to be used directly by customers.

The other smithy models (ItemEncryptor et al) have NOT changed.

## EncryptStructure and DecryptStructure

The interfaces of these two functions are slightly changed,
and are implemented as thin wrappers around EncryptPathStructure and DecryptPathStructure.

First, the maps passed in are no longer the complex recursive structures,
simple key-value maps where the key is a plain string,
and the value is a StructuredDataTerminal, CryptoAction or AuthenticateAction.

Further, the CryptoAction maps has moved from `output.parsedHeader.cryptoSchema` to `output.cryptoSchema`.

This latter change is so that `*cryptStructure` and `*cryptPathStructure`
can use the same ParsedHeader.

## EncryptPathStructure and DecryptPathStructure

These are the same as their non-path counter parts, except where EncryptStructure and DecryptStructure
deal in pairs of maps, e.g.

- data : map<String, StructuredDataTerminal>
- actions : map<String, CryptoAction>

These two take a single parameter which is a list of

- path : Path
- data : StructuredDataTerminal
- action : CryptoAction

and exhibit the same behavior, other than needing to generalize from string to path.

## ResolveAuthActions

Convert AuthActions into CryptoActions, without doing any decryption.
Useful if you need to know which fields are encrypted BEFORE you can properly call DecryptStructure or DecryptPathStructure.
