# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""
Wrapper file for executing Dafny tests from pytest.
This allows us to import modules required by Dafny-generated tests
before executing Dafny-generated tests.
pytest will find and execute the `test_dafny` method below,
which will execute the `internaldafny_test_executor.py` file in the `dafny` directory.
"""

import sys

# Different from standard test_dafny_wrapper due to weird test structure.
test_dir = '/'.join(__file__.split("/")[:-2])

sys.path.append(test_dir + "/internaldafny/extern")
sys.path.append(test_dir + "/internaldafny/generated")

import dbesdk_ddb_test_vectors.internaldafny.extern.CreateInterceptedDDBResource
import dbesdk_ddb_test_vectors.internaldafny.extern.CreateWrappedDictItemEncryptor

# Remove invalid tests.
# Supported operations on `resource` that are also supported by DBESDK are:
# - batch_get_item
# - batch_write_item
# Unsupported operations on `resource` are that are supported by DBESDK are:
# - put_item
# - get_item
# - query
# - scan
# - transact_get_items
# - transact_write_items
# Remove any tests that call unsupported operations.
# If more tests that call these operations are added, remove them below.
# If the list below becomes unmaintainable,
# or if other languages add clients with unsupported operations,
# refactor the Dafny code to conditionally call tests
# based on whether the client supports the operation under test.

def EmptyTest(*args):
  pass

dbesdk_ddb_test_vectors.internaldafny.generated.DdbEncryptionTestVectors.TestVectorConfig.BasicIoTestPutItem = EmptyTest
dbesdk_ddb_test_vectors.internaldafny.generated.DdbEncryptionTestVectors.TestVectorConfig.BasicIoTestTransactWriteItems = EmptyTest
dbesdk_ddb_test_vectors.internaldafny.generated.DdbEncryptionTestVectors.TestVectorConfig.BasicQueryTest = EmptyTest
dbesdk_ddb_test_vectors.internaldafny.generated.DdbEncryptionTestVectors.TestVectorConfig.BasicIoTestGetItem = EmptyTest
dbesdk_ddb_test_vectors.internaldafny.generated.DdbEncryptionTestVectors.TestVectorConfig.BasicIoTestScan = EmptyTest
dbesdk_ddb_test_vectors.internaldafny.generated.DdbEncryptionTestVectors.TestVectorConfig.BasicIoTestTransactGetItems = EmptyTest

def test_dafny():
  from ..internaldafny.generated import __main__