# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0

"""
Example demonstrating error handling for failed decryption during DynamoDB Scan operations with EncryptedClient.

Uses the Scan operation to show how to retrieve error messages from the
returned CollectionOfErrors when some of the Scan results do not decrypt successfully.

Running this example requires access to the DDB Table whose name is provided in
CLI arguments. This table must be configured with the following primary key
configuration:
  - Partition key is named "partition_key" with type (S)
  - Sort key is named "sort_key" with type (N)
"""
import boto3
from aws_dbesdk_dynamodb.encrypted.table import EncryptedTable

from .encryption_config import create_encryption_config, print_exception


def scan_error_with_table(kms_key_id: str, ddb_table_name: str):
    """
    Demonstrate handling scan errors with EncryptedClient.

    :param kms_key_id: The ARN of the KMS key to use
    :param ddb_table_name: The name of the DynamoDB table
    """
    # 1. Create the DynamoDb Encryption configuration for the table we will be writing to.
    #    See encryption_config.py in this directory for detailed steps on the encryption configuration.
    tables_config = create_encryption_config(
        kms_key_id=kms_key_id,
        ddb_table_name=ddb_table_name,
    )

    # 2. Create the EncryptedTable
    ddb_table = boto3.resource("dynamodb").Table(ddb_table_name)
    encrypted_ddb_table = EncryptedTable(
        table=ddb_table,
        encryption_config=tables_config,
    )

    # 3. Perform a Scan for which some records will not decrypt
    expression_attribute_values = {":prefix": "Broken"}

    try:
        encrypted_ddb_table.scan(
            FilterExpression="begins_with(partition_key, :prefix)",
            ExpressionAttributeValues=expression_attribute_values,
        )
        assert False, "scan should have failed"
    except Exception as e:
        print_exception(e)
