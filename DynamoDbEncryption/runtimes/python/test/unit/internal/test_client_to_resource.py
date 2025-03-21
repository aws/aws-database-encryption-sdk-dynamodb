from ...ddb_formatted_requests import (
    basic_put_item_request_ddb,
    exhaustive_put_item_request_ddb,
    basic_get_item_request_ddb,
    exhaustive_get_item_request_ddb,
    basic_query_request_ddb,
    exhaustive_query_request_ddb,
    basic_scan_request_ddb,
    exhaustive_scan_request_ddb,
)
from ...dict_formatted_requests import (
    basic_put_item_request_dict,
    exhaustive_put_item_request_dict,
    basic_get_item_request_dict,
    exhaustive_get_item_request_dict,
    basic_query_request_dict,
    exhaustive_query_request_dict,
    basic_scan_request_dict,
    exhaustive_scan_request_dict,
)
from ...items import *
from aws_database_encryption_sdk.internal.client_to_resource import ClientShapeToResourceShapeConverter
import pytest
from aws_database_encryption_sdk.internal.condition_expression_builder import InternalDBESDKDynamoDBConditionExpressionBuilder

client_to_resource_converter = ClientShapeToResourceShapeConverter()

@pytest.fixture(params=[True, False], ids=["complex_item", "simple_item"])
def use_complex_item(request):
    return request.param

@pytest.fixture
def test_ddb_item(use_complex_item):
    """Get a single test item in the appropriate format for the client."""
    if use_complex_item:
        return complex_item_ddb
    return simple_item_ddb

@pytest.fixture
def test_dict_item(use_complex_item):
    """Get a single test item in the appropriate format for the client."""
    if use_complex_item:
        return complex_item_dict
    return simple_item_dict

@pytest.fixture
def test_ddb_key(use_complex_item):
    """Get a single test item in the appropriate format for the client."""
    if use_complex_item:
        return complex_key_ddb
    return simple_key_ddb

@pytest.fixture
def test_dict_key(use_complex_item):
    """Get a single test item in the appropriate format for the client."""
    if use_complex_item:
        return complex_key_dict
    return simple_key_dict

@pytest.fixture(params=[True, False], ids=["exhaustive_request", "basic_request"])
def use_exhaustive_request(request):
    return request.param

@pytest.fixture
def test_put_item_request_ddb(use_exhaustive_request):
    if use_exhaustive_request:
        return exhaustive_put_item_request_ddb
    return basic_put_item_request_ddb

@pytest.fixture
def test_put_item_request_dict(use_exhaustive_request):
    if use_exhaustive_request:
        return exhaustive_put_item_request_dict
    return basic_put_item_request_dict

def test_GIVEN_test_put_item_request_WHEN_client_to_resource_THEN_returns_dict_value(test_put_item_request_ddb, test_put_item_request_dict, test_ddb_item, test_dict_item):
    # Given: Put item request
    request = test_put_item_request_ddb(test_ddb_item)
    # When: Converting to resource format
    dict_item = client_to_resource_converter.put_item_request(request)
    # Then: Returns dict value
    # For exhaustive requests, we need to handle ConditionExpression separately
    # since it keeps the original DDB-formatted string
    expected_dict_request = test_put_item_request_dict(test_dict_item)
    for key in dict_item.keys():
        if key != "ConditionExpression":
            assert dict_item[key] == expected_dict_request[key]

@pytest.fixture
def test_get_item_request_ddb(use_exhaustive_request):
    if use_exhaustive_request:
        return exhaustive_get_item_request_ddb
    return basic_get_item_request_ddb

@pytest.fixture
def test_get_item_request_dict(use_exhaustive_request):
    if use_exhaustive_request:
        return exhaustive_get_item_request_dict
    return basic_get_item_request_dict

def test_GIVEN_test_get_item_request_WHEN_client_to_resource_THEN_returns_dict_value(test_get_item_request_ddb, test_get_item_request_dict, test_ddb_item, test_dict_item):
    # Given: Get item request
    request = test_get_item_request_ddb(test_ddb_item)
    # When: Converting to resource format
    dict_item = client_to_resource_converter.get_item_request(request)
    # Then: Returns dict value
    assert dict_item == test_get_item_request_dict(test_dict_item)

@pytest.fixture
def test_query_request_ddb(use_exhaustive_request):
    if use_exhaustive_request:
        return exhaustive_query_request_ddb
    return basic_query_request_ddb

@pytest.fixture
def test_query_request_dict(use_exhaustive_request):
    if use_exhaustive_request:
        return exhaustive_query_request_dict
    return basic_query_request_dict

def test_GIVEN_test_query_request_WHEN_client_to_resource_THEN_returns_dict_value(test_query_request_ddb, test_query_request_dict, test_ddb_item, test_dict_item):
    # Given: Query request
    request = test_query_request_ddb(test_ddb_item)
    # When: Converting to resource format
    dict_item = client_to_resource_converter.query_request(request)
    # Then: Returns dict value
    for key in dict_item.keys():
        if key == "KeyConditionExpression":
            assert_condition_expressions_are_equal(test_query_request_dict(test_dict_item), dict_item, key)
        else:
            assert dict_item[key] == test_query_request_dict(test_dict_item)[key]

def get_string_for_key_condition_expression(key_condition_expression, expression_attribute_names, expression_attribute_values):
    """Get the string for the key condition expression."""
    if not isinstance(key_condition_expression, str):
        built_expression = InternalDBESDKDynamoDBConditionExpressionBuilder().build_expression(key_condition_expression, expression_attribute_names, expression_attribute_values)
        key_condition_expression = built_expression.condition_expression
        expression_attribute_names = built_expression.attribute_name_placeholders
        expression_attribute_values = built_expression.attribute_value_placeholders
    for expression_attribute_name, value in expression_attribute_names.items():
        key_condition_expression = key_condition_expression.replace(expression_attribute_name, str(value))
    for expression_attribute_value, value in expression_attribute_values.items():
        key_condition_expression = key_condition_expression.replace(expression_attribute_value, str(value))
    return key_condition_expression

def assert_condition_expressions_are_equal(expected_item, actual_item, key):
    expected_key_condition_expression = get_string_for_key_condition_expression(
        expected_item[key],
        expected_item["ExpressionAttributeNames"] if "ExpressionAttributeNames" in expected_item else {},
        expected_item["ExpressionAttributeValues"] if "ExpressionAttributeValues" in expected_item else {}
        )
    actual_key_condition_expression = get_string_for_key_condition_expression(
        actual_item[key],
        actual_item["ExpressionAttributeNames"] if "ExpressionAttributeNames" in actual_item else {},
        actual_item["ExpressionAttributeValues"] if "ExpressionAttributeValues" in actual_item else {}
        )
    assert expected_key_condition_expression == actual_key_condition_expression

@pytest.fixture
def test_scan_request_ddb(use_exhaustive_request):
    if use_exhaustive_request:
        return exhaustive_scan_request_ddb
    return basic_scan_request_ddb

@pytest.fixture
def test_scan_request_dict(use_exhaustive_request):
    if use_exhaustive_request:
        return exhaustive_scan_request_dict
    return basic_scan_request_dict

def test_GIVEN_test_scan_request_WHEN_client_to_resource_THEN_returns_dict_value(test_scan_request_ddb, test_scan_request_dict, test_ddb_item, test_dict_item):
    # Given: Scan request
    request = test_scan_request_ddb(test_ddb_item)
    # When: Converting to resource format
    dict_item = client_to_resource_converter.scan_request(request)
    # Then: Returns dict value
    assert dict_item == test_scan_request_dict(test_dict_item)

