// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
#[allow(missing_docs)]
pub struct ExecuteStatementOutputTransformInput {
    #[allow(missing_docs)]
    pub original_input: ::std::option::Option<
        aws_sdk_dynamodb::operation::execute_statement::ExecuteStatementInput,
    >,
    #[allow(missing_docs)]
    pub sdk_output: ::std::option::Option<
        aws_sdk_dynamodb::operation::execute_statement::ExecuteStatementOutput,
    >,
}
impl ExecuteStatementOutputTransformInput {
    #[allow(missing_docs)]
    pub fn original_input(
        &self,
    ) -> &::std::option::Option<aws_sdk_dynamodb::operation::execute_statement::ExecuteStatementInput>
    {
        &self.original_input
    }
    #[allow(missing_docs)]
    pub fn sdk_output(
        &self,
    ) -> &::std::option::Option<
        aws_sdk_dynamodb::operation::execute_statement::ExecuteStatementOutput,
    > {
        &self.sdk_output
    }
}
impl ExecuteStatementOutputTransformInput {
    /// Creates a new builder-style object to manufacture [`ExecuteStatementOutputTransformInput`](crate::types::ExecuteStatementOutputTransformInput).
    pub fn builder() -> crate::types::builders::ExecuteStatementOutputTransformInputBuilder {
        crate::types::builders::ExecuteStatementOutputTransformInputBuilder::default()
    }
}

/// A builder for [`ExecuteStatementOutputTransformInput`](crate::types::ExecuteStatementOutputTransformInput).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct ExecuteStatementOutputTransformInputBuilder {
    pub(crate) original_input: ::std::option::Option<
        aws_sdk_dynamodb::operation::execute_statement::ExecuteStatementInput,
    >,
    pub(crate) sdk_output: ::std::option::Option<
        aws_sdk_dynamodb::operation::execute_statement::ExecuteStatementOutput,
    >,
}
impl ExecuteStatementOutputTransformInputBuilder {
    #[allow(missing_docs)]
    pub fn original_input(
        mut self,
        input: impl ::std::convert::Into<
            aws_sdk_dynamodb::operation::execute_statement::ExecuteStatementInput,
        >,
    ) -> Self {
        self.original_input = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_original_input(
        mut self,
        input: ::std::option::Option<
            aws_sdk_dynamodb::operation::execute_statement::ExecuteStatementInput,
        >,
    ) -> Self {
        self.original_input = input;
        self
    }
    #[allow(missing_docs)]
    pub fn get_original_input(
        &self,
    ) -> &::std::option::Option<aws_sdk_dynamodb::operation::execute_statement::ExecuteStatementInput>
    {
        &self.original_input
    }
    #[allow(missing_docs)]
    pub fn sdk_output(
        mut self,
        input: impl ::std::convert::Into<
            aws_sdk_dynamodb::operation::execute_statement::ExecuteStatementOutput,
        >,
    ) -> Self {
        self.sdk_output = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_sdk_output(
        mut self,
        input: ::std::option::Option<
            aws_sdk_dynamodb::operation::execute_statement::ExecuteStatementOutput,
        >,
    ) -> Self {
        self.sdk_output = input;
        self
    }
    #[allow(missing_docs)]
    pub fn get_sdk_output(
        &self,
    ) -> &::std::option::Option<
        aws_sdk_dynamodb::operation::execute_statement::ExecuteStatementOutput,
    > {
        &self.sdk_output
    }
    /// Consumes the builder and constructs a [`ExecuteStatementOutputTransformInput`](crate::types::ExecuteStatementOutputTransformInput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::types::ExecuteStatementOutputTransformInput,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(crate::types::ExecuteStatementOutputTransformInput {
            original_input: self.original_input,
            sdk_output: self.sdk_output,
        })
    }
}
