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

from boto3.dynamodb.conditions import (
    Key,
    Equals,
    NotEquals,
    LessThan,
    LessThanEquals,
    GreaterThan,
    GreaterThanEquals,
    In,
    Between,
    BeginsWith,
    And,
    Or,
    Contains,
)
from boto3.dynamodb.types import TypeSerializer

from boto3.dynamodb.conditions import Key, Attr
from boto3.dynamodb.types import TypeSerializer

from boto3.dynamodb.conditions import Equals, LessThan, GreaterThan, BeginsWith, Between
from boto3.dynamodb.types import TypeSerializer

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
    
    # substitution_map = {}
    # tokenized_original_string = untransformed_request["KeyConditionExpression"].split(" ")
    # tokenized_transformed_string = untransformed_request["KeyConditionExpression"].split(" ")
    # assert len(tokenized_original_string) == len(tokenized_transformed_string)
    # for i in range(len(tokenized_original_string)):
    #     original = tokenized_original_string[i]
    #     transformed = tokenized_original_string[i]
    #     if original != transformed:
    #         substitution_map[original] = transformed
    
    
    
    
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

def is_number(obj):
    return isinstance(obj, (int, float, Decimal))

def convert_conditions_to_client_expression(condition, expression_attribute_names, expression_attribute_values):
    """
    Converts a Key/Attr condition into a client-compatible DynamoDB expression.

    :param condition: A boto3.dynamodb.conditions object (Key or Attr).
    :return: A tuple containing:
             - expression string
             - ExpressionAttributeValues dictionary
             - ExpressionAttributeNames dictionary
    """

    # from boto3.dynamodb.conditions import ConditionExpressionBuilder
    from aws_database_encryption_sdk.internal.condition_expression_builder import InternalDBESDKDynamoDBConditionExpressionBuilder
    
    a = InternalDBESDKDynamoDBConditionExpressionBuilder()
    out = a.build_expression(condition, expression_attribute_names, expression_attribute_values)
    print(f'our {out=}')
    return out

    def _recurse(condition, expression_attribute_names, expression_attribute_values):
        expression = condition.get_expression()
        expression_format = expression["format"]
        expression_operator = expression["operator"]
        expression_values = expression["values"]
        processed_expression_values = []

        for elem in expression_values:
            if isinstance(elem, Key) or isinstance(elem, Attr):
                attribute_name = elem.name
                # if attribute_name in expression_attribute_names:
                #     placeholder_name = expression_attribute_names[attribute_name]
                # else:
                # placeholder_name = "#pln" + str(len(expression_attribute_names))
                # expression_attribute_names[placeholder_name] = attribute_name
                elem = attribute_name
            elif isinstance(elem, Equals) or isinstance(elem, And) or isinstance(elem, Or) or isinstance(elem, Between) or isinstance(elem, BeginsWith) or isinstance(elem, GreaterThanEquals) or isinstance(elem, NotEquals) or isinstance(elem, Contains):
                elem, expression_attribute_names, expression_attribute_values = _recurse(elem, expression_attribute_names, expression_attribute_values)
            elif isinstance(elem, str) or is_number(elem):
                # assume it's a value...
                attribute_value = elem
                # # if attribute_value in expression_attribute_values:
                # #     placeholder_value = expression_attribute_values[attribute_value]
                # # else:
                # placeholder_value = ":plv" + str(len(expression_attribute_values))
                # expression_attribute_values[placeholder_value] = attribute_value
                elem = attribute_value
            elif isinstance(elem, list):
                s = "("
                for list_elem in elem:
                    s += str(list_elem)
                s += ")"
                elem = s
            else:
                print(f"unknown {elem=}")
                print(f"unknown {elem.__dict__=}")
                print(f"unknown {dir(elem)=}")
                raise ValueError(f"{elem=}")
            processed_expression_values.append(elem)
        output = expression_format.format(*processed_expression_values, operator = expression_operator)
        return (output, expression_attribute_names, expression_attribute_values)

    condition_expression, expression_attribute_names, expression_attribute_values = _recurse(condition, expression_attribute_names, expression_attribute_values)
    print(f"{(condition_expression, expression_attribute_names, expression_attribute_values)=}")
    # expression_attribute_names = {v: k for k, v in swapped_expression_attribute_names.items() if }
    # expression_attribute_values = {v: k for k, v in swapped_expression_attribute_values.items()}
    return (condition_expression, expression_attribute_names, expression_attribute_values)
    

    def process_condition(condition):
        nonlocal expression, expression_attribute_values, expression_attribute_names

        if isinstance(condition, Equals):
            attr_name = f"#{condition.attr_name}"
            placeholder = f":val_{len(expression_attribute_values)}"
            expression_attribute_names[attr_name] = condition.attr_name
            expression_attribute_values[placeholder] = serializer.serialize(condition.values[0])
            return f"{attr_name} = {placeholder}"
        elif isinstance(condition, LessThan):
            attr_name = f"#{condition.attr_name}"
            placeholder = f":val_{len(expression_attribute_values)}"
            expression_attribute_names[attr_name] = condition.attr_name
            expression_attribute_values[placeholder] = serializer.serialize(condition.values[0])
            return f"{attr_name} < {placeholder}"
        elif isinstance(condition, GreaterThan):
            attr_name = f"#{condition.attr_name}"
            placeholder = f":val_{len(expression_attribute_values)}"
            expression_attribute_names[attr_name] = condition.attr_name
            expression_attribute_values[placeholder] = serializer.serialize(condition.values[0])
            return f"{attr_name} > {placeholder}"
        elif isinstance(condition, BeginsWith):
            attr_name = f"#{condition.attr_name}"
            placeholder = f":val_{len(expression_attribute_values)}"
            expression_attribute_names[attr_name] = condition.attr_name
            expression_attribute_values[placeholder] = serializer.serialize(condition.values[0])
            return f"begins_with({attr_name}, {placeholder})"
        elif isinstance(condition, Between):
            attr_name = f"#{condition.attr_name}"
            placeholder1 = f":val_{len(expression_attribute_values)}"
            placeholder2 = f":val_{len(expression_attribute_values) + 1}"
            expression_attribute_names[attr_name] = condition.attr_name
            expression_attribute_values[placeholder1] = serializer.serialize(condition.values[0])
            expression_attribute_values[placeholder2] = serializer.serialize(condition.values[1])
            return f"{attr_name} BETWEEN {placeholder1} AND {placeholder2}"
        else:
            raise ValueError(f"Unsupported condition type: {type(condition).__name__}")

    expression = process_condition(condition)

    return expression, expression_attribute_values, expression_attribute_names
# from boto3.dynamodb.conditions import Key, Attr
# from boto3.dynamodb.types import TypeDeserializer

# def convert_client_expression_to_conditions(expression, expression_values, expression_names=None):
#     """
#     Converts DynamoDB client-compatible expressions into Key or Attr conditions.
    
#     :param expression: A string of the DynamoDB client expression (e.g., "RecNum = :zero").
#     :param expression_values: A dictionary of attribute values (e.g., {":zero": {"N": "0"}}).
#     :param expression_names: A dictionary of attribute names, if placeholders are used (e.g., {"#attr": "RecNum"}).
#     :return: A boto3.dynamodb.conditions object (Key or Attr).
#     """
#     # Split the expression into attribute and value
#     tokens = expression.split()
#     # if len(tokens) != 3:
#     #     raise ValueError("Only simple expressions (e.g., 'AttrName = :val') are supported.")

#     attr_name = tokens[0]  # The attribute name or placeholder
#     operator = tokens[1].upper()   # The operator (e.g., '=', '<', '>', "BETWEEN")
#     attr_value_placeholder = tokens[2]  # The value placeholder (e.g., ":zero")

#     # Map operator to Key or Attr
#     if operator == "=":
#         return Key(attr_name).eq(attr_value_placeholder)
#     elif operator == "<":
#         return Key(attr_name).lt(attr_value_placeholder)
#     elif operator == "<=":
#         return Key(attr_name).lte(attr_value_placeholder)
#     elif operator == ">":
#         return Key(attr_name).gt(attr_value_placeholder)
#     elif operator == ">=":
#         return Key(attr_name).gte(attr_value_placeholder)
#     elif operator == "begins_with":
#         return Key(attr_name).begins_with(attr_value_placeholder)
#     elif operator == "BETWEEN":
#         raise NotImplementedError("BETWEEN is not currently supported by this function.")
#     else:
#         # If no Key match, assume Attr condition
#         if operator == "!=" or operator == "<>":
#             return Attr(attr_name).ne(attr_value_placeholder)
#         elif operator == "contains":
#             return Attr(attr_name).contains(attr_value_placeholder)
#         else:
#             raise ValueError(f"Unsupported operator: {operator}")

from boto3.dynamodb.conditions import Key, Attr, And, Or, Not
from boto3.dynamodb.types import TypeDeserializer


def convert_client_expression_to_conditions(expression):
    """
    Crypto Tools internal method to convert a DynamoDB filter/key expression to boto3 Resource tokens.
    DO NOT USE FOR ANY OTHER PURPOSE.
    This is a basic implementation for simple expressions that will fail with complex expressions.
    
    To extend this to support one or a few complex expressions, consider extending the existing logic.
    To extend this to support all expressions, consider implementing and extending the code below:

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

    This library's generated internal Dafny code has a DynamoDB string parser.
    This will parse a _dafny.Seq and produce Dafny tokens for the expression.
    Implementing this will involve
        1. Mapping Dafny tokens to boto3 Resource tokens.
            (e.g. class Token_Between -> boto3.dynamodb.conditions.Between)
        2. Converting Dafny token grammar to boto3 Resource token grammar.
            (e.g.
                Dafny: [Token_Between, Token_Open, Token_Attr, Token_And, Token_Attr, Token_Close]
                ->
                boto3: [Between(Attr, Attr)]
            )
    
    :param expression: A string of the DynamoDB client expression (e.g., "AttrName = :val").
    :param expression_values: A dictionary of attribute values (e.g., {":val": {"N": "0"}}).
    :param expression_names: A dictionary of attribute names, if placeholders are used (e.g., {"#attr": "AttrName"}).
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