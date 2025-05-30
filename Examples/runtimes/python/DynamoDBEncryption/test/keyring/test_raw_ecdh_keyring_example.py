# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""Test raw ECDH keyring examples."""
# TODO: Resolve dependencies
# from aws_cryptographic_material_providers.mpl.models import ECDHCurveSpec

from ...src.keyring.raw_ecdh_keyring_example import (
    discovery_raw_ecdh_keyring_get_item,
    ephemeral_raw_ecdh_keyring_put_item,
    generate_ecc_key_pairs,
    raw_ecdh_keyring_get_item_put_item,
    should_generate_new_ecc_key_pairs,
)
from ..test_utils import TEST_DDB_TABLE_NAME


def test_static_raw_ecdh_keyring_example():
    """Test raw_ecdh_keyring_example with static configuration."""
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
    raw_ecdh_keyring_get_item_put_item(
        TEST_DDB_TABLE_NAME,
        "ECC_NIST_P256"
    )


def test_ephemeral_raw_ecdh_keyring_example():
    """Test raw_ecdh_keyring_example with ephemeral configuration."""
    # You may provide your own ECC Public Key in the files located at
    # - EXAMPLE_ECC_PUBLIC_KEY_FILENAME_RECIPIENT
    # If you provide this, the keys MUST be on curve P256
    # If these files are not present, this will generate a pair for you.
    # For this example we will use the curve P256.
    if should_generate_new_ecc_key_pairs():
        generate_ecc_key_pairs()

    # Part of using these keyrings is knowing which curve the keys used in the key agreement
    # lie on. The keyring will fail if the keys do not lie on the configured curve.
    ephemeral_raw_ecdh_keyring_put_item(
        TEST_DDB_TABLE_NAME,
        'ECC_NIST_P256'
    )


def test_discovery_raw_ecdh_keyring_example():
    """Test raw_ecdh_keyring_example with discovery configuration."""
    # You may provide your own ECC Public Key in the files located at
    # - EXAMPLE_ECC_PUBLIC_KEY_FILENAME_RECIPIENT
    # - EXAMPLE_ECC_PRIVATE_KEY_FILENAME_RECIPIENT
    # If you provide this, the keys MUST be on curve P256
    # If these files are not present, this will generate a pair for you.
    # For this example we will use the curve P256.
    if should_generate_new_ecc_key_pairs():
        generate_ecc_key_pairs()

    # The discovery configuration is not allowed to encrypt
    # To understand this example best, we will write a record with the ephemeral configuration
    # in the previous example. This means that the recipient public key configured on
    # both keyrings is the same. This means that the other party has the recipient public key
    # and is writing messages meant only for the owner of the recipient public key to decrypt.

    # In this call we are writing a record that is written with an ephemeral sender key pair.
    # The recipient will be able to decrypt the message
    ephemeral_raw_ecdh_keyring_put_item(
        TEST_DDB_TABLE_NAME,
        'ECC_NIST_P256'
    )

    # In this call we are reading a record that was written with the recipient's public key.
    # It will use the recipient's private key and the sender's public key stored in the message to
    # calculate the appropriate shared secret to successfully decrypt the message.
    discovery_raw_ecdh_keyring_get_item(
        TEST_DDB_TABLE_NAME,
        'ECC_NIST_P256'
    )
