from aws_database_encryption_sdk.transform import ddb_to_dict
from .boto3_conversions import BotoInterfaceShapeConverter

class ClientShapeToResourceShapeConverter(BotoInterfaceShapeConverter):

    def __init__(self, delete_table_name = True):
        self.delete_table_name = delete_table_name

    def item(self, item):
        return ddb_to_dict(item)
    
    def attribute_value(self, attribute_value):
        # TODO: optimize
        return list(ddb_to_dict({"throwaway_key": attribute_value}).values())[0]

    def put_item_request(self, put_item_request):
        out = super().put_item_request(put_item_request)
        if self.delete_table_name:
            del out["TableName"]
        return out
    
    def get_item_request(self, get_item_request):
        out = super().get_item_request(get_item_request)
        if self.delete_table_name:
            del out["TableName"]
        return out
    
    def query_request(self, query_request):
        out = super().query_request(query_request)
        if self.delete_table_name:
            del out["TableName"]
        return out

    def scan_request(self, scan_request):
        out = super().scan_request(scan_request)
        if self.delete_table_name:
            del out["TableName"]
        return out

    def expression(self, condition_expression, expression_attribute_names, expression_attribute_values):
        # Tables accept the same format as the client (string).
        return condition_expression
