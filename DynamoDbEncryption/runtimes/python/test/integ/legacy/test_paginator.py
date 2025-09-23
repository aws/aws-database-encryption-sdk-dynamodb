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
    basic_put_item_request_ddb,
    basic_put_item_request_dict,
    basic_query_paginator_request,
    basic_scan_paginator_request,
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


@pytest.fixture
def paginate_scan_request(expect_standard_dictionaries, test_item):
    """Get a scan paginator request in the appropriate format for the client."""
    if expect_standard_dictionaries:
        request = {**basic_scan_paginator_request(test_item), "TableName": INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME}
    else:
        request = basic_scan_paginator_request(test_item)
    return request


# Fixtures for legacy encryptors and clients


@pytest.fixture(params=["client", "table", "resource"], ids=["legacy_client", "legacy_table", "legacy_resource"])
def legacy_encryptor(request):
    """
    Create a legacy encryptor of the specified type.

    This fixture creates legacy encryptors of three types:
    - client: DynamoDB Encryption Client's EncryptedClient
    - table: DynamoDB Encryption Client's EncryptedTable
    - resource: DynamoDB Encryption Client's EncryptedResource
    """
    if request.param == "client":
        return create_legacy_encrypted_client()
    elif request.param == "table":
        return create_legacy_encrypted_table()
    elif request.param == "resource":
        return create_legacy_encrypted_resource()


# Fixtures for each legacy policy
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


@pytest.fixture
def client_legacy_force_encrypt_allow_decrypt(legacy_encryptor, expect_standard_dictionaries):
    """Create AWS DBE SDK client with FORCE_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT policy."""
    return encrypted_client_with_legacy_override(
        legacy_encryptor=legacy_encryptor,
        legacy_policy=LegacyPolicy.FORCE_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT,
        expect_standard_dictionaries=expect_standard_dictionaries,
    )


def test_GIVEN_awsdbe_encrypted_item_WHEN_paginate_with_legacy_query_paginator(
    encrypted_client, put_item_request, paginate_query_request, test_item, legacy_policy, expect_standard_dictionaries
):
    # Given: Valid put_item request
    # When: put_item using AWS DB-ESDK client
    put_response = encrypted_client.put_item(**put_item_request)
    # Then: Item is stored in the table
    assert put_response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # Given: Fresh legacy encrypted client and query paginator
    legacy_encrypted_client = create_legacy_encrypted_client(
        attribute_actions=legacy_actions(),
        expect_standard_dictionaries=expect_standard_dictionaries,
    )
    legacy_query_paginator = legacy_encrypted_client.get_paginator("query")

    if legacy_policy == LegacyPolicy.FORCE_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT:
        # When: Paginate with legacy query paginator using FORCE_LEGACY_ENCRYPT policy
        # Then: Legacy paginator can read and decrypt items
        response = legacy_query_paginator.paginate(**paginate_query_request)
        items = []
        for page in response:
            if "Items" in page:
                for item in page["Items"]:
                    items.append(item)

        assert len(items) == 1
        expected_item = sort_dynamodb_json_lists(test_item)
        legacy_actual_item = sort_dynamodb_json_lists(items[0])
        assert expected_item == legacy_actual_item
    else:
        # When: Paginate with legacy query paginator using FORBID policies
        # Then: Legacy paginator cannot decrypt items created with FORBID_LEGACY_ENCRYPT policy
        with pytest.raises(DecryptionError):
            response = legacy_query_paginator.paginate(**paginate_query_request)
            items = []
            for page in response:
                if "Items" in page:
                    for item in page["Items"]:
                        items.append(item)


def test_GIVEN_awsdbe_encrypted_item_WHEN_paginate_with_legacy_scan_paginator(
    encrypted_client, put_item_request, paginate_scan_request, test_item, legacy_policy, expect_standard_dictionaries
):
    # Given: Valid put_item request
    # When: put_item using AWS DB-ESDK client
    put_response = encrypted_client.put_item(**put_item_request)
    # Then: Item is stored in the table
    assert put_response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # Given: Fresh legacy encrypted client and scan paginator
    legacy_encrypted_client = create_legacy_encrypted_client(
        attribute_actions=legacy_actions(),
        expect_standard_dictionaries=expect_standard_dictionaries,
    )
    legacy_scan_paginator = legacy_encrypted_client.get_paginator("scan")

    if legacy_policy == LegacyPolicy.FORCE_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT:
        # When: Paginate with legacy scan paginator using FORCE_LEGACY_ENCRYPT policy
        # Then: Legacy paginator can read and decrypt items
        response = legacy_scan_paginator.paginate(**paginate_scan_request)
        items = []
        for page in response:
            if "Items" in page:
                for item in page["Items"]:
                    items.append(item)

        assert len(items) == 1
        expected_item = sort_dynamodb_json_lists(test_item)
        legacy_actual_item = sort_dynamodb_json_lists(items[0])
        assert expected_item == legacy_actual_item
    else:
        # When: Paginate with legacy scan paginator using FORBID policies
        # Then: Legacy paginator cannot decrypt items created with FORBID_LEGACY_ENCRYPT policy
        with pytest.raises(DecryptionError):
            response = legacy_scan_paginator.paginate(**paginate_scan_request)
            items = []
            for page in response:
                if "Items" in page:
                    for item in page["Items"]:
                        items.append(item)


def test_GIVEN_legacy_encrypted_item_WHEN_paginate_with_awsdbe_query_paginator(
    encrypted_client, put_item_request, paginate_query_request, test_item, legacy_policy, expect_standard_dictionaries
):
    # Given: Fresh legacy encrypted client and valid put_item request
    legacy_encrypted_client = create_legacy_encrypted_client(
        attribute_actions=legacy_actions(),
        expect_standard_dictionaries=expect_standard_dictionaries,
    )
    # When: put_item using legacy client
    legacy_encrypted_client.put_item(**put_item_request)
    # Then: Item is stored in the table

    # Given: Query paginator with AWS DB-ESDK client
    query_paginator = encrypted_client.get_paginator("query")

    if not legacy_policy == LegacyPolicy.FORBID_LEGACY_ENCRYPT_FORBID_LEGACY_DECRYPT:
        # When: Paginate with AWS DB-ESDK query paginator using ALLOW_LEGACY_DECRYPT policies
        # Then: AWS DB-ESDK paginator can read the legacy-encrypted item
        response = query_paginator.paginate(**paginate_query_request)
        items = []
        for page in response:
            if "Items" in page:
                for item in page["Items"]:
                    items.append(item)

        assert len(items) == 1
        expected_item = sort_dynamodb_json_lists(test_item)
        actual_item = sort_dynamodb_json_lists(items[0])
        assert expected_item == actual_item
    else:
        # Given: Valid paginate request with FORBID_LEGACY_DECRYPT policy
        # When: Paginate with AWS DB-ESDK client
        # Then: Throws a DynamoDbItemEncryptor exception (AWS DB-ESDK with FORBID policy cannot decrypt legacy items)
        with pytest.raises(DynamoDbItemEncryptor):
            response = query_paginator.paginate(**paginate_query_request)
            items = []
            for page in response:
                if "Items" in page:
                    for item in page["Items"]:
                        items.append(item)


def test_GIVEN_legacy_encrypted_item_WHEN_paginate_with_awsdbe_scan_paginator(
    encrypted_client, put_item_request, paginate_scan_request, test_item, legacy_policy, expect_standard_dictionaries
):
    # Given: Fresh legacy encrypted client and valid put_item request
    legacy_encrypted_client = create_legacy_encrypted_client(
        attribute_actions=legacy_actions(),
        expect_standard_dictionaries=expect_standard_dictionaries,
    )
    # When: put_item using legacy client
    legacy_encrypted_client.put_item(**put_item_request)
    # Then: Item is stored in the table

    # Given: Scan paginator with AWS DB-ESDK client
    scan_paginator = encrypted_client.get_paginator("scan")

    if not legacy_policy == LegacyPolicy.FORBID_LEGACY_ENCRYPT_FORBID_LEGACY_DECRYPT:
        # When: Paginate with AWS DB-ESDK scan paginator using ALLOW_LEGACY_DECRYPT policies
        # Then: AWS DB-ESDK paginator can read the legacy-encrypted item
        response = scan_paginator.paginate(**paginate_scan_request)
        items = []
        for page in response:
            if "Items" in page:
                for item in page["Items"]:
                    items.append(item)

        assert len(items) == 1
        expected_item = sort_dynamodb_json_lists(test_item)
        actual_item = sort_dynamodb_json_lists(items[0])
        assert expected_item == actual_item
    else:
        # Given: Valid paginate request with FORBID_LEGACY_DECRYPT policy
        # When: Paginate with AWS DB-ESDK client
        # Then: Throws a DynamoDbItemEncryptor exception (AWS DB-ESDK with FORBID policy cannot decrypt legacy items)
        with pytest.raises(DynamoDbItemEncryptor):
            response = scan_paginator.paginate(**paginate_scan_request)
            items = []
            for page in response:
                if "Items" in page:
                    for item in page["Items"]:
                        items.append(item)


# Delete the items in the table after the module runs
@pytest.fixture(scope="module", autouse=True)
def cleanup_after_module(test_run_suffix):
    yield
    table = boto3.client("dynamodb")
    items = [deepcopy(simple_item_ddb), deepcopy(complex_item_ddb)]
    for item in items:
        item["partition_key"]["S"] += test_run_suffix
        table.delete_item(**basic_delete_item_request_ddb(item))
