// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
/// Orchestration and serialization glue logic for `DecryptItem`.
#[derive(::std::clone::Clone, ::std::default::Default, ::std::fmt::Debug)]
#[non_exhaustive]
pub struct DecryptItem;
impl DecryptItem {
    /// Creates a new `DecryptItem`
    pub fn new() -> Self {
        Self
    }

    pub(crate) async fn send(
        client: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::client::Client,
        input: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::operation::decrypt_item::DecryptItemInput,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::operation::decrypt_item::DecryptItemOutput,
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::error::Error,
    >{
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::validation::validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_PitemEncryptor_HDecryptItemInput_for_DynamoDbItemEncryptor_DecryptItem(&input)
            .map_err(crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::error::Error::wrap_validation_err)?;
        let inner_input = crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::conversions::decrypt_item::_decrypt_item_input::to_dafny(input);
        let inner_result =
            ::dafny_runtime::md!(client.dafny_client.clone()).DecryptItem(&inner_input);
        if matches!(
            inner_result.as_ref(),
            crate::r#_Wrappers_Compile::Result::Success { .. }
        ) {
            Ok(
                crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::conversions::decrypt_item::_decrypt_item_output::from_dafny(inner_result.value().clone()),
            )
        } else {
            Err(crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::conversions::error::from_dafny(
                inner_result.error().clone(),
            ))
        }
    }
}

pub use crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::operation::decrypt_item::_decrypt_item_output::DecryptItemOutput;

pub use crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::operation::decrypt_item::_decrypt_item_input::DecryptItemInput;

pub(crate) mod _decrypt_item_output;

pub(crate) mod _decrypt_item_input;

/// Builders
pub mod builders;
