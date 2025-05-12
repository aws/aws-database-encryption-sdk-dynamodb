import boto3
import types
import aws_dbesdk_dynamodb_test_vectors.internaldafny.generated.CreateInterceptedDDBClient
import aws_cryptography_internal_dynamodb.internaldafny.extern
from aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.dafny_to_smithy import aws_cryptography_dbencryptionsdk_dynamodb_DynamoDbTablesEncryptionConfig
from aws_dbesdk_dynamodb.encrypted.table import EncryptedTable
from aws_dbesdk_dynamodb.encrypted.resource import EncryptedResource
from smithy_dafny_standard_library.internaldafny.generated import Wrappers
from aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.errors import _smithy_error_to_dafny_error
from aws_dbesdk_dynamodb_test_vectors.waiting_boto3_ddb_client import WaitingLocalDynamoClient
from aws_dbesdk_dynamodb.transform import (
    dict_to_ddb,
    ddb_to_dict,
)
from aws_dbesdk_dynamodb.internal.resource_to_client import ResourceShapeToClientShapeConverter
from aws_dbesdk_dynamodb.internal.client_to_resource import ClientShapeToResourceShapeConverter

# TestVectors-only override of ._flush method:
# persist response in self._response for TestVectors output processing.
def _flush_and_persist_response(self):
    items_to_send = self._items_buffer[: self._flush_amount]
    self._items_buffer = self._items_buffer[self._flush_amount :]
    # changed from `response = ` to `self.response = `
    self._response = self._client.batch_write_item(
        RequestItems={self._table_name: items_to_send}
    )
    unprocessed_items = self._response['UnprocessedItems']
    if not unprocessed_items:
        unprocessed_items = {}
    item_list = unprocessed_items.get(self._table_name, [])
    # Any unprocessed_items are immediately added to the
    # next batch we send.
    self._items_buffer.extend(item_list)

class DynamoDBClientWrapperForDynamoDBResource:
    """
    Internal-only wrapper class for DBESDK TestVectors.

    TestVectors Dafny code only knows how to interact with DynamoDB clients.
    However, Python DDBEC and DBESDK have an EncryptedResource class that wraps boto3 DynamoDB Resources.
    These classes create EncryptedTables that wrap boto3 DynamoDB Table Resources.
    This class interfaces between Dafny TestVectors' DynamoDB client-calling code
      and Python DBESDK's EncryptedResource/EncryptedTable classes.

    This class defers to a boto3 client for create_table and delete_table,
      which are not supported on boto3 DynamoDB Table resources.

    TODO: Transact not supported on table. What do?
    """

    def __init__(self, resource, client):
        self._resource = resource
        self._client = client
        self._client_shape_to_resource_shape_converter = ClientShapeToResourceShapeConverter()
        self._resource_shape_to_client_shape_converter = ResourceShapeToClientShapeConverter()

    def batch_write_item(self, **kwargs):
        # The input here is from the DBESDK TestVectors, which is in the shape of a client request.
        # Convert the client request to a resource request to be passed to the table.
        table_input = self._client_shape_to_resource_shape_converter.batch_write_item_request(kwargs)
        # ClientShapeToResourceShapeConverters don't convert DynamoDB expressions from strings to Condition objects,
        #   because resource shapes can accept strings.
        # For TestVectors coverage, use a TestVectors-internal string-to-Condition converter.
        # TODO: Use a shared Condition converter.
        table_output = self._resource.batch_write_item(**table_input)
        client_output = self._resource_shape_to_client_shape_converter.batch_write_item_response(table_output)
        return client_output
    
    def batch_get_item(self, **kwargs):
        table_input = self._client_shape_to_resource_shape_converter.batch_get_item_request(kwargs)
        table_output = self._resource.batch_get_item(**table_input)
        client_output = self._resource_shape_to_client_shape_converter.batch_get_item_response(table_output)
        return client_output
    
    def scan(self, **kwargs):
        # Resources don't have scan, but our EncryptedResources can provide EncryptedTables that do support scan.
        # This path tests that the EncryptedTables provided by EncryptedResources can used for scan.
        table_name = kwargs["TableName"]
        table_input = self._client_shape_to_resource_shape_converter.scan_request(kwargs)
        encrypted_table = self._resource.Table(table_name)
        table_output = encrypted_table.scan(**table_input)
        table_shape_converter = ResourceShapeToClientShapeConverter(table_name=table_name)
        client_output = table_shape_converter.scan_response(table_output)
        return client_output
    
    def put_item(self, **kwargs):
        # Resources don't have put_item, but our EncryptedResources can provide EncryptedTables that do support put_item.
        # This path tests that the EncryptedTables provided by EncryptedResources can used for put_item.
        table_name = kwargs["TableName"]
        table_input = self._client_shape_to_resource_shape_converter.put_item_request(kwargs)
        encrypted_table = self._resource.Table(table_name)
        table_output = encrypted_table.put_item(**table_input)
        table_shape_converter = ResourceShapeToClientShapeConverter(table_name=table_name)
        client_output = table_shape_converter.put_item_response(table_output)
        return client_output
    
    def get_item(self, **kwargs):
        # Resources don't have get_item, but our EncryptedResources can provide EncryptedTables that do support get_item.
        # This path tests that the EncryptedTables provided by EncryptedResources can used for get_item.
        table_name = kwargs["TableName"]
        table_input = self._client_shape_to_resource_shape_converter.get_item_request(kwargs)
        encrypted_table = self._resource.Table(table_name)
        table_output = encrypted_table.get_item(**table_input)
        table_shape_converter = ResourceShapeToClientShapeConverter(table_name=table_name)
        client_output = table_shape_converter.get_item_response(table_output)
        return client_output
    
    def query(self, **kwargs):
        # Resources don't have query, but our EncryptedResources can provide EncryptedTables that do support query.
        # This path tests that the EncryptedTables provided by EncryptedResources can used for query.
        table_name = kwargs["TableName"]
        table_input = self._client_shape_to_resource_shape_converter.put_item_request(kwargs)
        encrypted_table = self._resource.Table(table_name)
        table_output = encrypted_table.query(**table_input)
        table_shape_converter = ResourceShapeToClientShapeConverter(table_name=table_name)
        client_output = table_shape_converter.put_item_response(table_output)
        return client_output

    def transact_get_items(self, **kwargs):
        raise NotImplementedError("transact_get_items not supported on resources")

    def transact_write_items(self, **kwargs):
        raise NotImplementedError("transact_get_items not supported on resources")

    def delete_table(self, **kwargs):
        # Resources don't have delete_table. Plus, DBESDK doesn't intercept DeleteTable calls.
        # TestVectors only use this to ensure a new, clean table is created for each test.
        # Defer to the underlying boto3 client to delete the table.
        return self._client.delete_table(**kwargs)

    def create_table(self, **kwargs):
        # Resources don't have create_table. Plus, DBESDK doesn't intercept CreateTable calls.
        # TestVectors only use this to ensure a new, clean table is created for each test.
        # Defer to the underlying boto3 client to create a table.
        return self._client.create_table(**kwargs)


class default__:
    @staticmethod
    def CreateVanillaDDBClient():
        try:
            return aws_cryptography_internal_dynamodb.internaldafny.extern.Com_Amazonaws_Dynamodb.default__.DynamoDBClient(WaitingLocalDynamoClient())
        except Exception as e:
            return Wrappers.Result_Failure(_smithy_error_to_dafny_error(e))

    @staticmethod
    def CreateInterceptedDDBClient(dafny_encryption_config):
        try:
            native_encryption_config = aws_cryptography_dbencryptionsdk_dynamodb_DynamoDbTablesEncryptionConfig(dafny_encryption_config)
            boto3_client = WaitingLocalDynamoClient()
            table_config_names = list(native_encryption_config.table_encryption_configs.keys())
            if len(table_config_names) > 1:
                raise ValueError("TODO more than 1 table; need EncryptedTablesManager")
            # table = boto3.resource('dynamodb').Table(table_config_names[0])
            resource = boto3.resource('dynamodb', endpoint_url="http://localhost:8000")
            encrypted_resource = EncryptedResource(resource = resource, encryption_config = native_encryption_config)
            wrapped_encrypted_resource = DynamoDBClientWrapperForDynamoDBResource(resource = encrypted_resource, client = boto3_client)
            return aws_cryptography_internal_dynamodb.internaldafny.extern.Com_Amazonaws_Dynamodb.default__.DynamoDBClient(wrapped_encrypted_resource)
        except Exception as e:
            return Wrappers.Result_Failure(_smithy_error_to_dafny_error(e))

aws_dbesdk_dynamodb_test_vectors.internaldafny.generated.CreateInterceptedDDBClient.default__ = default__
