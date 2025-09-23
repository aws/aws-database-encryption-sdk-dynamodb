# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""
Test cleanup utilities for DynamoDB Encryption SDK.

This module provides utilities for cleaning up resources after running tests.

WARNING: Please be careful. This is only a test utility and should NOT be used in production code.
It is specifically designed for cleaning up test resources after test execution.
- Running this code on production resources or any data you want to keep could result
  in cryptographic shredding (permanent loss of access to encrypted data).
- Only use this on test resources that you are willing to permanently delete.
- Never run this against any production DynamoDB tables. Ensure you have backups
  of any important data before running cleanup operations.
"""
import boto3

BRANCH_KEY_IDENTIFIER_FIELD = "branch-key-id"
TYPE_FIELD = "type"


def delete_branch_key(
    identifier: str,
    table_name: str,
    ddb_client: boto3.client,
) -> bool:
    """
    Delete all branch key items with the given identifier.

    Args:
        identifier: Branch key identifier to delete
        table_name: DynamoDB table name
        ddb_client: DynamoDB client to use

    Returns:
        True if all items were deleted, False if more than 100 items exist

    Raises:
        ValueError: If an item is not a branch key

    """
    if ddb_client is None:
        ddb_client = boto3.client("dynamodb")

    # Query for items with matching identifier
    query_response = ddb_client.query(
        TableName=table_name,
        KeyConditionExpression="#pk = :pk",
        ExpressionAttributeNames={"#pk": BRANCH_KEY_IDENTIFIER_FIELD},
        ExpressionAttributeValues={":pk": {"S": identifier}},
    )

    items = query_response.get("Items", [])
    if not items:
        return True

    # Create delete requests for each item
    delete_items = []
    for item in items:
        if TYPE_FIELD not in item:
            raise ValueError("Item is not a branch key")

        delete_item = {
            "Delete": {
                "Key": {BRANCH_KEY_IDENTIFIER_FIELD: {"S": identifier}, TYPE_FIELD: item[TYPE_FIELD]},
                "TableName": table_name,
            }
        }
        delete_items.append(delete_item)

    if not delete_items:
        return True

    # DynamoDB transactions are limited to 100 items
    if len(delete_items) > 100:
        delete_items = delete_items[:100]

    # Execute the delete transaction
    ddb_client.transact_write_items(TransactItems=delete_items)

    # Return False if we had to truncate the deletion
    return len(items) <= 100
