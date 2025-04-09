// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

use crate::test_utils;
use aws_db_esdk::dynamodb::types::BeaconKeySource;
use aws_db_esdk::dynamodb::types::BeaconStyle;
use aws_db_esdk::dynamodb::types::BeaconVersion;
use aws_db_esdk::dynamodb::types::CompoundBeacon;
use aws_db_esdk::dynamodb::types::DynamoDbTableEncryptionConfig;
use aws_db_esdk::dynamodb::types::EncryptedPart;
use aws_db_esdk::dynamodb::types::SearchConfig;
use aws_db_esdk::dynamodb::types::SingleKeyStore;
use aws_db_esdk::dynamodb::types::StandardBeacon;
use aws_db_esdk::dynamodb::types::*;
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
   4. Branch key DDB table ARN for the DDB table representing the branch key store
*/

pub async fn put_and_query_with_beacon(branch_key_id: &str) -> Result<(), crate::BoxError> {
    let ddb_table_name = test_utils::UNIT_INSPECTION_TEST_DDB_TABLE_NAME;
    let branch_key_wrapping_kms_key_arn = test_utils::TEST_BRANCH_KEY_WRAPPING_KMS_KEY_ARN;
    let branch_key_ddb_table_name = test_utils::TEST_BRANCH_KEYSTORE_DDB_TABLE_NAME;

    // 1. Create Beacons.
    let standard_beacon_list = vec![
        // The fruit beacon allows searching on the encrypted fruit attribute
        // We have selected 30 as an example beacon length, but you should go to
        // https://docs.aws.amazon.com/database-encryption-sdk/latest/devguide/choosing-beacon-length.html
        // when creating your beacons.
        StandardBeacon::builder().name("fruit").length(30).build()?,
        // The basket beacon allows searching on the encrypted basket attribute
        // Basket is used as a Set, and therefore needs a beacon style to reflect that.
        // Further, we need to be able to compare the items in basket to the fruit attribute
        // so we `share` this beacon with `fruit`.
        // Since we need both of these things, we use the SharedSet style.
        StandardBeacon::builder()
            .name("basket")
            .length(30)
            .style(BeaconStyle::SharedSet(
                SharedSet::builder().other("fruit").build()?,
            ))
            .build()?,
        // The dessert beacon allows searching on the encrypted dessert attribute
        // We need to be able to compare the dessert attribute to the fruit attribute
        // so we `share` this beacon with `fruit`.
        StandardBeacon::builder()
            .name("dessert")
            .length(30)
            .style(BeaconStyle::Shared(
                Shared::builder().other("fruit").build()?,
            ))
            .build()?,
        // The veggieBeacon allows searching on the encrypted veggies attribute
        // veggies is used as a Set, and therefore needs a beacon style to reflect that.
        StandardBeacon::builder()
            .name("veggies")
            .length(30)
            .style(BeaconStyle::AsSet(AsSet::builder().build()?))
            .build()?,
        // The work_typeBeacon allows searching on the encrypted work_type attribute
        // We only use it as part of the compound work_unit beacon,
        // so we disable its use as a standalone beacon
        StandardBeacon::builder()
            .name("work_type")
            .length(30)
            .style(BeaconStyle::PartOnly(PartOnly::builder().build()?))
            .build()?,
    ];

    // Here we build a compound beacon from work_id and work_type
    // If we had tried to make a StandardBeacon from work_type, we would have seen an error
    // because work_type is "PartOnly"
    let encrypted_part_list = vec![EncryptedPart::builder()
        .name("work_type")
        .prefix("T-")
        .build()?];

    let signed_part_list = vec![SignedPart::builder().name("work_id").prefix("I-").build()?];

    let compound_beacon_list = vec![CompoundBeacon::builder()
        .name("work_unit")
        .split(".")
        .encrypted(encrypted_part_list)
        .signed(signed_part_list)
        .build()?];

    // 2. Configure the Keystore
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

    // 3. Create BeaconVersion.
    //    This is similar to the Basic example
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

    // 4. Create a Hierarchical Keyring
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

    // 5. Configure which attributes are encrypted and/or signed when writing new items.
    let attribute_actions_on_encrypt = HashMap::from([
        ("work_id".to_string(), CryptoAction::SignOnly), // Our partition attribute must be SIGN_ONLY
        ("inspection_date".to_string(), CryptoAction::SignOnly), // Our sort attribute must be SIGN_ONLY
        ("dessert".to_string(), CryptoAction::EncryptAndSign), // Beaconized attributes must be encrypted
        ("fruit".to_string(), CryptoAction::EncryptAndSign), // Beaconized attributes must be encrypted
        ("basket".to_string(), CryptoAction::EncryptAndSign), // Beaconized attributes must be encrypted
        ("veggies".to_string(), CryptoAction::EncryptAndSign), // Beaconized attributes must be encrypted
        ("work_type".to_string(), CryptoAction::EncryptAndSign), // Beaconized attributes must be encrypted
    ]);

    // 6. Create the DynamoDb Encryption configuration for the table we will be writing to.
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

    // 7. Create config
    let encryption_config = DynamoDbTablesEncryptionConfig::builder()
        .table_encryption_configs(HashMap::from([(ddb_table_name.to_string(), table_config)]))
        .build()?;

    // 8. Create item one, specifically with "dessert != fruit", and "fruit in basket".
    let item1 = HashMap::from([
        ("work_id".to_string(), AttributeValue::S("1".to_string())),
        (
            "inspection_date".to_string(),
            AttributeValue::S("2023-06-13".to_string()),
        ),
        ("dessert".to_string(), AttributeValue::S("cake".to_string())),
        ("fruit".to_string(), AttributeValue::S("banana".to_string())),
        (
            "basket".to_string(),
            AttributeValue::Ss(vec![
                "banana".to_string(),
                "apple".to_string(),
                "pear".to_string(),
            ]),
        ),
        (
            "veggies".to_string(),
            AttributeValue::Ss(vec![
                "beans".to_string(),
                "carrots".to_string(),
                "celery".to_string(),
            ]),
        ),
        (
            "work_type".to_string(),
            AttributeValue::S("small".to_string()),
        ),
    ]);

    // 9. Create item two, specifically with "dessert == fruit", and "fruit not in basket".
    let item2 = HashMap::from([
        ("work_id".to_string(), AttributeValue::S("2".to_string())),
        (
            "inspection_date".to_string(),
            AttributeValue::S("2023-06-13".to_string()),
        ),
        (
            "dessert".to_string(),
            AttributeValue::S("orange".to_string()),
        ),
        ("fruit".to_string(), AttributeValue::S("orange".to_string())),
        (
            "basket".to_string(),
            AttributeValue::Ss(vec![
                "strawberry".to_string(),
                "blueberry".to_string(),
                "blackberry".to_string(),
            ]),
        ),
        (
            "veggies".to_string(),
            AttributeValue::Ss(vec![
                "beans".to_string(),
                "carrots".to_string(),
                "peas".to_string(),
            ]),
        ),
        (
            "work_type".to_string(),
            AttributeValue::S("large".to_string()),
        ),
    ]);

    // 10. Create a new AWS SDK DynamoDb client using the DynamoDb Config above
    let dynamo_config = aws_sdk_dynamodb::config::Builder::from(&sdk_config)
        .interceptor(DbEsdkInterceptor::new(encryption_config)?)
        .build();
    let ddb = aws_sdk_dynamodb::Client::from_conf(dynamo_config);

    // 11. Add the two items
    ddb.put_item()
        .table_name(ddb_table_name)
        .set_item(Some(item1.clone()))
        .send()
        .await?;

    ddb.put_item()
        .table_name(ddb_table_name)
        .set_item(Some(item2.clone()))
        .send()
        .await?;

    // 12. Test the first type of Set operation :
    // Select records where the basket attribute holds a particular value
    let expression_attribute_values = HashMap::from([(
        ":value".to_string(),
        AttributeValue::S("banana".to_string()),
    )]);

    let scan_response = ddb
        .scan()
        .table_name(ddb_table_name)
        .filter_expression("contains(basket, :value)")
        .set_expression_attribute_values(Some(expression_attribute_values.clone()))
        .send()
        .await?;

    let attribute_values = scan_response.items.unwrap();
    // Validate only 1 item was returned: item1
    assert_eq!(attribute_values.len(), 1);
    let returned_item = &attribute_values[0];
    // Validate the item has the expected attributes
    assert_eq!(returned_item["work_id"], item1["work_id"]);

    // 13. Test the second type of Set operation :
    // Select records where the basket attribute holds the fruit attribute
    let scan_response = ddb
        .scan()
        .table_name(ddb_table_name)
        .filter_expression("contains(basket, fruit)")
        .send()
        .await?;

    let attribute_values = scan_response.items.unwrap();
    // Validate only 1 item was returned: item1
    assert_eq!(attribute_values.len(), 1);
    let returned_item = &attribute_values[0];
    // Validate the item has the expected attributes
    assert_eq!(returned_item["work_id"], item1["work_id"]);

    // 14. Test the third type of Set operation :
    // Select records where the fruit attribute exists in a particular set
    let basket3 = vec![
        "boysenberry".to_string(),
        "orange".to_string(),
        "grape".to_string(),
    ];
    let expression_attribute_values =
        HashMap::from([(":value".to_string(), AttributeValue::Ss(basket3))]);

    let scan_response = ddb
        .scan()
        .table_name(ddb_table_name)
        .filter_expression("contains(:value, fruit)")
        .set_expression_attribute_values(Some(expression_attribute_values.clone()))
        .send()
        .await?;

    let attribute_values = scan_response.items.unwrap();
    // Validate only 1 item was returned: item1
    assert_eq!(attribute_values.len(), 1);
    let returned_item = &attribute_values[0];
    // Validate the item has the expected attributes
    assert_eq!(returned_item["work_id"], item2["work_id"]);

    // 15. Test a Shared search. Select records where the dessert attribute matches the fruit attribute
    let scan_response = ddb
        .scan()
        .table_name(ddb_table_name)
        .filter_expression("dessert = fruit")
        .send()
        .await?;

    let attribute_values = scan_response.items.unwrap();
    // Validate only 1 item was returned: item1
    assert_eq!(attribute_values.len(), 1);
    let returned_item = &attribute_values[0];
    // Validate the item has the expected attributes
    assert_eq!(returned_item["work_id"], item2["work_id"]);

    // 15. Test the AsSet attribute 'veggies' :
    // Select records where the veggies attribute holds a particular value
    let expression_attribute_values =
        HashMap::from([(":value".to_string(), AttributeValue::S("peas".to_string()))]);

    let scan_response = ddb
        .scan()
        .table_name(ddb_table_name)
        .filter_expression("contains(veggies, :value)")
        .set_expression_attribute_values(Some(expression_attribute_values.clone()))
        .send()
        .await?;

    let attribute_values = scan_response.items.unwrap();
    // Validate only 1 item was returned: item1
    assert_eq!(attribute_values.len(), 1);
    let returned_item = &attribute_values[0];
    // Validate the item has the expected attributes
    assert_eq!(returned_item["work_id"], item2["work_id"]);

    // 16. Test the compound beacon 'work_unit' :
    let expression_attribute_values = HashMap::from([(
        ":value".to_string(),
        AttributeValue::S("I-1.T-small".to_string()),
    )]);

    let scan_response = ddb
        .scan()
        .table_name(ddb_table_name)
        .filter_expression("work_unit = :value")
        .set_expression_attribute_values(Some(expression_attribute_values.clone()))
        .send()
        .await?;

    let attribute_values = scan_response.items.unwrap();
    // Validate only 1 item was returned: item1
    assert_eq!(attribute_values.len(), 1);
    let returned_item = &attribute_values[0];
    // Validate the item has the expected attributes
    assert_eq!(returned_item["work_id"], item1["work_id"]);

    println!("beacon_styles_searchable_encryption successful.");
    Ok(())
}
