[//]: # "Copyright Amazon.com Inc. or its affiliates. All Rights Reserved."
[//]: # "SPDX-License-Identifier: CC-BY-SA-4.0"

# DynamoDB SDK Integration

## Version

1.0.0

### Changelog

- 1.0.0
  - Initial record

## Definitions

### Conventions used in this document

The key words "MUST", "MUST NOT", "REQUIRED", "SHALL", "SHALL NOT", "SHOULD", "SHOULD NOT", "RECOMMENDED", "MAY", and "OPTIONAL"
in this document are to be interpreted as described in [RFC 2119](https://tools.ietf.org/html/rfc2119).

## Overview

Customers want to be able to use the
AWS SDK to call the DynamoDB APIs they are familiar with,
while having encryption and decryption of their items
happen transparently.

The AWS SDK is available in a variety of languages,
and the ways to configure and construct the client in each differs.
Thus, providing this behavior in each AWS SDK language
will not be standardized.

There MUST be some process by which
the customer can create this AWS SDK with
additional encryption behavior, which
this document will refer to as a [DynamoDB Encryption Client](#dynamodb-encryption-client).
There is no restriction on what this process is,
other than the fact that at some point the customer
MUST specify a [DynamoDB Encryption Client Configuration](#dynamodb-encryption-client-configuration).
This configuration MUST be the configuration ultimately used by
the behaviors within the DynamoDB Encryption Client.

For example, the AWS SDK for Java (as of 2.x) defines a
[Interceptor interface](https://sdk.amazonaws.com/java/api/latest/software/amazon/awssdk/core/interceptor/ExecutionInterceptor.html)
which can be used to add logic before and after API calls.
In order to provide an idiomatic experience for AWS SDK for Java customers,
to implement this for the Java SDK we would implement an Interceptor that
requires the [DynamoDB Encryption Client Configuration](#dynamodb-encryption-client-configuration)
on construction.
This interceptor can then itself be use as input when building the AWS SDK client
in order to create a client which performs the necessary encryption and decryption
logic during API calls.

For AWS SDKs that do not support an idiomatic way to hook new
behavior before and after API calls,
this MAY be implemented by providing an
implementation of AWS SDK APIs that wrap
the relevant APIs with the necessary encryption and decryption logic.
This new implementation SHOULD be a drop-in replacement of the
regular AWS SDK.

## DynamoDB Encryption Client Configuration

The DynamoDB Encryption Client Configuration is a structure that
the customer MUST provide in the process of creating a [DynamoDB Encryption Client](#dynamodb-encryption-client).

The client configuration consists of the following REQUIRED field:

- [DynamoDb Table Encryption Configs](#dynamodb-table-encryption-configs)

### DynamoDb Table Encryption Configs

A map of DynamoDb table names to a structure that MUST contain
data as described by [DynamoDb Table Encryption Config](./ddb-table-encryption-config.md).
Note that this data does not need to contain the Table Name.

During initialization, this client MUST construct a
[DynamoDb Item Encryptor](./ddb-table-encryption-config.md)
per configured table, using these table encryption configs.

### Encrypted Table

If there exists an Item Encryptor specified within the
[DynamoDB Encryption Client Config](#dynamodb-encryption-client-configuration)
with a [DynamoDB Table Name](./ddb-item-encryptor.md#dynamodb-table-name)
equal to a given `TableName`, that table is said to be an `Encrypted Table`.

## DynamoDB Encryption Client

The DynamoDB Encryption Client is an AWS SDK client for DynamoDB,
such that client-side encryption and decryption happens transparently during
AWS SDK API calls to DynamoDB.

### General Modification Behavior

If no Item Encryptor is specified for the table, the call to DynamoDB is unmodified.
Otherwise:

No DDB API legacy parameters (such as `AttributesToGet`) can be specified.

Any Condition Expression must be checked for [validity](ddb-support.md#testconditionexpression).
Any Update Expression must be checked for [validity](ddb-support.md#testupdateexpression)

If data is to be written

- the input data must validated
- beacons must be added
- the input data must be encrypted

If data is being read

- the output data must be decrypted
- beacons must be removed

For Query and Scan, more complex processing must be invoked for both input (before encryption),
and output (after decryption).

### API modification

DynamoDB API calls
MUST have the following modified behavior:

- [Encrypt before PutItem](#encrypt-before-putitem)
- [Encrypt before BatchWriteItem](#encrypt-before-batchwriteitem)
- [Encrypt before TransactWriteItems](#encrypt-before-transactwriteitems)
- [Decrypt after GetItem](#decrypt-after-getitem)
- [Decrypt after PutItem](#decrypt-after-putitem)
- [Decrypt after UpdateItem](#decrypt-after-updateitem)
- [Decrypt after DeleteItem](#decrypt-after-deleteitem)
- [Decrypt after BatchGetItem](#decrypt-after-batchgetitem)
- [Decrypt after Scan](#decrypt-after-scan)
- [Decrypt after Query](#decrypt-after-query)
- [Decrypt after TransactGetItem](#decrypt-after-transactgetitems)
- [Validate before UpdateItem](#validate-before-updateitem)
- [Validate before DeleteItem](#validate-before-deleteitem)
- [Validate before ExecuteStatement](#validate-before-executestatement)
- [Validate before BatchExecuteStatement](#validate-before-batchexecutestatement)
- [Validate before ExecuteTransaction](#validate-before-executetransaction)
- [Modify before Scan](#modify-before-scan)
- [Modify before Query](#modify-before-query)

The [Allowed Passthrough DynamoDB APIs](#allowed-passthrough-dynamodb-apis)
MUST NOT be modified.

Any DynamoDB API not specified is this document either
MUST NOT be callable or MUST yield an error,
and that error SHOULD indicate that the operation
is not supported with DynamoDB client-side encryption.

### Encrypt before PutItem

Before the [PutItem](https://docs.aws.amazon.com/amazondynamodb/latest/APIReference/API_PutItem.html)
call is made to DynamoDB :

If the `TableName` in the request does not refer to an [encrypted-table](#encrypted-table),
the PutItem request MUST be unchanged.

Otherwise,

The PutItem request MUST NOT refer to any legacy parameters,
specifically Expected and ConditionalOperator MUST NOT be set.

The Item MUST be [writable](ddb-support.md#writable).

The ConditionExpression MUST be [valid](ddb-support.md#testconditionexpression).

Signed Beacons MUST be [added](ddb-support.md#addsignedbeacons).

If the [Beacon Key Source](../searchable-encryption/search-config.md#beacon-key-source)
is a [Multi Key Store](../searchable-encryption/search-config.md#multi-key-store-initialization)
the [Beacon Key Field Name](../searchable-encryption/search-config.md#beacon-key-field-name)
MUST be [handled](./ddb-support.md#handlebeaconkeyfieldname).

If the [Beacon Key Source](../searchable-encryption/search-config.md#beacon-key-source)
is a [Multi Key Store](../searchable-encryption/search-config.md#multi-key-store-initialization)
the [Item Encryptor](./ddb-item-encryptor.md) MUST perform
[Encrypt Item](./encrypt-item.md),
where the input [DynamoDB Item](./encrypt-item.md#dynamodb-item)
is output of [handling the beacon key field name](ddb-support.md#handlebeaconkeyfieldname) operation.

If the [Beacon Key Source](../searchable-encryption/search-config.md#beacon-key-source)
is a [Single Key Store](../searchable-encryption/search-config.md#single-key-store-initialization)
the [Item Encryptor](./ddb-item-encryptor.md) MUST perform
[Encrypt Item](./encrypt-item.md),
where the input [DynamoDB Item](./encrypt-item.md#dynamodb-item)
is output of [adding the signed beacons](ddb-support.md#addsignedbeacons) operation.

If the [Beacon Key Source](../searchable-encryption/search-config.md#beacon-key-source)
is a [Multi Key Store](../searchable-encryption/search-config.md#multi-key-store-initialization)
and a `branch key id` was returned from [handling the beacon key field name](ddb-support.md#handlebeaconkeyfieldname)
this `branch key id` MUST match the value
returned from [Get beacon key id from Parsed Header](../searchable-encryption/search-config.md#get-beacon-key-id-from-parsed-header).

Encrypted Beacons MUST be [added](ddb-support.md#addencryptedbeacons).

If any of the above fails,
the client MUST NOT make a network call to DynamoDB,
and PutItem MUST yield an error.

The PutItem request's `Item` field MUST be replaced
with a value that is equivalent to
the output of the [add encrypted beacons](ddb-support.md#addencryptedbeacons) operation
calculated above.

### Encrypt before BatchWriteItem

Before the [BatchWriteItem](https://docs.aws.amazon.com/amazondynamodb/latest/APIReference/API_BatchWriteItem.html)
call is made to DynamoDB :

For each table name in `RequestItems`

If the table name does not refer to an [encrypted-table](#encrypted-table),
the list of operations MUST be unchanged.

Otherwise,

For each operation associated with the table name, if there is a PutRequest:

The Item MUST be [writable](ddb-support.md#writable).

Signed Beacons MUST be [added](ddb-support.md#addsignedbeacons).

If the [Beacon Key Source](../searchable-encryption/search-config.md#beacon-key-source)
is a [Multi Key Store](../searchable-encryption/search-config.md#multi-key-store-initialization)
the [Beacon Key Field Name](../searchable-encryption/search-config.md#beacon-key-field-name)
MUST be [handled](./ddb-support.md#handlebeaconkeyfieldname).

If the [Beacon Key Source](../searchable-encryption/search-config.md#beacon-key-source)
is a [Multi Key Store](../searchable-encryption/search-config.md#multi-key-store-initialization)
the [Item Encryptor](./ddb-item-encryptor.md) MUST perform
[Encrypt Item](./encrypt-item.md),
where the input [DynamoDB Item](./encrypt-item.md#dynamodb-item)
is output of [handling the beacon key field name](ddb-support.md#handlebeaconkeyfieldname) operation.

If the [Beacon Key Source](../searchable-encryption/search-config.md#beacon-key-source)
is a [Single Key Store](../searchable-encryption/search-config.md#single-key-store-initialization)
the [Item Encryptor](./ddb-item-encryptor.md) MUST perform
[Encrypt Item](./encrypt-item.md),
where the input [DynamoDB Item](./encrypt-item.md#dynamodb-item)
is output of [adding the signed beacons](ddb-support.md#addsignedbeacons) operation.

If the [Beacon Key Source](../searchable-encryption/search-config.md#beacon-key-source)
is a [Multi Key Store](../searchable-encryption/search-config.md#multi-key-store-initialization)
and a `branch key id` was returned from [handling the beacon key field name](ddb-support.md#handlebeaconkeyfieldname)
this `branch key id` MUST match the value
returned from [Get beacon key id from Parsed Header](../searchable-encryption/search-config.md#get-beacon-key-id-from-parsed-header).

Encrypted Beacons MUST be [added](ddb-support.md#addencryptedbeacons).

If any of the above fails,
the client MUST NOT make a network call to DynamoDB,
and BatchWriteItem MUST yield an error.

The PutRequest request's `Item` field MUST be replaced
with a value that is equivalent to
the result [Encrypted DynamoDB Item](./encrypt-item.md#encrypted-dynamodb-item)
calculated above.

### Encrypt before TransactWriteItems

Before the [TransactWriteItems](https://docs.aws.amazon.com/amazondynamodb/latest/APIReference/API_TransactWriteItems.html)
call is made to DynamoDB, for every entry under `TransactItems`:

To protect against a possible fifth field being added to the TransactWriteItem structure in the future,
the client MUST fail if none of the `Update`, `ConditionCheck`, `Delete` and `Put` fields are set.

Any actions other than `Put`, MUST be unchanged.

Any `Put` actions with a `TableName` that does not refer to an [encrypted-table](#encrypted-table),
MUST be unchanged.

If there is an `Update` that refers to a `TableName` that refers to an [encrypted-table](#encrypted-table)

- The UpdateExpression of the `Update` MUST be [valid](ddb-support.md#testupdateexpression).
- The ConditionExpression of the `Update` MUST be [valid](ddb-support.md#testconditionexpression).

If there is a `ConditionCheck` that refers to a `TableName` that refers to an [encrypted-table](#encrypted-table)

- The ConditionExpression of the `ConditionCheck` MUST be [valid](ddb-support.md#testconditionexpression).

If there is a `Delete` that refers to a `TableName` that refers to an [encrypted-table](#encrypted-table)

- The ConditionExpression of the `Delete` MUST be [valid](ddb-support.md#testconditionexpression).

If there is a `Put` that refers to a `TableName` that refers to an [encrypted-table](#encrypted-table)

- The Item MUST be [writable](ddb-support.md#writable).
- The ConditionExpression `Put` MUST be [valid](ddb-support.md#testconditionexpression).
- Signed Beacons MUST be [added](ddb-support.md#addsignedbeacons).
- If the [Beacon Key Source](../searchable-encryption/search-config.md#beacon-key-source)
  is a [Multi Key Store](../searchable-encryption/search-config.md#multi-key-store-initialization)
  the [Beacon Key Field Name](../searchable-encryption/search-config.md#beacon-key-field-name)
  MUST be [handled](./ddb-support.md#handlebeaconkeyfieldname).
- If the [Beacon Key Source](../searchable-encryption/search-config.md#beacon-key-source)
  is a [Multi Key Store](../searchable-encryption/search-config.md#multi-key-store-initialization)
  the [Item Encryptor](./ddb-item-encryptor.md) MUST perform
  [Encrypt Item](./encrypt-item.md),
  where the input [DynamoDB Item](./encrypt-item.md#dynamodb-item)
  is output of [handling the beacon key field name](ddb-support.md#handlebeaconkeyfieldname) operation.
- If the [Beacon Key Source](../searchable-encryption/search-config.md#beacon-key-source)
  is a [Single Key Store](../searchable-encryption/search-config.md#single-key-store-initialization)
  the [Item Encryptor](./ddb-item-encryptor.md) MUST perform
  [Encrypt Item](./encrypt-item.md),
  where the input [DynamoDB Item](./encrypt-item.md#dynamodb-item)
  is output of [adding the signed beacons](ddb-support.md#addsignedbeacons) operation.
- If the [Beacon Key Source](../searchable-encryption/search-config.md#beacon-key-source)
  is a [Multi Key Store](../searchable-encryption/search-config.md#multi-key-store-initialization)
  and a `branch key id` was returned from [handling the beacon key field name](ddb-support.md#handlebeaconkeyfieldname)
  this `branch key id` MUST match the value
  returned from [Get beacon key id from Parsed Header](../searchable-encryption/search-config.md#get-beacon-key-id-from-parsed-header).
- Encrypted Beacons MUST be [added](ddb-support.md#addencryptedbeacons).
- If any of the above fails,
  the client MUST NOT make a network call to DynamoDB,
  and PutItem MUST yield an error.
- The PutItem request's `Item` field MUST be replaced
  with a value that is equivalent to
  the result [Encrypted DynamoDB Item](./encrypt-item.md#encrypted-dynamodb-item)
  calculated above.

### Decrypt after GetItem

After a [GetItem](https://docs.aws.amazon.com/amazondynamodb/latest/APIReference/API_GetItem.html)
call is made to DynamoDB,
the resulting response MUST be modified before
being returned to the caller if there exists
an Item Encryptor specified within the [DynamoDB Encryption Client Config](#dynamodb-encryption-client-configuration)
with a [DynamoDB Table Name](./ddb-item-encryptor.md#dynamodb-table-name)
equal to the `TableName` on the GetItem request.

The [Item Encryptor](./ddb-item-encryptor.md) MUST perform
[Decrypt Item](./decrypt-item.md) where the input
[DynamoDB Item](./decrypt-item.md#dynamodb-item)
is the `Item` field in the original response

Beacons MUST be [removed](ddb-support.md#removebeacons) from the result.

The GetItem response's `Item` field MUST be
replaced by the encrypted DynamoDb Item outputted above.

### Decrypt after PutItem

After a [PutItem](https://docs.aws.amazon.com/amazondynamodb/latest/APIReference/API_PutItem.html)
call is made to DynamoDB,
the resulting response MUST be modified before
being returned to the caller if:

- there exists an Item Encryptor specified within the
  [DynamoDB Encryption Client Config](#dynamodb-encryption-client-configuration)
  with a [DynamoDB Table Name](./ddb-item-encryptor.md#dynamodb-table-name)
  equal to the `TableName` on the PutItem request.
- the response contains [Attributes](https://docs.aws.amazon.com/amazondynamodb/latest/APIReference/API_PutItem.html#DDB-PutItem-response-Attributes).
  The response will contain Attributes if the related PutItem request's
  [ReturnValues](https://docs.aws.amazon.com/amazondynamodb/latest/APIReference/API_PutItem.html#DDB-PutItem-request-ReturnValues)
  had a value of `ALL_OLD` and the PutItem call replaced a pre-existing item.

In this case, the [Item Encryptor](./ddb-item-encryptor.md) MUST perform
[Decrypt Item](./decrypt-item.md) where the input
[DynamoDB Item](./decrypt-item.md#dynamodb-item)
is the `Attributes` field in the original response

Beacons MUST be [removed](ddb-support.md#removebeacons) from the result.

The PutItem response's `Attributes` field MUST be
replaced by the encrypted DynamoDb Item outputted above.

### Decrypt after DeleteItem

After a [DeleteItem](https://docs.aws.amazon.com/amazondynamodb/latest/APIReference/API_DeleteItem.html)
call is made to DynamoDB,
the resulting response MUST be modified before
being returned to the caller if:

- there exists an Item Encryptor specified within the
  [DynamoDB Encryption Client Config](#dynamodb-encryption-client-configuration)
  with a [DynamoDB Table Name](./ddb-item-encryptor.md#dynamodb-table-name)
  equal to the `TableName` on the DeleteItem request.
- the response contains [Attributes](https://docs.aws.amazon.com/amazondynamodb/latest/APIReference/API_DeleteItem.html#DDB-DeleteItem-response-Attributes).
  The response will contain Attributes if the related DeleteItem request's
  [ReturnValues](https://docs.aws.amazon.com/amazondynamodb/latest/APIReference/API_DeleteItem.html#DDB-DeleteItem-request-ReturnValues)
  had a value of `ALL_OLD` and an item was deleted.

In this case, the [Item Encryptor](./ddb-item-encryptor.md) MUST perform
[Decrypt Item](./decrypt-item.md) where the input
[DynamoDB Item](./decrypt-item.md#dynamodb-item)
is the `Attributes` field in the original response

Beacons MUST be [removed](ddb-support.md#removebeacons) from the result.

The DeleteItem response's `Attributes` field MUST be
replaced by the encrypted DynamoDb Item outputted above.

### Decrypt after UpdateItem

After a [UpdateItem](https://docs.aws.amazon.com/amazondynamodb/latest/APIReference/API_UpdateItem.html)
call is made to DynamoDB,
the resulting response MUST be modified before
being returned to the caller if:

- there exists an Item Encryptor specified within the
  [DynamoDB Encryption Client Config](#dynamodb-encryption-client-configuration)
  with a [DynamoDB Table Name](./ddb-item-encryptor.md#dynamodb-table-name)
  equal to the `TableName` on the UpdateItem request.
- the response contains [Attributes](https://docs.aws.amazon.com/amazondynamodb/latest/APIReference/API_UpdateItem.html#DDB-UpdateItem-response-Attributes).
- the original UpdateItem request had a
  [ReturnValues](https://docs.aws.amazon.com/amazondynamodb/latest/APIReference/API_UpdateItem.html#DDB-UpdateItem-request-ReturnValues)
  with a value of `ALL_OLD` or `ALL_NEW`.

In this case, the [Item Encryptor](./ddb-item-encryptor.md) MUST perform
[Decrypt Item](./decrypt-item.md) where the input
[DynamoDB Item](./decrypt-item.md#dynamodb-item)
is the `Attributes` field in the original response

Beacons MUST be [removed](ddb-support.md#removebeacons) from the result.

The UpdateItem response's `Attributes` field MUST be
replaced by the encrypted DynamoDb Item outputted above.

In all other cases, the UpdateItem response MUST NOT be modified.

Additionally, if a value of `UPDATED_OLD` or `UPDATED_NEW` was used,
and any Attributes in the response are authenticated
per the [DynamoDB Encryption Client Config](#dynamodb-encryption-client-configuration),
an error MUST be raised.
Given that we [validate UpdateItem requests](#validate-before-updateitem),
and thus updates will not modify any signed field,
an error here would indicate a bug in
our library or a bug within DynamoDB.

### Decrypt after BatchGetItem

After a [BatchGetItem](https://docs.aws.amazon.com/amazondynamodb/latest/APIReference/API_BatchGetItem.html)
call is made to DynamoDB :

For each list item under each key in `Responses`,
if there is a configured Item Encryptor with [DynamoDB Table Name](./ddb-item-encryptor.md#dynamodb-table-name) equal to the key,
that Item Encryptor MUST perform [Decrypt Item](./decrypt-item.md) where the input
[DynamoDB Item](./decrypt-item.md#dynamodb-item)
is the `Item` field in the original response.

Beacons MUST be [removed](ddb-support.md#removebeacons) from the result.

Each of these items on the original response MUST be replaced
with a value that is equivalent to
this result.

If any [Decrypt Item](./decrypt-item.md) operation fails,
BatchGetItem MUST yield an error.

### Decrypt after Scan

After a [Scan](https://docs.aws.amazon.com/amazondynamodb/latest/APIReference/API_Scan.html)
call is made to DynamoDB :

For each list entry in `Items` in the response,
if there exists an Item Encryptor specified within the
[DynamoDB Encryption Client Config](#dynamodb-encryption-client-configuration)
with a [DynamoDB Table Name](./ddb-item-encryptor.md#dynamodb-table-name)
equal to the `TableName` on the request,
the corresponding Item Encryptor MUST perform [Decrypt Item](./decrypt-item.md)
where the input [DynamoDB Item](./decrypt-item.md#dynamodb-item)
is this list entry.

Each of these entries on the original response MUST be replaced
with the resulting decrypted
[DynamoDB Item](./decrypt-item.md#dynamodb-item-1).

If any [Decrypt Item](./decrypt-item.md) operation fails,
Scan MUST yield an error.

The resulting decrypted response MUST be [filtered](ddb-support.md#scanoutputforbeacons) from the result.

### Decrypt after Query

After a [Query](https://docs.aws.amazon.com/amazondynamodb/latest/APIReference/API_Query.html)
call is made to DynamoDB :

For each list entry in `Items` in the response,
if there exists an Item Encryptor specified within the
[DynamoDB Encryption Client Config](#dynamodb-encryption-client-configuration)
with a [DynamoDB Table Name](./ddb-item-encryptor.md#dynamodb-table-name)
equal to the `TableName` on the request,
the corresponding Item Encryptor MUST perform [Decrypt Item](./decrypt-item.md)
where the input [DynamoDB Item](./decrypt-item.md#dynamodb-item)
is this list entry.

Each of these entries on the original response MUST be replaced
with the resulting decrypted [DynamoDB Item](./decrypt-item.md#dynamodb-item-1).

If any [Decrypt Item](./decrypt-item.md) fails,
Query MUST yield an error.

The resulting decrypted response MUST be [filtered](ddb-support.md#queryoutputforbeacons) from the result.

### Decrypt after TransactGetItems

After a [TransactGetItems](https://docs.aws.amazon.com/amazondynamodb/latest/APIReference/API_TransactGetItems.html)
call is made to DynamoDB :

For each list item under each key in `Responses`,
if there exists an Item Encryptor specified within
the [DynamoDB Encryption Client Config](#dynamodb-encryption-client-configuration)
with a [DynamoDB Table Name](./ddb-item-encryptor.md#dynamodb-table-name)
equal to the key,
the Item Encryptor that corresponds to the key in the request
MUST perform [Decrypt Item](./decrypt-item.md) where the input
[DynamoDB Item](./decrypt-item.md#dynamodb-item) is the `Item` in the original response.

Beacons MUST be [removed](ddb-support.md#removebeacons) from the result.

Each of these items on the original response MUST be replaced
with a value that is equivalent to the resulting item.

If any [Decrypt Item](./decrypt-item.md) fails,
TransactGetItems MUST yield an error.

### Validate Before UpdateItem

Before an [UpdateItem](https://docs.aws.amazon.com/amazondynamodb/latest/APIReference/API_UpdateItem.html)
call is made to DynamoDB,

If the `TableName` in the request does not refer to an [encrypted-table](#encrypted-table),
the UpdateItem request MUST be unchanged.

Otherwise,

The UpdateItem request MUST NOT refer to any legacy parameters,
specifically Expected, AttributeUpdates and ConditionalOperator MUST NOT be set.

The UpdateExpression MUST be [valid](ddb-support.md#testupdateexpression).

If all of the above validation succeeds, the UpdateItem request MUST be unchanged.

### Validate Before DeleteItem

Before a [DeleteItem](https://docs.aws.amazon.com/amazondynamodb/latest/APIReference/API_DeleteItem.html)
call is made to DynamoDB,

If the `TableName` in the request does not refer to an [encrypted-table](#encrypted-table),
the DeleteItem request MUST be unchanged.

Otherwise,

The DeleteItem request MUST NOT refer to any legacy parameters,
specifically Expected and ConditionalOperator MUST NOT be set.

The ConditionExpression MUST be [valid](ddb-support.md#testconditionexpression).

If all of the above validation succeeds, the DeleteItem request MUST be unchanged.

### Validate Before ExecuteStatement

Before an [ExecuteStatement](https://docs.aws.amazon.com/amazondynamodb/latest/APIReference/ExecuteStatement.html)
call is made to DynamoDB :

The request MUST fail, and the client make no network call to DynamoDB,
if there exists an Item Encryptor
specified within the [DynamoDB Encryption Client Config](#dynamodb-encryption-client-configuration)
with a [DynamoDB Table Name](./ddb-item-encryptor.md#dynamodb-table-name)
equal to table named in the request.

If no such Item Encryptor exists,
there MUST NOT be any modification
to the ExecuteStatement request.

### Validate Before BatchExecuteStatement

Before an [BatchExecuteStatement](https://docs.aws.amazon.com/amazondynamodb/latest/APIReference/BatchExecuteStatement.html)
call is made to DynamoDB :

The request MUST fail, and the client make no network call to DynamoDB,
if there exists an Item Encryptor
specified within the [DynamoDB Encryption Client Config](#dynamodb-encryption-client-configuration)
with a [DynamoDB Table Name](./ddb-item-encryptor.md#dynamodb-table-name)
equal to table named in any of the `Statements` of the request.

If no such Item Encryptor exists,
there MUST NOT be any modification
to the BatchExecuteStatement request.

### Validate Before ExecuteTransaction

Before an [ExecuteTransaction](https://docs.aws.amazon.com/amazondynamodb/latest/APIReference/BatchExecuteStatement.html)
call is made to DynamoDB :

The request MUST fail, and the client make no network call to DynamoDB,
if there exists an Item Encryptor
specified within the [DynamoDB Encryption Client Config](#dynamodb-encryption-client-configuration)
with a [DynamoDB Table Name](./ddb-item-encryptor.md#dynamodb-table-name)
equal to table named in any of the `TransactStatements` of the request.

If no such Item Encryptor exists,
there MUST NOT be any modification
to the ExecuteTransaction request.

### Modify before Scan

Before the [Scan](https://docs.aws.amazon.com/amazondynamodb/latest/APIReference/API_Scan.html)
call is made to DynamoDB :

If the `TableName` in the request does not refer to an [encrypted-table](#encrypted-table),
the Scan request MUST be unchanged.

Otherwise

The Scan request MUST NOT refer to any legacy parameters,
specifically AttributesToGet, ScanFilter and ConditionalOperator MUST NOT be set.

The request MUST be [altered](./ddb-support.md#scaninputforbeacons)
to transform any references to encrypted attributes into references to beacons.

### Modify before Query

Before the [Query](https://docs.aws.amazon.com/amazondynamodb/latest/APIReference/API_Query.html)
call is made to DynamoDB :

If the `TableName` in the request does not refer to an [encrypted-table](#encrypted-table),
the Query request MUST be unchanged.

Otherwise

The Query request MUST NOT refer to any legacy parameters,
specifically AttributesToGet, KeyConditions, QueryFilter and ConditionalOperator MUST NOT be set.

The request MUST be [altered](./ddb-support.md#queryinputforbeacons)
to transform any references to encrypted attributes into references to beacons.

## Allowed Passthrough DynamoDB APIs

- CreateBackup
- CreateGlobalTable
- CreateTable
- DeleteBackup
- DeleteTable
- DescribeBackup
- DescribeContinuousBackups
- DescribeContributorInsights
- DescribeEndpoints
- DescribeExport
- DescribeGlobalTable
- DescribeGlobalTableSettings
- DescribeImport
- DescribeKinesisStreamingDestination
- DescribeLimits
- DescribeTable
- DescribeTableReplicaAutoScaling
- DescribeTimeToLive
- DisableKinesisStreamingDestination
- EnableKinesisStreamingDestination
- ExportTableToPointInTime
- ImportTable
- ListBackups
- ListContributorInsights
- ListExports
- ListGlobalTables
- ListImports
- ListTables
- ListTagsOfResource
- RestoreTableFromBackup
- RestoreTableToPointInTime
- TagResource
- UntagResource
- UpdateContinuousBackups
- UpdateContributorInsights
- UpdateGlobalTable
- UpdateGlobalTableSettings
- UpdateTable
- UpdateTableReplicaAutoScaling
- UpdateTimeToLive
