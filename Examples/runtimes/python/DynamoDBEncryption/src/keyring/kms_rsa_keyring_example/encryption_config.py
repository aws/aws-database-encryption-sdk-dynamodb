# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""
Configuration module for KMS RSA keyring encryption setup.

This module provides the common encryption configuration used by both
EncryptedClient and EncryptedTable examples.
"""

import boto3
from aws_cryptographic_material_providers.mpl import AwsCryptographicMaterialProviders
from aws_cryptographic_material_providers.mpl.config import MaterialProvidersConfig
from aws_cryptographic_material_providers.mpl.models import (
    CreateAwsKmsRsaKeyringInput,
    DBEAlgorithmSuiteId,
)
from aws_dbesdk_dynamodb.structures.dynamodb import (
    DynamoDbTableEncryptionConfig,
    DynamoDbTablesEncryptionConfig,
)
from aws_dbesdk_dynamodb.structures.structured_encryption import (
    CryptoAction,
)


def create_encryption_config(
    ddb_table_name: str, rsa_key_arn: str, public_key_utf8_encoded: bytes
) -> DynamoDbTablesEncryptionConfig:
    """
    Create the encryption configuration for DynamoDB encryption using KMS RSA keyring.

    :param ddb_table_name: The name of the DynamoDB table
    :param rsa_key_arn: ARN of the KMS RSA key
    :param public_key_utf8_encoded: UTF-8 encoded public key in PEM format
    :return: The DynamoDB tables encryption configuration
    """
    # 1. Create a KMS RSA keyring.
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
    return DynamoDbTablesEncryptionConfig(table_encryption_configs=table_configs)
