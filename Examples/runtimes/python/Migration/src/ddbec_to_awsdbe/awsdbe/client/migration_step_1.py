# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0

"""
Migration Step 1.

This is an example demonstrating how to start using the
AWS Database Encryption SDK with a pre-existing table used with DynamoDB Encryption Client.
In this example, you configure a EncryptedClient to do the following:
  - Read items encrypted in the old format
  - Continue to encrypt items in the old format on write
  - Read items encrypted in the new format
While this step configures your client to be ready to start reading items encrypted,
we do not yet expect to be reading any items in the new format.
Before you move on to step 2, ensure that these changes have successfully been deployed
to all of your readers.

Running this example requires access to the DDB Table whose name
is provided in CLI arguments.
This table must be configured with the following
primary key configuration:
  - Partition key is named "partition_key" with type (S)
  - Sort key is named "sort_key" with type (S)
"""
from aws_dbesdk_dynamodb.structures.dynamodb import LegacyPolicy

from .common import setup_awsdbe_client_with_legacy_override


def migration_step_1_with_client(kms_key_id: str, ddb_table_name: str, sort_read_value: int = 1):
    """
    Migration Step 1: Using the AWS Database Encryption SDK with Legacy Override.

    :param kms_key_id: The ARN of the KMS key to use for encryption
    :param ddb_table_name: The name of the DynamoDB table
    :param sort_read_value: The sort key value to read

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
        "partition_key": {"S": "MigrationExampleForPython"},
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

    # 3. Get an item back from the table using the DynamoDb Enhanced Client.
    #     If this is an item written in the old format (e.g. any item written
    #     during Step 0 or 1), then we will attempt to decrypt the item
    #     using the legacy behavior.
    #     If this is an item written in the new format (e.g. any item written
    #     during Step 2 or after), then we will attempt to decrypt the item using
    #     the non-legacy behavior.
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
