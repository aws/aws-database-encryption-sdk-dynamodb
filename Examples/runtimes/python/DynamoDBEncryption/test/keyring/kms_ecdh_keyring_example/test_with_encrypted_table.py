# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""Test KMS ECDH keyring with encrypted table example."""
import pytest

from ....src.keyring.kms_ecdh_keyring_example.utility import (
    EXAMPLE_ECC_PUBLIC_KEY_RECIPIENT_FILENAME,
    EXAMPLE_ECC_PUBLIC_KEY_SENDER_FILENAME,
    should_get_new_public_keys,
    write_public_key_pem_for_ecc_key,
)
from ....src.keyring.kms_ecdh_keyring_example.with_encrypted_table import (
    kms_ecdh_discovery_table_example,
    kms_ecdh_keyring_table_example,
)
from ...test_utils import TEST_DDB_TABLE_NAME, TEST_KMS_ECDH_KEY_ID_P256_RECIPIENT, TEST_KMS_ECDH_KEY_ID_P256_SENDER

pytestmark = [pytest.mark.examples]


def test_kms_ecdh_keyring_table_example_static():
    """Test kms_ecdh_keyring_table_example with static configuration."""
    # You may provide your own ECC public keys at
    # - EXAMPLE_ECC_PUBLIC_KEY_SENDER_FILENAME
    # - EXAMPLE_ECC_PUBLIC_KEY_RECIPIENT_FILENAME.
    # If you provide these, the keys MUST be on curve P256
    # This must be the public key for the ECC key represented at eccKeyArn
    # If this file is not present, this will write a UTF-8 encoded PEM file for you.
    if should_get_new_public_keys():
        write_public_key_pem_for_ecc_key(TEST_KMS_ECDH_KEY_ID_P256_SENDER, EXAMPLE_ECC_PUBLIC_KEY_SENDER_FILENAME)
        write_public_key_pem_for_ecc_key(TEST_KMS_ECDH_KEY_ID_P256_RECIPIENT, EXAMPLE_ECC_PUBLIC_KEY_RECIPIENT_FILENAME)

    kms_ecdh_keyring_table_example(TEST_DDB_TABLE_NAME, TEST_KMS_ECDH_KEY_ID_P256_SENDER)


def test_kms_ecdh_keyring_table_example_discovery():
    """Test kms_ecdh_keyring_table_example with discovery configuration."""
    # In this example you do not need to provide the recipient ECC Public Key.
    # On initialization, the keyring will call KMS:getPublicKey on the configured
    # recipientKmsIdentifier set on the keyring. This example uses the previous example
    # to write an item meant for the recipient.
    # First, we need to run the static example to write the item
    if should_get_new_public_keys():
        write_public_key_pem_for_ecc_key(TEST_KMS_ECDH_KEY_ID_P256_SENDER, EXAMPLE_ECC_PUBLIC_KEY_SENDER_FILENAME)
        write_public_key_pem_for_ecc_key(TEST_KMS_ECDH_KEY_ID_P256_RECIPIENT, EXAMPLE_ECC_PUBLIC_KEY_RECIPIENT_FILENAME)

    kms_ecdh_keyring_table_example(TEST_DDB_TABLE_NAME, TEST_KMS_ECDH_KEY_ID_P256_SENDER)

    # Now test the discovery example
    kms_ecdh_discovery_table_example(TEST_DDB_TABLE_NAME, TEST_KMS_ECDH_KEY_ID_P256_RECIPIENT)
