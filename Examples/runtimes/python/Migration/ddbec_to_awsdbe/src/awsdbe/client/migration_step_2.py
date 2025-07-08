# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0

"""
Migration Step 2.

This is an example demonstrating how to update your configuration
to start writing items using the latest encryption format, but still continue
to read any items written using the old encryption format.

Once you deploy this change to your system, you will have a dataset
containing items in both the old and new format.
Because the changes in Step 1 have been deployed to all our readers,
we can be sure that our entire system is ready to read this new data.

Running this example requires access to the DDB Table whose name
is provided in CLI arguments.
This table must be configured with the following
primary key configuration:
  - Partition key is named "partition_key" with type (S)
  - Sort key is named "sort_key" with type (S)
"""

from aws_dbesdk_dynamodb.structures.dynamodb import LegacyPolicy

# Import from new AWS Database Encryption SDK
from .common import setup_awsdbe_client_with_legacy_override


def migration_step_2_with_client(kms_key_id: str, ddb_table_name: str, sort_read_value: int = 2):
    """
    Migration Step 2: Using pure AWS DBESDK and legacy override together with EncryptedClient.

    :param kms_key_id: The ARN of the KMS key to use for encryption
    :param ddb_table_name: The name of the DynamoDB table
    :param sort_read_value: The sort key value to read

    """
    # 1. Create a EncryptedClient with legacy override.
    #    When configuring our legacy behavior, use `FORBID_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT`.
    #    With this policy, you will continue to read items in both formats,
    #    but will only write new items using the new format.
    encrypted_client = setup_awsdbe_client_with_legacy_override(
        kms_key_id, ddb_table_name, policy=LegacyPolicy.FORBID_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT
    )

    # 2. Put an item into your table using the DB ESDK Client.
    #    This item will be encrypted in the latest format, using the
    #    configuration from your modelled class to decide
    #    which attribute to encrypt and/or sign.
    item_to_encrypt = {
        "partition_key": {"S": "MigrationExampleForPython"},
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

    # 3. Get an item back from the table using the Client.
    #    If this is an item written in the old format (e.g. any item written
    #    during Step 0 or 1), then we will attempt to decrypt the item
    #    using the legacy behavior.
    #    If this is an item written in the new format (e.g. any item written
    #    during Step 2 or after), then we will attempt to decrypt the item using
    #    the non-legacy behavior.
    key_to_get = {"partition_key": {"S": "MigrationExampleForPython"}, "sort_key": {"N": str(sort_read_value)}}

    get_item_request = {"TableName": ddb_table_name, "Key": key_to_get}
    get_item_response = encrypted_client.get_item(**get_item_request)

    # Demonstrate that GetItem succeeded and returned the decrypted item
    assert get_item_response["ResponseMetadata"]["HTTPStatusCode"] == 200
    decrypted_item = get_item_response["Item"]
    # Demonstrate we get the expected item back
    assert decrypted_item["partition_key"]["S"] == "MigrationExampleForPython"
    assert decrypted_item["sort_key"]["N"] == str(sort_read_value)
    assert decrypted_item["attribute1"]["S"] == "encrypt and sign me!"
    assert decrypted_item["attribute2"]["S"] == "sign me!"
    assert decrypted_item[":attribute3"]["S"] == "ignore me!"
