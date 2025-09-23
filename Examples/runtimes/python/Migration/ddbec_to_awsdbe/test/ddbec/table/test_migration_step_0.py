# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""
Test for Migration Step 0.

This test validates the compatibility between different stages of migration
and ensures that step 0 (using legacy DynamoDB Encryption Client with EncryptedTable) behaves correctly
with data from different migration stages.
"""
import pytest
from dynamodb_encryption_sdk.exceptions import DecryptionError

from ....src.awsdbe.table import (
    migration_step_1,
    migration_step_2,
    migration_step_3,
)
from ....src.ddbec.table import migration_step_0
from ...test_utils import TEST_DDB_TABLE_NAME, TEST_KMS_KEY_ID

pytestmark = [pytest.mark.examples]


def test_migration_step_0_with_table():
    """Test migration step 0 compatibility with different data formats."""
    # Successfully executes Step 0
    migration_step_0.migration_step_0_with_table(
        kms_key_id=TEST_KMS_KEY_ID, ddb_table_name=TEST_DDB_TABLE_NAME, sort_read_value=0
    )

    # Given: Step 1 has succeeded
    migration_step_1.migration_step_1_with_table(
        kms_key_id=TEST_KMS_KEY_ID, ddb_table_name=TEST_DDB_TABLE_NAME, sort_read_value=1
    )
    # When: Execute Step 0 with sort_read_value=1
    # Then: Success (i.e. can read values in old format)
    migration_step_0.migration_step_0_with_table(
        kms_key_id=TEST_KMS_KEY_ID, ddb_table_name=TEST_DDB_TABLE_NAME, sort_read_value=1
    )

    # Given: Step 2 has succeeded
    migration_step_2.migration_step_2_with_table(
        kms_key_id=TEST_KMS_KEY_ID, ddb_table_name=TEST_DDB_TABLE_NAME, sort_read_value=2
    )
    # When: Execute Step 0 with sort_read_value=2
    # Then: throws DecryptionError Exception (i.e. cannot read values in new format)
    with pytest.raises(DecryptionError):  # The exact exception may vary in Python implementation
        migration_step_0.migration_step_0_with_table(
            kms_key_id=TEST_KMS_KEY_ID, ddb_table_name=TEST_DDB_TABLE_NAME, sort_read_value=2
        )

    # Given: Step 3 has succeeded
    migration_step_3.migration_step_3_with_table(
        kms_key_id=TEST_KMS_KEY_ID, ddb_table_name=TEST_DDB_TABLE_NAME, sort_read_value=3
    )
    # When: Execute Step 0 with sort_read_value=3
    # Then: throws DecryptionError Exception (i.e. cannot read values in new format)
    with pytest.raises(DecryptionError):  # The exact exception may vary in Python implementation
        migration_step_0.migration_step_0_with_table(
            kms_key_id=TEST_KMS_KEY_ID, ddb_table_name=TEST_DDB_TABLE_NAME, sort_read_value=3
        )
