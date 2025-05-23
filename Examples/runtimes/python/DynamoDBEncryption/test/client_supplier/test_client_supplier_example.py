# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""Test suite for the client supplier example."""
import pytest

from .. import test_utils
from ...src.client_supplier.client_supplier_example import client_supplier_example

pytestmark = [pytest.mark.examples]

def test_client_supplier_example():
    """Test function for client supplier example."""
    accounts = [test_utils.TEST_AWS_ACCOUNT_ID]
    regions = ["eu-west-1"]  # Using eu-west-1

    # Call the client_supplier_example with the test parameters
    client_supplier_example(
        ddb_table_name=test_utils.TEST_DDB_TABLE_NAME,
        key_arn=test_utils.TEST_MRK_REPLICA_KEY_ID_US_EAST_1,
        account_ids=accounts,
        regions=regions
    )