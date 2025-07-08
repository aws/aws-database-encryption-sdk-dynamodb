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

from ..client.common import setup_pure_awsdbe_client


def migration_step_3_with_paginator(kms_key_id: str, ddb_table_name: str, sort_read_value: int = 3):
    """
    Migration Step 3: Using only pure AWS DBESDK (no legacy override) with EncryptedPaginator.

    :param kms_key_id: The ARN of the KMS key to use for encryption
    :param ddb_table_name: The name of the DynamoDB table
    """
    # 1. Create the EncryptedClient.
    #    Do not configure any legacy behavior.
    encrypted_client = setup_pure_awsdbe_client(kms_key_id, ddb_table_name)

    # 2. Put an item into your table using the Client.
    #    This item will be encrypted in the latest format, using the
    #    configuration from your modelled class to decide
    #    which attribute to encrypt and/or sign.
    item = {
        "partition_key": {"S": "PaginatorMigrationExampleForPython"},
        "sort_key": {"N": "3"},
        "attribute1": {"S": "encrypt and sign me!"},
        "attribute2": {"S": "sign me!"},
        ":attribute3": {"S": "ignore me!"},
    }

    put_item_response = encrypted_client.put_item(TableName=ddb_table_name, Item=item)
    # Demonstrate that PutItem succeeded
    assert put_item_response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # 3. Get the EncryptedPaginator from the EncryptedClient
    encrypted_paginator = encrypted_client.get_paginator("query")

    # 4. Use the EncryptedPaginator to paginate through the items in the table
    #    If the items were written in the old format (e.g. any item written
    #    during Step 0 or 1), then we will fail to decrypt those items.
    #    If the items were written in the new format (e.g. any item written
    #    during Step 2 or 3), then we will attempt to decrypt the item using
    #    the non-legacy behavior.
    items = []
    for page in encrypted_paginator.paginate(
        TableName=ddb_table_name,
        KeyConditionExpression="partition_key = :partition_key AND sort_key = :sort_key",
        ExpressionAttributeValues={
            ":partition_key": {"S": "PaginatorMigrationExampleForPython"},
            ":sort_key": {"N": str(sort_read_value)},
        },
    ):
        for item in page["Items"]:
            items.append(item)

    # 5. Verify the decrypted items
    assert len(items) == 1  # We should have only one item with above key condition
    item = next((i for i in items if i["sort_key"]["N"] == str(sort_read_value)), None)
    assert item is not None
    assert item["partition_key"]["S"] == "PaginatorMigrationExampleForPython"
    assert item["attribute1"]["S"] == "encrypt and sign me!"
    assert item["attribute2"]["S"] == "sign me!"
    assert item[":attribute3"]["S"] == "ignore me!"

    # Note: If we tried to query for items with sort_key = 1 or sort_key = 2 that were
    # written with the legacy format in previous migration steps and haven't been
    # re-encrypted, the operation would fail with a verification exception.
