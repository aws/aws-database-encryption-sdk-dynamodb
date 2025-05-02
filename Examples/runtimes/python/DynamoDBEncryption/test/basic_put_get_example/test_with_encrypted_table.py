# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""Test suite for the EncryptedClient example."""
import pytest

from ...src.basic_put_get_example.with_encrypted_table import encrypted_table_put_get_example

pytestmark = [pytest.mark.examples]


def test_encrypted_table_put_get_example():
    """Test function for encrypt and decrypt using the EncryptedClient example."""
    test_kms_key_id = "arn:aws:kms:us-west-2:658956600833:key/b3537ef1-d8dc-4780-9f5a-55776cbb2f7f"
    test_dynamodb_table_name = "DynamoDbEncryptionInterceptorTestTable"
    encrypted_table_put_get_example(test_kms_key_id, test_dynamodb_table_name)
