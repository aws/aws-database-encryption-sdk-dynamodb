# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0

"""
Migration Step 3.

This is an example demonstrating how to update your configuration
to stop accepting reading items in plaintext format.

Once you complete Step 3, all items being read by your system are encrypted.

Before you move onto this step, you will need to encrypt all plaintext items in your dataset.
How you will want to do this depends on your system.

Running this example requires access to the DDB Table whose name
is provided in CLI arguments.
This table must be configured with the following
primary key configuration:
  - Partition key is named "partition_key" with type (S)
  - Sort key is named "sort_key" with type (N)
"""

from .common import setup_awsdbe_resource_without_plaintext_override


def migration_step_3_with_resource(kms_key_id: str, ddb_table_name: str, sort_read_value: int = 3):
    """
    Migration Step 3: Using only pure AWS Database Encryption SDK (no plaintext override) with EncryptedResource.

    :param kms_key_id: The ARN of the KMS key to use for encryption
    :param ddb_table_name: The name of the DynamoDB table
    :param sort_read_value: The sort key value to read
    """
    # 1. Create the EncryptedResource.
    #    Do not configure any plaintext override.
    encrypted_resource = setup_awsdbe_resource_without_plaintext_override(kms_key_id, ddb_table_name)

    # 2. Write a batch of items to the table using the Encrypted Resource.
    #    These items will be encrypted using the DB Encryption SDK, using the
    #    configuration to determine which attributes to encrypt and/or sign.
    items = [
        {
            "partition_key": "PlaintextMigrationExample-1",
            "sort_key": 3,
            "attribute1": "encrypt and sign me!",
            "attribute2": "sign me!",
            ":attribute3": "ignore me!",
        },
        {
            "partition_key": "PlaintextMigrationExample-2",
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

    # 3. Read the items back from the table using the Encrypted Resource.
    #    If these are items written in plaintext (e.g. any items written
    #    during Step 0 or 1), then we will fail to process the items.
    #    If these are encrypted items (e.g. any items written during Step 2 or after),
    #    then we will decrypt the items and return them.
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
