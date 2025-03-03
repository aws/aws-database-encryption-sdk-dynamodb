from aws_database_encryption_sdk.transform import dict_to_ddb
from .boto3_conversions import BotoInterfaceShapeConverter
from aws_database_encryption_sdk.internal.condition_expression_builder import InternalDBESDKDynamoDBConditionExpressionBuilder
from boto3.dynamodb.conditions import BuiltConditionExpression
from boto3.dynamodb.types import TypeSerializer

class ResourceShapeToClientShapeConverter(BotoInterfaceShapeConverter):

    def __init__(self, table_name = None):
        self.table_name = table_name
        self.expression_builder = InternalDBESDKDynamoDBConditionExpressionBuilder()

    def _unpack_built_condition_expression(self, request_to_update, expression_key):
        built_condition_expression = request_to_update[expression_key]
        request_to_update[expression_key] = built_condition_expression.condition_expression
        attribute_names_from_built_expression = built_condition_expression.attribute_name_placeholders
        # Join any placeholder ExpressionAttributeNames with any other ExpressionAttributeNames
        try:
            request_to_update["ExpressionAttributeNames"] = request_to_update["ExpressionAttributeNames"] | attribute_names_from_built_expression
        except KeyError:
            request_to_update["ExpressionAttributeNames"] = attribute_names_from_built_expression
        # BuiltConditionExpression stores values in resource format; convert to client format before joining
        attribute_values_from_built_expression = super().expression_attribute_values(
            built_condition_expression.attribute_value_placeholders
        )
        try:
            request_to_update["ExpressionAttributeValues"] = request_to_update["ExpressionAttributeValues"] | attribute_values_from_built_expression
        except KeyError:
            request_to_update["ExpressionAttributeValues"] = attribute_values_from_built_expression

    def item(self, item):
        return dict_to_ddb(item)
    
    def key_to_attribute_value_map(self, key_to_attribute_value):
        return dict_to_ddb(key_to_attribute_value)
    
    def attribute_value(self, attribute_value):
        serializer = TypeSerializer()
        return serializer.serialize(attribute_value)

    def put_item_request(self, put_item_request):
        if not self.table_name:
            raise ValueError("Table name must be provided to ResourceShapeToClientShapeConverter to use put_item")
        put_item_request["TableName"] = self.table_name
        super_conversion = super().put_item_request(put_item_request)
        if "ConditionExpression" in super_conversion and isinstance(super_conversion["ConditionExpression"], BuiltConditionExpression):
            self._unpack_built_condition_expression(super_conversion, "ConditionExpression")
        return super_conversion
    
    def get_item_request(self, get_item_request):
        if not self.table_name:
            raise ValueError("Table name must be provided to ResourceShapeToClientShapeConverter to use get_item")
        get_item_request["TableName"] = self.table_name
        return super().get_item_request(get_item_request)
    
    def query_request(self, query_request):
        if not self.table_name:
            raise ValueError("Table name must be provided to ResourceShapeToClientShapeConverter to use query")
        query_request["TableName"] = self.table_name
        super_conversion = super().query_request(query_request)
        if "KeyConditionExpression" in super_conversion and isinstance(super_conversion["KeyConditionExpression"], BuiltConditionExpression):
            self._unpack_built_condition_expression(super_conversion, "KeyConditionExpression")
        if "FilterExpression" in super_conversion and isinstance(super_conversion["FilterExpression"], BuiltConditionExpression):
            self._unpack_built_condition_expression(super_conversion, "FilterExpression")
        return super_conversion

    def scan_request(self, scan_request):
        if not self.table_name:
            raise ValueError("Table name must be provided to ResourceShapeToClientShapeConverter to use scan")
        scan_request["TableName"] = self.table_name
        super_conversion = super().scan_request(scan_request)
        if "FilterExpression" in super_conversion and isinstance(super_conversion["FilterExpression"], BuiltConditionExpression):
            self._unpack_built_condition_expression(super_conversion, "FilterExpression")
        return super_conversion
    
    def expression(self, condition_expression, expression_attribute_names, expression_attribute_values):
        # Expressions provided to tables can be Condition objects, which need to be converted to strings.
        if hasattr(condition_expression, "__module__") and condition_expression.__module__ == "boto3.dynamodb.conditions":
            out = self.expression_builder.build_expression(condition_expression, expression_attribute_names, expression_attribute_values)
            return out
        # Expressions provided to tables can also already be string-like.
        # Assume the user has provided something string-like, and let Smithy-Python/DBESDK internals raise exceptions if not.
        print(f"probably a string: {condition_expression=}")
        return condition_expression