[//]: # "Copyright Amazon.com Inc. or its affiliates. All Rights Reserved."
[//]: # "SPDX-License-Identifier: CC-BY-SA-4.0"

# Beacon Partitions

## New Types

### PartitionCount

- An integer in the range 1..255
- The number of possible partitions in some context
- For customers not using PartitionBeacons, this is always `1`

### PartitionNumber

- An integer in the range 0..254
- The number of the partition currently under consideration in some context
- For customers not using PartitionBeacons, this is always `1`
- Range can also be considered : `0 <= PartitionNumber < PartitionCount`

### PartitionSelector

A customer supplied callback to select the [PartitionNumber](#partitionnumber) for a particular DynamoDB Item.

It has a single Entry Point
GetPartitionNumber(item: [AttributeMap](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/WorkingWithItems.html), numberOfPartitions : [PartitionCount](#partitioncount), logicalTableName : string) -> [PartitionNumber](#partitionnumber)

The default behavior ignores the Item, and picks a random partition in the range `0 <= PartitionNumber < PartitionCount`

The intent is to allow customers who know their data to take specific action.
For example, if LastName="Smith" then pick a random partition, but if LastName="Svaboda" then pick partition zero.

## New Options

### BeaconVersion

BeaconVersion has three new optional fields

#### partitionSelector : [PartitionSelector](#partitionselector)

The [PartitionSelector](#partitionselector) to be used for items in this table.

#### maximumNumberOfPartitions : [PartitionCount](#partitioncount)

The total number of partitions in the table. This may be increased over time.

#### defaultNumberOfPartitions : [PartitionCount](#partitioncount)

The number of partitions for any [Standard Beacon](../../searchable-encryption/beacons.md#standard-beacon) that does not explicitly specify a `numberOfPartitions`.

Under most circumstances, this may be increased over time.

Defaults to `maximumNumberOfPartitions`. If specified, must be less than `maximumNumberOfPartitions`.

### StandardBeacon

#### numberOfPartitions : [PartitionCount](#partitioncount)

The number of partitions to use for this particular beacon.

Defaults to `defaultNumberOfPartitions`. If specified, must be less than `maximumNumberOfPartitions`.

Under most circumstances, this may never be altered.

## New Entry Points

### TransformsClient::GetNumberOfQueries(QueryInput) -> PartitionCount

Examines the [query](https://docs.aws.amazon.com/amazondynamodb/latest/APIReference/API_Query.html), and the number of partitions associated with each [Standard Beacon](../../searchable-encryption/beacons.md#standard-beacon) used in the `KeyConditionExpression`, to determine the number of separate queries necessary to retrieve all of the items. In the general case, customer code would look like this.

    for i = 0 to transformClient.GetNumberOfQueries(query)
       query.ExpressionAttributeValues.Add(":aws_dbe_partition", N(i.to_string())
       dynamoClient.query(query)

In many situations, one already knows the number of queries,

- `1` if partitions are not being used,
- `maximumNumberOfPartitions` if partitions are being used, and nothing else is overridden
- `numberOfPartitions` if a single partitioned beacon is involved.

The actual value of GetNumberOfQueries is the minimum of

- maximumNumberOfPartitions
- The Least Common Multiple of the numbers of partitions in each
  [Standard Beacon](../../searchable-encryption/beacons.md#standard-beacon) involved,
  including those that are part of a [Compound Beacon](../../searchable-encryption/beacons.md#compound-beacon).

It is an error to set `:aws_dbe_partition` to a number greater than or equal to the value of `GetNumberOfQueries`.

If you did clever things with your [PartitionSelector](#partitionselector), then you might be able to perform fewer queries.

In the example above, if the query is indexed on `LastName="Svaboda"` then only one query is necessary.
