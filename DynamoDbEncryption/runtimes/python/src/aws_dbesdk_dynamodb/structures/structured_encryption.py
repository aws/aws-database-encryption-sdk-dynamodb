# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""Alias for generated models."""

# Alias from:
# "aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.models.ABC"
# to:
# "aws_dbesdk_dynamodb.structures.structured_encryption.ABC"
# ruff: noqa: F403
from aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.models import *

# Dynamically define __all__ to reflect everything imported
__all__ = [
    name
    for name in dir()
    if not name.startswith("_")
    and name != "sys"
    and name not in ["aws_cryptographic_material_providers", "aws_dbesdk_dynamodb"]
]
