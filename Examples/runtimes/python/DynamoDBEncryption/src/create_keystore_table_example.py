# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""
Example for creating a DynamoDB table for use as a KeyStore.

The Hierarchical Keyring Example and Searchable Encryption Examples rely on the
existence of a DDB-backed key store with pre-existing branch key material or
beacon key material.

Shows how to configure a KeyStore and use a helper method to create the DDB table
that will be used to persist branch keys and beacons keys for this KeyStore.

This table creation should occur within your control plane and only needs to occur
once. While not demonstrated in this example, you should additionally use the
`VersionKey` API on the KeyStore to periodically rotate your branch key material.
"""

import boto3
from aws_cryptographic_material_providers.keystore.client import KeyStore
from aws_cryptographic_material_providers.keystore.config import KeyStoreConfig
from aws_cryptographic_material_providers.keystore.models import (
    CreateKeyStoreInput,
    KMSConfigurationKmsKeyArn,
)


def keystore_create_table(keystore_table_name: str, logical_keystore_name: str, kms_key_arn: str):
    """
    Create KeyStore Table Example.

    :param keystore_table_name: The name of the DynamoDB table to create
    :param logical_keystore_name: The logical name for this keystore
    :param kms_key_arn: The ARN of the KMS key to use for protecting branch keys
    """
    # 1. Configure your KeyStore resource.
    #    `ddb_table_name` is the name you want for the DDB table that
    #    will back your keystore.
    #    `kms_key_arn` is the KMS Key that will protect your branch keys and beacon keys
    #    when they are stored in your DDB table.
    keystore = KeyStore(
        config=KeyStoreConfig(
            ddb_client=boto3.client("dynamodb"),
            ddb_table_name=keystore_table_name,
            logical_key_store_name=logical_keystore_name,
            kms_client=boto3.client("kms"),
            kms_configuration=KMSConfigurationKmsKeyArn(kms_key_arn),
        )
    )

    # 2. Create the DynamoDb table that will store the branch keys and beacon keys.
    #    This checks if the correct table already exists at `ddb_table_name`
    #    by using the DescribeTable API. If no table exists,
    #    it will create one. If a table exists, it will verify
    #    the table's configuration and will error if the configuration is incorrect.
    keystore.create_key_store(input=CreateKeyStoreInput())
    # It may take a couple of minutes for the table to become ACTIVE,
    # at which point it is ready to store branch and beacon keys.
    # See the Create KeyStore Key Example for how to populate
    # this table.
