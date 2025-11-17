# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
# Do not modify this file. This file is machine generated, and any changes to it will be overwritten.

import aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.smithy_to_dafny

from .dafny_protocol import DafnyRequest

from .config import Config


def _serialize_encrypt_structure(input, config: Config) -> DafnyRequest:
    return DafnyRequest(
        operation_name="EncryptStructure",
        dafny_operation_input=aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.smithy_to_dafny.aws_cryptography_dbencryptionsdk_structuredencryption_EncryptStructureInput(
            input
        ),
    )


def _serialize_decrypt_structure(input, config: Config) -> DafnyRequest:
    return DafnyRequest(
        operation_name="DecryptStructure",
        dafny_operation_input=aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.smithy_to_dafny.aws_cryptography_dbencryptionsdk_structuredencryption_DecryptStructureInput(
            input
        ),
    )


def _serialize_encrypt_path_structure(input, config: Config) -> DafnyRequest:
    return DafnyRequest(
        operation_name="EncryptPathStructure",
        dafny_operation_input=aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.smithy_to_dafny.aws_cryptography_dbencryptionsdk_structuredencryption_EncryptPathStructureInput(
            input
        ),
    )


def _serialize_decrypt_path_structure(input, config: Config) -> DafnyRequest:
    return DafnyRequest(
        operation_name="DecryptPathStructure",
        dafny_operation_input=aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.smithy_to_dafny.aws_cryptography_dbencryptionsdk_structuredencryption_DecryptPathStructureInput(
            input
        ),
    )


def _serialize_resolve_auth_actions(input, config: Config) -> DafnyRequest:
    return DafnyRequest(
        operation_name="ResolveAuthActions",
        dafny_operation_input=aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.smithy_to_dafny.aws_cryptography_dbencryptionsdk_structuredencryption_ResolveAuthActionsInput(
            input
        ),
    )
