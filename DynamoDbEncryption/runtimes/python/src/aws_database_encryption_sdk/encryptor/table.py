from boto3.resources.base import ServiceResource

"""High-level helper class to provide an encrypting wrapper for boto3 DynamoDB clients."""
from botocore.paginate import Paginator
import botocore.client
from boto3.dynamodb.table import BatchWriter
from typing import Callable, Optional
from decimal import Decimal

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
from aws_database_encryption_sdk.transform import (
    dict_to_ddb,
    ddb_to_dict,
)
from aws_database_encryption_sdk.encryptor.client import EncryptedClient
from aws_database_encryption_sdk.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.client import (
    DynamoDbEncryptionTransforms
)
from aws_database_encryption_sdk.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models import (
    DynamoDbTablesEncryptionConfig,
)


def transform_transformed_response_for_table_query_or_scan_response(sdk_output, transformed_response):
    response = transformed_response
    for sdk_output_key, sdk_output_value in sdk_output.items():
        if sdk_output_key not in transformed_response:
            response[sdk_output_key] = sdk_output_value
    ddb_items = response["Items"]
    dict_items = []
    for ddb_item in ddb_items:
        dict_item = ddb_to_dict(ddb_item)
        dict_items.append(dict_item)
    response["Items"] = dict_items
    print(f"query {response=}")
    return response

def transform_sdk_output_from_query_or_scan_for_internal_transformer(sdk_output):

    dict_items = sdk_output["Items"]
    ddb_items = []
    for dict_item in dict_items:
        ddb_item = dict_to_ddb(dict_item)
        ddb_items.append(ddb_item)
    sdk_output["Items"] = ddb_items
    return sdk_output

def transform_transformed_request_for_query_or_scan_on_table(transformed_request):
    if "ExpressionAttributeValues" in transformed_request:
        for name, ddb_value in transformed_request["ExpressionAttributeValues"].items():
            dict_item = ddb_to_dict({name: ddb_value})
            transformed_request["ExpressionAttributeValues"][list(dict_item.keys())[0]] = list(dict_item.values())[0]

    return transformed_request


def transform_query_or_scan_input_for_internal_transformer(**kwargs):
    print(f"query {kwargs=}")

    map_to_list_keys = ["KeyConditions", "QueryFilter"]

    # transform legacy keys
    # https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.KeyConditions.html
    for map_to_list_key in map_to_list_keys:
        if map_to_list_key in kwargs:
            attribute_name, attribute_values_lists = kwargs[map_to_list_key].items()
            for attribute_values_list in attribute_values_lists:
                new_attribute_values_list = []
                for attribute_value in attribute_values_list:
                    new_attribute_values_list.append(dict_to_ddb(attribute_value))
                kwargs[map_to_list_key][attribute_name] = new_attribute_values_list
            
    map_keys = ["ExclusiveStartKey"]

    for map_key in map_keys:
        if map_key in kwargs:
            kwargs[map_key] = dict_to_ddb(kwargs[map_key])

    if "ExpressionAttributeValues" in kwargs:
        for name, dict_value in kwargs["ExpressionAttributeValues"].items():
            updated_item = dict_to_ddb({name: dict_value})
            kwargs["ExpressionAttributeValues"][list(updated_item.keys())[0]] = list(updated_item.values())[0]

    # print(f"preconversion {kwargs=}")
    # print(f"preconversion {kwargs['KeyConditionExpression']._values[0].__dict__=}")
    
    # TODO expression_names
    others = ["KeyConditionExpression", "FilterExpression"]
    for other in others:
        if other in kwargs:
            if "ExpressionAttributeNames" in kwargs:
                expression_attribute_names = kwargs["ExpressionAttributeNames"]
            else:
                expression_attribute_names = {}
            
            if "ExpressionAttributeValues" in kwargs:
                expression_attribute_values = kwargs["ExpressionAttributeValues"]
            else:
                expression_attribute_values = {}
            condition_expression, expression_attribute_names, expression_attribute_values = convert_conditions_to_client_expression(kwargs[other],expression_attribute_names, expression_attribute_values)

            kwargs[other] = condition_expression
            if len(expression_attribute_names) > 0:
                kwargs["ExpressionAttributeNames"] = expression_attribute_names
            if len(expression_attribute_values) > 0:
                kwargs["ExpressionAttributeValues"] = expression_attribute_values
    return kwargs

def convert_conditions_to_client_expression(condition, expression_attribute_names, expression_attribute_values):
    """
    Converts a Key/Attr condition into a client-compatible DynamoDB expression.

    :param condition: A boto3.dynamodb.conditions object (Key or Attr).
    :return: A tuple containing:
             - expression string
             - ExpressionAttributeValues dictionary
             - ExpressionAttributeNames dictionary
    """

    from aws_database_encryption_sdk.internal.condition_expression_builder import InternalDBESDKDynamoDBConditionExpressionBuilder
    
    a = InternalDBESDKDynamoDBConditionExpressionBuilder()
    out = a.build_expression(condition, expression_attribute_names, expression_attribute_values)
    return out


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

    def put_item(self, **kwargs):
        # TODO: refactor shared logic (DDB/Python conversions, client/table)

        # Table PutItem requests differ from Client PutItem requests.
        # They do not have the table name, but DBESDK expects the TableName.
        # Insert the TableName for DBESDK.
        kwargs["TableName"] = self._table.table_name

        # Item comes in as a Python dict,
        # but DBESDK internals expect DynamoDB item.
        # Convert to DynamoDB item for DBESDK transformation.
        dynamodb_item = dict_to_ddb(kwargs["Item"])
        dynamodb_input = kwargs
        dynamodb_input["Item"] = dynamodb_item

        transformed_request = self._transformer.put_item_input_transform(
            PutItemInputTransformInput(
                sdk_input = dynamodb_input
            )
        ).transformed_input

        print(f"{transformed_request=}")

        # boto3 Table expects dict...
        dict_transformed_item = ddb_to_dict(transformed_request["Item"])
        transformed_request["Item"] = dict_transformed_item

        print(f"final {transformed_request=}")

        # Also 

        sdk_output = self._table.put_item(**transformed_request)

        # sdk_output is a dict, but DBESDK internals expect DDB

        transformed_response = self._transformer.put_item_output_transform(
            PutItemOutputTransformInput(
                original_input = dynamodb_input,
                sdk_output = sdk_output,
            )
        ).transformed_output
        response = transformed_response
        for sdk_output_key, sdk_output_value in sdk_output.items():
            if sdk_output_key not in transformed_response:
                response[sdk_output_key] = sdk_output_value
        # TODO: standard dicts transform output
        return response
    
    def get_item(self, **kwargs):
        # Table PutItem requests differ from Client PutItem requests.
        # They do not have the table name, but DBESDK expects the TableName.
        # Insert the TableName for DBESDK.
        kwargs["TableName"] = self._table.table_name

        dynamodb_item = dict_to_ddb(kwargs["Key"])
        dynamodb_input = kwargs
        dynamodb_input["Key"] = dynamodb_item


        transformed_request = self._transformer.get_item_input_transform(
            GetItemInputTransformInput(
                sdk_input = dynamodb_input
            )
        ).transformed_input

        # boto3 Table expects dict...
        dict_transformed_item = ddb_to_dict(transformed_request["Key"])
        transformed_request["Key"] = dict_transformed_item
        del transformed_request["TableName"]

        print(f"final get {transformed_request=}")
        
        sdk_output = self._table.get_item(**transformed_request)
        dict_item_from_sdk = sdk_output["Item"]
        ddb_item = dict_to_ddb(dict_item_from_sdk)
        sdk_output["Item"] = ddb_item
        
        transformed_response = self._transformer.get_item_output_transform(
            GetItemOutputTransformInput(
                original_input = dynamodb_input,
                sdk_output = sdk_output,
            )
        ).transformed_output
        response = transformed_response
        for sdk_output_key, sdk_output_value in sdk_output.items():
            if sdk_output_key not in transformed_response:
                response[sdk_output_key] = sdk_output_value
        response["Item"] = ddb_to_dict(response["Item"])
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
        # Table PutItem requests differ from Client PutItem requests.
        # They do not have the table name, but DBESDK expects the TableName.
        # Insert the TableName for DBESDK.
        kwargs["TableName"] = self._table.table_name

        dynamodb_input = transform_query_or_scan_input_for_internal_transformer(**kwargs)

        print(f"scan {kwargs=}")

        # dynamodb_item = dict_to_ddb(kwargs["Key"])
        # dynamodb_input = kwargs
        # dynamodb_input["Key"] = dynamodb_item


        transformed_request = self._transformer.scan_input_transform(
            ScanInputTransformInput(
                sdk_input = dynamodb_input
            )
        ).transformed_input

        # boto3 Table expects dict...
        # dict_transformed_item = ddb_to_dict(transformed_request["Key"])
        # transformed_request["Key"] = dict_transformed_item
        # del transformed_request["TableName"]

        print(f"posttransform {transformed_request=}")

        transformed_request = transform_transformed_request_for_query_or_scan_on_table(transformed_request)


        print(f"final scan {transformed_request=}")
        
        sdk_output = self._table.scan(**transformed_request)
        print(f"{sdk_output=}")

        sdk_output = transform_sdk_output_from_query_or_scan_for_internal_transformer(sdk_output)

        # dict_items = sdk_output["Items"]
        # ddb_items = []
        # for dict_item in dict_items:
        #     ddb_item = dict_to_ddb(dict_item)
        #     ddb_items.append(ddb_item)
        # sdk_output["Items"] = ddb_items

        # dict_item_from_sdk = sdk_output["Item"]
        # ddb_item = dict_to_ddb(dict_item_from_sdk)
        # sdk_output["Item"] = ddb_item
        
        transformed_response = self._transformer.scan_output_transform(
            ScanOutputTransformInput(
                original_input = dynamodb_input,
                sdk_output = sdk_output,
            )
        ).transformed_output
        response = transform_transformed_response_for_table_query_or_scan_response(sdk_output, transformed_response)
        # for sdk_output_key, sdk_output_value in sdk_output.items():
        #     if sdk_output_key not in transformed_response:
        #         response[sdk_output_key] = sdk_output_value
        # ddb_items = response["Items"]
        # dict_items = []
        # for ddb_item in ddb_items:
        #     dict_item = ddb_to_dict(ddb_item)
        #     dict_items.append(dict_item)
        # response["Items"] = dict_items
        # print(f"scan {response=}")
        return response
    
    def query(self, **kwargs):
        print(f"table query {kwargs=}")
        # QUery: no need to support AttributesTOGet,KeyConditions,QUeryFilter,ConditionalOperator

        # Transform table query request shape into client query request shape
        
        # Table PutItem requests differ from Client PutItem requests.
        # They do not have the table name, but DBESDK expects the TableName.
        # Insert the TableName for DBESDK.
        kwargs["TableName"] = self._table.table_name

        dynamodb_input = transform_query_or_scan_input_for_internal_transformer(**kwargs)

        # dynamodb_item = dict_to_ddb(kwargs["Key"])
        # dynamodb_input = kwargs
        # dynamodb_input["Key"] = dynamodb_item

        print(f"table query {dynamodb_input=}")

        transformed_request = self._transformer.query_input_transform(
            QueryInputTransformInput(
                sdk_input = dynamodb_input
            )
        ).transformed_input

        # boto3 Table expects dict...
        # dict_transformed_item = ddb_to_dict(transformed_request["Key"])
        # transformed_request["Key"] = dict_transformed_item
        # del transformed_request["TableName"]

        print(f"posttransform {transformed_request=}")

        transformed_request = transform_transformed_request_for_query_or_scan_on_table(transformed_request)

        # if "ExpressionAttributeValues" in transformed_request:
        #     for name, ddb_value in transformed_request["ExpressionAttributeValues"].items():
        #         dict_item = ddb_to_dict({name: ddb_value})
        #         transformed_request["ExpressionAttributeValues"][list(dict_item.keys())[0]] = list(dict_item.values())[0]
        

        print(f"final query {transformed_request=}")
        sdk_output = self._table.query(**transformed_request)
        print(f"{sdk_output=}")

        sdk_output = transform_sdk_output_from_query_or_scan_for_internal_transformer(sdk_output)

        # dict_item_from_sdk = sdk_output["Item"]
        # ddb_item = dict_to_ddb(dict_item_from_sdk)
        # sdk_output["Item"] = ddb_item
        
        transformed_response = self._transformer.query_output_transform(
            QueryOutputTransformInput(
                original_input = dynamodb_input,
                sdk_output = sdk_output,
            )
        ).transformed_output
        response = transform_transformed_response_for_table_query_or_scan_response(sdk_output, transformed_response)
        # for sdk_output_key, sdk_output_value in sdk_output.items():
        #     if sdk_output_key not in transformed_response:
        #         response[sdk_output_key] = sdk_output_value
        # ddb_items = response["Items"]
        # dict_items = []
        # for ddb_item in ddb_items:
        #     dict_item = ddb_to_dict(ddb_item)
        #     dict_items.append(dict_item)
        # response["Items"] = dict_items
        # print(f"query {response=}")
        return response

    # TODO: query, scan, BatchWriter
    # (maybe nobody uses BatchWriter... would save testing/testvectors work)
    # https://github.com/aws/aws-dynamodb-encryption-python/blob/master/src/dynamodb_encryption_sdk/encrypted/table.py