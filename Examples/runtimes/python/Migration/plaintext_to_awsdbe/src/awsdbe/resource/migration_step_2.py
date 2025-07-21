# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0

"""
Migration Step 2.

This is an example demonstrating how to update your configuration
to start writing items using the AWS Database Encryption SDK for DynamoDB,
but still continue to read any items written in plaintext.

Once you deploy this change to your system, you will have a dataset
containing items in both plaintext and encrypted formats.
Because the changes in Step 1 have been deployed to all our readers,
we can be sure that our entire system is ready to read this new data.

Running this example requires access to the DDB Table whose name
is provided in CLI arguments.
This table must be configured with the following
primary key configuration:
  - Partition key is named "partition_key" with type (S)
  - Sort key is named "sort_key" with type (N)
"""

from aws_dbesdk_dynamodb.structures.dynamodb import PlaintextOverride

from .common import setup_awsdbe_resource_with_plaintext_override


def migration_step_2_with_resource(kms_key_id: str, ddb_table_name: str, sort_read_value: int = 2):
    """
    Migration Step 2: Using AWS Database Encryption SDK for DynamoDB with plaintext override.

    :param kms_key_id: The ARN of the KMS key to use for encryption
    :param ddb_table_name: The name of the DynamoDB table
    :param sort_read_value: The sort key value to read
    """
    # 1. Create an EncryptedResource with plaintext override.
    #    When configuring our plaintext override, use `FORBID_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ`.
    #    This plaintext override means:
    #     - Write: Items are forbidden to be written as plaintext.
    #              Items will be written as encrypted items.
    #     - Read: Items are allowed to be read as plaintext.
    #             Items are allowed to be read as encrypted items.
    policy = PlaintextOverride.FORBID_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ
    encrypted_resource = setup_awsdbe_resource_with_plaintext_override(
        kms_key_id=kms_key_id, ddb_table_name=ddb_table_name, policy=policy
    )

    # 2. Write a batch of items to the table using the Encrypted Resource.
    #    These items will be encrypted using the DB Encryption SDK, using the
    #    configuration to determine which attributes to encrypt and/or sign.
    items = [
        {
            "partition_key": "PlaintextMigrationExample-1",
            "sort_key": 2,
            "attribute1": "encrypt and sign me!",
            "attribute2": "sign me!",
            ":attribute3": "ignore me!",
        },
        {
            "partition_key": "PlaintextMigrationExample-2",
            "sort_key": 2,
            "attribute1": "encrypt and sign me!",
            "attribute2": "sign me!",
            ":attribute3": "ignore me!",
        },
    ]

    batch_write_items_put_request = {
        "RequestItems": {
            ddb_table_name: [{"PutRequest": {"Item": item}} for item in items],
        },
    }

    batch_write_items_put_response = encrypted_resource.batch_write_item(**batch_write_items_put_request)

    # Demonstrate that BatchWriteItem succeeded
    assert batch_write_items_put_response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # 3. Read the items back from the table using the Encrypted Resource.
    #    If these are items written in plaintext (e.g. any items written
    #    during Step 0 or 1), then they will be returned as plaintext.
    #    If these are encrypted items (e.g. any items written during Step 2 or after),
    #    then they will be decrypted before being returned.
    batch_get_items_request = {
        "RequestItems": {
            ddb_table_name: {
                "Keys": [{"partition_key": item["partition_key"], "sort_key": sort_read_value} for item in items],
            }
        },
    }

    batch_get_items_response = encrypted_resource.batch_get_item(**batch_get_items_request)

    # Demonstrate that BatchGetItem succeeded with the expected result
    assert batch_get_items_response["ResponseMetadata"]["HTTPStatusCode"] == 200
    for item in batch_get_items_response["Responses"][ddb_table_name]:
        assert (
            item["partition_key"] == "PlaintextMigrationExample-1"
            or item["partition_key"] == "PlaintextMigrationExample-2"
        )
        assert item["sort_key"] == sort_read_value
        assert item["attribute1"] == "encrypt and sign me!"
        assert item["attribute2"] == "sign me!"
        assert item[":attribute3"] == "ignore me!"
