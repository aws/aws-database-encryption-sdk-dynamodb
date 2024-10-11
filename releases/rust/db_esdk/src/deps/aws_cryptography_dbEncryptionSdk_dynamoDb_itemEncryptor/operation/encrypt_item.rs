// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
/// Orchestration and serialization glue logic for `EncryptItem`.
#[derive(::std::clone::Clone, ::std::default::Default, ::std::fmt::Debug)]
#[non_exhaustive]
pub struct EncryptItem;
impl EncryptItem {
    /// Creates a new `EncryptItem`
    pub fn new() -> Self {
        Self
    }
    pub(crate) async fn send(
        client: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::client::Client,
        input: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::operation::encrypt_item::EncryptItemInput,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::operation::encrypt_item::EncryptItemOutput,
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::error::Error,
    >{
        let inner_input = crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::conversions::encrypt_item::_encrypt_item_input::to_dafny(input);
        let inner_result =
            ::dafny_runtime::md!(client.dafny_client.clone()).EncryptItem(&inner_input);
        if matches!(
            inner_result.as_ref(),
            crate::r#_Wrappers_Compile::Result::Success { .. }
        ) {
            Ok(
                crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::conversions::encrypt_item::_encrypt_item_output::from_dafny(inner_result.value().clone()),
            )
        } else {
            Err(crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::conversions::error::from_dafny(
                inner_result.error().clone(),
            ))
        }
    }
}

pub use crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::operation::encrypt_item::_encrypt_item_output::EncryptItemOutput;

pub use crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::operation::encrypt_item::_encrypt_item_input::EncryptItemInput;

pub(crate) mod _encrypt_item_output;

pub(crate) mod _encrypt_item_input;

/// Builders
pub mod builders;
