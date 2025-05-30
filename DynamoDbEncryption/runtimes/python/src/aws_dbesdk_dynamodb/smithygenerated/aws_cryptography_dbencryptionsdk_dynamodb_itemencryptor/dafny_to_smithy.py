# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
# Do not modify this file. This file is machine generated, and any changes to it will be overwritten.

import aws_cryptographic_material_providers.smithygenerated.aws_cryptography_materialproviders.dafny_to_smithy
import aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk
import aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.dafny_to_smithy
import aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor.dafny_to_smithy
import aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor.models
import aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.dafny_to_smithy


def aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor_EncryptItemInput(
    dafny_input,
):
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor.models.EncryptItemInput(
        plaintext_item={
            b"".join(ord(c).to_bytes(2, "big") for c in key).decode(
                "utf-16-be"
            ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_AttributeValue(
                value
            )
            for (key, value) in dafny_input.plaintextItem.items
        },
    )


def aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor_DecryptItemInput(
    dafny_input,
):
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor.models.DecryptItemInput(
        encrypted_item={
            b"".join(ord(c).to_bytes(2, "big") for c in key).decode(
                "utf-16-be"
            ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_AttributeValue(
                value
            )
            for (key, value) in dafny_input.encryptedItem.items
        },
    )


def aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor_ParsedHeader(dafny_input):
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor.models.ParsedHeader(
        attribute_actions_on_encrypt={
            b"".join(ord(c).to_bytes(2, "big") for c in key).decode(
                "utf-16-be"
            ): aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.dafny_to_smithy.aws_cryptography_dbencryptionsdk_structuredencryption_CryptoAction(
                value
            )
            for (key, value) in dafny_input.attributeActionsOnEncrypt.items
        },
        algorithm_suite_id=aws_cryptographic_material_providers.smithygenerated.aws_cryptography_materialproviders.dafny_to_smithy.aws_cryptography_materialproviders_DBEAlgorithmSuiteId(
            dafny_input.algorithmSuiteId
        ),
        encrypted_data_keys=[
            aws_cryptographic_material_providers.smithygenerated.aws_cryptography_materialproviders.dafny_to_smithy.aws_cryptography_materialproviders_EncryptedDataKey(
                list_element
            )
            for list_element in dafny_input.encryptedDataKeys
        ],
        stored_encryption_context={
            bytes(key.Elements).decode("utf-8"): bytes(value.Elements).decode("utf-8")
            for (key, value) in dafny_input.storedEncryptionContext.items
        },
        encryption_context={
            bytes(key.Elements).decode("utf-8"): bytes(value.Elements).decode("utf-8")
            for (key, value) in dafny_input.encryptionContext.items
        },
        selector_context={
            b"".join(ord(c).to_bytes(2, "big") for c in key).decode(
                "utf-16-be"
            ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_AttributeValue(
                value
            )
            for (key, value) in dafny_input.selectorContext.items
        },
    )


def aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor_EncryptItemOutput(
    dafny_input,
):
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor.models.EncryptItemOutput(
        encrypted_item={
            b"".join(ord(c).to_bytes(2, "big") for c in key).decode(
                "utf-16-be"
            ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_AttributeValue(
                value
            )
            for (key, value) in dafny_input.encryptedItem.items
        },
        parsed_header=(
            (
                aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor_ParsedHeader(
                    dafny_input.parsedHeader.value
                )
            )
            if (dafny_input.parsedHeader.is_Some)
            else None
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor_DecryptItemOutput(
    dafny_input,
):
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor.models.DecryptItemOutput(
        plaintext_item={
            b"".join(ord(c).to_bytes(2, "big") for c in key).decode(
                "utf-16-be"
            ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_AttributeValue(
                value
            )
            for (key, value) in dafny_input.plaintextItem.items
        },
        parsed_header=(
            (
                aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor_ParsedHeader(
                    dafny_input.parsedHeader.value
                )
            )
            if (dafny_input.parsedHeader.is_Some)
            else None
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor_AtomicPrimitivesReference(
    dafny_input,
):
    from aws_cryptography_primitives.smithygenerated.aws_cryptography_primitives.client import (
        AwsCryptographicPrimitives,
    )

    return AwsCryptographicPrimitives(config=None, dafny_client=dafny_input)


def aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor_DynamoDbItemEncryptorConfig(
    dafny_input,
):
    # Deferred import of .config to avoid circular dependency
    import aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor.config

    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor.config.DynamoDbItemEncryptorConfig(
        logical_table_name=b"".join(ord(c).to_bytes(2, "big") for c in dafny_input.logicalTableName).decode(
            "utf-16-be"
        ),
        partition_key_name=b"".join(ord(c).to_bytes(2, "big") for c in dafny_input.partitionKeyName).decode(
            "utf-16-be"
        ),
        sort_key_name=(
            (b"".join(ord(c).to_bytes(2, "big") for c in dafny_input.sortKeyName.value).decode("utf-16-be"))
            if (dafny_input.sortKeyName.is_Some)
            else None
        ),
        attribute_actions_on_encrypt={
            b"".join(ord(c).to_bytes(2, "big") for c in key).decode(
                "utf-16-be"
            ): aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.dafny_to_smithy.aws_cryptography_dbencryptionsdk_structuredencryption_CryptoAction(
                value
            )
            for (key, value) in dafny_input.attributeActionsOnEncrypt.items
        },
        allowed_unsigned_attributes=(
            (
                [
                    b"".join(ord(c).to_bytes(2, "big") for c in list_element).decode("utf-16-be")
                    for list_element in dafny_input.allowedUnsignedAttributes.value
                ]
            )
            if (dafny_input.allowedUnsignedAttributes.is_Some)
            else None
        ),
        allowed_unsigned_attribute_prefix=(
            (
                b"".join(ord(c).to_bytes(2, "big") for c in dafny_input.allowedUnsignedAttributePrefix.value).decode(
                    "utf-16-be"
                )
            )
            if (dafny_input.allowedUnsignedAttributePrefix.is_Some)
            else None
        ),
        algorithm_suite_id=(
            (
                aws_cryptographic_material_providers.smithygenerated.aws_cryptography_materialproviders.dafny_to_smithy.aws_cryptography_materialproviders_DBEAlgorithmSuiteId(
                    dafny_input.algorithmSuiteId.value
                )
            )
            if (dafny_input.algorithmSuiteId.is_Some)
            else None
        ),
        keyring=(
            (
                aws_cryptographic_material_providers.smithygenerated.aws_cryptography_materialproviders.dafny_to_smithy.aws_cryptography_materialproviders_KeyringReference(
                    dafny_input.keyring.UnwrapOr(None)
                )
            )
            if (dafny_input.keyring.UnwrapOr(None) is not None)
            else None
        ),
        cmm=(
            (
                aws_cryptographic_material_providers.smithygenerated.aws_cryptography_materialproviders.dafny_to_smithy.aws_cryptography_materialproviders_CryptographicMaterialsManagerReference(
                    dafny_input.cmm.UnwrapOr(None)
                )
            )
            if (dafny_input.cmm.UnwrapOr(None) is not None)
            else None
        ),
        legacy_override=(
            (
                aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_LegacyOverride(
                    dafny_input.legacyOverride.value
                )
            )
            if (dafny_input.legacyOverride.is_Some)
            else None
        ),
        plaintext_override=(
            (
                aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_PlaintextOverride(
                    dafny_input.plaintextOverride.value
                )
            )
            if (dafny_input.plaintextOverride.is_Some)
            else None
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor_StructuredEncryptionReference(
    dafny_input,
):
    from aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.client import (
        StructuredEncryption,
    )

    return StructuredEncryption(config=None, dafny_client=dafny_input)
