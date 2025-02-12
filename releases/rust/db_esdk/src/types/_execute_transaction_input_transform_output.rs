// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
#[allow(missing_docs)]
pub struct ExecuteTransactionInputTransformOutput {
    #[allow(missing_docs)]
    pub transformed_input: ::std::option::Option<
        aws_sdk_dynamodb::operation::execute_transaction::ExecuteTransactionInput,
    >,
}
impl ExecuteTransactionInputTransformOutput {
    #[allow(missing_docs)]
    pub fn transformed_input(
        &self,
    ) -> &::std::option::Option<
        aws_sdk_dynamodb::operation::execute_transaction::ExecuteTransactionInput,
    > {
        &self.transformed_input
    }
}
impl ExecuteTransactionInputTransformOutput {
    /// Creates a new builder-style object to manufacture [`ExecuteTransactionInputTransformOutput`](crate::types::ExecuteTransactionInputTransformOutput).
    pub fn builder() -> crate::types::builders::ExecuteTransactionInputTransformOutputBuilder {
        crate::types::builders::ExecuteTransactionInputTransformOutputBuilder::default()
    }
}

/// A builder for [`ExecuteTransactionInputTransformOutput`](crate::types::ExecuteTransactionInputTransformOutput).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct ExecuteTransactionInputTransformOutputBuilder {
    pub(crate) transformed_input: ::std::option::Option<
        aws_sdk_dynamodb::operation::execute_transaction::ExecuteTransactionInput,
    >,
}
impl ExecuteTransactionInputTransformOutputBuilder {
    #[allow(missing_docs)]
    pub fn transformed_input(
        mut self,
        input: impl ::std::convert::Into<
            aws_sdk_dynamodb::operation::execute_transaction::ExecuteTransactionInput,
        >,
    ) -> Self {
        self.transformed_input = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_transformed_input(
        mut self,
        input: ::std::option::Option<
            aws_sdk_dynamodb::operation::execute_transaction::ExecuteTransactionInput,
        >,
    ) -> Self {
        self.transformed_input = input;
        self
    }
    #[allow(missing_docs)]
    pub fn get_transformed_input(
        &self,
    ) -> &::std::option::Option<
        aws_sdk_dynamodb::operation::execute_transaction::ExecuteTransactionInput,
    > {
        &self.transformed_input
    }
    /// Consumes the builder and constructs a [`ExecuteTransactionInputTransformOutput`](crate::types::ExecuteTransactionInputTransformOutput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::types::ExecuteTransactionInputTransformOutput,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(crate::types::ExecuteTransactionInputTransformOutput {
            transformed_input: self.transformed_input,
        })
    }
}
