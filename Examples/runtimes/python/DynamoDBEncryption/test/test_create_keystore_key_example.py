# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""Test create key store key example."""
import pytest

from ..src.create_keystore_key_example import keystore_create_key
from .cleanup import delete_branch_key
from .test_utils import TEST_KEYSTORE_KMS_KEY_ID, TEST_KEYSTORE_NAME, TEST_LOGICAL_KEYSTORE_NAME

pytestmark = [pytest.mark.examples]


def test_create_keystore_key_example():
    """Test create_key_store_key_example."""
    key_id = keystore_create_key(TEST_KEYSTORE_NAME, TEST_LOGICAL_KEYSTORE_NAME, TEST_KEYSTORE_KMS_KEY_ID)

    assert key_id is not None

    # Cleanup Branch Key
    delete_branch_key(key_id, TEST_KEYSTORE_NAME, None)
