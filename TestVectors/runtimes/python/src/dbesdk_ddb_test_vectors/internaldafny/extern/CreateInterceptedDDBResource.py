import boto3
import types
import dbesdk_ddb_test_vectors.internaldafny.generated.CreateInterceptedDDBClient
import aws_cryptography_internal_dynamodb.internaldafny.extern
from aws_database_encryption_sdk.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.dafny_to_smithy import aws_cryptography_dbencryptionsdk_dynamodb_DynamoDbTablesEncryptionConfig
from aws_database_encryption_sdk.encryptor.table import EncryptedTable
from aws_database_encryption_sdk.encryptor.resource import EncryptedResource
from smithy_dafny_standard_library.internaldafny.generated import Wrappers
from aws_database_encryption_sdk.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.errors import _smithy_error_to_dafny_error
from dbesdk_ddb_test_vectors.waiting_boto3_ddb_client import WaitingDynamoClient
from aws_database_encryption_sdk.transform import (
    dict_to_ddb,
    ddb_to_dict,
)

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

    def put_item(self, **kwargs):
        pass

    def get_item(self, **kwargs):
        key_dynamodb_format = kwargs["Key"]
        key_dict_format = ddb_to_dict(key_dynamodb_format)
        kwargs["Key"] = key_dict_format
        dict_format_output = self._resource.get_item(**kwargs)
        dynamodb_format_item = dict_format_output
        if "Item" in dict_format_output:
            dynamodb_format_item["Item"] = dict_to_ddb(dict_format_output["Item"])
        return dynamodb_format_item

    def _convert_batch_write_item_request_from_dynamo_to_dict(self, **kwargs):
        for table, requests in kwargs["RequestItems"].items():
            dict_requests = []
            for request in requests:
                request_name_list = list(request.keys())
                if len(request_name_list) > 1:
                    raise ValueError("Cannot send more than one request in a single request")
                request_name = request_name_list[0]
                if request_name == "PutRequest":
                    dict_request = ddb_to_dict(request[request_name]["Item"])
                    dict_requests.append({request_name: {"Item": dict_request}})
                elif request_name == "DeleteRequest":
                    dict_request = ddb_to_dict(request[request_name]["Key"])
                    dict_requests.append({request_name: {"Key": dict_request}})
                else:
                    raise ValueError(f"Unknown batch_write_items method key: {request_name}")
            kwargs["RequestItems"][table] = dict_requests
        return kwargs

    def batch_write_item(self, **kwargs):
        print(f"batch_write_item {kwargs=}")
        dict_formatted = self._convert_batch_write_item_request_from_dynamo_to_dict(**kwargs)
        return self._resource.batch_write_item(**dict_formatted)

        # # print(f"batch_write_item {kwargs=}")
        # # Parse boto3 client.batch_write_item input into table.batch_writer() calls
        # # client.batch_write_item: https://boto3.amazonaws.com/v1/documentation/api/latest/reference/services/dynamodb/client/batch_write_item.html
        # # table.batch_writer(): https://boto3.amazonaws.com/v1/documentation/api/latest/reference/services/dynamodb/table/batch_writer.html
        # tables = kwargs["RequestItems"]
        # table_names = list(tables.keys())
        # if len(tables.keys()) > 1:
        #     raise ValueError("Table batch_write_item only supports 1 table in a request.")
        # requests = tables[table_names[0]]
        # with self._table.batch_writer() as batch:

        #     batch._flush=types.MethodType(_flush_and_persist_response, batch)

        #     for request in requests:
        #         request_name_list = list(request.keys())
        #         if len(request_name_list) > 1:
        #             raise ValueError("Cannot send more than one request in a single request")
        #         request_name = request_name_list[0]
        #         if request_name == "PutRequest":
        #             dict_request = ddb_to_dict(request[request_name]["Item"])
        #             boto3_request = {"Item": dict_request}
        #             batch.put_item(**boto3_request)
        #             # dynamodb_request = request[request_name]
        #             # print(f"{dynamodb_request}")
        #             # batch.put_item(**dynamodb_request)
        #         elif request_name == "DeleteRequest":
        #             batch.delete_item(Key=ddb_to_dict(request["Key"]))
        #         else:
        #             raise ValueError(f"Unknown batch_write_items method key: {request_name}")
        # return batch._response

    def batch_get_item(self, **kwargs):
        # batch_get_item doesn't exist on boto3 tables.
        # For TestVector compatibility, just make a series of get_item calls,
        # and massage inputs/outputs into expected formats.
        tables = kwargs["RequestItems"]
        table_names = list(tables.keys())
        if len(tables.keys()) > 1:
            raise ValueError("Table batch_get_item only supports 1 table in a request.")
        requests = tables[table_names[0]]
        with self._table.batch_writer() as batch:

            batch._flush=types.MethodType(_flush_and_persist_response, batch)

            for request in requests:
                request_name_list = list(request.keys())
                if len(request_name_list) > 1:
                    raise ValueError("Cannot send more than one request in a single request")
                request_name = request_name_list[0]
                if request_name == "PutRequest":
                    dict_request = ddb_to_dict(request[request_name]["Item"])
                    boto3_request = {"Item": dict_request}
                    batch.put_item(**boto3_request)
                    # dynamodb_request = request[request_name]
                    # print(f"{dynamodb_request}")
                    # batch.put_item(**dynamodb_request)
                elif request_name == "DeleteRequest":
                    batch.delete_item(Key=ddb_to_dict(request["Key"]))
                else:
                    raise ValueError(f"Unknown batch_write_items method key: {request_name}")
        return batch._response


    def scan(self, **kwargs):
        pass

    def transact_get_items(self, **kwargs):
        pass

    def transact_write_items(self, **kwargs):
        pass

    def query(self, **kwargs):
        pass

    def delete_table(self, **kwargs):
        return self._client.delete_table(**kwargs)

    def create_table(self, **kwargs):
        return self._client.create_table(**kwargs)


class default__:
    @staticmethod
    def CreateVanillaDDBClient():
        try:
            return aws_cryptography_internal_dynamodb.internaldafny.extern.Com_Amazonaws_Dynamodb.default__.DynamoDBClient(WaitingDynamoClient())
        except Exception as e:
            return Wrappers.Result_Failure(_smithy_error_to_dafny_error(e))

    @staticmethod
    def CreateInterceptedDDBClient(dafny_encryption_config):
        try:
            native_encryption_config = aws_cryptography_dbencryptionsdk_dynamodb_DynamoDbTablesEncryptionConfig(dafny_encryption_config)
            boto3_client = WaitingDynamoClient()
            table_config_names = list(native_encryption_config.table_encryption_configs.keys())
            if len(table_config_names) > 1:
                raise ValueError("TODO more than 1 table; need EncryptedTablesManager")
            # table = boto3.resource('dynamodb').Table(table_config_names[0])
            resource = boto3.resource('dynamodb')
            encrypted_resource = EncryptedResource(resource = resource, encryption_config = native_encryption_config)
            wrapped_encrypted_resource = DynamoDBClientWrapperForDynamoDBResource(resource = encrypted_resource, client = boto3_client)
            return aws_cryptography_internal_dynamodb.internaldafny.extern.Com_Amazonaws_Dynamodb.default__.DynamoDBClient(wrapped_encrypted_resource)
        except Exception as e:
            return Wrappers.Result_Failure(_smithy_error_to_dafny_error(e))

dbesdk_ddb_test_vectors.internaldafny.generated.CreateInterceptedDDBClient.default__ = default__
