# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
import uuid
from copy import deepcopy

import boto3
import pytest
from dynamodb_encryption_sdk.exceptions import DecryptionError

from aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.errors import (
    DynamoDbItemEncryptor,
)
from aws_dbesdk_dynamodb.structures.dynamodb import LegacyPolicy

from ...constants import (
    INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME,
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
    basic_delete_item_request_ddb,
    basic_delete_item_request_dict,
    basic_get_item_request_ddb,
    basic_get_item_request_dict,
    basic_put_item_request_ddb,
    basic_put_item_request_dict,
)
from . import sort_dynamodb_json_lists
from .utils import (
    create_legacy_encrypted_client,
    create_legacy_encrypted_resource,
    create_legacy_encrypted_table,
    encrypted_client_with_legacy_override,
    legacy_actions,
)


# Creates a matrix of tests for each value in param,
# with a user-friendly string for test output:
# expect_standard_dictionaries = True -> "standard_dicts"
# expect_standard_dictionaries = False -> "ddb_json"
@pytest.fixture(params=[True, False], ids=["standard_dicts", "ddb_json"])
def expect_standard_dictionaries(request):
    return request.param


# Creates a matrix of tests for each value in param,
# with a user-friendly string for test output:
# use_complex_item = True -> "complex_item"
# use_complex_item = False -> "simple_item"
@pytest.fixture(params=[True, False], ids=["complex_item", "simple_item"])
def use_complex_item(request):
    return request.param


# Append a suffix to the partition key to avoid collisions between test runs.
@pytest.fixture(scope="module")
def test_run_suffix():
    return "-" + str(uuid.uuid4())


@pytest.fixture
def test_item(expect_standard_dictionaries, use_complex_item, test_run_suffix):
    """Get a single test item in the appropriate format for the client."""
    if expect_standard_dictionaries:
        if use_complex_item:
            item = deepcopy(complex_item_dict)
        else:
            item = deepcopy(simple_item_dict)
    else:
        if use_complex_item:
            item = deepcopy(complex_item_ddb)
        else:
            item = deepcopy(simple_item_ddb)
    # Add a suffix to the partition key to avoid collisions between test runs.
    if isinstance(item["partition_key"], dict):
        item["partition_key"]["S"] += test_run_suffix
    else:
        item["partition_key"] += test_run_suffix
    return item


@pytest.fixture
def test_key(expect_standard_dictionaries, use_complex_item, test_run_suffix):
    """Get a single test item in the appropriate format for the client."""
    if expect_standard_dictionaries:
        if use_complex_item:
            key = deepcopy(complex_key_dict)
        else:
            key = deepcopy(simple_key_dict)
    else:
        if use_complex_item:
            key = deepcopy(complex_key_ddb)
        else:
            key = deepcopy(simple_key_ddb)
    # Add a suffix to the partition key to avoid collisions between test runs.
    if isinstance(key["partition_key"], dict):
        key["partition_key"]["S"] += test_run_suffix
    else:
        key["partition_key"] += test_run_suffix
    return key


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


# Fixtures for legacy encryptors and clients


@pytest.fixture(params=["client", "table", "resource"], ids=["legacy_client", "legacy_table", "legacy_resource"])
def legacy_encryptor(request):
    """Create a legacy encryptor of the specified type."""
    if request.param == "client":
        return create_legacy_encrypted_client()
    elif request.param == "table":
        return create_legacy_encrypted_table()
    elif request.param == "resource":
        return create_legacy_encrypted_resource()


@pytest.fixture(
    params=[
        LegacyPolicy.FORCE_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT,
        LegacyPolicy.FORBID_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT,
        LegacyPolicy.FORBID_LEGACY_ENCRYPT_FORBID_LEGACY_DECRYPT,
    ]
)
def legacy_policy(request):
    return request.param


@pytest.fixture
def encrypted_client(legacy_encryptor, legacy_policy, expect_standard_dictionaries):
    return encrypted_client_with_legacy_override(
        legacy_encryptor=legacy_encryptor,
        legacy_policy=legacy_policy,
        expect_standard_dictionaries=expect_standard_dictionaries,
    )


def test_GIVEN_awsdbe_encrypted_item_WHEN_get_with_legacy_client(
    encrypted_client,
    put_item_request,
    get_item_request,
    delete_item_request,
    expect_standard_dictionaries,
    legacy_policy,
):
    # Given: Valid put_item request
    # When: put_item
    put_response = encrypted_client.put_item(**put_item_request)
    # Then: put_item succeeds
    assert put_response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # Given: Fresh legacy encryptor of the same type as used in the fixture
    legacy_encrypted_client = create_legacy_encrypted_client(
        attribute_actions=legacy_actions(),
        expect_standard_dictionaries=expect_standard_dictionaries,
    )

    if legacy_policy == LegacyPolicy.FORCE_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT:
        # Given: Valid get_item request for the same item using legacy encryptor with FORCE_LEGACY_ENCRYPT policy
        # When: get_item with legacy encryptor
        get_response = legacy_encrypted_client.get_item(**get_item_request)
        # Then: Response is equal to the original item (legacy encryptor can decrypt item written by AWS DB-ESDK)
        assert get_response["ResponseMetadata"]["HTTPStatusCode"] == 200
        # DynamoDB JSON uses lists to represent sets, so strict equality can fail.
        # Sort lists to ensure consistent ordering when comparing expected and actual items.
        expected_item = sort_dynamodb_json_lists(put_item_request["Item"])
        legacy_actual_item = sort_dynamodb_json_lists(get_response["Item"])
        assert expected_item == legacy_actual_item
    else:
        # Given: Valid get_item request for the same item using legacy encryptor with FORBID_LEGACY_ENCRYPT policy
        # When: get_item with legacy encryptor
        # Then: throws DecryptionError Exception (i.e. legacy encryptor cannot read values in new format)
        with pytest.raises(DecryptionError):  # The exact exception may vary in Python implementation
            # Try to read the item with the legacy encryptor
            legacy_encrypted_client.get_item(**get_item_request)


def test_GIVEN_legacy_encrypted_item_WHEN_get_with_awsdbe(
    encrypted_client,
    put_item_request,
    get_item_request,
    delete_item_request,
    expect_standard_dictionaries,
    legacy_policy,
):
    # Given: Fresh legacy encryptor and valid put_item request
    legacy_encrypted_client = create_legacy_encrypted_client(
        attribute_actions=legacy_actions(),
        expect_standard_dictionaries=expect_standard_dictionaries,
    )
    # When: put_item using legacy encryptor
    put_response = legacy_encrypted_client.put_item(**put_item_request)
    # Then: put_item succeeds (item is written using legacy format)
    assert put_response["ResponseMetadata"]["HTTPStatusCode"] == 200

    if not legacy_policy == LegacyPolicy.FORBID_LEGACY_ENCRYPT_FORBID_LEGACY_DECRYPT:
        # Given: Valid get_item request for the same item with ALLOW_LEGACY_DECRYPT policy
        # When: get_item using AWS DB-ESDK client
        get_response = encrypted_client.get_item(**get_item_request)
        # Then: Response is equal to the original item (AWS DB ESDK can decrypt legacy items)
        assert get_response["ResponseMetadata"]["HTTPStatusCode"] == 200
        # DynamoDB JSON uses lists to represent sets, so strict equality can fail.
        # Sort lists to ensure consistent ordering when comparing expected and actual items.
        expected_item = sort_dynamodb_json_lists(put_item_request["Item"])
        actual_item = sort_dynamodb_json_lists(get_response["Item"])
        assert expected_item == actual_item
    else:
        # Given: Valid get_item request for the same item with FORBID_LEGACY_DECRYPT policy
        # When: get_item using AWS DBE SDK client
        # Then: Throws a DynamoDbItemEncryptor exception (AWS DB-ESDK with FORBID policy cannot decrypt legacy items)
        with pytest.raises(DynamoDbItemEncryptor):
            encrypted_client.get_item(**get_item_request)


# Delete the items in the table after the module runs
@pytest.fixture(scope="module", autouse=True)
def cleanup_after_module(test_run_suffix):
    yield
    table = boto3.client("dynamodb")
    items = [deepcopy(simple_item_ddb), deepcopy(complex_item_ddb)]
    for item in items:
        item["partition_key"]["S"] += test_run_suffix
        table.delete_item(**basic_delete_item_request_ddb(item))
