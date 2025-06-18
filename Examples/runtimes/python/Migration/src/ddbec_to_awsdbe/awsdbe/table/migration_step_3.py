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
  - Sort key is named "sort_key" with type (S)
"""

from .common import setup_pure_awsdbe_table


def migration_step_3_with_table(kms_key_id: str, ddb_table_name: str, sort_read_value: int = 3):
    """
    Migration Step 3: Using only pure AWS DBESDK (no legacy override).

    :param kms_key_id: The ARN of the KMS key to use for encryption
    :param ddb_table_name: The name of the DynamoDB table
    :param sort_read_value: The sort key value to read
    """
    # 1. Create the EncryptedTable
    #    Do not configure any legacy behavior.
    encrypted_table = setup_pure_awsdbe_table(kms_key_id, ddb_table_name)

    # 2. Put an item into your table using the EncryptedTable.
    #    This item will be encrypted in the latest format, using the
    #    configuration from your modelled class to decide
    #    which attribute to encrypt and/or sign.
    item_to_encrypt = {
        "partition_key": "MigrationExampleForPythonTable",
        "sort_key": 3,
        "attribute1": "encrypt and sign me!",
        "attribute2": "sign me!",
        ":attribute3": "ignore me!",
    }

    put_item_response = encrypted_table.put_item(Item=item_to_encrypt)

    # Demonstrate that PutItem succeeded
    assert put_item_response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # 3. Get an item back from the table using the EncryptedTable.
    #    If this is an item written in the old format (e.g. any item written
    #    during Step 0 or 1), then we fail to return the item.
    #    If this is an item written in the new format (e.g. any item written
    #    during Step 2 or after), then we will attempt to decrypt the item using
    #    the non-legacy behavior.
    key_to_get = {"partition_key": "MigrationExampleForPythonTable", "sort_key": sort_read_value}
    get_item_response = encrypted_table.get_item(Key=key_to_get)

    # Demonstrate that GetItem succeeded and returned the decrypted item
    assert get_item_response["ResponseMetadata"]["HTTPStatusCode"] == 200
    decrypted_item = get_item_response["Item"]
    # Demonstrate we get the expected item back
    assert decrypted_item["partition_key"] == "MigrationExampleForPythonTable"
    assert decrypted_item["sort_key"] == sort_read_value
    assert decrypted_item["attribute1"] == "encrypt and sign me!"
    assert decrypted_item["attribute2"] == "sign me!"
    assert decrypted_item[":attribute3"] == "ignore me!"
