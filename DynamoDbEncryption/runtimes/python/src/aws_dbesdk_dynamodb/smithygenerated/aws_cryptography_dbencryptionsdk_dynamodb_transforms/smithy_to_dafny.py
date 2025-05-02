# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
# Do not modify this file. This file is machine generated, and any changes to it will be overwritten.

from _dafny import Map, Seq
import aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny
from aws_dbesdk_dynamodb.internaldafny.generated.AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes import (
    BatchExecuteStatementInputTransformInput_BatchExecuteStatementInputTransformInput as DafnyBatchExecuteStatementInputTransformInput,
    BatchExecuteStatementInputTransformOutput_BatchExecuteStatementInputTransformOutput as DafnyBatchExecuteStatementInputTransformOutput,
    BatchExecuteStatementOutputTransformInput_BatchExecuteStatementOutputTransformInput as DafnyBatchExecuteStatementOutputTransformInput,
    BatchExecuteStatementOutputTransformOutput_BatchExecuteStatementOutputTransformOutput as DafnyBatchExecuteStatementOutputTransformOutput,
    BatchGetItemInputTransformInput_BatchGetItemInputTransformInput as DafnyBatchGetItemInputTransformInput,
    BatchGetItemInputTransformOutput_BatchGetItemInputTransformOutput as DafnyBatchGetItemInputTransformOutput,
    BatchGetItemOutputTransformInput_BatchGetItemOutputTransformInput as DafnyBatchGetItemOutputTransformInput,
    BatchGetItemOutputTransformOutput_BatchGetItemOutputTransformOutput as DafnyBatchGetItemOutputTransformOutput,
    BatchWriteItemInputTransformInput_BatchWriteItemInputTransformInput as DafnyBatchWriteItemInputTransformInput,
    BatchWriteItemInputTransformOutput_BatchWriteItemInputTransformOutput as DafnyBatchWriteItemInputTransformOutput,
    BatchWriteItemOutputTransformInput_BatchWriteItemOutputTransformInput as DafnyBatchWriteItemOutputTransformInput,
    BatchWriteItemOutputTransformOutput_BatchWriteItemOutputTransformOutput as DafnyBatchWriteItemOutputTransformOutput,
    DeleteItemInputTransformInput_DeleteItemInputTransformInput as DafnyDeleteItemInputTransformInput,
    DeleteItemInputTransformOutput_DeleteItemInputTransformOutput as DafnyDeleteItemInputTransformOutput,
    DeleteItemOutputTransformInput_DeleteItemOutputTransformInput as DafnyDeleteItemOutputTransformInput,
    DeleteItemOutputTransformOutput_DeleteItemOutputTransformOutput as DafnyDeleteItemOutputTransformOutput,
    ExecuteStatementInputTransformInput_ExecuteStatementInputTransformInput as DafnyExecuteStatementInputTransformInput,
    ExecuteStatementInputTransformOutput_ExecuteStatementInputTransformOutput as DafnyExecuteStatementInputTransformOutput,
    ExecuteStatementOutputTransformInput_ExecuteStatementOutputTransformInput as DafnyExecuteStatementOutputTransformInput,
    ExecuteStatementOutputTransformOutput_ExecuteStatementOutputTransformOutput as DafnyExecuteStatementOutputTransformOutput,
    ExecuteTransactionInputTransformInput_ExecuteTransactionInputTransformInput as DafnyExecuteTransactionInputTransformInput,
    ExecuteTransactionInputTransformOutput_ExecuteTransactionInputTransformOutput as DafnyExecuteTransactionInputTransformOutput,
    ExecuteTransactionOutputTransformInput_ExecuteTransactionOutputTransformInput as DafnyExecuteTransactionOutputTransformInput,
    ExecuteTransactionOutputTransformOutput_ExecuteTransactionOutputTransformOutput as DafnyExecuteTransactionOutputTransformOutput,
    GetItemInputTransformInput_GetItemInputTransformInput as DafnyGetItemInputTransformInput,
    GetItemInputTransformOutput_GetItemInputTransformOutput as DafnyGetItemInputTransformOutput,
    GetItemOutputTransformInput_GetItemOutputTransformInput as DafnyGetItemOutputTransformInput,
    GetItemOutputTransformOutput_GetItemOutputTransformOutput as DafnyGetItemOutputTransformOutput,
    PutItemInputTransformInput_PutItemInputTransformInput as DafnyPutItemInputTransformInput,
    PutItemInputTransformOutput_PutItemInputTransformOutput as DafnyPutItemInputTransformOutput,
    PutItemOutputTransformInput_PutItemOutputTransformInput as DafnyPutItemOutputTransformInput,
    PutItemOutputTransformOutput_PutItemOutputTransformOutput as DafnyPutItemOutputTransformOutput,
    QueryInputTransformInput_QueryInputTransformInput as DafnyQueryInputTransformInput,
    QueryInputTransformOutput_QueryInputTransformOutput as DafnyQueryInputTransformOutput,
    QueryOutputTransformInput_QueryOutputTransformInput as DafnyQueryOutputTransformInput,
    QueryOutputTransformOutput_QueryOutputTransformOutput as DafnyQueryOutputTransformOutput,
    ResolveAttributesInput_ResolveAttributesInput as DafnyResolveAttributesInput,
    ResolveAttributesOutput_ResolveAttributesOutput as DafnyResolveAttributesOutput,
    ScanInputTransformInput_ScanInputTransformInput as DafnyScanInputTransformInput,
    ScanInputTransformOutput_ScanInputTransformOutput as DafnyScanInputTransformOutput,
    ScanOutputTransformInput_ScanOutputTransformInput as DafnyScanOutputTransformInput,
    ScanOutputTransformOutput_ScanOutputTransformOutput as DafnyScanOutputTransformOutput,
    TransactGetItemsInputTransformInput_TransactGetItemsInputTransformInput as DafnyTransactGetItemsInputTransformInput,
    TransactGetItemsInputTransformOutput_TransactGetItemsInputTransformOutput as DafnyTransactGetItemsInputTransformOutput,
    TransactGetItemsOutputTransformInput_TransactGetItemsOutputTransformInput as DafnyTransactGetItemsOutputTransformInput,
    TransactGetItemsOutputTransformOutput_TransactGetItemsOutputTransformOutput as DafnyTransactGetItemsOutputTransformOutput,
    TransactWriteItemsInputTransformInput_TransactWriteItemsInputTransformInput as DafnyTransactWriteItemsInputTransformInput,
    TransactWriteItemsInputTransformOutput_TransactWriteItemsInputTransformOutput as DafnyTransactWriteItemsInputTransformOutput,
    TransactWriteItemsOutputTransformInput_TransactWriteItemsOutputTransformInput as DafnyTransactWriteItemsOutputTransformInput,
    TransactWriteItemsOutputTransformOutput_TransactWriteItemsOutputTransformOutput as DafnyTransactWriteItemsOutputTransformOutput,
    UpdateItemInputTransformInput_UpdateItemInputTransformInput as DafnyUpdateItemInputTransformInput,
    UpdateItemInputTransformOutput_UpdateItemInputTransformOutput as DafnyUpdateItemInputTransformOutput,
    UpdateItemOutputTransformInput_UpdateItemOutputTransformInput as DafnyUpdateItemOutputTransformInput,
    UpdateItemOutputTransformOutput_UpdateItemOutputTransformOutput as DafnyUpdateItemOutputTransformOutput,
)
import aws_dbesdk_dynamodb.internaldafny.generated.module_
from smithy_dafny_standard_library.internaldafny.generated.Wrappers import (
    Option_None,
    Option_Some,
)


def aws_cryptography_dbencryptionsdk_dynamodb_transforms_PutItemInputTransformInput(
    native_input,
):
    return DafnyPutItemInputTransformInput(
        sdkInput=aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_PutItemInput(
            native_input.sdk_input
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_transforms_PutItemOutputTransformInput(
    native_input,
):
    return DafnyPutItemOutputTransformInput(
        sdkOutput=aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_PutItemOutput(
            native_input.sdk_output
        ),
        originalInput=aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_PutItemInput(
            native_input.original_input
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_transforms_GetItemInputTransformInput(
    native_input,
):
    return DafnyGetItemInputTransformInput(
        sdkInput=aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_GetItemInput(
            native_input.sdk_input
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_transforms_GetItemOutputTransformInput(
    native_input,
):
    return DafnyGetItemOutputTransformInput(
        sdkOutput=aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_GetItemOutput(
            native_input.sdk_output
        ),
        originalInput=aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_GetItemInput(
            native_input.original_input
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_transforms_BatchWriteItemInputTransformInput(
    native_input,
):
    return DafnyBatchWriteItemInputTransformInput(
        sdkInput=aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_BatchWriteItemInput(
            native_input.sdk_input
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_transforms_BatchWriteItemOutputTransformInput(
    native_input,
):
    return DafnyBatchWriteItemOutputTransformInput(
        sdkOutput=aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_BatchWriteItemOutput(
            native_input.sdk_output
        ),
        originalInput=aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_BatchWriteItemInput(
            native_input.original_input
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_transforms_BatchGetItemInputTransformInput(
    native_input,
):
    return DafnyBatchGetItemInputTransformInput(
        sdkInput=aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_BatchGetItemInput(
            native_input.sdk_input
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_transforms_BatchGetItemOutputTransformInput(
    native_input,
):
    return DafnyBatchGetItemOutputTransformInput(
        sdkOutput=aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_BatchGetItemOutput(
            native_input.sdk_output
        ),
        originalInput=aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_BatchGetItemInput(
            native_input.original_input
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_transforms_ScanInputTransformInput(
    native_input,
):
    return DafnyScanInputTransformInput(
        sdkInput=aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ScanInput(
            native_input.sdk_input
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_transforms_ScanOutputTransformInput(
    native_input,
):
    return DafnyScanOutputTransformInput(
        sdkOutput=aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ScanOutput(
            native_input.sdk_output
        ),
        originalInput=aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ScanInput(
            native_input.original_input
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_transforms_QueryInputTransformInput(
    native_input,
):
    return DafnyQueryInputTransformInput(
        sdkInput=aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_QueryInput(
            native_input.sdk_input
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_transforms_QueryOutputTransformInput(
    native_input,
):
    return DafnyQueryOutputTransformInput(
        sdkOutput=aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_QueryOutput(
            native_input.sdk_output
        ),
        originalInput=aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_QueryInput(
            native_input.original_input
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_transforms_TransactWriteItemsInputTransformInput(
    native_input,
):
    return DafnyTransactWriteItemsInputTransformInput(
        sdkInput=aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_TransactWriteItemsInput(
            native_input.sdk_input
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_transforms_TransactWriteItemsOutputTransformInput(
    native_input,
):
    return DafnyTransactWriteItemsOutputTransformInput(
        sdkOutput=aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_TransactWriteItemsOutput(
            native_input.sdk_output
        ),
        originalInput=aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_TransactWriteItemsInput(
            native_input.original_input
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_transforms_UpdateItemInputTransformInput(
    native_input,
):
    return DafnyUpdateItemInputTransformInput(
        sdkInput=aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_UpdateItemInput(
            native_input.sdk_input
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_transforms_UpdateItemOutputTransformInput(
    native_input,
):
    return DafnyUpdateItemOutputTransformInput(
        sdkOutput=aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_UpdateItemOutput(
            native_input.sdk_output
        ),
        originalInput=aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_UpdateItemInput(
            native_input.original_input
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_transforms_DeleteItemInputTransformInput(
    native_input,
):
    return DafnyDeleteItemInputTransformInput(
        sdkInput=aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_DeleteItemInput(
            native_input.sdk_input
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_transforms_DeleteItemOutputTransformInput(
    native_input,
):
    return DafnyDeleteItemOutputTransformInput(
        sdkOutput=aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_DeleteItemOutput(
            native_input.sdk_output
        ),
        originalInput=aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_DeleteItemInput(
            native_input.original_input
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_transforms_TransactGetItemsInputTransformInput(
    native_input,
):
    return DafnyTransactGetItemsInputTransformInput(
        sdkInput=aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_TransactGetItemsInput(
            native_input.sdk_input
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_transforms_TransactGetItemsOutputTransformInput(
    native_input,
):
    return DafnyTransactGetItemsOutputTransformInput(
        sdkOutput=aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_TransactGetItemsOutput(
            native_input.sdk_output
        ),
        originalInput=aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_TransactGetItemsInput(
            native_input.original_input
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_transforms_ExecuteStatementInputTransformInput(
    native_input,
):
    return DafnyExecuteStatementInputTransformInput(
        sdkInput=aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ExecuteStatementInput(
            native_input.sdk_input
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_transforms_ExecuteStatementOutputTransformInput(
    native_input,
):
    return DafnyExecuteStatementOutputTransformInput(
        sdkOutput=aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ExecuteStatementOutput(
            native_input.sdk_output
        ),
        originalInput=aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ExecuteStatementInput(
            native_input.original_input
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_transforms_BatchExecuteStatementInputTransformInput(
    native_input,
):
    return DafnyBatchExecuteStatementInputTransformInput(
        sdkInput=aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_BatchExecuteStatementInput(
            native_input.sdk_input
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_transforms_BatchExecuteStatementOutputTransformInput(
    native_input,
):
    return DafnyBatchExecuteStatementOutputTransformInput(
        sdkOutput=aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_BatchExecuteStatementOutput(
            native_input.sdk_output
        ),
        originalInput=aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_BatchExecuteStatementInput(
            native_input.original_input
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_transforms_ExecuteTransactionInputTransformInput(
    native_input,
):
    return DafnyExecuteTransactionInputTransformInput(
        sdkInput=aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ExecuteTransactionInput(
            native_input.sdk_input
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_transforms_ExecuteTransactionOutputTransformInput(
    native_input,
):
    return DafnyExecuteTransactionOutputTransformInput(
        sdkOutput=aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ExecuteTransactionOutput(
            native_input.sdk_output
        ),
        originalInput=aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ExecuteTransactionInput(
            native_input.original_input
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_transforms_ResolveAttributesInput(
    native_input,
):
    return DafnyResolveAttributesInput(
        TableName=Seq(
            "".join(
                [
                    chr(int.from_bytes(pair, "big"))
                    for pair in zip(*[iter(native_input.table_name.encode("utf-16-be"))] * 2)
                ]
            )
        ),
        Item=Map(
            {
                Seq(
                    "".join([chr(int.from_bytes(pair, "big")) for pair in zip(*[iter(key.encode("utf-16-be"))] * 2)])
                ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_AttributeValue(
                    value
                )
                for (key, value) in native_input.item.items()
            }
        ),
        Version=((Option_Some(native_input.version)) if (native_input.version is not None) else (Option_None())),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_transforms_PutItemInputTransformOutput(
    native_input,
):
    return DafnyPutItemInputTransformOutput(
        transformedInput=aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_PutItemInput(
            native_input.transformed_input
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_transforms_PutItemOutputTransformOutput(
    native_input,
):
    return DafnyPutItemOutputTransformOutput(
        transformedOutput=aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_PutItemOutput(
            native_input.transformed_output
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_transforms_GetItemInputTransformOutput(
    native_input,
):
    return DafnyGetItemInputTransformOutput(
        transformedInput=aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_GetItemInput(
            native_input.transformed_input
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_transforms_GetItemOutputTransformOutput(
    native_input,
):
    return DafnyGetItemOutputTransformOutput(
        transformedOutput=aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_GetItemOutput(
            native_input.transformed_output
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_transforms_BatchWriteItemInputTransformOutput(
    native_input,
):
    return DafnyBatchWriteItemInputTransformOutput(
        transformedInput=aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_BatchWriteItemInput(
            native_input.transformed_input
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_transforms_BatchWriteItemOutputTransformOutput(
    native_input,
):
    return DafnyBatchWriteItemOutputTransformOutput(
        transformedOutput=aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_BatchWriteItemOutput(
            native_input.transformed_output
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_transforms_BatchGetItemInputTransformOutput(
    native_input,
):
    return DafnyBatchGetItemInputTransformOutput(
        transformedInput=aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_BatchGetItemInput(
            native_input.transformed_input
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_transforms_BatchGetItemOutputTransformOutput(
    native_input,
):
    return DafnyBatchGetItemOutputTransformOutput(
        transformedOutput=aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_BatchGetItemOutput(
            native_input.transformed_output
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_transforms_ScanInputTransformOutput(
    native_input,
):
    return DafnyScanInputTransformOutput(
        transformedInput=aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ScanInput(
            native_input.transformed_input
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_transforms_ScanOutputTransformOutput(
    native_input,
):
    return DafnyScanOutputTransformOutput(
        transformedOutput=aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ScanOutput(
            native_input.transformed_output
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_transforms_QueryInputTransformOutput(
    native_input,
):
    return DafnyQueryInputTransformOutput(
        transformedInput=aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_QueryInput(
            native_input.transformed_input
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_transforms_QueryOutputTransformOutput(
    native_input,
):
    return DafnyQueryOutputTransformOutput(
        transformedOutput=aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_QueryOutput(
            native_input.transformed_output
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_transforms_TransactWriteItemsInputTransformOutput(
    native_input,
):
    return DafnyTransactWriteItemsInputTransformOutput(
        transformedInput=aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_TransactWriteItemsInput(
            native_input.transformed_input
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_transforms_TransactWriteItemsOutputTransformOutput(
    native_input,
):
    return DafnyTransactWriteItemsOutputTransformOutput(
        transformedOutput=aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_TransactWriteItemsOutput(
            native_input.transformed_output
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_transforms_UpdateItemInputTransformOutput(
    native_input,
):
    return DafnyUpdateItemInputTransformOutput(
        transformedInput=aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_UpdateItemInput(
            native_input.transformed_input
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_transforms_UpdateItemOutputTransformOutput(
    native_input,
):
    return DafnyUpdateItemOutputTransformOutput(
        transformedOutput=aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_UpdateItemOutput(
            native_input.transformed_output
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_transforms_DeleteItemInputTransformOutput(
    native_input,
):
    return DafnyDeleteItemInputTransformOutput(
        transformedInput=aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_DeleteItemInput(
            native_input.transformed_input
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_transforms_DeleteItemOutputTransformOutput(
    native_input,
):
    return DafnyDeleteItemOutputTransformOutput(
        transformedOutput=aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_DeleteItemOutput(
            native_input.transformed_output
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_transforms_TransactGetItemsInputTransformOutput(
    native_input,
):
    return DafnyTransactGetItemsInputTransformOutput(
        transformedInput=aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_TransactGetItemsInput(
            native_input.transformed_input
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_transforms_TransactGetItemsOutputTransformOutput(
    native_input,
):
    return DafnyTransactGetItemsOutputTransformOutput(
        transformedOutput=aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_TransactGetItemsOutput(
            native_input.transformed_output
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_transforms_ExecuteStatementInputTransformOutput(
    native_input,
):
    return DafnyExecuteStatementInputTransformOutput(
        transformedInput=aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ExecuteStatementInput(
            native_input.transformed_input
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_transforms_ExecuteStatementOutputTransformOutput(
    native_input,
):
    return DafnyExecuteStatementOutputTransformOutput(
        transformedOutput=aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ExecuteStatementOutput(
            native_input.transformed_output
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_transforms_BatchExecuteStatementInputTransformOutput(
    native_input,
):
    return DafnyBatchExecuteStatementInputTransformOutput(
        transformedInput=aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_BatchExecuteStatementInput(
            native_input.transformed_input
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_transforms_BatchExecuteStatementOutputTransformOutput(
    native_input,
):
    return DafnyBatchExecuteStatementOutputTransformOutput(
        transformedOutput=aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_BatchExecuteStatementOutput(
            native_input.transformed_output
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_transforms_ExecuteTransactionInputTransformOutput(
    native_input,
):
    return DafnyExecuteTransactionInputTransformOutput(
        transformedInput=aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ExecuteTransactionInput(
            native_input.transformed_input
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_transforms_ExecuteTransactionOutputTransformOutput(
    native_input,
):
    return DafnyExecuteTransactionOutputTransformOutput(
        transformedOutput=aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ExecuteTransactionOutput(
            native_input.transformed_output
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_transforms_ResolveAttributesOutput(
    native_input,
):
    return DafnyResolveAttributesOutput(
        VirtualFields=Map(
            {
                Seq(
                    "".join([chr(int.from_bytes(pair, "big")) for pair in zip(*[iter(key.encode("utf-16-be"))] * 2)])
                ): Seq(
                    "".join([chr(int.from_bytes(pair, "big")) for pair in zip(*[iter(value.encode("utf-16-be"))] * 2)])
                )
                for (key, value) in native_input.virtual_fields.items()
            }
        ),
        CompoundBeacons=Map(
            {
                Seq(
                    "".join([chr(int.from_bytes(pair, "big")) for pair in zip(*[iter(key.encode("utf-16-be"))] * 2)])
                ): Seq(
                    "".join([chr(int.from_bytes(pair, "big")) for pair in zip(*[iter(value.encode("utf-16-be"))] * 2)])
                )
                for (key, value) in native_input.compound_beacons.items()
            }
        ),
    )


def aws_cryptography_dbencryptionsdk_dynamodb_transforms_AwsCryptographicMaterialProvidersReference(
    native_input,
):
    return native_input._config.dafnyImplInterface.impl


def aws_cryptography_dbencryptionsdk_dynamodb_transforms_DynamoDbEncryptionReference(
    native_input,
):
    return native_input._config.dafnyImplInterface.impl


def aws_cryptography_dbencryptionsdk_dynamodb_transforms_DynamoDbItemEncryptorReference(
    native_input,
):
    return native_input._config.dafnyImplInterface.impl


def aws_cryptography_dbencryptionsdk_dynamodb_transforms_StructuredEncryptionReference(
    native_input,
):
    return native_input._config.dafnyImplInterface.impl
