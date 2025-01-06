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
    """Converts a native Python dictionary to a raw DynamoDB item.

    :param dict item: Native item
    :returns: DynamoDB item
    """
    serializer = TypeSerializer()
    return {key: serializer.serialize(value) for key, value in item.items()}


def ddb_to_dict(item: Dict[str, Any]) -> Dict[str, Any]:
    """Converts a raw DynamoDB item to a native Python dictionary.

    :param dict item: DynamoDB item
    :returns: Native item
    """
    deserializer = TypeDeserializer()
    return {key: deserializer.deserialize(value) for key, value in item.items()}
