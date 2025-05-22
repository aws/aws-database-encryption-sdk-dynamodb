# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""Run the complex searchable encryption example with the EncryptedTable."""
import boto3
from aws_dbesdk_dynamodb.encrypted.table import EncryptedTable

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

    table = boto3.resource("dynamodb").Table(ddb_table_name)
    encrypted_table = EncryptedTable(table=table, encryption_config=encryption_config)

    put_all_items_to_table(encrypted_table)
    run_queries(encrypted_table)
