# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
from test.integ.encrypted.test_resource import INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME


def basic_put_item_response(item):
    """Get a put_item response in resource (ddb) format for any item."""
    return {"Attributes": item}


def exhaustive_put_item_response(item):
    """
    Get a put_item response in resource (ddb) format for any item.
    This is not intended to be a real response that DynamoDB would return,
    but the response should contain additional attributes that DynamoDB could return.
    This is only intended to exhaustively test the conversion of the request between client and resource formats.
    """
    base = basic_put_item_response(item)
    additional_keys = {
        "ConsumedCapacity": {"CapacityUnits": 1, "TableName": INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME},
        "ItemCollectionMetrics": {
            "TableName": INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME,
            "ItemCollectionKey": {"partition_key": item["partition_key"]},
        },
        "SequenceNumber": "1234567890",
        "SizeEstimateRangeGB": [0.5, 1.0],
    }
    return {**base, **additional_keys}


def basic_get_item_response(item):
    """Get a get_item response in resource (ddb) format for any item."""
    return {"Item": item}


def exhaustive_get_item_response(item):
    """
    Get a get_item response in resource (ddb) format for any item.
    This is not intended to be a real response that DynamoDB would return,
    but the response should contain additional attributes that DynamoDB could return.
    This is only intended to exhaustively test the conversion of the request between client and resource formats.
    """
    base = basic_get_item_response(item)
    additional_keys = {
        "ConsumedCapacity": {"CapacityUnits": 1, "TableName": INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME},
    }
    return {**base, **additional_keys}


def basic_query_response(items):
    """Get a query response in resource (ddb) format for any items."""
    return {
        "Items": items,
        "Count": len(items),
        "ScannedCount": len(items),
        "ConsumedCapacity": {"CapacityUnits": 1, "TableName": INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME},
    }


def exhaustive_query_response(items):
    """
    Get a query response in resource (ddb) format for any items.
    This is not intended to be a real response that DynamoDB would return,
    but the response should contain additional attributes that DynamoDB could return.
    This is only intended to exhaustively test the conversion of the request between client and resource formats.
    """
    base = basic_query_response(items)
    additional_keys = {
        "LastEvaluatedKey": {"partition_key": items[-1]["partition_key"]},
    }
    return {**base, **additional_keys}


def basic_scan_response(items, keys):
    """Get a scan response in resource (ddb) format for any items."""
    return {
        "Items": items,
    }


def exhaustive_scan_response(items, keys):
    """
    Get a scan response in resource (ddb) format for any items.
    This is not intended to be a real response that DynamoDB would return,
    but the response should contain additional attributes that DynamoDB could return.
    This is only intended to exhaustively test the conversion of the request between client and resource formats.
    """
    base = basic_scan_response(items, keys)
    additional_keys = {
        "ConsumedCapacity": {"CapacityUnits": 1, "TableName": INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME},
        "Count": len(items),
        "ScannedCount": len(items),
        "LastEvaluatedKey": keys[-1],
    }
    return {**base, **additional_keys}


def basic_batch_get_item_response(items):
    """Get a batch_get_item response in resource (ddb) format for any items."""
    return {"Responses": {INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME: items}}


def exhaustive_batch_get_item_response(items):
    """
    Get a batch_get_item response in resource (ddb) format for any items.
    This is not intended to be a real response that DynamoDB would return,
    but the response should contain additional attributes that DynamoDB could return.
    This is only intended to exhaustively test the conversion of the request between client and resource formats.
    """
    base = basic_batch_get_item_response(items)
    additional_keys = {
        "UnprocessedKeys": {
            INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME: {
                "Keys": [{"partition_key": item["partition_key"]} for item in items]
            }
        },
    }
    return {**base, **additional_keys}


def basic_batch_write_item_put_response(items):
    """Get a batch_write_item response in resource (ddb) format for any items."""
    return {
        "UnprocessedItems": {INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME: [{"PutRequest": {"Item": item}} for item in items]}
    }


def exhaustive_batch_write_item_put_response(items):
    """
    Get a batch_write_item response in resource (ddb) format for any items.
    This is not intended to be a real response that DynamoDB would return,
    but the response should contain additional attributes that DynamoDB could return.
    This is only intended to exhaustively test the conversion of the request between client and resource formats.
    """
    base = basic_batch_write_item_put_response(items)
    additional_keys = {
        "ItemCollectionMetrics": {
            INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME: [
                {"ItemCollectionKey": {"partition_key": items[-1]["partition_key"]}}
            ]
        },
    }
    return {**base, **additional_keys}


def basic_transact_write_items_response(items):
    """Get a transact_write_items response in resource (ddb) format for any items."""
    return {
        "ItemCollectionMetrics": {
            INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME: [
                {"ItemCollectionKey": {"partition_key": items[-1]["partition_key"]}}
            ]
        },
    }


# No exhaustive response for transact_write_items;
# The basic_transact_write_items_response is sufficient


def basic_transact_get_items_response(items):
    """Get a transact_get_items response in resource (ddb) format for any items."""
    return {"Responses": [{"Item": item} for item in items]}


# No exhaustive response for transact_get_items;
# The basic_transact_get_items_response is sufficient


def basic_update_item_response(item):
    """Get an update_item response in resource (ddb) format for any item."""
    return {"Attributes": item}


def exhaustive_update_item_response(item):
    """
    Get an update_item response in resource (ddb) format for any item.
    This is not intended to be a real response that DynamoDB would return,
    but the response should contain additional attributes that DynamoDB could return.
    This is only intended to exhaustively test the conversion of the request between client and resource formats.
    """
    base = basic_update_item_response(item)
    additional_keys = {
        "ItemCollectionMetrics": {
            "ItemCollectionKey": {"partition_key": item["partition_key"]},
        },
    }
    return {**base, **additional_keys}


def basic_delete_item_response(item):
    """Get a delete_item response in resource (ddb) format for any item."""
    return {"Attributes": item}


def exhaustive_delete_item_response(item):
    """
    Get a delete_item response in resource (ddb) format for any item.
    This is not intended to be a real response that DynamoDB would return,
    but the response should contain additional attributes that DynamoDB could return.
    This is only intended to exhaustively test the conversion of the request between client and resource formats.
    """
    base = basic_delete_item_response(item)
    additional_keys = {
        "ItemCollectionMetrics": {
            "ItemCollectionKey": {"partition_key": item["partition_key"]},
        },
    }
    return {**base, **additional_keys}


def basic_execute_statement_response(items):
    """Get an execute_statement response in resource (ddb) format for any items."""
    return {"Items": items}


def exhaustive_execute_statement_response(items):
    """
    Get an execute_statement response in resource (ddb) format for any items.
    This is not intended to be a real response that DynamoDB would return,
    but the response should contain additional attributes that DynamoDB could return.
    This is only intended to exhaustively test the conversion of the request between client and resource formats.
    """
    base = basic_execute_statement_response(items)
    additional_keys = {
        "LastEvaluatedKey": {
            "partition_key": items[-1]["partition_key"],
            "sort_key": items[-1]["sort_key"],
        },
    }
    return {**base, **additional_keys}


def basic_execute_transaction_response(items):
    """Get an execute_transaction response in resource (ddb) format for any items."""
    return {"Responses": [{"Item": item} for item in items]}


# No exhaustive response for execute_transaction;
# The basic_execute_transaction_response is sufficient


def basic_batch_execute_statement_response(items):
    """Get a batch_execute_statement response in resource (ddb) format for any items."""
    return {"Responses": [{"Item": item} for item in items]}


def exhaustive_batch_execute_statement_response(items):
    """
    Get a batch_execute_statement response in resource (ddb) format for any items.
    This is not intended to be a real response that DynamoDB would return,
    but the response should contain additional attributes that DynamoDB could return.
    This is only intended to exhaustively test the conversion of the request between client and resource formats.
    """
    base = basic_batch_execute_statement_response(items)
    base["Responses"][0]["Error"] = {
        "Item": {
            "partition_key": items[0]["partition_key"],
            "sort_key": items[0]["sort_key"],
        }
    }
    return base
