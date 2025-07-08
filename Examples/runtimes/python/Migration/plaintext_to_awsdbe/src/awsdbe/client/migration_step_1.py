# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0

"""
Migration Step 1.

This is an example demonstrating how to start using the
AWS Database Encryption SDK with a pre-existing table with plaintext items.
In this example, we configure an EncryptedClient to do the following:
  - Write items only in plaintext
  - Read items in plaintext or, if the item is encrypted, decrypt with our encryption configuration

While this step configures your client to be ready to start reading encrypted items,
we do not yet expect to be reading any encrypted items,
as our client still writes plaintext items.
Before you move on to step 2, ensure that these changes have successfully been deployed
to all of your readers.

Running this example requires access to the DDB Table whose name
is provided in CLI arguments.
This table must be configured with the following
primary key configuration:
  - Partition key is named "partition_key" with type (S)
  - Sort key is named "sort_key" with type (S)
"""
from aws_dbesdk_dynamodb.structures.dynamodb import PlaintextOverride

from .common import setup_awsdbe_client_with_plaintext_override


def migration_step_1_with_client(kms_key_id: str, ddb_table_name: str, sort_read_value: int = 1):
    """
    Migration Step 1: Using the AWS Database Encryption SDK with Plaintext Override.

    :param kms_key_id: The ARN of the KMS key to use for encryption
    :param ddb_table_name: The name of the DynamoDB table
    :param sort_read_value: The sort key value to read
    """
    # 1. Create an EncryptedClient with plaintext override.
    #    For Plaintext Override, use `FORCE_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ`.
    #    This plaintext override means:
    #     - Write: Items are forced to be written as plaintext.
    #              Items may not be written as encrypted items.
    #     - Read: Items are allowed to be read as plaintext.
    #             Items are allowed to be read as encrypted items.
    policy = PlaintextOverride.FORCE_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ
    encrypted_client = setup_awsdbe_client_with_plaintext_override(
        kms_key_id=kms_key_id, ddb_table_name=ddb_table_name, policy=policy
    )

    # 2. Put an item into your table using the Encrypted Client.
    #    This item will be stored in plaintext since we are using a plaintext override
    #    with FORCE_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ policy
    item_to_encrypt = {
        "partition_key": {"S": "PlaintextMigrationExample"},
        "sort_key": {"N": str(1)},
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

    # 3. Get an item back from the table using the Encrypted Client.
    #    If this is an item written in plaintext (e.g. any item written
    #    during Step 0 or 1), then it will be returned as plaintext.
    #    If this is an encrypted item (e.g. any item written during Step 2 or after),
    #    then it will be decrypted before being returned.
    key_to_get = {"partition_key": {"S": "PlaintextMigrationExample"}, "sort_key": {"N": str(sort_read_value)}}

    get_item_request = {"TableName": ddb_table_name, "Key": key_to_get}
    get_item_response = encrypted_client.get_item(**get_item_request)

    # Demonstrate that GetItem succeeded and returned the decrypted item
    assert get_item_response["ResponseMetadata"]["HTTPStatusCode"] == 200
    returned_item = get_item_response["Item"]

    # Demonstrate we get the expected item back
    assert returned_item["partition_key"]["S"] == "PlaintextMigrationExample"
    assert returned_item["sort_key"]["N"] == str(sort_read_value)
    assert returned_item["attribute1"]["S"] == "encrypt and sign me!"
    assert returned_item["attribute2"]["S"] == "sign me!"
    assert returned_item[":attribute3"]["S"] == "ignore me!"
