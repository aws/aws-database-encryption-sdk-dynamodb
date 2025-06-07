# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0

"""
Migration Step 2.

This is an example demonstrating the next step in migrating from
the DynamoDB Encryption Client to AWS Database Encryption SDK. In this step, we configure
and use a pure AWS Database Encryption SDK client alongside a client configured with
legacy override.

In this example, you'll do the following:
  - Create a pure AWS DBESDK client that can only read items encrypted with AWS DBESDK
  - Create an AWS DBESDK client with legacy override that can read legacy items
  - Use the pure client to encrypt new items
  - Use the client with legacy override to read both legacy and new items
  - Re-encrypt legacy items with the pure AWS DBESDK client

Running this example requires access to the DDB Table whose name
is provided in CLI arguments.
This table must be configured with the following
primary key configuration:
  - Partition key is named "partition_key" with type (S)
  - Sort key is named "sort_key" with type (S)
"""

import boto3

# Import from new AWS Database Encryption SDK
from . import migration_step_1
from .common import setup_pure_awsdbe_client, setup_awsdbe_client_with_legacy_override


def migration_step_2(kms_key_id, ddb_table_name):
    """
    Migration Step 2: Using pure AWS DBESDK and legacy override together.

    Args:
        kms_key_id: The ARN of the KMS key to use for encryption
        ddb_table_name: The name of the DynamoDB table

    """
    ddb_client = boto3.client("dynamodb")

    # 1. Create two AWS DBESDK clients:
    #    - A pure client that can only read items encrypted with AWS DBESDK
    #    - A client with legacy override that can read legacy items
    pure_client = setup_pure_awsdbe_client(kms_key_id, ddb_table_name)
    legacy_override_client = setup_awsdbe_client_with_legacy_override(kms_key_id, ddb_table_name)

    # 2. Write a new item using the pure client (it will use the new encryption format)
    item = {
        "partition_key": {"S": "MigrationExampleForPython"},
        "sort_key": {"N": str(2)},
        "attribute1": {"S": "encrypt and sign me!"},
        "attribute2": {"S": "sign me!"},
        "attribute3": {"S": "ignore me!"},
    }

    encrypted_item = pure_client.EncryptItem(item)
    ddb_client.put_item(TableName=ddb_table_name, Item=encrypted_item)
    print("Put item with sort_key=2 using pure AWS DBESDK client")

    # 3. Attempt to read a legacy-encrypted item (sort_key=0) with the pure client
    #    This should fail as the pure client doesn't understand the legacy format
    key = {"partition_key": {"S": "MigrationExampleForPython"}, "sort_key": {"N": str(0)}}

    response = ddb_client.get_item(TableName=ddb_table_name, Key=key)

    if "Item" in response:
        legacy_item = response["Item"]
        try:
            pure_client.DecryptItem(legacy_item)
            print("Unexpectedly succeeded in decrypting legacy item with pure client!")
        except Exception as e:
            print(f"Expected failure: Pure client can't decrypt legacy item: {type(e).__name__}")

    # 4. Read the same legacy item using the client with legacy override
    #    This should succeed as this client understands both legacy and new formats
    if "Item" in response:
        legacy_item = response["Item"]
        legacy_override_client.DecryptItem(legacy_item)
        print("Successfully decrypted legacy item (sort_key=0) using client with legacy override")

    # 5. Read the new item (sort_key=2) with both clients
    #    Both should be able to read the new format
    key = {"partition_key": {"S": "MigrationExampleForPython"}, "sort_key": {"N": str(2)}}

    response = ddb_client.get_item(TableName=ddb_table_name, Key=key)

    if "Item" in response:
        new_item = response["Item"]
        pure_client.DecryptItem(new_item)
        print("Successfully decrypted new item (sort_key=2) using pure client")

        legacy_override_client.DecryptItem(new_item)
        print("Successfully decrypted new item (sort_key=2) using client with legacy override")

    # 6. Re-encrypt a legacy item with the new format
    #    This is how you migrate your data from the legacy format to the new format
    key = {"partition_key": {"S": "MigrationExampleForPython"}, "sort_key": {"N": str(0)}}

    response = ddb_client.get_item(TableName=ddb_table_name, Key=key)

    if "Item" in response:
        # Get the legacy encrypted item
        legacy_item = response["Item"]

        # Decrypt it with the client that has legacy override
        decrypted_item = legacy_override_client.DecryptItem(legacy_item)
        print("Successfully decrypted legacy item for re-encryption")

        # Re-encrypt with the pure client (new format)
        new_encrypted_item = pure_client.EncryptItem(decrypted_item)
        print("Successfully re-encrypted item in new format")

        # Store the re-encrypted item back in DynamoDB
        ddb_client.put_item(TableName=ddb_table_name, Item=new_encrypted_item)
        print("Successfully stored re-encrypted item")

        # Verify we can now read it with the pure client
        verify_response = ddb_client.get_item(TableName=ddb_table_name, Key=key)

        if "Item" in verify_response:
            re_encrypted_item = verify_response["Item"]
            pure_client.DecryptItem(re_encrypted_item)
            print("Successfully verified re-encrypted item can be read with pure client")


# def run_example():
#     """Run the full migration example."""

#     print("\n=== Migration Example Step 2: Using Pure AWS DBESDK and Legacy Override Together ===")

#     try:
#         # Ensure we have items from previous steps
#         # First run migration step 0 to have legacy items
#         migration_step0.migration_step0(
#             kms_key_id=common.KMS_KEY_ID,
#             ddb_table_name=common.TABLE_NAME
#         )

#         # Now run migration step 2
#         migration_step2(
#             kms_key_id=common.KMS_KEY_ID,
#             ddb_table_name=common.TABLE_NAME
#         )

#         print("\nMigration Step 2 completed successfully!")
#         print("This demonstrates how to use both clients side-by-side and")
#         print("how to re-encrypt legacy data to the new format.")

#     except Exception as e:
#         print(f"Error in Migration Step 2: {e}")
#         raise
