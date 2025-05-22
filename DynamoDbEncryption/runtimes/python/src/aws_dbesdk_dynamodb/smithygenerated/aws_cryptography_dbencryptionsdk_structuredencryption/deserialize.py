# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
# Do not modify this file. This file is machine generated, and any changes to it will be overwritten.

import _dafny
from aws_dbesdk_dynamodb.internaldafny.generated.AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes import (
    DecryptPathStructureOutput_DecryptPathStructureOutput as DafnyDecryptPathStructureOutput,
    DecryptStructureOutput_DecryptStructureOutput as DafnyDecryptStructureOutput,
    EncryptPathStructureOutput_EncryptPathStructureOutput as DafnyEncryptPathStructureOutput,
    EncryptStructureOutput_EncryptStructureOutput as DafnyEncryptStructureOutput,
    Error,
    Error_StructuredEncryptionException,
    ResolveAuthActionsOutput_ResolveAuthActionsOutput as DafnyResolveAuthActionsOutput,
)
import aws_dbesdk_dynamodb.internaldafny.generated.module_
import aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.dafny_to_smithy
from typing import Any

from .dafny_protocol import DafnyResponse
from .errors import (
    AwsCryptographicMaterialProviders,
    AwsCryptographicPrimitives,
    CollectionOfErrors,
    OpaqueError,
    ServiceError,
    StructuredEncryptionException,
)
from aws_cryptographic_material_providers.smithygenerated.aws_cryptography_materialproviders.deserialize import (
    _deserialize_error as aws_cryptography_materialproviders_deserialize_error,
)
from aws_cryptography_primitives.smithygenerated.aws_cryptography_primitives.deserialize import (
    _deserialize_error as aws_cryptography_primitives_deserialize_error,
)

from .config import Config


def _deserialize_encrypt_structure(input: DafnyResponse, config: Config):

    if input.IsFailure():
        return _deserialize_error(input.error)
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.dafny_to_smithy.aws_cryptography_dbencryptionsdk_structuredencryption_EncryptStructureOutput(
        input.value
    )


def _deserialize_decrypt_structure(input: DafnyResponse, config: Config):

    if input.IsFailure():
        return _deserialize_error(input.error)
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.dafny_to_smithy.aws_cryptography_dbencryptionsdk_structuredencryption_DecryptStructureOutput(
        input.value
    )


def _deserialize_encrypt_path_structure(input: DafnyResponse, config: Config):

    if input.IsFailure():
        return _deserialize_error(input.error)
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.dafny_to_smithy.aws_cryptography_dbencryptionsdk_structuredencryption_EncryptPathStructureOutput(
        input.value
    )


def _deserialize_decrypt_path_structure(input: DafnyResponse, config: Config):

    if input.IsFailure():
        return _deserialize_error(input.error)
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.dafny_to_smithy.aws_cryptography_dbencryptionsdk_structuredencryption_DecryptPathStructureOutput(
        input.value
    )


def _deserialize_resolve_auth_actions(input: DafnyResponse, config: Config):

    if input.IsFailure():
        return _deserialize_error(input.error)
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.dafny_to_smithy.aws_cryptography_dbencryptionsdk_structuredencryption_ResolveAuthActionsOutput(
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
    elif error.is_StructuredEncryptionException:
        return StructuredEncryptionException(message=_dafny.string_of(error.message))
    elif error.is_AwsCryptographyPrimitives:
        return AwsCryptographicPrimitives(
            aws_cryptography_primitives_deserialize_error(error.AwsCryptographyPrimitives)
        )
    elif error.is_AwsCryptographyMaterialProviders:
        return AwsCryptographicMaterialProviders(
            aws_cryptography_materialproviders_deserialize_error(error.AwsCryptographyMaterialProviders)
        )
    else:
        return OpaqueError(obj=error)
