// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

use aws_db_esdk::key_store::types::KeyStoreConfig;
use aws_db_esdk::key_store::types::KmsConfiguration;
use aws_db_esdk::material_providers::types::MaterialProvidersConfig;
use aws_db_esdk::key_store::client as keystore_client;
use aws_db_esdk::material_providers::client;

pub async fn example() {
    let future = async move {
        let kms_key_id =
            "random key stuff"
                .to_string();

        // 1. Configure your KeyStore resource.
        //    This SHOULD be the same configuration that was used to create the DDB table
        //    in the "Create KeyStore Table Example".
        let sdk_config = aws_config::load_defaults(aws_config::BehaviorVersion::latest()).await;
        let key_store_config = KeyStoreConfig::builder()
            .kms_client(aws_sdk_kms::Client::new(&sdk_config))
            .ddb_client(aws_sdk_dynamodb::Client::new(&sdk_config))
            .ddb_table_name("KeyStore")
            .logical_key_store_name("KeyStore")
            .kms_configuration(KmsConfiguration::KmsKeyArn(kms_key_id.clone()))
            .build()
            .unwrap();

        let keystore = keystore_client::Client::from_conf(key_store_config).unwrap();

        let _new_key = keystore.create_key().send().await.unwrap();

        let provider_config = MaterialProvidersConfig::builder().build().unwrap();

        let mat_prov = client::Client::from_conf(provider_config).unwrap();
        let _kms_keyring = mat_prov
            .create_aws_kms_mrk_multi_keyring()
            .generator(kms_key_id)
            .send()
            .await
            .unwrap();
    };

    future.await;
}
