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
        if input.table_name.is_none() {
    return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::missing_field(
        "table_name",
        "table_name was not specified but it is required when building ResolveAttributesInput",
    )).map_err(crate::types::error::Error::wrap_validation_err);
}
if matches!(input.table_name, Some(ref x) if !(3..=255).contains(&x.chars().map(::std::primitive::char::len_utf16).fold(0usize, ::std::ops::Add::add))) {
    return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "table_name",
        "table_name failed to satisfy constraint: Member must have length between 3 and 255, inclusive",
    )).map_err(crate::types::error::Error::wrap_validation_err);
}
if input.item.is_none() {
    return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::missing_field(
        "item",
        "item was not specified but it is required when building ResolveAttributesInput",
    )).map_err(crate::types::error::Error::wrap_validation_err);
}
if matches!(input.version, Some(x) if !(1..).contains(&x)) {
    return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "version",
        "version failed to satisfy constraint: Member must be greater than or equal to 1",
    )).map_err(crate::types::error::Error::wrap_validation_err);
}
                let inner_input = crate::conversions::resolve_attributes::_resolve_attributes_input::to_dafny(input);
        let inner_result =
            ::dafny_runtime::md!(client.dafny_client.clone()).ResolveAttributes(&inner_input);
        if matches!(
            inner_result.as_ref(),
            crate::r#_Wrappers_Compile::Result::Success { .. }
        ) {
            Ok(
                crate::conversions::resolve_attributes::_resolve_attributes_output::from_dafny(inner_result.value().clone()),
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
