[//]: # "Copyright Amazon.com Inc. or its affiliates. All Rights Reserved."
[//]: # "SPDX-License-Identifier: CC-BY-SA-4.0"

# Search Config

## Version

- 1.2.0
  - Add beacon partitions
- 1.1.0
  - [Update Cache Entry Identifier Formulas to shared cache across multiple Beacon Key Sources](../../changes/2024-09-13_cache-across-hierarchical-keyrings/change.md)
  - New optional parameter `Partition ID` used to distinguish Cryptographic Material Providers (i.e: Beacon Key Sources) writing to a cache
  - New optional parameter `cache` allowed while creating a `SingleKeyStore`
- 1.0.0
  - Initial record

### Changelog

## Definitions

### Conventions used in this document

The key words "MUST", "MUST NOT", "REQUIRED", "SHALL", "SHALL NOT", "SHOULD", "SHOULD NOT", "RECOMMENDED", "MAY", and "OPTIONAL"
in this document are to be interpreted as described in [RFC 2119](https://tools.ietf.org/html/rfc2119).

## Overview

The search config holds the configuration for all of the searchable configuration functionality.

The search config MUST be an optional part of the [item encryptor config](../dynamodb-encryption-client/ddb-item-encryptor.md).

Although [versioning](#versioning) is not yet supported, it exists in the configuration, so that the configuration will not need to change when we add versioning.

## Initialization

On initialization of the Search Config, the caller MUST provide:

- A list of [beacon versions](#beacon-version-initialization)
- The [version number](#version-number) of the [beacon versions](#beacon-version-initialization) to be used for writing.

Initialization MUST fail if the length of the list of [beacon versions](#beacon-version-initialization) is not 1.

Initialization MUST fail if the [version number](#version-number) is not `1`.

### Configured Field

A name refers to a configured field if it appears in the
[item encryptor](../dynamodb-encryption-client/ddb-item-encryptor.md#initialization)
configuration as one of the
[attribute actions](../dynamodb-encryption-client/ddb-item-encryptor.md#attribute-actions) or
[unauthenticated attributes](../dynamodb-encryption-client/ddb-item-encryptor.md#unauthenticated-attributes),
or begins with the [unauthenticated attribute prefix](../dynamodb-encryption-client/ddb-item-encryptor.md#unauthenticated-attribute-prefix).

### Beacon Version Initialization

On initialization of a Beacon Version, the caller MUST provide:

- A [version number](#version-number)
- A [Beacon Key Source](#beacon-key-source)
- A [Keystore](#keystore)
- A list of [standard beacons](beacons.md#standard-beacon-initialization)

On initialization of the Beacon Version, the caller MAY provide:

- A list of [compound beacons](beacons.md#compound-beacon-initialization)
- A list of [virtual fields](virtual.md#virtual-field-initialization)
- A list of [signed parts](beacons.md#signed-part-initialization)
- A list of [encrypted parts](beacons.md#encrypted-part-initialization)
- A [maximum number of partitions](#max-partitions)
- A [default number of partitions](#default-partitions)
- A [partition selector](#partition-selector)

Initialization MUST fail if the [version number](#version-number) is not `1`.

Initialization MUST fail if at least one [standard beacon](beacons.md#standard-beacon)
is not provided.

Initialization MUST fail if the name of any [virtual fields](virtual.md#virtual-field) matches that
of any [configured field](#configured-field).

Initialization MUST fail if the [beacon key source](#beacon-key-source) is a [multi key store](#multi-key-store-initialization)
and the name of any of the following match the [beacon key field name](#beacon-key-field-name)

- [virtual fields](virtual.md#virtual-field)
- [standard beacons](beacons.md#standard-beacon)
- [compound beacons](beacons.md#compound-beacon)

Initialization MUST fail if the [beacon key source](#beacon-key-source) is a [multi key store](#multi-key-store-initialization)
and the [beacon key field name](#beacon-key-field-name)
is a [configured field](#configured-field)
with [ENCRYPT_AND_SIGN](../structured-encryption/structures.md#encrypt_and_sign).

Initialization MUST fail if the name of any [standard beacon](beacons.md#standard-beacon)
matches that of any unencrypted [configured field](#configured-field).

Initialization MUST fail if the name of any [compound beacon](beacons.md#compound-beacon)
matches that of any unencrypted [configured field](#configured-field).

Initialization MUST fail if there is any duplicates among the names of the
[standard beacons](beacons.md#standard-beacon)

Initialization MUST fail if there is any duplicates among the names of the
[compound beacons](beacons.md#compound-beacon)

Initialization MUST fail if the name of a
[compound beacons](beacons.md#compound-beacon)
matches the name of a
[standard beacons](beacons.md#standard-beacon)

Initialization MUST fail if [default number of partitions](#default-partitions) is supplied but [maximum number of partitions](#max-partitions) is not.

Initialization MUST fail if [default number of partitions](#default-partitions) is greater than or equal to [maximum number of partitions](#max-partitions).

A [terminal location](virtual.md#terminal-location) is considered `signed` if
the field that contains it is [SIGN_ONLY](../structured-encryption/structures.md#sign_only)
or [ENCRYPT_AND_SIGN](../structured-encryption/structures.md#encrypt_and_sign).

A [terminal location](virtual.md#terminal-location) is considered `encrypted` if
the field that contains it is [ENCRYPT_AND_SIGN](../structured-encryption/structures.md#encrypt_and_sign).

A virtual field is considered `signed` if all of its
[terminal locations](virtual.md#terminal-location) are `signed` or `encrypted`.

A virtual field is considered `encrypted` if any of its
[terminal locations](virtual.md#terminal-location) are `encrypted`.

Initialization MUST fail if any [virtual field](virtual.md#virtual-field) is not signed.

Initialization MUST fail if the [terminal location](virtual.md#terminal-location)
reference by a [standard beacon](beacons.md#standard-beacon) is not `encrypted`.

Initialization MUST fail if the [terminal location](virtual.md#terminal-location)
reference by a [signed part](beacons.md#signed-part) is `encrypted`,
or is not `signed`.

#### Global Parts List

The [signed parts](beacons.md#signed-part-initialization) and
[encrypted parts](beacons.md#encrypted-part-initialization) together are known as the
Global Parts List.
Parts specified in a [compound beacon's](beacons.md#compound-beacon-initialization) constructor,
may come from any combination of their local definitions or the Global Parts List.

### Version Number

A version number MUST be `1`.

In the future, when versioning is supported, other positive integers will be allowed.

### Versioning

There are some changes that can be made to a [beacon versions](#beacon-version-initialization)
such that a record written with the old version might not be retrieved by a query
using the new version.

If such a change is necessary, one adds another [beacon versions](#beacon-version-initialization)
with the next higher [version number](#version number).

When a record is written, its beacons are generated using the version designated in the [search config](#initialization).
In addition to the configured beacons, a [version tag](#version-tag) MUST also be written.

When a querying a database, it might be necessary to make multiple queries, one per version,
to successfully find all the records.
For this reason, it is recommended that one rewrite all of the records from an old version with the new version.

A version can safely be removed from the [search config](#initialization)
when no records exists with the associate [version tag](#version-tag).

### Version Tag

For version `N`, the name of the version tag is `aws_dbe_vN` and the value of the tag is a single space.

## Beacon Key Source

On initialization of a Beacon Key Source, the caller MUST provide exactly one of

- a [Single Key Store](#single-key-store-initialization)
- a [Multi Key Store](#multi-key-store-initialization)

### Single Key Store Initialization

The single key store is intended to be used
when all items in a DDB table will use the same beacon key.
This can also be described as single tenant.

On initialization of a Single Key Store, the caller MUST provide:

- [Beacon Key Id](#beacon-key-id)
- [cacheTTL](#cachettl)
- [cache](#key-store-cache)
- [partition-id](#partition-id)

### Multi Key Store Initialization

The multi key store is intended to be used
when different items in a DDB table will use the different beacon keys.
This can also be described as multi tenant.

On initialization of a Multi Key Store, the caller MUST provide:

- [Beacon Key Field Name](#beacon-key-field-name)
- [cacheTTL](#cachettl)
- [cache](#key-store-cache)
- [partition-id](#partition-id)

### Field descriptions

#### Keystore

A [Keystore](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/branch-key-store.md)
used to obtain the configured Beacon Key.
If being used with a Hierarchical Keyring to encrypt/decrypt items,
this SHOULD be the same Keystore as configured to that Keyring.

#### Beacon Key Id

A single [Beacon Key Id](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/branch-key-store.md)
that exists in the [keystore](#keystore).

#### Beacon Key Field Name

A attribute name that is used to identify the beacon key id.
This attribute can be passed in on the DDB item,
by default it will not be stored in the table
but will be stored if an attribute action of SIGN_ONLY
is configured.
It can be referenced in [compound beacons](./beacons.md#compound-beacon)
and used to extract a beacon key id from a query.

#### cacheTTL

The [cacheTTL](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/cryptographic-materials-cache.md#time-to-live-ttl)
for how long a beacon key should exist locally before reauthorization.

### Key Store Cache

For a Beacon Key Source a [CMC](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/cryptographic-materials-cache.md)
MUST be created.
For a [Single Key Store](#single-key-store-initialization), either the user provides a cache, or we create a cache that has [Entry Capacity](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/cryptographic-materials-cache.md#entry-capacity)
equal to 1.
For a [Multi Key Store](#multi-key-store-initialization), either the user provides a cache, or we create a cache that has [Entry Capacity](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/cryptographic-materials-cache.md#entry-capacity)
equal to 1000.

The Key Store Cache is shared across different [Beacon Key Sources](#beacon-key-source) if and only if a `Shared` cache is used.
In all other cases, the Key Store Cache is bound to the [Beacon Key Source](#beacon-key-source).
In either case, Cache Identifiers MUST be unique across all key sources.
Cache Identifiers for Searchable Encryption MUST be set as per the section [Searchable Encryption Cache Identifier](#searchable-encryption-cache-identifier).

### Partition ID

An optional string that uniquely identifies the respective [Beacon Key Source](#beacon-key-source)
and is used to avoid collisions with other [Beacon Key Sources](#beacon-key-source).

PartitionId can be a string provided by the user. If provided, it MUST be interpreted as UTF8 bytes.
If the PartitionId is NOT provided by the user, it MUST be set to the 16 byte representation of a v4 UUID.

The Partition ID MUST NOT be changed after initialization.

Please see [Shared Cache Considerations](#shared-cache-considerations) on how to provide the
Partition ID and Logical Key Store Name while providing a Shared Cache to the [Beacon Key Source](#beacon-key-source).

## Beacon Keys

In order for [beacons](./beacons.md) to function they need materials.
Beacon keys are these materials.
A beacon key forms a hierarchy of HMAC keys for all searchable components.
Beacon keys MUST be obtained from the configured [Beacon Key Source](#beacon-key-source).

### Get beacon key after encrypt

Takes a [Search Config](#search-config)
and a [Parsed Header](../dynamodb-encryption-client/encrypt-item.md#parsed-header).

If the [Beacon Key Source](#beacon-key-source) is a [Single Key Store](#single-key-store-initialization)
then `beacon key id` MUST be the configured [beacon key id](#beacon-key-id)

If the [Beacon Key Source](#beacon-key-source) is a [Multi Key Store](#multi-key-store-initialization)
then `beacon key id` MUST be obtained from [Get beacon key id from parsed header](#get-beacon-key-id-from-parsed-header).

The `beacon key id`, [Key Store Cache](#key-store-cache), and a `KeyStore`
MUST be passed to [Get Beacon Key Materials](#get-beacon-key-materials)
and the result returned for Get beacon key after encrypt.

### Get beacon key id from Parsed Header

Takes a [Parsed Header](../dynamodb-encryption-client/encrypt-item.md#parsed-header).

If the [Parsed Header](../dynamodb-encryption-client/encrypt-item.md#parsed-header)'s encrypted data keys
do not contain only one encrypted data key
this function MUST fail.

If this single encrypted data key's
[Key Provider ID](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/../structured-encryption/structures.md#key-provider-id)
does not equal the provider ID
for the [AWS KMS Hierarchical Keyring](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/aws-kms/aws-kms-hierarchical-keyring.md#ondecrypt)
this function MUST fail.

This function MUST return the [Key Provider Information](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/../structured-encryption/structures.md#key-provider-id).

### Get beacon key for query

Takes a [Search Config](#search-config) and a Query Object

If the [Beacon Key Source](#beacon-key-source) is a [Single Key Store](#single-key-store-initialization)
then `beacon key id` MUST be the configured [beacon key id](#beacon-key-id)

If the [Beacon Key Source](#beacon-key-source) is a [Multi Key Store](#multi-key-store-initialization)
then for each Key Condition Expression or Filter Expression,
extract the value of any [signed part](./beacons.md#signed-part-initialization)
of any [compound beacons](beacons.md#compound-beacon)
with the `name` that equals [Beacon Key Field Name](#beacon-key-field-name)
and construct a list of beacon key ids.

If this list of beacon key ids is empty get beacon key for query MUST
return a flag indicating this.

A query MUST fail if this flag is present, and any part of the query
requires a key; that is, needs to compute a standard beacon.

If this list of beacon key ids has more than one unique beacon key id
then get beacon key for query MUST fail.

`beacon key id` MUST be this unique value.

The `beacon key id`, [Key Store Cache](#key-store-cache), and a `KeyStore`
MUST be passed to [Get Beacon Key Materials](#get-beacon-key-materials)
and the result returned for Get beacon key for query.

### Get Beacon Key Materials

Takes a `beacon key id`, [Key Store Cache](#key-store-cache), and a `KeyStore`.

Get beacon key MUST Call the associated [Key Store Cache](#key-store-cache)
[Get Cache Entry](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/local-cryptographic-materials-cache.md#get-cache-entry)
with the cache identifier defined in the [Searchable Encryption Cache Identifier](#searchable-encryption-cache-identifier) section.

If a [cache entry](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/cryptographic-materials-cache.md#cache-entry)
exists, get beacon key MUST return the [entry materials](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/cryptographic-materials-cache.md#materials).

The `beacon key id` MUST be passed to the configured `KeyStore`'s `GetBeaconKey` operation.
If `GetBeaconKey` fails get beacon key MUST fail.

If using a `Shared` cache across multiple [Beacon Key Sources](#beacon-key-source),
different [Beacon Key Sources](#beacon-key-source) having the same `beaconKey` can have different TTLs.
In such a case, the expiry time in the cache is set according to the [Beacon Key Source](#beacon-key-source) that populated the cache.
There MUST be a check (cacheEntryWithinLimits) to make sure that for the cache entry found, who's TTL has NOT expired,
`time.now() - cacheEntryCreationTime <= ttlSeconds` is true and
valid for TTL of the [Beacon Key Source](#beacon-key-source) getting the cache entry.
If this is NOT true, then we MUST treat the cache entry as expired.

For every [standard beacons](beacons.md#standard-beacon-initialization), an HMAC key
MUST be generated in accordance with [HMAC Key Generation](#hmac-key-generation).

[Beacon Key Materials](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/structures.md#beacon-key-materials) MUST be generated
with the [beacon key id](#beacon-key-id) equal to the `beacon key id`
and the [HMAC Keys](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/structures.md#hmac-keys) equal to a map
of every [standard beacons](beacons.md#standard-beacon-initialization) name to its generated HMAC key.

These materials MUST be put into the associated [Key Store Cache](#key-store-cache)
with an [Expiry Time](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/cryptographic-materials-cache.md#expiry-time)
equal to now + configured [cacheTTL](#cachettl).

The Searchable Encryption cache identifier
used to [Put Cache Entry](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/local-cryptographic-materials-cache.md#put-cache-entry)
MUST be the same
as the identifier that was used to attempt [Get Cache Entry](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/local-cryptographic-materials-cache.md#get-cache-entry).

These cached materials MUST be returned.

### HMAC Key Generation

Each beacon requires a key for use in its HMAC calculation.

For each beacon HKDF-SHA512 MUST be used
to calculate the key for individual beacon,
using the beacon key retrieved above as the initial key material with no salt.
The `info` MUST be the concatenation of "AWS_DBE_SCAN_BEACON" encoded as UTF8
and the beacon name.
The `expectedLength` MUST be 64 bytes.

## Searchable Encryption Cache Identifier

This section is consistent with the Cache Entry Identifier formulas for the [Hierarchical Keyring](https://github.com/awslabs/aws-encryption-sdk-specification/blob/master/framework/aws-kms/aws-kms-hierarchical-keyring.md#appendix-a-cache-entry-identifier-formulas)
and [Caching CMM](https://github.com/awslabs/aws-encryption-sdk-specification/blob/master/framework/caching-cmm.md#appendix-a-cache-entry-identifier-formulas) in the Material Providers spec. These cache identifier formulas should
not be changed independently.

When accessing the underlying cryptographic materials cache,
Searchable Encryption MUST use the formulas specified in this section
in order to compute the [cache entry identifier](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/cryptographic-materials-cache.md#cache-identifier).

### Preliminaries

Each of the cache entry identifier formulas includes serialized information related to the branch key,
as defined in the [Key Provider Info](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/structures.md#key-provider-information).

We establish the following definitions for the Cache Entry Identifier formula:

#### Resource Identifier

Resource Identifier is defined in the [Material Providers specification](https://github.com/awslabs/aws-encryption-sdk-specification/blob/master/framework/aws-kms/aws-kms-hierarchical-keyring.md#resource-identifier).

#### Scope Identifier

Scope Identifier is defined in the [Material Providers specification](https://github.com/awslabs/aws-encryption-sdk-specification/blob/master/framework/aws-kms/aws-kms-hierarchical-keyring.md#scope-identifier).

#### Partition ID

Partition ID is an optional parameter provided to the [Beacon Key Source](#beacon-key-source) input, which distinguishes
Cryptographic Material Providers (i.e: [Beacon Key Sources](#beacon-key-source)) writing to a cache.
It can either be a String provided by the user, which MUST be interpreted as the bytes of
UTF-8 Encoding of the String, or a v4 UUID, which SHOULD be interpreted as the 16 byte representation of the UUID.

Note: The cache will not know if the Partition ID is a String set by the user or the UUID.
The constructor of the [Beacon Key Source](#beacon-key-source) MUST record these bytes at construction time.

Please see [Shared Cache Considerations](#shared-cache-considerations) on how to provide the
Partition ID and Logical Key Store Name of the [beacon versions](#beacon-version-initialization)
while providing a Shared Cache to the [Beacon Key Source](#beacon-key-source).

#### Resource Suffix

The resource suffixes for the Searchable Encryption is as follows:

```text
logicalKeyStoreName + NULL_BYTE + UTF8Encode(branchKeyId)
```

The aforementioned 4 definitions ([Resource Identifier](#resource-identifier),
[Scope Identifier](#scope-identifier), [Partition ID](#partition-id-1), and
[Resource Suffix](#resource-suffix)) MUST be appended together with the null byte, 0x00,
and the SHA384 of the result should be taken as the final cache identifier.

When the [Beacon Key Source](#beacon-key-source) receives a `getKeyMap` request,
the cache entry identifier MUST be calculated as the
SHA-384 hash of the following byte strings, in the order listed:

- MUST be the Resource ID for the Hierarchical Keyring (0x02)
- MUST be the Scope ID for Searchable Encryption (0x03)
- MUST be the Partition ID for the [Beacon Key Source](#beacon-key-source)
- Resource Suffix
  - MUST be the UTF8 encoded Logical Key Store Name of the keystore for the [beacon versions](#beacon-version-initialization)
  - MUST be the UTF8 encoded branch-key-id

All the above fields must be separated by a single NULL_BYTE `0x00`.

| Field                  | Length (bytes) | Interpreted as      |
| ---------------------- | -------------- | ------------------- |
| Resource ID            | 1              | bytes               |
| Null Byte              | 1              | `0x00`              |
| Scope ID               | 1              | bytes               |
| Null Byte              | 1              | `0x00`              |
| Partition ID           | Variable       | bytes               |
| Null Byte              | 1              | `0x00`              |
| Logical Key Store Name | Variable       | UTF-8 Encoded Bytes |
| Null Byte              | 1              | `0x00`              |
| Branch Key ID          | Variable       | UTF-8 Encoded Bytes |

As a formula:

```text
resource-id = [0x02]
scope-id = [0x03]
logical-key-store-name = UTF8Encode(beaconVersion.keystore.LogicalKeyStoreName)
branch-key-id = UTF8Encode(BranchKeyIdentifier)
NULL_BYTE = [0x00]

ENTRY_ID = SHA384(
    resource-id
    + NULL_BYTE
    + scope-id
    + NULL_BYTE
    + partition-id
    + NULL_BYTE
    + logical-key-store-name
    + NULL_BYTE
    + branch-key-id
)
```

## Shared Cache Considerations

If a user has two or more [beacon versions](#beacon-version-initialization) with:

- Same Partition ID
- Same Logical Key Store Name of the Key Store
- Same Branch Key ID

then they WILL share the cache entries in the `Shared` Cache.

Any keyring that has access to the `Shared` cache may be able to use materials
that it may or may not have direct access to.

Users should make sure that all of Partition ID, Logical Key Store Name of the Key Store
and Branch Key ID are set to be the same for two [beacon versions](#beacon-version-initialization)
if and only they want the keyrings to share cache entries.

Therefore, there are two important parameters that users need to carefully set while providing the shared cache:

### Partition ID

Partition ID is an optional parameter provided to the [Beacon Key Source](#beacon-key-source) input,
which distinguishes Cryptographic Material Providers (i.e: [Beacon Key Sources](#beacon-key-source)) writing to a cache.

- (Default) A a random 16-byte UUID, which makes
  it unique for every [Beacon Key Source](#beacon-key-source).
  In this case, two [Beacon Key Sources](#beacon-key-source) (or another Material Provider)
  WILL NOT share the same cache entries in the cache.
- If the Partition ID is set by the user and is the same for two [Beacon Key Sources](#beacon-key-source) (or another Material Provider),
  they MAY share the same cache entries in the cache.
- If the Partition ID is set by the user and is different for two [Beacon Key Sources](#beacon-key-source) (or another Material Provider),
  they WILL NOT share the same cache entries in the cache.

### Logical Key Store Name

> Note: Users should not have two different physical Key Stores with the same Logical Key Store Name.

Logical Key Store Name is set by the user when configuring the Key Store for
the [beacon versions](#beacon-version-initialization).
This is a logical name for the key store.
Logical Key Store Name MUST be converted to UTF8 Bytes to be used in
the cache identifiers.

Suppose there's a physical Key Store on DynamoDB (K). Two Key Store clients of K (K1 and K2) are created.
Now, two [beacon versions](#beacon-version-initialization) (BV1 and BV2) are created with these Key Store clients (K1 and K2 respectively).

- If we want to share cache entries across these two BeaconVersions BV1 and BV2, the Logical Key Store Names
  for both the Key Store clients (K1 and K2) should be set to be the same.
- If we set the Logical Key Store Names for K1 and K2 to be different, BV1 (which uses Key Store client K1)
  and BV2 (which uses Key Store client K2) will NOT be able to share cache entries.

Notice that both K1 and K2 are clients for the same physical Key Store (K).

## Beacon Partitions

`Beacon Partitions` refers to a way to add a little bit more randomness to your [beacons](../../searchable-encryption/beacons.md),
to add anonymity when your data distribution is uneven. See [beacon partition background](../changes/2025-08-25-partition-beacons/background.md).

### PartitionCount

A PartitionCount is an integer between 1 and 255 inclusive.
It refers to the total number of partitions in play.

### PartitionNumber

A PartitionNumber is an integer between 0 and 254 inclusive.
It refers to a specific partition, typically the partition to which a DynamoDB item has been assigned.

A PartitionNumber only has meaning in the context of a PartitionCount, where the PartitionNumber must be less than the PartitionCount.

### Max Partitions

The Max Partitions setting in a [beacon version](#beacon-version-initialization) configures the total number of partitions being used in a table.

If not set, Max Partitions MUST default to `1`, which is synonymous with "no partitions are being used".

### Default Partitions

The Default Partitions setting a [beacon version](#beacon-version-initialization) configures the number of partitions used by all
[standard beacons](beacons.md#standard-beacon-initialization) that do not directly specify a number of partitions.

If not set, Default Partitions MUST default to [Max Partitions](#max-partitions).

### Partition Selector

A Partition Selector is an object that implements GetPartitionNumber.

GetPartitionNumber MUST take as input

- A DynamoDB Item (i.e an AttributeMap)
- The [number of partitions](#max-partitions) defined in the associated [beacon version](#beacon-version-initialization).
- The logical table name for this defined in the associated [table config](../dynamodb-encryption-client/ddb-table-encryption-config.md#structure).

GetPartitionNumber MUST return

- The number of the partition to use for this item

It is an error for the Partition Selector to return a number greater than or equal to the input [number of partitions](#max-partitions).

The default implementation of the Partition Selector MUST return a random number within the acceptable range, i.e. 0..[number of partitions](#max-partitions).
