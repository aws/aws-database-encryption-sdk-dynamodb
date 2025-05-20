# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""Test suite for the EncryptedPaginator example."""
import pytest

from ...src.encrypted_paginator.encrypted_paginator_example import encrypted_paginator_example

pytestmark = [pytest.mark.examples]


def test_encrypted_paginator_example():
    """Test function for encrypt and decrypt using the EncryptedPaginator example."""
    test_kms_key_id = "arn:aws:kms:us-west-2:658956600833:key/b3537ef1-d8dc-4780-9f5a-55776cbb2f7f"
    test_dynamodb_table_name = "DynamoDbEncryptionInterceptorTestTable"
    encrypted_paginator_example(test_kms_key_id, test_dynamodb_table_name)
