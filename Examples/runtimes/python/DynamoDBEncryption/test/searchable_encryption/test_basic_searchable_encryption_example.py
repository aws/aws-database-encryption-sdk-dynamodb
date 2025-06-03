# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""Test basic searchable encryption example."""
import time

import pytest

from ...src.create_keystore_key_example import keystore_create_key
from ...src.searchable_encryption.basic_searchable_encryption_example import put_item_query_item_with_beacon
from ..cleanup import delete_branch_key
from .searchable_encryption_test_utils import (
    TEST_BRANCH_KEY_WRAPPING_KMS_KEY_ARN,
    TEST_BRANCH_KEYSTORE_DDB_TABLE_NAME,
    TEST_LOGICAL_KEYSTORE_NAME,
    UNIT_INSPECTION_TEST_DDB_TABLE_NAME,
)

pytestmark = [pytest.mark.examples]


def test_basic_example():
    """Test basic searchable encryption example."""
    # Create new branch key for test
    key_id = keystore_create_key(
        TEST_BRANCH_KEYSTORE_DDB_TABLE_NAME, TEST_LOGICAL_KEYSTORE_NAME, TEST_BRANCH_KEY_WRAPPING_KMS_KEY_ARN
    )

    # Key creation is eventually consistent, so wait 5 seconds to decrease the likelihood
    # our test fails due to eventual consistency issues.
    time.sleep(5)

    put_item_query_item_with_beacon(
        UNIT_INSPECTION_TEST_DDB_TABLE_NAME,
        key_id,
        TEST_BRANCH_KEY_WRAPPING_KMS_KEY_ARN,
        TEST_BRANCH_KEYSTORE_DDB_TABLE_NAME,
    )

    # Cleanup Branch Key
    delete_branch_key(key_id, TEST_BRANCH_KEYSTORE_DDB_TABLE_NAME, None)
