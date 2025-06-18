# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0

"""
Migration Step 1.

This is an example demonstrating how to start using the
AWS Database Encryption SDK with a pre-existing table used with DynamoDB Encryption Client.
In this example, you configure a EncryptedPaginator to do the following:
  - Read items encrypted in the old format
  - Continue to encrypt items in the old format on write
  - Read items encrypted in the new format
While this step configures your paginator to be ready to start reading items encrypted,
we do not yet expect to be reading any items in the new format.
Before you move on to step 2, ensure that these changes have successfully been deployed
to all of your readers.

Running this example requires access to the DDB Table whose name
is provided in CLI arguments.
This table must be configured with the following
primary key configuration:
  - Partition key is named "partition_key" with type (S)
  - Sort key is named "sort_key" with type (N)
"""
from aws_dbesdk_dynamodb.structures.dynamodb import LegacyPolicy

from ..client.common import setup_awsdbe_client_with_legacy_override


def migration_step_1_with_paginator(kms_key_id: str, ddb_table_name: str, sort_read_value: int = 1):
    """
    Migration Step 1: Using the AWS Database Encryption SDK EncryptedPaginator with Legacy Override.

    :param kms_key_id: The ARN of the KMS key to use for encryption
    :param ddb_table_name: The name of the DynamoDB table
    """
    # 1. Create a EncryptedClient with legacy override.
    #    For Legacy Policy, use `FORCE_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT`.
    #    With this policy, you will continue to read and write items using the old format,
    #    but will be able to start reading new items in the new format as soon as they appear
    policy = LegacyPolicy.FORCE_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT
    encrypted_client = setup_awsdbe_client_with_legacy_override(
        kms_key_id=kms_key_id, ddb_table_name=ddb_table_name, policy=policy
    )

    # 2. Put an item in the old format since we are using a legacy override
    #    with FORCE_LEGACY_ENCRYPT_ALLOW_DECRYPT policy
    item_to_encrypt = {
        "partition_key": {"S": "PaginatorMigrationExampleForPython"},
        "sort_key": {"N": "1"},
        "attribute1": {"S": "encrypt and sign me!"},
        "attribute2": {"S": "sign me!"},
        ":attribute3": {"S": "ignore me!"},
    }

    put_item_request = {
        "TableName": ddb_table_name,
        "Item": item_to_encrypt,
    }

    put_item_response = encrypted_client.put_item(**put_item_request)
    # Demonstrate that PutItem succeeded
    assert put_item_response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # 3. Get the EncryptedPaginator from the EncryptedClient
    encrypted_paginator = encrypted_client.get_paginator("query")

    # 4. Use the EncryptedPaginator to paginate through the items in the table
    #    If the items were written in the old format (e.g. any item written
    #    during Step 0 or 1), then we will attempt to decrypt the item
    #    using the legacy behavior.
    #    If the items were written in the new format (e.g. any item written
    #    during Step 2 or after), then we will attempt to decrypt the item using
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
