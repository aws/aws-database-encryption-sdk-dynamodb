# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""
Utility functions for the KMS ECDH keyring example.

This module provides functions for handling ECC public keys, including:
- Loading public key bytes from a PEM file
- Checking if new public keys should be generated
- Writing public key PEM files for ECC keys
"""

import pathlib

import boto3
from cryptography.hazmat.primitives import serialization

EXAMPLE_ECC_PUBLIC_KEY_SENDER_FILENAME = "KmsEccKeyringKeyringExamplePublicKeySender.pem"
EXAMPLE_ECC_PUBLIC_KEY_RECIPIENT_FILENAME = "KmsEccKeyringKeyringExamplePublicKeyRecipient.pem"


def load_public_key_bytes(ecc_public_key_filename: str) -> bytes:
    """
    Load public key bytes from a PEM file.

    :param ecc_public_key_filename: The filename containing the public key
    :return: The public key bytes
    """
    try:
        with open(ecc_public_key_filename, "rb") as f:
            public_key_file_bytes = f.read()
            public_key = serialization.load_pem_public_key(public_key_file_bytes)
            return public_key.public_bytes(
                encoding=serialization.Encoding.DER, format=serialization.PublicFormat.SubjectPublicKeyInfo
            )
    except IOError as e:
        raise OSError("IOError while reading public key from file") from e


def should_get_new_public_keys() -> bool:
    """
    Check if new public keys should be generated.

    :return: True if new keys should be generated, False otherwise
    """
    # Check if public keys already exist
    sender_public_key_file = pathlib.Path(EXAMPLE_ECC_PUBLIC_KEY_SENDER_FILENAME)
    recipient_public_key_file = pathlib.Path(EXAMPLE_ECC_PUBLIC_KEY_RECIPIENT_FILENAME)

    if sender_public_key_file.exists() or recipient_public_key_file.exists():
        return False

    if not sender_public_key_file.exists() and recipient_public_key_file.exists():
        raise FileNotFoundError(f"Missing public key sender file at {EXAMPLE_ECC_PUBLIC_KEY_SENDER_FILENAME}")

    if not recipient_public_key_file.exists() and sender_public_key_file.exists():
        raise FileNotFoundError(f"Missing public key recipient file at {EXAMPLE_ECC_PUBLIC_KEY_RECIPIENT_FILENAME}")

    return True


def write_public_key_pem_for_ecc_key(ecc_key_arn: str, ecc_public_key_filename: str):
    """
    Write a public key PEM file for an ECC key.

    :param ecc_key_arn: The ARN of the KMS ECC key
    :param ecc_public_key_filename: The filename to write the public key to
    """
    # Safety check: Validate file is not present
    public_key_file = pathlib.Path(ecc_public_key_filename)
    if public_key_file.exists():
        raise FileExistsError("writePublicKeyPemForEccKey will not overwrite existing PEM files")

    # This code will call KMS to get the public key for the KMS ECC key.
    # You must have kms:GetPublicKey permissions on the key for this to succeed.
    # The public key will be written to the file EXAMPLE_ECC_PUBLIC_KEY_SENDER_FILENAME
    # or EXAMPLE_ECC_PUBLIC_KEY_RECIPIENT_FILENAME.
    kms_client = boto3.client("kms")
    response = kms_client.get_public_key(KeyId=ecc_key_arn)
    public_key_bytes = response["PublicKey"]

    # Write the public key to a PEM file
    public_key = serialization.load_der_public_key(public_key_bytes)
    pem_data = public_key.public_bytes(
        encoding=serialization.Encoding.PEM, format=serialization.PublicFormat.SubjectPublicKeyInfo
    )

    with open(ecc_public_key_filename, "wb") as f:
        f.write(pem_data)
