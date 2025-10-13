[//]: # "Copyright Amazon.com Inc. or its affiliates. All Rights Reserved."
[//]: # "SPDX-License-Identifier: CC-BY-SA-4.0"

# Beacon Partitions

`Beacon Partitions` refers to a way to add a little bit more randomness to your [beacons](../../searchable-encryption/beacons.md),
to add anonymity when your data distribution is uneven

Probably read [changes](./change.md) first, as it gives a brief overview of the interface.

## A shortcoming of Beacons

[Beacons](../../searchable-encryption/beacons.md) are great if your data is evenly distributed.
There are ten of each value for an attribute,
and so in the table there are 10 or 20 or 30 occurrences of any given hash,
and an external observer can't deduce anything useful.

But what if the data is not evenly distributed?

What if you're storing last names, and your customers are primarily from the US?

In this case, some hashes will have many many occurrences, and some will have only one.

An external observer can look at census data and make an educated guess that the hashes with many occurrences are probably "Jones" or "Smith". Pretty soon, you've leaked real information.

## Introducing Beacon Partitions

One strategy to combat this is to further divide each item's beacons into separate `partitions`,
so that the same value in different records might produce different hashes.

Specifically, assigning an item to a `partition` alters the hash generated for a [Standard Beacon](../../searchable-encryption/beacons.md#standard-beacon),
so that within a partition, the hash for any given value for a given attribute is the same,
but the hash is different for different partitions.

This doesn't entirely solve the problem, but it flattens out the histogram quite a bit,
making things much more difficult to deduce.
To do the job properly, you'd need to deeply understand your data, and use a [Partition Selector](#partition-selector).

All existing databases are retroactively configured with one partition.
The hash for a value in partition number zero is the same as the hash in an unpartitioned system;
therefore, there is no difference between "one partition" and "not using partitions".

Unfortunately, when items are distributed across N partitions, retrieving all of them requires N separate queries.

- Only the `Query` operation is affected.
- `Scan` and `Get` operations continue to work as usual.

The reason Query behaves differently is that it searches against an index, which requires an exact match. This leaves no opportunity to optimize the query with a “this OR that OR other” approach, unlike a Scan which examines all items.

Note: There is no way to determine an item’s partition just by looking at its encrypted value.

### Performance Penalties

Multiple queries will always take longer than one query, however;
if the number of "pages" of results returned by DynamoDB for a query is large compared to the number of partitions,
then the overall query performance is not impacted very much.

If the query is only expected to return one result, then of course, making five queries will take five time as long,
with four of the queries returning nothing.

### Performance Advantages

On the other hand, beacon partitions can provide performance enhancements as well.

Sometimes a common value can share the same hash as a rare one.
In this case, a search for the rare one pays the penalty of retrieving and discarding all the
matches for the common one.
Beacon partitions reduce the maximum number occurrences of a single hash, reducing this penalty.

Increasing the number of partitions can allow you to increase the length of a standard beacon,
further decreasing the number of results that must be retrieved and discarded.

### Constrained Beacons

Maybe you need a different number of partitions for different standard beacons.

For example, maybe

- `LastName` has a terribly uneven distribution, and so needs 5 partitions.
- `Phone` is pretty much unique in each item, and so only needs on partition.
- `Precinct` is just a little bit uneven, and so needs two beacons.

To accomplish this, you set the number of partitions for the whole table to `5`,
and then constrain the number of partitions for the other two beacons.

The partition used to calculate the hash for a constrained beacon is
`ItemsPartition % BeaconConstraint` where `%` is the `modulo` or `remainder` operation.
The ensures that the values are reasonably well distributed among the constrained partitions,
while still guaranteeing that, given the partition for the item,
we can uniquely identify the partition for the constrained beacon.

**_WARNING_** Adding or changing the constraint on a beacon is difficult, sometimes impossible;
once any items have been written.

The only situation in which you might consider adding a constraint to a beacon is if **all** of the following apply

- You're going to use that beacon in an index (GSI)
- The queries you make against that index are expected to return a very small number of results
- Your security people have agreed that reducing the number of partitions for this beacon is acceptable.

### Behind the scenes

The KeyConditionExpression is an exact match, and therefore can only refer to one partition.
However, FilterExpression is much more flexible, and can refer to multiple partitions.

So when doing a Scan operation, only one Scan is needed.
Internally, where you had a FilterExpression of `foo`, we change it to
`(foo[0]) OR (foo[1]) OR (foo[2])`
where `foo[n]` refers to to "foo, as calculated for partition `n`"

Similarly, when you do a query where the KeyConditionExpression refers to constrained beacons,
and FilterExpression refers to some unconstrained beacons,
then we do a similar transformation on the FilterExpression of the query,
so that the total number of queries necessary is limited by the constrained beacons.

If the table has `maximumNumberOfPartitions` of `5`, then the query on partition zero will have
`(foo[0]) OR (foo[2]) OR (foo[4])` and the query on partition 1 will have `(foo[1]) OR (foo[3])`

## Usage

### GetNumberOfQueries

A new operation, GetNumberOfQueries, tells you how many queries are necessary for a given QueryInput.

One often knows this number ahead of time, as discussed in [changes](./change.md).

If you use a [Partition Selector](#partition-selector) you can sometimes do fewer queries than this.

### Query Loop

If you're using partitions, then wherever you do a query, you need code like this.

```text
    for i = 0 to transformClient.GetNumberOfQueries(query)
       query.ExpressionAttributeValues.Add(":aws_dbe_partition", N(i.to_string())
       dynamoClient.query(query)
```

It is an error to set `:aws_dbe_partition` to a value greater than or equal to the value returned by `GetNumberOfQueries`.

## Configuring Partitions

### Maximum Partitions

The [BeaconVersion](../../searchable-encryption/search-config.md#beacon-version-initialization) structure
has a new optional field maximumNumberOfPartitions.
This indicates the number of partitions into which your data is to be divided.
If you set `maximumNumberOfPartitions` to `5`,
then each item written will be assigned to one of five partitions,
and every [Standard Beacon](../../searchable-encryption/beacons.md#standard-beacon) value
will now have five different values in the table.
This means that you will have to make five different queries to get all of your data.

Setting only `maximumNumberOfPartitions` will provide the easiest forward compatibility story,
as going forward, `maximumNumberOfPartitions` can be increased at any time.
Increasing `maximumNumberOfPartitions` will not, of course,
change the partition assignment of any existing item; but only newly written items.
If you change `maximumNumberOfPartitions` from `5` to `7`,
then you will immediately need to start making 7 queries,
but the sixth and seventh queries will return a comparatively small number of items.

### Beacon Constraints

The configuration for each [Standard Beacon](../../searchable-encryption/beacons.md#standard-beacon)
can now take a `numberOfPartitions`, which constrains that beacon accordingly.
Be very careful with this, as per [Constrained Beacons](#constrained-beacons) above.

### Default Constraints

The [BeaconVersion](../../searchable-encryption/search-config.md#beacon-version-initialization) structure
also has a new optional field `defaultNumberOfPartitions`.

If this is set (to something less than `maximumNumberOfPartitions`) then any beacon that does not
specify an explicit `numberOfPartitions` will be constrained to this number of partitions.
For example, if LastName was the only attribute that warranted partition use, then you might have
`maximumNumberOfPartitions = 5` and `defaultNumberOfPartitions = 1` in the BeaconVersion,
and then `numberOfPartitions = 5` on the LastName beacon.

### Partition Selector

For fine grained control, one can implement a PartitionSelector, which is an object with a single method
GetPartitionNumber(item: [AttributeMap](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/WorkingWithItems.html), numberOfPartitions : [PartitionCount](./change.md#partitioncount), logicalTableName : string) -> [PartitionNumber](./change.md#partitionnumber).

This would allow one to set `numberOfPartitions = 5` on the LastName beacon as above,
and then choose the partition for each item explicitly, based on the LastName value.
Perhaps "Smith" would be divided among all 5 partitions, while "Svaboda" was always placed in partition zero.
This has two benefits

- This can do a much better job of overcoming the [shortcoming of Beacons](#a-shortcoming-of-beacons),
  by only splitting the popular names, making the distribution of hashes even more regular.
- When querying on the LastName "Svaboda", only one query is needed, rather than five.

## Changing Beacon Constraints

You shouldn't do this. Both Query and Scan may stop being able to find some items.

### Short answer

You can't. Once you've set `numberOfPartitions` on a beacon,
or `defaultNumberOfPartitions` on a table,
you can never change that configuration.

Why not? Because when we write, the item has a partition, and each beacon calculates its partition from the item's partition.
When we Query, the query has a partition and each beacon calculates its partition from the query's partition.
If you change a constraint, then the beacon partition calculation at query time will not produce the same results as were used when the item was written. For example:

- `maximumNumberOfPartitions` for a table is 5
- Beacon A has no constraint
- Beacon B is constrained to 2 partitions.
- We write an item. Its partition is 4.
- Beacon A is put in partition 4, beacon B is put in partition `4 % 2` or 0.
- We search with ":aws_dbe_partition = 4". We look for beacon A in partition 4 and beacon B in partition 0
- We find the item.
- Now we change the constraint to `3`.
- We search with ":aws_dbe_partition = 4". We look for beacon A in partition 4 and beacon B in partition `4 % 3` or 1
- We do not find the item.

### Long answer

Maybe sometimes, if you're careful.

As the example above shows, the problem is that a search with ":aws_dbe_partition = N" must calculate
hashes (i.e. partitions) for all the beacons in the same way as when then item was written.

However, if you're only using a few beacons, then as long as those beacons have compatible changes,
then all of the items can still be found.

`Using` in this context include both KeyConditionExpression and FilterExpression,
and include both plain standard beacons and standard beacons used as part of a compound beacon.

Compatible in this context means that, for any ":aws_dbe_partition = N",

- before the change, all involved beacons were put in the same partition
- after the change, all involved beacons are put in the same partition

but the partition before might be different than the partition after.

To be compatible, all involved beacons must have always had the same number of partitions as each other,
whether through `numberOfPartitions` or by inheriting from `defaultNumberOfPartitions`,
and that number has only increased over time.

The easiest compatible change : no involved beacons specified `numberOfPartitions`, and `defaultNumberOfPartitions` was increased.

### Possible Future Answer 1

Hypothetically, if the beacons in the KeyConditionExpression are compatible,
and the beacons in the FilterExpression are compatible,
but the two sets are not compatible with each other,
then we could flesh out the filter expression as discussed in [Behind the scenes](#behind-the-scenes)
to cover all the partitions, and not just the subset necessitated by the current partition.
This would require an extra value to be passed, possibly `[":aws_dbe_full_filter = true]` or some such.

### Possible Future Answer 2

Hypothetically, instead of `:aws_dbe_partition = 4` one could set `:aws_dbe_partition_map = ['A" = 4, 'B' = 0]`
which tells the interceptor to calculate beacon A for partition 4 and beacon B for partition 0.

If you know exactly what data has been written, a long enough list of these would find all of the items.

We don't want to implement this until we're sure someone would actually use it.

## Migration

A non-partitioned table is the same as a table with `maximumNumberOfPartitions == 1`.

Further, each individual beacon can either be considered to be unconstrained,
or constrained to one partition.

Given that, migration from non-partitioned to partitioned follows the same rules as any other change in partition settings.

You can always increase maximumNumberOfPartitions.
It won't magically improve the anonymity of you existing data,
but new data will be properly anonymized and both old and new data will be found when doing partitioned searches.

The individual beacon constraints must remain unchanged.
This when you first move to multiple partition,
each beacon must either be constrained to one partition, or be unconstrained.

## Test Strategy

### Normal Operation

Create a table with a maximum of 5 partitions, a variety of beacons with different numbers of partitions,
and with GSIs built on a variety of combinations of those indexes.

Put 100 items in that table, with different PK attributes,
but the exact same values for all the other attributes.
We expect around 20 items per partition, and are pretty guaranteed that no partition is empty.

Perform a variety of queries against the table.
For each, assert that

- GetNumberOfQueries returns the expected value
- When performing `GetNumberOfQueries` queries,
  - each partition returns at least one value
  - every item is returned exactly one
- When performing queries with the partition number set to `GetNumberOfQueries` or greater, an error is returned.

Perform a very large number of Scans against the table.
These are easier to test, as they do not require a different index for each one, as the Query ones do.
Test that a single Scan returns every item exactly once.

### Test Partition Selector

Repeat [Normal Operation](#normal-operation), but

- add an attribute to hold a partition number
- include a [Partition Selector](../../searchable-encryption/search-config.md#partition-selector)
  that puts each item in the indicated partition.
- when searching on a partition, assert that the item was in the correct partition.

### Test Filter Expressions

The functionality of the [Filter Expressions for Query](../../dynamodb-encryption-client/ddb-support.md#filter-expressions-for-query) is well tested by the above.

For a few scan operations, assert that the text of the calculated filter expressions are as expected.

### Test Compound Beacons

Create some complex compound beacons, create indexes with them,
and repeat the same test as in [Normal Operation](#normal-operation).
