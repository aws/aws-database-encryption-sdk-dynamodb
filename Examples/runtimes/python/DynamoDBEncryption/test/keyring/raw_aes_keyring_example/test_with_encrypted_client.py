# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""Test raw AES keyring with encrypted client example."""
import secrets

import pytest

from ....src.keyring.raw_aes_keyring_example.with_encrypted_client import raw_aes_keyring_client_example
from ...test_utils import TEST_DDB_TABLE_NAME

pytestmark = [pytest.mark.examples]


def test_raw_aes_keyring_client_example():
    """Test raw_aes_keyring_client_example."""
    # Generate a new AES key
    aes_key_bytes = secrets.token_bytes(32)  # 32 bytes = 256 bits

    raw_aes_keyring_client_example(TEST_DDB_TABLE_NAME, aes_key_bytes)
