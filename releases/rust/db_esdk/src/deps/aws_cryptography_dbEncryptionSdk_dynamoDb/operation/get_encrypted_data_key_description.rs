// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
/// Orchestration and serialization glue logic for `GetEncryptedDataKeyDescription`.
#[derive(::std::clone::Clone, ::std::default::Default, ::std::fmt::Debug)]
#[non_exhaustive]
pub struct GetEncryptedDataKeyDescription;
impl GetEncryptedDataKeyDescription {
    /// Creates a new `GetEncryptedDataKeyDescription`
    pub fn new() -> Self {
        Self
    }

    pub(crate) async fn send(
        client: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::client::Client,
        input: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_encrypted_data_key_description::GetEncryptedDataKeyDescriptionInput,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_encrypted_data_key_description::GetEncryptedDataKeyDescriptionOutput,
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::error::Error,
    >{
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::validation::validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HGetEncryptedDataKeyDescriptionInput_for_DynamoDbEncryption_GetEncryptedDataKeyDescription(&input)
            .map_err(crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::error::Error::wrap_validation_err)?;
        let inner_input = crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::get_encrypted_data_key_description::_get_encrypted_data_key_description_input::to_dafny(input);
        let inner_result = ::dafny_runtime::md!(client.dafny_client.clone())
            .GetEncryptedDataKeyDescription(&inner_input);
        if matches!(
            inner_result.as_ref(),
            crate::r#_Wrappers_Compile::Result::Success { .. }
        ) {
            Ok(
                crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::get_encrypted_data_key_description::_get_encrypted_data_key_description_output::from_dafny(inner_result.value().clone()),
            )
        } else {
            Err(crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::error::from_dafny(
                inner_result.error().clone(),
            ))
        }
    }
}

pub use crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_encrypted_data_key_description::_get_encrypted_data_key_description_output::GetEncryptedDataKeyDescriptionOutput;

pub use crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_encrypted_data_key_description::_get_encrypted_data_key_description_input::GetEncryptedDataKeyDescriptionInput;

pub(crate) mod _get_encrypted_data_key_description_output;

pub(crate) mod _get_encrypted_data_key_description_input;

/// Builders
pub mod builders;
