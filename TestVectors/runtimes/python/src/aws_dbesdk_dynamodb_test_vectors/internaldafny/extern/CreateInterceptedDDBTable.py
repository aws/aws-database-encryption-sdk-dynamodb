import boto3
import types
import aws_dbesdk_dynamodb_test_vectors.internaldafny.generated.CreateInterceptedDDBClient
import aws_cryptography_internal_dynamodb.internaldafny.extern
from aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.dafny_to_smithy import aws_cryptography_dbencryptionsdk_dynamodb_DynamoDbTablesEncryptionConfig
from aws_dbesdk_dynamodb.encrypted.table import (
    EncryptedTable,
)
from aws_dbesdk_dynamodb.internal.resource_to_client import ResourceShapeToClientShapeConverter
from aws_dbesdk_dynamodb.internal.client_to_resource import ClientShapeToResourceShapeConverter
from smithy_dafny_standard_library.internaldafny.generated import Wrappers
from aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.errors import _smithy_error_to_dafny_error
from aws_dbesdk_dynamodb_test_vectors.waiting_boto3_ddb_client import WaitingLocalDynamoClient
from aws_dbesdk_dynamodb.transform import (
    dict_to_ddb,
    ddb_to_dict,
)
from aws_dbesdk_dynamodb.internal import client_to_resource

from boto3.dynamodb.conditions import Key, Attr, And, Or, Not, Contains
from boto3.dynamodb.types import TypeDeserializer

# from .....test.resource_formatted_queries import (queries, complex_queries)

# When querying, DBESDK DDB TestVectors will pass the Table the query as a string.
# The Table would accept this string as-is and process it correctly.
# But EncryptedTables have extra logic to process boto3 Conditions.
# We want to test this extra logic as much as possible.
# This map converts some known query strings to equivalent Conditions.
# TestVectors will pass the query string (map key) to the Table;
# the Table's internal logic will look up the query string in this map:
#  - Entry found: Query with replaced Condition
#  - Not found: Query with original string. Table accepts passthrough strings.
# This map contains all query strings in the TestVectors' data.json as of commit
# 4f18689f79243c9a5ab0f3a23108671defddeac4
# If any query strings are added to TestVectors, they COULD be added here,
#   but do not need to be added.
known_query_string_to_condition_map = {
    # "Basic" queries
    "RecNum = :zero": Key("RecNum").eq(":zero"),
    "RecNum = :one": Key("RecNum").eq(":one"), 
    "RecNum = :zero": Attr("RecNum").eq(":zero"),
    "RecNum <= :zero": Attr("RecNum").lte(":zero"),
    "RecNum > :zero": Attr("RecNum").gt(":zero"),
    "RecNum >= :zero": Attr("RecNum").gte(":zero"),
    "RecNum <> :zero": Attr("RecNum").ne(":zero"),
    "RecNum = :zero": Attr("RecNum").eq(":zero"),
    "RecNum = :one": Attr("RecNum").eq(":one"),
    "Nine between :zeroD and :three": Attr("Nine").between(":zeroD", ":three"),
    "Nine between :nineD and :nine": Attr("Nine").between(":nineD", ":nine"),
    "Nine between :nine and :three": Attr("Nine").between(":nine", ":three"),
    "Nine between :nine and :nine": Attr("Nine").between(":nine", ":nine"),
    "NumberTest = :NumberTest": Attr("NumberTest").eq(":NumberTest"),
    "RecNum in (:zero, :one)": Attr("RecNum").is_in([":zero", ":one"]),
    "Two = :two": Attr("Two").eq(":two"),
    "Two = :two or Three = :three or Four = :four OR Five = :five": Attr("Two").eq(":two") | Attr("Three").eq(":three") | Attr("Four").eq(":four") | Attr("Five").eq(":five"),
    "Two = :two and Three = :three and Four = :four and Five = :five": Attr("Two").eq(":two") & Attr("Three").eq(":three") & Attr("Four").eq(":four") & Attr("Five").eq(":five"),
    "Two in (:two, :three, :four, :five)": Attr("Two").is_in([":two", ":three", ":four", ":five"]),
    "Five in (:two, :three, :four, :five)": Attr("Five").is_in([":two", ":three", ":four", ":five"]),
    "Five in (:strset)": Attr("Five").is_in([":strset"]),
    "Five in (:strlist)": Attr("Five").is_in([":strlist"]),
    "contains(One, :oneA)": Attr("One").contains(":oneA"),
    "contains(One, :oneB)": Attr("One").contains(":oneB"),
    # Hard-coding returning the input string for these cases.
    # These conditions test undocumented behavior in DynamoDB that can't be expressed with boto3 Conditions.
    # The undocumented behavior is that `contains`' first parameter can be a value,
    #   and does not need to be an attribute name.
    # DynamoDB documentation names `contains`' first argument as `path`,
    #   and only ever documents accepting an attribute name for `path`.
    # However, testing with an AWS SDK reveals that `path` can be a value;
    #   i.e. a hardcoded string or an attribute value, 
    #   so this expression is valid.
    # But I can't find a way to express this via boto3 Conditions,
    #   where Contains requires an attribute name.
    # For these strings, do not attempt to convert to boto3 conditions,
    #   and just return the input string.
    # The input string is still passed to the table and tested.
    "contains(:oneA, One)": "contains(:oneA, One)",
    "contains(:oneB, One)": "contains(:oneB, One)",
    "contains(:strset, One)": "contains(:strset, One)",
    
    # "Complex" queries
    "Comp1 := :cmp1a": Attr("Comp1").eq(":cmp1a"),
    "begins_with(Comp1, :cmp1c)": Attr("Comp1").begins_with(":cmp1c"),
    # Another query that can't be translated to boto3 Conditions,
    # since attribute values aren't attribute names.
    # Pass the original string through.
    ":cmp1c <= Comp1": ":cmp1c <= Comp1",

    "cmp1c < Comp1": Attr("cmp1c").lt("Comp1"),
    "cmp1c = Comp1": Attr("cmp1c").eq("Comp1"),
    "begins_with(Comp1, :cmp1d)": Attr("Comp1").begins_with(":cmp1d"),
    "contains(Comp1, :cmp1c)": Attr("Comp1").contains(":cmp1c"),
    "contains(Comp1, :cmp1d)": Attr("Comp1").contains(":cmp1d"),
    "Comp1 = :cmp1b": Attr("Comp1").eq(":cmp1b"),
}

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

class DynamoDBClientWrapperForDynamoDBTable:
    """
    DBESDK TestVectors-internal wrapper class.
    Converts boto3 DynamoDB client-formatted inputs Table-formatted inputs,
        and converts Table-formatted outputs to boto3 DynamoDB client-formatted outputs.

    TestVectors Dafny code only knows how to interact with DynamoDB clients.
    However, Python DDBEC and DBESDK have an EncryptedTable class that wraps boto3 DynamoDB Tables.
    This class interfaces between Dafny TestVectors' DynamoDB client-calling code
      and Python DBESDK's EncryptedTable class.

    This class defers to a boto3 client for create_table and delete_table,
      which are not supported on boto3 DynamoDB Table tables.
    """

    def __init__(self, table, client):
        self._table = table
        self._client = client
        self._client_shape_to_resource_shape_converter = ClientShapeToResourceShapeConverter()
        self._resource_shape_to_client_shape_converter = ResourceShapeToClientShapeConverter(table_name = self._table._table.table_name)

    def put_item(self, **kwargs):
        table_input = self._client_shape_to_resource_shape_converter.put_item_request(kwargs)
        table_output = self._table.put_item(**table_input)
        client_output = self._resource_shape_to_client_shape_converter.put_item_response(table_output)
        return client_output

    def get_item(self, **kwargs):
        table_input = self._client_shape_to_resource_shape_converter.get_item_request(kwargs)
        table_output = self._table.get_item(**table_input)
        client_output = self._resource_shape_to_client_shape_converter.get_item_response(table_output)
        return client_output

    def batch_write_item(self, **kwargs):
        table_input = self._client_shape_to_resource_shape_converter.batch_write_item_request(kwargs)
        table_output = self._table.batch_write_item(**table_input)
        client_output = self._resource_shape_to_client_shape_converter.batch_write_item_response(table_output)
        return client_output
    
        # Parse boto3 client.batch_write_item input into table.batch_writer() calls
        # client.batch_write_item: https://boto3.amazonaws.com/v1/documentation/api/latest/reference/services/dynamodb/client/batch_write_item.html
        # table.batch_writer(): https://boto3.amazonaws.com/v1/documentation/api/latest/reference/services/dynamodb/table/batch_writer.html
        tables = kwargs["RequestItems"]
        table_names = list(tables.keys())
        if len(tables.keys()) > 1:
            raise ValueError("Table batch_write_item only supports 1 table in a request.")
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

    def batch_get_item(self, **kwargs):
        raise NotImplementedError("batch_get_item not supported on table interface; remove tests calling this")
        # batch_get_item doesn't exist on boto3 tables.
        # For TestVector compatibility, just make a series of get_item calls,
        # and massage inputs/outputs into expected formats.
        # tables = kwargs["RequestItems"]
        # table_names = list(tables.keys())
        # if len(tables.keys()) > 1:
        #     raise ValueError("Table batch_get_item only supports 1 table in a request.")
        # table_name = table_names[0]
        # requests = tables[table_name]

        # outputs = []
        # for request in requests["Keys"]:
        #     output = self._table.get_item(Key = ddb_to_dict(request))
        #     outputs.append(dict_to_ddb(output["Item"]))

        # # boto3 client batch_get_item return shape
        # return {
        #     "Responses": {
        #         table_name: outputs
        #     }
        # }

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
        # print(f"batch_get_item output {batch._response=}")
        # return batch._response


    def scan(self, **kwargs):
        table_input = self._client_shape_to_resource_shape_converter.scan_request(kwargs)
        # To exhaustively test Tables,
        # convert the string-based KeyConditionExpression and FilterExpression
        # into the boto3.conditions.Key and boto3.conditions.Attr resource-formatted queries.
        if "KeyConditionExpression" in table_input:
            if table_input["KeyConditionExpression"] in known_query_string_to_condition_map:
                # Turn the query into the resource-formatted query
                query = known_query_string_to_condition_map[table_input["KeyConditionExpression"]]
                table_input["KeyConditionExpression"] = query
        if "FilterExpression" in table_input:
            if table_input["FilterExpression"] in known_query_string_to_condition_map:
                # Turn the query into the resource-formatted query
                table_input["FilterExpression"] = known_query_string_to_condition_map[table_input["FilterExpression"]]
        table_output = self._table.scan(**table_input)
        client_output = self._resource_shape_to_client_shape_converter.scan_response(table_output)
        return client_output

    def transact_get_items(self, **kwargs):
        raise NotImplementedError("transact_get_items not supported on table interface; remove tests calling this")
        # Parse client transact_get_items shape into series of table get_item calls
        # ddb_requests = kwargs["TransactItems"]
        # responses = []
        # for request in ddb_requests:
        #     get_request = request["Get"]
        #     ddb_key = get_request["Key"]
        #     dict_key = ddb_to_dict(ddb_key)
        #     get_request["Key"] = dict_key
        #     del get_request["TableName"]

        #     table_response = self._table.get_item(**get_request)

        #     dict_item = table_response["Item"]
        #     ddb_item = dict_to_ddb(dict_item)
        #     table_response["Item"] = ddb_item
        #     responses.append(table_response)
        # return {"Responses": responses}

    def transact_write_items(self, **kwargs):
        raise NotImplementedError("transact_write_items not supported on table interface; remove tests calling this")
        # Parse client transact_get_items shape into series of table get_item calls
        # ddb_requests = kwargs["TransactItems"]
        # responses = []
        # for request in ddb_requests:
        #     get_request = request["Get"]
        #     ddb_key = get_request["Key"]
        #     dict_key = ddb_to_dict(ddb_key)
        #     get_request["Key"] = dict_key
        #     del get_request["TableName"]

        #     table_response = self._table.get_item(**get_request)

        #     dict_item = table_response["Item"]
        #     ddb_item = dict_to_ddb(dict_item)
        #     table_response["Item"] = ddb_item
        #     responses.append(table_response)
        # return {"Responses": responses}

    def query(self, **kwargs):
        table_input = self._client_shape_to_resource_shape_converter.query_request(kwargs)
        # To exhaustively test Tables,
        # convert the string-based KeyConditionExpression and FilterExpression
        # into the boto3.conditions.Key and boto3.conditions.Attr resource-formatted queries.
        if "KeyConditionExpression" in table_input:
            if table_input["KeyConditionExpression"] in known_query_string_to_condition_map:
                # Turn the query into the resource-formatted query
                query = known_query_string_to_condition_map[table_input["KeyConditionExpression"]]
                table_input["KeyConditionExpression"] = query
        if "FilterExpression" in table_input:
            if table_input["FilterExpression"] in known_query_string_to_condition_map:
                # Turn the query into the resource-formatted query
                table_input["FilterExpression"] = known_query_string_to_condition_map[table_input["FilterExpression"]]
        table_output = self._table.query(**table_input)
        client_output = self._resource_shape_to_client_shape_converter.query_response(table_output)
        return client_output

    def delete_table(self, **kwargs):
        return self._client.delete_table(**kwargs)

    def create_table(self, **kwargs):
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
            table = boto3.resource('dynamodb').Table(table_config_names[0])
            encrypted_table = EncryptedTable(table = table, encryption_config = native_encryption_config)
            wrapped_encrypted_table = DynamoDBClientWrapperForDynamoDBTable(table = encrypted_table, client = boto3_client)
            return aws_cryptography_internal_dynamodb.internaldafny.extern.Com_Amazonaws_Dynamodb.default__.DynamoDBClient(wrapped_encrypted_table)
        except Exception as e:
            return Wrappers.Result_Failure(_smithy_error_to_dafny_error(e))

aws_dbesdk_dynamodb_test_vectors.internaldafny.generated.CreateInterceptedDDBClient.default__ = default__
