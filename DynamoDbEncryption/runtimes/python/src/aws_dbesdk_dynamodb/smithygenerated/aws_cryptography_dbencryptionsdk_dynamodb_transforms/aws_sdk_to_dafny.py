# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
# Do not modify this file. This file is machine generated, and any changes to it will be overwritten.

from _dafny import Map, Seq
from aws_cryptography_internal_dynamodb.internaldafny.generated.ComAmazonawsDynamodbTypes import (
    AttributeAction_ADD,
    AttributeAction_DELETE,
    AttributeAction_PUT,
    AttributeValueUpdate_AttributeValueUpdate as DafnyAttributeValueUpdate,
    AttributeValue_B,
    AttributeValue_BOOL,
    AttributeValue_BS,
    AttributeValue_L,
    AttributeValue_M,
    AttributeValue_N,
    AttributeValue_NS,
    AttributeValue_NULL,
    AttributeValue_S,
    AttributeValue_SS,
    BatchExecuteStatementInput_BatchExecuteStatementInput as DafnyBatchExecuteStatementInput,
    BatchExecuteStatementOutput_BatchExecuteStatementOutput as DafnyBatchExecuteStatementOutput,
    BatchGetItemInput_BatchGetItemInput as DafnyBatchGetItemInput,
    BatchGetItemOutput_BatchGetItemOutput as DafnyBatchGetItemOutput,
    BatchStatementErrorCodeEnum_AccessDenied,
    BatchStatementErrorCodeEnum_ConditionalCheckFailed,
    BatchStatementErrorCodeEnum_DuplicateItem,
    BatchStatementErrorCodeEnum_InternalServerError,
    BatchStatementErrorCodeEnum_ItemCollectionSizeLimitExceeded,
    BatchStatementErrorCodeEnum_ProvisionedThroughputExceeded,
    BatchStatementErrorCodeEnum_RequestLimitExceeded,
    BatchStatementErrorCodeEnum_ResourceNotFound,
    BatchStatementErrorCodeEnum_ThrottlingError,
    BatchStatementErrorCodeEnum_TransactionConflict,
    BatchStatementErrorCodeEnum_ValidationError,
    BatchStatementError_BatchStatementError as DafnyBatchStatementError,
    BatchStatementRequest_BatchStatementRequest as DafnyBatchStatementRequest,
    BatchStatementResponse_BatchStatementResponse as DafnyBatchStatementResponse,
    BatchWriteItemInput_BatchWriteItemInput as DafnyBatchWriteItemInput,
    BatchWriteItemOutput_BatchWriteItemOutput as DafnyBatchWriteItemOutput,
    Capacity_Capacity as DafnyCapacity,
    ComparisonOperator_BEGINS__WITH,
    ComparisonOperator_BETWEEN,
    ComparisonOperator_CONTAINS,
    ComparisonOperator_EQ,
    ComparisonOperator_GE,
    ComparisonOperator_GT,
    ComparisonOperator_IN,
    ComparisonOperator_LE,
    ComparisonOperator_LT,
    ComparisonOperator_NE,
    ComparisonOperator_NOT__CONTAINS,
    ComparisonOperator_NOT__NULL,
    ComparisonOperator_NULL,
    ConditionCheck_ConditionCheck as DafnyConditionCheck,
    Condition_Condition as DafnyCondition,
    ConditionalOperator_AND,
    ConditionalOperator_OR,
    ConsumedCapacity_ConsumedCapacity as DafnyConsumedCapacity,
    DeleteItemInput_DeleteItemInput as DafnyDeleteItemInput,
    DeleteItemOutput_DeleteItemOutput as DafnyDeleteItemOutput,
    DeleteRequest_DeleteRequest as DafnyDeleteRequest,
    Delete_Delete as DafnyDelete,
    ExecuteStatementInput_ExecuteStatementInput as DafnyExecuteStatementInput,
    ExecuteStatementOutput_ExecuteStatementOutput as DafnyExecuteStatementOutput,
    ExecuteTransactionInput_ExecuteTransactionInput as DafnyExecuteTransactionInput,
    ExecuteTransactionOutput_ExecuteTransactionOutput as DafnyExecuteTransactionOutput,
    ExpectedAttributeValue_ExpectedAttributeValue as DafnyExpectedAttributeValue,
    GetItemInput_GetItemInput as DafnyGetItemInput,
    GetItemOutput_GetItemOutput as DafnyGetItemOutput,
    Get_Get as DafnyGet,
    ItemCollectionMetrics_ItemCollectionMetrics as DafnyItemCollectionMetrics,
    ItemResponse_ItemResponse as DafnyItemResponse,
    KeysAndAttributes_KeysAndAttributes as DafnyKeysAndAttributes,
    ParameterizedStatement_ParameterizedStatement as DafnyParameterizedStatement,
    PutItemInput_PutItemInput as DafnyPutItemInput,
    PutItemOutput_PutItemOutput as DafnyPutItemOutput,
    PutRequest_PutRequest as DafnyPutRequest,
    Put_Put as DafnyPut,
    QueryInput_QueryInput as DafnyQueryInput,
    QueryOutput_QueryOutput as DafnyQueryOutput,
    ReturnConsumedCapacity_INDEXES,
    ReturnConsumedCapacity_NONE,
    ReturnConsumedCapacity_TOTAL,
    ReturnItemCollectionMetrics_NONE,
    ReturnItemCollectionMetrics_SIZE,
    ReturnValue_ALL__NEW,
    ReturnValue_ALL__OLD,
    ReturnValue_NONE,
    ReturnValue_UPDATED__NEW,
    ReturnValue_UPDATED__OLD,
    ReturnValuesOnConditionCheckFailure_ALL__OLD,
    ReturnValuesOnConditionCheckFailure_NONE,
    ScanInput_ScanInput as DafnyScanInput,
    ScanOutput_ScanOutput as DafnyScanOutput,
    Select_ALL__ATTRIBUTES,
    Select_ALL__PROJECTED__ATTRIBUTES,
    Select_COUNT,
    Select_SPECIFIC__ATTRIBUTES,
    TransactGetItem_TransactGetItem as DafnyTransactGetItem,
    TransactGetItemsInput_TransactGetItemsInput as DafnyTransactGetItemsInput,
    TransactGetItemsOutput_TransactGetItemsOutput as DafnyTransactGetItemsOutput,
    TransactWriteItem_TransactWriteItem as DafnyTransactWriteItem,
    TransactWriteItemsInput_TransactWriteItemsInput as DafnyTransactWriteItemsInput,
    TransactWriteItemsOutput_TransactWriteItemsOutput as DafnyTransactWriteItemsOutput,
    UpdateItemInput_UpdateItemInput as DafnyUpdateItemInput,
    UpdateItemOutput_UpdateItemOutput as DafnyUpdateItemOutput,
    Update_Update as DafnyUpdate,
    WriteRequest_WriteRequest as DafnyWriteRequest,
)
import aws_cryptography_internal_dynamodb.internaldafny.generated.module_
import aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny
from smithy_dafny_standard_library.internaldafny.generated.Wrappers import (
    Option_None,
    Option_Some,
)


def com_amazonaws_dynamodb_PutItemInput(native_input):
    return DafnyPutItemInput(
        TableName=Seq(
            "".join(
                [
                    chr(int.from_bytes(pair, "big"))
                    for pair in zip(
                        *[iter(native_input["TableName"].encode("utf-16-be"))] * 2
                    )
                ]
            )
        ),
        Item=Map(
            {
                Seq(
                    "".join(
                        [
                            chr(int.from_bytes(pair, "big"))
                            for pair in zip(*[iter(key.encode("utf-16-be"))] * 2)
                        ]
                    )
                ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_AttributeValue(
                    value
                )
                for (key, value) in native_input["Item"].items()
            }
        ),
        Expected=(
            Option_Some(
                Map(
                    {
                        Seq(
                            "".join(
                                [
                                    chr(int.from_bytes(pair, "big"))
                                    for pair in zip(
                                        *[iter(key.encode("utf-16-be"))] * 2
                                    )
                                ]
                            )
                        ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ExpectedAttributeValue(
                            value
                        )
                        for (key, value) in native_input["Expected"].items()
                    }
                )
            )
            if "Expected" in native_input.keys()
            else Option_None()
        ),
        ReturnValues=(
            Option_Some(
                aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ReturnValue(
                    native_input["ReturnValues"]
                )
            )
            if "ReturnValues" in native_input.keys()
            else Option_None()
        ),
        ReturnConsumedCapacity=(
            Option_Some(
                aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ReturnConsumedCapacity(
                    native_input["ReturnConsumedCapacity"]
                )
            )
            if "ReturnConsumedCapacity" in native_input.keys()
            else Option_None()
        ),
        ReturnItemCollectionMetrics=(
            Option_Some(
                aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ReturnItemCollectionMetrics(
                    native_input["ReturnItemCollectionMetrics"]
                )
            )
            if "ReturnItemCollectionMetrics" in native_input.keys()
            else Option_None()
        ),
        ConditionalOperator=(
            Option_Some(
                aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ConditionalOperator(
                    native_input["ConditionalOperator"]
                )
            )
            if "ConditionalOperator" in native_input.keys()
            else Option_None()
        ),
        ConditionExpression=(
            Option_Some(
                Seq(
                    "".join(
                        [
                            chr(int.from_bytes(pair, "big"))
                            for pair in zip(
                                *[
                                    iter(
                                        native_input["ConditionExpression"].encode(
                                            "utf-16-be"
                                        )
                                    )
                                ]
                                * 2
                            )
                        ]
                    )
                )
            )
            if "ConditionExpression" in native_input.keys()
            else Option_None()
        ),
        ExpressionAttributeNames=(
            Option_Some(
                Map(
                    {
                        Seq(
                            "".join(
                                [
                                    chr(int.from_bytes(pair, "big"))
                                    for pair in zip(
                                        *[iter(key.encode("utf-16-be"))] * 2
                                    )
                                ]
                            )
                        ): Seq(
                            "".join(
                                [
                                    chr(int.from_bytes(pair, "big"))
                                    for pair in zip(
                                        *[iter(value.encode("utf-16-be"))] * 2
                                    )
                                ]
                            )
                        )
                        for (key, value) in native_input[
                            "ExpressionAttributeNames"
                        ].items()
                    }
                )
            )
            if "ExpressionAttributeNames" in native_input.keys()
            else Option_None()
        ),
        ExpressionAttributeValues=(
            Option_Some(
                Map(
                    {
                        Seq(
                            "".join(
                                [
                                    chr(int.from_bytes(pair, "big"))
                                    for pair in zip(
                                        *[iter(key.encode("utf-16-be"))] * 2
                                    )
                                ]
                            )
                        ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_AttributeValue(
                            value
                        )
                        for (key, value) in native_input[
                            "ExpressionAttributeValues"
                        ].items()
                    }
                )
            )
            if "ExpressionAttributeValues" in native_input.keys()
            else Option_None()
        ),
        ReturnValuesOnConditionCheckFailure=(
            Option_Some(
                aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ReturnValuesOnConditionCheckFailure(
                    native_input["ReturnValuesOnConditionCheckFailure"]
                )
            )
            if "ReturnValuesOnConditionCheckFailure" in native_input.keys()
            else Option_None()
        ),
    )


def com_amazonaws_dynamodb_AttributeValue(native_input):
    if "S" in native_input.keys():
        AttributeValue_union_value = AttributeValue_S(
            Seq(
                "".join(
                    [
                        chr(int.from_bytes(pair, "big"))
                        for pair in zip(
                            *[iter(native_input["S"].encode("utf-16-be"))] * 2
                        )
                    ]
                )
            )
        )
    elif "N" in native_input.keys():
        AttributeValue_union_value = AttributeValue_N(
            Seq(
                "".join(
                    [
                        chr(int.from_bytes(pair, "big"))
                        for pair in zip(
                            *[iter(native_input["N"].encode("utf-16-be"))] * 2
                        )
                    ]
                )
            )
        )
    elif "B" in native_input.keys():
        AttributeValue_union_value = AttributeValue_B(Seq(native_input["B"]))
    elif "SS" in native_input.keys():
        AttributeValue_union_value = AttributeValue_SS(
            Seq(
                [
                    Seq(
                        "".join(
                            [
                                chr(int.from_bytes(pair, "big"))
                                for pair in zip(
                                    *[iter(list_element.encode("utf-16-be"))] * 2
                                )
                            ]
                        )
                    )
                    for list_element in native_input["SS"]
                ]
            )
        )
    elif "NS" in native_input.keys():
        AttributeValue_union_value = AttributeValue_NS(
            Seq(
                [
                    Seq(
                        "".join(
                            [
                                chr(int.from_bytes(pair, "big"))
                                for pair in zip(
                                    *[iter(list_element.encode("utf-16-be"))] * 2
                                )
                            ]
                        )
                    )
                    for list_element in native_input["NS"]
                ]
            )
        )
    elif "BS" in native_input.keys():
        AttributeValue_union_value = AttributeValue_BS(
            Seq([Seq(list_element) for list_element in native_input["BS"]])
        )
    elif "M" in native_input.keys():
        AttributeValue_union_value = AttributeValue_M(
            Map(
                {
                    Seq(
                        "".join(
                            [
                                chr(int.from_bytes(pair, "big"))
                                for pair in zip(*[iter(key.encode("utf-16-be"))] * 2)
                            ]
                        )
                    ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_AttributeValue(
                        value
                    )
                    for (key, value) in native_input["M"].items()
                }
            )
        )
    elif "L" in native_input.keys():
        AttributeValue_union_value = AttributeValue_L(
            Seq(
                [
                    aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_AttributeValue(
                        list_element
                    )
                    for list_element in native_input["L"]
                ]
            )
        )
    elif "NULL" in native_input.keys():
        AttributeValue_union_value = AttributeValue_NULL(native_input["NULL"])
    elif "BOOL" in native_input.keys():
        AttributeValue_union_value = AttributeValue_BOOL(native_input["BOOL"])
    else:
        raise ValueError(
            "No recognized union value in union type: " + str(native_input)
        )

    return AttributeValue_union_value


def com_amazonaws_dynamodb_ExpectedAttributeValue(native_input):
    return DafnyExpectedAttributeValue(
        Value=(
            Option_Some(
                aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_AttributeValue(
                    native_input["Value"]
                )
            )
            if "Value" in native_input.keys()
            else Option_None()
        ),
        Exists=(
            Option_Some(native_input["Exists"])
            if "Exists" in native_input.keys()
            else Option_None()
        ),
        ComparisonOperator=(
            Option_Some(
                aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ComparisonOperator(
                    native_input["ComparisonOperator"]
                )
            )
            if "ComparisonOperator" in native_input.keys()
            else Option_None()
        ),
        AttributeValueList=(
            Option_Some(
                Seq(
                    [
                        aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_AttributeValue(
                            list_element
                        )
                        for list_element in native_input["AttributeValueList"]
                    ]
                )
            )
            if "AttributeValueList" in native_input.keys()
            else Option_None()
        ),
    )


def com_amazonaws_dynamodb_ComparisonOperator(native_input):
    # Convert ComparisonOperator
    if native_input == "EQ":
        return ComparisonOperator_EQ()
    elif native_input == "NE":
        return ComparisonOperator_NE()
    elif native_input == "IN":
        return ComparisonOperator_IN()
    elif native_input == "LE":
        return ComparisonOperator_LE()
    elif native_input == "LT":
        return ComparisonOperator_LT()
    elif native_input == "GE":
        return ComparisonOperator_GE()
    elif native_input == "GT":
        return ComparisonOperator_GT()
    elif native_input == "BETWEEN":
        return ComparisonOperator_BETWEEN()
    elif native_input == "NOT_NULL":
        return ComparisonOperator_NOT__NULL()
    elif native_input == "NULL":
        return ComparisonOperator_NULL()
    elif native_input == "CONTAINS":
        return ComparisonOperator_CONTAINS()
    elif native_input == "NOT_CONTAINS":
        return ComparisonOperator_NOT__CONTAINS()
    elif native_input == "BEGINS_WITH":
        return ComparisonOperator_BEGINS__WITH()
    else:
        raise ValueError("No recognized enum value in enum type: " + native_input)


def com_amazonaws_dynamodb_ReturnValue(native_input):
    # Convert ReturnValue
    if native_input == "NONE":
        return ReturnValue_NONE()
    elif native_input == "ALL_OLD":
        return ReturnValue_ALL__OLD()
    elif native_input == "UPDATED_OLD":
        return ReturnValue_UPDATED__OLD()
    elif native_input == "ALL_NEW":
        return ReturnValue_ALL__NEW()
    elif native_input == "UPDATED_NEW":
        return ReturnValue_UPDATED__NEW()
    else:
        raise ValueError("No recognized enum value in enum type: " + native_input)


def com_amazonaws_dynamodb_ReturnConsumedCapacity(native_input):
    # Convert ReturnConsumedCapacity
    if native_input == "INDEXES":
        return ReturnConsumedCapacity_INDEXES()
    elif native_input == "TOTAL":
        return ReturnConsumedCapacity_TOTAL()
    elif native_input == "NONE":
        return ReturnConsumedCapacity_NONE()
    else:
        raise ValueError("No recognized enum value in enum type: " + native_input)


def com_amazonaws_dynamodb_ReturnItemCollectionMetrics(native_input):
    # Convert ReturnItemCollectionMetrics
    if native_input == "SIZE":
        return ReturnItemCollectionMetrics_SIZE()
    elif native_input == "NONE":
        return ReturnItemCollectionMetrics_NONE()
    else:
        raise ValueError("No recognized enum value in enum type: " + native_input)


def com_amazonaws_dynamodb_ConditionalOperator(native_input):
    # Convert ConditionalOperator
    if native_input == "AND":
        return ConditionalOperator_AND()
    elif native_input == "OR":
        return ConditionalOperator_OR()
    else:
        raise ValueError("No recognized enum value in enum type: " + native_input)


def com_amazonaws_dynamodb_ReturnValuesOnConditionCheckFailure(native_input):
    # Convert ReturnValuesOnConditionCheckFailure
    if native_input == "ALL_OLD":
        return ReturnValuesOnConditionCheckFailure_ALL__OLD()
    elif native_input == "NONE":
        return ReturnValuesOnConditionCheckFailure_NONE()
    else:
        raise ValueError("No recognized enum value in enum type: " + native_input)


def com_amazonaws_dynamodb_PutItemOutput(native_input):
    return DafnyPutItemOutput(
        Attributes=(
            Option_Some(
                Map(
                    {
                        Seq(
                            "".join(
                                [
                                    chr(int.from_bytes(pair, "big"))
                                    for pair in zip(
                                        *[iter(key.encode("utf-16-be"))] * 2
                                    )
                                ]
                            )
                        ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_AttributeValue(
                            value
                        )
                        for (key, value) in native_input["Attributes"].items()
                    }
                )
            )
            if "Attributes" in native_input.keys()
            else Option_None()
        ),
        ConsumedCapacity=(
            Option_Some(
                aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ConsumedCapacity(
                    native_input["ConsumedCapacity"]
                )
            )
            if "ConsumedCapacity" in native_input.keys()
            else Option_None()
        ),
        ItemCollectionMetrics=(
            Option_Some(
                aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ItemCollectionMetrics(
                    native_input["ItemCollectionMetrics"]
                )
            )
            if "ItemCollectionMetrics" in native_input.keys()
            else Option_None()
        ),
    )


def com_amazonaws_dynamodb_ConsumedCapacity(native_input):
    return DafnyConsumedCapacity(
        TableName=(
            Option_Some(
                Seq(
                    "".join(
                        [
                            chr(int.from_bytes(pair, "big"))
                            for pair in zip(
                                *[iter(native_input["TableName"].encode("utf-16-be"))]
                                * 2
                            )
                        ]
                    )
                )
            )
            if "TableName" in native_input.keys()
            else Option_None()
        ),
        CapacityUnits=(
            Option_Some(native_input["CapacityUnits"])
            if "CapacityUnits" in native_input.keys()
            else Option_None()
        ),
        ReadCapacityUnits=(
            Option_Some(native_input["ReadCapacityUnits"])
            if "ReadCapacityUnits" in native_input.keys()
            else Option_None()
        ),
        WriteCapacityUnits=(
            Option_Some(native_input["WriteCapacityUnits"])
            if "WriteCapacityUnits" in native_input.keys()
            else Option_None()
        ),
        Table=(
            Option_Some(
                aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_Capacity(
                    native_input["Table"]
                )
            )
            if "Table" in native_input.keys()
            else Option_None()
        ),
        LocalSecondaryIndexes=(
            Option_Some(
                Map(
                    {
                        Seq(
                            "".join(
                                [
                                    chr(int.from_bytes(pair, "big"))
                                    for pair in zip(
                                        *[iter(key.encode("utf-16-be"))] * 2
                                    )
                                ]
                            )
                        ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_Capacity(
                            value
                        )
                        for (key, value) in native_input[
                            "LocalSecondaryIndexes"
                        ].items()
                    }
                )
            )
            if "LocalSecondaryIndexes" in native_input.keys()
            else Option_None()
        ),
        GlobalSecondaryIndexes=(
            Option_Some(
                Map(
                    {
                        Seq(
                            "".join(
                                [
                                    chr(int.from_bytes(pair, "big"))
                                    for pair in zip(
                                        *[iter(key.encode("utf-16-be"))] * 2
                                    )
                                ]
                            )
                        ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_Capacity(
                            value
                        )
                        for (key, value) in native_input[
                            "GlobalSecondaryIndexes"
                        ].items()
                    }
                )
            )
            if "GlobalSecondaryIndexes" in native_input.keys()
            else Option_None()
        ),
    )


def com_amazonaws_dynamodb_Capacity(native_input):
    return DafnyCapacity(
        ReadCapacityUnits=(
            Option_Some(native_input["ReadCapacityUnits"])
            if "ReadCapacityUnits" in native_input.keys()
            else Option_None()
        ),
        WriteCapacityUnits=(
            Option_Some(native_input["WriteCapacityUnits"])
            if "WriteCapacityUnits" in native_input.keys()
            else Option_None()
        ),
        CapacityUnits=(
            Option_Some(native_input["CapacityUnits"])
            if "CapacityUnits" in native_input.keys()
            else Option_None()
        ),
    )


def com_amazonaws_dynamodb_ItemCollectionMetrics(native_input):
    return DafnyItemCollectionMetrics(
        ItemCollectionKey=(
            Option_Some(
                Map(
                    {
                        Seq(
                            "".join(
                                [
                                    chr(int.from_bytes(pair, "big"))
                                    for pair in zip(
                                        *[iter(key.encode("utf-16-be"))] * 2
                                    )
                                ]
                            )
                        ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_AttributeValue(
                            value
                        )
                        for (key, value) in native_input["ItemCollectionKey"].items()
                    }
                )
            )
            if "ItemCollectionKey" in native_input.keys()
            else Option_None()
        ),
        SizeEstimateRangeGB=(
            Option_Some(
                Seq(
                    [
                        list_element
                        for list_element in native_input["SizeEstimateRangeGB"]
                    ]
                )
            )
            if "SizeEstimateRangeGB" in native_input.keys()
            else Option_None()
        ),
    )


def com_amazonaws_dynamodb_GetItemInput(native_input):
    return DafnyGetItemInput(
        TableName=Seq(
            "".join(
                [
                    chr(int.from_bytes(pair, "big"))
                    for pair in zip(
                        *[iter(native_input["TableName"].encode("utf-16-be"))] * 2
                    )
                ]
            )
        ),
        Key=Map(
            {
                Seq(
                    "".join(
                        [
                            chr(int.from_bytes(pair, "big"))
                            for pair in zip(*[iter(key.encode("utf-16-be"))] * 2)
                        ]
                    )
                ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_AttributeValue(
                    value
                )
                for (key, value) in native_input["Key"].items()
            }
        ),
        AttributesToGet=(
            Option_Some(
                Seq(
                    [
                        Seq(
                            "".join(
                                [
                                    chr(int.from_bytes(pair, "big"))
                                    for pair in zip(
                                        *[iter(list_element.encode("utf-16-be"))] * 2
                                    )
                                ]
                            )
                        )
                        for list_element in native_input["AttributesToGet"]
                    ]
                )
            )
            if "AttributesToGet" in native_input.keys()
            else Option_None()
        ),
        ConsistentRead=(
            Option_Some(native_input["ConsistentRead"])
            if "ConsistentRead" in native_input.keys()
            else Option_None()
        ),
        ReturnConsumedCapacity=(
            Option_Some(
                aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ReturnConsumedCapacity(
                    native_input["ReturnConsumedCapacity"]
                )
            )
            if "ReturnConsumedCapacity" in native_input.keys()
            else Option_None()
        ),
        ProjectionExpression=(
            Option_Some(
                Seq(
                    "".join(
                        [
                            chr(int.from_bytes(pair, "big"))
                            for pair in zip(
                                *[
                                    iter(
                                        native_input["ProjectionExpression"].encode(
                                            "utf-16-be"
                                        )
                                    )
                                ]
                                * 2
                            )
                        ]
                    )
                )
            )
            if "ProjectionExpression" in native_input.keys()
            else Option_None()
        ),
        ExpressionAttributeNames=(
            Option_Some(
                Map(
                    {
                        Seq(
                            "".join(
                                [
                                    chr(int.from_bytes(pair, "big"))
                                    for pair in zip(
                                        *[iter(key.encode("utf-16-be"))] * 2
                                    )
                                ]
                            )
                        ): Seq(
                            "".join(
                                [
                                    chr(int.from_bytes(pair, "big"))
                                    for pair in zip(
                                        *[iter(value.encode("utf-16-be"))] * 2
                                    )
                                ]
                            )
                        )
                        for (key, value) in native_input[
                            "ExpressionAttributeNames"
                        ].items()
                    }
                )
            )
            if "ExpressionAttributeNames" in native_input.keys()
            else Option_None()
        ),
    )


def com_amazonaws_dynamodb_GetItemOutput(native_input):
    return DafnyGetItemOutput(
        Item=(
            Option_Some(
                Map(
                    {
                        Seq(
                            "".join(
                                [
                                    chr(int.from_bytes(pair, "big"))
                                    for pair in zip(
                                        *[iter(key.encode("utf-16-be"))] * 2
                                    )
                                ]
                            )
                        ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_AttributeValue(
                            value
                        )
                        for (key, value) in native_input["Item"].items()
                    }
                )
            )
            if "Item" in native_input.keys()
            else Option_None()
        ),
        ConsumedCapacity=(
            Option_Some(
                aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ConsumedCapacity(
                    native_input["ConsumedCapacity"]
                )
            )
            if "ConsumedCapacity" in native_input.keys()
            else Option_None()
        ),
    )


def com_amazonaws_dynamodb_BatchWriteItemInput(native_input):
    return DafnyBatchWriteItemInput(
        RequestItems=Map(
            {
                Seq(
                    "".join(
                        [
                            chr(int.from_bytes(pair, "big"))
                            for pair in zip(*[iter(key.encode("utf-16-be"))] * 2)
                        ]
                    )
                ): Seq(
                    [
                        aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_WriteRequest(
                            list_element
                        )
                        for list_element in value
                    ]
                )
                for (key, value) in native_input["RequestItems"].items()
            }
        ),
        ReturnConsumedCapacity=(
            Option_Some(
                aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ReturnConsumedCapacity(
                    native_input["ReturnConsumedCapacity"]
                )
            )
            if "ReturnConsumedCapacity" in native_input.keys()
            else Option_None()
        ),
        ReturnItemCollectionMetrics=(
            Option_Some(
                aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ReturnItemCollectionMetrics(
                    native_input["ReturnItemCollectionMetrics"]
                )
            )
            if "ReturnItemCollectionMetrics" in native_input.keys()
            else Option_None()
        ),
    )


def com_amazonaws_dynamodb_WriteRequest(native_input):
    return DafnyWriteRequest(
        PutRequest=(
            Option_Some(
                aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_PutRequest(
                    native_input["PutRequest"]
                )
            )
            if "PutRequest" in native_input.keys()
            else Option_None()
        ),
        DeleteRequest=(
            Option_Some(
                aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_DeleteRequest(
                    native_input["DeleteRequest"]
                )
            )
            if "DeleteRequest" in native_input.keys()
            else Option_None()
        ),
    )


def com_amazonaws_dynamodb_PutRequest(native_input):
    return DafnyPutRequest(
        Item=Map(
            {
                Seq(
                    "".join(
                        [
                            chr(int.from_bytes(pair, "big"))
                            for pair in zip(*[iter(key.encode("utf-16-be"))] * 2)
                        ]
                    )
                ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_AttributeValue(
                    value
                )
                for (key, value) in native_input["Item"].items()
            }
        ),
    )


def com_amazonaws_dynamodb_DeleteRequest(native_input):
    return DafnyDeleteRequest(
        Key=Map(
            {
                Seq(
                    "".join(
                        [
                            chr(int.from_bytes(pair, "big"))
                            for pair in zip(*[iter(key.encode("utf-16-be"))] * 2)
                        ]
                    )
                ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_AttributeValue(
                    value
                )
                for (key, value) in native_input["Key"].items()
            }
        ),
    )


def com_amazonaws_dynamodb_BatchWriteItemOutput(native_input):
    return DafnyBatchWriteItemOutput(
        UnprocessedItems=(
            Option_Some(
                Map(
                    {
                        Seq(
                            "".join(
                                [
                                    chr(int.from_bytes(pair, "big"))
                                    for pair in zip(
                                        *[iter(key.encode("utf-16-be"))] * 2
                                    )
                                ]
                            )
                        ): Seq(
                            [
                                aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_WriteRequest(
                                    list_element
                                )
                                for list_element in value
                            ]
                        )
                        for (key, value) in native_input["UnprocessedItems"].items()
                    }
                )
            )
            if "UnprocessedItems" in native_input.keys()
            else Option_None()
        ),
        ItemCollectionMetrics=(
            Option_Some(
                Map(
                    {
                        Seq(
                            "".join(
                                [
                                    chr(int.from_bytes(pair, "big"))
                                    for pair in zip(
                                        *[iter(key.encode("utf-16-be"))] * 2
                                    )
                                ]
                            )
                        ): Seq(
                            [
                                aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ItemCollectionMetrics(
                                    list_element
                                )
                                for list_element in value
                            ]
                        )
                        for (key, value) in native_input[
                            "ItemCollectionMetrics"
                        ].items()
                    }
                )
            )
            if "ItemCollectionMetrics" in native_input.keys()
            else Option_None()
        ),
        ConsumedCapacity=(
            Option_Some(
                Seq(
                    [
                        aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ConsumedCapacity(
                            list_element
                        )
                        for list_element in native_input["ConsumedCapacity"]
                    ]
                )
            )
            if "ConsumedCapacity" in native_input.keys()
            else Option_None()
        ),
    )


def com_amazonaws_dynamodb_BatchGetItemInput(native_input):
    return DafnyBatchGetItemInput(
        RequestItems=Map(
            {
                Seq(
                    "".join(
                        [
                            chr(int.from_bytes(pair, "big"))
                            for pair in zip(*[iter(key.encode("utf-16-be"))] * 2)
                        ]
                    )
                ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_KeysAndAttributes(
                    value
                )
                for (key, value) in native_input["RequestItems"].items()
            }
        ),
        ReturnConsumedCapacity=(
            Option_Some(
                aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ReturnConsumedCapacity(
                    native_input["ReturnConsumedCapacity"]
                )
            )
            if "ReturnConsumedCapacity" in native_input.keys()
            else Option_None()
        ),
    )


def com_amazonaws_dynamodb_KeysAndAttributes(native_input):
    return DafnyKeysAndAttributes(
        Keys=Seq(
            [
                Map(
                    {
                        Seq(
                            "".join(
                                [
                                    chr(int.from_bytes(pair, "big"))
                                    for pair in zip(
                                        *[iter(key.encode("utf-16-be"))] * 2
                                    )
                                ]
                            )
                        ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_AttributeValue(
                            value
                        )
                        for (key, value) in list_element.items()
                    }
                )
                for list_element in native_input["Keys"]
            ]
        ),
        AttributesToGet=(
            Option_Some(
                Seq(
                    [
                        Seq(
                            "".join(
                                [
                                    chr(int.from_bytes(pair, "big"))
                                    for pair in zip(
                                        *[iter(list_element.encode("utf-16-be"))] * 2
                                    )
                                ]
                            )
                        )
                        for list_element in native_input["AttributesToGet"]
                    ]
                )
            )
            if "AttributesToGet" in native_input.keys()
            else Option_None()
        ),
        ConsistentRead=(
            Option_Some(native_input["ConsistentRead"])
            if "ConsistentRead" in native_input.keys()
            else Option_None()
        ),
        ProjectionExpression=(
            Option_Some(
                Seq(
                    "".join(
                        [
                            chr(int.from_bytes(pair, "big"))
                            for pair in zip(
                                *[
                                    iter(
                                        native_input["ProjectionExpression"].encode(
                                            "utf-16-be"
                                        )
                                    )
                                ]
                                * 2
                            )
                        ]
                    )
                )
            )
            if "ProjectionExpression" in native_input.keys()
            else Option_None()
        ),
        ExpressionAttributeNames=(
            Option_Some(
                Map(
                    {
                        Seq(
                            "".join(
                                [
                                    chr(int.from_bytes(pair, "big"))
                                    for pair in zip(
                                        *[iter(key.encode("utf-16-be"))] * 2
                                    )
                                ]
                            )
                        ): Seq(
                            "".join(
                                [
                                    chr(int.from_bytes(pair, "big"))
                                    for pair in zip(
                                        *[iter(value.encode("utf-16-be"))] * 2
                                    )
                                ]
                            )
                        )
                        for (key, value) in native_input[
                            "ExpressionAttributeNames"
                        ].items()
                    }
                )
            )
            if "ExpressionAttributeNames" in native_input.keys()
            else Option_None()
        ),
    )


def com_amazonaws_dynamodb_BatchGetItemOutput(native_input):
    return DafnyBatchGetItemOutput(
        Responses=(
            Option_Some(
                Map(
                    {
                        Seq(
                            "".join(
                                [
                                    chr(int.from_bytes(pair, "big"))
                                    for pair in zip(
                                        *[iter(key.encode("utf-16-be"))] * 2
                                    )
                                ]
                            )
                        ): Seq(
                            [
                                Map(
                                    {
                                        Seq(
                                            "".join(
                                                [
                                                    chr(int.from_bytes(pair, "big"))
                                                    for pair in zip(
                                                        *[iter(key.encode("utf-16-be"))]
                                                        * 2
                                                    )
                                                ]
                                            )
                                        ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_AttributeValue(
                                            value
                                        )
                                        for (key, value) in list_element.items()
                                    }
                                )
                                for list_element in value
                            ]
                        )
                        for (key, value) in native_input["Responses"].items()
                    }
                )
            )
            if "Responses" in native_input.keys()
            else Option_None()
        ),
        UnprocessedKeys=(
            Option_Some(
                Map(
                    {
                        Seq(
                            "".join(
                                [
                                    chr(int.from_bytes(pair, "big"))
                                    for pair in zip(
                                        *[iter(key.encode("utf-16-be"))] * 2
                                    )
                                ]
                            )
                        ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_KeysAndAttributes(
                            value
                        )
                        for (key, value) in native_input["UnprocessedKeys"].items()
                    }
                )
            )
            if "UnprocessedKeys" in native_input.keys()
            else Option_None()
        ),
        ConsumedCapacity=(
            Option_Some(
                Seq(
                    [
                        aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ConsumedCapacity(
                            list_element
                        )
                        for list_element in native_input["ConsumedCapacity"]
                    ]
                )
            )
            if "ConsumedCapacity" in native_input.keys()
            else Option_None()
        ),
    )


def com_amazonaws_dynamodb_ScanInput(native_input):
    return DafnyScanInput(
        TableName=Seq(
            "".join(
                [
                    chr(int.from_bytes(pair, "big"))
                    for pair in zip(
                        *[iter(native_input["TableName"].encode("utf-16-be"))] * 2
                    )
                ]
            )
        ),
        IndexName=(
            Option_Some(
                Seq(
                    "".join(
                        [
                            chr(int.from_bytes(pair, "big"))
                            for pair in zip(
                                *[iter(native_input["IndexName"].encode("utf-16-be"))]
                                * 2
                            )
                        ]
                    )
                )
            )
            if "IndexName" in native_input.keys()
            else Option_None()
        ),
        AttributesToGet=(
            Option_Some(
                Seq(
                    [
                        Seq(
                            "".join(
                                [
                                    chr(int.from_bytes(pair, "big"))
                                    for pair in zip(
                                        *[iter(list_element.encode("utf-16-be"))] * 2
                                    )
                                ]
                            )
                        )
                        for list_element in native_input["AttributesToGet"]
                    ]
                )
            )
            if "AttributesToGet" in native_input.keys()
            else Option_None()
        ),
        Limit=(
            Option_Some(native_input["Limit"])
            if "Limit" in native_input.keys()
            else Option_None()
        ),
        Select=(
            Option_Some(
                aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_Select(
                    native_input["Select"]
                )
            )
            if "Select" in native_input.keys()
            else Option_None()
        ),
        ScanFilter=(
            Option_Some(
                Map(
                    {
                        Seq(
                            "".join(
                                [
                                    chr(int.from_bytes(pair, "big"))
                                    for pair in zip(
                                        *[iter(key.encode("utf-16-be"))] * 2
                                    )
                                ]
                            )
                        ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_Condition(
                            value
                        )
                        for (key, value) in native_input["ScanFilter"].items()
                    }
                )
            )
            if "ScanFilter" in native_input.keys()
            else Option_None()
        ),
        ConditionalOperator=(
            Option_Some(
                aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ConditionalOperator(
                    native_input["ConditionalOperator"]
                )
            )
            if "ConditionalOperator" in native_input.keys()
            else Option_None()
        ),
        ExclusiveStartKey=(
            Option_Some(
                Map(
                    {
                        Seq(
                            "".join(
                                [
                                    chr(int.from_bytes(pair, "big"))
                                    for pair in zip(
                                        *[iter(key.encode("utf-16-be"))] * 2
                                    )
                                ]
                            )
                        ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_AttributeValue(
                            value
                        )
                        for (key, value) in native_input["ExclusiveStartKey"].items()
                    }
                )
            )
            if "ExclusiveStartKey" in native_input.keys()
            else Option_None()
        ),
        ReturnConsumedCapacity=(
            Option_Some(
                aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ReturnConsumedCapacity(
                    native_input["ReturnConsumedCapacity"]
                )
            )
            if "ReturnConsumedCapacity" in native_input.keys()
            else Option_None()
        ),
        TotalSegments=(
            Option_Some(native_input["TotalSegments"])
            if "TotalSegments" in native_input.keys()
            else Option_None()
        ),
        Segment=(
            Option_Some(native_input["Segment"])
            if "Segment" in native_input.keys()
            else Option_None()
        ),
        ProjectionExpression=(
            Option_Some(
                Seq(
                    "".join(
                        [
                            chr(int.from_bytes(pair, "big"))
                            for pair in zip(
                                *[
                                    iter(
                                        native_input["ProjectionExpression"].encode(
                                            "utf-16-be"
                                        )
                                    )
                                ]
                                * 2
                            )
                        ]
                    )
                )
            )
            if "ProjectionExpression" in native_input.keys()
            else Option_None()
        ),
        FilterExpression=(
            Option_Some(
                Seq(
                    "".join(
                        [
                            chr(int.from_bytes(pair, "big"))
                            for pair in zip(
                                *[
                                    iter(
                                        native_input["FilterExpression"].encode(
                                            "utf-16-be"
                                        )
                                    )
                                ]
                                * 2
                            )
                        ]
                    )
                )
            )
            if "FilterExpression" in native_input.keys()
            else Option_None()
        ),
        ExpressionAttributeNames=(
            Option_Some(
                Map(
                    {
                        Seq(
                            "".join(
                                [
                                    chr(int.from_bytes(pair, "big"))
                                    for pair in zip(
                                        *[iter(key.encode("utf-16-be"))] * 2
                                    )
                                ]
                            )
                        ): Seq(
                            "".join(
                                [
                                    chr(int.from_bytes(pair, "big"))
                                    for pair in zip(
                                        *[iter(value.encode("utf-16-be"))] * 2
                                    )
                                ]
                            )
                        )
                        for (key, value) in native_input[
                            "ExpressionAttributeNames"
                        ].items()
                    }
                )
            )
            if "ExpressionAttributeNames" in native_input.keys()
            else Option_None()
        ),
        ExpressionAttributeValues=(
            Option_Some(
                Map(
                    {
                        Seq(
                            "".join(
                                [
                                    chr(int.from_bytes(pair, "big"))
                                    for pair in zip(
                                        *[iter(key.encode("utf-16-be"))] * 2
                                    )
                                ]
                            )
                        ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_AttributeValue(
                            value
                        )
                        for (key, value) in native_input[
                            "ExpressionAttributeValues"
                        ].items()
                    }
                )
            )
            if "ExpressionAttributeValues" in native_input.keys()
            else Option_None()
        ),
        ConsistentRead=(
            Option_Some(native_input["ConsistentRead"])
            if "ConsistentRead" in native_input.keys()
            else Option_None()
        ),
    )


def com_amazonaws_dynamodb_Select(native_input):
    # Convert Select
    if native_input == "ALL_ATTRIBUTES":
        return Select_ALL__ATTRIBUTES()
    elif native_input == "ALL_PROJECTED_ATTRIBUTES":
        return Select_ALL__PROJECTED__ATTRIBUTES()
    elif native_input == "SPECIFIC_ATTRIBUTES":
        return Select_SPECIFIC__ATTRIBUTES()
    elif native_input == "COUNT":
        return Select_COUNT()
    else:
        raise ValueError("No recognized enum value in enum type: " + native_input)


def com_amazonaws_dynamodb_Condition(native_input):
    return DafnyCondition(
        AttributeValueList=(
            Option_Some(
                Seq(
                    [
                        aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_AttributeValue(
                            list_element
                        )
                        for list_element in native_input["AttributeValueList"]
                    ]
                )
            )
            if "AttributeValueList" in native_input.keys()
            else Option_None()
        ),
        ComparisonOperator=aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ComparisonOperator(
            native_input["ComparisonOperator"]
        ),
    )


def com_amazonaws_dynamodb_ScanOutput(native_input):
    return DafnyScanOutput(
        Items=(
            Option_Some(
                Seq(
                    [
                        Map(
                            {
                                Seq(
                                    "".join(
                                        [
                                            chr(int.from_bytes(pair, "big"))
                                            for pair in zip(
                                                *[iter(key.encode("utf-16-be"))] * 2
                                            )
                                        ]
                                    )
                                ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_AttributeValue(
                                    value
                                )
                                for (key, value) in list_element.items()
                            }
                        )
                        for list_element in native_input["Items"]
                    ]
                )
            )
            if "Items" in native_input.keys()
            else Option_None()
        ),
        Count=(
            Option_Some(native_input["Count"])
            if "Count" in native_input.keys()
            else Option_None()
        ),
        ScannedCount=(
            Option_Some(native_input["ScannedCount"])
            if "ScannedCount" in native_input.keys()
            else Option_None()
        ),
        LastEvaluatedKey=(
            Option_Some(
                Map(
                    {
                        Seq(
                            "".join(
                                [
                                    chr(int.from_bytes(pair, "big"))
                                    for pair in zip(
                                        *[iter(key.encode("utf-16-be"))] * 2
                                    )
                                ]
                            )
                        ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_AttributeValue(
                            value
                        )
                        for (key, value) in native_input["LastEvaluatedKey"].items()
                    }
                )
            )
            if "LastEvaluatedKey" in native_input.keys()
            else Option_None()
        ),
        ConsumedCapacity=(
            Option_Some(
                aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ConsumedCapacity(
                    native_input["ConsumedCapacity"]
                )
            )
            if "ConsumedCapacity" in native_input.keys()
            else Option_None()
        ),
    )


def com_amazonaws_dynamodb_QueryInput(native_input):
    return DafnyQueryInput(
        TableName=Seq(
            "".join(
                [
                    chr(int.from_bytes(pair, "big"))
                    for pair in zip(
                        *[iter(native_input["TableName"].encode("utf-16-be"))] * 2
                    )
                ]
            )
        ),
        IndexName=(
            Option_Some(
                Seq(
                    "".join(
                        [
                            chr(int.from_bytes(pair, "big"))
                            for pair in zip(
                                *[iter(native_input["IndexName"].encode("utf-16-be"))]
                                * 2
                            )
                        ]
                    )
                )
            )
            if "IndexName" in native_input.keys()
            else Option_None()
        ),
        Select=(
            Option_Some(
                aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_Select(
                    native_input["Select"]
                )
            )
            if "Select" in native_input.keys()
            else Option_None()
        ),
        AttributesToGet=(
            Option_Some(
                Seq(
                    [
                        Seq(
                            "".join(
                                [
                                    chr(int.from_bytes(pair, "big"))
                                    for pair in zip(
                                        *[iter(list_element.encode("utf-16-be"))] * 2
                                    )
                                ]
                            )
                        )
                        for list_element in native_input["AttributesToGet"]
                    ]
                )
            )
            if "AttributesToGet" in native_input.keys()
            else Option_None()
        ),
        Limit=(
            Option_Some(native_input["Limit"])
            if "Limit" in native_input.keys()
            else Option_None()
        ),
        ConsistentRead=(
            Option_Some(native_input["ConsistentRead"])
            if "ConsistentRead" in native_input.keys()
            else Option_None()
        ),
        KeyConditions=(
            Option_Some(
                Map(
                    {
                        Seq(
                            "".join(
                                [
                                    chr(int.from_bytes(pair, "big"))
                                    for pair in zip(
                                        *[iter(key.encode("utf-16-be"))] * 2
                                    )
                                ]
                            )
                        ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_Condition(
                            value
                        )
                        for (key, value) in native_input["KeyConditions"].items()
                    }
                )
            )
            if "KeyConditions" in native_input.keys()
            else Option_None()
        ),
        QueryFilter=(
            Option_Some(
                Map(
                    {
                        Seq(
                            "".join(
                                [
                                    chr(int.from_bytes(pair, "big"))
                                    for pair in zip(
                                        *[iter(key.encode("utf-16-be"))] * 2
                                    )
                                ]
                            )
                        ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_Condition(
                            value
                        )
                        for (key, value) in native_input["QueryFilter"].items()
                    }
                )
            )
            if "QueryFilter" in native_input.keys()
            else Option_None()
        ),
        ConditionalOperator=(
            Option_Some(
                aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ConditionalOperator(
                    native_input["ConditionalOperator"]
                )
            )
            if "ConditionalOperator" in native_input.keys()
            else Option_None()
        ),
        ScanIndexForward=(
            Option_Some(native_input["ScanIndexForward"])
            if "ScanIndexForward" in native_input.keys()
            else Option_None()
        ),
        ExclusiveStartKey=(
            Option_Some(
                Map(
                    {
                        Seq(
                            "".join(
                                [
                                    chr(int.from_bytes(pair, "big"))
                                    for pair in zip(
                                        *[iter(key.encode("utf-16-be"))] * 2
                                    )
                                ]
                            )
                        ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_AttributeValue(
                            value
                        )
                        for (key, value) in native_input["ExclusiveStartKey"].items()
                    }
                )
            )
            if "ExclusiveStartKey" in native_input.keys()
            else Option_None()
        ),
        ReturnConsumedCapacity=(
            Option_Some(
                aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ReturnConsumedCapacity(
                    native_input["ReturnConsumedCapacity"]
                )
            )
            if "ReturnConsumedCapacity" in native_input.keys()
            else Option_None()
        ),
        ProjectionExpression=(
            Option_Some(
                Seq(
                    "".join(
                        [
                            chr(int.from_bytes(pair, "big"))
                            for pair in zip(
                                *[
                                    iter(
                                        native_input["ProjectionExpression"].encode(
                                            "utf-16-be"
                                        )
                                    )
                                ]
                                * 2
                            )
                        ]
                    )
                )
            )
            if "ProjectionExpression" in native_input.keys()
            else Option_None()
        ),
        FilterExpression=(
            Option_Some(
                Seq(
                    "".join(
                        [
                            chr(int.from_bytes(pair, "big"))
                            for pair in zip(
                                *[
                                    iter(
                                        native_input["FilterExpression"].encode(
                                            "utf-16-be"
                                        )
                                    )
                                ]
                                * 2
                            )
                        ]
                    )
                )
            )
            if "FilterExpression" in native_input.keys()
            else Option_None()
        ),
        KeyConditionExpression=(
            Option_Some(
                Seq(
                    "".join(
                        [
                            chr(int.from_bytes(pair, "big"))
                            for pair in zip(
                                *[
                                    iter(
                                        native_input["KeyConditionExpression"].encode(
                                            "utf-16-be"
                                        )
                                    )
                                ]
                                * 2
                            )
                        ]
                    )
                )
            )
            if "KeyConditionExpression" in native_input.keys()
            else Option_None()
        ),
        ExpressionAttributeNames=(
            Option_Some(
                Map(
                    {
                        Seq(
                            "".join(
                                [
                                    chr(int.from_bytes(pair, "big"))
                                    for pair in zip(
                                        *[iter(key.encode("utf-16-be"))] * 2
                                    )
                                ]
                            )
                        ): Seq(
                            "".join(
                                [
                                    chr(int.from_bytes(pair, "big"))
                                    for pair in zip(
                                        *[iter(value.encode("utf-16-be"))] * 2
                                    )
                                ]
                            )
                        )
                        for (key, value) in native_input[
                            "ExpressionAttributeNames"
                        ].items()
                    }
                )
            )
            if "ExpressionAttributeNames" in native_input.keys()
            else Option_None()
        ),
        ExpressionAttributeValues=(
            Option_Some(
                Map(
                    {
                        Seq(
                            "".join(
                                [
                                    chr(int.from_bytes(pair, "big"))
                                    for pair in zip(
                                        *[iter(key.encode("utf-16-be"))] * 2
                                    )
                                ]
                            )
                        ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_AttributeValue(
                            value
                        )
                        for (key, value) in native_input[
                            "ExpressionAttributeValues"
                        ].items()
                    }
                )
            )
            if "ExpressionAttributeValues" in native_input.keys()
            else Option_None()
        ),
    )


def com_amazonaws_dynamodb_QueryOutput(native_input):
    return DafnyQueryOutput(
        Items=(
            Option_Some(
                Seq(
                    [
                        Map(
                            {
                                Seq(
                                    "".join(
                                        [
                                            chr(int.from_bytes(pair, "big"))
                                            for pair in zip(
                                                *[iter(key.encode("utf-16-be"))] * 2
                                            )
                                        ]
                                    )
                                ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_AttributeValue(
                                    value
                                )
                                for (key, value) in list_element.items()
                            }
                        )
                        for list_element in native_input["Items"]
                    ]
                )
            )
            if "Items" in native_input.keys()
            else Option_None()
        ),
        Count=(
            Option_Some(native_input["Count"])
            if "Count" in native_input.keys()
            else Option_None()
        ),
        ScannedCount=(
            Option_Some(native_input["ScannedCount"])
            if "ScannedCount" in native_input.keys()
            else Option_None()
        ),
        LastEvaluatedKey=(
            Option_Some(
                Map(
                    {
                        Seq(
                            "".join(
                                [
                                    chr(int.from_bytes(pair, "big"))
                                    for pair in zip(
                                        *[iter(key.encode("utf-16-be"))] * 2
                                    )
                                ]
                            )
                        ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_AttributeValue(
                            value
                        )
                        for (key, value) in native_input["LastEvaluatedKey"].items()
                    }
                )
            )
            if "LastEvaluatedKey" in native_input.keys()
            else Option_None()
        ),
        ConsumedCapacity=(
            Option_Some(
                aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ConsumedCapacity(
                    native_input["ConsumedCapacity"]
                )
            )
            if "ConsumedCapacity" in native_input.keys()
            else Option_None()
        ),
    )


def com_amazonaws_dynamodb_TransactWriteItemsInput(native_input):
    return DafnyTransactWriteItemsInput(
        TransactItems=Seq(
            [
                aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_TransactWriteItem(
                    list_element
                )
                for list_element in native_input["TransactItems"]
            ]
        ),
        ReturnConsumedCapacity=(
            Option_Some(
                aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ReturnConsumedCapacity(
                    native_input["ReturnConsumedCapacity"]
                )
            )
            if "ReturnConsumedCapacity" in native_input.keys()
            else Option_None()
        ),
        ReturnItemCollectionMetrics=(
            Option_Some(
                aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ReturnItemCollectionMetrics(
                    native_input["ReturnItemCollectionMetrics"]
                )
            )
            if "ReturnItemCollectionMetrics" in native_input.keys()
            else Option_None()
        ),
        ClientRequestToken=(
            Option_Some(
                Seq(
                    "".join(
                        [
                            chr(int.from_bytes(pair, "big"))
                            for pair in zip(
                                *[
                                    iter(
                                        native_input["ClientRequestToken"].encode(
                                            "utf-16-be"
                                        )
                                    )
                                ]
                                * 2
                            )
                        ]
                    )
                )
            )
            if "ClientRequestToken" in native_input.keys()
            else Option_None()
        ),
    )


def com_amazonaws_dynamodb_TransactWriteItem(native_input):
    return DafnyTransactWriteItem(
        ConditionCheck=(
            Option_Some(
                aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ConditionCheck(
                    native_input["ConditionCheck"]
                )
            )
            if "ConditionCheck" in native_input.keys()
            else Option_None()
        ),
        Put=(
            Option_Some(
                aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_Put(
                    native_input["Put"]
                )
            )
            if "Put" in native_input.keys()
            else Option_None()
        ),
        Delete=(
            Option_Some(
                aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_Delete(
                    native_input["Delete"]
                )
            )
            if "Delete" in native_input.keys()
            else Option_None()
        ),
        Update=(
            Option_Some(
                aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_Update(
                    native_input["Update"]
                )
            )
            if "Update" in native_input.keys()
            else Option_None()
        ),
    )


def com_amazonaws_dynamodb_ConditionCheck(native_input):
    return DafnyConditionCheck(
        Key=Map(
            {
                Seq(
                    "".join(
                        [
                            chr(int.from_bytes(pair, "big"))
                            for pair in zip(*[iter(key.encode("utf-16-be"))] * 2)
                        ]
                    )
                ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_AttributeValue(
                    value
                )
                for (key, value) in native_input["Key"].items()
            }
        ),
        TableName=Seq(
            "".join(
                [
                    chr(int.from_bytes(pair, "big"))
                    for pair in zip(
                        *[iter(native_input["TableName"].encode("utf-16-be"))] * 2
                    )
                ]
            )
        ),
        ConditionExpression=Seq(
            "".join(
                [
                    chr(int.from_bytes(pair, "big"))
                    for pair in zip(
                        *[iter(native_input["ConditionExpression"].encode("utf-16-be"))]
                        * 2
                    )
                ]
            )
        ),
        ExpressionAttributeNames=(
            Option_Some(
                Map(
                    {
                        Seq(
                            "".join(
                                [
                                    chr(int.from_bytes(pair, "big"))
                                    for pair in zip(
                                        *[iter(key.encode("utf-16-be"))] * 2
                                    )
                                ]
                            )
                        ): Seq(
                            "".join(
                                [
                                    chr(int.from_bytes(pair, "big"))
                                    for pair in zip(
                                        *[iter(value.encode("utf-16-be"))] * 2
                                    )
                                ]
                            )
                        )
                        for (key, value) in native_input[
                            "ExpressionAttributeNames"
                        ].items()
                    }
                )
            )
            if "ExpressionAttributeNames" in native_input.keys()
            else Option_None()
        ),
        ExpressionAttributeValues=(
            Option_Some(
                Map(
                    {
                        Seq(
                            "".join(
                                [
                                    chr(int.from_bytes(pair, "big"))
                                    for pair in zip(
                                        *[iter(key.encode("utf-16-be"))] * 2
                                    )
                                ]
                            )
                        ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_AttributeValue(
                            value
                        )
                        for (key, value) in native_input[
                            "ExpressionAttributeValues"
                        ].items()
                    }
                )
            )
            if "ExpressionAttributeValues" in native_input.keys()
            else Option_None()
        ),
        ReturnValuesOnConditionCheckFailure=(
            Option_Some(
                aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ReturnValuesOnConditionCheckFailure(
                    native_input["ReturnValuesOnConditionCheckFailure"]
                )
            )
            if "ReturnValuesOnConditionCheckFailure" in native_input.keys()
            else Option_None()
        ),
    )


def com_amazonaws_dynamodb_Put(native_input):
    return DafnyPut(
        Item=Map(
            {
                Seq(
                    "".join(
                        [
                            chr(int.from_bytes(pair, "big"))
                            for pair in zip(*[iter(key.encode("utf-16-be"))] * 2)
                        ]
                    )
                ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_AttributeValue(
                    value
                )
                for (key, value) in native_input["Item"].items()
            }
        ),
        TableName=Seq(
            "".join(
                [
                    chr(int.from_bytes(pair, "big"))
                    for pair in zip(
                        *[iter(native_input["TableName"].encode("utf-16-be"))] * 2
                    )
                ]
            )
        ),
        ConditionExpression=(
            Option_Some(
                Seq(
                    "".join(
                        [
                            chr(int.from_bytes(pair, "big"))
                            for pair in zip(
                                *[
                                    iter(
                                        native_input["ConditionExpression"].encode(
                                            "utf-16-be"
                                        )
                                    )
                                ]
                                * 2
                            )
                        ]
                    )
                )
            )
            if "ConditionExpression" in native_input.keys()
            else Option_None()
        ),
        ExpressionAttributeNames=(
            Option_Some(
                Map(
                    {
                        Seq(
                            "".join(
                                [
                                    chr(int.from_bytes(pair, "big"))
                                    for pair in zip(
                                        *[iter(key.encode("utf-16-be"))] * 2
                                    )
                                ]
                            )
                        ): Seq(
                            "".join(
                                [
                                    chr(int.from_bytes(pair, "big"))
                                    for pair in zip(
                                        *[iter(value.encode("utf-16-be"))] * 2
                                    )
                                ]
                            )
                        )
                        for (key, value) in native_input[
                            "ExpressionAttributeNames"
                        ].items()
                    }
                )
            )
            if "ExpressionAttributeNames" in native_input.keys()
            else Option_None()
        ),
        ExpressionAttributeValues=(
            Option_Some(
                Map(
                    {
                        Seq(
                            "".join(
                                [
                                    chr(int.from_bytes(pair, "big"))
                                    for pair in zip(
                                        *[iter(key.encode("utf-16-be"))] * 2
                                    )
                                ]
                            )
                        ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_AttributeValue(
                            value
                        )
                        for (key, value) in native_input[
                            "ExpressionAttributeValues"
                        ].items()
                    }
                )
            )
            if "ExpressionAttributeValues" in native_input.keys()
            else Option_None()
        ),
        ReturnValuesOnConditionCheckFailure=(
            Option_Some(
                aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ReturnValuesOnConditionCheckFailure(
                    native_input["ReturnValuesOnConditionCheckFailure"]
                )
            )
            if "ReturnValuesOnConditionCheckFailure" in native_input.keys()
            else Option_None()
        ),
    )


def com_amazonaws_dynamodb_Delete(native_input):
    return DafnyDelete(
        Key=Map(
            {
                Seq(
                    "".join(
                        [
                            chr(int.from_bytes(pair, "big"))
                            for pair in zip(*[iter(key.encode("utf-16-be"))] * 2)
                        ]
                    )
                ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_AttributeValue(
                    value
                )
                for (key, value) in native_input["Key"].items()
            }
        ),
        TableName=Seq(
            "".join(
                [
                    chr(int.from_bytes(pair, "big"))
                    for pair in zip(
                        *[iter(native_input["TableName"].encode("utf-16-be"))] * 2
                    )
                ]
            )
        ),
        ConditionExpression=(
            Option_Some(
                Seq(
                    "".join(
                        [
                            chr(int.from_bytes(pair, "big"))
                            for pair in zip(
                                *[
                                    iter(
                                        native_input["ConditionExpression"].encode(
                                            "utf-16-be"
                                        )
                                    )
                                ]
                                * 2
                            )
                        ]
                    )
                )
            )
            if "ConditionExpression" in native_input.keys()
            else Option_None()
        ),
        ExpressionAttributeNames=(
            Option_Some(
                Map(
                    {
                        Seq(
                            "".join(
                                [
                                    chr(int.from_bytes(pair, "big"))
                                    for pair in zip(
                                        *[iter(key.encode("utf-16-be"))] * 2
                                    )
                                ]
                            )
                        ): Seq(
                            "".join(
                                [
                                    chr(int.from_bytes(pair, "big"))
                                    for pair in zip(
                                        *[iter(value.encode("utf-16-be"))] * 2
                                    )
                                ]
                            )
                        )
                        for (key, value) in native_input[
                            "ExpressionAttributeNames"
                        ].items()
                    }
                )
            )
            if "ExpressionAttributeNames" in native_input.keys()
            else Option_None()
        ),
        ExpressionAttributeValues=(
            Option_Some(
                Map(
                    {
                        Seq(
                            "".join(
                                [
                                    chr(int.from_bytes(pair, "big"))
                                    for pair in zip(
                                        *[iter(key.encode("utf-16-be"))] * 2
                                    )
                                ]
                            )
                        ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_AttributeValue(
                            value
                        )
                        for (key, value) in native_input[
                            "ExpressionAttributeValues"
                        ].items()
                    }
                )
            )
            if "ExpressionAttributeValues" in native_input.keys()
            else Option_None()
        ),
        ReturnValuesOnConditionCheckFailure=(
            Option_Some(
                aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ReturnValuesOnConditionCheckFailure(
                    native_input["ReturnValuesOnConditionCheckFailure"]
                )
            )
            if "ReturnValuesOnConditionCheckFailure" in native_input.keys()
            else Option_None()
        ),
    )


def com_amazonaws_dynamodb_Update(native_input):
    return DafnyUpdate(
        Key=Map(
            {
                Seq(
                    "".join(
                        [
                            chr(int.from_bytes(pair, "big"))
                            for pair in zip(*[iter(key.encode("utf-16-be"))] * 2)
                        ]
                    )
                ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_AttributeValue(
                    value
                )
                for (key, value) in native_input["Key"].items()
            }
        ),
        UpdateExpression=Seq(
            "".join(
                [
                    chr(int.from_bytes(pair, "big"))
                    for pair in zip(
                        *[iter(native_input["UpdateExpression"].encode("utf-16-be"))]
                        * 2
                    )
                ]
            )
        ),
        TableName=Seq(
            "".join(
                [
                    chr(int.from_bytes(pair, "big"))
                    for pair in zip(
                        *[iter(native_input["TableName"].encode("utf-16-be"))] * 2
                    )
                ]
            )
        ),
        ConditionExpression=(
            Option_Some(
                Seq(
                    "".join(
                        [
                            chr(int.from_bytes(pair, "big"))
                            for pair in zip(
                                *[
                                    iter(
                                        native_input["ConditionExpression"].encode(
                                            "utf-16-be"
                                        )
                                    )
                                ]
                                * 2
                            )
                        ]
                    )
                )
            )
            if "ConditionExpression" in native_input.keys()
            else Option_None()
        ),
        ExpressionAttributeNames=(
            Option_Some(
                Map(
                    {
                        Seq(
                            "".join(
                                [
                                    chr(int.from_bytes(pair, "big"))
                                    for pair in zip(
                                        *[iter(key.encode("utf-16-be"))] * 2
                                    )
                                ]
                            )
                        ): Seq(
                            "".join(
                                [
                                    chr(int.from_bytes(pair, "big"))
                                    for pair in zip(
                                        *[iter(value.encode("utf-16-be"))] * 2
                                    )
                                ]
                            )
                        )
                        for (key, value) in native_input[
                            "ExpressionAttributeNames"
                        ].items()
                    }
                )
            )
            if "ExpressionAttributeNames" in native_input.keys()
            else Option_None()
        ),
        ExpressionAttributeValues=(
            Option_Some(
                Map(
                    {
                        Seq(
                            "".join(
                                [
                                    chr(int.from_bytes(pair, "big"))
                                    for pair in zip(
                                        *[iter(key.encode("utf-16-be"))] * 2
                                    )
                                ]
                            )
                        ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_AttributeValue(
                            value
                        )
                        for (key, value) in native_input[
                            "ExpressionAttributeValues"
                        ].items()
                    }
                )
            )
            if "ExpressionAttributeValues" in native_input.keys()
            else Option_None()
        ),
        ReturnValuesOnConditionCheckFailure=(
            Option_Some(
                aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ReturnValuesOnConditionCheckFailure(
                    native_input["ReturnValuesOnConditionCheckFailure"]
                )
            )
            if "ReturnValuesOnConditionCheckFailure" in native_input.keys()
            else Option_None()
        ),
    )


def com_amazonaws_dynamodb_TransactWriteItemsOutput(native_input):
    return DafnyTransactWriteItemsOutput(
        ConsumedCapacity=(
            Option_Some(
                Seq(
                    [
                        aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ConsumedCapacity(
                            list_element
                        )
                        for list_element in native_input["ConsumedCapacity"]
                    ]
                )
            )
            if "ConsumedCapacity" in native_input.keys()
            else Option_None()
        ),
        ItemCollectionMetrics=(
            Option_Some(
                Map(
                    {
                        Seq(
                            "".join(
                                [
                                    chr(int.from_bytes(pair, "big"))
                                    for pair in zip(
                                        *[iter(key.encode("utf-16-be"))] * 2
                                    )
                                ]
                            )
                        ): Seq(
                            [
                                aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ItemCollectionMetrics(
                                    list_element
                                )
                                for list_element in value
                            ]
                        )
                        for (key, value) in native_input[
                            "ItemCollectionMetrics"
                        ].items()
                    }
                )
            )
            if "ItemCollectionMetrics" in native_input.keys()
            else Option_None()
        ),
    )


def com_amazonaws_dynamodb_UpdateItemInput(native_input):
    return DafnyUpdateItemInput(
        TableName=Seq(
            "".join(
                [
                    chr(int.from_bytes(pair, "big"))
                    for pair in zip(
                        *[iter(native_input["TableName"].encode("utf-16-be"))] * 2
                    )
                ]
            )
        ),
        Key=Map(
            {
                Seq(
                    "".join(
                        [
                            chr(int.from_bytes(pair, "big"))
                            for pair in zip(*[iter(key.encode("utf-16-be"))] * 2)
                        ]
                    )
                ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_AttributeValue(
                    value
                )
                for (key, value) in native_input["Key"].items()
            }
        ),
        AttributeUpdates=(
            Option_Some(
                Map(
                    {
                        Seq(
                            "".join(
                                [
                                    chr(int.from_bytes(pair, "big"))
                                    for pair in zip(
                                        *[iter(key.encode("utf-16-be"))] * 2
                                    )
                                ]
                            )
                        ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_AttributeValueUpdate(
                            value
                        )
                        for (key, value) in native_input["AttributeUpdates"].items()
                    }
                )
            )
            if "AttributeUpdates" in native_input.keys()
            else Option_None()
        ),
        Expected=(
            Option_Some(
                Map(
                    {
                        Seq(
                            "".join(
                                [
                                    chr(int.from_bytes(pair, "big"))
                                    for pair in zip(
                                        *[iter(key.encode("utf-16-be"))] * 2
                                    )
                                ]
                            )
                        ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ExpectedAttributeValue(
                            value
                        )
                        for (key, value) in native_input["Expected"].items()
                    }
                )
            )
            if "Expected" in native_input.keys()
            else Option_None()
        ),
        ConditionalOperator=(
            Option_Some(
                aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ConditionalOperator(
                    native_input["ConditionalOperator"]
                )
            )
            if "ConditionalOperator" in native_input.keys()
            else Option_None()
        ),
        ReturnValues=(
            Option_Some(
                aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ReturnValue(
                    native_input["ReturnValues"]
                )
            )
            if "ReturnValues" in native_input.keys()
            else Option_None()
        ),
        ReturnConsumedCapacity=(
            Option_Some(
                aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ReturnConsumedCapacity(
                    native_input["ReturnConsumedCapacity"]
                )
            )
            if "ReturnConsumedCapacity" in native_input.keys()
            else Option_None()
        ),
        ReturnItemCollectionMetrics=(
            Option_Some(
                aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ReturnItemCollectionMetrics(
                    native_input["ReturnItemCollectionMetrics"]
                )
            )
            if "ReturnItemCollectionMetrics" in native_input.keys()
            else Option_None()
        ),
        UpdateExpression=(
            Option_Some(
                Seq(
                    "".join(
                        [
                            chr(int.from_bytes(pair, "big"))
                            for pair in zip(
                                *[
                                    iter(
                                        native_input["UpdateExpression"].encode(
                                            "utf-16-be"
                                        )
                                    )
                                ]
                                * 2
                            )
                        ]
                    )
                )
            )
            if "UpdateExpression" in native_input.keys()
            else Option_None()
        ),
        ConditionExpression=(
            Option_Some(
                Seq(
                    "".join(
                        [
                            chr(int.from_bytes(pair, "big"))
                            for pair in zip(
                                *[
                                    iter(
                                        native_input["ConditionExpression"].encode(
                                            "utf-16-be"
                                        )
                                    )
                                ]
                                * 2
                            )
                        ]
                    )
                )
            )
            if "ConditionExpression" in native_input.keys()
            else Option_None()
        ),
        ExpressionAttributeNames=(
            Option_Some(
                Map(
                    {
                        Seq(
                            "".join(
                                [
                                    chr(int.from_bytes(pair, "big"))
                                    for pair in zip(
                                        *[iter(key.encode("utf-16-be"))] * 2
                                    )
                                ]
                            )
                        ): Seq(
                            "".join(
                                [
                                    chr(int.from_bytes(pair, "big"))
                                    for pair in zip(
                                        *[iter(value.encode("utf-16-be"))] * 2
                                    )
                                ]
                            )
                        )
                        for (key, value) in native_input[
                            "ExpressionAttributeNames"
                        ].items()
                    }
                )
            )
            if "ExpressionAttributeNames" in native_input.keys()
            else Option_None()
        ),
        ExpressionAttributeValues=(
            Option_Some(
                Map(
                    {
                        Seq(
                            "".join(
                                [
                                    chr(int.from_bytes(pair, "big"))
                                    for pair in zip(
                                        *[iter(key.encode("utf-16-be"))] * 2
                                    )
                                ]
                            )
                        ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_AttributeValue(
                            value
                        )
                        for (key, value) in native_input[
                            "ExpressionAttributeValues"
                        ].items()
                    }
                )
            )
            if "ExpressionAttributeValues" in native_input.keys()
            else Option_None()
        ),
        ReturnValuesOnConditionCheckFailure=(
            Option_Some(
                aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ReturnValuesOnConditionCheckFailure(
                    native_input["ReturnValuesOnConditionCheckFailure"]
                )
            )
            if "ReturnValuesOnConditionCheckFailure" in native_input.keys()
            else Option_None()
        ),
    )


def com_amazonaws_dynamodb_AttributeValueUpdate(native_input):
    return DafnyAttributeValueUpdate(
        Value=(
            Option_Some(
                aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_AttributeValue(
                    native_input["Value"]
                )
            )
            if "Value" in native_input.keys()
            else Option_None()
        ),
        Action=(
            Option_Some(
                aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_AttributeAction(
                    native_input["Action"]
                )
            )
            if "Action" in native_input.keys()
            else Option_None()
        ),
    )


def com_amazonaws_dynamodb_AttributeAction(native_input):
    # Convert AttributeAction
    if native_input == "ADD":
        return AttributeAction_ADD()
    elif native_input == "PUT":
        return AttributeAction_PUT()
    elif native_input == "DELETE":
        return AttributeAction_DELETE()
    else:
        raise ValueError("No recognized enum value in enum type: " + native_input)


def com_amazonaws_dynamodb_UpdateItemOutput(native_input):
    return DafnyUpdateItemOutput(
        Attributes=(
            Option_Some(
                Map(
                    {
                        Seq(
                            "".join(
                                [
                                    chr(int.from_bytes(pair, "big"))
                                    for pair in zip(
                                        *[iter(key.encode("utf-16-be"))] * 2
                                    )
                                ]
                            )
                        ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_AttributeValue(
                            value
                        )
                        for (key, value) in native_input["Attributes"].items()
                    }
                )
            )
            if "Attributes" in native_input.keys()
            else Option_None()
        ),
        ConsumedCapacity=(
            Option_Some(
                aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ConsumedCapacity(
                    native_input["ConsumedCapacity"]
                )
            )
            if "ConsumedCapacity" in native_input.keys()
            else Option_None()
        ),
        ItemCollectionMetrics=(
            Option_Some(
                aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ItemCollectionMetrics(
                    native_input["ItemCollectionMetrics"]
                )
            )
            if "ItemCollectionMetrics" in native_input.keys()
            else Option_None()
        ),
    )


def com_amazonaws_dynamodb_DeleteItemInput(native_input):
    return DafnyDeleteItemInput(
        TableName=Seq(
            "".join(
                [
                    chr(int.from_bytes(pair, "big"))
                    for pair in zip(
                        *[iter(native_input["TableName"].encode("utf-16-be"))] * 2
                    )
                ]
            )
        ),
        Key=Map(
            {
                Seq(
                    "".join(
                        [
                            chr(int.from_bytes(pair, "big"))
                            for pair in zip(*[iter(key.encode("utf-16-be"))] * 2)
                        ]
                    )
                ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_AttributeValue(
                    value
                )
                for (key, value) in native_input["Key"].items()
            }
        ),
        Expected=(
            Option_Some(
                Map(
                    {
                        Seq(
                            "".join(
                                [
                                    chr(int.from_bytes(pair, "big"))
                                    for pair in zip(
                                        *[iter(key.encode("utf-16-be"))] * 2
                                    )
                                ]
                            )
                        ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ExpectedAttributeValue(
                            value
                        )
                        for (key, value) in native_input["Expected"].items()
                    }
                )
            )
            if "Expected" in native_input.keys()
            else Option_None()
        ),
        ConditionalOperator=(
            Option_Some(
                aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ConditionalOperator(
                    native_input["ConditionalOperator"]
                )
            )
            if "ConditionalOperator" in native_input.keys()
            else Option_None()
        ),
        ReturnValues=(
            Option_Some(
                aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ReturnValue(
                    native_input["ReturnValues"]
                )
            )
            if "ReturnValues" in native_input.keys()
            else Option_None()
        ),
        ReturnConsumedCapacity=(
            Option_Some(
                aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ReturnConsumedCapacity(
                    native_input["ReturnConsumedCapacity"]
                )
            )
            if "ReturnConsumedCapacity" in native_input.keys()
            else Option_None()
        ),
        ReturnItemCollectionMetrics=(
            Option_Some(
                aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ReturnItemCollectionMetrics(
                    native_input["ReturnItemCollectionMetrics"]
                )
            )
            if "ReturnItemCollectionMetrics" in native_input.keys()
            else Option_None()
        ),
        ConditionExpression=(
            Option_Some(
                Seq(
                    "".join(
                        [
                            chr(int.from_bytes(pair, "big"))
                            for pair in zip(
                                *[
                                    iter(
                                        native_input["ConditionExpression"].encode(
                                            "utf-16-be"
                                        )
                                    )
                                ]
                                * 2
                            )
                        ]
                    )
                )
            )
            if "ConditionExpression" in native_input.keys()
            else Option_None()
        ),
        ExpressionAttributeNames=(
            Option_Some(
                Map(
                    {
                        Seq(
                            "".join(
                                [
                                    chr(int.from_bytes(pair, "big"))
                                    for pair in zip(
                                        *[iter(key.encode("utf-16-be"))] * 2
                                    )
                                ]
                            )
                        ): Seq(
                            "".join(
                                [
                                    chr(int.from_bytes(pair, "big"))
                                    for pair in zip(
                                        *[iter(value.encode("utf-16-be"))] * 2
                                    )
                                ]
                            )
                        )
                        for (key, value) in native_input[
                            "ExpressionAttributeNames"
                        ].items()
                    }
                )
            )
            if "ExpressionAttributeNames" in native_input.keys()
            else Option_None()
        ),
        ExpressionAttributeValues=(
            Option_Some(
                Map(
                    {
                        Seq(
                            "".join(
                                [
                                    chr(int.from_bytes(pair, "big"))
                                    for pair in zip(
                                        *[iter(key.encode("utf-16-be"))] * 2
                                    )
                                ]
                            )
                        ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_AttributeValue(
                            value
                        )
                        for (key, value) in native_input[
                            "ExpressionAttributeValues"
                        ].items()
                    }
                )
            )
            if "ExpressionAttributeValues" in native_input.keys()
            else Option_None()
        ),
        ReturnValuesOnConditionCheckFailure=(
            Option_Some(
                aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ReturnValuesOnConditionCheckFailure(
                    native_input["ReturnValuesOnConditionCheckFailure"]
                )
            )
            if "ReturnValuesOnConditionCheckFailure" in native_input.keys()
            else Option_None()
        ),
    )


def com_amazonaws_dynamodb_DeleteItemOutput(native_input):
    return DafnyDeleteItemOutput(
        Attributes=(
            Option_Some(
                Map(
                    {
                        Seq(
                            "".join(
                                [
                                    chr(int.from_bytes(pair, "big"))
                                    for pair in zip(
                                        *[iter(key.encode("utf-16-be"))] * 2
                                    )
                                ]
                            )
                        ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_AttributeValue(
                            value
                        )
                        for (key, value) in native_input["Attributes"].items()
                    }
                )
            )
            if "Attributes" in native_input.keys()
            else Option_None()
        ),
        ConsumedCapacity=(
            Option_Some(
                aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ConsumedCapacity(
                    native_input["ConsumedCapacity"]
                )
            )
            if "ConsumedCapacity" in native_input.keys()
            else Option_None()
        ),
        ItemCollectionMetrics=(
            Option_Some(
                aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ItemCollectionMetrics(
                    native_input["ItemCollectionMetrics"]
                )
            )
            if "ItemCollectionMetrics" in native_input.keys()
            else Option_None()
        ),
    )


def com_amazonaws_dynamodb_TransactGetItemsInput(native_input):
    return DafnyTransactGetItemsInput(
        TransactItems=Seq(
            [
                aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_TransactGetItem(
                    list_element
                )
                for list_element in native_input["TransactItems"]
            ]
        ),
        ReturnConsumedCapacity=(
            Option_Some(
                aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ReturnConsumedCapacity(
                    native_input["ReturnConsumedCapacity"]
                )
            )
            if "ReturnConsumedCapacity" in native_input.keys()
            else Option_None()
        ),
    )


def com_amazonaws_dynamodb_TransactGetItem(native_input):
    return DafnyTransactGetItem(
        Get=aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_Get(
            native_input["Get"]
        ),
    )


def com_amazonaws_dynamodb_Get(native_input):
    return DafnyGet(
        Key=Map(
            {
                Seq(
                    "".join(
                        [
                            chr(int.from_bytes(pair, "big"))
                            for pair in zip(*[iter(key.encode("utf-16-be"))] * 2)
                        ]
                    )
                ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_AttributeValue(
                    value
                )
                for (key, value) in native_input["Key"].items()
            }
        ),
        TableName=Seq(
            "".join(
                [
                    chr(int.from_bytes(pair, "big"))
                    for pair in zip(
                        *[iter(native_input["TableName"].encode("utf-16-be"))] * 2
                    )
                ]
            )
        ),
        ProjectionExpression=(
            Option_Some(
                Seq(
                    "".join(
                        [
                            chr(int.from_bytes(pair, "big"))
                            for pair in zip(
                                *[
                                    iter(
                                        native_input["ProjectionExpression"].encode(
                                            "utf-16-be"
                                        )
                                    )
                                ]
                                * 2
                            )
                        ]
                    )
                )
            )
            if "ProjectionExpression" in native_input.keys()
            else Option_None()
        ),
        ExpressionAttributeNames=(
            Option_Some(
                Map(
                    {
                        Seq(
                            "".join(
                                [
                                    chr(int.from_bytes(pair, "big"))
                                    for pair in zip(
                                        *[iter(key.encode("utf-16-be"))] * 2
                                    )
                                ]
                            )
                        ): Seq(
                            "".join(
                                [
                                    chr(int.from_bytes(pair, "big"))
                                    for pair in zip(
                                        *[iter(value.encode("utf-16-be"))] * 2
                                    )
                                ]
                            )
                        )
                        for (key, value) in native_input[
                            "ExpressionAttributeNames"
                        ].items()
                    }
                )
            )
            if "ExpressionAttributeNames" in native_input.keys()
            else Option_None()
        ),
    )


def com_amazonaws_dynamodb_TransactGetItemsOutput(native_input):
    return DafnyTransactGetItemsOutput(
        ConsumedCapacity=(
            Option_Some(
                Seq(
                    [
                        aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ConsumedCapacity(
                            list_element
                        )
                        for list_element in native_input["ConsumedCapacity"]
                    ]
                )
            )
            if "ConsumedCapacity" in native_input.keys()
            else Option_None()
        ),
        Responses=(
            Option_Some(
                Seq(
                    [
                        aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ItemResponse(
                            list_element
                        )
                        for list_element in native_input["Responses"]
                    ]
                )
            )
            if "Responses" in native_input.keys()
            else Option_None()
        ),
    )


def com_amazonaws_dynamodb_ItemResponse(native_input):
    return DafnyItemResponse(
        Item=(
            Option_Some(
                Map(
                    {
                        Seq(
                            "".join(
                                [
                                    chr(int.from_bytes(pair, "big"))
                                    for pair in zip(
                                        *[iter(key.encode("utf-16-be"))] * 2
                                    )
                                ]
                            )
                        ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_AttributeValue(
                            value
                        )
                        for (key, value) in native_input["Item"].items()
                    }
                )
            )
            if "Item" in native_input.keys()
            else Option_None()
        ),
    )


def com_amazonaws_dynamodb_ExecuteStatementInput(native_input):
    return DafnyExecuteStatementInput(
        Statement=Seq(
            "".join(
                [
                    chr(int.from_bytes(pair, "big"))
                    for pair in zip(
                        *[iter(native_input["Statement"].encode("utf-16-be"))] * 2
                    )
                ]
            )
        ),
        Parameters=(
            Option_Some(
                Seq(
                    [
                        aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_AttributeValue(
                            list_element
                        )
                        for list_element in native_input["Parameters"]
                    ]
                )
            )
            if "Parameters" in native_input.keys()
            else Option_None()
        ),
        ConsistentRead=(
            Option_Some(native_input["ConsistentRead"])
            if "ConsistentRead" in native_input.keys()
            else Option_None()
        ),
        NextToken=(
            Option_Some(
                Seq(
                    "".join(
                        [
                            chr(int.from_bytes(pair, "big"))
                            for pair in zip(
                                *[iter(native_input["NextToken"].encode("utf-16-be"))]
                                * 2
                            )
                        ]
                    )
                )
            )
            if "NextToken" in native_input.keys()
            else Option_None()
        ),
        ReturnConsumedCapacity=(
            Option_Some(
                aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ReturnConsumedCapacity(
                    native_input["ReturnConsumedCapacity"]
                )
            )
            if "ReturnConsumedCapacity" in native_input.keys()
            else Option_None()
        ),
        Limit=(
            Option_Some(native_input["Limit"])
            if "Limit" in native_input.keys()
            else Option_None()
        ),
        ReturnValuesOnConditionCheckFailure=(
            Option_Some(
                aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ReturnValuesOnConditionCheckFailure(
                    native_input["ReturnValuesOnConditionCheckFailure"]
                )
            )
            if "ReturnValuesOnConditionCheckFailure" in native_input.keys()
            else Option_None()
        ),
    )


def com_amazonaws_dynamodb_ExecuteStatementOutput(native_input):
    return DafnyExecuteStatementOutput(
        Items=(
            Option_Some(
                Seq(
                    [
                        Map(
                            {
                                Seq(
                                    "".join(
                                        [
                                            chr(int.from_bytes(pair, "big"))
                                            for pair in zip(
                                                *[iter(key.encode("utf-16-be"))] * 2
                                            )
                                        ]
                                    )
                                ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_AttributeValue(
                                    value
                                )
                                for (key, value) in list_element.items()
                            }
                        )
                        for list_element in native_input["Items"]
                    ]
                )
            )
            if "Items" in native_input.keys()
            else Option_None()
        ),
        NextToken=(
            Option_Some(
                Seq(
                    "".join(
                        [
                            chr(int.from_bytes(pair, "big"))
                            for pair in zip(
                                *[iter(native_input["NextToken"].encode("utf-16-be"))]
                                * 2
                            )
                        ]
                    )
                )
            )
            if "NextToken" in native_input.keys()
            else Option_None()
        ),
        ConsumedCapacity=(
            Option_Some(
                aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ConsumedCapacity(
                    native_input["ConsumedCapacity"]
                )
            )
            if "ConsumedCapacity" in native_input.keys()
            else Option_None()
        ),
        LastEvaluatedKey=(
            Option_Some(
                Map(
                    {
                        Seq(
                            "".join(
                                [
                                    chr(int.from_bytes(pair, "big"))
                                    for pair in zip(
                                        *[iter(key.encode("utf-16-be"))] * 2
                                    )
                                ]
                            )
                        ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_AttributeValue(
                            value
                        )
                        for (key, value) in native_input["LastEvaluatedKey"].items()
                    }
                )
            )
            if "LastEvaluatedKey" in native_input.keys()
            else Option_None()
        ),
    )


def com_amazonaws_dynamodb_BatchExecuteStatementInput(native_input):
    return DafnyBatchExecuteStatementInput(
        Statements=Seq(
            [
                aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_BatchStatementRequest(
                    list_element
                )
                for list_element in native_input["Statements"]
            ]
        ),
        ReturnConsumedCapacity=(
            Option_Some(
                aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ReturnConsumedCapacity(
                    native_input["ReturnConsumedCapacity"]
                )
            )
            if "ReturnConsumedCapacity" in native_input.keys()
            else Option_None()
        ),
    )


def com_amazonaws_dynamodb_BatchStatementRequest(native_input):
    return DafnyBatchStatementRequest(
        Statement=Seq(
            "".join(
                [
                    chr(int.from_bytes(pair, "big"))
                    for pair in zip(
                        *[iter(native_input["Statement"].encode("utf-16-be"))] * 2
                    )
                ]
            )
        ),
        Parameters=(
            Option_Some(
                Seq(
                    [
                        aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_AttributeValue(
                            list_element
                        )
                        for list_element in native_input["Parameters"]
                    ]
                )
            )
            if "Parameters" in native_input.keys()
            else Option_None()
        ),
        ConsistentRead=(
            Option_Some(native_input["ConsistentRead"])
            if "ConsistentRead" in native_input.keys()
            else Option_None()
        ),
        ReturnValuesOnConditionCheckFailure=(
            Option_Some(
                aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ReturnValuesOnConditionCheckFailure(
                    native_input["ReturnValuesOnConditionCheckFailure"]
                )
            )
            if "ReturnValuesOnConditionCheckFailure" in native_input.keys()
            else Option_None()
        ),
    )


def com_amazonaws_dynamodb_BatchExecuteStatementOutput(native_input):
    return DafnyBatchExecuteStatementOutput(
        Responses=(
            Option_Some(
                Seq(
                    [
                        aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_BatchStatementResponse(
                            list_element
                        )
                        for list_element in native_input["Responses"]
                    ]
                )
            )
            if "Responses" in native_input.keys()
            else Option_None()
        ),
        ConsumedCapacity=(
            Option_Some(
                Seq(
                    [
                        aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ConsumedCapacity(
                            list_element
                        )
                        for list_element in native_input["ConsumedCapacity"]
                    ]
                )
            )
            if "ConsumedCapacity" in native_input.keys()
            else Option_None()
        ),
    )


def com_amazonaws_dynamodb_BatchStatementResponse(native_input):
    return DafnyBatchStatementResponse(
        Error=(
            Option_Some(
                aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_BatchStatementError(
                    native_input["Error"]
                )
            )
            if "Error" in native_input.keys()
            else Option_None()
        ),
        TableName=(
            Option_Some(
                Seq(
                    "".join(
                        [
                            chr(int.from_bytes(pair, "big"))
                            for pair in zip(
                                *[iter(native_input["TableName"].encode("utf-16-be"))]
                                * 2
                            )
                        ]
                    )
                )
            )
            if "TableName" in native_input.keys()
            else Option_None()
        ),
        Item=(
            Option_Some(
                Map(
                    {
                        Seq(
                            "".join(
                                [
                                    chr(int.from_bytes(pair, "big"))
                                    for pair in zip(
                                        *[iter(key.encode("utf-16-be"))] * 2
                                    )
                                ]
                            )
                        ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_AttributeValue(
                            value
                        )
                        for (key, value) in native_input["Item"].items()
                    }
                )
            )
            if "Item" in native_input.keys()
            else Option_None()
        ),
    )


def com_amazonaws_dynamodb_BatchStatementError(native_input):
    return DafnyBatchStatementError(
        Code=(
            Option_Some(
                aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_BatchStatementErrorCodeEnum(
                    native_input["Code"]
                )
            )
            if "Code" in native_input.keys()
            else Option_None()
        ),
        Message=(
            Option_Some(
                Seq(
                    "".join(
                        [
                            chr(int.from_bytes(pair, "big"))
                            for pair in zip(
                                *[iter(native_input["Message"].encode("utf-16-be"))] * 2
                            )
                        ]
                    )
                )
            )
            if "Message" in native_input.keys()
            else Option_None()
        ),
        Item=(
            Option_Some(
                Map(
                    {
                        Seq(
                            "".join(
                                [
                                    chr(int.from_bytes(pair, "big"))
                                    for pair in zip(
                                        *[iter(key.encode("utf-16-be"))] * 2
                                    )
                                ]
                            )
                        ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_AttributeValue(
                            value
                        )
                        for (key, value) in native_input["Item"].items()
                    }
                )
            )
            if "Item" in native_input.keys()
            else Option_None()
        ),
    )


def com_amazonaws_dynamodb_BatchStatementErrorCodeEnum(native_input):
    # Convert BatchStatementErrorCodeEnum
    if native_input == "ConditionalCheckFailed":
        return BatchStatementErrorCodeEnum_ConditionalCheckFailed()
    elif native_input == "ItemCollectionSizeLimitExceeded":
        return BatchStatementErrorCodeEnum_ItemCollectionSizeLimitExceeded()
    elif native_input == "RequestLimitExceeded":
        return BatchStatementErrorCodeEnum_RequestLimitExceeded()
    elif native_input == "ValidationError":
        return BatchStatementErrorCodeEnum_ValidationError()
    elif native_input == "ProvisionedThroughputExceeded":
        return BatchStatementErrorCodeEnum_ProvisionedThroughputExceeded()
    elif native_input == "TransactionConflict":
        return BatchStatementErrorCodeEnum_TransactionConflict()
    elif native_input == "ThrottlingError":
        return BatchStatementErrorCodeEnum_ThrottlingError()
    elif native_input == "InternalServerError":
        return BatchStatementErrorCodeEnum_InternalServerError()
    elif native_input == "ResourceNotFound":
        return BatchStatementErrorCodeEnum_ResourceNotFound()
    elif native_input == "AccessDenied":
        return BatchStatementErrorCodeEnum_AccessDenied()
    elif native_input == "DuplicateItem":
        return BatchStatementErrorCodeEnum_DuplicateItem()
    else:
        raise ValueError("No recognized enum value in enum type: " + native_input)


def com_amazonaws_dynamodb_ExecuteTransactionInput(native_input):
    return DafnyExecuteTransactionInput(
        TransactStatements=Seq(
            [
                aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ParameterizedStatement(
                    list_element
                )
                for list_element in native_input["TransactStatements"]
            ]
        ),
        ClientRequestToken=(
            Option_Some(
                Seq(
                    "".join(
                        [
                            chr(int.from_bytes(pair, "big"))
                            for pair in zip(
                                *[
                                    iter(
                                        native_input["ClientRequestToken"].encode(
                                            "utf-16-be"
                                        )
                                    )
                                ]
                                * 2
                            )
                        ]
                    )
                )
            )
            if "ClientRequestToken" in native_input.keys()
            else Option_None()
        ),
        ReturnConsumedCapacity=(
            Option_Some(
                aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ReturnConsumedCapacity(
                    native_input["ReturnConsumedCapacity"]
                )
            )
            if "ReturnConsumedCapacity" in native_input.keys()
            else Option_None()
        ),
    )


def com_amazonaws_dynamodb_ParameterizedStatement(native_input):
    return DafnyParameterizedStatement(
        Statement=Seq(
            "".join(
                [
                    chr(int.from_bytes(pair, "big"))
                    for pair in zip(
                        *[iter(native_input["Statement"].encode("utf-16-be"))] * 2
                    )
                ]
            )
        ),
        Parameters=(
            Option_Some(
                Seq(
                    [
                        aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_AttributeValue(
                            list_element
                        )
                        for list_element in native_input["Parameters"]
                    ]
                )
            )
            if "Parameters" in native_input.keys()
            else Option_None()
        ),
        ReturnValuesOnConditionCheckFailure=(
            Option_Some(
                aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ReturnValuesOnConditionCheckFailure(
                    native_input["ReturnValuesOnConditionCheckFailure"]
                )
            )
            if "ReturnValuesOnConditionCheckFailure" in native_input.keys()
            else Option_None()
        ),
    )


def com_amazonaws_dynamodb_ExecuteTransactionOutput(native_input):
    return DafnyExecuteTransactionOutput(
        Responses=(
            Option_Some(
                Seq(
                    [
                        aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ItemResponse(
                            list_element
                        )
                        for list_element in native_input["Responses"]
                    ]
                )
            )
            if "Responses" in native_input.keys()
            else Option_None()
        ),
        ConsumedCapacity=(
            Option_Some(
                Seq(
                    [
                        aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny.com_amazonaws_dynamodb_ConsumedCapacity(
                            list_element
                        )
                        for list_element in native_input["ConsumedCapacity"]
                    ]
                )
            )
            if "ConsumedCapacity" in native_input.keys()
            else Option_None()
        ),
    )
