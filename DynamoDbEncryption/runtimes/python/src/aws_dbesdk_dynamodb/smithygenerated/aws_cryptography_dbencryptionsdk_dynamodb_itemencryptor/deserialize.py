# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
# Do not modify this file. This file is machine generated, and any changes to it will be overwritten.

import _dafny
from aws_dbesdk_dynamodb.internaldafny.generated.AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes import (
    DecryptItemOutput_DecryptItemOutput as DafnyDecryptItemOutput,
    EncryptItemOutput_EncryptItemOutput as DafnyEncryptItemOutput,
    Error,
    Error_DynamoDbItemEncryptorException,
)
import aws_dbesdk_dynamodb.internaldafny.generated.module_
import aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor.dafny_to_smithy
from typing import Any

from .dafny_protocol import DafnyResponse
from .errors import (
    AwsCryptographicMaterialProviders,
    AwsCryptographicPrimitives,
    CollectionOfErrors,
    ComAmazonawsDynamodb,
    DynamoDbEncryption,
    DynamoDbItemEncryptorException,
    OpaqueError,
    ServiceError,
    StructuredEncryption,
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

from ..aws_cryptography_dbencryptionsdk_dynamodb.deserialize import (
    _deserialize_error as aws_cryptography_dbencryptionsdk_dynamodb_deserialize_error,
)
from ..aws_cryptography_dbencryptionsdk_structuredencryption.deserialize import (
    _deserialize_error as aws_cryptography_dbencryptionsdk_structuredencryption_deserialize_error,
)
from .config import Config


def _deserialize_encrypt_item(input: DafnyResponse, config: Config):

    if input.IsFailure():
        return _deserialize_error(input.error)
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor_EncryptItemOutput(
        input.value
    )


def _deserialize_decrypt_item(input: DafnyResponse, config: Config):

    if input.IsFailure():
        return _deserialize_error(input.error)
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor_DecryptItemOutput(
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
    elif error.is_DynamoDbItemEncryptorException:
        return DynamoDbItemEncryptorException(message=_dafny.string_of(error.message))
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
    elif error.is_AwsCryptographyDbEncryptionSdkDynamoDb:
        return DynamoDbEncryption(
            aws_cryptography_dbencryptionsdk_dynamodb_deserialize_error(
                error.AwsCryptographyDbEncryptionSdkDynamoDb
            )
        )
    elif error.is_AwsCryptographyMaterialProviders:
        return AwsCryptographicMaterialProviders(
            aws_cryptography_materialproviders_deserialize_error(
                error.AwsCryptographyMaterialProviders
            )
        )
    elif error.is_ComAmazonawsDynamodb:
        return ComAmazonawsDynamodb(
            message=_dafny.string_of(error.ComAmazonawsDynamodb.message)
        )
    else:
        return OpaqueError(obj=error)
