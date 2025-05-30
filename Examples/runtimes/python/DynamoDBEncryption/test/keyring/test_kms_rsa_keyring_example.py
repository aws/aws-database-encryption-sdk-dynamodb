# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""Test for the KMS RSA keyring example."""
import pytest

from ...src.keyring.kms_rsa_keyring_example import (
    kms_rsa_keyring_example,
    should_get_new_public_key,
    write_public_key_pem_for_rsa_key,
)
from ..test_utils import (
    TEST_DDB_TABLE_NAME,
    TEST_KMS_RSA_KEY_ID,
)

pytestmark = [pytest.mark.examples]


def test_kms_rsa_keyring_example():
    """Test the KMS RSA keyring example."""
    # You may provide your own RSA public key at EXAMPLE_RSA_PUBLIC_KEY_FILENAME.
    # This must be the public key for the RSA key represented at rsa_key_arn.
    # If this file is not present, this will write a UTF-8 encoded PEM file for you.
    if should_get_new_public_key():
        write_public_key_pem_for_rsa_key(TEST_KMS_RSA_KEY_ID)

    kms_rsa_keyring_example(TEST_DDB_TABLE_NAME, TEST_KMS_RSA_KEY_ID)
