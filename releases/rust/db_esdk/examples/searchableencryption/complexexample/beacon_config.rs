// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

use aws_db_esdk::dynamodb::types::BeaconKeySource;
use aws_db_esdk::dynamodb::types::BeaconVersion;
use aws_db_esdk::dynamodb::types::CompoundBeacon;
use aws_db_esdk::dynamodb::types::Constructor;
use aws_db_esdk::dynamodb::types::ConstructorPart;
use aws_db_esdk::dynamodb::types::DynamoDbTableEncryptionConfig;
use aws_db_esdk::dynamodb::types::EncryptedPart;
use aws_db_esdk::dynamodb::types::SearchConfig;
use aws_db_esdk::dynamodb::types::SignedPart;
use aws_db_esdk::dynamodb::types::SingleKeyStore;
use aws_db_esdk::dynamodb::types::StandardBeacon;
use aws_db_esdk::intercept::DbEsdkInterceptor;
use aws_db_esdk::key_store::client as keystore_client;
use aws_db_esdk::key_store::types::key_store_config::KeyStoreConfig;
use aws_db_esdk::key_store::types::KmsConfiguration;
use aws_db_esdk::material_providers::client as mpl_client;
use aws_db_esdk::material_providers::types::material_providers_config::MaterialProvidersConfig;
use aws_db_esdk::CryptoAction;
use aws_db_esdk::DynamoDbTablesEncryptionConfig;
use std::collections::HashMap;

/*
 * This file is used in an example to demonstrate complex queries
 * that you can perform using beacons.
 * The example data used is for demonstrative purposes only,
 * and might not meet the distribution and correlation uniqueness
 * recommendations for beacons.
 * See our documentation for whether beacons are
 * right for your particular data set:
 * https://docs.aws.amazon.com/database-encryption-sdk/latest/devguide/searchable-encryption.html#are-beacons-right-for-me
 *
 * This file sets up all the searchable encryption configuration required to execute the examples from
 * our workshop using the encryption client.
 */

pub async fn setup_beacon_config(
    ddb_table_name: &str,
    branch_key_id: &str,
    branch_key_wrapping_kms_key_arn: &str,
    branch_key_ddb_table_name: &str,
) -> Result<aws_sdk_dynamodb::Client, crate::BoxError> {
    // 1. Create keystore and branch key
    //    These are the same constructions as in the Basic examples, which describe this in more detail.
    let sdk_config = aws_config::load_defaults(aws_config::BehaviorVersion::latest()).await;
    let key_store_config = KeyStoreConfig::builder()
        .kms_client(aws_sdk_kms::Client::new(&sdk_config))
        .ddb_client(aws_sdk_dynamodb::Client::new(&sdk_config))
        .ddb_table_name(branch_key_ddb_table_name)
        .logical_key_store_name(branch_key_ddb_table_name)
        .kms_configuration(KmsConfiguration::KmsKeyArn(
            branch_key_wrapping_kms_key_arn.to_string(),
        ))
        .build()?;

    let key_store = keystore_client::Client::from_conf(key_store_config)?;

    // 2. Create standard beacons
    //    For this example, we use a standard beacon length of 4.
    //    The BasicSearchableEncryptionExample gives a more thorough consideration of beacon length.
    //    For production applications, one should always exercise rigor when deciding beacon length, including
    //        examining population size and considering performance.
    let standard_beacon_list = vec![
        StandardBeacon::builder()
            .name("EmployeeID")
            .length(4)
            .build()?,
        StandardBeacon::builder()
            .name("TicketNumber")
            .length(4)
            .build()?,
        StandardBeacon::builder()
            .name("ProjectName")
            .length(4)
            .build()?,
        StandardBeacon::builder()
            .name("EmployeeEmail")
            .length(4)
            .build()?,
        StandardBeacon::builder()
            .name("CreatorEmail")
            .length(4)
            .build()?,
        StandardBeacon::builder()
            .name("ProjectStatus")
            .length(4)
            .build()?,
        StandardBeacon::builder()
            .name("OrganizerEmail")
            .length(4)
            .build()?,
        StandardBeacon::builder()
            .name("ManagerEmail")
            .length(4)
            .build()?,
        StandardBeacon::builder()
            .name("AssigneeEmail")
            .length(4)
            .build()?,
        StandardBeacon::builder()
            .name("Severity")
            .length(4)
            .build()?,
        StandardBeacon::builder()
            .name("City")
            .loc("Location.City")
            .length(4)
            .build()?,
        StandardBeacon::builder()
            .name("Building")
            .loc("Location.Building")
            .length(4)
            .build()?,
        StandardBeacon::builder()
            .name("Floor")
            .loc("Location.Floor")
            .length(4)
            .build()?,
        StandardBeacon::builder()
            .name("Room")
            .loc("Location.Room")
            .length(4)
            .build()?,
        StandardBeacon::builder()
            .name("Desk")
            .loc("Location.Desk")
            .length(4)
            .build()?,
    ];

    // 3. Define encrypted parts
    //    Note that some of the prefixes are modified from the suggested prefixes in Demo.md.
    //    This is because all prefixes must be unique in a configuration.
    //    Encrypted parts are described in more detail in the CompoundBeaconSearchableEncryptionExample.
    let encrypted_parts_list = vec![
        EncryptedPart::builder()
            .name("EmployeeID")
            .prefix("E-")
            .build()?,
        EncryptedPart::builder()
            .name("TicketNumber")
            .prefix("T-")
            .build()?,
        EncryptedPart::builder()
            .name("ProjectName")
            .prefix("P-")
            .build()?,
        EncryptedPart::builder()
            .name("EmployeeEmail")
            .prefix("EE-")
            .build()?,
        EncryptedPart::builder()
            .name("CreatorEmail")
            .prefix("CE-")
            .build()?,
        EncryptedPart::builder()
            .name("OrganizerEmail")
            .prefix("OE-")
            .build()?,
        EncryptedPart::builder()
            .name("ManagerEmail")
            .prefix("ME-")
            .build()?,
        EncryptedPart::builder()
            .name("AssigneeEmail")
            .prefix("AE-")
            .build()?,
        EncryptedPart::builder()
            .name("ProjectStatus")
            .prefix("PSts-")
            .build()?,
        EncryptedPart::builder().name("City").prefix("C-").build()?,
        EncryptedPart::builder()
            .name("Severity")
            .prefix("S-")
            .build()?,
        EncryptedPart::builder()
            .name("Building")
            .prefix("B-")
            .build()?,
        EncryptedPart::builder()
            .name("Floor")
            .prefix("F-")
            .build()?,
        EncryptedPart::builder().name("Room").prefix("R-").build()?,
        EncryptedPart::builder().name("Desk").prefix("D-").build()?,
    ];

    // 4. Define signed parts
    //    These are unencrypted attributes we would like to use in beacon queries.
    //    In this example, all of these represent dates or times.
    //    Keeping these attributes unencrypted allows us to use them in comparison-based queries. If a signed
    //        part is the first part in a compound beacon, then that part can be used in comparison for sorting.
    let signed_parts_list = vec![
        SignedPart::builder()
            .name("TicketModTime")
            .prefix("M-")
            .build()?,
        SignedPart::builder()
            .name("MeetingStart")
            .prefix("MS-")
            .build()?,
        SignedPart::builder()
            .name("TimeCardStart")
            .prefix("TC-")
            .build()?,
        SignedPart::builder()
            .name("ProjectStart")
            .prefix("PS-")
            .build()?,
    ];

    // 5. Create constructor parts
    //    Constructor parts are used to assemble constructors (constructors described more in next step).
    //    For each attribute that will be used in a constructor, there must be a corresponding constructor part.
    //    A constructor part must receive:
    //     - name: Name of a standard beacon
    //     - required: Whether this attribute must be present in the item to match a constructor
    //    In this example, we will define each constructor part once and re-use it across multiple constructors.
    //    The parts below are defined by working backwards from the constructors in "PK Constructors",
    //        "SK constructors", etc. sections in Demo.md.
    let employee_id_constructor_part = ConstructorPart::builder()
        .name("EmployeeID")
        .required(true)
        .build()?;
    let ticket_number_constructor_part = ConstructorPart::builder()
        .name("TicketNumber")
        .required(true)
        .build()?;
    let project_name_constructor_part = ConstructorPart::builder()
        .name("ProjectName")
        .required(true)
        .build()?;
    let ticket_mod_time_constructor_part = ConstructorPart::builder()
        .name("TicketModTime")
        .required(true)
        .build()?;
    let meeting_start_constructor_part = ConstructorPart::builder()
        .name("MeetingStart")
        .required(true)
        .build()?;
    let timecard_start_constructor_part = ConstructorPart::builder()
        .name("TimeCardStart")
        .required(true)
        .build()?;
    let employee_email_constructor_part = ConstructorPart::builder()
        .name("EmployeeEmail")
        .required(true)
        .build()?;
    let creator_email_constructor_part = ConstructorPart::builder()
        .name("CreatorEmail")
        .required(true)
        .build()?;
    let project_status_constructor_part = ConstructorPart::builder()
        .name("ProjectStatus")
        .required(true)
        .build()?;
    let organizer_email_constructor_part = ConstructorPart::builder()
        .name("OrganizerEmail")
        .required(true)
        .build()?;
    let project_start_constructor_part = ConstructorPart::builder()
        .name("ProjectStart")
        .required(true)
        .build()?;
    let manager_email_constructor_part = ConstructorPart::builder()
        .name("ManagerEmail")
        .required(true)
        .build()?;
    let assignee_email_constructor_part = ConstructorPart::builder()
        .name("AssigneeEmail")
        .required(true)
        .build()?;
    let city_constructor_part = ConstructorPart::builder()
        .name("City")
        .required(true)
        .build()?;
    let severity_constructor_part = ConstructorPart::builder()
        .name("Severity")
        .required(true)
        .build()?;
    let building_constructor_part = ConstructorPart::builder()
        .name("Building")
        .required(true)
        .build()?;
    let floor_constructor_part = ConstructorPart::builder()
        .name("Floor")
        .required(true)
        .build()?;
    let room_constructor_part = ConstructorPart::builder()
        .name("Room")
        .required(true)
        .build()?;
    let desk_constructor_part = ConstructorPart::builder()
        .name("Desk")
        .required(true)
        .build()?;

    // 6. Define constructors
    //    Constructors define how encrypted and signed parts are assembled into compound beacons.
    //    The constructors below are based off of the "PK Constructors", "SK constructors", etc. sections in Demo.md.

    // The employee ID constructor only requires an employee ID.
    // If an item has an attribute with name "EmployeeID", it will match this constructor.
    // If this is the first matching constructor in the constructor list (constructor list described more below),
    //     the compound beacon will use this constructor, and the compound beacon will be written as `E-X`.

    let employee_id_constructor = Constructor::builder()
        .parts(vec![employee_id_constructor_part])
        .build()?;
    let ticket_number_constructor = Constructor::builder()
        .parts(vec![ticket_number_constructor_part])
        .build()?;
    let project_name_constructor = Constructor::builder()
        .parts(vec![project_name_constructor_part])
        .build()?;
    let ticket_mod_time_constructor = Constructor::builder()
        .parts(vec![ticket_mod_time_constructor_part])
        .build()?;
    let building_constructor = Constructor::builder()
        .parts(vec![building_constructor_part.clone()])
        .build()?;

    // This constructor requires all of "MeetingStart", "Location.Floor", and "Location.Room" attributes.
    // If an item has all of these attributes, it will match this constructor.
    // If this is the first matching constructor in the constructor list (constructor list described more below),
    //     the compound beacon will use this constructor, and the compound beacon will be written as `MS-X~F-Y~R-Z`.
    // In a constructor with multiple constructor parts, the order the constructor parts are added to
    //     the constructor part list defines how the compound beacon is written.
    // We can rearrange the beacon parts by changing the order the constructors were added to the list.
    let meeting_start_floor_room_constructor = Constructor::builder()
        .parts(vec![
            meeting_start_constructor_part,
            floor_constructor_part.clone(),
            room_constructor_part,
        ])
        .build()?;

    let timecard_start_constructor = Constructor::builder()
        .parts(vec![timecard_start_constructor_part.clone()])
        .build()?;
    let timecard_start_employee_email_constructor = Constructor::builder()
        .parts(vec![
            timecard_start_constructor_part,
            employee_email_constructor_part.clone(),
        ])
        .build()?;
    let creator_email_constructor = Constructor::builder()
        .parts(vec![creator_email_constructor_part])
        .build()?;
    let project_status_constructor = Constructor::builder()
        .parts(vec![project_status_constructor_part])
        .build()?;
    let employee_email_constructor = Constructor::builder()
        .parts(vec![employee_email_constructor_part])
        .build()?;
    let organizer_email_constructor = Constructor::builder()
        .parts(vec![organizer_email_constructor_part])
        .build()?;
    let project_start_constructor = Constructor::builder()
        .parts(vec![project_start_constructor_part])
        .build()?;
    let manager_email_constructor = Constructor::builder()
        .parts(vec![manager_email_constructor_part])
        .build()?;
    let assignee_email_constructor = Constructor::builder()
        .parts(vec![assignee_email_constructor_part])
        .build()?;
    let city_constructor = Constructor::builder()
        .parts(vec![city_constructor_part])
        .build()?;
    let severity_constructor = Constructor::builder()
        .parts(vec![severity_constructor_part])
        .build()?;
    let building_floor_desk_constructor = Constructor::builder()
        .parts(vec![
            building_constructor_part,
            floor_constructor_part,
            desk_constructor_part,
        ])
        .build()?;

    // 7. Add constructors to the compound beacon constructor list in desired construction order
    //    In a compound beacon with multiple constructors, the order the constructors are added to
    //        the constructor list determines their priority.
    //    The first constructor added to a constructor list will be the first constructor that is executed.
    //    The client will evaluate constructors until one matches, and will use the first one that matches.
    //    If no constructors match, an attribute value is not written for that beacon.
    //    A general strategy is to add constructors with unique conditions at the beginning of the list,
    //       and add constructors with general conditions at the end of the list. This would allow a given
    //       item to trigger the constructor most specific to its attributes.
    let pk0_constructor_list = vec![
        employee_id_constructor.clone(),
        building_constructor,
        ticket_number_constructor,
        project_name_constructor.clone(),
    ];
    let sk0_constructor_list = vec![
        ticket_mod_time_constructor.clone(),
        meeting_start_floor_room_constructor.clone(),
        timecard_start_employee_email_constructor,
        project_name_constructor,
        employee_id_constructor.clone(),
    ];
    let pk1_constructor_list = vec![
        creator_email_constructor,
        employee_email_constructor,
        project_status_constructor,
        organizer_email_constructor,
    ];
    let sk1_constructor_list = vec![
        meeting_start_floor_room_constructor,
        timecard_start_constructor,
        ticket_mod_time_constructor.clone(),
        project_start_constructor,
        employee_id_constructor,
    ];
    let pk2_constructor_list = vec![manager_email_constructor, assignee_email_constructor];
    let pk3_constructor_list = vec![city_constructor, severity_constructor];
    let sk3_constructor_list = vec![building_floor_desk_constructor, ticket_mod_time_constructor];

    // 8. Define compound beacons
    //    Compound beacon construction is defined in more detail in CompoundBeaconSearchableEncryptionExample.
    //    Note that the split character must be a character that is not used in any attribute value.
    let compound_beacon_list = vec![
        CompoundBeacon::builder()
            .name("PK")
            .split("~")
            .constructors(pk0_constructor_list)
            .build()?,
        CompoundBeacon::builder()
            .name("SK")
            .split("~")
            .constructors(sk0_constructor_list)
            .build()?,
        CompoundBeacon::builder()
            .name("PK1")
            .split("~")
            .constructors(pk1_constructor_list)
            .build()?,
        CompoundBeacon::builder()
            .name("SK1")
            .split("~")
            .constructors(sk1_constructor_list)
            .build()?,
        CompoundBeacon::builder()
            .name("PK2")
            .split("~")
            .constructors(pk2_constructor_list)
            .build()?,
        CompoundBeacon::builder()
            .name("PK3")
            .split("~")
            .constructors(pk3_constructor_list)
            .build()?,
        CompoundBeacon::builder()
            .name("SK3")
            .split("~")
            .constructors(sk3_constructor_list)
            .build()?,
    ];

    // 9. Create BeaconVersion
    let beacon_versions = BeaconVersion::builder()
        .standard_beacons(standard_beacon_list)
        .compound_beacons(compound_beacon_list)
        .encrypted_parts(encrypted_parts_list)
        .signed_parts(signed_parts_list)
        .version(1)
        .key_store(key_store.clone())
        .key_source(BeaconKeySource::Single(
            SingleKeyStore::builder()
                .key_id(branch_key_id)
                .cache_ttl(6000)
                .build()?,
        ))
        .build()?;
    let beacon_versions = vec![beacon_versions];

    // 10. Create a Hierarchical Keyring
    let mpl_config = MaterialProvidersConfig::builder().build()?;
    let mpl = mpl_client::Client::from_conf(mpl_config)?;
    let kms_keyring = mpl
        .create_aws_kms_hierarchical_keyring()
        .branch_key_id(branch_key_id)
        .key_store(key_store)
        .ttl_seconds(600)
        .send()
        .await?;

    // 11. Define crypto actions
    let attribute_actions_on_encrypt = HashMap::from([
        // Our partition key must be configured as SIGN_ONLY
        ("partition_key".to_string(), CryptoAction::SignOnly),
        // Attributes used in beacons must be configured as ENCRYPT_AND_SIGN
        ("EmployeeID".to_string(), CryptoAction::EncryptAndSign),
        ("TicketNumber".to_string(), CryptoAction::EncryptAndSign),
        ("ProjectName".to_string(), CryptoAction::EncryptAndSign),
        ("EmployeeName".to_string(), CryptoAction::EncryptAndSign),
        ("EmployeeEmail".to_string(), CryptoAction::EncryptAndSign),
        ("CreatorEmail".to_string(), CryptoAction::EncryptAndSign),
        ("ProjectStatus".to_string(), CryptoAction::EncryptAndSign),
        ("OrganizerEmail".to_string(), CryptoAction::EncryptAndSign),
        ("ManagerEmail".to_string(), CryptoAction::EncryptAndSign),
        ("AssigneeEmail".to_string(), CryptoAction::EncryptAndSign),
        ("City".to_string(), CryptoAction::EncryptAndSign),
        ("Severity".to_string(), CryptoAction::EncryptAndSign),
        ("Location".to_string(), CryptoAction::EncryptAndSign),
        // These are not beaconized attributes, but are sensitive data that must be encrypted
        ("Attendees".to_string(), CryptoAction::EncryptAndSign),
        ("Subject".to_string(), CryptoAction::EncryptAndSign),
        // Signed parts and unencrypted attributes can be configured as SIGN_ONLY or DO_NOTHING
        // For this example, we will set these to SIGN_ONLY to ensure authenticity
        ("TicketModTime".to_string(), CryptoAction::SignOnly),
        ("MeetingStart".to_string(), CryptoAction::SignOnly),
        ("TimeCardStart".to_string(), CryptoAction::SignOnly),
        ("EmployeeTitle".to_string(), CryptoAction::SignOnly),
        ("Description".to_string(), CryptoAction::SignOnly),
        ("ProjectTarget".to_string(), CryptoAction::SignOnly),
        ("Hours".to_string(), CryptoAction::SignOnly),
        ("Role".to_string(), CryptoAction::SignOnly),
        ("Message".to_string(), CryptoAction::SignOnly),
        ("ProjectStart".to_string(), CryptoAction::SignOnly),
        ("Duration".to_string(), CryptoAction::SignOnly),
    ]);

    // 12. Set up table config
    let table_config = DynamoDbTableEncryptionConfig::builder()
        .logical_table_name(ddb_table_name)
        .partition_key_name("partition_key")
        .attribute_actions_on_encrypt(attribute_actions_on_encrypt)
        .keyring(kms_keyring)
        .search(
            SearchConfig::builder()
                .write_version(1)
                .versions(beacon_versions)
                .build()?,
        )
        .build()?;

    let table_configs = DynamoDbTablesEncryptionConfig::builder()
        .table_encryption_configs(HashMap::from([(ddb_table_name.to_string(), table_config)]))
        .build()?;

    // 13. Create a new AWS SDK DynamoDb client using the config above
    let sdk_config = aws_config::load_defaults(aws_config::BehaviorVersion::latest()).await;
    let dynamo_config = aws_sdk_dynamodb::config::Builder::from(&sdk_config)
        .interceptor(DbEsdkInterceptor::new(table_configs)?)
        .build();

    Ok(aws_sdk_dynamodb::Client::from_conf(dynamo_config))
}
