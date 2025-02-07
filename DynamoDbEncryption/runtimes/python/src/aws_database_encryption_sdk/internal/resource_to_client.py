from aws_database_encryption_sdk.transform import dict_to_ddb
from .boto3_conversions import BotoInterfaceShapeConverter
from aws_database_encryption_sdk.internal.condition_expression_builder import InternalDBESDKDynamoDBConditionExpressionBuilder
from boto3.dynamodb.conditions import ConditionBase

class ResourceShapeToClientShapeConverter(BotoInterfaceShapeConverter):

    def __init__(self, table_name = None):
        self.table_name = table_name
        self.expression_builder = InternalDBESDKDynamoDBConditionExpressionBuilder()

    def item(self, item):
        return dict_to_ddb(item)
    
    def key_to_attribute_value_map(self, key_to_attribute_value):
        return dict_to_ddb(key_to_attribute_value)
    
    def attribute_value(self, attribute_value):
        # TODO: optimize
        return list(dict_to_ddb({"throwaway_key": attribute_value}).values())[0]

    def put_item_request(self, put_item_request):
        if not self.table_name:
            raise ValueError("Table name must be provided to ResourceShapeToClientShapeConverter to use put_item")
        put_item_request["TableName"] = self.table_name
        return super().put_item_request(put_item_request)
    
    def get_item_request(self, get_item_request):
        if not self.table_name:
            raise ValueError("Table name must be provided to ResourceShapeToClientShapeConverter to use get_item")
        get_item_request["TableName"] = self.table_name
        return super().get_item_request(get_item_request)
    
    def query_request(self, query_request):
        if not self.table_name:
            raise ValueError("Table name must be provided to ResourceShapeToClientShapeConverter to use query")
        query_request["TableName"] = self.table_name
        return super().query_request(query_request)

    def scan_request(self, scan_request):
        if not self.table_name:
            raise ValueError("Table name must be provided to ResourceShapeToClientShapeConverter to use scan")
        scan_request["TableName"] = self.table_name
        return super().scan_request(scan_request)
    
    def expression(self, condition_expression):
        # Expressions provided to tables can be Condition objects, which need to be converted to strings.
        if isinstance(condition_expression, ConditionBase):
            return self.expression_builder.build_expression(condition_expression, "placeholder", "placeholder")
        # Expressions provided to tables can also already be string-like.
        # Assume the user has provided something string-like, and let Smithy-Python/DBESDK internals raise exceptions if not.
        return condition_expression