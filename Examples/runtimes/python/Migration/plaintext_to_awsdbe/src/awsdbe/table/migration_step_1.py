# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0

"""
Migration Step 1.

This is an example demonstrating how to start using the
AWS Database Encryption SDK with a pre-existing table with plaintext items.
In this example, we configure an EncryptedTable to do the following:
  - Write items only in plaintext
  - Read items in plaintext or, if the item is encrypted, decrypt with our encryption configuration

While this step configures your table to be ready to start reading encrypted items,
we do not yet expect to be reading any encrypted items,
as our table still writes plaintext items.
Before you move on to step 2, ensure that these changes have successfully been deployed
to all of your readers.

Running this example requires access to the DDB Table whose name
is provided in CLI arguments.
This table must be configured with the following
primary key configuration:
  - Partition key is named "partition_key" with type (S)
  - Sort key is named "sort_key" with type (N)
"""
from aws_dbesdk_dynamodb.structures.dynamodb import PlaintextOverride

from .common import setup_awsdbe_table_with_plaintext_override


def migration_step_1_with_table(kms_key_id: str, ddb_table_name: str, sort_read_value: int = 1):
    """
    Migration Step 1: Using the AWS Database Encryption SDK with Plaintext Override.

    :param kms_key_id: The ARN of the KMS key to use for encryption
    :param ddb_table_name: The name of the DynamoDB table
    :param sort_read_value: The sort key value to read
    """
    # 1. Create an EncryptedTable with plaintext override.
    #    For Plaintext Override, use `FORCE_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ`.
    #    This plaintext override means:
    #     - Write: Items are forced to be written as plaintext.
    #              Items may not be written as encrypted items.
    #     - Read: Items are allowed to be read as plaintext.
    #             Items are allowed to be read as encrypted items.
    policy = PlaintextOverride.FORCE_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ
    encrypted_table = setup_awsdbe_table_with_plaintext_override(
        kms_key_id=kms_key_id, ddb_table_name=ddb_table_name, policy=policy
    )

    # 2. Put an item into your table using the Encrypted Table.
    #    This item will be stored in plaintext since we are using a plaintext override
    #    with FORCE_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ policy
    item_to_encrypt = {
        "partition_key": "PlaintextMigrationExample",
        "sort_key": 1,
        "attribute1": "encrypt and sign me!",
        "attribute2": "sign me!",
        ":attribute3": "ignore me!",
    }

    put_item_response = encrypted_table.put_item(Item=item_to_encrypt)
    # Demonstrate that PutItem succeeded
    assert put_item_response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # 3. Get an item back from the table using the Encrypted Table.
    #    If this is an item written in plaintext (e.g. any item written
    #    during Step 0 or 1), then it will be returned as plaintext.
    #    If this is an encrypted item (e.g. any item written during Step 2 or after),
    #    then it will be decrypted before being returned.
    key_to_get = {"partition_key": "PlaintextMigrationExample", "sort_key": sort_read_value}
    get_item_response = encrypted_table.get_item(Key=key_to_get)

    # Demonstrate that GetItem succeeded and returned the decrypted item
    assert get_item_response["ResponseMetadata"]["HTTPStatusCode"] == 200
    returned_item = get_item_response["Item"]

    # Demonstrate we get the expected item back
    assert returned_item["partition_key"] == "PlaintextMigrationExample"
    assert returned_item["sort_key"] == sort_read_value
    assert returned_item["attribute1"] == "encrypt and sign me!"
    assert returned_item["attribute2"] == "sign me!"
    assert returned_item[":attribute3"] == "ignore me!"
