# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""Integration tests for the ItemEncryptor."""
import pytest

from aws_dbesdk_dynamodb.encrypted.item import ItemEncryptor
from aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor.models import (
    DecryptItemInput,
    EncryptItemInput,
)

from ...constants import INTEG_TEST_DEFAULT_ITEM_ENCRYPTOR_CONFIG
from ...items import complex_item_ddb, complex_item_dict, simple_item_ddb, simple_item_dict


# Creates a matrix of tests for each value in param,
# with a user-friendly string for test output:
# use_complex_item = True -> "complex_item"
# use_complex_item = False -> "simple_item"
@pytest.fixture(params=[True, False], ids=["complex_item", "simple_item"])
def use_complex_item(request):
    return request.param


@pytest.fixture
def test_dict_item(use_complex_item):
    if use_complex_item:
        return complex_item_dict
    return simple_item_dict


@pytest.fixture
def test_ddb_item(use_complex_item):
    if use_complex_item:
        return complex_item_ddb
    return simple_item_ddb


item_encryptor = ItemEncryptor(INTEG_TEST_DEFAULT_ITEM_ENCRYPTOR_CONFIG)


def test_GIVEN_valid_dict_item_WHEN_encrypt_python_item_AND_decrypt_python_item_THEN_round_trip_passes(test_dict_item):
    # Given: Valid dict item
    # When: encrypt_python_item
    encrypted_dict_item = item_encryptor.encrypt_python_item(test_dict_item).encrypted_item
    # Then: Encrypted dict item is returned
    assert encrypted_dict_item != test_dict_item
    # When: decrypt_python_item
    decrypted_dict_item = item_encryptor.decrypt_python_item(encrypted_dict_item).plaintext_item
    # Then: Decrypted dict item is returned and matches the original item
    assert decrypted_dict_item == test_dict_item


def test_GIVEN_valid_ddb_item_WHEN_encrypt_dynamodb_item_AND_decrypt_dynamodb_item_THEN_round_trip_passes(
    test_ddb_item,
):
    # Given: Valid ddb item
    # When: encrypt_dynamodb_item
    encrypted_ddb_item = item_encryptor.encrypt_dynamodb_item(test_ddb_item).encrypted_item
    # Then: Encrypted ddb item is returned
    assert encrypted_ddb_item != test_ddb_item
    # When: decrypt_dynamodb_item
    decrypted_ddb_item = item_encryptor.decrypt_dynamodb_item(encrypted_ddb_item).plaintext_item
    # Then: Decrypted ddb item is returned and matches the original item
    assert decrypted_ddb_item == test_ddb_item


def test_GIVEN_valid_encrypt_item_input_WHEN_encrypt_item_AND_decrypt_item_THEN_round_trip_passes(test_ddb_item):
    # Given: Valid encrypt_item_input
    encrypt_item_input = EncryptItemInput(plaintext_item=test_ddb_item)
    # When: encrypt_item
    encrypted_item = item_encryptor.encrypt_item(encrypt_item_input).encrypted_item
    # Then: Encrypted item is returned
    assert encrypted_item != test_ddb_item
    # When: decrypt_item
    decrypt_item_input = DecryptItemInput(encrypted_item=encrypted_item)
    decrypted_item = item_encryptor.decrypt_item(decrypt_item_input).plaintext_item
    # Then: Decrypted item is returned and matches the original item
    assert decrypted_item == test_ddb_item
