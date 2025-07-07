# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""
Example demonstrating DynamoDb Encryption using a KMS RSA Keyring with EncryptedTable.

The KMS RSA Keyring uses a KMS RSA key pair to encrypt and decrypt records. The client
uses the downloaded public key to encrypt items it adds to the table. The keyring
uses the private key to decrypt existing table items it retrieves by calling
KMS' decrypt API.

Running this example requires access to the DDB Table whose name is provided
in CLI arguments. This table must be configured with the following primary key
configuration:
  - Partition key is named "partition_key" with type (S)
  - Sort key is named "sort_key" with type (S)

The example also requires access to a KMS RSA key. Our tests provide a KMS RSA
ARN that anyone can use, but you can also provide your own KMS RSA key.
To use your own KMS RSA key, you must have either:
 - Its public key downloaded in a UTF-8 encoded PEM file
 - kms:GetPublicKey permissions on that key

If you do not have the public key downloaded, running this example through its
main method will download the public key for you by calling kms:GetPublicKey.
You must also have kms:Decrypt permissions on the KMS RSA key.
"""

import boto3
from aws_dbesdk_dynamodb.encrypted.table import EncryptedTable

from .encryption_config import create_encryption_config
from .utility import DEFAULT_EXAMPLE_RSA_PUBLIC_KEY_FILENAME


def kms_rsa_keyring_table_example(
    ddb_table_name: str, rsa_key_arn: str, rsa_public_key_filename: str = DEFAULT_EXAMPLE_RSA_PUBLIC_KEY_FILENAME
):
    """
    Create a KMS RSA keyring and use it to encrypt/decrypt DynamoDB items with EncryptedTable.

    :param ddb_table_name: The name of the DynamoDB table
    :param rsa_key_arn: ARN of the KMS RSA key
    :param rsa_public_key_filename: Path to the public key PEM file
    """
    # 1. Load UTF-8 encoded public key PEM file.
    #    You may have an RSA public key file already defined.
    #    If not, the main method in this class will call
    #    the KMS RSA key, retrieve its public key, and store it
    #    in a PEM file for example use.
    try:
        with open(rsa_public_key_filename, "rb") as f:
            public_key_utf8_encoded = f.read()
    except IOError as e:
        raise OSError("IOError while reading public key from file") from e

    # 2. Create the DynamoDb Encryption configuration for the table we will be writing to.
    #    See encryption_config.py in this directory for detailed steps on the encryption configuration.
    tables_config = create_encryption_config(
        ddb_table_name=ddb_table_name,
        rsa_key_arn=rsa_key_arn,
        public_key_utf8_encoded=public_key_utf8_encoded,
    )

    # 3. Create the EncryptedTable
    ddb_table = boto3.resource("dynamodb").Table(ddb_table_name)
    encrypted_table = EncryptedTable(
        table=ddb_table,
        encryption_config=tables_config,
    )

    # 4. Put an item into our table using the above table.
    #    Before the item gets sent to DynamoDb, it will be encrypted
    #    client-side using the KMS RSA keyring.
    item = {
        "partition_key": "awsKmsRsaKeyringItem",
        "sort_key": 0,
        "sensitive_data": "encrypt and sign me!",
    }

    put_response = encrypted_table.put_item(Item=item)

    # Demonstrate that PutItem succeeded
    assert put_response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # 5. Get the item back from our table using the table.
    #    The table will decrypt the item client-side using the RSA keyring
    #    and return the original item.
    key_to_get = {"partition_key": "awsKmsRsaKeyringItem", "sort_key": 0}

    get_response = encrypted_table.get_item(Key=key_to_get)

    # Demonstrate that GetItem succeeded and returned the decrypted item
    assert get_response["ResponseMetadata"]["HTTPStatusCode"] == 200
    returned_item = get_response["Item"]
    assert returned_item["sensitive_data"] == "encrypt and sign me!"
