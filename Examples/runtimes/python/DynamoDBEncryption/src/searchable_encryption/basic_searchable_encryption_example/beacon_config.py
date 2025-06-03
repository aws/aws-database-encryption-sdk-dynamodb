# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""Sets up the beacon config for basic searchable encryption."""
from typing import List

import boto3
from aws_cryptographic_material_providers.keystore.client import KeyStore
from aws_cryptographic_material_providers.keystore.config import KeyStoreConfig
from aws_cryptographic_material_providers.keystore.models import KMSConfigurationKmsKeyArn
from aws_cryptographic_material_providers.mpl import AwsCryptographicMaterialProviders
from aws_cryptographic_material_providers.mpl.config import MaterialProvidersConfig
from aws_cryptographic_material_providers.mpl.models import CreateAwsKmsHierarchicalKeyringInput
from aws_dbesdk_dynamodb.structures.dynamodb import (
    BeaconKeySourceSingle,
    BeaconVersion,
    DynamoDbTableEncryptionConfig,
    DynamoDbTablesEncryptionConfig,
    SearchConfig,
    SingleKeyStore,
    StandardBeacon,
)
from aws_dbesdk_dynamodb.structures.structured_encryption import CryptoAction

GSI_NAME = "last4-unit-index"


def setup_beacon_config(
    ddb_table_name: str,
    branch_key_id: str,
    branch_key_wrapping_kms_key_arn: str,
    branch_key_ddb_table_name: str,
):
    """Set up the beacon config for basic searchable encryption."""
    # 1. Configure Beacons.
    #    The beacon name must be the name of a table attribute that will be encrypted.
    #    The `length` parameter dictates how many bits are in the beacon attribute value.
    #    The following link provides guidance on choosing a beacon length:
    #        https://docs.aws.amazon.com/database-encryption-sdk/latest/devguide/choosing-beacon-length.html
    standard_beacon_list: List[StandardBeacon] = []

    # The configured DDB table has a GSI on the `aws_dbe_b_inspector_id_last4` AttributeName.
    # This field holds the last 4 digits of an inspector ID.
    # For our example, this field may range from 0 to 9,999 (10,000 possible values).
    # For our example, we assume a full inspector ID is an integer
    #     ranging from 0 to 99,999,999. We do not assume that the full inspector ID's
    #     values are uniformly distributed across its range of possible values.
    #     In many use cases, the prefix of an identifier encodes some information
    #     about that identifier (e.g. zipcode and SSN prefixes encode geographic
    #     information), while the suffix does not and is more uniformly distributed.
    #     We will assume that the inspector ID field matches a similar use case.
    #     So for this example, we only store and use the last
    #     4 digits of the inspector ID, which we assume is uniformly distributed.
    # Since the full ID's range is divisible by the range of the last 4 digits,
    #     then the last 4 digits of the inspector ID are uniformly distributed
    #     over the range from 0 to 9,999.
    # See our documentation for why you should avoid creating beacons over non-uniform distributions
    #  https://docs.aws.amazon.com/database-encryption-sdk/latest/devguide/searchable-encryption.html#are-beacons-right-for-me
    # A single inspector ID suffix may be assigned to multiple `work_id`s.
    #
    # This link provides guidance for choosing a beacon length:
    #    https://docs.aws.amazon.com/database-encryption-sdk/latest/devguide/choosing-beacon-length.html
    # We follow the guidance in the link above to determine reasonable bounds
    # for the length of a beacon on the last 4 digits of an inspector ID:
    #  - min: log(sqrt(10,000))/log(2) ~= 6.6, round up to 7
    #  - max: log((10,000/2))/log(2) ~= 12.3, round down to 12
    # You will somehow need to round results to a nearby integer.
    # We choose to round to the nearest integer; you might consider a different rounding approach.
    # Rounding up will return fewer expected "false positives" in queries,
    #    leading to fewer decrypt calls and better performance,
    #    but it is easier to identify which beacon values encode distinct plaintexts.
    # Rounding down will return more expected "false positives" in queries,
    #    leading to more decrypt calls and worse performance,
    #    but it is harder to identify which beacon values encode distinct plaintexts.
    # We can choose a beacon length between 7 and 12:
    #  - Closer to 7, we expect more "false positives" to be returned,
    #    making it harder to identify which beacon values encode distinct plaintexts,
    #    but leading to more decrypt calls and worse performance
    #  - Closer to 12, we expect fewer "false positives" returned in queries,
    #    leading to fewer decrypt calls and better performance,
    #    but it is easier to identify which beacon values encode distinct plaintexts.
    # As an example, we will choose 10.
    #
    # Values stored in aws_dbe_b_inspector_id_last4 will be 10 bits long (0x000 - 0x3ff)
    # There will be 2^10 = 1,024 possible HMAC values.
    # With a sufficiently large number of well-distributed inspector IDs,
    #    for a particular beacon we expect (10,000/1,024) ~= 9.8 4-digit inspector ID suffixes
    #    sharing that beacon value.
    last4_beacon = StandardBeacon(name="inspector_id_last4", length=10)
    standard_beacon_list.append(last4_beacon)

    # The configured DDB table has a GSI on the `aws_dbe_b_unit` AttributeName.
    # This field holds a unit serial number.
    # For this example, this is a 12-digit integer from 0 to 999,999,999,999 (10^12 possible values).
    # We will assume values for this attribute are uniformly distributed across this range.
    # A single unit serial number may be assigned to multiple `work_id`s.
    #
    # This link provides guidance for choosing a beacon length:
    #    https://docs.aws.amazon.com/database-encryption-sdk/latest/devguide/choosing-beacon-length.html
    # We follow the guidance in the link above to determine reasonable bounds
    # for the length of a beacon on a unit serial number:
    #  - min: log(sqrt(999,999,999,999))/log(2) ~= 19.9, round up to 20
    #  - max: log((999,999,999,999/2))/log(2) ~= 38.9, round up to 39
    # We can choose a beacon length between 20 and 39:
    #  - Closer to 20, we expect more "false positives" to be returned,
    #    making it harder to identify which beacon values encode distinct plaintexts,
    #    but leading to more decrypt calls and worse performance
    #  - Closer to 39, we expect fewer "false positives" returned in queries,
    #    leading to fewer decrypt calls and better performance,
    #    but it is easier to identify which beacon values encode distinct plaintexts.
    # As an example, we will choose 30.
    #
    # Values stored in aws_dbe_b_unit will be 30 bits long (0x00000000 - 0x3fffffff)
    # There will be 2^30 = 1,073,741,824 ~= 1.1B possible HMAC values.
    # With a sufficiently large number of well-distributed inspector IDs,
    #    for a particular beacon we expect (10^12/2^30) ~= 931.3 unit serial numbers
    #    sharing that beacon value.
    unit_beacon = StandardBeacon(name="unit", length=30)
    standard_beacon_list.append(unit_beacon)

    # 2. Configure Keystore.
    #    The keystore is a separate DDB table where the client stores encryption and decryption materials.
    #    In order to configure beacons on the DDB client, you must configure a keystore.
    #
    #    This example expects that you have already set up a KeyStore with a single branch key.
    #    See the "Create KeyStore Table Example" and "Create KeyStore Key Example" for how to do this.
    #    After you create a branch key, you should persist its ID for use in this example.
    keystore = KeyStore(
        config=KeyStoreConfig(
            ddb_client=boto3.client("dynamodb"),
            ddb_table_name=branch_key_ddb_table_name,
            logical_key_store_name=branch_key_ddb_table_name,
            kms_client=boto3.client("kms"),
            kms_configuration=KMSConfigurationKmsKeyArn(value=branch_key_wrapping_kms_key_arn),
        )
    )

    # 3. Create BeaconVersion.
    #    The BeaconVersion inside the list holds the list of beacons on the table.
    #    The BeaconVersion also stores information about the keystore.
    #    BeaconVersion must be provided:
    #      - keyStore: The keystore configured in step 2.
    #      - keySource: A configuration for the key source.
    #        For simple use cases, we can configure a 'singleKeySource' which
    #        statically configures a single beaconKey. That is the approach this example takes.
    #        For use cases where you want to use different beacon keys depending on the data
    #        (for example if your table holds data for multiple tenants, and you want to use
    #        a different beacon key per tenant), look into configuring a MultiKeyStore:
    #          https://docs.aws.amazon.com/database-encryption-sdk/latest/devguide/searchable-encryption-multitenant.html
    beacon_versions = [
        BeaconVersion(
            standard_beacons=standard_beacon_list,
            version=1,  # MUST be 1
            key_store=keystore,
            key_source=BeaconKeySourceSingle(
                SingleKeyStore(
                    # `key_id` references a beacon key.
                    # For every branch key we create in the keystore,
                    # we also create a beacon key.
                    # This beacon key is not the same as the branch key,
                    # but is created with the same ID as the branch key.
                    key_id=branch_key_id,
                    cache_ttl=6000,
                )
            ),
        )
    ]

    # 4. Create a Hierarchical Keyring
    #    This is a KMS keyring that utilizes the keystore table.
    #    This config defines how items are encrypted and decrypted.
    #    NOTE: You should configure this to use the same keystore as your search config.
    mat_prov = AwsCryptographicMaterialProviders(config=MaterialProvidersConfig())

    keyring_input = CreateAwsKmsHierarchicalKeyringInput(
        branch_key_id=branch_key_id, key_store=keystore, ttl_seconds=6000
    )

    kms_keyring = mat_prov.create_aws_kms_hierarchical_keyring(input=keyring_input)

    # 5. Configure which attributes are encrypted and/or signed when writing new items.
    #    For each attribute that may exist on the items we plan to write to our DynamoDbTable,
    #    we must explicitly configure how they should be treated during item encryption:
    #      - ENCRYPT_AND_SIGN: The attribute is encrypted and included in the signature
    #      - SIGN_ONLY: The attribute not encrypted, but is still included in the signature
    #      - DO_NOTHING: The attribute is not encrypted and not included in the signature
    #    Any attributes that will be used in beacons must be configured as ENCRYPT_AND_SIGN.
    attribute_actions = {
        "work_id": CryptoAction.SIGN_ONLY,  # Our partition attribute must be SIGN_ONLY
        "inspection_date": CryptoAction.SIGN_ONLY,  # Our sort attribute must be SIGN_ONLY
        "inspector_id_last4": CryptoAction.ENCRYPT_AND_SIGN,  # Beaconized attributes must be encrypted
        "unit": CryptoAction.ENCRYPT_AND_SIGN,  # Beaconized attributes must be encrypted
    }

    # 6. Create the DynamoDb Encryption configuration for the table we will be writing to.
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
    return DynamoDbTablesEncryptionConfig(table_encryption_configs=table_configs)
