// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

use crate::test_utils;
use aws_db_esdk::dynamodb::types::DynamoDbTableEncryptionConfig;
use aws_db_esdk::intercept::DbEsdkInterceptor;
use aws_db_esdk::material_providers::client as mpl_client;
use aws_db_esdk::material_providers::types::material_providers_config::MaterialProvidersConfig;
use aws_db_esdk::CryptoAction;
use aws_db_esdk::DynamoDbTablesEncryptionConfig;
use aws_sdk_dynamodb::types::AttributeValue;
use std::collections::HashMap;

/*
 This example sets up DynamoDb Encryption for the AWS SDK client
 using the MRK multi-keyring. This keyring takes in multiple AWS KMS
 MRKs (multi-region keys) or regular AWS KMS keys (single-region keys)
 and uses them to encrypt and decrypt data. Data encrypted using an MRK
 multi-keyring can be decrypted using any of its component keys. If a component
 key is an MRK with a replica in a second region, the replica key can also be
 used to decrypt data.

 For more information on MRKs, see
 https://docs.aws.amazon.com/kms/latest/developerguide/multi-region-keys-overview.html

 For more information on multi-keyrings, see
 https://docs.aws.amazon.com/encryption-sdk/latest/developer-guide/use-multi-keyring.html

 This example creates a new MRK multi-keyring consisting of one MRK
 (labeled as the "generator keyring") and one single-region key (labeled
  as the only "child keyring"). The MRK also has a replica in a second region.

 This example encrypts a test item using the MRK multi-keyring and puts the
 encrypted item to the provided DynamoDb table. Then, it gets the item
 from the table and decrypts it using three different configs:
   1. The MRK multi-keyring, where the MRK key is used to decrypt
   2. Another MRK multi-keyring, where the replica MRK key is used to decrypt
   3. Another MRK multi-keyring, where the single-region key that was present
      in the original MRK multi-keyring is used to decrypt

 Running this example requires access to the DDB Table whose name
 is provided in CLI arguments.
 This table must be configured with the following
 primary key configuration:
   - Partition key is named "partition_key" with type (S)
   - Sort key is named "sort_key" with type (S)

 This example demonstrates multi-region use cases. As a result,
 it requires that you have a default region set in your AWS client.
 You can set a default region through the AWS CLI with
 `aws configure set region [region-name]`
 e.g.
 `aws configure set region us-west-2`
 For more information on using AWS CLI to set config, see
 https://awscli.amazonaws.com/v2/documentation/api/latest/reference/configure/set.html
*/
pub async fn put_item_get_item() -> Result<(), crate::BoxError> {
    let ddb_table_name = test_utils::TEST_DDB_TABLE_NAME;
    let mrk_key_arn = test_utils::TEST_MRK_KEY_ID;
    let key_arn = test_utils::TEST_KMS_KEY_ID;
    let mrk_replica_key_arn = test_utils::TEST_MRK_REPLICA_KEY_ID_US_EAST_1;

    // 1. Create a single MRK multi-keyring using the MRK arn and the single-region key arn.
    let mpl_config = MaterialProvidersConfig::builder().build()?;
    let mpl = mpl_client::Client::from_conf(mpl_config)?;
    // Create the multi-keyring, using the MRK as the generator key,
    //   and the single-region key as a child key.
    // Note that the generator key will generate and encrypt a plaintext data key
    //   and all child keys will only encrypt that same plaintext data key.
    // As such, you must have permission to call KMS:GenerateDataKey on your generator key
    //   and permission to call KMS:Encrypt on all child keys.
    // For more information, see the AWS docs on multi-keyrings above.
    let aws_kms_mrk_multi_keyring = mpl
        .create_aws_kms_mrk_multi_keyring()
        .generator(mrk_key_arn)
        .kms_key_ids(vec![key_arn.to_string()])
        .send()
        .await?;

    // 2. Configure which attributes are encrypted and/or signed when writing new items.
    //    For each attribute that may exist on the items we plan to write to our DynamoDbTable,
    //    we must explicitly configure how they should be treated during item encryption:
    //      - ENCRYPT_AND_SIGN: The attribute is encrypted and included in the signature
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
        .keyring(aws_kms_mrk_multi_keyring)
        .allowed_unsigned_attribute_prefix(UNSIGNED_ATTR_PREFIX)
        .build()?;

    let table_configs = DynamoDbTablesEncryptionConfig::builder()
        .table_encryption_configs(HashMap::from([(ddb_table_name.to_string(), table_config)]))
        .build()?;

    // 5. Create the DynamoDb Encryption Interceptor
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
            AttributeValue::S("awsKmsMrkMultiKeyringItem".to_string()),
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

    // 7. Get the item back from our table using the client.
    //    The client will decrypt the item client-side using the MRK
    //    and return back the original item.
    //    Since the generator key is the first available key in the keyring,
    //    that is the KMS Key that will be used to decrypt this item.
    let key_to_get = HashMap::from([
        (
            "partition_key".to_string(),
            AttributeValue::S("awsKmsMrkMultiKeyringItem".to_string()),
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

    assert_eq!(resp.item, Some(item.clone()));

    // 8. Create a MRK keyring using the replica MRK arn.
    //    We will use this to demonstrate that the replica MRK
    //    can decrypt data created with the original MRK,
    //    even when the replica MRK was not present in the
    //    encrypting multi-keyring.
    let only_replica_key_mrk_multi_keyring = mpl
        .create_aws_kms_mrk_multi_keyring()
        .kms_key_ids(vec![mrk_replica_key_arn.to_string()])
        .send()
        .await?;

    // 9. Create a new config and client using the MRK keyring.
    //     This is the same setup as above, except we provide the MRK keyring to the config.
    let only_replica_table_config = DynamoDbTableEncryptionConfig::builder()
        .logical_table_name(ddb_table_name)
        .partition_key_name("partition_key")
        .sort_key_name("sort_key")
        .attribute_actions_on_encrypt(attribute_actions_on_encrypt.clone())
        // Only replica keyring added here
        .keyring(only_replica_key_mrk_multi_keyring)
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

    // 10. Get the item back from our table using the client configured with the replica.
    //    The client will decrypt the item client-side using the replica MRK
    //    and return back the original item.

    let only_replica_resp = only_replica_ddb
        .get_item()
        .table_name(ddb_table_name)
        .set_key(Some(key_to_get.clone()))
        .consistent_read(true)
        .send()
        .await?;

    assert_eq!(only_replica_resp.item, Some(item.clone()));

    // 11. Create an AWS KMS keyring using the single-region key ARN.
    //     We will use this to demonstrate that the single-region key
    //     can decrypt data created with the MRK multi-keyring,
    //     since it is present in the keyring used to encrypt.
    let only_srk_key_mrk_multi_keyring = mpl
        .create_aws_kms_mrk_multi_keyring()
        .kms_key_ids(vec![key_arn.to_string()])
        .send()
        .await?;

    // 12. Create a new config and client using the AWS KMS keyring.
    //     This is the same setup as above, except we provide the AWS KMS keyring to the config.
    let only_srk_table_config = DynamoDbTableEncryptionConfig::builder()
        .logical_table_name(ddb_table_name)
        .partition_key_name("partition_key")
        .sort_key_name("sort_key")
        .attribute_actions_on_encrypt(attribute_actions_on_encrypt)
        // Only srk keyring added here
        .keyring(only_srk_key_mrk_multi_keyring)
        .allowed_unsigned_attribute_prefix(UNSIGNED_ATTR_PREFIX)
        .build()?;

    let only_srk_table_configs = DynamoDbTablesEncryptionConfig::builder()
        .table_encryption_configs(HashMap::from([(
            ddb_table_name.to_string(),
            only_srk_table_config,
        )]))
        .build()?;

    let only_srk_dynamo_config = aws_sdk_dynamodb::config::Builder::from(&sdk_config)
        .interceptor(DbEsdkInterceptor::new(only_srk_table_configs)?)
        .build();
    let only_srk_ddb = aws_sdk_dynamodb::Client::from_conf(only_srk_dynamo_config);

    // 13. Get the item back from our table using the client configured with the AWS KMS keyring.
    //     The client will decrypt the item client-side using the single-region key
    //     and return back the original item.

    let only_srk_resp = only_srk_ddb
        .get_item()
        .table_name(ddb_table_name)
        .set_key(Some(key_to_get))
        .consistent_read(true)
        .send()
        .await?;

    assert_eq!(only_srk_resp.item, Some(item));

    println!("multi_mrk_keyring successful.");
    Ok(())
}
