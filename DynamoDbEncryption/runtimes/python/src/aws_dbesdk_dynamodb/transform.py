# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""Helper tools for translating between native and DynamoDB items.

For information on how types are serializes, see:
https://boto3.amazonaws.com/v1/documentation/api/latest/_modules/boto3/dynamodb/types.html
"""
from typing import Any

from boto3.dynamodb.types import TypeDeserializer, TypeSerializer

__all__ = ("dict_to_ddb", "ddb_to_dict")


def dict_to_ddb(item: dict[str, Any]) -> dict[str, Any]:
    """Converts a native Python dictionary to a DynamoDB-JSON item.

    Args:
        item (Dict[str, Any]): Native Python dictionary.

    Returns:
        Dict[str, Any]: DynamoDB-formatted item.

    """
    serializer = TypeSerializer()
    return {key: serializer.serialize(value) for key, value in item.items()}


def list_of_dict_to_list_of_ddb(items: list[dict[str, Any]]) -> list[dict[str, Any]]:
    """Converts a list of Python dictionaries into a list of DynamoDB-JSON formatted items.

    Args:
        items (List[Dict[str, Any]]): List of native Python dictionaries.

    Returns:
        List[Dict[str, Any]]: List of DynamoDB-formatted items.

    """
    return [dict_to_ddb(item) for item in items]


def ddb_to_dict(item: dict[str, Any]) -> dict[str, Any]:
    """Converts a DynamoDB-JSON item to a native Python dictionary.

    Args:
        item (Dict[str, Any]): DynamoDB-formatted item.

    Returns:
        Dict[str, Any]: Native Python dictionary.

    """
    deserializer = TypeDeserializer()
    return {key: deserializer.deserialize(value) for key, value in item.items()}


def list_of_ddb_to_list_of_dict(items: list[dict[str, Any]]) -> list[dict[str, Any]]:
    """Converts a list of DynamoDB-JSON formatted items to a list of Python dictionaries.

    Args:
        items (List[Dict[str, Any]]): List of DynamoDB-formatted items.

    Returns:
        List[Dict[str, Any]]: List of native Python dictionaries.

    """
    return [ddb_to_dict(item) for item in items]
