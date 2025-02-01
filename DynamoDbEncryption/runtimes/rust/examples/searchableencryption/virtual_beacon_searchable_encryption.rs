// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

use crate::test_utils;
use aws_db_esdk::client as transform_client;
use aws_db_esdk::dynamodb::types::BeaconKeySource;
use aws_db_esdk::dynamodb::types::BeaconVersion;
use aws_db_esdk::dynamodb::types::DynamoDbTableEncryptionConfig;
use aws_db_esdk::dynamodb::types::GetPrefix;
use aws_db_esdk::dynamodb::types::SearchConfig;
use aws_db_esdk::dynamodb::types::SingleKeyStore;
use aws_db_esdk::dynamodb::types::StandardBeacon;
use aws_db_esdk::dynamodb::types::VirtualField;
use aws_db_esdk::dynamodb::types::VirtualPart;
use aws_db_esdk::dynamodb::types::VirtualTransform;
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
 This example demonstrates how to set up a virtual field from two DDB
 attributes, create a standard beacon with that field, put an item with
 that beacon, and query against that beacon.

 A virtual field is a field consisting of a transformation of one or more attributes in a DDB item.
 Virtual fields are useful in querying against encrypted fields that only have a handful of
 possible values. They allow you to take fields with few possible values, concatenate
 them to other fields, then query against the combined field. This enables using these types of
 fields in queries while making it infeasible to identify which beacon values encode
 the few possible distinct plaintexts. This is explained in more detail below.
 Virtual fields are not stored in the DDB table. However, they are used to construct
 a beacon, the value of which is stored.

 For more information on virtual fields, see
   https://docs.aws.amazon.com/database-encryption-sdk/latest/devguide/beacons.html#virtual-field

 For our example, we will construct a virtual field
 from two DDB attributes `state` and `hasTestResult` as `state`+prefix(`hasTestResult`, 1).
 We will then create a beacon out of this virtual field and use it to search.

 This example follows a use case of a database that stores customer test result metadata.
 Records are indexed by `customer_id` and store a `state` attribute, representing the
 US state or territory where the customer lives, and a `hasTestResult` boolean attribute,
 representing whether the customer has a "test result" available. (Maybe this represents
 some medical test result, and this table stores "result available" metadata.) We assume
 that values in these fields are uniformly distributed across all possible values for
 these fields (56 for `state`, 2 for `hasTestResult`), and are uniformly distributed across
 customer IDs.

 The motivation behind this example is to demonstrate how and why one would use a virtual beacon.
 In this example, our table stores records with an encrypted boolean `hasTestResult` attribute.
 We would like to be able to query for customers in a given state with a `true` hasTestResult
 attribute.

 To be able to execute this query securely and efficiently, we want the following
 properties on our table:
  1. Hide the distribution of `hasTestResult` attribute values (i.e. it should be infeasible
     to determine the percentage of `true`s to `false`s across the dataset from beaconized
     values)
  2. Query against a combination of whether `hasTestResult` is true/false and the `state` field
 We cannot achieve these properties with a standard beacon on a true/false attribute. Following
 the guidance to choose a beacon length:
   https://docs.aws.amazon.com/database-encryption-sdk/latest/devguide/choosing-beacon-length.html
 For a boolean value (in our case, whether `hasTestResult` is true or false), the acceptable
 bounds for beacon length are either 0 or 1. This corresponds to either not storing a beacon
 (length 0), or effectively storing another boolean attribute (length 1). With
 length 0, this beacon is useless for searching (violating property 2); with length 1, this
 beacon may not hide the attribute (violating property 1).
 In addition, choosing a longer beacon length does not help us.
 Each attribute value is mapped to a distinct beacon.
 Since booleans only have 2 possible attribute values, we will still only have 2 possible
 beacon values, though those values may be longer. A longer beacon provides no advantages over
 beacon of length 1 in this situation.

 A compound beacon also does not help.
 To (over)simplify, a compound beacon is a concatenation of standard beacons,
 i.e. beacon(`state`)+beacon(`hasTestResult`).
 The `hasTestResult` beacon is still visible, so we would still have the problems above.

 To achieve these properties, we instead construct a virtual field and use that in our beacon,
 i.e. beacon(`state`+`hasTestResult`). Assuming these fields are well-distributed across
 customer IDs and possible values, this gives us both desired properties; we can query against
 both attributes while hiding information from the underlying data. This is demonstrated in more
 detail below.

 Running this example requires access to a DDB table  with the
 following primary key configuration:
   - Partition key is named "customer_id" with type (S)
   - Sort key is named "create_time" with type (S)
 This table must have a Global Secondary Index (GSI) configured named "stateAndHasTestResult-index":
   - Partition key is named "aws_dbe_b_stateAndHasTestResult" with type (S)

 In this example for storing customer location data, this schema is utilized for the data:
  - "customer_id" stores a unique customer identifier
  - "create_time" stores a Unix timestamp
  - "state" stores an encrypted 2-letter US state or territory abbreviation
        (https://www.faa.gov/air_traffic/publications/atpubs/cnt_html/appendix_a.html)
  - "hasTestResult" is not part of the schema, but is an attribute utilized in this example.
     It stores a boolean attribute (false/true) indicating whether this customer has a test result
     available.

 The example requires the following ordered input command line parameters:
   1. DDB table name for table to put/query data from
   2. Branch key ID for a branch key that was previously created in your key store. See the
      CreateKeyStoreKeyExample.
   2. Branch key wrapping KMS key ARN for the KMS key used to create the branch key
   3. Branch key DDB table name for the DDB table representing the branch key store
*/

const GSI_NAME: &str = "stateAndHasTestResult-index";

pub async fn put_and_query_with_beacon(branch_key_id: &str) -> Result<(), crate::BoxError> {
    let ddb_table_name = test_utils::SIMPLE_BEACON_TEST_DDB_TABLE_NAME;
    let branch_key_wrapping_kms_key_arn = test_utils::TEST_BRANCH_KEY_WRAPPING_KMS_KEY_ARN;
    let branch_key_ddb_table_name = test_utils::TEST_BRANCH_KEYSTORE_DDB_TABLE_NAME;

    // 1. Construct a length-1 prefix virtual transform.
    //    `hasTestResult` is a binary attribute, containing either `true` or `false`.
    //    As an example to demonstrate virtual transforms, we will truncate the value
    //    of `hasTestResult` in the virtual field to the length-1 prefix of the binary value, i.e.:
    //     - "true" -> "t"
    //     - "false -> "f"
    //    This is not necessary. This is done as a demonstration of virtual transforms.
    //    Virtual transform operations treat all attributes as strings
    //    (i.e. the boolean value `true` is interpreted as a string "true"),
    //    so its length-1 prefix is just "t".

    let length1_prefix_virtual_transform_list = vec![VirtualTransform::Prefix(
        GetPrefix::builder().length(1).build()?,
    )];

    // 2. Construct the VirtualParts required for the VirtualField
    let has_test_result_part = VirtualPart::builder()
        .loc("hasTestResult")
        .trans(length1_prefix_virtual_transform_list)
        .build()?;

    let state_part = VirtualPart::builder().loc("state").build()?;
    // Note that we do not apply any transform to the `state` attribute,
    // and the virtual field will read in the attribute as-is.

    // 3. Construct the VirtualField from the VirtualParts
    //    Note that the order that virtual parts are added to the virtualPartList
    //    dictates the order in which they are concatenated to build the virtual field.
    //    You must add virtual parts in the same order on write as you do on read.
    let virtual_part_list = vec![state_part, has_test_result_part];

    let state_and_has_test_result_field = VirtualField::builder()
        .name("stateAndHasTestResult")
        .parts(virtual_part_list)
        .build()?;

    let virtual_field_list = vec![state_and_has_test_result_field];

    // 4. Configure our beacon.
    //    The virtual field is assumed to hold a US 2-letter state abbreviation
    //    (56 possible values = 50 states + 6 territories) concatenated with a binary attribute
    //    (2 possible values: true/false hasTestResult field), we expect a population size of
    //    56 * 2 = 112 possible values.
    //    We will also assume that these values are reasonably well-distributed across
    //    customer IDs. In practice, this will not be true. We would expect
    //    more populous states to appear more frequently in the database.
    //    A more complex analysis would show that a stricter upper bound
    //    is necessary to account for this by hiding information from the
    //    underlying distribution.
    //
    //    This link provides guidance for choosing a beacon length:
    //       https://docs.aws.amazon.com/database-encryption-sdk/latest/devguide/choosing-beacon-length.html
    //    We follow the guidance in the link above to determine reasonable bounds for beacon length:
    //     - min: log(sqrt(112))/log(2) ~= 3.4, round down to 3
    //     - max: log((112/2))/log(2) ~= 5.8, round up to 6
    //    You will somehow need to round results to a nearby integer.
    //    We choose to round to the nearest integer; you might consider a different rounding approach.
    //    Rounding up will return fewer expected "false positives" in queries,
    //       leading to fewer decrypt calls and better performance,
    //       but it is easier to identify which beacon values encode distinct plaintexts.
    //    Rounding down will return more expected "false positives" in queries,
    //       leading to more decrypt calls and worse performance,
    //       but it is harder to identify which beacon values encode distinct plaintexts.
    //    We can choose a beacon length between 3 and 6:
    //     - Closer to 3, we expect more "false positives" to be returned,
    //       making it harder to identify which beacon values encode distinct plaintexts,
    //       but leading to more decrypt calls and worse performance
    //     - Closer to 6, we expect fewer "false positives" returned in queries,
    //       leading to fewer decrypt calls and better performance,
    //       but it is easier to identify which beacon values encode distinct plaintexts.
    //    As an example, we will choose 5.
    //    Values stored in aws_dbe_b_stateAndHasTestResult will be 5 bits long (0x00 - 0x1f)
    //    There will be 2^5 = 32 possible HMAC values.
    //    With a well-distributed dataset (112 values), for a particular beacon we expect
    //    (112/32) = 3.5 combinations of abbreviation + true/false attribute
    //    sharing that beacon value.
    let standard_beacon_list = vec![StandardBeacon::builder()
        .name("stateAndHasTestResult")
        .length(5)
        .build()?];

    // 5. Configure Keystore.
    //    This example expects that you have already set up a KeyStore with a single branch key.
    //    See the "CreateKeyStoreTableExample" and "CreateKeyStoreKeyExample" files for how to do this.
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

    // 6. Create BeaconVersion.
    //    The BeaconVersion inside the list holds the list of beacons on the table.
    //    The BeaconVersion also stores information about the keystore.
    //    BeaconVersion must be provided:
    //      - keyStore: The keystore configured in the previous step.
    //      - keySource: A configuration for the key source.
    //        For simple use cases, we can configure a 'singleKeySource' which
    //        statically configures a single beaconKey. That is the approach this example takes.
    //        For use cases where you want to use different beacon keys depending on the data
    //        (for example if your table holds data for multiple tenants, and you want to use
    //        a different beacon key per tenant), look into configuring a MultiKeyStore:
    //          https://docs.aws.amazon.com/database-encryption-sdk/latest/devguide/searchable-encryption-multitenant.html
    //    We also provide our standard beacon list and virtual fields here.
    let beacon_version = BeaconVersion::builder()
        .standard_beacons(standard_beacon_list)
        .virtual_fields(virtual_field_list)
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

    // 7. Create a Hierarchical Keyring
    //    This is a KMS keyring that utilizes the keystore table.
    //    This config defines how items are encrypted and decrypted.
    //    NOTE: You should configure this to use the same keystore as your search config.
    let mpl_config = MaterialProvidersConfig::builder().build()?;
    let mpl = mpl_client::Client::from_conf(mpl_config)?;
    let kms_keyring = mpl
        .create_aws_kms_hierarchical_keyring()
        .branch_key_id(branch_key_id)
        .key_store(key_store)
        .ttl_seconds(6000)
        .send()
        .await?;

    // 8. Configure which attributes are encrypted and/or signed when writing new items.
    //    For each attribute that may exist on the items we plan to write to our DynamoDbTable,
    //    we must explicitly configure how they should be treated during item encryption:
    //      - ENCRYPT_AND_SIGN: The attribute is encrypted and included in the signature
    //      - SIGN_ONLY: The attribute not encrypted, but is still included in the signature
    //      - DO_NOTHING: The attribute is not encrypted and not included in the signature
    //    Any attributes that will be used in beacons must be configured as ENCRYPT_AND_SIGN.
    let attribute_actions_on_encrypt = HashMap::from([
        ("customer_id".to_string(), CryptoAction::SignOnly), // Our partition attribute must be SIGN_ONLY
        ("create_time".to_string(), CryptoAction::SignOnly), // Our sort attribute must be SIGN_ONLY
        ("state".to_string(), CryptoAction::EncryptAndSign), // Beaconized attributes must be encrypted
        ("hasTestResult".to_string(), CryptoAction::EncryptAndSign), // Beaconized attributes must be encrypted
    ]);

    // 9. Create the DynamoDb Encryption configuration for the table we will be writing to.
    //    The beaconVersions are added to the search configuration.
    let table_config = DynamoDbTableEncryptionConfig::builder()
        .logical_table_name(ddb_table_name)
        .partition_key_name("customer_id")
        .sort_key_name("create_time")
        .attribute_actions_on_encrypt(attribute_actions_on_encrypt)
        .keyring(kms_keyring)
        .search(
            SearchConfig::builder()
                .write_version(1) // MUST be 1
                .versions(beacon_versions)
                .build()?,
        )
        .build()?;

    // 10. Create config
    let encryption_config = DynamoDbTablesEncryptionConfig::builder()
        .table_encryption_configs(HashMap::from([(ddb_table_name.to_string(), table_config)]))
        .build()?;

    // 11. Create test items

    // Create item with hasTestResult=true
    let item_with_has_test_result = HashMap::from([
        (
            "customer_id".to_string(),
            AttributeValue::S("ABC-123".to_string()),
        ),
        (
            "create_time".to_string(),
            AttributeValue::N("1681495205".to_string()),
        ),
        ("state".to_string(), AttributeValue::S("CA".to_string())),
        ("hasTestResult".to_string(), AttributeValue::Bool(true)),
    ]);

    // Create item with hasTestResult=false
    let item_with_no_has_test_result = HashMap::from([
        (
            "customer_id".to_string(),
            AttributeValue::S("DEF-456".to_string()),
        ),
        (
            "create_time".to_string(),
            AttributeValue::N("1681495205".to_string()),
        ),
        ("state".to_string(), AttributeValue::S("CA".to_string())),
        ("hasTestResult".to_string(), AttributeValue::Bool(false)),
    ]);

    // 12. If developing or debugging, verify config by checking virtual field values directly
    let trans = transform_client::Client::from_conf(encryption_config.clone())?;
    let resolve_output = trans
        .resolve_attributes()
        .table_name(ddb_table_name)
        .item(item_with_has_test_result.clone())
        .version(1)
        .send()
        .await?;

    // CompoundBeacons is empty because we have no Compound Beacons configured
    assert_eq!(resolve_output.compound_beacons.unwrap().len(), 0);

    // Verify that VirtualFields has the expected value
    let virtual_fields = resolve_output.virtual_fields.unwrap();
    assert_eq!(virtual_fields.len(), 1);
    assert_eq!(virtual_fields["stateAndHasTestResult"], "CAt");

    // 13. Create a new AWS SDK DynamoDb client using the DynamoDb Encryption Interceptor above
    let dynamo_config = aws_sdk_dynamodb::config::Builder::from(&sdk_config)
        .interceptor(DbEsdkInterceptor::new(encryption_config)?)
        .build();
    let ddb = aws_sdk_dynamodb::Client::from_conf(dynamo_config);

    // 14. Put two items into our table using the above client.
    //     The two items will differ only in their `customer_id` attribute (primary key)
    //         and their `hasTestResult` attribute.
    //     We will query against these items to demonstrate how to use our setup above
    //         to query against our `stateAndHasTestResult` beacon.
    //     Before the item gets sent to DynamoDb, it will be encrypted
    //         client-side, according to our configuration.
    //     Since our configuration includes a beacon on a virtual field named
    //         `stateAndHasTestResult`, the client will add an attribute
    //         to the item with name `aws_dbe_b_stateAndHasTestResult`.
    //         Its value will be an HMAC truncated to as many bits as the
    //         beacon's `length` parameter; i.e. 5.

    ddb.put_item()
        .table_name(ddb_table_name)
        .set_item(Some(item_with_has_test_result.clone()))
        .send()
        .await?;

    ddb.put_item()
        .table_name(ddb_table_name)
        .set_item(Some(item_with_no_has_test_result.clone()))
        .send()
        .await?;

    // 15. Query by stateAndHasTestResult attribute.
    //     Note that we are constructing the query as if we were querying on plaintext values.
    //     However, the DDB encryption client will detect that this attribute name has a beacon configured.
    //     The client will add the beaconized attribute name and attribute value to the query,
    //         and transform the query to use the beaconized name and value.
    //     Internally, the client will query for and receive all items with a matching HMAC value in the beacon field.
    //     This may include a number of "false positives" with different ciphertext, but the same truncated HMAC.
    //     e.g. if truncate(HMAC("CAt"), 5) == truncate(HMAC("DCf"), 5), the query will return both items.
    //     The client will decrypt all returned items to determine which ones have the expected attribute values,
    //         and only surface items with the correct plaintext to the user.
    //     This procedure is internal to the client and is abstracted away from the user;
    //     e.g. the user will only see "CAt" and never "DCf", though the actual query returned both.
    let expression_attribute_values = HashMap::from([
        // We are querying for the item with `state`="CA" and `hasTestResult`=`true`.
        // Since we added virtual parts as `state` then `hasTestResult`,
        //     we must write our query expression in the same order.
        // We constructed our virtual field as `state`+`hasTestResult`,
        //     so we add the two parts in that order.
        // Since we also created a virtual transform that truncated `hasTestResult`
        //     to its length-1 prefix, i.e. "true" -> "t",
        //     we write that field as its length-1 prefix in the query.
        (
            ":stateAndHasTestResult".to_string(),
            AttributeValue::S("CAt".to_string()),
        ),
    ]);

    // GSIs are sometimes a little bit delayed, so we retry if the query comes up empty.
    for _i in 0..10 {
        let query_response = ddb
            .query()
            .table_name(ddb_table_name)
            .index_name(GSI_NAME)
            .key_condition_expression("stateAndHasTestResult = :stateAndHasTestResult")
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
        assert_eq!(returned_item["state"], AttributeValue::S("CA".to_string()));
        assert_eq!(returned_item["hasTestResult"], AttributeValue::Bool(true));
        break;
    }
    println!("virtual_beacon_searchable_encryption successful.");
    Ok(())
}
