// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
#[allow(missing_docs)]
pub struct ExecuteTransactionOutputTransformOutput {
    #[allow(missing_docs)]
    pub transformed_output: ::std::option::Option<
        aws_sdk_dynamodb::operation::execute_transaction::ExecuteTransactionOutput,
    >,
}
impl ExecuteTransactionOutputTransformOutput {
    #[allow(missing_docs)]
    pub fn transformed_output(
        &self,
    ) -> &::std::option::Option<
        aws_sdk_dynamodb::operation::execute_transaction::ExecuteTransactionOutput,
    > {
        &self.transformed_output
    }
}
impl ExecuteTransactionOutputTransformOutput {
    /// Creates a new builder-style object to manufacture [`ExecuteTransactionOutputTransformOutput`](crate::operation::execute_transaction_output_transform::builders::ExecuteTransactionOutputTransformOutput).
    pub fn builder() -> crate::operation::execute_transaction_output_transform::builders::ExecuteTransactionOutputTransformOutputBuilder{
        crate::operation::execute_transaction_output_transform::builders::ExecuteTransactionOutputTransformOutputBuilder::default()
    }
}

/// A builder for [`ExecuteTransactionOutputTransformOutput`](crate::operation::operation::ExecuteTransactionOutputTransformOutput).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct ExecuteTransactionOutputTransformOutputBuilder {
    pub(crate) transformed_output: ::std::option::Option<
        aws_sdk_dynamodb::operation::execute_transaction::ExecuteTransactionOutput,
    >,
}
impl ExecuteTransactionOutputTransformOutputBuilder {
    #[allow(missing_docs)]
    pub fn transformed_output(
        mut self,
        input: impl ::std::convert::Into<
            aws_sdk_dynamodb::operation::execute_transaction::ExecuteTransactionOutput,
        >,
    ) -> Self {
        self.transformed_output = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_transformed_output(
        mut self,
        input: ::std::option::Option<
            aws_sdk_dynamodb::operation::execute_transaction::ExecuteTransactionOutput,
        >,
    ) -> Self {
        self.transformed_output = input;
        self
    }
    #[allow(missing_docs)]
    pub fn get_transformed_output(
        &self,
    ) -> &::std::option::Option<
        aws_sdk_dynamodb::operation::execute_transaction::ExecuteTransactionOutput,
    > {
        &self.transformed_output
    }
    /// Consumes the builder and constructs a [`ExecuteTransactionOutputTransformOutput`](crate::operation::operation::ExecuteTransactionOutputTransformOutput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::operation::execute_transaction_output_transform::ExecuteTransactionOutputTransformOutput,
        ::aws_smithy_types::error::operation::BuildError,
    >{
        ::std::result::Result::Ok(crate::operation::execute_transaction_output_transform::ExecuteTransactionOutputTransformOutput {
            transformed_output: self.transformed_output,
        })
    }
}
