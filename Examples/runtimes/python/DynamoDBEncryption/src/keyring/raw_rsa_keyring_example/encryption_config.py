# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""
Configuration module for raw RSA keyring encryption setup.

This module provides the common encryption configuration used by both
EncryptedClient and EncryptedTable examples.
"""

from aws_cryptographic_material_providers.mpl import AwsCryptographicMaterialProviders
from aws_cryptographic_material_providers.mpl.config import MaterialProvidersConfig
from aws_cryptographic_material_providers.mpl.models import (
    CreateRawRsaKeyringInput,
    PaddingScheme,
)
from aws_dbesdk_dynamodb.structures.dynamodb import (
    DynamoDbTableEncryptionConfig,
    DynamoDbTablesEncryptionConfig,
)
from aws_dbesdk_dynamodb.structures.structured_encryption import (
    CryptoAction,
)


def create_encryption_config(
    ddb_table_name: str, public_key_utf8_encoded: bytes, private_key_utf8_encoded: bytes
) -> DynamoDbTablesEncryptionConfig:
    """
    Create the encryption configuration for DynamoDB encryption using raw RSA keyring.

    :param ddb_table_name: The name of the DynamoDB table
    :param public_key_utf8_encoded: The UTF-8 encoded PEM format public key
    :param private_key_utf8_encoded: The UTF-8 encoded PEM format private key
    :return: The DynamoDB tables encryption configuration
    """
    # 1. Create the keyring.
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

    # 2. Configure which attributes are encrypted and/or signed when writing new items.
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

    # 3. Configure which attributes we expect to be included in the signature
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

    # 4. Create the DynamoDb Encryption configuration for the table we will be writing to.
    table_config = DynamoDbTableEncryptionConfig(
        logical_table_name=ddb_table_name,
        partition_key_name="partition_key",
        sort_key_name="sort_key",
        attribute_actions_on_encrypt=attribute_actions,
        keyring=raw_rsa_keyring,
        allowed_unsigned_attribute_prefix=unsign_attr_prefix,
    )

    table_configs = {ddb_table_name: table_config}
    return DynamoDbTablesEncryptionConfig(table_encryption_configs=table_configs)
