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
# The Table could accept this string as-is and process it correctly.
# However, EncryptedTables have extra logic to process boto3 Conditions.
# We want to test this extra logic as much as possible.
# This map converts some known query strings to equivalent Conditions.
# TestVectors will pass the query string (map key) to the Table;
# the Table's internal logic will look up the query string in this map:
#  - Entry found: Query with replaced Condition
#  - Not found: Query with original string. Table accepts strings.
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

class DynamoDBClientWrapperForDynamoDBTable:
    """
    DBESDK TestVectors-internal wrapper class.
    Converts boto3 DynamoDB client-formatted inputs to Table-formatted inputs,
        and converts Table-formatted outputs to boto3 DynamoDB client-formatted outputs.

    TestVectors Dafny code only knows how to interact with DynamoDB clients.
    However, Python DDBEC and DBESDK have this EncryptedTable class.
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
        # table_output = self._table.batch_write_item(**table_input)
        batch_writer = self._table.batch_writer()
        for item in table_input["Items"]:
            if "PutRequest" in item:
                batch_writer.put_item(item["PutRequest"]["Item"])
            elif "DeleteRequest" in item:
                batch_writer.delete_item(item["DeleteRequest"]["Key"])
        table_output = batch_writer.close()
        client_output = self._resource_shape_to_client_shape_converter.batch_write_item_response(table_output)
        return client_output

    def batch_get_item(self, **kwargs):
        raise NotImplementedError("batch_get_item not supported on table interface; remove tests calling this")

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

    def transact_write_items(self, **kwargs):
        raise NotImplementedError("transact_write_items not supported on table interface; remove tests calling this")

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
                # If needed, >1 table could be supported by setting up an EncryptedTablesManager
                raise ValueError(">1 table not supported")
            # For TestVectors, use local DynamoDB endpoint
            table = boto3.resource('dynamodb', endpoint_url="http://localhost:8000").Table(table_config_names[0])
            encrypted_table = EncryptedTable(table = table, encryption_config = native_encryption_config)
            wrapped_encrypted_table = DynamoDBClientWrapperForDynamoDBTable(table = encrypted_table, client = boto3_client)
            return aws_cryptography_internal_dynamodb.internaldafny.extern.Com_Amazonaws_Dynamodb.default__.DynamoDBClient(wrapped_encrypted_table)
        except Exception as e:
            return Wrappers.Result_Failure(_smithy_error_to_dafny_error(e))

aws_dbesdk_dynamodb_test_vectors.internaldafny.generated.CreateInterceptedDDBClient.default__ = default__
