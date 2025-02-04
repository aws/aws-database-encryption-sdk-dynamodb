// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
#[allow(missing_docs)]
pub struct ExecuteStatementOutputTransformOutput {
    #[allow(missing_docs)]
    pub transformed_output: ::std::option::Option<
        aws_sdk_dynamodb::operation::execute_statement::ExecuteStatementOutput,
    >,
}
impl ExecuteStatementOutputTransformOutput {
    #[allow(missing_docs)]
    pub fn transformed_output(
        &self,
    ) -> &::std::option::Option<
        aws_sdk_dynamodb::operation::execute_statement::ExecuteStatementOutput,
    > {
        &self.transformed_output
    }
}
impl ExecuteStatementOutputTransformOutput {
    /// Creates a new builder-style object to manufacture [`ExecuteStatementOutputTransformOutput`](crate::operation::execute_statement_output_transform::builders::ExecuteStatementOutputTransformOutput).
    pub fn builder() -> crate::operation::execute_statement_output_transform::builders::ExecuteStatementOutputTransformOutputBuilder{
        crate::operation::execute_statement_output_transform::builders::ExecuteStatementOutputTransformOutputBuilder::default()
    }
}

/// A builder for [`ExecuteStatementOutputTransformOutput`](crate::operation::operation::ExecuteStatementOutputTransformOutput).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct ExecuteStatementOutputTransformOutputBuilder {
    pub(crate) transformed_output: ::std::option::Option<
        aws_sdk_dynamodb::operation::execute_statement::ExecuteStatementOutput,
    >,
}
impl ExecuteStatementOutputTransformOutputBuilder {
    #[allow(missing_docs)]
    pub fn transformed_output(
        mut self,
        input: impl ::std::convert::Into<
            aws_sdk_dynamodb::operation::execute_statement::ExecuteStatementOutput,
        >,
    ) -> Self {
        self.transformed_output = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_transformed_output(
        mut self,
        input: ::std::option::Option<
            aws_sdk_dynamodb::operation::execute_statement::ExecuteStatementOutput,
        >,
    ) -> Self {
        self.transformed_output = input;
        self
    }
    #[allow(missing_docs)]
    pub fn get_transformed_output(
        &self,
    ) -> &::std::option::Option<
        aws_sdk_dynamodb::operation::execute_statement::ExecuteStatementOutput,
    > {
        &self.transformed_output
    }
    /// Consumes the builder and constructs a [`ExecuteStatementOutputTransformOutput`](crate::operation::operation::ExecuteStatementOutputTransformOutput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::operation::execute_statement_output_transform::ExecuteStatementOutputTransformOutput,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(crate::operation::execute_statement_output_transform::ExecuteStatementOutputTransformOutput {
            transformed_output: self.transformed_output,
        })
    }
}
