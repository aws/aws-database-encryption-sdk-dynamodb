# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""High-level helper class to provide an encrypting wrapper for boto3 DynamoDB tables."""
from collections.abc import Callable
from typing import Any

from boto3.dynamodb.table import BatchWriter
from boto3.resources.base import ServiceResource

from aws_dbesdk_dynamodb.encrypted.boto3_interface import EncryptedBotoInterface
from aws_dbesdk_dynamodb.encrypted.client import EncryptedClient
from aws_dbesdk_dynamodb.internal.client_to_resource import ClientShapeToResourceShapeConverter
from aws_dbesdk_dynamodb.internal.resource_to_client import ResourceShapeToClientShapeConverter
from aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models import (
    DynamoDbTablesEncryptionConfig,
)
from aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.client import (
    DynamoDbEncryptionTransforms,
)
from aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.models import (
    GetItemInputTransformInput,
    GetItemOutputTransformInput,
    PutItemInputTransformInput,
    PutItemOutputTransformInput,
    QueryInputTransformInput,
    QueryOutputTransformInput,
    ScanInputTransformInput,
    ScanOutputTransformInput,
)


class EncryptedTable(EncryptedBotoInterface):
    """
    Wrapper for a boto3 DynamoDB table that transparently encrypts/decrypts items.

    This class implements the complete boto3 DynamoDB table API, allowing it to serve as a
    drop-in replacement that transparently handles encryption and decryption of items.

    The API matches the standard boto3 DynamoDB table interface:
    https://boto3.amazonaws.com/v1/documentation/api/latest/reference/services/dynamodb/table.html

    This class will encrypt/decrypt items for the following operations:
        * put_item
        * get_item
        * query
        * scan

    Calling batch_writer() will return a BatchWriter that transparently encrypts batch write requests.

    Any other operations on this class will defer to the underlying boto3 DynamoDB Table's implementation
        and will not be encrypted/decrypted.

    Note: The update_item operation is not currently supported. Calling this operation will raise NotImplementedError.
    """

    def __init__(
        self,
        *,
        table: ServiceResource,
        encryption_config: DynamoDbTablesEncryptionConfig,
    ):
        """
        Create an EncryptedTable object.

        Args:
            table (ServiceResource): Initialized boto3 DynamoDB table
            encryption_config (DynamoDbTablesEncryptionConfig): Initialized DynamoDbTablesEncryptionConfig

        """
        self._table = table
        self._encryption_config = encryption_config
        self._transformer = DynamoDbEncryptionTransforms(config=encryption_config)
        self._client_shape_to_resource_shape_converter = ClientShapeToResourceShapeConverter()
        self._resource_shape_to_client_shape_converter = ResourceShapeToClientShapeConverter(
            table_name=self._table.table_name
        )

    def put_item(self, **kwargs) -> dict[str, Any]:
        """
        Put a single item to the table. Encrypts the item before writing to DynamoDB.

        The parameters and return value match the boto3 DynamoDB table put_item API:
        https://boto3.amazonaws.com/v1/documentation/api/latest/reference/services/dynamodb/table/put_item.html

        Args:
            **kwargs: Keyword arguments to pass to the operation. These match the boto3 put_item API parameters.

        Returns:
            dict: The response from DynamoDB. This matches the boto3 put_item API response.

        """
        return self._table_operation_logic(
            operation_input=kwargs,
            input_encryption_transform_method=self._transformer.put_item_input_transform,
            input_encryption_transform_shape=PutItemInputTransformInput,
            input_resource_to_client_shape_transform_method=self._resource_shape_to_client_shape_converter.put_item_request,
            input_client_to_resource_shape_transform_method=self._client_shape_to_resource_shape_converter.put_item_request,
            output_encryption_transform_method=self._transformer.put_item_output_transform,
            output_encryption_transform_shape=PutItemOutputTransformInput,
            output_resource_to_client_shape_transform_method=self._resource_shape_to_client_shape_converter.put_item_response,
            output_client_to_resource_shape_transform_method=self._client_shape_to_resource_shape_converter.put_item_response,
            table_method=self._table.put_item,
        )

    def get_item(self, **kwargs) -> dict[str, Any]:
        """
        Get a single item from the table. Decrypts the item after reading from DynamoDB.

        The parameters and return value match the boto3 DynamoDB table get_item API:
        https://boto3.amazonaws.com/v1/documentation/api/latest/reference/services/dynamodb/table/get_item.html

        Args:
            **kwargs: Keyword arguments to pass to the operation. These match the boto3 get_item API parameters.

        Returns:
            dict: The response from DynamoDB. This matches the boto3 get_item API response.

        """
        return self._table_operation_logic(
            operation_input=kwargs,
            input_encryption_transform_method=self._transformer.get_item_input_transform,
            input_encryption_transform_shape=GetItemInputTransformInput,
            input_resource_to_client_shape_transform_method=self._resource_shape_to_client_shape_converter.get_item_request,
            input_client_to_resource_shape_transform_method=self._client_shape_to_resource_shape_converter.get_item_request,
            output_encryption_transform_method=self._transformer.get_item_output_transform,
            output_encryption_transform_shape=GetItemOutputTransformInput,
            output_resource_to_client_shape_transform_method=self._resource_shape_to_client_shape_converter.get_item_response,
            output_client_to_resource_shape_transform_method=self._client_shape_to_resource_shape_converter.get_item_response,
            table_method=self._table.get_item,
        )

    def query(self, **kwargs) -> dict[str, Any]:
        """
        Query items from the table or index. Decrypts any returned items.

        The parameters and return value match the boto3 DynamoDB table query API:
        https://boto3.amazonaws.com/v1/documentation/api/latest/reference/services/dynamodb/table/query.html

        Args:
            **kwargs: Keyword arguments to pass to the operation. These match the boto3 query API parameters.

        Returns:
            dict: The response from DynamoDB. This matches the boto3 query API response.

        """
        return self._table_operation_logic(
            operation_input=kwargs,
            input_encryption_transform_method=self._transformer.query_input_transform,
            input_encryption_transform_shape=QueryInputTransformInput,
            input_resource_to_client_shape_transform_method=self._resource_shape_to_client_shape_converter.query_request,
            input_client_to_resource_shape_transform_method=self._client_shape_to_resource_shape_converter.query_request,
            output_encryption_transform_method=self._transformer.query_output_transform,
            output_encryption_transform_shape=QueryOutputTransformInput,
            output_resource_to_client_shape_transform_method=self._resource_shape_to_client_shape_converter.query_response,
            output_client_to_resource_shape_transform_method=self._client_shape_to_resource_shape_converter.query_response,
            table_method=self._table.query,
        )

    def scan(self, **kwargs) -> dict[str, Any]:
        """
        Scan the entire table or index. Decrypts any returned items.

        The parameters and return value match the boto3 DynamoDB table scan API:
        https://boto3.amazonaws.com/v1/documentation/api/latest/reference/services/dynamodb/table/scan.html

        Args:
            **kwargs: Keyword arguments to pass to the operation. These match the boto3 scan API parameters.

        Returns:
            dict: The response from DynamoDB. This matches the boto3 scan API response.

        """
        return self._table_operation_logic(
            operation_input=kwargs,
            input_encryption_transform_method=self._transformer.scan_input_transform,
            input_encryption_transform_shape=ScanInputTransformInput,
            input_resource_to_client_shape_transform_method=self._resource_shape_to_client_shape_converter.scan_request,
            input_client_to_resource_shape_transform_method=self._client_shape_to_resource_shape_converter.scan_request,
            output_encryption_transform_method=self._transformer.scan_output_transform,
            output_encryption_transform_shape=ScanOutputTransformInput,
            output_resource_to_client_shape_transform_method=self._resource_shape_to_client_shape_converter.scan_response,
            output_client_to_resource_shape_transform_method=self._client_shape_to_resource_shape_converter.scan_response,
            table_method=self._table.scan,
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

    def batch_writer(self, overwrite_by_pkeys: list[str] | None = None) -> BatchWriter:
        """
        Create a batch writer object that will transparently encrypt requests to DynamoDB.

        https://boto3.amazonaws.com/v1/documentation/api/latest/reference/services/dynamodb/table/batch_writer.html

        Args:
            overwrite_by_pkeys: De-duplicate request items in buffer if match new request
                item on specified primary keys. i.e ``["partition_key1", "sort_key2", "sort_key3"]``

        Returns:
            BatchWriter: A batch writer that will transparently encrypt requests

        """
        encrypted_client = EncryptedClient(
            client=self._table.meta.client,
            encryption_config=self._encryption_config,
            # The boto3 client comes from the underlying table, which is a ServiceResource.
            # ServiceResource clients expect standard dictionaries, not DynamoDB JSON.
            expect_standard_dictionaries=True,
        )
        return BatchWriter(table_name=self._table.name, client=encrypted_client, overwrite_by_pkeys=overwrite_by_pkeys)

    def _table_operation_logic(
        self,
        *,
        operation_input: dict[str, Any],
        input_encryption_transform_method: Callable,
        input_encryption_transform_shape: Any,
        input_resource_to_client_shape_transform_method: Callable,
        input_client_to_resource_shape_transform_method: Callable,
        output_encryption_transform_method: Callable,
        output_encryption_transform_shape: Any,
        output_resource_to_client_shape_transform_method: Callable,
        output_client_to_resource_shape_transform_method: Any,
        table_method: Callable,
    ) -> dict[str, Any]:
        """
        Interface between user-supplied input, encryption/decryption transformers, and boto3 Tables.

        Args:
            operation_input: User-supplied input to the operation
            input_encryption_transform_method: The method to transform the input for encryption/decryption
            input_encryption_transform_shape: The shape to supply to the input encryption/decryption transform
            input_resource_to_client_shape_transform_method: Method to transform resource-formatted input shape
                to client-formattted input shape
            input_client_to_resource_shape_transform_method: Method to transform client-formatted input shape
                to resource-formattted input shape
            output_encryption_transform_method: The method to transform the output for encryption/decryption
            output_encryption_transform_shape: The shape to supply to the output encryption/decryption transform
            output_resource_to_client_shape_transform_method: Method to transform resource-formatted output shape
                to client-formattted output shape
            output_client_to_resource_shape_transform_method: Method to transform client-formatted output shape
                to resource-formattted output shape
            table_method: The underlying table method to call

        Returns:
            dict: The transformed response from DynamoDB

        """
        # EncryptedTable inputs are formatted as standard dictionaries, but DBESDK transformations expect DynamoDB JSON.
        # Convert from standard dictionaries to DynamoDB JSON.
        input_transform_input = input_resource_to_client_shape_transform_method(operation_input)

        # Apply DBESDK transformation to the input
        input_transform_output = input_encryption_transform_method(
            input_encryption_transform_shape(sdk_input=input_transform_input)
        ).transformed_input

        # The encryption transformation result is formatted in DynamoDB JSON,
        # but the underlying boto3 table expects standard dictionaries.
        # Convert from DynamoDB JSON to standard dictionaries.
        sdk_input = input_client_to_resource_shape_transform_method(input_transform_output)

        sdk_output = table_method(**sdk_input)

        # Table outputs are formatted as standard dictionaries, but DBESDK transformations expect DynamoDB JSON.
        # Convert from standard dictionaries to DynamoDB JSON.
        output_transform_input = output_resource_to_client_shape_transform_method(sdk_output)

        # Apply DBESDK transformation to boto3 output
        output_transform_output = output_encryption_transform_method(
            output_encryption_transform_shape(
                original_input=input_transform_input,
                sdk_output=output_transform_input,
            )
        ).transformed_output

        # EncryptedTable outputs are formatted as standard dictionaries,
        # but DBESDK transformations provide DynamoDB JSON.
        # Convert from DynamoDB JSON to standard dictionaries.
        dbesdk_response = output_client_to_resource_shape_transform_method(output_transform_output)

        # Copy any missing fields from the SDK output to the response (e.g. `ConsumedCapacity`)
        dbesdk_response = self._copy_sdk_response_to_dbesdk_response(sdk_output, dbesdk_response)

        return dbesdk_response

    @property
    def _boto_client_attr_name(self) -> str:
        """
        Name of the attribute containing the underlying boto3 client.

        Returns:
            str: '_table'

        """
        return "_table"
