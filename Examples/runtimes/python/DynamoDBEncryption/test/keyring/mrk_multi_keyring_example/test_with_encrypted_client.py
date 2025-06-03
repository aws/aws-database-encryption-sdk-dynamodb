# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""Test MRK multi-keyring with encrypted client examples."""
import pytest

from ....src.keyring.mrk_multi_keyring_example.with_encrypted_client import (
    multi_mrk_keyring_client_example,
)
from ...test_utils import (
    TEST_DDB_TABLE_NAME,
    TEST_KMS_KEY_ID,
    TEST_MRK_KEY_ID,
    TEST_MRK_REPLICA_KEY_ID_US_EAST_1,
)

pytestmark = [pytest.mark.examples]


def test_multi_mrk_keyring_client_example():
    """Test multi_mrk_keyring_client_example."""
    multi_mrk_keyring_client_example(
        TEST_DDB_TABLE_NAME, TEST_MRK_KEY_ID, TEST_KMS_KEY_ID, TEST_MRK_REPLICA_KEY_ID_US_EAST_1
    )
