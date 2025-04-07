from aws_database_encryption_sdk.transform import dict_to_ddb
from .boto3_conversions import BotoInterfaceShapeConverter
from aws_database_encryption_sdk.internal.condition_expression_builder import InternalDBESDKDynamoDBConditionExpressionBuilder
from boto3.dynamodb.conditions import BuiltConditionExpression
from boto3.dynamodb.types import TypeSerializer
from aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.boto3_conversions import InternalBoto3DynamoDBFormatConverter

class ResourceShapeToClientShapeConverter:

    def __init__(self, table_name = None):
        self.boto3_converter = InternalBoto3DynamoDBFormatConverter(
            item_handler=TypeSerializer().serialize,
            condition_handler=self._unpack_built_condition_expression2
        )
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
        attribute_values_from_built_expression = dict_to_ddb(built_condition_expression.attribute_value_placeholders)
        try:
            request_to_update["ExpressionAttributeValues"] = request_to_update["ExpressionAttributeValues"] | attribute_values_from_built_expression
        except KeyError:
            request_to_update["ExpressionAttributeValues"] = attribute_values_from_built_expression

    def _unpack_built_condition_expression2(self, expression_key, request):
        condition_expression = request[expression_key]
        try:
            existing_expression_attribute_names = request["ExpressionAttributeNames"]
        except KeyError:
            existing_expression_attribute_names = {}
        try:
            existing_expression_attribute_values = request["ExpressionAttributeValues"]
        except KeyError:
            existing_expression_attribute_values = {}

        if hasattr(condition_expression, "__module__") and condition_expression.__module__ == "boto3.dynamodb.conditions":
            built_condition_expression = self.expression_builder.build_expression(condition_expression, existing_expression_attribute_names, existing_expression_attribute_values)
        else:
            return condition_expression, existing_expression_attribute_names, existing_expression_attribute_values
        
        expression_str = built_condition_expression.condition_expression
        attribute_names_from_built_expression = built_condition_expression.attribute_name_placeholders
        # Join any placeholder ExpressionAttributeNames with any other ExpressionAttributeNames
        try:
            out_names = request["ExpressionAttributeNames"] | attribute_names_from_built_expression
        except KeyError:
            out_names = attribute_names_from_built_expression
        # BuiltConditionExpression stores values in resource format; convert to client format before joining
        attribute_values_from_built_expression = dict_to_ddb(built_condition_expression.attribute_value_placeholders)
        try:
            out_values = request["ExpressionAttributeValues"] | attribute_values_from_built_expression
        except KeyError:
            out_values = attribute_values_from_built_expression

        return expression_str, out_names, out_values

    def item(self, item):
        return dict_to_ddb(item)
    
    def key_to_attribute_value_map(self, key_to_attribute_value):
        return dict_to_ddb(key_to_attribute_value)
    
    def attribute_value(self, attribute_value):
        serializer = TypeSerializer()
        return serializer.serialize(attribute_value)

    # def put_item_request(self, put_item_request):
    #     if not self.table_name:
    #         raise ValueError("Table name must be provided to ResourceShapeToClientShapeConverter to use put_item")
    #     put_item_request["TableName"] = self.table_name
    #     super_conversion = super().put_item_request(put_item_request)
    #     if "ConditionExpression" in super_conversion and isinstance(super_conversion["ConditionExpression"], BuiltConditionExpression):
    #         self._unpack_built_condition_expression(super_conversion, "ConditionExpression")
    #     return super_conversion

    def put_item_request(self, put_item_request):
        if not self.table_name:
            raise ValueError("Table name must be provided to ResourceShapeToClientShapeConverter to use put_item")
        put_item_request["TableName"] = self.table_name
        return self.boto3_converter.PutItemInput(put_item_request)
        # if "ConditionExpression" in super_conversion and isinstance(super_conversion["ConditionExpression"], BuiltConditionExpression):
        #     self._unpack_built_condition_expression(super_conversion, "ConditionExpression")
    
    def get_item_request(self, get_item_request):
        if not self.table_name:
            raise ValueError("Table name must be provided to ResourceShapeToClientShapeConverter to use get_item")
        get_item_request["TableName"] = self.table_name
        # return super().get_item_request(get_item_request)
        return self.boto3_converter.GetItemInput(get_item_request)
    
    def query_request(self, query_request):
        if not self.table_name:
            raise ValueError("Table name must be provided to ResourceShapeToClientShapeConverter to use query")
        query_request["TableName"] = self.table_name
        # super_conversion = super().query_request(query_request)
        # if "KeyConditionExpression" in super_conversion and isinstance(super_conversion["KeyConditionExpression"], BuiltConditionExpression):
        #     self._unpack_built_condition_expression(super_conversion, "KeyConditionExpression")
        # if "FilterExpression" in super_conversion and isinstance(super_conversion["FilterExpression"], BuiltConditionExpression):
        #     self._unpack_built_condition_expression(super_conversion, "FilterExpression")
        # return super_conversion
        return self.boto3_converter.QueryInput(query_request)

    def scan_request(self, scan_request):
        if not self.table_name:
            raise ValueError("Table name must be provided to ResourceShapeToClientShapeConverter to use scan")
        scan_request["TableName"] = self.table_name
        # super_conversion = super().scan_request(scan_request)
        # if "FilterExpression" in super_conversion and isinstance(super_conversion["FilterExpression"], BuiltConditionExpression):
        #     self._unpack_built_condition_expression(super_conversion, "FilterExpression")
        # return super_conversion
        return self.boto3_converter.ScanInput(scan_request)
    
    def transact_get_items_request(self, transact_get_items_request):
        return self.boto3_converter.TransactGetItemsInput(transact_get_items_request)
    
    def transact_get_items_response(self, transact_get_items_response):
        return self.boto3_converter.TransactGetItemsOutput(transact_get_items_response)
    
    def transact_write_items_request(self, transact_write_items_request):
        return self.boto3_converter.TransactWriteItemsInput(transact_write_items_request)
    
    def transact_write_items_response(self, transact_write_items_response):
        return self.boto3_converter.TransactWriteItemsOutput(transact_write_items_response)
    
    def batch_get_item_request(self, batch_get_item_request):
        return self.boto3_converter.BatchGetItemInput(batch_get_item_request)
    
    def batch_get_item_response(self, batch_get_item_response):
        return self.boto3_converter.BatchGetItemOutput(batch_get_item_response)
    
    def batch_write_item_request(self, batch_write_item_request):
        return self.boto3_converter.BatchWriteItemInput(batch_write_item_request)
    
    def batch_write_item_response(self, batch_write_item_response):
        return self.boto3_converter.BatchWriteItemOutput(batch_write_item_response)
    
    def scan_response(self, scan_response):
        return self.boto3_converter.ScanOutput(scan_response)
    
    def query_response(self, query_response):
        return self.boto3_converter.QueryOutput(query_response)
    
    def get_item_response(self, get_item_response):
        return self.boto3_converter.GetItemOutput(get_item_response)
    
    def put_item_response(self, put_item_response):
        return self.boto3_converter.PutItemOutput(put_item_response)
    
    
    
    
    # def expression(self, condition_expression, expression_attribute_names, expression_attribute_values):
    #     # Expressions provided to tables can be Condition objects, which need to be converted to strings.
    #     if hasattr(condition_expression, "__module__") and condition_expression.__module__ == "boto3.dynamodb.conditions":
    #         out = self.expression_builder.build_expression(condition_expression, expression_attribute_names, expression_attribute_values)
    #         return out
    #     # Expressions provided to tables can also already be string-like.
    #     # Assume the user has provided something string-like, and let Smithy-Python/DBESDK internals raise exceptions if not.
    #     print(f"probably a string: {condition_expression=}")
    #     return condition_expression

    # def batch_write_item_request_items(self, tables):
    #     """Transform a batch write request's items to DynamoDB format."""
    #     output_tables = {}
    #     table_names = list(tables.keys())
    #     for table_name in table_names:
    #         requests = tables[table_name]
    #         output_requests = []
    #         for request in requests:
    #             request_name_list = list(request.keys())
    #             if len(request_name_list) > 1:
    #                 raise ValueError("Invalid JSON format")
    #             request_name = request_name_list[0]
    #             if request_name == "PutRequest":
    #                 dict_request = dict_to_ddb(request[request_name]["Item"])
    #                 boto3_request = {"Item": dict_request}
    #             elif request_name == "DeleteRequest":
    #                 # Delete requests are based on Keys, which are expected to already be in DynamoDB JSON.
    #                 # Only Items can be in Python dictionary JSON.
    #                 boto3_request = request[request_name]
    #             else:
    #                 raise ValueError(f"Unknown batch_write_items method key: {request_name}")
    #             output_requests.append({request_name: boto3_request})
    #         output_tables[table_name] = output_requests
    #     return output_tables

    # def batch_get_request(self, **kwargs):
    #     """Transform a batch get request to DynamoDB format."""
    #     dynamodb_input = kwargs.copy()
    #     tables = dynamodb_input["RequestItems"]
        
    #     for table_name, table_data in tables.items():
    #         dynamodb_input["RequestItems"][table_name]["Keys"] = [
    #             self.key_to_attribute_value_map(key) for key in table_data["Keys"]
    #         ]
            
    #     return dynamodb_input