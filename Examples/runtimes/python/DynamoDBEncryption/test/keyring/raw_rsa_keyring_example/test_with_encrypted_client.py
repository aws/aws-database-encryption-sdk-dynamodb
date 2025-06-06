# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""Test raw RSA keyring with encrypted client example."""
import pytest

from ....src.keyring.raw_rsa_keyring_example.utility import (
    EXAMPLE_RSA_PRIVATE_KEY_FILENAME,
    EXAMPLE_RSA_PUBLIC_KEY_FILENAME,
    generate_rsa_key_pair,
    should_generate_new_rsa_key_pair,
)
from ....src.keyring.raw_rsa_keyring_example.with_encrypted_client import raw_rsa_keyring_client_example
from ...test_utils import TEST_DDB_TABLE_NAME

pytestmark = [pytest.mark.examples]


def test_raw_rsa_keyring_client_example():
    """Test raw_rsa_keyring_client_example."""
    # You may provide your own RSA key pair in the files located at
    #  - EXAMPLE_RSA_PRIVATE_KEY_FILENAME
    #  - EXAMPLE_RSA_PUBLIC_KEY_FILENAME
    # If these files are not present, this will generate a pair for you
    if should_generate_new_rsa_key_pair():
        generate_rsa_key_pair()

    raw_rsa_keyring_client_example(
        TEST_DDB_TABLE_NAME, EXAMPLE_RSA_PRIVATE_KEY_FILENAME, EXAMPLE_RSA_PUBLIC_KEY_FILENAME
    )
