[//]: # "Copyright Amazon.com Inc. or its affiliates. All Rights Reserved."
[//]: # "SPDX-License-Identifier: CC-BY-SA-4.0"

# Bucket Beacons

## New Types

### BucketCount

- An integer in the range 1..255
- The number of possible buckets in some context
- For customers not using BucketBeacons, this is always `1`

### BucketNumber

- An integer in the range 0..254
- The number of the bucket currently under consideration in some context
- For customers not using BucketBeacons, this is always `1`
- Range can also be considered : `0 <= BucketNumber < BucketCount`

### BucketSelector

A customer supplied callback to select the [BucketNumber](#bucketnumber) for a particular DynamoDB Item.

It has a single Entry Point
GetBucketNumber(item: [AttributeMap](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/WorkingWithItems.html), numberOfBuckets : [BucketCount](#bucketcount), logicalTableName : string) -> [BucketNumber](#bucketnumber)

The default behavior ignores the Item, and picks a random bucket in the range `0 <= BucketNumber < BucketCount`

The intent is to allow customers who know their data to take specific action.
For example, if LastName="Smith" then pick a random bucket, but if LastName="Svaboda" then pick bucket zero.

## New Options

### BeaconVersion

BeaconVersion has three new optional fields

#### bucketSelector : [BucketSelector](#bucketselector)

The [BucketSelector](#bucketselector) to be used for items in this table.

#### maximumNumberOfBuckets : [BucketCount](#bucketcount)

The total number of buckets in the table. This may be increased over time.

#### defaultNumberOfBuckets : [BucketCount](#bucketcount)

The number of buckets for any [Standard Beacon](../../searchable-encryption/beacons.md#standard-beacon) that does not explicitly specify a `numberOfBuckets`.

Under most circumstances, this may be increased over time.

Defaults to `maximumNumberOfBuckets`. If specified, must be less than `maximumNumberOfBuckets`.

### StandardBeacon

#### numberOfBuckets : [BucketCount](#bucketcount)

The number of buckets to use for this particular beacon.

Defaults to `defaultNumberOfBuckets`. If specified, must be less than `maximumNumberOfBuckets`.

Under most circumstances, this may never be altered.

## New Entry Points

### TransformsClient::GetNumberOfQueries(QueryInput) -> BucketCount

Examines the [query](https://docs.aws.amazon.com/amazondynamodb/latest/APIReference/API_Query.html), and the number of buckets associated with each [Standard Beacon](../../searchable-encryption/beacons.md#standard-beacon) used in the `KeyConditionExpression`, to determine the number of separate queries necessary to retrieve all of the items. In the general case, customer code would look like this.

    for i = 0 to transformClient.GetNumberOfQueries(query)
       query.ExpressionAttributeValues.Add(":aws_dbe_bucket", N(i.to_string())
       dynamoClient.query(query)

In many situations, one already knows the number of queries,

- `1` if buckets are not being used,
- `maximumNumberOfBuckets` if buckets are being used, and nothing else is overridden
- `numberOfBuckets` if a single bucketed beacon is involved.

The actual value of GetNumberOfQueries is the minimum of

- maximumNumberOfBuckets
- The Least Common Multiple of the numbers of buckets in each
  [Standard Beacon](../../searchable-encryption/beacons.md#standard-beacon) involved,
  including those that are part of a [Compound Beacon](../../searchable-encryption/beacons.md#compound-beacon).

It is an error to set `:aws_dbe_bucket` to a number greater than or equal to the value of `GetNumberOfQueries`.

If you did clever things with your [BucketSelector](#bucketselector), then you might be able to perform fewer queries.

In the example above, if the query is indexed on `LastName="Svaboda"` then only one query is necessary.
