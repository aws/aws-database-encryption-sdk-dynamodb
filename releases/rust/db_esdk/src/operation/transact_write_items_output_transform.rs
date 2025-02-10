// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
/// Orchestration and serialization glue logic for `TransactWriteItemsOutputTransform`.
#[derive(::std::clone::Clone, ::std::default::Default, ::std::fmt::Debug)]
#[non_exhaustive]
pub struct TransactWriteItemsOutputTransform;
impl TransactWriteItemsOutputTransform {
    /// Creates a new `TransactWriteItemsOutputTransform`
    pub fn new() -> Self {
        Self
    }

    pub(crate) async fn send(
        client: &crate::client::Client,
        input: crate::operation::transact_write_items_output_transform::TransactWriteItemsOutputTransformInput,
    ) -> ::std::result::Result<
        crate::operation::transact_write_items_output_transform::TransactWriteItemsOutputTransformOutput,
        crate::types::error::Error,
    >{
        crate::validation::validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HTransactWriteItemsOutputTransformInput_for_DynamoDbEncryptionTransforms_TransactWriteItemsOutputTransform(&input)
            .map_err(crate::types::error::Error::wrap_validation_err)?;
        let inner_input = crate::conversions::transact_write_items_output_transform::_transact_write_items_output_transform_input::to_dafny(input);
        let inner_result = ::dafny_runtime::md!(client.dafny_client.clone())
            .TransactWriteItemsOutputTransform(&inner_input);
        if matches!(
            inner_result.as_ref(),
            crate::r#_Wrappers_Compile::Result::Success { .. }
        ) {
            Ok(
                crate::conversions::transact_write_items_output_transform::_transact_write_items_output_transform_output::from_dafny(inner_result.value().clone()),
            )
        } else {
            Err(crate::conversions::error::from_dafny(
                inner_result.error().clone(),
            ))
        }
    }
}

pub use crate::operation::transact_write_items_output_transform::_transact_write_items_output_transform_output::TransactWriteItemsOutputTransformOutput;

pub use crate::operation::transact_write_items_output_transform::_transact_write_items_output_transform_input::TransactWriteItemsOutputTransformInput;

pub(crate) mod _transact_write_items_output_transform_output;

pub(crate) mod _transact_write_items_output_transform_input;

/// Builders
pub mod builders;
