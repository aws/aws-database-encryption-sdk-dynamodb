# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""Test create key store table example."""
import pytest

from ..src.create_keystore_table_example import keystore_create_table
from .test_utils import TEST_KEYSTORE_KMS_KEY_ID, TEST_KEYSTORE_NAME, TEST_LOGICAL_KEYSTORE_NAME

pytestmark = [pytest.mark.examples]


def test_create_keystore_table_example():
    """Test create_key_store_table_example."""
    keystore_create_table(TEST_KEYSTORE_NAME, TEST_LOGICAL_KEYSTORE_NAME, TEST_KEYSTORE_KMS_KEY_ID)
