// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

use crate::test_utils;
use aws_db_esdk::client as transform_client;
use aws_db_esdk::dynamodb::types::BeaconKeySource;
use aws_db_esdk::dynamodb::types::BeaconVersion;
use aws_db_esdk::dynamodb::types::CompoundBeacon;
use aws_db_esdk::dynamodb::types::DynamoDbTableEncryptionConfig;
use aws_db_esdk::dynamodb::types::EncryptedPart;
use aws_db_esdk::dynamodb::types::SearchConfig;
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
use aws_sdk_dynamodb::types::AttributeValue;
use std::collections::HashMap;

/*
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
   4. Branch key DDB table ARN for the DDB table representing the branch key store
*/

const GSI_NAME: &str = "last4UnitCompound-index";

pub async fn put_and_query_with_beacon(branch_key_id: &str) -> Result<(), crate::BoxError> {
    let ddb_table_name = test_utils::UNIT_INSPECTION_TEST_DDB_TABLE_NAME;
    let branch_key_wrapping_kms_key_arn = test_utils::TEST_BRANCH_KEY_WRAPPING_KMS_KEY_ARN;
    let branch_key_ddb_table_name = test_utils::TEST_BRANCH_KEYSTORE_DDB_TABLE_NAME;

    // 1. Create Beacons.
    //    These are the same beacons as in the "BasicSearchableEncryptionExample" in this directory.
    //    See that file to see details on beacon construction and parameters.
    //    While we will not directly query against these beacons,
    //      you must create standard beacons on encrypted fields
    //      that we wish to use in compound beacons.
    let last4_beacon = StandardBeacon::builder()
        .name("inspector_id_last4")
        .length(10)
        .build()?;

    let unit_beacon = StandardBeacon::builder().name("unit").length(30).build()?;

    let standard_beacon_list = vec![last4_beacon, unit_beacon];

    // 2. Define encrypted parts.
    //    Encrypted parts define the beacons that can be used to construct a compound beacon,
    //        and how the compound beacon prefixes those beacon values.

    // A encrypted part must receive:
    //  - name: Name of a standard beacon
    //  - prefix: Any string. This is plaintext that prefixes the beaconized value in the compound beacon.
    //            Prefixes must be unique across the configuration, and must not be a prefix of another prefix;
    //            i.e. for all configured prefixes, the first N characters of a prefix must not equal another prefix.
    // In practice, it is suggested to have a short value distinguishable from other parts served on the prefix.
    // For this example, we will choose "L-" as the prefix for "Last 4 digits of inspector ID".
    // With this prefix and the standard beacon's bit length definition (10), the beaconized
    //     version of the inspector ID's last 4 digits will appear as
    //     `L-000` to `L-3ff` inside a compound beacon.

    // For this example, we will choose "U-" as the prefix for "unit".
    // With this prefix and the standard beacon's bit length definition (30), a unit beacon will appear
    //     as `U-00000000` to `U-3fffffff` inside a compound beacon.
    let encrypted_parts_list = vec![
        EncryptedPart::builder()
            .name("inspector_id_last4")
            .prefix("L-")
            .build()?,
        EncryptedPart::builder().name("unit").prefix("U-").build()?,
    ];

    // 3. Define compound beacon.
    //    A compound beacon allows one to serve multiple beacons or attributes from a single index.
    //    A compound beacon must receive:
    //     - name: The name of the beacon. Compound beacon values will be written to `aws_ddb_e_[name]`.
    //     - split: A character separating parts in a compound beacon
    //    A compound beacon may also receive:
    //     - encrypted: A list of encrypted parts. This is effectively a list of beacons. We provide the list
    //                  that we created above.
    //     - constructors: A list of constructors. This is an ordered list of possible ways to create a beacon.
    //                     We have not defined any constructors here; see the complex example for how to do this.
    //                     The client will provide a default constructor, which will write a compound beacon as:
    //                     all signed parts in the order they are added to the signed list;
    //                     all encrypted parts in order they are added to the encrypted list; all parts required.
    //                     In this example, we expect compound beacons to be written as
    //                     `L-XXX.U-YYYYYYYY`, since our encrypted list looks like
    //                     [last4EncryptedPart, unitEncryptedPart].
    //     - signed: A list of signed parts, i.e. plaintext attributes. This would be provided if we
    //                     wanted to use plaintext values as part of constructing our compound beacon. We do not
    //                     provide this here; see the Complex example for an example.
    let compound_beacon_list = vec![CompoundBeacon::builder()
        .name("last4UnitCompound")
        .split(".")
        .encrypted(encrypted_parts_list)
        .build()?];

    // 4. Configure the Keystore
    //    These are the same constructions as in the Basic example, which describes these in more detail.

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

    // 5. Create BeaconVersion.
    //    This is similar to the Basic example, except we have also provided a compoundBeaconList.
    //    We must also continue to provide all of the standard beacons that compose a compound beacon list.
    let beacon_version = BeaconVersion::builder()
        .standard_beacons(standard_beacon_list)
        .compound_beacons(compound_beacon_list)
        .version(1) // MUST be 1
        .key_store(key_store.clone())
        .key_source(BeaconKeySource::Single(
            SingleKeyStore::builder()
                // `keyId` references a beacon key.
                // For every branch key we create in the keystore,
                // we also create a beacon key.
                // This beacon key is not the same as the branch key,
                // but is created with the same ID as the branch key.
                .key_id(branch_key_id)
                .cache_ttl(6000)
                .build()?,
        ))
        .build()?;
    let beacon_versions = vec![beacon_version];

    // 6. Create a Hierarchical Keyring
    //    This is the same configuration as in the Basic example.

    let mpl_config = MaterialProvidersConfig::builder().build()?;
    let mpl = mpl_client::Client::from_conf(mpl_config)?;
    let kms_keyring = mpl
        .create_aws_kms_hierarchical_keyring()
        .branch_key_id(branch_key_id)
        .key_store(key_store)
        .ttl_seconds(6000)
        .send()
        .await?;

    // 7. Configure which attributes are encrypted and/or signed when writing new items.
    let attribute_actions_on_encrypt = HashMap::from([
        ("work_id".to_string(), CryptoAction::SignOnly), // Our partition attribute must be SIGN_ONLY
        ("inspection_date".to_string(), CryptoAction::SignOnly), // Our sort attribute must be SIGN_ONLY
        (
            "inspector_id_last4".to_string(),
            CryptoAction::EncryptAndSign,
        ), // Beaconized attributes must be encrypted
        ("unit".to_string(), CryptoAction::EncryptAndSign), // Beaconized attributes must be encrypted
    ]);

    // We do not need to define a crypto action on last4UnitCompound.
    // We only need to define crypto actions on attributes that we pass to PutItem.

    // 8. Create the DynamoDb Encryption configuration for the table we will be writing to.
    //    The beaconVersions are added to the search configuration.
    let table_config = DynamoDbTableEncryptionConfig::builder()
        .logical_table_name(ddb_table_name)
        .partition_key_name("work_id")
        .sort_key_name("inspection_date")
        .attribute_actions_on_encrypt(attribute_actions_on_encrypt)
        .keyring(kms_keyring)
        .search(
            SearchConfig::builder()
                .write_version(1) // MUST be 1
                .versions(beacon_versions)
                .build()?,
        )
        .build()?;

    // 9. Create config
    let encryption_config = DynamoDbTablesEncryptionConfig::builder()
        .table_encryption_configs(HashMap::from([(ddb_table_name.to_string(), table_config)]))
        .build()?;

    // 10. Create an item with both attributes used in the compound beacon.
    let item = HashMap::from([
        (
            "work_id".to_string(),
            AttributeValue::S("9ce39272-8068-4efd-a211-cd162ad65d4c".to_string()),
        ),
        (
            "inspection_date".to_string(),
            AttributeValue::S("2023-06-13".to_string()),
        ),
        (
            "inspector_id_last4".to_string(),
            AttributeValue::S("5678".to_string()),
        ),
        (
            "unit".to_string(),
            AttributeValue::S("011899988199".to_string()),
        ),
    ]);

    // 11. If developing or debugging, verify config by checking compound beacon values directly
    let trans = transform_client::Client::from_conf(encryption_config.clone())?;
    let resolve_output = trans
        .resolve_attributes()
        .table_name(ddb_table_name)
        .item(item.clone())
        .version(1)
        .send()
        .await?;

    // Verify that there are no virtual fields
    assert_eq!(resolve_output.virtual_fields.unwrap().len(), 0);

    // Verify that CompoundBeacons has the expected value
    let compound_beacons = resolve_output.compound_beacons.unwrap();
    assert_eq!(compound_beacons.len(), 1);
    assert_eq!(
        compound_beacons["last4UnitCompound"],
        "L-5678.U-011899988199"
    );
    // Note : the compound beacon actually stored in the table is not "L-5678.U-011899988199"
    // but rather something like "L-abc.U-123", as both parts are EncryptedParts
    // and therefore the text is replaced by the associated beacon

    // 12. Create a new AWS SDK DynamoDb client using the DynamoDb Encryption Interceptor above
    let dynamo_config = aws_sdk_dynamodb::config::Builder::from(&sdk_config)
        .interceptor(DbEsdkInterceptor::new(encryption_config)?)
        .build();
    let ddb = aws_sdk_dynamodb::Client::from_conf(dynamo_config);

    // 13. Write the item to the table
    ddb.put_item()
        .table_name(ddb_table_name)
        .set_item(Some(item.clone()))
        .send()
        .await?;

    // 14. Query for the item we just put.
    let expression_attribute_values = HashMap::from([
        // This query expression takes a few factors into consideration:
        //  - The configured prefix for the last 4 digits of an inspector ID is "L-";
        //    the prefix for the unit is "U-"
        //  - The configured split character, separating component parts, is "."
        //  - The default constructor adds encrypted parts in the order they are in the encrypted list, which
        //    configures `last4` to come before `unit``
        // NOTE: We did not need to create a compound beacon for this query. This query could have also been
        //       done by querying on the partition and sort key, as was done in the Basic example.
        //       This is intended to be a simple example to demonstrate how one might set up a compound beacon.
        //       For examples where compound beacons are required, see the Complex example.
        //       The most basic extension to this example that would require a compound beacon would add a third
        //       part to the compound beacon, then query against three parts.
        (
            ":value".to_string(),
            AttributeValue::S("L-5678.U-011899988199".to_string()),
        ),
    ]);

    // GSIs are sometimes a little bit delayed, so we retry if the query comes up empty.
    for _i in 0..10 {
        let query_response = ddb
            .query()
            .table_name(ddb_table_name)
            .index_name(GSI_NAME)
            .key_condition_expression("last4UnitCompound = :value")
            .set_expression_attribute_values(Some(expression_attribute_values.clone()))
            .send()
            .await?;

        // if no results, sleep and try again
        if query_response.items.is_none() || query_response.items.as_ref().unwrap().is_empty() {
            std::thread::sleep(std::time::Duration::from_millis(20));
            continue;
        }

        let attribute_values = query_response.items.unwrap();
        // Validate only 1 item was returned: the item we just put
        assert_eq!(attribute_values.len(), 1);
        let returned_item = &attribute_values[0];
        // Validate the item has the expected attributes
        assert_eq!(
            returned_item["inspector_id_last4"],
            AttributeValue::S("5678".to_string())
        );
        assert_eq!(
            returned_item["unit"],
            AttributeValue::S("011899988199".to_string())
        );
        break;
    }
    println!("compound_beacon_searchable_encryption successful.");
    Ok(())
}
