# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""High-level helper class to provide an encrypting wrapper for boto3 DynamoDB clients."""
from copy import deepcopy
from typing import Any

import botocore.client

from aws_dbesdk_dynamodb.encrypted.boto3_interface import EncryptedBotoInterface
from aws_dbesdk_dynamodb.encrypted.paginator import EncryptedPaginator
from aws_dbesdk_dynamodb.internal.client_to_resource import ClientShapeToResourceShapeConverter
from aws_dbesdk_dynamodb.internal.resource_to_client import ResourceShapeToClientShapeConverter
from aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models import (
    DynamoDbTablesEncryptionConfig,
)
from aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.client import (
    DynamoDbEncryptionTransforms,
)
from aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.models import (
    BatchGetItemInputTransformInput,
    BatchGetItemOutputTransformInput,
    BatchWriteItemInputTransformInput,
    BatchWriteItemOutputTransformInput,
    GetItemInputTransformInput,
    GetItemOutputTransformInput,
    PutItemInputTransformInput,
    PutItemOutputTransformInput,
    QueryInputTransformInput,
    QueryOutputTransformInput,
    ScanInputTransformInput,
    ScanOutputTransformInput,
    TransactGetItemsInputTransformInput,
    TransactGetItemsOutputTransformInput,
    TransactWriteItemsInputTransformInput,
    TransactWriteItemsOutputTransformInput,
)


class EncryptedClient(EncryptedBotoInterface):
    """
    Wrapper for a boto3 DynamoDB client that transparently encrypts/decrypts items.

    This class implements the complete boto3 DynamoDB client API, allowing it to serve as a
    drop-in replacement that transparently handles encryption and decryption of items.

    The API matches the standard boto3 DynamoDB client interface:

    https://boto3.amazonaws.com/v1/documentation/api/latest/reference/services/dynamodb.html#client

    This class will encrypt/decrypt items for the following operations:

        * `put_item`
        * `get_item`
        * `query`
        * `scan`
        * `batch_write_item`
        * `batch_get_item`
        * `transact_get_items`
        * `transact_write_items`

    The `update_item` operation is not currently supported. Calling this operation will raise `NotImplementedError`.

    Any other operations on this class will defer to the underlying boto3 DynamoDB client's implementation.

    `EncryptedClient` can also return an `EncryptedPaginator` for transparent decryption of paginated results.
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
        expect_standard_dictionaries: bool | None = False,
    ):
        """
        Create an `EncryptedClient` object.

        Args:
            client (botocore.client.BaseClient): Initialized boto3 DynamoDB client
            encryption_config (DynamoDbTablesEncryptionConfig): Initialized DynamoDbTablesEncryptionConfig
            expect_standard_dictionaries (Optional[bool]): Does the underlying boto3 client expect items
                to be standard Python dictionaries? This should only be set to True if you are using a
                client obtained from a service resource or table resource (ex: `table.meta.client`).
                If this is True, EncryptedClient will expect item-like shapes to be
                standard Python dictionaries (default: False).

        """
        self._client = client
        self._encryption_config = encryption_config
        self._transformer = DynamoDbEncryptionTransforms(config=encryption_config)
        self._expect_standard_dictionaries = expect_standard_dictionaries
        self._resource_to_client_shape_converter = ResourceShapeToClientShapeConverter()
        self._client_to_resource_shape_converter = ClientShapeToResourceShapeConverter(delete_table_name=False)

    def put_item(self, **kwargs) -> dict[str, Any]:
        """
        Put a single item to a table. Encrypts the item before writing to DynamoDB.

        The input and output dicts' keys match the input and output dicts' keys for the boto3 DynamoDB `put_item` API:

        https://boto3.amazonaws.com/v1/documentation/api/latest/reference/services/dynamodb/client/put_item.html

        Args:
            **kwargs: Keyword arguments to pass to the operation. These match the boto3 `put_item` API parameters' argument names.
            The "Item" argument will be encrypted locally before being written to DynamoDB.

        Returns:
            dict: The response from DynamoDB. This matches the boto3 `put_item` API response shape.

        """
        return self._client_operation_logic(
            operation_input=kwargs,
            input_item_to_ddb_transform_method=self._resource_to_client_shape_converter.put_item_request,
            input_item_to_dict_transform_method=self._client_to_resource_shape_converter.put_item_request,
            input_transform_method=self._transformer.put_item_input_transform,
            input_transform_shape=PutItemInputTransformInput,
            output_transform_method=self._transformer.put_item_output_transform,
            output_transform_shape=PutItemOutputTransformInput,
            output_item_to_ddb_transform_method=self._resource_to_client_shape_converter.put_item_response,
            output_item_to_dict_transform_method=self._client_to_resource_shape_converter.put_item_response,
            client_method=self._client.put_item,
        )

    def get_item(self, **kwargs) -> dict[str, Any]:
        """
        Get a single item from a table. Decrypts the item after reading from DynamoDB.

        The parameters and return value match the boto3 DynamoDB get_item API:

        https://boto3.amazonaws.com/v1/documentation/api/latest/reference/services/dynamodb/client/get_item.html

        Args:
            **kwargs: Keyword arguments to pass to the operation. These match the boto3 get_item API parameters.

        Returns:
            dict: The response from DynamoDB. This matches the boto3 get_item API response.
            The "Item" field will be decrypted locally after being read from DynamoDB.

        """
        return self._client_operation_logic(
            operation_input=kwargs,
            input_item_to_ddb_transform_method=self._resource_to_client_shape_converter.get_item_request,
            input_item_to_dict_transform_method=self._client_to_resource_shape_converter.get_item_request,
            input_transform_method=self._transformer.get_item_input_transform,
            input_transform_shape=GetItemInputTransformInput,
            output_transform_method=self._transformer.get_item_output_transform,
            output_transform_shape=GetItemOutputTransformInput,
            client_method=self._client.get_item,
            output_item_to_ddb_transform_method=self._resource_to_client_shape_converter.get_item_response,
            output_item_to_dict_transform_method=self._client_to_resource_shape_converter.get_item_response,
        )

    def query(self, **kwargs) -> dict[str, Any]:
        """
        Query items from a table or index. Decrypts any returned items.

        The parameters and return value match the boto3 DynamoDB query API:

        https://boto3.amazonaws.com/v1/documentation/api/latest/reference/services/dynamodb/client/query.html

        Args:
            **kwargs: Keyword arguments to pass to the operation. These match the boto3 query API parameters.

        Returns:
            dict: The response from DynamoDB. This matches the boto3 query API response.
                The "Items" field will be decrypted locally after being read from DynamoDB.

        """
        return self._client_operation_logic(
            operation_input=kwargs,
            input_item_to_ddb_transform_method=self._resource_to_client_shape_converter.query_request,
            input_item_to_dict_transform_method=self._client_to_resource_shape_converter.query_request,
            input_transform_method=self._transformer.query_input_transform,
            input_transform_shape=QueryInputTransformInput,
            output_transform_method=self._transformer.query_output_transform,
            output_transform_shape=QueryOutputTransformInput,
            client_method=self._client.query,
            output_item_to_dict_transform_method=self._client_to_resource_shape_converter.query_response,
            output_item_to_ddb_transform_method=self._resource_to_client_shape_converter.query_response,
        )

    def scan(self, **kwargs) -> dict[str, Any]:
        """
        Scan an entire table or index. Decrypts any returned items.

        The parameters and return value match the boto3 DynamoDB scan API:

        https://boto3.amazonaws.com/v1/documentation/api/latest/reference/services/dynamodb/client/scan.html

        Args:
            **kwargs: Keyword arguments to pass to the operation. These match the boto3 scan API parameters.

        Returns:
            dict: The response from DynamoDB. This matches the boto3 scan API response.
                The "Items" field will be decrypted locally after being read from DynamoDB.

        """
        return self._client_operation_logic(
            operation_input=kwargs,
            input_item_to_ddb_transform_method=self._resource_to_client_shape_converter.scan_request,
            input_item_to_dict_transform_method=self._client_to_resource_shape_converter.scan_request,
            input_transform_method=self._transformer.scan_input_transform,
            input_transform_shape=ScanInputTransformInput,
            output_transform_method=self._transformer.scan_output_transform,
            output_transform_shape=ScanOutputTransformInput,
            client_method=self._client.scan,
            output_item_to_dict_transform_method=self._client_to_resource_shape_converter.scan_response,
            output_item_to_ddb_transform_method=self._resource_to_client_shape_converter.scan_response,
        )

    def batch_write_item(self, **kwargs) -> dict[str, Any]:
        """
        Put or delete multiple items in one or more tables.

        For put operations, encrypts items before writing.

        The parameters and return value match the boto3 DynamoDB batch_write_item API:

        https://boto3.amazonaws.com/v1/documentation/api/latest/reference/services/dynamodb/client/batch_write_item.html

        Args:
            **kwargs: Keyword arguments to pass to the operation. These match the boto3 batch_write_item API parameters.
                Any put operations in the "RequestItems" argument will be encrypted locally
                before being written to DynamoDB.

        Returns:
            dict: The response from DynamoDB. This matches the boto3 batch_write_item API response.

        """
        return self._client_operation_logic(
            operation_input=kwargs,
            input_item_to_ddb_transform_method=self._resource_to_client_shape_converter.batch_write_item_request,
            input_item_to_dict_transform_method=self._client_to_resource_shape_converter.batch_write_item_request,
            input_transform_method=self._transformer.batch_write_item_input_transform,
            input_transform_shape=BatchWriteItemInputTransformInput,
            output_transform_method=self._transformer.batch_write_item_output_transform,
            output_transform_shape=BatchWriteItemOutputTransformInput,
            client_method=self._client.batch_write_item,
            output_item_to_dict_transform_method=self._client_to_resource_shape_converter.batch_write_item_response,
            output_item_to_ddb_transform_method=self._resource_to_client_shape_converter.batch_write_item_response,
        )

    def batch_get_item(self, **kwargs) -> dict[str, Any]:
        """
        Get multiple items from one or more tables. Decrypts any returned items.

        The parameters and return value match the boto3 DynamoDB batch_get_item API:

        https://boto3.amazonaws.com/v1/documentation/api/latest/reference/services/dynamodb/client/batch_get_item.html

        Args:
            **kwargs: Keyword arguments to pass to the operation. These match the boto3 batch_get_item API parameters.

        Returns:
            dict: The response from DynamoDB. This matches the boto3 batch_get_item API response.
                The "Responses" field will be decrypted locally after being read from DynamoDB.

        """
        return self._client_operation_logic(
            operation_input=kwargs,
            input_item_to_ddb_transform_method=self._resource_to_client_shape_converter.batch_get_item_request,
            input_item_to_dict_transform_method=self._client_to_resource_shape_converter.batch_get_item_request,
            input_transform_method=self._transformer.batch_get_item_input_transform,
            input_transform_shape=BatchGetItemInputTransformInput,
            output_transform_method=self._transformer.batch_get_item_output_transform,
            output_transform_shape=BatchGetItemOutputTransformInput,
            client_method=self._client.batch_get_item,
            output_item_to_dict_transform_method=self._client_to_resource_shape_converter.batch_get_item_response,
            output_item_to_ddb_transform_method=self._resource_to_client_shape_converter.batch_get_item_response,
        )

    def transact_get_items(self, **kwargs) -> dict[str, Any]:
        """
        Get multiple items in a single transaction. Decrypts any returned items.

        The parameters and return value match the boto3 DynamoDB transact_get_items API:

        https://boto3.amazonaws.com/v1/documentation/api/latest/reference/services/dynamodb/client/transact_get_items.html

        Args:
            **kwargs: Keyword arguments to pass to the operation. These match the boto3 transact_get_items API
                parameters.

        Returns:
            dict: The response from DynamoDB. This matches the boto3 transact_get_items API response.

        """
        return self._client_operation_logic(
            operation_input=kwargs,
            input_item_to_ddb_transform_method=self._resource_to_client_shape_converter.transact_get_items_request,
            input_item_to_dict_transform_method=self._client_to_resource_shape_converter.transact_get_items_request,
            input_transform_method=self._transformer.transact_get_items_input_transform,
            input_transform_shape=TransactGetItemsInputTransformInput,
            output_transform_method=self._transformer.transact_get_items_output_transform,
            output_transform_shape=TransactGetItemsOutputTransformInput,
            client_method=self._client.transact_get_items,
            output_item_to_dict_transform_method=self._client_to_resource_shape_converter.transact_get_items_response,
            output_item_to_ddb_transform_method=self._resource_to_client_shape_converter.transact_get_items_response,
        )

    def transact_write_items(self, **kwargs) -> dict[str, Any]:
        """
        Perform multiple write operations in a single transaction.

        For put operations, encrypts items before writing.

        The parameters and return value match the boto3 DynamoDB transact_write_items API:

        https://boto3.amazonaws.com/v1/documentation/api/latest/reference/services/dynamodb/client/transact_write_items.html

        Args:
            **kwargs: Keyword arguments to pass to the operation. These match the boto3 transact_write_items API
                parameters. Any put operations in the "TransactItems" argument will be encrypted locally
                before being written to DynamoDB.

        Returns:
            dict: The response from DynamoDB. This matches the boto3 transact_write_items API response.

        """
        return self._client_operation_logic(
            operation_input=kwargs,
            input_item_to_ddb_transform_method=self._resource_to_client_shape_converter.transact_write_items_request,
            input_item_to_dict_transform_method=self._client_to_resource_shape_converter.transact_write_items_request,
            input_transform_method=self._transformer.transact_write_items_input_transform,
            input_transform_shape=TransactWriteItemsInputTransformInput,
            output_transform_method=self._transformer.transact_write_items_output_transform,
            output_transform_shape=TransactWriteItemsOutputTransformInput,
            client_method=self._client.transact_write_items,
            output_item_to_dict_transform_method=self._client_to_resource_shape_converter.transact_write_items_response,
            output_item_to_ddb_transform_method=self._resource_to_client_shape_converter.transact_write_items_response,
        )

    def update_item(self, **kwargs):
        """
        Not implemented. Raises NotImplementedError.

        Args:
            **kwargs: Any arguments passed to this method

        Raises:
            NotImplementedError: This operation is not yet implemented

        """
        raise NotImplementedError('"update_item" is not yet implemented')

    def get_paginator(self, operation_name: str) -> EncryptedPaginator | botocore.client.Paginator:
        """
        Get a paginator from the underlying client.

        If the paginator requested is for  "scan" or "query", the paginator returned will
        transparently decrypt the returned items.

        https://boto3.amazonaws.com/v1/documentation/api/latest/reference/services/dynamodb.html#paginators

        Args:
            operation_name (str): Name of operation for which to get paginator

        Returns:
            EncryptedPaginator | botocore.client.Paginator: A paginator that will transparently decrypt items
                for scan/query operations, or the standard paginator for other operations.

        """
        paginator = self._client.get_paginator(operation_name)

        if operation_name in ("scan", "query"):
            return EncryptedPaginator(
                paginator=paginator,
                encryption_config=self._encryption_config,
                expect_standard_dictionaries=self._expect_standard_dictionaries,
            )
        else:
            # The paginator can still be used for list_backups, list_tables, and list_tags_of_resource,
            # but there is nothing to encrypt/decrypt in these operations.
            return paginator

    def _client_operation_logic(
        self,
        *,
        operation_input: dict[str, Any],
        input_item_to_ddb_transform_method: callable,
        input_item_to_dict_transform_method: callable,
        input_transform_method: Any,
        input_transform_shape: Any,
        output_transform_method: Any,
        output_transform_shape: Any,
        client_method: Any,
        output_item_to_ddb_transform_method: callable,
        output_item_to_dict_transform_method: callable,
    ) -> dict[str, Any]:
        """
        Shared logic to interface between boto3 Client operation inputs and encryption transformers.

        This captures the shared pattern to call encryption/decryption transformer code
        and boto3 Clients across all methods in this class.

        Args:
            operation_input: The input to the operation
            input_item_to_ddb_transform_method: Method to transform input items from standard dictionaries
                to DynamoDB JSON
            input_item_to_dict_transform_method: Method to transform input items from DynamoDB JSON
                to standard dictionaries
            input_transform_method: The method to transform the input for encryption
            input_transform_shape: The shape of the input transform
            output_transform_method: The method to transform the output for decryption
            output_transform_shape: The shape of the output transform
            client_method: The underlying client method to call
            output_item_to_ddb_transform_method: Method to transform output items from standard dictionaries
                to DynamoDB JSON
            output_item_to_dict_transform_method: Method to transform output items from DynamoDB JSON
                to standard dictionaries

        Returns:
            dict: The transformed response from DynamoDB

        """
        # If _expect_standard_dictionaries is true, input items are expected to be standard dictionaries,
        # and need to be converted to DDB-JSON before encryption.
        sdk_input = deepcopy(operation_input)
        if self._expect_standard_dictionaries:
            if "TableName" in sdk_input:
                self._resource_to_client_shape_converter.table_name = sdk_input["TableName"]
            sdk_input = input_item_to_ddb_transform_method(sdk_input)

        # Apply DBESDK transformation to the input
        transformed_request = input_transform_method(input_transform_shape(sdk_input=sdk_input)).transformed_input

        # If _expect_standard_dictionaries is true, the boto3 client expects items to be standard dictionaries,
        # and needs to convert the DDB-JSON to a standard dictionary before passing the request to the boto3 client.
        if self._expect_standard_dictionaries:
            transformed_request = input_item_to_dict_transform_method(transformed_request)

        sdk_response = client_method(**transformed_request)

        # If _expect_standard_dictionaries is true, the boto3 client returns items as standard dictionaries,
        # and needs to convert the standard dictionary to DDB-JSON before passing the response to the DBESDK.
        if self._expect_standard_dictionaries:
            sdk_response = output_item_to_ddb_transform_method(sdk_response)

        # Apply DBESDK transformation to the boto3 output
        dbesdk_response = output_transform_method(
            output_transform_shape(
                original_input=sdk_input,
                sdk_output=sdk_response,
            )
        ).transformed_output

        # Copy any missing fields from the SDK output to the response (e.g. ConsumedCapacity)
        dbesdk_response = self._copy_sdk_response_to_dbesdk_response(sdk_response, dbesdk_response)

        # If _expect_standard_dictionaries is true, output items are expected to be standard dictionaries,
        # and need to be converted from DDB-JSON to a standard dictionary before returning the response.
        if self._expect_standard_dictionaries:
            dbesdk_response = output_item_to_dict_transform_method(dbesdk_response)

        return dbesdk_response

    @property
    def _boto_client_attr_name(self) -> str:
        """
        Name of the attribute containing the underlying boto3 client.

        Returns:
            str: '_client'

        """
        return "_client"
