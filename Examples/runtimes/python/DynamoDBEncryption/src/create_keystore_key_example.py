# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""
Example for creating a new key in a KeyStore.

The Hierarchical Keyring Example and Searchable Encryption Examples rely on the
existence of a DDB-backed key store with pre-existing branch key material or
beacon key material.

See the "Create KeyStore Table Example" for how to first set up the DDB Table
that will back this KeyStore.

Demonstrates configuring a KeyStore and using a helper method to create a branch
key and beacon key that share the same Id. A new beacon key is always created
alongside a new branch key, even if searchable encryption is not being used.

Note: This key creation should occur within your control plane.
"""

import boto3
from aws_cryptographic_material_providers.keystore.client import KeyStore
from aws_cryptographic_material_providers.keystore.config import KeyStoreConfig
from aws_cryptographic_material_providers.keystore.models import (
    CreateKeyInput,
    KMSConfigurationKmsKeyArn,
)


def keystore_create_key(key_store_table_name: str, logical_key_store_name: str, kms_key_arn: str) -> str:
    """Create a new branch key and beacon key in our KeyStore."""
    # 1. Configure your KeyStore resource.
    #    This SHOULD be the same configuration that was used to create the DDB table
    #    in the "Create KeyStore Table Example".
    keystore: KeyStore = KeyStore(
        KeyStoreConfig(
            ddb_table_name=key_store_table_name,
            kms_configuration=KMSConfigurationKmsKeyArn(kms_key_arn),
            logical_key_store_name=logical_key_store_name,
            kms_client=boto3.client("kms"),
            ddb_client=boto3.client("dynamodb"),
        )
    )

    # 2. Create a new branch key and beacon key in our KeyStore.
    #    Both the branch key and the beacon key will share an Id.
    #    This creation is eventually consistent.
    branch_key_id = keystore.create_key(CreateKeyInput()).branch_key_identifier

    return branch_key_id
