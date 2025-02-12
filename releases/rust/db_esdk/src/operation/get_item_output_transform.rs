// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
/// Orchestration and serialization glue logic for `GetItemOutputTransform`.
#[derive(::std::clone::Clone, ::std::default::Default, ::std::fmt::Debug)]
#[non_exhaustive]
pub struct GetItemOutputTransform;
impl GetItemOutputTransform {
    /// Creates a new `GetItemOutputTransform`
    pub fn new() -> Self {
        Self
    }

    pub(crate) async fn send(
        client: &crate::client::Client,
        input: crate::operation::get_item_output_transform::GetItemOutputTransformInput,
    ) -> ::std::result::Result<
        crate::operation::get_item_output_transform::GetItemOutputTransformOutput,
        crate::types::error::Error,
    > {
        crate::validation::validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HGetItemOutputTransformInput_for_DynamoDbEncryptionTransforms_GetItemOutputTransform(&input)
            .map_err(crate::types::error::Error::wrap_validation_err)?;
        let inner_input = crate::conversions::get_item_output_transform::_get_item_output_transform_input::to_dafny(input);
        let inner_result =
            ::dafny_runtime::md!(client.dafny_client.clone()).GetItemOutputTransform(&inner_input);
        if matches!(
            inner_result.as_ref(),
            crate::r#_Wrappers_Compile::Result::Success { .. }
        ) {
            Ok(
                crate::conversions::get_item_output_transform::_get_item_output_transform_output::from_dafny(inner_result.value().clone()),
            )
        } else {
            Err(crate::conversions::error::from_dafny(
                inner_result.error().clone(),
            ))
        }
    }
}

pub use crate::operation::get_item_output_transform::_get_item_output_transform_output::GetItemOutputTransformOutput;

pub use crate::operation::get_item_output_transform::_get_item_output_transform_input::GetItemOutputTransformInput;

pub(crate) mod _get_item_output_transform_output;

pub(crate) mod _get_item_output_transform_input;

/// Builders
pub mod builders;
