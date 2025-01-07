# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""High-level helper class to provide an encrypting wrapper for boto3 DynamoDB clients."""
from botocore.paginate import Paginator
import botocore.client
from typing import Callable, Optional

from aws_database_encryption_sdk.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.models import (
    GetItemInputTransformInput,
    GetItemOutputTransformInput,
    PutItemInputTransformInput,
    PutItemOutputTransformInput,
)
from aws_database_encryption_sdk.transform import (
    dict_to_ddb,
    ddb_to_dict,
)
from aws_database_encryption_sdk.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.client import (
    DynamoDbEncryptionTransforms
)
from aws_database_encryption_sdk.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models import (
    DynamoDbTablesEncryptionConfig,
)


class EncryptedClient:
    """
    A client that provides encryption and decryption for an underlying boto3 DynamoDB client.
    """

    _client: botocore.client.BaseClient
    _encryption_config: DynamoDbTablesEncryptionConfig
    _expect_standard_dictionaries: Optional[bool]
    _transformer: DynamoDbEncryptionTransforms

    def __init__(
        self,
        *,
        client: botocore.client.BaseClient,
        encryption_config: DynamoDbTablesEncryptionConfig,
        expect_standard_dictionaries: Optional[bool] = False,
    ):
        """
        Parameters:
        client (botocore.client.BaseClient): Initialized boto3 DynamoDB client
        encryption_config (DynamoDbTablesEncryptionConfig): Initialized DynamoDbTablesEncryptionConfig
        expect_standard_dictionaries (Optional[bool]): Should we expect items to be standard Python
            dictionaries? (default: False)
        """
        self._client = client
        self._encryption_config = encryption_config
        self._expect_standard_dictionaries = expect_standard_dictionaries
        self._transformer = DynamoDbEncryptionTransforms(
            config = encryption_config
        )

    def put_item(self, **kwargs):
        # TODO: refactor shared logic (DDB/Python conversions, client/table)
        if self._expect_standard_dictionaries:
            dynamodb_item = dict_to_ddb(kwargs["Item"])
            dynamodb_input = kwargs
            dynamodb_input["Item"] = dynamodb_item
        else:
            dynamodb_input = kwargs
        transformed_request = self._transformer.put_item_input_transform(
            PutItemInputTransformInput(
                sdk_input = dynamodb_input
            )
        ).transformed_input
        sdk_output = self._client.put_item(**transformed_request)
        transformed_response = self._transformer.put_item_output_transform(
            PutItemOutputTransformInput(
                original_input = dynamodb_input,
                sdk_output = sdk_output,
            )
        ).transformed_output
        response = transformed_response
        for sdk_output_key, sdk_output_value in sdk_output.items():
            if sdk_output_key not in transformed_response:
                response[sdk_output_key] = sdk_output_value
        # TODO: standard dicts transform output
        return response
    
    def get_item(self, **kwargs):
        if self._expect_standard_dictionaries:
            dynamodb_item = dict_to_ddb(kwargs["Key"])
            dynamodb_input = kwargs
            dynamodb_input["Key"] = dynamodb_item
        else:
            dynamodb_input = kwargs
        transformed_request = self._transformer.get_item_input_transform(
            GetItemInputTransformInput(
                sdk_input = dynamodb_input
            )
        ).transformed_input
        sdk_output = self._client.get_item(**transformed_request)
        transformed_response = self._transformer.get_item_output_transform(
            GetItemOutputTransformInput(
                original_input = dynamodb_input,
                sdk_output = sdk_output,
            )
        ).transformed_output
        response = transformed_response
        for sdk_output_key, sdk_output_value in sdk_output.items():
            if sdk_output_key not in transformed_response:
                response[sdk_output_key] = sdk_output_value
        if self._expect_standard_dictionaries:
            response["Item"] = ddb_to_dict(response["Item"])
        return response
