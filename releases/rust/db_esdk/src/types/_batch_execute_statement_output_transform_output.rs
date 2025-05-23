// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
#[allow(missing_docs)]
pub struct BatchExecuteStatementOutputTransformOutput {
    #[allow(missing_docs)]
    pub transformed_output: ::std::option::Option<
        aws_sdk_dynamodb::operation::batch_execute_statement::BatchExecuteStatementOutput,
    >,
}
impl BatchExecuteStatementOutputTransformOutput {
    #[allow(missing_docs)]
    pub fn transformed_output(
        &self,
    ) -> &::std::option::Option<
        aws_sdk_dynamodb::operation::batch_execute_statement::BatchExecuteStatementOutput,
    > {
        &self.transformed_output
    }
}
impl BatchExecuteStatementOutputTransformOutput {
    /// Creates a new builder-style object to manufacture [`BatchExecuteStatementOutputTransformOutput`](crate::types::BatchExecuteStatementOutputTransformOutput).
    pub fn builder() -> crate::types::builders::BatchExecuteStatementOutputTransformOutputBuilder {
        crate::types::builders::BatchExecuteStatementOutputTransformOutputBuilder::default()
    }
}

/// A builder for [`BatchExecuteStatementOutputTransformOutput`](crate::types::BatchExecuteStatementOutputTransformOutput).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct BatchExecuteStatementOutputTransformOutputBuilder {
    pub(crate) transformed_output: ::std::option::Option<
        aws_sdk_dynamodb::operation::batch_execute_statement::BatchExecuteStatementOutput,
    >,
}
impl BatchExecuteStatementOutputTransformOutputBuilder {
    #[allow(missing_docs)]
    pub fn transformed_output(
        mut self,
        input: impl ::std::convert::Into<
            aws_sdk_dynamodb::operation::batch_execute_statement::BatchExecuteStatementOutput,
        >,
    ) -> Self {
        self.transformed_output = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_transformed_output(
        mut self,
        input: ::std::option::Option<
            aws_sdk_dynamodb::operation::batch_execute_statement::BatchExecuteStatementOutput,
        >,
    ) -> Self {
        self.transformed_output = input;
        self
    }
    #[allow(missing_docs)]
    pub fn get_transformed_output(
        &self,
    ) -> &::std::option::Option<
        aws_sdk_dynamodb::operation::batch_execute_statement::BatchExecuteStatementOutput,
    > {
        &self.transformed_output
    }
    /// Consumes the builder and constructs a [`BatchExecuteStatementOutputTransformOutput`](crate::types::BatchExecuteStatementOutputTransformOutput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::types::BatchExecuteStatementOutputTransformOutput,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(crate::types::BatchExecuteStatementOutputTransformOutput {
            transformed_output: self.transformed_output,
        })
    }
}
