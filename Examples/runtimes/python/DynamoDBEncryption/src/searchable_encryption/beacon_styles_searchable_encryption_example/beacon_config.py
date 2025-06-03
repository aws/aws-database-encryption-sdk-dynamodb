# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""Sets up the beacon config for demonstrating different beacon styles."""
from typing import List

import boto3
from aws_cryptographic_material_providers.keystore.client import KeyStore
from aws_cryptographic_material_providers.keystore.config import KeyStoreConfig
from aws_cryptographic_material_providers.keystore.models import KMSConfigurationKmsKeyArn
from aws_cryptographic_material_providers.mpl import AwsCryptographicMaterialProviders
from aws_cryptographic_material_providers.mpl.config import MaterialProvidersConfig
from aws_cryptographic_material_providers.mpl.models import CreateAwsKmsHierarchicalKeyringInput
from aws_dbesdk_dynamodb.structures.dynamodb import (
    AsSet,
    BeaconKeySourceSingle,
    BeaconStyleAsSet,
    BeaconStylePartOnly,
    BeaconStyleShared,
    BeaconStyleSharedSet,
    BeaconVersion,
    CompoundBeacon,
    DynamoDbTableEncryptionConfig,
    DynamoDbTablesEncryptionConfig,
    EncryptedPart,
    PartOnly,
    SearchConfig,
    Shared,
    SharedSet,
    SignedPart,
    SingleKeyStore,
    StandardBeacon,
)
from aws_dbesdk_dynamodb.structures.structured_encryption import CryptoAction


def setup_beacon_config(
    ddb_table_name: str,
    branch_key_id: str,
    branch_key_wrapping_kms_key_arn: str,
    branch_key_ddb_table_name: str,
):
    """Set up the beacon config demonstrating different beacon styles."""
    # 1. Create Beacons.
    standard_beacon_list: List[StandardBeacon] = []

    # The fruit beacon allows searching on the encrypted fruit attribute
    # We have selected 30 as an example beacon length, but you should go to
    # https://docs.aws.amazon.com/database-encryption-sdk/latest/devguide/choosing-beacon-length.html
    # when creating your beacons.
    fruit_beacon = StandardBeacon(name="fruit", length=30)
    standard_beacon_list.append(fruit_beacon)

    # The basket beacon allows searching on the encrypted basket attribute
    # basket is used as a Set, and therefore needs a beacon style to reflect that.
    # Further, we need to be able to compare the items in basket to the fruit attribute
    # so we `share` this beacon with `fruit`.
    # Since we need both of these things, we use the SharedSet style.
    basket_beacon = StandardBeacon(name="basket", length=30, style=BeaconStyleSharedSet(SharedSet(other="fruit")))
    standard_beacon_list.append(basket_beacon)

    # The dessert beacon allows searching on the encrypted dessert attribute
    # We need to be able to compare the dessert attribute to the fruit attribute
    # so we `share` this beacon with `fruit`.
    dessert_beacon = StandardBeacon(name="dessert", length=30, style=BeaconStyleShared(Shared(other="fruit")))
    standard_beacon_list.append(dessert_beacon)

    # The veggie_beacon allows searching on the encrypted veggies attribute
    # veggies is used as a Set, and therefore needs a beacon style to reflect that.
    veggie_beacon = StandardBeacon(name="veggies", length=30, style=BeaconStyleAsSet(AsSet()))
    standard_beacon_list.append(veggie_beacon)

    # The work_type_beacon allows searching on the encrypted work_type attribute
    # We only use it as part of the compound work_unit beacon,
    # so we disable its use as a standalone beacon
    work_type_beacon = StandardBeacon(name="work_type", length=30, style=BeaconStylePartOnly(PartOnly()))
    standard_beacon_list.append(work_type_beacon)

    # Here we build a compound beacon from work_id and work_type
    # If we had tried to make a StandardBeacon from work_type, we would have seen an error
    # because work_type is "PartOnly"
    encrypted_part_list = [EncryptedPart(name="work_type", prefix="T-")]

    signed_part_list = [SignedPart(name="work_id", prefix="I-")]

    compound_beacon_list = [
        CompoundBeacon(name="work_unit", split=".", encrypted=encrypted_part_list, signed=signed_part_list)
    ]

    # 2. Configure the Keystore
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

    # 3. Create BeaconVersion.
    #    This is similar to the Basic example
    beacon_versions = [
        BeaconVersion(
            standard_beacons=standard_beacon_list,
            compound_beacons=compound_beacon_list,
            version=1,  # MUST be 1
            key_store=keystore,
            key_source=BeaconKeySourceSingle(SingleKeyStore(key_id=branch_key_id, cache_ttl=6000)),
        )
    ]

    # 4. Create a Hierarchical Keyring
    #    This is the same configuration as in the Basic example.
    mat_prov = AwsCryptographicMaterialProviders(config=MaterialProvidersConfig())

    keyring_input = CreateAwsKmsHierarchicalKeyringInput(
        branch_key_id=branch_key_id, key_store=keystore, ttl_seconds=6000
    )

    kms_keyring = mat_prov.create_aws_kms_hierarchical_keyring(input=keyring_input)

    # 5. Configure which attributes are encrypted and/or signed when writing new items.
    attribute_actions = {
        "work_id": CryptoAction.SIGN_ONLY,  # Our partition attribute must be SIGN_ONLY
        "inspection_date": CryptoAction.SIGN_ONLY,  # Our sort attribute must be SIGN_ONLY
        "dessert": CryptoAction.ENCRYPT_AND_SIGN,  # Beaconized attributes must be encrypted
        "fruit": CryptoAction.ENCRYPT_AND_SIGN,  # Beaconized attributes must be encrypted
        "basket": CryptoAction.ENCRYPT_AND_SIGN,  # Beaconized attributes must be encrypted
        "veggies": CryptoAction.ENCRYPT_AND_SIGN,  # Beaconized attributes must be encrypted
        "work_type": CryptoAction.ENCRYPT_AND_SIGN,  # Beaconized attributes must be encrypted
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
