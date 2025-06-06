# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""
Run all three steps of the migration example in sequence.

This script demonstrates the complete migration path from the legacy
DynamoDB Encryption Client to the new AWS Database Encryption SDK.
"""
import pytest

from ....src.ddbec_to_awsdbe.awsdbe import (
    migration_step_1,
    migration_step_2,
    migration_step_3,
)
from ....src.ddbec_to_awsdbe.ddbec import migration_step_0
from ..test_utils import TEST_DDB_TABLE_NAME, TEST_KMS_KEY_ID

pytestmark = [pytest.mark.examples]


def test_run_migration_example():
    """Run all migration examples in sequence."""
    print("=== Running Complete Migration Path Example ===\n")

    try:
        # Run Step 0: Using legacy DynamoDB Encryption Client
        print("\n\n======================================================")
        print("STEP 0: Using legacy DynamoDB Encryption Client")
        print("======================================================")
        migration_step_0.migration_step_0(kms_key_id=TEST_KMS_KEY_ID, ddb_table_name=TEST_DDB_TABLE_NAME)

        # Run Step 1: Using AWS DBESDK with Legacy Override
        print("\n\n======================================================")
        print("STEP 1: Using AWS DBESDK with Legacy Override")
        print("======================================================")
        migration_step_1.migration_step_1(kms_key_id=TEST_KMS_KEY_ID, ddb_table_name=TEST_DDB_TABLE_NAME)

        # Run Step 2: Full Migration to AWS Database Encryption SDK
        print("\n\n======================================================")
        print("STEP 2: Full Migration to AWS Database Encryption SDK")
        print("======================================================")
        migration_step_2.migration_step_2(kms_key_id=TEST_KMS_KEY_ID, ddb_table_name=TEST_DDB_TABLE_NAME)

        # Run Step 3: Complete Migration - Using Only AWS DBESK
        print("\n\n======================================================")
        print("STEP 3: Complete Migration - Using Only AWS DBESK")
        print("======================================================")
        migration_step_3.migration_step_3(kms_key_id=TEST_KMS_KEY_ID, ddb_table_name=TEST_DDB_TABLE_NAME)

        print("\n\n======================================================")
        print("Migration path completed successfully!")
        print("======================================================")
    finally:
        pass