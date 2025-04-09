// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

use super::regional_role_client_supplier::RegionalRoleClientSupplier;
use crate::test_utils;
use aws_db_esdk::dynamodb::types::DynamoDbTableEncryptionConfig;
use aws_db_esdk::intercept::DbEsdkInterceptor;
use aws_db_esdk::material_providers::client as mpl_client;
use aws_db_esdk::material_providers::types::material_providers_config::MaterialProvidersConfig;
use aws_db_esdk::material_providers::types::DiscoveryFilter;
use aws_db_esdk::CryptoAction;
use aws_db_esdk::DynamoDbTablesEncryptionConfig;
use aws_sdk_dynamodb::types::AttributeValue;
use std::collections::HashMap;

/*
 This example sets up an MRK multi-keyring and an MRK discovery
 multi-keyring using a custom client supplier.
 A custom client supplier grants users access to more granular
 configuration aspects of their authentication details and KMS
 client. In this example, we create a simple custom client supplier
 that authenticates with a different IAM role based on the
 region of the KMS key.

 This example creates a MRK multi-keyring configured with a custom
 client supplier using a single MRK and puts an encrypted item to the
 table. Then, it creates a MRK discovery multi-keyring to decrypt the item
 and retrieves the item from the table.

 Running this example requires access to the DDB Table whose name
 is provided in CLI arguments.
 This table must be configured with the following
 primary key configuration:
   - Partition key is named "partition_key" with type (S)
   - Sort key is named "sort_key" with type (S)
*/
pub async fn put_item_get_item() -> Result<(), crate::BoxError> {
    let ddb_table_name = test_utils::TEST_DDB_TABLE_NAME;
    // Note that we pass in an MRK in us-east-1...
    let key_arn = test_utils::TEST_MRK_REPLICA_KEY_ID_US_EAST_1.to_string();
    let account_ids = vec![test_utils::TEST_AWS_ACCOUNT_ID.to_string()];
    // ...and access its replica in eu-west-1
    let regions = vec!["eu-west-1".to_string()];

    // 1. Create a single MRK multi-keyring.
    //    This can be either a single-region KMS key or an MRK.
    //    For this example to succeed, the key's region must either
    //    1) be in the regions list, or
    //    2) the key must be an MRK with a replica defined
    //    in a region in the regions list, and the client
    //    must have the correct permissions to access the replica.
    let mpl_config = MaterialProvidersConfig::builder().build()?;
    let mpl = mpl_client::Client::from_conf(mpl_config)?;

    // Create the multi-keyring using our custom client supplier
    // defined in the RegionalRoleClientSupplier class in this directory.
    // Note: RegionalRoleClientSupplier will internally use the key_arn's region
    // to retrieve the correct IAM role.

    let mrk_keyring_with_client_supplier = mpl
        .create_aws_kms_mrk_multi_keyring()
        .client_supplier(RegionalRoleClientSupplier {})
        .generator(key_arn)
        .send()
        .await?;

    // 2. Configure which attributes are encrypted and/or signed when writing new items.
    //    For each attribute that may exist on the items we plan to write to our DynamoDbTable,
    //    we must explicitly configure how they should be treated during item encryption:
    //      - ENCRYPT_AND_SIGN: The attribute is encrypted and included in the signature
    //      - SIGN_ONLY: The attribute is not encrypted, but is still included in the signature
    //      - DO_NOTHING: The attribute is not encrypted and not included in the signature
    let attribute_actions_on_encrypt = HashMap::from([
        ("partition_key".to_string(), CryptoAction::SignOnly), // Our partition attribute must be SIGN_ONLY
        ("sort_key".to_string(), CryptoAction::SignOnly), // Our sort attribute must be SIGN_ONLY
        ("sensitive_data".to_string(), CryptoAction::EncryptAndSign),
    ]);

    // 3. Configure which attributes we expect to be included in the signature
    //    when reading items. There are two options for configuring this:
    //
    //    - (Recommended) Configure `allowedUnsignedAttributesPrefix`:
    //      When defining your DynamoDb schema and deciding on attribute names,
    //      choose a distinguishing prefix (such as ":") for all attributes that
    //      you do not want to include in the signature.
    //      This has two main benefits:
    //      - It is easier to reason about the security and authenticity of data within your item
    //        when all unauthenticated data is easily distinguishable by their attribute name.
    //      - If you need to add new unauthenticated attributes in the future,
    //        you can easily make the corresponding update to your `attributeActionsOnEncrypt`
    //        and immediately start writing to that new attribute, without
    //        any other configuration update needed.
    //      Once you configure this field, it is not safe to update it.
    //
    //    - Configure `allowedUnsignedAttributes`: You may also explicitly list
    //      a set of attributes that should be considered unauthenticated when encountered
    //      on read. Be careful if you use this configuration. Do not remove an attribute
    //      name from this configuration, even if you are no longer writing with that attribute,
    //      as old items may still include this attribute, and our configuration needs to know
    //      to continue to exclude this attribute from the signature scope.
    //      If you add new attribute names to this field, you must first deploy the update to this
    //      field to all readers in your host fleet before deploying the update to start writing
    //      with that new attribute.
    //
    //   For this example, we currently authenticate all attributes. To make it easier to
    //   add unauthenticated attributes in the future, we define a prefix ":" for such attributes.
    const UNSIGNED_ATTR_PREFIX: &str = ":";

    // 4. Create the DynamoDb Encryption configuration for the table we will be writing to.
    let table_config = DynamoDbTableEncryptionConfig::builder()
        .logical_table_name(ddb_table_name)
        .partition_key_name("partition_key")
        .sort_key_name("sort_key")
        .attribute_actions_on_encrypt(attribute_actions_on_encrypt.clone())
        .keyring(mrk_keyring_with_client_supplier)
        .allowed_unsigned_attribute_prefix(UNSIGNED_ATTR_PREFIX)
        .build()?;

    let table_configs = DynamoDbTablesEncryptionConfig::builder()
        .table_encryption_configs(HashMap::from([(ddb_table_name.to_string(), table_config)]))
        .build()?;

    // 5. Create a new AWS SDK DynamoDb client using the DynamoDb Config above
    let sdk_config = aws_config::load_defaults(aws_config::BehaviorVersion::latest()).await;
    let dynamo_config = aws_sdk_dynamodb::config::Builder::from(&sdk_config)
        .interceptor(DbEsdkInterceptor::new(table_configs)?)
        .build();
    let ddb = aws_sdk_dynamodb::Client::from_conf(dynamo_config);

    // 6. Put an item into our table using the above client.
    //    Before the item gets sent to DynamoDb, it will be encrypted
    //    client-side using the MRK multi-keyring.
    //    The data key protecting this item will be encrypted
    //    with all the KMS Keys in this keyring, so that it can be
    //    decrypted with any one of those KMS Keys.
    let item = HashMap::from([
        (
            "partition_key".to_string(),
            AttributeValue::S("clientSupplierItem".to_string()),
        ),
        ("sort_key".to_string(), AttributeValue::N("0".to_string())),
        (
            "sensitive_data".to_string(),
            AttributeValue::S("encrypt and sign me!".to_string()),
        ),
    ]);

    ddb.put_item()
        .table_name(ddb_table_name)
        .set_item(Some(item.clone()))
        .send()
        .await?;

    // 7. Get the item back from our table using the same keyring.
    //    The client will decrypt the item client-side using the MRK
    //    and return the original item.
    let key_to_get = HashMap::from([
        (
            "partition_key".to_string(),
            AttributeValue::S("clientSupplierItem".to_string()),
        ),
        ("sort_key".to_string(), AttributeValue::N("0".to_string())),
    ]);

    let resp = ddb
        .get_item()
        .table_name(ddb_table_name)
        .set_key(Some(key_to_get.clone()))
        .consistent_read(true)
        .send()
        .await?;

    assert_eq!(
        resp.item.unwrap()["sensitive_data"],
        AttributeValue::S("encrypt and sign me!".to_string())
    );

    // 8. Create a MRK discovery multi-keyring with a custom client supplier.
    //    A discovery MRK multi-keyring will be composed of
    //    multiple discovery MRK keyrings, one for each region.
    //    Each component keyring has its own KMS client in a particular region.
    //    When we provide a client supplier to the multi-keyring, all component
    //    keyrings will use that client supplier configuration.
    //    In our tests, we make `key_arn` an MRK with a replica, and
    //    provide only the replica region in our discovery filter.
    let discovery_filter = DiscoveryFilter::builder()
        .partition("aws")
        .account_ids(account_ids)
        .build()?;

    let mrk_discovery_client_supplier_keyring = mpl
        .create_aws_kms_mrk_discovery_multi_keyring()
        .client_supplier(RegionalRoleClientSupplier {})
        .discovery_filter(discovery_filter)
        .regions(regions)
        .send()
        .await?;

    // 9. Create a new config and client using the discovery keyring.
    //     This is the same setup as above, except we provide the discovery keyring to the config.
    let only_replica_table_config = DynamoDbTableEncryptionConfig::builder()
        .logical_table_name(ddb_table_name)
        .partition_key_name("partition_key")
        .sort_key_name("sort_key")
        .attribute_actions_on_encrypt(attribute_actions_on_encrypt)
        .keyring(mrk_discovery_client_supplier_keyring)
        .allowed_unsigned_attribute_prefix(UNSIGNED_ATTR_PREFIX)
        .build()?;

    let only_replica_table_configs = DynamoDbTablesEncryptionConfig::builder()
        .table_encryption_configs(HashMap::from([(
            ddb_table_name.to_string(),
            only_replica_table_config,
        )]))
        .build()?;

    let only_replica_dynamo_config = aws_sdk_dynamodb::config::Builder::from(&sdk_config)
        .interceptor(DbEsdkInterceptor::new(only_replica_table_configs)?)
        .build();
    let only_replica_ddb = aws_sdk_dynamodb::Client::from_conf(only_replica_dynamo_config);

    // 10. Get the item back from our table using the discovery keyring client.
    //     The client will decrypt the item client-side using the keyring,
    //     and return the original item.
    //     The discovery keyring will only use KMS keys in the provided regions and
    //     AWS accounts. Since we have provided it with a custom client supplier
    //     which uses different IAM roles based on the key region,
    //     the discovery keyring will use a particular IAM role to decrypt
    //     based on the region of the KMS key it uses to decrypt.

    let resp = only_replica_ddb
        .get_item()
        .table_name(ddb_table_name)
        .set_key(Some(key_to_get))
        .consistent_read(true)
        .send()
        .await?;

    assert_eq!(
        resp.item.unwrap()["sensitive_data"],
        AttributeValue::S("encrypt and sign me!".to_string())
    );

    println!("client_supplier_example successful.");
    Ok(())
}
