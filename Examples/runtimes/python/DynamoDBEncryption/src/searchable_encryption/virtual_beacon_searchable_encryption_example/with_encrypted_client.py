# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""
Example demonstrating DynamoDB encryption using virtual beacons with EncryptedClient.

This example demonstrates how to set up a virtual field from two DDB
attributes, create a standard beacon with that field, put an item with
that beacon, and query against that beacon.

A virtual field is a field consisting of a transformation of one or more attributes in a DDB item.
Virtual fields are useful in querying against encrypted fields that only have a handful of
possible values. They allow you to take fields with few possible values, concatenate
them to other fields, then query against the combined field. This enables using these types of
fields in queries while making it infeasible to identify which beacon values encode
the few possible distinct plaintexts. This is explained in more detail below.
Virtual fields are not stored in the DDB table. However, they are used to construct
a beacon, the value of which is stored.

For more information on virtual fields, see
  https://docs.aws.amazon.com/database-encryption-sdk/latest/devguide/beacons.html#virtual-field

For our example, we will construct a virtual field
from two DDB attributes `state` and `hasTestResult` as `state`+prefix(`hasTestResult`, 1).
We will then create a beacon out of this virtual field and use it to search.

This example follows a use case of a database that stores customer test result metadata.
Records are indexed by `customer_id` and store a `state` attribute, representing the
US state or territory where the customer lives, and a `hasTestResult` boolean attribute,
representing whether the customer has a "test result" available. (Maybe this represents
some medical test result, and this table stores "result available" metadata.) We assume
that values in these fields are uniformly distributed across all possible values for
these fields (56 for `state`, 2 for `hasTestResult`), and are uniformly distributed across
customer IDs.

The motivation behind this example is to demonstrate how and why one would use a virtual beacon.
In this example, our table stores records with an encrypted boolean `hasTestResult` attribute.
We would like to be able to query for customers in a given state with a `true` hasTestResult
attribute.

To be able to execute this query securely and efficiently, we want the following
properties on our table:
 1. Hide the distribution of `hasTestResult` attribute values (i.e. it should be infeasible
    to determine the percentage of `true`s to `false`s across the dataset from beaconized
    values)
 2. Query against a combination of whether `hasTestResult` is true/false and the `state` field
We cannot achieve these properties with a standard beacon on a true/false attribute. Following
the guidance to choose a beacon length:
  https://docs.aws.amazon.com/database-encryption-sdk/latest/devguide/choosing-beacon-length.html
For a boolean value (in our case, whether `hasTestResult` is true or false), the acceptable
bounds for beacon length are either 0 or 1. This corresponds to either not storing a beacon
(length 0), or effectively storing another boolean attribute (length 1). With
length 0, this beacon is useless for searching (violating property 2); with length 1, this
beacon may not hide the attribute (violating property 1).
In addition, choosing a longer beacon length does not help us.
Each attribute value is mapped to a distinct beacon.
Since booleans only have 2 possible attribute values, we will still only have 2 possible
beacon values, though those values may be longer. A longer beacon provides no advantages over
beacon of length 1 in this situation.

A compound beacon also does not help.
To (over)simplify, a compound beacon is a concatenation of standard beacons,
i.e. beacon(`state`)+beacon(`hasTestResult`).
The `hasTestResult` beacon is still visible, so we would still have the problems above.

To achieve these properties, we instead construct a virtual field and use that in our beacon,
i.e. beacon(`state`+`hasTestResult`). Assuming these fields are well-distributed across
customer IDs and possible values, this gives us both desired properties; we can query against
both attributes while hiding information from the underlying data. This is demonstrated in more
detail below.

Running this example requires access to a DDB table  with the
following primary key configuration:
  - Partition key is named "customer_id" with type (S)
  - Sort key is named "create_time" with type (S)
This table must have a Global Secondary Index (GSI) configured named "stateAndHasTestResult-index":
  - Partition key is named "aws_dbe_b_stateAndHasTestResult" with type (S)

In this example for storing customer location data, this schema is utilized for the data:
 - "customer_id" stores a unique customer identifier
 - "create_time" stores a Unix timestamp
 - "state" stores an encrypted 2-letter US state or territory abbreviation
       (https://www.faa.gov/air_traffic/publications/atpubs/cnt_html/appendix_a.html)
 - "hasTestResult" is not part of the schema, but is an attribute utilized in this example.
    It stores a boolean attribute (false/true) indicating whether this customer has a test result
    available.

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
from aws_dbesdk_dynamodb.encrypted.client import EncryptedClient
from aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.client import (
    DynamoDbEncryptionTransforms,
)
from aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.models import (
    ResolveAttributesInput,
)

from DynamoDBEncryption.src.searchable_encryption.virtual_beacon_searchable_encryption_example.beacon_config import (
    setup_beacon_config,
)

GSI_NAME = "stateAndHasTestResult-index"


def virtual_beacon_client_example(
    ddb_table_name: str,
    branch_key_id: str,
    branch_key_wrapping_kms_key_arn: str,
    branch_key_ddb_table_name: str,
):
    """
    Demonstrate using virtual beacon searchable encryption with EncryptedClient.

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

    # 3. Create test items - one with hasTestResult=true and one with hasTestResult=false
    # Create item with hasTestResult=true
    item_with_has_test_result = {
        "customer_id": {"S": "ABC-123"},
        "create_time": {"N": "1681495205"},
        "state": {"S": "CA"},
        "hasTestResult": {"BOOL": True},
    }

    # Create item with hasTestResult=false
    item_with_no_has_test_result = {
        "customer_id": {"S": "DEF-456"},
        "create_time": {"N": "1681495205"},
        "state": {"S": "CA"},
        "hasTestResult": {"BOOL": False},
    }

    # 4. If developing or debugging, verify config by checking virtual field values directly
    trans = DynamoDbEncryptionTransforms(config=tables_config)

    resolve_input = ResolveAttributesInput(table_name=ddb_table_name, item=item_with_has_test_result, version=1)

    resolve_output = trans.resolve_attributes(input=resolve_input)

    # CompoundBeacons is empty because we have no Compound Beacons configured
    assert not resolve_output.compound_beacons

    # Verify that VirtualFields has the expected value
    vf = {"stateAndHasTestResult": "CAt"}
    assert resolve_output.virtual_fields == vf

    # 5. Put two items into our table using the above client.
    #     The two items will differ only in their `customer_id` attribute (primary key)
    #         and their `hasTestResult` attribute.
    #     We will query against these items to demonstrate how to use our setup above
    #         to query against our `stateAndHasTestResult` beacon.
    #     Before the item gets sent to DynamoDb, it will be encrypted
    #         client-side, according to our configuration.
    #     Since our configuration includes a beacon on a virtual field named
    #         `stateAndHasTestResult`, the client will add an attribute
    #         to the item with name `aws_dbe_b_stateAndHasTestResult`.
    #         Its value will be an HMAC truncated to as many bits as the
    #         beacon's `length` parameter; i.e. 5.
    put_response = encrypted_ddb_client.put_item(TableName=ddb_table_name, Item=item_with_has_test_result)
    # Assert PutItem was successful
    assert put_response["ResponseMetadata"]["HTTPStatusCode"] == 200

    put_response = encrypted_ddb_client.put_item(TableName=ddb_table_name, Item=item_with_no_has_test_result)
    # Assert PutItem was successful
    assert put_response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # 6. Query by stateAndHasTestResult attribute.
    #     Note that we are constructing the query as if we were querying on plaintext values.
    #     However, the DDB encryption client will detect that this attribute name has a beacon configured.
    #     The client will add the beaconized attribute name and attribute value to the query,
    #         and transform the query to use the beaconized name and value.
    #     Internally, the client will query for and receive all items with a matching HMAC value in the beacon field.
    #     This may include a number of "false positives" with different ciphertext, but the same truncated HMAC.
    #     e.g. if truncate(HMAC("CAt"), 5) == truncate(HMAC("DCf"), 5), the query will return both items.
    #     The client will decrypt all returned items to determine which ones have the expected attribute values,
    #         and only surface items with the correct plaintext to the user.
    #     This procedure is internal to the client and is abstracted away from the user;
    #     e.g. the user will only see "CAt" and never "DCf", though the actual query returned both.
    expression_attribute_names = {"#stateAndHasTestResult": "stateAndHasTestResult"}

    # We are querying for the item with `state`="CA" and `hasTestResult`=`true`.
    # Since we added virtual parts as `state` then `hasTestResult`,
    #     we must write our query expression in the same order.
    # We constructed our virtual field as `state`+`hasTestResult`,
    #     so we add the two parts in that order.
    # Since we also created a virtual transform that truncated `hasTestResult`
    #     to its length-1 prefix, i.e. "true" -> "t",
    #     we write that field as its length-1 prefix in the query.
    expression_attribute_values = {":stateAndHasTestResult": {"S": "CAt"}}

    # We are querying for the item with state="CA" and hasTestResult=true.
    # We constructed our virtual field as state+hasTestResult,
    # with hasTestResult truncated to its first character.
    # For "true", this is "t", so we search for "CAt"
    expression_attribute_values = {":stateAndHasTestResult": {"S": "CAt"}}

    # GSIs do not update instantly
    # so if the results come back empty
    # we retry after a short sleep
    for _ in range(10):
        query_response = encrypted_ddb_client.query(
            TableName=ddb_table_name,
            IndexName=GSI_NAME,
            KeyConditionExpression="#stateAndHasTestResult = :stateAndHasTestResult",
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

        # Validate only 1 item was returned: the item with the expected attributes
        assert len(items) == 1
        returned_item = items[0]
        # Validate the item has the expected attributes
        assert returned_item["state"]["S"] == "CA"
        assert returned_item["hasTestResult"]["BOOL"] is True
        break
