# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""
Set up an ItemEncryptor and use its APIs to encrypt and decrypt items in 3 different formats.

You should use the ItemEncryptor
if you already have an item to encrypt or decrypt,
and do not need to make a Put or Get call to DynamoDb.
For example, if you are using DynamoDb Streams,
you may already be working with an encrypted item obtained from
DynamoDb, and want to directly decrypt the item.

This example demonstrates the 3 formats the Item Encryptor can accept:
- Python dictionaries (encrypt_python_item, decrypt_python_item)
- DynamoDB JSON (encrypt_dynamodb_item, decrypt_dynamodb_item)
- DBESDK shapes (encrypt_item, decrypt_item)

Running this example requires access to the DDB Table whose name
is provided in CLI arguments.
This table must be configured with the following
primary key configuration:
  - Partition key is named "partition_key" with type (S)
  - Sort key is named "sort_key" with type (S)
"""

from typing import Any, Dict

from aws_cryptographic_material_providers.mpl import AwsCryptographicMaterialProviders
from aws_cryptographic_material_providers.mpl.config import MaterialProvidersConfig
from aws_cryptographic_material_providers.mpl.models import (
    CreateAwsKmsMrkMultiKeyringInput,
    DBEAlgorithmSuiteId,
)
from aws_cryptographic_material_providers.mpl.references import IKeyring
from aws_dbesdk_dynamodb.encrypted.item import (
    DecryptItemInput,
    DynamoDbItemEncryptorConfig,
    EncryptItemInput,
    ItemEncryptor,
)
from aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.models import (
    CryptoAction,
)


def encrypt_decrypt_example(kms_key_id: str, ddb_table_name: str) -> None:
    """Encrypt and decrypt an item with an ItemEncryptor."""
    # 1. Create a Keyring. This Keyring will be responsible for protecting the data keys that protect your data.
    #    For this example, we will create a AWS KMS Keyring with the AWS KMS Key we want to use.
    #    We will use the `CreateAwsKmsMrkMultiKeyringInput` method to create this keyring,
    #    as it will correctly handle both single region and Multi-Region KMS Keys.
    mat_prov: AwsCryptographicMaterialProviders = AwsCryptographicMaterialProviders(config=MaterialProvidersConfig())
    kms_mrk_multi_keyring_input: CreateAwsKmsMrkMultiKeyringInput = CreateAwsKmsMrkMultiKeyringInput(
        generator=kms_key_id,
    )
    kms_mrk_multi_keyring: IKeyring = mat_prov.create_aws_kms_mrk_multi_keyring(input=kms_mrk_multi_keyring_input)

    # 2. Configure which attributes are encrypted and/or signed when writing new items.
    #    For each attribute that may exist on the items we plan to write to our DynamoDbTable,
    #    we must explicitly configure how they should be treated during item encryption:
    #      - ENCRYPT_AND_SIGN: The attribute is encrypted and included in the signature
    #      - SIGN_ONLY: The attribute not encrypted, but is still included in the signature
    #      - DO_NOTHING: The attribute is not encrypted and not included in the signature
    attribute_actions_on_encrypt: Dict[str, str] = {
        "partition_key": CryptoAction.SIGN_ONLY,  # Our partition attribute must be SIGN_ONLY
        "sort_key": CryptoAction.SIGN_ONLY,  # Our sort attribute must be SIGN_ONLY
        "attribute1": CryptoAction.ENCRYPT_AND_SIGN,
        "attribute2": CryptoAction.SIGN_ONLY,
        ":attribute3": CryptoAction.DO_NOTHING,
    }

    # 3. Configure which attributes we expect to be included in the signature
    #    when reading items. There are two options for configuring this:
    #
    #    - (Recommended) Configure `allowedUnsignedAttributesPrefix`:
    #      When defining your DynamoDb schema and deciding on attribute names,
    #      choose a distinguishing prefix (such as ":") for all attributes that
    #      you do not want to include in the signature.
    #      This has two main benefits:
    #      - It is easier to reason about the security and authenticity of data within your item
    #        when all unauthenticated data is easily distinguishable by their attribute name.
    #      - If you need to add new unauthenticated attributes in the future,
    #        you can easily make the corresponding update to your `attributeActionsOnEncrypt`
    #        and immediately start writing to that new attribute, without
    #        any other configuration update needed.
    #      Once you configure this field, it is not safe to update it.
    #
    #    - Configure `allowedUnsignedAttributes`: You may also explicitly list
    #      a set of attributes that should be considered unauthenticated when encountered
    #      on read. Be careful if you use this configuration. Do not remove an attribute
    #      name from this configuration, even if you are no longer writing with that attribute,
    #      as old items may still include this attribute, and our configuration needs to know
    #      to continue to exclude this attribute from the signature scope.
    #      If you add new attribute names to this field, you must first deploy the update to this
    #      field to all readers in your host fleet before deploying the update to start writing
    #      with that new attribute.
    #
    #   For this example, we have designed our DynamoDb table such that any attribute name with
    #   the ":" prefix should be considered unauthenticated.
    unsign_attr_prefix = ":"

    # 4. Create the configuration for the DynamoDb Item Encryptor
    config = DynamoDbItemEncryptorConfig(
        logical_table_name=ddb_table_name,
        partition_key_name="partition_key",
        sort_key_name="sort_key",
        attribute_actions_on_encrypt=attribute_actions_on_encrypt,
        keyring=kms_mrk_multi_keyring,
        allowed_unsigned_attribute_prefix=unsign_attr_prefix,
        # Specifying an algorithm suite is not required,
        # but is done here to demonstrate how to do so.
        # We suggest using the
        # `ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_ECDSA_P384_SYMSIG_HMAC_SHA384` suite,
        # which includes AES-GCM with key derivation, signing, and key commitment.
        # This is also the default algorithm suite if one is not specified in this config.
        # For more information on supported algorithm suites, see:
        #   https://docs.aws.amazon.com/database-encryption-sdk/latest/devguide/supported-algorithms.html
        algorithm_suite_id=DBEAlgorithmSuiteId.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_ECDSA_P384_SYMSIG_HMAC_SHA384,
    )

    # 5. Create the DynamoDb Item Encryptor
    item_encryptor = ItemEncryptor(config)

    # 6. Directly encrypt a Python dictionary item using the ItemEncryptor
    plaintext_dict_item: Dict[str, Any] = {
        "partition_key": "ItemEncryptDecryptExample",
        "sort_key": 0,
        "attribute1": "encrypt and sign me!",
        "attribute2": "sign me!",
        ":attribute3": "ignore me!",
    }

    encrypt_output = item_encryptor.encrypt_python_item(plaintext_dict_item)
    encrypted_dict_item = encrypt_output.encrypted_item

    # Demonstrate that the item has been encrypted according to the configuration
    # Our configuration specified that the partition key should be SIGN_ONLY,
    # so it should not have been encrypted
    assert encrypted_dict_item["partition_key"] == "ItemEncryptDecryptExample"
    # Our configuration specified that the sort key should be SIGN_ONLY,
    # so it should not have been encrypted
    assert encrypted_dict_item["sort_key"] == 0
    # Our configuration specified that attribute1 should be ENCRYPT_AND_SIGN,
    # so it should have been encrypted
    assert "attribute1" in encrypted_dict_item
    assert encrypted_dict_item["attribute1"] != plaintext_dict_item["attribute1"]

    # 7. Directly decrypt the encrypted item using the DynamoDb Item Encryptor
    decrypt_output = item_encryptor.decrypt_python_item(encrypted_dict_item)
    decrypted_dict_item = decrypt_output.plaintext_item

    # Demonstrate that GetItem succeeded and returned the decrypted item
    assert decrypted_dict_item["partition_key"] == "ItemEncryptDecryptExample"
    assert decrypted_dict_item["sort_key"] == 0
    assert decrypted_dict_item["attribute1"] == "encrypt and sign me!"

    # 8. Directly encrypt a DynamoDB JSON item using the ItemEncryptor
    plaintext_dynamodb_item: Dict[str, Any] = {
        "partition_key": {"S": "ItemEncryptDecryptExample"},
        "sort_key": {"N": "0"},
        "attribute1": {"S": "encrypt and sign me!"},
        "attribute2": {"S": "sign me!"},
        ":attribute3": {"S": "ignore me!"},
    }
    encrypt_output = item_encryptor.encrypt_dynamodb_item(plaintext_dynamodb_item)
    encrypted_dynamodb_item = encrypt_output.encrypted_item

    # Demonstrate that the item has been encrypted according to the configuration
    # Our configuration specified that the partition key should be SIGN_ONLY,
    # so it should not have been encrypted
    assert encrypted_dynamodb_item["partition_key"] == {"S": "ItemEncryptDecryptExample"}
    # Our configuration specified that the sort key should be SIGN_ONLY,
    # so it should not have been encrypted
    assert encrypted_dynamodb_item["sort_key"] == {"N": "0"}
    # Our configuration specified that attribute1 should be ENCRYPT_AND_SIGN,
    # so it should have been encrypted
    assert "attribute1" in encrypted_dynamodb_item
    assert encrypted_dynamodb_item["attribute1"] != plaintext_dynamodb_item["attribute1"]

    # 9. Directly decrypt the encrypted item using the DynamoDb Item Encryptor
    decrypt_output = item_encryptor.decrypt_dynamodb_item(encrypted_dynamodb_item)
    decrypted_dynamodb_item = decrypt_output.plaintext_item

    # Demonstrate that GetItem succeeded and returned the decrypted item
    assert decrypted_dynamodb_item["partition_key"] == {"S": "ItemEncryptDecryptExample"}
    assert decrypted_dynamodb_item["sort_key"] == {"N": "0"}
    assert decrypted_dynamodb_item["attribute1"] == {"S": "encrypt and sign me!"}

    # 10. Directly encrypt a DBESDK shape item using the ItemEncryptor
    encrypt_item_input: EncryptItemInput = EncryptItemInput(plaintext_item=plaintext_dynamodb_item)
    encrypt_item_output = item_encryptor.encrypt_item(encrypt_item_input)
    encrypted_item = encrypt_item_output.encrypted_item

    # Demonstrate that the item has been encrypted according to the configuration
    # Our configuration specified that the partition key should be SIGN_ONLY,
    # so it should not have been encrypted
    assert encrypted_item["partition_key"] == {"S": "ItemEncryptDecryptExample"}
    # Our configuration specified that the sort key should be SIGN_ONLY,
    # so it should not have been encrypted
    assert encrypted_item["sort_key"] == {"N": "0"}
    # Our configuration specified that attribute1 should be ENCRYPT_AND_SIGN,
    # so it should have been encrypted
    assert "attribute1" in encrypted_item
    assert encrypted_item["attribute1"] != plaintext_dynamodb_item["attribute1"]

    # 11. Directly decrypt the encrypted item using the DynamoDb Item Encryptor
    decrypt_item_input: DecryptItemInput = DecryptItemInput(encrypted_item=encrypted_item)
    decrypt_output = item_encryptor.decrypt_item(decrypt_item_input)
    decrypted_item = decrypt_output.plaintext_item

    # Demonstrate that GetItem succeeded and returned the decrypted item
    assert decrypted_item["partition_key"] == {"S": "ItemEncryptDecryptExample"}
    assert decrypted_item["sort_key"] == {"N": "0"}
    assert decrypted_item["attribute1"] == {"S": "encrypt and sign me!"}
