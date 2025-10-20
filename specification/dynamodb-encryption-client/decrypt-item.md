[//]: # "Copyright Amazon.com Inc. or its affiliates. All Rights Reserved."
[//]: # "SPDX-License-Identifier: CC-BY-SA-4.0"

# Decrypt Item

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
decrypts a DynamoDB Item originally encrypted via the [Encrypt Item](./encrypt-item.md) operation.

## Input

The following inputs to this behavior are REQUIRED:

- [DynamoDb Item](#input-dynamodb-item)

### Input DynamoDB Item

The DynamoDB Item is the item to be decrypted by this behavior.

This item MUST include an Attribute with a name that matches the
[DynamoDB Partition Key Name](./ddb-table-encryption-config.md#dynamodb-partition-key-name)
configured on the [DynamoDB Item Encryptor](./ddb-item-encryptor.md).
Otherwise this operation MUST yield an error.

If the [DynamoDB Item Encryptor](./ddb-item-encryptor.md)
has a [DynamoDB Sort Key Name](./ddb-table-encryption-config.md#dynamodb-sort-key-name) configured,
this item MUST include an Attribute with that name.
Otherwise this operation MUST yield an error.

## Output

This operation MUST output the following:

- [DynamoDb Item](#output-dynamodb-item)

This operation MUST also output a [Parsed Header](#parsed-header) if the following is true:

- The operation is not using a [Legacy Policy](./ddb-table-encryption-config.md#legacy-policy) that allows legacy decrypts,
  and the input item is a [legacy item](#determining-legacy-items).
- The operation is not using a [Plaintext Policy](./ddb-table-encryption-config.md#plaintext-policy) that allows plaintext reads,
  and the input item is a [plaintext item](#determining-plaintext-items).

### Output DynamoDB Item

The DynamoDB Item is the decryption of the [input DynamoBD Item](#input dynamodb-item).

### Parsed Header

This structure MUST contain the following values,
representing the deserialized form of the header of the input encrypted structure:

- [Algorithm Suite ID](./header.md#format-flavor): The Algorithm Suite ID associated with the Format Flavor on the header.
- [Attribute Actions](./ddb-table-encryption-config.md#attribute-actions): The Crypto Schema for each signed attribute,
  calculated using the Crypto Legend in the header, the signature scope used for decryption, and the data in the structure,
  converted into Attribute Actions.
- [Encrypted Data Keys](./header.md#encrypted-data-keys): The Encrypted Data Keys stored in the header.
- [Stored Encryption Context](../structured-encryption/header.md#encryption-context): The Encryption Context stored in the header.
- [Encryption Context](../structured-encryption/decrypt-structure#encryption-context): The full Encryption Context used.
- Selector Context : the AttributeMap as passed to the [Branch Key Supplier](./ddb-encryption-branch-key-id-supplier.md)

## Behavior

If a [Legacy Policy](./ddb-table-encryption-config.md#legacy-policy) of
`FORBID_LEGACY_ENCRYPT_FORBID_LEGACY_DECRYPT` is configured,
and the input item [is an item written in the legacy format](#determining-legacy-items),
this operation MUST fail.

If a [Legacy Policy](./ddb-table-encryption-config.md#legacy-policy) of
`FORCE_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT` or `FORBID_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT` is configured,
and the input item [is an item written in the legacy format](#determining-legacy-items),
this operation MUST delegate decryption of this item to the
[Legacy Encryptor](./ddb-table-encryption-config.md#legacy-encryptor),
using the configured [Attribute Flags](./ddb-table-encryption-config.md) as input.
The item returned by this operation MUST be the item outputted by the
[Legacy Encryptor](./ddb-table-encryption-config.md#legacy-encryptor).
Otherwise, this operations continues as follows.

If a [Plaintext Policy](./ddb-table-encryption-config.md#plaintext-policy) of
`FORCE_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ` or `FORBID_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ` is specified,
and the input item [is a plaintext item](#determining-plaintext-items)
this operation MUST NOT decrypt the input item,
and MUST passthrough that item as the output.

This behavior REQUIRES a [Structured Data](../structured-encryption/structures.md#structured-data)
which is [converted](./ddb-item-conversion.md) from the [input DynamoDB Item](#input-dynamodb-item).

This operation MUST create a
[Required Encryption Context CMM](https://github.com/awslabs/private-aws-encryption-sdk-specification-staging/blob/dafny-verified/framework/required-encryption-context-cmm.md)
with the following inputs:

- This item encryptor's [CMM](./ddb-table-encryption-config.md#cmm) as the underlying CMM.
- The keys from the [DynamoDB Item Base Context](#dynamodb-item-base-context).

Given the converted [Structured Data](../structured-encryption/structures.md#structured-data),
this operation MUST delegate decryption of this data to
Structured Encryption Client's [Decrypt Structure](../structured-encryption/encrypt-structure.md),
with the following inputs:

- Encrypted Structured Data MUST be the Structured Data converted above.
- Authenticate Schema MUST be a [Authenticate Schema](../structured-encryption/structures.md#crypto-schema)
  built with the following requirements:
  - For every Attribute in the [input DynamoDB Item](#input-dynamodb-item)
    that is in the [signature scope](#signature-scope),
    there MUST exist a [SIGN Authenticate Action](../structured-encryption/structures.md#sign)
    in the Authenticate Schema,
    string indexed at the top level by that attribute name.
  - For every Attribute in the [input DynamoDB Item](#input-dynamodb-item)
    that is not in the [signature scope](#signature-scope),
    there MUST exist a [DO_NOT_SIGN Authenticate Action](../structured-encryption/structures.md#do_not_sign)
    in the Authenticate Schema,
    string indexed at the top level by that attribute name.
  - The number of Authenticate Actions in the Authenticate Schema
    MUST EQUAL the number of Attributes on the [input DynamoDB Item](#input-dynamodb-item).
- Encryption Context MUST be the input Item's [DynamoDB Item Base Context](./encrypt-item.md#dynamodb-item-base-context).
- CMM MUST be the CMM constructed above.

The output to this behavior is the [conversion](./ddb-item-conversion.md)
of the decrypted Structured Data determined above
into the [output DynamoDB Item](./encrypt-item.md#encrypted-dynamodb-item).

The output MUST also include a [Parsed Header](#parsed-header) that contains
data that was serialized into the header included in the output DynamoDb Item.

### DynamoDB Item Base Context

The item to be encrypted MUST have an attribute named `aws_dbe_head`.

The attribute named `aws_dbe_head` MUST be of type `B` Binary.

The first byte of that value is the Version Number.

If the Version Number is 2, then the base context MUST be the [version 2](./encrypt-item.md#dynamodb-item-base-context-version-2) context.

If the Version Number is 1, the base context MUST be the [version 1](./encrypt-item.md#dynamodb-item-base-context-version-1) context.

If the Version Number is not 1 or 2, the operation MUST return an error.

### Signature Scope

The Signature Scope is a client-side configuration of what attributes should be
included within signature calculations whenever encrypting or decrypting items.

An Attribute on a DynamoDB Item MUST NOT be considered as within the signature scope
if it's Attribute Name is included in [Unauthenticated Attributes](./ddb-table-encryption-config.md#unauthenticated-attributes)
or if it's Attribute Name begins with the prefix specified in
[Unauthenticated Attribute Prefix](./ddb-table-encryption-config.md#unauthenticated-attribute-prefix).
Otherwise, Attributes MUST be considered as within the signature scope.

If an Authenticate Action other than DO_NOTHING is configured for an attribute name included in [Unauthenticated Attributes](./ddb-table-encryption-config.md#unauthenticated-attributes)
or beginning with the prefix specified in [Unauthenticated Attribute Prefix](./ddb-table-encryption-config.md#unauthenticated-attribute-prefix),
this operation MUST yield an error.

### Determining Legacy Items

An item MUST be determined to be encrypted under the legacy format if it contains
attributes for the material description and the signature.
These are usually "_amzn-ddb-map-desc_" and "_amzn-ddb-map-sig_" respectively,
although the DynamoDbEncryptor allows callers to configure custom names for these attributes.

### Determining Plaintext Items

An item MUST be determined to be plaintext if it does not contain
attributes with the names "aws_dbe_head" and "aws_dbe_foot".

Note that this does not conflict with the [legacy item](#determining-legacy-items) definition,
as there is no configuration state which needs to be able to distinguish
between legacy items and plaintext items.
