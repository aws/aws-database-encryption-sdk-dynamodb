# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0

"""
Migration Step 0.

This is an example demonstrating use with the DynamoDb Encryption Client.
and is the starting state for our migration to the AWS Database Encryption SDK for DynamoDb.
In this example we configure an EncryptedClient which provides an encrypted paginator
configured to encrypt and decrypt items. The encryption and decryption of data is
configured to use a KMS Key as the root of trust.

Running this example requires access to the DDB Table whose name
is provided in CLI arguments.
This table must be configured with the following
primary key configuration:
  - Partition key is named "partition_key" with type (S)
  - Sort key is named "sort_key" with type (N)
"""

import boto3

# Import from legacy DynamoDB Encryption Client
from dynamodb_encryption_sdk.encrypted.client import EncryptedClient
from dynamodb_encryption_sdk.identifiers import CryptoAction
from dynamodb_encryption_sdk.material_providers.aws_kms import AwsKmsCryptographicMaterialsProvider
from dynamodb_encryption_sdk.structures import AttributeActions


def migration_step_0_with_paginator(kms_key_id: str, ddb_table_name: str, sort_read_value: int = 0):
    """
    Migration Step 0: Using the DynamoDb Encryption Client with EncryptedClient's paginator.

    :param kms_key_id: The ARN of the KMS key to use for encryption
    :param ddb_table_name: The name of the DynamoDB table
    """
    # 1. Create the MaterialProvider that protects your data keys. For this example,
    #    we create a KmsCryptographicMaterialsProvider which protects data keys using a single kmsKey.
    cmp = AwsKmsCryptographicMaterialsProvider(key_id=kms_key_id)

    # 2. Create the AttributeActions to configure encryption and signing
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
        "partition_key": {"S": "PaginatorMigrationExampleForPython"},
        "sort_key": {"N": "0"},
        "attribute1": {"S": "encrypt and sign me!"},
        "attribute2": {"S": "sign me!"},
        ":attribute3": {"S": "ignore me!"},
    }

    put_item_response = encrypted_client.put_item(TableName=ddb_table_name, Item=item)
    # Demonstrate that PutItem succeeded
    assert put_item_response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # 5. Get a paginator from the encrypted client
    #    The paginator will automatically decrypt items as they are returned.
    encrypted_paginator = encrypted_client.get_paginator("query")

    # 6. Use the paginator to get items from the table
    items = []
    for page in encrypted_paginator.paginate(
        TableName=ddb_table_name,
        KeyConditionExpression="partition_key = :partition_key AND sort_key = :sort_key",
        ExpressionAttributeValues={
            ":partition_key": {"S": "PaginatorMigrationExampleForPython"},
            ":sort_key": {"N": str(sort_read_value)},
        },
    ):
        for item in page["Items"]:
            items.append(item)

    # 7. Verify the decrypted items
    assert len(items) == 1  # We should have only one item with above key condition
    item = next((i for i in items if i["sort_key"]["N"] == str(sort_read_value)), None)
    assert item is not None
    assert item["partition_key"]["S"] == "PaginatorMigrationExampleForPython"
    assert item["attribute1"]["S"] == "encrypt and sign me!"
    assert item["attribute2"]["S"] == "sign me!"
    assert item[":attribute3"]["S"] == "ignore me!"
