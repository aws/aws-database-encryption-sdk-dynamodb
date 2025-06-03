# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""Example demonstrating how to get encrypted data key descriptions from DynamoDB items."""

import boto3
from aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.client import DynamoDbEncryption
from aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.config import (
    DynamoDbEncryptionConfig,
)
from aws_dbesdk_dynamodb.structures.dynamodb import (
    GetEncryptedDataKeyDescriptionInput,
    GetEncryptedDataKeyDescriptionUnionItem,
)


def get_encrypted_data_key_description(
    table_name: str,
    partition_key: str,
    partition_key_val: str,
    sort_key_name: str,
    sort_key_value: str,
    expected_key_provider_id: str,
    expected_key_provider_info: str,
    expected_branch_key_id: str,
    expected_branch_key_version: str,
):
    """
    Get encrypted data key description from a DynamoDB item.

    :param table_name: The name of the DynamoDB table
    :param partition_key: The name of the partition key
    :param partition_key_val: The value of the partition key
    :param sort_key_name: The name of the sort key
    :param sort_key_value: The value of the sort key
    :param expected_key_provider_id: The expected key provider ID
    :param expected_key_provider_info: The expected key provider info (optional)
    :param expected_branch_key_id: The expected branch key ID (optional)
    :param expected_branch_key_version: The expected branch key version (optional)
    """
    # 1. Create a new AWS SDK DynamoDb client. This client will be used to get item from the DynamoDB table
    ddb = boto3.client("dynamodb")

    # 2. Get item from the DynamoDB table. This item will be used to Get Encrypted DataKey Description
    key_to_get = {partition_key: {"S": partition_key_val}, sort_key_name: {"N": sort_key_value}}

    response = ddb.get_item(TableName=table_name, Key=key_to_get)

    returned_item = response.get("Item", {})
    if not returned_item:
        print(f"No item found with the key {partition_key}!")
        return

    # 3. Prepare the input for GetEncryptedDataKeyDescription method.
    # This input can be a DynamoDB item or a header. For now, we are giving input as a DynamoDB item
    # but users can also extract the header from the attribute "aws_dbe_head" in the DynamoDB table
    # and use it for GetEncryptedDataKeyDescription method.
    ddb_enc = DynamoDbEncryption(config=DynamoDbEncryptionConfig())

    input_union = GetEncryptedDataKeyDescriptionUnionItem(returned_item)

    input_obj = GetEncryptedDataKeyDescriptionInput(input=input_union)

    output = ddb_enc.get_encrypted_data_key_description(input=input_obj)

    # In the following code, we are giving input as header instead of a complete DynamoDB item
    # This code is provided solely to demo how the alternative approach works. So, it is commented.

    # header_attribute = "aws_dbe_head"
    # header = returned_item[header_attribute]["B"]
    # input_union = GetEncryptedDataKeyDescriptionUnion(
    #     header=header
    # )

    # Assert everything
    assert output.encrypted_data_key_description_output[0].key_provider_id == expected_key_provider_id

    if expected_key_provider_id.startswith("aws-kms"):
        assert output.encrypted_data_key_description_output[0].key_provider_info == expected_key_provider_info

    if output.encrypted_data_key_description_output[0].key_provider_id == "aws-kms-hierarchy":
        assert output.encrypted_data_key_description_output[0].branch_key_id == expected_branch_key_id
        assert output.encrypted_data_key_description_output[0].branch_key_version == expected_branch_key_version
