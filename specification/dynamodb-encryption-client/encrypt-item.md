[//]: # "Copyright Amazon.com Inc. or its affiliates. All Rights Reserved."
[//]: # "SPDX-License-Identifier: CC-BY-SA-4.0"

# Encrypt Item

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

This document describes the behavior by which the [DynamoDB Item Encryptor](./ddb-item-encryptor.md)
produces an encrypted form of a DynamoDB Item for a particular DynamoDB Table.

## Input

The following inputs to this behavior are REQUIRED:

- DynamoDB Item

### DynamoDB Item

The DynamoDB Item is the plaintext item to be encrypted by this behavior.

This item MUST include an Attribute with a name that matches the
[DynamoDB Partition Key Name](./ddb-table-encryption-config.md#dynamodb-partition-key-name)
configured on the [DynamoDB Item Encryptor](./ddb-item-encryptor.md).
Otherwise this operation MUST yield an error.

If the [DynamoDB Item Encryptor](./ddb-item-encryptor.md)
has a [DynamoDB Sort Key Name](./ddb-table-encryption-config.md#dynamodb-sort-key-name) configured,
this item MUST include an Attribute with that name.
Otherwise this operation MUST yield an error.

If the [DynamoDB Item Encryptor](./ddb-item-encryptor.md)
has any attribute configured as
[SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT](../structured-encryption/structures.md#contextandsign)
then this item MUST include an Attribute with that name.

## Output

This operation MUST output the following:

- [Encrypted DynamoDB Item](#encrypted-dynamodb-item)

This operation MUST also output a [Parsed Header](#parsed-header) if the following is true:

- The operation is not using a [Legacy Policy](./ddb-table-encryption-config.md#legacy-policy) that allows legacy decrypts,
  and the input item is a [legacy item](./decrypt-item.md#determining-legacy-items).
- The operation is not using a [Plaintext Policy](./ddb-table-encryption-config.md#plaintext-policy) that allows plaintext reads,
  and the input item is a [plaintext item](./decrypt-item.md#determining-plaintext-items).

### Encrypted DynamoDB Item

The Encrypted DynamoDB Item is a DynamoBD Item that is
the encrypted form of the [input DynamoDB Item](#dynamodb-item).

### Parsed Header

This structure MUST contain the following values,
representing the deserialized form of the header of the input encrypted structure:

- [Algorithm Suite ID](./header.md#format-flavor): The Algorithm Suite ID associated with the Format Flavor on the header.
- [Attribute Actions](./ddb-table-encryption-config.md#attribute-actions): The Crypto Schema for each signed attribute,
  calculated using the Crypto Legend in the header, the signature scope used for decryption, and the data in the structure,
  converted into Attribute Actions.
- [Encrypted Data Keys](./header.md#encrypted-data-keys): The Encrypted Data Keys stored in the header.

## Behavior

If a [Legacy Policy](./ddb-table-encryption-config.md#legacy-policy) of
`FORCE_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT` is specified,
this operation MUST delegate encryption of this item to the
[Legacy Encryptor](./ddb-table-encryption-config.md#legacy-encryptor),
using the configured [Attribute Flags](./ddb-table-encryption-config.md) as input.
The item returned by this operation MUST be the item outputted by the
[Legacy Encryptor](./ddb-table-encryption-config.md#legacy-encryptor).
Otherwise, this operations continues as follows.

If a [Plaintext Policy](./ddb-table-encryption-config.md#plaintext-policy) of
`FORCE_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ` is specified,
this operation MUST NOT encrypt the input item,
and MUST passthrough that item as the output.

The [Attributes Actions](./ddb-table-encryption-config.md#attribute-actions)
configured on this Item Encryptor MUST specify a Crypto Action
for every attribute in the [input DynamoDB Item](#dynamodb-item)
(Attribute Actions MAY specify a Crypto Action for an attribute not
in the input DynamoDB Item).

This behavior REQUIRES a [Structured Data](../structured-encryption/structures.md#structured-data)
which is [converted](./ddb-item-conversion.md) from the [input DynamoDB Item](#dynamodb-item).

This operation MUST create a
[Required Encryption Context CMM](https://github.com/awslabs/private-aws-encryption-sdk-specification-staging/blob/dafny-verified/framework/required-encryption-context-cmm.md)
with the following inputs:

- This item encryptor's [CMM](./ddb-table-encryption-config.md#cmm) as the underlying CMM.
- The keys from the [DynamoDB Item Base Context](#dynamodb-item-base-context)

Given the converted [Structured Data](../structured-encryption/structures.md#structured-data),
this operation MUST delegate encryption of this data to
Structured Encryption Client's [Encrypt Structure](../structured-encryption/encrypt-structure.md),
with the following inputs:

- Structured Data MUST be the Structured Data converted above.
- Crypto Schema MUST be a [Crypto Schema](../structured-encryption/structures.md#crypto-schema)
  analogous to the [configured Attribute Actions](./ddb-table-encryption-config.md#attribute-actions).
  More specifically:
  - For every attribute on the input Item,
    there MUST exist a Crypto Action in the Crypto Schema
    such that the Crypto Action indexed by that attribute name in the Crypto Schema
    equals the Crypto Action indexed by that attribute name in the configured Attribute Actions.
  - The Crypto Schema MUST NOT contain more Crypto Actions than those specified by the previous point.
    E.g. the Crypto Schema must not specify actions for attributes that don't exist on the item.
- If configured, the Algorithm Suite MUST be the
  [Algorithm Suite configured on this Item Encryptor](./ddb-table-encryption-config.md#algorithm-suite).
  If not configured on the Item Encryptor, Algorithm Suite MUST NOT be specified.
- Encryption Context MUST be this input Item's [DynamoDB Item Base Context](#dynamodb-item-base-context).
- The CMM MUST be the CMM created above.

The output to this behavior is the [conversion](./ddb-item-conversion.md)
of the Encrypted Structured Data determined above
into the [Encrypted DynamoDB Item](#encrypted-dynamodb-item).

### DynamoDB Item Base Context

If the [Configuration Version](./ddb-table-encryption-config.md#configuration-version) is 2,
then the base context MUST be the [version 2](#dynamodb-item-base-context-version-2) context;
otherwise, the base context MUST be the [version 1](#dynamodb-item-base-context-version-1) context.

### DynamoDB Item Base Context Version 1

A DynamoDB Item Base Context is a map of string key-values pairs
that contains information related to a particular DynamoDB Item.

The DynamoDB Item Base Context MUST contain:

- the key "aws-crypto-table-name" with a value equal to the configured
  [logical table name](./ddb-table-encryption-config.md#logical-table-name).
- the key "aws-crypto-partition-name" with a value equal to the name of the Partition Key on this item.
- the [value](#base-context-value-version-1) of the Partition Key.

If this item has a Sort Key attribute, the DynamoDB Item Base Context MUST contain:

- the key "aws-crypto-sort-name" with a value equal to the [DynamoDB Sort Key Name](./ddb-table-encryption-config.md#dynamodb-sort-key-name).
- the [value](#base-context-value-version-1) of the Sort Key.

If this item does not have a sort key attribute,
the DynamoDB Item Context MUST NOT contain the key `aws-crypto-sort-name`.

### DynamoDB Item Base Context Version 2

A DynamoDB Item Base Context is a map of string key-values pairs
that contains information related to a particular DynamoDB Item.

The DynamoDB Item Base Context MUST contain:

- the key "aws-crypto-table-name" with a value equal to the DynamoDB Table Name of the DynamoDB Table
  this item is stored in (or will be stored in).
- the key "aws-crypto-partition-name" with a value equal to the name of the Partition Key on this item.

If this item has a Sort Key attribute, the DynamoDB Item Base Context MUST contain:

- the key "aws-crypto-sort-name" with a value equal to the [DynamoDB Sort Key Name](./ddb-table-encryption-config.md#dynamodb-sort-key-name).

If this item does not have a sort key attribute,
the DynamoDB Item Context MUST NOT contain the key `aws-crypto-sort-name`.

#### Base Context Value Version 1

The key MUST be as per [Encryption Context Naming]
(../structured-encryption/encrypt-path-structure.md#encryption-context-naming).

The value MUST be the UTF8 Encoding of the
[Base 64 encoded](https://www.rfc-editor.org/rfc/rfc4648),
of the concatenation of the bytes `typeID + serializedValue`
where `typeId` is the attribute's [type ID](./ddb-attribute-serialization.md#type-id)
and `serializedValue` is the attribute's value serialized according to
[Attribute Value Serialization](./ddb-attribute-serialization.md#attribute-value-serialization).

#### Base Context Value Version 2

The key MUST be as per [Encryption Context Naming]
(../structured-encryption/encrypt-path-structure.md#encryption-context-naming).

The value MUST be :

- If the type is Number or String, the unaltered (already utf8) bytes of the value
- If the type if Null, the string "null"
- If the type is Boolean, then the string "true" for true and the string "false" for false.
- Else, the value as defined in [Base Context Value Version 1](#base-context-value-version-1)
