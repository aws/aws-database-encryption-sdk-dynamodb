# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""Test constants."""

# This is a public KMS Key that MUST only be used for testing, and MUST NOT be used for any production data
TEST_KMS_KEY_ID = "arn:aws:kms:us-west-2:658956600833:key/b3537ef1-d8dc-4780-9f5a-55776cbb2f7f"
# Personal Testing Resource
# TEST_KMS_KEY_ID = "arn:aws:kms:us-west-2:452750982249:key/773d55bf-c816-48a2-96cd-b386f7980d08"

# Our tests require access to DDB Table with this name
TEST_DDB_TABLE_NAME = "DynamoDbEncryptionInterceptorTestTable"
