// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
/// Orchestration and serialization glue logic for `QueryOutputTransform`.
#[derive(::std::clone::Clone, ::std::default::Default, ::std::fmt::Debug)]
#[non_exhaustive]
pub struct QueryOutputTransform;
impl QueryOutputTransform {
    /// Creates a new `QueryOutputTransform`
    pub fn new() -> Self {
        Self
    }

    pub(crate) async fn send(
        client: &crate::client::Client,
        input: crate::operation::query_output_transform::QueryOutputTransformInput,
    ) -> ::std::result::Result<
        crate::operation::query_output_transform::QueryOutputTransformOutput,
        crate::types::error::Error,
    > {
        crate::validation::validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HQueryOutputTransformInput_for_DynamoDbEncryptionTransforms_QueryOutputTransform(&input)
            .map_err(crate::types::error::Error::wrap_validation_err)?;
        let inner_input =
            crate::conversions::query_output_transform::_query_output_transform_input::to_dafny(
                input,
            );
        let inner_result =
            ::dafny_runtime::md!(client.dafny_client.clone()).QueryOutputTransform(&inner_input);
        if matches!(
            inner_result.as_ref(),
            crate::r#_Wrappers_Compile::Result::Success { .. }
        ) {
            Ok(
                crate::conversions::query_output_transform::_query_output_transform_output::from_dafny(inner_result.value().clone()),
            )
        } else {
            Err(crate::conversions::error::from_dafny(
                inner_result.error().clone(),
            ))
        }
    }
}

pub use crate::operation::query_output_transform::_query_output_transform_output::QueryOutputTransformOutput;

pub use crate::operation::query_output_transform::_query_output_transform_input::QueryOutputTransformInput;

pub(crate) mod _query_output_transform_output;

pub(crate) mod _query_output_transform_input;

/// Builders
pub mod builders;
