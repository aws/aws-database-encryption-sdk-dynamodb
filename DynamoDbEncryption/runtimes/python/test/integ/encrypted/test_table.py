import pytest
import boto3
from decimal import Decimal
from boto3.dynamodb.types import Binary

from aws_dbesdk_dynamodb.encrypted.table import EncryptedTable
from aws_dbesdk_dynamodb.encrypted.paginator import EncryptedPaginator
from aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models import (
    DynamoDbTablesEncryptionConfig,
)
from ...constants import (
    INTEG_TEST_DEFAULT_TABLE_CONFIGS,
    INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME,
    INTEG_TEST_DEFAULT_ATTRIBUTE_ACTIONS_ON_ENCRYPT,
)
from boto3.dynamodb.types import TypeDeserializer, TypeSerializer
from ...items import simple_item_ddb, simple_item_dict, complex_item_ddb, complex_item_dict
from ...requests import (
    basic_put_item_request_dict,
    basic_get_item_request_dict,
    basic_query_request_dict,
    basic_scan_request_dict,
)

serializer = TypeSerializer()
deserializer = TypeDeserializer()


def encrypted_table():
    """Create an encrypted table."""
    table = boto3.resource("dynamodb").Table(INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME)
    return EncryptedTable(
        table=table,
        encryption_config=INTEG_TEST_DEFAULT_TABLE_CONFIGS,
    )


def plaintext_table():
    """Create a plaintext table."""
    table = boto3.resource("dynamodb").Table(INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME)
    return table


@pytest.fixture(params=[True, False], ids=["encrypted", "plaintext"])
def encrypted(request):
    return request.param


@pytest.fixture
def table(encrypted):
    """Create a table client.
    Use both to test that the same input can be provided to both boto3 and the EncryptedTable."""
    if encrypted:
        return encrypted_table()
    else:
        return plaintext_table()


@pytest.fixture(params=[simple_item_dict, complex_item_dict], ids=["simple_item", "complex_item"])
def test_item(request):
    return request.param


def test_GIVEN_item_WHEN_basic_put_and_basic_get_THEN_round_trip_passes(table, test_item):
    """Test put_item and get_item operations."""
    # Given: Simple and complex items in appropriate format for client
    put_item_request_dict = basic_put_item_request_dict(test_item)

    # When: Putting and getting item
    put_response = table.put_item(**put_item_request_dict)
    assert put_response["ResponseMetadata"]["HTTPStatusCode"] == 200

    get_item_request_dict = basic_get_item_request_dict(test_item)
    get_response = table.get_item(**get_item_request_dict)
    # Then: Simple item is encrypted and decrypted correctly
    assert get_response["ResponseMetadata"]["HTTPStatusCode"] == 200
    assert get_response["Item"] == put_item_request_dict["Item"]


def test_GIVEN_items_WHEN_batch_write_and_get_THEN_round_trip_passes(
    table,
):
    # Given: Simple and complex items in appropriate format for client
    # When: Batch put items
    with table.batch_writer() as batch_writer:
        # boto3 documentation for batch_writer.put_item() is incorrect;
        # the method accepts the item directly, not the item inside an "Item" key.
        batch_writer.put_item(simple_item_dict)
        batch_writer.put_item(complex_item_dict)

    # When: Get items
    get_item_request_dict = basic_get_item_request_dict(simple_item_dict)
    get_response = table.get_item(**get_item_request_dict)
    # Then: All items are encrypted and decrypted correctly
    assert get_response["ResponseMetadata"]["HTTPStatusCode"] == 200
    assert get_response["Item"] == simple_item_dict

    get_item_request_dict = basic_get_item_request_dict(complex_item_dict)
    get_response = table.get_item(**get_item_request_dict)
    # Then: All items are encrypted and decrypted correctly
    assert get_response["ResponseMetadata"]["HTTPStatusCode"] == 200
    assert get_response["Item"] == complex_item_dict

    # When: Batch delete items
    with table.batch_writer() as batch_writer:
        batch_writer.delete_item(
            {"partition_key": simple_item_dict["partition_key"], "sort_key": simple_item_dict["sort_key"]}
        )
        batch_writer.delete_item(
            {"partition_key": complex_item_dict["partition_key"], "sort_key": complex_item_dict["sort_key"]}
        )

    # When: Get items
    get_item_request_dict = basic_get_item_request_dict(simple_item_dict)
    get_response = table.get_item(**get_item_request_dict)
    # Then: All items are encrypted and decrypted correctly
    assert get_response["ResponseMetadata"]["HTTPStatusCode"] == 200
    assert "Item" not in get_response

    get_item_request_dict = basic_get_item_request_dict(complex_item_dict)
    get_response = table.get_item(**get_item_request_dict)
    # Then: All items are encrypted and decrypted correctly
    assert get_response["ResponseMetadata"]["HTTPStatusCode"] == 200
    assert "Item" not in get_response


def test_GIVEN_items_in_table_WHEN_query_THEN_items_are_decrypted_correctly(table, test_item):
    """Test query and scan operations."""
    # Given: Simple and complex items in appropriate format for client
    # When: Putting items into table
    put_item_request_dict = basic_put_item_request_dict(test_item)
    table.put_item(**put_item_request_dict)

    # When: Querying items by partition key
    query_request_dict = basic_query_request_dict(test_item)
    query_response = table.query(**query_request_dict)
    # Then: Query returns correct items
    assert query_response["ResponseMetadata"]["HTTPStatusCode"] == 200
    assert len(query_response["Items"]) == 1
    assert query_response["Items"][0] == put_item_request_dict["Item"]

    # Scans work, but the test items are not found because
    # DDB only returns the first 1MB of data, and the test items
    # are not in the first 1MB sometimes. We probably need a new table.
    # TODO: Add a new table for these tests, enable tests.
    # # When: Scanning with filter that matches only our test items
    # scan_response = encrypted_table.scan(**scan_request_dict)
    # # Then: Scan returns both test items
    # assert scan_response["ResponseMetadata"]["HTTPStatusCode"] == 200
    # assert len(scan_response["Items"]) == 2
    # # Check each test item is found in scan results
    # found_items = scan_response["Items"]
    # assert all(any(found_item == item for found_item in found_items) for item in items)


@pytest.fixture
def scan_request(encrypted, test_item):
    if encrypted:
        request = basic_scan_request_dict(test_item)
        request["FilterExpression"] = request["FilterExpression"] + " AND attribute_exists (#sig)"
        request["ExpressionAttributeNames"] = {}
        request["ExpressionAttributeNames"]["#sig"] = "amzn-ddb-map-sig"
        return request
    return basic_scan_request_dict(test_item)


def test_GIVEN_valid_put_and_scan_requests_WHEN_put_and_scan_THEN_round_trip_passes(table, test_item, scan_request):
    """Test put_item and scan operations."""
    # Given: Simple and complex items in appropriate format for client
    put_item_request_dict = basic_put_item_request_dict(test_item)
    table.put_item(**put_item_request_dict)

    # When: Scanning items
    scan_request_dict = scan_request
    scan_response = table.scan(**scan_request_dict)
    # Then: Scan returns both test items
    assert scan_response["ResponseMetadata"]["HTTPStatusCode"] == 200


def test_WHEN_update_item_THEN_raises_not_implemented_error():
    # Given: Encrypted client and update item parameters
    # When: Calling update_item
    with pytest.raises(NotImplementedError):
        encrypted_table().update_item(
            TableName=INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME,
            Key={"partition_key": "test-key", "sort_key": 1},
            UpdateExpression="SET attribute1 = :val",
            ExpressionAttributeValues={":val": {"S": "new value"}},
        )
    # Then: NotImplementedError is raised


def test_WHEN_call_passthrough_method_THEN_correct_response_is_returned():
    """Test that calling a passthrough method returns the correct response."""
    # Given: Encrypted client
    # When: Calling some passthrough method that does not explicitly exist on EncryptedClient,
    # but exists on the underlying boto3 client
    response = encrypted_table().meta.client.list_backups()
    # Then: Correct response is returned, i.e. EncryptedClient forwards the call to the underlying boto3 client
    assert response["ResponseMetadata"]["HTTPStatusCode"] == 200
