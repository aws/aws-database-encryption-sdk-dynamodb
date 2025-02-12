// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
#[allow(missing_docs)]
pub struct ExecuteStatementInputTransformInput {
    #[allow(missing_docs)]
    pub sdk_input: ::std::option::Option<
        aws_sdk_dynamodb::operation::execute_statement::ExecuteStatementInput,
    >,
}
impl ExecuteStatementInputTransformInput {
    #[allow(missing_docs)]
    pub fn sdk_input(
        &self,
    ) -> &::std::option::Option<aws_sdk_dynamodb::operation::execute_statement::ExecuteStatementInput>
    {
        &self.sdk_input
    }
}
impl ExecuteStatementInputTransformInput {
    /// Creates a new builder-style object to manufacture [`ExecuteStatementInputTransformInput`](crate::types::ExecuteStatementInputTransformInput).
    pub fn builder() -> crate::types::builders::ExecuteStatementInputTransformInputBuilder {
        crate::types::builders::ExecuteStatementInputTransformInputBuilder::default()
    }
}

/// A builder for [`ExecuteStatementInputTransformInput`](crate::types::ExecuteStatementInputTransformInput).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct ExecuteStatementInputTransformInputBuilder {
    pub(crate) sdk_input: ::std::option::Option<
        aws_sdk_dynamodb::operation::execute_statement::ExecuteStatementInput,
    >,
}
impl ExecuteStatementInputTransformInputBuilder {
    #[allow(missing_docs)]
    pub fn sdk_input(
        mut self,
        input: impl ::std::convert::Into<
            aws_sdk_dynamodb::operation::execute_statement::ExecuteStatementInput,
        >,
    ) -> Self {
        self.sdk_input = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_sdk_input(
        mut self,
        input: ::std::option::Option<
            aws_sdk_dynamodb::operation::execute_statement::ExecuteStatementInput,
        >,
    ) -> Self {
        self.sdk_input = input;
        self
    }
    #[allow(missing_docs)]
    pub fn get_sdk_input(
        &self,
    ) -> &::std::option::Option<aws_sdk_dynamodb::operation::execute_statement::ExecuteStatementInput>
    {
        &self.sdk_input
    }
    /// Consumes the builder and constructs a [`ExecuteStatementInputTransformInput`](crate::types::ExecuteStatementInputTransformInput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::types::ExecuteStatementInputTransformInput,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(crate::types::ExecuteStatementInputTransformInput {
            sdk_input: self.sdk_input,
        })
    }
}
