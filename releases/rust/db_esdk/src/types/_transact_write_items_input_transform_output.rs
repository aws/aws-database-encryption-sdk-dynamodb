// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
#[allow(missing_docs)]
pub struct TransactWriteItemsInputTransformOutput {
    #[allow(missing_docs)]
    pub transformed_input: ::std::option::Option<
        aws_sdk_dynamodb::operation::transact_write_items::TransactWriteItemsInput,
    >,
}
impl TransactWriteItemsInputTransformOutput {
    #[allow(missing_docs)]
    pub fn transformed_input(
        &self,
    ) -> &::std::option::Option<
        aws_sdk_dynamodb::operation::transact_write_items::TransactWriteItemsInput,
    > {
        &self.transformed_input
    }
}
impl TransactWriteItemsInputTransformOutput {
    /// Creates a new builder-style object to manufacture [`TransactWriteItemsInputTransformOutput`](crate::types::TransactWriteItemsInputTransformOutput).
    pub fn builder() -> crate::types::builders::TransactWriteItemsInputTransformOutputBuilder {
        crate::types::builders::TransactWriteItemsInputTransformOutputBuilder::default()
    }
}

/// A builder for [`TransactWriteItemsInputTransformOutput`](crate::types::TransactWriteItemsInputTransformOutput).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct TransactWriteItemsInputTransformOutputBuilder {
    pub(crate) transformed_input: ::std::option::Option<
        aws_sdk_dynamodb::operation::transact_write_items::TransactWriteItemsInput,
    >,
}
impl TransactWriteItemsInputTransformOutputBuilder {
    #[allow(missing_docs)]
    pub fn transformed_input(
        mut self,
        input: impl ::std::convert::Into<
            aws_sdk_dynamodb::operation::transact_write_items::TransactWriteItemsInput,
        >,
    ) -> Self {
        self.transformed_input = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_transformed_input(
        mut self,
        input: ::std::option::Option<
            aws_sdk_dynamodb::operation::transact_write_items::TransactWriteItemsInput,
        >,
    ) -> Self {
        self.transformed_input = input;
        self
    }
    #[allow(missing_docs)]
    pub fn get_transformed_input(
        &self,
    ) -> &::std::option::Option<
        aws_sdk_dynamodb::operation::transact_write_items::TransactWriteItemsInput,
    > {
        &self.transformed_input
    }
    /// Consumes the builder and constructs a [`TransactWriteItemsInputTransformOutput`](crate::types::TransactWriteItemsInputTransformOutput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::types::TransactWriteItemsInputTransformOutput,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(crate::types::TransactWriteItemsInputTransformOutput {
            transformed_input: self.transformed_input,
        })
    }
}
