# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
# Do not modify this file. This file is machine generated, and any changes to it will be overwritten.

from _dafny import Map, Seq
import aws_cryptographic_material_providers.smithygenerated.aws_cryptography_materialproviders.smithy_to_dafny
import aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny
from aws_dbesdk_dynamodb.internaldafny.generated.AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes import (
    DecryptItemInput_DecryptItemInput as DafnyDecryptItemInput,
    DecryptItemOutput_DecryptItemOutput as DafnyDecryptItemOutput,
    DynamoDbItemEncryptorConfig_DynamoDbItemEncryptorConfig as DafnyDynamoDbItemEncryptorConfig,
    EncryptItemInput_EncryptItemInput as DafnyEncryptItemInput,
    EncryptItemOutput_EncryptItemOutput as DafnyEncryptItemOutput,
    ParsedHeader_ParsedHeader as DafnyParsedHeader,
)
import aws_dbesdk_dynamodb.internaldafny.generated.module_
import aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.smithy_to_dafny
import aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor.smithy_to_dafny
import aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.smithy_to_dafny
from smithy_dafny_standard_library.internaldafny.generated.Wrappers import (
    Option_None,
    Option_Some,
)


def aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor_EncryptItemInput(
    native_input,
):
    return DafnyEncryptItemInput(
        plaintextItem=Map(
            {
                Seq(
                    "".join(
                        [
                            chr(int.from_bytes(pair, "big"))
                            for pair in zip(*[iter(key.encode("utf-16-be"))] * 2)
                        ]
                    )
                ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_AttributeValue(
                    value
                )
                for (key, value) in native_input.plaintext_item.items()
            }
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor_DecryptItemInput(
    native_input,
):
    return DafnyDecryptItemInput(
        encryptedItem=Map(
            {
                Seq(
                    "".join(
                        [
                            chr(int.from_bytes(pair, "big"))
                            for pair in zip(*[iter(key.encode("utf-16-be"))] * 2)
                        ]
                    )
                ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_AttributeValue(
                    value
                )
                for (key, value) in native_input.encrypted_item.items()
            }
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor_EncryptItemOutput(
    native_input,
):
    return DafnyEncryptItemOutput(
        encryptedItem=Map(
            {
                Seq(
                    "".join(
                        [
                            chr(int.from_bytes(pair, "big"))
                            for pair in zip(*[iter(key.encode("utf-16-be"))] * 2)
                        ]
                    )
                ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_AttributeValue(
                    value
                )
                for (key, value) in native_input.encrypted_item.items()
            }
        ),
        parsedHeader=(
            (
                Option_Some(
                    aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor_ParsedHeader(
                        native_input.parsed_header
                    )
                )
            )
            if (native_input.parsed_header is not None)
            else (Option_None())
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor_ParsedHeader(native_input):
    return DafnyParsedHeader(
        attributeActionsOnEncrypt=Map(
            {
                Seq(
                    "".join(
                        [
                            chr(int.from_bytes(pair, "big"))
                            for pair in zip(*[iter(key.encode("utf-16-be"))] * 2)
                        ]
                    )
                ): aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.smithy_to_dafny.aws_cryptography_dbencryptionsdk_structuredencryption_CryptoAction(
                    value
                )
                for (key, value) in native_input.attribute_actions_on_encrypt.items()
            }
        ),
        algorithmSuiteId=aws_cryptographic_material_providers.smithygenerated.aws_cryptography_materialproviders.smithy_to_dafny.aws_cryptography_materialproviders_DBEAlgorithmSuiteId(
            native_input.algorithm_suite_id
        ),
        encryptedDataKeys=Seq(
            [
                aws_cryptographic_material_providers.smithygenerated.aws_cryptography_materialproviders.smithy_to_dafny.aws_cryptography_materialproviders_EncryptedDataKey(
                    list_element
                )
                for list_element in native_input.encrypted_data_keys
            ]
        ),
        storedEncryptionContext=Map(
            {
                Seq(key.encode("utf-8")): Seq(value.encode("utf-8"))
                for (key, value) in native_input.stored_encryption_context.items()
            }
        ),
        encryptionContext=Map(
            {
                Seq(key.encode("utf-8")): Seq(value.encode("utf-8"))
                for (key, value) in native_input.encryption_context.items()
            }
        ),
        selectorContext=Map(
            {
                Seq(
                    "".join(
                        [
                            chr(int.from_bytes(pair, "big"))
                            for pair in zip(*[iter(key.encode("utf-16-be"))] * 2)
                        ]
                    )
                ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_AttributeValue(
                    value
                )
                for (key, value) in native_input.selector_context.items()
            }
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor_DecryptItemOutput(
    native_input,
):
    return DafnyDecryptItemOutput(
        plaintextItem=Map(
            {
                Seq(
                    "".join(
                        [
                            chr(int.from_bytes(pair, "big"))
                            for pair in zip(*[iter(key.encode("utf-16-be"))] * 2)
                        ]
                    )
                ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_AttributeValue(
                    value
                )
                for (key, value) in native_input.plaintext_item.items()
            }
        ),
        parsedHeader=(
            (
                Option_Some(
                    aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor_ParsedHeader(
                        native_input.parsed_header
                    )
                )
            )
            if (native_input.parsed_header is not None)
            else (Option_None())
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor_AtomicPrimitivesReference(
    native_input,
):
    return native_input._config.dafnyImplInterface.impl


def aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor_DynamoDbItemEncryptorConfig(
    native_input,
):
    return DafnyDynamoDbItemEncryptorConfig(
        logicalTableName=Seq(
            "".join(
                [
                    chr(int.from_bytes(pair, "big"))
                    for pair in zip(
                        *[iter(native_input.logical_table_name.encode("utf-16-be"))] * 2
                    )
                ]
            )
        ),
        partitionKeyName=Seq(
            "".join(
                [
                    chr(int.from_bytes(pair, "big"))
                    for pair in zip(
                        *[iter(native_input.partition_key_name.encode("utf-16-be"))] * 2
                    )
                ]
            )
        ),
        sortKeyName=(
            (
                Option_Some(
                    Seq(
                        "".join(
                            [
                                chr(int.from_bytes(pair, "big"))
                                for pair in zip(
                                    *[
                                        iter(
                                            native_input.sort_key_name.encode(
                                                "utf-16-be"
                                            )
                                        )
                                    ]
                                    * 2
                                )
                            ]
                        )
                    )
                )
            )
            if (native_input.sort_key_name is not None)
            else (Option_None())
        ),
        attributeActionsOnEncrypt=Map(
            {
                Seq(
                    "".join(
                        [
                            chr(int.from_bytes(pair, "big"))
                            for pair in zip(*[iter(key.encode("utf-16-be"))] * 2)
                        ]
                    )
                ): aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.smithy_to_dafny.aws_cryptography_dbencryptionsdk_structuredencryption_CryptoAction(
                    value
                )
                for (key, value) in native_input.attribute_actions_on_encrypt.items()
            }
        ),
        allowedUnsignedAttributes=(
            (
                Option_Some(
                    Seq(
                        [
                            Seq(
                                "".join(
                                    [
                                        chr(int.from_bytes(pair, "big"))
                                        for pair in zip(
                                            *[iter(list_element.encode("utf-16-be"))]
                                            * 2
                                        )
                                    ]
                                )
                            )
                            for list_element in native_input.allowed_unsigned_attributes
                        ]
                    )
                )
            )
            if (native_input.allowed_unsigned_attributes is not None)
            else (Option_None())
        ),
        allowedUnsignedAttributePrefix=(
            (
                Option_Some(
                    Seq(
                        "".join(
                            [
                                chr(int.from_bytes(pair, "big"))
                                for pair in zip(
                                    *[
                                        iter(
                                            native_input.allowed_unsigned_attribute_prefix.encode(
                                                "utf-16-be"
                                            )
                                        )
                                    ]
                                    * 2
                                )
                            ]
                        )
                    )
                )
            )
            if (native_input.allowed_unsigned_attribute_prefix is not None)
            else (Option_None())
        ),
        algorithmSuiteId=(
            (
                Option_Some(
                    aws_cryptographic_material_providers.smithygenerated.aws_cryptography_materialproviders.smithy_to_dafny.aws_cryptography_materialproviders_DBEAlgorithmSuiteId(
                        native_input.algorithm_suite_id
                    )
                )
            )
            if (native_input.algorithm_suite_id is not None)
            else (Option_None())
        ),
        keyring=(
            (
                Option_Some(
                    aws_cryptographic_material_providers.smithygenerated.aws_cryptography_materialproviders.smithy_to_dafny.aws_cryptography_materialproviders_KeyringReference(
                        native_input.keyring
                    )
                )
            )
            if (
                (native_input.keyring is not None)
                and (
                    aws_cryptographic_material_providers.smithygenerated.aws_cryptography_materialproviders.smithy_to_dafny.aws_cryptography_materialproviders_KeyringReference(
                        native_input.keyring
                    )
                    is not None
                )
            )
            else (Option_None())
        ),
        cmm=(
            (
                Option_Some(
                    aws_cryptographic_material_providers.smithygenerated.aws_cryptography_materialproviders.smithy_to_dafny.aws_cryptography_materialproviders_CryptographicMaterialsManagerReference(
                        native_input.cmm
                    )
                )
            )
            if (
                (native_input.cmm is not None)
                and (
                    aws_cryptographic_material_providers.smithygenerated.aws_cryptography_materialproviders.smithy_to_dafny.aws_cryptography_materialproviders_CryptographicMaterialsManagerReference(
                        native_input.cmm
                    )
                    is not None
                )
            )
            else (Option_None())
        ),
        legacyOverride=(
            (
                Option_Some(
                    aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_LegacyOverride(
                        native_input.legacy_override
                    )
                )
            )
            if (native_input.legacy_override is not None)
            else (Option_None())
        ),
        plaintextOverride=(
            (
                Option_Some(
                    aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_PlaintextOverride(
                        native_input.plaintext_override
                    )
                )
            )
            if (native_input.plaintext_override is not None)
            else (Option_None())
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor_StructuredEncryptionReference(
    native_input,
):
    return native_input._config.dafnyImplInterface.impl
