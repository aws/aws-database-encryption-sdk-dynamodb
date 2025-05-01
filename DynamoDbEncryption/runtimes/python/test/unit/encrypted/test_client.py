# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""High-level helper class to provide an encrypting wrapper for boto3 DynamoDB clients."""
from botocore.paginate import Paginator
import botocore.client
from typing import Callable, Optional
import inspect
import pytest
from mock import MagicMock
from aws_dbesdk_dynamodb.encrypted.client import (
    EncryptedClient,
)

from aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models import (
    DynamoDbTablesEncryptionConfig,
)
from botocore.client import BaseClient

mock_boto3_dynamodb_client = MagicMock(__class__=BaseClient)
mock_tables_encryption_config = MagicMock(__class__=DynamoDbTablesEncryptionConfig)


def test_GIVEN_valid_inputs_WHEN_create_EncryptedClient_THEN_success():
    # Given: Valid EncryptedClient inputs
    # When: Create EncryptedClient
    EncryptedClient(
        client=mock_boto3_dynamodb_client,
        encryption_config=mock_tables_encryption_config,
    )
    # Then: Success


def test_GIVEN_invalid_class_attribute_WHEN_getattr_THEN_raise_error():
    some_unknown_attribute = "not_a_valid_attribute_on_EncryptedClient_nor_boto3_client"

    # Create a mock with a specific spec that excludes our unknown attribute
    mock_boto3_dynamodb_client = MagicMock(spec=["put_item", "get_item", "query", "scan"])
    encrypted_client = EncryptedClient(
        client=mock_boto3_dynamodb_client,
        encryption_config=mock_tables_encryption_config,
    )

    # Then: AttributeError is raised
    with pytest.raises(AttributeError):
        # Given: Invalid class attribute: not_a_valid_attribute_on_EncryptedClient_nor_boto3_client
        # When: getattr is called
        encrypted_client.not_a_valid_attribute_on_EncryptedClient_nor_boto3_client()
