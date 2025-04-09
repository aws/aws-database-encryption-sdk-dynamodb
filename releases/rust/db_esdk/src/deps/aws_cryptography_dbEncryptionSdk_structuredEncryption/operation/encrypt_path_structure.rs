// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
/// Orchestration and serialization glue logic for `EncryptPathStructure`.
#[derive(::std::clone::Clone, ::std::default::Default, ::std::fmt::Debug)]
#[non_exhaustive]
pub struct EncryptPathStructure;
impl EncryptPathStructure {
    /// Creates a new `EncryptPathStructure`
    pub fn new() -> Self {
        Self
    }

    pub(crate) async fn send(
        client: &crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::client::Client,
        input: crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::operation::encrypt_path_structure::EncryptPathStructureInput,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::operation::encrypt_path_structure::EncryptPathStructureOutput,
        crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::error::Error,
    >{
        crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::validation::validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HEncryptPathStructureInput_for_StructuredEncryption_EncryptPathStructure(&input)
            .map_err(crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::error::Error::wrap_validation_err)?;
        let inner_input = crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::conversions::encrypt_path_structure::_encrypt_path_structure_input::to_dafny(input);
        let inner_result =
            ::dafny_runtime::md!(client.dafny_client.clone()).EncryptPathStructure(&inner_input);
        if matches!(
            inner_result.as_ref(),
            crate::r#_Wrappers_Compile::Result::Success { .. }
        ) {
            Ok(
                crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::conversions::encrypt_path_structure::_encrypt_path_structure_output::from_dafny(inner_result.value().clone()),
            )
        } else {
            Err(crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::conversions::error::from_dafny(
                inner_result.error().clone(),
            ))
        }
    }
}

pub use crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::operation::encrypt_path_structure::_encrypt_path_structure_output::EncryptPathStructureOutput;

pub use crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::operation::encrypt_path_structure::_encrypt_path_structure_input::EncryptPathStructureInput;

pub(crate) mod _encrypt_path_structure_output;

pub(crate) mod _encrypt_path_structure_input;

/// Builders
pub mod builders;
