# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""Test MRK multi-keyring example."""
import pytest

from ...src.keyring.mrk_multi_keyring_example import multi_mrk_keyring_get_item_put_item
from ..test_utils import (
    TEST_DDB_TABLE_NAME,
    TEST_KMS_KEY_ID,
    TEST_MRK_KEY_ID,
    TEST_MRK_REPLICA_KEY_ID_US_EAST_1,
)

pytestmark = [pytest.mark.examples]


def test_mrk_multi_keyring_example():
    """Test mrk_multi_keyring_example."""
    multi_mrk_keyring_get_item_put_item(
        TEST_DDB_TABLE_NAME, TEST_MRK_KEY_ID, TEST_KMS_KEY_ID, TEST_MRK_REPLICA_KEY_ID_US_EAST_1
    )
