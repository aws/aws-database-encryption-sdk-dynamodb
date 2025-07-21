# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""
Test for Migration Step 0.

This test validates the initial plaintext state for DynamoDB operations with Resource interface.
It verifies basic functionality of the plaintext DynamoDB Resource operations.
"""
import pytest

from ....src.awsdbe.resource import (
    migration_step_1,
    migration_step_2,
    migration_step_3,
)
from ....src.plaintext.resource import migration_step_0
from ...test_utils import TEST_DDB_TABLE_NAME, TEST_KMS_KEY_ID

pytestmark = [pytest.mark.examples]


def test_migration_step_0_with_resource():
    """Test plaintext DynamoDB Resource operations."""
    # Successfully executes Step 0
    migration_step_0.migration_step_0_with_resource(ddb_table_name=TEST_DDB_TABLE_NAME, sort_read_value=0)

    # Given: Step 1 has succeeded
    migration_step_1.migration_step_1_with_resource(
        kms_key_id=TEST_KMS_KEY_ID, ddb_table_name=TEST_DDB_TABLE_NAME, sort_read_value=1
    )
    # When: Execute Step 0 with sort_read_value=1
    # Then: Success (i.e. can read values in plaintext format)
    migration_step_0.migration_step_0_with_resource(ddb_table_name=TEST_DDB_TABLE_NAME, sort_read_value=1)

    # Given: Step 2 has succeeded
    migration_step_2.migration_step_2_with_resource(
        kms_key_id=TEST_KMS_KEY_ID, ddb_table_name=TEST_DDB_TABLE_NAME, sort_read_value=2
    )
    # When: Execute Step 0 with sort_read_value=2
    # Then: throws AssertionError (i.e. cannot read encrypted values)
    # AssertionError: attribute1 now has type (binary) value instead of (string) value
    with pytest.raises(AssertionError):
        migration_step_0.migration_step_0_with_resource(ddb_table_name=TEST_DDB_TABLE_NAME, sort_read_value=2)

    # Given: Step 3 has succeeded
    migration_step_3.migration_step_3_with_resource(
        kms_key_id=TEST_KMS_KEY_ID, ddb_table_name=TEST_DDB_TABLE_NAME, sort_read_value=3
    )
    # When: Execute Step 0 with sort_read_value=3
    # Then: throws AssertionError (i.e. cannot read encrypted values)
    # AssertionError: attribute1 now has type (binary) value instead of (string) value
    with pytest.raises(AssertionError):
        migration_step_0.migration_step_0_with_resource(ddb_table_name=TEST_DDB_TABLE_NAME, sort_read_value=3)
