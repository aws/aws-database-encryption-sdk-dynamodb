# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
# Do not modify this file. This file is machine generated, and any changes to it will be overwritten.

from _dafny import Map, Seq
import aws_cryptographic_materialproviders.smithygenerated.aws_cryptography_materialproviders.smithy_to_dafny
import aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny
from aws_database_encryption_sdk.internaldafny.generated.AwsCryptographyDbEncryptionSdkDynamoDbTypes import (
    CreateDynamoDbEncryptionBranchKeyIdSupplierInput_CreateDynamoDbEncryptionBranchKeyIdSupplierInput as DafnyCreateDynamoDbEncryptionBranchKeyIdSupplierInput,
    CreateDynamoDbEncryptionBranchKeyIdSupplierOutput_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput as DafnyCreateDynamoDbEncryptionBranchKeyIdSupplierOutput,
    DynamoDbEncryptionConfig_DynamoDbEncryptionConfig as DafnyDynamoDbEncryptionConfig,
    EncryptedDataKeyDescription_EncryptedDataKeyDescription as DafnyEncryptedDataKeyDescription,
    GetBranchKeyIdFromDdbKeyInput_GetBranchKeyIdFromDdbKeyInput as DafnyGetBranchKeyIdFromDdbKeyInput,
    GetBranchKeyIdFromDdbKeyOutput_GetBranchKeyIdFromDdbKeyOutput as DafnyGetBranchKeyIdFromDdbKeyOutput,
    GetEncryptedDataKeyDescriptionInput_GetEncryptedDataKeyDescriptionInput as DafnyGetEncryptedDataKeyDescriptionInput,
    GetEncryptedDataKeyDescriptionOutput_GetEncryptedDataKeyDescriptionOutput as DafnyGetEncryptedDataKeyDescriptionOutput,
    GetEncryptedDataKeyDescriptionUnion_header,
    GetEncryptedDataKeyDescriptionUnion_item,
)
import aws_database_encryption_sdk.internaldafny.generated.module_
import aws_database_encryption_sdk.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models
import aws_database_encryption_sdk.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.smithy_to_dafny
from smithy_dafny_standard_library.internaldafny.generated.Wrappers import (
    Option_None,
    Option_Some,
)


def aws_cryptography_dbencryptionsdk_dynamodb_GetBranchKeyIdFromDdbKeyInput(
    native_input,
):
    return DafnyGetBranchKeyIdFromDdbKeyInput(
        ddbKey=Map(
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
                for (key, value) in native_input.ddb_key.items()
            }
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_GetBranchKeyIdFromDdbKeyOutput(
    native_input,
):
    return DafnyGetBranchKeyIdFromDdbKeyOutput(
        branchKeyId=Seq(
            "".join(
                [
                    chr(int.from_bytes(pair, "big"))
                    for pair in zip(
                        *[iter(native_input.branch_key_id.encode("utf-16-be"))] * 2
                    )
                ]
            )
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_CreateDynamoDbEncryptionBranchKeyIdSupplierInput(
    native_input,
):
    return DafnyCreateDynamoDbEncryptionBranchKeyIdSupplierInput(
        ddbKeyBranchKeyIdSupplier=aws_database_encryption_sdk.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_DynamoDbKeyBranchKeyIdSupplierReference(
            native_input.ddb_key_branch_key_id_supplier
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_DynamoDbKeyBranchKeyIdSupplierReference(
    native_input,
):
    if hasattr(native_input, "_impl"):
        return native_input._impl

    else:
        return native_input


def aws_cryptography_dbencryptionsdk_dynamodb_GetEncryptedDataKeyDescriptionInput(
    native_input,
):
    return DafnyGetEncryptedDataKeyDescriptionInput(
        input=aws_database_encryption_sdk.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_GetEncryptedDataKeyDescriptionUnion(
            native_input.input
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_GetEncryptedDataKeyDescriptionUnion(
    native_input,
):
    if isinstance(
        native_input,
        aws_database_encryption_sdk.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.GetEncryptedDataKeyDescriptionUnionHeader,
    ):
        GetEncryptedDataKeyDescriptionUnion_union_value = (
            GetEncryptedDataKeyDescriptionUnion_header(Seq(native_input.value))
        )
    elif isinstance(
        native_input,
        aws_database_encryption_sdk.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.GetEncryptedDataKeyDescriptionUnionItem,
    ):
        GetEncryptedDataKeyDescriptionUnion_union_value = GetEncryptedDataKeyDescriptionUnion_item(
            Map(
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
                    for (key, value) in native_input.value.items()
                }
            )
        )
    else:
        raise ValueError(
            "No recognized union value in union type: " + str(native_input)
        )

    return GetEncryptedDataKeyDescriptionUnion_union_value


def aws_cryptography_dbencryptionsdk_dynamodb_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput(
    native_input,
):
    return DafnyCreateDynamoDbEncryptionBranchKeyIdSupplierOutput(
        branchKeyIdSupplier=aws_cryptographic_materialproviders.smithygenerated.aws_cryptography_materialproviders.smithy_to_dafny.aws_cryptography_materialproviders_BranchKeyIdSupplierReference(
            native_input.branch_key_id_supplier
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_GetEncryptedDataKeyDescriptionOutput(
    native_input,
):
    return DafnyGetEncryptedDataKeyDescriptionOutput(
        EncryptedDataKeyDescriptionOutput=Seq(
            [
                aws_database_encryption_sdk.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_EncryptedDataKeyDescription(
                    list_element
                )
                for list_element in native_input.encrypted_data_key_description_output
            ]
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_EncryptedDataKeyDescription(native_input):
    return DafnyEncryptedDataKeyDescription(
        keyProviderId=Seq(
            "".join(
                [
                    chr(int.from_bytes(pair, "big"))
                    for pair in zip(
                        *[iter(native_input.key_provider_id.encode("utf-16-be"))] * 2
                    )
                ]
            )
        ),
        keyProviderInfo=(
            (
                Option_Some(
                    Seq(
                        "".join(
                            [
                                chr(int.from_bytes(pair, "big"))
                                for pair in zip(
                                    *[
                                        iter(
                                            native_input.key_provider_info.encode(
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
            if (native_input.key_provider_info is not None)
            else (Option_None())
        ),
        branchKeyId=(
            (
                Option_Some(
                    Seq(
                        "".join(
                            [
                                chr(int.from_bytes(pair, "big"))
                                for pair in zip(
                                    *[
                                        iter(
                                            native_input.branch_key_id.encode(
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
            if (native_input.branch_key_id is not None)
            else (Option_None())
        ),
        branchKeyVersion=(
            (
                Option_Some(
                    Seq(
                        "".join(
                            [
                                chr(int.from_bytes(pair, "big"))
                                for pair in zip(
                                    *[
                                        iter(
                                            native_input.branch_key_version.encode(
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
            if (native_input.branch_key_version is not None)
            else (Option_None())
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_DynamoDbEncryptionConfig(native_input):
    return DafnyDynamoDbEncryptionConfig()
