# DynamoDB Support Layer

The DynamoDB Support Layer provides everything necessary to the middleware interceptors,
with the exception of encryption and decryption.

This document specifies the interface and high level semantics of these entry points.

[DynamoDB SDK Integration](ddb-sdk-integration.md) should be specified in terms of
these operations.

The specific behavior of these operations will change over time,
as more searchable encryption functionality is implemented.

TODO - fully specify and implement these functions.

## Writable

Writable examines an AttributeMap and ensures that all attribute names are suitable for writing.
Generally this means that no attribute names starts with "aws_dbe_",
and that the name isn't already reserved as a [compound beacon](beacons.md#compound-beacon)
or [virtual field](virtual.md).

## TestConditionExpression

TestConditionExpression fails if a condition expression is not suitable for the
given encryption schema.
Generally this means no encrypted attribute is referenced.

## TestUpdateExpression

TestConditionExpression fails if a condition expression is not suitable for the
given encryption schema.
Generally this means no signed attribute is referenced.

## AddBeacons

AddBeacons examines an AttributeMap and modifies it to be appropriate for Searchable Encryption,
returning a replacement AttributeMap.

## RemoveBeacons

RemoveBeacons examines an AttributeMap and modifies it to be appropriate for customer use,
returning a replacement AttributeMap.

## CreateTableInputForBeacons

Transform a CreateTableInput object for searchable encryption.

## UpdateTableInputForBeacons

Transform an UpdateTableInput object for searchable encryption.

## DescribeTableOutputForBeacons

Transform a DescribeTableOutput object for searchable encryption.

## QueryInputForBeacons

Transform an unencrypted QueryInput object for searchable encryption.

## QueryOutputForBeacons

Transform an unencrypted QueryOutput object for searchable encryption.

## ScanInputForBeacons

Transform an unencrypted QueryInput object for searchable encryption.

## ScanOutputForBeacons

Transform an unencrypted QueryOutput object for searchable encryption.

