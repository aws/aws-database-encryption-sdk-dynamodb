# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""Test scan error example."""
import pytest

from ..src.scan_error_example import scan_error
from .test_utils import TEST_DDB_TABLE_NAME, TEST_KMS_KEY_ID

pytestmark = [pytest.mark.examples]


def test_scan_error():
    """Test scan_error."""
    scan_error(TEST_KMS_KEY_ID, TEST_DDB_TABLE_NAME)
