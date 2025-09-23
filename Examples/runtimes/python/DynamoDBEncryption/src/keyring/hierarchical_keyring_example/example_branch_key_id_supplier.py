# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""
Example implementation of a branch key ID supplier.

Used in the 'HierarchicalKeyringExample'.
In that example, we have a table where we distinguish multiple tenants
by a tenant ID that is stored in our partition attribute.
The expectation is that this does not produce a confused deputy
because the tenants are separated by partition.
In order to create a Hierarchical Keyring that is capable of encrypting or
decrypting data for either tenant, we implement this interface
to map the correct branch key ID to the correct tenant ID.
"""
from typing import Dict

from aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.references import (
    IDynamoDbKeyBranchKeyIdSupplier,
)
from aws_dbesdk_dynamodb.structures.dynamodb import GetBranchKeyIdFromDdbKeyInput, GetBranchKeyIdFromDdbKeyOutput


class ExampleBranchKeyIdSupplier(IDynamoDbKeyBranchKeyIdSupplier):
    """Example implementation of a branch key ID supplier."""

    branch_key_id_for_tenant1: str
    branch_key_id_for_tenant2: str

    def __init__(self, tenant1_id: str, tenant2_id: str):
        """
        Initialize a branch key ID supplier.

        :param tenant1_id: Branch key ID for tenant 1
        :param tenant2_id: Branch key ID for tenant 2
        """
        self.branch_key_id_for_tenant1 = tenant1_id
        self.branch_key_id_for_tenant2 = tenant2_id

    def get_branch_key_id_from_ddb_key(self, param: GetBranchKeyIdFromDdbKeyInput) -> GetBranchKeyIdFromDdbKeyOutput:
        """
        Get branch key ID from the tenant ID in input's DDB key.

        :param param: Input containing DDB key
        :return: Output containing branch key ID
        :raises ValueError: If DDB key is invalid or contains invalid tenant ID
        """
        key: Dict[str, Dict] = param.ddb_key

        if "partition_key" not in key:
            raise ValueError("Item invalid, does not contain expected partition key attribute.")

        tenant_key_id = key["partition_key"]["S"]

        if tenant_key_id == "tenant1Id":
            branch_key_id = self.branch_key_id_for_tenant1
        elif tenant_key_id == "tenant2Id":
            branch_key_id = self.branch_key_id_for_tenant2
        else:
            raise ValueError("Item does not contain valid tenant ID")

        return GetBranchKeyIdFromDdbKeyOutput(branch_key_id=branch_key_id)
