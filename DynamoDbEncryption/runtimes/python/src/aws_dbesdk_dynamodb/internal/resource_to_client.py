# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
from aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.boto3_conversions import (
    InternalBoto3DynamoDBFormatConverter,
)
from boto3.dynamodb.types import TypeSerializer
from boto3.dynamodb.conditions import ConditionExpressionBuilder


class ResourceShapeToClientShapeConverter:

    def __init__(self, table_name=None):
        self.boto3_converter = InternalBoto3DynamoDBFormatConverter(
            item_handler=TypeSerializer().serialize, condition_handler=self.condition_handler
        )
        # TableName is optional;
        # Some requests require it (ex. put_item, update_item, delete_item),
        # but others do not (ex. transact_get_items, batch_write_item).
        self.table_name = table_name
        self.expression_builder = ConditionExpressionBuilder()

    def condition_handler(self, expression_key, request):
        """
        Converts an object from boto3.dynamodb.conditions to a string
        and updates ExpressionAttributeNames and ExpressionAttributeValues with any new names/values.
        The ExpressionAttributeValues are returned in resource format (Python dictionaries).
        """
        condition_expression = request[expression_key]

        try:
            existing_expression_attribute_names = request["ExpressionAttributeNames"]
        except KeyError:
            existing_expression_attribute_names = {}
        try:
            existing_expression_attribute_values = request["ExpressionAttributeValues"]
        except KeyError:
            existing_expression_attribute_values = {}

        # Only convert if the condition expression is a boto3.dynamodb.conditions object.
        # Resources also accept strings.
        # If condition is not from boto3.dynamodb.conditions, assume the condition is string-like, and return as-is.
        if (
            hasattr(condition_expression, "__module__")
            and condition_expression.__module__ == "boto3.dynamodb.conditions"
        ):
            built_condition_expression = self.expression_builder.build_expression(
                condition_expression
            )
            return built_condition_expression.condition_expression, built_condition_expression.attribute_name_placeholders, built_condition_expression.attribute_value_placeholders
        else:
            return condition_expression, existing_expression_attribute_names, existing_expression_attribute_values

    def put_item_request(self, put_item_request):
        # put_item requests on a boto3.resource.Table require a configured table name.
        if not self.table_name:
            raise ValueError("Table name must be provided to ResourceShapeToClientShapeConverter to use put_item")
        put_item_request["TableName"] = self.table_name
        return self.boto3_converter.PutItemInput(put_item_request)

    def get_item_request(self, get_item_request):
        # get_item requests on a boto3.resource.Table require a configured table name.
        if not self.table_name:
            raise ValueError("Table name must be provided to ResourceShapeToClientShapeConverter to use get_item")
        get_item_request["TableName"] = self.table_name
        return self.boto3_converter.GetItemInput(get_item_request)

    def query_request(self, query_request):
        # query requests on a boto3.resource.Table require a configured table name.
        if not self.table_name:
            raise ValueError("Table name must be provided to ResourceShapeToClientShapeConverter to use query")
        query_request["TableName"] = self.table_name
        return self.boto3_converter.QueryInput(query_request)

    def scan_request(self, scan_request):
        # scan requests on a boto3.resource.Table require a configured table name.
        if not self.table_name:
            raise ValueError("Table name must be provided to ResourceShapeToClientShapeConverter to use scan")
        scan_request["TableName"] = self.table_name
        return self.boto3_converter.ScanInput(scan_request)

    def update_item_request(self, update_item_request):
        # update_item requests on a boto3.resource.Table require a configured table name.
        if not self.table_name:
            raise ValueError("Table name must be provided to ResourceShapeToClientShapeConverter to use update_item")
        update_item_request["TableName"] = self.table_name
        return self.boto3_converter.UpdateItemInput(update_item_request)

    def delete_item_request(self, delete_item_request):
        # delete_item requests on a boto3.resource.Table require a configured table name.
        if not self.table_name:
            raise ValueError("Table name must be provided to ResourceShapeToClientShapeConverter to use delete_item")
        delete_item_request["TableName"] = self.table_name
        return self.boto3_converter.DeleteItemInput(delete_item_request)

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

    def scan_response(self, scan_response):
        return self.boto3_converter.ScanOutput(scan_response)

    def query_response(self, query_response):
        return self.boto3_converter.QueryOutput(query_response)

    def get_item_response(self, get_item_response):
        return self.boto3_converter.GetItemOutput(get_item_response)

    def put_item_response(self, put_item_response):
        return self.boto3_converter.PutItemOutput(put_item_response)

    def update_item_response(self, update_item_response):
        return self.boto3_converter.UpdateItemOutput(update_item_response)

    def delete_item_response(self, delete_item_response):
        return self.boto3_converter.DeleteItemOutput(delete_item_response)
