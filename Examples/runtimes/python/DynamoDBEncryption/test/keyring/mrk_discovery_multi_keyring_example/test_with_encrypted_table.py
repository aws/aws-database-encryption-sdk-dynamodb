# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""Test MRK discovery multi-keyring with encrypted table examples."""
import pytest

from ....src.keyring.mrk_discovery_multi_keyring_example.with_encrypted_table import (
    multi_mrk_discovery_keyring_table_example,
)
from ...test_utils import (
    TEST_AWS_ACCOUNT_ID,
    TEST_AWS_REGION,
    TEST_DDB_TABLE_NAME,
    TEST_MRK_KEY_ID,
)

pytestmark = [pytest.mark.examples]


def test_multi_mrk_discovery_keyring_table_example():
    """Test multi_mrk_discovery_keyring_table_example."""
    accounts = [TEST_AWS_ACCOUNT_ID]
    regions = [TEST_AWS_REGION]

    multi_mrk_discovery_keyring_table_example(TEST_DDB_TABLE_NAME, TEST_MRK_KEY_ID, accounts, regions)
