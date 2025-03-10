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
    """Wrapper class for a boto3 DynamoDB client providing transparent encryption/decryption of DynamoDB Client APIs.

    This class implements the complete boto3 DynamoDB client API, allowing it to serve as a
    drop-in replacement that transparently handles encryption and decryption of table data.
    
    The API matches the standard boto3 DynamoDB client interface:
    https://boto3.amazonaws.com/v1/documentation/api/latest/reference/services/dynamodb.html#client

    The supported operations for transparent encryption/decryption are:
        * put_item
        * get_item
        * query
        * scan
        * batch_write_item
        * batch_get_item
        * transact_get_items
        * transact_write_items

    Any other operations on EncryptedClient will defer to the underlying boto3 DynamoDB client implementation.

    Note: The update_item operation is not currently supported. Calling this operation will raise NotImplementedError.

    EncryptedClient can also return an EncryptedPaginator for transparent decryption of pages.
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
            expect_standard_dictionaries (Optional[bool]): Should we expect items to be standard Python
                dictionaries? This should only be set to True if you are using a client obtained
                from a service resource or table resource (ex: ``table.meta.client``). (default: False)
        """
        self._client = client
        self._encryption_config = encryption_config
        self._transformer = DynamoDbEncryptionTransforms(
            config = encryption_config
        )
        self._expect_standard_dictionaries = expect_standard_dictionaries

    
    def put_item(self, **kwargs) -> dict:
        """Puts a single item in a table. Encrypts the item before writing to DynamoDB.

        The parameters and return value match the boto3 DynamoDB put_item API:
        https://boto3.amazonaws.com/v1/documentation/api/latest/reference/services/dynamodb/client/put_item.html

        Args:
            TableName (str): Name of the table to write to
            Item (dict): A map of attribute name/value pairs to write to the table
            
        These are only a list of required args; see boto3 docs for complete request structure.

        Returns:
            dict: The response from DynamoDB.
            
        See boto3 docs for complete response structure.
        """
        return self._client_operation_logic(
            operation_input = kwargs,
            item_key = "Item",
            input_transform_method=self._transformer.put_item_input_transform,
            input_transform_shape=PutItemInputTransformInput,
            output_transform_method=self._transformer.put_item_output_transform,
            output_transform_shape=PutItemOutputTransformInput,
            client_method=self._client.put_item
        )
    
    def get_item(self, **kwargs) -> dict:
        """Gets a single item from a table. Decrypts the item after reading from DynamoDB.

        The parameters and return value match the boto3 DynamoDB get_item API:
        https://boto3.amazonaws.com/v1/documentation/api/latest/reference/services/dynamodb/client/get_item.html

        Args:
            TableName (str): Name of the table to read from
            Key (dict): The primary key of the item to retrieve

        These are only a list of required args; see boto3 docs for complete request structure.

        Returns:
            dict: The response from DynamoDB containing the requested item.
            
        See boto3 docs for complete response structure.
        """
        return self._client_operation_logic(
            operation_input = kwargs,
            item_key = "Key",
            input_transform_method=self._transformer.get_item_input_transform,
            input_transform_shape=GetItemInputTransformInput,
            output_transform_method=self._transformer.get_item_output_transform,
            output_transform_shape=GetItemOutputTransformInput,
            client_method=self._client.get_item
        )
    

    def query(self, **kwargs) -> dict:
        """Queries items from a table or index. Decrypts any returned items.

        The parameters and return value match the boto3 DynamoDB query API:
        https://boto3.amazonaws.com/v1/documentation/api/latest/reference/services/dynamodb/client/query.html

        Args:
            TableName (str): Name of the table to query

        These are only a list of required args; see boto3 docs for complete request structure.

        Returns:
            dict: The response from DynamoDB containing the matching items.
            
        See boto3 docs for complete response structure.
        """
        return self._client_operation_logic(
            operation_input = kwargs,
            item_key = "Key",
            input_transform_method=self._transformer.query_input_transform,
            input_transform_shape=QueryInputTransformInput,
            output_transform_method=self._transformer.query_output_transform,
            output_transform_shape=QueryOutputTransformInput,
            client_method=self._client.query
        )
    
    def scan(self, **kwargs) -> dict:
        """Scans an entire table or index. Decrypts any returned items.

        The parameters and return value match the boto3 DynamoDB scan API:
        https://boto3.amazonaws.com/v1/documentation/api/latest/reference/services/dynamodb/client/scan.html

        Args:
            TableName (str): Name of the table to scan

        These are only a list of required args; see boto3 docs for complete request structure.

        Returns:
            dict: The response from DynamoDB containing the scanned items.
            
        See boto3 docs for complete response structure.
        """
        return self._client_operation_logic(
            operation_input = kwargs,
            item_key = "Key",
            input_transform_method=self._transformer.scan_input_transform,
            input_transform_shape=ScanInputTransformInput,
            output_transform_method=self._transformer.scan_output_transform,
            output_transform_shape=ScanOutputTransformInput,
            client_method=self._client.scan
        )
    

    def batch_write_item(self, **kwargs) -> dict:
        """Puts or deletes multiple items in one or more tables. Encrypts items before writing.

        The parameters and return value match the boto3 DynamoDB batch_write_item API:
        https://boto3.amazonaws.com/v1/documentation/api/latest/reference/services/dynamodb/client/batch_write_item.html

        Args:
            RequestItems (dict): A map of table names to lists of write operations

        These are only a list of required args; see boto3 docs for complete request structure.

        Returns:
            dict: The response from DynamoDB.
            
        See boto3 docs for complete response structure.
        """
        return self._client_operation_logic(
            operation_input = kwargs,
            item_key = None,
            input_transform_method=self._transformer.batch_write_item_input_transform,
            input_transform_shape=BatchWriteItemInputTransformInput,
            output_transform_method=self._transformer.batch_write_item_output_transform,
            output_transform_shape=BatchWriteItemOutputTransformInput,
            client_method=self._client.batch_write_item,
            transform_operation_input_override=self._maybe_transform_batch_write_item_request_to_dynamodb_item,
            # transform_transformed_input_override=self._maybe_transform_batch_request_to_dict_item,
            transform_output_override=self._maybe_transform_batch_response_to_python_dict
        )
    
    def batch_get_item(self, **kwargs) -> dict:
        """Gets multiple items from one or more tables. Decrypts any returned items.

        The parameters and return value match the boto3 DynamoDB batch_get_item API:
        https://boto3.amazonaws.com/v1/documentation/api/latest/reference/services/dynamodb/client/batch_get_item.html

        Args:
            RequestItems (dict): A map of table names to lists of keys to retrieve

        These are only a list of required args; see boto3 docs for complete request structure.

        Returns:
            dict: The response from DynamoDB containing the requested items.
            
        See boto3 docs for complete response structure.
        """
        return self._client_operation_logic(
            operation_input = kwargs,
            item_key = None,
            input_transform_method=self._transformer.batch_get_item_input_transform,
            input_transform_shape=BatchGetItemInputTransformInput,
            output_transform_method=self._transformer.batch_get_item_output_transform,
            output_transform_shape=BatchGetItemOutputTransformInput,
            client_method=self._client.batch_get_item,
            transform_operation_input_override=self._maybe_transform_batch_get_item_request_to_dynamodb_item,
            transform_output_override=self._maybe_transform_batch_response_to_python_dict
        )
    

    def transact_get_items(self, **kwargs) -> dict:
        """Gets multiple items in a single transaction. Decrypts any returned items.

        The parameters and return value match the boto3 DynamoDB transact_get_items API:
        https://boto3.amazonaws.com/v1/documentation/api/latest/reference/services/dynamodb/client/transact_get_items.html

        Args:
            TransactItems (list): List of operations to perform in the transaction

        These are only a list of required args; see boto3 docs for complete request structure.

        Returns:
            dict: The response from DynamoDB containing the requested items.
            
        See boto3 docs for complete response structure.
        """
        return self._client_operation_logic(
            operation_input = kwargs,
            item_key = "Key",
            input_transform_method=self._transformer.transact_get_items_input_transform,
            input_transform_shape=TransactGetItemsInputTransformInput,
            output_transform_method=self._transformer.transact_get_items_output_transform,
            output_transform_shape=TransactGetItemsOutputTransformInput,
            client_method=self._client.transact_get_items
        )

    def transact_write_items(self, **kwargs) -> dict:
        """Performs multiple write operations in a single transaction. Encrypts items before writing.

        The parameters and return value match the boto3 DynamoDB transact_write_items API:
        https://boto3.amazonaws.com/v1/documentation/api/latest/reference/services/dynamodb/client/transact_write_items.html

        Args:
            TransactItems (list): List of operations to perform in the transaction

        These are only a list of required args; see boto3 docs for complete request structure.

        Returns:
            dict: The response from DynamoDB.
            
        See boto3 docs for complete response structure.
        """
        return self._client_operation_logic(
            operation_input = kwargs,
            item_key = "Key",
            input_transform_method=self._transformer.transact_write_items_input_transform,
            input_transform_shape=TransactWriteItemsInputTransformInput,
            output_transform_method=self._transformer.transact_write_items_output_transform,
            output_transform_shape=TransactWriteItemsOutputTransformInput,
            client_method=self._client.transact_write_items
        )

    def update_item(self, **kwargs):
        raise NotImplementedError('"update_item" is not yet implemented')
        
    def get_paginator(self, operation_name: str) -> EncryptedPaginator:
        """Get a paginator from the underlying client. If the paginator requested is for
        "scan" or "query", the paginator returned will transparently decrypt the returned items.

        Parameters:
            operation_name (str): Name of operation for which to get paginator
        """
        paginator = self._client.get_paginator(operation_name)

        if operation_name in ("scan", "query"):
            return EncryptedPaginator(
                paginator=paginator, encryption_config=self._encryption_config
            )
        else:
            # 
            return paginator
        
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
        transform_output_override=None,
    ):
        """
        Shared logic to interface between boto3 Client operation inputs and encryption transformers.
        This captures the shared pattern to call encryption/decryption transformer code
            and boto3 Clients across all methods in this class.
        """
        # Transform input from Python dictionary JSON to DynamoDB JSON if required
        if transform_operation_input_override:
            sdk_input = transform_operation_input_override(**operation_input)
        else:
            sdk_input = self._maybe_transform_request_to_dynamodb_item(item_key=item_key, **operation_input)

        print(f'{sdk_input=}')

        # Apply encryption transformation to the user-supplied input
        transformed_request = input_transform_method(
            input_transform_shape(
                sdk_input=sdk_input
            )
        ).transformed_input

        if transform_transformed_input_override:
            transformed_request = transform_transformed_input_override(**transformed_request)

        print(f'{transformed_request=}')

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
        dbesdk_response = self._copy_sdk_response_to_dbesdk_response(sdk_response, dbesdk_response)

        # Transform response from DynamoDB JSON to Python dictionary JSON if required
        if transform_output_override:
            dbesdk_response = transform_output_override(dbesdk_response)
        else:
            dbesdk_response = self._maybe_transform_response_to_python_dict(dbesdk_response)

        return dbesdk_response

    def _maybe_transform_request_to_dynamodb_item(self, item_key, **kwargs):
        if self._expect_standard_dictionaries:
            dynamodb_item = dict_to_ddb(kwargs[item_key])
            dynamodb_input = kwargs.copy()
            dynamodb_input[item_key] = dynamodb_item
        else:
            dynamodb_input = kwargs.copy()
        return dynamodb_input
    
    def _maybe_transform_batch_write_item_request_to_dynamodb_item(self, **kwargs):
        if not self._expect_standard_dictionaries:
            return kwargs
        
        tables = kwargs["RequestItems"]
        table_names = list(tables.keys())
        for table_name in table_names:
            requests = tables[table_name]
            output_requests = []
            for request in requests:
                request_name_list = list(request.keys())
                if len(request_name_list) > 1:
                    raise ValueError("Invalid JSON format")
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

    def _maybe_transform_batch_get_item_request_to_dynamodb_item(self, **kwargs):
        if not self._expect_standard_dictionaries:
            return kwargs
        
        tables = kwargs["RequestItems"]
        table_names = list(tables.keys())
        for table_name in table_names:
            keys = tables[table_name]["Keys"]
            output_keys = []
            for key in keys:
                dict_key = dict_to_ddb(key)
                output_keys.append(dict_key)
            kwargs["RequestItems"][table_name]["Keys"] = output_keys
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
            if "Item" in response:
                response["Item"] = ddb_to_dict(response["Item"])
        return response

    def _maybe_transform_batch_response_to_python_dict(self, response):
        if self._expect_standard_dictionaries:
            if "Responses" in response:
                for table_name, items in response["Responses"].items():
                    response["Responses"][table_name] = [ddb_to_dict(item) for item in items]
        return response

    def _copy_sdk_response_to_dbesdk_response(self, sdk_response, dbesdk_response):
        for sdk_response_key, sdk_response_value in sdk_response.items():
            if sdk_response_key not in dbesdk_response:
                dbesdk_response[sdk_response_key] = sdk_response_value
        return dbesdk_response

    def _get_protected_methods(self):
        """Return a list of all protected methods in the given object."""
        return [
            name for name, member in inspect.getmembers(self, predicate=inspect.ismethod)
            if name.startswith('_') and not name.startswith('__')
        ]


        
    def __getattr__(self, name):
        # Before calling __getattr__, the class will look at its own methods.
        # Any methods defined on the class are called before getting to this point.

        # __getattr__ doesn't find a class' protected methods by default.
        # if name in self._get_protected_methods():
        #     return getattr(self, name)
        # If the class doesn't override a boto3 method, defer to boto3 now.
        if hasattr(self._client, name):
            return getattr(self._client, name)
        else:
            raise AttributeError(f"'{self.__class__.__name__}' object has no attribute '{name}'")
