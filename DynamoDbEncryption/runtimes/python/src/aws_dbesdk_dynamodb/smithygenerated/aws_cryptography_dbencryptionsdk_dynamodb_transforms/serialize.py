# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
# Do not modify this file. This file is machine generated, and any changes to it will be overwritten.

import aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.smithy_to_dafny

from .dafny_protocol import DafnyRequest

from .config import Config


def _serialize_put_item_input_transform(input, config: Config) -> DafnyRequest:
    return DafnyRequest(
        operation_name="PutItemInputTransform",
        dafny_operation_input=aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_transforms_PutItemInputTransformInput(
            input
        ),
    )


def _serialize_put_item_output_transform(input, config: Config) -> DafnyRequest:
    return DafnyRequest(
        operation_name="PutItemOutputTransform",
        dafny_operation_input=aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_transforms_PutItemOutputTransformInput(
            input
        ),
    )


def _serialize_get_item_input_transform(input, config: Config) -> DafnyRequest:
    return DafnyRequest(
        operation_name="GetItemInputTransform",
        dafny_operation_input=aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_transforms_GetItemInputTransformInput(
            input
        ),
    )


def _serialize_get_item_output_transform(input, config: Config) -> DafnyRequest:
    return DafnyRequest(
        operation_name="GetItemOutputTransform",
        dafny_operation_input=aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_transforms_GetItemOutputTransformInput(
            input
        ),
    )


def _serialize_batch_write_item_input_transform(input, config: Config) -> DafnyRequest:
    return DafnyRequest(
        operation_name="BatchWriteItemInputTransform",
        dafny_operation_input=aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_transforms_BatchWriteItemInputTransformInput(
            input
        ),
    )


def _serialize_batch_write_item_output_transform(input, config: Config) -> DafnyRequest:
    return DafnyRequest(
        operation_name="BatchWriteItemOutputTransform",
        dafny_operation_input=aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_transforms_BatchWriteItemOutputTransformInput(
            input
        ),
    )


def _serialize_batch_get_item_input_transform(input, config: Config) -> DafnyRequest:
    return DafnyRequest(
        operation_name="BatchGetItemInputTransform",
        dafny_operation_input=aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_transforms_BatchGetItemInputTransformInput(
            input
        ),
    )


def _serialize_batch_get_item_output_transform(input, config: Config) -> DafnyRequest:
    return DafnyRequest(
        operation_name="BatchGetItemOutputTransform",
        dafny_operation_input=aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_transforms_BatchGetItemOutputTransformInput(
            input
        ),
    )


def _serialize_scan_input_transform(input, config: Config) -> DafnyRequest:
    return DafnyRequest(
        operation_name="ScanInputTransform",
        dafny_operation_input=aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_transforms_ScanInputTransformInput(
            input
        ),
    )


def _serialize_scan_output_transform(input, config: Config) -> DafnyRequest:
    return DafnyRequest(
        operation_name="ScanOutputTransform",
        dafny_operation_input=aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_transforms_ScanOutputTransformInput(
            input
        ),
    )


def _serialize_query_input_transform(input, config: Config) -> DafnyRequest:
    return DafnyRequest(
        operation_name="QueryInputTransform",
        dafny_operation_input=aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_transforms_QueryInputTransformInput(
            input
        ),
    )


def _serialize_query_output_transform(input, config: Config) -> DafnyRequest:
    return DafnyRequest(
        operation_name="QueryOutputTransform",
        dafny_operation_input=aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_transforms_QueryOutputTransformInput(
            input
        ),
    )


def _serialize_transact_write_items_input_transform(
    input, config: Config
) -> DafnyRequest:
    return DafnyRequest(
        operation_name="TransactWriteItemsInputTransform",
        dafny_operation_input=aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_transforms_TransactWriteItemsInputTransformInput(
            input
        ),
    )


def _serialize_transact_write_items_output_transform(
    input, config: Config
) -> DafnyRequest:
    return DafnyRequest(
        operation_name="TransactWriteItemsOutputTransform",
        dafny_operation_input=aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_transforms_TransactWriteItemsOutputTransformInput(
            input
        ),
    )


def _serialize_update_item_input_transform(input, config: Config) -> DafnyRequest:
    return DafnyRequest(
        operation_name="UpdateItemInputTransform",
        dafny_operation_input=aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_transforms_UpdateItemInputTransformInput(
            input
        ),
    )


def _serialize_update_item_output_transform(input, config: Config) -> DafnyRequest:
    return DafnyRequest(
        operation_name="UpdateItemOutputTransform",
        dafny_operation_input=aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_transforms_UpdateItemOutputTransformInput(
            input
        ),
    )


def _serialize_delete_item_input_transform(input, config: Config) -> DafnyRequest:
    return DafnyRequest(
        operation_name="DeleteItemInputTransform",
        dafny_operation_input=aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_transforms_DeleteItemInputTransformInput(
            input
        ),
    )


def _serialize_delete_item_output_transform(input, config: Config) -> DafnyRequest:
    return DafnyRequest(
        operation_name="DeleteItemOutputTransform",
        dafny_operation_input=aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_transforms_DeleteItemOutputTransformInput(
            input
        ),
    )


def _serialize_transact_get_items_input_transform(
    input, config: Config
) -> DafnyRequest:
    return DafnyRequest(
        operation_name="TransactGetItemsInputTransform",
        dafny_operation_input=aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_transforms_TransactGetItemsInputTransformInput(
            input
        ),
    )


def _serialize_transact_get_items_output_transform(
    input, config: Config
) -> DafnyRequest:
    return DafnyRequest(
        operation_name="TransactGetItemsOutputTransform",
        dafny_operation_input=aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_transforms_TransactGetItemsOutputTransformInput(
            input
        ),
    )


def _serialize_execute_statement_input_transform(input, config: Config) -> DafnyRequest:
    return DafnyRequest(
        operation_name="ExecuteStatementInputTransform",
        dafny_operation_input=aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_transforms_ExecuteStatementInputTransformInput(
            input
        ),
    )


def _serialize_execute_statement_output_transform(
    input, config: Config
) -> DafnyRequest:
    return DafnyRequest(
        operation_name="ExecuteStatementOutputTransform",
        dafny_operation_input=aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_transforms_ExecuteStatementOutputTransformInput(
            input
        ),
    )


def _serialize_batch_execute_statement_input_transform(
    input, config: Config
) -> DafnyRequest:
    return DafnyRequest(
        operation_name="BatchExecuteStatementInputTransform",
        dafny_operation_input=aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_transforms_BatchExecuteStatementInputTransformInput(
            input
        ),
    )


def _serialize_batch_execute_statement_output_transform(
    input, config: Config
) -> DafnyRequest:
    return DafnyRequest(
        operation_name="BatchExecuteStatementOutputTransform",
        dafny_operation_input=aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_transforms_BatchExecuteStatementOutputTransformInput(
            input
        ),
    )


def _serialize_execute_transaction_input_transform(
    input, config: Config
) -> DafnyRequest:
    return DafnyRequest(
        operation_name="ExecuteTransactionInputTransform",
        dafny_operation_input=aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_transforms_ExecuteTransactionInputTransformInput(
            input
        ),
    )


def _serialize_execute_transaction_output_transform(
    input, config: Config
) -> DafnyRequest:
    return DafnyRequest(
        operation_name="ExecuteTransactionOutputTransform",
        dafny_operation_input=aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_transforms_ExecuteTransactionOutputTransformInput(
            input
        ),
    )


def _serialize_resolve_attributes(input, config: Config) -> DafnyRequest:
    return DafnyRequest(
        operation_name="ResolveAttributes",
        dafny_operation_input=aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_transforms_ResolveAttributesInput(
            input
        ),
    )
