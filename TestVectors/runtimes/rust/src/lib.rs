// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

#![allow(warnings, unconditional_panic)]
#![allow(nonstandard_style)]

pub mod client;
pub mod conversions;
pub mod deps;
/// Common errors and error handling utilities.
pub mod error;
/// All operations that this crate can perform.
pub mod operation;
pub mod types;
pub mod validation;
pub mod intercept;
#[cfg(feature = "wrapped-client")]
pub mod wrapped;

#[cfg(feature = "fips")]
use aws_lc_fips_sys as aws_lc_sys_impl;

#[cfg(not(feature = "fips"))]
use aws_lc_sys as aws_lc_sys_impl;

mod standard_library_conversions;
mod standard_library_externs;

pub use client::Client;

pub use crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor;
pub use crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption;
pub use crate::deps::aws_cryptography_keyStore;
pub use crate::deps::aws_cryptography_materialProviders;
pub use crate::deps::aws_cryptography_primitives;

pub(crate) mod implementation_from_dafny;
pub(crate) use crate::implementation_from_dafny::r#_Wrappers_Compile;
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
pub(crate) use crate::deps::com_amazonaws_kms::client::Client as KmsClient;

pub mod aes_gcm;
pub mod aes_kdf_ctr;
pub mod concurrent_call;
pub mod dafny_libraries;
pub mod ddb;
pub mod digest;
pub mod ecdh;
pub mod ecdsa;
pub mod hmac;
pub mod kms;
pub mod local_cmc;
pub mod oslang;
pub mod random;
pub mod rsa;
pub mod sets;
pub mod software_externs;
pub mod storm_tracker;
pub mod time;
pub mod uuid;

pub mod create_client;
pub mod create_wrapped_item_encryptor;
