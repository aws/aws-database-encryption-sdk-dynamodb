// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

use crate::test_utils;
use aws_db_esdk::key_store::client as keystore_client;
use aws_db_esdk::key_store::types::key_store_config::KeyStoreConfig;
use aws_db_esdk::key_store::types::KmsConfiguration;

/*
 The Hierarchical Keyring Example and Searchable Encryption Examples
 rely on the existence of a DDB-backed key store with pre-existing
 branch key material or beacon key material.

 See the "Create KeyStore Table Example" for how to first set up
 the DDB Table that will back this KeyStore.

 This example demonstrates configuring a KeyStore and then
 using a helper method to create a branch key and beacon key
 that share the same Id, then return that Id.
 We will always create a new beacon key alongside a new branch key,
 even if you are not using searchable encryption.

 This key creation should occur within your control plane.
*/
pub async fn keystore_create_key() -> Result<String, crate::BoxError> {
    let key_store_table_name = test_utils::TEST_KEYSTORE_NAME;
    let logical_key_store_name = test_utils::TEST_LOGICAL_KEYSTORE_NAME;
    let kms_key_arn = test_utils::TEST_KEYSTORE_KMS_KEY_ID;

    // 1. Configure your KeyStore resource.
    //    This SHOULD be the same configuration that was used to create the DDB table
    //    in the "Create KeyStore Table Example".
    let sdk_config = aws_config::load_defaults(aws_config::BehaviorVersion::latest()).await;
    let key_store_config = KeyStoreConfig::builder()
        .kms_client(aws_sdk_kms::Client::new(&sdk_config))
        .ddb_client(aws_sdk_dynamodb::Client::new(&sdk_config))
        .ddb_table_name(key_store_table_name)
        .logical_key_store_name(logical_key_store_name)
        .kms_configuration(KmsConfiguration::KmsKeyArn(kms_key_arn.to_string()))
        .build()?;

    let keystore = keystore_client::Client::from_conf(key_store_config)?;

    // 2. Create a new branch key and beacon key in our KeyStore.
    //    Both the branch key and the beacon key will share an Id.
    //    This creation is eventually consistent.

    let new_key = keystore.create_key().send().await?;
    Ok(new_key.branch_key_identifier.unwrap())
}
