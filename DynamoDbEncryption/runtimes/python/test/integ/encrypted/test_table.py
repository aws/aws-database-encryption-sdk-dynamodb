import boto3
import pytest
import uuid
from copy import deepcopy

from aws_dbesdk_dynamodb.encrypted.table import EncryptedTable
from aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.errors import (
    DynamoDbEncryptionTransformsException,
)

from ...constants import (
    INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME,
    INTEG_TEST_DEFAULT_TABLE_CONFIGS,
)
from ...items import complex_item_dict, simple_item_dict
from ...requests import (
    basic_delete_item_request_dict,
    basic_get_item_request_dict,
    basic_put_item_request_dict,
    basic_query_request_dict,
    basic_scan_request_dict,
    basic_update_item_request_dict_signed_attribute,
    basic_update_item_request_dict_unsigned_attribute,
)


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


# Creates a matrix of tests for each value in param,
# with a user-friendly string for test output:
# encrypted = True -> "encrypted"
# encrypted = False -> "plaintext"
@pytest.fixture(params=[True, False], ids=["encrypted", "plaintext"])
def encrypted(request):
    return request.param


@pytest.fixture
def table(encrypted):
    """
    Create a table client.
    Use both to test that the same input can be provided to both boto3 and the EncryptedTable.
    """
    if encrypted:
        return encrypted_table()
    else:
        return plaintext_table()

@pytest.fixture(scope="module")
def test_run_suffix():
    return str(uuid.uuid4())

# Creates a matrix of tests for each value in param,
# with a user-friendly string for test output:
# use_complex_item = True -> "complex_item"
# use_complex_item = False -> "simple_item"
@pytest.fixture(params=[simple_item_dict, complex_item_dict], ids=["simple_item", "complex_item"])
def test_item(request, test_run_suffix):
    item = deepcopy(request.param)
    item["partition_key"] += test_run_suffix
    return item


def test_GIVEN_item_WHEN_basic_put_AND_basic_get_AND_basic_delete_THEN_round_trip_passes(table, test_item):
    """Test put_item, get_item, and delete_item operations."""
    # Given: Valid put_item request
    put_item_request_dict = basic_put_item_request_dict(test_item)
    # When: put_item
    put_response = table.put_item(**put_item_request_dict)
    # Then: put_item succeeds
    assert put_response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # Given: Valid get_item request for the same item
    get_item_request_dict = basic_get_item_request_dict(test_item)
    # When: get_item
    get_response = table.get_item(**get_item_request_dict)
    # Then: Simple item is encrypted and decrypted correctly
    assert get_response["ResponseMetadata"]["HTTPStatusCode"] == 200
    assert get_response["Item"] == put_item_request_dict["Item"]

    # Given: Valid delete_item request for the same item
    delete_item_request_dict = basic_delete_item_request_dict(test_item)
    # When: delete_item
    delete_response = table.delete_item(**delete_item_request_dict)
    # Then: delete_item succeeds
    assert delete_response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # Given: Valid get_item request for the same item
    get_item_request_dict = basic_get_item_request_dict(test_item)
    # When: get_item
    get_response = table.get_item(**get_item_request_dict)
    # Then: get_item is empty (i.e. the item was deleted)
    assert "Item" not in get_response


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


@pytest.fixture
def scan_request(encrypted, test_item):
    if encrypted:
        request = basic_scan_request_dict(test_item)
        # If the encrypted scan encounters a plaintext item, the scan will fail.
        # To avoid this, encrypted scans add a filter expression that matches only encrypted items.
        request["FilterExpression"] = request["FilterExpression"] + " AND attribute_exists (#sig)"
        request["ExpressionAttributeNames"] = {}
        request["ExpressionAttributeNames"]["#sig"] = "amzn-ddb-map-sig"
        return request
    return basic_scan_request_dict(test_item)


def test_GIVEN_valid_put_and_scan_requests_WHEN_put_and_scan_THEN_round_trip_passes(table, test_item, scan_request):
    # Given: Simple and complex items in appropriate format for client
    put_item_request_dict = basic_put_item_request_dict(test_item)
    table.put_item(**put_item_request_dict)

    # When: Scanning items
    scan_request_dict = scan_request
    scan_response = table.scan(**scan_request_dict)
    # Then: Scan succeeds
    # Can't assert anything about the scan;
    # there are too many items.
    # The critical assertion is that the scan succeeds.
    assert scan_response["ResponseMetadata"]["HTTPStatusCode"] == 200


def test_GIVEN_update_for_unsigned_attribute_WHEN_update_item_THEN_passes(table, test_item):
    # Given: some item is already in the table
    put_response = table.put_item(**basic_put_item_request_dict(test_item))
    assert put_response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # Given: Valid update item request for unsigned attribute
    update_item_request = basic_update_item_request_dict_unsigned_attribute(test_item)

    # When: Calling update_item
    update_response = table.update_item(**update_item_request)
    # Then: update_item succeeds
    assert update_response["ResponseMetadata"]["HTTPStatusCode"] == 200


def test_GIVEN_update_for_signed_attribute_WHEN_update_item_THEN_raises_DynamoDbEncryptionTransformsException(
    table, test_item, encrypted
):
    if not encrypted:
        pytest.skip("Skipping negative test for plaintext client")

    # Given: some item is already in the table
    put_response = table.put_item(**basic_put_item_request_dict(test_item))
    assert put_response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # Given: Valid update item request for signed attribute
    update_item_request = basic_update_item_request_dict_signed_attribute(test_item)

    # Then: raises DynamoDbEncryptionTransformsException
    with pytest.raises(DynamoDbEncryptionTransformsException):
        # When: Calling update_item
        table.update_item(**update_item_request)


def test_WHEN_call_passthrough_method_THEN_correct_response_is_returned():
    """Test that calling a passthrough method returns the correct response."""
    # Given: Encrypted or plaintext table
    # When: Calling some passthrough method that does not explicitly exist on EncryptedTable,
    # but exists on the underlying boto3 table
    response = encrypted_table().table_name
    # Then: Correct response is returned, i.e. EncryptedTable forwards the call to the underlying boto3 table
    assert response == INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME

# Delete the items in the table after the module runs
@pytest.fixture(scope="module", autouse=True)
def cleanup_after_module(test_run_suffix):
    yield
    table = boto3.resource("dynamodb").Table(INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME)
    items = [deepcopy(simple_item_dict), deepcopy(complex_item_dict)]
    for item in items:
        item["partition_key"] = item["partition_key"] + test_run_suffix
        table.delete_item(**basic_delete_item_request_dict(item))
