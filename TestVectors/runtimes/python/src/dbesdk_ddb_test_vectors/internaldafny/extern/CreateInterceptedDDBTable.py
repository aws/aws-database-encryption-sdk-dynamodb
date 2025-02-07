import boto3
import types
import dbesdk_ddb_test_vectors.internaldafny.generated.CreateInterceptedDDBClient
import aws_cryptography_internal_dynamodb.internaldafny.extern
from aws_database_encryption_sdk.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.dafny_to_smithy import aws_cryptography_dbencryptionsdk_dynamodb_DynamoDbTablesEncryptionConfig
from aws_database_encryption_sdk.encryptor.table import (
    EncryptedTable,
)
from aws_database_encryption_sdk.internal.resource_to_client import ResourceShapeToClientShapeConverter
from aws_database_encryption_sdk.internal.client_to_resource import ClientShapeToResourceShapeConverter
from smithy_dafny_standard_library.internaldafny.generated import Wrappers
from aws_database_encryption_sdk.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.errors import _smithy_error_to_dafny_error
from dbesdk_ddb_test_vectors.waiting_boto3_ddb_client import WaitingDynamoClient
from aws_database_encryption_sdk.transform import (
    dict_to_ddb,
    ddb_to_dict,
)
from aws_database_encryption_sdk.internal import client_to_resource

from boto3.dynamodb.conditions import Key, Attr, And, Or, Not
from boto3.dynamodb.types import TypeDeserializer


def convert_client_expression_to_conditions(expression):
    """
    Crypto Tools internal method to convert a DynamoDB filter/key expression to boto3 Resource tokens.

    THIS SHOULD NOT BE USED BY ANY EXTERNAL USERS.
    This is a basic implementation for simple expressions that will fail with complex expressions.
    
    I have two suggestions for extending this to support more complex expressions:
    1) To support one or a few complex expressions, consider extending the existing logic.

    2) To support all expressions, consider implementing and extending this library's generated internal Dafny code.
    This library's generated internal Dafny code has a DynamoDB filter/conditions expression syntax parser.
    This will parse a _dafny.Seq of an expression and produce Dafny tokens for the expression.
    Reusing this parser here this will involve
        1. Mapping Dafny tokens to boto3 Resource tokens.
            (e.g. Dafny class Token_Between -> boto3.dynamodb.conditions.Between)
        2. Converting Dafny token grammar to boto3 Resource token grammar.
            (e.g.
                Dafny: [Token_Between, Token_Open, Token_Attr, Token_And, Token_Attr, Token_Close]
                ->
                boto3: [Between(Attr, Attr)]
            )

    Stub code for using the parser from Dafny:

    ```
    from aws_database_encryption_sdk.internaldafny.generated.DynamoDBFilterExpr import default__ as filter_expr
    import _dafny
    from smithy_dafny_standard_library.internaldafny.generated import Wrappers

    dafny_expr_token = filter_expr.ParseExpr(
        _dafny.Seq(
            expression
        ),
    )
    ```
    
    :param expression: A string of the DynamoDB client expression (e.g., "AttrName = :val").
    :return: A boto3.dynamodb.conditions object (Key, Attr, or a combination of them).
    """

    # Recursive parser for complex expressions
    def parse_expression(expr_tokens):
        # simple between
        if "BETWEEN" == expr_tokens[1].upper():
            attr_name = expr_tokens[0]
            value1 = expr_tokens[2]
            value2 = expr_tokens[4]
            return Key(attr_name).between(value1, value2)

        # simple in
        elif "IN" == expr_tokens[1].upper():
            print(f"IN {expr_tokens=}")
            attr_name = expr_tokens[0]
            values_in_list = expr_tokens[3:-1]
            for i in range(len(values_in_list)):
                if values_in_list[i][-1] == ",":
                    values_in_list[i] = values_in_list[i][:-1]
            return Attr(attr_name).is_in(values_in_list)

        # simple contains
        elif "CONTAINS" == expr_tokens[0].upper():
            attr_name = expr_tokens[2]
            if attr_name[-1] == ",":
                attr_name = attr_name[:-1]
            value = expr_tokens[3]
            return Attr(attr_name).contains(value)
        
        # simple begins_with
        elif "BEGINS_WITH" == expr_tokens[0].upper():
            attr_name = expr_tokens[2]
            if attr_name[-1] == ",":
                attr_name = attr_name[:-1]
            value = expr_tokens[3]
            return Attr(attr_name).begins_with(value)
         
        # Base case: Single comparison or condition
        if "AND" not in [t.upper() for t in expr_tokens] and "OR" not in [t.upper() for t in expr_tokens]:

            # simple comparison
            attr_name = expr_tokens[0]
            operator = expr_tokens[1].upper()
            value = expr_tokens[2]

            # Map operator to Key or Attr
            if operator == "=":
                return Key(attr_name).eq(value)
            elif operator == "<":
                return Key(attr_name).lt(value)
            elif operator == "<=":
                return Key(attr_name).lte(value)
            elif operator == ">":
                return Key(attr_name).gt(value)
            elif operator == ">=":
                return Key(attr_name).gte(value)
            elif operator in ("!=", "<>"):
                return Attr(attr_name).ne(value)
            else:
                raise ValueError(f"Unsupported operator: {operator}")

        # Recursive case: Logical AND/OR
        stack = []
        current_expr = []

        for token in expr_tokens:
            if token.upper() in ("AND", "OR"):
                left = parse_expression(current_expr)
                current_expr = []
                stack.append((left, token))  # Save the left condition and operator
            else:
                current_expr.append(token)

        # Handle the final condition on the right
        right = parse_expression(current_expr)

        # Combine the stack of conditions
        while stack:
            left, operator = stack.pop()
            if operator.upper() == "AND":
                right = And(left, right)
            elif operator.upper() == "OR":
                right = Or(left, right)

        return right

    # Tokenize the expression and parse it
    tokens = expression.replace("(", " ( ").replace(")", " ) ").split()
    return parse_expression(tokens)

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
        self._client_shape_to_table_shape_converter = ClientShapeToResourceShapeConverter()
        self._table_shape_to_client_shape_converter = ResourceShapeToClientShapeConverter(table_name = self._table._table.table_name)

    def put_item(self, **kwargs):
        table_input = self._client_shape_to_table_shape_converter.put_item_request(kwargs)
        table_output = self._table.put_item(**table_input)
        client_output = self._table_shape_to_client_shape_converter.put_item_response(table_output)
        return client_output

    def get_item(self, **kwargs):
        table_input = self._client_shape_to_table_shape_converter.get_item_request(kwargs)
        table_output = self._table.get_item(**table_input)
        client_output = self._table_shape_to_client_shape_converter.get_item_response(table_output)
        return client_output

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
        # print(f"batch_write_item {kwargs=}")
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
        table_input = self._client_shape_to_table_shape_converter.scan_request(kwargs)
        table_output = self._table.scan(**table_input)
        client_output = self._table_shape_to_client_shape_converter.scan_response(table_output)
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
        table_input = self._client_shape_to_table_shape_converter.query_request(kwargs)
        table_output = self._table.query(**table_input)
        client_output = self._table_shape_to_client_shape_converter.query_response(table_output)
        return client_output

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
            table = boto3.resource('dynamodb').Table(table_config_names[0])
            encrypted_table = EncryptedTable(table = table, encryption_config = native_encryption_config)
            wrapped_encrypted_table = DynamoDBClientWrapperForDynamoDBTable(table = encrypted_table, client = boto3_client)
            return aws_cryptography_internal_dynamodb.internaldafny.extern.Com_Amazonaws_Dynamodb.default__.DynamoDBClient(wrapped_encrypted_table)
        except Exception as e:
            return Wrappers.Result_Failure(_smithy_error_to_dafny_error(e))

dbesdk_ddb_test_vectors.internaldafny.generated.CreateInterceptedDDBClient.default__ = default__
