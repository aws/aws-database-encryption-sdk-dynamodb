[//]: # "Copyright Amazon.com Inc. or its affiliates. All Rights Reserved."
[//]: # "SPDX-License-Identifier: CC-BY-SA-4.0"

# Search Config

## Version

1.0.0

### Changelog

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

- A [version number](#version number)
- A [Beacon Key Source](#beacon-key-source)
- A [Keystore](#keystore)
- A list of [standard beacons](beacons.md#standard-beacon-initialization)

On initialization of the Beacon Version, the caller MAY provide:

- A list of [compound beacons](beacons.md#compound-beacon-initialization)
- A list of [virtual fields](virtual.md#virtual-field-initialization)
- A list of [signed parts](beacons.md#signed-part-initialization)
- A list of [encrypted parts](beacons.md#encrypted-part-initialization)

Initialization MUST fail if the [version number](#version number) is not `1`.

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

### Multi Key Store Initialization

The multi key store is intended to be used
when different items in a DDB table will use the different beacon keys.
This can also be described as multi tenant.

On initialization of a Multi Key Store, the caller MUST provide:

- [Beacon Key Field Name](#beacon-key-field-name)
- [cacheTTL](#cachettl)
- [max cache size](#max-cache-size)

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

#### max cache size

The [max cache size](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/local-cryptographic-materials-cache.md#entry-capacity)
that the [Key Store Cache](#key-store-cache) will be configured to.

### Key Store Cache

For a Beacon Key Source a [CMC](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/cryptographic-materials-cache.md)
MUST be created.
For a [Single Key Store](#single-key-store-initialization) the [Entry Capacity](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/cryptographic-materials-cache.md#entry-capacity)
MUST be 1
For a [Multi Key Store](#multi-key-store-initialization) the [Entry Capacity](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/cryptographic-materials-cache.md#entry-capacity)
MUST be key store's max cache size.

The Key Store Cache MUST be bound to the Beacon Key Source.
This is currently invariant because we construct the cache for each search config
It is easy for beacon key ids to be unique within a single key source,
this may not be true across all key sources.

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

Takes a `beacon key id`, [Key Store Cache](#key-store-cache), and a `KeyStore`

Get beacon key MUST Call the associated [Key Store Cache](#key-store-cache)
[Get Cache Entry](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/local-cryptographic-materials-cache.md#get-cache-entry)
with the `beacon key id`.

If a [cache entry](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/cryptographic-materials-cache.md#cache-entry)
exists, get beacon key MUST return the [entry materials](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/cryptographic-materials-cache.md#materials).

The `beacon key id` MUST be passed to the configured `KeyStore`'s `GetBeaconKey` operation.
If `GetBeaconKey` fails get beacon key MUST fail.

For every [standard beacons](beacons.md#standard-beacon-initialization) an HMAC key
MUST be generated in accordance with [HMAC Key Generation](#hmac-key-generation).

[Beacon Key Materials](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/structures.md#beacon-key-materials) MUST be generated
with the [beacon key id](#beacon-key-id) equal to the `beacon key id`
and the [HMAC Keys](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/structures.md#hmac-keys) equal to a map
of every [standard beacons](beacons.md#standard-beacon-initialization) name to its generated HMAC key.

These materials MUST be put into the associated [Key Store Cache](#key-store-cache)
with an [Expiry Time](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/cryptographic-materials-cache.md#expiry-time)
equal to now + configured [cacheTTL](#cachettl).

These cached materials MUST be returned.

### HMAC Key Generation

Each beacon requires a key for use in its HMAC calculation.

For each beacon HKDF-SHA512 MUST be used
to calculate the key for individual beacon,
using the beacon key retrieved above as the initial key material with no salt.
The `info` MUST be the concatenation of "AWS_DBE_SCAN_BEACON" encoded as UTF8
and the beacon name.
The `expectedLength` MUST be 64 bytes.
