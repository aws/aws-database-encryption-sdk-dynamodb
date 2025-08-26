// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

use aws_db_esdk::material_providers::client;
use aws_db_esdk::material_providers::types::material_providers_config::MaterialProvidersConfig;
use aws_db_esdk::CryptoAction;
use aws_db_esdk::dynamodb::types::DynamoDbTableEncryptionConfig;
use aws_db_esdk::types::dynamo_db_tables_encryption_config::DynamoDbTablesEncryptionConfig;
use aws_db_esdk::dynamodb::types::PlaintextOverride;
use std::collections::HashMap;

pub async fn create_table_configs(
    kms_key_id: &str,
    ddb_table_name: &str,
    plaintext_override: PlaintextOverride,
) -> Result<DynamoDbTablesEncryptionConfig, Box<dyn std::error::Error>> {
    // Create a Keyring. This Keyring will be responsible for protecting the data keys that protect your data.
    // For this example, we will create a AWS KMS Keyring with the AWS KMS Key we want to use.
    // We will use the `CreateMrkMultiKeyring` method to create this keyring,
    // as it will correctly handle both single region and Multi-Region KMS Keys.
    let provider_config = MaterialProvidersConfig::builder().build()?;
    let mat_prov = client::Client::from_conf(provider_config)?;
    let kms_keyring = mat_prov
        .create_aws_kms_mrk_multi_keyring()
        .generator(kms_key_id)
        .send()
        .await?;

    // Configure which attributes are encrypted and/or signed when writing new items.
    // For each attribute that may exist on the items we plan to write to our DynamoDbTable,
    // we must explicitly configure how they should be treated during item encryption:
    //  - ENCRYPT_AND_SIGN: The attribute is encrypted and included in the signature
    //  - SIGN_ONLY: The attribute not encrypted, but is still included in the signature
    //  - DO_NOTHING: The attribute is not encrypted and not included in the signature
    let partition_key_name = "partition_key";
    let sort_key_name = "sort_key";
    let attribute_actions_on_encrypt = HashMap::from([
        (partition_key_name.to_string(), CryptoAction::SignOnly),
        (sort_key_name.to_string(), CryptoAction::SignOnly),
        ("attribute1".to_string(), CryptoAction::EncryptAndSign),
        ("attribute2".to_string(), CryptoAction::SignOnly),
        ("attribute3".to_string(), CryptoAction::DoNothing),
    ]);

    // Configure which attributes we expect to be excluded in the signature
    // when reading items. There are two options for configuring this:
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
    //   For this example, we will explicitly list the attributes that are not signed.
    let unsigned_attributes = vec!["attribute3".to_string()];

    // Create the DynamoDb Encryption configuration for the table we will be writing to.
    let table_config = DynamoDbTableEncryptionConfig::builder()
        .logical_table_name(ddb_table_name)
        .partition_key_name(partition_key_name)
        .sort_key_name(sort_key_name)
        .attribute_actions_on_encrypt(attribute_actions_on_encrypt)
        .keyring(kms_keyring)
        .allowed_unsigned_attributes(unsigned_attributes)
        .plaintext_override(plaintext_override)
        .build()?;

    let table_configs = DynamoDbTablesEncryptionConfig::builder()
        .table_encryption_configs(HashMap::from([(ddb_table_name.to_string(), table_config)]))
        .build()?;

    Ok(table_configs)
}
