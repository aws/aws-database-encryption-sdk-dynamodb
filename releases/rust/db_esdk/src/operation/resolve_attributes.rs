// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
/// Orchestration and serialization glue logic for `ResolveAttributes`.
#[derive(::std::clone::Clone, ::std::default::Default, ::std::fmt::Debug)]
#[non_exhaustive]
pub struct ResolveAttributes;
impl ResolveAttributes {
    /// Creates a new `ResolveAttributes`
    pub fn new() -> Self {
        Self
    }

    pub(crate) async fn send(
        client: &crate::client::Client,
        input: crate::operation::resolve_attributes::ResolveAttributesInput,
    ) -> ::std::result::Result<
        crate::operation::resolve_attributes::ResolveAttributesOutput,
        crate::types::error::Error,
    > {
        crate::validation::validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HResolveAttributesInput_for_DynamoDbEncryptionTransforms_ResolveAttributes(&input)
            .map_err(crate::types::error::Error::wrap_validation_err)?;
        let inner_input =
            crate::conversions::resolve_attributes::_resolve_attributes_input::to_dafny(input);
        let inner_result =
            ::dafny_runtime::md!(client.dafny_client.clone()).ResolveAttributes(&inner_input);
        if matches!(
            inner_result.as_ref(),
            crate::r#_Wrappers_Compile::Result::Success { .. }
        ) {
            Ok(
                crate::conversions::resolve_attributes::_resolve_attributes_output::from_dafny(
                    inner_result.value().clone(),
                ),
            )
        } else {
            Err(crate::conversions::error::from_dafny(
                inner_result.error().clone(),
            ))
        }
    }
}

pub use crate::operation::resolve_attributes::_resolve_attributes_output::ResolveAttributesOutput;

pub use crate::operation::resolve_attributes::_resolve_attributes_input::ResolveAttributesInput;

pub(crate) mod _resolve_attributes_output;

pub(crate) mod _resolve_attributes_input;

/// Builders
pub mod builders;
