# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""High-level helper class to provide an encrypting wrapper for boto3 DynamoDB clients."""
from botocore.paginate import Paginator
import botocore.client
from typing import Callable, Optional
import inspect

from aws_database_encryption_sdk.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.models import (
    GetItemInputTransformInput,
    GetItemOutputTransformInput,
    PutItemInputTransformInput,
    PutItemOutputTransformInput,
    BatchWriteItemInputTransformInput,
    BatchWriteItemOutputTransformInput,
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

    def _maybe_transform_request_to_dynamodb_item(self, item_key, **kwargs):
        if self._expect_standard_dictionaries:
            dynamodb_item = dict_to_ddb(kwargs[item_key])
            dynamodb_input = kwargs
            dynamodb_input[item_key] = dynamodb_item
        else:
            dynamodb_input = kwargs
        return dynamodb_input

    def _maybe_transform_response_item_to_python_dict(self, response):
        if self._expect_standard_dictionaries:
            if hasattr(response, "Item"):
                response["Item"] = ddb_to_dict(response["Item"])

    def _copy_sdk_response_to_dbesdk_response(self, sdk_response, dbesdk_response):
        for sdk_response_key, sdk_response_value in sdk_response.items():
            if sdk_response_key not in dbesdk_response:
                dbesdk_response[sdk_response_key] = sdk_response_value

    def _get_protected_methods(self):
        """Return a list of all protected methods in the given object."""
        return [
            name for name, member in inspect.getmembers(self, predicate=inspect.ismethod)
            if name.startswith('_') and not name.startswith('__')
        ]

    def put_item(self, **kwargs):
        # TODO: refactor shared logic (DDB/Python conversions, client/table)
        dynamodb_input = self._maybe_transform_request_to_dynamodb_item(item_key = "Item", **kwargs)
        # if self._expect_standard_dictionaries:
        #     dynamodb_item = dict_to_ddb(kwargs["Item"])
        #     dynamodb_input = kwargs
        #     dynamodb_input["Item"] = dynamodb_item
        # else:
        #     dynamodb_input = kwargs
        transformed_request = self._transformer.put_item_input_transform(
            PutItemInputTransformInput(
                sdk_input = dynamodb_input
            )
        ).transformed_input
        sdk_response = self._client.put_item(**transformed_request)
        dbesdk_response = self._transformer.put_item_output_transform(
            PutItemOutputTransformInput(
                original_input = dynamodb_input,
                sdk_output = sdk_response,
            )
        ).transformed_output
        self._copy_sdk_response_to_dbesdk_response(sdk_response, dbesdk_response)
        self._maybe_transform_response_item_to_python_dict(dbesdk_response)
        return dbesdk_response
    
    def get_item(self, **kwargs):
        dynamodb_input = self._maybe_transform_request_to_dynamodb_item(item_key = "Key", **kwargs)
        transformed_request = self._transformer.get_item_input_transform(
            GetItemInputTransformInput(
                sdk_input = dynamodb_input
            )
        ).transformed_input
        sdk_response = self._client.get_item(**transformed_request)
        dbesdk_response = self._transformer.get_item_output_transform(
            GetItemOutputTransformInput(
                original_input = dynamodb_input,
                sdk_output = sdk_response,
            )
        ).transformed_output
        self._copy_sdk_response_to_dbesdk_response(sdk_response, dbesdk_response)
        self._maybe_transform_response_item_to_python_dict(dbesdk_response)
        return dbesdk_response

    def batch_write_item(self, **kwargs):
        # dynamodb_input = self._maybe_transform_request_to_dynamodb_item(item_key = "Key", **kwargs)
        dynamodb_input = kwargs
        transformed_request = self._transformer.batch_write_item_input_transform(
            BatchWriteItemInputTransformInput(
                sdk_input = dynamodb_input
            )
        ).transformed_input
        sdk_response = self._client.batch_write_item(**transformed_request)
        dbesdk_response = self._transformer.batch_write_item_output_transform(
            BatchWriteItemOutputTransformInput(
                original_input = dynamodb_input,
                sdk_output = sdk_response,
            )
        ).transformed_output
        self._copy_sdk_response_to_dbesdk_response(sdk_response, dbesdk_response)
        # self._maybe_transform_response_to_python_dict(dbesdk_response)
        return dbesdk_response
        
    def __getattr__(self, name):
        if hasattr(self._client, name):
            print(f'calling underlyign client {name=}')
            return getattr(self._client, name)
        # __getattr__ doesn't find protected methods by default.
        elif name in self._get_protected_methods():
            return getattr(self, name)
        else:
            raise KeyError("idk still")