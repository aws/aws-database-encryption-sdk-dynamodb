# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0

"""
Migration Step 2.

This is an example demonstrating how to update your configuration
to start writing items using the AWS Database Encryption SDK for DynamoDB,
but still continue to read any items written in plaintext.

Once you deploy this change to your system, you will have a dataset
containing items in both plaintext and encrypted formats.
Because the changes in Step 1 have been deployed to all our readers,
we can be sure that our entire system is ready to read this new data.

Running this example requires access to the DDB Table whose name
is provided in CLI arguments.
This table must be configured with the following
primary key configuration:
  - Partition key is named "partition_key" with type (S)
  - Sort key is named "sort_key" with type (S)
"""

from aws_dbesdk_dynamodb.structures.dynamodb import PlaintextOverride

from .common import setup_awsdbe_client_with_plaintext_override


def migration_step_2_with_client(kms_key_id: str, ddb_table_name: str, sort_read_value: int = 2):
    """
    Migration Step 2: Using AWS Database Encryption SDK for DynamoDB with plaintext override.

    :param kms_key_id: The ARN of the KMS key to use for encryption
    :param ddb_table_name: The name of the DynamoDB table
    :param sort_read_value: The sort key value to read
    """
    # 1. Create an EncryptedClient with plaintext override.
    #    When configuring our plaintext override, use `FORBID_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ`.
    #    This plaintext override means:
    #     - Write: Items are forbidden to be written as plaintext.
    #              Items will be written as encrypted items.
    #     - Read: Items are allowed to be read as plaintext.
    #             Items are allowed to be read as encrypted items.
    policy = PlaintextOverride.FORBID_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ
    encrypted_client = setup_awsdbe_client_with_plaintext_override(
        kms_key_id=kms_key_id, ddb_table_name=ddb_table_name, policy=policy
    )

    # 2. Put an item into your table using the Encrypted Client.
    #    This item will be encrypted using the DB Encryption SDK, using the
    #    configuration to determine which attributes to encrypt and/or sign.
    item_to_encrypt = {
        "partition_key": {"S": "PlaintextMigrationExample"},
        "sort_key": {"N": str(2)},
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

    # Demonstrate that GetItem succeeded and returned the decrypted/plaintext item
    assert get_item_response["ResponseMetadata"]["HTTPStatusCode"] == 200
    returned_item = get_item_response["Item"]

    # Demonstrate we get the expected item back
    assert returned_item["partition_key"]["S"] == "PlaintextMigrationExample"
    assert returned_item["sort_key"]["N"] == str(sort_read_value)
    assert returned_item["attribute1"]["S"] == "encrypt and sign me!"
    assert returned_item["attribute2"]["S"] == "sign me!"
    assert returned_item[":attribute3"]["S"] == "ignore me!"
