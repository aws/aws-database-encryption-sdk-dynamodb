// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
#[allow(missing_docs)]
pub struct BatchExecuteStatementInputTransformInput {
    #[allow(missing_docs)]
    pub sdk_input: ::std::option::Option<
        aws_sdk_dynamodb::operation::batch_execute_statement::BatchExecuteStatementInput,
    >,
}
impl BatchExecuteStatementInputTransformInput {
    #[allow(missing_docs)]
    pub fn sdk_input(
        &self,
    ) -> &::std::option::Option<
        aws_sdk_dynamodb::operation::batch_execute_statement::BatchExecuteStatementInput,
    > {
        &self.sdk_input
    }
}
impl BatchExecuteStatementInputTransformInput {
    /// Creates a new builder-style object to manufacture [`BatchExecuteStatementInputTransformInput`](crate::types::BatchExecuteStatementInputTransformInput).
    pub fn builder() -> crate::types::builders::BatchExecuteStatementInputTransformInputBuilder {
        crate::types::builders::BatchExecuteStatementInputTransformInputBuilder::default()
    }
}

/// A builder for [`BatchExecuteStatementInputTransformInput`](crate::types::BatchExecuteStatementInputTransformInput).
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
    #[allow(missing_docs)]
    pub fn sdk_input(
        mut self,
        input: impl ::std::convert::Into<
            aws_sdk_dynamodb::operation::batch_execute_statement::BatchExecuteStatementInput,
        >,
    ) -> Self {
        self.sdk_input = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_sdk_input(
        mut self,
        input: ::std::option::Option<
            aws_sdk_dynamodb::operation::batch_execute_statement::BatchExecuteStatementInput,
        >,
    ) -> Self {
        self.sdk_input = input;
        self
    }
    #[allow(missing_docs)]
    pub fn get_sdk_input(
        &self,
    ) -> &::std::option::Option<
        aws_sdk_dynamodb::operation::batch_execute_statement::BatchExecuteStatementInput,
    > {
        &self.sdk_input
    }
    /// Consumes the builder and constructs a [`BatchExecuteStatementInputTransformInput`](crate::types::BatchExecuteStatementInputTransformInput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::types::BatchExecuteStatementInputTransformInput,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(crate::types::BatchExecuteStatementInputTransformInput {
            sdk_input: self.sdk_input,
        })
    }
}
