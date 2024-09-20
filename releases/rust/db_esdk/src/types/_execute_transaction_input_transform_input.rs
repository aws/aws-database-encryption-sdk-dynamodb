// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(missing_docs)] // documentation missing in model
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
pub struct ExecuteTransactionInputTransformInput {
    #[allow(missing_docs)] // documentation missing in model
    pub sdk_input: ::std::option::Option<
        aws_sdk_dynamodb::operation::execute_transaction::ExecuteTransactionInput,
    >,
}
impl ExecuteTransactionInputTransformInput {
    #[allow(missing_docs)] // documentation missing in model
    pub fn sdk_input(
        &self,
    ) -> &::std::option::Option<
        aws_sdk_dynamodb::operation::execute_transaction::ExecuteTransactionInput,
    > {
        &self.sdk_input
    }
}
impl ExecuteTransactionInputTransformInput {
    /// Creates a new builder-style object to manufacture [`ExecuteTransactionInputTransformInput`](crate::types::ExecuteTransactionInputTransformInput).
    pub fn builder() -> crate::types::builders::ExecuteTransactionInputTransformInputBuilder {
        crate::types::builders::ExecuteTransactionInputTransformInputBuilder::default()
    }
}

/// A builder for [`ExecuteTransactionInputTransformInput`](crate::types::ExecuteTransactionInputTransformInput).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct ExecuteTransactionInputTransformInputBuilder {
    pub(crate) sdk_input: ::std::option::Option<
        aws_sdk_dynamodb::operation::execute_transaction::ExecuteTransactionInput,
    >,
}
impl ExecuteTransactionInputTransformInputBuilder {
    #[allow(missing_docs)] // documentation missing in model
    pub fn sdk_input(
        mut self,
        input: impl ::std::convert::Into<
            aws_sdk_dynamodb::operation::execute_transaction::ExecuteTransactionInput,
        >,
    ) -> Self {
        self.sdk_input = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn set_sdk_input(
        mut self,
        input: ::std::option::Option<
            aws_sdk_dynamodb::operation::execute_transaction::ExecuteTransactionInput,
        >,
    ) -> Self {
        self.sdk_input = input;
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn get_sdk_input(
        &self,
    ) -> &::std::option::Option<
        aws_sdk_dynamodb::operation::execute_transaction::ExecuteTransactionInput,
    > {
        &self.sdk_input
    }
    /// Consumes the builder and constructs a [`ExecuteTransactionInputTransformInput`](crate::types::ExecuteTransactionInputTransformInput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::types::ExecuteTransactionInputTransformInput,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(crate::types::ExecuteTransactionInputTransformInput {
            sdk_input: self.sdk_input,
        })
    }
}
