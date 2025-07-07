# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""
Example demonstrating DynamoDB encryption using beacons with EncryptedTable.

This example demonstrates how to set up a beacon on an encrypted attribute,
put an item with the beacon, and query against that beacon.
This example follows a use case of a database that stores unit inspection information.

Running this example requires access to a DDB table with the
following key configuration:
  - Partition key is named "work_id" with type (S)
  - Sort key is named "inspection_date" with type (S)
This table must have a Global Secondary Index (GSI) configured named "last4-unit-index":
  - Partition key is named "aws_dbe_b_inspector_id_last4" with type (S)
  - Sort key is named "aws_dbe_b_unit" with type (S)

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

import boto3
from aws_dbesdk_dynamodb.encrypted.table import EncryptedTable

from .beacon_config import (
    GSI_NAME,
    setup_beacon_config,
)


def basic_searchable_encryption_table_example(
    ddb_table_name: str, branch_key_id: str, branch_key_wrapping_kms_key_arn: str, branch_key_ddb_table_name: str
):
    """
    Demonstrate using beacons with DynamoDB encryption with EncryptedTable.

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

    # 2. Create the EncryptedTable
    ddb_table = boto3.resource("dynamodb").Table(ddb_table_name)
    encrypted_ddb_table = EncryptedTable(table=ddb_table, encryption_config=tables_config)

    # 3. Put an item into our table using the above encrypted table.
    #    Before the item gets sent to DynamoDb, it will be encrypted
    #        client-side, according to our configuration.
    #    Since our configuration includes beacons for `inspector_id_last4` and `unit`,
    #        the client will add two additional attributes to the item. These attributes will have names
    #        `aws_dbe_b_inspector_id_last4` and `aws_dbe_b_unit`. Their values will be HMACs
    #        truncated to as many bits as the beacon's `length` parameter; e.g.
    #    aws_dbe_b_inspector_id_last4 = truncate(HMAC("4321"), 10)
    #    aws_dbe_b_unit = truncate(HMAC("123456789012"), 30)
    item = {
        "work_id": "1313ba89-5661-41eb-ba6c-cb1b4cb67b2d",
        "inspection_date": "2023-06-13",
        "inspector_id_last4": "4321",
        "unit": "123456789012",
    }

    put_response = encrypted_ddb_table.put_item(Item=item)

    assert put_response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # 4. Query for the item we just put.
    #    Note that we are constructing the query as if we were querying on plaintext values.
    #    However, the DDB encryption client will detect that this attribute name has a beacon configured.
    #    The client will add the beaconized attribute name and attribute value to the query,
    #        and transform the query to use the beaconized name and value.
    #    Internally, the client will query for and receive all items with a matching HMAC value in the beacon field.
    #    This may include a number of "false positives" with different ciphertext, but the same truncated HMAC.
    #    e.g. if truncate(HMAC("123456789012"), 30)
    #         == truncate(HMAC("098765432109"), 30),
    #    the query will return both items.
    #    The client will decrypt all returned items to determine which ones have the expected attribute values,
    #        and only surface items with the correct plaintext to the user.
    #    This procedure is internal to the client and is abstracted away from the user;
    #    e.g. the user will only see "123456789012" and never
    #       "098765432109", though the actual query returned both.
    expression_attribute_names = {"#last4": "inspector_id_last4", "#unit": "unit"}

    expression_attribute_values = {":last4": "4321", ":unit": "123456789012"}

    # GSIs do not update instantly
    # so if the results come back empty
    # we retry after a short sleep
    for _ in range(10):
        query_response = encrypted_ddb_table.query(
            IndexName=GSI_NAME,
            KeyConditionExpression="#last4 = :last4 and #unit = :unit",
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
        assert returned_item["inspector_id_last4"] == "4321"
        assert returned_item["unit"] == "123456789012"
        break
