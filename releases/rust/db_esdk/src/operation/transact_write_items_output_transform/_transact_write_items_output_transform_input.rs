// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
#[allow(missing_docs)]
pub struct TransactWriteItemsOutputTransformInput {
    #[allow(missing_docs)]
    pub original_input: ::std::option::Option<
        aws_sdk_dynamodb::operation::transact_write_items::TransactWriteItemsInput,
    >,
    #[allow(missing_docs)]
    pub sdk_output: ::std::option::Option<
        aws_sdk_dynamodb::operation::transact_write_items::TransactWriteItemsOutput,
    >,
}
impl TransactWriteItemsOutputTransformInput {
    #[allow(missing_docs)]
    pub fn original_input(
        &self,
    ) -> &::std::option::Option<
        aws_sdk_dynamodb::operation::transact_write_items::TransactWriteItemsInput,
    > {
        &self.original_input
    }
    #[allow(missing_docs)]
    pub fn sdk_output(
        &self,
    ) -> &::std::option::Option<
        aws_sdk_dynamodb::operation::transact_write_items::TransactWriteItemsOutput,
    > {
        &self.sdk_output
    }
}
impl TransactWriteItemsOutputTransformInput {
    /// Creates a new builder-style object to manufacture [`TransactWriteItemsOutputTransformInput`](crate::operation::transact_write_items_output_transform::builders::TransactWriteItemsOutputTransformInput).
    pub fn builder() -> crate::operation::transact_write_items_output_transform::builders::TransactWriteItemsOutputTransformInputBuilder{
        crate::operation::transact_write_items_output_transform::builders::TransactWriteItemsOutputTransformInputBuilder::default()
    }
}

/// A builder for [`TransactWriteItemsOutputTransformInput`](crate::operation::operation::TransactWriteItemsOutputTransformInput).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct TransactWriteItemsOutputTransformInputBuilder {
    pub(crate) original_input: ::std::option::Option<
        aws_sdk_dynamodb::operation::transact_write_items::TransactWriteItemsInput,
    >,
    pub(crate) sdk_output: ::std::option::Option<
        aws_sdk_dynamodb::operation::transact_write_items::TransactWriteItemsOutput,
    >,
}
impl TransactWriteItemsOutputTransformInputBuilder {
    #[allow(missing_docs)]
    pub fn original_input(
        mut self,
        input: impl ::std::convert::Into<
            aws_sdk_dynamodb::operation::transact_write_items::TransactWriteItemsInput,
        >,
    ) -> Self {
        self.original_input = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_original_input(
        mut self,
        input: ::std::option::Option<
            aws_sdk_dynamodb::operation::transact_write_items::TransactWriteItemsInput,
        >,
    ) -> Self {
        self.original_input = input;
        self
    }
    #[allow(missing_docs)]
    pub fn get_original_input(
        &self,
    ) -> &::std::option::Option<
        aws_sdk_dynamodb::operation::transact_write_items::TransactWriteItemsInput,
    > {
        &self.original_input
    }
    #[allow(missing_docs)]
    pub fn sdk_output(
        mut self,
        input: impl ::std::convert::Into<
            aws_sdk_dynamodb::operation::transact_write_items::TransactWriteItemsOutput,
        >,
    ) -> Self {
        self.sdk_output = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_sdk_output(
        mut self,
        input: ::std::option::Option<
            aws_sdk_dynamodb::operation::transact_write_items::TransactWriteItemsOutput,
        >,
    ) -> Self {
        self.sdk_output = input;
        self
    }
    #[allow(missing_docs)]
    pub fn get_sdk_output(
        &self,
    ) -> &::std::option::Option<
        aws_sdk_dynamodb::operation::transact_write_items::TransactWriteItemsOutput,
    > {
        &self.sdk_output
    }
    /// Consumes the builder and constructs a [`TransactWriteItemsOutputTransformInput`](crate::operation::operation::TransactWriteItemsOutputTransformInput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::operation::transact_write_items_output_transform::TransactWriteItemsOutputTransformInput,
        ::aws_smithy_types::error::operation::BuildError,
    >{
        ::std::result::Result::Ok(crate::operation::transact_write_items_output_transform::TransactWriteItemsOutputTransformInput {
            original_input: self.original_input,
sdk_output: self.sdk_output,
        })
    }
}
