# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""
Example demonstrating DynamoDB encryption using compound beacons with EncryptedClient.

This example demonstrates how to set up a compound beacon on encrypted attributes,
    put an item with the beacon, and query against that beacon.
This example follows a use case of a database that stores unit inspection information.
    This is an extension of the "BasicSearchableEncryptionExample" in this directory.
    This example uses the same situation (storing unit inspection information)
    and the same table schema.
However, this example uses a different Global Secondary Index (GSI)
    that is based on a compound beacon configuration composed of
    the `last4` and `unit` attributes.

Running this example requires access to a DDB table with the
following key configuration:
  - Partition key is named "work_id" with type (S)
  - Sort key is named "inspection_time" with type (S)
This table must have a Global Secondary Index (GSI) configured named "last4UnitCompound-index":
  - Partition key is named "aws_dbe_b_last4UnitCompound" with type (S)

In this example for storing unit inspection information, this schema is utilized for the data:
 - "work_id" stores a unique identifier for a unit inspection work order (v4 UUID)
 - "inspection_date" stores an ISO 8601 date for the inspection (YYYY-MM-DD)
 - "inspector_id_last4" stores the last 4 digits of the ID of the inspector performing the work
 - "unit" stores a 12-digit serial number for the unit being inspected

The example requires the following ordered input command line parameters:
  1. DDB table name for table to put/query data from
  2. Branch key ID for a branch key that was previously created in your key store. See the
     CreateKeyStoreKeyExample.
  3. Branch key wrapping KMS key ARN for the KMS key used to create the branch key with ID
     provided in arg 2
  4. Branch key DDB table name for the DDB table representing the branch key store
"""
import time
from typing import Dict

import boto3
from aws_dbesdk_dynamodb.encrypted.client import EncryptedClient
from aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.client import (
    DynamoDbEncryptionTransforms,
)
from aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.models import (
    ResolveAttributesInput,
)

from DynamoDBEncryption.src.searchable_encryption.compound_beacon_searchable_encryption_example.beacon_config import (
    GSI_NAME,
    setup_beacon_config,
)


def compound_beacon_client_example(
    ddb_table_name: str,
    branch_key_id: str,
    branch_key_wrapping_kms_key_arn: str,
    branch_key_ddb_table_name: str,
):
    """
    Demonstrate using compound beacon searchable encryption with EncryptedClient.

    :param ddb_table_name: The name of the DynamoDB table
    :param branch_key_id: Branch key ID for a branch key previously created in key store
    :param branch_key_wrapping_kms_key_arn: ARN of KMS key used to create the branch key
    :param branch_key_ddb_table_name: Name of DDB table representing the branch key store
    """
    # 1. Create the DynamoDb Encryption configuration for the table we will be writing to.
    #    See beacon_config.py in this directory for detailed steps on the encryption configuration.
    tables_config = setup_beacon_config(
        ddb_table_name, branch_key_id, branch_key_wrapping_kms_key_arn, branch_key_ddb_table_name
    )

    # 2. Create the EncryptedClient
    ddb_client = boto3.client("dynamodb")
    encrypted_client = EncryptedClient(client=ddb_client, encryption_config=tables_config)

    # 3. Create an item with both attributes used in the compound beacon.
    item = {
        "work_id": {"S": "9ce39272-8068-4efd-a211-cd162ad65d4c"},
        "inspection_date": {"S": "2023-06-13"},
        "inspector_id_last4": {"S": "5678"},
        "unit": {"S": "011899988199"},
    }

    # 4. If developing or debugging, verify config by checking compound beacon values directly
    trans = DynamoDbEncryptionTransforms(config=tables_config)

    resolve_input = ResolveAttributesInput(table_name=ddb_table_name, item=item, version=1)

    resolve_output = trans.resolve_attributes(input=resolve_input)

    # VirtualFields is empty because we have no Virtual Fields configured
    assert not resolve_output.virtual_fields

    # Verify that CompoundBeacons has the expected value
    cbs = {"last4UnitCompound": "L-5678.U-011899988199"}
    assert resolve_output.compound_beacons == cbs
    # Note : the compound beacon actually stored in the table is not "L-5678.U-011899988199"
    # but rather something like "L-abc.U-123", as both parts are EncryptedParts
    # and therefore the text is replaced by the associated beacon

    put_and_query_item_with_compound_beacon(encrypted_client, ddb_table_name, item)


def put_and_query_item_with_compound_beacon(ddb_client: EncryptedClient, ddb_table_name: str, item: Dict):
    """
    Put and query an item using a compound beacon.

    :param ddb_client: The encrypted DynamoDB client
    :param ddb_table_name: The name of the DynamoDB table
    :param item: The item to put and query
    """
    # Write the item to the table
    put_response = ddb_client.put_item(TableName=ddb_table_name, Item=item)
    # Validate object put successfully
    assert put_response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # Query for the item we just put.
    expression_attribute_names = {"#compound": "last4UnitCompound"}

    # This query expression takes a few factors into consideration:
    #  - The configured prefix for the last 4 digits of an inspector ID is "L-";
    #    the prefix for the unit is "U-"
    #  - The configured split character, separating component parts, is "."
    #  - The default constructor adds encrypted parts in the order they are in the encrypted list, which
    #    configures `last4` to come before `unit``
    # NOTE: We did not need to create a compound beacon for this query. This query could have also been
    #       done by querying on the partition and sort key, as was done in the Basic example.
    #       This is intended to be a simple example to demonstrate how one might set up a compound beacon.
    #       For examples where compound beacons are required, see the Complex example.
    #       The most basic extension to this example that would require a compound beacon would add a third
    #       part to the compound beacon, then query against three parts.
    expression_attribute_values = {":value": {"S": "L-5678.U-011899988199"}}

    # GSIs do not update instantly
    # so if the results come back empty
    # we retry after a short sleep
    for _ in range(10):
        query_response = ddb_client.query(
            TableName=ddb_table_name,
            IndexName=GSI_NAME,
            KeyConditionExpression="#compound = :value",
            ExpressionAttributeNames=expression_attribute_names,
            ExpressionAttributeValues=expression_attribute_values,
        )

        # Validate query was returned successfully
        assert query_response["ResponseMetadata"]["HTTPStatusCode"] == 200

        items = query_response.get("Items", [])
        # if no results, sleep and try again
        if not items:
            time.sleep(0.02)
            continue

        # Validate only 1 item was returned: the item we just put
        assert len(items) == 1
        returned_item = items[0]
        # Validate the item has the expected attributes
        assert returned_item["inspector_id_last4"]["S"] == "5678"
        assert returned_item["unit"]["S"] == "011899988199"
        break
