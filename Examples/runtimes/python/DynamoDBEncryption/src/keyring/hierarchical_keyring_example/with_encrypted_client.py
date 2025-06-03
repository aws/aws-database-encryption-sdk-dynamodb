# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""
Example demonstrating DynamoDb Encryption using a Hierarchical Keyring with EncryptedClient.

This example sets up DynamoDb Encryption for the AWS SDK client
using the Hierarchical Keyring, which establishes a key hierarchy
where "branch" keys are persisted in DynamoDb.
These branch keys are used to protect your data keys,
and these branch keys are themselves protected by a root KMS Key.

Running this example requires access to the DDB Table whose name
is provided in CLI arguments.
This table must be configured with the following
primary key configuration:
  - Partition key is named "partition_key" with type (S)
  - Sort key is named "sort_key" with type (S)

This example also requires using a KMS Key whose ARN
is provided in CLI arguments. You need the following access
on this key:
  - GenerateDataKeyWithoutPlaintext
  - Decrypt
"""

import boto3
from aws_dbesdk_dynamodb.encrypted.client import EncryptedClient

from .encryption_config import create_encryption_config


def hierarchical_keyring_client_example(
    ddb_table_name: str,
    tenant1_branch_key_id: str,
    tenant2_branch_key_id: str,
    keystore_table_name: str,
    logical_keystore_name: str,
    kms_key_id: str,
):
    """
    Demonstrate using a hierarchical keyring with multiple tenants using EncryptedClient.

    :param ddb_table_name: The name of the DynamoDB table
    :param tenant1_branch_key_id: Branch key ID for tenant 1
    :param tenant2_branch_key_id: Branch key ID for tenant 2
    :param keystore_table_name: The name of the KeyStore DynamoDB table
    :param logical_keystore_name: The logical name for this keystore
    :param kms_key_id: The ARN of the KMS key to use
    """
    # 1. Create the DynamoDb Encryption configuration for the table we will be writing to.
    #    See encryption_config.py in this directory for detailed steps on the encryption configuration.
    tables_config = create_encryption_config(
        ddb_table_name=ddb_table_name,
        tenant1_branch_key_id=tenant1_branch_key_id,
        tenant2_branch_key_id=tenant2_branch_key_id,
        keystore_table_name=keystore_table_name,
        logical_keystore_name=logical_keystore_name,
        kms_key_id=kms_key_id,
    )

    # 2. Create the EncryptedClient
    ddb_client = boto3.client("dynamodb")
    encrypted_ddb_client = EncryptedClient(client=ddb_client, encryption_config=tables_config)

    # 3. Put an item into our table using the above client.
    #    Before the item gets sent to DynamoDb, it will be encrypted
    #    client-side, according to our configuration.
    #    Because the item we are writing uses "tenantId1" as our partition value,
    #    based on the code we wrote in the ExampleBranchKeySupplier,
    #    `tenant1_branch_key_id` will be used to encrypt this item.
    item = {
        "partition_key": {"S": "tenant1Id"},
        "sort_key": {"N": "0"},
        "tenant_sensitive_data": {"S": "encrypt and sign me!"},
    }

    put_response = encrypted_ddb_client.put_item(TableName=ddb_table_name, Item=item)

    # Demonstrate that PutItem succeeded
    assert put_response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # 4. Get the item back from our table using the same client.
    #    The client will decrypt the item client-side, and return
    #    back the original item.
    #    Because the returned item's partition value is "tenantId1",
    #    based on the code we wrote in the ExampleBranchKeySupplier,
    #    `tenant1_branch_key_id` will be used to decrypt this item.
    key_to_get = {"partition_key": {"S": "tenant1Id"}, "sort_key": {"N": "0"}}

    get_response = encrypted_ddb_client.get_item(TableName=ddb_table_name, Key=key_to_get)

    # Demonstrate that GetItem succeeded and returned the decrypted item
    assert get_response["ResponseMetadata"]["HTTPStatusCode"] == 200
    returned_item = get_response["Item"]
    assert returned_item["tenant_sensitive_data"]["S"] == "encrypt and sign me!"
