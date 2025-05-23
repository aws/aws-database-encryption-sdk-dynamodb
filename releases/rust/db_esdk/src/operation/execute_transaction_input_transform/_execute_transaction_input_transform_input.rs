// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
#[allow(missing_docs)]
pub struct ExecuteTransactionInputTransformInput {
    #[allow(missing_docs)]
    pub sdk_input: ::std::option::Option<
        aws_sdk_dynamodb::operation::execute_transaction::ExecuteTransactionInput,
    >,
}
impl ExecuteTransactionInputTransformInput {
    #[allow(missing_docs)]
    pub fn sdk_input(
        &self,
    ) -> &::std::option::Option<
        aws_sdk_dynamodb::operation::execute_transaction::ExecuteTransactionInput,
    > {
        &self.sdk_input
    }
}
impl ExecuteTransactionInputTransformInput {
    /// Creates a new builder-style object to manufacture [`ExecuteTransactionInputTransformInput`](crate::operation::execute_transaction_input_transform::builders::ExecuteTransactionInputTransformInput).
    pub fn builder() -> crate::operation::execute_transaction_input_transform::builders::ExecuteTransactionInputTransformInputBuilder{
        crate::operation::execute_transaction_input_transform::builders::ExecuteTransactionInputTransformInputBuilder::default()
    }
}

/// A builder for [`ExecuteTransactionInputTransformInput`](crate::operation::operation::ExecuteTransactionInputTransformInput).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct ExecuteTransactionInputTransformInputBuilder {
    pub(crate) sdk_input: ::std::option::Option<
        aws_sdk_dynamodb::operation::execute_transaction::ExecuteTransactionInput,
    >,
}
impl ExecuteTransactionInputTransformInputBuilder {
    #[allow(missing_docs)]
    pub fn sdk_input(
        mut self,
        input: impl ::std::convert::Into<
            aws_sdk_dynamodb::operation::execute_transaction::ExecuteTransactionInput,
        >,
    ) -> Self {
        self.sdk_input = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_sdk_input(
        mut self,
        input: ::std::option::Option<
            aws_sdk_dynamodb::operation::execute_transaction::ExecuteTransactionInput,
        >,
    ) -> Self {
        self.sdk_input = input;
        self
    }
    #[allow(missing_docs)]
    pub fn get_sdk_input(
        &self,
    ) -> &::std::option::Option<
        aws_sdk_dynamodb::operation::execute_transaction::ExecuteTransactionInput,
    > {
        &self.sdk_input
    }
    /// Consumes the builder and constructs a [`ExecuteTransactionInputTransformInput`](crate::operation::operation::ExecuteTransactionInputTransformInput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::operation::execute_transaction_input_transform::ExecuteTransactionInputTransformInput,
        ::aws_smithy_types::error::operation::BuildError,
    >{
        ::std::result::Result::Ok(crate::operation::execute_transaction_input_transform::ExecuteTransactionInputTransformInput {
            sdk_input: self.sdk_input,
        })
    }
}
