# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0

"""
Migration Step 0.

This is an example demonstrating use with the DynamoDb Encryption Client.
and is the starting state for our migration to the AWS Database Encryption SDK for DynamoDb.
In this example we configure an EncryptedResource configured to encrypt and decrypt
items. The encryption and decryption of data is configured to use a KMS Key as the root of trust.

Running this example requires access to the DDB Table whose name
is provided in CLI arguments.
This table must be configured with the following
primary key configuration:
  - Partition key is named "partition_key" with type (S)
  - Sort key is named "sort_key" with type (N)
"""

import boto3

# Import from legacy DynamoDB Encryption Resource
from dynamodb_encryption_sdk.encrypted.resource import EncryptedResource
from dynamodb_encryption_sdk.identifiers import CryptoAction
from dynamodb_encryption_sdk.material_providers.aws_kms import AwsKmsCryptographicMaterialsProvider
from dynamodb_encryption_sdk.structures import AttributeActions


def migration_step_0_with_resource(kms_key_id: str, ddb_table_name: str, sort_read_value: int = 0):
    """
    Migration Step 0: Using the DynamoDb Encryption Client with EncryptedResource.

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

    # 3. Create a legacy EncryptedResource.
    encrypted_resource = EncryptedResource(
        resource=boto3.resource("dynamodb"), materials_provider=cmp, attribute_actions=actions
    )

    # 4. Write a batch of items to the table.
    #    These items will be encrypted client-side before they are sent to DynamoDB.
    items = [
        {
            "partition_key": "PythonEncryptedResourceMigrationExample-1",
            "sort_key": 0,
            "attribute1": "encrypt and sign me!",
            "attribute2": "sign me!",
            ":attribute3": "ignore me!",
        },
        {
            "partition_key": "PythonEncryptedResourceMigrationExample-2",
            "sort_key": 0,
            "attribute1": "encrypt and sign me!",
            "attribute2": "sign me!",
            ":attribute3": "ignore me!",
        },
    ]

    batch_write_items_put_request = {
        "RequestItems": {
            ddb_table_name: [{"PutRequest": {"Item": item}} for item in items],
        },
    }

    batch_write_items_put_response = encrypted_resource.batch_write_item(**batch_write_items_put_request)

    # Demonstrate that BatchWriteItem succeeded
    assert batch_write_items_put_response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # 5. Read the items back from the table.
    #    The items will be decrypted client-side, and the original items returned.
    batch_get_items_request = {
        "RequestItems": {
            ddb_table_name: {
                "Keys": [{"partition_key": item["partition_key"], "sort_key": sort_read_value} for item in items],
            }
        },
    }

    batch_get_items_response = encrypted_resource.batch_get_item(**batch_get_items_request)

    # Demonstrate that BatchGetItem succeeded with the expected result
    assert batch_get_items_response["ResponseMetadata"]["HTTPStatusCode"] == 200
    for item in batch_get_items_response["Responses"][ddb_table_name]:
        assert (
            item["partition_key"] == "PythonEncryptedResourceMigrationExample-1"
            or item["partition_key"] == "PythonEncryptedResourceMigrationExample-2"
        )
        assert item["sort_key"] == sort_read_value
        assert item["attribute1"] == "encrypt and sign me!"
        assert item["attribute2"] == "sign me!"
        assert item[":attribute3"] == "ignore me!"
