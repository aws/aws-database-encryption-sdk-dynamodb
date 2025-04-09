// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
#[allow(missing_docs)]
pub struct TransactGetItemsInputTransformInput {
    #[allow(missing_docs)]
    pub sdk_input: ::std::option::Option<
        aws_sdk_dynamodb::operation::transact_get_items::TransactGetItemsInput,
    >,
}
impl TransactGetItemsInputTransformInput {
    #[allow(missing_docs)]
    pub fn sdk_input(
        &self,
    ) -> &::std::option::Option<
        aws_sdk_dynamodb::operation::transact_get_items::TransactGetItemsInput,
    > {
        &self.sdk_input
    }
}
impl TransactGetItemsInputTransformInput {
    /// Creates a new builder-style object to manufacture [`TransactGetItemsInputTransformInput`](crate::types::TransactGetItemsInputTransformInput).
    pub fn builder() -> crate::types::builders::TransactGetItemsInputTransformInputBuilder {
        crate::types::builders::TransactGetItemsInputTransformInputBuilder::default()
    }
}

/// A builder for [`TransactGetItemsInputTransformInput`](crate::types::TransactGetItemsInputTransformInput).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct TransactGetItemsInputTransformInputBuilder {
    pub(crate) sdk_input: ::std::option::Option<
        aws_sdk_dynamodb::operation::transact_get_items::TransactGetItemsInput,
    >,
}
impl TransactGetItemsInputTransformInputBuilder {
    #[allow(missing_docs)]
    pub fn sdk_input(
        mut self,
        input: impl ::std::convert::Into<
            aws_sdk_dynamodb::operation::transact_get_items::TransactGetItemsInput,
        >,
    ) -> Self {
        self.sdk_input = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_sdk_input(
        mut self,
        input: ::std::option::Option<
            aws_sdk_dynamodb::operation::transact_get_items::TransactGetItemsInput,
        >,
    ) -> Self {
        self.sdk_input = input;
        self
    }
    #[allow(missing_docs)]
    pub fn get_sdk_input(
        &self,
    ) -> &::std::option::Option<
        aws_sdk_dynamodb::operation::transact_get_items::TransactGetItemsInput,
    > {
        &self.sdk_input
    }
    /// Consumes the builder and constructs a [`TransactGetItemsInputTransformInput`](crate::types::TransactGetItemsInputTransformInput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::types::TransactGetItemsInputTransformInput,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(crate::types::TransactGetItemsInputTransformInput {
            sdk_input: self.sdk_input,
        })
    }
}
