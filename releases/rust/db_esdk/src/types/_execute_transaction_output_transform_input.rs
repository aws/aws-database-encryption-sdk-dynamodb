// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
#[allow(missing_docs)]
pub struct ExecuteTransactionOutputTransformInput {
    #[allow(missing_docs)]
    pub original_input: ::std::option::Option<
        aws_sdk_dynamodb::operation::execute_transaction::ExecuteTransactionInput,
    >,
    #[allow(missing_docs)]
    pub sdk_output: ::std::option::Option<
        aws_sdk_dynamodb::operation::execute_transaction::ExecuteTransactionOutput,
    >,
}
impl ExecuteTransactionOutputTransformInput {
    #[allow(missing_docs)]
    pub fn original_input(
        &self,
    ) -> &::std::option::Option<
        aws_sdk_dynamodb::operation::execute_transaction::ExecuteTransactionInput,
    > {
        &self.original_input
    }
    #[allow(missing_docs)]
    pub fn sdk_output(
        &self,
    ) -> &::std::option::Option<
        aws_sdk_dynamodb::operation::execute_transaction::ExecuteTransactionOutput,
    > {
        &self.sdk_output
    }
}
impl ExecuteTransactionOutputTransformInput {
    /// Creates a new builder-style object to manufacture [`ExecuteTransactionOutputTransformInput`](crate::types::ExecuteTransactionOutputTransformInput).
    pub fn builder() -> crate::types::builders::ExecuteTransactionOutputTransformInputBuilder {
        crate::types::builders::ExecuteTransactionOutputTransformInputBuilder::default()
    }
}

/// A builder for [`ExecuteTransactionOutputTransformInput`](crate::types::ExecuteTransactionOutputTransformInput).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct ExecuteTransactionOutputTransformInputBuilder {
    pub(crate) original_input: ::std::option::Option<
        aws_sdk_dynamodb::operation::execute_transaction::ExecuteTransactionInput,
    >,
    pub(crate) sdk_output: ::std::option::Option<
        aws_sdk_dynamodb::operation::execute_transaction::ExecuteTransactionOutput,
    >,
}
impl ExecuteTransactionOutputTransformInputBuilder {
    #[allow(missing_docs)]
    pub fn original_input(
        mut self,
        input: impl ::std::convert::Into<
            aws_sdk_dynamodb::operation::execute_transaction::ExecuteTransactionInput,
        >,
    ) -> Self {
        self.original_input = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_original_input(
        mut self,
        input: ::std::option::Option<
            aws_sdk_dynamodb::operation::execute_transaction::ExecuteTransactionInput,
        >,
    ) -> Self {
        self.original_input = input;
        self
    }
    #[allow(missing_docs)]
    pub fn get_original_input(
        &self,
    ) -> &::std::option::Option<
        aws_sdk_dynamodb::operation::execute_transaction::ExecuteTransactionInput,
    > {
        &self.original_input
    }
    #[allow(missing_docs)]
    pub fn sdk_output(
        mut self,
        input: impl ::std::convert::Into<
            aws_sdk_dynamodb::operation::execute_transaction::ExecuteTransactionOutput,
        >,
    ) -> Self {
        self.sdk_output = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_sdk_output(
        mut self,
        input: ::std::option::Option<
            aws_sdk_dynamodb::operation::execute_transaction::ExecuteTransactionOutput,
        >,
    ) -> Self {
        self.sdk_output = input;
        self
    }
    #[allow(missing_docs)]
    pub fn get_sdk_output(
        &self,
    ) -> &::std::option::Option<
        aws_sdk_dynamodb::operation::execute_transaction::ExecuteTransactionOutput,
    > {
        &self.sdk_output
    }
    /// Consumes the builder and constructs a [`ExecuteTransactionOutputTransformInput`](crate::types::ExecuteTransactionOutputTransformInput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::types::ExecuteTransactionOutputTransformInput,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(crate::types::ExecuteTransactionOutputTransformInput {
            original_input: self.original_input,
            sdk_output: self.sdk_output,
        })
    }
}
