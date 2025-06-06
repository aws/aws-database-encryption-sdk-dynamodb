# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0

"""
Migration Step 3.

This is an example demonstrating how to update your configuration
to stop accepting reading items encrypted using the old format.
In order to proceed with this step, you will need to re-encrypt all
old items in your table.

Once you complete Step 3, you can be sure that all items being read by your system
ensure the security properties configured for the new format.

Running this example requires access to the DDB Table whose name
is provided in CLI arguments.
This table must be configured with the following
primary key configuration:
  - Partition key is named "partition_key" with type (S)
  - Sort key is named "sort_key" with type (N)
"""

from .common import setup_pure_awsdbe_resource


def migration_step_3_with_resource(kms_key_id: str, ddb_table_name: str, sort_read_value: int = 3):
    """
    Migration Step 3: Using only pure AWS DBESDK (no legacy override) with EncryptedResource.

    :param kms_key_id: The ARN of the KMS key to use for encryption
    :param ddb_table_name: The name of the DynamoDB table
    :param sort_read_value: The sort key value to read
    """
    # 1. Create the EncryptedResource.
    #    Do not configure any legacy behavior.
    encrypted_resource = setup_pure_awsdbe_resource(kms_key_id, ddb_table_name)

    # 2. Write a batch of items to the table.
    #    These items will be encrypted in the latest format, using the
    #    configuration from your modelled class to decide
    #    which attribute to encrypt and/or sign.
    items = [
        {
            "partition_key": "PythonEncryptedResourceMigrationExample-1",
            "sort_key": 3,
            "attribute1": "encrypt and sign me!",
            "attribute2": "sign me!",
            ":attribute3": "ignore me!",
        },
        {
            "partition_key": "PythonEncryptedResourceMigrationExample-2",
            "sort_key": 3,
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

    # 3. Read the items back from the table.
    #    If this is an item written in the old format (e.g. any item written
    #    during Step 0 or 1), then we fail to return the item.
    #    If this is an item written in the new format (e.g. any item written
    #    during Step 2 or after), then we will attempt to decrypt the item using
    #    the non-legacy behavior.
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
            item["partition_key"] == "PythonEncryptedResourceMigrationExample-1"
            or item["partition_key"] == "PythonEncryptedResourceMigrationExample-2"
        )
        assert item["sort_key"] == sort_read_value
        assert item["attribute1"] == "encrypt and sign me!"
        assert item["attribute2"] == "sign me!"
        assert item[":attribute3"] == "ignore me!"
