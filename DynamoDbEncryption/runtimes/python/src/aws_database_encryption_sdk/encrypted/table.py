from boto3.resources.base import ServiceResource

"""High-level helper class to provide an encrypting wrapper for boto3 DynamoDB clients."""
from boto3.dynamodb.table import BatchWriter

from aws_database_encryption_sdk.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.models import (
    GetItemInputTransformInput,
    GetItemOutputTransformInput,
    PutItemInputTransformInput,
    PutItemOutputTransformInput,
    ScanInputTransformInput,
    ScanOutputTransformInput,
    QueryInputTransformInput,
    QueryOutputTransformInput,
)
from aws_database_encryption_sdk.encrypted.client import EncryptedClient
from aws_database_encryption_sdk.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.client import (
    DynamoDbEncryptionTransforms
)
from aws_database_encryption_sdk.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models import (
    DynamoDbTablesEncryptionConfig,
)
from aws_database_encryption_sdk.internal.resource_to_client import ResourceShapeToClientShapeConverter
from aws_database_encryption_sdk.internal.client_to_resource import ClientShapeToResourceShapeConverter


class EncryptedTable:

    def __init__(
        self,
        *,
        table: ServiceResource,
        encryption_config: DynamoDbTablesEncryptionConfig,
    ):
        self._table = table
        self._encryption_config = encryption_config
        self._transformer = DynamoDbEncryptionTransforms(
            config = encryption_config
        )
        self._client_shape_to_resource_shape_converter = ClientShapeToResourceShapeConverter()
        self._resource_shape_to_client_shape_converter = ResourceShapeToClientShapeConverter(table_name = self._table.table_name)

    def _table_operation_logic(
        self,
        *,
        operation_input,
        input_transform_method,
        input_transform_shape,
        input_resource_to_client_shape_transform_method,
        input_client_to_resource_shape_transform_method,
        output_transform_method,
        output_transform_shape,
        output_resource_to_client_shape_transform_method,
        output_client_to_resource_shape_transform_method,
        table_method,
    ):
        """Shared logic to interface between boto3 Table operation inputs and encryption transformers."""
        # Table inputs are formatted as Python dictionary JSON, but encryption transformers expect DynamoDB JSON.
        # `input_resource_to_client_shape_transform_method` formats the supplied Python dictionary as DynamoDB JSON.
        input_transform_input = input_resource_to_client_shape_transform_method(operation_input)

        # Apply encryption transformation to the user-supplied input
        input_transform_output = input_transform_method(
            input_transform_shape(
                sdk_input = input_transform_input
            )
        ).transformed_input

        # The encryption transformation result is formatted in DynamoDB JSON,
        #   but the underlying table expects Python dictionary JSON.
        # `input_client_to_resource_shape_transform_method` formats the transformation as Python dictionary JSON.
        sdk_input = input_client_to_resource_shape_transform_method(input_transform_output)

        # Call boto3 Table method with Python-dictionary-JSON-formatted, encryption-transformed input,
        #   and receive Python-dictionary-JSON-formatted, raw boto3 output.
        sdk_output = table_method(**sdk_input)

        # Format Python dictionary JSON-formatted SDK output as DynamoDB JSON for encryption transformer
        output_transform_input = output_resource_to_client_shape_transform_method(sdk_output)

        # Apply encryption transformer to boto3 output
        output_transform_output = output_transform_method(
            output_transform_shape(
                original_input = input_transform_input,
                sdk_output = output_transform_input,
            )
        ).transformed_output

        # Format DynamoDB JSON-formatted encryption transformation result as Python dictionary JSON
        response = output_client_to_resource_shape_transform_method(output_transform_output)
        # Copy any missing fields from the SDK output to the response
        #   (e.g. `ConsumedCapacity` on `batch_write_item`)
        response = self._copy_missing_sdk_output_fields_to_response(sdk_output, response, output_transform_output)

        return response

    def put_item(self, **kwargs):
        return self._table_operation_logic(
            operation_input = kwargs,
            input_transform_method=self._transformer.put_item_input_transform,
            input_transform_shape=PutItemInputTransformInput,
            input_resource_to_client_shape_transform_method=self._resource_shape_to_client_shape_converter.put_item_request,
            input_client_to_resource_shape_transform_method=self._client_shape_to_resource_shape_converter.put_item_request,
            output_transform_method=self._transformer.put_item_output_transform,
            output_transform_shape=PutItemOutputTransformInput,
            output_resource_to_client_shape_transform_method=self._resource_shape_to_client_shape_converter.put_item_response,
            output_client_to_resource_shape_transform_method=self._client_shape_to_resource_shape_converter.put_item_response,
            table_method=self._table.put_item
        )
        # input_transform_input = self._resource_shape_to_client_shape_converter.put_item_request(kwargs)
        # input_transform_output = self._transformer.put_item_input_transform(
        #     PutItemInputTransformInput(
        #         sdk_input = input_transform_input
        #     )
        # ).transformed_input

        # sdk_input = self._client_shape_to_resource_shape_converter.put_item_request(input_transform_output)

        # sdk_output = self._table.put_item(**sdk_input)

        # output_transform_input = self._resource_shape_to_client_shape_converter.put_item_response(sdk_output)

        # output_transform_output = self._transformer.put_item_output_transform(
        #     PutItemOutputTransformInput(
        #         original_input = input_transform_input,
        #         sdk_output = output_transform_input,
        #     )
        # ).transformed_output

        # response = self._client_shape_to_resource_shape_converter.put_item_response(output_transform_output)
        # response = self._copy_missing_sdk_output_fields_to_response(sdk_output, response, output_transform_output)

        # return response
    
    def get_item(self, **kwargs):
        return self._table_operation_logic(
            operation_input = kwargs,
            input_transform_method=self._transformer.get_item_input_transform,
            input_transform_shape=GetItemInputTransformInput,
            input_resource_to_client_shape_transform_method=self._resource_shape_to_client_shape_converter.get_item_request,
            input_client_to_resource_shape_transform_method=self._client_shape_to_resource_shape_converter.get_item_request,
            output_transform_method=self._transformer.get_item_output_transform,
            output_transform_shape=GetItemOutputTransformInput,
            output_resource_to_client_shape_transform_method=self._resource_shape_to_client_shape_converter.get_item_response,
            output_client_to_resource_shape_transform_method=self._client_shape_to_resource_shape_converter.get_item_response,
            table_method=self._table.get_item
        )
        # input_transform_input = self._resource_shape_to_client_shape_converter.get_item_request(kwargs)
        # input_transform_output = self._transformer.get_item_input_transform(
        #     GetItemInputTransformInput(
        #         sdk_input = input_transform_input
        #     )
        # ).transformed_input

        # sdk_input = self._client_shape_to_resource_shape_converter.get_item_request(input_transform_output)
        # sdk_output = self._table.get_item(**sdk_input)

        # output_transform_input = self._resource_shape_to_client_shape_converter.get_item_response(sdk_output)
        
        # output_transform_output = self._transformer.get_item_output_transform(
        #     GetItemOutputTransformInput(
        #         original_input = input_transform_input,
        #         sdk_output = output_transform_input,
        #     )
        # ).transformed_output

        # response = self._client_shape_to_resource_shape_converter.get_item_response(output_transform_output)
        # response = self._copy_missing_sdk_output_fields_to_response(sdk_output, response, output_transform_output)

        # return response
    
    # TODO refactor across table/client/resource/more?
    def _copy_missing_sdk_output_fields_to_response(self, sdk_output, response, output_transform_output):
        for sdk_output_key, sdk_output_value in sdk_output.items():
            if sdk_output_key not in output_transform_output:
                response[sdk_output_key] = sdk_output_value
        return response

    def update_item(self, **kwargs):
        """Update item is not yet supported."""
        raise NotImplementedError('"update_item" is not yet implemented')
    
    def batch_writer(self, overwrite_by_pkeys=None):
        """Create a batch writer object.

        https://boto3.amazonaws.com/v1/documentation/api/latest/reference/services/dynamodb/table/batch_writer.html

        :type overwrite_by_pkeys: list(string)
        :param overwrite_by_pkeys: De-duplicate request items in buffer if match new request
            item on specified primary keys. i.e ``["partition_key1", "sort_key2", "sort_key3"]``
        """
        print("making encrypted client")
        encrypted_client = EncryptedClient(
            client = self._table.meta.client,
            encryption_config = self._encryption_config,
            expect_standard_dictionaries = True,
        )
        return BatchWriter(table_name=self._table.name, client=encrypted_client, overwrite_by_pkeys=overwrite_by_pkeys)
    
    def scan(self, **kwargs):
        return self._table_operation_logic(
            operation_input = kwargs,
            input_transform_method=self._transformer.scan_input_transform,
            input_transform_shape=ScanInputTransformInput,
            input_resource_to_client_shape_transform_method=self._resource_shape_to_client_shape_converter.scan_request,
            input_client_to_resource_shape_transform_method=self._client_shape_to_resource_shape_converter.scan_request,
            output_transform_method=self._transformer.scan_output_transform,
            output_transform_shape=ScanOutputTransformInput,
            output_resource_to_client_shape_transform_method=self._resource_shape_to_client_shape_converter.scan_response,
            output_client_to_resource_shape_transform_method=self._client_shape_to_resource_shape_converter.scan_response,
            table_method=self._table.scan
        
        )
        # input_transform_input = self._resource_shape_to_client_shape_converter.scan_request(kwargs)
        # input_transform_output = self._transformer.scan_input_transform(
        #     ScanInputTransformInput(
        #         sdk_input = input_transform_input
        #     )
        # ).transformed_input

        # sdk_input = self._client_shape_to_resource_shape_converter.scan_request(input_transform_output)

        # sdk_output = self._table.scan(**sdk_input)

        # # sdk_output is a dict, but DBESDK internals expect DDB

        # output_transform_input = self._resource_shape_to_client_shape_converter.scan_response(sdk_output)

        # output_transform_output = self._transformer.scan_output_transform(
        #     ScanOutputTransformInput(
        #         original_input = input_transform_input,
        #         sdk_output = output_transform_input,
        #     )
        # ).transformed_output

        # response = self._client_shape_to_resource_shape_converter.scan_response(output_transform_output)
        # response = self._copy_missing_sdk_output_fields_to_response(sdk_output, response, output_transform_output)

        # return response

    def query(self, **kwargs):
        return self._table_operation_logic(
            operation_input = kwargs,
            input_transform_method=self._transformer.query_input_transform,
            input_transform_shape=QueryInputTransformInput,
            input_resource_to_client_shape_transform_method=self._resource_shape_to_client_shape_converter.query_request,
            input_client_to_resource_shape_transform_method=self._client_shape_to_resource_shape_converter.query_request,
            output_transform_method=self._transformer.query_output_transform,
            output_transform_shape=QueryOutputTransformInput,
            output_resource_to_client_shape_transform_method=self._resource_shape_to_client_shape_converter.query_response,
            output_client_to_resource_shape_transform_method=self._client_shape_to_resource_shape_converter.query_response,
            table_method=self._table.query
        )
        # print(f"query {kwargs=}")
        # input_transform_input = self._resource_shape_to_client_shape_converter.query_request(kwargs)

        # print(f"query {input_transform_input=}")
        # input_transform_output = self._transformer.query_input_transform(
        #     QueryInputTransformInput(
        #         sdk_input = input_transform_input
        #     )
        # ).transformed_input

        # print(f"query {input_transform_output=}")

        # sdk_input = self._client_shape_to_resource_shape_converter.query_request(input_transform_output)

        # print(f"query {sdk_input=}")

        # sdk_output = self._table.query(**sdk_input)

        # output_transform_input = self._resource_shape_to_client_shape_converter.query_response(sdk_output)

        # output_transform_output = self._transformer.query_output_transform(
        #     QueryOutputTransformInput(
        #         original_input = input_transform_input,
        #         sdk_output = output_transform_input,
        #     )
        # ).transformed_output

        # response = self._client_shape_to_resource_shape_converter.query_response(output_transform_output)
        # response = self._copy_missing_sdk_output_fields_to_response(sdk_output, response, output_transform_output)

        # return response

    def __getattr__(self, name):
        # Before calling __getattr__, the class will look at its own methods.
        # Any methods defined on the class are called before getting to this point.

        # __getattr__ doesn't find a class' protected methods by default.
        # if name in self._get_protected_methods():
        #     return getattr(self, name)
        # If the class doesn't override a boto3 method, defer to boto3 now.
        if hasattr(self._resource, name):
            return getattr(self._resource, name)
        else:
            raise AttributeError(f"'{self.__class__.__name__}' object has no attribute '{name}'")
