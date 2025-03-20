"""Request constants for DynamoDB operations."""

import pytest
from .constants import INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME
from .items import simple_item_ddb, simple_item_ddb, complex_item_ddb, complex_item_ddb

def basic_put_item_request_ddb(item):
    """Get a put_item request in resource (ddb) format for any item."""
    return {
        "TableName": INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME,
        "Item": item
    }

def exhaustive_put_item_request_ddb(item):
    """Get a put_item request in resource (ddb) format for any item."""
    base = basic_put_item_request_ddb(item)
    additional_keys = {
        # Expected is legacy, but still in the boto3 docs.
        "Expected": {
            "partition_key": {
                "Value": item["partition_key"]
            },
            "sort_key": {
                "Value": item["sort_key"]
            }
        },
        "ConditionExpression": "attribute_not_exists(#pk) AND attribute_not_exists(#sk)",
        "ExpressionAttributeNames": {
            "#pk": "partition_key",
            "#sk": "sort_key"
        },
        "ExpressionAttributeValues": {
            ":pk": item["partition_key"],
            ":sk": item["sort_key"]
        },
        "ReturnConsumedCapacity": "TOTAL",
        "ReturnItemCollectionMetrics": "SIZE",
        "ReturnValues": "ALL_OLD",
        "ReturnValuesOnConditionCheckFailure": "ALL_OLD"
    }
    return {**base, **additional_keys}

def basic_get_item_request_ddb(item):
    """Get a get_item request in resource (ddb) format for any item."""
    return {
        "TableName": INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME,
        "Key": {
            "partition_key": item["partition_key"],
            "sort_key": item["sort_key"]
        }
    }

def exhaustive_get_item_request_ddb(item):
    """Get a get_item request in resource (ddb) format for any item."""
    base = basic_get_item_request_ddb(item)
    additional_keys = {
        "ReturnConsumedCapacity": "TOTAL",
        "ReturnItemCollectionMetrics": "SIZE",
        "ProjectionExpression": "partition_key, sort_key, attribute1, attribute2",
        "ExpressionAttributeNames": {
            "#pk": "partition_key",
            "#sk": "sort_key",
            "#a1": "attribute1",
            "#a2": "attribute2"
        },
        "ConsistentRead": True,
        "AttributesToGet": ["partition_key", "sort_key", "attribute1", "attribute2"]
    }
    return {**base, **additional_keys}

def basic_query_request_ddb(item):
    """Get a query request in resource (ddb) format for any item."""
    return {
        "TableName": INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME,
        "KeyConditionExpression": "partition_key = :pk",
        "ExpressionAttributeValues": {
            ":pk": item["partition_key"]
        }
    }

def exhaustive_query_request_ddb(item):
    """Get a query request in resource (ddb) format for any item."""
    base = basic_query_request_ddb(item)
    additional_keys = {
        "ReturnConsumedCapacity": "TOTAL",
        "ReturnItemCollectionMetrics": "SIZE",
        "ProjectionExpression": "partition_key, sort_key, attribute1, attribute2",
        "ExpressionAttributeNames": {
            "#pk": "partition_key",
            "#sk": "sort_key",
            "#a1": "attribute1",
            "#a2": "attribute2"
        },
        "FilterExpression": "attribute1 = :a1",
        "ExpressionAttributeValues": {
            **base["ExpressionAttributeValues"],
            ":a1": item["attribute1"]
        },
        "Limit": 10,
        "ScanIndexForward": True
    }
    return {**base, **additional_keys}

def basic_batch_write_item_request_ddb(actions_with_items):
    """Get a batch_write_item request in resource (ddb) format for any items."""
    return {
        "RequestItems": {
            INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME: actions_with_items
        }
    }

def basic_batch_put_item_request_ddb(items):
    actions_with_items = [
        {"PutRequest": {"Item": item}}
        for item in items
    ]
    return basic_batch_write_item_request_ddb(actions_with_items)

def basic_batch_delete_item_request_ddb(keys):
    actions_with_keys = [
        {"DeleteRequest": {"Key": key}}
        for key in keys
    ]
    return basic_batch_write_item_request_ddb(actions_with_keys)

def basic_batch_get_item_request_ddb(keys):
    """Get a batch_get_item request in resource (ddb) format for any keys."""
    return {
        "RequestItems": {
            INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME: {
                "Keys": keys
            }
        }
    }

def basic_transact_write_item_request_ddb(actions_with_items):
    """Get a transact_write_item request in resource (ddb) format for any items."""
    return {
        "TransactItems": actions_with_items
    }

def basic_transact_write_item_put_request_ddb(items):
    actions_with_items = [
        {"Put": {"TableName": INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME, "Item": item}}
        for item in items
    ]
    return basic_transact_write_item_request_ddb(actions_with_items)

def basic_transact_write_item_delete_request_ddb(keys):
    actions_with_keys = [
        {"Delete": {"TableName": INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME, "Key": key}}
        for key in keys
    ]
    return basic_transact_write_item_request_ddb(actions_with_keys) 

def basic_transact_get_item_request_ddb(keys):
    """Get a transact_get_item request in resource (ddb) format for any keys."""
    return {
        "TransactItems": [{"Get": {"TableName": INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME, "Key": key}} for key in keys]
    }

