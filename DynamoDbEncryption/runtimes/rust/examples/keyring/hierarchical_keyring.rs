// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

use super::branch_key_id_supplier::ExampleBranchKeyIdSupplier;
use crate::test_utils;
use aws_db_esdk::dynamodb::client as dbesdk_client;
use aws_db_esdk::dynamodb::types::dynamo_db_encryption_config::DynamoDbEncryptionConfig;
use aws_db_esdk::dynamodb::types::DynamoDbTableEncryptionConfig;
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
 This example sets up DynamoDb Encryption for the AWS SDK client
 using the Hierarchical Keyring, which establishes a key hierarchy
 where "branch" keys are persisted in DynamoDb.
 These branch keys are used to protect your data keys,
 and these branch keys are themselves protected by a root KMS Key.

 Establishing a key hierarchy like this has two benefits:

 First, by caching the branch key material, and only calling back
 to KMS to re-establish authentication regularly according to your configured TTL,
 you limit how often you need to call back to KMS to protect your data.
 This is a performance/security tradeoff, where your authentication, audit, and
 logging from KMS is no longer one-to-one with every encrypt or decrypt call.
 However, the benefit is that you no longer have to make a
 network call to KMS for every encrypt or decrypt.

 Second, this key hierarchy makes it easy to hold multi-tenant data
 that is isolated per branch key in a single DynamoDb table.
 You can create a branch key for each tenant in your table,
 and encrypt all that tenant's data under that distinct branch key.
 On decrypt, you can either statically configure a single branch key
 to ensure you are restricting decryption to a single tenant,
 or you can implement an interface that lets you map the primary key on your items
 to the branch key that should be responsible for decrypting that data.

 This example then demonstrates configuring a Hierarchical Keyring
 with a Branch Key ID Supplier to encrypt and decrypt data for
 two separate tenants.

 Running this example requires access to the DDB Table whose name
 is provided in CLI arguments.
 This table must be configured with the following
 primary key configuration:
   - Partition key is named "partition_key" with type (S)
   - Sort key is named "sort_key" with type (S)

 This example also requires using a KMS Key whose ARN
 is provided in CLI arguments. You need the following access
 on this key:
   - GenerateDataKeyWithoutPlaintext
   - Decrypt
*/
pub async fn put_item_get_item(
    tenant1_branch_key_id: &str,
    tenant2_branch_key_id: &str,
) -> Result<(), crate::BoxError> {
    let ddb_table_name = test_utils::TEST_DDB_TABLE_NAME;

    let keystore_table_name = test_utils::TEST_KEYSTORE_NAME;
    let logical_keystore_name = test_utils::TEST_LOGICAL_KEYSTORE_NAME;
    let kms_key_id = test_utils::TEST_KEYSTORE_KMS_KEY_ID;

    // Initial KeyStore Setup: This example requires that you have already
    // created your KeyStore, and have populated it with two new branch keys.
    // See the "Create KeyStore Table Example" and "Create KeyStore Key Example"
    // for an example of how to do this.

    // 1. Configure your KeyStore resource.
    //    This SHOULD be the same configuration that you used
    //    to initially create and populate your KeyStore.
    let sdk_config = aws_config::load_defaults(aws_config::BehaviorVersion::latest()).await;
    let key_store_config = KeyStoreConfig::builder()
        .kms_client(aws_sdk_kms::Client::new(&sdk_config))
        .ddb_client(aws_sdk_dynamodb::Client::new(&sdk_config))
        .ddb_table_name(keystore_table_name)
        .logical_key_store_name(logical_keystore_name)
        .kms_configuration(KmsConfiguration::KmsKeyArn(kms_key_id.to_string()))
        .build()?;

    let key_store = keystore_client::Client::from_conf(key_store_config)?;

    // 2. Create a Branch Key ID Supplier. See ExampleBranchKeyIdSupplier in this directory.
    let dbesdk_config = DynamoDbEncryptionConfig::builder().build()?;
    let dbesdk = dbesdk_client::Client::from_conf(dbesdk_config)?;
    let supplier = ExampleBranchKeyIdSupplier::new(tenant1_branch_key_id, tenant2_branch_key_id);

    let branch_key_id_supplier = dbesdk
        .create_dynamo_db_encryption_branch_key_id_supplier()
        .ddb_key_branch_key_id_supplier(supplier)
        .send()
        .await?
        .branch_key_id_supplier
        .unwrap();

    // 3. Create the Hierarchical Keyring, using the Branch Key ID Supplier above.
    //    With this configuration, the AWS SDK Client ultimately configured will be capable
    //    of encrypting or decrypting items for either tenant (assuming correct KMS access).
    //    If you want to restrict the client to only encrypt or decrypt for a single tenant,
    //    configure this Hierarchical Keyring using `.branchKeyId(tenant1BranchKeyId)` instead
    //    of `.branchKeyIdSupplier(branchKeyIdSupplier)`.
    let mpl_config = MaterialProvidersConfig::builder().build()?;
    let mpl = mpl_client::Client::from_conf(mpl_config)?;

    let hierarchical_keyring = mpl
        .create_aws_kms_hierarchical_keyring()
        .branch_key_id_supplier(branch_key_id_supplier)
        .key_store(key_store)
        .ttl_seconds(600)
        .send()
        .await?;

    // 4. Configure which attributes are encrypted and/or signed when writing new items.
    //    For each attribute that may exist on the items we plan to write to our DynamoDbTable,
    //    we must explicitly configure how they should be treated during item encryption:
    //      - ENCRYPT_AND_SIGN: The attribute is encrypted and included in the signature
    //      - SIGN_ONLY: The attribute not encrypted, but is still included in the signature
    //      - DO_NOTHING: The attribute is not encrypted and not included in the signature
    let attribute_actions_on_encrypt = HashMap::from([
        ("partition_key".to_string(), CryptoAction::SignOnly), // Our partition attribute must be SIGN_ONLY
        ("sort_key".to_string(), CryptoAction::SignOnly), // Our sort attribute must be SIGN_ONLY
        (
            "tenant_sensitive_data".to_string(),
            CryptoAction::EncryptAndSign,
        ),
    ]);

    // 5. Configure which attributes we expect to be included in the signature
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

    // 6. Create the DynamoDb Encryption configuration for the table we will be writing to.
    let table_config = DynamoDbTableEncryptionConfig::builder()
        .logical_table_name(ddb_table_name)
        .partition_key_name("partition_key")
        .sort_key_name("sort_key")
        .attribute_actions_on_encrypt(attribute_actions_on_encrypt)
        .keyring(hierarchical_keyring)
        .allowed_unsigned_attribute_prefix(UNSIGNED_ATTR_PREFIX)
        .build()?;

    let table_configs = DynamoDbTablesEncryptionConfig::builder()
        .table_encryption_configs(HashMap::from([(ddb_table_name.to_string(), table_config)]))
        .build()?;

    // 7. Create a new AWS SDK DynamoDb client using the DynamoDb Encryption Interceptor above
    let sdk_config = aws_config::load_defaults(aws_config::BehaviorVersion::latest()).await;
    let dynamo_config = aws_sdk_dynamodb::config::Builder::from(&sdk_config)
        .interceptor(DbEsdkInterceptor::new(table_configs)?)
        .build();
    let ddb = aws_sdk_dynamodb::Client::from_conf(dynamo_config);

    // 8. Put an item into our table using the above client.
    //    Before the item gets sent to DynamoDb, it will be encrypted
    //    client-side, according to our configuration.
    //    Because the item we are writing uses "tenantId1" as our partition value,
    //    based on the code we wrote in the ExampleBranchKeySupplier,
    //    `tenant1BranchKeyId` will be used to encrypt this item.
    let item = HashMap::from([
        (
            "partition_key".to_string(),
            AttributeValue::S("tenant1Id".to_string()),
        ),
        ("sort_key".to_string(), AttributeValue::N("0".to_string())),
        (
            "tenant_sensitive_data".to_string(),
            AttributeValue::S("encrypt and sign me!".to_string()),
        ),
    ]);

    ddb.put_item()
        .table_name(ddb_table_name)
        .set_item(Some(item.clone()))
        .send()
        .await?;

    // 9. Get the item back from our table using the same client.
    //     The client will decrypt the item client-side, and return
    //     back the original item.
    //     Because the returned item's partition value is "tenantId1",
    //     based on the code we wrote in the ExampleBranchKeySupplier,
    //     `tenant1BranchKeyId` will be used to decrypt this item.
    let key_to_get = HashMap::from([
        (
            "partition_key".to_string(),
            AttributeValue::S("tenant1Id".to_string()),
        ),
        ("sort_key".to_string(), AttributeValue::N("0".to_string())),
    ]);

    let resp = ddb
        .get_item()
        .table_name(ddb_table_name)
        .set_key(Some(key_to_get))
        .consistent_read(true)
        .send()
        .await?;

    assert_eq!(resp.item, Some(item));
    println!("hierarchical_keyring successful.");
    Ok(())
}
