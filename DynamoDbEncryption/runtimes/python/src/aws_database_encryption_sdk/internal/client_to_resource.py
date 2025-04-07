from aws_database_encryption_sdk.transform import ddb_to_dict
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
        try:
            identity_names =  request["ExpressionAttributeNames"]
        except KeyError:
            identity_names = {}

        try:
            identity_values = request["ExpressionAttributeValues"]
        except KeyError:
            identity_values = {}
        return request[expression_key], identity_names, identity_values

    def put_item_request(self, put_item_request):
        # out = super().put_item_request(put_item_request)
        out = self.boto3_converter.PutItemInput(put_item_request)
        if self.delete_table_name:
            del out["TableName"]
        return out
    
    def get_item_request(self, get_item_request):
        # out = super().get_item_request(get_item_request)
        out = self.boto3_converter.GetItemInput(get_item_request)
        if self.delete_table_name:
            del out["TableName"]
        return out
    
    def query_request(self, query_request):
        # out = super().query_request(query_request)
        out = self.boto3_converter.QueryInput(query_request)
        if self.delete_table_name:
            del out["TableName"]
        return out

    def scan_request(self, scan_request):
        # out = super().scan_request(scan_request)
        out = self.boto3_converter.ScanInput(scan_request)
        if self.delete_table_name:
            del out["TableName"]
        return out

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
    
    