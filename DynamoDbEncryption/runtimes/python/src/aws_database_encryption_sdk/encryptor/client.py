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
    BatchGetItemInputTransformInput,
    BatchGetItemOutputTransformInput,
    ScanInputTransformInput,
    ScanOutputTransformInput,
    TransactGetItemsInputTransformInput,
    TransactGetItemsOutputTransformInput,
    TransactWriteItemsInputTransformInput,
    TransactWriteItemsOutputTransformInput,
    QueryInputTransformInput,
    QueryOutputTransformInput,
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
    _transformer: DynamoDbEncryptionTransforms

    def __init__(
        self,
        *,
        client: botocore.client.BaseClient,
        encryption_config: DynamoDbTablesEncryptionConfig,
    ):
        """
        Parameters:
        client (botocore.client.BaseClient): Initialized boto3 DynamoDB client
        encryption_config (DynamoDbTablesEncryptionConfig): Initialized DynamoDbTablesEncryptionConfig
        """
        self._client = client
        self._encryption_config = encryption_config
        self._transformer = DynamoDbEncryptionTransforms(
            config = encryption_config
        )

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
        transformed_request = self._transformer.put_item_input_transform(
            PutItemInputTransformInput(
                sdk_input = kwargs
            )
        ).transformed_input
        sdk_response = self._client.put_item(**transformed_request)
        dbesdk_response = self._transformer.put_item_output_transform(
            PutItemOutputTransformInput(
                original_input = kwargs,
                sdk_output = sdk_response,
            )
        ).transformed_output
        self._copy_sdk_response_to_dbesdk_response(sdk_response, dbesdk_response)
        return dbesdk_response
    
    def get_item(self, **kwargs):
        transformed_request = self._transformer.get_item_input_transform(
            GetItemInputTransformInput(
                sdk_input = kwargs
            )
        ).transformed_input
        sdk_response = self._client.get_item(**transformed_request)
        dbesdk_response = self._transformer.get_item_output_transform(
            GetItemOutputTransformInput(
                original_input = kwargs,
                sdk_output = sdk_response,
            )
        ).transformed_output
        self._copy_sdk_response_to_dbesdk_response(sdk_response, dbesdk_response)
        return dbesdk_response

    def batch_write_item(self, **kwargs):
        transformed_request = self._transformer.batch_write_item_input_transform(
            BatchWriteItemInputTransformInput(
                sdk_input = kwargs
            )
        ).transformed_input
        sdk_response = self._client.batch_write_item(**transformed_request)
        dbesdk_response = self._transformer.batch_write_item_output_transform(
            BatchWriteItemOutputTransformInput(
                original_input = kwargs,
                sdk_output = sdk_response,
            )
        ).transformed_output
        self._copy_sdk_response_to_dbesdk_response(sdk_response, dbesdk_response)
        return dbesdk_response

    def batch_get_item(self, **kwargs):
        transformed_request = self._transformer.batch_get_item_input_transform(
            BatchGetItemInputTransformInput(
                sdk_input = kwargs
            )
        ).transformed_input
        sdk_response = self._client.batch_get_item(**transformed_request)
        dbesdk_response = self._transformer.batch_get_item_output_transform(
            BatchGetItemOutputTransformInput(
                original_input = kwargs,
                sdk_output = sdk_response,
            )
        ).transformed_output
        self._copy_sdk_response_to_dbesdk_response(sdk_response, dbesdk_response)
        return dbesdk_response

    def scan(self, **kwargs):
        transformed_request = self._transformer.scan_input_transform(
            ScanInputTransformInput(
                sdk_input = kwargs
            )
        ).transformed_input
        sdk_response = self._client.scan(**transformed_request)
        dbesdk_response = self._transformer.scan_output_transform(
            ScanOutputTransformInput(
                original_input = kwargs,
                sdk_output = sdk_response,
            )
        ).transformed_output
        self._copy_sdk_response_to_dbesdk_response(sdk_response, dbesdk_response)
        return dbesdk_response

    def transact_get_items(self, **kwargs):
        transformed_request = self._transformer.transact_get_items_input_transform(
            TransactGetItemsInputTransformInput(
                sdk_input = kwargs
            )
        ).transformed_input
        sdk_response = self._client.transact_get_items(**transformed_request)
        dbesdk_response = self._transformer.transact_get_items_output_transform(
            TransactGetItemsOutputTransformInput(
                original_input = kwargs,
                sdk_output = sdk_response,
            )
        ).transformed_output
        self._copy_sdk_response_to_dbesdk_response(sdk_response, dbesdk_response)
        return dbesdk_response

    def transact_write_items(self, **kwargs):
        transformed_request = self._transformer.transact_write_items_input_transform(
            TransactWriteItemsInputTransformInput(
                sdk_input = kwargs
            )
        ).transformed_input
        sdk_response = self._client.transact_write_items(**transformed_request)
        dbesdk_response = self._transformer.transact_write_items_output_transform(
            TransactWriteItemsOutputTransformInput(
                original_input = kwargs,
                sdk_output = sdk_response,
            )
        ).transformed_output
        self._copy_sdk_response_to_dbesdk_response(sdk_response, dbesdk_response)
        return dbesdk_response

    def query(self, **kwargs):
        transformed_request = self._transformer.query_input_transform(
            QueryInputTransformInput(
                sdk_input = kwargs
            )
        ).transformed_input
        sdk_response = self._client.query(**transformed_request)
        dbesdk_response = self._transformer.query_output_transform(
            QueryOutputTransformInput(
                original_input = kwargs,
                sdk_output = sdk_response,
            )
        ).transformed_output
        self._copy_sdk_response_to_dbesdk_response(sdk_response, dbesdk_response)
        return dbesdk_response
        
    def __getattr__(self, name):
        # Before calling __getattr__, the class will look at its own methods.
        # Any methods defined on the class are called before getting to this point.

        # __getattr__ doesn't find a class' protected methods by default.
        if name in self._get_protected_methods():
            return getattr(self, name)
        # If the class doesn't override a boto3 method, defer to boto3 now.
        elif hasattr(self._client, name):
            return getattr(self._client, name)
        else:
            raise AttributeError(f"'{self.__class__.__name__}' object has no attribute '{name}'")