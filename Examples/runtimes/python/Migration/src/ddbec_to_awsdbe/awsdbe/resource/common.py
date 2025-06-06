# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""Common Utilities for Migration Examples."""
import boto3
from aws_cryptographic_material_providers.mpl import AwsCryptographicMaterialProviders
from aws_cryptographic_material_providers.mpl.config import MaterialProvidersConfig
from aws_cryptographic_material_providers.mpl.models import (
    CreateAwsKmsMrkMultiKeyringInput,
    DBEAlgorithmSuiteId,
)
from aws_cryptographic_material_providers.mpl.references import IKeyring
from aws_dbesdk_dynamodb.encrypted.resource import EncryptedResource
from aws_dbesdk_dynamodb.structures.dynamodb import (
    DynamoDbTableEncryptionConfig,
    DynamoDbTablesEncryptionConfig,
    LegacyOverride,
)
from aws_dbesdk_dynamodb.structures.structured_encryption import (
    CryptoAction,
)

# Import from legacy DynamoDB Encryption Client
from dynamodb_encryption_sdk.encrypted.resource import EncryptedResource as LegacyEncryptedResource
from dynamodb_encryption_sdk.material_providers.aws_kms import AwsKmsCryptographicMaterialsProvider


def setup_pure_awsdbe_resource(kms_key_id: str, ddb_table_name: str):
    """
    Set up a pure AWS Database Encryption SDK EncryptedResource without legacy override.

    :param kms_key_id: The ARN of the KMS key to use for encryption
    :param ddb_table_name: The name of the DynamoDB table
    :returns EncryptedResource for DynamoDB
    """
    # 1. Create a Keyring. This Keyring will be responsible for protecting the data keys that protect your data.
    #    For this example, we will create a AWS KMS Keyring with the AWS KMS Key we want to use.
    #    We will use the `CreateMrkMultiKeyring` method to create this keyring,
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
    attribute_actions_on_encrypt = {
        "partition_key": CryptoAction.SIGN_ONLY,
        "sort_key": CryptoAction.SIGN_ONLY,
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
    unsignAttrPrefix: str = ":"

    # 4. Create the DynamoDb Encryption configuration for the table we will be writing to.
    #    without the legacy override
    table_configs = {}
    table_config = DynamoDbTableEncryptionConfig(
        logical_table_name=ddb_table_name,
        partition_key_name="partition_key",
        sort_key_name="sort_key",
        attribute_actions_on_encrypt=attribute_actions_on_encrypt,
        keyring=kms_mrk_multi_keyring,
        allowed_unsigned_attribute_prefix=unsignAttrPrefix,
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
    table_configs[ddb_table_name] = table_config
    tables_config = DynamoDbTablesEncryptionConfig(table_encryption_configs=table_configs)

    # 5. Create the EncryptedResource
    return EncryptedResource(
        resource=boto3.resource("dynamodb"),
        encryption_config=tables_config,
    )


def setup_awsdbe_resource_with_legacy_override(kms_key_id: str, ddb_table_name: str, policy: str):
    """
    Set up an AWS Database Encryption SDK EncryptedResource with legacy override.

    :param kms_key_id: The ARN of the KMS key to use for encryption
    :param ddb_table_name: The name of the DynamoDB table
    :param policy: The policy required for the Legacy Override configuration
    :returns EncryptedResource for DynamoDB

    """
    # 0. Create AWS SDK DynamoDB Resource
    ddb_resource = boto3.resource("dynamodb")

    # 1. Create the legacy EncryptedResource
    cmp = AwsKmsCryptographicMaterialsProvider(key_id=kms_key_id)
    legacy_encrypted_resource = LegacyEncryptedResource(
        resource=ddb_resource,
        materials_provider=cmp,
    )

    # 2. Configure our legacy behavior, inputting the DynamoDBEncryptor, attribute actions
    #    created above, and legacy policy.
    legacy_override = LegacyOverride(
        encryptor=legacy_encrypted_resource,
        attribute_actions_on_encrypt={
            "partition_key": CryptoAction.SIGN_ONLY,
            "sort_key": CryptoAction.SIGN_ONLY,
            "attribute1": CryptoAction.ENCRYPT_AND_SIGN,
            "attribute2": CryptoAction.SIGN_ONLY,
            ":attribute3": CryptoAction.DO_NOTHING,
        },
        policy=policy,
    )

    # 3. Create a Keyring. This Keyring will be responsible for protecting the data keys that protect your data.
    #    For this example, we will create a AWS KMS Keyring with the AWS KMS Key we want to use.
    #    We will use the `CreateMrkMultiKeyring` method to create this keyring,
    #    as it will correctly handle both single region and Multi-Region KMS Keys.
    mat_prov: AwsCryptographicMaterialProviders = AwsCryptographicMaterialProviders(config=MaterialProvidersConfig())
    kms_mrk_multi_keyring_input: CreateAwsKmsMrkMultiKeyringInput = CreateAwsKmsMrkMultiKeyringInput(
        generator=kms_key_id,
    )
    kms_mrk_multi_keyring: IKeyring = mat_prov.create_aws_kms_mrk_multi_keyring(input=kms_mrk_multi_keyring_input)

    # 4. Configure which attributes are encrypted and/or signed when writing new items.
    #    For each attribute that may exist on the items we plan to write to our DynamoDbTable,
    #    we must explicitly configure how they should be treated during item encryption:
    #      - ENCRYPT_AND_SIGN: The attribute is encrypted and included in the signature
    #      - SIGN_ONLY: The attribute not encrypted, but is still included in the signature
    #      - DO_NOTHING: The attribute is not encrypted and not included in the signature
    attribute_actions_on_encrypt = {
        "partition_key": CryptoAction.SIGN_ONLY,
        "sort_key": CryptoAction.SIGN_ONLY,
        "attribute1": CryptoAction.ENCRYPT_AND_SIGN,
        "attribute2": CryptoAction.SIGN_ONLY,
        ":attribute3": CryptoAction.DO_NOTHING,
    }

    # 5. Configure which attributes we expect to be included in the signature
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
    unsignAttrPrefix: str = ":"

    # 6. Create the DynamoDb Encryption configuration for the table we will be writing to.
    #    with the legacy override
    table_configs = {}
    table_config = DynamoDbTableEncryptionConfig(
        logical_table_name=ddb_table_name,
        partition_key_name="partition_key",
        sort_key_name="sort_key",
        attribute_actions_on_encrypt=attribute_actions_on_encrypt,
        keyring=kms_mrk_multi_keyring,
        legacy_override=legacy_override,
        allowed_unsigned_attribute_prefix=unsignAttrPrefix,
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
    table_configs[ddb_table_name] = table_config
    tables_config = DynamoDbTablesEncryptionConfig(table_encryption_configs=table_configs)

    # 7. Create the EncryptedResource
    return EncryptedResource(
        resource=boto3.resource("dynamodb"),
        encryption_config=tables_config,
    )
