# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""
Example demonstrating DynamoDB encryption using compound beacons.

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
import concurrent.futures
import time
from typing import Dict

import boto3
from aws_cryptographic_material_providers.keystore.client import KeyStore
from aws_cryptographic_material_providers.keystore.config import KeyStoreConfig
from aws_cryptographic_material_providers.keystore.models import KMSConfigurationKmsKeyArn
from aws_cryptographic_material_providers.mpl import AwsCryptographicMaterialProviders
from aws_cryptographic_material_providers.mpl.config import MaterialProvidersConfig
from aws_cryptographic_material_providers.mpl.models import CreateAwsKmsHierarchicalKeyringInput
from aws_dbesdk_dynamodb.encrypted.client import EncryptedClient
from aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.client import (
    DynamoDbEncryptionTransforms,
)
from aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.models import (
    ResolveAttributesInput,
)
from aws_dbesdk_dynamodb.structures.dynamodb import (
    BeaconKeySourceSingle,
    BeaconStylePartOnly,
    BeaconVersion,
    CompoundBeacon,
    Constructor,
    ConstructorPart,
    DynamoDbTableEncryptionConfig,
    DynamoDbTablesEncryptionConfig,
    EncryptedPart,
    PartOnly,
    SearchConfig,
    SingleKeyStore,
    StandardBeacon,
)
from aws_dbesdk_dynamodb.structures.structured_encryption import CryptoAction

GSI_NAME = "last4UnitCompound-index"
MAX_CONCURRENT_QUERY_THREADS = 10


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


def put_item_query_item_with_compound_beacon(
    ddb_table_name: str, branch_key_id: str, branch_key_wrapping_kms_key_arn: str, branch_key_ddb_table_name: str
):
    """
    Demonstrate using compound beacons with DynamoDB encryption.

    :param ddb_table_name: The name of the DynamoDB table
    :param branch_key_id: Branch key ID for a branch key previously created in key store
    :param branch_key_wrapping_kms_key_arn: ARN of KMS key used to create the branch key
    :param branch_key_ddb_table_name: Name of DDB table representing the branch key store
    """
    # 1. Create Beacons.
    #    These are the same beacons as in the "BasicSearchableEncryptionExample" in this directory.
    #    See that file to see details on beacon construction and parameters.
    #    While we will not directly query against these beacons,
    #      you must create standard beacons on encrypted fields
    #      that we wish to use in compound beacons.
    #    We mark them both as PartOnly to enforce the fact that
    #      we will not directly query against these beacons.
    standard_beacon_list = [
        StandardBeacon(name="inspector_id_last4", length=10, style=BeaconStylePartOnly(PartOnly())),
        StandardBeacon(name="unit", length=30, style=BeaconStylePartOnly(PartOnly())),
    ]

    # 2. Define encrypted parts.
    #    Encrypted parts define the beacons that can be used to construct a compound beacon,
    #        and how the compound beacon prefixes those beacon values.
    # A encrypted part must receive:
    #  - name: Name of a standard beacon
    #  - prefix: Any string. This is plaintext that prefixes the beaconized value in the compound beacon.
    #            Prefixes must be unique across the configuration, and must not be a prefix of another prefix;
    #            i.e. for all configured prefixes, the first N characters of a prefix must not equal another prefix.
    # In practice, it is suggested to have a short value distinguishable from other parts served on the prefix.
    encrypted_part_list = [
        # For this example, we will choose "L-" as the prefix for "Last 4 digits of inspector ID".
        # With this prefix and the standard beacon's bit length definition (10), the beaconized
        #     version of the inspector ID's last 4 digits will appear as
        #     `L-000` to `L-3ff` inside a compound beacon.
        EncryptedPart(name="inspector_id_last4", prefix="L-"),
        # For this example, we will choose "U-" as the prefix for "unit".
        # With this prefix and the standard beacon's bit length definition (30), a unit beacon will appear
        #     as `U-00000000` to `U-3fffffff` inside a compound beacon.
        EncryptedPart(name="unit", prefix="U-"),
    ]

    constructor_parts = [
        ConstructorPart(name="inspector_id_last4", required=True),
        ConstructorPart(name="unit", required=True),
    ]

    constructors = [Constructor(parts=constructor_parts)]

    # 3. Define compound beacon.
    #    A compound beacon allows one to serve multiple beacons or attributes from a single index.
    #    A compound beacon must receive:
    #     - name: The name of the beacon. Compound beacon values will be written to `aws_ddb_e_[name]`.
    #     - split: A character separating parts in a compound beacon
    #    A compound beacon may also receive:
    #     - encrypted: A list of encrypted parts. This is effectively a list of beacons. We provide the list
    #                  that we created above.
    #     - constructors: A list of constructors. This is an ordered list of possible ways to create a beacon.
    #                     We have not defined any constructors here; see the complex example for how to do this.
    #                     The client will provide a default constructor, which will write a compound beacon as:
    #                     all signed parts in the order they are added to the signed list;
    #                     all encrypted parts in order they are added to the encrypted list; all parts required.
    #                     In this example, we expect compound beacons to be written as
    #                     `L-XXX.U-YYYYYYYY`, since our encrypted list looks like
    #                     [last4EncryptedPart, unitEncryptedPart].
    #     - signed: A list of signed parts, i.e. plaintext attributes. This would be provided if we
    #                     wanted to use plaintext values as part of constructing our compound beacon. We do not
    #                     provide this here; see the Complex example for an example.
    compound_beacon_list = [CompoundBeacon(name="last4UnitCompound", constructors=constructors, split=".")]

    # 4. Configure the Keystore
    #    These are the same constructions as in the Basic example, which describes these in more detail.
    keystore = KeyStore(
        config=KeyStoreConfig(
            ddb_client=boto3.client("dynamodb"),
            ddb_table_name=branch_key_ddb_table_name,
            logical_key_store_name=branch_key_ddb_table_name,
            kms_client=boto3.client("kms"),
            kms_configuration=KMSConfigurationKmsKeyArn(value=branch_key_wrapping_kms_key_arn),
        )
    )

    # 5. Create BeaconVersion.
    #    This is similar to the Basic example, except we have also provided a compoundBeaconList.
    #    We must also continue to provide all of the standard beacons that compose a compound beacon list.
    beacon_versions = [
        BeaconVersion(
            encrypted_parts=encrypted_part_list,
            standard_beacons=standard_beacon_list,
            compound_beacons=compound_beacon_list,
            version=1,  # MUST be 1
            key_store=keystore,
            key_source=BeaconKeySourceSingle(SingleKeyStore(key_id=branch_key_id, cache_ttl=6000)),
        )
    ]

    # 6. Create a Hierarchical Keyring
    #    This is the same configuration as in the Basic example.
    mat_prov = AwsCryptographicMaterialProviders(config=MaterialProvidersConfig())

    keyring_input = CreateAwsKmsHierarchicalKeyringInput(
        branch_key_id=branch_key_id, key_store=keystore, ttl_seconds=6000
    )

    kms_keyring = mat_prov.create_aws_kms_hierarchical_keyring(input=keyring_input)

    # 7. Configure which attributes are encrypted and/or signed when writing new items.
    attribute_actions = {
        "work_id": CryptoAction.SIGN_ONLY,  # Our partition attribute must be SIGN_ONLY
        "inspection_date": CryptoAction.SIGN_ONLY,  # Our sort attribute must be SIGN_ONLY
        "inspector_id_last4": CryptoAction.ENCRYPT_AND_SIGN,  # Beaconized attributes must be encrypted
        "unit": CryptoAction.ENCRYPT_AND_SIGN,  # Beaconized attributes must be encrypted
    }

    # We do not need to define a crypto action on last4UnitCompound.
    # We only need to define crypto actions on attributes that we pass to PutItem.

    # 8. Create the DynamoDb Encryption configuration for the table we will be writing to.
    #    The beaconVersions are added to the search configuration.
    table_config = DynamoDbTableEncryptionConfig(
        logical_table_name=ddb_table_name,
        partition_key_name="work_id",
        sort_key_name="inspection_date",
        attribute_actions_on_encrypt=attribute_actions,
        keyring=kms_keyring,
        search=SearchConfig(write_version=1, versions=beacon_versions),  # MUST be 1
    )

    table_configs = {ddb_table_name: table_config}
    tables_config = DynamoDbTablesEncryptionConfig(table_encryption_configs=table_configs)

    # 9. Create an item with both attributes used in the compound beacon.
    item = {
        "work_id": {"S": "9ce39272-8068-4efd-a211-cd162ad65d4c"},
        "inspection_date": {"S": "2023-06-13"},
        "inspector_id_last4": {"S": "5678"},
        "unit": {"S": "011899988199"},
    }

    # 10. If developing or debugging, verify config by checking compound beacon values directly
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

    # 11. Create the EncryptedClient
    ddb_client = boto3.client("dynamodb")
    encrypted_ddb_client = EncryptedClient(client=ddb_client, encryption_config=tables_config)

    put_and_query_item_with_compound_beacon(encrypted_ddb_client, ddb_table_name, item)

    # If instead you were working in a multi-threaded context
    # it might look like this
    with concurrent.futures.ThreadPoolExecutor(max_workers=MAX_CONCURRENT_QUERY_THREADS) as executor:
        futures = []
        for _ in range(2 * MAX_CONCURRENT_QUERY_THREADS):
            for _ in range(20):
                futures.append(
                    executor.submit(put_and_query_item_with_compound_beacon, encrypted_ddb_client, ddb_table_name, item)
                )
        concurrent.futures.wait(futures, timeout=30)
