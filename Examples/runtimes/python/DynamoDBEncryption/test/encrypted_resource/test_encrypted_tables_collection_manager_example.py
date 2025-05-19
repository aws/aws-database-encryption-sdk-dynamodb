# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""Test suite for the EncryptedResource batch read/write example."""
import pytest

from ...src.encrypted_resource.encrypted_tables_collection_manager_example import encrypted_tables_collection_manager_example

pytestmark = [pytest.mark.examples]


def test_encrypted_resource_batch_read_write_example():
    """Test function for encrypt and decrypt using the EncryptedClient example."""
    test_kms_key_id = "arn:aws:kms:us-west-2:658956600833:key/b3537ef1-d8dc-4780-9f5a-55776cbb2f7f"
    test_dynamodb_table_name = "DynamoDbEncryptionInterceptorTestTable"
    encrypted_tables_collection_manager_example(test_kms_key_id, [test_dynamodb_table_name])
