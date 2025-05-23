# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""
Class containing config for the RegionalRoleClientSupplier.
In your own code, this might be hardcoded, or reference
an external source, e.g. environment variables or AWS AppConfig.
"""


class RegionalRoleClientSupplierConfig:
    US_EAST_1_IAM_ROLE = "arn:aws:iam::370957321024:role/GitHub-CI-DDBEC-Dafny-Role-only-us-east-1-KMS-keys"
    EU_WEST_1_IAM_ROLE = "arn:aws:iam::370957321024:role/GitHub-CI-DDBEC-Dafny-Role-only-eu-west-1-KMS-keys"

    def __init__(self):
        self.region_iam_role_map = {
            "us-east-1": self.US_EAST_1_IAM_ROLE,
            "eu-west-1": self.EU_WEST_1_IAM_ROLE
        }
