# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
# Do not modify this file. This file is machine generated, and any changes to it will be overwritten.

import aws_cryptographic_material_providers.smithygenerated.aws_cryptography_materialproviders.dafny_to_smithy
from aws_dbesdk_dynamodb.internaldafny.generated.AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes import (
    AuthenticateAction_DO__NOT__SIGN,
    AuthenticateAction_SIGN,
    CryptoAction_DO__NOTHING,
    CryptoAction_ENCRYPT__AND__SIGN,
    CryptoAction_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT,
    CryptoAction_SIGN__ONLY,
    PathSegment_member,
)
import aws_dbesdk_dynamodb.internaldafny.generated.module_
import aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.dafny_to_smithy
import aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.models


def aws_cryptography_dbencryptionsdk_structuredencryption_StructuredDataTerminal(
    dafny_input,
):
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.models.StructuredDataTerminal(
        value=bytes(dafny_input.value),
        type_id=bytes(dafny_input.typeId),
    )


def aws_cryptography_dbencryptionsdk_structuredencryption_CryptoAction(dafny_input):
    if isinstance(dafny_input, CryptoAction_ENCRYPT__AND__SIGN):
        return "ENCRYPT_AND_SIGN"

    elif isinstance(dafny_input, CryptoAction_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT):
        return "SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT"

    elif isinstance(dafny_input, CryptoAction_SIGN__ONLY):
        return "SIGN_ONLY"

    elif isinstance(dafny_input, CryptoAction_DO__NOTHING):
        return "DO_NOTHING"

    else:
        raise ValueError(f"No recognized enum value in enum type: {dafny_input=}")


def aws_cryptography_dbencryptionsdk_structuredencryption_EncryptStructureInput(
    dafny_input,
):
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.models.EncryptStructureInput(
        table_name=b"".join(ord(c).to_bytes(2, "big") for c in dafny_input.tableName).decode("utf-16-be"),
        plaintext_structure={
            b"".join(ord(c).to_bytes(2, "big") for c in key).decode(
                "utf-16-be"
            ): aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.dafny_to_smithy.aws_cryptography_dbencryptionsdk_structuredencryption_StructuredDataTerminal(
                value
            )
            for (key, value) in dafny_input.plaintextStructure.items
        },
        crypto_schema={
            b"".join(ord(c).to_bytes(2, "big") for c in key).decode(
                "utf-16-be"
            ): aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.dafny_to_smithy.aws_cryptography_dbencryptionsdk_structuredencryption_CryptoAction(
                value
            )
            for (key, value) in dafny_input.cryptoSchema.items
        },
        cmm=(
            (
                aws_cryptographic_material_providers.smithygenerated.aws_cryptography_materialproviders.dafny_to_smithy.aws_cryptography_materialproviders_CryptographicMaterialsManagerReference(
                    dafny_input.cmm
                )
            )
            if (dafny_input.cmm is not None)
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
        encryption_context=(
            (
                {
                    bytes(key.Elements).decode("utf-8"): bytes(value.Elements).decode("utf-8")
                    for (key, value) in dafny_input.encryptionContext.value.items
                }
            )
            if (dafny_input.encryptionContext.is_Some)
            else None
        ),
    )


def aws_cryptography_dbencryptionsdk_structuredencryption_AuthenticateAction(
    dafny_input,
):
    if isinstance(dafny_input, AuthenticateAction_SIGN):
        return "SIGN"

    elif isinstance(dafny_input, AuthenticateAction_DO__NOT__SIGN):
        return "DO_NOT_SIGN"

    else:
        raise ValueError(f"No recognized enum value in enum type: {dafny_input=}")


def aws_cryptography_dbencryptionsdk_structuredencryption_DecryptStructureInput(
    dafny_input,
):
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.models.DecryptStructureInput(
        table_name=b"".join(ord(c).to_bytes(2, "big") for c in dafny_input.tableName).decode("utf-16-be"),
        encrypted_structure={
            b"".join(ord(c).to_bytes(2, "big") for c in key).decode(
                "utf-16-be"
            ): aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.dafny_to_smithy.aws_cryptography_dbencryptionsdk_structuredencryption_StructuredDataTerminal(
                value
            )
            for (key, value) in dafny_input.encryptedStructure.items
        },
        authenticate_schema={
            b"".join(ord(c).to_bytes(2, "big") for c in key).decode(
                "utf-16-be"
            ): aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.dafny_to_smithy.aws_cryptography_dbencryptionsdk_structuredencryption_AuthenticateAction(
                value
            )
            for (key, value) in dafny_input.authenticateSchema.items
        },
        cmm=(
            (
                aws_cryptographic_material_providers.smithygenerated.aws_cryptography_materialproviders.dafny_to_smithy.aws_cryptography_materialproviders_CryptographicMaterialsManagerReference(
                    dafny_input.cmm
                )
            )
            if (dafny_input.cmm is not None)
            else None
        ),
        encryption_context=(
            (
                {
                    bytes(key.Elements).decode("utf-8"): bytes(value.Elements).decode("utf-8")
                    for (key, value) in dafny_input.encryptionContext.value.items
                }
            )
            if (dafny_input.encryptionContext.is_Some)
            else None
        ),
    )


def aws_cryptography_dbencryptionsdk_structuredencryption_CryptoItem(dafny_input):
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.models.CryptoItem(
        key=[
            aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.dafny_to_smithy.aws_cryptography_dbencryptionsdk_structuredencryption_PathSegment(
                list_element
            )
            for list_element in dafny_input.key
        ],
        data=aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.dafny_to_smithy.aws_cryptography_dbencryptionsdk_structuredencryption_StructuredDataTerminal(
            dafny_input.data
        ),
        action=aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.dafny_to_smithy.aws_cryptography_dbencryptionsdk_structuredencryption_CryptoAction(
            dafny_input.action
        ),
    )


def aws_cryptography_dbencryptionsdk_structuredencryption_PathSegment(dafny_input):
    # Convert PathSegment
    if isinstance(dafny_input, PathSegment_member):
        PathSegment_union_value = aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.models.PathSegmentMember(
            aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.dafny_to_smithy.aws_cryptography_dbencryptionsdk_structuredencryption_StructureSegment(
                dafny_input.member
            )
        )
    else:
        raise ValueError("No recognized union value in union type: " + str(dafny_input))

    return PathSegment_union_value


def aws_cryptography_dbencryptionsdk_structuredencryption_StructureSegment(dafny_input):
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.models.StructureSegment(
        key=b"".join(ord(c).to_bytes(2, "big") for c in dafny_input.key).decode("utf-16-be"),
    )


def aws_cryptography_dbencryptionsdk_structuredencryption_EncryptPathStructureInput(
    dafny_input,
):
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.models.EncryptPathStructureInput(
        table_name=b"".join(ord(c).to_bytes(2, "big") for c in dafny_input.tableName).decode("utf-16-be"),
        plaintext_structure=[
            aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.dafny_to_smithy.aws_cryptography_dbencryptionsdk_structuredencryption_CryptoItem(
                list_element
            )
            for list_element in dafny_input.plaintextStructure
        ],
        cmm=(
            (
                aws_cryptographic_material_providers.smithygenerated.aws_cryptography_materialproviders.dafny_to_smithy.aws_cryptography_materialproviders_CryptographicMaterialsManagerReference(
                    dafny_input.cmm
                )
            )
            if (dafny_input.cmm is not None)
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
        encryption_context=(
            (
                {
                    bytes(key.Elements).decode("utf-8"): bytes(value.Elements).decode("utf-8")
                    for (key, value) in dafny_input.encryptionContext.value.items
                }
            )
            if (dafny_input.encryptionContext.is_Some)
            else None
        ),
    )


def aws_cryptography_dbencryptionsdk_structuredencryption_AuthItem(dafny_input):
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.models.AuthItem(
        key=[
            aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.dafny_to_smithy.aws_cryptography_dbencryptionsdk_structuredencryption_PathSegment(
                list_element
            )
            for list_element in dafny_input.key
        ],
        data=aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.dafny_to_smithy.aws_cryptography_dbencryptionsdk_structuredencryption_StructuredDataTerminal(
            dafny_input.data
        ),
        action=aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.dafny_to_smithy.aws_cryptography_dbencryptionsdk_structuredencryption_AuthenticateAction(
            dafny_input.action
        ),
    )


def aws_cryptography_dbencryptionsdk_structuredencryption_DecryptPathStructureInput(
    dafny_input,
):
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.models.DecryptPathStructureInput(
        table_name=b"".join(ord(c).to_bytes(2, "big") for c in dafny_input.tableName).decode("utf-16-be"),
        encrypted_structure=[
            aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.dafny_to_smithy.aws_cryptography_dbencryptionsdk_structuredencryption_AuthItem(
                list_element
            )
            for list_element in dafny_input.encryptedStructure
        ],
        cmm=(
            (
                aws_cryptographic_material_providers.smithygenerated.aws_cryptography_materialproviders.dafny_to_smithy.aws_cryptography_materialproviders_CryptographicMaterialsManagerReference(
                    dafny_input.cmm
                )
            )
            if (dafny_input.cmm is not None)
            else None
        ),
        encryption_context=(
            (
                {
                    bytes(key.Elements).decode("utf-8"): bytes(value.Elements).decode("utf-8")
                    for (key, value) in dafny_input.encryptionContext.value.items
                }
            )
            if (dafny_input.encryptionContext.is_Some)
            else None
        ),
    )


def aws_cryptography_dbencryptionsdk_structuredencryption_ResolveAuthActionsInput(
    dafny_input,
):
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.models.ResolveAuthActionsInput(
        table_name=b"".join(ord(c).to_bytes(2, "big") for c in dafny_input.tableName).decode("utf-16-be"),
        auth_actions=[
            aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.dafny_to_smithy.aws_cryptography_dbencryptionsdk_structuredencryption_AuthItem(
                list_element
            )
            for list_element in dafny_input.authActions
        ],
        header_bytes=bytes(dafny_input.headerBytes),
    )


def aws_cryptography_dbencryptionsdk_structuredencryption_ParsedHeader(dafny_input):
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.models.ParsedHeader(
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
    )


def aws_cryptography_dbencryptionsdk_structuredencryption_EncryptStructureOutput(
    dafny_input,
):
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.models.EncryptStructureOutput(
        encrypted_structure={
            b"".join(ord(c).to_bytes(2, "big") for c in key).decode(
                "utf-16-be"
            ): aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.dafny_to_smithy.aws_cryptography_dbencryptionsdk_structuredencryption_StructuredDataTerminal(
                value
            )
            for (key, value) in dafny_input.encryptedStructure.items
        },
        crypto_schema={
            b"".join(ord(c).to_bytes(2, "big") for c in key).decode(
                "utf-16-be"
            ): aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.dafny_to_smithy.aws_cryptography_dbencryptionsdk_structuredencryption_CryptoAction(
                value
            )
            for (key, value) in dafny_input.cryptoSchema.items
        },
        parsed_header=aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.dafny_to_smithy.aws_cryptography_dbencryptionsdk_structuredencryption_ParsedHeader(
            dafny_input.parsedHeader
        ),
    )


def aws_cryptography_dbencryptionsdk_structuredencryption_DecryptStructureOutput(
    dafny_input,
):
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.models.DecryptStructureOutput(
        plaintext_structure={
            b"".join(ord(c).to_bytes(2, "big") for c in key).decode(
                "utf-16-be"
            ): aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.dafny_to_smithy.aws_cryptography_dbencryptionsdk_structuredencryption_StructuredDataTerminal(
                value
            )
            for (key, value) in dafny_input.plaintextStructure.items
        },
        crypto_schema={
            b"".join(ord(c).to_bytes(2, "big") for c in key).decode(
                "utf-16-be"
            ): aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.dafny_to_smithy.aws_cryptography_dbencryptionsdk_structuredencryption_CryptoAction(
                value
            )
            for (key, value) in dafny_input.cryptoSchema.items
        },
        parsed_header=aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.dafny_to_smithy.aws_cryptography_dbencryptionsdk_structuredencryption_ParsedHeader(
            dafny_input.parsedHeader
        ),
    )


def aws_cryptography_dbencryptionsdk_structuredencryption_EncryptPathStructureOutput(
    dafny_input,
):
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.models.EncryptPathStructureOutput(
        encrypted_structure=[
            aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.dafny_to_smithy.aws_cryptography_dbencryptionsdk_structuredencryption_CryptoItem(
                list_element
            )
            for list_element in dafny_input.encryptedStructure
        ],
        parsed_header=aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.dafny_to_smithy.aws_cryptography_dbencryptionsdk_structuredencryption_ParsedHeader(
            dafny_input.parsedHeader
        ),
    )


def aws_cryptography_dbencryptionsdk_structuredencryption_DecryptPathStructureOutput(
    dafny_input,
):
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.models.DecryptPathStructureOutput(
        plaintext_structure=[
            aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.dafny_to_smithy.aws_cryptography_dbencryptionsdk_structuredencryption_CryptoItem(
                list_element
            )
            for list_element in dafny_input.plaintextStructure
        ],
        parsed_header=aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.dafny_to_smithy.aws_cryptography_dbencryptionsdk_structuredencryption_ParsedHeader(
            dafny_input.parsedHeader
        ),
    )


def aws_cryptography_dbencryptionsdk_structuredencryption_ResolveAuthActionsOutput(
    dafny_input,
):
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.models.ResolveAuthActionsOutput(
        crypto_actions=[
            aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.dafny_to_smithy.aws_cryptography_dbencryptionsdk_structuredencryption_CryptoItem(
                list_element
            )
            for list_element in dafny_input.cryptoActions
        ],
    )


def aws_cryptography_dbencryptionsdk_structuredencryption_AtomicPrimitivesReference(
    dafny_input,
):
    from aws_cryptography_primitives.smithygenerated.aws_cryptography_primitives.client import (
        AwsCryptographicPrimitives,
    )

    return AwsCryptographicPrimitives(config=None, dafny_client=dafny_input)


def aws_cryptography_dbencryptionsdk_structuredencryption_StructuredEncryptionConfig(
    dafny_input,
):
    # Deferred import of .config to avoid circular dependency
    import aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.config

    return (
        aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.config.StructuredEncryptionConfig()
    )
