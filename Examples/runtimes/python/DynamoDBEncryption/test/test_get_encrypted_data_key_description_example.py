# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""Test get encrypted data key description example."""
import pytest

from ..src.get_encrypted_data_key_description_example import get_encrypted_data_key_description
from .test_utils import (
    TEST_DDB_TABLE_NAME,
    TEST_KMS_KEY_ID,
)

pytestmark = [pytest.mark.examples]


def test_get_encrypted_data_key_description():
    """Test get encrypted data key description example."""
    get_encrypted_data_key_description(
        TEST_DDB_TABLE_NAME,
        "partition_key",
        "BasicPutGetExample",
        "sort_key",
        "0",
        "aws-kms",
        TEST_KMS_KEY_ID,
        None,
        None,
    )
