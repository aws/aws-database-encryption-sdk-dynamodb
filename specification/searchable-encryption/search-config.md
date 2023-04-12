[//]: # "Copyright Amazon.com Inc. or its affiliates. All Rights Reserved."
[//]: # "SPDX-License-Identifier: CC-BY-SA-4.0"

# Search Config

## Version

1.0.0

### Changelog

## Overview

The search config holds the configuration for all of the searchable configuration functionality.

It MUST be an optional part of the [item encryptor config](../dynamodb-encryption-client/ddb-item-encryptor.md).

Although [versioning](#versioning) is not yet supported, it exists in the configuration, so that the configuration will not need to change when we add versioning.

## Initialization

On initialization of the Search Config, the caller MUST provide:

 - A list of [beacon versions](#beacon-version-initialization)
 - The [version number](#version-number) of the [beacon versions](#beacon-version) to be used for writing.

Initialization MUST fail if the length of the list of [beacon versions](#beacon-version) is not 1.

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

On initialization of the Beacon Version, the caller MAY provide:

 - a list of [standard beacons](beacons.md#standard-beacon-initialization)
 - a list of [compound beacons](beacons.md#compound-beacon-initialization)
 - a list of [virtual fields](virtual.md#virtual-field-initialization)

Initialization MUST fail if the [version number](#version number) is not `1`.

Initialization MUST fail if at least one [standard beacon](beacons.md#standard-beacon) or
[compound beacon](beacons.md#compound-beacon) is not provided.

Initialization MUST fail if the name of any [virtual fields](virtual.md#virtual-field) matches that
of any [configured field](#configured-field).

Initialization MUST fail if the [beacon key source](#beacon-key-source) is a [multi key store](#multi-key-store-initialization)
and the name of any of the following matches
the [multi key store](#multi-key-store-initialization)'s Key Field Name:
- [virtual fields](virtual.md#virtual-field)
- [standard beacons](beacons.md#standard-beacon)
- [compound beacons](beacons.md#compound-beacon)
- [configured field](#configured-field)

Initialization MUST fail if the name of any [standard beacon](beacons.md#standard-beacon) or
[compound beacon](beacons.md#compound-beacon) matches that
of any unencrypted [configured field](#configured-field).

Initialization MUST fail if there is any overlap among the names of the
[standard beacons](beacons.md#standard-beacon)
[compound beacons](beacons.md#compound-beacon)
or [virtual fields](virtual.md#virtual-field).

A [terminal location](virtual.md#terminal-location) is considered `signed` if
the field that contains it is [SIGN_ONLY](structures.md#signonly)
or [ENCRYPT_AND_SIGN](structures.md#encryptandsign).

A [terminal location](virtual.md#terminal-location) is considered `encrypted` if
the field that contains it is [ENCRYPT_AND_SIGN](structures.md#encryptandsign).

A virtual field is considered `signed` if all of its
[terminal locations](virtual.md#terminal-location) are `signed` or `encrypted`.

A virtual field is considered `encrypted` if any of its
[terminal locations](virtual.md#terminal-location) are `encrypted`.

Initialization MUST fail if any [virtual field](virtual.md#virtual-field) is not signed.

Initialization MUST fail if the [terminal location](virtual.md#terminal-location)
reference by a [standard beacon](beacons.md#standard-beacon) is not `encrypted`.

Initialization MUST fail if the [terminal location](virtual.md#terminal-location)
reference by a [sensitive part](beacons.md#sensitive-part) is not `encrypted`.

Initialization MUST fail if the [terminal location](virtual.md#terminal-location)
reference by a [non-sensitive part](beacons.md#non-sensitive-part) is `encrypted`,
or is not `signed`.

### Version Number

A version number MUST be `1`.

In the future, when versioning is supported, other positive integers will be allowed.

### Versioning

There are some changes that can be made to a [beacon versions](#beacon-version-initialization)
such that a record written with the old version might not be retrieved by a query
using the new version.

If such a change is necessary, one adds another [beacon versions](#beacon-version-initialization)
with the next higher [version number](#version number).

When a record is written, its beacons are generated using the version designated in the [search config](#initialization). In addition to the configured beacons, a [version tag](#version-tag) MUST also be written.

When a querying a database, it might be necessary to make multiple queries, one per version, 
to successfully find all the records.
For this reason, it is recommended that one rewrite all of the records from an old version with the new version.

A version can safely be removed from the [search config](#initialization)
when no records exists with the associate [version tag](#version-tag).

### Version Tag

For version `N`, the name of the version tag is `aws_dbe_vN` and the value of the tag is a single space.

## Beacon Key Source

A Beacon Version needs to be able to get beacon keys.
This defines two flavors of source.

### Single Key Store Initialization

The single key store is intended to be used
when all items in a DDB table use the same beacon key.
This can also be described as single tenant.

On initialization of a Single Key Store, the caller MUST provide:

 - [Keystore](#keystore)
 - [Beacon Key Id](#beacon-key-id)
 - [cacheTTL](#cachettl)
### Multi Key Store Initialization

The multi key store is intended to be used
when different items in a DDB table use the different beacon keys.
This can also be described as multi tenant.

On initialization of a Multi Key Store, the caller MUST provide:

 - [Keystore](#keystore)
 - [Key Field Name](#key-field-name)
 - [cacheTTL](#cachettl)
 - [max cache size](#max-cache-size)

### Field descriptions

#### Keystore

A [Keystore](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/branch-key-store.md)
used to obtain the configured Beacon Key.
If being used with a Hierarchical Keyring to encrypt/decrypt items, this SHOULD be the same Keystore as configured to that Keyring.

#### Beacon Key Id

A single [Beacon Key Id](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/branch-key-store.md) that exists in the [keystore](####keystore).

#### Key Field Name 

A attribute name that is used to identify the beacon key.
This attribute can be passed in on the DDB item,
but will not be stored in the table.
It can be referenced in [compound beacons](./beacons.md#compound-beacon)
and used to extract a beacon key id from a query.

#### cacheTTL
The [cacheTTL](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/cryptographic-materials-cache.md#time-to-live-ttl)
for how long a beacon key should exist locally before reauthorization.

#### max cache size 
The [max cache size](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/local-cryptographic-materials-cache.md#entry-capacity)
that the [Key Store Cache](#key-store-cache) will be configured to.

 ### Key Store Cache

 For a Beacon Key Source a [Local CMC](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/local-cryptographic-materials-cache.md)
 MUST be created.
 For a [Single Key Store](#single-key-store-initialization) the [Entry Capacity](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/local-cryptographic-materials-cache.md#entry-capacity)
 MUST be 1
 For a [Multi Key Store](#multi-key-store-initialization) the [Entry Capacity](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/local-cryptographic-materials-cache.md#entry-capacity)
 MUST be key store's max cache size.

 The Key Store Cache MUST be bound to the Beacon Key Source.
 It is easy for beacon key ids to be unique within a single key source,
 this may not be true across all key sources.



The key field name is used
to discover the beacon key to request from the keystore.
It can be used on its own or as part of a compound beacon.

## Beacon Keys

In order for [beacons](./beacons.md) to function they need materials.
Beacon keys are these materials.
A beacon key forms a hierarchy of HMAC keys for all searchable components.
Beacon keys MUST be obtained from the configured [Beacon Key Source](#beacon-key-source).

### Get beacon key

Takes a [Beacon Key Source](#beacon-key-source) and a [DynamoDB Item](../dynamodb-encryption-client/encrypt-item.md#dynamodb-item).

If the [Beacon Key Source](#beacon-key-source) is a [Single Key Store](#single-key-store-initialization) then:

Get beacon key MUST Call the associated [Key Store Cache](#key-store-cache)
[Get Cache Entry](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/local-cryptographic-materials-cache.md#get-cache-entry)
with the configured Beacon Key Id.
If the cache returns an [cache entry](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/cryptographic-materials-cache.md#cache-entry)
the get beacon key MUST return the [entry materials](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/cryptographic-materials-cache.md#materials).

If the cache does not return a [cache entry](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/cryptographic-materials-cache.md#cache-entry)
then the beacon key id MUST be passed to the configured `KeyStore`'s `GetBeaconKey` operation.

These materials MUST be put into the associated [Key Store Cache](#key-store-cache)
with an [Expiry Time](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/cryptographic-materials-cache.md#expiry-time)
equal to now + configured `cacheTTL`.

These cached materials MUST be returned.

If the [Beacon Key Source](#beacon-key-source) is a [Multi Key Store](#multi-key-store-initialization) then:




### Get beacon key for query


### Verify beacon key after encrypt

### Verify beacon key after decrypt



The BeaconVersion uses KeyStore in its Beacon Key Source to retrieve the beacon key.
In the case of a Single Key Store,
the Beacon Key Id on the Single Key Store MUST be passed to the KeyStore
to retrieve the beacon key.
In the case of a Multi Key Store,
the value of Key Field Name MUST be used to get the beacon key it
and be passed to the KeyStore.

### HMAC Key Generation

Each beacon requires a key for use in its HMAC calculation.

For each beacon HKDF-SHA512 MUST be used
to calculate the key for individual beacon,
using the beacon key retrieved above as the initial key material with no salt.
The `info` MUST be the concatenation of "AWS_DBE_SCAN_BEACON" and the beacon name.
The `expectedLength` MUST be 64 bytes.