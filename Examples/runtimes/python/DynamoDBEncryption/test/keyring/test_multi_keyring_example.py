# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""Test multi-keyring example."""
import secrets

import pytest

from ...src.keyring.multi_keyring_example import multi_keyring_get_item_put_item
from ..test_utils import TEST_DDB_TABLE_NAME, TEST_KMS_KEY_ID

pytestmark = [pytest.mark.examples]


def test_multi_keyring_example():
    """Test multi_keyring_example."""
    # Generate a new AES key
    aes_key_bytes = secrets.token_bytes(32)  # 32 bytes = 256 bits

    multi_keyring_get_item_put_item(TEST_DDB_TABLE_NAME, TEST_KMS_KEY_ID, aes_key_bytes)
