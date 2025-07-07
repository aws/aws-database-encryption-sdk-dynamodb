# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""Utility functions for the raw RSA keyring example."""

import os

from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.primitives.asymmetric import rsa

EXAMPLE_RSA_PRIVATE_KEY_FILENAME = "RawRsaKeyringExamplePrivateKey.pem"
EXAMPLE_RSA_PUBLIC_KEY_FILENAME = "RawRsaKeyringExamplePublicKey.pem"


def should_generate_new_rsa_key_pair() -> bool:
    """
    Check if we need to generate a new RSA key pair.

    :return: True if we need to generate a new key pair, False otherwise
    """
    # Check if a key pair already exists
    private_key_file = os.path.exists(EXAMPLE_RSA_PRIVATE_KEY_FILENAME)
    public_key_file = os.path.exists(EXAMPLE_RSA_PUBLIC_KEY_FILENAME)

    # If a key pair already exists: do not overwrite existing key pair
    if private_key_file and public_key_file:
        return False

    # If only one file is present: throw exception
    if private_key_file and not public_key_file:
        raise ValueError(f"Missing public key file at {EXAMPLE_RSA_PUBLIC_KEY_FILENAME}")
    if not private_key_file and public_key_file:
        raise ValueError(f"Missing private key file at {EXAMPLE_RSA_PRIVATE_KEY_FILENAME}")

    # If neither file is present, generate a new key pair
    return True


def generate_rsa_key_pair():
    """Generate a new RSA key pair and save to PEM files."""
    # Safety check: Validate neither file is present
    if os.path.exists(EXAMPLE_RSA_PRIVATE_KEY_FILENAME) or os.path.exists(EXAMPLE_RSA_PUBLIC_KEY_FILENAME):
        raise FileExistsError("generateRsaKeyPair will not overwrite existing PEM files")

    # This code will generate a new RSA key pair for example use.
    # The public and private key will be written to the files:
    #  - public: EXAMPLE_RSA_PUBLIC_KEY_FILENAME
    #  - private: EXAMPLE_RSA_PRIVATE_KEY_FILENAME
    # In practice, you should not generate this in your code, and should instead
    # retrieve this key from a secure key management system (e.g. HSM)
    # This key is created here for example purposes only.
    private_key = rsa.generate_private_key(public_exponent=65537, key_size=2048)

    # Write private key PEM file
    private_key_pem = private_key.private_bytes(
        encoding=serialization.Encoding.PEM,
        format=serialization.PrivateFormat.PKCS8,
        encryption_algorithm=serialization.NoEncryption(),
    )

    try:
        with open(EXAMPLE_RSA_PRIVATE_KEY_FILENAME, "wb") as f:
            f.write(private_key_pem)
    except IOError as e:
        raise OSError("IOError while writing private key PEM") from e

    # Write public key PEM file
    public_key = private_key.public_key()
    public_key_pem = public_key.public_bytes(
        encoding=serialization.Encoding.PEM, format=serialization.PublicFormat.SubjectPublicKeyInfo
    )

    try:
        with open(EXAMPLE_RSA_PUBLIC_KEY_FILENAME, "wb") as f:
            f.write(public_key_pem)
    except IOError as e:
        raise OSError("IOError while writing public key PEM") from e
