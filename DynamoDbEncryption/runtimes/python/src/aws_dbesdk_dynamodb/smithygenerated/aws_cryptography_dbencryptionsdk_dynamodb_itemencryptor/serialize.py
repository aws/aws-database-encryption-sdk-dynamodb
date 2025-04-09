# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
# Do not modify this file. This file is machine generated, and any changes to it will be overwritten.

import aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor.smithy_to_dafny

from .dafny_protocol import DafnyRequest

from .config import Config


def _serialize_encrypt_item(input, config: Config) -> DafnyRequest:
    return DafnyRequest(
        operation_name="EncryptItem",
        dafny_operation_input=aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor_EncryptItemInput(
            input
        ),
    )


def _serialize_decrypt_item(input, config: Config) -> DafnyRequest:
    return DafnyRequest(
        operation_name="DecryptItem",
        dafny_operation_input=aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor_DecryptItemInput(
            input
        ),
    )
