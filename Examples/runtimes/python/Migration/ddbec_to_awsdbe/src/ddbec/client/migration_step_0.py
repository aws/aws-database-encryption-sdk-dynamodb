# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0

"""
Migration Step 0.

This is an example demonstrating use with the DynamoDb Encryption Client.
and is the starting state for our migration to the AWS Database Encryption SDK for DynamoDb.
In this example we configure an AWS SDK Client configured to encrypt and decrypt
items. The encryption and decryption of data is configured to use a KMS Key as the root of trust.

Running this example requires access to the DDB Table whose name
is provided in CLI arguments.
This table must be configured with the following
primary key configuration:
  - Partition key is named "partition_key" with type (S)
  - Sort key is named "sort_key" with type (S)
"""

import boto3

# Import from legacy DynamoDB Encryption Client
from dynamodb_encryption_sdk.encrypted.client import EncryptedClient
from dynamodb_encryption_sdk.identifiers import CryptoAction
from dynamodb_encryption_sdk.material_providers.aws_kms import AwsKmsCryptographicMaterialsProvider
from dynamodb_encryption_sdk.structures import AttributeActions


def migration_step_0_with_client(kms_key_id: str, ddb_table_name: str, sort_read_value: int = 0):
    """
    Migration Step 0: Using the DynamoDb Encryption Client with EncryptedClient.

    :param kms_key_id: The ARN of the KMS key to use for encryption
    :param ddb_table_name: The name of the DynamoDB table
    :param sort_read_value: The sort key value to read

    """
    # 1. Create the MaterialProvider that protects your data keys. For this example,
    #    we create a KmsCryptographicMaterialsProvider which protects data keys using a single kmsKey.
    cmp = AwsKmsCryptographicMaterialsProvider(key_id=kms_key_id)

    # 2. Create the DynamoDBEncryptor using the Material Provider created above
    actions = AttributeActions(
        default_action=CryptoAction.ENCRYPT_AND_SIGN,
        attribute_actions={
            "partition_key": CryptoAction.SIGN_ONLY,
            "sort_key": CryptoAction.SIGN_ONLY,
            "attribute1": CryptoAction.ENCRYPT_AND_SIGN,
            "attribute2": CryptoAction.SIGN_ONLY,
            ":attribute3": CryptoAction.DO_NOTHING,
        },
    )

    # 3. Create a legacy EncryptedClient.
    ddb_client = boto3.client("dynamodb")
    encrypted_client = EncryptedClient(client=ddb_client, materials_provider=cmp, attribute_actions=actions)

    # 4. Put an example item into our DynamoDb table.
    #    This item will be encrypted client-side before it is sent to DynamoDb.
    item = {
        "partition_key": {"S": "MigrationExampleForPython"},
        "sort_key": {"N": str(0)},
        "attribute1": {"S": "encrypt and sign me!"},
        "attribute2": {"S": "sign me!"},
        ":attribute3": {"S": "ignore me!"},
    }

    encrypted_client.put_item(TableName=ddb_table_name, Item=item)

    # 5. Get this item back from DynamoDb.
    #    The item will be decrypted client-side, and the original item returned.
    key = {"partition_key": {"S": "MigrationExampleForPython"}, "sort_key": {"N": str(sort_read_value)}}

    get_item_response = encrypted_client.get_item(TableName=ddb_table_name, Key=key)
    # Demonstrate that GetItem succeeded and returned the decrypted item
    assert get_item_response["ResponseMetadata"]["HTTPStatusCode"] == 200
    decrypted_item = get_item_response["Item"]
    # Demonstrate we get the expected item back
    assert decrypted_item["partition_key"]["S"] == "MigrationExampleForPython"
    assert decrypted_item["sort_key"]["N"] == str(sort_read_value)
    assert decrypted_item["attribute1"]["S"] == "encrypt and sign me!"
    assert decrypted_item["attribute2"]["S"] == "sign me!"
    assert decrypted_item[":attribute3"]["S"] == "ignore me!"
