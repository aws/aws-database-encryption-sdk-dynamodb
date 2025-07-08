# DyanmoDb Encryption Client to AWS Database Encryption SDK for DynamoDb Migration

This projects demonstrates the three Steps necessary to migration to the AWS Database Encryption SDK for DynamoDb
if you are currently using the DynamoDb Encryption Client.

[Step 0](./ddbec/README.md) demonstrates the starting state for your system.

## Step 1

In Step 1, you update your system to do the following:

- continue to read items in the old format
- continue to write items in the old format
- prepare to read items in the new format

When you deploy changes in Step 1, you should not expect any behavior change in your system,
and your dataset still consists of data written in the old format.

You must ensure that the changes in Step 1 make it to all your reads before you proceed to step 2.

## Step 2

In Step 2, you update your system to do the following:

- continue to read items in the old format
- start writing items in the new format
- continue to read items in the new format

When you deploy changes in Step 2, you are introducing a new encryption format to your system,
and must make sure that all your readers are updated with the changes from Step 1.

Before you move onto the next step, you will need to re-encrypt all old items in your dataset
to use the newest format. How you will want to do this, and how long you may want to remain in this Step,
depends on your system and your desired security properties for old and new items.

## Step 3

Once all old items are re-encrypted to use the new format,
you may update your system to do the following:

- continue to write items in the new format
- continue to read items in the new format
- do not accept reading items in the old format

Once you have deployed these changes to your system, you have completed migration.
