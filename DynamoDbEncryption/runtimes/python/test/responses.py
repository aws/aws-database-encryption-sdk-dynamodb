from test.integ.encrypted.test_resource import INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME


def basic_put_item_response(item):
    """Get a put_item response in resource (ddb) format for any item."""
    return {"Attributes": item}


def exhaustive_put_item_response(item):
    """Get a put_item response in resource (ddb) format for any item."""
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
    """Get a get_item response in resource (ddb) format for any item."""
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
    """Get a query response in resource (ddb) format for any items."""
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
    """Get a scan response in resource (ddb) format for any items."""
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
    """Get a batch_get_item response in resource (ddb) format for any items."""
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
    """Get a batch_write_item response in resource (ddb) format for any items."""
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


def basic_transact_get_items_response(items):
    """Get a transact_get_items response in resource (ddb) format for any items."""
    return {"Responses": [{"Item": item} for item in items]}
