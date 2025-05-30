# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""Test for the Raw RSA keyring example."""
import pytest

from ...src.keyring.raw_rsa_keyring_example import (
    generate_rsa_key_pair,
    raw_rsa_keyring_example,
    should_generate_new_rsa_key_pair,
)
from ..test_utils import TEST_DDB_TABLE_NAME

pytestmark = [pytest.mark.examples]


def test_raw_rsa_keyring_example():
    """Test the Raw RSA keyring example."""
    # You may provide your own RSA key pair in the files located at
    #  - EXAMPLE_RSA_PRIVATE_KEY_FILENAME
    #  - EXAMPLE_RSA_PUBLIC_KEY_FILENAME
    # If these files are not present, this will generate a pair for you
    if should_generate_new_rsa_key_pair():
        generate_rsa_key_pair()

    raw_rsa_keyring_example(TEST_DDB_TABLE_NAME)
