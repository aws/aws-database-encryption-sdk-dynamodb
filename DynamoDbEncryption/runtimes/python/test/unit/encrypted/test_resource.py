# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
from mock import MagicMock

from aws_dbesdk_dynamodb.encrypted.resource import EncryptedResource, EncryptedTablesCollectionManager


def test_WHEN_boto3_client_attr_name_THEN_returns_expected_value():
    # Given: EncryptedResource
    assert EncryptedResource(resource=MagicMock(), encryption_config=MagicMock())._boto_client_attr_name == "_resource"
    # And: EncryptedTablesCollectionManager
    assert (
        EncryptedTablesCollectionManager(collection=MagicMock(), encryption_config=MagicMock())._boto_client_attr_name
        == "_collection"
    )
