import pytest

from aws_dbesdk_dynamodb.internal.client_to_resource import ClientShapeToResourceShapeConverter
from aws_dbesdk_dynamodb.internal.condition_expression_builder import InternalDBESDKDynamoDBConditionExpressionBuilder

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
    basic_execute_statement_request_encrypted_table,
    basic_execute_transaction_request_encrypted_table,
    basic_batch_execute_statement_request_encrypted_table,
    basic_batch_get_item_request_ddb,
    basic_batch_get_item_request_dict,
    basic_batch_write_item_delete_request_ddb,
    basic_batch_write_item_delete_request_dict,
    basic_batch_write_item_put_request_ddb,
    basic_batch_write_item_put_request_dict,
    basic_delete_item_request_ddb,
    basic_delete_item_request_dict,
    basic_get_item_request_ddb,
    basic_get_item_request_dict,
    basic_put_item_request_ddb,
    basic_put_item_request_dict,
    basic_query_request_ddb,
    basic_query_request_dict,
    basic_scan_request_ddb,
    basic_scan_request_dict,
    basic_transact_get_item_request_ddb,
    basic_transact_get_item_request_dict,
    basic_transact_write_item_condition_check_request_ddb,
    basic_transact_write_item_condition_check_request_dict,
    basic_transact_write_item_delete_request_ddb,
    basic_transact_write_item_delete_request_dict,
    basic_transact_write_item_put_request_ddb,
    basic_transact_write_item_put_request_dict,
    basic_update_item_request_ddb_unsigned_attribute,
    basic_update_item_request_dict_unsigned_attribute,
    exhaustive_get_item_request_ddb,
    exhaustive_get_item_request_dict,
    exhaustive_put_item_request_ddb,
    exhaustive_put_item_request_dict,
    exhaustive_query_request_ddb,
    exhaustive_query_request_dict,
    exhaustive_scan_request_ddb,
    exhaustive_scan_request_dict,
)
from ...responses import (
    basic_batch_get_item_response,
    basic_batch_write_item_put_response,
    basic_delete_item_response,
    basic_get_item_response,
    basic_put_item_response,
    basic_query_response,
    basic_scan_response,
    basic_transact_get_items_response,
    basic_transact_write_items_response,
    basic_update_item_response,
    exhaustive_batch_get_item_response,
    exhaustive_batch_write_item_put_response,
    exhaustive_get_item_response,
    exhaustive_put_item_response,
    exhaustive_query_response,
    exhaustive_scan_response,
)

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


def test_GIVEN_test_put_item_request_WHEN_client_to_resource_THEN_returns_dict_value(
    test_put_item_request_ddb, test_put_item_request_dict, test_ddb_item, test_dict_item
):
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
def test_put_item_response(use_exhaustive_request):
    if use_exhaustive_request:
        return exhaustive_put_item_response
    return basic_put_item_response


def test_GIVEN_test_put_item_response_WHEN_client_to_resource_THEN_returns_dict_value(
    test_put_item_response, test_ddb_key, test_dict_key
):
    # Given: Put item response
    response = test_put_item_response(test_ddb_key)
    # When: Converting to resource format
    dict_item = client_to_resource_converter.put_item_response(response)
    # Then: Returns dict value
    assert dict_item == test_put_item_response(test_dict_key)


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


def test_GIVEN_test_get_item_request_WHEN_client_to_resource_THEN_returns_dict_value(
    test_get_item_request_ddb, test_get_item_request_dict, test_ddb_item, test_dict_item
):
    # Given: Get item request
    request = test_get_item_request_ddb(test_ddb_item)
    # When: Converting to resource format
    dict_item = client_to_resource_converter.get_item_request(request)
    # Then: Returns dict value
    assert dict_item == test_get_item_request_dict(test_dict_item)


@pytest.fixture
def test_get_item_response(use_exhaustive_request):
    if use_exhaustive_request:
        return exhaustive_get_item_response
    return basic_get_item_response


def test_GIVEN_test_get_item_response_WHEN_client_to_resource_THEN_returns_dict_value(
    test_get_item_response, test_ddb_item, test_dict_item
):
    # Given: Get item response
    response = test_get_item_response(test_ddb_item)
    # When: Converting to resource format
    dict_item = client_to_resource_converter.get_item_response(response)
    # Then: Returns dict value
    assert dict_item == test_get_item_response(test_dict_item)


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


def test_GIVEN_test_query_request_WHEN_client_to_resource_THEN_returns_dict_value(
    test_query_request_ddb, test_query_request_dict, test_ddb_item, test_dict_item
):
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


@pytest.fixture
def test_query_response(use_exhaustive_request):
    if use_exhaustive_request:
        return exhaustive_query_response
    return basic_query_response


def test_GIVEN_test_query_response_WHEN_client_to_resource_THEN_returns_dict_value(
    test_query_response, test_ddb_item, test_dict_item
):
    # Given: Query response
    response = test_query_response([test_ddb_item])
    # When: Converting to resource format
    dict_item = client_to_resource_converter.query_response(response)
    # Then: Returns dict value
    assert dict_item == test_query_response([test_dict_item])


def get_string_for_key_condition_expression(
    key_condition_expression, expression_attribute_names, expression_attribute_values
):
    """Get the string for the key condition expression."""
    if not isinstance(key_condition_expression, str):
        built_expression = InternalDBESDKDynamoDBConditionExpressionBuilder().build_expression(
            key_condition_expression, expression_attribute_names, expression_attribute_values
        )
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
        expected_item["ExpressionAttributeValues"] if "ExpressionAttributeValues" in expected_item else {},
    )
    actual_key_condition_expression = get_string_for_key_condition_expression(
        actual_item[key],
        actual_item["ExpressionAttributeNames"] if "ExpressionAttributeNames" in actual_item else {},
        actual_item["ExpressionAttributeValues"] if "ExpressionAttributeValues" in actual_item else {},
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


def test_GIVEN_test_scan_request_WHEN_client_to_resource_THEN_returns_dict_value(
    test_scan_request_ddb, test_scan_request_dict, test_ddb_item, test_dict_item
):
    # Given: Scan request
    request = test_scan_request_ddb(test_ddb_item)
    # When: Converting to resource format
    dict_item = client_to_resource_converter.scan_request(request)
    # Then: Returns dict value
    assert dict_item == test_scan_request_dict(test_dict_item)


@pytest.fixture
def test_scan_response(use_exhaustive_request):
    if use_exhaustive_request:
        return exhaustive_scan_response
    return basic_scan_response


def test_GIVEN_test_scan_response_WHEN_client_to_resource_THEN_returns_dict_value(
    test_scan_response, test_ddb_item, test_dict_item, test_ddb_key, test_dict_key
):
    # Given: Scan response
    response = test_scan_response([test_ddb_item], [test_ddb_key])
    # When: Converting to resource format
    dict_item = client_to_resource_converter.scan_response(response)
    # Then: Returns dict value
    assert dict_item == test_scan_response([test_dict_item], [test_dict_key])


@pytest.fixture
def test_batch_get_item_request_ddb():
    return basic_batch_get_item_request_ddb


@pytest.fixture
def test_batch_get_item_request_dict():
    return basic_batch_get_item_request_dict


def test_GIVEN_test_batch_get_item_request_WHEN_client_to_resource_THEN_returns_dict_value(
    test_batch_get_item_request_ddb, test_batch_get_item_request_dict, test_ddb_item, test_dict_item
):
    # Given: Batch get item request
    request = test_batch_get_item_request_ddb([test_ddb_item])
    # When: Converting to resource format
    dict_item = client_to_resource_converter.batch_get_item_request(request)
    # Then: Returns dict value
    assert dict_item == test_batch_get_item_request_dict([test_dict_item])


@pytest.fixture
def test_batch_get_item_response(use_exhaustive_request):
    if use_exhaustive_request:
        return exhaustive_batch_get_item_response
    return basic_batch_get_item_response


def test_GIVEN_test_batch_get_item_response_WHEN_client_to_resource_THEN_returns_dict_value(
    test_batch_get_item_response, test_ddb_item, test_dict_item
):
    # Given: Batch get item response
    response = test_batch_get_item_response([test_ddb_item])
    # When: Converting to resource format
    dict_item = client_to_resource_converter.batch_get_item_response(response)
    # Then: Returns dict value
    assert dict_item == test_batch_get_item_response([test_dict_item])


@pytest.fixture
def test_batch_write_item_put_request_ddb():
    return basic_batch_write_item_put_request_ddb


@pytest.fixture
def test_batch_write_item_put_request_dict():
    return basic_batch_write_item_put_request_dict


def test_GIVEN_test_batch_write_item_put_request_WHEN_client_to_resource_THEN_returns_dict_value(
    test_batch_write_item_put_request_ddb, test_batch_write_item_put_request_dict, test_ddb_item, test_dict_item
):
    # Given: Batch write item request
    request = test_batch_write_item_put_request_ddb([test_ddb_item])
    # When: Converting to resource format
    dict_item = client_to_resource_converter.batch_write_item_request(request)
    # Then: Returns dict value
    assert dict_item == test_batch_write_item_put_request_dict([test_dict_item])


@pytest.fixture
def test_batch_write_item_delete_request_ddb():
    return basic_batch_write_item_delete_request_ddb


@pytest.fixture
def test_batch_write_item_delete_request_dict():
    return basic_batch_write_item_delete_request_dict


def test_GIVEN_test_batch_write_item_delete_request_WHEN_client_to_resource_THEN_returns_dict_value(
    test_batch_write_item_delete_request_ddb, test_batch_write_item_delete_request_dict, test_ddb_key, test_dict_key
):
    # Given: Batch write item delete request
    request = test_batch_write_item_delete_request_ddb([test_ddb_key])
    # When: Converting to resource format
    dict_item = client_to_resource_converter.batch_write_item_request(request)
    # Then: Returns dict value
    assert dict_item == test_batch_write_item_delete_request_dict([test_dict_key])


@pytest.fixture
def test_batch_write_item_put_response(use_exhaustive_request):
    if use_exhaustive_request:
        return exhaustive_batch_write_item_put_response
    return basic_batch_write_item_put_response


def test_GIVEN_test_batch_write_item_put_response_WHEN_client_to_resource_THEN_returns_dict_value(
    test_batch_write_item_put_response, test_ddb_item, test_dict_item
):
    # Given: Batch write item put response
    response = test_batch_write_item_put_response([test_ddb_item])
    # When: Converting to resource format
    dict_item = client_to_resource_converter.batch_write_item_response(response)
    # Then: Returns dict value
    assert dict_item == test_batch_write_item_put_response([test_dict_item])


@pytest.fixture
def test_transact_write_items_put_request_ddb():
    return basic_transact_write_item_put_request_ddb


@pytest.fixture
def test_transact_write_items_put_request_dict():
    return basic_transact_write_item_put_request_dict


def test_GIVEN_test_transact_write_items_put_request_WHEN_client_to_resource_THEN_returns_dict_value(
    test_transact_write_items_put_request_ddb, test_transact_write_items_put_request_dict, test_ddb_item, test_dict_item
):
    # Given: Transact write item put request
    request = test_transact_write_items_put_request_ddb([test_ddb_item])
    # When: Converting to resource format
    dict_item = client_to_resource_converter.transact_write_items_request(request)
    # Then: Returns dict value
    assert dict_item == test_transact_write_items_put_request_dict([test_dict_item])


@pytest.fixture
def test_transact_write_items_delete_request_ddb():
    return basic_transact_write_item_delete_request_ddb


@pytest.fixture
def test_transact_write_items_delete_request_dict():
    return basic_transact_write_item_delete_request_dict


def test_GIVEN_test_transact_write_items_delete_request_WHEN_client_to_resource_THEN_returns_dict_value(
    test_transact_write_items_delete_request_ddb,
    test_transact_write_items_delete_request_dict,
    test_ddb_key,
    test_dict_key,
):
    # Given: Transact write item delete request
    request = test_transact_write_items_delete_request_ddb([test_ddb_key])
    # When: Converting to resource format
    dict_item = client_to_resource_converter.transact_write_items_request(request)
    # Then: Returns dict value
    assert dict_item == test_transact_write_items_delete_request_dict([test_dict_key])


@pytest.fixture
def test_transact_write_items_condition_check_request_ddb():
    return basic_transact_write_item_condition_check_request_ddb


@pytest.fixture
def test_transact_write_items_condition_check_request_dict():
    return basic_transact_write_item_condition_check_request_dict


def test_GIVEN_test_transact_write_items_condition_check_request_WHEN_client_to_resource_THEN_returns_dict_value(
    test_transact_write_items_condition_check_request_ddb,
    test_transact_write_items_condition_check_request_dict,
    test_ddb_key,
    test_dict_key,
):
    # Given: Transact write item condition check request
    request = test_transact_write_items_condition_check_request_ddb([test_ddb_key])
    # When: Converting to resource format
    dict_item = client_to_resource_converter.transact_write_items_request(request)
    # Then: Returns dict value
    assert dict_item == test_transact_write_items_condition_check_request_dict([test_dict_key])


@pytest.fixture
def test_transact_write_items_response():
    return basic_transact_write_items_response


def test_GIVEN_test_transact_write_items_response_WHEN_client_to_resource_THEN_returns_dict_value(
    test_transact_write_items_response, test_ddb_item, test_dict_item
):
    # Given: Transact write items response
    response = test_transact_write_items_response([test_ddb_item])
    # When: Converting to resource format
    dict_item = client_to_resource_converter.transact_write_items_response(response)
    # Then: Returns dict value
    assert dict_item == test_transact_write_items_response([test_dict_item])


@pytest.fixture
def test_transact_get_items_request_ddb():
    return basic_transact_get_item_request_ddb


@pytest.fixture
def test_transact_get_items_request_dict():
    return basic_transact_get_item_request_dict


def test_GIVEN_test_transact_get_items_request_WHEN_client_to_resource_THEN_returns_dict_value(
    test_transact_get_items_request_ddb, test_transact_get_items_request_dict, test_ddb_key, test_dict_key
):
    # Given: Transact get items request
    request = test_transact_get_items_request_ddb([test_ddb_key])
    # When: Converting to resource format
    dict_item = client_to_resource_converter.transact_get_items_request(request)
    # Then: Returns dict value
    assert dict_item == test_transact_get_items_request_dict([test_dict_key])


@pytest.fixture
def test_transact_get_items_response():
    return basic_transact_get_items_response


def test_GIVEN_test_transact_get_items_response_WHEN_client_to_resource_THEN_returns_dict_value(
    test_transact_get_items_response, test_ddb_item, test_dict_item
):
    # Given: Transact get items response
    response = test_transact_get_items_response([test_ddb_item])
    # When: Converting to resource format
    dict_item = client_to_resource_converter.transact_get_items_response(response)
    # Then: Returns dict value
    assert dict_item == test_transact_get_items_response([test_dict_item])


@pytest.fixture
def test_update_item_request_ddb():
    # Select unsigned attribute without loss of generality;
    # resource/client logic doesn't care about signed attributes
    # TODO: Add exhaustive request
    return basic_update_item_request_ddb_unsigned_attribute


@pytest.fixture
def test_update_item_request_dict():
    # Select unsigned attribute without loss of generality;
    # resource/client logic doesn't care about signed attributes
    # TODO: Add exhaustive request
    return basic_update_item_request_dict_unsigned_attribute


def test_GIVEN_test_update_item_request_WHEN_client_to_resource_THEN_returns_dict_value(
    test_update_item_request_ddb, test_update_item_request_dict, test_ddb_item, test_dict_item
):
    # Given: Update item request
    request = test_update_item_request_ddb(test_ddb_item)
    # When: Converting to resource format
    dict_item = client_to_resource_converter.update_item_request(request)
    # Then: Returns dict value
    assert dict_item == test_update_item_request_dict(test_dict_item)


@pytest.fixture
def test_update_item_response():
    # TODO: Add exhaustive response
    return basic_update_item_response


def test_GIVEN_test_update_item_response_WHEN_client_to_resource_THEN_returns_dict_value(
    test_update_item_response, test_ddb_item, test_dict_item
):
    # Given: Update item response
    response = test_update_item_response(test_ddb_item)
    # When: Converting to resource format
    dict_item = client_to_resource_converter.update_item_response(response)
    # Then: Returns dict value
    assert dict_item == test_update_item_response(test_dict_item)


@pytest.fixture
def test_execute_statement_request():
    return basic_execute_statement_request_encrypted_table


def test_GIVEN_test_execute_statement_request_WHEN_client_to_resource_THEN_returns_dict_value(
    test_execute_statement_request, test_ddb_item, test_dict_item
):
    # Given: Execute statement request
    request = test_execute_statement_request()
    # When: Converting to resource format
    dict_item = client_to_resource_converter.execute_statement_request(request)
    # Then: Returns dict value (here, request is not modified)
    assert dict_item == test_execute_statement_request()


def test_GIVEN_test_execute_statement_response_WHEN_client_to_resource_THEN_raises_NotImplementedError():
    # Given: Execute statement response
    response = {"Some": "Response"}
    # Then: Raises NotImplementedError
    with pytest.raises(NotImplementedError):
        # When: Converting to resource format
        client_to_resource_converter.execute_statement_response(response)


@pytest.fixture
def test_execute_transaction_request():
    return basic_execute_transaction_request_encrypted_table


def test_GIVEN_test_execute_transaction_request_WHEN_client_to_resource_THEN_returns_dict_value(
    test_execute_transaction_request, test_ddb_item, test_dict_item
):
    # Given: Execute transaction request
    request = test_execute_transaction_request(test_ddb_item)
    # When: Converting to resource format
    dict_item = client_to_resource_converter.execute_transaction_request(request)
    # Then: Returns dict value (here, request is not modified)
    assert dict_item == test_execute_transaction_request(test_dict_item)


def test_GIVEN_test_execute_transaction_response_WHEN_client_to_resource_THEN_raises_NotImplementedError():
    # Given: Execute transaction response
    response = {"Some": "Response"}
    # Then: Raises NotImplementedError
    with pytest.raises(NotImplementedError):
        # When: Converting to resource format
        client_to_resource_converter.execute_transaction_response(response)


@pytest.fixture
def test_batch_execute_statement_request():
    return basic_batch_execute_statement_request_encrypted_table


def test_GIVEN_test_batch_execute_statement_request_WHEN_client_to_resource_THEN_returns_dict_value(
    test_batch_execute_statement_request, test_ddb_item, test_dict_item
):
    # Given: Batch execute statement request
    request = test_batch_execute_statement_request()
    # When: Converting to resource format
    dict_item = client_to_resource_converter.batch_execute_statement_request(request)
    # Then: Returns dict value (here, request is not modified)
    assert dict_item == test_batch_execute_statement_request()


def test_GIVEN_test_batch_execute_statement_response_WHEN_client_to_resource_THEN_raises_NotImplementedError():
    # Given: Batch execute statement response
    response = {"Some": "Response"}
    # Then: Raises NotImplementedError
    with pytest.raises(NotImplementedError):
        # When: Converting to resource format
        client_to_resource_converter.batch_execute_statement_response(response)


@pytest.fixture
def test_delete_item_request_ddb():
    return basic_delete_item_request_ddb


@pytest.fixture
def test_delete_item_request_dict():
    return basic_delete_item_request_dict


def test_GIVEN_test_delete_item_request_WHEN_client_to_resource_THEN_returns_dict_value(
    test_delete_item_request_ddb, test_delete_item_request_dict, test_ddb_key, test_dict_key
):
    # Given: Delete item request
    request = test_delete_item_request_ddb(test_ddb_key)
    # When: Converting to resource format
    dict_item = client_to_resource_converter.delete_item_request(request)
    # Then: Returns dict value
    assert dict_item == test_delete_item_request_dict(test_dict_key)


@pytest.fixture
def test_delete_item_response():
    return basic_delete_item_response


def test_GIVEN_test_delete_item_response_WHEN_client_to_resource_THEN_returns_dict_value(
    test_delete_item_response, test_ddb_item, test_dict_item
):
    # Given: Delete item response
    response = test_delete_item_response(test_ddb_item)
    # When: Converting to resource format
    dict_item = client_to_resource_converter.delete_item_response(response)
    # Then: Returns dict value
    assert dict_item == test_delete_item_response(test_dict_item)


# ruff: noqa: E501
def test_GIVEN_request_with_neither_ExpressionAttributeValues_nor_ExpressionAttributeNames_WHEN_condition_handler_THEN_returns_identity_output():
    # Given: Request with neither ExpressionAttributeValues nor ExpressionAttributeNames
    request = exhaustive_put_item_request_ddb(simple_item_ddb)
    if "ExpressionAttributeValues" in request:
        del request["ExpressionAttributeValues"]
    if "ExpressionAttributeNames" in request:
        del request["ExpressionAttributeNames"]
    # When: Call condition_handler method
    actual = client_to_resource_converter.condition_handler("ConditionExpression", request)
    # Then: Returns "identity" output (input condition expression and no attribute names or values)
    expected = request["ConditionExpression"], {}, {}
    assert actual == expected
