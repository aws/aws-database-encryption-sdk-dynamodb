// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
/// Orchestration and serialization glue logic for `DecryptPathStructure`.
#[derive(::std::clone::Clone, ::std::default::Default, ::std::fmt::Debug)]
#[non_exhaustive]
pub struct DecryptPathStructure;
impl DecryptPathStructure {
    /// Creates a new `DecryptPathStructure`
    pub fn new() -> Self {
        Self
    }

    pub(crate) async fn send(
        client: &crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::client::Client,
        input: crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::operation::decrypt_path_structure::DecryptPathStructureInput,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::operation::decrypt_path_structure::DecryptPathStructureOutput,
        crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::error::Error,
    >{
        if input.table_name.is_none() {
            return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::missing_field(
        "table_name",
        "table_name was not specified but it is required when building DecryptPathStructureInput",
    )).map_err(crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::error::Error::wrap_validation_err);
        }
        if input.encrypted_structure.is_none() {
            return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::missing_field(
        "encrypted_structure",
        "encrypted_structure was not specified but it is required when building DecryptPathStructureInput",
    )).map_err(crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::error::Error::wrap_validation_err);
        }
        if input.cmm.is_none() {
            return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::missing_field(
        "cmm",
        "cmm was not specified but it is required when building DecryptPathStructureInput",
    )).map_err(crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::error::Error::wrap_validation_err);
        }
        let inner_input = crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::conversions::decrypt_path_structure::_decrypt_path_structure_input::to_dafny(input);
        let inner_result =
            ::dafny_runtime::md!(client.dafny_client.clone()).DecryptPathStructure(&inner_input);
        if matches!(
            inner_result.as_ref(),
            crate::r#_Wrappers_Compile::Result::Success { .. }
        ) {
            Ok(
                crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::conversions::decrypt_path_structure::_decrypt_path_structure_output::from_dafny(inner_result.value().clone()),
            )
        } else {
            Err(crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::conversions::error::from_dafny(
                inner_result.error().clone(),
            ))
        }
    }
}

pub use crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::operation::decrypt_path_structure::_decrypt_path_structure_output::DecryptPathStructureOutput;

pub use crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::operation::decrypt_path_structure::_decrypt_path_structure_input::DecryptPathStructureInput;

pub(crate) mod _decrypt_path_structure_output;

pub(crate) mod _decrypt_path_structure_input;

/// Builders
pub mod builders;
