# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
# Do not modify this file. This file is machine generated, and any changes to it will be overwritten.

from aws_dbesdk_dynamodb.internaldafny.generated.AwsCryptographyDbEncryptionSdkDynamoDbTypes import (
    CreateDynamoDbEncryptionBranchKeyIdSupplierInput_CreateDynamoDbEncryptionBranchKeyIdSupplierInput as DafnyCreateDynamoDbEncryptionBranchKeyIdSupplierInput,
    CreateDynamoDbEncryptionBranchKeyIdSupplierOutput_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput as DafnyCreateDynamoDbEncryptionBranchKeyIdSupplierOutput,
    GetEncryptedDataKeyDescriptionInput_GetEncryptedDataKeyDescriptionInput as DafnyGetEncryptedDataKeyDescriptionInput,
    GetEncryptedDataKeyDescriptionOutput_GetEncryptedDataKeyDescriptionOutput as DafnyGetEncryptedDataKeyDescriptionOutput,
)
import aws_dbesdk_dynamodb.internaldafny.generated.module_
import aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.dafny_to_smithy
import aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.errors
from aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.errors import (
    CollectionOfErrors,
    OpaqueError,
    ServiceError,
    _smithy_error_to_dafny_error,
)
import aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models
import aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.smithy_to_dafny
from typing import Any


import smithy_dafny_standard_library.internaldafny.generated.Wrappers as Wrappers
import aws_dbesdk_dynamodb.internaldafny.generated.AwsCryptographyDbEncryptionSdkDynamoDbTypes
import aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.client as client_impl


class DynamoDbEncryptionShim(
    aws_dbesdk_dynamodb.internaldafny.generated.AwsCryptographyDbEncryptionSdkDynamoDbTypes.IDynamoDbEncryptionClient
):
    def __init__(self, _impl: client_impl):
        self._impl = _impl

    def CreateDynamoDbEncryptionBranchKeyIdSupplier(self, input):
        try:
            smithy_client_request: (
                aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.CreateDynamoDbEncryptionBranchKeyIdSupplierInput
            ) = aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_CreateDynamoDbEncryptionBranchKeyIdSupplierInput(
                input
            )
            smithy_client_response = (
                self._impl.create_dynamo_db_encryption_branch_key_id_supplier(
                    smithy_client_request
                )
            )
            return Wrappers.Result_Success(
                aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput(
                    smithy_client_response
                )
            )
        except Exception as e:
            return Wrappers.Result_Failure(_smithy_error_to_dafny_error(e))

    def GetEncryptedDataKeyDescription(self, input):
        try:
            smithy_client_request: (
                aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.GetEncryptedDataKeyDescriptionInput
            ) = aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_GetEncryptedDataKeyDescriptionInput(
                input
            )
            smithy_client_response = self._impl.get_encrypted_data_key_description(
                smithy_client_request
            )
            return Wrappers.Result_Success(
                aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_GetEncryptedDataKeyDescriptionOutput(
                    smithy_client_response
                )
            )
        except Exception as e:
            return Wrappers.Result_Failure(_smithy_error_to_dafny_error(e))
