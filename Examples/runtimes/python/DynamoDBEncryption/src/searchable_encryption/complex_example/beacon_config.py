# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""Sets up the beacon config."""
import boto3
from aws_cryptographic_material_providers.keystore.client import KeyStore
from aws_cryptographic_material_providers.keystore.config import KeyStoreConfig
from aws_cryptographic_material_providers.keystore.models import (
    KMSConfigurationKmsKeyArn,
)
from aws_cryptographic_material_providers.mpl.client import AwsCryptographicMaterialProviders
from aws_cryptographic_material_providers.mpl.config import MaterialProvidersConfig
from aws_cryptographic_material_providers.mpl.models import (
    CreateAwsKmsHierarchicalKeyringInput,
)
from aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models import (
    BeaconKeySourceSingle,
    BeaconVersion,
    CompoundBeacon,
    Constructor,
    ConstructorPart,
    DynamoDbTableEncryptionConfig,
    DynamoDbTablesEncryptionConfig,
    EncryptedPart,
    SearchConfig,
    SignedPart,
    SingleKeyStore,
    StandardBeacon,
)
from aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.models import (
    CryptoAction,
)


def setup_beacon_config(
    ddb_table_name: str,
    branch_key_id: str,
    branch_key_wrapping_kms_key_arn: str,
    branch_key_ddb_table_name: str,
):
    """Set up the beacon config."""
    keystore: KeyStore = KeyStore(
        KeyStoreConfig(
            ddb_table_name=branch_key_ddb_table_name,
            kms_configuration=KMSConfigurationKmsKeyArn(branch_key_wrapping_kms_key_arn),
            logical_key_store_name=branch_key_ddb_table_name,
            kms_client=boto3.client("kms"),
            ddb_client=boto3.client("dynamodb"),
        )
    )

    # Create standard beacons
    standard_beacon_list = [
        StandardBeacon(name="EmployeeID", length=4),
        StandardBeacon(name="TicketNumber", length=4),
        StandardBeacon(name="ProjectName", length=4),
        StandardBeacon(name="EmployeeEmail", length=4),
        StandardBeacon(name="CreatorEmail", length=4),
        StandardBeacon(name="ProjectStatus", length=4),
        StandardBeacon(name="OrganizerEmail", length=4),
        StandardBeacon(name="ManagerEmail", length=4),
        StandardBeacon(name="AssigneeEmail", length=4),
        StandardBeacon(name="City", loc="Location.City", length=4),
        StandardBeacon(name="Severity", length=4),
        StandardBeacon(name="Building", loc="Location.Building", length=4),
        StandardBeacon(name="Floor", loc="Location.Floor", length=4),
        StandardBeacon(name="Room", loc="Location.Room", length=4),
        StandardBeacon(name="Desk", loc="Location.Desk", length=4),
    ]

    # Define encrypted parts
    encrypted_part_list = [
        EncryptedPart(name="EmployeeID", prefix="E-"),
        EncryptedPart(name="TicketNumber", prefix="T-"),
        EncryptedPart(name="ProjectName", prefix="P-"),
        EncryptedPart(name="EmployeeEmail", prefix="EE-"),
        EncryptedPart(name="CreatorEmail", prefix="CE-"),
        EncryptedPart(name="ProjectStatus", prefix="PSts-"),
        EncryptedPart(name="OrganizerEmail", prefix="OE-"),
        EncryptedPart(name="ManagerEmail", prefix="ME-"),
        EncryptedPart(name="AssigneeEmail", prefix="AE-"),
        EncryptedPart(name="City", prefix="C-"),
        EncryptedPart(name="Severity", prefix="S-"),
        EncryptedPart(name="Building", prefix="B-"),
        EncryptedPart(name="Floor", prefix="F-"),
        EncryptedPart(name="Room", prefix="R-"),
        EncryptedPart(name="Desk", prefix="D-"),
    ]

    # Define signed parts
    signed_part_list = [
        SignedPart(name="TicketModTime", prefix="M-"),
        SignedPart(name="MeetingStart", prefix="MS-"),
        SignedPart(name="TimeCardStart", prefix="TC-"),
        SignedPart(name="ProjectStart", prefix="PS-"),
    ]

    employee_id_constructor_part = ConstructorPart(name="EmployeeID", required=True)
    ticket_number_constructor_part = ConstructorPart(name="TicketNumber", required=True)
    project_name_constructor_part = ConstructorPart(name="ProjectName", required=True)
    ticket_mod_time_constructor_part = ConstructorPart(name="TicketModTime", required=True)
    meeting_start_constructor_part = ConstructorPart(name="MeetingStart", required=True)
    time_card_start_constructor_part = ConstructorPart(name="TimeCardStart", required=True)
    employee_email_constructor_part = ConstructorPart(name="EmployeeEmail", required=True)
    creator_email_constructor_part = ConstructorPart(name="CreatorEmail", required=True)
    project_status_constructor_part = ConstructorPart(name="ProjectStatus", required=True)
    organizer_email_constructor_part = ConstructorPart(name="OrganizerEmail", required=True)
    project_start_constructor_part = ConstructorPart(name="ProjectStart", required=True)
    manager_email_constructor_part = ConstructorPart(name="ManagerEmail", required=True)
    assignee_email_constructor_part = ConstructorPart(name="AssigneeEmail", required=True)
    city_constructor_part = ConstructorPart(name="City", required=True)
    severity_constructor_part = ConstructorPart(name="Severity", required=True)
    building_constructor_part = ConstructorPart(name="Building", required=True)
    floor_constructor_part = ConstructorPart(name="Floor", required=True)
    room_constructor_part = ConstructorPart(name="Room", required=True)
    desk_constructor_part = ConstructorPart(name="Desk", required=True)

    # 6
    employee_id_constructor = Constructor(parts=[employee_id_constructor_part])
    ticket_number_constructor = Constructor(parts=[ticket_number_constructor_part])
    project_name_constructor = Constructor(parts=[project_name_constructor_part])
    ticket_mod_time_constructor = Constructor(parts=[ticket_mod_time_constructor_part])
    building_constructor = Constructor(parts=[building_constructor_part])

    meeting_start_floor_room_constructor = Constructor(
        parts=[meeting_start_constructor_part, floor_constructor_part, room_constructor_part]
    )

    time_card_start_employee_email_constructor = Constructor(
        parts=[time_card_start_constructor_part, employee_email_constructor_part]
    )

    time_card_start_constructor = Constructor(parts=[time_card_start_constructor_part])

    creator_email_constructor = Constructor(parts=[creator_email_constructor_part])

    project_status_constructor = Constructor(parts=[project_status_constructor_part])

    employee_email_constructor = Constructor(parts=[employee_email_constructor_part])

    organizer_email_constructor = Constructor(parts=[organizer_email_constructor_part])

    project_start_constructor = Constructor(parts=[project_start_constructor_part])

    manager_email_constructor = Constructor(parts=[manager_email_constructor_part])

    assignee_email_constructor = Constructor(parts=[assignee_email_constructor_part])

    city_constructor = Constructor(parts=[city_constructor_part])

    severity_constructor = Constructor(parts=[severity_constructor_part])

    building_floor_desk_constructor = Constructor(
        parts=[building_constructor_part, floor_constructor_part, desk_constructor_part]
    )

    # 7
    pk0_constructor_list = [
        employee_id_constructor,
        building_constructor,
        ticket_number_constructor,
        project_name_constructor,
    ]

    sk0_constructor_list = [
        ticket_mod_time_constructor,
        meeting_start_floor_room_constructor,
        time_card_start_employee_email_constructor,
        project_name_constructor,
        employee_id_constructor,
    ]

    pk1_constructor_list = [
        creator_email_constructor,
        employee_email_constructor,
        project_status_constructor,
        organizer_email_constructor,
    ]

    sk1_constructor_list = [
        meeting_start_floor_room_constructor,
        time_card_start_constructor,
        ticket_mod_time_constructor,
        project_start_constructor,
        employee_id_constructor,
    ]

    pk2_constructor_list = [manager_email_constructor, assignee_email_constructor]

    pk3_constructor_list = [city_constructor, severity_constructor]

    sk3_constructor_list = [building_floor_desk_constructor, ticket_mod_time_constructor]

    # 8
    compound_beacon_list = [
        CompoundBeacon(name="PK", split="~", constructors=pk0_constructor_list),
        CompoundBeacon(name="SK", split="~", constructors=sk0_constructor_list),
        CompoundBeacon(name="PK1", split="~", constructors=pk1_constructor_list),
        CompoundBeacon(name="SK1", split="~", constructors=sk1_constructor_list),
        CompoundBeacon(name="PK2", split="~", constructors=pk2_constructor_list),
        CompoundBeacon(name="PK3", split="~", constructors=pk3_constructor_list),
        CompoundBeacon(name="SK3", split="~", constructors=sk3_constructor_list),
    ]

    # 9
    beacon_versions = [
        BeaconVersion(
            standard_beacons=standard_beacon_list,
            compound_beacons=compound_beacon_list,
            encrypted_parts=encrypted_part_list,
            signed_parts=signed_part_list,
            version=1,  # MUST be 1
            key_store=keystore,
            key_source=BeaconKeySourceSingle(SingleKeyStore(key_id=branch_key_id, cache_ttl=6000)),
        )
    ]

    # 10. Create a Hierarchical Keyring
    mat_prov = AwsCryptographicMaterialProviders(MaterialProvidersConfig())

    keyring_input = CreateAwsKmsHierarchicalKeyringInput(
        branch_key_id=branch_key_id, key_store=keystore, ttl_seconds=6000
    )

    kms_keyring = mat_prov.create_aws_kms_hierarchical_keyring(keyring_input)

    # 11. Define crypto actions
    attribute_actions_on_encrypt = {
        # Our partition key must be configured as SIGN_ONLY
        "partition_key": CryptoAction.SIGN_ONLY,
        # Attributes used in beacons must be configured as ENCRYPT_AND_SIGN
        "EmployeeID": CryptoAction.ENCRYPT_AND_SIGN,
        "TicketNumber": CryptoAction.ENCRYPT_AND_SIGN,
        "ProjectName": CryptoAction.ENCRYPT_AND_SIGN,
        "EmployeeName": CryptoAction.ENCRYPT_AND_SIGN,
        "EmployeeEmail": CryptoAction.ENCRYPT_AND_SIGN,
        "CreatorEmail": CryptoAction.ENCRYPT_AND_SIGN,
        "ProjectStatus": CryptoAction.ENCRYPT_AND_SIGN,
        "OrganizerEmail": CryptoAction.ENCRYPT_AND_SIGN,
        "ManagerEmail": CryptoAction.ENCRYPT_AND_SIGN,
        "AssigneeEmail": CryptoAction.ENCRYPT_AND_SIGN,
        "City": CryptoAction.ENCRYPT_AND_SIGN,
        "Severity": CryptoAction.ENCRYPT_AND_SIGN,
        "Location": CryptoAction.ENCRYPT_AND_SIGN,
        # These are not beaconized attributes, but are sensitive data that must be encrypted
        "Attendees": CryptoAction.ENCRYPT_AND_SIGN,
        "Subject": CryptoAction.ENCRYPT_AND_SIGN,
        # Signed parts and unencrypted attributes can be configured as SIGN_ONLY or DO_NOTHING
        # For this example, we will set these to SIGN_ONLY to ensure authenticity
        "TicketModTime": CryptoAction.SIGN_ONLY,
        "MeetingStart": CryptoAction.SIGN_ONLY,
        "TimeCardStart": CryptoAction.SIGN_ONLY,
        "EmployeeTitle": CryptoAction.SIGN_ONLY,
        "Description": CryptoAction.SIGN_ONLY,
        "ProjectTarget": CryptoAction.SIGN_ONLY,
        "Hours": CryptoAction.SIGN_ONLY,
        "Role": CryptoAction.SIGN_ONLY,
        "Message": CryptoAction.SIGN_ONLY,
        "ProjectStart": CryptoAction.SIGN_ONLY,
        "Duration": CryptoAction.SIGN_ONLY,
    }

    # Define table encryption configuration
    table_configs = {}

    config = DynamoDbTableEncryptionConfig(
        logical_table_name=ddb_table_name,
        partition_key_name="partition_key",
        attribute_actions_on_encrypt=attribute_actions_on_encrypt,
        keyring=kms_keyring,
        search=SearchConfig(write_version=1, versions=beacon_versions),  # MUST be 1
    )

    # Store the configuration in a dictionary
    table_configs[ddb_table_name] = config

    # Return encryption configuration
    return DynamoDbTablesEncryptionConfig(table_encryption_configs=table_configs)
