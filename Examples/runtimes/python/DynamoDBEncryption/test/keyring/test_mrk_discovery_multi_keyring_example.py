# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""Test MRK discovery multi-keyring example."""
import pytest

from ...src.keyring.mrk_discovery_multi_keyring_example import multi_mrk_discovery_keyring_get_item_put_item
from ..test_utils import (
    TEST_AWS_ACCOUNT_ID,
    TEST_AWS_REGION,
    TEST_DDB_TABLE_NAME,
    TEST_MRK_KEY_ID,
)

pytestmark = [pytest.mark.examples]


def test_mrk_discovery_multi_keyring_example():
    """Test mrk_discovery_multi_keyring_example."""
    accounts = [TEST_AWS_ACCOUNT_ID]
    regions = [TEST_AWS_REGION]

    multi_mrk_discovery_keyring_get_item_put_item(TEST_DDB_TABLE_NAME, TEST_MRK_KEY_ID, accounts, regions)
