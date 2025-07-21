# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0

"""
Migration Step 0.

This is the pre-migration step for the plaintext-to-encrypted database migration,
and is the starting state for our migration from a plaintext database to a
client-side encrypted database encrypted using the AWS Database Encryption SDK for DynamoDB.

In this example, we use a standard DynamoDB resource to write and read plaintext data.
This emulates the starting state of a plaintext-to-encrypted database migration;
i.e., a plaintext database you can read and write to with the standard DynamoDB resource.

Running this example requires access to the DDB Table whose name
is provided in CLI arguments.
This table must be configured with the following
primary key configuration:
  - Partition key is named "partition_key" with type (S)
  - Sort key is named "sort_key" with type (N)
"""

import boto3


def migration_step_0_with_resource(ddb_table_name: str, sort_read_value: int = 0):
    """
    Migration Step 0: Using a standard DynamoDB resource with plaintext data.

    :param ddb_table_name: The name of the DynamoDB table
    :param sort_read_value: The sort key value to read
    """
    # 1. Create a standard AWS SDK DynamoDB resource
    ddb_resource = boto3.resource("dynamodb")

    # 2. Write a batch of items to the table.
    #    These items will be stored in plaintext.
    items = [
        {
            "partition_key": "PlaintextMigrationExample-1",
            "sort_key": 0,
            "attribute1": "encrypt and sign me!",
            "attribute2": "sign me!",
            ":attribute3": "ignore me!",
        },
        {
            "partition_key": "PlaintextMigrationExample-2",
            "sort_key": 0,
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

    batch_write_items_put_response = ddb_resource.batch_write_item(**batch_write_items_put_request)

    # Demonstrate that BatchWriteItem succeeded
    assert batch_write_items_put_response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # 3. Read the items back from the table.
    #    The items will be returned in plaintext, as they were stored.
    batch_get_items_request = {
        "RequestItems": {
            ddb_table_name: {
                "Keys": [{"partition_key": item["partition_key"], "sort_key": sort_read_value} for item in items],
            }
        },
    }

    batch_get_items_response = ddb_resource.batch_get_item(**batch_get_items_request)

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
