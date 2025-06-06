# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0

"""
Migration Step 3.

This is an example demonstrating the final state of migrating
from the DynamoDB Encryption Client to AWS Database Encryption SDK. At this point,
all your data has been re-encrypted with the new format, and you are ready to
stop using the legacy override feature entirely.

In this example, you'll do the following:
  - Use only the pure AWS DBESDK client for all operations
  - Verify that items that were originally encrypted with the legacy client can be read
    after they have been re-encrypted
  - Add new items with the pure client

Running this example requires access to the DDB Table whose name
is provided in CLI arguments.
This table must be configured with the following
primary key configuration:
  - Partition key is named "partition_key" with type (S)
  - Sort key is named "sort_key" with type (S)
"""

from .common import setup_pure_awsdbe_client


def migration_step_3(kms_key_id, ddb_table_name):
    """
    Migration Step 3: Using only pure AWS DBESDK (no legacy override).

    Args:
        kms_key_id: The ARN of the KMS key to use for encryption
        ddb_table_name: The name of the DynamoDB table

    """
    # 0. Create AWS SDK DynamoDB Client
    # ddb_client = boto3.client('dynamodb')

    # 1. Create only a pure AWS DBESDK client
    #    At this point, we no longer need the legacy override
    pure_client = setup_pure_awsdbe_client(kms_key_id, ddb_table_name)

    # 2. First, verify that all existing data can be read
    #    This includes items that were originally encrypted with the legacy client
    #    but have been re-encrypted in migration step 2
    keys = [
        {"partition_key": {"S": "MigrationExampleForPython"}, "sort_key": {"N": str(0)}},  # Originally from step 0
        {"partition_key": {"S": "MigrationExampleForPython"}, "sort_key": {"N": str(1)}},  # Originally from step 1
        {"partition_key": {"S": "MigrationExampleForPython"}, "sort_key": {"N": str(2)}},  # Originally from step 2
    ]

    for key in keys:
        sort_key_value = key["sort_key"]["N"]
        try:
            get_item_response = pure_client.get_item(TableName=ddb_table_name, Key=key)
            # Demonstrate that PutItem succeeded
            assert get_item_response["ResponseMetadata"]["HTTPStatusCode"] == 200
            # print(f"Put Item Response SHOULD have legacy attributes")
            # print(f"Put Item Response: {get_item_response['Item']}")
            decrypted_item = get_item_response["Item"]
            assert decrypted_item["attribute1"]["S"] == "encrypt and sign me!"
            print(f"Successfully read and decrypted item with sort_key={sort_key_value} using pure client")
        except Exception as e:
            print(f"Error reading item with sort_key={sort_key_value}: {type(e).__name__}")
            print("This indicates that not all items have been re-encrypted with the new format.")
            print("You should run migration step 2 again to re-encrypt all legacy items.")

    # 3. Add a new item with the pure client
    item = {
        "partition_key": {"S": "MigrationExampleForPython"},
        "sort_key": {"N": str(3)},
        "attribute1": {"S": "encrypt and sign me!"},
        "attribute2": {"S": "sign me!"},
        "attribute3": {"S": "ignore me!"},
    }

    pure_client.put_item(TableName=ddb_table_name, Item=item)
    print("Put item with sort_key=3 using pure AWS DBESDK client")

    # 4. Verify we can read the newly added item
    key_to_get_3 = {"partition_key": {"S": "MigrationExampleForPython"}, "sort_key": {"N": str(3)}}

    get_item_response_3 = pure_client.get_item(TableName=ddb_table_name, Key=key_to_get_3)

    # Demonstrate that PutItem succeeded
    assert get_item_response_3["ResponseMetadata"]["HTTPStatusCode"] == 200
    # print(f"Get Item Response: {get_item_response_3['Item']}")
    return pure_client


# def run_example():
#     """Run the final migration example."""

#     print("\n=== Migration Example Step 3: Complete Migration - Using Only AWS DBESK ===")

#     try:
#         # First ensure we have properly migrated data from step 2
#         # This will create items with keys 0, 1, and 2
#         migration_step2.migration_step2(
#             kms_key_id=common.KMS_KEY_ID,
#             ddb_table_name=common.TABLE_NAME
#         )

#         # Now run migration step 3 to demonstrate using only the pure client
#         migration_step3(
#             kms_key_id=common.KMS_KEY_ID,
#             ddb_table_name=common.TABLE_NAME
#         )

#         print("\nMigration Step 3 completed successfully!")
#         print("All data is now in the AWS DBESK format and can be accessed")
#         print("without the legacy override feature.")
#         print("\nMigration path summary:")
#         print("1. Started with legacy DynamoDB Encryption Client (Step 0)")
#         print("2. Deployed AWS DBESK with legacy override for backward compatibility (Step 1)")
#         print("3. Used pure AWS DBESK for new data while maintaining legacy read capability (Step 2)")
#         print("4. Re-encrypted all legacy data and removed legacy dependency (Step 3)")

#     except Exception as e:
#         print(f"Error in Migration Step 3: {e}")
#         raise
