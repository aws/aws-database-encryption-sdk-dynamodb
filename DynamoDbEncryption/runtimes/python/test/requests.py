"""Request constants for DynamoDB operations."""

from boto3.dynamodb.conditions import Attr, Key

from .constants import INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME

# Base request structures that are shared between DDB and dict formats


def base_put_item_request(item):
    """Base structure for put_item requests."""
    return {"Item": item}


def base_get_item_request(item):
    """Base structure for get_item requests."""
    return {"Key": {"partition_key": item["partition_key"], "sort_key": item["sort_key"]}}


def base_delete_item_request(item):
    """Base structure for delete_item requests."""
    return {"Key": {"partition_key": item["partition_key"], "sort_key": item["sort_key"]}}


def base_query_request(item):
    """Base structure for query requests."""
    return {
        "KeyConditionExpression": "partition_key = :pk",
        "ExpressionAttributeValues": {":pk": item["partition_key"]},
    }


def base_scan_request(item):
    """Base structure for scan requests."""
    return {
        "FilterExpression": "attribute2 = :a2",
        "ExpressionAttributeValues": {":a2": item["attribute2"]},
    }


def base_batch_write_item_request(actions_with_items):
    """Base structure for batch_write_item requests."""
    return {"RequestItems": {INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME: actions_with_items}}


def base_batch_get_item_request(keys):
    """Base structure for batch_get_item requests."""
    return {"RequestItems": {INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME: {"Keys": keys}}}


def base_transact_write_item_request(actions_with_items):
    """Base structure for transact_write_item requests."""
    return {"TransactItems": actions_with_items}


def base_transact_get_item_request(keys):
    """Base structure for transact_get_item requests."""
    return {
        "TransactItems": [{"Get": {"TableName": INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME, "Key": key}} for key in keys]
    }


def base_update_item_request(item):
    """Base structure for update_item requests."""
    return {
        "Key": {"partition_key": item["partition_key"], "sort_key": item["sort_key"]},
        "UpdateExpression": "SET attribute1 = :val",
        "ExpressionAttributeValues": {":val": item["attribute1"]},
    }


def base_execute_statement_request():
    """Base structure for execute_statement requests."""
    return {"Statement": "SELECT * FROM " + INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME}


def base_execute_transaction_request():
    """Base structure for execute_transaction requests."""
    return {"TransactStatements": [{"Statement": "SELECT * FROM " + INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME}]}


def base_batch_execute_statement_request():
    """Base structure for batch_execute_statement requests."""
    return {"Statements": [{"Statement": "SELECT * FROM " + INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME}]}


# Base exhaustive request structures that are shared between DDB and dict formats

# No exhaustive requests are intended to be able to be used as real requests.
# Some parameters conflict with each other when sent to DynamoDB.
# These are only intended to test the conversion of the request from client to resource format.


def base_exhaustive_put_item_request(item):
    """
    Base structure for exhaustive put_item requests.
    This is not intended to be able to be used as a real request.
    Some parameters conflict with each other when sent to DynamoDB.
    This is only intended to test the conversion of the request from client to resource format.
    """
    return {
        # Expected is legacy, but still in the boto3 docs.
        "Expected": {
            "partition_key": {
                "Value": item["partition_key"],
            },
            "sort_key": {"AttributeValueList": [item["sort_key"]], "ComparisonOperator": "EQ"},
        },
        "ExpressionAttributeNames": {"#pk": "partition_key", "#sk": "sort_key"},
        "ExpressionAttributeValues": {":pk": item["partition_key"], ":sk": item["sort_key"]},
        "ReturnConsumedCapacity": "TOTAL",
        "ReturnItemCollectionMetrics": "SIZE",
        "ReturnValues": "ALL_OLD",
        "ReturnValuesOnConditionCheckFailure": "ALL_OLD",
    }


def base_exhaustive_get_item_request(item):
    """
    Base structure for exhaustive get_item requests.
    This is not intended to be able to be used as a real request.
    Some parameters conflict with each other when sent to DynamoDB.
    This is only intended to test the conversion of the request from client to resource format.
    """
    return {
        "ReturnConsumedCapacity": "TOTAL",
        "ReturnItemCollectionMetrics": "SIZE",
        "ProjectionExpression": "partition_key, sort_key, attribute1, attribute2",
        "ExpressionAttributeNames": {
            "#pk": "partition_key",
            "#sk": "sort_key",
            "#a1": "attribute1",
            "#a2": "attribute2",
        },
        "ConsistentRead": True,
        "AttributesToGet": ["partition_key", "sort_key", "attribute1", "attribute2"],
    }


def base_exhaustive_delete_item_request(item):
    """
    Base structure for exhaustive delete_item requests.
    This is not intended to be able to be used as a real request.
    Some parameters conflict with each other when sent to DynamoDB.
    This is only intended to test the conversion of the request from client to resource format.
    """
    return {
        "ReturnConsumedCapacity": "TOTAL",
        "ReturnItemCollectionMetrics": "SIZE",
        "ReturnValues": "ALL_OLD",
        "ReturnValuesOnConditionCheckFailure": "ALL_OLD",
    }


def base_exhaustive_query_request(item):
    """
    Base structure for exhaustive query requests.
    This is not intended to be able to be used as a real request.
    Some parameters conflict with each other when sent to DynamoDB.
    This is only intended to test the conversion of the request from client to resource format.
    """
    return {
        "IndexName": "index_name",
        "Select": "SPECIFIC_ATTRIBUTES",
        "AttributesToGet": ["partition_key", "sort_key", "attribute1", "attribute2"],
        "KeyConditions": {"partition_key": {"AttributeValueList": [item["partition_key"]], "ComparisonOperator": "EQ"}},
        "QueryFilter": {"attribute1": {"AttributeValueList": [item["attribute1"]], "ComparisonOperator": "EQ"}},
        "ConditionalOperator": "AND",
        "ScanIndexForward": True,
        "ExclusiveStartKey": {"partition_key": item["partition_key"], "sort_key": item["sort_key"]},
        "ReturnConsumedCapacity": "TOTAL",
        "ProjectionExpression": "partition_key, sort_key, attribute1, attribute2",
        "FilterExpression": "attribute1 = :a1",
        "ExpressionAttributeNames": {
            "#pk": "partition_key",
            "#sk": "sort_key",
            "#a1": "attribute1",
            "#a2": "attribute2",
        },
        "ExpressionAttributeValues": {":pk": item["partition_key"], ":a1": item["attribute1"]},
    }


def base_exhaustive_scan_request(item):
    """
    Base structure for exhaustive scan requests.
    This is not intended to be able to be used as a real request.
    Some parameters conflict with each other when sent to DynamoDB.
    This is only intended to test the conversion of the request from client to resource format.
    """
    return {
        "IndexName": "index_name",
        "AttributesToGet": ["partition_key", "sort_key", "attribute1", "attribute2"],
        "Select": "SPECIFIC_ATTRIBUTES",
        "ScanFilter": {"attribute1": {"AttributeValueList": [item["attribute1"]], "ComparisonOperator": "EQ"}},
        "ConditionalOperator": "AND",
        "ReturnConsumedCapacity": "TOTAL",
        "ReturnItemCollectionMetrics": "SIZE",
        "ExpressionAttributeNames": {"#a1": "attribute1"},
        "ExpressionAttributeValues": {":a1": item["attribute1"]},
        "ExclusiveStartKey": {"partition_key": item["partition_key"], "sort_key": item["sort_key"]},
    }


# DDB format request functions


def basic_put_item_request_ddb(item):
    """Get a put_item request in DDB format for any item."""
    base = base_put_item_request(item)
    return {"TableName": INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME, **base}


def exhaustive_put_item_request_ddb(item):
    """Get a put_item request in DDB format for any item."""
    base = basic_put_item_request_ddb(item)
    additional_keys = base_exhaustive_put_item_request(item)
    additional_keys["ConditionExpression"] = "attribute_not_exists(#pk) AND attribute_not_exists(#sk)"
    return {**base, **additional_keys}


def basic_get_item_request_ddb(item):
    """Get a get_item request in DDB format for any item."""
    base = base_get_item_request(item)
    return {"TableName": INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME, **base}


def exhaustive_get_item_request_ddb(item):
    """Get a get_item request in DDB format for any item."""
    base = basic_get_item_request_ddb(item)
    additional_keys = base_exhaustive_get_item_request(item)
    return {**base, **additional_keys}


def basic_delete_item_request_ddb(item):
    """Get a delete_item request in DDB format for any item."""
    base = base_delete_item_request(item)
    return {"TableName": INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME, **base}


def exhaustive_delete_item_request_ddb(item):
    """Get a delete_item request in DDB format for any item."""
    base = basic_delete_item_request_ddb(item)
    additional_keys = base_exhaustive_delete_item_request(item)
    return {**base, **additional_keys}


def basic_query_request_ddb(item):
    """Get a query request in DDB format for any item."""
    base = base_query_request(item)
    return {"TableName": INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME, **base}


def exhaustive_query_request_ddb(item):
    """
    Query request with all possible parameters.
    This is not intended to be able to be used as a real request.
    Some parameters conflict with each other when sent to DynamoDB.
    This is only intended to test the conversion of the request from client to resource format.
    """
    base = basic_query_request_ddb(item)
    additional_keys = base_exhaustive_query_request(item)
    return {**base, **additional_keys}


def basic_scan_request_ddb(item):
    """Get a scan request in DDB format for any item."""
    base = base_scan_request(item)
    return {"TableName": INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME, **base}


def exhaustive_scan_request_ddb(item):
    """Get a scan request in DDB format for any item."""
    base = basic_scan_request_ddb(item)
    additional_keys = base_exhaustive_scan_request(item)
    return {**base, **additional_keys}


def basic_batch_write_item_request_ddb(actions_with_items):
    """Get a batch_write_item request in DDB format for any items."""
    return base_batch_write_item_request(actions_with_items)


def basic_batch_write_item_put_request_ddb(items):
    """Get a batch_write_item put request in DDB format for any items."""
    actions_with_items = [{"PutRequest": {"Item": item}} for item in items]
    return basic_batch_write_item_request_ddb(actions_with_items)


def basic_batch_write_item_delete_request_ddb(keys):
    """Get a batch_write_item delete request in DDB format for any keys."""
    actions_with_keys = [{"DeleteRequest": {"Key": key}} for key in keys]
    return basic_batch_write_item_request_ddb(actions_with_keys)


def basic_batch_get_item_request_ddb(keys):
    """Get a batch_get_item request in DDB format for any keys."""
    return base_batch_get_item_request(keys)


def basic_transact_write_item_request_ddb(actions_with_items):
    """Get a transact_write_item request in DDB format for any items."""
    return base_transact_write_item_request(actions_with_items)


def basic_transact_write_item_put_request_ddb(items):
    """Get a transact_write_item put request in DDB format for any items."""
    actions_with_items = [
        {"Put": {"TableName": INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME, "Item": item}} for item in items
    ]
    return basic_transact_write_item_request_ddb(actions_with_items)


def basic_transact_write_item_delete_request_ddb(keys):
    """Get a transact_write_item delete request in DDB format for any keys."""
    actions_with_keys = [{"Delete": {"TableName": INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME, "Key": key}} for key in keys]
    return basic_transact_write_item_request_ddb(actions_with_keys)


def basic_transact_write_item_condition_check_request_ddb(keys):
    """Get a transact_write_item condition check request in DDB format for any keys."""
    actions_with_keys = [
        {"ConditionCheck": {"TableName": INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME, "Key": key}} for key in keys
    ]
    return basic_transact_write_item_request_ddb(actions_with_keys)


def basic_transact_get_item_request_ddb(keys):
    """Get a transact_get_item request in DDB format for any keys."""
    return base_transact_get_item_request(keys)


def basic_query_paginator_request(key):
    """Get a query paginator request in DDB format for any item."""
    return {
        "TableName": INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME,
        "KeyConditionExpression": "partition_key = :pk AND sort_key = :sk",
        "ExpressionAttributeValues": {":pk": key["partition_key"], ":sk": key["sort_key"]},
    }


def basic_scan_paginator_request(item):
    """Get a scan paginator request in DDB format for any item."""
    return {
        "TableName": INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME,
        "FilterExpression": "partition_key = :pk AND sort_key = :sk",
        "ExpressionAttributeValues": {":pk": item["partition_key"], ":sk": item["sort_key"]},
    }


def basic_update_item_request_ddb(item):
    """Get an update_item request in DDB format for any item."""
    base = base_update_item_request(item)
    return {"TableName": INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME, **base}


def basic_execute_statement_request_ddb():
    """Get an execute_statement request in DDB format."""
    base = base_execute_statement_request()
    return base


def basic_execute_transaction_request_ddb():
    """Get an execute_transaction request in DDB format."""
    base = base_execute_transaction_request()
    return base


def basic_batch_execute_statement_request_ddb():
    """Get a batch_execute_statement request in DDB format."""
    base = base_batch_execute_statement_request()
    return base

# Dict format request functions


def basic_put_item_request_dict(item):
    """Get a put_item request in dict format for any item."""
    return base_put_item_request(item)


def exhaustive_put_item_request_dict(item):
    """
    Get a put_item request in dict format for any item.
    This is not intended to be able to be used as a real request.
    Some parameters conflict with each other when sent to DynamoDB.
    This is only intended to test the conversion of the request from client to resource format.
    """
    base = basic_put_item_request_dict(item)
    # Replace the default ConditionExpression string with a ConditionExpression object
    # to increase test coverage.
    additional_keys = base_exhaustive_put_item_request(item)
    additional_keys["ConditionExpression"] = Attr("#pk").not_exists() & Attr("#sk").not_exists()
    return {**base, **additional_keys}


def basic_get_item_request_dict(item):
    """Get a get_item request in dict format for any item."""
    return base_get_item_request(item)


def basic_delete_item_request_dict(item):
    """Get a delete_item request in dict format for any item."""
    return base_delete_item_request(item)


def exhaustive_get_item_request_dict(item):
    """
    Get a get_item request in dict format for any item.
    This is not intended to be able to be used as a real request.
    Some parameters conflict with each other when sent to DynamoDB.
    This is only intended to test the conversion of the request from client to resource format.
    """
    base = basic_get_item_request_dict(item)
    additional_keys = base_exhaustive_get_item_request(item)
    return {**base, **additional_keys}


def basic_query_request_dict(item):
    """Get a query request in dict format for any item."""
    base = base_query_request(item)
    return base


def basic_query_request_dict_condition_expression(item):
    """Get a query request in dict format for any item."""
    base = base_query_request(item)
    # Replace the default KeyConditionExpression string with a ConditionExpression object
    # to increase test coverage.
    return {"KeyConditionExpression": Key("partition_key").eq(item["partition_key"]), **base}


def exhaustive_query_request_dict(item):
    """
    Get a query request in dict format for any item.
    This is not intended to be able to be used as a real request.
    Some parameters conflict with each other when sent to DynamoDB.
    This is only intended to test the conversion of the request from client to resource format.
    """
    base = basic_query_request_dict(item)
    additional_keys = base_exhaustive_query_request(item)
    return {**base, **additional_keys}


def basic_scan_request_dict(item):
    """Get a scan request in dict format for any item."""
    return base_scan_request(item)


def exhaustive_scan_request_dict(item):
    """
    Get a scan request in dict format for any item.
    This is not intended to be able to be used as a real request.
    Some parameters conflict with each other when sent to DynamoDB.
    This is only intended to test the conversion of the request from client to resource format.
    """
    base = basic_scan_request_dict(item)
    additional_keys = base_exhaustive_scan_request(item)
    return {**base, **additional_keys}


def basic_batch_write_item_request_dict(actions_with_items):
    """Get a batch_write_item request in dict format for any items."""
    return base_batch_write_item_request(actions_with_items)


def basic_batch_write_item_put_request_dict(items):
    """Get a batch_put_item request in dict format for any items."""
    actions_with_items = [{"PutRequest": {"Item": item}} for item in items]
    return basic_batch_write_item_request_dict(actions_with_items)


def basic_batch_write_item_delete_request_dict(keys):
    """Get a batch_write_item delete request in dict format for any keys."""
    actions_with_keys = [{"DeleteRequest": {"Key": key}} for key in keys]
    return basic_batch_write_item_request_dict(actions_with_keys)


def basic_batch_get_item_request_dict(keys):
    """Get a batch_get_item request in dict format for any keys."""
    return base_batch_get_item_request(keys)


def basic_transact_write_item_request_dict(actions_with_items):
    """Get a transact_write_item request in dict format for any items."""
    return base_transact_write_item_request(actions_with_items)


def basic_transact_write_item_put_request_dict(items):
    """Get a transact_write_item put request in dict format for any items."""
    actions_with_items = [
        {"Put": {"TableName": INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME, "Item": item}} for item in items
    ]
    return basic_transact_write_item_request_dict(actions_with_items)


def basic_transact_write_item_delete_request_dict(keys):
    """Get a transact_write_item delete request in dict format for any keys."""
    actions_with_keys = [{"Delete": {"TableName": INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME, "Key": key}} for key in keys]
    return basic_transact_write_item_request_dict(actions_with_keys)


def basic_transact_write_item_condition_check_request_dict(keys):
    """Get a transact_write_item condition check request in dict format for any keys."""
    actions_with_keys = [
        {"ConditionCheck": {"TableName": INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME, "Key": key}} for key in keys
    ]
    return basic_transact_write_item_request_dict(actions_with_keys)


def basic_transact_get_item_request_dict(keys):
    """Get a transact_get_item request in dict format for any keys."""
    return base_transact_get_item_request(keys)


def basic_update_item_request_dict(item):
    """Get an update_item request in DDB format for any item."""
    base = base_update_item_request(item)
    return base


def basic_execute_statement_request_dict():
    """Get an execute_statement request in DDB format."""
    base = base_execute_statement_request()
    return base


def basic_execute_transaction_request_dict():
    """Get an execute_transaction request in DDB format."""
    base = base_execute_transaction_request()
    return base


def basic_batch_execute_statement_request_dict():
    """Get a batch_execute_statement request in DDB format."""
    base = base_batch_execute_statement_request()
    return base
