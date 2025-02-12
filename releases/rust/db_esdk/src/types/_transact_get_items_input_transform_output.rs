// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
#[allow(missing_docs)]
pub struct TransactGetItemsInputTransformOutput {
    #[allow(missing_docs)]
    pub transformed_input: ::std::option::Option<
        aws_sdk_dynamodb::operation::transact_get_items::TransactGetItemsInput,
    >,
}
impl TransactGetItemsInputTransformOutput {
    #[allow(missing_docs)]
    pub fn transformed_input(
        &self,
    ) -> &::std::option::Option<
        aws_sdk_dynamodb::operation::transact_get_items::TransactGetItemsInput,
    > {
        &self.transformed_input
    }
}
impl TransactGetItemsInputTransformOutput {
    /// Creates a new builder-style object to manufacture [`TransactGetItemsInputTransformOutput`](crate::types::TransactGetItemsInputTransformOutput).
    pub fn builder() -> crate::types::builders::TransactGetItemsInputTransformOutputBuilder {
        crate::types::builders::TransactGetItemsInputTransformOutputBuilder::default()
    }
}

/// A builder for [`TransactGetItemsInputTransformOutput`](crate::types::TransactGetItemsInputTransformOutput).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct TransactGetItemsInputTransformOutputBuilder {
    pub(crate) transformed_input: ::std::option::Option<
        aws_sdk_dynamodb::operation::transact_get_items::TransactGetItemsInput,
    >,
}
impl TransactGetItemsInputTransformOutputBuilder {
    #[allow(missing_docs)]
    pub fn transformed_input(
        mut self,
        input: impl ::std::convert::Into<
            aws_sdk_dynamodb::operation::transact_get_items::TransactGetItemsInput,
        >,
    ) -> Self {
        self.transformed_input = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_transformed_input(
        mut self,
        input: ::std::option::Option<
            aws_sdk_dynamodb::operation::transact_get_items::TransactGetItemsInput,
        >,
    ) -> Self {
        self.transformed_input = input;
        self
    }
    #[allow(missing_docs)]
    pub fn get_transformed_input(
        &self,
    ) -> &::std::option::Option<
        aws_sdk_dynamodb::operation::transact_get_items::TransactGetItemsInput,
    > {
        &self.transformed_input
    }
    /// Consumes the builder and constructs a [`TransactGetItemsInputTransformOutput`](crate::types::TransactGetItemsInputTransformOutput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::types::TransactGetItemsInputTransformOutput,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(crate::types::TransactGetItemsInputTransformOutput {
            transformed_input: self.transformed_input,
        })
    }
}
