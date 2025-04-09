from aws_dbesdk_dynamodb.transform import ddb_to_dict
from .boto3_conversions import BotoInterfaceShapeConverter
from aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.boto3_conversions import InternalBoto3DynamoDBFormatConverter
from boto3.dynamodb.types import TypeDeserializer

class ClientShapeToResourceShapeConverter:

    def __init__(self, delete_table_name = True):
        self.delete_table_name = delete_table_name
        self.boto3_converter = InternalBoto3DynamoDBFormatConverter(
            item_handler=TypeDeserializer().deserialize,
            condition_handler=self.condition_handler
        )

    def condition_handler(self, expression_key, request):
        """Returns the input condition/names/values as-is."""
        # Conditions do not need to be converted from strings to boto3 Attrs.
        # Resources accept either strings or Attrs.
        condition = request[expression_key]

        # This conversion in client_to_resource does not update ExpressionAttributeNames nor ExpressionAttributeValues.
        # However, resource_to_client condition_handler may add new ExpressionAttributeNames and ExpressionAttributeValues.
        # Smithy-generated code expects condition_handlers to return ExpressionAttributeNames and ExpressionAttributeValues.
        try:
            names = request["ExpressionAttributeNames"]
        except KeyError:
            names = {}

        try:
            values = request["ExpressionAttributeValues"]
        except KeyError:
            values = {}
        return condition, names, values

    def put_item_request(self, put_item_request):
        out = self.boto3_converter.PutItemInput(put_item_request)
        # put_item requests on a boto3.resource.Table do not have a table name.
        if self.delete_table_name:
            del out["TableName"]
        return out
    
    def put_item_response(self, put_item_response):
        return self.boto3_converter.PutItemOutput(put_item_response)
    
    def get_item_request(self, get_item_request):
        out = self.boto3_converter.GetItemInput(get_item_request)
        # get_item requests on a boto3.resource.Table do not have a table name.
        if self.delete_table_name:
            del out["TableName"]
        return out
    
    def get_item_response(self, get_item_response):
        return self.boto3_converter.GetItemOutput(get_item_response)
    
    def query_request(self, query_request):
        out = self.boto3_converter.QueryInput(query_request)
        # query requests on a boto3.resource.Table do not have a table name.
        if self.delete_table_name:
            del out["TableName"]
        return out
    
    def query_response(self, query_response):
        return self.boto3_converter.QueryOutput(query_response)

    def scan_request(self, scan_request):
        out = self.boto3_converter.ScanInput(scan_request)
        # scan requests on a boto3.resource.Table do not have a table name.
        if self.delete_table_name:
            del out["TableName"]
        return out
    
    def scan_response(self, scan_response):
        return self.boto3_converter.ScanOutput(scan_response)

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
    