# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""High-level helper class to provide an encrypting wrapper for boto3 DynamoDB clients."""
from botocore.paginate import (
    Paginator,
    PageIterator,
)
import botocore.client
from typing import Callable, Optional, Any, Dict
import inspect
from typing import Generator

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
from aws_database_encryption_sdk.encrypted.boto3_interface import EncryptedBotoInterface

class EncryptedPaginator(EncryptedBotoInterface):
    """
    Wrapping class for botocore.paginate.Paginator that decrypts returned items before returning them.
    """
    def __init__(
        self,
        paginator: Paginator,
        encryption_config: DynamoDbTablesEncryptionConfig,
    ):
        """Create an EncryptedPaginator.

        Args:
            paginator (Paginator): A boto3 Paginator object for DynamoDB operations.
                This can be either a "query" or "scan" Paginator.
            encryption_config (DynamoDbTablesEncryptionConfig): Encryption configuration object.
        """
        self._paginator = paginator
        self._encryption_config = encryption_config
        self._transformer = DynamoDbEncryptionTransforms(
            config = encryption_config
        )
        
    def paginate(self, **kwargs) -> Generator[dict, None, None]:
        """Yields a generator that paginates through responses from DynamoDB, decrypting items.

        Note:
            Calling `botocore.paginate.Paginator`'s `paginate` method for Query or Scan
            returns a `PageIterator` object, but this implementation returns a Python generator.
            However, you can use this generator to iterate exactly as described in the official
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

        """

        if self._paginator._model.name == "Query":
            yield from self._paginate_query(**kwargs)
        elif self._paginator._model.name == "Scan":
            yield from self._paginate_scan(**kwargs)
        else:
            yield from self._paginator.paginate(**kwargs)

    def _paginate_query(self, **paginate_query_kwargs):
        return self._paginate_request(
            paginate_kwargs = paginate_query_kwargs,
            input_transform_method = self._transformer.query_input_transform,
            input_transform_shape = QueryInputTransformInput,
            output_transform_method = self._transformer.query_output_transform,
            output_transform_shape = QueryOutputTransformInput,
        )

    def _paginate_scan(self, **paginate_scan_kwargs):
        return self._paginate_request(
            paginate_kwargs = paginate_scan_kwargs,
            input_transform_method = self._transformer.scan_input_transform,
            input_transform_shape = ScanInputTransformInput,
            output_transform_method = self._transformer.scan_output_transform,
            output_transform_shape = ScanOutputTransformInput,
        )

    def _paginate_request(
        self,
        *,
        paginate_kwargs: Dict[str, Any],
        input_transform_method: Callable,
        input_transform_shape: Any,
        output_transform_method: Callable,
        output_transform_shape: Any,
    ):
        client_kwargs = paginate_kwargs.copy()
        try:
            # Remove PaginationConfig from the request if it exists.
            # The input_transform_method does not expect it.
            # It is added back to the request sent to the SDK.
            pagination_config = client_kwargs["PaginationConfig"]
            del client_kwargs["PaginationConfig"]
        except KeyError:
            pagination_config = None
        
        transformed_request = input_transform_method(
            input_transform_shape(
                sdk_input = client_kwargs
            )
        ).transformed_input

        if pagination_config is not None:
            transformed_request["PaginationConfig"] = pagination_config
        
        sdk_page_response = self._paginator.paginate(**transformed_request)
            
        for page in sdk_page_response:
            dbesdk_response = output_transform_method(
                output_transform_shape(
                    original_input = client_kwargs,
                    sdk_output = page,
                )
            ).transformed_output
            yield dbesdk_response

    @property
    def _boto_client_attr_name(self) -> str:
        """Name of the attribute containing the underlying boto3 client.
        
        Returns:
            str: '_paginator'
        """
        return '_paginator'
