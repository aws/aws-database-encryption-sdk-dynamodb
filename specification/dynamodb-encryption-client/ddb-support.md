# DynamoDB Support Layer

The DynamoDB Support Layer provides everything necessary to the middleware interceptors,
with the exception of encryption and decryption.

This document specifies the interface and high level semantics of these entry points.

[DynamoDB SDK Integration](ddb-sdk-integration.md) should be specified in terms of
these operations.

There are two categories os support function.

The first category is for general support, used across multiple DynamoDB interceptors.
 * [Writable](#writable) - are the attributes in this item ok to write
 * [TestConditionExpression](#testconditionexpression) - Is this condition expression suitable for use
 * [TestUpdateExpression](#testupdateexpression) - Is this update expression suitable for use
 * [AddBeacons](#addbeacons) - Add attributes to an item to enable searchable encryption
 * [RemoveBeacons](#removebeacons) - Remove all private attributes from an item, e.g. the ones added in [AddBeacons](#addbeacons)

The second category is support for specific interceptors, where the whole input or output structure is modified.
 * [CreateTableInputForBeacons](#createtableinputforbeacons)
 * [UpdateTableInputForBeacons](#updatetableinputforbeacons)
 * [DescribeTableOutputForBeacons](#describetableoutputforbeacons)
 * [QueryInputForBeacons](#queryinputforbeacons)
 * [QueryOutputForBeacons](#queryoutputforbeacons)
 * [ScanInputForBeacons](#scaninputforbeacons)
 * [ScanOutputForBeacons](#scanoutputforbeacons)

## Writable

Writeable MUST reject any item containing an attribute which
* begins with `aws_dbe_`
* has the same name as a [virtual field](../searchable-encryption/virtual.md)
* has the same name as a [compound beacon](../searchable-encryption/beacons.md#compound-beacon)

## TestConditionExpression

TestConditionExpression MUST fail if a condition expression refers to any encrypted attribute.

## TestUpdateExpression

TestUpdateExpression MUST fail if an update expression refers to any signed attribute.

## AddBeacons

AddBeacons examines an AttributeMap and modifies it to be appropriate for Searchable Encryption,
returning a replacement AttributeMap.

For every configured beacon which can be successfully built from the attributes in the input AttributeMap,
AddBeacons MUST add an attribute named aws_dbe_b_NAME, where NAME is the name of the beacon.
The value of this attribute MUST be a string, and must have the value defined in [beacons](../searchable-encryption/beacons.md)

AddBeacons MUST also add an attribute with name `aws_dbe_v_1` and whose value is a string containing a single space.

The result of AddBeacons MUST contain, unaltered, everything in the input AttributeMap.

## RemoveBeacons

RemoveBeacons examines an AttributeMap and modifies it to be appropriate for customer use,
returning a replacement AttributeMap.

AddBeacons MUST remove any attributes whose name begins with `aws_dbe_`,
and leave all other attributes unchanged.


## CreateTableInputForBeacons

Transform a CreateTableInput object for searchable encryption.

Any beacon mentioned by name in the KeySchema, AttributeDefinitions, LocalSecondaryIndexes or GlobalSecondaryIndexes
MUST be replaced by the internal beacon name, i.e. aws_dbe_b_NAME, where NAME is the name of the beacon.

## UpdateTableInputForBeacons

Transform an UpdateTableInput object for searchable encryption.

Any beacon mentioned by name in the AttributeDefinitions or GlobalSecondaryIndexes
MUST be replaced by the internal beacon name, i.e. aws_dbe_b_NAME, where NAME is the name of the beacon.

## DescribeTableOutputForBeacons

Transform a DescribeTableOutput object for searchable encryption.

Any internal beacon name used in the KeySchema, LocalSecondaryIndexes or GlobalSecondaryIndexes
MUST be replaced by the beacon name, i.e. aws_dbe_b_NAME, must be replaced by NAME.

## QueryInputForBeacons

Transform an unencrypted QueryInput object for searchable encryption.

For any beacon mentioned in the KeyConditionExpression or FilterExpression,
the name MUST be replaced but the internal beacon name, i.e. NAME must be replaced by aws_dbe_b_NAME.
If the name was used directly in the expression, the name should be change in the expression;
otherwise the name should be changed in ExpressionAttributeNames.

Similarly, any values in ExpressionAttributeValues that are referred to by a beacon name
MUST be changed to the beacon value, as calculated defined in [beacons](../searchable-encryption/beacons.md).

## QueryOutputForBeacons

Transform an unencrypted QueryOutput object for searchable encryption.

Each item in `Items` must be examined in the context of the original `QueryInput`,
and any items that should not have matched MUST be discarded.

The `Count` field, must be updated to reflect the new item count.

## ScanInputForBeacons

Transform an unencrypted ScanInput object for searchable encryption.

The ScanInput is transformed in the same way as [QueryInputForBeacons](#queryinputforbeacons).

## ScanOutputForBeacons

Transform an unencrypted ScanOutput object for searchable encryption.

The ScanOutput is transformed in the same way as [QueryOutputForBeacons](#queryoutputforbeacons).
