from ...ddb_formatted_requests import (
    basic_put_item_request_ddb_simple_item,
    basic_put_item_request_ddb_complex_item,
    exhaustive_put_item_request_ddb_simple_item,
    exhaustive_put_item_request_ddb_complex_item,
    basic_get_item_request_ddb_simple_item,
    basic_get_item_request_ddb_complex_item,
    exhaustive_get_item_request_ddb_simple_item,
    exhaustive_get_item_request_ddb_complex_item,
)
from ...dict_formatted_requests import (
    basic_put_item_request_dict_simple_item,
    basic_put_item_request_dict_complex_item,
    exhaustive_put_item_request_dict_simple_item,
    exhaustive_put_item_request_dict_complex_item,
    basic_get_item_request_dict_simple_item,
    basic_get_item_request_dict_complex_item,
    exhaustive_get_item_request_dict_simple_item,
    exhaustive_get_item_request_dict_complex_item,
)
from ...items import *
from aws_database_encryption_sdk.internal.client_to_resource import ClientShapeToResourceShapeConverter
import pytest

converter = ClientShapeToResourceShapeConverter()

@pytest.mark.parametrize(
    "ddb_item_fixture_name,dict_item_fixture_name,test_name",
    [
        (
            "basic_put_item_request_ddb_simple_item",
            "basic_put_item_request_dict_simple_item",
            "basic simple item"
        ),
        (
            "basic_put_item_request_ddb_complex_item",
            "basic_put_item_request_dict_complex_item",
            "basic complex item"
        ),
        (
            "exhaustive_put_item_request_ddb_simple_item",
            "exhaustive_put_item_request_dict_simple_item",
            "exhaustive simple item"
        ),
        (
            "exhaustive_put_item_request_ddb_complex_item",
            "exhaustive_put_item_request_dict_complex_item",
            "exhaustive complex item"
        ),
    ]
)
def test_GIVEN_put_item_request_WHEN_client_to_resource_THEN_returns_dict_value(
    request,
    ddb_item_fixture_name,
    dict_item_fixture_name,
    test_name,
):
    """Test that client-to-resource conversion works for put_item requests.
    
    Args:
        request: The pytest request object to access fixtures
        ddb_fixture_name: Name of the fixture containing the DynamoDB-formatted request
        expected_dict_fixture_name: Name of the fixture containing the expected resource-formatted request
        test_name: A descriptive name for this test case
    """
    # Get the actual fixture values
    ddb_request = request.getfixturevalue(ddb_item_fixture_name)
    expected_dict_request = request.getfixturevalue(dict_item_fixture_name)

    # When: Converting to resource format
    dict_item = converter.put_item_request(ddb_request)

    # Then: Returns dict value
    # For exhaustive requests, we need to handle ConditionExpression separately
    # since it keeps the original DDB-formatted string
    for key in dict_item.keys():
        if key != "ConditionExpression":
            assert dict_item[key] == expected_dict_request[key]

@pytest.mark.parametrize(
    "ddb_item_fixture_name,dict_item_fixture_name,test_name",
    [
        (
            "basic_get_item_request_ddb_simple_item",
            "basic_get_item_request_dict_simple_item",
            "basic simple item"
        ),
        (
            "basic_get_item_request_ddb_complex_item",
            "basic_get_item_request_dict_complex_item",
            "basic complex item"
        ),
        (
            "exhaustive_get_item_request_ddb_simple_item",
            "exhaustive_get_item_request_dict_simple_item",
            "exhaustive simple item"
        ),
        (
            "exhaustive_get_item_request_ddb_complex_item",
            "exhaustive_get_item_request_dict_complex_item",
            "exhaustive complex item"
        ),
    ]
)
def test_GIVEN_get_item_request_WHEN_client_to_resource_THEN_returns_dict_value(
    request,
    ddb_item_fixture_name,
    dict_item_fixture_name,
    test_name,
):
    """Test that client-to-resource conversion works for get_item requests.
    
    Args:
        request: The pytest request object to access fixtures
        ddb_fixture_name: Name of the fixture containing the DynamoDB-formatted request
        expected_dict_fixture_name: Name of the fixture containing the expected resource-formatted request
        test_name: A descriptive name for this test case
    """
    # Get the actual fixture values
    ddb_request = request.getfixturevalue(ddb_item_fixture_name)
    expected_dict_request = request.getfixturevalue(dict_item_fixture_name)

    # When: Converting to resource format
    dict_item = converter.get_item_request(ddb_request)

    # Then: Returns dict value
    assert dict_item == expected_dict_request
