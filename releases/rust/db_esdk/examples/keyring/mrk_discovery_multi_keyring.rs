// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

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
 This example sets up a MRK discovery multi-keyring to decrypt data using
 the DynamoDB encryption client. A discovery keyring is not provided with any wrapping
 keys; instead, it recognizes the KMS key that was used to encrypt a data key,
 and asks KMS to decrypt with that KMS key. Discovery keyrings cannot be used
 to encrypt data.

 For more information on discovery keyrings, see
 https://docs.aws.amazon.com/encryption-sdk/latest/developer-guide/use-kms-keyring.html#kms-keyring-discovery

 This example encrypts an item using an MRK multi-keyring and puts the
 encrypted item to the configured DynamoDb table. Then, it gets the item
 from the table and decrypts it using the discovery keyring.

 Running this example requires access to the DDB Table whose name
 is provided in CLI arguments.
 This table must be configured with the following
 primary key configuration:
   - Partition key is named "partition_key" with type (S)
   - Sort key is named "sort_key" with type (S)
*/

pub async fn put_item_get_item() -> Result<(), crate::BoxError> {
    let ddb_table_name = test_utils::TEST_DDB_TABLE_NAME;
    let key_arn = test_utils::TEST_MRK_KEY_ID;
    let account_ids = vec![test_utils::TEST_AWS_ACCOUNT_ID.to_string()];
    let regions = vec![test_utils::TEST_AWS_REGION.to_string()];

    // 1. Create a single MRK multi-keyring using the key arn.
    //    Although this example demonstrates use of the MRK discovery multi-keyring,
    //    a discovery keyring cannot be used to encrypt. So we will need to construct
    //    a non-discovery keyring for this example to encrypt. For more information on MRK
    //    multi-keyrings, see the MultiMrkKeyringExample in this directory.
    //    Though this is an "MRK multi-keyring", we do not need to provide multiple keys,
    //    and can use single-region KMS keys. We will provide a single key here; this
    //    can be either an MRK or a single-region key.
    let mpl_config = MaterialProvidersConfig::builder().build()?;
    let mpl = mpl_client::Client::from_conf(mpl_config)?;
    let encrypt_keyring = mpl
        .create_aws_kms_mrk_multi_keyring()
        .generator(key_arn)
        .send()
        .await?;

    // 2. Configure which attributes are encrypted and/or signed when writing new items.
    //    For each attribute that may exist on the items we plan to write to our DynamoDbTable,
    //    we must explicitly configure how they should be treated during item encryption:
    //      - ENCRYPT_AND_SIGN: The attribute is encrypted and icncluded in the signature
    //      - SIGN_ONLY: The attribute not encrypted, but is still included in the signature
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
        .keyring(encrypt_keyring)
        .allowed_unsigned_attribute_prefix(UNSIGNED_ATTR_PREFIX)
        .build()?;

    let table_configs = DynamoDbTablesEncryptionConfig::builder()
        .table_encryption_configs(HashMap::from([(ddb_table_name.to_string(), table_config)]))
        .build()?;

    // 5. Create a new AWS SDK DynamoDb client using the config above
    let sdk_config = aws_config::load_defaults(aws_config::BehaviorVersion::latest()).await;
    let dynamo_config = aws_sdk_dynamodb::config::Builder::from(&sdk_config)
        .interceptor(DbEsdkInterceptor::new(table_configs)?)
        .build();
    let ddb = aws_sdk_dynamodb::Client::from_conf(dynamo_config);

    // 6. Put an item into our table using the above client.
    //    Before the item gets sent to DynamoDb, it will be encrypted
    //    client-side using the MRK multi-keyring.
    let item = HashMap::from([
        (
            "partition_key".to_string(),
            AttributeValue::S("awsKmsMrkDiscoveryMultiKeyringItem".to_string()),
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

    // 7. Construct a discovery filter.
    //    A discovery filter limits the set of encrypted data keys
    //    the keyring can use to decrypt data.
    //    We will only let the keyring use keys in the selected AWS accounts
    //    and in the `aws` partition.
    //    This is the suggested config for most users; for more detailed config, see
    //      https://docs.aws.amazon.com/encryption-sdk/latest/developer-guide/use-kms-keyring.html#kms-keyring-discovery
    let discovery_filter = DiscoveryFilter::builder()
        .partition("aws")
        .account_ids(account_ids)
        .build()?;

    // 8. Construct a discovery keyring.
    //    Note that we choose to use the MRK discovery multi-keyring, even though
    //    our original keyring used a single KMS key.

    let decrypt_keyring = mpl
        .create_aws_kms_mrk_discovery_multi_keyring()
        .discovery_filter(discovery_filter)
        .regions(regions)
        .send()
        .await?;

    // 9. Create new DDB config and client using the decrypt discovery keyring.
    //     This is the same as the above config, except we pass in the decrypt keyring.
    let table_config_for_decrypt = DynamoDbTableEncryptionConfig::builder()
        .logical_table_name(ddb_table_name)
        .partition_key_name("partition_key")
        .sort_key_name("sort_key")
        .attribute_actions_on_encrypt(attribute_actions_on_encrypt)
        .keyring(decrypt_keyring)
        .allowed_unsigned_attribute_prefix(UNSIGNED_ATTR_PREFIX)
        .build()?;

    let table_configs_for_decrypt = DynamoDbTablesEncryptionConfig::builder()
        .table_encryption_configs(HashMap::from([(
            ddb_table_name.to_string(),
            table_config_for_decrypt,
        )]))
        .build()?;

    let dynamo_config_for_decrypt = aws_sdk_dynamodb::config::Builder::from(&sdk_config)
        .interceptor(DbEsdkInterceptor::new(table_configs_for_decrypt)?)
        .build();
    let ddb_for_decrypt = aws_sdk_dynamodb::Client::from_conf(dynamo_config_for_decrypt);

    // 10. Get the item back from our table using the client.
    //     The client will retrieve encrypted items from the DDB table, then
    //     detect the KMS key that was used to encrypt their data keys.
    //     The client will make a request to KMS to decrypt with the encrypting KMS key.
    //     If the client has permission to decrypt with the KMS key,
    //     the client will decrypt the item client-side using the keyring
    //     and return the original item.
    let key_to_get = HashMap::from([
        (
            "partition_key".to_string(),
            AttributeValue::S("awsKmsMrkDiscoveryMultiKeyringItem".to_string()),
        ),
        ("sort_key".to_string(), AttributeValue::N("0".to_string())),
    ]);

    let resp = ddb_for_decrypt
        .get_item()
        .table_name(ddb_table_name)
        .set_key(Some(key_to_get))
        .consistent_read(true)
        .send()
        .await?;

    assert_eq!(resp.item, Some(item));

    println!("mrk_discovery_multi_keyring successful.");
    Ok(())
}
