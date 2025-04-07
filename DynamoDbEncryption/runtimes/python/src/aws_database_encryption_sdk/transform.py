# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""Helper tools for translating between native and DynamoDB items.

For information on how types are serializes, see:
https://boto3.amazonaws.com/v1/documentation/api/latest/_modules/boto3/dynamodb/types.html
"""
from typing import Any, Dict

from boto3.dynamodb.types import TypeDeserializer, TypeSerializer

__all__ = ("dict_to_ddb", "ddb_to_dict")


def dict_to_ddb(item: Dict[str, Any]) -> Dict[str, Any]:
    """Converts a native Python dictionary to a DynamoDB-JSON item.

    Args:
        item (Dict[str, Any]): Native Python dictionary.

    Returns:
        Dict[str, Any]: DynamoDB-formatted item.
    """
    serializer = TypeSerializer()
    return {key: serializer.serialize(value) for key, value in item.items()}

def list_of_dict_to_list_of_ddb(items: list[Dict[str, Any]]) -> list[Dict[str, Any]]:
    """Converts a list of Python dictionaries into a list of DynamoDB-JSON formatted items.

    Args:
        items (List[Dict[str, Any]]): List of native Python dictionaries.

    Returns:
        List[Dict[str, Any]]: List of DynamoDB-formatted items.
    """
    return [dict_to_ddb(item) for item in items]

def ddb_to_dict(item: Dict[str, Any]) -> Dict[str, Any]:
    """Converts a DynamoDB-JSON item to a native Python dictionary.

    Args:
        item (Dict[str, Any]): DynamoDB-formatted item.

    Returns:
        Dict[str, Any]: Native Python dictionary.
    """
    deserializer = TypeDeserializer()
    return {key: deserializer.deserialize(value) for key, value in item.items()}

def list_of_ddb_to_list_of_dict(items: list[Dict[str, Any]]) -> list[Dict[str, Any]]:
    """Converts a list of DynamoDB-JSON formatted items to a list of Python dictionaries.

    Args:
        items (List[Dict[str, Any]]): List of DynamoDB-formatted items.

    Returns:
        List[Dict[str, Any]]: List of native Python dictionaries.
    """
    return [ddb_to_dict(item) for item in items]

# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
# Do not modify this file. This file is machine generated, and any changes to it will be overwritten.

import aws_database_encryption_sdk.transform
from boto3.dynamodb.types import TypeSerializer


def com_amazonaws_dynamodb_BackupInUseException(native_input):
    output = {}
    if "message" in native_input:
        output["message"] = native_input["message"]

    return output


def com_amazonaws_dynamodb_BackupNotFoundException(native_input):
    output = {}
    if "message" in native_input:
        output["message"] = native_input["message"]

    return output


def com_amazonaws_dynamodb_ConditionalCheckFailedException(native_input):
    output = {}
    if "message" in native_input:
        output["message"] = native_input["message"]

    if "Item" in native_input:
        output["Item"] = {
            key: TypeSerializer().serialize(value)
            for (key, value) in native_input["Item"].items()
        }

    return output


def com_amazonaws_dynamodb_ContinuousBackupsUnavailableException(native_input):
    output = {}
    if "message" in native_input:
        output["message"] = native_input["message"]

    return output


def com_amazonaws_dynamodb_DuplicateItemException(native_input):
    output = {}
    if "message" in native_input:
        output["message"] = native_input["message"]

    return output


def com_amazonaws_dynamodb_ExportConflictException(native_input):
    output = {}
    if "message" in native_input:
        output["message"] = native_input["message"]

    return output


def com_amazonaws_dynamodb_ExportNotFoundException(native_input):
    output = {}
    if "message" in native_input:
        output["message"] = native_input["message"]

    return output


def com_amazonaws_dynamodb_GlobalTableAlreadyExistsException(native_input):
    output = {}
    if "message" in native_input:
        output["message"] = native_input["message"]

    return output


def com_amazonaws_dynamodb_GlobalTableNotFoundException(native_input):
    output = {}
    if "message" in native_input:
        output["message"] = native_input["message"]

    return output


def com_amazonaws_dynamodb_IdempotentParameterMismatchException(native_input):
    output = {}
    if "Message" in native_input:
        output["Message"] = native_input["Message"]

    return output


def com_amazonaws_dynamodb_ImportConflictException(native_input):
    output = {}
    if "message" in native_input:
        output["message"] = native_input["message"]

    return output


def com_amazonaws_dynamodb_ImportNotFoundException(native_input):
    output = {}
    if "message" in native_input:
        output["message"] = native_input["message"]

    return output


def com_amazonaws_dynamodb_IndexNotFoundException(native_input):
    output = {}
    if "message" in native_input:
        output["message"] = native_input["message"]

    return output


def com_amazonaws_dynamodb_InternalServerError(native_input):
    output = {}
    if "message" in native_input:
        output["message"] = native_input["message"]

    return output


def com_amazonaws_dynamodb_InvalidEndpointException(native_input):
    output = {}
    if "Message" in native_input:
        output["Message"] = native_input["Message"]

    return output


def com_amazonaws_dynamodb_InvalidExportTimeException(native_input):
    output = {}
    if "message" in native_input:
        output["message"] = native_input["message"]

    return output


def com_amazonaws_dynamodb_InvalidRestoreTimeException(native_input):
    output = {}
    if "message" in native_input:
        output["message"] = native_input["message"]

    return output


def com_amazonaws_dynamodb_ItemCollectionSizeLimitExceededException(native_input):
    output = {}
    if "message" in native_input:
        output["message"] = native_input["message"]

    return output


def com_amazonaws_dynamodb_LimitExceededException(native_input):
    output = {}
    if "message" in native_input:
        output["message"] = native_input["message"]

    return output


def com_amazonaws_dynamodb_PointInTimeRecoveryUnavailableException(native_input):
    output = {}
    if "message" in native_input:
        output["message"] = native_input["message"]

    return output


def com_amazonaws_dynamodb_PolicyNotFoundException(native_input):
    output = {}
    if "message" in native_input:
        output["message"] = native_input["message"]

    return output


def com_amazonaws_dynamodb_ProvisionedThroughputExceededException(native_input):
    output = {}
    if "message" in native_input:
        output["message"] = native_input["message"]

    return output


def com_amazonaws_dynamodb_ReplicaAlreadyExistsException(native_input):
    output = {}
    if "message" in native_input:
        output["message"] = native_input["message"]

    return output


def com_amazonaws_dynamodb_ReplicaNotFoundException(native_input):
    output = {}
    if "message" in native_input:
        output["message"] = native_input["message"]

    return output


def com_amazonaws_dynamodb_RequestLimitExceeded(native_input):
    output = {}
    if "message" in native_input:
        output["message"] = native_input["message"]

    return output


def com_amazonaws_dynamodb_ResourceInUseException(native_input):
    output = {}
    if "message" in native_input:
        output["message"] = native_input["message"]

    return output


def com_amazonaws_dynamodb_ResourceNotFoundException(native_input):
    output = {}
    if "message" in native_input:
        output["message"] = native_input["message"]

    return output


def com_amazonaws_dynamodb_TableAlreadyExistsException(native_input):
    output = {}
    if "message" in native_input:
        output["message"] = native_input["message"]

    return output


def com_amazonaws_dynamodb_TableInUseException(native_input):
    output = {}
    if "message" in native_input:
        output["message"] = native_input["message"]

    return output


def com_amazonaws_dynamodb_TableNotFoundException(native_input):
    output = {}
    if "message" in native_input:
        output["message"] = native_input["message"]

    return output


def com_amazonaws_dynamodb_TransactionCanceledException(native_input):
    output = {}
    if "Message" in native_input:
        output["Message"] = native_input["Message"]

    if "CancellationReasons" in native_input:
        output["CancellationReasons"] = [
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_CancellationReason(
                list_element
            )
            for list_element in native_input["CancellationReasons"]
        ]

    return output


def com_amazonaws_dynamodb_CancellationReason(native_input):
    output = {}
    if "Item" in native_input:
        output["Item"] = {
            key: TypeSerializer().serialize(value)
            for (key, value) in native_input["Item"].items()
        }

    if "Code" in native_input:
        output["Code"] = native_input["Code"]

    if "Message" in native_input:
        output["Message"] = native_input["Message"]

    return output


def com_amazonaws_dynamodb_TransactionConflictException(native_input):
    output = {}
    if "message" in native_input:
        output["message"] = native_input["message"]

    return output


def com_amazonaws_dynamodb_TransactionInProgressException(native_input):
    output = {}
    if "Message" in native_input:
        output["Message"] = native_input["Message"]

    return output


def com_amazonaws_dynamodb_BatchExecuteStatementInput(native_input):
    output = {}
    output["Statements"] = [
        aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_BatchStatementRequest(
            list_element
        )
        for list_element in native_input["Statements"]
    ]
    if "ReturnConsumedCapacity" in native_input:
        output["ReturnConsumedCapacity"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ReturnConsumedCapacity(
                native_input["ReturnConsumedCapacity"]
            )
        )

    return output


def com_amazonaws_dynamodb_BatchStatementRequest(native_input):
    output = {}
    output["Statement"] = native_input["Statement"]
    if "Parameters" in native_input:
        output["Parameters"] = [
            TypeSerializer().serialize(list_element)
            for list_element in native_input["Parameters"]
        ]

    if "ConsistentRead" in native_input:
        output["ConsistentRead"] = native_input["ConsistentRead"]

    return output


def com_amazonaws_dynamodb_ReturnConsumedCapacity(native_input):
    # Always return input enum
    return native_input


def com_amazonaws_dynamodb_BatchExecuteStatementOutput(native_input):
    output = {}
    if "Responses" in native_input:
        output["Responses"] = [
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_BatchStatementResponse(
                list_element
            )
            for list_element in native_input["Responses"]
        ]

    if "ConsumedCapacity" in native_input:
        output["ConsumedCapacity"] = [
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ConsumedCapacity(
                list_element
            )
            for list_element in native_input["ConsumedCapacity"]
        ]

    return output


def com_amazonaws_dynamodb_BatchStatementResponse(native_input):
    output = {}
    if "Error" in native_input:
        output["Error"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_BatchStatementError(
                native_input["Error"]
            )
        )

    if "TableName" in native_input:
        output["TableName"] = native_input["TableName"]

    if "Item" in native_input:
        output["Item"] = {
            key: TypeSerializer().serialize(value)
            for (key, value) in native_input["Item"].items()
        }

    return output


def com_amazonaws_dynamodb_ConsumedCapacity(native_input):
    output = {}
    if "TableName" in native_input:
        output["TableName"] = native_input["TableName"]

    if "CapacityUnits" in native_input:
        output["CapacityUnits"] = native_input["CapacityUnits"]

    if "ReadCapacityUnits" in native_input:
        output["ReadCapacityUnits"] = native_input["ReadCapacityUnits"]

    if "WriteCapacityUnits" in native_input:
        output["WriteCapacityUnits"] = native_input["WriteCapacityUnits"]

    if "Table" in native_input:
        output["Table"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_Capacity(
                native_input["Table"]
            )
        )

    if "LocalSecondaryIndexes" in native_input:
        output["LocalSecondaryIndexes"] = {
            key: aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_Capacity(
                value
            )
            for (key, value) in native_input["LocalSecondaryIndexes"].items()
        }

    if "GlobalSecondaryIndexes" in native_input:
        output["GlobalSecondaryIndexes"] = {
            key: aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_Capacity(
                value
            )
            for (key, value) in native_input["GlobalSecondaryIndexes"].items()
        }

    return output


def com_amazonaws_dynamodb_BatchStatementError(native_input):
    output = {}
    if "Code" in native_input:
        output["Code"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_BatchStatementErrorCodeEnum(
                native_input["Code"]
            )
        )

    if "Message" in native_input:
        output["Message"] = native_input["Message"]

    return output


def com_amazonaws_dynamodb_Capacity(native_input):
    output = {}
    if "ReadCapacityUnits" in native_input:
        output["ReadCapacityUnits"] = native_input["ReadCapacityUnits"]

    if "WriteCapacityUnits" in native_input:
        output["WriteCapacityUnits"] = native_input["WriteCapacityUnits"]

    if "CapacityUnits" in native_input:
        output["CapacityUnits"] = native_input["CapacityUnits"]

    return output


def com_amazonaws_dynamodb_BatchStatementErrorCodeEnum(native_input):
    # Always return input enum
    return native_input


def com_amazonaws_dynamodb_BatchGetItemInput(native_input):
    output = {}
    output["RequestItems"] = {
        key: aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_KeysAndAttributes(
            value
        )
        for (key, value) in native_input["RequestItems"].items()
    }
    if "ReturnConsumedCapacity" in native_input:
        output["ReturnConsumedCapacity"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ReturnConsumedCapacity(
                native_input["ReturnConsumedCapacity"]
            )
        )

    return output


def com_amazonaws_dynamodb_KeysAndAttributes(native_input):
    output = {}
    output["Keys"] = [
        {
            key: TypeSerializer().serialize(value)
            for (key, value) in list_element.items()
        }
        for list_element in native_input["Keys"]
    ]
    if "AttributesToGet" in native_input:
        output["AttributesToGet"] = [
            list_element for list_element in native_input["AttributesToGet"]
        ]

    if "ConsistentRead" in native_input:
        output["ConsistentRead"] = native_input["ConsistentRead"]

    if "ProjectionExpression" in native_input:
        output["ProjectionExpression"] = native_input["ProjectionExpression"]

    if "ExpressionAttributeNames" in native_input:
        output["ExpressionAttributeNames"] = {
            key: value
            for (key, value) in native_input["ExpressionAttributeNames"].items()
        }

    return output


def com_amazonaws_dynamodb_BatchGetItemOutput(native_input):
    output = {}
    if "Responses" in native_input:
        output["Responses"] = {
            key: [
                {
                    key: TypeSerializer().serialize(value)
                    for (key, value) in list_element.items()
                }
                for list_element in value
            ]
            for (key, value) in native_input["Responses"].items()
        }

    if "UnprocessedKeys" in native_input:
        output["UnprocessedKeys"] = {
            key: aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_KeysAndAttributes(
                value
            )
            for (key, value) in native_input["UnprocessedKeys"].items()
        }

    if "ConsumedCapacity" in native_input:
        output["ConsumedCapacity"] = [
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ConsumedCapacity(
                list_element
            )
            for list_element in native_input["ConsumedCapacity"]
        ]

    return output


def com_amazonaws_dynamodb_BatchWriteItemInput(native_input):
    output = {}
    output["RequestItems"] = {
        key: [
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_WriteRequest(
                list_element
            )
            for list_element in value
        ]
        for (key, value) in native_input["RequestItems"].items()
    }
    if "ReturnConsumedCapacity" in native_input:
        output["ReturnConsumedCapacity"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ReturnConsumedCapacity(
                native_input["ReturnConsumedCapacity"]
            )
        )

    if "ReturnItemCollectionMetrics" in native_input:
        output["ReturnItemCollectionMetrics"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ReturnItemCollectionMetrics(
                native_input["ReturnItemCollectionMetrics"]
            )
        )

    return output


def com_amazonaws_dynamodb_WriteRequest(native_input):
    output = {}
    if "PutRequest" in native_input:
        output["PutRequest"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_PutRequest(
                native_input["PutRequest"]
            )
        )

    if "DeleteRequest" in native_input:
        output["DeleteRequest"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_DeleteRequest(
                native_input["DeleteRequest"]
            )
        )

    return output


def com_amazonaws_dynamodb_ReturnItemCollectionMetrics(native_input):
    # Always return input enum
    return native_input


def com_amazonaws_dynamodb_PutRequest(native_input):
    output = {}
    output["Item"] = {
        key: TypeSerializer().serialize(value)
        for (key, value) in native_input["Item"].items()
    }
    return output


def com_amazonaws_dynamodb_DeleteRequest(native_input):
    output = {}
    output["Key"] = {
        key: TypeSerializer().serialize(value)
        for (key, value) in native_input["Key"].items()
    }
    return output


def com_amazonaws_dynamodb_BatchWriteItemOutput(native_input):
    output = {}
    if "UnprocessedItems" in native_input:
        output["UnprocessedItems"] = {
            key: [
                aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_WriteRequest(
                    list_element
                )
                for list_element in value
            ]
            for (key, value) in native_input["UnprocessedItems"].items()
        }

    if "ItemCollectionMetrics" in native_input:
        output["ItemCollectionMetrics"] = {
            key: [
                aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ItemCollectionMetrics(
                    list_element
                )
                for list_element in value
            ]
            for (key, value) in native_input["ItemCollectionMetrics"].items()
        }

    if "ConsumedCapacity" in native_input:
        output["ConsumedCapacity"] = [
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ConsumedCapacity(
                list_element
            )
            for list_element in native_input["ConsumedCapacity"]
        ]

    return output


def com_amazonaws_dynamodb_ItemCollectionMetrics(native_input):
    output = {}
    if "ItemCollectionKey" in native_input:
        output["ItemCollectionKey"] = {
            key: TypeSerializer().serialize(value)
            for (key, value) in native_input["ItemCollectionKey"].items()
        }

    if "SizeEstimateRangeGB" in native_input:
        output["SizeEstimateRangeGB"] = [
            list_element for list_element in native_input["SizeEstimateRangeGB"]
        ]

    return output


def com_amazonaws_dynamodb_CreateBackupInput(native_input):
    output = {}
    output["TableName"] = native_input["TableName"]
    output["BackupName"] = native_input["BackupName"]
    return output


def com_amazonaws_dynamodb_CreateBackupOutput(native_input):
    output = {}
    if "BackupDetails" in native_input:
        output["BackupDetails"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_BackupDetails(
                native_input["BackupDetails"]
            )
        )

    return output


def com_amazonaws_dynamodb_BackupDetails(native_input):
    output = {}
    output["BackupArn"] = native_input["BackupArn"]
    output["BackupName"] = native_input["BackupName"]
    if "BackupSizeBytes" in native_input:
        output["BackupSizeBytes"] = native_input["BackupSizeBytes"]

    output["BackupStatus"] = (
        aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_BackupStatus(
            native_input["BackupStatus"]
        )
    )
    output["BackupType"] = (
        aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_BackupType(
            native_input["BackupType"]
        )
    )
    output["BackupCreationDateTime"] = native_input["BackupCreationDateTime"]
    if "BackupExpiryDateTime" in native_input:
        output["BackupExpiryDateTime"] = native_input["BackupExpiryDateTime"]

    return output


def com_amazonaws_dynamodb_BackupStatus(native_input):
    # Always return input enum
    return native_input


def com_amazonaws_dynamodb_BackupType(native_input):
    # Always return input enum
    return native_input


def com_amazonaws_dynamodb_CreateGlobalTableInput(native_input):
    output = {}
    output["GlobalTableName"] = native_input["GlobalTableName"]
    output["ReplicationGroup"] = [
        aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_Replica(
            list_element
        )
        for list_element in native_input["ReplicationGroup"]
    ]
    return output


def com_amazonaws_dynamodb_Replica(native_input):
    output = {}
    if "RegionName" in native_input:
        output["RegionName"] = native_input["RegionName"]

    return output


def com_amazonaws_dynamodb_CreateGlobalTableOutput(native_input):
    output = {}
    if "GlobalTableDescription" in native_input:
        output["GlobalTableDescription"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_GlobalTableDescription(
                native_input["GlobalTableDescription"]
            )
        )

    return output


def com_amazonaws_dynamodb_GlobalTableDescription(native_input):
    output = {}
    if "ReplicationGroup" in native_input:
        output["ReplicationGroup"] = [
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ReplicaDescription(
                list_element
            )
            for list_element in native_input["ReplicationGroup"]
        ]

    if "GlobalTableArn" in native_input:
        output["GlobalTableArn"] = native_input["GlobalTableArn"]

    if "CreationDateTime" in native_input:
        output["CreationDateTime"] = native_input["CreationDateTime"]

    if "GlobalTableStatus" in native_input:
        output["GlobalTableStatus"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_GlobalTableStatus(
                native_input["GlobalTableStatus"]
            )
        )

    if "GlobalTableName" in native_input:
        output["GlobalTableName"] = native_input["GlobalTableName"]

    return output


def com_amazonaws_dynamodb_ReplicaDescription(native_input):
    output = {}
    if "RegionName" in native_input:
        output["RegionName"] = native_input["RegionName"]

    if "ReplicaStatus" in native_input:
        output["ReplicaStatus"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ReplicaStatus(
                native_input["ReplicaStatus"]
            )
        )

    if "ReplicaStatusDescription" in native_input:
        output["ReplicaStatusDescription"] = native_input["ReplicaStatusDescription"]

    if "ReplicaStatusPercentProgress" in native_input:
        output["ReplicaStatusPercentProgress"] = native_input[
            "ReplicaStatusPercentProgress"
        ]

    if "KMSMasterKeyId" in native_input:
        output["KMSMasterKeyId"] = native_input["KMSMasterKeyId"]

    if "ProvisionedThroughputOverride" in native_input:
        output["ProvisionedThroughputOverride"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ProvisionedThroughputOverride(
                native_input["ProvisionedThroughputOverride"]
            )
        )

    if "OnDemandThroughputOverride" in native_input:
        output["OnDemandThroughputOverride"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_OnDemandThroughputOverride(
                native_input["OnDemandThroughputOverride"]
            )
        )

    if "GlobalSecondaryIndexes" in native_input:
        output["GlobalSecondaryIndexes"] = [
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ReplicaGlobalSecondaryIndexDescription(
                list_element
            )
            for list_element in native_input["GlobalSecondaryIndexes"]
        ]

    if "ReplicaInaccessibleDateTime" in native_input:
        output["ReplicaInaccessibleDateTime"] = native_input[
            "ReplicaInaccessibleDateTime"
        ]

    if "ReplicaTableClassSummary" in native_input:
        output["ReplicaTableClassSummary"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_TableClassSummary(
                native_input["ReplicaTableClassSummary"]
            )
        )

    return output


def com_amazonaws_dynamodb_GlobalTableStatus(native_input):
    # Always return input enum
    return native_input


def com_amazonaws_dynamodb_ReplicaStatus(native_input):
    # Always return input enum
    return native_input


def com_amazonaws_dynamodb_ProvisionedThroughputOverride(native_input):
    output = {}
    if "ReadCapacityUnits" in native_input:
        output["ReadCapacityUnits"] = native_input["ReadCapacityUnits"]

    return output


def com_amazonaws_dynamodb_OnDemandThroughputOverride(native_input):
    output = {}
    if "MaxReadRequestUnits" in native_input:
        output["MaxReadRequestUnits"] = native_input["MaxReadRequestUnits"]

    return output


def com_amazonaws_dynamodb_ReplicaGlobalSecondaryIndexDescription(native_input):
    output = {}
    if "IndexName" in native_input:
        output["IndexName"] = native_input["IndexName"]

    if "ProvisionedThroughputOverride" in native_input:
        output["ProvisionedThroughputOverride"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ProvisionedThroughputOverride(
                native_input["ProvisionedThroughputOverride"]
            )
        )

    if "OnDemandThroughputOverride" in native_input:
        output["OnDemandThroughputOverride"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_OnDemandThroughputOverride(
                native_input["OnDemandThroughputOverride"]
            )
        )

    return output


def com_amazonaws_dynamodb_TableClassSummary(native_input):
    output = {}
    if "TableClass" in native_input:
        output["TableClass"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_TableClass(
                native_input["TableClass"]
            )
        )

    if "LastUpdateDateTime" in native_input:
        output["LastUpdateDateTime"] = native_input["LastUpdateDateTime"]

    return output


def com_amazonaws_dynamodb_TableClass(native_input):
    # Always return input enum
    return native_input


def com_amazonaws_dynamodb_CreateTableInput(native_input):
    output = {}
    output["AttributeDefinitions"] = [
        aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_AttributeDefinition(
            list_element
        )
        for list_element in native_input["AttributeDefinitions"]
    ]
    output["TableName"] = native_input["TableName"]
    output["KeySchema"] = [
        aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_KeySchemaElement(
            list_element
        )
        for list_element in native_input["KeySchema"]
    ]
    if "LocalSecondaryIndexes" in native_input:
        output["LocalSecondaryIndexes"] = [
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_LocalSecondaryIndex(
                list_element
            )
            for list_element in native_input["LocalSecondaryIndexes"]
        ]

    if "GlobalSecondaryIndexes" in native_input:
        output["GlobalSecondaryIndexes"] = [
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_GlobalSecondaryIndex(
                list_element
            )
            for list_element in native_input["GlobalSecondaryIndexes"]
        ]

    if "BillingMode" in native_input:
        output["BillingMode"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_BillingMode(
                native_input["BillingMode"]
            )
        )

    if "ProvisionedThroughput" in native_input:
        output["ProvisionedThroughput"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ProvisionedThroughput(
                native_input["ProvisionedThroughput"]
            )
        )

    if "StreamSpecification" in native_input:
        output["StreamSpecification"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_StreamSpecification(
                native_input["StreamSpecification"]
            )
        )

    if "SSESpecification" in native_input:
        output["SSESpecification"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_SSESpecification(
                native_input["SSESpecification"]
            )
        )

    if "Tags" in native_input:
        output["Tags"] = [
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_Tag(
                list_element
            )
            for list_element in native_input["Tags"]
        ]

    if "TableClass" in native_input:
        output["TableClass"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_TableClass(
                native_input["TableClass"]
            )
        )

    if "DeletionProtectionEnabled" in native_input:
        output["DeletionProtectionEnabled"] = native_input["DeletionProtectionEnabled"]

    if "ResourcePolicy" in native_input:
        output["ResourcePolicy"] = native_input["ResourcePolicy"]

    if "OnDemandThroughput" in native_input:
        output["OnDemandThroughput"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_OnDemandThroughput(
                native_input["OnDemandThroughput"]
            )
        )

    return output


def com_amazonaws_dynamodb_AttributeDefinition(native_input):
    output = {}
    output["AttributeName"] = native_input["AttributeName"]
    output["AttributeType"] = (
        aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ScalarAttributeType(
            native_input["AttributeType"]
        )
    )
    return output


def com_amazonaws_dynamodb_KeySchemaElement(native_input):
    output = {}
    output["AttributeName"] = native_input["AttributeName"]
    output["KeyType"] = (
        aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_KeyType(
            native_input["KeyType"]
        )
    )
    return output


def com_amazonaws_dynamodb_LocalSecondaryIndex(native_input):
    output = {}
    output["IndexName"] = native_input["IndexName"]
    output["KeySchema"] = [
        aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_KeySchemaElement(
            list_element
        )
        for list_element in native_input["KeySchema"]
    ]
    output["Projection"] = (
        aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_Projection(
            native_input["Projection"]
        )
    )
    return output


def com_amazonaws_dynamodb_GlobalSecondaryIndex(native_input):
    output = {}
    output["IndexName"] = native_input["IndexName"]
    output["KeySchema"] = [
        aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_KeySchemaElement(
            list_element
        )
        for list_element in native_input["KeySchema"]
    ]
    output["Projection"] = (
        aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_Projection(
            native_input["Projection"]
        )
    )
    if "ProvisionedThroughput" in native_input:
        output["ProvisionedThroughput"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ProvisionedThroughput(
                native_input["ProvisionedThroughput"]
            )
        )

    if "OnDemandThroughput" in native_input:
        output["OnDemandThroughput"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_OnDemandThroughput(
                native_input["OnDemandThroughput"]
            )
        )

    return output


def com_amazonaws_dynamodb_BillingMode(native_input):
    # Always return input enum
    return native_input


def com_amazonaws_dynamodb_ProvisionedThroughput(native_input):
    output = {}
    output["ReadCapacityUnits"] = native_input["ReadCapacityUnits"]
    output["WriteCapacityUnits"] = native_input["WriteCapacityUnits"]
    return output


def com_amazonaws_dynamodb_StreamSpecification(native_input):
    output = {}
    output["StreamEnabled"] = native_input["StreamEnabled"]
    if "StreamViewType" in native_input:
        output["StreamViewType"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_StreamViewType(
                native_input["StreamViewType"]
            )
        )

    return output


def com_amazonaws_dynamodb_SSESpecification(native_input):
    output = {}
    if "Enabled" in native_input:
        output["Enabled"] = native_input["Enabled"]

    if "SSEType" in native_input:
        output["SSEType"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_SSEType(
                native_input["SSEType"]
            )
        )

    if "KMSMasterKeyId" in native_input:
        output["KMSMasterKeyId"] = native_input["KMSMasterKeyId"]

    return output


def com_amazonaws_dynamodb_Tag(native_input):
    output = {}
    output["Key"] = native_input["Key"]
    output["Value"] = native_input["Value"]
    return output


def com_amazonaws_dynamodb_OnDemandThroughput(native_input):
    output = {}
    if "MaxReadRequestUnits" in native_input:
        output["MaxReadRequestUnits"] = native_input["MaxReadRequestUnits"]

    if "MaxWriteRequestUnits" in native_input:
        output["MaxWriteRequestUnits"] = native_input["MaxWriteRequestUnits"]

    return output


def com_amazonaws_dynamodb_ScalarAttributeType(native_input):
    # Always return input enum
    return native_input


def com_amazonaws_dynamodb_KeyType(native_input):
    # Always return input enum
    return native_input


def com_amazonaws_dynamodb_Projection(native_input):
    output = {}
    if "ProjectionType" in native_input:
        output["ProjectionType"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ProjectionType(
                native_input["ProjectionType"]
            )
        )

    if "NonKeyAttributes" in native_input:
        output["NonKeyAttributes"] = [
            list_element for list_element in native_input["NonKeyAttributes"]
        ]

    return output


def com_amazonaws_dynamodb_StreamViewType(native_input):
    # Always return input enum
    return native_input


def com_amazonaws_dynamodb_SSEType(native_input):
    # Always return input enum
    return native_input


def com_amazonaws_dynamodb_ProjectionType(native_input):
    # Always return input enum
    return native_input


def com_amazonaws_dynamodb_CreateTableOutput(native_input):
    output = {}
    if "TableDescription" in native_input:
        output["TableDescription"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_TableDescription(
                native_input["TableDescription"]
            )
        )

    return output


def com_amazonaws_dynamodb_TableDescription(native_input):
    output = {}
    if "AttributeDefinitions" in native_input:
        output["AttributeDefinitions"] = [
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_AttributeDefinition(
                list_element
            )
            for list_element in native_input["AttributeDefinitions"]
        ]

    if "TableName" in native_input:
        output["TableName"] = native_input["TableName"]

    if "KeySchema" in native_input:
        output["KeySchema"] = [
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_KeySchemaElement(
                list_element
            )
            for list_element in native_input["KeySchema"]
        ]

    if "TableStatus" in native_input:
        output["TableStatus"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_TableStatus(
                native_input["TableStatus"]
            )
        )

    if "CreationDateTime" in native_input:
        output["CreationDateTime"] = native_input["CreationDateTime"]

    if "ProvisionedThroughput" in native_input:
        output["ProvisionedThroughput"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ProvisionedThroughputDescription(
                native_input["ProvisionedThroughput"]
            )
        )

    if "TableSizeBytes" in native_input:
        output["TableSizeBytes"] = native_input["TableSizeBytes"]

    if "ItemCount" in native_input:
        output["ItemCount"] = native_input["ItemCount"]

    if "TableArn" in native_input:
        output["TableArn"] = native_input["TableArn"]

    if "TableId" in native_input:
        output["TableId"] = native_input["TableId"]

    if "BillingModeSummary" in native_input:
        output["BillingModeSummary"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_BillingModeSummary(
                native_input["BillingModeSummary"]
            )
        )

    if "LocalSecondaryIndexes" in native_input:
        output["LocalSecondaryIndexes"] = [
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_LocalSecondaryIndexDescription(
                list_element
            )
            for list_element in native_input["LocalSecondaryIndexes"]
        ]

    if "GlobalSecondaryIndexes" in native_input:
        output["GlobalSecondaryIndexes"] = [
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_GlobalSecondaryIndexDescription(
                list_element
            )
            for list_element in native_input["GlobalSecondaryIndexes"]
        ]

    if "StreamSpecification" in native_input:
        output["StreamSpecification"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_StreamSpecification(
                native_input["StreamSpecification"]
            )
        )

    if "LatestStreamLabel" in native_input:
        output["LatestStreamLabel"] = native_input["LatestStreamLabel"]

    if "LatestStreamArn" in native_input:
        output["LatestStreamArn"] = native_input["LatestStreamArn"]

    if "GlobalTableVersion" in native_input:
        output["GlobalTableVersion"] = native_input["GlobalTableVersion"]

    if "Replicas" in native_input:
        output["Replicas"] = [
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ReplicaDescription(
                list_element
            )
            for list_element in native_input["Replicas"]
        ]

    if "RestoreSummary" in native_input:
        output["RestoreSummary"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_RestoreSummary(
                native_input["RestoreSummary"]
            )
        )

    if "SSEDescription" in native_input:
        output["SSEDescription"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_SSEDescription(
                native_input["SSEDescription"]
            )
        )

    if "ArchivalSummary" in native_input:
        output["ArchivalSummary"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ArchivalSummary(
                native_input["ArchivalSummary"]
            )
        )

    if "TableClassSummary" in native_input:
        output["TableClassSummary"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_TableClassSummary(
                native_input["TableClassSummary"]
            )
        )

    if "DeletionProtectionEnabled" in native_input:
        output["DeletionProtectionEnabled"] = native_input["DeletionProtectionEnabled"]

    if "OnDemandThroughput" in native_input:
        output["OnDemandThroughput"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_OnDemandThroughput(
                native_input["OnDemandThroughput"]
            )
        )

    return output


def com_amazonaws_dynamodb_TableStatus(native_input):
    # Always return input enum
    return native_input


def com_amazonaws_dynamodb_ProvisionedThroughputDescription(native_input):
    output = {}
    if "LastIncreaseDateTime" in native_input:
        output["LastIncreaseDateTime"] = native_input["LastIncreaseDateTime"]

    if "LastDecreaseDateTime" in native_input:
        output["LastDecreaseDateTime"] = native_input["LastDecreaseDateTime"]

    if "NumberOfDecreasesToday" in native_input:
        output["NumberOfDecreasesToday"] = native_input["NumberOfDecreasesToday"]

    if "ReadCapacityUnits" in native_input:
        output["ReadCapacityUnits"] = native_input["ReadCapacityUnits"]

    if "WriteCapacityUnits" in native_input:
        output["WriteCapacityUnits"] = native_input["WriteCapacityUnits"]

    return output


def com_amazonaws_dynamodb_BillingModeSummary(native_input):
    output = {}
    if "BillingMode" in native_input:
        output["BillingMode"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_BillingMode(
                native_input["BillingMode"]
            )
        )

    if "LastUpdateToPayPerRequestDateTime" in native_input:
        output["LastUpdateToPayPerRequestDateTime"] = native_input[
            "LastUpdateToPayPerRequestDateTime"
        ]

    return output


def com_amazonaws_dynamodb_LocalSecondaryIndexDescription(native_input):
    output = {}
    if "IndexName" in native_input:
        output["IndexName"] = native_input["IndexName"]

    if "KeySchema" in native_input:
        output["KeySchema"] = [
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_KeySchemaElement(
                list_element
            )
            for list_element in native_input["KeySchema"]
        ]

    if "Projection" in native_input:
        output["Projection"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_Projection(
                native_input["Projection"]
            )
        )

    if "IndexSizeBytes" in native_input:
        output["IndexSizeBytes"] = native_input["IndexSizeBytes"]

    if "ItemCount" in native_input:
        output["ItemCount"] = native_input["ItemCount"]

    if "IndexArn" in native_input:
        output["IndexArn"] = native_input["IndexArn"]

    return output


def com_amazonaws_dynamodb_GlobalSecondaryIndexDescription(native_input):
    output = {}
    if "IndexName" in native_input:
        output["IndexName"] = native_input["IndexName"]

    if "KeySchema" in native_input:
        output["KeySchema"] = [
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_KeySchemaElement(
                list_element
            )
            for list_element in native_input["KeySchema"]
        ]

    if "Projection" in native_input:
        output["Projection"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_Projection(
                native_input["Projection"]
            )
        )

    if "IndexStatus" in native_input:
        output["IndexStatus"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_IndexStatus(
                native_input["IndexStatus"]
            )
        )

    if "Backfilling" in native_input:
        output["Backfilling"] = native_input["Backfilling"]

    if "ProvisionedThroughput" in native_input:
        output["ProvisionedThroughput"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ProvisionedThroughputDescription(
                native_input["ProvisionedThroughput"]
            )
        )

    if "IndexSizeBytes" in native_input:
        output["IndexSizeBytes"] = native_input["IndexSizeBytes"]

    if "ItemCount" in native_input:
        output["ItemCount"] = native_input["ItemCount"]

    if "IndexArn" in native_input:
        output["IndexArn"] = native_input["IndexArn"]

    if "OnDemandThroughput" in native_input:
        output["OnDemandThroughput"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_OnDemandThroughput(
                native_input["OnDemandThroughput"]
            )
        )

    return output


def com_amazonaws_dynamodb_RestoreSummary(native_input):
    output = {}
    if "SourceBackupArn" in native_input:
        output["SourceBackupArn"] = native_input["SourceBackupArn"]

    if "SourceTableArn" in native_input:
        output["SourceTableArn"] = native_input["SourceTableArn"]

    output["RestoreDateTime"] = native_input["RestoreDateTime"]
    output["RestoreInProgress"] = native_input["RestoreInProgress"]
    return output


def com_amazonaws_dynamodb_SSEDescription(native_input):
    output = {}
    if "Status" in native_input:
        output["Status"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_SSEStatus(
                native_input["Status"]
            )
        )

    if "SSEType" in native_input:
        output["SSEType"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_SSEType(
                native_input["SSEType"]
            )
        )

    if "KMSMasterKeyArn" in native_input:
        output["KMSMasterKeyArn"] = native_input["KMSMasterKeyArn"]

    if "InaccessibleEncryptionDateTime" in native_input:
        output["InaccessibleEncryptionDateTime"] = native_input[
            "InaccessibleEncryptionDateTime"
        ]

    return output


def com_amazonaws_dynamodb_ArchivalSummary(native_input):
    output = {}
    if "ArchivalDateTime" in native_input:
        output["ArchivalDateTime"] = native_input["ArchivalDateTime"]

    if "ArchivalReason" in native_input:
        output["ArchivalReason"] = native_input["ArchivalReason"]

    if "ArchivalBackupArn" in native_input:
        output["ArchivalBackupArn"] = native_input["ArchivalBackupArn"]

    return output


def com_amazonaws_dynamodb_IndexStatus(native_input):
    # Always return input enum
    return native_input


def com_amazonaws_dynamodb_SSEStatus(native_input):
    # Always return input enum
    return native_input


def com_amazonaws_dynamodb_DeleteBackupInput(native_input):
    output = {}
    output["BackupArn"] = native_input["BackupArn"]
    return output


def com_amazonaws_dynamodb_DeleteBackupOutput(native_input):
    output = {}
    if "BackupDescription" in native_input:
        output["BackupDescription"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_BackupDescription(
                native_input["BackupDescription"]
            )
        )

    return output


def com_amazonaws_dynamodb_BackupDescription(native_input):
    output = {}
    if "BackupDetails" in native_input:
        output["BackupDetails"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_BackupDetails(
                native_input["BackupDetails"]
            )
        )

    if "SourceTableDetails" in native_input:
        output["SourceTableDetails"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_SourceTableDetails(
                native_input["SourceTableDetails"]
            )
        )

    if "SourceTableFeatureDetails" in native_input:
        output["SourceTableFeatureDetails"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_SourceTableFeatureDetails(
                native_input["SourceTableFeatureDetails"]
            )
        )

    return output


def com_amazonaws_dynamodb_SourceTableDetails(native_input):
    output = {}
    output["TableName"] = native_input["TableName"]
    output["TableId"] = native_input["TableId"]
    if "TableArn" in native_input:
        output["TableArn"] = native_input["TableArn"]

    if "TableSizeBytes" in native_input:
        output["TableSizeBytes"] = native_input["TableSizeBytes"]

    output["KeySchema"] = [
        aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_KeySchemaElement(
            list_element
        )
        for list_element in native_input["KeySchema"]
    ]
    output["TableCreationDateTime"] = native_input["TableCreationDateTime"]
    output["ProvisionedThroughput"] = (
        aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ProvisionedThroughput(
            native_input["ProvisionedThroughput"]
        )
    )
    if "OnDemandThroughput" in native_input:
        output["OnDemandThroughput"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_OnDemandThroughput(
                native_input["OnDemandThroughput"]
            )
        )

    if "ItemCount" in native_input:
        output["ItemCount"] = native_input["ItemCount"]

    if "BillingMode" in native_input:
        output["BillingMode"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_BillingMode(
                native_input["BillingMode"]
            )
        )

    return output


def com_amazonaws_dynamodb_SourceTableFeatureDetails(native_input):
    output = {}
    if "LocalSecondaryIndexes" in native_input:
        output["LocalSecondaryIndexes"] = [
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_LocalSecondaryIndexInfo(
                list_element
            )
            for list_element in native_input["LocalSecondaryIndexes"]
        ]

    if "GlobalSecondaryIndexes" in native_input:
        output["GlobalSecondaryIndexes"] = [
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_GlobalSecondaryIndexInfo(
                list_element
            )
            for list_element in native_input["GlobalSecondaryIndexes"]
        ]

    if "StreamDescription" in native_input:
        output["StreamDescription"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_StreamSpecification(
                native_input["StreamDescription"]
            )
        )

    if "TimeToLiveDescription" in native_input:
        output["TimeToLiveDescription"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_TimeToLiveDescription(
                native_input["TimeToLiveDescription"]
            )
        )

    if "SSEDescription" in native_input:
        output["SSEDescription"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_SSEDescription(
                native_input["SSEDescription"]
            )
        )

    return output


def com_amazonaws_dynamodb_LocalSecondaryIndexInfo(native_input):
    output = {}
    if "IndexName" in native_input:
        output["IndexName"] = native_input["IndexName"]

    if "KeySchema" in native_input:
        output["KeySchema"] = [
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_KeySchemaElement(
                list_element
            )
            for list_element in native_input["KeySchema"]
        ]

    if "Projection" in native_input:
        output["Projection"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_Projection(
                native_input["Projection"]
            )
        )

    return output


def com_amazonaws_dynamodb_GlobalSecondaryIndexInfo(native_input):
    output = {}
    if "IndexName" in native_input:
        output["IndexName"] = native_input["IndexName"]

    if "KeySchema" in native_input:
        output["KeySchema"] = [
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_KeySchemaElement(
                list_element
            )
            for list_element in native_input["KeySchema"]
        ]

    if "Projection" in native_input:
        output["Projection"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_Projection(
                native_input["Projection"]
            )
        )

    if "ProvisionedThroughput" in native_input:
        output["ProvisionedThroughput"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ProvisionedThroughput(
                native_input["ProvisionedThroughput"]
            )
        )

    if "OnDemandThroughput" in native_input:
        output["OnDemandThroughput"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_OnDemandThroughput(
                native_input["OnDemandThroughput"]
            )
        )

    return output


def com_amazonaws_dynamodb_TimeToLiveDescription(native_input):
    output = {}
    if "TimeToLiveStatus" in native_input:
        output["TimeToLiveStatus"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_TimeToLiveStatus(
                native_input["TimeToLiveStatus"]
            )
        )

    if "AttributeName" in native_input:
        output["AttributeName"] = native_input["AttributeName"]

    return output


def com_amazonaws_dynamodb_TimeToLiveStatus(native_input):
    # Always return input enum
    return native_input


def com_amazonaws_dynamodb_DeleteItemInput(native_input):
    output = {}
    output["TableName"] = native_input["TableName"]
    output["Key"] = {
        key: TypeSerializer().serialize(value)
        for (key, value) in native_input["Key"].items()
    }
    if "Expected" in native_input:
        output["Expected"] = {
            key: aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ExpectedAttributeValue(
                value
            )
            for (key, value) in native_input["Expected"].items()
        }

    if "ConditionalOperator" in native_input:
        output["ConditionalOperator"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ConditionalOperator(
                native_input["ConditionalOperator"]
            )
        )

    if "ReturnValues" in native_input:
        output["ReturnValues"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ReturnValue(
                native_input["ReturnValues"]
            )
        )

    if "ReturnConsumedCapacity" in native_input:
        output["ReturnConsumedCapacity"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ReturnConsumedCapacity(
                native_input["ReturnConsumedCapacity"]
            )
        )

    if "ReturnItemCollectionMetrics" in native_input:
        output["ReturnItemCollectionMetrics"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ReturnItemCollectionMetrics(
                native_input["ReturnItemCollectionMetrics"]
            )
        )

    if "ConditionExpression" in native_input:
        output["ConditionExpression"] = native_input["ConditionExpression"]

    if "ExpressionAttributeNames" in native_input:
        output["ExpressionAttributeNames"] = {
            key: value
            for (key, value) in native_input["ExpressionAttributeNames"].items()
        }

    if "ExpressionAttributeValues" in native_input:
        output["ExpressionAttributeValues"] = {
            key: TypeSerializer().serialize(value)
            for (key, value) in native_input["ExpressionAttributeValues"].items()
        }

    return output


def com_amazonaws_dynamodb_ExpectedAttributeValue(native_input):
    output = {}
    if "Value" in native_input:
        output["Value"] = TypeSerializer().serialize(native_input["Value"])

    if "Exists" in native_input:
        output["Exists"] = native_input["Exists"]

    if "ComparisonOperator" in native_input:
        output["ComparisonOperator"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ComparisonOperator(
                native_input["ComparisonOperator"]
            )
        )

    if "AttributeValueList" in native_input:
        output["AttributeValueList"] = [
            TypeSerializer().serialize(list_element)
            for list_element in native_input["AttributeValueList"]
        ]

    return output


def com_amazonaws_dynamodb_ConditionalOperator(native_input):
    # Always return input enum
    return native_input


def com_amazonaws_dynamodb_ReturnValue(native_input):
    # Always return input enum
    return native_input


def com_amazonaws_dynamodb_ComparisonOperator(native_input):
    # Always return input enum
    return native_input


def com_amazonaws_dynamodb_DeleteItemOutput(native_input):
    output = {}
    if "Attributes" in native_input:
        output["Attributes"] = {
            key: TypeSerializer().serialize(value)
            for (key, value) in native_input["Attributes"].items()
        }

    if "ConsumedCapacity" in native_input:
        output["ConsumedCapacity"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ConsumedCapacity(
                native_input["ConsumedCapacity"]
            )
        )

    if "ItemCollectionMetrics" in native_input:
        output["ItemCollectionMetrics"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ItemCollectionMetrics(
                native_input["ItemCollectionMetrics"]
            )
        )

    return output


def com_amazonaws_dynamodb_DeleteResourcePolicyInput(native_input):
    output = {}
    output["ResourceArn"] = native_input["ResourceArn"]
    if "ExpectedRevisionId" in native_input:
        output["ExpectedRevisionId"] = native_input["ExpectedRevisionId"]

    return output


def com_amazonaws_dynamodb_DeleteResourcePolicyOutput(native_input):
    output = {}
    if "RevisionId" in native_input:
        output["RevisionId"] = native_input["RevisionId"]

    return output


def com_amazonaws_dynamodb_DeleteTableInput(native_input):
    output = {}
    output["TableName"] = native_input["TableName"]
    return output


def com_amazonaws_dynamodb_DeleteTableOutput(native_input):
    output = {}
    if "TableDescription" in native_input:
        output["TableDescription"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_TableDescription(
                native_input["TableDescription"]
            )
        )

    return output


def com_amazonaws_dynamodb_DescribeBackupInput(native_input):
    output = {}
    output["BackupArn"] = native_input["BackupArn"]
    return output


def com_amazonaws_dynamodb_DescribeBackupOutput(native_input):
    output = {}
    if "BackupDescription" in native_input:
        output["BackupDescription"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_BackupDescription(
                native_input["BackupDescription"]
            )
        )

    return output


def com_amazonaws_dynamodb_DescribeContinuousBackupsInput(native_input):
    output = {}
    output["TableName"] = native_input["TableName"]
    return output


def com_amazonaws_dynamodb_DescribeContinuousBackupsOutput(native_input):
    output = {}
    if "ContinuousBackupsDescription" in native_input:
        output["ContinuousBackupsDescription"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ContinuousBackupsDescription(
                native_input["ContinuousBackupsDescription"]
            )
        )

    return output


def com_amazonaws_dynamodb_ContinuousBackupsDescription(native_input):
    output = {}
    output["ContinuousBackupsStatus"] = (
        aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ContinuousBackupsStatus(
            native_input["ContinuousBackupsStatus"]
        )
    )
    if "PointInTimeRecoveryDescription" in native_input:
        output["PointInTimeRecoveryDescription"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_PointInTimeRecoveryDescription(
                native_input["PointInTimeRecoveryDescription"]
            )
        )

    return output


def com_amazonaws_dynamodb_ContinuousBackupsStatus(native_input):
    # Always return input enum
    return native_input


def com_amazonaws_dynamodb_PointInTimeRecoveryDescription(native_input):
    output = {}
    if "PointInTimeRecoveryStatus" in native_input:
        output["PointInTimeRecoveryStatus"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_PointInTimeRecoveryStatus(
                native_input["PointInTimeRecoveryStatus"]
            )
        )

    if "EarliestRestorableDateTime" in native_input:
        output["EarliestRestorableDateTime"] = native_input[
            "EarliestRestorableDateTime"
        ]

    if "LatestRestorableDateTime" in native_input:
        output["LatestRestorableDateTime"] = native_input["LatestRestorableDateTime"]

    return output


def com_amazonaws_dynamodb_PointInTimeRecoveryStatus(native_input):
    # Always return input enum
    return native_input


def com_amazonaws_dynamodb_DescribeContributorInsightsInput(native_input):
    output = {}
    output["TableName"] = native_input["TableName"]
    if "IndexName" in native_input:
        output["IndexName"] = native_input["IndexName"]

    return output


def com_amazonaws_dynamodb_DescribeContributorInsightsOutput(native_input):
    output = {}
    if "TableName" in native_input:
        output["TableName"] = native_input["TableName"]

    if "IndexName" in native_input:
        output["IndexName"] = native_input["IndexName"]

    if "ContributorInsightsRuleList" in native_input:
        output["ContributorInsightsRuleList"] = [
            list_element for list_element in native_input["ContributorInsightsRuleList"]
        ]

    if "ContributorInsightsStatus" in native_input:
        output["ContributorInsightsStatus"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ContributorInsightsStatus(
                native_input["ContributorInsightsStatus"]
            )
        )

    if "LastUpdateDateTime" in native_input:
        output["LastUpdateDateTime"] = native_input["LastUpdateDateTime"]

    if "FailureException" in native_input:
        output["FailureException"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_FailureException(
                native_input["FailureException"]
            )
        )

    return output


def com_amazonaws_dynamodb_ContributorInsightsStatus(native_input):
    # Always return input enum
    return native_input


def com_amazonaws_dynamodb_FailureException(native_input):
    output = {}
    if "ExceptionName" in native_input:
        output["ExceptionName"] = native_input["ExceptionName"]

    if "ExceptionDescription" in native_input:
        output["ExceptionDescription"] = native_input["ExceptionDescription"]

    return output


def com_amazonaws_dynamodb_DescribeEndpointsRequest(native_input):
    output = {}
    return output


def com_amazonaws_dynamodb_DescribeEndpointsResponse(native_input):
    output = {}
    output["Endpoints"] = [
        aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_Endpoint(
            list_element
        )
        for list_element in native_input["Endpoints"]
    ]
    return output


def com_amazonaws_dynamodb_Endpoint(native_input):
    output = {}
    output["Address"] = native_input["Address"]
    output["CachePeriodInMinutes"] = native_input["CachePeriodInMinutes"]
    return output


def com_amazonaws_dynamodb_DescribeExportInput(native_input):
    output = {}
    output["ExportArn"] = native_input["ExportArn"]
    return output


def com_amazonaws_dynamodb_DescribeExportOutput(native_input):
    output = {}
    if "ExportDescription" in native_input:
        output["ExportDescription"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ExportDescription(
                native_input["ExportDescription"]
            )
        )

    return output


def com_amazonaws_dynamodb_ExportDescription(native_input):
    output = {}
    if "ExportArn" in native_input:
        output["ExportArn"] = native_input["ExportArn"]

    if "ExportStatus" in native_input:
        output["ExportStatus"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ExportStatus(
                native_input["ExportStatus"]
            )
        )

    if "StartTime" in native_input:
        output["StartTime"] = native_input["StartTime"]

    if "EndTime" in native_input:
        output["EndTime"] = native_input["EndTime"]

    if "ExportManifest" in native_input:
        output["ExportManifest"] = native_input["ExportManifest"]

    if "TableArn" in native_input:
        output["TableArn"] = native_input["TableArn"]

    if "TableId" in native_input:
        output["TableId"] = native_input["TableId"]

    if "ExportTime" in native_input:
        output["ExportTime"] = native_input["ExportTime"]

    if "ClientToken" in native_input:
        output["ClientToken"] = native_input["ClientToken"]

    if "S3Bucket" in native_input:
        output["S3Bucket"] = native_input["S3Bucket"]

    if "S3BucketOwner" in native_input:
        output["S3BucketOwner"] = native_input["S3BucketOwner"]

    if "S3Prefix" in native_input:
        output["S3Prefix"] = native_input["S3Prefix"]

    if "S3SseAlgorithm" in native_input:
        output["S3SseAlgorithm"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_S3SseAlgorithm(
                native_input["S3SseAlgorithm"]
            )
        )

    if "S3SseKmsKeyId" in native_input:
        output["S3SseKmsKeyId"] = native_input["S3SseKmsKeyId"]

    if "FailureCode" in native_input:
        output["FailureCode"] = native_input["FailureCode"]

    if "FailureMessage" in native_input:
        output["FailureMessage"] = native_input["FailureMessage"]

    if "ExportFormat" in native_input:
        output["ExportFormat"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ExportFormat(
                native_input["ExportFormat"]
            )
        )

    if "BilledSizeBytes" in native_input:
        output["BilledSizeBytes"] = native_input["BilledSizeBytes"]

    if "ItemCount" in native_input:
        output["ItemCount"] = native_input["ItemCount"]

    if "ExportType" in native_input:
        output["ExportType"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ExportType(
                native_input["ExportType"]
            )
        )

    if "IncrementalExportSpecification" in native_input:
        output["IncrementalExportSpecification"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_IncrementalExportSpecification(
                native_input["IncrementalExportSpecification"]
            )
        )

    return output


def com_amazonaws_dynamodb_ExportStatus(native_input):
    # Always return input enum
    return native_input


def com_amazonaws_dynamodb_S3SseAlgorithm(native_input):
    # Always return input enum
    return native_input


def com_amazonaws_dynamodb_ExportFormat(native_input):
    # Always return input enum
    return native_input


def com_amazonaws_dynamodb_ExportType(native_input):
    # Always return input enum
    return native_input


def com_amazonaws_dynamodb_IncrementalExportSpecification(native_input):
    output = {}
    if "ExportFromTime" in native_input:
        output["ExportFromTime"] = native_input["ExportFromTime"]

    if "ExportToTime" in native_input:
        output["ExportToTime"] = native_input["ExportToTime"]

    if "ExportViewType" in native_input:
        output["ExportViewType"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ExportViewType(
                native_input["ExportViewType"]
            )
        )

    return output


def com_amazonaws_dynamodb_ExportViewType(native_input):
    # Always return input enum
    return native_input


def com_amazonaws_dynamodb_DescribeGlobalTableInput(native_input):
    output = {}
    output["GlobalTableName"] = native_input["GlobalTableName"]
    return output


def com_amazonaws_dynamodb_DescribeGlobalTableOutput(native_input):
    output = {}
    if "GlobalTableDescription" in native_input:
        output["GlobalTableDescription"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_GlobalTableDescription(
                native_input["GlobalTableDescription"]
            )
        )

    return output


def com_amazonaws_dynamodb_DescribeGlobalTableSettingsInput(native_input):
    output = {}
    output["GlobalTableName"] = native_input["GlobalTableName"]
    return output


def com_amazonaws_dynamodb_DescribeGlobalTableSettingsOutput(native_input):
    output = {}
    if "GlobalTableName" in native_input:
        output["GlobalTableName"] = native_input["GlobalTableName"]

    if "ReplicaSettings" in native_input:
        output["ReplicaSettings"] = [
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ReplicaSettingsDescription(
                list_element
            )
            for list_element in native_input["ReplicaSettings"]
        ]

    return output


def com_amazonaws_dynamodb_ReplicaSettingsDescription(native_input):
    output = {}
    output["RegionName"] = native_input["RegionName"]
    if "ReplicaStatus" in native_input:
        output["ReplicaStatus"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ReplicaStatus(
                native_input["ReplicaStatus"]
            )
        )

    if "ReplicaBillingModeSummary" in native_input:
        output["ReplicaBillingModeSummary"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_BillingModeSummary(
                native_input["ReplicaBillingModeSummary"]
            )
        )

    if "ReplicaProvisionedReadCapacityUnits" in native_input:
        output["ReplicaProvisionedReadCapacityUnits"] = native_input[
            "ReplicaProvisionedReadCapacityUnits"
        ]

    if "ReplicaProvisionedReadCapacityAutoScalingSettings" in native_input:
        output["ReplicaProvisionedReadCapacityAutoScalingSettings"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_AutoScalingSettingsDescription(
                native_input["ReplicaProvisionedReadCapacityAutoScalingSettings"]
            )
        )

    if "ReplicaProvisionedWriteCapacityUnits" in native_input:
        output["ReplicaProvisionedWriteCapacityUnits"] = native_input[
            "ReplicaProvisionedWriteCapacityUnits"
        ]

    if "ReplicaProvisionedWriteCapacityAutoScalingSettings" in native_input:
        output["ReplicaProvisionedWriteCapacityAutoScalingSettings"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_AutoScalingSettingsDescription(
                native_input["ReplicaProvisionedWriteCapacityAutoScalingSettings"]
            )
        )

    if "ReplicaGlobalSecondaryIndexSettings" in native_input:
        output["ReplicaGlobalSecondaryIndexSettings"] = [
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ReplicaGlobalSecondaryIndexSettingsDescription(
                list_element
            )
            for list_element in native_input["ReplicaGlobalSecondaryIndexSettings"]
        ]

    if "ReplicaTableClassSummary" in native_input:
        output["ReplicaTableClassSummary"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_TableClassSummary(
                native_input["ReplicaTableClassSummary"]
            )
        )

    return output


def com_amazonaws_dynamodb_AutoScalingSettingsDescription(native_input):
    output = {}
    if "MinimumUnits" in native_input:
        output["MinimumUnits"] = native_input["MinimumUnits"]

    if "MaximumUnits" in native_input:
        output["MaximumUnits"] = native_input["MaximumUnits"]

    if "AutoScalingDisabled" in native_input:
        output["AutoScalingDisabled"] = native_input["AutoScalingDisabled"]

    if "AutoScalingRoleArn" in native_input:
        output["AutoScalingRoleArn"] = native_input["AutoScalingRoleArn"]

    if "ScalingPolicies" in native_input:
        output["ScalingPolicies"] = [
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_AutoScalingPolicyDescription(
                list_element
            )
            for list_element in native_input["ScalingPolicies"]
        ]

    return output


def com_amazonaws_dynamodb_ReplicaGlobalSecondaryIndexSettingsDescription(native_input):
    output = {}
    output["IndexName"] = native_input["IndexName"]
    if "IndexStatus" in native_input:
        output["IndexStatus"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_IndexStatus(
                native_input["IndexStatus"]
            )
        )

    if "ProvisionedReadCapacityUnits" in native_input:
        output["ProvisionedReadCapacityUnits"] = native_input[
            "ProvisionedReadCapacityUnits"
        ]

    if "ProvisionedReadCapacityAutoScalingSettings" in native_input:
        output["ProvisionedReadCapacityAutoScalingSettings"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_AutoScalingSettingsDescription(
                native_input["ProvisionedReadCapacityAutoScalingSettings"]
            )
        )

    if "ProvisionedWriteCapacityUnits" in native_input:
        output["ProvisionedWriteCapacityUnits"] = native_input[
            "ProvisionedWriteCapacityUnits"
        ]

    if "ProvisionedWriteCapacityAutoScalingSettings" in native_input:
        output["ProvisionedWriteCapacityAutoScalingSettings"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_AutoScalingSettingsDescription(
                native_input["ProvisionedWriteCapacityAutoScalingSettings"]
            )
        )

    return output


def com_amazonaws_dynamodb_AutoScalingPolicyDescription(native_input):
    output = {}
    if "PolicyName" in native_input:
        output["PolicyName"] = native_input["PolicyName"]

    if "TargetTrackingScalingPolicyConfiguration" in native_input:
        output["TargetTrackingScalingPolicyConfiguration"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_AutoScalingTargetTrackingScalingPolicyConfigurationDescription(
                native_input["TargetTrackingScalingPolicyConfiguration"]
            )
        )

    return output


def com_amazonaws_dynamodb_AutoScalingTargetTrackingScalingPolicyConfigurationDescription(
    native_input,
):
    output = {}
    if "DisableScaleIn" in native_input:
        output["DisableScaleIn"] = native_input["DisableScaleIn"]

    if "ScaleInCooldown" in native_input:
        output["ScaleInCooldown"] = native_input["ScaleInCooldown"]

    if "ScaleOutCooldown" in native_input:
        output["ScaleOutCooldown"] = native_input["ScaleOutCooldown"]

    output["TargetValue"] = native_input["TargetValue"]
    return output


def com_amazonaws_dynamodb_DescribeImportInput(native_input):
    output = {}
    output["ImportArn"] = native_input["ImportArn"]
    return output


def com_amazonaws_dynamodb_DescribeImportOutput(native_input):
    output = {}
    output["ImportTableDescription"] = (
        aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ImportTableDescription(
            native_input["ImportTableDescription"]
        )
    )
    return output


def com_amazonaws_dynamodb_ImportTableDescription(native_input):
    output = {}
    if "ImportArn" in native_input:
        output["ImportArn"] = native_input["ImportArn"]

    if "ImportStatus" in native_input:
        output["ImportStatus"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ImportStatus(
                native_input["ImportStatus"]
            )
        )

    if "TableArn" in native_input:
        output["TableArn"] = native_input["TableArn"]

    if "TableId" in native_input:
        output["TableId"] = native_input["TableId"]

    if "ClientToken" in native_input:
        output["ClientToken"] = native_input["ClientToken"]

    if "S3BucketSource" in native_input:
        output["S3BucketSource"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_S3BucketSource(
                native_input["S3BucketSource"]
            )
        )

    if "ErrorCount" in native_input:
        output["ErrorCount"] = native_input["ErrorCount"]

    if "CloudWatchLogGroupArn" in native_input:
        output["CloudWatchLogGroupArn"] = native_input["CloudWatchLogGroupArn"]

    if "InputFormat" in native_input:
        output["InputFormat"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_InputFormat(
                native_input["InputFormat"]
            )
        )

    if "InputFormatOptions" in native_input:
        output["InputFormatOptions"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_InputFormatOptions(
                native_input["InputFormatOptions"]
            )
        )

    if "InputCompressionType" in native_input:
        output["InputCompressionType"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_InputCompressionType(
                native_input["InputCompressionType"]
            )
        )

    if "TableCreationParameters" in native_input:
        output["TableCreationParameters"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_TableCreationParameters(
                native_input["TableCreationParameters"]
            )
        )

    if "StartTime" in native_input:
        output["StartTime"] = native_input["StartTime"]

    if "EndTime" in native_input:
        output["EndTime"] = native_input["EndTime"]

    if "ProcessedSizeBytes" in native_input:
        output["ProcessedSizeBytes"] = native_input["ProcessedSizeBytes"]

    if "ProcessedItemCount" in native_input:
        output["ProcessedItemCount"] = native_input["ProcessedItemCount"]

    if "ImportedItemCount" in native_input:
        output["ImportedItemCount"] = native_input["ImportedItemCount"]

    if "FailureCode" in native_input:
        output["FailureCode"] = native_input["FailureCode"]

    if "FailureMessage" in native_input:
        output["FailureMessage"] = native_input["FailureMessage"]

    return output


def com_amazonaws_dynamodb_ImportStatus(native_input):
    # Always return input enum
    return native_input


def com_amazonaws_dynamodb_S3BucketSource(native_input):
    output = {}
    if "S3BucketOwner" in native_input:
        output["S3BucketOwner"] = native_input["S3BucketOwner"]

    output["S3Bucket"] = native_input["S3Bucket"]
    if "S3KeyPrefix" in native_input:
        output["S3KeyPrefix"] = native_input["S3KeyPrefix"]

    return output


def com_amazonaws_dynamodb_InputFormat(native_input):
    # Always return input enum
    return native_input


def com_amazonaws_dynamodb_InputFormatOptions(native_input):
    output = {}
    if "Csv" in native_input:
        output["Csv"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_CsvOptions(
                native_input["Csv"]
            )
        )

    return output


def com_amazonaws_dynamodb_InputCompressionType(native_input):
    # Always return input enum
    return native_input


def com_amazonaws_dynamodb_TableCreationParameters(native_input):
    output = {}
    output["TableName"] = native_input["TableName"]
    output["AttributeDefinitions"] = [
        aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_AttributeDefinition(
            list_element
        )
        for list_element in native_input["AttributeDefinitions"]
    ]
    output["KeySchema"] = [
        aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_KeySchemaElement(
            list_element
        )
        for list_element in native_input["KeySchema"]
    ]
    if "BillingMode" in native_input:
        output["BillingMode"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_BillingMode(
                native_input["BillingMode"]
            )
        )

    if "ProvisionedThroughput" in native_input:
        output["ProvisionedThroughput"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ProvisionedThroughput(
                native_input["ProvisionedThroughput"]
            )
        )

    if "OnDemandThroughput" in native_input:
        output["OnDemandThroughput"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_OnDemandThroughput(
                native_input["OnDemandThroughput"]
            )
        )

    if "SSESpecification" in native_input:
        output["SSESpecification"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_SSESpecification(
                native_input["SSESpecification"]
            )
        )

    if "GlobalSecondaryIndexes" in native_input:
        output["GlobalSecondaryIndexes"] = [
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_GlobalSecondaryIndex(
                list_element
            )
            for list_element in native_input["GlobalSecondaryIndexes"]
        ]

    return output


def com_amazonaws_dynamodb_CsvOptions(native_input):
    output = {}
    if "Delimiter" in native_input:
        output["Delimiter"] = native_input["Delimiter"]

    if "HeaderList" in native_input:
        output["HeaderList"] = [
            list_element for list_element in native_input["HeaderList"]
        ]

    return output


def com_amazonaws_dynamodb_DescribeKinesisStreamingDestinationInput(native_input):
    output = {}
    output["TableName"] = native_input["TableName"]
    return output


def com_amazonaws_dynamodb_DescribeKinesisStreamingDestinationOutput(native_input):
    output = {}
    if "TableName" in native_input:
        output["TableName"] = native_input["TableName"]

    if "KinesisDataStreamDestinations" in native_input:
        output["KinesisDataStreamDestinations"] = [
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_KinesisDataStreamDestination(
                list_element
            )
            for list_element in native_input["KinesisDataStreamDestinations"]
        ]

    return output


def com_amazonaws_dynamodb_KinesisDataStreamDestination(native_input):
    output = {}
    if "StreamArn" in native_input:
        output["StreamArn"] = native_input["StreamArn"]

    if "DestinationStatus" in native_input:
        output["DestinationStatus"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_DestinationStatus(
                native_input["DestinationStatus"]
            )
        )

    if "DestinationStatusDescription" in native_input:
        output["DestinationStatusDescription"] = native_input[
            "DestinationStatusDescription"
        ]

    if "ApproximateCreationDateTimePrecision" in native_input:
        output["ApproximateCreationDateTimePrecision"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ApproximateCreationDateTimePrecision(
                native_input["ApproximateCreationDateTimePrecision"]
            )
        )

    return output


def com_amazonaws_dynamodb_DestinationStatus(native_input):
    # Always return input enum
    return native_input


def com_amazonaws_dynamodb_ApproximateCreationDateTimePrecision(native_input):
    # Always return input enum
    return native_input


def com_amazonaws_dynamodb_DescribeLimitsInput(native_input):
    output = {}
    return output


def com_amazonaws_dynamodb_DescribeLimitsOutput(native_input):
    output = {}
    if "AccountMaxReadCapacityUnits" in native_input:
        output["AccountMaxReadCapacityUnits"] = native_input[
            "AccountMaxReadCapacityUnits"
        ]

    if "AccountMaxWriteCapacityUnits" in native_input:
        output["AccountMaxWriteCapacityUnits"] = native_input[
            "AccountMaxWriteCapacityUnits"
        ]

    if "TableMaxReadCapacityUnits" in native_input:
        output["TableMaxReadCapacityUnits"] = native_input["TableMaxReadCapacityUnits"]

    if "TableMaxWriteCapacityUnits" in native_input:
        output["TableMaxWriteCapacityUnits"] = native_input[
            "TableMaxWriteCapacityUnits"
        ]

    return output


def com_amazonaws_dynamodb_DescribeTableInput(native_input):
    output = {}
    output["TableName"] = native_input["TableName"]
    return output


def com_amazonaws_dynamodb_DescribeTableOutput(native_input):
    output = {}
    if "Table" in native_input:
        output["Table"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_TableDescription(
                native_input["Table"]
            )
        )

    return output


def com_amazonaws_dynamodb_DescribeTableReplicaAutoScalingInput(native_input):
    output = {}
    output["TableName"] = native_input["TableName"]
    return output


def com_amazonaws_dynamodb_DescribeTableReplicaAutoScalingOutput(native_input):
    output = {}
    if "TableAutoScalingDescription" in native_input:
        output["TableAutoScalingDescription"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_TableAutoScalingDescription(
                native_input["TableAutoScalingDescription"]
            )
        )

    return output


def com_amazonaws_dynamodb_TableAutoScalingDescription(native_input):
    output = {}
    if "TableName" in native_input:
        output["TableName"] = native_input["TableName"]

    if "TableStatus" in native_input:
        output["TableStatus"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_TableStatus(
                native_input["TableStatus"]
            )
        )

    if "Replicas" in native_input:
        output["Replicas"] = [
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ReplicaAutoScalingDescription(
                list_element
            )
            for list_element in native_input["Replicas"]
        ]

    return output


def com_amazonaws_dynamodb_ReplicaAutoScalingDescription(native_input):
    output = {}
    if "RegionName" in native_input:
        output["RegionName"] = native_input["RegionName"]

    if "GlobalSecondaryIndexes" in native_input:
        output["GlobalSecondaryIndexes"] = [
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ReplicaGlobalSecondaryIndexAutoScalingDescription(
                list_element
            )
            for list_element in native_input["GlobalSecondaryIndexes"]
        ]

    if "ReplicaProvisionedReadCapacityAutoScalingSettings" in native_input:
        output["ReplicaProvisionedReadCapacityAutoScalingSettings"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_AutoScalingSettingsDescription(
                native_input["ReplicaProvisionedReadCapacityAutoScalingSettings"]
            )
        )

    if "ReplicaProvisionedWriteCapacityAutoScalingSettings" in native_input:
        output["ReplicaProvisionedWriteCapacityAutoScalingSettings"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_AutoScalingSettingsDescription(
                native_input["ReplicaProvisionedWriteCapacityAutoScalingSettings"]
            )
        )

    if "ReplicaStatus" in native_input:
        output["ReplicaStatus"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ReplicaStatus(
                native_input["ReplicaStatus"]
            )
        )

    return output


def com_amazonaws_dynamodb_ReplicaGlobalSecondaryIndexAutoScalingDescription(
    native_input,
):
    output = {}
    if "IndexName" in native_input:
        output["IndexName"] = native_input["IndexName"]

    if "IndexStatus" in native_input:
        output["IndexStatus"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_IndexStatus(
                native_input["IndexStatus"]
            )
        )

    if "ProvisionedReadCapacityAutoScalingSettings" in native_input:
        output["ProvisionedReadCapacityAutoScalingSettings"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_AutoScalingSettingsDescription(
                native_input["ProvisionedReadCapacityAutoScalingSettings"]
            )
        )

    if "ProvisionedWriteCapacityAutoScalingSettings" in native_input:
        output["ProvisionedWriteCapacityAutoScalingSettings"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_AutoScalingSettingsDescription(
                native_input["ProvisionedWriteCapacityAutoScalingSettings"]
            )
        )

    return output


def com_amazonaws_dynamodb_DescribeTimeToLiveInput(native_input):
    output = {}
    output["TableName"] = native_input["TableName"]
    return output


def com_amazonaws_dynamodb_DescribeTimeToLiveOutput(native_input):
    output = {}
    if "TimeToLiveDescription" in native_input:
        output["TimeToLiveDescription"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_TimeToLiveDescription(
                native_input["TimeToLiveDescription"]
            )
        )

    return output


def com_amazonaws_dynamodb_DisableKinesisStreamingDestinationInput(native_input):
    output = {}
    output["TableName"] = native_input["TableName"]
    output["StreamArn"] = native_input["StreamArn"]
    if "EnableKinesisStreamingConfiguration" in native_input:
        output["EnableKinesisStreamingConfiguration"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_EnableKinesisStreamingConfiguration(
                native_input["EnableKinesisStreamingConfiguration"]
            )
        )

    return output


def com_amazonaws_dynamodb_EnableKinesisStreamingConfiguration(native_input):
    output = {}
    if "ApproximateCreationDateTimePrecision" in native_input:
        output["ApproximateCreationDateTimePrecision"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ApproximateCreationDateTimePrecision(
                native_input["ApproximateCreationDateTimePrecision"]
            )
        )

    return output


def com_amazonaws_dynamodb_DisableKinesisStreamingDestinationOutput(native_input):
    output = {}
    if "TableName" in native_input:
        output["TableName"] = native_input["TableName"]

    if "StreamArn" in native_input:
        output["StreamArn"] = native_input["StreamArn"]

    if "DestinationStatus" in native_input:
        output["DestinationStatus"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_DestinationStatus(
                native_input["DestinationStatus"]
            )
        )

    if "EnableKinesisStreamingConfiguration" in native_input:
        output["EnableKinesisStreamingConfiguration"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_EnableKinesisStreamingConfiguration(
                native_input["EnableKinesisStreamingConfiguration"]
            )
        )

    return output


def com_amazonaws_dynamodb_EnableKinesisStreamingDestinationInput(native_input):
    output = {}
    output["TableName"] = native_input["TableName"]
    output["StreamArn"] = native_input["StreamArn"]
    if "EnableKinesisStreamingConfiguration" in native_input:
        output["EnableKinesisStreamingConfiguration"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_EnableKinesisStreamingConfiguration(
                native_input["EnableKinesisStreamingConfiguration"]
            )
        )

    return output


def com_amazonaws_dynamodb_EnableKinesisStreamingDestinationOutput(native_input):
    output = {}
    if "TableName" in native_input:
        output["TableName"] = native_input["TableName"]

    if "StreamArn" in native_input:
        output["StreamArn"] = native_input["StreamArn"]

    if "DestinationStatus" in native_input:
        output["DestinationStatus"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_DestinationStatus(
                native_input["DestinationStatus"]
            )
        )

    if "EnableKinesisStreamingConfiguration" in native_input:
        output["EnableKinesisStreamingConfiguration"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_EnableKinesisStreamingConfiguration(
                native_input["EnableKinesisStreamingConfiguration"]
            )
        )

    return output


def com_amazonaws_dynamodb_ExecuteStatementInput(native_input):
    output = {}
    output["Statement"] = native_input["Statement"]
    if "Parameters" in native_input:
        output["Parameters"] = [
            TypeSerializer().serialize(list_element)
            for list_element in native_input["Parameters"]
        ]

    if "ConsistentRead" in native_input:
        output["ConsistentRead"] = native_input["ConsistentRead"]

    if "NextToken" in native_input:
        output["NextToken"] = native_input["NextToken"]

    if "ReturnConsumedCapacity" in native_input:
        output["ReturnConsumedCapacity"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ReturnConsumedCapacity(
                native_input["ReturnConsumedCapacity"]
            )
        )

    if "Limit" in native_input:
        output["Limit"] = native_input["Limit"]

    return output


def com_amazonaws_dynamodb_ExecuteStatementOutput(native_input):
    output = {}
    if "Items" in native_input:
        output["Items"] = [
            {
                key: TypeSerializer().serialize(value)
                for (key, value) in list_element.items()
            }
            for list_element in native_input["Items"]
        ]

    if "NextToken" in native_input:
        output["NextToken"] = native_input["NextToken"]

    if "ConsumedCapacity" in native_input:
        output["ConsumedCapacity"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ConsumedCapacity(
                native_input["ConsumedCapacity"]
            )
        )

    if "LastEvaluatedKey" in native_input:
        output["LastEvaluatedKey"] = {
            key: TypeSerializer().serialize(value)
            for (key, value) in native_input["LastEvaluatedKey"].items()
        }

    return output


def com_amazonaws_dynamodb_ExecuteTransactionInput(native_input):
    output = {}
    output["TransactStatements"] = [
        aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ParameterizedStatement(
            list_element
        )
        for list_element in native_input["TransactStatements"]
    ]
    if "ClientRequestToken" in native_input:
        output["ClientRequestToken"] = native_input["ClientRequestToken"]

    if "ReturnConsumedCapacity" in native_input:
        output["ReturnConsumedCapacity"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ReturnConsumedCapacity(
                native_input["ReturnConsumedCapacity"]
            )
        )

    return output


def com_amazonaws_dynamodb_ParameterizedStatement(native_input):
    output = {}
    output["Statement"] = native_input["Statement"]
    if "Parameters" in native_input:
        output["Parameters"] = [
            TypeSerializer().serialize(list_element)
            for list_element in native_input["Parameters"]
        ]

    return output


def com_amazonaws_dynamodb_ExecuteTransactionOutput(native_input):
    output = {}
    if "Responses" in native_input:
        output["Responses"] = [
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ItemResponse(
                list_element
            )
            for list_element in native_input["Responses"]
        ]

    if "ConsumedCapacity" in native_input:
        output["ConsumedCapacity"] = [
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ConsumedCapacity(
                list_element
            )
            for list_element in native_input["ConsumedCapacity"]
        ]

    return output


def com_amazonaws_dynamodb_ItemResponse(native_input):
    output = {}
    if "Item" in native_input:
        output["Item"] = {
            key: TypeSerializer().serialize(value)
            for (key, value) in native_input["Item"].items()
        }

    return output


def com_amazonaws_dynamodb_ExportTableToPointInTimeInput(native_input):
    output = {}
    output["TableArn"] = native_input["TableArn"]
    if "ExportTime" in native_input:
        output["ExportTime"] = native_input["ExportTime"]

    if "ClientToken" in native_input:
        output["ClientToken"] = native_input["ClientToken"]

    output["S3Bucket"] = native_input["S3Bucket"]
    if "S3BucketOwner" in native_input:
        output["S3BucketOwner"] = native_input["S3BucketOwner"]

    if "S3Prefix" in native_input:
        output["S3Prefix"] = native_input["S3Prefix"]

    if "S3SseAlgorithm" in native_input:
        output["S3SseAlgorithm"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_S3SseAlgorithm(
                native_input["S3SseAlgorithm"]
            )
        )

    if "S3SseKmsKeyId" in native_input:
        output["S3SseKmsKeyId"] = native_input["S3SseKmsKeyId"]

    if "ExportFormat" in native_input:
        output["ExportFormat"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ExportFormat(
                native_input["ExportFormat"]
            )
        )

    if "ExportType" in native_input:
        output["ExportType"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ExportType(
                native_input["ExportType"]
            )
        )

    if "IncrementalExportSpecification" in native_input:
        output["IncrementalExportSpecification"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_IncrementalExportSpecification(
                native_input["IncrementalExportSpecification"]
            )
        )

    return output


def com_amazonaws_dynamodb_ExportTableToPointInTimeOutput(native_input):
    output = {}
    if "ExportDescription" in native_input:
        output["ExportDescription"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ExportDescription(
                native_input["ExportDescription"]
            )
        )

    return output


def com_amazonaws_dynamodb_GetItemInput(native_input):
    output = {}
    output["TableName"] = native_input["TableName"]
    output["Key"] = {
        key: TypeSerializer().serialize(value)
        for (key, value) in native_input["Key"].items()
    }
    if "AttributesToGet" in native_input:
        output["AttributesToGet"] = [
            list_element for list_element in native_input["AttributesToGet"]
        ]

    if "ConsistentRead" in native_input:
        output["ConsistentRead"] = native_input["ConsistentRead"]

    if "ReturnConsumedCapacity" in native_input:
        output["ReturnConsumedCapacity"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ReturnConsumedCapacity(
                native_input["ReturnConsumedCapacity"]
            )
        )

    if "ProjectionExpression" in native_input:
        output["ProjectionExpression"] = native_input["ProjectionExpression"]

    if "ExpressionAttributeNames" in native_input:
        output["ExpressionAttributeNames"] = {
            key: value
            for (key, value) in native_input["ExpressionAttributeNames"].items()
        }

    return output


def com_amazonaws_dynamodb_GetItemOutput(native_input):
    output = {}
    if "Item" in native_input:
        output["Item"] = {
            key: TypeSerializer().serialize(value)
            for (key, value) in native_input["Item"].items()
        }

    if "ConsumedCapacity" in native_input:
        output["ConsumedCapacity"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ConsumedCapacity(
                native_input["ConsumedCapacity"]
            )
        )

    return output


def com_amazonaws_dynamodb_GetResourcePolicyInput(native_input):
    output = {}
    output["ResourceArn"] = native_input["ResourceArn"]
    return output


def com_amazonaws_dynamodb_GetResourcePolicyOutput(native_input):
    output = {}
    if "Policy" in native_input:
        output["Policy"] = native_input["Policy"]

    if "RevisionId" in native_input:
        output["RevisionId"] = native_input["RevisionId"]

    return output


def com_amazonaws_dynamodb_ImportTableInput(native_input):
    output = {}
    if "ClientToken" in native_input:
        output["ClientToken"] = native_input["ClientToken"]

    output["S3BucketSource"] = (
        aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_S3BucketSource(
            native_input["S3BucketSource"]
        )
    )
    output["InputFormat"] = (
        aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_InputFormat(
            native_input["InputFormat"]
        )
    )
    if "InputFormatOptions" in native_input:
        output["InputFormatOptions"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_InputFormatOptions(
                native_input["InputFormatOptions"]
            )
        )

    if "InputCompressionType" in native_input:
        output["InputCompressionType"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_InputCompressionType(
                native_input["InputCompressionType"]
            )
        )

    output["TableCreationParameters"] = (
        aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_TableCreationParameters(
            native_input["TableCreationParameters"]
        )
    )
    return output


def com_amazonaws_dynamodb_ImportTableOutput(native_input):
    output = {}
    output["ImportTableDescription"] = (
        aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ImportTableDescription(
            native_input["ImportTableDescription"]
        )
    )
    return output


def com_amazonaws_dynamodb_ListBackupsInput(native_input):
    output = {}
    if "TableName" in native_input:
        output["TableName"] = native_input["TableName"]

    if "Limit" in native_input:
        output["Limit"] = native_input["Limit"]

    if "TimeRangeLowerBound" in native_input:
        output["TimeRangeLowerBound"] = native_input["TimeRangeLowerBound"]

    if "TimeRangeUpperBound" in native_input:
        output["TimeRangeUpperBound"] = native_input["TimeRangeUpperBound"]

    if "ExclusiveStartBackupArn" in native_input:
        output["ExclusiveStartBackupArn"] = native_input["ExclusiveStartBackupArn"]

    if "BackupType" in native_input:
        output["BackupType"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_BackupTypeFilter(
                native_input["BackupType"]
            )
        )

    return output


def com_amazonaws_dynamodb_BackupTypeFilter(native_input):
    # Always return input enum
    return native_input


def com_amazonaws_dynamodb_ListBackupsOutput(native_input):
    output = {}
    if "BackupSummaries" in native_input:
        output["BackupSummaries"] = [
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_BackupSummary(
                list_element
            )
            for list_element in native_input["BackupSummaries"]
        ]

    if "LastEvaluatedBackupArn" in native_input:
        output["LastEvaluatedBackupArn"] = native_input["LastEvaluatedBackupArn"]

    return output


def com_amazonaws_dynamodb_BackupSummary(native_input):
    output = {}
    if "TableName" in native_input:
        output["TableName"] = native_input["TableName"]

    if "TableId" in native_input:
        output["TableId"] = native_input["TableId"]

    if "TableArn" in native_input:
        output["TableArn"] = native_input["TableArn"]

    if "BackupArn" in native_input:
        output["BackupArn"] = native_input["BackupArn"]

    if "BackupName" in native_input:
        output["BackupName"] = native_input["BackupName"]

    if "BackupCreationDateTime" in native_input:
        output["BackupCreationDateTime"] = native_input["BackupCreationDateTime"]

    if "BackupExpiryDateTime" in native_input:
        output["BackupExpiryDateTime"] = native_input["BackupExpiryDateTime"]

    if "BackupStatus" in native_input:
        output["BackupStatus"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_BackupStatus(
                native_input["BackupStatus"]
            )
        )

    if "BackupType" in native_input:
        output["BackupType"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_BackupType(
                native_input["BackupType"]
            )
        )

    if "BackupSizeBytes" in native_input:
        output["BackupSizeBytes"] = native_input["BackupSizeBytes"]

    return output


def com_amazonaws_dynamodb_ListContributorInsightsInput(native_input):
    output = {}
    if "TableName" in native_input:
        output["TableName"] = native_input["TableName"]

    if "NextToken" in native_input:
        output["NextToken"] = native_input["NextToken"]

    if "MaxResults" in native_input:
        output["MaxResults"] = native_input["MaxResults"]

    return output


def com_amazonaws_dynamodb_ListContributorInsightsOutput(native_input):
    output = {}
    if "ContributorInsightsSummaries" in native_input:
        output["ContributorInsightsSummaries"] = [
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ContributorInsightsSummary(
                list_element
            )
            for list_element in native_input["ContributorInsightsSummaries"]
        ]

    if "NextToken" in native_input:
        output["NextToken"] = native_input["NextToken"]

    return output


def com_amazonaws_dynamodb_ContributorInsightsSummary(native_input):
    output = {}
    if "TableName" in native_input:
        output["TableName"] = native_input["TableName"]

    if "IndexName" in native_input:
        output["IndexName"] = native_input["IndexName"]

    if "ContributorInsightsStatus" in native_input:
        output["ContributorInsightsStatus"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ContributorInsightsStatus(
                native_input["ContributorInsightsStatus"]
            )
        )

    return output


def com_amazonaws_dynamodb_ListExportsInput(native_input):
    output = {}
    if "TableArn" in native_input:
        output["TableArn"] = native_input["TableArn"]

    if "MaxResults" in native_input:
        output["MaxResults"] = native_input["MaxResults"]

    if "NextToken" in native_input:
        output["NextToken"] = native_input["NextToken"]

    return output


def com_amazonaws_dynamodb_ListExportsOutput(native_input):
    output = {}
    if "ExportSummaries" in native_input:
        output["ExportSummaries"] = [
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ExportSummary(
                list_element
            )
            for list_element in native_input["ExportSummaries"]
        ]

    if "NextToken" in native_input:
        output["NextToken"] = native_input["NextToken"]

    return output


def com_amazonaws_dynamodb_ExportSummary(native_input):
    output = {}
    if "ExportArn" in native_input:
        output["ExportArn"] = native_input["ExportArn"]

    if "ExportStatus" in native_input:
        output["ExportStatus"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ExportStatus(
                native_input["ExportStatus"]
            )
        )

    if "ExportType" in native_input:
        output["ExportType"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ExportType(
                native_input["ExportType"]
            )
        )

    return output


def com_amazonaws_dynamodb_ListGlobalTablesInput(native_input):
    output = {}
    if "ExclusiveStartGlobalTableName" in native_input:
        output["ExclusiveStartGlobalTableName"] = native_input[
            "ExclusiveStartGlobalTableName"
        ]

    if "Limit" in native_input:
        output["Limit"] = native_input["Limit"]

    if "RegionName" in native_input:
        output["RegionName"] = native_input["RegionName"]

    return output


def com_amazonaws_dynamodb_ListGlobalTablesOutput(native_input):
    output = {}
    if "GlobalTables" in native_input:
        output["GlobalTables"] = [
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_GlobalTable(
                list_element
            )
            for list_element in native_input["GlobalTables"]
        ]

    if "LastEvaluatedGlobalTableName" in native_input:
        output["LastEvaluatedGlobalTableName"] = native_input[
            "LastEvaluatedGlobalTableName"
        ]

    return output


def com_amazonaws_dynamodb_GlobalTable(native_input):
    output = {}
    if "GlobalTableName" in native_input:
        output["GlobalTableName"] = native_input["GlobalTableName"]

    if "ReplicationGroup" in native_input:
        output["ReplicationGroup"] = [
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_Replica(
                list_element
            )
            for list_element in native_input["ReplicationGroup"]
        ]

    return output


def com_amazonaws_dynamodb_ListImportsInput(native_input):
    output = {}
    if "TableArn" in native_input:
        output["TableArn"] = native_input["TableArn"]

    if "PageSize" in native_input:
        output["PageSize"] = native_input["PageSize"]

    if "NextToken" in native_input:
        output["NextToken"] = native_input["NextToken"]

    return output


def com_amazonaws_dynamodb_ListImportsOutput(native_input):
    output = {}
    if "ImportSummaryList" in native_input:
        output["ImportSummaryList"] = [
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ImportSummary(
                list_element
            )
            for list_element in native_input["ImportSummaryList"]
        ]

    if "NextToken" in native_input:
        output["NextToken"] = native_input["NextToken"]

    return output


def com_amazonaws_dynamodb_ImportSummary(native_input):
    output = {}
    if "ImportArn" in native_input:
        output["ImportArn"] = native_input["ImportArn"]

    if "ImportStatus" in native_input:
        output["ImportStatus"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ImportStatus(
                native_input["ImportStatus"]
            )
        )

    if "TableArn" in native_input:
        output["TableArn"] = native_input["TableArn"]

    if "S3BucketSource" in native_input:
        output["S3BucketSource"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_S3BucketSource(
                native_input["S3BucketSource"]
            )
        )

    if "CloudWatchLogGroupArn" in native_input:
        output["CloudWatchLogGroupArn"] = native_input["CloudWatchLogGroupArn"]

    if "InputFormat" in native_input:
        output["InputFormat"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_InputFormat(
                native_input["InputFormat"]
            )
        )

    if "StartTime" in native_input:
        output["StartTime"] = native_input["StartTime"]

    if "EndTime" in native_input:
        output["EndTime"] = native_input["EndTime"]

    return output


def com_amazonaws_dynamodb_ListTablesInput(native_input):
    output = {}
    if "ExclusiveStartTableName" in native_input:
        output["ExclusiveStartTableName"] = native_input["ExclusiveStartTableName"]

    if "Limit" in native_input:
        output["Limit"] = native_input["Limit"]

    return output


def com_amazonaws_dynamodb_ListTablesOutput(native_input):
    output = {}
    if "TableNames" in native_input:
        output["TableNames"] = [
            list_element for list_element in native_input["TableNames"]
        ]

    if "LastEvaluatedTableName" in native_input:
        output["LastEvaluatedTableName"] = native_input["LastEvaluatedTableName"]

    return output


def com_amazonaws_dynamodb_ListTagsOfResourceInput(native_input):
    output = {}
    output["ResourceArn"] = native_input["ResourceArn"]
    if "NextToken" in native_input:
        output["NextToken"] = native_input["NextToken"]

    return output


def com_amazonaws_dynamodb_ListTagsOfResourceOutput(native_input):
    output = {}
    if "Tags" in native_input:
        output["Tags"] = [
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_Tag(
                list_element
            )
            for list_element in native_input["Tags"]
        ]

    if "NextToken" in native_input:
        output["NextToken"] = native_input["NextToken"]

    return output


def com_amazonaws_dynamodb_PutItemInput(native_input):
    output = {}
    output["TableName"] = native_input["TableName"]
    output["Item"] = {
        key: TypeSerializer().serialize(value)
        for (key, value) in native_input["Item"].items()
    }
    if "Expected" in native_input:
        output["Expected"] = {
            key: aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ExpectedAttributeValue(
                value
            )
            for (key, value) in native_input["Expected"].items()
        }

    if "ReturnValues" in native_input:
        output["ReturnValues"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ReturnValue(
                native_input["ReturnValues"]
            )
        )

    if "ReturnConsumedCapacity" in native_input:
        output["ReturnConsumedCapacity"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ReturnConsumedCapacity(
                native_input["ReturnConsumedCapacity"]
            )
        )

    if "ReturnItemCollectionMetrics" in native_input:
        output["ReturnItemCollectionMetrics"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ReturnItemCollectionMetrics(
                native_input["ReturnItemCollectionMetrics"]
            )
        )

    if "ConditionalOperator" in native_input:
        output["ConditionalOperator"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ConditionalOperator(
                native_input["ConditionalOperator"]
            )
        )

    if "ConditionExpression" in native_input:
        output["ConditionExpression"] = native_input["ConditionExpression"]

    if "ExpressionAttributeNames" in native_input:
        output["ExpressionAttributeNames"] = {
            key: value
            for (key, value) in native_input["ExpressionAttributeNames"].items()
        }

    if "ExpressionAttributeValues" in native_input:
        output["ExpressionAttributeValues"] = {
            key: TypeSerializer().serialize(value)
            for (key, value) in native_input["ExpressionAttributeValues"].items()
        }

    return output


def com_amazonaws_dynamodb_PutItemOutput(native_input):
    output = {}
    if "Attributes" in native_input:
        output["Attributes"] = {
            key: TypeSerializer().serialize(value)
            for (key, value) in native_input["Attributes"].items()
        }

    if "ConsumedCapacity" in native_input:
        output["ConsumedCapacity"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ConsumedCapacity(
                native_input["ConsumedCapacity"]
            )
        )

    if "ItemCollectionMetrics" in native_input:
        output["ItemCollectionMetrics"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ItemCollectionMetrics(
                native_input["ItemCollectionMetrics"]
            )
        )

    return output


def com_amazonaws_dynamodb_PutResourcePolicyInput(native_input):
    output = {}
    output["ResourceArn"] = native_input["ResourceArn"]
    output["Policy"] = native_input["Policy"]
    if "ExpectedRevisionId" in native_input:
        output["ExpectedRevisionId"] = native_input["ExpectedRevisionId"]

    if "ConfirmRemoveSelfResourceAccess" in native_input:
        output["ConfirmRemoveSelfResourceAccess"] = native_input[
            "ConfirmRemoveSelfResourceAccess"
        ]

    return output


def com_amazonaws_dynamodb_PutResourcePolicyOutput(native_input):
    output = {}
    if "RevisionId" in native_input:
        output["RevisionId"] = native_input["RevisionId"]

    return output


def com_amazonaws_dynamodb_QueryInput(native_input):
    output = {}
    output["TableName"] = native_input["TableName"]
    if "IndexName" in native_input:
        output["IndexName"] = native_input["IndexName"]

    if "Select" in native_input:
        output["Select"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_Select(
                native_input["Select"]
            )
        )

    if "AttributesToGet" in native_input:
        output["AttributesToGet"] = [
            list_element for list_element in native_input["AttributesToGet"]
        ]

    if "Limit" in native_input:
        output["Limit"] = native_input["Limit"]

    if "ConsistentRead" in native_input:
        output["ConsistentRead"] = native_input["ConsistentRead"]

    if "KeyConditions" in native_input:
        output["KeyConditions"] = {
            key: aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_Condition(
                value
            )
            for (key, value) in native_input["KeyConditions"].items()
        }

    if "QueryFilter" in native_input:
        output["QueryFilter"] = {
            key: aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_Condition(
                value
            )
            for (key, value) in native_input["QueryFilter"].items()
        }

    if "ConditionalOperator" in native_input:
        output["ConditionalOperator"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ConditionalOperator(
                native_input["ConditionalOperator"]
            )
        )

    if "ScanIndexForward" in native_input:
        output["ScanIndexForward"] = native_input["ScanIndexForward"]

    if "ExclusiveStartKey" in native_input:
        output["ExclusiveStartKey"] = {
            key: TypeSerializer().serialize(value)
            for (key, value) in native_input["ExclusiveStartKey"].items()
        }

    if "ReturnConsumedCapacity" in native_input:
        output["ReturnConsumedCapacity"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ReturnConsumedCapacity(
                native_input["ReturnConsumedCapacity"]
            )
        )

    if "ProjectionExpression" in native_input:
        output["ProjectionExpression"] = native_input["ProjectionExpression"]

    if "FilterExpression" in native_input:
        output["FilterExpression"] = native_input["FilterExpression"]

    if "KeyConditionExpression" in native_input:
        output["KeyConditionExpression"] = native_input["KeyConditionExpression"]

    if "ExpressionAttributeNames" in native_input:
        output["ExpressionAttributeNames"] = {
            key: value
            for (key, value) in native_input["ExpressionAttributeNames"].items()
        }

    if "ExpressionAttributeValues" in native_input:
        output["ExpressionAttributeValues"] = {
            key: TypeSerializer().serialize(value)
            for (key, value) in native_input["ExpressionAttributeValues"].items()
        }

    return output


def com_amazonaws_dynamodb_Select(native_input):
    # Always return input enum
    return native_input


def com_amazonaws_dynamodb_Condition(native_input):
    output = {}
    if "AttributeValueList" in native_input:
        output["AttributeValueList"] = [
            TypeSerializer().serialize(list_element)
            for list_element in native_input["AttributeValueList"]
        ]

    output["ComparisonOperator"] = (
        aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ComparisonOperator(
            native_input["ComparisonOperator"]
        )
    )
    return output


def com_amazonaws_dynamodb_QueryOutput(native_input):
    output = {}
    if "Items" in native_input:
        output["Items"] = [
            {
                key: TypeSerializer().serialize(value)
                for (key, value) in list_element.items()
            }
            for list_element in native_input["Items"]
        ]

    if "Count" in native_input:
        output["Count"] = native_input["Count"]

    if "ScannedCount" in native_input:
        output["ScannedCount"] = native_input["ScannedCount"]

    if "LastEvaluatedKey" in native_input:
        output["LastEvaluatedKey"] = {
            key: TypeSerializer().serialize(value)
            for (key, value) in native_input["LastEvaluatedKey"].items()
        }

    if "ConsumedCapacity" in native_input:
        output["ConsumedCapacity"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ConsumedCapacity(
                native_input["ConsumedCapacity"]
            )
        )

    return output


def com_amazonaws_dynamodb_RestoreTableFromBackupInput(native_input):
    output = {}
    output["TargetTableName"] = native_input["TargetTableName"]
    output["BackupArn"] = native_input["BackupArn"]
    if "BillingModeOverride" in native_input:
        output["BillingModeOverride"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_BillingMode(
                native_input["BillingModeOverride"]
            )
        )

    if "GlobalSecondaryIndexOverride" in native_input:
        output["GlobalSecondaryIndexOverride"] = [
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_GlobalSecondaryIndex(
                list_element
            )
            for list_element in native_input["GlobalSecondaryIndexOverride"]
        ]

    if "LocalSecondaryIndexOverride" in native_input:
        output["LocalSecondaryIndexOverride"] = [
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_LocalSecondaryIndex(
                list_element
            )
            for list_element in native_input["LocalSecondaryIndexOverride"]
        ]

    if "ProvisionedThroughputOverride" in native_input:
        output["ProvisionedThroughputOverride"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ProvisionedThroughput(
                native_input["ProvisionedThroughputOverride"]
            )
        )

    if "OnDemandThroughputOverride" in native_input:
        output["OnDemandThroughputOverride"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_OnDemandThroughput(
                native_input["OnDemandThroughputOverride"]
            )
        )

    if "SSESpecificationOverride" in native_input:
        output["SSESpecificationOverride"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_SSESpecification(
                native_input["SSESpecificationOverride"]
            )
        )

    return output


def com_amazonaws_dynamodb_RestoreTableFromBackupOutput(native_input):
    output = {}
    if "TableDescription" in native_input:
        output["TableDescription"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_TableDescription(
                native_input["TableDescription"]
            )
        )

    return output


def com_amazonaws_dynamodb_RestoreTableToPointInTimeInput(native_input):
    output = {}
    if "SourceTableArn" in native_input:
        output["SourceTableArn"] = native_input["SourceTableArn"]

    if "SourceTableName" in native_input:
        output["SourceTableName"] = native_input["SourceTableName"]

    output["TargetTableName"] = native_input["TargetTableName"]
    if "UseLatestRestorableTime" in native_input:
        output["UseLatestRestorableTime"] = native_input["UseLatestRestorableTime"]

    if "RestoreDateTime" in native_input:
        output["RestoreDateTime"] = native_input["RestoreDateTime"]

    if "BillingModeOverride" in native_input:
        output["BillingModeOverride"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_BillingMode(
                native_input["BillingModeOverride"]
            )
        )

    if "GlobalSecondaryIndexOverride" in native_input:
        output["GlobalSecondaryIndexOverride"] = [
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_GlobalSecondaryIndex(
                list_element
            )
            for list_element in native_input["GlobalSecondaryIndexOverride"]
        ]

    if "LocalSecondaryIndexOverride" in native_input:
        output["LocalSecondaryIndexOverride"] = [
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_LocalSecondaryIndex(
                list_element
            )
            for list_element in native_input["LocalSecondaryIndexOverride"]
        ]

    if "ProvisionedThroughputOverride" in native_input:
        output["ProvisionedThroughputOverride"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ProvisionedThroughput(
                native_input["ProvisionedThroughputOverride"]
            )
        )

    if "OnDemandThroughputOverride" in native_input:
        output["OnDemandThroughputOverride"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_OnDemandThroughput(
                native_input["OnDemandThroughputOverride"]
            )
        )

    if "SSESpecificationOverride" in native_input:
        output["SSESpecificationOverride"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_SSESpecification(
                native_input["SSESpecificationOverride"]
            )
        )

    return output


def com_amazonaws_dynamodb_RestoreTableToPointInTimeOutput(native_input):
    output = {}
    if "TableDescription" in native_input:
        output["TableDescription"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_TableDescription(
                native_input["TableDescription"]
            )
        )

    return output


def com_amazonaws_dynamodb_ScanInput(native_input):
    output = {}
    output["TableName"] = native_input["TableName"]
    if "IndexName" in native_input:
        output["IndexName"] = native_input["IndexName"]

    if "AttributesToGet" in native_input:
        output["AttributesToGet"] = [
            list_element for list_element in native_input["AttributesToGet"]
        ]

    if "Limit" in native_input:
        output["Limit"] = native_input["Limit"]

    if "Select" in native_input:
        output["Select"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_Select(
                native_input["Select"]
            )
        )

    if "ScanFilter" in native_input:
        output["ScanFilter"] = {
            key: aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_Condition(
                value
            )
            for (key, value) in native_input["ScanFilter"].items()
        }

    if "ConditionalOperator" in native_input:
        output["ConditionalOperator"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ConditionalOperator(
                native_input["ConditionalOperator"]
            )
        )

    if "ExclusiveStartKey" in native_input:
        output["ExclusiveStartKey"] = {
            key: TypeSerializer().serialize(value)
            for (key, value) in native_input["ExclusiveStartKey"].items()
        }

    if "ReturnConsumedCapacity" in native_input:
        output["ReturnConsumedCapacity"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ReturnConsumedCapacity(
                native_input["ReturnConsumedCapacity"]
            )
        )

    if "TotalSegments" in native_input:
        output["TotalSegments"] = native_input["TotalSegments"]

    if "Segment" in native_input:
        output["Segment"] = native_input["Segment"]

    if "ProjectionExpression" in native_input:
        output["ProjectionExpression"] = native_input["ProjectionExpression"]

    if "FilterExpression" in native_input:
        output["FilterExpression"] = native_input["FilterExpression"]

    if "ExpressionAttributeNames" in native_input:
        output["ExpressionAttributeNames"] = {
            key: value
            for (key, value) in native_input["ExpressionAttributeNames"].items()
        }

    if "ExpressionAttributeValues" in native_input:
        output["ExpressionAttributeValues"] = {
            key: TypeSerializer().serialize(value)
            for (key, value) in native_input["ExpressionAttributeValues"].items()
        }

    if "ConsistentRead" in native_input:
        output["ConsistentRead"] = native_input["ConsistentRead"]

    return output


def com_amazonaws_dynamodb_ScanOutput(native_input):
    output = {}
    if "Items" in native_input:
        output["Items"] = [
            {
                key: TypeSerializer().serialize(value)
                for (key, value) in list_element.items()
            }
            for list_element in native_input["Items"]
        ]

    if "Count" in native_input:
        output["Count"] = native_input["Count"]

    if "ScannedCount" in native_input:
        output["ScannedCount"] = native_input["ScannedCount"]

    if "LastEvaluatedKey" in native_input:
        output["LastEvaluatedKey"] = {
            key: TypeSerializer().serialize(value)
            for (key, value) in native_input["LastEvaluatedKey"].items()
        }

    if "ConsumedCapacity" in native_input:
        output["ConsumedCapacity"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ConsumedCapacity(
                native_input["ConsumedCapacity"]
            )
        )

    return output


def com_amazonaws_dynamodb_TagResourceInput(native_input):
    output = {}
    output["ResourceArn"] = native_input["ResourceArn"]
    output["Tags"] = [
        aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_Tag(
            list_element
        )
        for list_element in native_input["Tags"]
    ]
    return output


def com_amazonaws_dynamodb_TransactGetItemsInput(native_input):
    output = {}
    output["TransactItems"] = [
        aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_TransactGetItem(
            list_element
        )
        for list_element in native_input["TransactItems"]
    ]
    if "ReturnConsumedCapacity" in native_input:
        output["ReturnConsumedCapacity"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ReturnConsumedCapacity(
                native_input["ReturnConsumedCapacity"]
            )
        )

    return output


def com_amazonaws_dynamodb_TransactGetItem(native_input):
    output = {}
    output["Get"] = (
        aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_Get(
            native_input["Get"]
        )
    )
    return output


def com_amazonaws_dynamodb_Get(native_input):
    output = {}
    output["Key"] = {
        key: TypeSerializer().serialize(value)
        for (key, value) in native_input["Key"].items()
    }
    output["TableName"] = native_input["TableName"]
    if "ProjectionExpression" in native_input:
        output["ProjectionExpression"] = native_input["ProjectionExpression"]

    if "ExpressionAttributeNames" in native_input:
        output["ExpressionAttributeNames"] = {
            key: value
            for (key, value) in native_input["ExpressionAttributeNames"].items()
        }

    return output


def com_amazonaws_dynamodb_TransactGetItemsOutput(native_input):
    output = {}
    if "ConsumedCapacity" in native_input:
        output["ConsumedCapacity"] = [
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ConsumedCapacity(
                list_element
            )
            for list_element in native_input["ConsumedCapacity"]
        ]

    if "Responses" in native_input:
        output["Responses"] = [
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ItemResponse(
                list_element
            )
            for list_element in native_input["Responses"]
        ]

    return output


def com_amazonaws_dynamodb_TransactWriteItemsInput(native_input):
    output = {}
    output["TransactItems"] = [
        aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_TransactWriteItem(
            list_element
        )
        for list_element in native_input["TransactItems"]
    ]
    if "ReturnConsumedCapacity" in native_input:
        output["ReturnConsumedCapacity"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ReturnConsumedCapacity(
                native_input["ReturnConsumedCapacity"]
            )
        )

    if "ReturnItemCollectionMetrics" in native_input:
        output["ReturnItemCollectionMetrics"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ReturnItemCollectionMetrics(
                native_input["ReturnItemCollectionMetrics"]
            )
        )

    if "ClientRequestToken" in native_input:
        output["ClientRequestToken"] = native_input["ClientRequestToken"]

    return output


def com_amazonaws_dynamodb_TransactWriteItem(native_input):
    output = {}
    if "ConditionCheck" in native_input:
        output["ConditionCheck"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ConditionCheck(
                native_input["ConditionCheck"]
            )
        )

    if "Put" in native_input:
        output["Put"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_Put(
                native_input["Put"]
            )
        )

    if "Delete" in native_input:
        output["Delete"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_Delete(
                native_input["Delete"]
            )
        )

    if "Update" in native_input:
        output["Update"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_Update(
                native_input["Update"]
            )
        )

    return output


def com_amazonaws_dynamodb_ConditionCheck(native_input):
    output = {}
    output["Key"] = {
        key: TypeSerializer().serialize(value)
        for (key, value) in native_input["Key"].items()
    }
    output["TableName"] = native_input["TableName"]
    output["ConditionExpression"] = native_input["ConditionExpression"]
    if "ExpressionAttributeNames" in native_input:
        output["ExpressionAttributeNames"] = {
            key: value
            for (key, value) in native_input["ExpressionAttributeNames"].items()
        }

    if "ExpressionAttributeValues" in native_input:
        output["ExpressionAttributeValues"] = {
            key: TypeSerializer().serialize(value)
            for (key, value) in native_input["ExpressionAttributeValues"].items()
        }

    if "ReturnValuesOnConditionCheckFailure" in native_input:
        output["ReturnValuesOnConditionCheckFailure"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ReturnValuesOnConditionCheckFailure(
                native_input["ReturnValuesOnConditionCheckFailure"]
            )
        )

    return output


def com_amazonaws_dynamodb_Put(native_input):
    output = {}
    output["Item"] = {
        key: TypeSerializer().serialize(value)
        for (key, value) in native_input["Item"].items()
    }
    output["TableName"] = native_input["TableName"]
    if "ConditionExpression" in native_input:
        output["ConditionExpression"] = native_input["ConditionExpression"]

    if "ExpressionAttributeNames" in native_input:
        output["ExpressionAttributeNames"] = {
            key: value
            for (key, value) in native_input["ExpressionAttributeNames"].items()
        }

    if "ExpressionAttributeValues" in native_input:
        output["ExpressionAttributeValues"] = {
            key: TypeSerializer().serialize(value)
            for (key, value) in native_input["ExpressionAttributeValues"].items()
        }

    if "ReturnValuesOnConditionCheckFailure" in native_input:
        output["ReturnValuesOnConditionCheckFailure"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ReturnValuesOnConditionCheckFailure(
                native_input["ReturnValuesOnConditionCheckFailure"]
            )
        )

    return output


def com_amazonaws_dynamodb_Delete(native_input):
    output = {}
    output["Key"] = {
        key: TypeSerializer().serialize(value)
        for (key, value) in native_input["Key"].items()
    }
    output["TableName"] = native_input["TableName"]
    if "ConditionExpression" in native_input:
        output["ConditionExpression"] = native_input["ConditionExpression"]

    if "ExpressionAttributeNames" in native_input:
        output["ExpressionAttributeNames"] = {
            key: value
            for (key, value) in native_input["ExpressionAttributeNames"].items()
        }

    if "ExpressionAttributeValues" in native_input:
        output["ExpressionAttributeValues"] = {
            key: TypeSerializer().serialize(value)
            for (key, value) in native_input["ExpressionAttributeValues"].items()
        }

    if "ReturnValuesOnConditionCheckFailure" in native_input:
        output["ReturnValuesOnConditionCheckFailure"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ReturnValuesOnConditionCheckFailure(
                native_input["ReturnValuesOnConditionCheckFailure"]
            )
        )

    return output


def com_amazonaws_dynamodb_Update(native_input):
    output = {}
    output["Key"] = {
        key: TypeSerializer().serialize(value)
        for (key, value) in native_input["Key"].items()
    }
    output["UpdateExpression"] = native_input["UpdateExpression"]
    output["TableName"] = native_input["TableName"]
    if "ConditionExpression" in native_input:
        output["ConditionExpression"] = native_input["ConditionExpression"]

    if "ExpressionAttributeNames" in native_input:
        output["ExpressionAttributeNames"] = {
            key: value
            for (key, value) in native_input["ExpressionAttributeNames"].items()
        }

    if "ExpressionAttributeValues" in native_input:
        output["ExpressionAttributeValues"] = {
            key: TypeSerializer().serialize(value)
            for (key, value) in native_input["ExpressionAttributeValues"].items()
        }

    if "ReturnValuesOnConditionCheckFailure" in native_input:
        output["ReturnValuesOnConditionCheckFailure"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ReturnValuesOnConditionCheckFailure(
                native_input["ReturnValuesOnConditionCheckFailure"]
            )
        )

    return output


def com_amazonaws_dynamodb_ReturnValuesOnConditionCheckFailure(native_input):
    # Always return input enum
    return native_input


def com_amazonaws_dynamodb_TransactWriteItemsOutput(native_input):
    output = {}
    if "ConsumedCapacity" in native_input:
        output["ConsumedCapacity"] = [
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ConsumedCapacity(
                list_element
            )
            for list_element in native_input["ConsumedCapacity"]
        ]

    if "ItemCollectionMetrics" in native_input:
        output["ItemCollectionMetrics"] = {
            key: [
                aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ItemCollectionMetrics(
                    list_element
                )
                for list_element in value
            ]
            for (key, value) in native_input["ItemCollectionMetrics"].items()
        }

    return output


def com_amazonaws_dynamodb_UntagResourceInput(native_input):
    output = {}
    output["ResourceArn"] = native_input["ResourceArn"]
    output["TagKeys"] = [list_element for list_element in native_input["TagKeys"]]
    return output


def com_amazonaws_dynamodb_UpdateContinuousBackupsInput(native_input):
    output = {}
    output["TableName"] = native_input["TableName"]
    output["PointInTimeRecoverySpecification"] = (
        aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_PointInTimeRecoverySpecification(
            native_input["PointInTimeRecoverySpecification"]
        )
    )
    return output


def com_amazonaws_dynamodb_PointInTimeRecoverySpecification(native_input):
    output = {}
    output["PointInTimeRecoveryEnabled"] = native_input["PointInTimeRecoveryEnabled"]
    return output


def com_amazonaws_dynamodb_UpdateContinuousBackupsOutput(native_input):
    output = {}
    if "ContinuousBackupsDescription" in native_input:
        output["ContinuousBackupsDescription"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ContinuousBackupsDescription(
                native_input["ContinuousBackupsDescription"]
            )
        )

    return output


def com_amazonaws_dynamodb_UpdateContributorInsightsInput(native_input):
    output = {}
    output["TableName"] = native_input["TableName"]
    if "IndexName" in native_input:
        output["IndexName"] = native_input["IndexName"]

    output["ContributorInsightsAction"] = (
        aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ContributorInsightsAction(
            native_input["ContributorInsightsAction"]
        )
    )
    return output


def com_amazonaws_dynamodb_ContributorInsightsAction(native_input):
    # Always return input enum
    return native_input


def com_amazonaws_dynamodb_UpdateContributorInsightsOutput(native_input):
    output = {}
    if "TableName" in native_input:
        output["TableName"] = native_input["TableName"]

    if "IndexName" in native_input:
        output["IndexName"] = native_input["IndexName"]

    if "ContributorInsightsStatus" in native_input:
        output["ContributorInsightsStatus"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ContributorInsightsStatus(
                native_input["ContributorInsightsStatus"]
            )
        )

    return output


def com_amazonaws_dynamodb_UpdateGlobalTableInput(native_input):
    output = {}
    output["GlobalTableName"] = native_input["GlobalTableName"]
    output["ReplicaUpdates"] = [
        aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ReplicaUpdate(
            list_element
        )
        for list_element in native_input["ReplicaUpdates"]
    ]
    return output


def com_amazonaws_dynamodb_ReplicaUpdate(native_input):
    output = {}
    if "Create" in native_input:
        output["Create"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_CreateReplicaAction(
                native_input["Create"]
            )
        )

    if "Delete" in native_input:
        output["Delete"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_DeleteReplicaAction(
                native_input["Delete"]
            )
        )

    return output


def com_amazonaws_dynamodb_CreateReplicaAction(native_input):
    output = {}
    output["RegionName"] = native_input["RegionName"]
    return output


def com_amazonaws_dynamodb_DeleteReplicaAction(native_input):
    output = {}
    output["RegionName"] = native_input["RegionName"]
    return output


def com_amazonaws_dynamodb_UpdateGlobalTableOutput(native_input):
    output = {}
    if "GlobalTableDescription" in native_input:
        output["GlobalTableDescription"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_GlobalTableDescription(
                native_input["GlobalTableDescription"]
            )
        )

    return output


def com_amazonaws_dynamodb_UpdateGlobalTableSettingsInput(native_input):
    output = {}
    output["GlobalTableName"] = native_input["GlobalTableName"]
    if "GlobalTableBillingMode" in native_input:
        output["GlobalTableBillingMode"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_BillingMode(
                native_input["GlobalTableBillingMode"]
            )
        )

    if "GlobalTableProvisionedWriteCapacityUnits" in native_input:
        output["GlobalTableProvisionedWriteCapacityUnits"] = native_input[
            "GlobalTableProvisionedWriteCapacityUnits"
        ]

    if "GlobalTableProvisionedWriteCapacityAutoScalingSettingsUpdate" in native_input:
        output["GlobalTableProvisionedWriteCapacityAutoScalingSettingsUpdate"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_AutoScalingSettingsUpdate(
                native_input[
                    "GlobalTableProvisionedWriteCapacityAutoScalingSettingsUpdate"
                ]
            )
        )

    if "GlobalTableGlobalSecondaryIndexSettingsUpdate" in native_input:
        output["GlobalTableGlobalSecondaryIndexSettingsUpdate"] = [
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_GlobalTableGlobalSecondaryIndexSettingsUpdate(
                list_element
            )
            for list_element in native_input[
                "GlobalTableGlobalSecondaryIndexSettingsUpdate"
            ]
        ]

    if "ReplicaSettingsUpdate" in native_input:
        output["ReplicaSettingsUpdate"] = [
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ReplicaSettingsUpdate(
                list_element
            )
            for list_element in native_input["ReplicaSettingsUpdate"]
        ]

    return output


def com_amazonaws_dynamodb_AutoScalingSettingsUpdate(native_input):
    output = {}
    if "MinimumUnits" in native_input:
        output["MinimumUnits"] = native_input["MinimumUnits"]

    if "MaximumUnits" in native_input:
        output["MaximumUnits"] = native_input["MaximumUnits"]

    if "AutoScalingDisabled" in native_input:
        output["AutoScalingDisabled"] = native_input["AutoScalingDisabled"]

    if "AutoScalingRoleArn" in native_input:
        output["AutoScalingRoleArn"] = native_input["AutoScalingRoleArn"]

    if "ScalingPolicyUpdate" in native_input:
        output["ScalingPolicyUpdate"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_AutoScalingPolicyUpdate(
                native_input["ScalingPolicyUpdate"]
            )
        )

    return output


def com_amazonaws_dynamodb_GlobalTableGlobalSecondaryIndexSettingsUpdate(native_input):
    output = {}
    output["IndexName"] = native_input["IndexName"]
    if "ProvisionedWriteCapacityUnits" in native_input:
        output["ProvisionedWriteCapacityUnits"] = native_input[
            "ProvisionedWriteCapacityUnits"
        ]

    if "ProvisionedWriteCapacityAutoScalingSettingsUpdate" in native_input:
        output["ProvisionedWriteCapacityAutoScalingSettingsUpdate"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_AutoScalingSettingsUpdate(
                native_input["ProvisionedWriteCapacityAutoScalingSettingsUpdate"]
            )
        )

    return output


def com_amazonaws_dynamodb_ReplicaSettingsUpdate(native_input):
    output = {}
    output["RegionName"] = native_input["RegionName"]
    if "ReplicaProvisionedReadCapacityUnits" in native_input:
        output["ReplicaProvisionedReadCapacityUnits"] = native_input[
            "ReplicaProvisionedReadCapacityUnits"
        ]

    if "ReplicaProvisionedReadCapacityAutoScalingSettingsUpdate" in native_input:
        output["ReplicaProvisionedReadCapacityAutoScalingSettingsUpdate"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_AutoScalingSettingsUpdate(
                native_input["ReplicaProvisionedReadCapacityAutoScalingSettingsUpdate"]
            )
        )

    if "ReplicaGlobalSecondaryIndexSettingsUpdate" in native_input:
        output["ReplicaGlobalSecondaryIndexSettingsUpdate"] = [
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ReplicaGlobalSecondaryIndexSettingsUpdate(
                list_element
            )
            for list_element in native_input[
                "ReplicaGlobalSecondaryIndexSettingsUpdate"
            ]
        ]

    if "ReplicaTableClass" in native_input:
        output["ReplicaTableClass"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_TableClass(
                native_input["ReplicaTableClass"]
            )
        )

    return output


def com_amazonaws_dynamodb_AutoScalingPolicyUpdate(native_input):
    output = {}
    if "PolicyName" in native_input:
        output["PolicyName"] = native_input["PolicyName"]

    output["TargetTrackingScalingPolicyConfiguration"] = (
        aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_AutoScalingTargetTrackingScalingPolicyConfigurationUpdate(
            native_input["TargetTrackingScalingPolicyConfiguration"]
        )
    )
    return output


def com_amazonaws_dynamodb_ReplicaGlobalSecondaryIndexSettingsUpdate(native_input):
    output = {}
    output["IndexName"] = native_input["IndexName"]
    if "ProvisionedReadCapacityUnits" in native_input:
        output["ProvisionedReadCapacityUnits"] = native_input[
            "ProvisionedReadCapacityUnits"
        ]

    if "ProvisionedReadCapacityAutoScalingSettingsUpdate" in native_input:
        output["ProvisionedReadCapacityAutoScalingSettingsUpdate"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_AutoScalingSettingsUpdate(
                native_input["ProvisionedReadCapacityAutoScalingSettingsUpdate"]
            )
        )

    return output


def com_amazonaws_dynamodb_AutoScalingTargetTrackingScalingPolicyConfigurationUpdate(
    native_input,
):
    output = {}
    if "DisableScaleIn" in native_input:
        output["DisableScaleIn"] = native_input["DisableScaleIn"]

    if "ScaleInCooldown" in native_input:
        output["ScaleInCooldown"] = native_input["ScaleInCooldown"]

    if "ScaleOutCooldown" in native_input:
        output["ScaleOutCooldown"] = native_input["ScaleOutCooldown"]

    output["TargetValue"] = native_input["TargetValue"]
    return output


def com_amazonaws_dynamodb_UpdateGlobalTableSettingsOutput(native_input):
    output = {}
    if "GlobalTableName" in native_input:
        output["GlobalTableName"] = native_input["GlobalTableName"]

    if "ReplicaSettings" in native_input:
        output["ReplicaSettings"] = [
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ReplicaSettingsDescription(
                list_element
            )
            for list_element in native_input["ReplicaSettings"]
        ]

    return output


def com_amazonaws_dynamodb_UpdateItemInput(native_input):
    output = {}
    output["TableName"] = native_input["TableName"]
    output["Key"] = {
        key: TypeSerializer().serialize(value)
        for (key, value) in native_input["Key"].items()
    }
    if "AttributeUpdates" in native_input:
        output["AttributeUpdates"] = {
            key: aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_AttributeValueUpdate(
                value
            )
            for (key, value) in native_input["AttributeUpdates"].items()
        }

    if "Expected" in native_input:
        output["Expected"] = {
            key: aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ExpectedAttributeValue(
                value
            )
            for (key, value) in native_input["Expected"].items()
        }

    if "ConditionalOperator" in native_input:
        output["ConditionalOperator"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ConditionalOperator(
                native_input["ConditionalOperator"]
            )
        )

    if "ReturnValues" in native_input:
        output["ReturnValues"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ReturnValue(
                native_input["ReturnValues"]
            )
        )

    if "ReturnConsumedCapacity" in native_input:
        output["ReturnConsumedCapacity"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ReturnConsumedCapacity(
                native_input["ReturnConsumedCapacity"]
            )
        )

    if "ReturnItemCollectionMetrics" in native_input:
        output["ReturnItemCollectionMetrics"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ReturnItemCollectionMetrics(
                native_input["ReturnItemCollectionMetrics"]
            )
        )

    if "UpdateExpression" in native_input:
        output["UpdateExpression"] = native_input["UpdateExpression"]

    if "ConditionExpression" in native_input:
        output["ConditionExpression"] = native_input["ConditionExpression"]

    if "ExpressionAttributeNames" in native_input:
        output["ExpressionAttributeNames"] = {
            key: value
            for (key, value) in native_input["ExpressionAttributeNames"].items()
        }

    if "ExpressionAttributeValues" in native_input:
        output["ExpressionAttributeValues"] = {
            key: TypeSerializer().serialize(value)
            for (key, value) in native_input["ExpressionAttributeValues"].items()
        }

    return output


def com_amazonaws_dynamodb_AttributeValueUpdate(native_input):
    output = {}
    if "Value" in native_input:
        output["Value"] = TypeSerializer().serialize(native_input["Value"])

    if "Action" in native_input:
        output["Action"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_AttributeAction(
                native_input["Action"]
            )
        )

    return output


def com_amazonaws_dynamodb_AttributeAction(native_input):
    # Always return input enum
    return native_input


def com_amazonaws_dynamodb_UpdateItemOutput(native_input):
    output = {}
    if "Attributes" in native_input:
        output["Attributes"] = {
            key: TypeSerializer().serialize(value)
            for (key, value) in native_input["Attributes"].items()
        }

    if "ConsumedCapacity" in native_input:
        output["ConsumedCapacity"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ConsumedCapacity(
                native_input["ConsumedCapacity"]
            )
        )

    if "ItemCollectionMetrics" in native_input:
        output["ItemCollectionMetrics"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ItemCollectionMetrics(
                native_input["ItemCollectionMetrics"]
            )
        )

    return output


def com_amazonaws_dynamodb_UpdateKinesisStreamingDestinationInput(native_input):
    output = {}
    output["TableName"] = native_input["TableName"]
    output["StreamArn"] = native_input["StreamArn"]
    if "UpdateKinesisStreamingConfiguration" in native_input:
        output["UpdateKinesisStreamingConfiguration"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_UpdateKinesisStreamingConfiguration(
                native_input["UpdateKinesisStreamingConfiguration"]
            )
        )

    return output


def com_amazonaws_dynamodb_UpdateKinesisStreamingConfiguration(native_input):
    output = {}
    if "ApproximateCreationDateTimePrecision" in native_input:
        output["ApproximateCreationDateTimePrecision"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ApproximateCreationDateTimePrecision(
                native_input["ApproximateCreationDateTimePrecision"]
            )
        )

    return output


def com_amazonaws_dynamodb_UpdateKinesisStreamingDestinationOutput(native_input):
    output = {}
    if "TableName" in native_input:
        output["TableName"] = native_input["TableName"]

    if "StreamArn" in native_input:
        output["StreamArn"] = native_input["StreamArn"]

    if "DestinationStatus" in native_input:
        output["DestinationStatus"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_DestinationStatus(
                native_input["DestinationStatus"]
            )
        )

    if "UpdateKinesisStreamingConfiguration" in native_input:
        output["UpdateKinesisStreamingConfiguration"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_UpdateKinesisStreamingConfiguration(
                native_input["UpdateKinesisStreamingConfiguration"]
            )
        )

    return output


def com_amazonaws_dynamodb_UpdateTableInput(native_input):
    output = {}
    if "AttributeDefinitions" in native_input:
        output["AttributeDefinitions"] = [
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_AttributeDefinition(
                list_element
            )
            for list_element in native_input["AttributeDefinitions"]
        ]

    output["TableName"] = native_input["TableName"]
    if "BillingMode" in native_input:
        output["BillingMode"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_BillingMode(
                native_input["BillingMode"]
            )
        )

    if "ProvisionedThroughput" in native_input:
        output["ProvisionedThroughput"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ProvisionedThroughput(
                native_input["ProvisionedThroughput"]
            )
        )

    if "GlobalSecondaryIndexUpdates" in native_input:
        output["GlobalSecondaryIndexUpdates"] = [
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_GlobalSecondaryIndexUpdate(
                list_element
            )
            for list_element in native_input["GlobalSecondaryIndexUpdates"]
        ]

    if "StreamSpecification" in native_input:
        output["StreamSpecification"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_StreamSpecification(
                native_input["StreamSpecification"]
            )
        )

    if "SSESpecification" in native_input:
        output["SSESpecification"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_SSESpecification(
                native_input["SSESpecification"]
            )
        )

    if "ReplicaUpdates" in native_input:
        output["ReplicaUpdates"] = [
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ReplicationGroupUpdate(
                list_element
            )
            for list_element in native_input["ReplicaUpdates"]
        ]

    if "TableClass" in native_input:
        output["TableClass"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_TableClass(
                native_input["TableClass"]
            )
        )

    if "DeletionProtectionEnabled" in native_input:
        output["DeletionProtectionEnabled"] = native_input["DeletionProtectionEnabled"]

    if "OnDemandThroughput" in native_input:
        output["OnDemandThroughput"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_OnDemandThroughput(
                native_input["OnDemandThroughput"]
            )
        )

    return output


def com_amazonaws_dynamodb_GlobalSecondaryIndexUpdate(native_input):
    output = {}
    if "Update" in native_input:
        output["Update"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_UpdateGlobalSecondaryIndexAction(
                native_input["Update"]
            )
        )

    if "Create" in native_input:
        output["Create"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_CreateGlobalSecondaryIndexAction(
                native_input["Create"]
            )
        )

    if "Delete" in native_input:
        output["Delete"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_DeleteGlobalSecondaryIndexAction(
                native_input["Delete"]
            )
        )

    return output


def com_amazonaws_dynamodb_ReplicationGroupUpdate(native_input):
    output = {}
    if "Create" in native_input:
        output["Create"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_CreateReplicationGroupMemberAction(
                native_input["Create"]
            )
        )

    if "Update" in native_input:
        output["Update"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_UpdateReplicationGroupMemberAction(
                native_input["Update"]
            )
        )

    if "Delete" in native_input:
        output["Delete"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_DeleteReplicationGroupMemberAction(
                native_input["Delete"]
            )
        )

    return output


def com_amazonaws_dynamodb_UpdateGlobalSecondaryIndexAction(native_input):
    output = {}
    output["IndexName"] = native_input["IndexName"]
    if "ProvisionedThroughput" in native_input:
        output["ProvisionedThroughput"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ProvisionedThroughput(
                native_input["ProvisionedThroughput"]
            )
        )

    if "OnDemandThroughput" in native_input:
        output["OnDemandThroughput"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_OnDemandThroughput(
                native_input["OnDemandThroughput"]
            )
        )

    return output


def com_amazonaws_dynamodb_CreateGlobalSecondaryIndexAction(native_input):
    output = {}
    output["IndexName"] = native_input["IndexName"]
    output["KeySchema"] = [
        aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_KeySchemaElement(
            list_element
        )
        for list_element in native_input["KeySchema"]
    ]
    output["Projection"] = (
        aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_Projection(
            native_input["Projection"]
        )
    )
    if "ProvisionedThroughput" in native_input:
        output["ProvisionedThroughput"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ProvisionedThroughput(
                native_input["ProvisionedThroughput"]
            )
        )

    if "OnDemandThroughput" in native_input:
        output["OnDemandThroughput"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_OnDemandThroughput(
                native_input["OnDemandThroughput"]
            )
        )

    return output


def com_amazonaws_dynamodb_DeleteGlobalSecondaryIndexAction(native_input):
    output = {}
    output["IndexName"] = native_input["IndexName"]
    return output


def com_amazonaws_dynamodb_CreateReplicationGroupMemberAction(native_input):
    output = {}
    output["RegionName"] = native_input["RegionName"]
    if "KMSMasterKeyId" in native_input:
        output["KMSMasterKeyId"] = native_input["KMSMasterKeyId"]

    if "ProvisionedThroughputOverride" in native_input:
        output["ProvisionedThroughputOverride"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ProvisionedThroughputOverride(
                native_input["ProvisionedThroughputOverride"]
            )
        )

    if "OnDemandThroughputOverride" in native_input:
        output["OnDemandThroughputOverride"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_OnDemandThroughputOverride(
                native_input["OnDemandThroughputOverride"]
            )
        )

    if "GlobalSecondaryIndexes" in native_input:
        output["GlobalSecondaryIndexes"] = [
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ReplicaGlobalSecondaryIndex(
                list_element
            )
            for list_element in native_input["GlobalSecondaryIndexes"]
        ]

    if "TableClassOverride" in native_input:
        output["TableClassOverride"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_TableClass(
                native_input["TableClassOverride"]
            )
        )

    return output


def com_amazonaws_dynamodb_UpdateReplicationGroupMemberAction(native_input):
    output = {}
    output["RegionName"] = native_input["RegionName"]
    if "KMSMasterKeyId" in native_input:
        output["KMSMasterKeyId"] = native_input["KMSMasterKeyId"]

    if "ProvisionedThroughputOverride" in native_input:
        output["ProvisionedThroughputOverride"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ProvisionedThroughputOverride(
                native_input["ProvisionedThroughputOverride"]
            )
        )

    if "OnDemandThroughputOverride" in native_input:
        output["OnDemandThroughputOverride"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_OnDemandThroughputOverride(
                native_input["OnDemandThroughputOverride"]
            )
        )

    if "GlobalSecondaryIndexes" in native_input:
        output["GlobalSecondaryIndexes"] = [
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ReplicaGlobalSecondaryIndex(
                list_element
            )
            for list_element in native_input["GlobalSecondaryIndexes"]
        ]

    if "TableClassOverride" in native_input:
        output["TableClassOverride"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_TableClass(
                native_input["TableClassOverride"]
            )
        )

    return output


def com_amazonaws_dynamodb_DeleteReplicationGroupMemberAction(native_input):
    output = {}
    output["RegionName"] = native_input["RegionName"]
    return output


def com_amazonaws_dynamodb_ReplicaGlobalSecondaryIndex(native_input):
    output = {}
    output["IndexName"] = native_input["IndexName"]
    if "ProvisionedThroughputOverride" in native_input:
        output["ProvisionedThroughputOverride"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ProvisionedThroughputOverride(
                native_input["ProvisionedThroughputOverride"]
            )
        )

    if "OnDemandThroughputOverride" in native_input:
        output["OnDemandThroughputOverride"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_OnDemandThroughputOverride(
                native_input["OnDemandThroughputOverride"]
            )
        )

    return output


def com_amazonaws_dynamodb_UpdateTableOutput(native_input):
    output = {}
    if "TableDescription" in native_input:
        output["TableDescription"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_TableDescription(
                native_input["TableDescription"]
            )
        )

    return output


def com_amazonaws_dynamodb_UpdateTableReplicaAutoScalingInput(native_input):
    output = {}
    if "GlobalSecondaryIndexUpdates" in native_input:
        output["GlobalSecondaryIndexUpdates"] = [
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_GlobalSecondaryIndexAutoScalingUpdate(
                list_element
            )
            for list_element in native_input["GlobalSecondaryIndexUpdates"]
        ]

    output["TableName"] = native_input["TableName"]
    if "ProvisionedWriteCapacityAutoScalingUpdate" in native_input:
        output["ProvisionedWriteCapacityAutoScalingUpdate"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_AutoScalingSettingsUpdate(
                native_input["ProvisionedWriteCapacityAutoScalingUpdate"]
            )
        )

    if "ReplicaUpdates" in native_input:
        output["ReplicaUpdates"] = [
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ReplicaAutoScalingUpdate(
                list_element
            )
            for list_element in native_input["ReplicaUpdates"]
        ]

    return output


def com_amazonaws_dynamodb_GlobalSecondaryIndexAutoScalingUpdate(native_input):
    output = {}
    if "IndexName" in native_input:
        output["IndexName"] = native_input["IndexName"]

    if "ProvisionedWriteCapacityAutoScalingUpdate" in native_input:
        output["ProvisionedWriteCapacityAutoScalingUpdate"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_AutoScalingSettingsUpdate(
                native_input["ProvisionedWriteCapacityAutoScalingUpdate"]
            )
        )

    return output


def com_amazonaws_dynamodb_ReplicaAutoScalingUpdate(native_input):
    output = {}
    output["RegionName"] = native_input["RegionName"]
    if "ReplicaGlobalSecondaryIndexUpdates" in native_input:
        output["ReplicaGlobalSecondaryIndexUpdates"] = [
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_ReplicaGlobalSecondaryIndexAutoScalingUpdate(
                list_element
            )
            for list_element in native_input["ReplicaGlobalSecondaryIndexUpdates"]
        ]

    if "ReplicaProvisionedReadCapacityAutoScalingUpdate" in native_input:
        output["ReplicaProvisionedReadCapacityAutoScalingUpdate"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_AutoScalingSettingsUpdate(
                native_input["ReplicaProvisionedReadCapacityAutoScalingUpdate"]
            )
        )

    return output


def com_amazonaws_dynamodb_ReplicaGlobalSecondaryIndexAutoScalingUpdate(native_input):
    output = {}
    if "IndexName" in native_input:
        output["IndexName"] = native_input["IndexName"]

    if "ProvisionedReadCapacityAutoScalingUpdate" in native_input:
        output["ProvisionedReadCapacityAutoScalingUpdate"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_AutoScalingSettingsUpdate(
                native_input["ProvisionedReadCapacityAutoScalingUpdate"]
            )
        )

    return output


def com_amazonaws_dynamodb_UpdateTableReplicaAutoScalingOutput(native_input):
    output = {}
    if "TableAutoScalingDescription" in native_input:
        output["TableAutoScalingDescription"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_TableAutoScalingDescription(
                native_input["TableAutoScalingDescription"]
            )
        )

    return output


def com_amazonaws_dynamodb_UpdateTimeToLiveInput(native_input):
    output = {}
    output["TableName"] = native_input["TableName"]
    output["TimeToLiveSpecification"] = (
        aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_TimeToLiveSpecification(
            native_input["TimeToLiveSpecification"]
        )
    )
    return output


def com_amazonaws_dynamodb_TimeToLiveSpecification(native_input):
    output = {}
    output["Enabled"] = native_input["Enabled"]
    output["AttributeName"] = native_input["AttributeName"]
    return output


def com_amazonaws_dynamodb_UpdateTimeToLiveOutput(native_input):
    output = {}
    if "TimeToLiveSpecification" in native_input:
        output["TimeToLiveSpecification"] = (
            aws_database_encryption_sdk.transform.com_amazonaws_dynamodb_TimeToLiveSpecification(
                native_input["TimeToLiveSpecification"]
            )
        )

    return output
