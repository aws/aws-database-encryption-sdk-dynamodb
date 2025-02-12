// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

//! The AWS Database Encryption SDK provides client side encryption for DynamoDB.
//!
//! The journey starts with a configuration.
//! For details see the [Examples](https://github.com/aws/aws-database-encryption-sdk-dynamodb/tree/main/releases/rust/db_esdk/examples)
//! or the [Developer Guide](https://docs.aws.amazon.com/database-encryption-sdk/latest/devguide)
//!
//! The examples below will use an empty configuration for brevity.
//! This is not something you would do in actual use.
//!
//! There are two modes of operation.
//!
//! ## DynamoDB Client with Interceptor
//! By far the most common mode is to add our interceptor to your DynamoDB client.
//!
//! Once you've created your augmented DynamoDB Client, use it as you normally would.
//! Values are automatically encrypted on Put and decrypted on Get.
//!
//! If configured, Scan Beacons are generated to allow [Searchable Encryption](https://docs.aws.amazon.com/database-encryption-sdk/latest/devguide/searchable-encryption.html)
//!
//! [See full example](https://github.com/aws/aws-database-encryption-sdk-dynamodb/blob/main/releases/rust/db_esdk/examples/basic_get_put_example.rs)
//!
//! ```text
//! let table_configs = DynamoDbTablesEncryptionConfig::builder()
//! .table_encryption_configs(HashMap::new()) // your configuration here
//! .build()?;
//!
//! let sdk_config = aws_config::load_defaults(aws_config::BehaviorVersion::latest()).await;
//! let dynamo_config = aws_sdk_dynamodb::config::Builder::from(&sdk_config)
//! .interceptor(DbEsdkInterceptor::new(table_configs)?)
//! .build();
//!
//! let ddb_client = aws_sdk_dynamodb::Client::from_conf(dynamo_config);
//! ```
//!
//! ## Item Encryptor
//!
//! Rather than letting things happen automatically, you can manually encrypt
//! and decrypt individual DynamoDB Items.
//! This does NOT allow for [Searchable Encryption](https://docs.aws.amazon.com/database-encryption-sdk/latest/devguide/searchable-encryption.html).
//!
//! [See full example](https://github.com/aws/aws-database-encryption-sdk-dynamodb/blob/main/releases/rust/db_esdk/examples/itemencryptor/item_encrypt_decrypt.rs)
//!
//! ```text
//!  let config = DynamoDbItemEncryptorConfig::builder()
//! // your configuration here
//!  .build()?;
//!
//! let item_encryptor = enc_client::Client::from_conf(config)?;
//!
//! let encrypted_item = item_encryptor
//!   .encrypt_item()
//!   .plaintext_item(original_item)
//!   .send()
//!   .await?
//!   .encrypted_item
//!   .unwrap();
//!
//! let decrypted_item = item_encryptor
//!   .decrypt_item()
//!   .encrypted_item(encrypted_item)
//!   .send()
//!   .await?
//!   .encrypted_item
//!   .unwrap();
//!
//! assert_eq!(decrypted_item, original_item);
//! ```
//!

#![allow(warnings, unconditional_panic)]
#![allow(nonstandard_style)]
#![allow(clippy::never_loop)]
#![allow(clippy::absurd_extreme_comparisons)]

/// Client for use with the various low level transform operations
pub mod client;
/// Errors and error handling utilities.
pub mod error;
/// the DbEsdkInterceptor type for use with the aws_sdk_dynamodb interceptor
pub mod intercept;
/// All the transform operations. Rarely useful.
pub mod operation;
/// Types for the transform client. Rarely useful.
pub mod types;

pub use client::Client;
pub use types::dynamo_db_tables_encryption_config::DynamoDbTablesEncryptionConfig;

/// Configuration types etc.
pub use crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb as dynamodb;
/// Low level interface to encrypt or decrypt individual Items.
pub use crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor as item_encryptor;
pub(crate) use crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption;
pub use crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoAction;
/// Branch key support. See [Key Stores](https://docs.aws.amazon.com/encryption-sdk/latest/developer-guide/keystores.html)
pub use crate::deps::aws_cryptography_keyStore as key_store;
/// [Key Rings](https://docs.aws.amazon.com/encryption-sdk/latest/developer-guide/choose-keyring.html) and other fundamentals.
pub use crate::deps::aws_cryptography_materialProviders as material_providers;
/// Rarely needed internal KMS Client, needed for [ClientSupplier](https://github.com/aws/aws-database-encryption-sdk-dynamodb/blob/main/releases/rust/db_esdk/examples/clientsupplier/regional_role_client_supplier.rs)
pub use crate::deps::com_amazonaws_kms;

mod standard_library_conversions;
mod standard_library_externs;

pub(crate) use crate::deps::aws_cryptography_primitives;

pub(crate) mod implementation_from_dafny;
pub(crate) use crate::implementation_from_dafny::_Wrappers_Compile;
pub(crate) use crate::implementation_from_dafny::software;
pub(crate) use crate::implementation_from_dafny::AesKdfCtr;
pub(crate) use crate::implementation_from_dafny::ConcurrentCall;
pub(crate) use crate::implementation_from_dafny::DafnyLibraries;
pub(crate) use crate::implementation_from_dafny::ExternDigest;
pub(crate) use crate::implementation_from_dafny::ExternRandom;
pub(crate) use crate::implementation_from_dafny::Signature;
pub(crate) use crate::implementation_from_dafny::Time;
pub(crate) use crate::implementation_from_dafny::_LocalCMC_Compile;
pub(crate) use crate::implementation_from_dafny::_StormTracker_Compile;
pub(crate) use crate::implementation_from_dafny::ECDH;
pub(crate) use crate::implementation_from_dafny::HMAC;
pub(crate) use crate::implementation_from_dafny::UTF8;
pub(crate) use crate::implementation_from_dafny::UUID;

pub(crate) mod conversions;
pub(crate) mod deps;
pub(crate) mod validation;

pub(crate) mod aes_gcm;
pub(crate) mod aes_kdf_ctr;
pub(crate) mod concurrent_call;
pub(crate) mod dafny_libraries;
pub(crate) mod ddb;
pub(crate) mod digest;
pub(crate) mod ecdh;
pub(crate) mod ecdsa;
pub(crate) mod hmac;
pub(crate) mod kms;
pub(crate) mod local_cmc;
pub(crate) mod oslang;
pub(crate) mod random;
pub(crate) mod rsa;
pub(crate) mod sets;
pub(crate) mod software_externs;
pub(crate) mod storm_tracker;
pub(crate) mod time;
pub(crate) mod uuid;
