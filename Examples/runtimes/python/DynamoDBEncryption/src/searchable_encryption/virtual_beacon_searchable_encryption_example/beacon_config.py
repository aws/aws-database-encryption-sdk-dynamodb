# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""Sets up the beacon config for virtual beacon searchable encryption."""
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
    GetPrefix,
    SearchConfig,
    SingleKeyStore,
    StandardBeacon,
    VirtualField,
    VirtualPart,
    VirtualTransformPrefix,
)
from aws_dbesdk_dynamodb.structures.structured_encryption import CryptoAction


def setup_beacon_config(
    ddb_table_name: str,
    branch_key_id: str,
    branch_key_wrapping_kms_key_arn: str,
    branch_key_ddb_table_name: str,
):
    """Set up the beacon config for virtual beacon searchable encryption."""
    # 1. Construct a length-1 prefix virtual transform.
    #    `hasTestResult` is a binary attribute, containing either `true` or `false`.
    #    As an example to demonstrate virtual transforms, we will truncate the value
    #    of `hasTestResult` in the virtual field to the length-1 prefix of the binary value, i.e.:
    #     - "true" -> "t"
    #     - "false -> "f"
    #    This is not necessary. This is done as a demonstration of virtual transforms.
    #    Virtual transform operations treat all attributes as strings
    #    (i.e. the boolean value `true` is interpreted as a string "true"),
    #    so its length-1 prefix is just "t".
    length1_prefix_virtual_transform_list = [VirtualTransformPrefix(GetPrefix(length=1))]

    # 2. Construct the VirtualParts required for the VirtualField
    has_test_result_part = VirtualPart(
        loc="hasTestResult",
        # Here, we apply the length-1 prefix virtual transform
        trans=length1_prefix_virtual_transform_list,
    )

    state_part = VirtualPart(
        loc="state",
        # Note that we do not apply any transform to the `state` attribute,
        # and the virtual field will read in the attribute as-is.
    )

    # 3. Construct the VirtualField from the VirtualParts
    #    Note that the order that virtual parts are added to the virtualPartList
    #    dictates the order in which they are concatenated to build the virtual field.
    #    You must add virtual parts in the same order on write as you do on read.
    virtual_part_list = [state_part, has_test_result_part]

    state_and_has_test_result_field = VirtualField(name="stateAndHasTestResult", parts=virtual_part_list)

    virtual_field_list = [state_and_has_test_result_field]

    # 4. Configure our beacon.
    #    The virtual field is assumed to hold a US 2-letter state abbreviation
    #    (56 possible values = 50 states + 6 territories) concatenated with a binary attribute
    #    (2 possible values: true/false hasTestResult field), we expect a population size of
    #    56 * 2 = 112 possible values.
    #    We will also assume that these values are reasonably well-distributed across
    #    customer IDs. In practice, this will not be true. We would expect
    #    more populous states to appear more frequently in the database.
    #    A more complex analysis would show that a stricter upper bound
    #    is necessary to account for this by hiding information from the
    #    underlying distribution.
    #
    #    This link provides guidance for choosing a beacon length:
    #       https://docs.aws.amazon.com/database-encryption-sdk/latest/devguide/choosing-beacon-length.html
    #    We follow the guidance in the link above to determine reasonable bounds for beacon length:
    #     - min: log(sqrt(112))/log(2) ~= 3.4, round down to 3
    #     - max: log((112/2))/log(2) ~= 5.8, round up to 6
    #    You will somehow need to round results to a nearby integer.
    #    We choose to round to the nearest integer; you might consider a different rounding approach.
    #    Rounding up will return fewer expected "false positives" in queries,
    #       leading to fewer decrypt calls and better performance,
    #       but it is easier to identify which beacon values encode distinct plaintexts.
    #    Rounding down will return more expected "false positives" in queries,
    #       leading to more decrypt calls and worse performance,
    #       but it is harder to identify which beacon values encode distinct plaintexts.
    #    We can choose a beacon length between 3 and 6:
    #     - Closer to 3, we expect more "false positives" to be returned,
    #       making it harder to identify which beacon values encode distinct plaintexts,
    #       but leading to more decrypt calls and worse performance
    #     - Closer to 6, we expect fewer "false positives" returned in queries,
    #       leading to fewer decrypt calls and better performance,
    #       but it is easier to identify which beacon values encode distinct plaintexts.
    #    As an example, we will choose 5.
    #    Values stored in aws_dbe_b_stateAndHasTestResult will be 5 bits long (0x00 - 0x1f)
    #    There will be 2^5 = 32 possible HMAC values.
    #    With a well-distributed dataset (112 values), for a particular beacon we expect
    #    (112/32) = 3.5 combinations of abbreviation + true/false attribute
    #    sharing that beacon value.
    standard_beacon_list = [
        StandardBeacon(
            # This name is the same as our virtual field's name above
            name="stateAndHasTestResult",
            length=5,
        )
    ]

    # 5. Configure Keystore.
    #    This example expects that you have already set up a KeyStore with a single branch key.
    #    See the "CreateKeyStoreTableExample" and "CreateKeyStoreKeyExample" files for how to do this.
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

    # 6. Create BeaconVersion.
    #    The BeaconVersion inside the list holds the list of beacons on the table.
    #    The BeaconVersion also stores information about the keystore.
    #    BeaconVersion must be provided:
    #      - keyStore: The keystore configured in the previous step.
    #      - keySource: A configuration for the key source.
    #        For simple use cases, we can configure a 'singleKeySource' which
    #        statically configures a single beaconKey. That is the approach this example takes.
    #        For use cases where you want to use different beacon keys depending on the data
    #        (for example if your table holds data for multiple tenants, and you want to use
    #        a different beacon key per tenant), look into configuring a MultiKeyStore:
    #          https://docs.aws.amazon.com/database-encryption-sdk/latest/devguide/searchable-encryption-multitenant.html
    #    We also provide our standard beacon list and virtual fields here.
    beacon_versions = [
        BeaconVersion(
            virtual_fields=virtual_field_list,
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

    # 7. Create a Hierarchical Keyring
    #    This is a KMS keyring that utilizes the keystore table.
    #    This config defines how items are encrypted and decrypted.
    #    NOTE: You should configure this to use the same keystore as your search config.
    mat_prov = AwsCryptographicMaterialProviders(config=MaterialProvidersConfig())

    keyring_input = CreateAwsKmsHierarchicalKeyringInput(
        branch_key_id=branch_key_id, key_store=keystore, ttl_seconds=6000
    )

    kms_keyring = mat_prov.create_aws_kms_hierarchical_keyring(input=keyring_input)

    # 8. Configure which attributes are encrypted and/or signed when writing new items.
    #    For each attribute that may exist on the items we plan to write to our DynamoDbTable,
    #    we must explicitly configure how they should be treated during item encryption:
    #      - ENCRYPT_AND_SIGN: The attribute is encrypted and included in the signature
    #      - SIGN_ONLY: The attribute not encrypted, but is still included in the signature
    #      - DO_NOTHING: The attribute is not encrypted and not included in the signature
    #    Any attributes that will be used in beacons must be configured as ENCRYPT_AND_SIGN.
    attribute_actions = {
        "customer_id": CryptoAction.SIGN_ONLY,  # Our partition attribute must be SIGN_ONLY
        "create_time": CryptoAction.SIGN_ONLY,  # Our sort attribute must be SIGN_ONLY
        "state": CryptoAction.ENCRYPT_AND_SIGN,  # Beaconized attributes must be encrypted
        "hasTestResult": CryptoAction.ENCRYPT_AND_SIGN,  # Beaconized attributes must be encrypted
    }

    # 9. Create the DynamoDb Encryption configuration for the table we will be writing to.
    #    The beaconVersions are added to the search configuration.
    table_config = DynamoDbTableEncryptionConfig(
        logical_table_name=ddb_table_name,
        partition_key_name="customer_id",
        sort_key_name="create_time",
        attribute_actions_on_encrypt=attribute_actions,
        keyring=kms_keyring,
        search=SearchConfig(write_version=1, versions=beacon_versions),  # MUST be 1
    )

    table_configs = {ddb_table_name: table_config}
    return DynamoDbTablesEncryptionConfig(table_encryption_configs=table_configs)
