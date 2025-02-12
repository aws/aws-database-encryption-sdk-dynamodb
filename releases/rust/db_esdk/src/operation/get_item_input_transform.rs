// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
/// Orchestration and serialization glue logic for `GetItemInputTransform`.
#[derive(::std::clone::Clone, ::std::default::Default, ::std::fmt::Debug)]
#[non_exhaustive]
pub struct GetItemInputTransform;
impl GetItemInputTransform {
    /// Creates a new `GetItemInputTransform`
    pub fn new() -> Self {
        Self
    }

    pub(crate) async fn send(
        client: &crate::client::Client,
        input: crate::operation::get_item_input_transform::GetItemInputTransformInput,
    ) -> ::std::result::Result<
        crate::operation::get_item_input_transform::GetItemInputTransformOutput,
        crate::types::error::Error,
    > {
        crate::validation::validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HGetItemInputTransformInput_for_DynamoDbEncryptionTransforms_GetItemInputTransform(&input)
            .map_err(crate::types::error::Error::wrap_validation_err)?;
        let inner_input =
            crate::conversions::get_item_input_transform::_get_item_input_transform_input::to_dafny(
                input,
            );
        let inner_result =
            ::dafny_runtime::md!(client.dafny_client.clone()).GetItemInputTransform(&inner_input);
        if matches!(
            inner_result.as_ref(),
            crate::r#_Wrappers_Compile::Result::Success { .. }
        ) {
            Ok(
                crate::conversions::get_item_input_transform::_get_item_input_transform_output::from_dafny(inner_result.value().clone()),
            )
        } else {
            Err(crate::conversions::error::from_dafny(
                inner_result.error().clone(),
            ))
        }
    }
}

pub use crate::operation::get_item_input_transform::_get_item_input_transform_output::GetItemInputTransformOutput;

pub use crate::operation::get_item_input_transform::_get_item_input_transform_input::GetItemInputTransformInput;

pub(crate) mod _get_item_input_transform_output;

pub(crate) mod _get_item_input_transform_input;

/// Builders
pub mod builders;
