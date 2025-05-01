# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0

# Disable sorting imports; this order initializes code in the required order
# (generated Dafny, then externs)
# ruff: noqa: I
# Initialize generated Dafny
from .internaldafny.generated import module_

# Initialize externs
# noqa: F401, F403
from .internaldafny import extern

"""
boto3 uses Python's decimal library to deserialize numbers retrieved by resources
    (Tables, etc.) from strings to `decimal.Decimal`s.
boto3 deserializes strings to Decimals according to its DYNAMODB_CONTEXT:
https://github.com/boto/boto3/blob/develop/boto3/dynamodb/types.py#L37-L42

boto3 is configured to raise an exception if the deserialization is "Rounded": (`traps: [.. Rounded]`)
https://docs.python.org/3/library/decimal.html#decimal.Rounded
"Rounded" means some digits were discarded.
However, those digits may have been 0, and no information is lost.

boto3 is also configured to raise an exception if the deserialization is "Inexact":
https://docs.python.org/3/library/decimal.html#decimal.Inexact
"Inexact" means non-zero digits are discarded, and the result is inexact.

Other DBESDK DynamoDB runtimes treat "Rounded" as acceptable, but "Inexact" as unacceptable.
By default, boto3 will treat both "Rounded" and "Inexact" as unacceptable.

For DBESDK DynamoDB, change the DynamoDB context to treat "Rounded" as acceptable.
"""
from decimal import Rounded

import boto3.dynamodb.types

old_context = boto3.dynamodb.types.DYNAMODB_CONTEXT
old_traps = old_context.__getattribute__("traps")
# traps structure: {k (trap class) : v (True if trap should raise Exception; False otherwise)}
old_traps[Rounded] = False
boto3.dynamodb.types.DYNAMODB_CONTEXT.__setattr__("traps", old_traps)
