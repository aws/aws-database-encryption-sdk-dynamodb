# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""Utility functions for the KMS RSA keyring example."""

import os

import boto3
from cryptography.hazmat.primitives import serialization

DEFAULT_EXAMPLE_RSA_PUBLIC_KEY_FILENAME = "KmsRsaKeyringExamplePublicKey.pem"


def should_get_new_public_key(rsa_public_key_filename: str = DEFAULT_EXAMPLE_RSA_PUBLIC_KEY_FILENAME) -> bool:
    """
    Check if we need to get a new public key.

    :param rsa_public_key_filename: Path to the public key PEM file
    :return: True if we need to get a new public key, False otherwise
    """
    # Check if a public key file already exists
    public_key_file = os.path.exists(rsa_public_key_filename)

    # If a public key file already exists: do not overwrite existing file
    if public_key_file:
        return False

    # If file is not present, generate a new key pair
    return True


def write_public_key_pem_for_rsa_key(
    rsa_key_arn: str, rsa_public_key_filename: str = DEFAULT_EXAMPLE_RSA_PUBLIC_KEY_FILENAME
):
    """
    Get the public key from KMS and write it to a PEM file.

    :param rsa_key_arn: The ARN of the KMS RSA key
    :param rsa_public_key_filename: Path to write the public key PEM file
    """
    # Safety check: Validate file is not present
    if os.path.exists(rsa_public_key_filename):
        raise FileExistsError("getRsaPublicKey will not overwrite existing PEM files")

    # This code will call KMS to get the public key for the KMS RSA key.
    # You must have kms:GetPublicKey permissions on the key for this to succeed.
    # The public key will be written to the file EXAMPLE_RSA_PUBLIC_KEY_FILENAME.
    kms_client = boto3.client("kms")
    response = kms_client.get_public_key(KeyId=rsa_key_arn)
    public_key_bytes = response["PublicKey"]

    # Convert the public key to PEM format
    public_key = serialization.load_der_public_key(public_key_bytes)
    pem_data = public_key.public_bytes(
        encoding=serialization.Encoding.PEM, format=serialization.PublicFormat.SubjectPublicKeyInfo
    )

    # Write the PEM file
    try:
        with open(rsa_public_key_filename, "wb") as f:
            f.write(pem_data)
    except IOError as e:
        raise OSError("IOError while writing public key PEM") from e
