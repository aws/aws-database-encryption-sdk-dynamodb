// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

use crate::test_utils;
use aws_sdk_dynamodb::types::AttributeValue;
use std::collections::HashMap;

use aws_db_esdk::material_providers::client as mpl_client;
use aws_db_esdk::material_providers::types::material_providers_config::MaterialProvidersConfig;
use aws_db_esdk::CryptoAction;

use aws_db_esdk::item_encryptor::client as enc_client;
use aws_db_esdk::item_encryptor::types::dynamo_db_item_encryptor_config::DynamoDbItemEncryptorConfig;
use aws_db_esdk::material_providers::types::DbeAlgorithmSuiteId;

/*
 This example sets up a DynamoDb Item Encryptor and uses
 the EncryptItem and DecryptItem APIs to directly encrypt and
 decrypt an existing DynamoDb item.
 You should use the DynamoDb Item Encryptor
 if you already have a DynamoDb Item to encrypt or decrypt,
 and do not need to make a Put or Get call to DynamoDb.
 For example, if you are using DynamoDb Streams,
 you may already be working with an encrypted item obtained from
 DynamoDb, and want to directly decrypt the item.

 Running this example requires access to the DDB Table whose name
 is provided in CLI arguments.
 This table must be configured with the following
 primary key configuration:
   - Partition key is named "partition_key" with type (S)
   - Sort key is named "sort_key" with type (S)
*/
pub async fn encrypt_decrypt() -> Result<(), crate::BoxError> {
    let kms_key_id = test_utils::TEST_KMS_KEY_ID;
    let ddb_table_name = test_utils::TEST_DDB_TABLE_NAME;

    // 1. Create a Keyring. This Keyring will be responsible for protecting the data keys that protect your data.
    //    For this example, we will create a AWS KMS Keyring with the AWS KMS Key we want to use.
    //    We will use the `CreateMrkMultiKeyring` method to create this keyring,
    //    as it will correctly handle both single region and Multi-Region KMS Keys.
    let provider_config = MaterialProvidersConfig::builder().build()?;
    let mat_prov = mpl_client::Client::from_conf(provider_config)?;
    let kms_keyring = mat_prov
        .create_aws_kms_mrk_multi_keyring()
        .generator(kms_key_id)
        .send()
        .await?;

    // 2. Configure which attributes are encrypted and/or signed when writing new items.
    //    For each attribute that may exist on the items we plan to write to our DynamoDbTable,
    //    we must explicitly configure how they should be treated during item encryption:
    //      - ENCRYPT_AND_SIGN: The attribute is encrypted and included in the signature
    //      - SIGN_ONLY: The attribute not encrypted, but is still included in the signature
    //      - DO_NOTHING: The attribute is not encrypted and not included in the signature
    let attribute_actions_on_encrypt = HashMap::from([
        ("partition_key".to_string(), CryptoAction::SignOnly),
        ("sort_key".to_string(), CryptoAction::SignOnly),
        ("attribute1".to_string(), CryptoAction::EncryptAndSign),
        ("attribute2".to_string(), CryptoAction::SignOnly),
        (":attribute3".to_string(), CryptoAction::DoNothing),
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
    //   For this example, we have designed our DynamoDb table such that any attribute name with
    //   the ":" prefix should be considered unauthenticated.
    const UNSIGNED_ATTR_PREFIX: &str = ":";

    // 4. Create the configuration for the DynamoDb Item Encryptor
    let config = DynamoDbItemEncryptorConfig::builder()
        .logical_table_name(ddb_table_name)
        .partition_key_name("partition_key")
        .sort_key_name("sort_key")
        .attribute_actions_on_encrypt(attribute_actions_on_encrypt)
        .keyring(kms_keyring)
        .allowed_unsigned_attribute_prefix(UNSIGNED_ATTR_PREFIX)
        // Specifying an algorithm suite is not required,
        // but is done here to demonstrate how to do so.
        // We suggest using the
        // `ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_ECDSA_P384_SYMSIG_HMAC_SHA384` suite,
        // which includes AES-GCM with key derivation, signing, and key commitment.
        // This is also the default algorithm suite if one is not specified in this config.
        // For more information on supported algorithm suites, see:
        //   https://docs.aws.amazon.com/database-encryption-sdk/latest/devguide/supported-algorithms.html
        .algorithm_suite_id(
            DbeAlgorithmSuiteId::AlgAes256GcmHkdfSha512CommitKeyEcdsaP384SymsigHmacSha384,
        )
        .build()?;

    // 5. Create the DynamoDb Item Encryptor
    let item_encryptor = enc_client::Client::from_conf(config)?;

    // 6. Directly encrypt a DynamoDb item using the DynamoDb Item Encryptor
    let original_item = HashMap::from([
        (
            "partition_key".to_string(),
            AttributeValue::S("ItemEncryptDecryptExample".to_string()),
        ),
        ("sort_key".to_string(), AttributeValue::N("0".to_string())),
        (
            "attribute1".to_string(),
            AttributeValue::S("encrypt and sign me!".to_string()),
        ),
        (
            "attribute2".to_string(),
            AttributeValue::S("sign me!".to_string()),
        ),
        (
            ":attribute3".to_string(),
            AttributeValue::S("ignore me!".to_string()),
        ),
    ]);

    let encrypted_item = item_encryptor
        .encrypt_item()
        .plaintext_item(original_item.clone())
        .send()
        .await?
        .encrypted_item
        .unwrap();

    // Demonstrate that the item has been encrypted
    assert_eq!(
        encrypted_item["partition_key"],
        AttributeValue::S("ItemEncryptDecryptExample".to_string())
    );
    assert_eq!(
        encrypted_item["sort_key"],
        AttributeValue::N("0".to_string())
    );
    assert!(encrypted_item["attribute1"].is_b());
    assert!(!encrypted_item["attribute1"].is_s());

    // 7. Directly decrypt the encrypted item using the DynamoDb Item Encryptor
    let decrypted_item = item_encryptor
        .decrypt_item()
        .encrypted_item(encrypted_item)
        .send()
        .await?
        .plaintext_item
        .unwrap();

    // Demonstrate that GetItem succeeded and returned the decrypted item
    assert_eq!(decrypted_item, original_item);
    println!("encrypt_decrypt successful.");
    Ok(())
}
