# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0

"""
Migration Step 0.

This is the pre-migration step for the plaintext-to-encrypted database migration,
and is the starting state for our migration from a plaintext database to a
client-side encrypted database encrypted using the AWS Database Encryption SDK for DynamoDB.

In this example, we use a standard DynamoDB client to write and read plaintext data.
This emulates the starting state of a plaintext-to-encrypted database migration;
i.e., a plaintext database you can read and write to with the standard DynamoDB client.

Running this example requires access to the DDB Table whose name
is provided in CLI arguments.
This table must be configured with the following
primary key configuration:
  - Partition key is named "partition_key" with type (S)
  - Sort key is named "sort_key" with type (S)
"""

import boto3


def migration_step_0_with_client(ddb_table_name: str, sort_read_value: int = 0):
    """
    Migration Step 0: Using a standard DynamoDB client with plaintext data.

    :param ddb_table_name: The name of the DynamoDB table
    :param sort_read_value: The sort key value to read
    """
    # 1. Create a standard AWS SDK DynamoDB client
    ddb_client = boto3.client("dynamodb")

    # 2. Put an example item into our DynamoDb table.
    #    This item will be stored in plaintext.
    item_to_put = {
        "partition_key": {"S": "PlaintextMigrationExample"},
        "sort_key": {"N": str(0)},
        "attribute1": {"S": "encrypt and sign me!"},
        "attribute2": {"S": "sign me!"},
        ":attribute3": {"S": "ignore me!"},
    }

    put_item_request = {
        "TableName": ddb_table_name,
        "Item": item_to_put,
    }

    put_item_response = ddb_client.put_item(**put_item_request)
    # Demonstrate that PutItem succeeded
    assert put_item_response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # 3. Get an item back from the table using the DynamoDB client.
    #    This item will be returned in plaintext, as it was stored.
    key_to_get = {"partition_key": {"S": "PlaintextMigrationExample"}, "sort_key": {"N": str(sort_read_value)}}

    get_item_request = {"TableName": ddb_table_name, "Key": key_to_get}
    get_item_response = ddb_client.get_item(**get_item_request)

    # Demonstrate that GetItem succeeded and returned the plaintext item
    assert get_item_response["ResponseMetadata"]["HTTPStatusCode"] == 200
    plaintext_item = get_item_response["Item"]

    # Demonstrate we get the expected item back
    assert plaintext_item["partition_key"]["S"] == "PlaintextMigrationExample"
    assert plaintext_item["sort_key"]["N"] == str(sort_read_value)
    assert "S" in plaintext_item["attribute1"] and plaintext_item["attribute1"]["S"] == "encrypt and sign me!"
    assert "S" in plaintext_item["attribute2"] and plaintext_item["attribute2"]["S"] == "sign me!"
    assert "S" in plaintext_item[":attribute3"] and plaintext_item[":attribute3"]["S"] == "ignore me!"
