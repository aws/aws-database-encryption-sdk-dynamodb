// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
#[allow(missing_docs)]
pub struct TransactGetItemsOutputTransformInput {
    #[allow(missing_docs)]
    pub original_input: ::std::option::Option<
        aws_sdk_dynamodb::operation::transact_get_items::TransactGetItemsInput,
    >,
    #[allow(missing_docs)]
    pub sdk_output: ::std::option::Option<
        aws_sdk_dynamodb::operation::transact_get_items::TransactGetItemsOutput,
    >,
}
impl TransactGetItemsOutputTransformInput {
    #[allow(missing_docs)]
    pub fn original_input(
        &self,
    ) -> &::std::option::Option<
        aws_sdk_dynamodb::operation::transact_get_items::TransactGetItemsInput,
    > {
        &self.original_input
    }
    #[allow(missing_docs)]
    pub fn sdk_output(
        &self,
    ) -> &::std::option::Option<
        aws_sdk_dynamodb::operation::transact_get_items::TransactGetItemsOutput,
    > {
        &self.sdk_output
    }
}
impl TransactGetItemsOutputTransformInput {
    /// Creates a new builder-style object to manufacture [`TransactGetItemsOutputTransformInput`](crate::types::TransactGetItemsOutputTransformInput).
    pub fn builder() -> crate::types::builders::TransactGetItemsOutputTransformInputBuilder {
        crate::types::builders::TransactGetItemsOutputTransformInputBuilder::default()
    }
}

/// A builder for [`TransactGetItemsOutputTransformInput`](crate::types::TransactGetItemsOutputTransformInput).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct TransactGetItemsOutputTransformInputBuilder {
    pub(crate) original_input: ::std::option::Option<
        aws_sdk_dynamodb::operation::transact_get_items::TransactGetItemsInput,
    >,
    pub(crate) sdk_output: ::std::option::Option<
        aws_sdk_dynamodb::operation::transact_get_items::TransactGetItemsOutput,
    >,
}
impl TransactGetItemsOutputTransformInputBuilder {
    #[allow(missing_docs)]
    pub fn original_input(
        mut self,
        input: impl ::std::convert::Into<
            aws_sdk_dynamodb::operation::transact_get_items::TransactGetItemsInput,
        >,
    ) -> Self {
        self.original_input = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_original_input(
        mut self,
        input: ::std::option::Option<
            aws_sdk_dynamodb::operation::transact_get_items::TransactGetItemsInput,
        >,
    ) -> Self {
        self.original_input = input;
        self
    }
    #[allow(missing_docs)]
    pub fn get_original_input(
        &self,
    ) -> &::std::option::Option<
        aws_sdk_dynamodb::operation::transact_get_items::TransactGetItemsInput,
    > {
        &self.original_input
    }
    #[allow(missing_docs)]
    pub fn sdk_output(
        mut self,
        input: impl ::std::convert::Into<
            aws_sdk_dynamodb::operation::transact_get_items::TransactGetItemsOutput,
        >,
    ) -> Self {
        self.sdk_output = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_sdk_output(
        mut self,
        input: ::std::option::Option<
            aws_sdk_dynamodb::operation::transact_get_items::TransactGetItemsOutput,
        >,
    ) -> Self {
        self.sdk_output = input;
        self
    }
    #[allow(missing_docs)]
    pub fn get_sdk_output(
        &self,
    ) -> &::std::option::Option<
        aws_sdk_dynamodb::operation::transact_get_items::TransactGetItemsOutput,
    > {
        &self.sdk_output
    }
    /// Consumes the builder and constructs a [`TransactGetItemsOutputTransformInput`](crate::types::TransactGetItemsOutputTransformInput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::types::TransactGetItemsOutputTransformInput,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(crate::types::TransactGetItemsOutputTransformInput {
            original_input: self.original_input,
            sdk_output: self.sdk_output,
        })
    }
}
