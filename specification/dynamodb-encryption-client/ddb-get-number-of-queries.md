[//]: # "Copyright Amazon.com Inc. or its affiliates. All Rights Reserved."
[//]: # "SPDX-License-Identifier: CC-BY-SA-4.0"

# Get Number of Queries

## Overview

When using [Partition Beacons](../changes/2025-08-25-partition-beacons/background.md),
more than one [query](https://docs.aws.amazon.com/amazondynamodb/latest/APIReference/API_Query.html)
can be necessary to retrieve all of the desired results,
leading to code something like this:

```text
    for i = 0 to transformClient.GetNumberOfQueries(query)
       query.ExpressionAttributeValues.Add(":aws_dbe_partition", N(i.to_string())
       dynamoClient.query(query)
```

## Operation

### Input

This operation MUST take as input the QueryInput structure under consideration.

This operation MUST return the number of queries necessary.

### Behavior

Based on the [standard beacons](../searchable-encryption/beacons.md#standard-beacon)
used in the [KeyConditionExpression](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Query.KeyConditionExpressions.html) of the query, calculate the required number of queries.

This value is the minimum of the calculated value,
and the [maximum number of partitions](../searchable-encryption/search-config.md#max-partitions)
configured for the table.

The calculated value is the least common multiple of the number of partitions for each of the beacons involved.

This is not needed for a [scan](https://docs.aws.amazon.com/amazondynamodb/latest/APIReference/API_Scan.html)
operation. Only one Scan is needed, regardless of partition settings.
