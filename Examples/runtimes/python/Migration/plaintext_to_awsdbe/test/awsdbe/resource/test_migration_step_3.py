# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""
Test for Migration Step 3.

This test validates the compatibility behavior for step 3 (pure AWS DBESDK without plaintext override).
Step 3 can only read encrypted items and will fail with plaintext items.
"""
import pytest

from ....src.awsdbe.resource import (
    migration_step_2,
    migration_step_3,
)
from ...test_utils import TEST_DDB_TABLE_NAME, TEST_KMS_KEY_ID

pytestmark = [pytest.mark.examples]


def test_migration_step_3_with_resource():
    """Test migration step 3 compatibility with encrypted data formats only."""
    # Successfully executes Step 3
    migration_step_3.migration_step_3_with_resource(
        kms_key_id=TEST_KMS_KEY_ID, ddb_table_name=TEST_DDB_TABLE_NAME, sort_read_value=3
    )

    # Given: Step 2 has succeeded (writing encrypted data)
    migration_step_2.migration_step_2_with_resource(
        kms_key_id=TEST_KMS_KEY_ID, ddb_table_name=TEST_DDB_TABLE_NAME, sort_read_value=2
    )
    # When: Execute Step 3 with sort_read_value=2
    # Then: Success (i.e. can read values in encrypted format)
    migration_step_3.migration_step_3_with_resource(
        kms_key_id=TEST_KMS_KEY_ID, ddb_table_name=TEST_DDB_TABLE_NAME, sort_read_value=2
    )

    # Note: Step 3 cannot read plaintext items (those written by Step 0 or Step 1)
    # If attempted, it would throw an error because those items don't have the
    # necessary encryption material
