[//]: # "Copyright Amazon.com Inc. or its affiliates. All Rights Reserved."
[//]: # "SPDX-License-Identifier: CC-BY-SA-4.0"

# DynamoDb Encryption Branch Key Supplier

## Overview

Customers currently do not have the ability to specify additional key value pairs to be introduced into the encryption context.
However, this creates a limitation when using the Hierarchical Keyring with BranchKeyIdSuppliers.
The intention is that this option allows customers to programmatically define what branch key should be used based on
information supplied at encrypt/decrypt time.
As part of normal operation, the DynamoDb Item Encryptor does put information regarding the partition and sort key into
the encryption context.
However it is serialized in a way that is difficult for customers to use.

In order to effectively use the Hierarchy Keyring's
[BranchKeyIdSupplier](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/aws-kms/aws-kms-hierarchical-keyring.md#branch-key-id-supplier) with the DynamoDbItem encryptor,
we provide a static operation that takes in a simplified interface for customers to implement,
and returns a BranchKeyIdSupplier that can be directly plugged into the Hierarchical Keyring configuration.

## Operation

The `CreateDynamoDbEncryptionBranchKeyIdSupplier` is an operation that MUST be vended alongside the DynamoDb Item Encryptor.

### Input

This operation MUST take in a [DynamoDbKeyBranchKeyIdSupplier](#dynamodbkeybranchkeyidsupplier) as input.

### Output

This operation MUST output a BranchKeyIdSupplierReference.

### Behavior

The returned implementation of `BranchKeyIdSupplier` behaves in the following way on `GetBranchKeyId`:

- It MUST deserialize the "aws-crypto-partition-name" value in the input encryption context to determine the partition name.
- If the partition name does not exist in the encryption context, this operation MUST fail.
- It MUST get the serialized partition value by grabbing the `aws-crypto-attr.<partition_name>` from the encryption context.
- If the partition value does not exist in the encryption context, this operation MUST fail.
- It MUST check for the existence of "aws-crypto-sort-name" in the input encryption context.
  - If this key exists, it MUST get the serialized sort value by grabbing the `aws-crypto.attr:<sort_name>` from the encryption context.
  - If the sort value does not exist in the context, this operation MUST fail.
- If the field "aws-crypto-legend" exists in the encryption context,
  it MUST [deserialize](./ddb-attribute-serialization.md), all values with keys beginning "aws-crypto-attr.",
  and create a Key with these values, using names with the "aws-crypto-attr." removed.
- If the field "aws-crypto-legend" does not exist in the encryption context, it MUST [deserialize the partition (and optionally sort) value](./ddb-attribute-serialization.md), and create a Key with these values.
- It passes this Key to the supplied DynamoDbKeyBranchKeyIdSupplier via the `GetBranchKeyIdFromDdbKey` operation.
  - If successful, the resulting string MUST be outputted by this operation.
  - Otherwise, this operation MUST fail.

## DynamoDbKeyBranchKeyIdSupplier

The DynamoDb Key Branch Key Id Supplier is an interface containing the `GetBranchKeyIdFromDdbKey` operation.
This operation MUST take in a DDB `Key` structure
(an attribute map containing the partition and sort attributes,
along with the values of any attributes configured as SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT)
as input.
This operation MUST return a branch key id (string) as output.
