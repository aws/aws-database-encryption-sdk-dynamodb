# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0

"""
Migration Step 0.

This is the pre-migration step for the plaintext-to-encrypted database migration,
and is the starting state for our migration from a plaintext database to a
client-side encrypted database encrypted using the AWS Database Encryption SDK for DynamoDB.

In this example, we use a standard DynamoDB client paginator to work with plaintext data.
This emulates the starting state of a plaintext-to-encrypted database migration;
i.e., a plaintext database you can read and write to with the standard DynamoDB client and paginator.

Running this example requires access to the DDB Table whose name
is provided in CLI arguments.
This table must be configured with the following
primary key configuration:
  - Partition key is named "partition_key" with type (S)
  - Sort key is named "sort_key" with type (N)
"""

import boto3


def migration_step_0_with_paginator(ddb_table_name: str, sort_read_value: int = 0):
    """
    Migration Step 0: Using a standard DynamoDB client paginator with plaintext data.

    :param ddb_table_name: The name of the DynamoDB table
    :param sort_read_value: The sort key value to read
    """
    # 1. Create a standard AWS SDK DynamoDB client
    ddb_client = boto3.client("dynamodb")

    # 2. Put an example item into our DynamoDb table.
    #    This item will be stored in plaintext.
    item = {
        "partition_key": {"S": "PlaintextMigrationExample"},
        "sort_key": {"N": str(0)},
        "attribute1": {"S": "encrypt and sign me!"},
        "attribute2": {"S": "sign me!"},
        ":attribute3": {"S": "ignore me!"},
    }

    put_item_response = ddb_client.put_item(TableName=ddb_table_name, Item=item)
    # Demonstrate that PutItem succeeded
    assert put_item_response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # 3. Get a paginator from the client
    paginator = ddb_client.get_paginator("query")

    # 4. Use the paginator to get items from the table
    items = []
    for page in paginator.paginate(
        TableName=ddb_table_name,
        KeyConditionExpression="partition_key = :partition_key AND sort_key = :sort_key",
        ExpressionAttributeValues={
            ":partition_key": {"S": "PlaintextMigrationExample"},
            ":sort_key": {"N": str(sort_read_value)},
        },
    ):
        for item in page["Items"]:
            items.append(item)

    # 5. Demonstrate we get the expected items back.
    assert len(items) == 1  # We should have only one item with above key condition
    item = next((i for i in items if i["sort_key"]["N"] == str(sort_read_value)), None)
    assert item is not None
    assert item["partition_key"]["S"] == "PlaintextMigrationExample"
    assert "S" in item["attribute1"] and item["attribute1"]["S"] == "encrypt and sign me!"
    assert "S" in item["attribute2"] and item["attribute2"]["S"] == "sign me!"
    assert "S" in item[":attribute3"] and item[":attribute3"]["S"] == "ignore me!"
