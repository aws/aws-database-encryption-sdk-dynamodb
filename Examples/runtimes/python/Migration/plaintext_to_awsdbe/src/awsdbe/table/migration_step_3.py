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
  - Sort key is named "sort_key" with type (N)
"""

from .common import setup_awsdbe_table_without_plaintext_override


def migration_step_3_with_table(kms_key_id: str, ddb_table_name: str, sort_read_value: int = 3):
    """
    Migration Step 3: Using only pure AWS Database Encryption SDK (no plaintext override) with EncryptedTable.

    :param kms_key_id: The ARN of the KMS key to use for encryption
    :param ddb_table_name: The name of the DynamoDB table
    :param sort_read_value: The sort key value to read
    """
    # 1. Create the EncryptedTable.
    #    Do not configure any plaintext override.
    encrypted_table = setup_awsdbe_table_without_plaintext_override(kms_key_id, ddb_table_name)

    # 2. Put an item into your table using the Encrypted Table.
    #    This item will be encrypted using the DB Encryption SDK, using the
    #    configuration to determine which attributes to encrypt and/or sign.
    item = {
        "partition_key": "PlaintextMigrationExample",
        "sort_key": 3,
        "attribute1": "encrypt and sign me!",
        "attribute2": "sign me!",
        ":attribute3": "ignore me!",
    }

    put_item_response = encrypted_table.put_item(Item=item)
    # Demonstrate that PutItem succeeded
    assert put_item_response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # 3. Get an item back from the table using the Encrypted Table.
    #    If this is an item written in plaintext (e.g. any item written
    #    during Step 0 or 1), then we will fail to process the item.
    #    If this is an encrypted item (e.g. any item written during Step 2 or after),
    #    then we will decrypt the item and return it.
    key_to_get = {"partition_key": "PlaintextMigrationExample", "sort_key": sort_read_value}
    get_item_response = encrypted_table.get_item(Key=key_to_get)

    # Demonstrate that GetItem succeeded and returned the decrypted item
    assert get_item_response["ResponseMetadata"]["HTTPStatusCode"] == 200
    decrypted_item = get_item_response["Item"]

    # Demonstrate we get the expected item back
    assert decrypted_item["partition_key"] == "PlaintextMigrationExample"
    assert decrypted_item["sort_key"] == sort_read_value
    assert decrypted_item["attribute1"] == "encrypt and sign me!"
    assert decrypted_item["attribute2"] == "sign me!"
    assert decrypted_item[":attribute3"] == "ignore me!"
