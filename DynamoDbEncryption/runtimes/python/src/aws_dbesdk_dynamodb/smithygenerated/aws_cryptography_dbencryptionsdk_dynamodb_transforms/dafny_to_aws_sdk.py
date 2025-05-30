# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
# Do not modify this file. This file is machine generated, and any changes to it will be overwritten.

from aws_cryptography_internal_dynamodb.internaldafny.generated.ComAmazonawsDynamodbTypes import (
    AttributeAction_ADD,
    AttributeAction_DELETE,
    AttributeAction_PUT,
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
    ConditionalOperator_AND,
    ConditionalOperator_OR,
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
    Select_ALL__ATTRIBUTES,
    Select_ALL__PROJECTED__ATTRIBUTES,
    Select_COUNT,
    Select_SPECIFIC__ATTRIBUTES,
)
import aws_cryptography_internal_dynamodb.internaldafny.generated.module_
import aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk


def com_amazonaws_dynamodb_AttributeValue(dafny_input):
    # Convert AttributeValue
    if isinstance(dafny_input, AttributeValue_S):
        AttributeValue_union_value = {
            "S": b"".join(ord(c).to_bytes(2, "big") for c in dafny_input.S).decode("utf-16-be")
        }
    elif isinstance(dafny_input, AttributeValue_N):
        AttributeValue_union_value = {
            "N": b"".join(ord(c).to_bytes(2, "big") for c in dafny_input.N).decode("utf-16-be")
        }
    elif isinstance(dafny_input, AttributeValue_B):
        AttributeValue_union_value = {"B": bytes(dafny_input.B)}
    elif isinstance(dafny_input, AttributeValue_SS):
        AttributeValue_union_value = {
            "SS": [
                b"".join(ord(c).to_bytes(2, "big") for c in list_element).decode("utf-16-be")
                for list_element in dafny_input.SS
            ]
        }
    elif isinstance(dafny_input, AttributeValue_NS):
        AttributeValue_union_value = {
            "NS": [
                b"".join(ord(c).to_bytes(2, "big") for c in list_element).decode("utf-16-be")
                for list_element in dafny_input.NS
            ]
        }
    elif isinstance(dafny_input, AttributeValue_BS):
        AttributeValue_union_value = {"BS": [bytes(list_element) for list_element in dafny_input.BS]}
    elif isinstance(dafny_input, AttributeValue_M):
        AttributeValue_union_value = {
            "M": {
                b"".join(ord(c).to_bytes(2, "big") for c in key).decode(
                    "utf-16-be"
                ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_AttributeValue(
                    value
                )
                for (key, value) in dafny_input.M.items
            }
        }
    elif isinstance(dafny_input, AttributeValue_L):
        AttributeValue_union_value = {
            "L": [
                aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_AttributeValue(
                    list_element
                )
                for list_element in dafny_input.L
            ]
        }
    elif isinstance(dafny_input, AttributeValue_NULL):
        AttributeValue_union_value = {"NULL": dafny_input.NULL}
    elif isinstance(dafny_input, AttributeValue_BOOL):
        AttributeValue_union_value = {"BOOL": dafny_input.BOOL}
    else:
        raise ValueError("No recognized union value in union type: " + str(dafny_input))

    return AttributeValue_union_value


def com_amazonaws_dynamodb_ExpectedAttributeValue(dafny_input):
    output = {}
    if dafny_input.Value.is_Some:
        output["Value"] = (
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_AttributeValue(
                dafny_input.Value.value
            )
        )

    if dafny_input.Exists.is_Some:
        output["Exists"] = dafny_input.Exists.value

    if dafny_input.ComparisonOperator.is_Some:
        output["ComparisonOperator"] = (
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_ComparisonOperator(
                dafny_input.ComparisonOperator.value
            )
        )

    if dafny_input.AttributeValueList.is_Some:
        output["AttributeValueList"] = [
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_AttributeValue(
                list_element
            )
            for list_element in dafny_input.AttributeValueList.value
        ]

    return output


def com_amazonaws_dynamodb_ComparisonOperator(dafny_input):
    # Convert ComparisonOperator
    if isinstance(dafny_input, ComparisonOperator_EQ):
        return "EQ"

    elif isinstance(dafny_input, ComparisonOperator_NE):
        return "NE"

    elif isinstance(dafny_input, ComparisonOperator_IN):
        return "IN"

    elif isinstance(dafny_input, ComparisonOperator_LE):
        return "LE"

    elif isinstance(dafny_input, ComparisonOperator_LT):
        return "LT"

    elif isinstance(dafny_input, ComparisonOperator_GE):
        return "GE"

    elif isinstance(dafny_input, ComparisonOperator_GT):
        return "GT"

    elif isinstance(dafny_input, ComparisonOperator_BETWEEN):
        return "BETWEEN"

    elif isinstance(dafny_input, ComparisonOperator_NOT__NULL):
        return "NOT_NULL"

    elif isinstance(dafny_input, ComparisonOperator_NULL):
        return "NULL"

    elif isinstance(dafny_input, ComparisonOperator_CONTAINS):
        return "CONTAINS"

    elif isinstance(dafny_input, ComparisonOperator_NOT__CONTAINS):
        return "NOT_CONTAINS"

    elif isinstance(dafny_input, ComparisonOperator_BEGINS__WITH):
        return "BEGINS_WITH"

    else:
        raise ValueError("No recognized enum value in enum type: " + dafny_input)


def com_amazonaws_dynamodb_ReturnValue(dafny_input):
    # Convert ReturnValue
    if isinstance(dafny_input, ReturnValue_NONE):
        return "NONE"

    elif isinstance(dafny_input, ReturnValue_ALL__OLD):
        return "ALL_OLD"

    elif isinstance(dafny_input, ReturnValue_UPDATED__OLD):
        return "UPDATED_OLD"

    elif isinstance(dafny_input, ReturnValue_ALL__NEW):
        return "ALL_NEW"

    elif isinstance(dafny_input, ReturnValue_UPDATED__NEW):
        return "UPDATED_NEW"

    else:
        raise ValueError("No recognized enum value in enum type: " + dafny_input)


def com_amazonaws_dynamodb_ReturnConsumedCapacity(dafny_input):
    # Convert ReturnConsumedCapacity
    if isinstance(dafny_input, ReturnConsumedCapacity_INDEXES):
        return "INDEXES"

    elif isinstance(dafny_input, ReturnConsumedCapacity_TOTAL):
        return "TOTAL"

    elif isinstance(dafny_input, ReturnConsumedCapacity_NONE):
        return "NONE"

    else:
        raise ValueError("No recognized enum value in enum type: " + dafny_input)


def com_amazonaws_dynamodb_ReturnItemCollectionMetrics(dafny_input):
    # Convert ReturnItemCollectionMetrics
    if isinstance(dafny_input, ReturnItemCollectionMetrics_SIZE):
        return "SIZE"

    elif isinstance(dafny_input, ReturnItemCollectionMetrics_NONE):
        return "NONE"

    else:
        raise ValueError("No recognized enum value in enum type: " + dafny_input)


def com_amazonaws_dynamodb_ConditionalOperator(dafny_input):
    # Convert ConditionalOperator
    if isinstance(dafny_input, ConditionalOperator_AND):
        return "AND"

    elif isinstance(dafny_input, ConditionalOperator_OR):
        return "OR"

    else:
        raise ValueError("No recognized enum value in enum type: " + dafny_input)


def com_amazonaws_dynamodb_ReturnValuesOnConditionCheckFailure(dafny_input):
    # Convert ReturnValuesOnConditionCheckFailure
    if isinstance(dafny_input, ReturnValuesOnConditionCheckFailure_ALL__OLD):
        return "ALL_OLD"

    elif isinstance(dafny_input, ReturnValuesOnConditionCheckFailure_NONE):
        return "NONE"

    else:
        raise ValueError("No recognized enum value in enum type: " + dafny_input)


def com_amazonaws_dynamodb_PutItemInput(dafny_input):
    output = {}
    output["TableName"] = b"".join(ord(c).to_bytes(2, "big") for c in dafny_input.TableName).decode("utf-16-be")
    output["Item"] = {
        b"".join(ord(c).to_bytes(2, "big") for c in key).decode(
            "utf-16-be"
        ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_AttributeValue(
            value
        )
        for (key, value) in dafny_input.Item.items
    }
    if dafny_input.Expected.is_Some:
        output["Expected"] = {
            b"".join(ord(c).to_bytes(2, "big") for c in key).decode(
                "utf-16-be"
            ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_ExpectedAttributeValue(
                value
            )
            for (key, value) in dafny_input.Expected.value.items
        }

    if dafny_input.ReturnValues.is_Some:
        output["ReturnValues"] = (
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_ReturnValue(
                dafny_input.ReturnValues.value
            )
        )

    if dafny_input.ReturnConsumedCapacity.is_Some:
        output["ReturnConsumedCapacity"] = (
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_ReturnConsumedCapacity(
                dafny_input.ReturnConsumedCapacity.value
            )
        )

    if dafny_input.ReturnItemCollectionMetrics.is_Some:
        output["ReturnItemCollectionMetrics"] = (
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_ReturnItemCollectionMetrics(
                dafny_input.ReturnItemCollectionMetrics.value
            )
        )

    if dafny_input.ConditionalOperator.is_Some:
        output["ConditionalOperator"] = (
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_ConditionalOperator(
                dafny_input.ConditionalOperator.value
            )
        )

    if dafny_input.ConditionExpression.is_Some:
        output["ConditionExpression"] = b"".join(
            ord(c).to_bytes(2, "big") for c in dafny_input.ConditionExpression.value
        ).decode("utf-16-be")

    if dafny_input.ExpressionAttributeNames.is_Some:
        output["ExpressionAttributeNames"] = {
            b"".join(ord(c).to_bytes(2, "big") for c in key)
            .decode("utf-16-be"): b"".join(ord(c).to_bytes(2, "big") for c in value)
            .decode("utf-16-be")
            for (key, value) in dafny_input.ExpressionAttributeNames.value.items
        }

    if dafny_input.ExpressionAttributeValues.is_Some:
        output["ExpressionAttributeValues"] = {
            b"".join(ord(c).to_bytes(2, "big") for c in key).decode(
                "utf-16-be"
            ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_AttributeValue(
                value
            )
            for (key, value) in dafny_input.ExpressionAttributeValues.value.items
        }

    if dafny_input.ReturnValuesOnConditionCheckFailure.is_Some:
        output["ReturnValuesOnConditionCheckFailure"] = (
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_ReturnValuesOnConditionCheckFailure(
                dafny_input.ReturnValuesOnConditionCheckFailure.value
            )
        )

    return output


def com_amazonaws_dynamodb_ConsumedCapacity(dafny_input):
    output = {}
    if dafny_input.TableName.is_Some:
        output["TableName"] = b"".join(ord(c).to_bytes(2, "big") for c in dafny_input.TableName.value).decode(
            "utf-16-be"
        )

    if dafny_input.CapacityUnits.is_Some:
        output["CapacityUnits"] = dafny_input.CapacityUnits.value

    if dafny_input.ReadCapacityUnits.is_Some:
        output["ReadCapacityUnits"] = dafny_input.ReadCapacityUnits.value

    if dafny_input.WriteCapacityUnits.is_Some:
        output["WriteCapacityUnits"] = dafny_input.WriteCapacityUnits.value

    if dafny_input.Table.is_Some:
        output["Table"] = (
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_Capacity(
                dafny_input.Table.value
            )
        )

    if dafny_input.LocalSecondaryIndexes.is_Some:
        output["LocalSecondaryIndexes"] = {
            b"".join(ord(c).to_bytes(2, "big") for c in key).decode(
                "utf-16-be"
            ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_Capacity(
                value
            )
            for (key, value) in dafny_input.LocalSecondaryIndexes.value.items
        }

    if dafny_input.GlobalSecondaryIndexes.is_Some:
        output["GlobalSecondaryIndexes"] = {
            b"".join(ord(c).to_bytes(2, "big") for c in key).decode(
                "utf-16-be"
            ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_Capacity(
                value
            )
            for (key, value) in dafny_input.GlobalSecondaryIndexes.value.items
        }

    return output


def com_amazonaws_dynamodb_Capacity(dafny_input):
    output = {}
    if dafny_input.ReadCapacityUnits.is_Some:
        output["ReadCapacityUnits"] = dafny_input.ReadCapacityUnits.value

    if dafny_input.WriteCapacityUnits.is_Some:
        output["WriteCapacityUnits"] = dafny_input.WriteCapacityUnits.value

    if dafny_input.CapacityUnits.is_Some:
        output["CapacityUnits"] = dafny_input.CapacityUnits.value

    return output


def com_amazonaws_dynamodb_ItemCollectionMetrics(dafny_input):
    output = {}
    if dafny_input.ItemCollectionKey.is_Some:
        output["ItemCollectionKey"] = {
            b"".join(ord(c).to_bytes(2, "big") for c in key).decode(
                "utf-16-be"
            ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_AttributeValue(
                value
            )
            for (key, value) in dafny_input.ItemCollectionKey.value.items
        }

    if dafny_input.SizeEstimateRangeGB.is_Some:
        output["SizeEstimateRangeGB"] = [list_element for list_element in dafny_input.SizeEstimateRangeGB.value]

    return output


def com_amazonaws_dynamodb_PutItemOutput(dafny_input):
    output = {}
    if dafny_input.Attributes.is_Some:
        output["Attributes"] = {
            b"".join(ord(c).to_bytes(2, "big") for c in key).decode(
                "utf-16-be"
            ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_AttributeValue(
                value
            )
            for (key, value) in dafny_input.Attributes.value.items
        }

    if dafny_input.ConsumedCapacity.is_Some:
        output["ConsumedCapacity"] = (
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_ConsumedCapacity(
                dafny_input.ConsumedCapacity.value
            )
        )

    if dafny_input.ItemCollectionMetrics.is_Some:
        output["ItemCollectionMetrics"] = (
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_ItemCollectionMetrics(
                dafny_input.ItemCollectionMetrics.value
            )
        )

    return output


def com_amazonaws_dynamodb_GetItemInput(dafny_input):
    output = {}
    output["TableName"] = b"".join(ord(c).to_bytes(2, "big") for c in dafny_input.TableName).decode("utf-16-be")
    output["Key"] = {
        b"".join(ord(c).to_bytes(2, "big") for c in key).decode(
            "utf-16-be"
        ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_AttributeValue(
            value
        )
        for (key, value) in dafny_input.Key.items
    }
    if dafny_input.AttributesToGet.is_Some:
        output["AttributesToGet"] = [
            b"".join(ord(c).to_bytes(2, "big") for c in list_element).decode("utf-16-be")
            for list_element in dafny_input.AttributesToGet.value
        ]

    if dafny_input.ConsistentRead.is_Some:
        output["ConsistentRead"] = dafny_input.ConsistentRead.value

    if dafny_input.ReturnConsumedCapacity.is_Some:
        output["ReturnConsumedCapacity"] = (
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_ReturnConsumedCapacity(
                dafny_input.ReturnConsumedCapacity.value
            )
        )

    if dafny_input.ProjectionExpression.is_Some:
        output["ProjectionExpression"] = b"".join(
            ord(c).to_bytes(2, "big") for c in dafny_input.ProjectionExpression.value
        ).decode("utf-16-be")

    if dafny_input.ExpressionAttributeNames.is_Some:
        output["ExpressionAttributeNames"] = {
            b"".join(ord(c).to_bytes(2, "big") for c in key)
            .decode("utf-16-be"): b"".join(ord(c).to_bytes(2, "big") for c in value)
            .decode("utf-16-be")
            for (key, value) in dafny_input.ExpressionAttributeNames.value.items
        }

    return output


def com_amazonaws_dynamodb_GetItemOutput(dafny_input):
    output = {}
    if dafny_input.Item.is_Some:
        output["Item"] = {
            b"".join(ord(c).to_bytes(2, "big") for c in key).decode(
                "utf-16-be"
            ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_AttributeValue(
                value
            )
            for (key, value) in dafny_input.Item.value.items
        }

    if dafny_input.ConsumedCapacity.is_Some:
        output["ConsumedCapacity"] = (
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_ConsumedCapacity(
                dafny_input.ConsumedCapacity.value
            )
        )

    return output


def com_amazonaws_dynamodb_WriteRequest(dafny_input):
    output = {}
    if dafny_input.PutRequest.is_Some:
        output["PutRequest"] = (
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_PutRequest(
                dafny_input.PutRequest.value
            )
        )

    if dafny_input.DeleteRequest.is_Some:
        output["DeleteRequest"] = (
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_DeleteRequest(
                dafny_input.DeleteRequest.value
            )
        )

    return output


def com_amazonaws_dynamodb_PutRequest(dafny_input):
    output = {}
    output["Item"] = {
        b"".join(ord(c).to_bytes(2, "big") for c in key).decode(
            "utf-16-be"
        ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_AttributeValue(
            value
        )
        for (key, value) in dafny_input.Item.items
    }
    return output


def com_amazonaws_dynamodb_DeleteRequest(dafny_input):
    output = {}
    output["Key"] = {
        b"".join(ord(c).to_bytes(2, "big") for c in key).decode(
            "utf-16-be"
        ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_AttributeValue(
            value
        )
        for (key, value) in dafny_input.Key.items
    }
    return output


def com_amazonaws_dynamodb_BatchWriteItemInput(dafny_input):
    output = {}
    output["RequestItems"] = {
        b"".join(ord(c).to_bytes(2, "big") for c in key).decode("utf-16-be"): [
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_WriteRequest(
                list_element
            )
            for list_element in value
        ]
        for (key, value) in dafny_input.RequestItems.items
    }
    if dafny_input.ReturnConsumedCapacity.is_Some:
        output["ReturnConsumedCapacity"] = (
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_ReturnConsumedCapacity(
                dafny_input.ReturnConsumedCapacity.value
            )
        )

    if dafny_input.ReturnItemCollectionMetrics.is_Some:
        output["ReturnItemCollectionMetrics"] = (
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_ReturnItemCollectionMetrics(
                dafny_input.ReturnItemCollectionMetrics.value
            )
        )

    return output


def com_amazonaws_dynamodb_BatchWriteItemOutput(dafny_input):
    output = {}
    if dafny_input.UnprocessedItems.is_Some:
        output["UnprocessedItems"] = {
            b"".join(ord(c).to_bytes(2, "big") for c in key).decode("utf-16-be"): [
                aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_WriteRequest(
                    list_element
                )
                for list_element in value
            ]
            for (key, value) in dafny_input.UnprocessedItems.value.items
        }

    if dafny_input.ItemCollectionMetrics.is_Some:
        output["ItemCollectionMetrics"] = {
            b"".join(ord(c).to_bytes(2, "big") for c in key).decode("utf-16-be"): [
                aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_ItemCollectionMetrics(
                    list_element
                )
                for list_element in value
            ]
            for (key, value) in dafny_input.ItemCollectionMetrics.value.items
        }

    if dafny_input.ConsumedCapacity.is_Some:
        output["ConsumedCapacity"] = [
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_ConsumedCapacity(
                list_element
            )
            for list_element in dafny_input.ConsumedCapacity.value
        ]

    return output


def com_amazonaws_dynamodb_KeysAndAttributes(dafny_input):
    output = {}
    output["Keys"] = [
        {
            b"".join(ord(c).to_bytes(2, "big") for c in key).decode(
                "utf-16-be"
            ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_AttributeValue(
                value
            )
            for (key, value) in list_element.items
        }
        for list_element in dafny_input.Keys
    ]
    if dafny_input.AttributesToGet.is_Some:
        output["AttributesToGet"] = [
            b"".join(ord(c).to_bytes(2, "big") for c in list_element).decode("utf-16-be")
            for list_element in dafny_input.AttributesToGet.value
        ]

    if dafny_input.ConsistentRead.is_Some:
        output["ConsistentRead"] = dafny_input.ConsistentRead.value

    if dafny_input.ProjectionExpression.is_Some:
        output["ProjectionExpression"] = b"".join(
            ord(c).to_bytes(2, "big") for c in dafny_input.ProjectionExpression.value
        ).decode("utf-16-be")

    if dafny_input.ExpressionAttributeNames.is_Some:
        output["ExpressionAttributeNames"] = {
            b"".join(ord(c).to_bytes(2, "big") for c in key)
            .decode("utf-16-be"): b"".join(ord(c).to_bytes(2, "big") for c in value)
            .decode("utf-16-be")
            for (key, value) in dafny_input.ExpressionAttributeNames.value.items
        }

    return output


def com_amazonaws_dynamodb_BatchGetItemInput(dafny_input):
    output = {}
    output["RequestItems"] = {
        b"".join(ord(c).to_bytes(2, "big") for c in key).decode(
            "utf-16-be"
        ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_KeysAndAttributes(
            value
        )
        for (key, value) in dafny_input.RequestItems.items
    }
    if dafny_input.ReturnConsumedCapacity.is_Some:
        output["ReturnConsumedCapacity"] = (
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_ReturnConsumedCapacity(
                dafny_input.ReturnConsumedCapacity.value
            )
        )

    return output


def com_amazonaws_dynamodb_BatchGetItemOutput(dafny_input):
    output = {}
    if dafny_input.Responses.is_Some:
        output["Responses"] = {
            b"".join(ord(c).to_bytes(2, "big") for c in key).decode("utf-16-be"): [
                {
                    b"".join(ord(c).to_bytes(2, "big") for c in key).decode(
                        "utf-16-be"
                    ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_AttributeValue(
                        value
                    )
                    for (key, value) in list_element.items
                }
                for list_element in value
            ]
            for (key, value) in dafny_input.Responses.value.items
        }

    if dafny_input.UnprocessedKeys.is_Some:
        output["UnprocessedKeys"] = {
            b"".join(ord(c).to_bytes(2, "big") for c in key).decode(
                "utf-16-be"
            ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_KeysAndAttributes(
                value
            )
            for (key, value) in dafny_input.UnprocessedKeys.value.items
        }

    if dafny_input.ConsumedCapacity.is_Some:
        output["ConsumedCapacity"] = [
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_ConsumedCapacity(
                list_element
            )
            for list_element in dafny_input.ConsumedCapacity.value
        ]

    return output


def com_amazonaws_dynamodb_Select(dafny_input):
    # Convert Select
    if isinstance(dafny_input, Select_ALL__ATTRIBUTES):
        return "ALL_ATTRIBUTES"

    elif isinstance(dafny_input, Select_ALL__PROJECTED__ATTRIBUTES):
        return "ALL_PROJECTED_ATTRIBUTES"

    elif isinstance(dafny_input, Select_SPECIFIC__ATTRIBUTES):
        return "SPECIFIC_ATTRIBUTES"

    elif isinstance(dafny_input, Select_COUNT):
        return "COUNT"

    else:
        raise ValueError("No recognized enum value in enum type: " + dafny_input)


def com_amazonaws_dynamodb_Condition(dafny_input):
    output = {}
    if dafny_input.AttributeValueList.is_Some:
        output["AttributeValueList"] = [
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_AttributeValue(
                list_element
            )
            for list_element in dafny_input.AttributeValueList.value
        ]

    output["ComparisonOperator"] = (
        aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_ComparisonOperator(
            dafny_input.ComparisonOperator
        )
    )
    return output


def com_amazonaws_dynamodb_ScanInput(dafny_input):
    output = {}
    output["TableName"] = b"".join(ord(c).to_bytes(2, "big") for c in dafny_input.TableName).decode("utf-16-be")
    if dafny_input.IndexName.is_Some:
        output["IndexName"] = b"".join(ord(c).to_bytes(2, "big") for c in dafny_input.IndexName.value).decode(
            "utf-16-be"
        )

    if dafny_input.AttributesToGet.is_Some:
        output["AttributesToGet"] = [
            b"".join(ord(c).to_bytes(2, "big") for c in list_element).decode("utf-16-be")
            for list_element in dafny_input.AttributesToGet.value
        ]

    if dafny_input.Limit.is_Some:
        output["Limit"] = dafny_input.Limit.value

    if dafny_input.Select.is_Some:
        output["Select"] = (
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_Select(
                dafny_input.Select.value
            )
        )

    if dafny_input.ScanFilter.is_Some:
        output["ScanFilter"] = {
            b"".join(ord(c).to_bytes(2, "big") for c in key).decode(
                "utf-16-be"
            ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_Condition(
                value
            )
            for (key, value) in dafny_input.ScanFilter.value.items
        }

    if dafny_input.ConditionalOperator.is_Some:
        output["ConditionalOperator"] = (
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_ConditionalOperator(
                dafny_input.ConditionalOperator.value
            )
        )

    if dafny_input.ExclusiveStartKey.is_Some:
        output["ExclusiveStartKey"] = {
            b"".join(ord(c).to_bytes(2, "big") for c in key).decode(
                "utf-16-be"
            ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_AttributeValue(
                value
            )
            for (key, value) in dafny_input.ExclusiveStartKey.value.items
        }

    if dafny_input.ReturnConsumedCapacity.is_Some:
        output["ReturnConsumedCapacity"] = (
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_ReturnConsumedCapacity(
                dafny_input.ReturnConsumedCapacity.value
            )
        )

    if dafny_input.TotalSegments.is_Some:
        output["TotalSegments"] = dafny_input.TotalSegments.value

    if dafny_input.Segment.is_Some:
        output["Segment"] = dafny_input.Segment.value

    if dafny_input.ProjectionExpression.is_Some:
        output["ProjectionExpression"] = b"".join(
            ord(c).to_bytes(2, "big") for c in dafny_input.ProjectionExpression.value
        ).decode("utf-16-be")

    if dafny_input.FilterExpression.is_Some:
        output["FilterExpression"] = b"".join(
            ord(c).to_bytes(2, "big") for c in dafny_input.FilterExpression.value
        ).decode("utf-16-be")

    if dafny_input.ExpressionAttributeNames.is_Some:
        output["ExpressionAttributeNames"] = {
            b"".join(ord(c).to_bytes(2, "big") for c in key)
            .decode("utf-16-be"): b"".join(ord(c).to_bytes(2, "big") for c in value)
            .decode("utf-16-be")
            for (key, value) in dafny_input.ExpressionAttributeNames.value.items
        }

    if dafny_input.ExpressionAttributeValues.is_Some:
        output["ExpressionAttributeValues"] = {
            b"".join(ord(c).to_bytes(2, "big") for c in key).decode(
                "utf-16-be"
            ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_AttributeValue(
                value
            )
            for (key, value) in dafny_input.ExpressionAttributeValues.value.items
        }

    if dafny_input.ConsistentRead.is_Some:
        output["ConsistentRead"] = dafny_input.ConsistentRead.value

    return output


def com_amazonaws_dynamodb_ScanOutput(dafny_input):
    output = {}
    if dafny_input.Items.is_Some:
        output["Items"] = [
            {
                b"".join(ord(c).to_bytes(2, "big") for c in key).decode(
                    "utf-16-be"
                ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_AttributeValue(
                    value
                )
                for (key, value) in list_element.items
            }
            for list_element in dafny_input.Items.value
        ]

    if dafny_input.Count.is_Some:
        output["Count"] = dafny_input.Count.value

    if dafny_input.ScannedCount.is_Some:
        output["ScannedCount"] = dafny_input.ScannedCount.value

    if dafny_input.LastEvaluatedKey.is_Some:
        output["LastEvaluatedKey"] = {
            b"".join(ord(c).to_bytes(2, "big") for c in key).decode(
                "utf-16-be"
            ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_AttributeValue(
                value
            )
            for (key, value) in dafny_input.LastEvaluatedKey.value.items
        }

    if dafny_input.ConsumedCapacity.is_Some:
        output["ConsumedCapacity"] = (
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_ConsumedCapacity(
                dafny_input.ConsumedCapacity.value
            )
        )

    return output


def com_amazonaws_dynamodb_QueryInput(dafny_input):
    output = {}
    output["TableName"] = b"".join(ord(c).to_bytes(2, "big") for c in dafny_input.TableName).decode("utf-16-be")
    if dafny_input.IndexName.is_Some:
        output["IndexName"] = b"".join(ord(c).to_bytes(2, "big") for c in dafny_input.IndexName.value).decode(
            "utf-16-be"
        )

    if dafny_input.Select.is_Some:
        output["Select"] = (
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_Select(
                dafny_input.Select.value
            )
        )

    if dafny_input.AttributesToGet.is_Some:
        output["AttributesToGet"] = [
            b"".join(ord(c).to_bytes(2, "big") for c in list_element).decode("utf-16-be")
            for list_element in dafny_input.AttributesToGet.value
        ]

    if dafny_input.Limit.is_Some:
        output["Limit"] = dafny_input.Limit.value

    if dafny_input.ConsistentRead.is_Some:
        output["ConsistentRead"] = dafny_input.ConsistentRead.value

    if dafny_input.KeyConditions.is_Some:
        output["KeyConditions"] = {
            b"".join(ord(c).to_bytes(2, "big") for c in key).decode(
                "utf-16-be"
            ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_Condition(
                value
            )
            for (key, value) in dafny_input.KeyConditions.value.items
        }

    if dafny_input.QueryFilter.is_Some:
        output["QueryFilter"] = {
            b"".join(ord(c).to_bytes(2, "big") for c in key).decode(
                "utf-16-be"
            ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_Condition(
                value
            )
            for (key, value) in dafny_input.QueryFilter.value.items
        }

    if dafny_input.ConditionalOperator.is_Some:
        output["ConditionalOperator"] = (
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_ConditionalOperator(
                dafny_input.ConditionalOperator.value
            )
        )

    if dafny_input.ScanIndexForward.is_Some:
        output["ScanIndexForward"] = dafny_input.ScanIndexForward.value

    if dafny_input.ExclusiveStartKey.is_Some:
        output["ExclusiveStartKey"] = {
            b"".join(ord(c).to_bytes(2, "big") for c in key).decode(
                "utf-16-be"
            ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_AttributeValue(
                value
            )
            for (key, value) in dafny_input.ExclusiveStartKey.value.items
        }

    if dafny_input.ReturnConsumedCapacity.is_Some:
        output["ReturnConsumedCapacity"] = (
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_ReturnConsumedCapacity(
                dafny_input.ReturnConsumedCapacity.value
            )
        )

    if dafny_input.ProjectionExpression.is_Some:
        output["ProjectionExpression"] = b"".join(
            ord(c).to_bytes(2, "big") for c in dafny_input.ProjectionExpression.value
        ).decode("utf-16-be")

    if dafny_input.FilterExpression.is_Some:
        output["FilterExpression"] = b"".join(
            ord(c).to_bytes(2, "big") for c in dafny_input.FilterExpression.value
        ).decode("utf-16-be")

    if dafny_input.KeyConditionExpression.is_Some:
        output["KeyConditionExpression"] = b"".join(
            ord(c).to_bytes(2, "big") for c in dafny_input.KeyConditionExpression.value
        ).decode("utf-16-be")

    if dafny_input.ExpressionAttributeNames.is_Some:
        output["ExpressionAttributeNames"] = {
            b"".join(ord(c).to_bytes(2, "big") for c in key)
            .decode("utf-16-be"): b"".join(ord(c).to_bytes(2, "big") for c in value)
            .decode("utf-16-be")
            for (key, value) in dafny_input.ExpressionAttributeNames.value.items
        }

    if dafny_input.ExpressionAttributeValues.is_Some:
        output["ExpressionAttributeValues"] = {
            b"".join(ord(c).to_bytes(2, "big") for c in key).decode(
                "utf-16-be"
            ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_AttributeValue(
                value
            )
            for (key, value) in dafny_input.ExpressionAttributeValues.value.items
        }

    return output


def com_amazonaws_dynamodb_QueryOutput(dafny_input):
    output = {}
    if dafny_input.Items.is_Some:
        output["Items"] = [
            {
                b"".join(ord(c).to_bytes(2, "big") for c in key).decode(
                    "utf-16-be"
                ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_AttributeValue(
                    value
                )
                for (key, value) in list_element.items
            }
            for list_element in dafny_input.Items.value
        ]

    if dafny_input.Count.is_Some:
        output["Count"] = dafny_input.Count.value

    if dafny_input.ScannedCount.is_Some:
        output["ScannedCount"] = dafny_input.ScannedCount.value

    if dafny_input.LastEvaluatedKey.is_Some:
        output["LastEvaluatedKey"] = {
            b"".join(ord(c).to_bytes(2, "big") for c in key).decode(
                "utf-16-be"
            ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_AttributeValue(
                value
            )
            for (key, value) in dafny_input.LastEvaluatedKey.value.items
        }

    if dafny_input.ConsumedCapacity.is_Some:
        output["ConsumedCapacity"] = (
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_ConsumedCapacity(
                dafny_input.ConsumedCapacity.value
            )
        )

    return output


def com_amazonaws_dynamodb_TransactWriteItem(dafny_input):
    output = {}
    if dafny_input.ConditionCheck.is_Some:
        output["ConditionCheck"] = (
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_ConditionCheck(
                dafny_input.ConditionCheck.value
            )
        )

    if dafny_input.Put.is_Some:
        output["Put"] = (
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_Put(
                dafny_input.Put.value
            )
        )

    if dafny_input.Delete.is_Some:
        output["Delete"] = (
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_Delete(
                dafny_input.Delete.value
            )
        )

    if dafny_input.Update.is_Some:
        output["Update"] = (
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_Update(
                dafny_input.Update.value
            )
        )

    return output


def com_amazonaws_dynamodb_ConditionCheck(dafny_input):
    output = {}
    output["Key"] = {
        b"".join(ord(c).to_bytes(2, "big") for c in key).decode(
            "utf-16-be"
        ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_AttributeValue(
            value
        )
        for (key, value) in dafny_input.Key.items
    }
    output["TableName"] = b"".join(ord(c).to_bytes(2, "big") for c in dafny_input.TableName).decode("utf-16-be")
    output["ConditionExpression"] = b"".join(ord(c).to_bytes(2, "big") for c in dafny_input.ConditionExpression).decode(
        "utf-16-be"
    )
    if dafny_input.ExpressionAttributeNames.is_Some:
        output["ExpressionAttributeNames"] = {
            b"".join(ord(c).to_bytes(2, "big") for c in key)
            .decode("utf-16-be"): b"".join(ord(c).to_bytes(2, "big") for c in value)
            .decode("utf-16-be")
            for (key, value) in dafny_input.ExpressionAttributeNames.value.items
        }

    if dafny_input.ExpressionAttributeValues.is_Some:
        output["ExpressionAttributeValues"] = {
            b"".join(ord(c).to_bytes(2, "big") for c in key).decode(
                "utf-16-be"
            ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_AttributeValue(
                value
            )
            for (key, value) in dafny_input.ExpressionAttributeValues.value.items
        }

    if dafny_input.ReturnValuesOnConditionCheckFailure.is_Some:
        output["ReturnValuesOnConditionCheckFailure"] = (
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_ReturnValuesOnConditionCheckFailure(
                dafny_input.ReturnValuesOnConditionCheckFailure.value
            )
        )

    return output


def com_amazonaws_dynamodb_Put(dafny_input):
    output = {}
    output["Item"] = {
        b"".join(ord(c).to_bytes(2, "big") for c in key).decode(
            "utf-16-be"
        ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_AttributeValue(
            value
        )
        for (key, value) in dafny_input.Item.items
    }
    output["TableName"] = b"".join(ord(c).to_bytes(2, "big") for c in dafny_input.TableName).decode("utf-16-be")
    if dafny_input.ConditionExpression.is_Some:
        output["ConditionExpression"] = b"".join(
            ord(c).to_bytes(2, "big") for c in dafny_input.ConditionExpression.value
        ).decode("utf-16-be")

    if dafny_input.ExpressionAttributeNames.is_Some:
        output["ExpressionAttributeNames"] = {
            b"".join(ord(c).to_bytes(2, "big") for c in key)
            .decode("utf-16-be"): b"".join(ord(c).to_bytes(2, "big") for c in value)
            .decode("utf-16-be")
            for (key, value) in dafny_input.ExpressionAttributeNames.value.items
        }

    if dafny_input.ExpressionAttributeValues.is_Some:
        output["ExpressionAttributeValues"] = {
            b"".join(ord(c).to_bytes(2, "big") for c in key).decode(
                "utf-16-be"
            ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_AttributeValue(
                value
            )
            for (key, value) in dafny_input.ExpressionAttributeValues.value.items
        }

    if dafny_input.ReturnValuesOnConditionCheckFailure.is_Some:
        output["ReturnValuesOnConditionCheckFailure"] = (
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_ReturnValuesOnConditionCheckFailure(
                dafny_input.ReturnValuesOnConditionCheckFailure.value
            )
        )

    return output


def com_amazonaws_dynamodb_Delete(dafny_input):
    output = {}
    output["Key"] = {
        b"".join(ord(c).to_bytes(2, "big") for c in key).decode(
            "utf-16-be"
        ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_AttributeValue(
            value
        )
        for (key, value) in dafny_input.Key.items
    }
    output["TableName"] = b"".join(ord(c).to_bytes(2, "big") for c in dafny_input.TableName).decode("utf-16-be")
    if dafny_input.ConditionExpression.is_Some:
        output["ConditionExpression"] = b"".join(
            ord(c).to_bytes(2, "big") for c in dafny_input.ConditionExpression.value
        ).decode("utf-16-be")

    if dafny_input.ExpressionAttributeNames.is_Some:
        output["ExpressionAttributeNames"] = {
            b"".join(ord(c).to_bytes(2, "big") for c in key)
            .decode("utf-16-be"): b"".join(ord(c).to_bytes(2, "big") for c in value)
            .decode("utf-16-be")
            for (key, value) in dafny_input.ExpressionAttributeNames.value.items
        }

    if dafny_input.ExpressionAttributeValues.is_Some:
        output["ExpressionAttributeValues"] = {
            b"".join(ord(c).to_bytes(2, "big") for c in key).decode(
                "utf-16-be"
            ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_AttributeValue(
                value
            )
            for (key, value) in dafny_input.ExpressionAttributeValues.value.items
        }

    if dafny_input.ReturnValuesOnConditionCheckFailure.is_Some:
        output["ReturnValuesOnConditionCheckFailure"] = (
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_ReturnValuesOnConditionCheckFailure(
                dafny_input.ReturnValuesOnConditionCheckFailure.value
            )
        )

    return output


def com_amazonaws_dynamodb_Update(dafny_input):
    output = {}
    output["Key"] = {
        b"".join(ord(c).to_bytes(2, "big") for c in key).decode(
            "utf-16-be"
        ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_AttributeValue(
            value
        )
        for (key, value) in dafny_input.Key.items
    }
    output["UpdateExpression"] = b"".join(ord(c).to_bytes(2, "big") for c in dafny_input.UpdateExpression).decode(
        "utf-16-be"
    )
    output["TableName"] = b"".join(ord(c).to_bytes(2, "big") for c in dafny_input.TableName).decode("utf-16-be")
    if dafny_input.ConditionExpression.is_Some:
        output["ConditionExpression"] = b"".join(
            ord(c).to_bytes(2, "big") for c in dafny_input.ConditionExpression.value
        ).decode("utf-16-be")

    if dafny_input.ExpressionAttributeNames.is_Some:
        output["ExpressionAttributeNames"] = {
            b"".join(ord(c).to_bytes(2, "big") for c in key)
            .decode("utf-16-be"): b"".join(ord(c).to_bytes(2, "big") for c in value)
            .decode("utf-16-be")
            for (key, value) in dafny_input.ExpressionAttributeNames.value.items
        }

    if dafny_input.ExpressionAttributeValues.is_Some:
        output["ExpressionAttributeValues"] = {
            b"".join(ord(c).to_bytes(2, "big") for c in key).decode(
                "utf-16-be"
            ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_AttributeValue(
                value
            )
            for (key, value) in dafny_input.ExpressionAttributeValues.value.items
        }

    if dafny_input.ReturnValuesOnConditionCheckFailure.is_Some:
        output["ReturnValuesOnConditionCheckFailure"] = (
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_ReturnValuesOnConditionCheckFailure(
                dafny_input.ReturnValuesOnConditionCheckFailure.value
            )
        )

    return output


def com_amazonaws_dynamodb_TransactWriteItemsInput(dafny_input):
    output = {}
    output["TransactItems"] = [
        aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_TransactWriteItem(
            list_element
        )
        for list_element in dafny_input.TransactItems
    ]
    if dafny_input.ReturnConsumedCapacity.is_Some:
        output["ReturnConsumedCapacity"] = (
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_ReturnConsumedCapacity(
                dafny_input.ReturnConsumedCapacity.value
            )
        )

    if dafny_input.ReturnItemCollectionMetrics.is_Some:
        output["ReturnItemCollectionMetrics"] = (
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_ReturnItemCollectionMetrics(
                dafny_input.ReturnItemCollectionMetrics.value
            )
        )

    if dafny_input.ClientRequestToken.is_Some:
        output["ClientRequestToken"] = b"".join(
            ord(c).to_bytes(2, "big") for c in dafny_input.ClientRequestToken.value
        ).decode("utf-16-be")

    return output


def com_amazonaws_dynamodb_TransactWriteItemsOutput(dafny_input):
    output = {}
    if dafny_input.ConsumedCapacity.is_Some:
        output["ConsumedCapacity"] = [
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_ConsumedCapacity(
                list_element
            )
            for list_element in dafny_input.ConsumedCapacity.value
        ]

    if dafny_input.ItemCollectionMetrics.is_Some:
        output["ItemCollectionMetrics"] = {
            b"".join(ord(c).to_bytes(2, "big") for c in key).decode("utf-16-be"): [
                aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_ItemCollectionMetrics(
                    list_element
                )
                for list_element in value
            ]
            for (key, value) in dafny_input.ItemCollectionMetrics.value.items
        }

    return output


def com_amazonaws_dynamodb_AttributeValueUpdate(dafny_input):
    output = {}
    if dafny_input.Value.is_Some:
        output["Value"] = (
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_AttributeValue(
                dafny_input.Value.value
            )
        )

    if dafny_input.Action.is_Some:
        output["Action"] = (
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_AttributeAction(
                dafny_input.Action.value
            )
        )

    return output


def com_amazonaws_dynamodb_AttributeAction(dafny_input):
    # Convert AttributeAction
    if isinstance(dafny_input, AttributeAction_ADD):
        return "ADD"

    elif isinstance(dafny_input, AttributeAction_PUT):
        return "PUT"

    elif isinstance(dafny_input, AttributeAction_DELETE):
        return "DELETE"

    else:
        raise ValueError("No recognized enum value in enum type: " + dafny_input)


def com_amazonaws_dynamodb_UpdateItemInput(dafny_input):
    output = {}
    output["TableName"] = b"".join(ord(c).to_bytes(2, "big") for c in dafny_input.TableName).decode("utf-16-be")
    output["Key"] = {
        b"".join(ord(c).to_bytes(2, "big") for c in key).decode(
            "utf-16-be"
        ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_AttributeValue(
            value
        )
        for (key, value) in dafny_input.Key.items
    }
    if dafny_input.AttributeUpdates.is_Some:
        output["AttributeUpdates"] = {
            b"".join(ord(c).to_bytes(2, "big") for c in key).decode(
                "utf-16-be"
            ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_AttributeValueUpdate(
                value
            )
            for (key, value) in dafny_input.AttributeUpdates.value.items
        }

    if dafny_input.Expected.is_Some:
        output["Expected"] = {
            b"".join(ord(c).to_bytes(2, "big") for c in key).decode(
                "utf-16-be"
            ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_ExpectedAttributeValue(
                value
            )
            for (key, value) in dafny_input.Expected.value.items
        }

    if dafny_input.ConditionalOperator.is_Some:
        output["ConditionalOperator"] = (
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_ConditionalOperator(
                dafny_input.ConditionalOperator.value
            )
        )

    if dafny_input.ReturnValues.is_Some:
        output["ReturnValues"] = (
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_ReturnValue(
                dafny_input.ReturnValues.value
            )
        )

    if dafny_input.ReturnConsumedCapacity.is_Some:
        output["ReturnConsumedCapacity"] = (
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_ReturnConsumedCapacity(
                dafny_input.ReturnConsumedCapacity.value
            )
        )

    if dafny_input.ReturnItemCollectionMetrics.is_Some:
        output["ReturnItemCollectionMetrics"] = (
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_ReturnItemCollectionMetrics(
                dafny_input.ReturnItemCollectionMetrics.value
            )
        )

    if dafny_input.UpdateExpression.is_Some:
        output["UpdateExpression"] = b"".join(
            ord(c).to_bytes(2, "big") for c in dafny_input.UpdateExpression.value
        ).decode("utf-16-be")

    if dafny_input.ConditionExpression.is_Some:
        output["ConditionExpression"] = b"".join(
            ord(c).to_bytes(2, "big") for c in dafny_input.ConditionExpression.value
        ).decode("utf-16-be")

    if dafny_input.ExpressionAttributeNames.is_Some:
        output["ExpressionAttributeNames"] = {
            b"".join(ord(c).to_bytes(2, "big") for c in key)
            .decode("utf-16-be"): b"".join(ord(c).to_bytes(2, "big") for c in value)
            .decode("utf-16-be")
            for (key, value) in dafny_input.ExpressionAttributeNames.value.items
        }

    if dafny_input.ExpressionAttributeValues.is_Some:
        output["ExpressionAttributeValues"] = {
            b"".join(ord(c).to_bytes(2, "big") for c in key).decode(
                "utf-16-be"
            ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_AttributeValue(
                value
            )
            for (key, value) in dafny_input.ExpressionAttributeValues.value.items
        }

    if dafny_input.ReturnValuesOnConditionCheckFailure.is_Some:
        output["ReturnValuesOnConditionCheckFailure"] = (
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_ReturnValuesOnConditionCheckFailure(
                dafny_input.ReturnValuesOnConditionCheckFailure.value
            )
        )

    return output


def com_amazonaws_dynamodb_UpdateItemOutput(dafny_input):
    output = {}
    if dafny_input.Attributes.is_Some:
        output["Attributes"] = {
            b"".join(ord(c).to_bytes(2, "big") for c in key).decode(
                "utf-16-be"
            ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_AttributeValue(
                value
            )
            for (key, value) in dafny_input.Attributes.value.items
        }

    if dafny_input.ConsumedCapacity.is_Some:
        output["ConsumedCapacity"] = (
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_ConsumedCapacity(
                dafny_input.ConsumedCapacity.value
            )
        )

    if dafny_input.ItemCollectionMetrics.is_Some:
        output["ItemCollectionMetrics"] = (
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_ItemCollectionMetrics(
                dafny_input.ItemCollectionMetrics.value
            )
        )

    return output


def com_amazonaws_dynamodb_DeleteItemInput(dafny_input):
    output = {}
    output["TableName"] = b"".join(ord(c).to_bytes(2, "big") for c in dafny_input.TableName).decode("utf-16-be")
    output["Key"] = {
        b"".join(ord(c).to_bytes(2, "big") for c in key).decode(
            "utf-16-be"
        ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_AttributeValue(
            value
        )
        for (key, value) in dafny_input.Key.items
    }
    if dafny_input.Expected.is_Some:
        output["Expected"] = {
            b"".join(ord(c).to_bytes(2, "big") for c in key).decode(
                "utf-16-be"
            ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_ExpectedAttributeValue(
                value
            )
            for (key, value) in dafny_input.Expected.value.items
        }

    if dafny_input.ConditionalOperator.is_Some:
        output["ConditionalOperator"] = (
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_ConditionalOperator(
                dafny_input.ConditionalOperator.value
            )
        )

    if dafny_input.ReturnValues.is_Some:
        output["ReturnValues"] = (
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_ReturnValue(
                dafny_input.ReturnValues.value
            )
        )

    if dafny_input.ReturnConsumedCapacity.is_Some:
        output["ReturnConsumedCapacity"] = (
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_ReturnConsumedCapacity(
                dafny_input.ReturnConsumedCapacity.value
            )
        )

    if dafny_input.ReturnItemCollectionMetrics.is_Some:
        output["ReturnItemCollectionMetrics"] = (
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_ReturnItemCollectionMetrics(
                dafny_input.ReturnItemCollectionMetrics.value
            )
        )

    if dafny_input.ConditionExpression.is_Some:
        output["ConditionExpression"] = b"".join(
            ord(c).to_bytes(2, "big") for c in dafny_input.ConditionExpression.value
        ).decode("utf-16-be")

    if dafny_input.ExpressionAttributeNames.is_Some:
        output["ExpressionAttributeNames"] = {
            b"".join(ord(c).to_bytes(2, "big") for c in key)
            .decode("utf-16-be"): b"".join(ord(c).to_bytes(2, "big") for c in value)
            .decode("utf-16-be")
            for (key, value) in dafny_input.ExpressionAttributeNames.value.items
        }

    if dafny_input.ExpressionAttributeValues.is_Some:
        output["ExpressionAttributeValues"] = {
            b"".join(ord(c).to_bytes(2, "big") for c in key).decode(
                "utf-16-be"
            ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_AttributeValue(
                value
            )
            for (key, value) in dafny_input.ExpressionAttributeValues.value.items
        }

    if dafny_input.ReturnValuesOnConditionCheckFailure.is_Some:
        output["ReturnValuesOnConditionCheckFailure"] = (
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_ReturnValuesOnConditionCheckFailure(
                dafny_input.ReturnValuesOnConditionCheckFailure.value
            )
        )

    return output


def com_amazonaws_dynamodb_DeleteItemOutput(dafny_input):
    output = {}
    if dafny_input.Attributes.is_Some:
        output["Attributes"] = {
            b"".join(ord(c).to_bytes(2, "big") for c in key).decode(
                "utf-16-be"
            ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_AttributeValue(
                value
            )
            for (key, value) in dafny_input.Attributes.value.items
        }

    if dafny_input.ConsumedCapacity.is_Some:
        output["ConsumedCapacity"] = (
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_ConsumedCapacity(
                dafny_input.ConsumedCapacity.value
            )
        )

    if dafny_input.ItemCollectionMetrics.is_Some:
        output["ItemCollectionMetrics"] = (
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_ItemCollectionMetrics(
                dafny_input.ItemCollectionMetrics.value
            )
        )

    return output


def com_amazonaws_dynamodb_TransactGetItem(dafny_input):
    output = {}
    output["Get"] = (
        aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_Get(
            dafny_input.Get
        )
    )
    return output


def com_amazonaws_dynamodb_Get(dafny_input):
    output = {}
    output["Key"] = {
        b"".join(ord(c).to_bytes(2, "big") for c in key).decode(
            "utf-16-be"
        ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_AttributeValue(
            value
        )
        for (key, value) in dafny_input.Key.items
    }
    output["TableName"] = b"".join(ord(c).to_bytes(2, "big") for c in dafny_input.TableName).decode("utf-16-be")
    if dafny_input.ProjectionExpression.is_Some:
        output["ProjectionExpression"] = b"".join(
            ord(c).to_bytes(2, "big") for c in dafny_input.ProjectionExpression.value
        ).decode("utf-16-be")

    if dafny_input.ExpressionAttributeNames.is_Some:
        output["ExpressionAttributeNames"] = {
            b"".join(ord(c).to_bytes(2, "big") for c in key)
            .decode("utf-16-be"): b"".join(ord(c).to_bytes(2, "big") for c in value)
            .decode("utf-16-be")
            for (key, value) in dafny_input.ExpressionAttributeNames.value.items
        }

    return output


def com_amazonaws_dynamodb_TransactGetItemsInput(dafny_input):
    output = {}
    output["TransactItems"] = [
        aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_TransactGetItem(
            list_element
        )
        for list_element in dafny_input.TransactItems
    ]
    if dafny_input.ReturnConsumedCapacity.is_Some:
        output["ReturnConsumedCapacity"] = (
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_ReturnConsumedCapacity(
                dafny_input.ReturnConsumedCapacity.value
            )
        )

    return output


def com_amazonaws_dynamodb_ItemResponse(dafny_input):
    output = {}
    if dafny_input.Item.is_Some:
        output["Item"] = {
            b"".join(ord(c).to_bytes(2, "big") for c in key).decode(
                "utf-16-be"
            ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_AttributeValue(
                value
            )
            for (key, value) in dafny_input.Item.value.items
        }

    return output


def com_amazonaws_dynamodb_TransactGetItemsOutput(dafny_input):
    output = {}
    if dafny_input.ConsumedCapacity.is_Some:
        output["ConsumedCapacity"] = [
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_ConsumedCapacity(
                list_element
            )
            for list_element in dafny_input.ConsumedCapacity.value
        ]

    if dafny_input.Responses.is_Some:
        output["Responses"] = [
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_ItemResponse(
                list_element
            )
            for list_element in dafny_input.Responses.value
        ]

    return output


def com_amazonaws_dynamodb_ExecuteStatementInput(dafny_input):
    output = {}
    output["Statement"] = b"".join(ord(c).to_bytes(2, "big") for c in dafny_input.Statement).decode("utf-16-be")
    if dafny_input.Parameters.is_Some:
        output["Parameters"] = [
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_AttributeValue(
                list_element
            )
            for list_element in dafny_input.Parameters.value
        ]

    if dafny_input.ConsistentRead.is_Some:
        output["ConsistentRead"] = dafny_input.ConsistentRead.value

    if dafny_input.NextToken.is_Some:
        output["NextToken"] = b"".join(ord(c).to_bytes(2, "big") for c in dafny_input.NextToken.value).decode(
            "utf-16-be"
        )

    if dafny_input.ReturnConsumedCapacity.is_Some:
        output["ReturnConsumedCapacity"] = (
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_ReturnConsumedCapacity(
                dafny_input.ReturnConsumedCapacity.value
            )
        )

    if dafny_input.Limit.is_Some:
        output["Limit"] = dafny_input.Limit.value

    if dafny_input.ReturnValuesOnConditionCheckFailure.is_Some:
        output["ReturnValuesOnConditionCheckFailure"] = (
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_ReturnValuesOnConditionCheckFailure(
                dafny_input.ReturnValuesOnConditionCheckFailure.value
            )
        )

    return output


def com_amazonaws_dynamodb_ExecuteStatementOutput(dafny_input):
    output = {}
    if dafny_input.Items.is_Some:
        output["Items"] = [
            {
                b"".join(ord(c).to_bytes(2, "big") for c in key).decode(
                    "utf-16-be"
                ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_AttributeValue(
                    value
                )
                for (key, value) in list_element.items
            }
            for list_element in dafny_input.Items.value
        ]

    if dafny_input.NextToken.is_Some:
        output["NextToken"] = b"".join(ord(c).to_bytes(2, "big") for c in dafny_input.NextToken.value).decode(
            "utf-16-be"
        )

    if dafny_input.ConsumedCapacity.is_Some:
        output["ConsumedCapacity"] = (
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_ConsumedCapacity(
                dafny_input.ConsumedCapacity.value
            )
        )

    if dafny_input.LastEvaluatedKey.is_Some:
        output["LastEvaluatedKey"] = {
            b"".join(ord(c).to_bytes(2, "big") for c in key).decode(
                "utf-16-be"
            ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_AttributeValue(
                value
            )
            for (key, value) in dafny_input.LastEvaluatedKey.value.items
        }

    return output


def com_amazonaws_dynamodb_BatchStatementRequest(dafny_input):
    output = {}
    output["Statement"] = b"".join(ord(c).to_bytes(2, "big") for c in dafny_input.Statement).decode("utf-16-be")
    if dafny_input.Parameters.is_Some:
        output["Parameters"] = [
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_AttributeValue(
                list_element
            )
            for list_element in dafny_input.Parameters.value
        ]

    if dafny_input.ConsistentRead.is_Some:
        output["ConsistentRead"] = dafny_input.ConsistentRead.value

    if dafny_input.ReturnValuesOnConditionCheckFailure.is_Some:
        output["ReturnValuesOnConditionCheckFailure"] = (
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_ReturnValuesOnConditionCheckFailure(
                dafny_input.ReturnValuesOnConditionCheckFailure.value
            )
        )

    return output


def com_amazonaws_dynamodb_BatchExecuteStatementInput(dafny_input):
    output = {}
    output["Statements"] = [
        aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_BatchStatementRequest(
            list_element
        )
        for list_element in dafny_input.Statements
    ]
    if dafny_input.ReturnConsumedCapacity.is_Some:
        output["ReturnConsumedCapacity"] = (
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_ReturnConsumedCapacity(
                dafny_input.ReturnConsumedCapacity.value
            )
        )

    return output


def com_amazonaws_dynamodb_BatchStatementResponse(dafny_input):
    output = {}
    if dafny_input.Error.is_Some:
        output["Error"] = (
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_BatchStatementError(
                dafny_input.Error.value
            )
        )

    if dafny_input.TableName.is_Some:
        output["TableName"] = b"".join(ord(c).to_bytes(2, "big") for c in dafny_input.TableName.value).decode(
            "utf-16-be"
        )

    if dafny_input.Item.is_Some:
        output["Item"] = {
            b"".join(ord(c).to_bytes(2, "big") for c in key).decode(
                "utf-16-be"
            ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_AttributeValue(
                value
            )
            for (key, value) in dafny_input.Item.value.items
        }

    return output


def com_amazonaws_dynamodb_BatchStatementError(dafny_input):
    output = {}
    if dafny_input.Code.is_Some:
        output["Code"] = (
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_BatchStatementErrorCodeEnum(
                dafny_input.Code.value
            )
        )

    if dafny_input.Message.is_Some:
        output["Message"] = b"".join(ord(c).to_bytes(2, "big") for c in dafny_input.Message.value).decode("utf-16-be")

    if dafny_input.Item.is_Some:
        output["Item"] = {
            b"".join(ord(c).to_bytes(2, "big") for c in key).decode(
                "utf-16-be"
            ): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_AttributeValue(
                value
            )
            for (key, value) in dafny_input.Item.value.items
        }

    return output


def com_amazonaws_dynamodb_BatchStatementErrorCodeEnum(dafny_input):
    # Convert BatchStatementErrorCodeEnum
    if isinstance(dafny_input, BatchStatementErrorCodeEnum_ConditionalCheckFailed):
        return "ConditionalCheckFailed"

    elif isinstance(dafny_input, BatchStatementErrorCodeEnum_ItemCollectionSizeLimitExceeded):
        return "ItemCollectionSizeLimitExceeded"

    elif isinstance(dafny_input, BatchStatementErrorCodeEnum_RequestLimitExceeded):
        return "RequestLimitExceeded"

    elif isinstance(dafny_input, BatchStatementErrorCodeEnum_ValidationError):
        return "ValidationError"

    elif isinstance(dafny_input, BatchStatementErrorCodeEnum_ProvisionedThroughputExceeded):
        return "ProvisionedThroughputExceeded"

    elif isinstance(dafny_input, BatchStatementErrorCodeEnum_TransactionConflict):
        return "TransactionConflict"

    elif isinstance(dafny_input, BatchStatementErrorCodeEnum_ThrottlingError):
        return "ThrottlingError"

    elif isinstance(dafny_input, BatchStatementErrorCodeEnum_InternalServerError):
        return "InternalServerError"

    elif isinstance(dafny_input, BatchStatementErrorCodeEnum_ResourceNotFound):
        return "ResourceNotFound"

    elif isinstance(dafny_input, BatchStatementErrorCodeEnum_AccessDenied):
        return "AccessDenied"

    elif isinstance(dafny_input, BatchStatementErrorCodeEnum_DuplicateItem):
        return "DuplicateItem"

    else:
        raise ValueError("No recognized enum value in enum type: " + dafny_input)


def com_amazonaws_dynamodb_BatchExecuteStatementOutput(dafny_input):
    output = {}
    if dafny_input.Responses.is_Some:
        output["Responses"] = [
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_BatchStatementResponse(
                list_element
            )
            for list_element in dafny_input.Responses.value
        ]

    if dafny_input.ConsumedCapacity.is_Some:
        output["ConsumedCapacity"] = [
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_ConsumedCapacity(
                list_element
            )
            for list_element in dafny_input.ConsumedCapacity.value
        ]

    return output


def com_amazonaws_dynamodb_ParameterizedStatement(dafny_input):
    output = {}
    output["Statement"] = b"".join(ord(c).to_bytes(2, "big") for c in dafny_input.Statement).decode("utf-16-be")
    if dafny_input.Parameters.is_Some:
        output["Parameters"] = [
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_AttributeValue(
                list_element
            )
            for list_element in dafny_input.Parameters.value
        ]

    if dafny_input.ReturnValuesOnConditionCheckFailure.is_Some:
        output["ReturnValuesOnConditionCheckFailure"] = (
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_ReturnValuesOnConditionCheckFailure(
                dafny_input.ReturnValuesOnConditionCheckFailure.value
            )
        )

    return output


def com_amazonaws_dynamodb_ExecuteTransactionInput(dafny_input):
    output = {}
    output["TransactStatements"] = [
        aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_ParameterizedStatement(
            list_element
        )
        for list_element in dafny_input.TransactStatements
    ]
    if dafny_input.ClientRequestToken.is_Some:
        output["ClientRequestToken"] = b"".join(
            ord(c).to_bytes(2, "big") for c in dafny_input.ClientRequestToken.value
        ).decode("utf-16-be")

    if dafny_input.ReturnConsumedCapacity.is_Some:
        output["ReturnConsumedCapacity"] = (
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_ReturnConsumedCapacity(
                dafny_input.ReturnConsumedCapacity.value
            )
        )

    return output


def com_amazonaws_dynamodb_ExecuteTransactionOutput(dafny_input):
    output = {}
    if dafny_input.Responses.is_Some:
        output["Responses"] = [
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_ItemResponse(
                list_element
            )
            for list_element in dafny_input.Responses.value
        ]

    if dafny_input.ConsumedCapacity.is_Some:
        output["ConsumedCapacity"] = [
            aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_ConsumedCapacity(
                list_element
            )
            for list_element in dafny_input.ConsumedCapacity.value
        ]

    return output
