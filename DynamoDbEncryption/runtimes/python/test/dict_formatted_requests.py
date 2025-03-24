"""Request constants for DynamoDB operations."""

import pytest
from .constants import INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME
from .items import simple_item_ddb, simple_item_dict, complex_item_ddb, complex_item_dict
from boto3.dynamodb.conditions import Attr, Key

def basic_put_item_request_dict(item):
    """Get a put_item request in resource (dict) format for any item."""
    return {
        "Item": item
    }

def exhaustive_put_item_request_dict(item):
    """Get a put_item request in resource (dict) format for any item."""
    base = basic_put_item_request_dict(item)
    additional_keys = {
        # Expected is legacy, but still in the boto3 docs.
        "Expected": {
            "partition_key": {
                "Value": item["partition_key"]
            },
            "sort_key": {
                "AttributeValueList": [item["sort_key"]],
                "ComparisonOperator": "EQ"
            }
        },
        "ConditionExpression": Attr("pk").not_exists() & Attr("sk").not_exists(),
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

def basic_get_item_request_dict(item):
    """Get a get_item request in resource (dict) format for any item."""
    return {
        "Key": {
            "partition_key": item["partition_key"],
            "sort_key": item["sort_key"]
        }
    }

def exhaustive_get_item_request_dict(item):
    """Get a get_item request in resource (dict) format for any item."""
    base = basic_get_item_request_dict(item)
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

def basic_batch_write_item_request_dict(actions_with_items):
    """Get a batch_write_item request in resource (dict) format for any items."""
    return {
        "RequestItems": {
            INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME: [action_with_item for action_with_item in actions_with_items]
        }
    }

def basic_query_request_dict(item):
    """Get a query request in resource (dict) format for any item."""
    return {
        "KeyConditionExpression": Key("partition_key").eq(item["partition_key"]),
        "ExpressionAttributeValues": {
            ":pk": item["partition_key"]
        }
    }

def exhaustive_query_request_dict(item):
    """Get a query request in resource (dict) format for any item."""
    base = basic_query_request_dict(item)
    additional_keys = {
        "IndexName": "index_name",
        "Select": "SPECIFIC_ATTRIBUTES",
        "AttributesToGet": ["partition_key", "sort_key", "attribute1", "attribute2"],
        "KeyConditions": {
            "partition_key": {
                "AttributeValueList": [item["partition_key"]],
                "ComparisonOperator": "EQ"
            }
        },
        "QueryFilter": {
            "attribute1": {
                "AttributeValueList": [item["attribute1"]],
                "ComparisonOperator": "EQ"
            }
        },
        "ConditionalOperator": "AND",
        "ScanIndexForward": True,
        "ExclusiveStartKey": {
            "partition_key": item["partition_key"],
            "sort_key": item["sort_key"]
        },
        "ReturnConsumedCapacity": "TOTAL",
        "ProjectionExpression": "partition_key, sort_key, attribute1, attribute2",
        "FilterExpression": "attribute1 = :a1",
        "ExpressionAttributeNames": {
            "#pk": "partition_key",
            "#sk": "sort_key",
            "#a1": "attribute1",
            "#a2": "attribute2"
        },
        "ExpressionAttributeValues": {
            **base["ExpressionAttributeValues"],
            ":a1": item["attribute1"]
        },
    }
    return {**base, **additional_keys}

def basic_scan_request_dict(item):
    """Get a scan request in resource (dict) format for any item."""
    return {
        "FilterExpression": "attribute1 = :a1",
        "ExpressionAttributeValues": {
            ":a1": item["attribute1"]
        }
    }

def exhaustive_scan_request_dict(item):
    """Get a scan request in resource (dict) format for any item."""
    base = basic_scan_request_dict(item)
    additional_keys = {
        "IndexName": "index_name",
        "AttributesToGet": ["partition_key", "sort_key", "attribute1", "attribute2"],
        "Select": "SPECIFIC_ATTRIBUTES",
        "ScanFilter": {
            "attribute1": {
                "AttributeValueList": [item["attribute1"]],
                "ComparisonOperator": "EQ"
            }
        },
        "ConditionalOperator": "AND",
        "ReturnConsumedCapacity": "TOTAL",
        "ReturnItemCollectionMetrics": "SIZE",
        "ExpressionAttributeNames": {
            "#a1": "attribute1"
        },
        "ExpressionAttributeValues": {
            ":a1": item["attribute1"]
        },
        "ExclusiveStartKey": {
            "partition_key": item["partition_key"],
            "sort_key": item["sort_key"]
        }
    }
    return {**base, **additional_keys}

def basic_batch_write_item_request_dict(actions_with_items):
    """Get a batch_write_item request in resource (dict) format for any items."""
    return {
        "RequestItems": {
            INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME: actions_with_items
        }
    }

def basic_batch_write_item_put_request_dict(items):
    """Get a batch_put_item request in resource (dict) format for any items."""
    actions_with_items = [
        {"PutRequest": {"Item": item}}
        for item in items
    ]
    return basic_batch_write_item_request_dict(actions_with_items)

def basic_batch_write_item_delete_request_dict(keys):
    actions_with_keys = [
        {"DeleteRequest": {"Key": key}}
        for key in keys
    ]
    return basic_batch_write_item_request_dict(actions_with_keys)

def basic_batch_get_item_request_dict(keys):
    """Get a batch_get_item request in resource (dict) format for any keys."""
    return {
        "RequestItems": {
            INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME: {"Keys": keys}
        }
    }

def basic_transact_write_item_request_dict(actions_with_items):
    """Get a transact_write_item request in resource (dict) format for any items."""
    return {
        "TransactItems": actions_with_items
    }

def basic_transact_write_item_put_request_dict(items):
    """Get a transact_write_item put request in resource (dict) format for any items."""
    actions_with_items = [
        {"Put": {"TableName": INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME, "Item": item}}
        for item in items
    ]
    return basic_transact_write_item_request_dict(actions_with_items)

def basic_transact_write_item_delete_request_dict(keys):
    """Get a transact_write_item delete request in resource (dict) format for any keys."""
    actions_with_keys = [
        {"Delete": {"TableName": INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME, "Key": key}}
        for key in keys
    ]
    return basic_transact_write_item_request_dict(actions_with_keys)

def basic_transact_get_item_request_dict(keys):
    """Get a transact_get_item request in resource (dict) format for any keys."""
    return {
        "TransactItems": [{"Get": {"TableName": INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME, "Key": key}} for key in keys]
    }
