# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""
Example demonstrating DynamoDb Encryption using a Raw RSA Keyring with EncryptedClient.

The raw RSA Keyring uses an RSA key pair to encrypt and decrypt records.
The keyring accepts PEM encodings of the key pair as UTF-8 interpreted bytes.
The client uses the public key to encrypt items it adds to the table and
uses the private key to decrypt existing table items it retrieves.

The example loads a key pair from PEM files with paths defined in:
 - EXAMPLE_RSA_PRIVATE_KEY_FILENAME
 - EXAMPLE_RSA_PUBLIC_KEY_FILENAME

If you do not provide these files, running this example through the main method
will generate these files for you in the directory where the example is run.
In practice, users of this library should not generate new key pairs like this,
and should instead retrieve an existing key from a secure key management system
(e.g. an HSM).

You may also provide your own key pair by placing PEM files in the directory
where the example is run or modifying the paths in the code below. These files
must be valid PEM encodings of the key pair as UTF-8 encoded bytes. If you do
provide your own key pair, or if a key pair already exists, this class' main
method will not generate a new key pair.

The example loads a key pair from disk, encrypts a test item, and puts the
encrypted item to the provided DynamoDb table. Then, it gets the item from
the table and decrypts it.

Running this example requires access to the DDB Table whose name is provided
in CLI arguments. This table must be configured with the following primary
key configuration:
  - Partition key is named "partition_key" with type (S)
  - Sort key is named "sort_key" with type (S)
"""

import boto3
from aws_dbesdk_dynamodb.encrypted.client import EncryptedClient

from .encryption_config import create_encryption_config
from .utility import (
    EXAMPLE_RSA_PRIVATE_KEY_FILENAME,
    EXAMPLE_RSA_PUBLIC_KEY_FILENAME,
)


def raw_rsa_keyring_client_example(ddb_table_name: str, private_key_path: str, public_key_path: str):
    """
    Demonstrate using a raw RSA keyring with EncryptedClient.

    :param ddb_table_name: The name of the DynamoDB table
    :param private_key_path: Path to the private key PEM file
    :param public_key_path: Path to the public key PEM file
    """
    # 1. Load key pair from UTF-8 encoded PEM files.
    #    You may provide your own PEM files to use here.
    #    If you do not, the main method in this class will generate PEM
    #    files for example use. Do not use these files for any other purpose.
    try:
        with open(EXAMPLE_RSA_PUBLIC_KEY_FILENAME, "rb") as f:
            public_key_utf8_encoded = f.read()
    except IOError as e:
        raise OSError("IOError while reading public key from file") from e

    try:
        with open(EXAMPLE_RSA_PRIVATE_KEY_FILENAME, "rb") as f:
            private_key_utf8_encoded = f.read()
    except IOError as e:
        raise OSError("IOError while reading private key from file") from e

    # 2. Create the DynamoDb Encryption configuration for the table we will be writing to.
    #    See encryption_config.py in this directory for detailed steps on the encryption configuration.
    tables_config = create_encryption_config(
        ddb_table_name=ddb_table_name,
        public_key_utf8_encoded=public_key_utf8_encoded,
        private_key_utf8_encoded=private_key_utf8_encoded,
    )

    # 3. Create the EncryptedClient
    ddb_client = boto3.client("dynamodb")
    encrypted_ddb_client = EncryptedClient(client=ddb_client, encryption_config=tables_config)

    # 4. Put an item into our table using the above client.
    #    Before the item gets sent to DynamoDb, it will be encrypted
    #    client-side, according to our configuration.
    item = {
        "partition_key": {"S": "rawRsaKeyringItem"},
        "sort_key": {"N": "0"},
        "sensitive_data": {"S": "encrypt and sign me!"},
    }

    put_response = encrypted_ddb_client.put_item(TableName=ddb_table_name, Item=item)

    # Demonstrate that PutItem succeeded
    assert put_response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # 5. Get the item back from our table using the same client.
    #    The client will decrypt the item client-side, and return
    #    back the original item.
    key_to_get = {"partition_key": {"S": "rawRsaKeyringItem"}, "sort_key": {"N": "0"}}

    get_response = encrypted_ddb_client.get_item(TableName=ddb_table_name, Key=key_to_get)

    # Demonstrate that GetItem succeeded and returned the decrypted item
    assert get_response["ResponseMetadata"]["HTTPStatusCode"] == 200
    returned_item = get_response["Item"]
    assert returned_item["sensitive_data"]["S"] == "encrypt and sign me!"
