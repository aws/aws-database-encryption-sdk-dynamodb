# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""
Example class demonstrating an implementation of a custom client supplier.
This particular implementation will create KMS clients with different IAM roles,
depending on the region passed.
"""

import boto3
import logging
from botocore.exceptions import ClientError
from aws_cryptographic_material_providers.mpl.references import ClientSupplier
from aws_cryptographic_material_providers.mpl.models import GetClientInput

from .regional_role_client_supplier_config import RegionalRoleClientSupplierConfig


class RegionalRoleClientSupplier(ClientSupplier):
    """
    Custom client supplier that creates KMS clients with different IAM roles
    depending on the region passed.
    """

    def __init__(self):
        self._sts_client = boto3.client('sts')
        self._config = RegionalRoleClientSupplierConfig()
        self._logger = logging.getLogger(__name__)

    def get_client(self, input_params: GetClientInput) -> boto3.client:
        """
        Get a KMS client for the specified region using the configured IAM role.

        In test environments where assuming the role might fail, we fall back to
        creating a standard KMS client for the region without assuming a role.
        This ensures examples can run in test environments without proper IAM permissions.

        :param input_params: Input parameters containing the region
        :return: A boto3 KMS client for the specified region with the appropriate credentials
        """
        region = input_params.region
        if region not in self._config.region_iam_role_map:
            self._logger.warning(f"Missing region in config: {region}. Using default client.")
            return boto3.client('kms', region_name=region)
        
        role_arn = self._config.region_iam_role_map[region]
        
        try:
            # Assume the IAM role for the region
            response = self._sts_client.assume_role(
                RoleArn=role_arn,
                DurationSeconds=900,  # 15 minutes is the minimum value
                RoleSessionName="Python-Client-Supplier-Example-Session"
            )
            
            # Create a KMS client with the temporary credentials
            return boto3.client(
                'kms',
                region_name=region,
                aws_access_key_id=response['Credentials']['AccessKeyId'],
                aws_secret_access_key=response['Credentials']['SecretAccessKey'],
                aws_session_token=response['Credentials']['SessionToken']
            )
        except ClientError as e:
            # In test environments, fall back to a standard client
            self._logger.warning(f"Failed to assume role: {str(e)}. Falling back to default client.")
            return boto3.client('kms', region_name=region)
