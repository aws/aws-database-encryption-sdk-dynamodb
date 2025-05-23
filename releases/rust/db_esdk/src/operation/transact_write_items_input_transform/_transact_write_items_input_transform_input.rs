// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
#[allow(missing_docs)]
pub struct TransactWriteItemsInputTransformInput {
    #[allow(missing_docs)]
    pub sdk_input: ::std::option::Option<
        aws_sdk_dynamodb::operation::transact_write_items::TransactWriteItemsInput,
    >,
}
impl TransactWriteItemsInputTransformInput {
    #[allow(missing_docs)]
    pub fn sdk_input(
        &self,
    ) -> &::std::option::Option<
        aws_sdk_dynamodb::operation::transact_write_items::TransactWriteItemsInput,
    > {
        &self.sdk_input
    }
}
impl TransactWriteItemsInputTransformInput {
    /// Creates a new builder-style object to manufacture [`TransactWriteItemsInputTransformInput`](crate::operation::transact_write_items_input_transform::builders::TransactWriteItemsInputTransformInput).
    pub fn builder() -> crate::operation::transact_write_items_input_transform::builders::TransactWriteItemsInputTransformInputBuilder{
        crate::operation::transact_write_items_input_transform::builders::TransactWriteItemsInputTransformInputBuilder::default()
    }
}

/// A builder for [`TransactWriteItemsInputTransformInput`](crate::operation::operation::TransactWriteItemsInputTransformInput).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct TransactWriteItemsInputTransformInputBuilder {
    pub(crate) sdk_input: ::std::option::Option<
        aws_sdk_dynamodb::operation::transact_write_items::TransactWriteItemsInput,
    >,
}
impl TransactWriteItemsInputTransformInputBuilder {
    #[allow(missing_docs)]
    pub fn sdk_input(
        mut self,
        input: impl ::std::convert::Into<
            aws_sdk_dynamodb::operation::transact_write_items::TransactWriteItemsInput,
        >,
    ) -> Self {
        self.sdk_input = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_sdk_input(
        mut self,
        input: ::std::option::Option<
            aws_sdk_dynamodb::operation::transact_write_items::TransactWriteItemsInput,
        >,
    ) -> Self {
        self.sdk_input = input;
        self
    }
    #[allow(missing_docs)]
    pub fn get_sdk_input(
        &self,
    ) -> &::std::option::Option<
        aws_sdk_dynamodb::operation::transact_write_items::TransactWriteItemsInput,
    > {
        &self.sdk_input
    }
    /// Consumes the builder and constructs a [`TransactWriteItemsInputTransformInput`](crate::operation::operation::TransactWriteItemsInputTransformInput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::operation::transact_write_items_input_transform::TransactWriteItemsInputTransformInput,
        ::aws_smithy_types::error::operation::BuildError,
    >{
        ::std::result::Result::Ok(crate::operation::transact_write_items_input_transform::TransactWriteItemsInputTransformInput {
            sdk_input: self.sdk_input,
        })
    }
}
