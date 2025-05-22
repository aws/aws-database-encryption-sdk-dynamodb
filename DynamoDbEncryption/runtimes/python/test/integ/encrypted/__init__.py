# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0


def sort_dynamodb_json_lists(obj):
    """
    Utility that recursively sorts all lists in a DynamoDB JSON-like structure.
    DynamoDB JSON uses lists to represent sets, so strict equality can fail.
    Sort lists to ensure consistent ordering when comparing expected and actual items.
    """
    if isinstance(obj, dict):
        return {k: sort_dynamodb_json_lists(v) for k, v in obj.items()}
    elif isinstance(obj, list):
        try:
            return sorted(obj)  # Sort lists for consistent comparison
        except TypeError:
            return obj  # Not all lists are sortable; ex. complex_item_ddb's "list" attribute
    return obj
