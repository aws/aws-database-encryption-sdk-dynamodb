from ...requests import (
    basic_put_item_request_ddb,
    exhaustive_put_item_request_ddb,
    basic_get_item_request_ddb,
    exhaustive_get_item_request_ddb,
    basic_query_request_ddb,
    exhaustive_query_request_ddb,
    basic_scan_request_ddb,
    exhaustive_scan_request_ddb,
    basic_batch_get_item_request_ddb,
    basic_batch_write_item_put_request_ddb,
    basic_batch_write_item_delete_request_ddb,
    basic_transact_write_item_put_request_ddb,
    basic_transact_write_item_delete_request_ddb,
    basic_transact_write_item_condition_check_request_ddb,
    basic_transact_get_item_request_ddb,
)
from ...requests import (
    basic_put_item_request_dict,
    exhaustive_put_item_request_dict,
    basic_get_item_request_dict,
    exhaustive_get_item_request_dict,
    basic_query_request_dict,
    exhaustive_query_request_dict,
    basic_scan_request_dict,
    exhaustive_scan_request_dict,
    basic_batch_get_item_request_dict,
    basic_batch_write_item_put_request_dict,
    basic_batch_write_item_delete_request_dict,
    basic_transact_write_item_put_request_dict,
    basic_transact_write_item_delete_request_dict,
    basic_transact_write_item_condition_check_request_dict,
    basic_transact_get_item_request_dict,
)
from ...responses import (
    basic_query_response,
    basic_scan_response,
    exhaustive_scan_response,
    basic_put_item_response,
    exhaustive_put_item_response,
    basic_get_item_response,
    exhaustive_get_item_response,
    exhaustive_query_response,
    basic_batch_get_item_response,
    exhaustive_batch_get_item_response,
    basic_batch_write_item_put_response,
    exhaustive_batch_write_item_put_response,
    basic_transact_write_items_response,
    basic_transact_get_items_response,
)
from ...items import *
from aws_dbesdk_dynamodb.internal.resource_to_client import ResourceShapeToClientShapeConverter
import pytest
from aws_dbesdk_dynamodb.internal.condition_expression_builder import InternalDBESDKDynamoDBConditionExpressionBuilder
from ...constants import INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME

resource_to_client_converter = ResourceShapeToClientShapeConverter(table_name=INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME)


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


def sort_dynamodb_json_lists(obj):
    """Utility that recursively sorts all lists in a DynamoDB JSON-like structure.
    DynamoDB JSON uses lists to represent sets, so strict equality can fail.
    Sort lists to ensure consistent ordering when comparing expected and actual items."""
    if isinstance(obj, dict):
        return {k: sort_dynamodb_json_lists(v) for k, v in obj.items()}
    elif isinstance(obj, list):
        try:
            a = sorted(obj)  # Sort lists for consistent comparison
            return a
        except TypeError:
            return obj  # Not all lists are sortable; ex. complex_item_ddb's "list" attribute
    return obj


def test_GIVEN_test_put_item_request_WHEN_resource_to_client_THEN_returns_ddb_value(
    test_put_item_request_ddb, test_put_item_request_dict, test_ddb_item, test_dict_item
):
    # Given: Put item request
    request = test_put_item_request_dict(test_dict_item)
    # When: Converting to resource format
    ddb_item = resource_to_client_converter.put_item_request(request)
    # Then: Returns dict value
    # For exhaustive requests, we need to handle ConditionExpression separately
    # since it keeps the original DDB-formatted string
    expected_ddb_request = test_put_item_request_ddb(test_ddb_item)

    actual_ddb_request = sort_dynamodb_json_lists(ddb_item)
    expected_ddb_request = sort_dynamodb_json_lists(expected_ddb_request)

    for key in actual_ddb_request.keys():
        if key != "ConditionExpression":
            assert actual_ddb_request[key] == expected_ddb_request[key]


def test_GIVEN_put_item_request_without_table_name_WHEN_resource_to_client_THEN_raises_error(
    test_put_item_request_dict,
):
    # Given: ResourceShapeToClientShapeConverter without table name
    resource_to_client_converter_without_table_name = ResourceShapeToClientShapeConverter(table_name=None)
    # Given: Put item request without table name
    request = basic_put_item_request_dict(simple_item_dict)
    # When: Converting to resource format
    with pytest.raises(ValueError):
        resource_to_client_converter_without_table_name.put_item_request(request)


@pytest.fixture
def test_put_item_response(use_exhaustive_request):
    if use_exhaustive_request:
        return exhaustive_put_item_response
    return basic_put_item_response


def test_GIVEN_test_put_item_response_WHEN_resource_to_client_THEN_returns_ddb_value(
    test_put_item_response, test_ddb_key, test_dict_key
):
    # Given: Put item response
    response = test_put_item_response(test_dict_key)
    # When: Converting to resource format
    ddb_item = resource_to_client_converter.put_item_response(response)
    # Then: Returns dict value
    expected_ddb_response = test_put_item_response(test_ddb_key)
    assert ddb_item == expected_ddb_response


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


def test_GIVEN_test_get_item_request_WHEN_resource_to_client_THEN_returns_ddb_value(
    test_get_item_request_ddb, test_get_item_request_dict, test_ddb_item, test_dict_item
):
    # Given: Get item request
    request = test_get_item_request_dict(test_dict_item)
    # When: Converting to resource format
    ddb_item = resource_to_client_converter.get_item_request(request)
    # Then: Returns dict value
    expected_ddb_request = test_get_item_request_ddb(test_ddb_item)
    assert ddb_item == expected_ddb_request


def test_GIVEN_get_item_request_without_table_name_WHEN_resource_to_client_THEN_raises_error(
    test_get_item_request_dict,
):
    # Given: ResourceShapeToClientShapeConverter without table name
    resource_to_client_converter_without_table_name = ResourceShapeToClientShapeConverter(table_name=None)
    # Given: Get item request without table name
    request = basic_get_item_request_dict(simple_item_dict)
    # When: Converting to resource format
    with pytest.raises(ValueError):
        resource_to_client_converter_without_table_name.get_item_request(request)


@pytest.fixture
def test_get_item_response(use_exhaustive_request):
    if use_exhaustive_request:
        return exhaustive_get_item_response
    return basic_get_item_response


def test_GIVEN_test_get_item_response_WHEN_resource_to_client_THEN_returns_ddb_value(
    test_get_item_response, test_ddb_item, test_dict_item
):
    # Given: Get item response
    response = test_get_item_response(test_dict_item)
    # When: Converting to resource format
    ddb_item = resource_to_client_converter.get_item_response(response)
    # Then: Returns dict value
    expected_ddb_response = test_get_item_response(test_ddb_item)
    if "Item" in ddb_item:
        ddb_item["Item"] = sort_dynamodb_json_lists(ddb_item["Item"])
        expected_ddb_response["Item"] = sort_dynamodb_json_lists(expected_ddb_response["Item"])
    assert ddb_item == expected_ddb_response


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


def test_GIVEN_test_query_request_WHEN_resource_to_client_THEN_returns_ddb_value(
    test_query_request_ddb, test_query_request_dict, test_ddb_item, test_dict_item
):
    # Given: Query request
    dict_request = test_query_request_dict(test_dict_item)
    # When: Converting to resource format
    ddb_request = resource_to_client_converter.query_request(dict_request)
    # Then: Returns ddb value
    actual_ddb_request = ddb_request
    expected_ddb_request = test_query_request_ddb(test_ddb_item)

    try:
        for key in actual_ddb_request["ExpressionAttributeValues"].keys():
            actual_ddb_request["ExpressionAttributeValues"][key] = sort_dynamodb_json_lists(
                actual_ddb_request["ExpressionAttributeValues"][key]
            )
    except KeyError:
        pass

    try:
        for key in expected_ddb_request["ExpressionAttributeValues"].keys():
            expected_ddb_request["ExpressionAttributeValues"][key] = sort_dynamodb_json_lists(
                expected_ddb_request["ExpressionAttributeValues"][key]
            )
    except KeyError:
        pass

    try:
        for key in actual_ddb_request["QueryFilter"].keys():
            actual_ddb_request["QueryFilter"][key]["AttributeValueList"] = [
                sort_dynamodb_json_lists(item) for item in actual_ddb_request["QueryFilter"][key]["AttributeValueList"]
            ]
    except KeyError:
        pass

    try:
        for key in expected_ddb_request["QueryFilter"].keys():
            expected_ddb_request["QueryFilter"][key]["AttributeValueList"] = [
                sort_dynamodb_json_lists(item)
                for item in expected_ddb_request["QueryFilter"][key]["AttributeValueList"]
            ]
    except KeyError:
        pass

    try:
        for key in actual_ddb_request["ExclusiveStartKey"].keys():
            actual_ddb_request["ExclusiveStartKey"][key] = sort_dynamodb_json_lists(
                actual_ddb_request["ExclusiveStartKey"][key]
            )
    except KeyError:
        pass

    try:
        for key in expected_ddb_request["ExclusiveStartKey"].keys():
            expected_ddb_request["ExclusiveStartKey"][key] = sort_dynamodb_json_lists(
                expected_ddb_request["ExclusiveStartKey"][key]
            )
    except KeyError:
        pass

    try:
        for key in actual_ddb_request["KeyConditions"].keys():
            actual_ddb_request["KeyConditions"][key]["AttributeValueList"] = [
                sort_dynamodb_json_lists(item)
                for item in actual_ddb_request["KeyConditions"][key]["AttributeValueList"]
            ]
    except KeyError:
        pass

    try:
        for key in expected_ddb_request["KeyConditions"].keys():
            expected_ddb_request["KeyConditions"][key]["AttributeValueList"] = [
                sort_dynamodb_json_lists(item)
                for item in expected_ddb_request["KeyConditions"][key]["AttributeValueList"]
            ]
    except KeyError:
        pass

    for key in actual_ddb_request.keys():
        if key == "KeyConditionExpression":
            assert_condition_expressions_are_equal(expected_ddb_request, actual_ddb_request, key)
        elif key == "ExpressionAttributeValues":
            # Any values in expected_ddb_request MUST be in actual_ddb_request,
            # but not the other way around.
            # actual_ddb_request will generate attribute symbols as needed,
            # but any values in expected_ddb_request MUST be present in actual_ddb_request.
            if key in expected_ddb_request:
                for name, value in expected_ddb_request[key].items():
                    assert name in actual_ddb_request[key]
                    assert actual_ddb_request[key][name] == value
            else:
                # Keys in actual_ddb_request don't need to be in expected_ddb_request.
                pass
        elif key == "ExpressionAttributeNames":
            # Any keys in expected_ddb_request MUST be in actual_ddb_request,
            # but not the other way around.
            # actual_ddb_request will generate attribute symbols as needed,
            # but any keys in expected_ddb_request MUST be present in actual_ddb_request.
            if key in expected_ddb_request:
                for name, value in expected_ddb_request[key].items():
                    assert name in actual_ddb_request[key]
                    assert actual_ddb_request[key][name] == value
            else:
                # Keys in actual_ddb_request don't need to be in expected_ddb_request.
                pass
        else:
            assert actual_ddb_request[key] == expected_ddb_request[key]


def test_GIVEN_query_request_without_table_name_WHEN_resource_to_client_THEN_raises_error(test_query_request_dict):
    # Given: ResourceShapeToClientShapeConverter without table name
    resource_to_client_converter_without_table_name = ResourceShapeToClientShapeConverter(table_name=None)
    # Given: Query request without table name
    request = basic_query_request_dict(simple_item_dict)
    # When: Converting to resource format
    with pytest.raises(ValueError):
        resource_to_client_converter_without_table_name.query_request(request)


@pytest.fixture
def test_query_response(use_exhaustive_request):
    if use_exhaustive_request:
        return exhaustive_query_response
    return basic_query_response


def test_GIVEN_test_query_response_WHEN_resource_to_client_THEN_returns_ddb_value(
    test_query_response, test_ddb_item, test_dict_item
):
    # Given: Query response
    response = test_query_response([test_dict_item])
    # When: Converting to resource format
    ddb_item = resource_to_client_converter.query_response(response)
    # Then: Returns dict value
    actual_ddb_response = ddb_item
    actual_ddb_response["Items"] = [sort_dynamodb_json_lists(item) for item in actual_ddb_response["Items"]]
    expected_ddb_response = test_query_response([test_ddb_item])
    expected_ddb_response["Items"] = [sort_dynamodb_json_lists(item) for item in expected_ddb_response["Items"]]

    assert actual_ddb_response == expected_ddb_response


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


def sort_attribute_dynamodb_json_lists(item, attribute):
    if attribute in item:
        item[attribute] = sort_dynamodb_json_lists(item[attribute])
    return item


def sort_attribute_list_of_dynamodb_json_lists(item, attribute):
    if attribute in item:
        item[attribute] = [sort_dynamodb_json_lists(item) for item in item[attribute]]
    return item


def test_GIVEN_test_scan_request_WHEN_resource_to_client_THEN_returns_ddb_value(
    test_scan_request_ddb, test_scan_request_dict, test_ddb_item, test_dict_item
):
    # Given: Scan request
    request = test_scan_request_dict(test_dict_item)
    # When: Converting to resource format
    actual_ddb_request = resource_to_client_converter.scan_request(request)
    # Then: Returns dict value
    expected_ddb_request = test_scan_request_ddb(test_ddb_item)

    actual_ddb_request = sort_attribute_list_of_dynamodb_json_lists(actual_ddb_request, "ScanFilter")
    expected_ddb_request = sort_attribute_list_of_dynamodb_json_lists(expected_ddb_request, "ScanFilter")

    actual_ddb_request = sort_attribute_dynamodb_json_lists(actual_ddb_request, "ExclusiveStartKey")
    expected_ddb_request = sort_attribute_dynamodb_json_lists(expected_ddb_request, "ExclusiveStartKey")

    actual_ddb_request = sort_attribute_dynamodb_json_lists(actual_ddb_request, "ExpressionAttributeValues")
    expected_ddb_request = sort_attribute_dynamodb_json_lists(expected_ddb_request, "ExpressionAttributeValues")

    assert actual_ddb_request == expected_ddb_request


def test_GIVEN_scan_request_without_table_name_WHEN_resource_to_client_THEN_raises_error(test_scan_request_dict):
    # Given: ResourceShapeToClientShapeConverter without table name
    resource_to_client_converter_without_table_name = ResourceShapeToClientShapeConverter(table_name=None)
    # Given: Scan request without table name
    request = basic_scan_request_dict(simple_item_dict)
    # When: Converting to resource format
    with pytest.raises(ValueError):
        resource_to_client_converter_without_table_name.scan_request(request)


@pytest.fixture
def test_scan_response(use_exhaustive_request):
    if use_exhaustive_request:
        return exhaustive_scan_response
    return basic_scan_response


def test_GIVEN_test_scan_response_WHEN_resource_to_client_THEN_returns_ddb_value(
    test_scan_response, test_ddb_item, test_dict_item, test_ddb_key, test_dict_key
):
    # Given: Scan response
    response = test_scan_response([test_dict_item], [test_dict_key])
    # When: Converting to resource format
    actual_ddb_response = resource_to_client_converter.scan_response(response)
    # Then: Returns dict value
    expected_ddb_response = test_scan_response([test_ddb_item], [test_ddb_key])

    actual_ddb_response = sort_attribute_list_of_dynamodb_json_lists(actual_ddb_response, "Items")
    expected_ddb_response = sort_attribute_list_of_dynamodb_json_lists(expected_ddb_response, "Items")

    assert actual_ddb_response == expected_ddb_response


@pytest.fixture
def test_batch_get_item_request_ddb():
    return basic_batch_get_item_request_ddb


@pytest.fixture
def test_batch_get_item_request_dict():
    return basic_batch_get_item_request_dict


def test_GIVEN_test_batch_get_item_request_WHEN_resource_to_client_THEN_returns_ddb_value(
    test_batch_get_item_request_ddb, test_batch_get_item_request_dict, test_ddb_item, test_dict_item
):
    # Given: Batch get item request
    request = test_batch_get_item_request_dict([test_dict_item])
    # When: Converting to resource format
    actual_ddb_request = resource_to_client_converter.batch_get_item_request(request)
    # Then: Returns dict value
    expected_ddb_request = test_batch_get_item_request_ddb([test_ddb_item])

    actual_ddb_request = sort_attribute_list_of_dynamodb_json_lists(actual_ddb_request, "RequestItems")
    expected_ddb_request = sort_attribute_list_of_dynamodb_json_lists(expected_ddb_request, "RequestItems")

    assert actual_ddb_request == expected_ddb_request


@pytest.fixture
def test_batch_get_item_response(use_exhaustive_request):
    if use_exhaustive_request:
        return exhaustive_batch_get_item_response
    return basic_batch_get_item_response


def test_GIVEN_test_batch_get_item_response_WHEN_resource_to_client_THEN_returns_ddb_value(
    test_batch_get_item_response, test_ddb_item, test_dict_item
):
    # Given: Batch get item response
    response = test_batch_get_item_response([test_dict_item])
    # When: Converting to resource format
    actual_ddb_response = resource_to_client_converter.batch_get_item_response(response)
    # Then: Returns dict value
    expected_ddb_response = test_batch_get_item_response([test_ddb_item])

    actual_ddb_response = sort_attribute_list_of_dynamodb_json_lists(actual_ddb_response, "Responses")
    expected_ddb_response = sort_attribute_list_of_dynamodb_json_lists(expected_ddb_response, "Responses")

    assert actual_ddb_response == expected_ddb_response


@pytest.fixture
def test_batch_write_item_put_request_ddb():
    return basic_batch_write_item_put_request_ddb


@pytest.fixture
def test_batch_write_item_put_request_dict():
    return basic_batch_write_item_put_request_dict


def test_GIVEN_test_batch_write_item_put_request_WHEN_resource_to_client_THEN_returns_ddb_value(
    test_batch_write_item_put_request_ddb, test_batch_write_item_put_request_dict, test_ddb_item, test_dict_item
):
    # Given: Batch write item request
    request = test_batch_write_item_put_request_dict([test_dict_item])
    # When: Converting to resource format
    actual_ddb_request = resource_to_client_converter.batch_write_item_request(request)
    # Then: Returns dict value
    expected_ddb_request = test_batch_write_item_put_request_ddb([test_ddb_item])

    actual_ddb_request = sort_attribute_list_of_dynamodb_json_lists(actual_ddb_request, "RequestItems")
    expected_ddb_request = sort_attribute_list_of_dynamodb_json_lists(expected_ddb_request, "RequestItems")

    assert actual_ddb_request == expected_ddb_request


@pytest.fixture
def test_batch_write_item_delete_request_ddb():
    return basic_batch_write_item_delete_request_ddb


@pytest.fixture
def test_batch_write_item_delete_request_dict():
    return basic_batch_write_item_delete_request_dict


def test_GIVEN_test_batch_write_item_delete_request_WHEN_resource_to_client_THEN_returns_ddb_value(
    test_batch_write_item_delete_request_ddb, test_batch_write_item_delete_request_dict, test_ddb_key, test_dict_key
):
    # Given: Batch write item delete request
    request = test_batch_write_item_delete_request_dict([test_dict_key])
    # When: Converting to resource format
    actual_ddb_request = resource_to_client_converter.batch_write_item_request(request)
    # Then: Returns dict value
    expected_ddb_request = test_batch_write_item_delete_request_ddb([test_ddb_key])

    actual_ddb_request = sort_attribute_list_of_dynamodb_json_lists(actual_ddb_request, "RequestItems")
    expected_ddb_request = sort_attribute_list_of_dynamodb_json_lists(expected_ddb_request, "RequestItems")

    assert actual_ddb_request == expected_ddb_request


@pytest.fixture
def test_batch_write_item_put_response(use_exhaustive_request):
    if use_exhaustive_request:
        return exhaustive_batch_write_item_put_response
    return basic_batch_write_item_put_response


def test_GIVEN_test_batch_write_item_put_response_WHEN_resource_to_client_THEN_returns_ddb_value(
    test_batch_write_item_put_response, test_ddb_item, test_dict_item
):
    # Given: Batch write item put response
    response = test_batch_write_item_put_response([test_dict_item])
    # When: Converting to resource format
    actual_ddb_response = resource_to_client_converter.batch_write_item_response(response)
    # Then: Returns dict value
    expected_ddb_response = test_batch_write_item_put_response([test_ddb_item])

    actual_ddb_response = sort_attribute_list_of_dynamodb_json_lists(actual_ddb_response, "UnprocessedItems")
    expected_ddb_response = sort_attribute_list_of_dynamodb_json_lists(expected_ddb_response, "UnprocessedItems")

    assert actual_ddb_response == expected_ddb_response


@pytest.fixture
def test_transact_write_items_put_request_ddb():
    return basic_transact_write_item_put_request_ddb


@pytest.fixture
def test_transact_write_items_put_request_dict():
    return basic_transact_write_item_put_request_dict


def test_GIVEN_test_transact_write_items_put_request_WHEN_resource_to_client_THEN_returns_ddb_value(
    test_transact_write_items_put_request_ddb, test_transact_write_items_put_request_dict, test_ddb_item, test_dict_item
):
    # Given: Transact write item put request
    request = test_transact_write_items_put_request_dict([test_dict_item])
    # When: Converting to resource format
    actual_ddb_request = resource_to_client_converter.transact_write_items_request(request)
    # Then: Returns dict value
    expected_ddb_request = test_transact_write_items_put_request_ddb([test_ddb_item])

    actual_ddb_request = sort_attribute_list_of_dynamodb_json_lists(actual_ddb_request, "TransactItems")
    expected_ddb_request = sort_attribute_list_of_dynamodb_json_lists(expected_ddb_request, "TransactItems")

    assert actual_ddb_request == expected_ddb_request


@pytest.fixture
def test_transact_write_items_delete_request_ddb():
    return basic_transact_write_item_delete_request_ddb


@pytest.fixture
def test_transact_write_items_delete_request_dict():
    return basic_transact_write_item_delete_request_dict


def test_GIVEN_test_transact_write_items_delete_request_WHEN_resource_to_client_THEN_returns_ddb_value(
    test_transact_write_items_delete_request_ddb,
    test_transact_write_items_delete_request_dict,
    test_ddb_key,
    test_dict_key,
):
    # Given: Transact write item delete request
    request = test_transact_write_items_delete_request_dict([test_dict_key])
    # When: Converting to resource format
    actual_ddb_request = resource_to_client_converter.transact_write_items_request(request)
    # Then: Returns dict value
    expected_ddb_request = test_transact_write_items_delete_request_ddb([test_ddb_key])

    actual_ddb_request = sort_attribute_list_of_dynamodb_json_lists(actual_ddb_request, "TransactItems")
    expected_ddb_request = sort_attribute_list_of_dynamodb_json_lists(expected_ddb_request, "TransactItems")

    assert actual_ddb_request == expected_ddb_request


@pytest.fixture
def test_transact_write_items_condition_check_request_ddb():
    return basic_transact_write_item_condition_check_request_ddb


@pytest.fixture
def test_transact_write_items_condition_check_request_dict():
    return basic_transact_write_item_condition_check_request_dict


def test_GIVEN_test_transact_write_items_condition_check_request_WHEN_resource_to_client_THEN_returns_ddb_value(
    test_transact_write_items_condition_check_request_ddb,
    test_transact_write_items_condition_check_request_dict,
    test_ddb_key,
    test_dict_key,
):
    # Given: Transact write item condition check request
    request = test_transact_write_items_condition_check_request_dict([test_dict_key])
    # When: Converting to resource format
    actual_ddb_request = resource_to_client_converter.transact_write_items_request(request)
    # Then: Returns dict value
    expected_ddb_request = test_transact_write_items_condition_check_request_ddb([test_ddb_key])

    actual_ddb_request = sort_attribute_list_of_dynamodb_json_lists(actual_ddb_request, "TransactItems")
    expected_ddb_request = sort_attribute_list_of_dynamodb_json_lists(expected_ddb_request, "TransactItems")

    assert actual_ddb_request == expected_ddb_request


@pytest.fixture
def test_transact_write_items_response():
    return basic_transact_write_items_response


def test_GIVEN_test_transact_write_items_response_WHEN_resource_to_client_THEN_returns_ddb_value(
    test_transact_write_items_response, test_ddb_item, test_dict_item
):
    # Given: Transact write items response
    response = test_transact_write_items_response([test_dict_item])
    # When: Converting to resource format
    actual_ddb_response = resource_to_client_converter.transact_write_items_response(response)
    # Then: Returns dict value
    expected_ddb_response = test_transact_write_items_response([test_ddb_item])

    actual_ddb_response = sort_attribute_list_of_dynamodb_json_lists(actual_ddb_response, "ConsumedCapacity")
    expected_ddb_response = sort_attribute_list_of_dynamodb_json_lists(expected_ddb_response, "ConsumedCapacity")

    assert actual_ddb_response == expected_ddb_response


@pytest.fixture
def test_transact_get_items_request_ddb():
    return basic_transact_get_item_request_ddb


@pytest.fixture
def test_transact_get_items_request_dict():
    return basic_transact_get_item_request_dict


def test_GIVEN_test_transact_get_items_request_WHEN_resource_to_client_THEN_returns_ddb_value(
    test_transact_get_items_request_ddb, test_transact_get_items_request_dict, test_ddb_key, test_dict_key
):
    # Given: Transact get items request
    request = test_transact_get_items_request_dict([test_dict_key])
    # When: Converting to resource format
    actual_ddb_request = resource_to_client_converter.transact_get_items_request(request)
    # Then: Returns dict value
    expected_ddb_request = test_transact_get_items_request_ddb([test_ddb_key])

    actual_ddb_request = sort_attribute_list_of_dynamodb_json_lists(actual_ddb_request, "TransactItems")
    expected_ddb_request = sort_attribute_list_of_dynamodb_json_lists(expected_ddb_request, "TransactItems")

    assert actual_ddb_request == expected_ddb_request


@pytest.fixture
def test_transact_get_items_response():
    return basic_transact_get_items_response


def test_GIVEN_test_transact_get_items_response_WHEN_resource_to_client_THEN_returns_ddb_value(
    test_transact_get_items_response, test_ddb_item, test_dict_item
):
    # Given: Transact get items response
    response = test_transact_get_items_response([test_dict_item])
    # When: Converting to resource format
    actual_ddb_response = resource_to_client_converter.transact_get_items_response(response)
    # Then: Returns dict value
    expected_ddb_response = test_transact_get_items_response([test_ddb_item])

    actual_ddb_response = sort_attribute_list_of_dynamodb_json_lists(actual_ddb_response, "Responses")
    expected_ddb_response = sort_attribute_list_of_dynamodb_json_lists(expected_ddb_response, "Responses")

    assert actual_ddb_response == expected_ddb_response


def test_GIVEN_request_with_neither_ExpressionAttributeValues_nor_ExpressionAttributeNames_WHEN_condition_handler_THEN_returns_BuiltConditionExpression_output():
    # Given: Request with neither ExpressionAttributeValues nor ExpressionAttributeNames
    request = exhaustive_put_item_request_dict(simple_item_dict)
    if "ExpressionAttributeValues" in request:
        del request["ExpressionAttributeValues"]
    if "ExpressionAttributeNames" in request:
        del request["ExpressionAttributeNames"]
    actual = resource_to_client_converter.condition_handler("ConditionExpression", request)
    # Reset expression_builder numbering to make test equality easier
    # (ex. Instead of starting names at '#n2', it starts at '#n0' and can equal the `actual` expression string that starts at '#n0')
    resource_to_client_converter.expression_builder.reset()
    expected = resource_to_client_converter.expression_builder.build_expression(request["ConditionExpression"], {}, {})

    assert actual == (
        expected.condition_expression,
        expected.attribute_name_placeholders,
        expected.attribute_value_placeholders,
    )
