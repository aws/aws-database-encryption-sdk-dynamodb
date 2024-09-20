// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

use crate::test_utils;
use db_esdk::aws_cryptography_keyStore::types::key_store_config::KeyStoreConfig;
use db_esdk::aws_cryptography_keyStore::types::KmsConfiguration;
use db_esdk::aws_cryptography_keyStore::client as keystore_client;

/*
  The Hierarchical Keyring Example and Searchable Encryption Examples
  rely on the existence of a DDB-backed key store with pre-existing
  branch key material or beacon key material.

  This example demonstrates configuring a KeyStore and then
  using a helper method to create the DDB table that will be
  used to persist branch keys and beacons keys for this KeyStore.

  This table creation should occur within your control plane. This
  only needs to occur once. While not demonstrated in this example,
  you should additionally use the `VersionKey` API on the KeyStore
  to periodically rotate your branch key material.
 */

 pub async fn keystore_create_table() -> String
    {
      let key_store_table_name = test_utils::TEST_KEYSTORE_NAME;
      let logical_key_store_name = test_utils::TEST_LOGICAL_KEYSTORE_NAME;
      let kms_key_arn = test_utils::TEST_KEYSTORE_KMS_KEY_ID;

        // 1. Configure your KeyStore resource.
        //    `ddbTableName` is the name you want for the DDB table that
        //    will back your keystore.
        //    `kmsKeyArn` is the KMS Key that will protect your branch keys and beacon keys
        //    when they are stored in your DDB table.
        let sdk_config = aws_config::load_defaults(aws_config::BehaviorVersion::latest()).await;
      let key_store_config = KeyStoreConfig::builder()
          .kms_client(aws_sdk_kms::Client::new(&sdk_config))
          .ddb_client(aws_sdk_dynamodb::Client::new(&sdk_config))
          .ddb_table_name(key_store_table_name)
          .logical_key_store_name(logical_key_store_name)
          .kms_configuration(KmsConfiguration::KmsKeyArn(kms_key_arn.to_string()))
          .build()
          .unwrap();
        
        let keystore = keystore_client::Client::from_conf(key_store_config).unwrap();

        // 2. Create the DynamoDb table that will store the branch keys and beacon keys.
        //    This checks if the correct table already exists at `ddbTableName`
        //    by using the DescribeTable API. If no table exists,
        //    it will create one. If a table exists, it will verify
        //    the table's configuration and will error if the configuration is incorrect.
        keystore.create_keystore.send().await.unwrap();

        // It may take a couple minutes for the table to become ACTIVE,
        // at which point it is ready to store branch and beacon keys.
        // See the create_keystore_key example for how to populate
        // this table.
  }
