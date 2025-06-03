# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""
Example demonstrating DynamoDB encryption using beacon styles with EncryptedClient.

This example demonstrates how to use Beacons Styles on Standard Beacons on encrypted attributes,
    put an item with the beacon, and query against that beacon.
This example follows a use case of a database that stores food information.
    This is an extension of the "BasicSearchableEncryptionExample" in this directory
    and uses the same table schema.

Running this example requires access to a DDB table with the
following key configuration:
  - Partition key is named "work_id" with type (S)
  - Sort key is named "inspection_time" with type (S)

In this example for storing food information, this schema is utilized for the data:
 - "work_id" stores a unique identifier for a unit inspection work order (v4 UUID)
 - "inspection_date" stores an ISO 8601 date for the inspection (YYYY-MM-DD)
 - "fruit" stores one type of fruit
 - "basket" stores a set of types of fruit
 - "dessert" stores one type of dessert
 - "veggies" stores a set of types of vegetable
 - "work_type" stores a unit inspection category

The example requires the following ordered input command line parameters:
  1. DDB table name for table to put/query data from
  2. Branch key ID for a branch key that was previously created in your key store. See the
     CreateKeyStoreKeyExample.
  3. Branch key wrapping KMS key ARN for the KMS key used to create the branch key with ID
     provided in arg 2
  4. Branch key DDB table name for the DDB table representing the branch key store
"""
import boto3
from aws_dbesdk_dynamodb.encrypted.client import EncryptedClient

from .beacon_config import setup_beacon_config


def beacon_styles_client_example(
    ddb_table_name: str,
    branch_key_id: str,
    branch_key_wrapping_kms_key_arn: str,
    branch_key_ddb_table_name: str,
):
    """
    Demonstrate using different beacon styles with EncryptedClient.

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
    encrypted_ddb_client = EncryptedClient(client=ddb_client, encryption_config=tables_config)

    # 3. Create item one, specifically with "dessert != fruit", and "fruit in basket".
    item1 = {
        "work_id": {"S": "1"},
        "inspection_date": {"S": "2023-06-13"},
        "dessert": {"S": "cake"},
        "fruit": {"S": "banana"},
        "basket": {"SS": ["apple", "banana", "pear"]},
        "veggies": {"SS": ["beans", "carrots", "celery"]},
        "work_type": {"S": "small"},
    }

    # 4. Create item two, specifically with "dessert == fruit", and "fruit not in basket".
    item2 = {
        "work_id": {"S": "2"},
        "inspection_date": {"S": "2023-06-13"},
        "fruit": {"S": "orange"},
        "dessert": {"S": "orange"},
        "basket": {"SS": ["blackberry", "blueberry", "strawberry"]},
        "veggies": {"SS": ["beans", "carrots", "peas"]},
        "work_type": {"S": "large"},
    }

    # 5. Add the two items
    put_response = encrypted_ddb_client.put_item(TableName=ddb_table_name, Item=item1)
    # Validate object put successfully
    assert put_response["ResponseMetadata"]["HTTPStatusCode"] == 200

    put_response = encrypted_ddb_client.put_item(TableName=ddb_table_name, Item=item2)
    # Validate object put successfully
    assert put_response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # 6. Test the first type of Set operation:
    # Select records where the basket attribute holds a particular value
    expression_attribute_values = {":value": {"S": "banana"}}

    scan_response = encrypted_ddb_client.scan(
        TableName=ddb_table_name,
        FilterExpression="contains(basket, :value)",
        ExpressionAttributeValues=expression_attribute_values,
    )
    # Validate query was returned successfully
    assert scan_response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # Validate only 1 item was returned: item1
    assert len(scan_response["Items"]) == 1
    assert scan_response["Items"][0] == item1

    # 7. Test the second type of Set operation:
    # Select records where the basket attribute holds the fruit attribute
    scan_response = encrypted_ddb_client.scan(TableName=ddb_table_name, FilterExpression="contains(basket, fruit)")
    # Validate query was returned successfully
    assert scan_response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # Validate only 1 item was returned: item1
    assert len(scan_response["Items"]) == 1
    assert scan_response["Items"][0] == item1

    # 8. Test the third type of Set operation:
    # Select records where the fruit attribute exists in a particular set
    expression_attribute_values = {":value": {"SS": ["boysenberry", "grape", "orange"]}}

    scan_response = encrypted_ddb_client.scan(
        TableName=ddb_table_name,
        FilterExpression="contains(:value, fruit)",
        ExpressionAttributeValues=expression_attribute_values,
    )
    # Validate query was returned successfully
    assert scan_response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # Validate only 1 item was returned: item2
    assert len(scan_response["Items"]) == 1
    assert scan_response["Items"][0] == item2

    # 9. Test a Shared search. Select records where the dessert attribute matches the fruit attribute
    scan_response = encrypted_ddb_client.scan(TableName=ddb_table_name, FilterExpression="dessert = fruit")
    # Validate query was returned successfully
    assert scan_response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # Validate only 1 item was returned: item2
    assert len(scan_response["Items"]) == 1
    assert scan_response["Items"][0] == item2

    # 10. Test the AsSet attribute 'veggies':
    # Select records where the veggies attribute holds a particular value
    expression_attribute_values = {":value": {"S": "peas"}}

    scan_response = encrypted_ddb_client.scan(
        TableName=ddb_table_name,
        FilterExpression="contains(veggies, :value)",
        ExpressionAttributeValues=expression_attribute_values,
    )
    # Validate query was returned successfully
    assert scan_response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # Validate only 1 item was returned: item2
    assert len(scan_response["Items"]) == 1
    assert scan_response["Items"][0] == item2

    # 11. Test the compound beacon 'work_unit':
    expression_attribute_values = {":value": {"S": "I-1.T-small"}}

    scan_response = encrypted_ddb_client.scan(
        TableName=ddb_table_name,
        FilterExpression="work_unit = :value",
        ExpressionAttributeValues=expression_attribute_values,
    )
    # Validate query was returned successfully
    assert scan_response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # Validate only 1 item was returned: item1
    assert len(scan_response["Items"]) == 1
    assert scan_response["Items"][0] == item1
