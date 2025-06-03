# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""
Example demonstrating DynamoDb Encryption using a raw RSA Keyring.

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
import os

import boto3
from aws_cryptographic_material_providers.mpl import AwsCryptographicMaterialProviders
from aws_cryptographic_material_providers.mpl.config import MaterialProvidersConfig
from aws_cryptographic_material_providers.mpl.models import (
    CreateRawRsaKeyringInput,
    PaddingScheme,
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
from cryptography.hazmat.primitives.asymmetric import rsa

EXAMPLE_RSA_PRIVATE_KEY_FILENAME = "RawRsaKeyringExamplePrivateKey.pem"
EXAMPLE_RSA_PUBLIC_KEY_FILENAME = "RawRsaKeyringExamplePublicKey.pem"


def raw_rsa_keyring_example(ddb_table_name: str):
    """
    Create a Raw RSA keyring and use it to encrypt/decrypt DynamoDB items.

    :param ddb_table_name: The name of the DynamoDB table
    """
    # 1. Load key pair from UTF-8 encoded PEM files.
    #    You may provide your own PEM files to use here.
    #    If you do not, the main method in this class will generate PEM
    #    files for example use. Do not use these files for any other purpose.
    try:
        with open(EXAMPLE_RSA_PUBLIC_KEY_FILENAME, "rb") as f:
            public_key_utf8_encoded = f.read()
    except IOError as e:
        raise RuntimeError("IOError while reading public key from file") from e

    try:
        with open(EXAMPLE_RSA_PRIVATE_KEY_FILENAME, "rb") as f:
            private_key_utf8_encoded = f.read()
    except IOError as e:
        raise RuntimeError("IOError while reading private key from file") from e

    # 2. Create the keyring.
    #    The DynamoDb encryption client uses this to encrypt and decrypt items.
    mat_prov = AwsCryptographicMaterialProviders(config=MaterialProvidersConfig())

    keyring_input = CreateRawRsaKeyringInput(
        key_name="my-rsa-key-name",
        key_namespace="my-key-namespace",
        padding_scheme=PaddingScheme.OAEP_SHA256_MGF1,
        public_key=public_key_utf8_encoded,
        private_key=private_key_utf8_encoded,
    )

    raw_rsa_keyring = mat_prov.create_raw_rsa_keyring(input=keyring_input)

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
    table_config = DynamoDbTableEncryptionConfig(
        logical_table_name=ddb_table_name,
        partition_key_name="partition_key",
        sort_key_name="sort_key",
        attribute_actions_on_encrypt=attribute_actions,
        keyring=raw_rsa_keyring,
        allowed_unsigned_attribute_prefix=unsign_attr_prefix,
    )

    table_configs = {ddb_table_name: table_config}
    tables_config = DynamoDbTablesEncryptionConfig(table_encryption_configs=table_configs)

    # 6. Create the EncryptedClient
    ddb_client = boto3.client("dynamodb")
    encrypted_ddb_client = EncryptedClient(client=ddb_client, encryption_config=tables_config)

    # 7. Put an item into our table using the above client.
    #    Before the item gets sent to DynamoDb, it will be encrypted
    #    client-side using the Raw RSA keyring.
    item = {
        "partition_key": {"S": "rawRsaKeyringItem"},
        "sort_key": {"N": "0"},
        "sensitive_data": {"S": "encrypt and sign me!"},
    }

    put_response = encrypted_ddb_client.put_item(TableName=ddb_table_name, Item=item)

    # Demonstrate that PutItem succeeded
    assert put_response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # 8. Get the item back from our table using the same client.
    #    The client will decrypt the item client-side using the Raw RSA keyring
    #    and return the original item.
    key_to_get = {"partition_key": {"S": "rawRsaKeyringItem"}, "sort_key": {"N": "0"}}

    get_response = encrypted_ddb_client.get_item(TableName=ddb_table_name, Key=key_to_get)

    # Demonstrate that GetItem succeeded and returned the decrypted item
    assert get_response["ResponseMetadata"]["HTTPStatusCode"] == 200
    returned_item = get_response["Item"]
    assert returned_item["sensitive_data"]["S"] == "encrypt and sign me!"


def should_generate_new_rsa_key_pair() -> bool:
    """
    Check if we need to generate a new RSA key pair.

    :return: True if we need to generate a new key pair, False otherwise
    """
    # Check if a key pair already exists
    private_key_file = os.path.exists(EXAMPLE_RSA_PRIVATE_KEY_FILENAME)
    public_key_file = os.path.exists(EXAMPLE_RSA_PUBLIC_KEY_FILENAME)

    # If a key pair already exists: do not overwrite existing key pair
    if private_key_file and public_key_file:
        return False

    # If only one file is present: throw exception
    if private_key_file and not public_key_file:
        raise ValueError(f"Missing public key file at {EXAMPLE_RSA_PUBLIC_KEY_FILENAME}")
    if not private_key_file and public_key_file:
        raise ValueError(f"Missing private key file at {EXAMPLE_RSA_PRIVATE_KEY_FILENAME}")

    # If neither file is present, generate a new key pair
    return True


def generate_rsa_key_pair():
    """Generate a new RSA key pair and save to PEM files."""
    # Safety check: Validate neither file is present
    if os.path.exists(EXAMPLE_RSA_PRIVATE_KEY_FILENAME) or os.path.exists(EXAMPLE_RSA_PUBLIC_KEY_FILENAME):
        raise FileExistsError("generateRsaKeyPair will not overwrite existing PEM files")

    # This code will generate a new RSA key pair for example use.
    # The public and private key will be written to the files:
    #  - public: EXAMPLE_RSA_PUBLIC_KEY_FILENAME
    #  - private: EXAMPLE_RSA_PRIVATE_KEY_FILENAME
    # In practice, you should not generate this in your code, and should instead
    # retrieve this key from a secure key management system (e.g. HSM)
    # This key is created here for example purposes only.
    private_key = rsa.generate_private_key(public_exponent=65537, key_size=2048)

    # Write private key PEM file
    private_key_pem = private_key.private_bytes(
        encoding=serialization.Encoding.PEM,
        format=serialization.PrivateFormat.PKCS8,
        encryption_algorithm=serialization.NoEncryption(),
    )

    try:
        with open(EXAMPLE_RSA_PRIVATE_KEY_FILENAME, "wb") as f:
            f.write(private_key_pem)
    except IOError as e:
        raise OSError("IOError while writing private key PEM") from e

    # Write public key PEM file
    public_key = private_key.public_key()
    public_key_pem = public_key.public_bytes(
        encoding=serialization.Encoding.PEM, format=serialization.PublicFormat.SubjectPublicKeyInfo
    )

    try:
        with open(EXAMPLE_RSA_PUBLIC_KEY_FILENAME, "wb") as f:
            f.write(public_key_pem)
    except IOError as e:
        raise RuntimeError("IOError while writing public key PEM") from e
