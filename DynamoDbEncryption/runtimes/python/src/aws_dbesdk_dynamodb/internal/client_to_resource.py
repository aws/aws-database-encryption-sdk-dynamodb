# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
from aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.boto3_conversions import (
    InternalBoto3DynamoDBFormatConverter,
)
from boto3.dynamodb.types import TypeDeserializer


class ClientShapeToResourceShapeConverter:

    def __init__(self, delete_table_name=True):
        # Some callers expect the TableName kwarg to be removed from the outputs of this class.
        # (EncryptedResource, EncryptedTable.)
        # These callers' boto3 shapes do not include TableName.
        # Other callers expect the TableName kwarg to be included in the outputs of this class.
        # (EncryptedClient, EncryptedPaginator.)
        # These callers' boto3 shapes include TableName.
        self.delete_table_name = delete_table_name
        self.boto3_converter = InternalBoto3DynamoDBFormatConverter(
            item_handler=TypeDeserializer().deserialize, condition_handler=self.condition_handler
        )

    def condition_handler(self, expression_key, request):
        """Returns the input condition/names/values as-is."""
        # Conditions do not need to be converted from strings to boto3 Attrs.
        # Resources accept either strings or Attrs.
        # Return the provided condition string.
        condition = request[expression_key]

        # This conversion in client_to_resource does not update ExpressionAttributeNames or ExpressionAttributeValues.
        # However, resource_to_client condition_handler may add new ExpressionAttributeNames and
        # ExpressionAttributeValues.
        # Smithy-generated code expects condition_handlers to return ExpressionAttributeNames and
        # ExpressionAttributeValues,
        # expecting empty dicts if there are none.
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
        # put_item requests on resources do not have a table name.
        if self.delete_table_name:
            del out["TableName"]
        return out

    def put_item_response(self, put_item_response):
        return self.boto3_converter.PutItemOutput(put_item_response)

    def get_item_request(self, get_item_request):
        out = self.boto3_converter.GetItemInput(get_item_request)
        # get_item requests on resources do not have a table name.
        if self.delete_table_name:
            del out["TableName"]
        return out

    def get_item_response(self, get_item_response):
        return self.boto3_converter.GetItemOutput(get_item_response)

    def query_request(self, query_request):
        out = self.boto3_converter.QueryInput(query_request)
        # query requests on resources do not have a table name.
        if self.delete_table_name:
            del out["TableName"]
        return out

    def query_response(self, query_response):
        return self.boto3_converter.QueryOutput(query_response)

    def scan_request(self, scan_request):
        out = self.boto3_converter.ScanInput(scan_request)
        # scan requests on resources do not have a table name.
        if self.delete_table_name:
            del out["TableName"]
        return out

    def scan_response(self, scan_response):
        return self.boto3_converter.ScanOutput(scan_response)

    def delete_item_request(self, delete_item_request):
        out = self.boto3_converter.DeleteItemInput(delete_item_request)
        # delete_item requests on resources do not have a table name.
        if self.delete_table_name:
            del out["TableName"]
        return out

    def delete_item_response(self, delete_item_response):
        return self.boto3_converter.DeleteItemOutput(delete_item_response)

    def update_item_request(self, update_item_request):
        out = self.boto3_converter.UpdateItemInput(update_item_request)
        # update_item requests on resources do not have a table name.
        if self.delete_table_name:
            del out["TableName"]
        return out

    def update_item_response(self, update_item_response):
        return self.boto3_converter.UpdateItemOutput(update_item_response)

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

    def batch_execute_statement_request(self, batch_execute_statement_request):
        return self.boto3_converter.BatchExecuteStatementInput(batch_execute_statement_request)

    def batch_execute_statement_response(self, batch_execute_statement_response):
        return self.boto3_converter.BatchExecuteStatementOutput(batch_execute_statement_response)

    def execute_statement_request(self, execute_statement_request):
        return self.boto3_converter.ExecuteStatementInput(execute_statement_request)

    def execute_statement_response(self, execute_statement_response):
        return self.boto3_converter.ExecuteStatementOutput(execute_statement_response)

    def execute_transaction_request(self, execute_transaction_request):
        return self.boto3_converter.ExecuteTransactionInput(execute_transaction_request)

    def execute_transaction_response(self, execute_transaction_response):
        return self.boto3_converter.ExecuteTransactionOutput(execute_transaction_response)
