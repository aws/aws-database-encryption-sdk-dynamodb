# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
# Do not modify this file. This file is machine generated, and any changes to it will be overwritten.

from aws_dbesdk_dynamodb.internaldafny.generated.AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes import (
    BatchExecuteStatementInputTransformInput_BatchExecuteStatementInputTransformInput as DafnyBatchExecuteStatementInputTransformInput,
    BatchExecuteStatementOutputTransformInput_BatchExecuteStatementOutputTransformInput as DafnyBatchExecuteStatementOutputTransformInput,
    BatchGetItemInputTransformInput_BatchGetItemInputTransformInput as DafnyBatchGetItemInputTransformInput,
    BatchGetItemOutputTransformInput_BatchGetItemOutputTransformInput as DafnyBatchGetItemOutputTransformInput,
    BatchWriteItemInputTransformInput_BatchWriteItemInputTransformInput as DafnyBatchWriteItemInputTransformInput,
    BatchWriteItemOutputTransformInput_BatchWriteItemOutputTransformInput as DafnyBatchWriteItemOutputTransformInput,
    DeleteItemInputTransformInput_DeleteItemInputTransformInput as DafnyDeleteItemInputTransformInput,
    DeleteItemOutputTransformInput_DeleteItemOutputTransformInput as DafnyDeleteItemOutputTransformInput,
    ExecuteStatementInputTransformInput_ExecuteStatementInputTransformInput as DafnyExecuteStatementInputTransformInput,
    ExecuteStatementOutputTransformInput_ExecuteStatementOutputTransformInput as DafnyExecuteStatementOutputTransformInput,
    ExecuteTransactionInputTransformInput_ExecuteTransactionInputTransformInput as DafnyExecuteTransactionInputTransformInput,
    ExecuteTransactionOutputTransformInput_ExecuteTransactionOutputTransformInput as DafnyExecuteTransactionOutputTransformInput,
    GetItemInputTransformInput_GetItemInputTransformInput as DafnyGetItemInputTransformInput,
    GetItemOutputTransformInput_GetItemOutputTransformInput as DafnyGetItemOutputTransformInput,
    PutItemInputTransformInput_PutItemInputTransformInput as DafnyPutItemInputTransformInput,
    PutItemOutputTransformInput_PutItemOutputTransformInput as DafnyPutItemOutputTransformInput,
    QueryInputTransformInput_QueryInputTransformInput as DafnyQueryInputTransformInput,
    QueryOutputTransformInput_QueryOutputTransformInput as DafnyQueryOutputTransformInput,
    ResolveAttributesInput_ResolveAttributesInput as DafnyResolveAttributesInput,
    ScanInputTransformInput_ScanInputTransformInput as DafnyScanInputTransformInput,
    ScanOutputTransformInput_ScanOutputTransformInput as DafnyScanOutputTransformInput,
    TransactGetItemsInputTransformInput_TransactGetItemsInputTransformInput as DafnyTransactGetItemsInputTransformInput,
    TransactGetItemsOutputTransformInput_TransactGetItemsOutputTransformInput as DafnyTransactGetItemsOutputTransformInput,
    TransactWriteItemsInputTransformInput_TransactWriteItemsInputTransformInput as DafnyTransactWriteItemsInputTransformInput,
    TransactWriteItemsOutputTransformInput_TransactWriteItemsOutputTransformInput as DafnyTransactWriteItemsOutputTransformInput,
    UpdateItemInputTransformInput_UpdateItemInputTransformInput as DafnyUpdateItemInputTransformInput,
    UpdateItemOutputTransformInput_UpdateItemOutputTransformInput as DafnyUpdateItemOutputTransformInput,
)
import aws_dbesdk_dynamodb.internaldafny.generated.module_


import smithy_dafny_standard_library.internaldafny.generated.Wrappers as Wrappers
from typing import Union


class DafnyRequest:
    operation_name: str

    # dafny_operation_input can take on any one of the types
    # of the input values passed to the Dafny implementation
    dafny_operation_input: Union[
        DafnyTransactWriteItemsInputTransformInput,
        DafnyExecuteTransactionInputTransformInput,
        DafnyBatchExecuteStatementOutputTransformInput,
        DafnyQueryOutputTransformInput,
        DafnyExecuteStatementOutputTransformInput,
        DafnyDeleteItemInputTransformInput,
        DafnyBatchGetItemOutputTransformInput,
        DafnyQueryInputTransformInput,
        DafnyTransactWriteItemsOutputTransformInput,
        DafnyPutItemOutputTransformInput,
        DafnyBatchWriteItemOutputTransformInput,
        DafnyUpdateItemOutputTransformInput,
        DafnyUpdateItemInputTransformInput,
        DafnyExecuteStatementInputTransformInput,
        DafnyBatchGetItemInputTransformInput,
        DafnyTransactGetItemsOutputTransformInput,
        DafnyGetItemInputTransformInput,
        DafnyBatchExecuteStatementInputTransformInput,
        DafnyBatchWriteItemInputTransformInput,
        DafnyDeleteItemOutputTransformInput,
        DafnyExecuteTransactionOutputTransformInput,
        DafnyResolveAttributesInput,
        DafnyTransactGetItemsInputTransformInput,
        DafnyScanInputTransformInput,
        DafnyPutItemInputTransformInput,
        DafnyGetItemOutputTransformInput,
        DafnyScanOutputTransformInput,
    ]

    def __init__(self, operation_name, dafny_operation_input):
        self.operation_name = operation_name
        self.dafny_operation_input = dafny_operation_input


class DafnyResponse(Wrappers.Result):
    def __init__(self):
        super().__init__(self)
