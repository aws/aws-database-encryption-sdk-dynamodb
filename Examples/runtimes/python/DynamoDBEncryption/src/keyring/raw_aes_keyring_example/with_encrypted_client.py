# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""
Example demonstrating DynamoDb Encryption using a Raw AES Keyring with EncryptedClient.

The raw AES Keyring takes in an AES key and uses that key to protect the data
keys that encrypt and decrypt DynamoDb table items.

This example takes an `aes_key_bytes` parameter representing a 256-bit AES key.
If run through the script's main method, it will create a new key. In practice,
users should not randomly generate a key, but instead retrieve an existing key
from a secure key management system (e.g. an HSM).

This example encrypts a test item using the provided AES key and puts the encrypted
item to the provided DynamoDb table. Then, it gets the item from the table and
decrypts it.

Running this example requires access to the DDB Table whose name is provided in
CLI arguments. This table must be configured with the following primary key
configuration:
  - Partition key is named "partition_key" with type (S)
  - Sort key is named "sort_key" with type (S)
"""

import boto3
from aws_dbesdk_dynamodb.encrypted.client import EncryptedClient

from .encryption_config import create_encryption_config


def raw_aes_keyring_client_example(ddb_table_name: str, aes_key_bytes: bytes):
    """
    Demonstrate using a raw AES keyring with EncryptedClient.

    :param ddb_table_name: The name of the DynamoDB table
    :param aes_key_bytes: The AES key bytes to use
    """
    # 1. Create the DynamoDb Encryption configuration for the table we will be writing to.
    #    See encryption_config.py in this directory for detailed steps on the encryption configuration.
    tables_config = create_encryption_config(
        ddb_table_name=ddb_table_name,
        aes_key_bytes=aes_key_bytes,
    )

    # 2. Create the EncryptedClient
    ddb_client = boto3.client("dynamodb")
    encrypted_ddb_client = EncryptedClient(client=ddb_client, encryption_config=tables_config)

    # 3. Put an item into our table using the above client.
    #    Before the item gets sent to DynamoDb, it will be encrypted
    #    client-side, according to our configuration.
    item = {
        "partition_key": {"S": "rawAesKeyringItem"},
        "sort_key": {"N": "0"},
        "sensitive_data": {"S": "encrypt and sign me!"},
    }

    put_response = encrypted_ddb_client.put_item(TableName=ddb_table_name, Item=item)

    # Demonstrate that PutItem succeeded
    assert put_response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # 4. Get the item back from our table using the same client.
    #    The client will decrypt the item client-side, and return
    #    back the original item.
    key_to_get = {"partition_key": {"S": "rawAesKeyringItem"}, "sort_key": {"N": "0"}}

    get_response = encrypted_ddb_client.get_item(TableName=ddb_table_name, Key=key_to_get)

    # Demonstrate that GetItem succeeded and returned the decrypted item
    assert get_response["ResponseMetadata"]["HTTPStatusCode"] == 200
    returned_item = get_response["Item"]
    assert returned_item["sensitive_data"]["S"] == "encrypt and sign me!"
