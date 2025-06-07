# Migration Examples: Legacy DynamoDB Encryption Client to AWS Database Encryption SDK

These examples demonstrate a complete migration path from the legacy AWS DynamoDB Encryption Client Python library to the new AWS Database Encryption SDK for DynamoDB.

## Overview

The migration process is demonstrated through a series of example steps that show how to gradually transition from the legacy client to the new SDK while maintaining compatibility with previously encrypted data.

## Migration Steps

### Step 0: Legacy DynamoDB Encryption Client

[migration_step0.py](./migration_step0.py) demonstrates using the legacy DynamoDB Encryption Client to encrypt and decrypt items. This represents the starting point for migration.

Key concepts:
- Setting up the legacy client with an AWS KMS cryptographic materials provider
- Defining attribute actions for encryption/signing
- Storing and retrieving encrypted items

### Step 1: AWS Database Encryption SDK with Legacy Override

[migration_step1.py](./migration_step1.py) demonstrates how to start using the AWS Database Encryption SDK with a pre-existing table used with the DynamoDB Encryption Client. 

Key concepts:
- Configure AWS DBESDK to read items encrypted in the legacy format
- Continue to encrypt items in the legacy format (FORCE_LEGACY_ENCRYPT_ALLOW_DECRYPT policy)
- Read items encrypted in the new format
- Deploy this step to all readers before moving to step 2

### Step 2: Full Migration to AWS Database Encryption SDK

[migration_step2.py](./migration_step2.py) demonstrates the next step in the migration process, using both the pure AWS DBESDK client and the legacy-override client side by side.

Key concepts:
- Create a pure AWS DBESDK client for new data
- Keep using legacy-override client when needed for legacy data
- Re-encrypt legacy data with the new client
- Demonstrate that the legacy-override client can read both formats

### Step 3: Complete Migration - Using Only AWS DBESDK

[migration_step3.py](./migration_step3.py) demonstrates the final state of the migration, where all data has been re-encrypted using the new format.

Key concepts:
- Use only the pure AWS DBESDK client (no more legacy override)
- Verify all previously re-encrypted data is readable
- Add new data using the pure client

### Run All Migration Steps

[run_all.py](./run_all.py) runs all four migration steps in sequence, demonstrating the entire migration path.

## How to Run

To run an individual step:

```bash
python -m Examples.runtimes.python.DynamoDBEncryption.src.migration.ddbec_to_awsdbe.migration_step0
python -m Examples.runtimes.python.DynamoDBEncryption.src.migration.ddbec_to_awsdbe.migration_step1
python -m Examples.runtimes.python.DynamoDBEncryption.src.migration.ddbec_to_awsdbe.migration_step2
python -m Examples.runtimes.python.DynamoDBEncryption.src.migration.ddbec_to_awsdbe.migration_step3
```

To run all steps in sequence:

```bash
python -m Examples.runtimes.python.DynamoDBEncryption.src.migration.ddbec_to_awsdbe.run_all
```

## Prerequisites

Before running these examples:

1. Replace `common.KMS_KEY_ID` with a valid AWS KMS key ID or alias
2. Ensure you have AWS credentials configured with permissions for:
   - DynamoDB (CreateTable, PutItem, GetItem, etc.)
   - KMS (GenerateDataKey, Decrypt)
3. Have both libraries installed:
   - Legacy library: `pip install dynamodb-encryption-sdk`
   - New SDK: `pip install aws-dbesdk-dynamodb`

## Important Notes

- These examples create a real DynamoDB table and perform actual AWS KMS operations, which may incur AWS charges
- By default, the examples leave the created table intact when they finish - uncomment the table deletion code in the example scripts if you want to clean up resources
- These examples are focused on demonstrating a migration path and are not production-ready code
