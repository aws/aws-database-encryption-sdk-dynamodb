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
  - Sort key is named "sort_key" with type (S)
"""

from .common import setup_awsdbe_client_without_plaintext_override


def migration_step_3_with_client(kms_key_id: str, ddb_table_name: str, sort_read_value: int = 3):
    """
    Migration Step 3: Using only pure AWS Database Encryption SDK (no plaintext override) with EncryptedClient.

    :param kms_key_id: The ARN of the KMS key to use for encryption
    :param ddb_table_name: The name of the DynamoDB table
    :param sort_read_value: The sort key value to read
    """
    # 1. Create the EncryptedClient.
    #    Do not configure any plaintext override.
    encrypted_client = setup_awsdbe_client_without_plaintext_override(kms_key_id, ddb_table_name)

    # 2. Put an item into your table using the Encrypted Client.
    #    This item will be encrypted using the DB Encryption SDK, using the
    #    configuration to determine which attributes to encrypt and/or sign.
    item = {
        "partition_key": {"S": "PlaintextMigrationExample"},
        "sort_key": {"N": str(3)},
        "attribute1": {"S": "encrypt and sign me!"},
        "attribute2": {"S": "sign me!"},
        ":attribute3": {"S": "ignore me!"},
    }

    put_item_response = encrypted_client.put_item(TableName=ddb_table_name, Item=item)
    # Demonstrate that PutItem succeeded
    assert put_item_response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # 3. Get an item back from the table using the Encrypted Client.
    #    If this is an item written in plaintext (e.g. any item written
    #    during Step 0 or 1), then we will fail to process the item.
    #    If this is an encrypted item (e.g. any item written during Step 2 or after),
    #    then we will decrypt the item and return it.
    key_to_get = {"partition_key": {"S": "PlaintextMigrationExample"}, "sort_key": {"N": str(sort_read_value)}}

    get_item_request = {"TableName": ddb_table_name, "Key": key_to_get}
    get_item_response = encrypted_client.get_item(**get_item_request)

    # Demonstrate that GetItem succeeded and returned the decrypted item
    assert get_item_response["ResponseMetadata"]["HTTPStatusCode"] == 200
    decrypted_item = get_item_response["Item"]

    # Demonstrate we get the expected item back
    assert decrypted_item["partition_key"]["S"] == "PlaintextMigrationExample"
    assert decrypted_item["sort_key"]["N"] == str(sort_read_value)
    assert decrypted_item["attribute1"]["S"] == "encrypt and sign me!"
    assert decrypted_item["attribute2"]["S"] == "sign me!"
    assert decrypted_item[":attribute3"]["S"] == "ignore me!"
