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

import aws_dbesdk_dynamodb_test_vectors.internaldafny.extern.CreateInterceptedDDBTable
import aws_dbesdk_dynamodb_test_vectors.internaldafny.extern.CreateWrappedDictItemEncryptor

# Remove invalid tests.
# Supported operations on Tables that are also supported by DBESDK are:
# - put_item
# - get_item
# - query
# - scan
# https://boto3.amazonaws.com/v1/documentation/api/latest/reference/services/dynamodb/table/index.html#DynamoDB.Table
# 
# Unsupported operations on Tables are that are supported by DBESDK are:
# - transact_get_items
# - transact_write_items
# - batch_get_item
# Remove any tests that call unsupported operations by overriding the test method to do nothing.
# If more tests that call these operations are added, remove them below.
# If the list below becomes unmaintainable, or if other languages add clients with unsupported operations,
# refactor the Dafny code to conditionally call tests based on whether the client supports the operation under test.

def EmptyTest(*args):
  pass

aws_dbesdk_dynamodb_test_vectors.internaldafny.generated.DdbEncryptionTestVectors.TestVectorConfig.BasicIoTestTransactGetItems = EmptyTest
aws_dbesdk_dynamodb_test_vectors.internaldafny.generated.DdbEncryptionTestVectors.TestVectorConfig.BasicIoTestTransactWriteItems = EmptyTest
aws_dbesdk_dynamodb_test_vectors.internaldafny.generated.DdbEncryptionTestVectors.TestVectorConfig.BasicIoTestBatchGetItems = EmptyTest

def test_dafny():
  from ..internaldafny.generated import __main__