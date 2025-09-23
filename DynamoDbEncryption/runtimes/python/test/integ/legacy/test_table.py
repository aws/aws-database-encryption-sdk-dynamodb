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

from ...constants import INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME
from ...items import (
    complex_item_dict,
    simple_item_dict,
)
from ...requests import basic_delete_item_request_dict, basic_get_item_request_dict, basic_put_item_request_dict
from .utils import (
    create_legacy_encrypted_client,
    create_legacy_encrypted_resource,
    create_legacy_encrypted_table,
    encrypted_table_with_legacy_override,
    legacy_actions,
)


@pytest.fixture(scope="module")
def test_run_suffix():
    return "-" + str(uuid.uuid4())


# Creates a matrix of tests for each value in param,
# with a user-friendly string for test output:
# use_complex_item = True -> "complex_item"
# use_complex_item = False -> "simple_item"
@pytest.fixture(params=[simple_item_dict, complex_item_dict], ids=["simple_item", "complex_item"])
def test_item(request, test_run_suffix):
    item = deepcopy(request.param)
    item["partition_key"] += test_run_suffix
    return item


# Fixtures for legacy encryptors and tables


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
def encrypted_table(legacy_encryptor, legacy_policy):
    """Create AWS DBE SDK table with specified legacy policy."""
    return encrypted_table_with_legacy_override(
        legacy_encryptor=legacy_encryptor,
        legacy_policy=legacy_policy,
    )


def test_GIVEN_awsdbe_encrypted_item_WHEN_get_with_legacy_table(
    encrypted_table,
    test_item,
    legacy_policy,
):
    # Given: Valid put_item request
    put_item_request_dict = basic_put_item_request_dict(test_item)
    # When: put_item
    put_response = encrypted_table.put_item(**put_item_request_dict)
    # Then: put_item succeeds
    assert put_response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # Given: Fresh legacy encryptor of the same type as used in the fixture
    legacy_encrypted_table = create_legacy_encrypted_table(
        attribute_actions=legacy_actions(),
    )

    # Get item request
    get_item_request_dict = basic_get_item_request_dict(test_item)

    if legacy_policy == LegacyPolicy.FORCE_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT:
        # Given: Valid get_item request for the same item using legacy encryptor with FORCE_LEGACY_ENCRYPT policy
        # When: get_item with legacy encryptor
        get_response = legacy_encrypted_table.get_item(**get_item_request_dict)
        # Then: Response is equal to the original item (legacy encryptor can decrypt item written by AWS DB-ESDK)
        assert get_response["ResponseMetadata"]["HTTPStatusCode"] == 200
        assert get_response["Item"] == put_item_request_dict["Item"]
    else:
        # Given: Valid get_item request for the same item using legacy encryptor with FORBID_LEGACY_ENCRYPT policy
        # When: get_item with legacy encryptor
        # Then: throws DecryptionError Exception (i.e. legacy encryptor cannot read values in new format)
        with pytest.raises(DecryptionError):  # The exact exception may vary in Python implementation
            # Try to read the item with the legacy encryptor
            legacy_encrypted_table.get_item(**get_item_request_dict)


def test_GIVEN_legacy_encrypted_item_WHEN_get_with_awsdbe(
    encrypted_table,
    test_item,
    legacy_policy,
):
    # Given: Fresh legacy encryptor and valid put_item request
    legacy_encrypted_table = create_legacy_encrypted_table(
        attribute_actions=legacy_actions(),
    )
    # Given: Valid put_item request
    put_item_request_dict = basic_put_item_request_dict(test_item)
    # When: put_item using legacy encryptor
    put_response = legacy_encrypted_table.put_item(**put_item_request_dict)
    # Then: put_item succeeds (item is written using legacy format)
    assert put_response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # Get item request
    get_item_request_dict = basic_get_item_request_dict(test_item)

    if not legacy_policy == LegacyPolicy.FORBID_LEGACY_ENCRYPT_FORBID_LEGACY_DECRYPT:
        # Given: Valid get_item request for the same item with ALLOW_LEGACY_DECRYPT policy
        # When: get_item using AWS DB-ESDK client
        get_response = encrypted_table.get_item(**get_item_request_dict)
        # Then: Table can read the legacy-encrypted item
        assert get_response["ResponseMetadata"]["HTTPStatusCode"] == 200
        assert get_response["Item"] == put_item_request_dict["Item"]
    else:
        # Given: Valid get_item request for the same item with FORBID_LEGACY_DECRYPT policy
        # When: get_item using AWS DB-ESDK client
        # Then: Throws a DynamoDbItemEncryptor exception (AWS DB-ESDK with FORBID policy cannot decrypt legacy items)
        with pytest.raises(DynamoDbItemEncryptor):
            encrypted_table.get_item(**get_item_request_dict)


# Delete the items in the table after the module runs
@pytest.fixture(scope="module", autouse=True)
def cleanup_after_module(test_run_suffix):
    yield
    table = boto3.resource("dynamodb").Table(INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME)
    items = [deepcopy(simple_item_dict), deepcopy(complex_item_dict)]
    for item in items:
        item["partition_key"] = item["partition_key"] + test_run_suffix
        table.delete_item(**basic_delete_item_request_dict(item))
