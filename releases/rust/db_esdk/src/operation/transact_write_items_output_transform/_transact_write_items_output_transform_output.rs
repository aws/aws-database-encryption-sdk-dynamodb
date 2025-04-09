// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
#[allow(missing_docs)]
pub struct TransactWriteItemsOutputTransformOutput {
    #[allow(missing_docs)]
    pub transformed_output: ::std::option::Option<
        aws_sdk_dynamodb::operation::transact_write_items::TransactWriteItemsOutput,
    >,
}
impl TransactWriteItemsOutputTransformOutput {
    #[allow(missing_docs)]
    pub fn transformed_output(
        &self,
    ) -> &::std::option::Option<
        aws_sdk_dynamodb::operation::transact_write_items::TransactWriteItemsOutput,
    > {
        &self.transformed_output
    }
}
impl TransactWriteItemsOutputTransformOutput {
    /// Creates a new builder-style object to manufacture [`TransactWriteItemsOutputTransformOutput`](crate::operation::transact_write_items_output_transform::builders::TransactWriteItemsOutputTransformOutput).
    pub fn builder() -> crate::operation::transact_write_items_output_transform::builders::TransactWriteItemsOutputTransformOutputBuilder{
        crate::operation::transact_write_items_output_transform::builders::TransactWriteItemsOutputTransformOutputBuilder::default()
    }
}

/// A builder for [`TransactWriteItemsOutputTransformOutput`](crate::operation::operation::TransactWriteItemsOutputTransformOutput).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct TransactWriteItemsOutputTransformOutputBuilder {
    pub(crate) transformed_output: ::std::option::Option<
        aws_sdk_dynamodb::operation::transact_write_items::TransactWriteItemsOutput,
    >,
}
impl TransactWriteItemsOutputTransformOutputBuilder {
    #[allow(missing_docs)]
    pub fn transformed_output(
        mut self,
        input: impl ::std::convert::Into<
            aws_sdk_dynamodb::operation::transact_write_items::TransactWriteItemsOutput,
        >,
    ) -> Self {
        self.transformed_output = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_transformed_output(
        mut self,
        input: ::std::option::Option<
            aws_sdk_dynamodb::operation::transact_write_items::TransactWriteItemsOutput,
        >,
    ) -> Self {
        self.transformed_output = input;
        self
    }
    #[allow(missing_docs)]
    pub fn get_transformed_output(
        &self,
    ) -> &::std::option::Option<
        aws_sdk_dynamodb::operation::transact_write_items::TransactWriteItemsOutput,
    > {
        &self.transformed_output
    }
    /// Consumes the builder and constructs a [`TransactWriteItemsOutputTransformOutput`](crate::operation::operation::TransactWriteItemsOutputTransformOutput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::operation::transact_write_items_output_transform::TransactWriteItemsOutputTransformOutput,
        ::aws_smithy_types::error::operation::BuildError,
    >{
        ::std::result::Result::Ok(crate::operation::transact_write_items_output_transform::TransactWriteItemsOutputTransformOutput {
            transformed_output: self.transformed_output,
        })
    }
}
