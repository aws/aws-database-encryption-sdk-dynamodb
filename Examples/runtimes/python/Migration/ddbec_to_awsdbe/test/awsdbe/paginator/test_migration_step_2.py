# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""
Test for Migration Step 2.

This test validates the compatibility between different stages of migration
and ensures that step 2 (using AWS DBESDK with FORBID_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT)
can read data from all other migration steps.
"""
import pytest

from ....src.awsdbe.paginator import (
    migration_step_1,
    migration_step_2,
    migration_step_3,
)
from ....src.ddbec.paginator import migration_step_0
from ...test_utils import TEST_DDB_TABLE_NAME, TEST_KMS_KEY_ID

pytestmark = [pytest.mark.examples]


def test_migration_step_2_with_paginator():
    """Test migration step 2 compatibility with different data formats."""
    # Successfully executes Step 2
    migration_step_2.migration_step_2_with_paginator(
        kms_key_id=TEST_KMS_KEY_ID, ddb_table_name=TEST_DDB_TABLE_NAME, sort_read_value=2
    )

    # Given: Step 0 has succeeded
    migration_step_0.migration_step_0_with_paginator(
        kms_key_id=TEST_KMS_KEY_ID, ddb_table_name=TEST_DDB_TABLE_NAME, sort_read_value=0
    )
    # When: Execute Step 2 with sort_read_value=0
    # Then: Success (i.e. can read values in old format)
    migration_step_2.migration_step_2_with_paginator(
        kms_key_id=TEST_KMS_KEY_ID, ddb_table_name=TEST_DDB_TABLE_NAME, sort_read_value=0
    )

    # Given: Step 1 has succeeded
    migration_step_1.migration_step_1_with_paginator(
        kms_key_id=TEST_KMS_KEY_ID, ddb_table_name=TEST_DDB_TABLE_NAME, sort_read_value=1
    )
    # When: Execute Step 2 with sort_read_value=1
    # Then: Success (i.e. can read values in old format)
    migration_step_2.migration_step_2_with_paginator(
        kms_key_id=TEST_KMS_KEY_ID, ddb_table_name=TEST_DDB_TABLE_NAME, sort_read_value=1
    )

    # Given: Step 3 has succeeded
    migration_step_3.migration_step_3_with_paginator(
        kms_key_id=TEST_KMS_KEY_ID, ddb_table_name=TEST_DDB_TABLE_NAME, sort_read_value=3
    )
    # When: Execute Step 2 with sort_read_value=3
    # Then: Success (i.e. can read values in new format)
    migration_step_2.migration_step_2_with_paginator(
        kms_key_id=TEST_KMS_KEY_ID, ddb_table_name=TEST_DDB_TABLE_NAME, sort_read_value=3
    )
