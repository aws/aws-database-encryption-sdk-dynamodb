// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(missing_docs)] // documentation missing in model
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
pub struct BatchWriteItemInputTransformInput {
    #[allow(missing_docs)] // documentation missing in model
    pub sdk_input:
        ::std::option::Option<aws_sdk_dynamodb::operation::batch_write_item::BatchWriteItemInput>,
}
impl BatchWriteItemInputTransformInput {
    #[allow(missing_docs)] // documentation missing in model
    pub fn sdk_input(
        &self,
    ) -> &::std::option::Option<aws_sdk_dynamodb::operation::batch_write_item::BatchWriteItemInput>
    {
        &self.sdk_input
    }
}
impl BatchWriteItemInputTransformInput {
    /// Creates a new builder-style object to manufacture [`BatchWriteItemInputTransformInput`](crate::types::BatchWriteItemInputTransformInput).
    pub fn builder() -> crate::types::builders::BatchWriteItemInputTransformInputBuilder {
        crate::types::builders::BatchWriteItemInputTransformInputBuilder::default()
    }
}

/// A builder for [`BatchWriteItemInputTransformInput`](crate::types::BatchWriteItemInputTransformInput).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct BatchWriteItemInputTransformInputBuilder {
    pub(crate) sdk_input:
        ::std::option::Option<aws_sdk_dynamodb::operation::batch_write_item::BatchWriteItemInput>,
}
impl BatchWriteItemInputTransformInputBuilder {
    #[allow(missing_docs)] // documentation missing in model
    pub fn sdk_input(
        mut self,
        input: impl ::std::convert::Into<
            aws_sdk_dynamodb::operation::batch_write_item::BatchWriteItemInput,
        >,
    ) -> Self {
        self.sdk_input = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn set_sdk_input(
        mut self,
        input: ::std::option::Option<
            aws_sdk_dynamodb::operation::batch_write_item::BatchWriteItemInput,
        >,
    ) -> Self {
        self.sdk_input = input;
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn get_sdk_input(
        &self,
    ) -> &::std::option::Option<aws_sdk_dynamodb::operation::batch_write_item::BatchWriteItemInput>
    {
        &self.sdk_input
    }
    /// Consumes the builder and constructs a [`BatchWriteItemInputTransformInput`](crate::types::BatchWriteItemInputTransformInput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::types::BatchWriteItemInputTransformInput,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(crate::types::BatchWriteItemInputTransformInput {
            sdk_input: self.sdk_input,
        })
    }
}