// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(missing_docs)] // documentation missing in model
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
pub struct BatchExecuteStatementInputTransformInput {
    #[allow(missing_docs)] // documentation missing in model
    pub sdk_input: ::std::option::Option<
        aws_sdk_dynamodb::operation::batch_execute_statement::BatchExecuteStatementInput,
    >,
}
impl BatchExecuteStatementInputTransformInput {
    #[allow(missing_docs)] // documentation missing in model
    pub fn sdk_input(
        &self,
    ) -> &::std::option::Option<
        aws_sdk_dynamodb::operation::batch_execute_statement::BatchExecuteStatementInput,
    > {
        &self.sdk_input
    }
}
impl BatchExecuteStatementInputTransformInput {
    /// Creates a new builder-style object to manufacture [`BatchExecuteStatementInputTransformInput`](crate::operation::batch_execute_statement_input_transform::builders::BatchExecuteStatementInputTransformInput).
    pub fn builder() -> crate::operation::batch_execute_statement_input_transform::builders::BatchExecuteStatementInputTransformInputBuilder{
        crate::operation::batch_execute_statement_input_transform::builders::BatchExecuteStatementInputTransformInputBuilder::default()
    }
}

/// A builder for [`BatchExecuteStatementInputTransformInput`](crate::operation::operation::BatchExecuteStatementInputTransformInput).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct BatchExecuteStatementInputTransformInputBuilder {
    pub(crate) sdk_input: ::std::option::Option<
        aws_sdk_dynamodb::operation::batch_execute_statement::BatchExecuteStatementInput,
    >,
}
impl BatchExecuteStatementInputTransformInputBuilder {
    #[allow(missing_docs)] // documentation missing in model
    pub fn sdk_input(
        mut self,
        input: impl ::std::convert::Into<
            aws_sdk_dynamodb::operation::batch_execute_statement::BatchExecuteStatementInput,
        >,
    ) -> Self {
        self.sdk_input = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn set_sdk_input(
        mut self,
        input: ::std::option::Option<
            aws_sdk_dynamodb::operation::batch_execute_statement::BatchExecuteStatementInput,
        >,
    ) -> Self {
        self.sdk_input = input;
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn get_sdk_input(
        &self,
    ) -> &::std::option::Option<
        aws_sdk_dynamodb::operation::batch_execute_statement::BatchExecuteStatementInput,
    > {
        &self.sdk_input
    }
    /// Consumes the builder and constructs a [`BatchExecuteStatementInputTransformInput`](crate::operation::operation::BatchExecuteStatementInputTransformInput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::operation::batch_execute_statement_input_transform::BatchExecuteStatementInputTransformInput,
        ::aws_smithy_types::error::operation::BuildError,
    >{
        ::std::result::Result::Ok(crate::operation::batch_execute_statement_input_transform::BatchExecuteStatementInputTransformInput {
            sdk_input: self.sdk_input,
        })
    }
}
