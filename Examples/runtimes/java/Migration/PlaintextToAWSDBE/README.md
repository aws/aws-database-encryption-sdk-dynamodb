# DyanmoDb Encryption Client to AWS Database Encryption SDK for DynamoDb Migration

This projects demonstrates the steps necessary
to migrate to the AWS Database Encryption SDK for DynamoDb
from a plaintext database.

[Step 0](Desktop/workplace/aws-dynamodb-encryption-dafny/Examples/runtimes/java/Migration/PlaintextToAWSDBE/DDBEC/README.md) demonstrates the starting state for your system.

## Step 1

In Step 1, you update your system to do the following:
- continue to read plaintext items
- continue to write plaintext items
- prepare to read encrypted items

When you deploy changes in Step 1,
you should not expect any behavior change in your system,
and your dataset still consists of plaintext data.

You must ensure that the changes in Step 1 make it to all your readers before you proceed to Step 2.

## Step 2

In Step 2, you update your system to do the following:
- continue to read plaintext items
- start writing encrypted items
- continue to read encrypted items

When you deploy changes in Step 2,
you are introducing a new encryption format to your system,
and must make sure that all your readers are updated with the changes from Step 1.

## Step 3

Step 3 does not introduce any configuration updates.
It demonstrates one approach to encrypting all plaintext items
using the configuration from Step 2.

Before you move onto the next step, you will need to encrypt all plaintext items in your dataset.
How you will want to do this, and how long you may want to remain in the configuration in Step 2,
depends on your system and your desired security properties for plaintext and encrypted items.

## Step 4

Once all old items are encrypted,
you may update your system to do the following:
- continue to write encrypted items
- continue to read encrypted items
- do not accept reading plaintext items

Once you have deployed these changes to your system, you have completed migration.
