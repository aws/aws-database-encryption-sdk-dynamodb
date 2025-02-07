from aws_database_encryption_sdk.transform import ddb_to_dict
from .boto3_conversions import BotoInterfaceShapeConverter

class ClientShapeToResourceShapeConverter(BotoInterfaceShapeConverter):

    def item(self, item):
        return ddb_to_dict(item)
    
    def attribute_value(self, attribute_value):
        # TODO: optimize
        return list(ddb_to_dict({"throwaway_key": attribute_value}).values())[0]

    def put_item_request(self, put_item_request):
        del put_item_request["TableName"]
        return super().put_item_request(put_item_request)
    
    def get_item_request(self, get_item_request):
        del get_item_request["TableName"]
        return super().get_item_request(get_item_request)
    
    def query_request(self, query_request):
        del query_request["TableName"]
        return super().query_request(query_request)

    def scan_request(self, scan_request):
        del scan_request["TableName"]
        return super().scan_request(scan_request)

    def expression(self, condition_expression):
        # Tables accept the same format as the client (string).
        return condition_expression
