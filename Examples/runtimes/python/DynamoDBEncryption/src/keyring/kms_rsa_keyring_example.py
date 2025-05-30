# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""
Example demonstrating DynamoDb Encryption using a KMS RSA Keyring.

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

import os

import boto3
from aws_cryptographic_material_providers.mpl import AwsCryptographicMaterialProviders
from aws_cryptographic_material_providers.mpl.config import MaterialProvidersConfig
from aws_cryptographic_material_providers.mpl.models import (
    CreateAwsKmsRsaKeyringInput,
    DBEAlgorithmSuiteId,
)
from aws_dbesdk_dynamodb.encrypted.client import EncryptedClient
from aws_dbesdk_dynamodb.structures.dynamodb import (
    DynamoDbTableEncryptionConfig,
    DynamoDbTablesEncryptionConfig,
)
from aws_dbesdk_dynamodb.structures.structured_encryption import (
    CryptoAction,
)
from cryptography.hazmat.primitives import serialization

DEFAULT_EXAMPLE_RSA_PUBLIC_KEY_FILENAME = "KmsRsaKeyringExamplePublicKey.pem"


def kms_rsa_keyring_example(
    ddb_table_name: str, rsa_key_arn: str, rsa_public_key_filename: str = DEFAULT_EXAMPLE_RSA_PUBLIC_KEY_FILENAME
):
    """
    Create a KMS RSA keyring and use it to encrypt/decrypt DynamoDB items.

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
        raise RuntimeError("IOError while reading public key from file") from e

    # 2. Create a KMS RSA keyring.
    #    This keyring takes in:
    #     - kms_client
    #     - kms_key_id: Must be an ARN representing a KMS RSA key
    #     - public_key: A ByteBuffer of a UTF-8 encoded PEM file representing the public
    #                  key for the key passed into kms_key_id
    #     - encryption_algorithm: Must be either RSAES_OAEP_SHA_256 or RSAES_OAEP_SHA_1
    mat_prov = AwsCryptographicMaterialProviders(config=MaterialProvidersConfig())

    keyring_input = CreateAwsKmsRsaKeyringInput(
        kms_key_id=rsa_key_arn,
        kms_client=boto3.client("kms"),
        public_key=public_key_utf8_encoded,
        encryption_algorithm="RSAES_OAEP_SHA_256",
    )

    kms_rsa_keyring = mat_prov.create_aws_kms_rsa_keyring(input=keyring_input)

    # 3. Configure which attributes are encrypted and/or signed when writing new items.
    #    For each attribute that may exist on the items we plan to write to our DynamoDbTable,
    #    we must explicitly configure how they should be treated during item encryption:
    #      - ENCRYPT_AND_SIGN: The attribute is encrypted and included in the signature
    #      - SIGN_ONLY: The attribute not encrypted, but is still included in the signature
    #      - DO_NOTHING: The attribute is not encrypted and not included in the signature
    attribute_actions = {
        "partition_key": CryptoAction.SIGN_ONLY,  # Our partition attribute must be SIGN_ONLY
        "sort_key": CryptoAction.SIGN_ONLY,  # Our sort attribute must be SIGN_ONLY
        "sensitive_data": CryptoAction.ENCRYPT_AND_SIGN,
    }

    # 4. Configure which attributes we expect to be included in the signature
    #    when reading items. There are two options for configuring this:
    #
    #    - (Recommended) Configure `allowed_unsigned_attribute_prefix`:
    #      When defining your DynamoDb schema and deciding on attribute names,
    #      choose a distinguishing prefix (such as ":") for all attributes that
    #      you do not want to include in the signature.
    #      This has two main benefits:
    #      - It is easier to reason about the security and authenticity of data within your item
    #        when all unauthenticated data is easily distinguishable by their attribute name.
    #      - If you need to add new unauthenticated attributes in the future,
    #        you can easily make the corresponding update to your `attribute_actions`
    #        and immediately start writing to that new attribute, without
    #        any other configuration update needed.
    #      Once you configure this field, it is not safe to update it.
    #
    #    - Configure `allowed_unsigned_attributes`: You may also explicitly list
    #      a set of attributes that should be considered unauthenticated when encountered
    #      on read. Be careful if you use this configuration. Do not remove an attribute
    #      name from this configuration, even if you are no longer writing with that attribute,
    #      as old items may still include this attribute, and our configuration needs to know
    #      to continue to exclude this attribute from the signature scope.
    #      If you add new attribute names to this field, you must first deploy the update to this
    #      field to all readers in your host fleet before deploying the update to start writing
    #      with that new attribute.
    #
    #   For this example, we currently authenticate all attributes. To make it easier to
    #   add unauthenticated attributes in the future, we define a prefix ":" for such attributes.
    unsign_attr_prefix = ":"

    # 5. Create the DynamoDb Encryption configuration for the table we will be writing to.
    #    Note: To use the KMS RSA keyring, your table config must specify an algorithmSuite
    #    that does not use asymmetric signing.
    table_config = DynamoDbTableEncryptionConfig(
        logical_table_name=ddb_table_name,
        partition_key_name="partition_key",
        sort_key_name="sort_key",
        attribute_actions_on_encrypt=attribute_actions,
        keyring=kms_rsa_keyring,
        allowed_unsigned_attribute_prefix=unsign_attr_prefix,
        # Specify algorithmSuite without asymmetric signing here
        # As of v3.0.0, the only supported algorithmSuite without asymmetric signing is
        # ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_SYMSIG_HMAC_SHA384.
        algorithm_suite_id=DBEAlgorithmSuiteId.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_SYMSIG_HMAC_SHA384,
    )

    table_configs = {ddb_table_name: table_config}
    tables_config = DynamoDbTablesEncryptionConfig(table_encryption_configs=table_configs)

    # 6. Create the EncryptedClient
    ddb_client = boto3.client("dynamodb")
    encrypted_ddb_client = EncryptedClient(client=ddb_client, encryption_config=tables_config)

    # 7. Put an item into our table using the above client.
    #    Before the item gets sent to DynamoDb, it will be encrypted
    #    client-side using the KMS RSA keyring.
    item = {
        "partition_key": {"S": "awsKmsRsaKeyringItem"},
        "sort_key": {"N": "0"},
        "sensitive_data": {"S": "encrypt and sign me!"},
    }

    put_response = encrypted_ddb_client.put_item(TableName=ddb_table_name, Item=item)

    # Demonstrate that PutItem succeeded
    assert put_response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # 8. Get the item back from our table using the client.
    #    The client will decrypt the item client-side using the RSA keyring
    #    and return the original item.
    key_to_get = {"partition_key": {"S": "awsKmsRsaKeyringItem"}, "sort_key": {"N": "0"}}

    get_response = encrypted_ddb_client.get_item(TableName=ddb_table_name, Key=key_to_get)

    # Demonstrate that GetItem succeeded and returned the decrypted item
    assert get_response["ResponseMetadata"]["HTTPStatusCode"] == 200
    returned_item = get_response["Item"]
    assert returned_item["sensitive_data"]["S"] == "encrypt and sign me!"


def should_get_new_public_key(rsa_public_key_filename: str = DEFAULT_EXAMPLE_RSA_PUBLIC_KEY_FILENAME) -> bool:
    """
    Check if we need to get a new public key.

    :param rsa_public_key_filename: Path to the public key PEM file
    :return: True if we need to get a new public key, False otherwise
    """
    # Check if a public key file already exists
    public_key_file = os.path.exists(rsa_public_key_filename)

    # If a public key file already exists: do not overwrite existing file
    if public_key_file:
        return False

    # If file is not present, generate a new key pair
    return True


def write_public_key_pem_for_rsa_key(
    rsa_key_arn: str, rsa_public_key_filename: str = DEFAULT_EXAMPLE_RSA_PUBLIC_KEY_FILENAME
):
    """
    Get the public key from KMS and write it to a PEM file.

    :param rsa_key_arn: The ARN of the KMS RSA key
    :param rsa_public_key_filename: Path to write the public key PEM file
    """
    # Safety check: Validate file is not present
    if os.path.exists(rsa_public_key_filename):
        raise RuntimeError("getRsaPublicKey will not overwrite existing PEM files")

    # This code will call KMS to get the public key for the KMS RSA key.
    # You must have kms:GetPublicKey permissions on the key for this to succeed.
    # The public key will be written to the file EXAMPLE_RSA_PUBLIC_KEY_FILENAME.
    kms_client = boto3.client("kms")
    response = kms_client.get_public_key(KeyId=rsa_key_arn)
    public_key_bytes = response["PublicKey"]

    # Convert the public key to PEM format
    public_key = serialization.load_der_public_key(public_key_bytes)
    pem_data = public_key.public_bytes(
        encoding=serialization.Encoding.PEM, format=serialization.PublicFormat.SubjectPublicKeyInfo
    )

    # Write the PEM file
    try:
        with open(rsa_public_key_filename, "wb") as f:
            f.write(pem_data)
    except IOError as e:
        raise RuntimeError("IOError while writing public key PEM") from e
