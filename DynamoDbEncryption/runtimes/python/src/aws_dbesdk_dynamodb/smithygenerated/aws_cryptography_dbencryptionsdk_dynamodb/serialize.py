# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
# Do not modify this file. This file is machine generated, and any changes to it will be overwritten.

import aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.smithy_to_dafny

from .dafny_protocol import DafnyRequest

from .config import Config


def _serialize_create_dynamo_db_encryption_branch_key_id_supplier(
    input, config: Config
) -> DafnyRequest:
    return DafnyRequest(
        operation_name="CreateDynamoDbEncryptionBranchKeyIdSupplier",
        dafny_operation_input=aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_CreateDynamoDbEncryptionBranchKeyIdSupplierInput(
            input
        ),
    )


def _serialize_get_encrypted_data_key_description(
    input, config: Config
) -> DafnyRequest:
    return DafnyRequest(
        operation_name="GetEncryptedDataKeyDescription",
        dafny_operation_input=aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_GetEncryptedDataKeyDescriptionInput(
            input
        ),
    )
