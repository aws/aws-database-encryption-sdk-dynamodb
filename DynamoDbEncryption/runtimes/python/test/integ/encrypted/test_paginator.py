import boto3
import pytest

from aws_dbesdk_dynamodb.encrypted.client import EncryptedClient

from . import sort_dynamodb_json_lists

from ...constants import (
    INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME,
    INTEG_TEST_DEFAULT_TABLE_CONFIGS,
)
from ...items import (
    complex_item_ddb,
    complex_item_dict,
    complex_key_ddb,
    complex_key_dict,
    simple_item_ddb,
    simple_item_dict,
    simple_key_ddb,
    simple_key_dict,
)
from ...requests import (
    basic_put_item_request_ddb,
    basic_put_item_request_dict,
    basic_query_paginator_request,
    basic_scan_paginator_request,
)


# Creates a matrix of tests for each value in param,
# with a user-friendly string for test output:
# expect_standard_dictionaries = True -> "standard_dicts"
# expect_standard_dictionaries = False -> "ddb_json"
@pytest.fixture(params=[True, False], ids=["standard_dicts", "ddb_json"])
def expect_standard_dictionaries(request):
    return request.param


def encrypted_client(expect_standard_dictionaries):
    return EncryptedClient(
        client=plaintext_client(expect_standard_dictionaries),
        encryption_config=INTEG_TEST_DEFAULT_TABLE_CONFIGS,
        expect_standard_dictionaries=expect_standard_dictionaries,
    )


def plaintext_client(expect_standard_dictionaries):
    if expect_standard_dictionaries:
        client = boto3.resource("dynamodb").Table(INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME).meta.client
    else:
        client = boto3.client("dynamodb")
    return client


# Creates a matrix of tests for each value in param,
# with a user-friendly string for test output:
# encrypted = True -> "encrypted"
# encrypted = False -> "plaintext"
@pytest.fixture(params=[True, False], ids=["encrypted", "plaintext"])
def encrypted(request):
    return request.param


@pytest.fixture
def client(encrypted, expect_standard_dictionaries):
    if encrypted:
        return encrypted_client(expect_standard_dictionaries)
    else:
        return plaintext_client(expect_standard_dictionaries)


@pytest.fixture
def query_paginator(client):
    return client.get_paginator("query")


@pytest.fixture
def scan_paginator(client):
    return client.get_paginator("scan")

# Creates a matrix of tests for each value in param,
# with a user-friendly string for test output:
# use_complex_item = True -> "complex_item"
# use_complex_item = False -> "simple_item"
@pytest.fixture(params=[True, False], ids=["complex_item", "simple_item"])
def use_complex_item(request):
    return request.param


@pytest.fixture
def test_key(expect_standard_dictionaries, use_complex_item):
    """Get a single test item in the appropriate format for the client."""
    if expect_standard_dictionaries:
        if use_complex_item:
            return complex_key_dict
        return simple_key_dict
    if use_complex_item:
        return complex_key_ddb
    return simple_key_ddb


@pytest.fixture
def multiple_test_keys(expect_standard_dictionaries):
    """Get two test keys in the appropriate format for the client."""
    if expect_standard_dictionaries:
        return [simple_key_dict, complex_key_dict]
    return [simple_key_ddb, complex_key_ddb]


@pytest.fixture
def test_item(expect_standard_dictionaries, use_complex_item):
    """Get a single test item in the appropriate format for the client."""
    if expect_standard_dictionaries:
        if use_complex_item:
            return complex_item_dict
        return simple_item_dict
    if use_complex_item:
        return complex_item_ddb
    return simple_item_ddb


@pytest.fixture
def paginate_query_request(expect_standard_dictionaries, test_key):
    if expect_standard_dictionaries:
        return {**basic_query_paginator_request(test_key), "TableName": INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME}
    return basic_query_paginator_request(test_key)


@pytest.fixture
def put_item_request(expect_standard_dictionaries, test_item):
    if expect_standard_dictionaries:
        # Client requests with `expect_standard_dictionaries=True` use dict-formatted requests
        # with an added "TableName" key.
        return {**basic_put_item_request_dict(test_item), "TableName": INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME}
    return basic_put_item_request_ddb(test_item)

def test_GIVEN_query_paginator_WHEN_paginate_THEN_returns_expected_items(
    client, query_paginator, paginate_query_request, put_item_request, test_item
):
    # Given: item in table
    client.put_item(**put_item_request)
    # Given: Query paginator
    # When: Paginate
    response = query_paginator.paginate(**paginate_query_request)
    # Then: Returns encrypted items
    items = []
    for page in response:
        if "Items" in page:
            for item in page["Items"]:
                items.append(item)
    assert len(items) == 1
    # DynamoDB JSON uses lists to represent sets, so strict equality can fail.
    # Sort lists to ensure consistent ordering when comparing expected and actual items.
    expected_item = sort_dynamodb_json_lists(test_item)
    actual_item = sort_dynamodb_json_lists(items[0])
    # Then: Items are equal
    assert expected_item == actual_item


@pytest.fixture
def paginate_scan_request(expect_standard_dictionaries, test_item):
    if expect_standard_dictionaries:
        request = {**basic_scan_paginator_request(test_item), "TableName": INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME}
    else:
        request = basic_scan_paginator_request(test_item)
    return request


def test_GIVEN_scan_paginator_WHEN_paginate_THEN_returns_expected_items(
    client, scan_paginator, paginate_scan_request, put_item_request, test_item
):
    # Given: item in table
    client.put_item(**put_item_request)
    # Given: Scan paginator
    # When: Paginate
    response = scan_paginator.paginate(**paginate_scan_request)
    # Then: Returns encrypted items
    items = []
    for page in response:
        if "Items" in page:
            for item in page["Items"]:
                items.append(item)
    assert len(items) == 1
    # DynamoDB JSON uses lists to represent sets, so strict equality can fail.
    # Sort lists to ensure consistent ordering when comparing expected and actual items.
    expected_item = sort_dynamodb_json_lists(test_item)
    actual_item = sort_dynamodb_json_lists(items[0])
    # Then: Items are equal
    assert expected_item == actual_item
