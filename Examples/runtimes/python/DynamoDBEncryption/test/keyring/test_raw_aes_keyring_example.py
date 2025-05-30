# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""Test raw AES keyring example."""
import secrets

import pytest

from ...src.keyring.raw_aes_keyring_example import raw_aes_keyring_get_item_put_item
from ..test_utils import TEST_DDB_TABLE_NAME

pytestmark = [pytest.mark.examples]


def test_raw_aes_keyring_example():
    """Test raw_aes_keyring_example."""
    # Generate a new AES key
    aes_key_bytes = secrets.token_bytes(32)  # 32 bytes = 256 bits

    raw_aes_keyring_get_item_put_item(TEST_DDB_TABLE_NAME, aes_key_bytes)
