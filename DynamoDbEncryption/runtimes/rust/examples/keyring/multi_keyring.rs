// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

use crate::test_utils;
use aws_db_esdk::dynamodb::types::DynamoDbTableEncryptionConfig;
use aws_db_esdk::intercept::DbEsdkInterceptor;
use aws_db_esdk::material_providers::client as mpl_client;
use aws_db_esdk::material_providers::types::material_providers_config::MaterialProvidersConfig;
use aws_db_esdk::material_providers::types::AesWrappingAlg;
use aws_db_esdk::CryptoAction;
use aws_db_esdk::DynamoDbTablesEncryptionConfig;
use aws_sdk_dynamodb::types::AttributeValue;
use std::collections::HashMap;

/*
 This example sets up DynamoDb Encryption for the AWS SDK client
 using the multi-keyring. This keyring takes in multiple keyrings
 and uses them to encrypt and decrypt data. Data encrypted with
 a multi-keyring can be decrypted with any of its component keyrings.

 For more information on multi-keyrings, see
 https://docs.aws.amazon.com/encryption-sdk/latest/developer-guide/use-multi-keyring.html

 This example creates a new multi-keyring consisting of an AWS KMS
 keyring (labeled the "generator keyring") and a raw AES keyring
 (labeled as the only "child keyring"). It encrypts a test item
 using the multi-keyring and puts the encrypted item to the provided
 DynamoDb table. Then, it gets the item from the table and decrypts it
 using only the raw AES keyring.

 This example takes in an `aesKeyBytes` parameter. This parameter
 should be a ByteBuffer representing a 256-bit AES key. If this example
 is run through the class' main method, it will create a new key.
 In practice, users of this library should not randomly generate a key,
 and should instead retrieve an existing key from a secure key
 management system (e.g. an HSM).

 Running this example requires access to the DDB Table whose name
 is provided in CLI arguments.
 This table must be configured with the following
 primary key configuration:
   - Partition key is named "partition_key" with type (S)
   - Sort key is named "sort_key" with type (S)
*/

pub async fn put_item_get_item() -> Result<(), crate::BoxError> {
    let ddb_table_name = test_utils::TEST_DDB_TABLE_NAME;
    let key_arn = test_utils::TEST_KMS_KEY_ID;
    let aes_key_bytes = generate_aes_key_bytes();

    // 1. Create the raw AES keyring.
    let mpl_config = MaterialProvidersConfig::builder().build()?;
    let mpl = mpl_client::Client::from_conf(mpl_config)?;
    let raw_aes_keyring = mpl
        .create_raw_aes_keyring()
        .key_name("my-aes-key-name")
        .key_namespace("my-key-namespace")
        .wrapping_key(aes_key_bytes)
        .wrapping_alg(AesWrappingAlg::AlgAes256GcmIv12Tag16)
        .send()
        .await?;

    // 2. Create the AWS KMS keyring.
    //    We create a MRK multi keyring, as this interface also supports
    //    single-region KMS keys (standard KMS keys),
    //    and creates the KMS client for us automatically.
    let aws_kms_mrk_multi_keyring = mpl
        .create_aws_kms_mrk_multi_keyring()
        .generator(key_arn)
        .send()
        .await?;

    // 3. Create the multi-keyring.
    //    We will label the AWS KMS keyring as the generator and the raw AES keyring as the
    //        only child keyring.
    //    You must provide a generator keyring to encrypt data.
    //    You may provide additional child keyrings. Each child keyring will be able to
    //        decrypt data encrypted with the multi-keyring on its own. It does not need
    //        knowledge of any other child keyrings or the generator keyring to decrypt.

    let multi_keyring = mpl
        .create_multi_keyring()
        .generator(aws_kms_mrk_multi_keyring)
        .child_keyrings(vec![raw_aes_keyring.clone()])
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
        ("sensitive_data".to_string(), CryptoAction::EncryptAndSign),
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
    //    Note that this example creates one config/client combination for PUT, and another
    //        for GET. The PUT config uses the multi-keyring, while the GET config uses the
    //        raw AES keyring. This is solely done to demonstrate that a keyring included as
    //        a child of a multi-keyring can be used to decrypt data on its own.
    let table_config = DynamoDbTableEncryptionConfig::builder()
        .logical_table_name(ddb_table_name)
        .partition_key_name("partition_key")
        .sort_key_name("sort_key")
        .attribute_actions_on_encrypt(attribute_actions_on_encrypt.clone())
        .keyring(multi_keyring)
        .allowed_unsigned_attribute_prefix(UNSIGNED_ATTR_PREFIX)
        .build()?;

    let table_configs = DynamoDbTablesEncryptionConfig::builder()
        .table_encryption_configs(HashMap::from([(ddb_table_name.to_string(), table_config)]))
        .build()?;

    // 7. Create a new AWS SDK DynamoDb client using the config above
    let sdk_config = aws_config::load_defaults(aws_config::BehaviorVersion::latest()).await;
    let dynamo_config = aws_sdk_dynamodb::config::Builder::from(&sdk_config)
        .interceptor(DbEsdkInterceptor::new(table_configs)?)
        .build();
    let ddb = aws_sdk_dynamodb::Client::from_conf(dynamo_config);

    // 8. Put an item into our table using the above client.
    //    Before the item gets sent to DynamoDb, it will be encrypted
    //    client-side using the multi-keyring.
    //    The item will be encrypted with all wrapping keys in the keyring,
    //    so that it can be decrypted with any one of the keys.
    let item = HashMap::from([
        (
            "partition_key".to_string(),
            AttributeValue::S("multiKeyringItem".to_string()),
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

    // 9. Get the item back from our table using the above client.
    //     The client will decrypt the item client-side using the AWS KMS
    //     keyring, and return back the original item.
    //     Since the generator key is the first available key in the keyring,
    //     that is the key that will be used to decrypt this item.
    let key_to_get = HashMap::from([
        (
            "partition_key".to_string(),
            AttributeValue::S("multiKeyringItem".to_string()),
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

    // 10. Create a new config and client with only the raw AES keyring to GET the item
    //     This is the same setup as above, except the config uses the `rawAesKeyring`.
    let only_aes_table_config = DynamoDbTableEncryptionConfig::builder()
        .logical_table_name(ddb_table_name)
        .partition_key_name("partition_key")
        .sort_key_name("sort_key")
        .attribute_actions_on_encrypt(attribute_actions_on_encrypt)
        .keyring(raw_aes_keyring)
        .allowed_unsigned_attribute_prefix(UNSIGNED_ATTR_PREFIX)
        .build()?;

    let only_aes_table_configs = DynamoDbTablesEncryptionConfig::builder()
        .table_encryption_configs(HashMap::from([(
            ddb_table_name.to_string(),
            only_aes_table_config,
        )]))
        .build()?;

    let only_aes_dynamo_config = aws_sdk_dynamodb::config::Builder::from(&sdk_config)
        .interceptor(DbEsdkInterceptor::new(only_aes_table_configs)?)
        .build();
    let only_aes_ddb = aws_sdk_dynamodb::Client::from_conf(only_aes_dynamo_config);

    // 11. Get the item back from our table using the client
    //     configured with only the raw AES keyring.
    //     The client will decrypt the item client-side using the raw
    //     AES keyring, and return back the original item.
    let resp = only_aes_ddb
        .get_item()
        .table_name(ddb_table_name)
        .set_key(Some(key_to_get.clone()))
        .consistent_read(true)
        .send()
        .await?;

    assert_eq!(resp.item, Some(item.clone()));

    println!("multi_keyring successful.");
    Ok(())
}

fn generate_aes_key_bytes() -> Vec<u8> {
    // This example returns a static key.
    // In practice, you should not generate this key in your code, and should instead
    //     retrieve this key from a secure key management system (e.g. HSM).
    // This key is created here for example purposes only and should not be used for any other purpose.
    vec![
        1u8, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24,
        25, 26, 27, 28, 29, 30, 31, 32,
    ]
}
