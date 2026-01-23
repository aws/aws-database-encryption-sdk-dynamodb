// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

use anyhow::{anyhow, Result};
use aws_db_esdk::{
    item_encryptor::{
        client::Client as ItemEncryptorClient,
        types::DynamoDbItemEncryptorConfig,
    },
    material_providers::{
        client::Client as MaterialProvidersClient,
        types::{MaterialProvidersConfig, AesWrappingAlg, DbeAlgorithmSuiteId},
    },
};
use log::info;
use rand::Rng;
use sysinfo::System;

use crate::config::{TestConfig, load_config};
use crate::results::BenchmarkResult;
use crate::tests::create_attribute_actions;

// Constants for memory testing
pub const MEMORY_TEST_ITERATIONS: usize = 5;

pub struct DbeSDKBenchmark {
    pub item_encryptor: ItemEncryptorClient,
    pub config: TestConfig,
    pub results: Vec<BenchmarkResult>,
    pub cpu_count: usize,
    pub total_memory_gb: f64,
}

impl DbeSDKBenchmark {
    pub async fn new(config_path: &str) -> Result<Self> {
        // Get system info
        let mut system = System::new_all();
        system.refresh_all();
        let cpu_count = system.cpus().len();
        let total_memory_gb = system.total_memory() as f64 / (1024.0 * 1024.0 * 1024.0);

        // Load configuration
        let config = load_config(config_path)?;

        // Setup item encryptor
        let item_encryptor = Self::setup_item_encryptor(&config).await?;

        info!(
            "Initialized DB-ESDK Benchmark - CPU cores: {}, Memory: {:.1}GB",
            cpu_count, total_memory_gb
        );

        Ok(Self {
            item_encryptor,
            config,
            results: Vec::new(),
            cpu_count,
            total_memory_gb,
        })
    }

    async fn setup_item_encryptor(config: &TestConfig) -> Result<ItemEncryptorClient> {
        // Initialize material providers client
        let mpl_config = MaterialProvidersConfig::builder().build()?;
        let mpl_client = MaterialProvidersClient::from_conf(mpl_config)?;

        // Create Raw AES keyring
        let mut key = [0u8; 32]; // 256-bit key
        rand::rng().fill(&mut key);

        let raw_keyring = mpl_client
            .create_raw_aes_keyring()
            .key_name("test-aes-256-key")
            .key_namespace("dbesdk-performance-test")
            .wrapping_key(key.to_vec())
            .wrapping_alg(AesWrappingAlg::AlgAes256GcmIv12Tag16)
            .send()
            .await?;

        // Create item encryptor configuration
        let attribute_actions = create_attribute_actions();
        let allowed_unsigned_attribute_prefix = ":".to_string();
        let partition_key_name = "partition_key".to_string();
        let sort_key_name = "sort_key".to_string();
        let algorithm_suite_id = DbeAlgorithmSuiteId::AlgAes256GcmHkdfSha512CommitKeyEcdsaP384SymsigHmacSha384;

        let encryptor_config = DynamoDbItemEncryptorConfig::builder()
            .logical_table_name(config.table_name.clone())
            .partition_key_name(partition_key_name)
            .sort_key_name(sort_key_name)
            .attribute_actions_on_encrypt(attribute_actions)
            .keyring(raw_keyring.clone())
            .allowed_unsigned_attribute_prefix(allowed_unsigned_attribute_prefix)
            .algorithm_suite_id(algorithm_suite_id)
            .build()
            .map_err(|e| anyhow!("Failed to create item encryptor config: {}", e))?;

        // Create item encryptor client
        let item_encryptor = ItemEncryptorClient::from_conf(encryptor_config)
            .map_err(|e| anyhow!("Failed to create item encryptor: {}", e))?;

        info!("DB-ESDK item encryptor initialized successfully");
        Ok(item_encryptor)
    }

    pub fn save_results(&self, output_path: &str) -> Result<()> {
        crate::results::save_results(
            &self.results,
            output_path,
            self.cpu_count,
            self.total_memory_gb,
        )
    }
}
