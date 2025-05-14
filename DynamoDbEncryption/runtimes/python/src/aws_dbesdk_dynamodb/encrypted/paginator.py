# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""High-level helper class to provide an encrypting wrapper for boto3 DynamoDB paginators."""
from collections.abc import Callable, Generator
from copy import deepcopy
from typing import Any

from botocore.paginate import (
    Paginator,
)

from aws_dbesdk_dynamodb.encrypted.boto3_interface import EncryptedBotoInterface
from aws_dbesdk_dynamodb.internal.client_to_resource import ClientShapeToResourceShapeConverter
from aws_dbesdk_dynamodb.internal.resource_to_client import ResourceShapeToClientShapeConverter
from aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models import (
    DynamoDbTablesEncryptionConfig,
)
from aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.client import (
    DynamoDbEncryptionTransforms,
)
from aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.models import (
    QueryInputTransformInput,
    QueryOutputTransformInput,
    ScanInputTransformInput,
    ScanOutputTransformInput,
)


class EncryptedPaginator(EncryptedBotoInterface):
    """Wrapping class for the boto3 Paginator that decrypts returned items before returning them."""

    def __init__(
        self,
        *,
        paginator: Paginator,
        encryption_config: DynamoDbTablesEncryptionConfig,
        expect_standard_dictionaries: bool | None = False,
    ):
        """
        Create an EncryptedPaginator.

        Args:
            paginator (Paginator): A boto3 Paginator object for DynamoDB operations.
                This can be either a "query" or "scan" Paginator.
            encryption_config (DynamoDbTablesEncryptionConfig): Encryption configuration object.
            expect_standard_dictionaries (Optional[bool]): Does the underlying boto3 client expect items
                to be standard Python dictionaries? This should only be set to True if you are using a
                client obtained from a service resource or table resource (ex: ``table.meta.client``).
                If this is True, EncryptedClient will expect item-like shapes to be
                standard Python dictionaries (default: False).

        """
        self._paginator = paginator
        self._encryption_config = encryption_config
        self._transformer = DynamoDbEncryptionTransforms(config=encryption_config)
        self._expect_standard_dictionaries = expect_standard_dictionaries
        self._resource_to_client_shape_converter = ResourceShapeToClientShapeConverter()
        self._client_to_resource_shape_converter = ClientShapeToResourceShapeConverter(delete_table_name=False)

    def paginate(self, **kwargs) -> Generator[dict, None, None]:
        """
        Yield a generator that paginates through responses from DynamoDB, decrypting items.

        Note:
            Calling ``botocore.paginate.Paginator``'s ``paginate`` method for Query or Scan
            returns a ``PageIterator`` object, but this implementation returns a Python generator.
            However, you can use this generator to iterate exactly as described in the
            boto3 documentation:

            https://botocore.amazonaws.com/v1/documentation/api/latest/topics/paginators.html

            Any other operations on this class will defer to the underlying boto3 Paginator's implementation.

        Args:
            **kwargs: Keyword arguments passed directly to the underlying DynamoDB paginator.
                For a Scan operation, structure these arguments according to:

                https://boto3.amazonaws.com/v1/documentation/api/latest/reference/services/dynamodb/paginator/Scan.html

                For a Query operation, structure these arguments according to:

                https://boto3.amazonaws.com/v1/documentation/api/latest/reference/services/dynamodb/paginator/Query.html

        Returns:
            Generator[dict, None, None]: A generator yielding pages as dictionaries.
            The items in the pages will be decrypted locally after being read from DynamoDB.

        """
        if self._paginator._model.name == "Query":
            yield from self._paginate_query(**kwargs)
        elif self._paginator._model.name == "Scan":
            yield from self._paginate_scan(**kwargs)
        else:
            yield from self._paginator.paginate(**kwargs)

    def _paginate_query(self, **paginate_query_kwargs):
        return self._paginate_request(
            paginate_kwargs=paginate_query_kwargs,
            input_item_to_ddb_transform_method=self._resource_to_client_shape_converter.query_request,
            input_item_to_dict_transform_method=self._client_to_resource_shape_converter.query_request,
            input_transform_method=self._transformer.query_input_transform,
            input_transform_shape=QueryInputTransformInput,
            output_item_to_ddb_transform_method=self._resource_to_client_shape_converter.query_response,
            output_item_to_dict_transform_method=self._client_to_resource_shape_converter.query_response,
            output_transform_method=self._transformer.query_output_transform,
            output_transform_shape=QueryOutputTransformInput,
        )

    def _paginate_scan(self, **paginate_scan_kwargs):
        return self._paginate_request(
            paginate_kwargs=paginate_scan_kwargs,
            input_item_to_ddb_transform_method=self._resource_to_client_shape_converter.scan_request,
            input_item_to_dict_transform_method=self._client_to_resource_shape_converter.scan_request,
            input_transform_method=self._transformer.scan_input_transform,
            input_transform_shape=ScanInputTransformInput,
            output_item_to_ddb_transform_method=self._resource_to_client_shape_converter.scan_response,
            output_item_to_dict_transform_method=self._client_to_resource_shape_converter.scan_response,
            output_transform_method=self._transformer.scan_output_transform,
            output_transform_shape=ScanOutputTransformInput,
        )

    def _paginate_request(
        self,
        *,
        paginate_kwargs: dict[str, Any],
        input_item_to_ddb_transform_method: Callable,
        input_item_to_dict_transform_method: Callable,
        input_transform_method: Callable,
        input_transform_shape: Any,
        output_item_to_ddb_transform_method: Callable,
        output_item_to_dict_transform_method: Callable,
        output_transform_method: Callable,
        output_transform_shape: Any,
    ):
        client_kwargs = deepcopy(paginate_kwargs)
        try:
            # Remove PaginationConfig from the request if it exists.
            # The input_transform_method does not expect it.
            # It is added back to the request sent to the SDK.
            pagination_config = client_kwargs["PaginationConfig"]
            del client_kwargs["PaginationConfig"]
        except KeyError:
            pagination_config = None

        # If _expect_standard_dictionaries is true, input items are expected to be standard dictionaries,
        # and need to be converted to DDB-JSON before encryption.
        if self._expect_standard_dictionaries:
            if "TableName" in client_kwargs:
                self._resource_to_client_shape_converter.table_name = client_kwargs["TableName"]
            client_kwargs = input_item_to_ddb_transform_method(client_kwargs)

        # Apply DBESDK transformations to the input
        transformed_request = input_transform_method(input_transform_shape(sdk_input=client_kwargs)).transformed_input

        # If _expect_standard_dictionaries is true, the boto3 client expects items to be standard dictionaries,
        # and need to be converted from DDB-JSON to a standard dictionary before being passed to the boto3 client.
        if self._expect_standard_dictionaries:
            transformed_request = input_item_to_dict_transform_method(transformed_request)

        if pagination_config is not None:
            transformed_request["PaginationConfig"] = pagination_config

        sdk_page_response = self._paginator.paginate(**transformed_request)

        for page in sdk_page_response:
            # If _expect_standard_dictionaries is true, the boto3 client returns items as standard dictionaries,
            # and needs to convert the standard dictionary to DDB-JSON before passing the response to the DBESDK.
            if self._expect_standard_dictionaries:
                page = output_item_to_ddb_transform_method(page)

            # Apply DBESDK transformation to the boto3 output
            dbesdk_response = output_transform_method(
                output_transform_shape(
                    original_input=client_kwargs,
                    sdk_output=page,
                )
            ).transformed_output

            # Copy any missing fields from the SDK output to the response (e.g. ConsumedCapacity)
            dbesdk_response = self._copy_sdk_response_to_dbesdk_response(page, dbesdk_response)

            # If _expect_standard_dictionaries is true, the boto3 client expects items to be standard dictionaries,
            # and need to be converted from DDB-JSON to a standard dictionary before returning the response.
            if self._expect_standard_dictionaries:
                dbesdk_response = output_item_to_dict_transform_method(dbesdk_response)

            yield dbesdk_response

    @property
    def _boto_client_attr_name(self) -> str:
        """
        Name of the attribute containing the underlying boto3 client.

        Returns:
            str: '_paginator'

        """
        return "_paginator"
