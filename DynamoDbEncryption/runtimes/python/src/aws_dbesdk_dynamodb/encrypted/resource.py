# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""High-level helper classes to provide encrypting wrappers for boto3 DynamoDB resources."""
from collections.abc import Callable, Generator
from copy import deepcopy
from typing import Any

from boto3.resources.base import ServiceResource
from boto3.resources.collection import CollectionManager

from aws_dbesdk_dynamodb.encrypted.boto3_interface import EncryptedBotoInterface
from aws_dbesdk_dynamodb.encrypted.table import EncryptedTable
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
)


class EncryptedTablesCollectionManager(EncryptedBotoInterface):
    """
    Collection manager that provides EncryptedTable objects.

    The API matches boto3's tables collection manager interface:

    https://boto3.amazonaws.com/v1/documentation/api/latest/reference/services/dynamodb/service-resource/tables.html

    All operations on this class will yield EncryptedTable objects.
    """

    def __init__(
        self,
        *,
        collection: CollectionManager,
        encryption_config: DynamoDbTablesEncryptionConfig,
    ):
        """
        Create an EncryptedTablesCollectionManager object.

        Args:
            collection (CollectionManager): Pre-configured boto3 DynamoDB table collection manager
            encryption_config (DynamoDbTablesEncryptionConfig): Initialized DynamoDbTablesEncryptionConfig

        """
        self._collection = collection
        self._encryption_config = encryption_config

    def all(self) -> Generator[EncryptedTable, None, None]:
        """
        Create an iterable of all EncryptedTable resources in the collection.

        https://boto3.amazonaws.com/v1/documentation/api/latest/reference/services/dynamodb/service-resource/tables.html#DynamoDB.ServiceResource.all

        Returns:
            Generator[EncryptedTable, None, None]: An iterable of EncryptedTable objects

        """
        yield from self._transform_table(self._collection.all)

    def filter(self, **kwargs) -> Generator[EncryptedTable, None, None]:
        """
        Create an iterable of all EncryptedTable resources in the collection filtered by kwargs passed to method.

        https://boto3.amazonaws.com/v1/documentation/api/latest/reference/services/dynamodb/service-resource/tables.html#filter

        Returns:
            Generator[EncryptedTable, None, None]: An iterable of EncryptedTable objects

        """
        yield from self._transform_table(self._collection.filter, **kwargs)

    def limit(self, **kwargs) -> Generator[EncryptedTable, None, None]:
        """
        Create an iterable of all EncryptedTable resources in the collection filtered by kwargs passed to method.

        https://boto3.amazonaws.com/v1/documentation/api/latest/reference/services/dynamodb/service-resource/tables.html#limit

        Returns:
            Generator[EncryptedTable, None, None]: An iterable of EncryptedTable objects

        """
        yield from self._transform_table(self._collection.limit, **kwargs)

    def page_size(self, **kwargs) -> Generator[EncryptedTable, None, None]:
        """
        Create an iterable of all EncryptedTable resources in the collection.

        This limits the number of items returned by each service call by the specified amount.

        https://boto3.amazonaws.com/v1/documentation/api/latest/reference/services/dynamodb/service-resource/tables.html#page_size

        Returns:
            Generator[EncryptedTable, None, None]: An iterable of EncryptedTable objects

        """
        yield from self._transform_table(self._collection.page_size, **kwargs)

    def _transform_table(
        self,
        method: Callable,
        **kwargs,
    ) -> Generator[EncryptedTable, None, None]:
        for table in method(**kwargs):
            yield EncryptedTable(table=table, encryption_config=self._encryption_config)

    @property
    def _boto_client_attr_name(self) -> str:
        """
        Name of the attribute containing the underlying boto3 client.

        Returns:
            str: '_collection'

        """
        return "_collection"


class EncryptedResource(EncryptedBotoInterface):
    """
    Wrapper for a boto3 DynamoDB resource.

    This class implements the complete boto3 DynamoDB resource API, allowing it to serve as a
    drop-in replacement that transparently handles encryption and decryption of items.

    The API matches the standard boto3 DynamoDB resource interface:

    https://boto3.amazonaws.com/v1/documentation/api/latest/reference/services/dynamodb/service-resource/index.html

    This class will encrypt/decrypt items for the following operations:
        * ``batch_get_item``
        * ``batch_write_item``

    Calling ``Table()`` will return an ``EncryptedTable`` object.

    Any other operations on this class will defer to the underlying boto3 DynamoDB resource's implementation
    and will not be encrypted/decrypted.

    """

    def __init__(
        self,
        *,
        resource: ServiceResource,
        encryption_config: DynamoDbTablesEncryptionConfig,
    ):
        """
        Create an ``EncryptedResource`` object.

        Args:
            resource (ServiceResource): Initialized boto3 DynamoDB resource
            encryption_config (DynamoDbTablesEncryptionConfig): Initialized DynamoDbTablesEncryptionConfig

        """
        self._resource = resource
        self._encryption_config = encryption_config
        self._transformer = DynamoDbEncryptionTransforms(config=encryption_config)
        self._client_shape_to_resource_shape_converter = ClientShapeToResourceShapeConverter()
        self._resource_shape_to_client_shape_converter = ResourceShapeToClientShapeConverter()
        self.tables = EncryptedTablesCollectionManager(
            collection=self._resource.tables, encryption_config=self._encryption_config
        )

    def Table(self, name):
        """
        Create an ``EncryptedTable`` resource.

        https://boto3.amazonaws.com/v1/documentation/api/latest/reference/services/dynamodb/service-resource/Table.html

        Args:
            name (str): The EncryptedTable's name identifier. This must be set.

        Returns:
            EncryptedTable: An ``EncryptedTable`` resource

        """
        return EncryptedTable(table=self._resource.Table(name), encryption_config=self._encryption_config)

    def batch_get_item(self, **kwargs):
        """
        Get multiple items from one or more tables. Decrypts any returned items.

        The input and output syntaxes match those for the boto3 DynamoDB resource ``batch_get_item`` API:

        https://boto3.amazonaws.com/v1/documentation/api/latest/reference/services/dynamodb/service-resource/batch_get_item.html

        Args:
            **kwargs: Keyword arguments to pass to the operation. These match the boto3 resource ``batch_get_item``
                request syntax.

        Returns:
            dict: The response from DynamoDB. This matches the boto3 resource ``batch_get_item`` response syntax.
            The ``"Responses"`` field will be decrypted locally after being read from DynamoDB.

        """
        return self._resource_operation_logic(
            operation_input=kwargs,
            input_resource_to_client_shape_transform_method=self._resource_shape_to_client_shape_converter.batch_get_item_request,
            input_client_to_resource_shape_transform_method=self._client_shape_to_resource_shape_converter.batch_get_item_request,
            input_encryption_transform_method=self._transformer.batch_get_item_input_transform,
            input_encryption_transform_shape=BatchGetItemInputTransformInput,
            output_encryption_transform_method=self._transformer.batch_get_item_output_transform,
            output_encryption_transform_shape=BatchGetItemOutputTransformInput,
            output_resource_to_client_shape_transform_method=self._resource_shape_to_client_shape_converter.batch_get_item_response,
            output_client_to_resource_shape_transform_method=self._client_shape_to_resource_shape_converter.batch_get_item_response,
            resource_method=self._resource.batch_get_item,
        )

    def batch_write_item(self, **kwargs):
        """
        Put or delete multiple items in one or more tables.

        For put operations, encrypts items before writing.

        The input and output syntaxes match those for the boto3 DynamoDB resource ``batch_write_item`` API:

        https://boto3.amazonaws.com/v1/documentation/api/latest/reference/services/dynamodb/service-resource/batch_write_item.html

        Args:
            **kwargs: Keyword arguments to pass to the operation. These match the boto3 resource
                ``batch_write_item`` request syntax. Any ``"PutRequest"`` values in the ``"RequestItems"``
                argument will be encrypted locally before being written to DynamoDB.

        Returns:
            dict: The response from DynamoDB. This matches the boto3 resource ``batch_write_item`` response syntax.

        """
        return self._resource_operation_logic(
            operation_input=kwargs,
            input_resource_to_client_shape_transform_method=self._resource_shape_to_client_shape_converter.batch_write_item_request,
            input_client_to_resource_shape_transform_method=self._client_shape_to_resource_shape_converter.batch_write_item_request,
            input_encryption_transform_method=self._transformer.batch_write_item_input_transform,
            input_encryption_transform_shape=BatchWriteItemInputTransformInput,
            output_encryption_transform_method=self._transformer.batch_write_item_output_transform,
            output_encryption_transform_shape=BatchWriteItemOutputTransformInput,
            output_resource_to_client_shape_transform_method=self._resource_shape_to_client_shape_converter.batch_write_item_response,
            output_client_to_resource_shape_transform_method=self._client_shape_to_resource_shape_converter.batch_write_item_response,
            resource_method=self._resource.batch_write_item,
        )

    def _resource_operation_logic(
        self,
        *,
        operation_input: dict[str, Any],
        input_resource_to_client_shape_transform_method: Callable,
        input_client_to_resource_shape_transform_method: Callable,
        input_encryption_transform_method: Callable,
        input_encryption_transform_shape: Any,
        output_encryption_transform_method: Callable,
        output_encryption_transform_shape: Any,
        output_resource_to_client_shape_transform_method: Callable,
        output_client_to_resource_shape_transform_method: Callable,
        resource_method: Callable,
    ):
        operation_input = deepcopy(operation_input)
        # Table inputs are formatted as Python dictionary JSON, but encryption transformers expect DynamoDB JSON.
        # `input_resource_to_client_shape_transform_method` formats the supplied Python dictionary as DynamoDB JSON.
        input_transform_input = input_resource_to_client_shape_transform_method(operation_input)

        # Apply encryption transformation to the user-supplied input
        input_transform_output = input_encryption_transform_method(
            input_encryption_transform_shape(sdk_input=input_transform_input)
        ).transformed_input

        # The encryption transformation result is formatted in DynamoDB JSON,
        #   but the underlying boto3 table expects Python dictionary JSON.
        # `input_client_to_resource_shape_transform_method` formats the transformation as Python dictionary JSON.
        sdk_input = input_client_to_resource_shape_transform_method(input_transform_output)

        # Call boto3 Table method with Python-dictionary-JSON-formatted, encryption-transformed input,
        #   and receive Python-dictionary-JSON-formatted boto3 output.
        sdk_output = resource_method(**sdk_input)

        # Format Python dictionary JSON-formatted SDK output as DynamoDB JSON for encryption transformer
        output_transform_input = output_resource_to_client_shape_transform_method(sdk_output)

        # Apply encryption transformer to boto3 output
        output_transform_output = output_encryption_transform_method(
            output_encryption_transform_shape(
                original_input=input_transform_input,
                sdk_output=output_transform_input,
            )
        ).transformed_output

        # Format DynamoDB JSON-formatted encryption transformation result as Python dictionary JSON
        dbesdk_response = output_client_to_resource_shape_transform_method(output_transform_output)
        # Copy any missing fields from the SDK output to the response
        #   (e.g. `ConsumedCapacity`)
        dbesdk_response = self._copy_sdk_response_to_dbesdk_response(sdk_output, dbesdk_response)

        return dbesdk_response

    @property
    def _boto_client_attr_name(self) -> str:
        """
        Name of the attribute containing the underlying boto3 client.

        Returns:
            str: '_resource'

        """
        return "_resource"
