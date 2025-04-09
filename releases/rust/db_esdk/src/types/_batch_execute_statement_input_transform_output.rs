// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
#[allow(missing_docs)]
pub struct BatchExecuteStatementInputTransformOutput {
    #[allow(missing_docs)]
    pub transformed_input: ::std::option::Option<
        aws_sdk_dynamodb::operation::batch_execute_statement::BatchExecuteStatementInput,
    >,
}
impl BatchExecuteStatementInputTransformOutput {
    #[allow(missing_docs)]
    pub fn transformed_input(
        &self,
    ) -> &::std::option::Option<
        aws_sdk_dynamodb::operation::batch_execute_statement::BatchExecuteStatementInput,
    > {
        &self.transformed_input
    }
}
impl BatchExecuteStatementInputTransformOutput {
    /// Creates a new builder-style object to manufacture [`BatchExecuteStatementInputTransformOutput`](crate::types::BatchExecuteStatementInputTransformOutput).
    pub fn builder() -> crate::types::builders::BatchExecuteStatementInputTransformOutputBuilder {
        crate::types::builders::BatchExecuteStatementInputTransformOutputBuilder::default()
    }
}

/// A builder for [`BatchExecuteStatementInputTransformOutput`](crate::types::BatchExecuteStatementInputTransformOutput).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct BatchExecuteStatementInputTransformOutputBuilder {
    pub(crate) transformed_input: ::std::option::Option<
        aws_sdk_dynamodb::operation::batch_execute_statement::BatchExecuteStatementInput,
    >,
}
impl BatchExecuteStatementInputTransformOutputBuilder {
    #[allow(missing_docs)]
    pub fn transformed_input(
        mut self,
        input: impl ::std::convert::Into<
            aws_sdk_dynamodb::operation::batch_execute_statement::BatchExecuteStatementInput,
        >,
    ) -> Self {
        self.transformed_input = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_transformed_input(
        mut self,
        input: ::std::option::Option<
            aws_sdk_dynamodb::operation::batch_execute_statement::BatchExecuteStatementInput,
        >,
    ) -> Self {
        self.transformed_input = input;
        self
    }
    #[allow(missing_docs)]
    pub fn get_transformed_input(
        &self,
    ) -> &::std::option::Option<
        aws_sdk_dynamodb::operation::batch_execute_statement::BatchExecuteStatementInput,
    > {
        &self.transformed_input
    }
    /// Consumes the builder and constructs a [`BatchExecuteStatementInputTransformOutput`](crate::types::BatchExecuteStatementInputTransformOutput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::types::BatchExecuteStatementInputTransformOutput,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(crate::types::BatchExecuteStatementInputTransformOutput {
            transformed_input: self.transformed_input,
        })
    }
}
