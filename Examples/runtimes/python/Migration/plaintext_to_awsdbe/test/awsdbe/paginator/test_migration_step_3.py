# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""
Test for Migration Step 3.

This test validates the compatibility behavior for step 3 (pure AWS DBESDK without plaintext override).
Step 3 can only read encrypted items and will fail with plaintext items.
"""
import pytest
from aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.errors import (
    DynamoDbItemEncryptor,
)

from ....src.awsdbe.paginator import (
    migration_step_1,
    migration_step_2,
    migration_step_3,
)
from ....src.plaintext.paginator import migration_step_0
from ...test_utils import TEST_DDB_TABLE_NAME, TEST_KMS_KEY_ID

pytestmark = [pytest.mark.examples]


def test_migration_step_3_with_paginator():
    """Test migration step 3 compatibility with encrypted data formats only."""
    # Successfully executes Step 3
    migration_step_3.migration_step_3_with_paginator(
        kms_key_id=TEST_KMS_KEY_ID, ddb_table_name=TEST_DDB_TABLE_NAME, sort_read_value=3
    )

    # Given: Step 0 has succeeded
    migration_step_0.migration_step_0_with_paginator(ddb_table_name=TEST_DDB_TABLE_NAME, sort_read_value=0)
    # When: Execute Step 3 with sort_read_value=0
    # Then: throws DynamoDbItemEncryptor Exception (i.e. cannot read values in plaintext format)
    with pytest.raises(DynamoDbItemEncryptor):
        migration_step_3.migration_step_3_with_paginator(
            kms_key_id=TEST_KMS_KEY_ID, ddb_table_name=TEST_DDB_TABLE_NAME, sort_read_value=0
        )

    # Given: Step 1 has succeeded
    migration_step_1.migration_step_1_with_paginator(
        kms_key_id=TEST_KMS_KEY_ID, ddb_table_name=TEST_DDB_TABLE_NAME, sort_read_value=1
    )
    # When: Execute Step 3 with sort_read_value=1
    # Then: throws DynamoDbItemEncryptor Exception (i.e. cannot read values in plaintext format)
    with pytest.raises(DynamoDbItemEncryptor):
        migration_step_3.migration_step_3_with_paginator(
            kms_key_id=TEST_KMS_KEY_ID, ddb_table_name=TEST_DDB_TABLE_NAME, sort_read_value=1
        )

    # Given: Step 2 has succeeded
    migration_step_2.migration_step_2_with_paginator(
        kms_key_id=TEST_KMS_KEY_ID, ddb_table_name=TEST_DDB_TABLE_NAME, sort_read_value=2
    )
    # When: Execute Step 3 with sort_read_value=2
    # Then: Success (i.e. can read values in encrypted format)
    migration_step_3.migration_step_3_with_paginator(
        kms_key_id=TEST_KMS_KEY_ID, ddb_table_name=TEST_DDB_TABLE_NAME, sort_read_value=2
    )
