# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""Test the complex searchable encryption example with the EncryptedTable."""
import time

import pytest

from .....src import create_keystore_key_example
from .....src.searchable_encryption.complex_example.table import example
from ...searchable_encryption_test_utils import (
    TEST_BRANCH_KEY_WRAPPING_KMS_KEY_ARN,
    TEST_BRANCH_KEYSTORE_DDB_TABLE_NAME,
    TEST_LOGICAL_KEYSTORE_NAME,
)
from ..complex_searchable_encryption_example_test_utils import (
    TEST_DDB_TABLE_NAME,
)

pytestmark = [pytest.mark.examples]


def test_complex_example_table():
    """Test function for encrypt and decrypt using the AWS KMS Keyring example."""
    key_id = create_keystore_key_example.keystore_create_key(
        TEST_BRANCH_KEYSTORE_DDB_TABLE_NAME,
        TEST_LOGICAL_KEYSTORE_NAME,
        TEST_BRANCH_KEY_WRAPPING_KMS_KEY_ARN,
    )

    # Key creation is eventually consistent, so wait 5 seconds to decrease the likelihood
    # our test fails due to eventual consistency issues.
    time.sleep(5)

    example.run_example(
        TEST_DDB_TABLE_NAME, key_id, TEST_BRANCH_KEY_WRAPPING_KMS_KEY_ARN, TEST_BRANCH_KEYSTORE_DDB_TABLE_NAME
    )
