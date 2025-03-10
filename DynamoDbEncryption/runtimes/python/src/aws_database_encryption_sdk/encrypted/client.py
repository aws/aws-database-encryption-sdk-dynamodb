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
    DynamoDbTableEncryptionConfig,
)
from aws_database_encryption_sdk.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor.config import (
    DynamoDbItemEncryptorConfig,
)
from aws_database_encryption_sdk.encrypted.item import ItemEncryptor
from aws_database_encryption_sdk.encrypted.paginator import EncryptedPaginator

        

class EncryptedClient:
    """
    A client that provides encryption and decryption for an underlying boto3 DynamoDB client.
    """

    _client: botocore.client.BaseClient
    _encryption_config: DynamoDbTablesEncryptionConfig
    _transformer: DynamoDbEncryptionTransforms
    _expect_standard_dictionaries: bool

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
        """
        self._client = client
        self._encryption_config = encryption_config
        self._transformer = DynamoDbEncryptionTransforms(
            config = encryption_config
        )
        self._expect_standard_dictionaries = expect_standard_dictionaries

    def _maybe_transform_request_to_dynamodb_item(self, item_key, **kwargs):
        if self._expect_standard_dictionaries:
            dynamodb_item = dict_to_ddb(kwargs[item_key])
            dynamodb_input = kwargs.copy()
            dynamodb_input[item_key] = dynamodb_item
        else:
            dynamodb_input = kwargs.copy()
        return dynamodb_input
    
    def _maybe_transform_batch_request_to_dynamodb_item(self, **kwargs):
        if not self._expect_standard_dictionaries:
            return kwargs
        
        output_requests = []

        tables = kwargs["RequestItems"]
        table_names = list(tables.keys())
        if len(tables.keys()) > 1:
            raise ValueError("Table batch_write_item only supports 1 table in a request.")
        table_name = table_names[0]
        requests = tables[table_names[0]]
        for request in requests:
            request_name_list = list(request.keys())
            if len(request_name_list) > 1:
                raise ValueError("Cannot send more than one request in a single request")
            request_name = request_name_list[0]
            if request_name == "PutRequest":
                dict_request = dict_to_ddb(request[request_name]["Item"])
                boto3_request = {"Item": dict_request}
            elif request_name == "DeleteRequest":
                dict_request = dict_to_ddb(request[request_name]["Key"])
                boto3_request = {"Key": dict_request}
                output_requests.append({request_name: boto3_request})
            else:
                raise ValueError(f"Unknown batch_write_items method key: {request_name}")
            output_requests.append({request_name: boto3_request})
        kwargs["RequestItems"][table_name] = output_requests
        return kwargs
    
    def _maybe_transform_batch_request_to_dict_item(self, **kwargs):
        # TODO: I forget what vVv meant. I think it's ok to keep the same since internal client is created internally.
        # TODO separate standard dictionaries for this one (internal client expects dicts)
        if not self._expect_standard_dictionaries:
            return kwargs
        
        output_requests = []

        tables = kwargs["RequestItems"]
        table_names = list(tables.keys())
        if len(tables.keys()) > 1:
            raise ValueError("Table batch_write_item only supports 1 table in a request.")
        table_name = table_names[0]
        requests = tables[table_names[0]]
        for request in requests:
            request_name_list = list(request.keys())
            if len(request_name_list) > 1:
                raise ValueError("Cannot send more than one request in a single request")
            request_name = request_name_list[0]
            if request_name == "PutRequest":
                dict_request = ddb_to_dict(request[request_name]["Item"])
                boto3_request = {"Item": dict_request}
            elif request_name == "DeleteRequest":
                dict_request = ddb_to_dict(request[request_name]["Key"])
                boto3_request = {"Key": dict_request}
                output_requests.append({request_name: boto3_request})
            else:
                raise ValueError(f"Unknown batch_write_items method key: {request_name}")
            output_requests.append({request_name: boto3_request})
        kwargs["RequestItems"][table_name] = output_requests
        return kwargs
    
    def _maybe_transform_response_to_python_dict(self, response):
        if self._expect_standard_dictionaries:
            if hasattr(response, "Item"):
                response["Item"] = ddb_to_dict(response["Item"])

    def _maybe_transform_batch_response_to_python_dict(self, response):
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
        # sdk_input = self._maybe_transform_request_to_dynamodb_item(item_key = "Item", **kwargs)
        # transformed_request = self._transformer.put_item_input_transform(
        #     PutItemInputTransformInput(
        #         sdk_input = sdk_input
        #     )
        # ).transformed_input
        # sdk_response = self._client.put_item(**transformed_request)
        # dbesdk_response = self._transformer.put_item_output_transform(
        #     PutItemOutputTransformInput(
        #         original_input = sdk_input,
        #         sdk_output = sdk_response,
        #     )
        # ).transformed_output
        # self._copy_sdk_response_to_dbesdk_response(sdk_response, dbesdk_response)
        # self._maybe_transform_response_to_python_dict(dbesdk_response)
        # return dbesdk_response
        return self._client_operation_logic(
            operation_input = kwargs,
            item_key = "Item",
            input_transform_method=self._transformer.put_item_input_transform,
            input_transform_shape=PutItemInputTransformInput,
            output_transform_method=self._transformer.put_item_output_transform,
            output_transform_shape=PutItemOutputTransformInput,
            client_method=self._client.put_item
        )
    
    def get_item(self, **kwargs):
        # sdk_input = self._maybe_transform_request_to_dynamodb_item(item_key = "Key", **kwargs)
        # transformed_request = self._transformer.get_item_input_transform(
        #     GetItemInputTransformInput(
        #         sdk_input = sdk_input
        #     )
        # ).transformed_input
        # sdk_response = self._client.get_item(**transformed_request)
        # dbesdk_response = self._transformer.get_item_output_transform(
        #     GetItemOutputTransformInput(
        #         original_input = sdk_input,
        #         sdk_output = sdk_response,
        #     )
        # ).transformed_output
        # self._copy_sdk_response_to_dbesdk_response(sdk_response, dbesdk_response)
        # self._maybe_transform_response_to_python_dict(dbesdk_response)
        # return dbesdk_response
        return self._client_operation_logic(
            operation_input = kwargs,
            item_key = "Key",
            input_transform_method=self._transformer.get_item_input_transform,
            input_transform_shape=GetItemInputTransformInput,
            output_transform_method=self._transformer.get_item_output_transform,
            output_transform_shape=GetItemOutputTransformInput,
            client_method=self._client.get_item
        )

    def batch_write_item(self, **kwargs):
        # # print(f"batch_write_item pre {kwargs=}")
        # sdk_input = self._maybe_transform_batch_request_to_dynamodb_item(**kwargs)
        # # print(f"batch_write_item post {kwargs=}")
        # transformed_request = self._transformer.batch_write_item_input_transform(
        #     BatchWriteItemInputTransformInput(
        #         sdk_input = sdk_input
        #     )
        # ).transformed_input
        # # print(f"{self._client=}")
        # # print(f"{transformed_request=}")
        # transformed_request = self._maybe_transform_batch_request_to_dict_item(**transformed_request)
        # sdk_response = self._client.batch_write_item(**transformed_request)
        # dbesdk_response = self._transformer.batch_write_item_output_transform(
        #     BatchWriteItemOutputTransformInput(
        #         original_input = sdk_input,
        #         sdk_output = sdk_response,
        #     )
        # ).transformed_output
        # print(f'{sdk_response=}')
        # self._copy_sdk_response_to_dbesdk_response(sdk_response, dbesdk_response)
        # self._maybe_transform_response_to_python_dict(dbesdk_response)
        # print(f'{dbesdk_response=}')
        # return dbesdk_response
        # TODO I don't like this, revisit after mroe refactor
        return self._client_operation_logic(
            operation_input = kwargs,
            item_key = None,
            input_transform_method=self._transformer.batch_get_item_input_transform,
            input_transform_shape=BatchGetItemInputTransformInput,
            output_transform_method=self._transformer.batch_get_item_output_transform,
            output_transform_shape=BatchGetItemOutputTransformInput,
            client_method=self._client.batch_get_item,
            transform_operation_input_override=self._maybe_transform_batch_request_to_dynamodb_item,
            transform_transformed_input_override=self._maybe_transform_batch_request_to_dict_item,
        )
    

    def batch_get_item(self, **kwargs):
        # sdk_input = self._maybe_transform_request_to_dynamodb_item(item_key = None, **kwargs)
        # transformed_request = self._transformer.batch_get_item_input_transform(
        #     BatchGetItemInputTransformInput(
        #         sdk_input = sdk_input
        #     )
        # ).transformed_input
        # sdk_response = self._client.batch_get_item(**transformed_request)
        # dbesdk_response = self._transformer.batch_get_item_output_transform(
        #     BatchGetItemOutputTransformInput(
        #         original_input = sdk_input,
        #         sdk_output = sdk_response,
        #     )
        # ).transformed_output
        # self._copy_sdk_response_to_dbesdk_response(sdk_response, dbesdk_response)
        # self._maybe_transform_response_to_python_dict(dbesdk_response)
        # return dbesdk_response
        return self._client_operation_logic(
            operation_input = kwargs,
            item_key = None,
            input_transform_method=self._transformer.batch_get_item_input_transform,
            input_transform_shape=BatchGetItemInputTransformInput,
            output_transform_method=self._transformer.batch_get_item_output_transform,
            output_transform_shape=BatchGetItemOutputTransformInput,
            client_method=self._client.batch_get_item
        )
    
    def _client_operation_logic(
        self,
        *,
        operation_input,
        item_key,
        input_transform_method,
        input_transform_shape,
        output_transform_method,
        output_transform_shape,
        client_method,
        transform_operation_input_override=None,
        transform_transformed_input_override=None,
    ):
        """
        Shared logic to interface between boto3 Client operation inputs and encryption transformers.

        This method handles the transformation of inputs and outputs between Python dictionary JSON format
        and DynamoDB JSON format, applying encryption transformations as necessary.
        """
        # Transform input from Python dictionary JSON to DynamoDB JSON if required
        sdk_input = self._maybe_transform_request_to_dynamodb_item(item_key=item_key, **operation_input)

        # Apply encryption transformation to the user-supplied input
        transformed_request = input_transform_method(
            input_transform_shape(
                sdk_input=sdk_input
            )
        ).transformed_input

        # Call boto3 client method with transformed input and receive raw boto3 output
        sdk_response = client_method(**transformed_request)

        # Apply encryption transformation to the boto3 output
        dbesdk_response = output_transform_method(
            output_transform_shape(
                original_input=sdk_input,
                sdk_output=sdk_response,
            )
        ).transformed_output

        # Copy any missing fields from the SDK output to the response
        self._copy_sdk_response_to_dbesdk_response(sdk_response, dbesdk_response)

        # Transform response from DynamoDB JSON to Python dictionary JSON if required
        self._maybe_transform_response_to_python_dict(dbesdk_response)

        return dbesdk_response

    def scan(self, **kwargs):
        # sdk_input = self._maybe_transform_request_to_dynamodb_item(item_key = "Key", **kwargs)
        # transformed_request = self._transformer.scan_input_transform(
        #     ScanInputTransformInput(
        #         sdk_input = sdk_input
        #     )
        # ).transformed_input
        # sdk_response = self._client.scan(**transformed_request)
        # dbesdk_response = self._transformer.scan_output_transform(
        #     ScanOutputTransformInput(
        #         original_input = sdk_input,
        #         sdk_output = sdk_response,
        #     )
        # ).transformed_output
        # self._copy_sdk_response_to_dbesdk_response(sdk_response, dbesdk_response)
        # self._maybe_transform_response_to_python_dict(dbesdk_response)
        # return dbesdk_response
        return self._client_operation_logic(
            operation_input = kwargs,
            item_key = "Key",
            input_transform_method=self._transformer.scan_input_transform,
            input_transform_shape=ScanInputTransformInput,
            output_transform_method=self._transformer.scan_output_transform,
            output_transform_shape=ScanOutputTransformInput,
            client_method=self._client.batch_get_item
        )

    def transact_get_items(self, **kwargs):
        # sdk_input = self._maybe_transform_request_to_dynamodb_item(item_key = "Key", **kwargs)
        # transformed_request = self._transformer.transact_get_items_input_transform(
        #     TransactGetItemsInputTransformInput(
        #         sdk_input = sdk_input
        #     )
        # ).transformed_input
        # sdk_response = self._client.transact_get_items(**transformed_request)
        # dbesdk_response = self._transformer.transact_get_items_output_transform(
        #     TransactGetItemsOutputTransformInput(
        #         original_input = sdk_input,
        #         sdk_output = sdk_response,
        #     )
        # ).transformed_output
        # self._copy_sdk_response_to_dbesdk_response(sdk_response, dbesdk_response)
        # self._maybe_transform_response_to_python_dict(dbesdk_response)
        # return dbesdk_response
        return self._client_operation_logic(
            operation_input = kwargs,
            item_key = "Key",
            input_transform_method=self._transformer.transact_get_items_input_transform,
            input_transform_shape=TransactGetItemsInputTransformInput,
            output_transform_method=self._transformer.transact_get_items_output_transform,
            output_transform_shape=TransactGetItemsOutputTransformInput,
            client_method=self._client.transact_get_items
        )

    def transact_write_items(self, **kwargs):
        # sdk_input = self._maybe_transform_request_to_dynamodb_item(item_key = "Key", **kwargs)
        # transformed_request = self._transformer.transact_write_items_input_transform(
        #     TransactWriteItemsInputTransformInput(
        #         sdk_input = sdk_input
        #     )
        # ).transformed_input
        # sdk_response = self._client.transact_write_items(**transformed_request)
        # dbesdk_response = self._transformer.transact_write_items_output_transform(
        #     TransactWriteItemsOutputTransformInput(
        #         original_input = sdk_input,
        #         sdk_output = sdk_response,
        #     )
        # ).transformed_output
        # self._copy_sdk_response_to_dbesdk_response(sdk_response, dbesdk_response)
        # self._maybe_transform_response_to_python_dict(dbesdk_response)
        # return dbesdk_response
        return self._client_operation_logic(
            operation_input = kwargs,
            item_key = "Key",
            input_transform_method=self._transformer.transact_write_items_input_transform,
            input_transform_shape=TransactWriteItemsInputTransformInput,
            output_transform_method=self._transformer.transact_write_items_output_transform,
            output_transform_shape=TransactWriteItemsOutputTransformInput,
            client_method=self._client.transact_get_items
        )

    def query(self, **kwargs):
        # sdk_input = self._maybe_transform_request_to_dynamodb_item(item_key = "Key", **kwargs)
        # transformed_request = self._transformer.query_input_transform(
        #     QueryInputTransformInput(
        #         sdk_input = sdk_input
        #     )
        # ).transformed_input
        # sdk_response = self._client.query(**transformed_request)
        # dbesdk_response = self._transformer.query_output_transform(
        #     QueryOutputTransformInput(
        #         original_input = sdk_input,
        #         sdk_output = sdk_response,
        #     )
        # ).transformed_output
        # self._copy_sdk_response_to_dbesdk_response(sdk_response, dbesdk_response)
        # self._maybe_transform_response_to_python_dict(dbesdk_response)
        # return dbesdk_response
        return self._client_operation_logic(
            operation_input = kwargs,
            item_key = "Key",
            input_transform_method=self._transformer.query_input_transform,
            input_transform_shape=QueryInputTransformInput,
            output_transform_method=self._transformer.query_output_transform,
            output_transform_shape=QueryOutputTransformInput,
            client_method=self._client.transact_get_items
        )
        
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
        
    def get_paginator(self, operation_name: str) -> EncryptedPaginator:
        """Get a paginator from the underlying client. If the paginator requested is for
        "scan" or "query", the paginator returned will transparently decrypt the returned items.

        :param str operation_name: Name of operation for which to get paginator
        :returns: Paginator for name
        :rtype: :class:`botocore.paginate.Paginator` or :class:`EncryptedPaginator`
        """
        paginator = self._client.get_paginator(operation_name)

        if operation_name in ("scan", "query"):
            return EncryptedPaginator(
                paginator=paginator, encryption_config=self._encryption_config, operation_name=operation_name
            )
        else:
            # 
            return paginator
