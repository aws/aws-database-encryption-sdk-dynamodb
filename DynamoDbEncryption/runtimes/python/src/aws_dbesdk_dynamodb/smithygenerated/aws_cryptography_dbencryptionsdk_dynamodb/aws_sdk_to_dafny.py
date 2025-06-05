# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
# Do not modify this file. This file is machine generated, and any changes to it will be overwritten.

from _dafny import Map, Seq
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
import aws_cryptography_internal_dynamodb.smithygenerated.com_amazonaws_dynamodb.aws_sdk_to_dafny


def com_amazonaws_dynamodb_AttributeValue(native_input):
    if "S" in native_input.keys():
        AttributeValue_union_value = AttributeValue_S(
            Seq(
                "".join(
                    [
                        chr(int.from_bytes(pair, "big"))
                        for pair in zip(*[iter(native_input["S"].encode("utf-16-be"))] * 2)
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
                        for pair in zip(*[iter(native_input["N"].encode("utf-16-be"))] * 2)
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
                                for pair in zip(*[iter(list_element.encode("utf-16-be"))] * 2)
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
                                for pair in zip(*[iter(list_element.encode("utf-16-be"))] * 2)
                            ]
                        )
                    )
                    for list_element in native_input["NS"]
                ]
            )
        )
    elif "BS" in native_input.keys():
        AttributeValue_union_value = AttributeValue_BS(Seq([Seq(list_element) for list_element in native_input["BS"]]))
    elif "M" in native_input.keys():
        AttributeValue_union_value = AttributeValue_M(
            Map(
                {
                    Seq(
                        "".join(
                            [chr(int.from_bytes(pair, "big")) for pair in zip(*[iter(key.encode("utf-16-be"))] * 2)]
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
        raise ValueError("No recognized union value in union type: " + str(native_input))

    return AttributeValue_union_value
