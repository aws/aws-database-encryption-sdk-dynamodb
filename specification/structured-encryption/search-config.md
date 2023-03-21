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
 - The [version number](#version number) of the [beacon versions](#beacon-version) to be used or writing.

Initialization MUST fail if the length of the list of [beacon versions](#beacon-version) is not 1.

Initialization MUST fail if the [version number](#version number) is not `1`.

### Beacon Version Initialization

On initialization of a Beacon Version, the caller MUST provide:

 - A [version number](#version number) 
 - A [KeyringReference](../../private-aws-encryption-sdk-dafny-staging/aws-encryption-sdk-specification/framework/keyring-interface.md)

On initialization of the Beacon Version, the caller MAY provide:

 - a list of [standard beacons](beacons.md#standard-beacon-initialization)
 - a list of [compound beacons](beacons.md#compound-beacon-initialization)
 - a list of [virtual fields](virtual.md#virtual-field-initialization)

Initialization MUST fail if the [version number](#version number) is not `1`.

Initialization MUST fail if the keyring is not a Hierarchy Keyring.

Initialization MUST fail if at least one [standard beacon](beacons.md#standard-beacon) or
[compound beacon](beacons.md#compound-beacon) is not provided.

Initialization MUST fail if the name of any [virtual fields](virtual.md#virtual-field) matches that
of any [configured field](#configured-field).

Initialization MUST fail if the name of any [standard beacon](beacons.md#standard-beacon) or
[compound beacon](beacons.md#compound-beacon) matches that
of any unencrypted [configured field](#configured-field).

Initialization MUST fail if there is any overlap among the names of the
[standard beacons](beacons.md#standard-beacon)
[compound beacons](beacons.md#compound-beacon)
or [virtual fields](virtual.md#virtual-field).

A [terminal location](virtual.md#terminal-location) is considered `signed` if
the field that  contains it is  [SIGN_ONLY](structures.md#signonly)
or [ENCRYPT_AND_SIGN](structures.md#encryptandsign).

A [terminal location](virtual.md#terminal-location) is considered `encrypted` if
the field that  contains it is [ENCRYPT_AND_SIGN](structures.md#encryptandsign).

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
