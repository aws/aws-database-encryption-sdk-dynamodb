# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""Sets up the beacon config for compound beacon searchable encryption."""
import boto3
from aws_cryptographic_material_providers.keystore.client import KeyStore
from aws_cryptographic_material_providers.keystore.config import KeyStoreConfig
from aws_cryptographic_material_providers.keystore.models import KMSConfigurationKmsKeyArn
from aws_cryptographic_material_providers.mpl import AwsCryptographicMaterialProviders
from aws_cryptographic_material_providers.mpl.config import MaterialProvidersConfig
from aws_cryptographic_material_providers.mpl.models import CreateAwsKmsHierarchicalKeyringInput
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


def setup_beacon_config(
    ddb_table_name: str,
    branch_key_id: str,
    branch_key_wrapping_kms_key_arn: str,
    branch_key_ddb_table_name: str,
):
    """Set up the beacon config for compound beacon searchable encryption."""
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
    return DynamoDbTablesEncryptionConfig(table_encryption_configs=table_configs)
