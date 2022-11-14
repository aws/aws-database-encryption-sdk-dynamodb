[//]: # "Copyright Amazon.com Inc. or its affiliates. All Rights Reserved."
[//]: # "SPDX-License-Identifier: CC-BY-SA-4.0"

# DynamoDB Beacon Versions

## Version

1.0.0

### Changelog

## Overview

This document assumes familiarity with the [base](./ddb-base.md)
DynamoDB support for beacons, and describes the changes
necesary to add versioning support.

### Forbidden Fields
 
In the [base](./ddb-base.md) document, we forbid any use of
attribute names beginning with the [reserved prefix](./ddb-base.md#reserved-prefix).

[Version markers](#version-marker) start with the
[reserved prefix](./ddb-base.md#reserved-prefix),
but customers should be allowed read access to
[Version markers](#version-marker).

### Versioning

Sometimes, a customer might need to change their
[beacon](./beacons.md) configuration.

**Note:** *Changing the encryption configuration, which attributes
are encrypted or signed, is a completely different process.
It doesn't need versioning and is not discussed here.*

To handle this, we introduce [beacon versions](#beaconversion).
A beacon version is a complete specification of how beacons
should work with a particular table,
and includes a [version number](#version-number).

The full [beacon context](#beaconcontext) specifies which
version is the [current version](#current-version).

A customer must keep a [beacon version](#beaconversion) in the
[beacon context](#beaconcontext) until no items written
with that version exist in the table.

`Query` operations are inefficient when there are
multiple active [beacon versions](#beaconversion).
When a customer makes a single Query request,
one backend `Query` must be made for each active version.

This costs the customer both time and money,
and so we encourage customers to rewrite old items with
the new version, so that they might retire the old
[beacon versions](#beaconversion).

Each item is written with a [version marker](#version-marker)
to make this easier.

For small systems, a customer can add a new [beacon version](#beaconversion),
bump the [current version](#current-version) to match, and be on their way.

For large, distributed systems a two-phase process might be needed

1. Add a new [beacon version](#beaconversion)
1. Distribute this new configuration throughout the system
1. Update the [current version](#current-version)
1. Distribute this new configuration throughout the system

Failure to do so means that some clients might not find some items
during the time the new configuration is being distributed.

#### Changes That Require a New Version

Anything for which the old [beacon version](#beaconversion) and the
new [beacon version](#beaconversion) would both return valid results
that the other would not return.

 * Changing the [beacon length](./beacons.md#beacon-length)
 * modifying the details of a [compound beacon](./beacons.md#compound-beacon)
 * removing a beacon, if you still want to be able to find old items with this beacon


#### Changes That Do Not Require a New Version

Anything for which the new [beacon version](#beaconversion)
would return all valid results that the old [beacon version](#beaconversion)
would return.

 * adding a beacon
 * removing a beacon, if you do not want to be able to find old items with this beacon



### Version Number

The version number of a [beacon version](#beaconversion) is
an integer, greater than zero.

It is expected that, as typical with version numbers,
the original version will be "1", 
the first revision "2" and so on.

It is also expected that most customers will never get to
version 2, and almost none will have more than a few.

### Current Version

The [beacon version](#beaconversion) with the [version number](#version-number)
specified in the [BeaconContext](#beaconcontext) is known as the 
`current version`. Typically, this is highest version number,
associated with the most recently added [beacon version](#beaconversion).


### Version Marker

When an item is written, a special attribute called a version marker is also written.

The name of this attribute is the concatenation of the [ddbec prefix](#ddbec-prefix), `v_`, and the [version number](#version-number) of the [current version](#current-version).
The value has type "S" string, and the
string value is a single space. 

For example, version 12 would write the attribute `gZ_v_12`

When a customer wants to retire version 12, they can

 * scan the database for any items where attr_exists("gZ_v_12") and re-write them
 * create a temporary GSI, with a partition key of `gZ_v_12`,
  scan that table and re-write the items.
  When the index is empty,
  the customer can be certain that no items remain
  that were written with version 12,
  at which point they can remove version 12 from the [BeaconContext](#beaconcontext)
  and delete the temporary GSI

It is important for customers to update previous versions,
because until they do, a single customer Query request will have to be
translated into multiple backend Query requests
to find all matching items across all beacon versions.

### Version Pagination

The `Query` operation is tricky in the face of multiple [beacon versions](#beaconversion). Since they involve an index lookup,
a separate backend Query is needed for each [beacon versions](#beaconversion),
to support a single customer Query.

The only thing that persists between queries is the `LastEvaluatedKey` field
of the `QueryResponse`, which maps to the `exclusiveStartKey` of the
next `QueryRequest`; so we hide some information there; specifically,
we add a numeric field named `gZ_version` holding the [version number](#version-number) of the [beacon version](#beaconversion) currently in use.

We start with the lowest version, and whenever a `Query` is finished,
we bump to the next one.

When transforming a QueryResponse, we get the version from the
associated QueryRequest, and add it to the LastEvaluatedKey.
If there was no LastEvaluatedKey, then if we're on the last version,
we leave it with no LastEvaluatedKey; otherwise we create a
LastEvaluatedKey with only the `gZ_version` field.

A QueryRequest transforms the query based on the [beacon versions](#beaconversion)
named in the `gZ_version` field of the exclusiveStartKey.
If there is no `gZ_version` field, we use the lowest version.
If the `gZ_version` field is the only field in the exclusiveStartKey,
we use the next highest [beacon versions](#beaconversion).
The transformQueryRequest operation always removes the `gZ_version` field,
so that the backend Query doesn't get confused.


For a setup with versions 1 and 2, a single Query might go something like this like this, from the point of view of the transformQueryRequest and transformQueryResponse operations.

1. A QueryRequest comes in with no exclusiveStartKey. We modify the query with beacon version 1.
1. The QueryResponse comes back with a LastEvaluatedKey. We see that the original QueryRequest had no exclusiveStartKey, so we tag the LastEvaluatedKey with the lowest version, 'version 1'.
1. A QueryRequest comes in with an exclusiveStartKey with a 'version 1' tag; we remove the tag and modify the query with beacon version 1.
1. The QueryResponse comes back with no LastEvaluatedKey. We see that the original QueryRequest had an exclusiveStartKey tagged with version 1, so we create a new 
LastEvaluatedKey tagged with version 1.
1. A QueryRequest comes in with an exclusiveStartKey with a 'version 1', but no body. We modify the query with beacon version 2 and remove the exclusiveStartKey.
1. The QueryResponse comes back with a LastEvaluatedKey. We see that the original
QueryRequest had a version 1 tag but no body, so we tag the LastEvaluatedKey
with version 2.
1. A QueryRequest comes in with an exclusiveStartKey with a 'version 2'.
We remove the tag and modify the query with beacon version 2.
1. The QueryResponse comes back with no LastEvaluatedKey. We see that the original
QueryRequest had a version 2 tag, which is the last version, so
we leave the QueryResponse with no LastEvaluatedKey.
1. No QueryRequest comes in, because there was no LastEvaluatedKey. 

### Writing

Whenever an item is written, under a configuration with
any beacons configured, a [Version marker](#version-marker)
for the [current version](#current-version) is also written.

## Configuration

### BeaconContext

The BeaconContext object MUST also contain

 * The [version number](#version-number) of the [BeaconVersion](#beaconversion) to be used for writing

### BeaconVersion

The BeaconVersion object MUST contain

 * version -- a [version number](#version-number)

## Operations

The object types below are referred to by the Dafny names generated by Polymorph

When the text below says "alter the input" this should be read as
"the output should be equal to the input, but altered in this way".

These operations are defined in terms of functionality
defined in the following section, [Helpers](#beacon-helpers).

These operations MUST have access to a [DynamoDBEncryption](./ddb-base/#dynamodbencryption).


### transformPutItemInput

 * The returned `Item` must include the current [version marker](#version-marker)


### transformUpdateItemInput

 * transformUpdateItemInput MUST be allowed to alter
[version markers](#version-marker)


### transformQueryInput

 * If the `keyConditionExpression` refers to no encrypted attributes,
then the result MUST be exactly as outlined in
[ddb-base](./ddb-base#transformQueryInput)

Otherwise, we need to find the proper [BeaconVersion](#beaconversion) for
this query, and the associated keyConditionExpression and exclusiveStartKey.

 * transformQueryInput MUST call [createKeyConditionList](#createkeyconditionlist) to create `KeyConditionList`
 * transformQueryInput MUST call [findVersion](#findversion) to create `currentVersion` and `hadContent`
 * transformQueryInput MUST fail if [findVersion](#findversion) returned (None, true)
 * if [findVersion](#findversion) returned (None, false) then transformQueryInput MUST return
the `keyConditionExpression` with the lowest version and no exclusiveStartKey
 * if [findVersion](#findversion) returned (Some(currentVersion), false), then transformQueryInput MUST return
the keyConditionExpression with lowest version greater than currentVersion,
and no exclusiveStartKey
 * if [findVersion](#findversion) returned (Some(currentVersion), true), then transformQueryInput MUST return
 * * the keyConditionExpression that matches currentVersion, and the exclusiveStartKey with the  `gZ_version` field removed, if such a keyConditionExpression exists.
 * * the keyConditionExpression with the lowest version greater than currentVersion, with no exclusiveStartKey if such a keyConditionExpression exists
 * * failure if all available versions are less than the returned version.

### transformQueryOutput
transformQueryOutput needs the original QueryInput object,
because we need to check the result items against the values searched in the QueryInput object, which are not directly available in the QueryOutput object.

 * If the `keyConditionExpression` refers to no encrypted attributes,
then the result MUST be exactly as outlined in
[ddb-base](./ddb-base#transformQueryInput).

Otherwise, we need to tag the LastEvaluatedKey

 * transformQueryOutput MUST call [createKeyConditionList](#createkeyconditionlist) to create a `keyConditionList`
 * transformQueryOutput MUST use [findVersion](#findversion) to retrieve the `currentVersion`
 * if `currentVersion` is None, replace it with the lowest version in keyConditionList
 * If the input object has a LastEvaluatedKey, transformQueryOutput must return a LastEvaluatedKey equal to the input LastEvaluatedKey with the addition of a numeric field `gZ_version=currentVersion`
 * If the input object has no LastEvaluatedKey, and `currentVersion` is greater than or equal to the highest version in the keyConditionList, then transformQueryOutput must return an object with no LastEvaluatedKey
 * Otherwise, transformQueryOutput must return a LastEvaluatedKey containing only a number field `gZ_version` set to the lowest version in keyConditionList greater than `currentVersion`


### transformScanInput

 * The object's filterExpression must be modified according to
[transformationFilterExpressionMulti](#transformationfilterexpressionmulti),
rather than [transformationFilterExpression](#transformationfilterexpression).

## Helpers


### ReadableAttribute

Version Markers are readable, so attribute names
beginnign with the [version prefix](#versionprefix) gZ_v_
must also be readable.

### transformationFilterExpressionMulti
 * transformationFilterExpression MUST take as input
a list of [BeaconVersions](#beaconversion),
an `Option<ConditionExpression>`,
an `Option<ExpressionAttributeNameMap>`,
and an `Option<ExpressionAttributeValueMap>`
 * transformationFilterExpression MUST return
an `Option<ConditionExpression>`,
an `Option<ExpressionAttributeNameMap>`,
and an `Option<ExpressionAttributeValueMap>`
 * If no [BeaconVersion](#beaconversion) is provided, transformationFilterExpressionMulti
MUST return the input arguments unchanged.
 * If one [BeaconVersion](#beaconversion) is provided, transformationFilterExpressionMulti
MUST return the results of [transformationFilterExpression](#transformationfilterexpression) with that beacon version.
 * transformationFilterExpressionMulti MUST create a list of results by calling
[transformationFilterExpression](#transformationfilterexpression)
with each provided Beacon Version.
 * transformationFilterExpressionMulti MUST remove duplicates from this list.
 * transformationFilterExpressionMulti MUST join the remaining ones, individually parenthesized, with `OR`.
For example, if E1 and E2 are created and unique, return `(E1) OR (E2)`

### findVersion
findVersion looks at the exclusiveStartKey in a QueryInput
and returns the [version number](#version-number) held therein.

 * findVersion MUST take as input a QueryInput object
 * findVersion MUST return both an optional version number and a boolean `hadContent` flag.
 * If the input object has no exclusiveStartKey, then findVersion MUST return (None, false)
 * If the exclusiveStartKey has a `gZ_version` field which holds a number,
the first value returned by findVersion MUST be that number, and None otherwise
 * If the exclusiveStartKey has fields other than `gZ_version`,
the second value returned by findVersion MUST be true, and false otherwise

### createKeyConditionList
 * createKeyConditionList MUST take as input a QueryInput object
 * createKeyConditionList MUST return a list of keyConditionExpression,
each with an associated [beacon version](#beaconversion).
 * For each [beacon version](#beacon-version) in the
[BeaconContext](#beaconcontext),
create keyConditionExpression with [createKeyCondition](#createkeycondition)
 * remove any duplicate keyConditionExpressions, keeping the ones with the highest version number.

