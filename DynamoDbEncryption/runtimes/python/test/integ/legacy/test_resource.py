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
    complex_key_dict,
    simple_item_ddb,
    simple_item_dict,
    simple_key_dict,
)
from ...requests import (
    basic_batch_get_item_request_dict,
    basic_batch_write_item_put_request_dict,
    basic_delete_item_request_ddb,
)
from .utils import (
    create_legacy_encrypted_client,
    create_legacy_encrypted_resource,
    create_legacy_encrypted_table,
    encrypted_resource_with_legacy_override,
    legacy_actions,
)


@pytest.fixture
def tables(resource):
    return resource.tables


@pytest.fixture(scope="module")
def test_run_suffix():
    return "-" + str(uuid.uuid4())


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


@pytest.fixture(
    params=[
        LegacyPolicy.FORCE_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT,
        LegacyPolicy.FORBID_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT,
        LegacyPolicy.FORBID_LEGACY_ENCRYPT_FORBID_LEGACY_DECRYPT,
    ]
)
def legacy_policy(request):
    """Fixture providing different legacy policies to test."""
    return request.param


@pytest.fixture
def encrypted_resource(legacy_encryptor, legacy_policy):
    """Create AWS DBE SDK resource with specified legacy policy."""
    return encrypted_resource_with_legacy_override(
        legacy_encryptor=legacy_encryptor,
        legacy_policy=legacy_policy,
    )


def test_GIVEN_awsdbe_encrypted_item_WHEN_get_with_legacy_resource(
    encrypted_resource,
    test_items,
    test_keys,
    legacy_policy,
):
    # Given: Valid batch_write_item request with items to put
    batch_write_item_put_request = basic_batch_write_item_put_request_dict(test_items)
    # When: batch_write_item using AWS DB-ESDK resource
    batch_write_response = encrypted_resource.batch_write_item(**batch_write_item_put_request)
    # Then: batch_write_item succeeds
    assert batch_write_response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # Given: Fresh legacy encrypted resource and valid batch_get request
    legacy_resource = create_legacy_encrypted_resource(attribute_actions=legacy_actions())
    batch_get_item_request = basic_batch_get_item_request_dict(test_keys)

    if legacy_policy == LegacyPolicy.FORCE_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT:
        # When: batch_get_item with legacy resource using FORCE_LEGACY_ENCRYPT policy
        # Then: Items can be decrypted by legacy resource
        batch_get_response = legacy_resource.batch_get_item(**batch_get_item_request)
        assert batch_get_response["ResponseMetadata"]["HTTPStatusCode"] == 200
        responses = batch_get_response["Responses"][INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME]
        assert len(responses) == 2
        for response in responses:
            assert response in test_items
    else:
        # When: batch_get_item with legacy resource using FORBID policies
        # Then: Legacy resource cannot decrypt items created with FORBID_LEGACY_ENCRYPT policy
        with pytest.raises(DecryptionError):
            legacy_resource.batch_get_item(**batch_get_item_request)


def test_GIVEN_legacy_encrypted_item_WHEN_get_with_awsdbe_resource(
    encrypted_resource,
    test_items,
    test_keys,
    legacy_policy,
):
    # Given: Fresh legacy encrypted resource and valid batch_write request
    legacy_resource = create_legacy_encrypted_resource(attribute_actions=legacy_actions())

    # When: batch_write_item using legacy resource
    batch_write_item_put_request = basic_batch_write_item_put_request_dict(test_items)
    batch_write_response = legacy_resource.batch_write_item(**batch_write_item_put_request)
    # Then: batch_write_item succeeds
    assert batch_write_response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # Create batch_get request
    batch_get_item_request = basic_batch_get_item_request_dict(test_keys)

    if not legacy_policy == LegacyPolicy.FORBID_LEGACY_ENCRYPT_FORBID_LEGACY_DECRYPT:
        # Given: Valid batch_get_item request for the same items with ALLOW_LEGACY_DECRYPT policy
        # When: batch_get_item using AWS DB-ESDK resource
        batch_get_response = encrypted_resource.batch_get_item(**batch_get_item_request)
        # Then: Legacy resource can decrypt items created with FORCE_LEGACY_ENCRYPT policy
        assert batch_get_response["ResponseMetadata"]["HTTPStatusCode"] == 200
        responses = batch_get_response["Responses"][INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME]
        assert len(responses) == 2
        for response in responses:
            assert response in test_items
    else:
        # Given: Valid get_item request for the same item with FORBID_LEGACY_DECRYPT policy
        # When: get_item using AWS DB-ESDK client
        # Then: Throws DynamoDbItemEncryptor exception (AWS DB-ESDK with FORBID policy cannot decrypt legacy items)
        with pytest.raises(DynamoDbItemEncryptor):
            encrypted_resource.batch_get_item(**batch_get_item_request)


# Delete the items in the table after the module runs
@pytest.fixture(scope="module", autouse=True)
def cleanup_after_module(test_run_suffix):
    yield
    table = boto3.client("dynamodb")
    items = [deepcopy(simple_item_ddb), deepcopy(complex_item_ddb)]
    for item in items:
        item["partition_key"]["S"] += test_run_suffix
        table.delete_item(**basic_delete_item_request_ddb(item))
