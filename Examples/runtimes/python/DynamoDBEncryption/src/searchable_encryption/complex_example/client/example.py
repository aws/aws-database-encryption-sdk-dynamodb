# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""Run the complex searchable encryption example with the EncryptedClient."""
import boto3
from aws_dbesdk_dynamodb.encrypted.client import EncryptedClient

from ..beacon_config import setup_beacon_config
from .put_requests import put_all_items_to_table
from .query_requests import run_queries


def run_example(
    ddb_table_name: str,
    branch_key_id: str,
    branch_key_wrapping_kms_key_arn: str,
    branch_key_ddb_table_name: str,
):
    """Run the example."""
    encryption_config = setup_beacon_config(
        ddb_table_name, branch_key_id, branch_key_wrapping_kms_key_arn, branch_key_ddb_table_name
    )

    client = boto3.client("dynamodb")

    encrypted_client = EncryptedClient(client=client, encryption_config=encryption_config)

    put_all_items_to_table(ddb_table_name, encrypted_client)
    run_queries(encrypted_client, ddb_table_name)
