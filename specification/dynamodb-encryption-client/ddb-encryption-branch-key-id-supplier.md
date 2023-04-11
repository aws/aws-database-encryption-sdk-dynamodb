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

This operation MUST take in a [DynamoDbKeyBranchKeyIdSupplier](#dynamodb-key-branch-key-id-supplier) as input.

### Output

This operation MUST output a string.
This string is the Branch Key Id that MUST be used by the hierarchical keyring for decryption of this item.

### Behavior

This operation MUST return an implementation of the `BranchKeyIdSupplier` that behaves in the following way on `GetBranchKeyId`:
- It MUST deserialize the "aws-crypto-partition_name" value in the input encryption context to determine the partition name.
  If this key does not exist in the encryption context, this operation MUST fail.
- It MUST get the serialized partition value by grabbing the `aws-crypto.attr:<partition_name>` from the encryption context.
  If this key does not exist in the encryption context, this operation MUST fail.
- It MUST check for the existence of "aws-crypto-sort-name" in the input encryption context.
  - If this key exists, it gets the serialized sort value by grabbing the `aws-crypto.attr:<sort_name>` from the encryption context.
    If this does not exist in the context, this operation MUST fail.
- If MUST [deserialize the partition (and optionally sort) value](./ddb-attribute-serialization.md), and create a KeySchema with these values.
- It passes this KeySchema to the supplied DynamoDbKeyBranchKeyIdSupplier via the `GetBranchKeyIdFromDdbKey` operation.
  - If successful, the resulting string MUST be outputted by this operation.
  - Otherwise, this operation MUST fail.

## DynamoDbKeyBranchKeyIdSupplier

The DynamoDb Key Branch Key Id Supplier is an interface containing the `GetBranchKeyIdFromDdbKey` operation.
This operation MUST take in a DDB `Key` structure (and attribute map containing the partition and sort attributes) as input,
and return a branch key id (string) as output.
