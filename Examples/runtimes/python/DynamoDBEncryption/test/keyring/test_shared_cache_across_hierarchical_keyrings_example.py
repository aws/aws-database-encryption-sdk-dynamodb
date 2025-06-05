# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""Test for the shared cache across hierarchical keyrings example."""
import time

import pytest

from ...src.create_keystore_key_example import keystore_create_key
from ...src.keyring.shared_cache_across_hierarchical_keyrings_example import (
    shared_cache_across_hierarchical_keyrings_example,
)
from ..cleanup import delete_branch_key
from ..test_utils import (
    TEST_DDB_TABLE_NAME,
    TEST_KEYSTORE_KMS_KEY_ID,
    TEST_KEYSTORE_NAME,
    TEST_LOGICAL_KEYSTORE_NAME,
    TEST_PARTITION_ID,
)

pytestmark = [pytest.mark.examples]


def test_shared_cache_across_hierarchical_keyrings_example():
    """Test the shared cache across hierarchical keyrings example."""
    # Create new branch key for test
    key_id = keystore_create_key(TEST_KEYSTORE_NAME, TEST_LOGICAL_KEYSTORE_NAME, TEST_KEYSTORE_KMS_KEY_ID)

    # Key creation is eventually consistent, so wait 5 seconds to decrease the likelihood
    # our test fails due to eventual consistency issues.
    time.sleep(5)

    shared_cache_across_hierarchical_keyrings_example(
        TEST_DDB_TABLE_NAME,
        key_id,
        TEST_KEYSTORE_NAME,
        TEST_LOGICAL_KEYSTORE_NAME,
        TEST_PARTITION_ID,
        TEST_KEYSTORE_KMS_KEY_ID,
    )

    # Cleanup Branch Key
    delete_branch_key(key_id, TEST_KEYSTORE_NAME, None)
