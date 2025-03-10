# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""High-level helper class to provide an encrypting wrapper for boto3 DynamoDB clients."""
from botocore.paginate import (
    Paginator,
    PageIterator,
)
import botocore.client
from typing import Callable, Optional
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
from aws_database_encryption_sdk.encrypted.item import ItemEncryptor

class EncryptedPaginator:
    """
    Wrapping class for botocore.paginate.Paginator that decrypts returned items before returning them.
    """
    def __init__(
        self,
        paginator: Paginator,
        encryption_config: DynamoDbTablesEncryptionConfig,
        operation_name: str,
    ):
        self._paginator = paginator
        self._encryption_config = encryption_config
        self._transformer = DynamoDbEncryptionTransforms(
            config = encryption_config
        )
        self._operation_name = operation_name
        
    def paginate(self, **kwargs) -> Generator[dict, None, None]:
        """Yield a generator that will paginate through responses from the underlying paginator,
        transparently decrypting any returned items.

        Note: `botocore.paginate.Paginator.paginate` yields an iterable `PageIterator` object,
        while this `paginate` implementation yields an iterable `generator` object.
        This `paginate` implementation can be used exactly as described in the boto3 documentation:
        https://botocore.amazonaws.com/v1/documentation/api/latest/topics/paginators.html
        but cannot be used with undocumented PageIterator methods (ex. `build_full_result`).

        Args:
            **kwargs: Keyword arguments to pass to the underlying paginator.

            If this is a Scan operation, these should be structured according to:
            https://boto3.amazonaws.com/v1/documentation/api/latest/reference/services/dynamodb/paginator/Scan.html

            If this is a Query operation, these should be structured according to:
            https://boto3.amazonaws.com/v1/documentation/api/latest/reference/services/dynamodb/paginator/Query.html

        Returns:
            Generator[dict, None, None]: A generator that yields decrypted response pages
            
        Raises:
            NotImplementedError: If pagination is not supported for the operation
        """

        if self._operation_name == "query":
            yield from self.paginate_query(**kwargs)
        elif self._operation_name == "scan":
            yield from self.paginate_scan(**kwargs)
        else:
            raise NotImplementedError("EncryptedPaginator does not support paginating on {self._operation_name}")

    def paginate_query(self, **paginate_query_kwargs):
        try:
            pagination_config = paginate_query_kwargs["PaginationConfig"]
        except KeyError:
            pagination_config = None
    
        client_query_kwargs = paginate_query_kwargs
        try:
            del client_query_kwargs["PaginationConfig"]
        except KeyError:
            pass
    
        # client_query_input = self._maybe_transform_request_to_dynamodb_item(item_key = "Key", **client_query_kwargs)
        transformed_request = self._transformer.query_input_transform(
            QueryInputTransformInput(
                sdk_input = client_query_kwargs
            )
        ).transformed_input

        if pagination_config is not None:
            transformed_request["PaginationConfig"] = pagination_config
        sdk_page_response = self._paginator.paginate(**transformed_request)

        print(f"{sdk_page_response=}")
        print(f"{sdk_page_response.__dict__=}")



        for page in sdk_page_response:

            # TODO: Is this always returned? do i need to provide back
            try:
                next_token = page["NextToken"]
                del page["NextToken"]
            except KeyError:
                pass

            dbesdk_response = self._transformer.query_output_transform(
                QueryOutputTransformInput(
                    original_input = client_query_kwargs,
                    sdk_output = page,
                )
            ).transformed_output

            # refactor out of client class
            # self._copy_sdk_response_to_dbesdk_response(page, dbesdk_response)
            # self._maybe_transform_response_to_python_dict(dbesdk_response)
            yield dbesdk_response

    def paginate_scan(self, **paginate_scan_kwargs):
        try:
            pagination_config = paginate_scan_kwargs["PaginationConfig"]
        except KeyError:
            pagination_config = None
    
        client_scan_kwargs = paginate_scan_kwargs
        try:
            del client_scan_kwargs["PaginationConfig"]
        except KeyError:
            pass
    
        # client_scan_input = self._maybe_transform_request_to_dynamodb_item(item_key = "Key", **client_scan_kwargs)
        transformed_request = self._transformer.scan_input_transform(
            ScanInputTransformInput(
                sdk_input = client_scan_kwargs
            )
        ).transformed_input

        if pagination_config is not None:
            transformed_request["PaginationConfig"] = pagination_config

        print(f"{transformed_request=}")
        sdk_page_response = self._paginator.paginate(**transformed_request)

        for page in sdk_page_response:

            print(f"{page=}")

            # TODO: Is this always returned? do i need to provide back
            try:
                next_token = page["NextToken"]
                del page["NextToken"]
            except KeyError:
                next_token = None

            dbesdk_response = self._transformer.scan_output_transform(
                ScanOutputTransformInput(
                    original_input = client_scan_kwargs,
                    sdk_output = page,
                )
            ).transformed_output

            if next_token is not None:
                dbesdk_response["NextToken"] = next_token

            # refactor out of client class
            # self._copy_sdk_response_to_dbesdk_response(page, dbesdk_response)
            # self._maybe_transform_response_to_python_dict(dbesdk_response)
            yield dbesdk_response

    def __getattr__(self, name):
        # Before calling __getattr__, the class will look at its own methods.
        # Any methods defined on the class are called before getting to this point.

        # If the class doesn't override a boto3 method, defer to boto3 now.
        if hasattr(self._paginator, name):
            return getattr(self._paginator, name)
        else:
            raise AttributeError(f"'{self.__class__.__name__}' object has no attribute '{name}'")