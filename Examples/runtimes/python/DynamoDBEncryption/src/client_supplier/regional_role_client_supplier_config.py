# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""
Configuration for the RegionalRoleClientSupplier.

Contains hardcoded configuration values for demonstration purposes. In production
code, these values might be loaded from environment variables, AWS AppConfig, or
other external sources.
"""


class RegionalRoleClientSupplierConfig:
    """
    Configuration class mapping AWS regions to IAM roles.

    Provides a mapping between AWS regions and their corresponding IAM roles for
    use in the RegionalRoleClientSupplier. For demonstration purposes, this uses
    hardcoded values.
    """

    US_EAST_1_IAM_ROLE = "arn:aws:iam::370957321024:role/GitHub-CI-DDBEC-Dafny-Role-only-us-east-1-KMS-keys"
    EU_WEST_1_IAM_ROLE = "arn:aws:iam::370957321024:role/GitHub-CI-DDBEC-Dafny-Role-only-eu-west-1-KMS-keys"

    def __init__(self):
        """Initialize the configuration with region to IAM role mapping."""
        self.region_iam_role_map = {"us-east-1": self.US_EAST_1_IAM_ROLE, "eu-west-1": self.EU_WEST_1_IAM_ROLE}
