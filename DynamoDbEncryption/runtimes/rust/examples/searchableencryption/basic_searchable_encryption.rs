// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

use crate::test_utils;
use aws_sdk_dynamodb::types::AttributeValue;
use std::collections::HashMap;

use aws_db_esdk::material_providers::client;
use aws_db_esdk::material_providers::types::material_providers_config::MaterialProvidersConfig;
use aws_db_esdk::CryptoAction;

use aws_db_esdk::dynamodb::types::BeaconKeySource;
use aws_db_esdk::dynamodb::types::BeaconVersion;
use aws_db_esdk::dynamodb::types::DynamoDbTableEncryptionConfig;
use aws_db_esdk::dynamodb::types::SearchConfig;
use aws_db_esdk::dynamodb::types::SingleKeyStore;
use aws_db_esdk::dynamodb::types::StandardBeacon;
use aws_db_esdk::intercept::DbEsdkInterceptor;
use aws_db_esdk::key_store::client as keystore_client;
use aws_db_esdk::key_store::types::key_store_config::KeyStoreConfig;
use aws_db_esdk::key_store::types::KmsConfiguration;
use aws_db_esdk::types::dynamo_db_tables_encryption_config::DynamoDbTablesEncryptionConfig;

/*
 This example demonstrates how to set up a beacon on an encrypted attribute,
 put an item with the beacon, and query against that beacon.
 This example follows a use case of a database that stores unit inspection information.

 Running this example requires access to a DDB table with the
 following key configuration:
   - Partition key is named "work_id" with type (S)
   - Sort key is named "inspection_date" with type (S)
 This table must have a Global Secondary Index (GSI) configured named "last4-unit-index":
   - Partition key is named "aws_dbe_b_inspector_id_last4" with type (S)
   - Sort key is named "aws_dbe_b_unit" with type (S)

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
*/

const GSI_NAME: &str = "last4-unit-index";

pub async fn put_and_query_with_beacon(branch_key_id: &str) -> Result<(), crate::BoxError> {
    // The whole thing is wrapped in a future to ensure that everything is Send and Sync
    let future = async move {
        let ddb_table_name = test_utils::UNIT_INSPECTION_TEST_DDB_TABLE_NAME;
        let branch_key_wrapping_kms_key_arn = test_utils::TEST_BRANCH_KEY_WRAPPING_KMS_KEY_ARN;
        let branch_key_ddb_table_name = test_utils::TEST_BRANCH_KEYSTORE_DDB_TABLE_NAME;

        // 1. Configure Beacons.
        //    The beacon name must be the name of a table attribute that will be encrypted.
        //    The `length` parameter dictates how many bits are in the beacon attribute value.
        //    The following link provides guidance on choosing a beacon length:
        //        https://docs.aws.amazon.com/database-encryption-sdk/latest/devguide/choosing-beacon-length.html

        // The configured DDB table has a GSI on the `aws_dbe_b_inspector_id_last4` AttributeName.
        // This field holds the last 4 digits of an inspector ID.
        // For our example, this field may range from 0 to 9,999 (10,000 possible values).
        // For our example, we assume a full inspector ID is an integer
        //     ranging from 0 to 99,999,999. We do not assume that the full inspector ID's
        //     values are uniformly distributed across its range of possible values.
        //     In many use cases, the prefix of an identifier encodes some information
        //     about that identifier (e.g. zipcode and SSN prefixes encode geographic
        //     information), while the suffix does not and is more uniformly distributed.
        //     We will assume that the inspector ID field matches a similar use case.
        //     So for this example, we only store and use the last
        //     4 digits of the inspector ID, which we assume is uniformly distributed.
        // Since the full ID's range is divisible by the range of the last 4 digits,
        //     then the last 4 digits of the inspector ID are uniformly distributed
        //     over the range from 0 to 9,999.
        // See our documentation for why you should avoid creating beacons over non-uniform distributions
        //  https://docs.aws.amazon.com/database-encryption-sdk/latest/devguide/searchable-encryption.html#are-beacons-right-for-me
        // A single inspector ID suffix may be assigned to multiple `work_id`s.
        //
        // This link provides guidance for choosing a beacon length:
        //    https://docs.aws.amazon.com/database-encryption-sdk/latest/devguide/choosing-beacon-length.html
        // We follow the guidance in the link above to determine reasonable bounds
        // for the length of a beacon on the last 4 digits of an inspector ID:
        //  - min: log(sqrt(10,000))/log(2) ~= 6.6, round up to 7
        //  - max: log((10,000/2))/log(2) ~= 12.3, round down to 12
        // You will somehow need to round results to a nearby integer.
        // We choose to round to the nearest integer; you might consider a different rounding approach.
        // Rounding up will return fewer expected "false positives" in queries,
        //    leading to fewer decrypt calls and better performance,
        //    but it is easier to identify which beacon values encode distinct plaintexts.
        // Rounding down will return more expected "false positives" in queries,
        //    leading to more decrypt calls and worse performance,
        //    but it is harder to identify which beacon values encode distinct plaintexts.
        // We can choose a beacon length between 7 and 12:
        //  - Closer to 7, we expect more "false positives" to be returned,
        //    making it harder to identify which beacon values encode distinct plaintexts,
        //    but leading to more decrypt calls and worse performance
        //  - Closer to 12, we expect fewer "false positives" returned in queries,
        //    leading to fewer decrypt calls and better performance,
        //    but it is easier to identify which beacon values encode distinct plaintexts.
        // As an example, we will choose 10.
        //
        // Values stored in aws_dbe_b_inspector_id_last4 will be 10 bits long (0x000 - 0x3ff)
        // There will be 2^10 = 1,024 possible HMAC values.
        // With a sufficiently large number of well-distributed inspector IDs,
        //    for a particular beacon we expect (10,000/1,024) ~= 9.8 4-digit inspector ID suffixes
        //    sharing that beacon value.
        let last4_beacon = StandardBeacon::builder()
            .name("inspector_id_last4")
            .length(10)
            .build()?;

        // The configured DDB table has a GSI on the `aws_dbe_b_unit` AttributeName.
        // This field holds a unit serial number.
        // For this example, this is a 12-digit integer from 0 to 999,999,999,999 (10^12 possible values).
        // We will assume values for this attribute are uniformly distributed across this range.
        // A single unit serial number may be assigned to multiple `work_id`s.
        //
        // This link provides guidance for choosing a beacon length:
        //    https://docs.aws.amazon.com/database-encryption-sdk/latest/devguide/choosing-beacon-length.html
        // We follow the guidance in the link above to determine reasonable bounds
        // for the length of a beacon on a unit serial number:
        //  - min: log(sqrt(999,999,999,999))/log(2) ~= 19.9, round up to 20
        //  - max: log((999,999,999,999/2))/log(2) ~= 38.9, round up to 39
        // We can choose a beacon length between 20 and 39:
        //  - Closer to 20, we expect more "false positives" to be returned,
        //    making it harder to identify which beacon values encode distinct plaintexts,
        //    but leading to more decrypt calls and worse performance
        //  - Closer to 39, we expect fewer "false positives" returned in queries,
        //    leading to fewer decrypt calls and better performance,
        //    but it is easier to identify which beacon values encode distinct plaintexts.
        // As an example, we will choose 30.
        //
        // Values stored in aws_dbe_b_unit will be 30 bits long (0x00000000 - 0x3fffffff)
        // There will be 2^30 = 1,073,741,824 ~= 1.1B possible HMAC values.
        // With a sufficiently large number of well-distributed inspector IDs,
        //    for a particular beacon we expect (10^12/2^30) ~= 931.3 unit serial numbers
        //    sharing that beacon value.
        let unit_beacon = StandardBeacon::builder().name("unit").length(30).build()?;

        let standard_beacon_list = vec![last4_beacon, unit_beacon];

        // 2. Configure Keystore.
        //    The keystore is a separate DDB table where the client stores encryption and decryption materials.
        //    In order to configure beacons on the DDB client, you must configure a keystore.
        //
        //    This example expects that you have already set up a KeyStore with a single branch key.
        //    See the "Create KeyStore Table Example" and "Create KeyStore Key Example" for how to do this.
        //    After you create a branch key, you should persist its ID for use in this example.
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
        //    The BeaconVersion inside the list holds the list of beacons on the table.
        //    The BeaconVersion also stores information about the keystore.
        //    BeaconVersion must be provided:
        //      - keyStore: The keystore configured in step 2.
        //      - keySource: A configuration for the key source.
        //        For simple use cases, we can configure a 'singleKeySource' which
        //        statically configures a single beaconKey. That is the approach this example takes.
        //        For use cases where you want to use different beacon keys depending on the data
        //        (for example if your table holds data for multiple tenants, and you want to use
        //        a different beacon key per tenant), look into configuring a MultiKeyStore:
        //          https://docs.aws.amazon.com/database-encryption-sdk/latest/devguide/searchable-encryption-multitenant.html

        let beacon_version = BeaconVersion::builder()
            .standard_beacons(standard_beacon_list)
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
        //    This is a KMS keyring that utilizes the keystore table.
        //    This config defines how items are encrypted and decrypted.
        //    NOTE: You should configure this to use the same keystore as your search config.
        let provider_config = MaterialProvidersConfig::builder().build()?;
        let mat_prov = client::Client::from_conf(provider_config)?;
        let kms_keyring = mat_prov
            .create_aws_kms_hierarchical_keyring()
            .branch_key_id(branch_key_id)
            .key_store(key_store)
            .ttl_seconds(6000)
            .send()
            .await?;

        // 5. Configure which attributes are encrypted and/or signed when writing new items.
        //    For each attribute that may exist on the items we plan to write to our DynamoDbTable,
        //    we must explicitly configure how they should be treated during item encryption:
        //      - ENCRYPT_AND_SIGN: The attribute is encrypted and included in the signature
        //      - SIGN_ONLY: The attribute not encrypted, but is still included in the signature
        //      - DO_NOTHING: The attribute is not encrypted and not included in the signature
        //    Any attributes that will be used in beacons must be configured as ENCRYPT_AND_SIGN.
        let attribute_actions_on_encrypt = HashMap::from([
            ("work_id".to_string(), CryptoAction::SignOnly), // Our partition attribute must be SIGN_ONLY
            ("inspection_date".to_string(), CryptoAction::SignOnly), // Our sort attribute must be SIGN_ONLY
            (
                "inspector_id_last4".to_string(),
                CryptoAction::EncryptAndSign,
            ), // Beaconized attributes must be encrypted
            ("unit".to_string(), CryptoAction::EncryptAndSign), // Beaconized attributes must be encrypted
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

        let table_configs = DynamoDbTablesEncryptionConfig::builder()
            .table_encryption_configs(HashMap::from([(ddb_table_name.to_string(), table_config)]))
            .build()?;

        // 7. Create a new AWS SDK DynamoDb client using the TableEncryptionConfigs
        let sdk_config = aws_config::load_defaults(aws_config::BehaviorVersion::latest()).await;
        let dynamo_config = aws_sdk_dynamodb::config::Builder::from(&sdk_config)
            .interceptor(DbEsdkInterceptor::new(table_configs)?)
            .build();
        let ddb = aws_sdk_dynamodb::Client::from_conf(dynamo_config);

        // 8. Put an item into our table using the above client.
        //    Before the item gets sent to DynamoDb, it will be encrypted
        //        client-side, according to our configuration.
        //    Since our configuration includes beacons for `inspector_id_last4` and `unit`,
        //        the client will add two additional attributes to the item. These attributes will have names
        //        `aws_dbe_b_inspector_id_last4` and `aws_dbe_b_unit`. Their values will be HMACs
        //        truncated to as many bits as the beacon's `length` parameter; e.g.
        //    aws_dbe_b_inspector_id_last4 = truncate(HMAC("4321"), 10)
        //    aws_dbe_b_unit = truncate(HMAC("123456789012"), 30)

        let item = HashMap::from([
            (
                "work_id".to_string(),
                AttributeValue::S("1313ba89-5661-41eb-ba6c-cb1b4cb67b2d".to_string()),
            ),
            (
                "inspection_date".to_string(),
                AttributeValue::S("2023-06-13".to_string()),
            ),
            (
                "inspector_id_last4".to_string(),
                AttributeValue::S("4321".to_string()),
            ),
            (
                "unit".to_string(),
                AttributeValue::S("123456789012".to_string()),
            ),
        ]);

        ddb.put_item()
            .table_name(ddb_table_name)
            .set_item(Some(item.clone()))
            .send()
            .await?;

        // 9. Query for the item we just put.
        //     Note that we are constructing the query as if we were querying on plaintext values.
        //     However, the DDB encryption client will detect that this attribute name has a beacon configured.
        //     The client will add the beaconized attribute name and attribute value to the query,
        //         and transform the query to use the beaconized name and value.
        //     Internally, the client will query for and receive all items with a matching HMAC value in the beacon field.
        //     This may include a number of "false positives" with different ciphertext, but the same truncated HMAC.
        //     e.g. if truncate(HMAC("123456789012"), 30)
        //          == truncate(HMAC("098765432109"), 30),
        //     the query will return both items.
        //     The client will decrypt all returned items to determine which ones have the expected attribute values,
        //         and only surface items with the correct plaintext to the user.
        //     This procedure is internal to the client and is abstracted away from the user;
        //     e.g. the user will only see "123456789012" and never
        //        "098765432109", though the actual query returned both.
        let expression_attributes_names = HashMap::from([
            ("#last4".to_string(), "inspector_id_last4".to_string()),
            ("#unit".to_string(), "unit".to_string()),
        ]);

        let expression_attribute_values = HashMap::from([
            (":last4".to_string(), AttributeValue::S("4321".to_string())),
            (
                ":unit".to_string(),
                AttributeValue::S("123456789012".to_string()),
            ),
        ]);

        // GSIs do not update instantly
        // so if the results come back empty
        // we retry after a short sleep
        for _i in 0..10 {
            let query_response = ddb
                .query()
                .table_name(ddb_table_name)
                .index_name(GSI_NAME)
                .key_condition_expression("#last4 = :last4 and #unit = :unit")
                .set_expression_attribute_names(Some(expression_attributes_names.clone()))
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
                AttributeValue::S("4321".to_string())
            );
            assert_eq!(
                returned_item["unit"],
                AttributeValue::S("123456789012".to_string())
            );
            break;
        }
        println!("basic_searchable_encryption successful.");
        Ok(())
    };
    future.await
}
