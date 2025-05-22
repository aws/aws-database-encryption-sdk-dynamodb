# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
# Do not modify this file. This file is machine generated, and any changes to it will be overwritten.

from _dafny import Map, Seq
import aws_cryptographic_material_providers.smithygenerated.aws_cryptography_materialproviders.smithy_to_dafny
from aws_dbesdk_dynamodb.internaldafny.generated.AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes import (
    AuthItem_AuthItem as DafnyAuthItem,
    AuthenticateAction_DO__NOT__SIGN,
    AuthenticateAction_SIGN,
    CryptoAction_DO__NOTHING,
    CryptoAction_ENCRYPT__AND__SIGN,
    CryptoAction_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT,
    CryptoAction_SIGN__ONLY,
    CryptoItem_CryptoItem as DafnyCryptoItem,
    DecryptPathStructureInput_DecryptPathStructureInput as DafnyDecryptPathStructureInput,
    DecryptPathStructureOutput_DecryptPathStructureOutput as DafnyDecryptPathStructureOutput,
    DecryptStructureInput_DecryptStructureInput as DafnyDecryptStructureInput,
    DecryptStructureOutput_DecryptStructureOutput as DafnyDecryptStructureOutput,
    EncryptPathStructureInput_EncryptPathStructureInput as DafnyEncryptPathStructureInput,
    EncryptPathStructureOutput_EncryptPathStructureOutput as DafnyEncryptPathStructureOutput,
    EncryptStructureInput_EncryptStructureInput as DafnyEncryptStructureInput,
    EncryptStructureOutput_EncryptStructureOutput as DafnyEncryptStructureOutput,
    ParsedHeader_ParsedHeader as DafnyParsedHeader,
    PathSegment_member,
    ResolveAuthActionsInput_ResolveAuthActionsInput as DafnyResolveAuthActionsInput,
    ResolveAuthActionsOutput_ResolveAuthActionsOutput as DafnyResolveAuthActionsOutput,
    StructureSegment_StructureSegment as DafnyStructureSegment,
    StructuredDataTerminal_StructuredDataTerminal as DafnyStructuredDataTerminal,
    StructuredEncryptionConfig_StructuredEncryptionConfig as DafnyStructuredEncryptionConfig,
)
import aws_dbesdk_dynamodb.internaldafny.generated.module_
import aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.models
import aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.smithy_to_dafny
from smithy_dafny_standard_library.internaldafny.generated.Wrappers import (
    Option_None,
    Option_Some,
)


def aws_cryptography_dbencryptionsdk_structuredencryption_EncryptStructureInput(
    native_input,
):
    return DafnyEncryptStructureInput(
        tableName=Seq(
            "".join(
                [
                    chr(int.from_bytes(pair, "big"))
                    for pair in zip(
                        *[iter(native_input.table_name.encode("utf-16-be"))] * 2
                    )
                ]
            )
        ),
        plaintextStructure=Map(
            {
                Seq(
                    "".join(
                        [
                            chr(int.from_bytes(pair, "big"))
                            for pair in zip(*[iter(key.encode("utf-16-be"))] * 2)
                        ]
                    )
                ): aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.smithy_to_dafny.aws_cryptography_dbencryptionsdk_structuredencryption_StructuredDataTerminal(
                    value
                )
                for (key, value) in native_input.plaintext_structure.items()
            }
        ),
        cryptoSchema=Map(
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
                for (key, value) in native_input.crypto_schema.items()
            }
        ),
        cmm=aws_cryptographic_material_providers.smithygenerated.aws_cryptography_materialproviders.smithy_to_dafny.aws_cryptography_materialproviders_CryptographicMaterialsManagerReference(
            native_input.cmm
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
        encryptionContext=(
            (
                Option_Some(
                    Map(
                        {
                            Seq(key.encode("utf-8")): Seq(value.encode("utf-8"))
                            for (key, value) in native_input.encryption_context.items()
                        }
                    )
                )
            )
            if (native_input.encryption_context is not None)
            else (Option_None())
        ),
    )


def aws_cryptography_dbencryptionsdk_structuredencryption_StructuredDataTerminal(
    native_input,
):
    return DafnyStructuredDataTerminal(
        value=Seq(native_input.value),
        typeId=Seq(native_input.type_id),
    )


def aws_cryptography_dbencryptionsdk_structuredencryption_CryptoAction(native_input):
    if native_input == "ENCRYPT_AND_SIGN":
        return CryptoAction_ENCRYPT__AND__SIGN()

    elif native_input == "SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT":
        return CryptoAction_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT()

    elif native_input == "SIGN_ONLY":
        return CryptoAction_SIGN__ONLY()

    elif native_input == "DO_NOTHING":
        return CryptoAction_DO__NOTHING()

    else:
        raise ValueError(f"No recognized enum value in enum type: {native_input=}")


def aws_cryptography_dbencryptionsdk_structuredencryption_DecryptStructureInput(
    native_input,
):
    return DafnyDecryptStructureInput(
        tableName=Seq(
            "".join(
                [
                    chr(int.from_bytes(pair, "big"))
                    for pair in zip(
                        *[iter(native_input.table_name.encode("utf-16-be"))] * 2
                    )
                ]
            )
        ),
        encryptedStructure=Map(
            {
                Seq(
                    "".join(
                        [
                            chr(int.from_bytes(pair, "big"))
                            for pair in zip(*[iter(key.encode("utf-16-be"))] * 2)
                        ]
                    )
                ): aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.smithy_to_dafny.aws_cryptography_dbencryptionsdk_structuredencryption_StructuredDataTerminal(
                    value
                )
                for (key, value) in native_input.encrypted_structure.items()
            }
        ),
        authenticateSchema=Map(
            {
                Seq(
                    "".join(
                        [
                            chr(int.from_bytes(pair, "big"))
                            for pair in zip(*[iter(key.encode("utf-16-be"))] * 2)
                        ]
                    )
                ): aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.smithy_to_dafny.aws_cryptography_dbencryptionsdk_structuredencryption_AuthenticateAction(
                    value
                )
                for (key, value) in native_input.authenticate_schema.items()
            }
        ),
        cmm=aws_cryptographic_material_providers.smithygenerated.aws_cryptography_materialproviders.smithy_to_dafny.aws_cryptography_materialproviders_CryptographicMaterialsManagerReference(
            native_input.cmm
        ),
        encryptionContext=(
            (
                Option_Some(
                    Map(
                        {
                            Seq(key.encode("utf-8")): Seq(value.encode("utf-8"))
                            for (key, value) in native_input.encryption_context.items()
                        }
                    )
                )
            )
            if (native_input.encryption_context is not None)
            else (Option_None())
        ),
    )


def aws_cryptography_dbencryptionsdk_structuredencryption_AuthenticateAction(
    native_input,
):
    if native_input == "SIGN":
        return AuthenticateAction_SIGN()

    elif native_input == "DO_NOT_SIGN":
        return AuthenticateAction_DO__NOT__SIGN()

    else:
        raise ValueError(f"No recognized enum value in enum type: {native_input=}")


def aws_cryptography_dbencryptionsdk_structuredencryption_EncryptPathStructureInput(
    native_input,
):
    return DafnyEncryptPathStructureInput(
        tableName=Seq(
            "".join(
                [
                    chr(int.from_bytes(pair, "big"))
                    for pair in zip(
                        *[iter(native_input.table_name.encode("utf-16-be"))] * 2
                    )
                ]
            )
        ),
        plaintextStructure=Seq(
            [
                aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.smithy_to_dafny.aws_cryptography_dbencryptionsdk_structuredencryption_CryptoItem(
                    list_element
                )
                for list_element in native_input.plaintext_structure
            ]
        ),
        cmm=aws_cryptographic_material_providers.smithygenerated.aws_cryptography_materialproviders.smithy_to_dafny.aws_cryptography_materialproviders_CryptographicMaterialsManagerReference(
            native_input.cmm
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
        encryptionContext=(
            (
                Option_Some(
                    Map(
                        {
                            Seq(key.encode("utf-8")): Seq(value.encode("utf-8"))
                            for (key, value) in native_input.encryption_context.items()
                        }
                    )
                )
            )
            if (native_input.encryption_context is not None)
            else (Option_None())
        ),
    )


def aws_cryptography_dbencryptionsdk_structuredencryption_CryptoItem(native_input):
    return DafnyCryptoItem(
        key=Seq(
            [
                aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.smithy_to_dafny.aws_cryptography_dbencryptionsdk_structuredencryption_PathSegment(
                    list_element
                )
                for list_element in native_input.key
            ]
        ),
        data=aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.smithy_to_dafny.aws_cryptography_dbencryptionsdk_structuredencryption_StructuredDataTerminal(
            native_input.data
        ),
        action=aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.smithy_to_dafny.aws_cryptography_dbencryptionsdk_structuredencryption_CryptoAction(
            native_input.action
        ),
    )


def aws_cryptography_dbencryptionsdk_structuredencryption_PathSegment(native_input):
    if isinstance(
        native_input,
        aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.models.PathSegmentMember,
    ):
        PathSegment_union_value = PathSegment_member(
            aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.smithy_to_dafny.aws_cryptography_dbencryptionsdk_structuredencryption_StructureSegment(
                native_input.value
            )
        )
    else:
        raise ValueError(
            "No recognized union value in union type: " + str(native_input)
        )

    return PathSegment_union_value


def aws_cryptography_dbencryptionsdk_structuredencryption_StructureSegment(
    native_input,
):
    return DafnyStructureSegment(
        key=Seq(
            "".join(
                [
                    chr(int.from_bytes(pair, "big"))
                    for pair in zip(*[iter(native_input.key.encode("utf-16-be"))] * 2)
                ]
            )
        ),
    )


def aws_cryptography_dbencryptionsdk_structuredencryption_DecryptPathStructureInput(
    native_input,
):
    return DafnyDecryptPathStructureInput(
        tableName=Seq(
            "".join(
                [
                    chr(int.from_bytes(pair, "big"))
                    for pair in zip(
                        *[iter(native_input.table_name.encode("utf-16-be"))] * 2
                    )
                ]
            )
        ),
        encryptedStructure=Seq(
            [
                aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.smithy_to_dafny.aws_cryptography_dbencryptionsdk_structuredencryption_AuthItem(
                    list_element
                )
                for list_element in native_input.encrypted_structure
            ]
        ),
        cmm=aws_cryptographic_material_providers.smithygenerated.aws_cryptography_materialproviders.smithy_to_dafny.aws_cryptography_materialproviders_CryptographicMaterialsManagerReference(
            native_input.cmm
        ),
        encryptionContext=(
            (
                Option_Some(
                    Map(
                        {
                            Seq(key.encode("utf-8")): Seq(value.encode("utf-8"))
                            for (key, value) in native_input.encryption_context.items()
                        }
                    )
                )
            )
            if (native_input.encryption_context is not None)
            else (Option_None())
        ),
    )


def aws_cryptography_dbencryptionsdk_structuredencryption_AuthItem(native_input):
    return DafnyAuthItem(
        key=Seq(
            [
                aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.smithy_to_dafny.aws_cryptography_dbencryptionsdk_structuredencryption_PathSegment(
                    list_element
                )
                for list_element in native_input.key
            ]
        ),
        data=aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.smithy_to_dafny.aws_cryptography_dbencryptionsdk_structuredencryption_StructuredDataTerminal(
            native_input.data
        ),
        action=aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.smithy_to_dafny.aws_cryptography_dbencryptionsdk_structuredencryption_AuthenticateAction(
            native_input.action
        ),
    )


def aws_cryptography_dbencryptionsdk_structuredencryption_ResolveAuthActionsInput(
    native_input,
):
    return DafnyResolveAuthActionsInput(
        tableName=Seq(
            "".join(
                [
                    chr(int.from_bytes(pair, "big"))
                    for pair in zip(
                        *[iter(native_input.table_name.encode("utf-16-be"))] * 2
                    )
                ]
            )
        ),
        authActions=Seq(
            [
                aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.smithy_to_dafny.aws_cryptography_dbencryptionsdk_structuredencryption_AuthItem(
                    list_element
                )
                for list_element in native_input.auth_actions
            ]
        ),
        headerBytes=Seq(native_input.header_bytes),
    )


def aws_cryptography_dbencryptionsdk_structuredencryption_EncryptStructureOutput(
    native_input,
):
    return DafnyEncryptStructureOutput(
        encryptedStructure=Map(
            {
                Seq(
                    "".join(
                        [
                            chr(int.from_bytes(pair, "big"))
                            for pair in zip(*[iter(key.encode("utf-16-be"))] * 2)
                        ]
                    )
                ): aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.smithy_to_dafny.aws_cryptography_dbencryptionsdk_structuredencryption_StructuredDataTerminal(
                    value
                )
                for (key, value) in native_input.encrypted_structure.items()
            }
        ),
        cryptoSchema=Map(
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
                for (key, value) in native_input.crypto_schema.items()
            }
        ),
        parsedHeader=aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.smithy_to_dafny.aws_cryptography_dbencryptionsdk_structuredencryption_ParsedHeader(
            native_input.parsed_header
        ),
    )


def aws_cryptography_dbencryptionsdk_structuredencryption_ParsedHeader(native_input):
    return DafnyParsedHeader(
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
    )


def aws_cryptography_dbencryptionsdk_structuredencryption_DecryptStructureOutput(
    native_input,
):
    return DafnyDecryptStructureOutput(
        plaintextStructure=Map(
            {
                Seq(
                    "".join(
                        [
                            chr(int.from_bytes(pair, "big"))
                            for pair in zip(*[iter(key.encode("utf-16-be"))] * 2)
                        ]
                    )
                ): aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.smithy_to_dafny.aws_cryptography_dbencryptionsdk_structuredencryption_StructuredDataTerminal(
                    value
                )
                for (key, value) in native_input.plaintext_structure.items()
            }
        ),
        cryptoSchema=Map(
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
                for (key, value) in native_input.crypto_schema.items()
            }
        ),
        parsedHeader=aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.smithy_to_dafny.aws_cryptography_dbencryptionsdk_structuredencryption_ParsedHeader(
            native_input.parsed_header
        ),
    )


def aws_cryptography_dbencryptionsdk_structuredencryption_EncryptPathStructureOutput(
    native_input,
):
    return DafnyEncryptPathStructureOutput(
        encryptedStructure=Seq(
            [
                aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.smithy_to_dafny.aws_cryptography_dbencryptionsdk_structuredencryption_CryptoItem(
                    list_element
                )
                for list_element in native_input.encrypted_structure
            ]
        ),
        parsedHeader=aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.smithy_to_dafny.aws_cryptography_dbencryptionsdk_structuredencryption_ParsedHeader(
            native_input.parsed_header
        ),
    )


def aws_cryptography_dbencryptionsdk_structuredencryption_DecryptPathStructureOutput(
    native_input,
):
    return DafnyDecryptPathStructureOutput(
        plaintextStructure=Seq(
            [
                aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.smithy_to_dafny.aws_cryptography_dbencryptionsdk_structuredencryption_CryptoItem(
                    list_element
                )
                for list_element in native_input.plaintext_structure
            ]
        ),
        parsedHeader=aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.smithy_to_dafny.aws_cryptography_dbencryptionsdk_structuredencryption_ParsedHeader(
            native_input.parsed_header
        ),
    )


def aws_cryptography_dbencryptionsdk_structuredencryption_ResolveAuthActionsOutput(
    native_input,
):
    return DafnyResolveAuthActionsOutput(
        cryptoActions=Seq(
            [
                aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.smithy_to_dafny.aws_cryptography_dbencryptionsdk_structuredencryption_CryptoItem(
                    list_element
                )
                for list_element in native_input.crypto_actions
            ]
        ),
    )


def aws_cryptography_dbencryptionsdk_structuredencryption_AtomicPrimitivesReference(
    native_input,
):
    return native_input._config.dafnyImplInterface.impl


def aws_cryptography_dbencryptionsdk_structuredencryption_StructuredEncryptionConfig(
    native_input,
):
    return DafnyStructuredEncryptionConfig()
