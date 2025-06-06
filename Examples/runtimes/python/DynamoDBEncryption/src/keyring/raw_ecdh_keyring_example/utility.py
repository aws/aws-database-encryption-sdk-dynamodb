# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""
Utility functions for the raw ECDH keyring example.

This module provides functions for handling ECC keys, including:
- Loading key bytes from PEM files
- Checking if new key pairs should be generated
- Generating new ECC key pairs
"""

import pathlib

from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.primitives.asymmetric import ec

EXAMPLE_ECC_PRIVATE_KEY_FILENAME_SENDER = "RawEcdhKeyringExamplePrivateKeySender.pem"
EXAMPLE_ECC_PRIVATE_KEY_FILENAME_RECIPIENT = "RawEcdhKeyringExamplePrivateKeyRecipient.pem"
EXAMPLE_ECC_PUBLIC_KEY_FILENAME_RECIPIENT = "RawEcdhKeyringExamplePublicKeyRecipient.pem"


def load_private_key(private_key_filename: str) -> bytes:
    """
    Load private key bytes from a PEM file.

    :param private_key_filename: The filename containing the private key
    :return: The UTF-8 PEM-encoded private key bytes
    """
    try:
        with open(private_key_filename, "rb") as f:
            private_key_utf8_encoded = f.read()
        return private_key_utf8_encoded
    except IOError as e:
        raise OSError("IOError while reading the private key from file") from e


def load_public_key_bytes(public_key_filename: str) -> bytes:
    """
    Load public key bytes from a PEM file and convert to DER format.

    :param public_key_filename: The filename containing the public key
    :return: The DER-encoded public key bytes
    """
    try:
        with open(public_key_filename, "rb") as f:
            public_key_utf8_encoded = f.read()
            public_key = serialization.load_pem_public_key(public_key_utf8_encoded)
            return public_key.public_bytes(
                encoding=serialization.Encoding.DER, format=serialization.PublicFormat.SubjectPublicKeyInfo
            )
    except IOError as e:
        raise OSError("IOError while reading the public key from file") from e


def should_generate_new_ecc_key_pairs() -> bool:
    """
    Check if new ECC key pairs should be generated.

    :return: True if new key pairs should be generated, False otherwise
    """
    private_key_file_sender = pathlib.Path(EXAMPLE_ECC_PRIVATE_KEY_FILENAME_SENDER)
    private_key_file_recipient = pathlib.Path(EXAMPLE_ECC_PRIVATE_KEY_FILENAME_RECIPIENT)
    public_key_file_recipient = pathlib.Path(EXAMPLE_ECC_PUBLIC_KEY_FILENAME_RECIPIENT)

    # If keys already exist: do not overwrite existing keys
    return (
        not private_key_file_sender.exists()
        and not public_key_file_recipient.exists()
        and not private_key_file_recipient.exists()
    )


def generate_ecc_key_pairs():
    """
    Generate new ECC key pairs.

    This code will generate new ECC key pairs for example use.
    The keys will be written to the files:
     - private_sender: EXAMPLE_ECC_PRIVATE_KEY_FILENAME_SENDER
     - private_recipient: EXAMPLE_ECC_PRIVATE_KEY_FILENAME_RECIPIENT
     - public_recipient: EXAMPLE_ECC_PUBLIC_KEY_FILENAME_RECIPIENT
    This example uses cryptography's EllipticCurve to generate the key pairs.
    In practice, you should not generate this in your code, and should instead
    retrieve this key from a secure key management system (e.g. HSM).
    These examples only demonstrate using the P256 curve while the keyring accepts
    P256, P384, or P521.
    These keys are created here for example purposes only.
    """
    private_key_file_sender = pathlib.Path(EXAMPLE_ECC_PRIVATE_KEY_FILENAME_SENDER)
    private_key_file_recipient = pathlib.Path(EXAMPLE_ECC_PRIVATE_KEY_FILENAME_RECIPIENT)
    public_key_file_recipient = pathlib.Path(EXAMPLE_ECC_PUBLIC_KEY_FILENAME_RECIPIENT)

    if private_key_file_sender.exists() or public_key_file_recipient.exists() or private_key_file_recipient.exists():
        raise FileExistsError("generateEccKeyPairs will not overwrite existing PEM files")

    # Generate sender key pair
    sender_private_key = ec.generate_private_key(ec.SECP256R1())

    # Generate recipient key pair
    recipient_private_key = ec.generate_private_key(ec.SECP256R1())
    recipient_public_key = recipient_private_key.public_key()

    # Write private keys
    write_private_key(sender_private_key, EXAMPLE_ECC_PRIVATE_KEY_FILENAME_SENDER)
    write_private_key(recipient_private_key, EXAMPLE_ECC_PRIVATE_KEY_FILENAME_RECIPIENT)

    # Write public key
    write_public_key(recipient_public_key, EXAMPLE_ECC_PUBLIC_KEY_FILENAME_RECIPIENT)


def write_private_key(private_key: ec.EllipticCurvePrivateKey, filename: str):
    """
    Write a private key to a PEM file.

    :param private_key: The private key to write
    :param filename: The filename to write to
    """
    pem_data = private_key.private_bytes(
        encoding=serialization.Encoding.PEM,
        format=serialization.PrivateFormat.PKCS8,
        encryption_algorithm=serialization.NoEncryption(),
    )

    with open(filename, "wb") as f:
        f.write(pem_data)


def write_public_key(public_key: ec.EllipticCurvePublicKey, filename: str):
    """
    Write a public key to a PEM file.

    :param public_key: The public key to write
    :param filename: The filename to write to
    """
    pem_data = public_key.public_bytes(
        encoding=serialization.Encoding.PEM, format=serialization.PublicFormat.SubjectPublicKeyInfo
    )

    with open(filename, "wb") as f:
        f.write(pem_data)
