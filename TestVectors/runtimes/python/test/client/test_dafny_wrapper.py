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

# Import extern to use an EncryptedClient as the wrapped DBESDK client.
import aws_dbesdk_dynamodb_test_vectors.internaldafny.extern.CreateInterceptedDDBClient
# Import extern to use the ItemEncryptor with DDB JSON-formatted items.
# (EncryptedClients use DDB JSON-formatted items by default.)
import aws_dbesdk_dynamodb_test_vectors.internaldafny.extern.CreateWrappedDynamoDbItemEncryptor

def test_dafny():
  from ..internaldafny.generated import __main__