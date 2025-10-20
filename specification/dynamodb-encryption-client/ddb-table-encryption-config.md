[//]: # "Copyright Amazon.com Inc. or its affiliates. All Rights Reserved."
[//]: # "SPDX-License-Identifier: CC-BY-SA-4.0"

# DynamoDB Table Encryption Config

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

This document describes a set of data used in the initialization of
the [DynamoDb Item Encryptor](./ddb-item-encryptor.md) as well as the
[AWS SDK integration with DDB](./ddb-sdk-integration.md).
This data describes how items in a specific DynamoDb Table
should be encrypted and decrypted.

## Structure

The physical [DynamoDB Table Name](#dynamodb-table-name) is REQUIRED
to be associated with the DynamoDb Table Encryption Configuration.

The following are REQUIRED for DynamoDb Table Encryption Configuration:

- [Logical Table Name](#logical-table-name)
- [DynamoDB Partition Key Name](#dynamodb-partition-key-name)
- [Attribute Actions](#attribute-actions)
- A [CMM](#cmm) or [Keyring](#keyring)

The following are OPTIONAL for DynamoDb Table Encryption Configuration:

- [DynamoDB Sort Key Name](#dynamodb-sort-key-name)
- [Unauthenticated Attributes](#unauthenticated-attributes)
- [Unauthenticated Attribute Name Prefix](#unauthenticated-attribute-prefix)
- [Algorithm Suite](#algorithm-suite)
- [Legacy Config](#legacy-config)
- [Plaintext Policy](#plaintext-policy)
- [Searchable Encryption Config](../searchable-encryption/search-config.md)

A [Legacy Config](#legacy-config)
and a [Plaintext Policy](#plaintext-policy)
both specified on the same config is invalid,
and MUST result in an error.

A [Searchable Encryption Config](../searchable-encryption/search-config.md)
and either a [Legacy Config](./ddb-table-encryption-config.md#legacy-config)
or a [Plaintext Policy](./ddb-table-encryption-config.md#plaintext-policy)
being specified on the same config is invalid,
and MUST result in an error.

### DynamoDB Table Name

The name of the DynamoDB Table where the
DynamoDB Items to be decrypted or encrypted
are stored or intended to be stored.

This Table Name MUST be a valid DynamoDB Table Name.

If this config is being organized with other table configs in a map,
this value MAY exist as a key value to identify other data in this config,
instead of existing alongside this data in the same object.
We specify this data instead of specifying a more complex
but consistent structure in order to give us flexibility for providing the
simplest customer experience.
Also in the case of a restore from backup,
this physical name may not match the logical name for the data stored.
So a [logical table name](#logical-table-name) exists.

### Logical Table Name

The logical name for the DynamoDB Table.
This value can match the DynamoDB Table Name
but does not need to.
This name is cryptographically bound to all data stored in this table.
In the case of a restore from backup
the [DynamoDB Table Name](#dynamodb-table-name) can change to a new name,
but this name must remain the same.

When mapping [DynamoDB Table Names](#dynamodb-table-name) to [logical table name](#logical-table-name)
there MUST a one to one mapping between the two.
The purpose of the logical name is to simplify restore type operations,
not make it easier to confuse what data comes from what physical table.

### DynamoDB Partition Key Name

The DynamoDB Partition Key Name is the attribute name of the partition key of the DynamoDB Table
identified by the [input DynamoDB Table Name](#dynamodb-table-name).

This Partition Key Name MUST be a valid DynamoDB Key Schema Attribute Name

### DynamoDB Sort Key Name

The DynamoDB Sort Key Name is the attribute name of the sort key
of the DynamoDB Table identified by the [input DynamoDB Table Name](#dynamodb-table-name).

This Sort Key Name MUST be a valid DynamoDB Key Schema Attribute Name

### Configuration Version

If any of the [Attribute Actions](#attribute-actions) are configured as
[SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT](../structured-encryption/structures.md#contextandsign)
then the configuration version MUST be 2; otherwise,
the configuration version MUST be 1.

### Key Action

if the [configuration version](#configuration-version) is 2, then
the key action MUST be [SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT](../structured-encryption/structures.md#contextandsign);
otherwise, the key action MUST be [SIGN_ONLY](../structured-encryption/structures.md#signonly).

### Attribute Actions

Attribute Actions is a map of attribute names to
[Crypto Actions](../structured-encryption/structures.md#crypto-action)
that describes what Crypto Action applies to a particular attribute
(if it exists) during encryption.

The [Key Action](#key-action)
MUST be configured to the partition attribute and, if present, sort attribute.

### CMM

A CMM that implements the [CMM interface](https://github.com/awslabs/aws-encryption-sdk-specification/blob/master/framework/cmm-interface.md)
that is responsible for obtaining materials for encryption and decryption.

If not supplied during initialization,
the CMM considered "configured" to this
Item Encryptor MUST be a
[default CMM](https://github.com/awslabs/aws-encryption-sdk-specification/blob/master/framework/default-cmm.md)
constructed using the [supplied keyring](#keyring) as input.

### Keyring

A Keyring that implements the [keyring interface](https://github.com/awslabs/aws-encryption-sdk-specification/blob/master/framework/keyring-interface.md).

### Unauthenticated Attributes

Unauthenticated Attributes MUST be a set of Attribute Names.
With [Unauthenticated Attribute Prefix](#unauthenticated-attribute-prefix),
This identifies Attributes within this table
that are not authenticated during decryption.

### Unauthenticated Attribute Prefix

Unauthenticated Attribute Prefix MUST be a string.
With [Unauthenticated Attributes](#unauthenticated-attributes),
This identifies Attributes within this table
that are not authenticated during decryption.

### Algorithm Suite

The [algorithm suite](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/algorithm-suites.md) that SHOULD be used for encryption.

This algorithm suite MUST be a [Structured Encryption Library Supported algorithm suite](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/algorithm-suites.md).

### Legacy Config

A configuration that specifies whether items written in a legacy format in this table are allowed to be decrypted,
how those items should be decrypted,
and whether new items should be encrypted using the legacy format.

This config MUST contain:

- [Legacy Encryptor](#legacy-encryptor)
- [Attributes Flags](#attribute-flags)
- [Legacy Policy](#legacy-policy)

#### Legacy Encryptor

The DynamoDbEncryptor for Java.

#### Attribute Flags

A map of attribute names to [Crypto Actions](../structured-encryption/structures.md#crypto-action),
that describes what Crypto Action applies to a particular attribute
on any items written in the legacy format.

This map MAY be different from the top level [Attribute Actions](#attribute-actions).

#### Legacy Policy

An enum that represent three different ways in which the legacy format should be used with this table.

- FORCE_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT: On encrypt, items are encrypted using the legacy format,
  using the legacy configuration as input.
  On decrypt, items written by the legacy format are attempted to be decrypted using the
  legacy configuration.
  All other items are attempted to be decrypted using the normal decrypt path.
- FORBID_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT: On encrypt, items are encrypted using the normal encrypt path.
  On decrypt, items written by the legacy format are attempted to be decrypted using the
  legacy configuration.
  All other items are attempted to be decrypted using the normal decrypt path.
- FORBID_LEGACY_ENCRYPT_FORBID_LEGACY_DECRYPT: On encrypt, items are encrypted using the normal encrypt path.
  On decrypt, items written by the legacy format result in a failure.
  All other items are attempted to be decrypted using the normal decrypt path.

### Plaintext Policy

An enum that indicates whether plaintext is allowed to be read or written to this table:

- FORCE_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ: On write, items are written as plaintext.
  On read, plaintext items are passed-through and all other items are attempted to be decrypted.
- FORBID_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ: On write, items are encrypted.
  On read, plaintext items are passed-through and all other items are attempted to be decrypted.
- FORBID_PLAINTEXT_WRITE_FORBID_PLAINTEXT_READ: On write, items are encrypted.
  On read, attempt to decrypt all items.

If not specified, encryption and decryption MUST behave according to `FORBID_PLAINTEXT_WRITE_FORBID_PLAINTEXT_READ`.
