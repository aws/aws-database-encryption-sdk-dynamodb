# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
import pytest
from mock import MagicMock

from aws_database_encryption_sdk.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models import (
    DynamoDbTablesEncryptionConfig,
)
from aws_database_encryption_sdk.encrypted.client import (
    EncryptedPaginator,
)

from botocore.client import BaseClient

pytestmark = [pytest.mark.unit, pytest.mark.local]

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
