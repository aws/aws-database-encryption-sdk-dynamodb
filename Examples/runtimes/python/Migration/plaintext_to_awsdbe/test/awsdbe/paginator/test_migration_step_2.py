# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""
Test for Migration Step 2.

This test validates the compatibility between different stages of migration
and ensures that step 2 (using AWS DBESDK with FORBID_PLAINTEXT_WRITE override) can read data
from all other migration steps.
"""
import pytest

from ....src.awsdbe.paginator import (
    migration_step_1,
    migration_step_2,
    migration_step_3,
)
from ....src.plaintext.paginator import migration_step_0
from ...test_utils import TEST_DDB_TABLE_NAME, TEST_KMS_KEY_ID

pytestmark = [pytest.mark.examples]


def test_migration_step_2_with_paginator():
    """Test migration step 2 compatibility with different data formats."""
    # Successfully executes Step 2
    migration_step_2.migration_step_2_with_paginator(kms_key_id=TEST_KMS_KEY_ID, ddb_table_name=TEST_DDB_TABLE_NAME)

    # Given: Step 0 has succeeded
    migration_step_0.migration_step_0_with_paginator(ddb_table_name=TEST_DDB_TABLE_NAME)
    # When: Execute Step 2
    # Then: Success (i.e. can read values in plaintext format)
    migration_step_2.migration_step_2_with_paginator(kms_key_id=TEST_KMS_KEY_ID, ddb_table_name=TEST_DDB_TABLE_NAME)

    # Given: Step 1 has succeeded
    migration_step_1.migration_step_1_with_paginator(kms_key_id=TEST_KMS_KEY_ID, ddb_table_name=TEST_DDB_TABLE_NAME)
    # When: Execute Step 2
    # Then: Success (i.e. can read values in plaintext format)
    migration_step_2.migration_step_2_with_paginator(kms_key_id=TEST_KMS_KEY_ID, ddb_table_name=TEST_DDB_TABLE_NAME)

    # Given: Step 3 has succeeded
    migration_step_3.migration_step_3_with_paginator(kms_key_id=TEST_KMS_KEY_ID, ddb_table_name=TEST_DDB_TABLE_NAME)
    # When: Execute Step 2
    # Then: Success (i.e. can read values in encrypted format)
    migration_step_2.migration_step_2_with_paginator(kms_key_id=TEST_KMS_KEY_ID, ddb_table_name=TEST_DDB_TABLE_NAME)
