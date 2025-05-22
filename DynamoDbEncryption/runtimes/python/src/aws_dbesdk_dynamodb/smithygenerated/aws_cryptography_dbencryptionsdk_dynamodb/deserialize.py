# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
# Do not modify this file. This file is machine generated, and any changes to it will be overwritten.

import _dafny
from aws_dbesdk_dynamodb.internaldafny.generated.AwsCryptographyDbEncryptionSdkDynamoDbTypes import (
    CreateDynamoDbEncryptionBranchKeyIdSupplierOutput_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput as DafnyCreateDynamoDbEncryptionBranchKeyIdSupplierOutput,
    Error,
    Error_DynamoDbEncryptionException,
    GetEncryptedDataKeyDescriptionOutput_GetEncryptedDataKeyDescriptionOutput as DafnyGetEncryptedDataKeyDescriptionOutput,
)
import aws_dbesdk_dynamodb.internaldafny.generated.module_
import aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.dafny_to_smithy
from typing import Any

from .dafny_protocol import DafnyResponse
from .errors import (
    AwsCryptographicMaterialProviders,
    AwsCryptographicPrimitives,
    CollectionOfErrors,
    ComAmazonawsDynamodb,
    DynamoDbEncryptionException,
    KeyStore,
    OpaqueError,
    ServiceError,
    StructuredEncryption,
)
from aws_cryptographic_material_providers.smithygenerated.aws_cryptography_keystore.deserialize import (
    _deserialize_error as aws_cryptography_keystore_deserialize_error,
)
from aws_cryptographic_material_providers.smithygenerated.aws_cryptography_materialproviders.deserialize import (
    _deserialize_error as aws_cryptography_materialproviders_deserialize_error,
)
from aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.shim import (
    _sdk_error_to_dafny_error as com_amazonaws_dynamodb_sdk_error_to_dafny_error,
)
from aws_cryptography_primitives.smithygenerated.aws_cryptography_primitives.deserialize import (
    _deserialize_error as aws_cryptography_primitives_deserialize_error,
)

from ..aws_cryptography_dbencryptionsdk_structuredencryption.deserialize import (
    _deserialize_error as aws_cryptography_dbencryptionsdk_structuredencryption_deserialize_error,
)
from .config import Config


def _deserialize_create_dynamo_db_encryption_branch_key_id_supplier(
    input: DafnyResponse, config: Config
):

    if input.IsFailure():
        return _deserialize_error(input.error)
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput(
        input.value
    )


def _deserialize_get_encrypted_data_key_description(
    input: DafnyResponse, config: Config
):

    if input.IsFailure():
        return _deserialize_error(input.error)
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_GetEncryptedDataKeyDescriptionOutput(
        input.value
    )


def _deserialize_error(error: Error) -> ServiceError:
    if error.is_Opaque:
        return OpaqueError(obj=error.obj)
    elif error.is_OpaqueWithText:
        return OpaqueErrorWithText(obj=error.obj, obj_message=error.objMessage)
    elif error.is_CollectionOfErrors:
        return CollectionOfErrors(
            message=_dafny.string_of(error.message),
            list=[_deserialize_error(dafny_e) for dafny_e in error.list],
        )
    elif error.is_DynamoDbEncryptionException:
        return DynamoDbEncryptionException(message=_dafny.string_of(error.message))
    elif error.is_AwsCryptographyDbEncryptionSdkStructuredEncryption:
        return StructuredEncryption(
            aws_cryptography_dbencryptionsdk_structuredencryption_deserialize_error(
                error.AwsCryptographyDbEncryptionSdkStructuredEncryption
            )
        )
    elif error.is_AwsCryptographyPrimitives:
        return AwsCryptographicPrimitives(
            aws_cryptography_primitives_deserialize_error(
                error.AwsCryptographyPrimitives
            )
        )
    elif error.is_AwsCryptographyMaterialProviders:
        return AwsCryptographicMaterialProviders(
            aws_cryptography_materialproviders_deserialize_error(
                error.AwsCryptographyMaterialProviders
            )
        )
    elif error.is_AwsCryptographyKeyStore:
        return KeyStore(
            aws_cryptography_keystore_deserialize_error(error.AwsCryptographyKeyStore)
        )
    elif error.is_ComAmazonawsDynamodb:
        return ComAmazonawsDynamodb(
            message=_dafny.string_of(error.ComAmazonawsDynamodb.message)
        )
    else:
        return OpaqueError(obj=error)
