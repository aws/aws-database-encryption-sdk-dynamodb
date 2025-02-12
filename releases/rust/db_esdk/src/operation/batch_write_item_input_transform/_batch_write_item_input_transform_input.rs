// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
#[allow(missing_docs)]
pub struct BatchWriteItemInputTransformInput {
    #[allow(missing_docs)]
    pub sdk_input:
        ::std::option::Option<aws_sdk_dynamodb::operation::batch_write_item::BatchWriteItemInput>,
}
impl BatchWriteItemInputTransformInput {
    #[allow(missing_docs)]
    pub fn sdk_input(
        &self,
    ) -> &::std::option::Option<aws_sdk_dynamodb::operation::batch_write_item::BatchWriteItemInput>
    {
        &self.sdk_input
    }
}
impl BatchWriteItemInputTransformInput {
    /// Creates a new builder-style object to manufacture [`BatchWriteItemInputTransformInput`](crate::operation::batch_write_item_input_transform::builders::BatchWriteItemInputTransformInput).
    pub fn builder() -> crate::operation::batch_write_item_input_transform::builders::BatchWriteItemInputTransformInputBuilder{
        crate::operation::batch_write_item_input_transform::builders::BatchWriteItemInputTransformInputBuilder::default()
    }
}

/// A builder for [`BatchWriteItemInputTransformInput`](crate::operation::operation::BatchWriteItemInputTransformInput).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct BatchWriteItemInputTransformInputBuilder {
    pub(crate) sdk_input:
        ::std::option::Option<aws_sdk_dynamodb::operation::batch_write_item::BatchWriteItemInput>,
}
impl BatchWriteItemInputTransformInputBuilder {
    #[allow(missing_docs)]
    pub fn sdk_input(
        mut self,
        input: impl ::std::convert::Into<
            aws_sdk_dynamodb::operation::batch_write_item::BatchWriteItemInput,
        >,
    ) -> Self {
        self.sdk_input = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_sdk_input(
        mut self,
        input: ::std::option::Option<
            aws_sdk_dynamodb::operation::batch_write_item::BatchWriteItemInput,
        >,
    ) -> Self {
        self.sdk_input = input;
        self
    }
    #[allow(missing_docs)]
    pub fn get_sdk_input(
        &self,
    ) -> &::std::option::Option<aws_sdk_dynamodb::operation::batch_write_item::BatchWriteItemInput>
    {
        &self.sdk_input
    }
    /// Consumes the builder and constructs a [`BatchWriteItemInputTransformInput`](crate::operation::operation::BatchWriteItemInputTransformInput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::operation::batch_write_item_input_transform::BatchWriteItemInputTransformInput,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(
            crate::operation::batch_write_item_input_transform::BatchWriteItemInputTransformInput {
                sdk_input: self.sdk_input,
            },
        )
    }
}
