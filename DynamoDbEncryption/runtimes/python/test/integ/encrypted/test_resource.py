import uuid
from copy import deepcopy

import boto3
import pytest

from aws_dbesdk_dynamodb.encrypted.resource import EncryptedResource, EncryptedTablesCollectionManager
from aws_dbesdk_dynamodb.encrypted.table import EncryptedTable

from ...constants import INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME, INTEG_TEST_DEFAULT_TABLE_CONFIGS
from ...items import (
    complex_item_ddb,
    complex_item_dict,
    complex_key_dict,
    simple_item_ddb,
    simple_item_dict,
    simple_key_dict,
)
from ...requests import (
    basic_batch_get_item_request_dict,
    basic_batch_write_item_delete_request_dict,
    basic_batch_write_item_put_request_dict,
    basic_delete_item_request_ddb,
)


@pytest.fixture(params=[True, False], ids=["encrypted", "plaintext"])
def encrypted(request):
    return request.param


def plaintext_resource():
    return boto3.resource("dynamodb")


def encrypted_resource():
    return EncryptedResource(
        resource=plaintext_resource(),
        encryption_config=INTEG_TEST_DEFAULT_TABLE_CONFIGS,
    )


@pytest.fixture
def resource(encrypted):
    if encrypted:
        return encrypted_resource()
    else:
        return plaintext_resource()


@pytest.fixture
def tables(resource):
    return resource.tables


@pytest.fixture(scope="module")
def test_run_suffix():
    return str(uuid.uuid4())


@pytest.fixture
def test_items(test_run_suffix):
    items = [deepcopy(complex_item_dict), deepcopy(simple_item_dict)]
    for item in items:
        item["partition_key"] += test_run_suffix
    return items


@pytest.fixture
def test_keys(test_run_suffix):
    keys = [deepcopy(complex_key_dict), deepcopy(simple_key_dict)]
    for key in keys:
        key["partition_key"] += test_run_suffix
    return keys


def test_GIVEN_items_WHEN_batch_write_and_get_THEN_round_trip_passes(
    resource,
    test_items,
    test_keys,
):
    batch_write_item_put_request = basic_batch_write_item_put_request_dict(test_items)
    batch_write_response = resource.batch_write_item(**batch_write_item_put_request)
    assert batch_write_response["ResponseMetadata"]["HTTPStatusCode"] == 200

    batch_get_item_request = basic_batch_get_item_request_dict(test_keys)
    batch_get_response = resource.batch_get_item(**batch_get_item_request)
    assert batch_get_response["ResponseMetadata"]["HTTPStatusCode"] == 200
    responses = batch_get_response["Responses"][INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME]
    assert len(responses) == 2
    for response in responses:
        assert response in test_items

    batch_write_item_delete_request = basic_batch_write_item_delete_request_dict(test_keys)
    batch_write_response = resource.batch_write_item(**batch_write_item_delete_request)
    assert batch_write_response["ResponseMetadata"]["HTTPStatusCode"] == 200

    batch_get_response = resource.batch_get_item(**batch_get_item_request)
    assert batch_get_response["ResponseMetadata"]["HTTPStatusCode"] == 200
    assert len(batch_get_response["Responses"][INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME]) == 0


def test_GIVEN_encrypted_resource_WHEN_Table_THEN_returns_encrypted_table_with_correct_arguments():
    # Given: Encrypted resource
    resource = encrypted_resource()
    # When: Table
    table = resource.Table(INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME)
    # Then: Returns encrypted table
    assert isinstance(table, EncryptedTable)
    assert table.name == INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME
    assert table._encryption_config == resource._encryption_config


def test_GIVEN_encrypted_resource_WHEN_tables_THEN_returns_encrypted_tables_collection_manager():
    # Given: Encrypted resource
    resource = encrypted_resource()
    # When: tables
    tables = resource.tables
    # Then: Returns encrypted tables collection manager
    assert isinstance(tables, EncryptedTablesCollectionManager)
    # Given: Encrypted tables collection manager
    tables = resource.tables
    # When: all
    iter = tables.all()
    tables_list = []
    for table in iter:
        tables_list.append(table)
    assert len(tables_list) > 0
    for table in tables_list:
        assert isinstance(table, EncryptedTable)
        assert table._encryption_config == resource._encryption_config


def test_GIVEN_tables_WHEN_all_THEN_returns_tables(
    tables,
):
    # Given: Tables
    # When: all
    tables_list = []
    for table in tables.all():
        tables_list.append(table)
    # Then: Returns tables
    assert len(tables_list) > 0
    table_names = [table.name for table in tables_list]
    # "All tables" includes the integ test table
    assert INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME in table_names


def test_GIVEN_tables_WHEN_filter_THEN_returns_tables(
    tables,
):
    # Given: Tables
    # When: filter
    tables_list = []
    for table in tables.filter(
        ExclusiveStartTableName=INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME,
        Limit=1,
    ):
        tables_list.append(table)
    # Then: Returns tables
    assert len(tables_list) > 0
    table_names = [table.name for table in tables_list]
    # The filter request started from the integ test table, not inclusive; it should not be in the list
    assert INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME not in table_names


def test_GIVEN_tables_WHEN_limit_THEN_returns_tables(
    tables,
):
    # Given: Tables
    # When: limit
    tables_list = []
    for table in tables.limit(count=1):
        tables_list.append(table)
    # Then: Returns tables
    assert len(tables_list) == 1


def test_GIVEN_tables_WHEN_page_size_THEN_returns_tables(
    tables,
):
    # Given: Tables
    # When: page_size
    tables_list = []
    for table in tables.page_size(count=1):
        tables_list.append(table)
    # Then: Returns tables
    assert len(tables_list) > 0


# Delete the items in the table after the module runs
@pytest.fixture(scope="module", autouse=True)
def cleanup_after_module(test_run_suffix):
    yield
    table = boto3.client("dynamodb")
    items = [deepcopy(simple_item_ddb), deepcopy(complex_item_ddb)]
    for item in items:
        item["partition_key"]["S"] += test_run_suffix
        table.delete_item(**basic_delete_item_request_ddb(item))
