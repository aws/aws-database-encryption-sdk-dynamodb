# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
# Do not modify this file. This file is machine generated, and any changes to it will be overwritten.

import aws_cryptographic_materialproviders.smithygenerated.aws_cryptography_materialproviders.dafny_to_smithy
import aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk
from aws_database_encryption_sdk.internaldafny.generated.AwsCryptographyDbEncryptionSdkDynamoDbTypes import (
    GetEncryptedDataKeyDescriptionUnion_header,
    GetEncryptedDataKeyDescriptionUnion_item,
)
import aws_database_encryption_sdk.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.dafny_to_smithy
import aws_database_encryption_sdk.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models


def aws_cryptography_dbencryptionsdk_dynamodb_GetBranchKeyIdFromDdbKeyInput(
    dafny_input,
):
    return aws_database_encryption_sdk.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.GetBranchKeyIdFromDdbKeyInput(
        ddb_key={
            b"".join(ord(c).to_bytes(2, "big") for c in key).decode(
                "utf-16-be"
            ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_AttributeValue(
                value
            )
            for (key, value) in dafny_input.ddbKey.items
        },
    )


def aws_cryptography_dbencryptionsdk_dynamodb_GetBranchKeyIdFromDdbKeyOutput(
    dafny_input,
):
    return aws_database_encryption_sdk.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.GetBranchKeyIdFromDdbKeyOutput(
        branch_key_id=b"".join(
            ord(c).to_bytes(2, "big") for c in dafny_input.branchKeyId
        ).decode("utf-16-be"),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_DynamoDbKeyBranchKeyIdSupplierReference(
    dafny_input,
):
    if hasattr(dafny_input, "_native_impl"):
        return dafny_input._native_impl

    else:
        from aws_database_encryption_sdk.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.references import (
            DynamoDbKeyBranchKeyIdSupplier,
        )

        return DynamoDbKeyBranchKeyIdSupplier(_impl=dafny_input)


def aws_cryptography_dbencryptionsdk_dynamodb_CreateDynamoDbEncryptionBranchKeyIdSupplierInput(
    dafny_input,
):
    return aws_database_encryption_sdk.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.CreateDynamoDbEncryptionBranchKeyIdSupplierInput(
        ddb_key_branch_key_id_supplier=(
            (
                aws_database_encryption_sdk.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_DynamoDbKeyBranchKeyIdSupplierReference(
                    dafny_input.ddbKeyBranchKeyIdSupplier
                )
            )
            if (dafny_input.ddbKeyBranchKeyIdSupplier is not None)
            else None
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_GetEncryptedDataKeyDescriptionUnion(
    dafny_input,
):
    # Convert GetEncryptedDataKeyDescriptionUnion
    if isinstance(dafny_input, GetEncryptedDataKeyDescriptionUnion_header):
        GetEncryptedDataKeyDescriptionUnion_union_value = aws_database_encryption_sdk.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.GetEncryptedDataKeyDescriptionUnionHeader(
            bytes(dafny_input.header)
        )
    elif isinstance(dafny_input, GetEncryptedDataKeyDescriptionUnion_item):
        GetEncryptedDataKeyDescriptionUnion_union_value = aws_database_encryption_sdk.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.GetEncryptedDataKeyDescriptionUnionItem(
            {
                b"".join(ord(c).to_bytes(2, "big") for c in key).decode(
                    "utf-16-be"
                ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_AttributeValue(
                    value
                )
                for (key, value) in dafny_input.item.items
            }
        )
    else:
        raise ValueError("No recognized union value in union type: " + str(dafny_input))

    return GetEncryptedDataKeyDescriptionUnion_union_value


def aws_cryptography_dbencryptionsdk_dynamodb_GetEncryptedDataKeyDescriptionInput(
    dafny_input,
):
    return aws_database_encryption_sdk.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.GetEncryptedDataKeyDescriptionInput(
        input=aws_database_encryption_sdk.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_GetEncryptedDataKeyDescriptionUnion(
            dafny_input.input
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput(
    dafny_input,
):
    return aws_database_encryption_sdk.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput(
        branch_key_id_supplier=(
            (
                aws_cryptographic_materialproviders.smithygenerated.aws_cryptography_materialproviders.dafny_to_smithy.aws_cryptography_materialproviders_BranchKeyIdSupplierReference(
                    dafny_input.branchKeyIdSupplier
                )
            )
            if (dafny_input.branchKeyIdSupplier is not None)
            else None
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_EncryptedDataKeyDescription(dafny_input):
    return aws_database_encryption_sdk.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.EncryptedDataKeyDescription(
        key_provider_id=b"".join(
            ord(c).to_bytes(2, "big") for c in dafny_input.keyProviderId
        ).decode("utf-16-be"),
        key_provider_info=(
            (
                b"".join(
                    ord(c).to_bytes(2, "big") for c in dafny_input.keyProviderInfo.value
                ).decode("utf-16-be")
            )
            if (dafny_input.keyProviderInfo.is_Some)
            else None
        ),
        branch_key_id=(
            (
                b"".join(
                    ord(c).to_bytes(2, "big") for c in dafny_input.branchKeyId.value
                ).decode("utf-16-be")
            )
            if (dafny_input.branchKeyId.is_Some)
            else None
        ),
        branch_key_version=(
            (
                b"".join(
                    ord(c).to_bytes(2, "big")
                    for c in dafny_input.branchKeyVersion.value
                ).decode("utf-16-be")
            )
            if (dafny_input.branchKeyVersion.is_Some)
            else None
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_GetEncryptedDataKeyDescriptionOutput(
    dafny_input,
):
    return aws_database_encryption_sdk.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.GetEncryptedDataKeyDescriptionOutput(
        encrypted_data_key_description_output=[
            aws_database_encryption_sdk.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_EncryptedDataKeyDescription(
                list_element
            )
            for list_element in dafny_input.EncryptedDataKeyDescriptionOutput
        ],
    )


def aws_cryptography_dbencryptionsdk_dynamodb_DynamoDbEncryptionConfig(dafny_input):
    # Deferred import of .config to avoid circular dependency
    import aws_database_encryption_sdk.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.config

    return (
        aws_database_encryption_sdk.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.config.DynamoDbEncryptionConfig()
    )
