// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
#[allow(missing_docs)]
pub struct TransactGetItemsOutputTransformOutput {
    #[allow(missing_docs)]
    pub transformed_output: ::std::option::Option<
        aws_sdk_dynamodb::operation::transact_get_items::TransactGetItemsOutput,
    >,
}
impl TransactGetItemsOutputTransformOutput {
    #[allow(missing_docs)]
    pub fn transformed_output(
        &self,
    ) -> &::std::option::Option<
        aws_sdk_dynamodb::operation::transact_get_items::TransactGetItemsOutput,
    > {
        &self.transformed_output
    }
}
impl TransactGetItemsOutputTransformOutput {
    /// Creates a new builder-style object to manufacture [`TransactGetItemsOutputTransformOutput`](crate::types::TransactGetItemsOutputTransformOutput).
    pub fn builder() -> crate::types::builders::TransactGetItemsOutputTransformOutputBuilder {
        crate::types::builders::TransactGetItemsOutputTransformOutputBuilder::default()
    }
}

/// A builder for [`TransactGetItemsOutputTransformOutput`](crate::types::TransactGetItemsOutputTransformOutput).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct TransactGetItemsOutputTransformOutputBuilder {
    pub(crate) transformed_output: ::std::option::Option<
        aws_sdk_dynamodb::operation::transact_get_items::TransactGetItemsOutput,
    >,
}
impl TransactGetItemsOutputTransformOutputBuilder {
    #[allow(missing_docs)]
    pub fn transformed_output(
        mut self,
        input: impl ::std::convert::Into<
            aws_sdk_dynamodb::operation::transact_get_items::TransactGetItemsOutput,
        >,
    ) -> Self {
        self.transformed_output = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_transformed_output(
        mut self,
        input: ::std::option::Option<
            aws_sdk_dynamodb::operation::transact_get_items::TransactGetItemsOutput,
        >,
    ) -> Self {
        self.transformed_output = input;
        self
    }
    #[allow(missing_docs)]
    pub fn get_transformed_output(
        &self,
    ) -> &::std::option::Option<
        aws_sdk_dynamodb::operation::transact_get_items::TransactGetItemsOutput,
    > {
        &self.transformed_output
    }
    /// Consumes the builder and constructs a [`TransactGetItemsOutputTransformOutput`](crate::types::TransactGetItemsOutputTransformOutput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::types::TransactGetItemsOutputTransformOutput,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(crate::types::TransactGetItemsOutputTransformOutput {
            transformed_output: self.transformed_output,
        })
    }
}
