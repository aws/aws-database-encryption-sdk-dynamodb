# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""Test virtual beacon searchable encryption example."""
import time

import pytest

from ....src.create_keystore_key_example import keystore_create_key
from ....src.searchable_encryption.virtual_beacon_searchable_encryption_example.with_encrypted_table import (
    virtual_beacon_table_example,
)
from ...cleanup import delete_branch_key
from ..searchable_encryption_test_utils import (
    SIMPLE_BEACON_TEST_DDB_TABLE_NAME,
    TEST_BRANCH_KEY_WRAPPING_KMS_KEY_ARN,
    TEST_BRANCH_KEYSTORE_DDB_TABLE_NAME,
    TEST_LOGICAL_KEYSTORE_NAME,
)

pytestmark = [pytest.mark.examples]


def test_virtual_beacon_table_example():
    """Test virtual beacon searchable encryption example."""
    # Create new branch key for test
    key_id = keystore_create_key(
        TEST_BRANCH_KEYSTORE_DDB_TABLE_NAME, TEST_LOGICAL_KEYSTORE_NAME, TEST_BRANCH_KEY_WRAPPING_KMS_KEY_ARN
    )

    # Key creation is eventually consistent, so wait 5 seconds to decrease the likelihood
    # our test fails due to eventual consistency issues.
    time.sleep(5)

    virtual_beacon_table_example(
        SIMPLE_BEACON_TEST_DDB_TABLE_NAME,
        key_id,
        TEST_BRANCH_KEY_WRAPPING_KMS_KEY_ARN,
        TEST_BRANCH_KEYSTORE_DDB_TABLE_NAME,
    )

    # Cleanup Branch Key
    delete_branch_key(key_id, TEST_BRANCH_KEYSTORE_DDB_TABLE_NAME, None)
