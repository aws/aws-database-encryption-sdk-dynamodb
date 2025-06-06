# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""Test raw ECDH keyring with encrypted client example."""
import pytest
from aws_cryptography_primitives.smithygenerated.aws_cryptography_primitives.models import ECDHCurveSpec

from ....src.keyring.raw_ecdh_keyring_example.utility import (
    generate_ecc_key_pairs,
    should_generate_new_ecc_key_pairs,
)
from ....src.keyring.raw_ecdh_keyring_example.with_encrypted_client import (
    discovery_raw_ecdh_keyring_get_item_with_ecnrypted_client,
    ephemeral_raw_ecdh_keyring_put_item_with_ecnrypted_client,
    raw_ecdh_keyring_get_item_put_item_with_encrypted_client,
)
from ...test_utils import TEST_DDB_TABLE_NAME

pytestmark = [pytest.mark.examples]


def test_raw_ecdh_keyring_get_item_put_item():
    """Test raw_ecdh_keyring_get_item_put_item with static configuration."""
    # You may provide your own ECC Key pairs in the files located at
    # - EXAMPLE_ECC_PRIVATE_KEY_FILENAME_SENDER
    # - EXAMPLE_ECC_PUBLIC_KEY_FILENAME_RECIPIENT
    # If you provide this, the keys MUST be on curve P256
    # If these files are not present, this will generate a pair for you.
    # For this example we will use the curve P256.
    if should_generate_new_ecc_key_pairs():
        generate_ecc_key_pairs()

    # Part of using these keyrings is knowing which curve the keys used in the key agreement
    # lie on. The keyring will fail if the keys do not lie on the configured curve.
    raw_ecdh_keyring_get_item_put_item_with_encrypted_client(TEST_DDB_TABLE_NAME, ECDHCurveSpec.ECC_NIST_P256)


def test_ephemeral_raw_ecdh_keyring_put_item():
    """Test ephemeral_raw_ecdh_keyring_put_item with ephemeral configuration."""
    # You may provide your own ECC Public Key in the files located at
    # - EXAMPLE_ECC_PUBLIC_KEY_FILENAME_RECIPIENT
    # If you provide this, the keys MUST be on curve P256
    # If these files are not present, this will generate a pair for you.
    # For this example we will use the curve P256.
    if should_generate_new_ecc_key_pairs():
        generate_ecc_key_pairs()

    # Part of using these keyrings is knowing which curve the keys used in the key agreement
    # lie on. The keyring will fail if the keys do not lie on the configured curve.
    ephemeral_raw_ecdh_keyring_put_item_with_ecnrypted_client(TEST_DDB_TABLE_NAME, ECDHCurveSpec.ECC_NIST_P256)


def test_discovery_raw_ecdh_keyring_get_item():
    """Test discovery_raw_ecdh_keyring_get_item with discovery configuration."""
    # You may provide your own ECC Public Key in the files located at
    # - EXAMPLE_ECC_PUBLIC_KEY_FILENAME_RECIPIENT
    # - EXAMPLE_ECC_PRIVATE_KEY_FILENAME_RECIPIENT
    # If you provide this, the keys MUST be on curve P256
    # If these files are not present, this will generate a pair for you.
    # For this example we will use the curve P256.
    if should_generate_new_ecc_key_pairs():
        generate_ecc_key_pairs()

    # The discovery configuration is not allowed to encrypt
    # To understand this example best, first, write a record with the ephemeral configuration
    # This means that the recipient public key configured on both keyrings is the same.
    # The other party has the recipient public key and is writing messages meant only for
    # the owner of the recipient public key to decrypt.

    # In this call we are writing a record that is written with an ephemeral sender key pair.
    # The recipient will be able to decrypt the message
    ephemeral_raw_ecdh_keyring_put_item_with_ecnrypted_client(TEST_DDB_TABLE_NAME, ECDHCurveSpec.ECC_NIST_P256)

    # In this call we are reading a record that was written with the recipient's public key.
    # It will use the recipient's private key and the sender's public key stored in the message to
    # calculate the appropriate shared secret to successfully decrypt the message.
    discovery_raw_ecdh_keyring_get_item_with_ecnrypted_client(TEST_DDB_TABLE_NAME, ECDHCurveSpec.ECC_NIST_P256)
