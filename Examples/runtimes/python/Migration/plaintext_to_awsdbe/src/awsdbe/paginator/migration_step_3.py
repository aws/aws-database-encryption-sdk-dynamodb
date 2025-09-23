# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0

"""
Migration Step 3.

This is an example demonstrating how to update your configuration
to complete your migration from plaintext to encrypted DynamoDB.
In this step, the client will only read items that have been encrypted with
the AWS Database Encryption SDK for DynamoDB. This step assumes that you have
already completed steps 1 and 2, and have converted all plaintext data in
your table to encrypted data.

Running this example requires access to the DDB Table whose name
is provided in CLI arguments.
This table must be configured with the following
primary key configuration:
  - Partition key is named "partition_key" with type (S)
  - Sort key is named "sort_key" with type (N)
"""

from ..client.common import setup_awsdbe_client_without_plaintext_override


def migration_step_3_with_paginator(kms_key_id: str, ddb_table_name: str, sort_read_value: int = 3):
    """
    Migration Step 3: Using AWS Database Encryption SDK for DynamoDB without plaintext override.

    :param kms_key_id: The ARN of the KMS key to use for encryption
    :param ddb_table_name: The name of the DynamoDB table
    :param sort_read_value: The sort key value to read
    """
    # 1. Create an EncryptedClient without plaintext override.
    #    Without a plaintext override, both reads and writes will use the AWS Database Encryption SDK,
    #    meaning that we can only read items that have been encrypted and we will always encrypt items on write.
    encrypted_client = setup_awsdbe_client_without_plaintext_override(
        kms_key_id=kms_key_id, ddb_table_name=ddb_table_name
    )

    # 2. Put an example item into our DynamoDb table using the Encrypted Client.
    #    This item will be encrypted using the DB Encryption SDK, using the
    #    configuration to determine which attributes to encrypt and/or sign.
    item = {
        "partition_key": {"S": "PlaintextMigrationExample"},
        "sort_key": {"N": "3"},
        "attribute1": {"S": "encrypt and sign me!"},
        "attribute2": {"S": "sign me!"},
        ":attribute3": {"S": "ignore me!"},
    }

    put_item_request = {
        "TableName": ddb_table_name,
        "Item": item,
    }

    put_item_response = encrypted_client.put_item(**put_item_request)
    # Demonstrate that PutItem succeeded
    assert put_item_response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # 3. Get a paginator from the encrypted client
    encrypted_paginator = encrypted_client.get_paginator("query")

    # 4. Use the paginator to get items from the table
    #    If these are items written in plaintext (e.g. any items written
    #    during Step 0 or 1), then we will fail to process the items.
    #    If these are encrypted items (e.g. any items written during Step 2 or after),
    #    then they will be decrypted before being returned.
    items = []
    for page in encrypted_paginator.paginate(
        TableName=ddb_table_name,
        KeyConditionExpression="partition_key = :partition_key AND sort_key = :sort_key",
        ExpressionAttributeValues={
            ":partition_key": {"S": "PlaintextMigrationExample"},
            ":sort_key": {"N": str(sort_read_value)},
        },
    ):
        for item in page["Items"]:
            items.append(item)

    # 5. Demonstrate we get the expected items back
    assert len(items) == 1  # We should have only one item with above key condition
    item = next((i for i in items if i["sort_key"]["N"] == str(sort_read_value)), None)
    assert item is not None
    assert item["partition_key"]["S"] == "PlaintextMigrationExample"
    assert item["attribute1"]["S"] == "encrypt and sign me!"
    assert item["attribute2"]["S"] == "sign me!"
    assert item[":attribute3"]["S"] == "ignore me!"

    # Note: If we tried to query for items with sort_key = 1 or sort_key = 2 that were
    # written with the legacy format in previous migration steps and haven't been
    # re-encrypted, the operation would fail with a verification exception.
