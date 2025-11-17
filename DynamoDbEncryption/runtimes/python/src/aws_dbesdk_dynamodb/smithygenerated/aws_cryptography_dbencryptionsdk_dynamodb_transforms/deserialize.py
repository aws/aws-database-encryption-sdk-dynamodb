# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
# Do not modify this file. This file is machine generated, and any changes to it will be overwritten.

import _dafny
from aws_dbesdk_dynamodb.internaldafny.generated.AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes import (
    BatchExecuteStatementInputTransformOutput_BatchExecuteStatementInputTransformOutput as DafnyBatchExecuteStatementInputTransformOutput,
    BatchExecuteStatementOutputTransformOutput_BatchExecuteStatementOutputTransformOutput as DafnyBatchExecuteStatementOutputTransformOutput,
    BatchGetItemInputTransformOutput_BatchGetItemInputTransformOutput as DafnyBatchGetItemInputTransformOutput,
    BatchGetItemOutputTransformOutput_BatchGetItemOutputTransformOutput as DafnyBatchGetItemOutputTransformOutput,
    BatchWriteItemInputTransformOutput_BatchWriteItemInputTransformOutput as DafnyBatchWriteItemInputTransformOutput,
    BatchWriteItemOutputTransformOutput_BatchWriteItemOutputTransformOutput as DafnyBatchWriteItemOutputTransformOutput,
    DeleteItemInputTransformOutput_DeleteItemInputTransformOutput as DafnyDeleteItemInputTransformOutput,
    DeleteItemOutputTransformOutput_DeleteItemOutputTransformOutput as DafnyDeleteItemOutputTransformOutput,
    Error,
    Error_DynamoDbEncryptionTransformsException,
    ExecuteStatementInputTransformOutput_ExecuteStatementInputTransformOutput as DafnyExecuteStatementInputTransformOutput,
    ExecuteStatementOutputTransformOutput_ExecuteStatementOutputTransformOutput as DafnyExecuteStatementOutputTransformOutput,
    ExecuteTransactionInputTransformOutput_ExecuteTransactionInputTransformOutput as DafnyExecuteTransactionInputTransformOutput,
    ExecuteTransactionOutputTransformOutput_ExecuteTransactionOutputTransformOutput as DafnyExecuteTransactionOutputTransformOutput,
    GetItemInputTransformOutput_GetItemInputTransformOutput as DafnyGetItemInputTransformOutput,
    GetItemOutputTransformOutput_GetItemOutputTransformOutput as DafnyGetItemOutputTransformOutput,
    PutItemInputTransformOutput_PutItemInputTransformOutput as DafnyPutItemInputTransformOutput,
    PutItemOutputTransformOutput_PutItemOutputTransformOutput as DafnyPutItemOutputTransformOutput,
    QueryInputTransformOutput_QueryInputTransformOutput as DafnyQueryInputTransformOutput,
    QueryOutputTransformOutput_QueryOutputTransformOutput as DafnyQueryOutputTransformOutput,
    ResolveAttributesOutput_ResolveAttributesOutput as DafnyResolveAttributesOutput,
    ScanInputTransformOutput_ScanInputTransformOutput as DafnyScanInputTransformOutput,
    ScanOutputTransformOutput_ScanOutputTransformOutput as DafnyScanOutputTransformOutput,
    TransactGetItemsInputTransformOutput_TransactGetItemsInputTransformOutput as DafnyTransactGetItemsInputTransformOutput,
    TransactGetItemsOutputTransformOutput_TransactGetItemsOutputTransformOutput as DafnyTransactGetItemsOutputTransformOutput,
    TransactWriteItemsInputTransformOutput_TransactWriteItemsInputTransformOutput as DafnyTransactWriteItemsInputTransformOutput,
    TransactWriteItemsOutputTransformOutput_TransactWriteItemsOutputTransformOutput as DafnyTransactWriteItemsOutputTransformOutput,
    UpdateItemInputTransformOutput_UpdateItemInputTransformOutput as DafnyUpdateItemInputTransformOutput,
    UpdateItemOutputTransformOutput_UpdateItemOutputTransformOutput as DafnyUpdateItemOutputTransformOutput,
)
import aws_dbesdk_dynamodb.internaldafny.generated.module_
import aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.dafny_to_smithy
from typing import Any

from .dafny_protocol import DafnyResponse
from .errors import (
    AwsCryptographicMaterialProviders,
    CollectionOfErrors,
    ComAmazonawsDynamodb,
    DynamoDbEncryption,
    DynamoDbEncryptionTransformsException,
    DynamoDbItemEncryptor,
    OpaqueError,
    OpaqueWithTextError,
    ServiceError,
    StructuredEncryption,
)
from aws_cryptographic_material_providers.smithygenerated.aws_cryptography_materialproviders.deserialize import (
    _deserialize_error as aws_cryptography_materialproviders_deserialize_error,
)
from aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.shim import (
    _sdk_error_to_dafny_error as com_amazonaws_dynamodb_sdk_error_to_dafny_error,
)

from ..aws_cryptography_dbencryptionsdk_dynamodb.deserialize import (
    _deserialize_error as aws_cryptography_dbencryptionsdk_dynamodb_deserialize_error,
)
from ..aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor.deserialize import (
    _deserialize_error as aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor_deserialize_error,
)
from ..aws_cryptography_dbencryptionsdk_structuredencryption.deserialize import (
    _deserialize_error as aws_cryptography_dbencryptionsdk_structuredencryption_deserialize_error,
)
from .config import Config


def _deserialize_put_item_input_transform(input: DafnyResponse, config: Config):

    if input.IsFailure():
        return _deserialize_error(input.error)
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_transforms_PutItemInputTransformOutput(
        input.value
    )


def _deserialize_put_item_output_transform(input: DafnyResponse, config: Config):

    if input.IsFailure():
        return _deserialize_error(input.error)
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_transforms_PutItemOutputTransformOutput(
        input.value
    )


def _deserialize_get_item_input_transform(input: DafnyResponse, config: Config):

    if input.IsFailure():
        return _deserialize_error(input.error)
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_transforms_GetItemInputTransformOutput(
        input.value
    )


def _deserialize_get_item_output_transform(input: DafnyResponse, config: Config):

    if input.IsFailure():
        return _deserialize_error(input.error)
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_transforms_GetItemOutputTransformOutput(
        input.value
    )


def _deserialize_batch_write_item_input_transform(input: DafnyResponse, config: Config):

    if input.IsFailure():
        return _deserialize_error(input.error)
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_transforms_BatchWriteItemInputTransformOutput(
        input.value
    )


def _deserialize_batch_write_item_output_transform(input: DafnyResponse, config: Config):

    if input.IsFailure():
        return _deserialize_error(input.error)
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_transforms_BatchWriteItemOutputTransformOutput(
        input.value
    )


def _deserialize_batch_get_item_input_transform(input: DafnyResponse, config: Config):

    if input.IsFailure():
        return _deserialize_error(input.error)
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_transforms_BatchGetItemInputTransformOutput(
        input.value
    )


def _deserialize_batch_get_item_output_transform(input: DafnyResponse, config: Config):

    if input.IsFailure():
        return _deserialize_error(input.error)
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_transforms_BatchGetItemOutputTransformOutput(
        input.value
    )


def _deserialize_scan_input_transform(input: DafnyResponse, config: Config):

    if input.IsFailure():
        return _deserialize_error(input.error)
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_transforms_ScanInputTransformOutput(
        input.value
    )


def _deserialize_scan_output_transform(input: DafnyResponse, config: Config):

    if input.IsFailure():
        return _deserialize_error(input.error)
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_transforms_ScanOutputTransformOutput(
        input.value
    )


def _deserialize_query_input_transform(input: DafnyResponse, config: Config):

    if input.IsFailure():
        return _deserialize_error(input.error)
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_transforms_QueryInputTransformOutput(
        input.value
    )


def _deserialize_query_output_transform(input: DafnyResponse, config: Config):

    if input.IsFailure():
        return _deserialize_error(input.error)
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_transforms_QueryOutputTransformOutput(
        input.value
    )


def _deserialize_transact_write_items_input_transform(input: DafnyResponse, config: Config):

    if input.IsFailure():
        return _deserialize_error(input.error)
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_transforms_TransactWriteItemsInputTransformOutput(
        input.value
    )


def _deserialize_transact_write_items_output_transform(input: DafnyResponse, config: Config):

    if input.IsFailure():
        return _deserialize_error(input.error)
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_transforms_TransactWriteItemsOutputTransformOutput(
        input.value
    )


def _deserialize_update_item_input_transform(input: DafnyResponse, config: Config):

    if input.IsFailure():
        return _deserialize_error(input.error)
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_transforms_UpdateItemInputTransformOutput(
        input.value
    )


def _deserialize_update_item_output_transform(input: DafnyResponse, config: Config):

    if input.IsFailure():
        return _deserialize_error(input.error)
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_transforms_UpdateItemOutputTransformOutput(
        input.value
    )


def _deserialize_delete_item_input_transform(input: DafnyResponse, config: Config):

    if input.IsFailure():
        return _deserialize_error(input.error)
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_transforms_DeleteItemInputTransformOutput(
        input.value
    )


def _deserialize_delete_item_output_transform(input: DafnyResponse, config: Config):

    if input.IsFailure():
        return _deserialize_error(input.error)
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_transforms_DeleteItemOutputTransformOutput(
        input.value
    )


def _deserialize_transact_get_items_input_transform(input: DafnyResponse, config: Config):

    if input.IsFailure():
        return _deserialize_error(input.error)
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_transforms_TransactGetItemsInputTransformOutput(
        input.value
    )


def _deserialize_transact_get_items_output_transform(input: DafnyResponse, config: Config):

    if input.IsFailure():
        return _deserialize_error(input.error)
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_transforms_TransactGetItemsOutputTransformOutput(
        input.value
    )


def _deserialize_execute_statement_input_transform(input: DafnyResponse, config: Config):

    if input.IsFailure():
        return _deserialize_error(input.error)
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_transforms_ExecuteStatementInputTransformOutput(
        input.value
    )


def _deserialize_execute_statement_output_transform(input: DafnyResponse, config: Config):

    if input.IsFailure():
        return _deserialize_error(input.error)
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_transforms_ExecuteStatementOutputTransformOutput(
        input.value
    )


def _deserialize_batch_execute_statement_input_transform(input: DafnyResponse, config: Config):

    if input.IsFailure():
        return _deserialize_error(input.error)
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_transforms_BatchExecuteStatementInputTransformOutput(
        input.value
    )


def _deserialize_batch_execute_statement_output_transform(input: DafnyResponse, config: Config):

    if input.IsFailure():
        return _deserialize_error(input.error)
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_transforms_BatchExecuteStatementOutputTransformOutput(
        input.value
    )


def _deserialize_execute_transaction_input_transform(input: DafnyResponse, config: Config):

    if input.IsFailure():
        return _deserialize_error(input.error)
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_transforms_ExecuteTransactionInputTransformOutput(
        input.value
    )


def _deserialize_execute_transaction_output_transform(input: DafnyResponse, config: Config):

    if input.IsFailure():
        return _deserialize_error(input.error)
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_transforms_ExecuteTransactionOutputTransformOutput(
        input.value
    )


def _deserialize_resolve_attributes(input: DafnyResponse, config: Config):

    if input.IsFailure():
        return _deserialize_error(input.error)
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_transforms_ResolveAttributesOutput(
        input.value
    )


def _deserialize_error(error: Error) -> ServiceError:
    if error.is_Opaque:
        return OpaqueError(obj=error.obj)
    elif error.is_OpaqueWithText:
        return OpaqueWithTextError(obj=error.obj, obj_message=_dafny.string_of(error.objMessage))
    elif error.is_CollectionOfErrors:
        return CollectionOfErrors(
            message=_dafny.string_of(error.message),
            list=[_deserialize_error(dafny_e) for dafny_e in error.list],
        )
    elif error.is_DynamoDbEncryptionTransformsException:
        return DynamoDbEncryptionTransformsException(message=_dafny.string_of(error.message))
    elif error.is_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor:
        return DynamoDbItemEncryptor(
            aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor_deserialize_error(
                error.AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor
            )
        )
    elif error.is_AwsCryptographyDbEncryptionSdkStructuredEncryption:
        return StructuredEncryption(
            aws_cryptography_dbencryptionsdk_structuredencryption_deserialize_error(
                error.AwsCryptographyDbEncryptionSdkStructuredEncryption
            )
        )
    elif error.is_AwsCryptographyDbEncryptionSdkDynamoDb:
        return DynamoDbEncryption(
            aws_cryptography_dbencryptionsdk_dynamodb_deserialize_error(error.AwsCryptographyDbEncryptionSdkDynamoDb)
        )
    elif error.is_AwsCryptographyMaterialProviders:
        return AwsCryptographicMaterialProviders(
            aws_cryptography_materialproviders_deserialize_error(error.AwsCryptographyMaterialProviders)
        )
    elif error.is_ComAmazonawsDynamodb:
        if hasattr(error.ComAmazonawsDynamodb, "objMessage"):
            return ComAmazonawsDynamodb(message=_dafny.string_of(error.ComAmazonawsDynamodb.objMessage))
        elif hasattr(error.ComAmazonawsDynamodb, "Message"):
            return ComAmazonawsDynamodb(message=_dafny.string_of(error.ComAmazonawsDynamodb.Message))
        else:
            return ComAmazonawsDynamodb(message=_dafny.string_of(error.ComAmazonawsDynamodb.message))
    else:
        return OpaqueError(obj=error)
