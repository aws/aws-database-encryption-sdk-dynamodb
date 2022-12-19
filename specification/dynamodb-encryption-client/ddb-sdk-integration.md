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

- [Encryptors](#encryptors)

### Encryptors

Encryptors MUST be a list of [DynamoDB Item Encryptors](./ddb-item-encryptor.md),
where each DynamoDB Item Encryptor contains the desired encryption configuration for unique DynamoDB Tables.
There MUST NOT be two Item Encryptors in this list with the same
[DynamoDB Table Name](./ddb-item-encryptor.md#dynamodb-table-name).

## DynamoDB Encryption Client

The DynamoDB Encryption Client is an AWS SDK client for DynamoDB,
such that client-side encryption and decryption happens transparently during
AWS SDK API calls to DynamoDB.

DynamoDB API calls
MUST have the following modified behavior:

- [Encrypt before PutItem](#encrypt-before-putitem)
- [Encrypt before BatchWriteItem](#encrypt-before-batchwriteitem)
- [Encrypt before TransactWriteItems](#encrypt-before-TransactWriteItems)
- [Decrypt after GetItem](#decrypt-after-getitem)
- [Decrypt after BatchGetItem](#decrypt-after-batchgetitem)
- [Decrypt after Scan](#decrypt-after-scan)
- [Decrypt after Query](#decrypt-after-query)
- [Decrypt after TransactGetItem](#decrypt-after-transactgetitem)
- [Validate before UpdateItem](#validate-before-updateitem)
- [Validate before DeleteItem](#validate-before-deleteitem)

The [Allowed Passthrough DynmanoDB APIs](#allowed-passthrough-dynamodb-apis)
MUST NOT be modified.

Any DynamoDB API not specified is this document either
MUST NOT be callable or MUST yield an error,
and that error SHOULD indicate that the operation
is not supported with DynamoDB client-side encryption.

### Encrypt before PutItem

Before the [PutItem](https://docs.aws.amazon.com/amazondynamodb/latest/APIReference/API_PutItem.html)
call is made to DynamoDB :

If there exists an Item Encryptor specified within the
[DynamoDB Encryption Client Config](#dynamodb-encryption-client-configuration)
with a [DynamoDB Table Name](./ddb-item-encryptor.md#dynamodb-table-name)
equal to `TableName` in the request,
this PutItem request MUST NOT contain a `ConditionExpression`.

TODO: Is there any additional validation we can bring into P0 scope which would allow some condition checks?

If the above validation fails,
the client MUST NOT make a network call to DynamoDB,
and PutItem MUST yield an error.

If the request is validated,
it MUST be modified before a network call is made to DynamoDB
if there exists an Item Encryptor specified within the
[DynamoDB Encryption Client Config](#dynamodb-encryption-client-configuration)
with a [DynamoDB Table Name](./ddb-item-encryptor.md#dynamodb-table-name)
equal to `TableName` in the request.

This [Item Encryptor](./ddb-item-encryptor.md) MUST perform
[Encrypt Item](./encrypt-item.md),
where the input [DynamoDB Item](./encrypt-item.md#dynamodb-item)
is the `Item` field in the original request.

The PutItem request's `Item` field MUST be replaced
with a value that is equivalent to
the result [Encrypted DynamoDB Item](./encrypt-item.md#encrypted-dynamodb-item)
calculated above.

### Encrypt before BatchWriteItem

Before the [BatchWriteItem](https://docs.aws.amazon.com/amazondynamodb/latest/APIReference/API_BatchWriteItem.html)
call is made to DynamoDB :

For each `PutRequest` under each key in `RequestItems`,
if there is an Item Encryptor with [DynamoDB Table Name](./ddb-item-encryptor.md#dynamodb-table-name) equal to the key,
that Item Encryptor MUST perform [Encrypt Item](./encrypt-item.md) where the input
[DynamoDB Item](./encrypt-item.md#dynamodb-item) is the `Item` field in this `PutRequest`

The `Item` field in this `PutRequest` MUST be replaced
with a value that is equivalent to
the result [Encrypted DynamoDB Item](./encrypt-item.md#encrypted-dynamodb-item).

If any [Encrypt Item](./encrypt-item.md) fails,
the client MUST NOT make a network call to DynamoDB,
and BatchWriteItem MUST yield an error.

### Encrypt before TransactWriteItems

Before the [TransactWriteItems](https://docs.aws.amazon.com/amazondynamodb/latest/APIReference/API_TransactWriteItems.html)
call is made to DynamoDB, for every entry under `TransactItems`:


- The client MUST fail if in the `Update` field has a `TableName` which matches
  the [DynamoDB Table Name](./ddb-item-encryptor.md#dynamodb-table-name)
  of any Item Encryptor specified within the
  [DynamoDB Encryption Client Config](#dynamodb-encryption-client-configuration)

- The client MUST fail if in the `ConditionCheck` field has a `TableName` which matches
  the [DynamoDB Table Name](./ddb-item-encryptor.md#dynamodb-table-name)
  of any Item Encryptor specified within the
  [DynamoDB Encryption Client Config](#dynamodb-encryption-client-configuration)

- The client MUST fail if in the `Delete` field has a `TableName` which matches
  the [DynamoDB Table Name](./ddb-item-encryptor.md#dynamodb-table-name)
  of any Item Encryptor specified within the
  [DynamoDB Encryption Client Config](#dynamodb-encryption-client-configuration)
  and also has a `ConditionExpression`

- The client MUST fail if in the `Put` field has a `TableName` which matches
  the [DynamoDB Table Name](./ddb-item-encryptor.md#dynamodb-table-name)
  of any Item Encryptor specified within the
  [DynamoDB Encryption Client Config](#dynamodb-encryption-client-configuration)
  and also has a `ConditionExpression`

TODO: Is there any additional validation we can bring into P0 scope which would allow some condition checks?

If the request is valid, for each `Put` in `TransactItems` in the request,
if a corresponding Item Encryptor exists,
it MUST perform [Encrypt Item](./encrypt-item.md) where the input
[DynamoDB Item](./encrypt-item.md#dynamodb-item) is
the `Item` field in this `Put`

The `Item` field in this `Put` MUST be replaced
with a value that is equivalent to
the resulting [Encrypted DynamoDB Item](./encrypt-item.md#encrypted-dynamodb-item).

If any of the above validation fails, or any [Encrypt Item](./encrypt-item.md) fails,
the client MUST NOT make a network call to DynamoDB and
TransactWriteItems MUST yield an error.

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

The GetItem request's `Item` field MUST be replaced
with a value that is equivalent to
the resulting decrypted [DynamoDB Item](./decrypt-item.md#dynamodb-item-1).

TODO: Should we strip the header and footer? (and other genreated fields, such as beacons)

### Decrypt after BatchGetItem

After a [BatchGetItem](https://docs.aws.amazon.com/amazondynamodb/latest/APIReference/API_BatchGetItem.html)
call is made to DynamoDB :

For each list item under each key in `Responses`,
if there is a configured Item Encryptor with  [DynamoDB Table Name](./ddb-item-encryptor.md#dynamodb-table-name) equal to the key,
that Item Encryptor MUST perform [Decrypt Item](./decrypt-item.md) where the input
[DynamoDB Item](./decrypt-item.md#dynamodb-item)
is the `Item` field in the original response.

Each of these items on the original repsonse MUST be replaced
with a value that is equivalent to
the resulting decrypted [DynamoDB Item](./decrypt-item.md#dynamodb-item-1).

If any [Decrypt Item](./decrypt-item.md) operation fails,
BatchGetItem MUST yield an error.

TODO: Is there a way to make use of `UnprocessedKeys` to return a partial result?

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

Each of these entries on the original repsonse MUST be replaced
with the resulting decrypted
[DynamoDB Item](./decrypt-item.md#dynamodb-item-1).

If any [Decrypt Item](./decrypt-item.md) operation fails,
the client MUST NOT make a network call to DynamoDB
and Scan MUST yield an error.

TODO: Is there a way we can return a partial result?

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

Each of these entries on the original repsonse MUST be replaced
with the resulting decrypted [DynamoDB Item](./decrypt-item.md#dynamodb-item-1).

If any [Decrypt Item](./decrypt-item.md) fails,
the client MUST NOT make a network call to DynamoDB
and Query MUST yield an error.

TODO: Is there a way we can return a partial result?

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
[DynamoDB Item](./decrypt-item.md#dynamodb-item) is the `Item` in the original response

Each of these items on the original repsonse MUST be replaced
with a value that is equivalent to
the result [DynamoDB Item](./decrypt-item.md#dynamodb-item-1).

If any [Decrypt Item](./decrypt-item.md) fails,
the client MUST NOT make a network call to DynamoDB
and TransactGetItems MUST yield an error.

TODO: Is there a way to return a partial result?

### Validate Before UpdateItem

Before a [UpdateItem](https://docs.aws.amazon.com/amazondynamodb/latest/APIReference/API_UpdateItem.html)
call is made to DynamoDB,
the request MUST fail, and the client make no network call to DynamoDB,
if there exists an Item Encryptor
specified within the [DynamoDB Encryption Client Config](#dynamodb-encryption-client-configuration)
with a [DynamoDB Table Name](./ddb-item-encryptor.md#dynamodb-table-name)
equal to `TableName` in the request.

If no such Item Encryptor exists,
there MUST NOT be any modification
to the UpdateItem request.

TODO: Can we do further validation to allow safe updates on configured tables? We may be able to get this for free with the work being done for scan beacons.

### Validate Before DeleteItem

Before a [DeleteItem](https://docs.aws.amazon.com/amazondynamodb/latest/APIReference/API_DeleteItem.html)
call is made to DynamoDB,
the request MUST fail, and the client make no network call to DynamoDB,
if the request specifies a `ConditionExpression`,
and there exists an Item Encryptor specified
within the [DynamoDB Encryption Client Config](#dynamodb-encryption-client-configuration)
with a [DynamoDB Table Name](./ddb-item-encryptor.md#dynamodb-table-name)
equal to `TableName` in the request.

Otherwise, there MUST NOT be any modification
to the UpdateItem request.

TODO: Is there validation we can do on the ConditionCheck to allow for some checks on non-encrypted items?

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
