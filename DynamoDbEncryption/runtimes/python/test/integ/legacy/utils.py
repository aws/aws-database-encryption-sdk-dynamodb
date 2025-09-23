# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
import uuid

import boto3
from dynamodb_encryption_sdk.encrypted.client import EncryptedClient as LegacyEncryptedClient
from dynamodb_encryption_sdk.encrypted.resource import EncryptedResource as LegacyEncryptedResource
from dynamodb_encryption_sdk.encrypted.table import EncryptedTable as LegacyEncryptedTable
from dynamodb_encryption_sdk.identifiers import CryptoAction
from dynamodb_encryption_sdk.material_providers.aws_kms import AwsKmsCryptographicMaterialsProvider
from dynamodb_encryption_sdk.structures import AttributeActions

from aws_dbesdk_dynamodb.encrypted.client import EncryptedClient
from aws_dbesdk_dynamodb.encrypted.resource import EncryptedResource
from aws_dbesdk_dynamodb.encrypted.table import EncryptedTable
from aws_dbesdk_dynamodb.structures.dynamodb import (
    DynamoDbTableEncryptionConfig,
    DynamoDbTablesEncryptionConfig,
    LegacyOverride,
)

from ...constants import (
    INTEG_TEST_DEFAULT_ALGORITHM_SUITE_ID,
    INTEG_TEST_DEFAULT_ATTRIBUTE_ACTIONS_ON_ENCRYPT,
    INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME,
    INTEG_TEST_DEFAULT_KEYRING,
    INTEG_TEST_DEFAULT_KMS_KEY_ID,
    INTEG_TEST_DEFAULT_UNSIGNED_ATTRIBUTE_PREFIX,
)


def generate_unique_suffix():
    """Generate a unique suffix for test items."""
    return "-" + str(uuid.uuid4())


# Legacy Attribute Actions
def legacy_actions():
    return AttributeActions(
        default_action=CryptoAction.ENCRYPT_AND_SIGN,
        attribute_actions={
            "partition_key": CryptoAction.SIGN_ONLY,
            "sort_key": CryptoAction.SIGN_ONLY,
            "attribute1": CryptoAction.ENCRYPT_AND_SIGN,
            "attribute2": CryptoAction.SIGN_ONLY,
            ":attribute3": CryptoAction.DO_NOTHING,
        },
    )


# Legacy interface creation functions


def create_legacy_encrypted_client(attribute_actions=None, expect_standard_dictionaries=False):
    """Create a legacy DynamoDB encrypted client."""
    cmp = AwsKmsCryptographicMaterialsProvider(key_id=INTEG_TEST_DEFAULT_KMS_KEY_ID)
    return LegacyEncryptedClient(
        client=plaintext_client(expect_standard_dictionaries),
        materials_provider=cmp,
        attribute_actions=attribute_actions,
        expect_standard_dictionaries=expect_standard_dictionaries,
    )


def create_legacy_encrypted_table(attribute_actions=None):
    """Create a legacy DynamoDB encrypted table."""
    plaintext_table = boto3.resource("dynamodb").Table(INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME)
    cmp = AwsKmsCryptographicMaterialsProvider(key_id=INTEG_TEST_DEFAULT_KMS_KEY_ID)
    return LegacyEncryptedTable(
        table=plaintext_table,
        materials_provider=cmp,
        attribute_actions=attribute_actions,
    )


def create_legacy_encrypted_resource(attribute_actions=None):
    """Create a legacy DynamoDB encrypted resource."""
    plaintext_resource = boto3.resource("dynamodb")
    cmp = AwsKmsCryptographicMaterialsProvider(key_id=INTEG_TEST_DEFAULT_KMS_KEY_ID)
    return LegacyEncryptedResource(
        resource=plaintext_resource,
        materials_provider=cmp,
        attribute_actions=attribute_actions,
    )


# AWS DBE SDK interface creation functions with legacy override


def create_encryption_config(legacy_encryptor, legacy_policy):
    """Create a DynamoDbTableEncryptionConfig with optional legacy override."""
    # Configure legacy behavior
    legacy_override = LegacyOverride(
        encryptor=legacy_encryptor,
        attribute_actions_on_encrypt=INTEG_TEST_DEFAULT_ATTRIBUTE_ACTIONS_ON_ENCRYPT,
        policy=legacy_policy,
    )

    # Create the table config with legacy override
    table_config = DynamoDbTableEncryptionConfig(
        logical_table_name=INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME,
        partition_key_name="partition_key",
        sort_key_name="sort_key",
        attribute_actions_on_encrypt=INTEG_TEST_DEFAULT_ATTRIBUTE_ACTIONS_ON_ENCRYPT,
        keyring=INTEG_TEST_DEFAULT_KEYRING,
        legacy_override=legacy_override,
        allowed_unsigned_attribute_prefix=INTEG_TEST_DEFAULT_UNSIGNED_ATTRIBUTE_PREFIX,
        algorithm_suite_id=INTEG_TEST_DEFAULT_ALGORITHM_SUITE_ID,
    )

    # Create the tables config
    table_configs = {INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME: table_config}
    return DynamoDbTablesEncryptionConfig(table_encryption_configs=table_configs)


def plaintext_client(expect_standard_dictionaries):
    if expect_standard_dictionaries:
        client = boto3.resource("dynamodb").Table(INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME).meta.client
    else:
        client = boto3.client("dynamodb")
    return client


def encrypted_client_with_legacy_override(
    legacy_encryptor=None, legacy_policy=None, expect_standard_dictionaries=False
):
    """Create an AWS Database Encryption SDK client with optional legacy override."""
    tables_config = create_encryption_config(legacy_encryptor=legacy_encryptor, legacy_policy=legacy_policy)

    # Create the EncryptedClient
    return EncryptedClient(
        client=plaintext_client(expect_standard_dictionaries),
        encryption_config=tables_config,
        expect_standard_dictionaries=expect_standard_dictionaries,
    )


def encrypted_table_with_legacy_override(legacy_encryptor=None, legacy_policy=None):
    """Create an AWS Database Encryption SDK table from a client."""
    tables_config = create_encryption_config(legacy_encryptor=legacy_encryptor, legacy_policy=legacy_policy)

    # Create the EncryptedTable
    table = boto3.resource("dynamodb").Table(INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME)
    return EncryptedTable(
        table=table,
        encryption_config=tables_config,
    )


def encrypted_resource_with_legacy_override(legacy_encryptor=None, legacy_policy=None):
    """Create an AWS Database Encryption SDK resource with optional legacy override."""
    tables_config = create_encryption_config(legacy_encryptor=legacy_encryptor, legacy_policy=legacy_policy)

    # Create the EncryptedResource
    return EncryptedResource(
        resource=boto3.resource("dynamodb"),
        encryption_config=tables_config,
    )
