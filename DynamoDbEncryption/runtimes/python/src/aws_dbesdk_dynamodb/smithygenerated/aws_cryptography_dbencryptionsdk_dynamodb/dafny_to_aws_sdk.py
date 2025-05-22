# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
# Do not modify this file. This file is machine generated, and any changes to it will be overwritten.

from aws_cryptography_internal_dynamodb.internaldafny.generated.ComAmazonawsDynamodbTypes import (
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
)
import aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk


def com_amazonaws_dynamodb_AttributeValue(dafny_input):
    # Convert AttributeValue
    if isinstance(dafny_input, AttributeValue_S):
        AttributeValue_union_value = {"S": b''.join(ord(c).to_bytes(2, 'big') for c in dafny_input.S).decode('utf-16-be')}
    elif isinstance(dafny_input, AttributeValue_N):
        AttributeValue_union_value = {"N": b''.join(ord(c).to_bytes(2, 'big') for c in dafny_input.N).decode('utf-16-be')}
    elif isinstance(dafny_input, AttributeValue_B):
        AttributeValue_union_value = {"B": bytes(dafny_input.B)}
    elif isinstance(dafny_input, AttributeValue_SS):
        AttributeValue_union_value = {"SS": [b''.join(ord(c).to_bytes(2, 'big') for c in list_element).decode('utf-16-be') for list_element in dafny_input.SS]}
    elif isinstance(dafny_input, AttributeValue_NS):
        AttributeValue_union_value = {"NS": [b''.join(ord(c).to_bytes(2, 'big') for c in list_element).decode('utf-16-be') for list_element in dafny_input.NS]}
    elif isinstance(dafny_input, AttributeValue_BS):
        AttributeValue_union_value = {"BS": [bytes(list_element) for list_element in dafny_input.BS]}
    elif isinstance(dafny_input, AttributeValue_M):
        AttributeValue_union_value = {"M": {b''.join(ord(c).to_bytes(2, 'big') for c in key).decode('utf-16-be'): aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_AttributeValue(value) for (key, value) in dafny_input.M.items }}
    elif isinstance(dafny_input, AttributeValue_L):
        AttributeValue_union_value = {"L": [aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.dafny_to_aws_sdk.com_amazonaws_dynamodb_AttributeValue(list_element) for list_element in dafny_input.L]}
    elif isinstance(dafny_input, AttributeValue_NULL):
        AttributeValue_union_value = {"NULL": dafny_input.NULL}
    elif isinstance(dafny_input, AttributeValue_BOOL):
        AttributeValue_union_value = {"BOOL": dafny_input.BOOL}
    else:
        raise ValueError("No recognized union value in union type: " + str(dafny_input))

    return AttributeValue_union_value
