from boto3.resources.base import ServiceResource
from boto3.resources.collection import CollectionManager
from aws_database_encryption_sdk.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models import (
    DynamoDbTablesEncryptionConfig,
)
from aws_database_encryption_sdk.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.models import (
    BatchGetItemInputTransformInput,
    BatchGetItemOutputTransformInput,
    BatchWriteItemInputTransformInput,
    BatchWriteItemOutputTransformInput,
)
from aws_database_encryption_sdk.internal.resource_to_client import ResourceShapeToClientShapeConverter
from aws_database_encryption_sdk.internal.client_to_resource import ClientShapeToResourceShapeConverter
from aws_database_encryption_sdk.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.client import (
    DynamoDbEncryptionTransforms
)
from aws_database_encryption_sdk.encrypted.table import EncryptedTable

class EncryptedTablesCollectionManager:

    def __init__(
        self,
        collection: CollectionManager,
        encryption_config: DynamoDbTablesEncryptionConfig,
    ):
        self._collection = collection
        self._encryption_config = encryption_config

    # def _transform_table:

class EncryptedResource:
    def __init__(
        self,
        resource: ServiceResource,
        encryption_config: DynamoDbTablesEncryptionConfig,
    ):
        self._resource = resource
        self._encryption_config = encryption_config
        self._transformer = DynamoDbEncryptionTransforms(
            config = encryption_config
        )
        self._client_shape_to_resource_shape_converter = ClientShapeToResourceShapeConverter()
        self._resource_shape_to_client_shape_converter = ResourceShapeToClientShapeConverter()

    
    def Table(self, name, **kwargs):
        print("EncryptedResource making EncryptedTable")

        return EncryptedTable(
            table=self._resource.Table(name),
            encryption_config=self._encryption_config
        )
    
    def __getattr__(self, name):
        print("calling EncryptedResource.__getattr__")
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
        
    def batch_get_item(self, **kwargs):
        input_transform_input = self._resource_shape_to_client_shape_converter.batch_get_item_request(kwargs)
        input_transform_output = self._transformer.batch_get_item_input_transform(
            BatchGetItemInputTransformInput(
                sdk_input = input_transform_input
            )
        ).transformed_input

        sdk_input = self._client_shape_to_resource_shape_converter.batch_get_item_request(input_transform_output)

        sdk_output = self._resource.batch_get_item(**sdk_input)

        output_transform_input = self._resource_shape_to_client_shape_converter.batch_get_item_response(sdk_output)

        output_transform_output = self._transformer.batch_get_item_output_transform(
            BatchGetItemOutputTransformInput(
                original_input = input_transform_input,
                sdk_output = output_transform_input,
            )
        ).transformed_output

        response = self._client_shape_to_resource_shape_converter.batch_get_item_response(output_transform_output)
        response = self._copy_missing_sdk_output_fields_to_response(sdk_output, response, output_transform_output)

        return response
    
    def batch_write_item(self, **kwargs):
        input_transform_input = self._resource_shape_to_client_shape_converter.batch_write_item_request(kwargs)
        input_transform_output = self._transformer.batch_write_item_input_transform(
            BatchWriteItemInputTransformInput(
                sdk_input = input_transform_input
            )
        ).transformed_input

        sdk_input = self._client_shape_to_resource_shape_converter.batch_write_item_request(input_transform_output)

        sdk_output = self._resource.batch_write_item(**sdk_input)

        output_transform_input = self._resource_shape_to_client_shape_converter.batch_write_item_response(sdk_output)

        output_transform_output = self._transformer.batch_write_item_output_transform(
            BatchWriteItemOutputTransformInput(
                original_input = input_transform_input,
                sdk_output = output_transform_input,
            )
        ).transformed_output

        response = self._client_shape_to_resource_shape_converter.batch_write_item_response(output_transform_output)
        response = self._copy_missing_sdk_output_fields_to_response(sdk_output, response, output_transform_output)

        return response

    def _copy_missing_sdk_output_fields_to_response(self, sdk_output, response, output_transform_output):
        for sdk_output_key, sdk_output_value in sdk_output.items():
            if sdk_output_key not in output_transform_output:
                response[sdk_output_key] = sdk_output_value
        return response