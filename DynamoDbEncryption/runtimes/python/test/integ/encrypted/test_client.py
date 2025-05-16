# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
import boto3
import pytest

from aws_dbesdk_dynamodb.encrypted.client import EncryptedClient
from aws_dbesdk_dynamodb.encrypted.paginator import EncryptedPaginator
from aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.errors import (
    DynamoDbEncryptionTransformsException,
)

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
    basic_batch_execute_statement_request_encrypted_table,
    basic_batch_execute_statement_request_plaintext_table,
    basic_batch_get_item_request_ddb,
    basic_batch_get_item_request_dict,
    basic_batch_write_item_delete_request_ddb,
    basic_batch_write_item_delete_request_dict,
    basic_batch_write_item_put_request_ddb,
    basic_batch_write_item_put_request_dict,
    basic_delete_item_request_ddb,
    basic_delete_item_request_dict,
    basic_execute_statement_request_encrypted_table,
    basic_execute_statement_request_plaintext_table,
    basic_execute_transaction_request_encrypted_table,
    basic_execute_transaction_request_plaintext_table,
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
    basic_transact_write_item_delete_request_ddb,
    basic_transact_write_item_delete_request_dict,
    basic_transact_write_item_put_request_ddb,
    basic_transact_write_item_put_request_dict,
    basic_update_item_request_ddb_signed_attribute,
    basic_update_item_request_ddb_unsigned_attribute,
    basic_update_item_request_dict_signed_attribute,
    basic_update_item_request_dict_unsigned_attribute,
)
from . import sort_dynamodb_json_lists


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


# Creates a matrix of tests for each value in param,
# with a user-friendly string for test output:
# use_complex_item = True -> "complex_item"
# use_complex_item = False -> "simple_item"
@pytest.fixture(params=[True, False], ids=["complex_item", "simple_item"])
def use_complex_item(request):
    return request.param


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
def multiple_test_items(expect_standard_dictionaries):
    """Get two test items in the appropriate format for the client."""
    if expect_standard_dictionaries:
        return [simple_item_dict, complex_item_dict]
    return [simple_item_ddb, complex_item_ddb]


@pytest.fixture
def multiple_test_keys(expect_standard_dictionaries):
    """Get two test keys in the appropriate format for the client."""
    if expect_standard_dictionaries:
        return [simple_key_dict, complex_key_dict]
    return [simple_key_ddb, complex_key_ddb]


@pytest.fixture
def put_item_request(expect_standard_dictionaries, test_item):
    if expect_standard_dictionaries:
        # Client requests with `expect_standard_dictionaries=True` use dict-formatted requests
        # with an added "TableName" key.
        return {**basic_put_item_request_dict(test_item), "TableName": INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME}
    return basic_put_item_request_ddb(test_item)


@pytest.fixture
def get_item_request(expect_standard_dictionaries, test_item):
    if expect_standard_dictionaries:
        # Client requests with `expect_standard_dictionaries=True` use dict-formatted requests
        # with an added "TableName" key.
        return {**basic_get_item_request_dict(test_item), "TableName": INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME}
    return basic_get_item_request_ddb(test_item)


@pytest.fixture
def delete_item_request(expect_standard_dictionaries, test_item):
    if expect_standard_dictionaries:
        return {**basic_delete_item_request_dict(test_item), "TableName": INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME}
    return basic_delete_item_request_ddb(test_item)


def test_GIVEN_valid_put_and_get_and_delete_requests_WHEN_put_and_get_and_delete_THEN_round_trip_passes(
    client, put_item_request, get_item_request, delete_item_request
):
    # Given: Valid put_item request
    # When: put_item
    put_response = client.put_item(**put_item_request)
    # Then: put_item succeeds
    assert put_response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # Given: Valid get_item request for the same item
    # When: get_item
    get_response = client.get_item(**get_item_request)
    # Then: Resposne is equal to the original item
    assert get_response["ResponseMetadata"]["HTTPStatusCode"] == 200
    # DynamoDB JSON uses lists to represent sets, so strict equality can fail.
    # Sort lists to ensure consistent ordering when comparing expected and actual items.
    expected_item = sort_dynamodb_json_lists(put_item_request["Item"])
    actual_item = sort_dynamodb_json_lists(get_response["Item"])
    assert expected_item == actual_item

    # Given: Valid delete_item request for the same item
    # When: delete_item
    delete_response = client.delete_item(**{**delete_item_request, "ReturnValues": "ALL_OLD"})
    # Then: delete_item succeeds and contains the expected response
    assert delete_response["ResponseMetadata"]["HTTPStatusCode"] == 200
    # DynamoDB JSON uses lists to represent sets, so strict equality can fail.
    # Sort lists to ensure consistent ordering when comparing expected and actual items.
    expected_item = sort_dynamodb_json_lists(put_item_request["Item"])
    actual_item = sort_dynamodb_json_lists(delete_response["Attributes"])
    assert expected_item == actual_item

    # Given: Valid get_item request for the same item
    # When: get_item
    get_response = client.get_item(**get_item_request)
    # Then: get_item is empty (i.e. the item was deleted)
    assert "Item" not in get_response


@pytest.fixture
def batch_write_item_put_request(expect_standard_dictionaries, multiple_test_items):
    if expect_standard_dictionaries:
        return basic_batch_write_item_put_request_dict(multiple_test_items)
    return basic_batch_write_item_put_request_ddb(multiple_test_items)


@pytest.fixture
def batch_write_item_delete_request(expect_standard_dictionaries, multiple_test_keys):
    if expect_standard_dictionaries:
        return basic_batch_write_item_delete_request_dict(multiple_test_keys)
    return basic_batch_write_item_delete_request_ddb(multiple_test_keys)


@pytest.fixture
def batch_get_item_request(expect_standard_dictionaries, multiple_test_keys):
    if expect_standard_dictionaries:
        return basic_batch_get_item_request_dict(multiple_test_keys)
    return basic_batch_get_item_request_ddb(multiple_test_keys)


def test_GIVEN_valid_batch_write_and_get_requests_WHEN_batch_write_and_get_THEN_round_trip_passes(
    client, multiple_test_items, batch_write_item_put_request, batch_get_item_request, batch_write_item_delete_request
):
    # Given: Valid batch_write_item put request
    # When: batch_write_item put
    batch_write_response = client.batch_write_item(**batch_write_item_put_request)
    # Then: batch_write_item put succeeds
    assert batch_write_response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # Given: Valid batch_get_item request
    # When: batch_get_item
    batch_get_response = client.batch_get_item(**batch_get_item_request)
    # Then: batch_get_item succeeds
    assert batch_get_response["ResponseMetadata"]["HTTPStatusCode"] == 200
    # Then: All items are encrypted and decrypted correctly
    retrieved_items = batch_get_response["Responses"][INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME]
    assert len(retrieved_items) > 0
    assert len(retrieved_items) == len(multiple_test_items)
    expected_items = [sort_dynamodb_json_lists(expected_item) for expected_item in multiple_test_items]
    actual_items = [sort_dynamodb_json_lists(actual_item) for actual_item in retrieved_items]
    for actual_item in actual_items:
        assert actual_item in expected_items

    # Given: Valid batch_delete_item request
    # When: batch_delete_item
    batch_delete_response = client.batch_write_item(**batch_write_item_delete_request)
    # Then: batch_delete_item succeeds
    assert batch_delete_response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # Given: Valid batch_get_item request
    # When: batch_get_item
    batch_get_response = client.batch_get_item(**batch_get_item_request)
    # Then: batch_get_item succeeds
    assert batch_get_response["ResponseMetadata"]["HTTPStatusCode"] == 200
    # Then: All items are deleted
    retrieved_items = batch_get_response["Responses"]


@pytest.fixture
def query_request(expect_standard_dictionaries, test_item):
    if expect_standard_dictionaries:
        return {**basic_query_request_dict(test_item), "TableName": INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME}
    return basic_query_request_ddb(test_item)


def test_GIVEN_valid_put_and_query_requests_WHEN_put_and_query_THEN_round_trip_passes(
    client, put_item_request, query_request
):
    # Given: Valid put_item request
    # When: put_item
    put_response = client.put_item(**put_item_request)
    # Then: put_item succeeds
    assert put_response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # Given: Valid query request
    # When: query
    query_response = client.query(**query_request)
    # Then: query succeeds
    assert query_response["ResponseMetadata"]["HTTPStatusCode"] == 200
    assert len(query_response["Items"]) == 1
    # DynamoDB JSON uses lists to represent sets, so strict equality can fail.
    # Sort lists to ensure consistent ordering when comparing expected and actual items.
    expected_item = sort_dynamodb_json_lists(put_item_request["Item"])
    actual_item = sort_dynamodb_json_lists(query_response["Items"][0])
    assert expected_item == actual_item


@pytest.fixture
def scan_request(expect_standard_dictionaries, test_item):
    if expect_standard_dictionaries:
        return {**basic_scan_request_dict(test_item), "TableName": INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME}
    return basic_scan_request_ddb(test_item)


def test_GIVEN_valid_put_and_scan_requests_WHEN_put_and_scan_THEN_round_trip_passes(
    client, put_item_request, scan_request
):
    # Given: Valid put_item request
    # When: put_item
    put_response = client.put_item(**put_item_request)
    # Then: put_item succeeds
    assert put_response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # Given: Valid scan request
    # When: scan
    scan_response = client.scan(**scan_request)
    # Then: scan succeeds
    assert scan_response["ResponseMetadata"]["HTTPStatusCode"] == 200
    assert len(scan_response["Items"]) >= 1
    # Can't assert anything about the scan;
    # there are too many items.
    # The critical assertion is that the scan succeeds.


@pytest.fixture
def transact_write_item_put_request(expect_standard_dictionaries, multiple_test_items):
    if expect_standard_dictionaries:
        return basic_transact_write_item_put_request_dict(multiple_test_items)
    return basic_transact_write_item_put_request_ddb(multiple_test_items)


@pytest.fixture
def transact_write_item_delete_request(expect_standard_dictionaries, multiple_test_keys):
    if expect_standard_dictionaries:
        return basic_transact_write_item_delete_request_dict(multiple_test_keys)
    return basic_transact_write_item_delete_request_ddb(multiple_test_keys)


@pytest.fixture
def transact_get_item_request(expect_standard_dictionaries, multiple_test_keys):
    if expect_standard_dictionaries:
        return basic_transact_get_item_request_dict(multiple_test_keys)
    return basic_transact_get_item_request_ddb(multiple_test_keys)


def test_GIVEN_valid_transact_write_and_get_requests_WHEN_transact_write_and_get_THEN_round_trip_passes(
    client,
    multiple_test_items,
    transact_write_item_put_request,
    transact_write_item_delete_request,
    transact_get_item_request,
    batch_get_item_request,
):
    # Given: Valid transact_write_item put request
    # When: transact_write_item put
    transact_write_put_response = client.transact_write_items(**transact_write_item_put_request)
    # Then: transact_write_item put succeeds
    assert transact_write_put_response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # Given: Valid transact_get_item request
    # When: transact_get_item
    transact_get_response = client.transact_get_items(**transact_get_item_request)
    # Then: transact_get_item succeeds
    assert transact_get_response["ResponseMetadata"]["HTTPStatusCode"] == 200
    # Then: All items are encrypted and decrypted correctly
    retrieved_items = transact_get_response["Responses"]
    assert len(retrieved_items) > 0
    assert len(retrieved_items) == len(multiple_test_items)
    expected_items = [sort_dynamodb_json_lists(expected_item) for expected_item in multiple_test_items]
    actual_items = [sort_dynamodb_json_lists(actual_item) for actual_item in retrieved_items]
    for actual_item in actual_items:
        assert actual_item["Item"] in expected_items

    # Given: Valid transact_write_item delete request
    # When: transact_write_item delete
    transact_write_delete_response = client.transact_write_items(**transact_write_item_delete_request)
    # Then: transact_write_item delete succeeds
    assert transact_write_delete_response["ResponseMetadata"]["HTTPStatusCode"] == 200


@pytest.fixture
def update_item_request_unsigned_attribute(expect_standard_dictionaries, test_item):
    if expect_standard_dictionaries:
        return {
            **basic_update_item_request_dict_unsigned_attribute(test_item),
            "TableName": INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME,
        }
    return basic_update_item_request_ddb_unsigned_attribute(test_item)


def test_WHEN_update_item_with_unsigned_attribute_THEN_passes(
    client, update_item_request_unsigned_attribute, encrypted, get_item_request
):
    # Given: Valid update_item request
    # When: update_item
    update_response = client.update_item(**update_item_request_unsigned_attribute)
    # Then: update_item succeeds
    assert update_response["ResponseMetadata"]["HTTPStatusCode"] == 200


@pytest.fixture
def update_item_request_signed_attribute(expect_standard_dictionaries, test_item):
    if expect_standard_dictionaries:
        return {
            **basic_update_item_request_dict_signed_attribute(test_item),
            "TableName": INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME,
        }
    return basic_update_item_request_ddb_signed_attribute(test_item)


def test_WHEN_update_item_with_signed_attribute_THEN_raises_DynamoDbEncryptionTransformsException(
    client,
    update_item_request_signed_attribute,
    encrypted,
):
    if not encrypted:
        pytest.skip("Skipping negative test for plaintext client")

    # Given: Encrypted client and update item parameters
    # Then: DynamoDbEncryptionTransformsException is raised
    with pytest.raises(DynamoDbEncryptionTransformsException):
        # When: Calling update_item
        client.update_item(**update_item_request_signed_attribute)


@pytest.fixture(params=[True, False], ids=["encrypted_table", "plaintext_table"])
def execute_uses_encrypted_table(request):
    return request.param


@pytest.fixture
def execute_statement_request(execute_uses_encrypted_table):
    if execute_uses_encrypted_table:
        return basic_execute_statement_request_encrypted_table()
    return basic_execute_statement_request_plaintext_table()


def test_WHEN_execute_statement_for_encrypted_table_THEN_raises_DynamoDbEncryptionTransformsException(
    client,
    execute_statement_request,
    encrypted,
    execute_uses_encrypted_table,
):
    if not encrypted:
        pytest.skip("Skipping negative test for plaintext client")

    if execute_uses_encrypted_table:
        # Given: Encrypted client and execute_statement request on encrypted table
        # Then: DynamoDbEncryptionTransformsException is raised
        with pytest.raises(DynamoDbEncryptionTransformsException):
            # When: Calling execute_statement
            client.execute_statement(**execute_statement_request)
    else:
        pytest.skip("Skipping test for plaintext table; this test is only for encrypted tables")


def test_WHEN_execute_statement_for_plaintext_table_THEN_passes(
    client,
    execute_statement_request,
    execute_uses_encrypted_table,
):
    if execute_uses_encrypted_table:
        pytest.skip("Skipping test for encrypted table; this test is only for plaintext tables")

    # Given: Client calls execute_statement on plaintext table
    # When: Calling execute_statement
    response = client.execute_statement(**execute_statement_request)
    # Then: Success
    assert response["ResponseMetadata"]["HTTPStatusCode"] == 200


@pytest.fixture
def execute_transaction_request(execute_uses_encrypted_table, test_item):
    if execute_uses_encrypted_table:
        return basic_execute_transaction_request_encrypted_table(test_item)
    return basic_execute_transaction_request_plaintext_table(test_item)


def test_WHEN_execute_transaction_for_encrypted_table_THEN_raises_DynamoDbEncryptionTransformsException(
    client,
    execute_transaction_request,
    encrypted,
    execute_uses_encrypted_table,
):
    if not encrypted:
        pytest.skip("Skipping negative test for plaintext client")

    if execute_uses_encrypted_table:
        # Given: Encrypted client and execute_transaction request on encrypted table
        # Then: DynamoDbEncryptionTransformsException is raised
        with pytest.raises(DynamoDbEncryptionTransformsException):
            # When: Calling execute_transaction
            client.execute_transaction(**execute_transaction_request)
    else:
        pytest.skip("Skipping test for plaintext table; this test is only for encrypted tables")


def test_WHEN_execute_transaction_for_plaintext_table_THEN_passes(
    client,
    execute_transaction_request,
    execute_uses_encrypted_table,
    put_item_request,
):
    if execute_uses_encrypted_table:
        pytest.skip("Skipping test for encrypted table; this test is only for plaintext tables")

    put_response = client.put_item(**put_item_request)
    assert put_response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # Given: Client calls execute_transaction on plaintext table
    # When: Calling execute_transaction
    response = client.execute_transaction(**execute_transaction_request)
    # Then: Success
    assert response["ResponseMetadata"]["HTTPStatusCode"] == 200


@pytest.fixture
def batch_execute_statement_request(execute_uses_encrypted_table):
    if execute_uses_encrypted_table:
        return basic_batch_execute_statement_request_encrypted_table()
    return basic_batch_execute_statement_request_plaintext_table()


def test_WHEN_batch_execute_statement_for_encrypted_table_THEN_raises_DynamoDbEncryptionTransformsException(
    client,
    batch_execute_statement_request,
    encrypted,
    execute_uses_encrypted_table,
):
    if not encrypted:
        pytest.skip("Skipping negative test for plaintext client")

    if execute_uses_encrypted_table:
        # Given: Encrypted client and batch_execute_statement request on encrypted table
        # Then: DynamoDbEncryptionTransformsException is raised
        with pytest.raises(DynamoDbEncryptionTransformsException):
            # When: Calling batch_execute_statement
            client.batch_execute_statement(**batch_execute_statement_request)
    else:
        pytest.skip("Skipping test for plaintext table; this test is only for encrypted tables")


def test_WHEN_batch_execute_statement_for_plaintext_table_THEN_passes(
    client,
    batch_execute_statement_request,
    execute_uses_encrypted_table,
):
    if execute_uses_encrypted_table:
        pytest.skip("Skipping test for encrypted table; this test is only for plaintext tables")

    # Given: Client calls batch_execute_statement on plaintext table
    # When: Calling batch_execute_statement
    response = client.batch_execute_statement(**batch_execute_statement_request)
    # Then: Success
    assert response["ResponseMetadata"]["HTTPStatusCode"] == 200


def test_WHEN_get_paginator_THEN_correct_paginator_is_returned():
    """Test get_paginator for scan and query operations."""
    # Given: Encrypted client

    # When: Getting paginator for some encrypted operation
    scan_paginator = encrypted_client(expect_standard_dictionaries=False).get_paginator("query")
    # Then: EncryptedPaginator is returned
    assert isinstance(scan_paginator, EncryptedPaginator)

    # When: Getting paginator for some non-encrypted operation
    list_backups_paginator = encrypted_client(expect_standard_dictionaries=False).get_paginator("list_backups")
    # Then: Query paginator is returned
    assert not isinstance(list_backups_paginator, EncryptedPaginator)


def test_WHEN_call_passthrough_method_THEN_correct_response_is_returned():
    """Test that calling a passthrough method returns the correct response."""
    # Given: Encrypted client
    # When: Calling some passthrough method that does not explicitly exist on EncryptedClient,
    # but exists on the underlying boto3 client
    response = encrypted_client(expect_standard_dictionaries=False).list_backups()
    # Then: Correct response is returned, i.e. EncryptedClient forwards the call to the underlying boto3 client
    assert response["ResponseMetadata"]["HTTPStatusCode"] == 200
