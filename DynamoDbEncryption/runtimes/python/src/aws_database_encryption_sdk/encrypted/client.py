# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""High-level helper class to provide an encrypting wrapper for boto3 DynamoDB clients."""
import botocore.client
from typing import Optional

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
    list_of_ddb_to_list_of_dict,
)
from aws_database_encryption_sdk.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.client import (
    DynamoDbEncryptionTransforms
)
from aws_database_encryption_sdk.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models import (
    DynamoDbTablesEncryptionConfig,
)
from aws_database_encryption_sdk.encrypted.paginator import EncryptedPaginator


class EncryptedClient:
    """Wrapper for a boto3 DynamoDB client that transparently items to/from DynamoDB.

    This class implements the complete boto3 DynamoDB client API, allowing it to serve as a
    drop-in replacement that transparently handles encryption and decryption of items.
    
    The API matches the standard boto3 DynamoDB client interface:
    https://boto3.amazonaws.com/v1/documentation/api/latest/reference/services/dynamodb.html#client

    This class will encrypt/decrypt items for the following operations:
        * put_item
        * get_item
        * query
        * scan
        * batch_write_item
        * batch_get_item
        * transact_get_items
        * transact_write_items

    Any other operations on this class will defer to the underlying boto3 DynamoDB client's implementation.

    Note: The update_item operation is not currently supported. Calling this operation will raise NotImplementedError.

    EncryptedClient can also return an EncryptedPaginator for transparent decryption of paginated results.
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
                from a service resource or table resource (ex: ``table.meta.client``).
                Note: expect_standard_dictionaries only transforms Items.
                (e.g. if True: put_item takes in a Python dictionary; get_item returns a Python dictionary.)
                expect_standard_dictionaries does NOT transform any other shapes.
                (e.g. Keys, AttributeValues are NOT transformed and are expected to be formatted as DynamoDB JSON.)
                (default: False).
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
            operation_input=kwargs,
            input_item_key="Item",
            input_item_transform_method=dict_to_ddb,
            input_transform_method=self._transformer.put_item_input_transform,
            input_transform_shape=PutItemInputTransformInput,
            output_transform_method=self._transformer.put_item_output_transform,
            output_transform_shape=PutItemOutputTransformInput,
            output_item_key="Attributes",
            output_item_transform_method=ddb_to_dict,
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
            operation_input=kwargs,
            input_item_key=None,
            input_item_transform_method=None,
            input_transform_method=self._transformer.get_item_input_transform,
            input_transform_shape=GetItemInputTransformInput,
            output_transform_method=self._transformer.get_item_output_transform,
            output_transform_shape=GetItemOutputTransformInput,
            client_method=self._client.get_item,
            output_item_key="Item",
            output_item_transform_method=ddb_to_dict,
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
            operation_input=kwargs,
            input_item_key=None,
            input_item_transform_method=None,
            input_transform_method=self._transformer.query_input_transform,
            input_transform_shape=QueryInputTransformInput,
            output_transform_method=self._transformer.query_output_transform,
            output_transform_shape=QueryOutputTransformInput,
            client_method=self._client.query,
            output_item_key="Items",
            output_item_transform_method=list_of_ddb_to_list_of_dict,
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
            operation_input=kwargs,
            input_item_key=None,
            input_item_transform_method=None,
            input_transform_method=self._transformer.scan_input_transform,
            input_transform_shape=ScanInputTransformInput,
            output_transform_method=self._transformer.scan_output_transform,
            output_transform_shape=ScanOutputTransformInput,
            client_method=self._client.scan,
            output_item_key="Items",
            output_item_transform_method=list_of_ddb_to_list_of_dict,
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
            operation_input=kwargs,
            input_item_key="RequestItems",
            input_item_transform_method=self._transform_batch_write_item_request_items_expect_standard_dictionaries,
            input_transform_method=self._transformer.batch_write_item_input_transform,
            input_transform_shape=BatchWriteItemInputTransformInput,
            output_transform_method=self._transformer.batch_write_item_output_transform,
            output_transform_shape=BatchWriteItemOutputTransformInput,
            client_method=self._client.batch_write_item,
            output_item_key="UnprocessedItems",
            output_item_transform_method=self._transform_batch_write_item_unprocessed_items_expect_standard_dictionaries,
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
            operation_input=kwargs,
            input_item_key=None,
            input_item_transform_method=None,
            input_transform_method=self._transformer.batch_get_item_input_transform,
            input_transform_shape=BatchGetItemInputTransformInput,
            output_transform_method=self._transformer.batch_get_item_output_transform,
            output_transform_shape=BatchGetItemOutputTransformInput,
            client_method=self._client.batch_get_item,
            output_item_key="Responses",
            output_item_transform_method=self._transform_batch_get_item_responses_expect_standard_dictionaries,
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
            operation_input=kwargs,
            input_item_key=None,
            input_item_transform_method=None,
            input_transform_method=self._transformer.transact_get_items_input_transform,
            input_transform_shape=TransactGetItemsInputTransformInput,
            output_transform_method=self._transformer.transact_get_items_output_transform,
            output_transform_shape=TransactGetItemsOutputTransformInput,
            client_method=self._client.transact_get_items,
            output_item_key="Responses",
            output_item_transform_method=self._transform_transact_get_items_responses_expect_standard_dictionaries,
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
            operation_input=kwargs,
            input_item_key="TransactItems",
            input_item_transform_method=self._transform_transact_write_items_transact_items_expect_standard_dictionaries,
            input_transform_method=self._transformer.transact_write_items_input_transform,
            input_transform_shape=TransactWriteItemsInputTransformInput,
            output_transform_method=self._transformer.transact_write_items_output_transform,
            output_transform_shape=TransactWriteItemsOutputTransformInput,
            client_method=self._client.transact_write_items,
            output_item_key=None,
            output_item_transform_method=None,
        )

    def update_item(self, **kwargs):
        raise NotImplementedError('"update_item" is not yet implemented')
        
    def get_paginator(self, operation_name: str) -> EncryptedPaginator:
        """Get a paginator from the underlying client. If the paginator requested is for
        "scan" or "query", the paginator returned will transparently decrypt the returned items.

        https://boto3.amazonaws.com/v1/documentation/api/latest/reference/services/dynamodb.html#paginators

        Parameters:
            operation_name (str): Name of operation for which to get paginator
        """
        paginator = self._client.get_paginator(operation_name)

        if operation_name in ("scan", "query"):
            return EncryptedPaginator(
                paginator=paginator, encryption_config=self._encryption_config
            )
        else:
            # The paginator can still be used for list_backups, list_tables, and list_tags_of_resource,
            # but there is nothing to encrypt/decrypt in these operations.
            return paginator
        
    def _client_operation_logic(
        self,
        *,
        operation_input,
        input_item_key,
        input_item_transform_method,
        input_transform_method,
        input_transform_shape,
        output_transform_method,
        output_transform_shape,
        client_method,
        output_item_key,
        output_item_transform_method,
    ):
        """
        Shared logic to interface between boto3 Client operation inputs and encryption transformers.
        This captures the shared pattern to call encryption/decryption transformer code
            and boto3 Clients across all methods in this class.
        """
        # Transform input from Python dictionary JSON to DynamoDB JSON if required
        sdk_input = operation_input.copy()
        if self._expect_standard_dictionaries and input_item_transform_method and input_item_key and input_item_key in sdk_input:
            sdk_input[input_item_key] = input_item_transform_method(operation_input[input_item_key])

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
        dbesdk_response = self._copy_sdk_response_to_dbesdk_response(sdk_response, dbesdk_response)

        # Transform response from DynamoDB JSON to Python dictionary JSON if required
        if self._expect_standard_dictionaries and output_item_transform_method and output_item_key and output_item_key in dbesdk_response:
            dbesdk_response[output_item_key] = output_item_transform_method(dbesdk_response[output_item_key])

        return dbesdk_response

    def _transform_batch_write_item_request_items_expect_standard_dictionaries(self, tables):
        return self._transform_map_of_table_to_list_of_requests_expect_standard_dictionaries(tables)
    
    def _transform_batch_write_item_unprocessed_items_expect_standard_dictionaries(self, tables):
        return self._transform_map_of_table_to_list_of_requests_expect_standard_dictionaries(tables)
    
    def _transform_batch_get_item_responses_expect_standard_dictionaries(self, tables):
        return self._transform_map_of_table_to_list_of_items_expect_standard_dictionaries(tables)

    def _transform_map_of_table_to_list_of_requests_expect_standard_dictionaries(self, tables):
        output_tables = {}
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
                    # Delete requests are based on Keys, which are expected to already be in DynamoDB JSON.
                    # Only Items can be in Python dictionary JSON.
                    boto3_request = request[request_name]
                else:
                    raise ValueError(f"Unknown batch_write_items method key: {request_name}")
                output_requests.append({request_name: boto3_request})
            output_tables[table_name] = output_requests
        return output_tables

    def _transform_map_of_table_to_list_of_items_expect_standard_dictionaries(self, tables):
        output_tables = {}
        table_names = list(tables.keys())
        for table_name in table_names:
            items = tables[table_name]
            output_items = []
            for item in items:
                output_items.append(ddb_to_dict(item))
            output_tables[table_name] = output_items
        return output_tables

    def _transform_transact_get_items_responses_expect_standard_dictionaries(self, items):
        output_items = []
        for item in items:
            output_items.append({"Item": ddb_to_dict(item["Item"])})
        return output_items

    def _transform_transact_write_items_transact_items_expect_standard_dictionaries(self, transact_items):
        output_transact_items = []
        for transact_item in transact_items:
            if "Put" in transact_item:
                transact_item["Put"]["Item"] = dict_to_ddb(transact_item["Put"]["Item"])
                output_transact_items.append(transact_item)
            elif "Delete" or "ConditionCheck" in transact_item:
                # Delete and ConditionCheck requests are based on Keys, which are expected to already be in DynamoDB JSON.
                output_transact_items.append(transact_item)
            elif "Update" in transact_item:
                # Update requests are not supported yet.
                raise NotImplementedError('"update_item" is not yet implemented')
            else:
                raise ValueError(f"Unknown transact_write_items method key: {transact_item}")
        return output_transact_items

    def _copy_sdk_response_to_dbesdk_response(self, sdk_response, dbesdk_response):
        for sdk_response_key, sdk_response_value in sdk_response.items():
            if sdk_response_key not in dbesdk_response:
                dbesdk_response[sdk_response_key] = sdk_response_value
        return dbesdk_response

    def __getattr__(self, name):
        # Before calling __getattr__, the class will look at its own methods.
        # Any methods defined on the class are called before getting to this point.

        # If the class doesn't override a boto3 method, defer to boto3 now.
        if hasattr(self._client, name):
            return getattr(self._client, name)
        else:
            raise AttributeError(f"'{self.__class__.__name__}' object has no attribute '{name}'")
