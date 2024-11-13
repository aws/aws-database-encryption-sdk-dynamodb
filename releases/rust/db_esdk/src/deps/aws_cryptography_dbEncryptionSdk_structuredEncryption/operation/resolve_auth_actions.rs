// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
/// Orchestration and serialization glue logic for `ResolveAuthActions`.
#[derive(::std::clone::Clone, ::std::default::Default, ::std::fmt::Debug)]
#[non_exhaustive]
pub struct ResolveAuthActions;
impl ResolveAuthActions {
    /// Creates a new `ResolveAuthActions`
    pub fn new() -> Self {
        Self
    }

    pub(crate) async fn send(
        client: &crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::client::Client,
        input: crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::operation::resolve_auth_actions::ResolveAuthActionsInput,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::operation::resolve_auth_actions::ResolveAuthActionsOutput,
        crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::error::Error,
    > {
        if input.table_name.is_none() {
    return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::missing_field(
        "table_name",
        "table_name was not specified but it is required when building ResolveAuthActionsInput",
    )).map_err(crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::error::Error::wrap_validation_err);
}
if input.auth_actions.is_none() {
    return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::missing_field(
        "auth_actions",
        "auth_actions was not specified but it is required when building ResolveAuthActionsInput",
    )).map_err(crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::error::Error::wrap_validation_err);
}
if input.header_bytes.is_none() {
    return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::missing_field(
        "header_bytes",
        "header_bytes was not specified but it is required when building ResolveAuthActionsInput",
    )).map_err(crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::error::Error::wrap_validation_err);
}
                let inner_input = crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::conversions::resolve_auth_actions::_resolve_auth_actions_input::to_dafny(input);
        let inner_result =
            ::dafny_runtime::md!(client.dafny_client.clone()).ResolveAuthActions(&inner_input);
        if matches!(
            inner_result.as_ref(),
            crate::r#_Wrappers_Compile::Result::Success { .. }
        ) {
            Ok(
                crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::conversions::resolve_auth_actions::_resolve_auth_actions_output::from_dafny(inner_result.value().clone()),
            )
        } else {
            Err(crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::conversions::error::from_dafny(
                inner_result.error().clone(),
            ))
        }
    }
}

pub use crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::operation::resolve_auth_actions::_resolve_auth_actions_output::ResolveAuthActionsOutput;

pub use crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::operation::resolve_auth_actions::_resolve_auth_actions_input::ResolveAuthActionsInput;

pub(crate) mod _resolve_auth_actions_output;

pub(crate) mod _resolve_auth_actions_input;

/// Builders
pub mod builders;
