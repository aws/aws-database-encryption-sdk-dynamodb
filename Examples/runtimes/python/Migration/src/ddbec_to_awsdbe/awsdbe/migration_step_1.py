# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0

"""
Migration Step 1.

This is an example demonstrating how to start using the
AWS Database Encryption SDK with a pre-existing table used with DynamoDB Encryption Client.
In this example, you configure a DynamoDb Encryption Interceptor to do the following:
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

import boto3

# Import from new AWS Database Encryption SDK
from aws_dbesdk_dynamodb.structures.dynamodb import (
    LegacyOverride,
    LegacyPolicy,
)

# Import from legacy DynamoDB Encryption Client
from dynamodb_encryption_sdk.encrypted.client import EncryptedClient as LegacyEncryptedClient
from dynamodb_encryption_sdk.material_providers.aws_kms import AwsKmsCryptographicMaterialsProvider
from dynamodb_encryption_sdk.structures import AttributeActions, CryptoAction

from .common import ATTRIBUTE_ACTIONS_ON_ENCRYPT, setup_awsdbe_client_with_legacy_override


def migration_step_1(kms_key_id, ddb_table_name, sort_read_value=0):
    """
    Migration Step 1: Using the AWS Database Encryption SDK with Legacy Override.

    Args:
        kms_key_id: The ARN of the KMS key to use for encryption
        ddb_table_name: The name of the DynamoDB table
        sort_read_value: The sort key value to read

    """
    # 1. Create AWS SDK DynamoDB Client
    ddb_client = boto3.client("dynamodb")

    # 2. Create a DynamoDB Encryption SDK client with legacy override
    encrypted_client = setup_awsdbe_client_with_legacy_override(
        kms_key_id=kms_key_id, ddb_table_name=ddb_table_name
    )

    # 3. Put an item in the old format since we are using a legacy override
    #    with FORCE_LEGACY_ENCRYPT_ALLOW_DECRYPT policy
    item_to_encrypt = {
        "partition_key": {"S": "MigrationExampleForPython"},
        "sort_key": {"N": str(1)},
        "attribute1": {"S": "encrypt and sign me!"},
        "attribute2": {"S": "sign me!"},
        "attribute3": {"S": "ignore me!"},
    }

    put_item_request = {
        "TableName": ddb_table_name,
        "Item": item_to_encrypt,
    }

    put_item_response = encrypted_client.put_item(**put_item_request)
    # Demonstrate that PutItem succeeded
    assert put_item_response["ResponseMetadata"]["HTTPStatusCode"] == 200
    print("Put Item Response SHOULD have legacy attributes")
    print(f"Put Item Response: {put_item_response['Item']}")

    # 4. Get the item back from DynamoDB directly and decrypt it with our client.
    #    Because we used FORCE_LEGACY_ENCRYPT_ALLOW_DECRYPT, we expect the item to
    #    be encrypted in the old format.
    key_to_get = {"partition_key": {"S": "MigrationExampleForPython"}, "sort_key": {"N": str(sort_read_value)}}

    get_item_request = {"TableName": ddb_table_name, "Key": key_to_get}
    get_item_response = encrypted_client.get_item(**get_item_request)

    # Demonstrate that GetItem succeeded and returned the decrypted item
    assert get_item_response["ResponseMetadata"]["HTTPStatusCode"] == 200
    assert get_item_response["Item"] == item_to_encrypt

    decrypted_item = get_item_response["Item"]
    # Demonstrate we get the expected item back
    assert decrypted_item["partition_key"]["S"] == "MigrationExampleForPython"
    if sort_read_value == 0:
        assert decrypted_item["attribute1"]["S"] == "encrypt and sign me!"
    elif sort_read_value == 1:
        assert decrypted_item["attribute1"]["S"] == "encrypt and sign me!"
    assert decrypted_item["attribute2"]["S"] == "sign me!"
    assert decrypted_item["attribute3"]["S"] == "ignore me!"
