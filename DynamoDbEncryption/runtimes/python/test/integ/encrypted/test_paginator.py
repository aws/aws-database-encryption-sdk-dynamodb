import boto3
import pytest

from aws_dbesdk_dynamodb.encrypted.client import EncryptedClient

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
    basic_scan_request_ddb,
    basic_scan_request_dict,
)

BOTO3_CLIENT = boto3.client("dynamodb")
ENCRYPTED_CLIENT = EncryptedClient(client=BOTO3_CLIENT, encryption_config=INTEG_TEST_DEFAULT_TABLE_CONFIGS)
SCAN_PAGINATOR = ENCRYPTED_CLIENT.get_paginator("scan")
QUERY_PAGINATOR = ENCRYPTED_CLIENT.get_paginator("query")


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


def sort_dynamodb_json_lists(obj):
    """
    Utility that recursively sorts all lists in a DynamoDB JSON-like structure.
    DynamoDB JSON uses lists to represent sets, so strict equality can fail.
    Sort lists to ensure consistent ordering when comparing expected and actual items.
    """
    if isinstance(obj, dict):
        return {k: sort_dynamodb_json_lists(v) for k, v in obj.items()}
    elif isinstance(obj, list):
        try:
            return sorted(obj)  # Sort lists for consistent comparison
        except TypeError:
            return obj  # Not all lists are sortable; ex. complex_item_ddb's "list" attribute
    return obj


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
def paginate_scan_request(expect_standard_dictionaries, encrypted, test_item):
    if expect_standard_dictionaries:
        request = {**basic_scan_request_dict(test_item), "TableName": INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME}
    else:
        request = basic_scan_request_ddb(test_item)
    if encrypted:
        request["FilterExpression"] = request["FilterExpression"] + " AND attribute_exists (#sig)"
        request["ExpressionAttributeNames"] = {}
        request["ExpressionAttributeNames"]["#sig"] = "amzn-ddb-map-sig"
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


# TODO: set up scan table and tests

# @pytest.fixture
# def default_requests(simple_item_ddb):
#     """Fixture to provide default scan and query requests."""
#     return {
#         "scan": get_scan_request(simple_item_ddb["partition_key"]),
#         "query": get_query_request(simple_item_ddb["partition_key"]),
#     }

# @pytest.fixture(scope="module", autouse=True)
# def setup_module_fixture(simple_item_ddb):
#     # Runs before all tests in this module
#     for i in range(10):
#         ENCRYPTED_CLIENT.put_item(
#             TableName=INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME,
#             Item={
#                 "partition_key": simple_item_ddb["partition_key"],
#                 "sort_key": {"N": str(i)},
#                 "attribute1": {"S": "encrypt and sign me!"},
#                 "attribute2": {"S": "sign me!"},
#                 ":attribute3": {"S": "ignore me!"},
#             },
#         )
#     # Yield to all tests in this module
#     yield
#     # TODO: Delete items? not needed but nice

# @pytest.mark.parametrize("paginator_name, request_key", [
#     ("scan", "scan"),
#     ("query", "query")
# ])
# def test_GIVEN_incomplete_search_WHEN_build_full_result_THEN_NextToken_completes_search(
#     paginator_name,
#     request_key,
#     default_requests,
# ):
#     # TODO: test
#     return
#     # Given: PaginationConfig that will result in an incomplete search.
#     # There are 10 items, and returning 2 per operation results in multiple uses of NextToken.
#     pagination_config = {
#         "MaxItems": 2,
#     }

#     paginator = getattr(ENCRYPTED_CLIENT, f"get_paginator")(paginator_name)
#     incomplete_search_request = default_requests[request_key].copy()
#     incomplete_search_request["PaginationConfig"] = pagination_config

#     # When: Build full result from paginator
#     full_result = paginator.paginate(**incomplete_search_request)

#     print(f"{full_result=}")

#     collected_items = []

#     print(f'{full_result=}')

#     for item in full_result:
#         # assert item["attribute1"]["S"] == "encrypt and sign me!"
#         collected_items.append(item)

#     # Then: NextToken should be present
#     # assert "NextToken" in full_result
#     # Then: NextToken is able to complete the search
