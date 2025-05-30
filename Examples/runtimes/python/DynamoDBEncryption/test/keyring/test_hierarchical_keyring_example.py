# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""Test hierarchical keyring example."""
import time

import pytest

from ...src.create_keystore_key_example import keystore_create_key
from ...src.keyring.hierarchical_keyring_example import hierarchical_keyring_get_item_put_item
from ..cleanup import delete_branch_key
from ..test_utils import (
    TEST_DDB_TABLE_NAME,
    TEST_KEYSTORE_KMS_KEY_ID,
    TEST_KEYSTORE_NAME,
    TEST_LOGICAL_KEYSTORE_NAME,
)

pytestmark = [pytest.mark.examples]


def test_hierarchical_keyring_example():
    """Test hierarchical_keyring_example."""
    # Create new branch keys for test
    key_id1 = keystore_create_key(TEST_KEYSTORE_NAME, TEST_LOGICAL_KEYSTORE_NAME, TEST_KEYSTORE_KMS_KEY_ID)
    key_id2 = keystore_create_key(TEST_KEYSTORE_NAME, TEST_LOGICAL_KEYSTORE_NAME, TEST_KEYSTORE_KMS_KEY_ID)

    # Key creation is eventually consistent, so wait 5 seconds to decrease the likelihood
    # our test fails due to eventual consistency issues.
    time.sleep(5)

    hierarchical_keyring_get_item_put_item(
        TEST_DDB_TABLE_NAME, key_id1, key_id2, TEST_KEYSTORE_NAME, TEST_LOGICAL_KEYSTORE_NAME, TEST_KEYSTORE_KMS_KEY_ID
    )

    # Cleanup Branch Key
    delete_branch_key(key_id1, TEST_KEYSTORE_NAME, None)
    delete_branch_key(key_id2, TEST_KEYSTORE_NAME, None)
