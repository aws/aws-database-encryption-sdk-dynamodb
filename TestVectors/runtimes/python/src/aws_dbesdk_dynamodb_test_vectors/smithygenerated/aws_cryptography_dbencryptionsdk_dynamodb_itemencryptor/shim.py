# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
# Do not modify this file. This file is machine generated, and any changes to it will be overwritten.

from aws_dbesdk_dynamodb.internaldafny.generated.AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes import (
    DecryptItemInput_DecryptItemInput as DafnyDecryptItemInput,
    DecryptItemOutput_DecryptItemOutput as DafnyDecryptItemOutput,
    EncryptItemInput_EncryptItemInput as DafnyEncryptItemInput,
    EncryptItemOutput_EncryptItemOutput as DafnyEncryptItemOutput,
)
import aws_dbesdk_dynamodb.internaldafny.generated.module_
import aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor.dafny_to_smithy
import aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor.errors
from aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor.errors import (
    CollectionOfErrors,
    OpaqueError,
    ServiceError,
    _smithy_error_to_dafny_error,
)
import aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor.models
import aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor.smithy_to_dafny
from typing import Any


import smithy_dafny_standard_library.internaldafny.generated.Wrappers as Wrappers
import aws_dbesdk_dynamodb.internaldafny.generated.AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes
import aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor.client as client_impl


class DynamoDbItemEncryptorShim(
    aws_dbesdk_dynamodb.internaldafny.generated.AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.IDynamoDbItemEncryptorClient
):
    def __init__(self, _impl: client_impl):
        self._impl = _impl

    def EncryptItem(self, input):
        try:
            smithy_client_request: (
                aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor.models.EncryptItemInput
            ) = aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor_EncryptItemInput(
                input
            )
            smithy_client_response = self._impl.encrypt_item(smithy_client_request)
            return Wrappers.Result_Success(
                aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor_EncryptItemOutput(
                    smithy_client_response
                )
            )
        except Exception as e:
            return Wrappers.Result_Failure(_smithy_error_to_dafny_error(e))

    def DecryptItem(self, input):
        try:
            smithy_client_request: (
                aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor.models.DecryptItemInput
            ) = aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor_DecryptItemInput(
                input
            )
            smithy_client_response = self._impl.decrypt_item(smithy_client_request)
            return Wrappers.Result_Success(
                aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor_DecryptItemOutput(
                    smithy_client_response
                )
            )
        except Exception as e:
            return Wrappers.Result_Failure(_smithy_error_to_dafny_error(e))
