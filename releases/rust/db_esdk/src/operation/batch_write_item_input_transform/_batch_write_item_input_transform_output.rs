// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(missing_docs)] // documentation missing in model
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
pub struct BatchWriteItemInputTransformOutput {
    #[allow(missing_docs)] // documentation missing in model
    pub transformed_input:
        ::std::option::Option<aws_sdk_dynamodb::operation::batch_write_item::BatchWriteItemInput>,
}
impl BatchWriteItemInputTransformOutput {
    #[allow(missing_docs)] // documentation missing in model
    pub fn transformed_input(
        &self,
    ) -> &::std::option::Option<aws_sdk_dynamodb::operation::batch_write_item::BatchWriteItemInput>
    {
        &self.transformed_input
    }
}
impl BatchWriteItemInputTransformOutput {
    /// Creates a new builder-style object to manufacture [`BatchWriteItemInputTransformOutput`](crate::operation::batch_write_item_input_transform::builders::BatchWriteItemInputTransformOutput).
    pub fn builder() -> crate::operation::batch_write_item_input_transform::builders::BatchWriteItemInputTransformOutputBuilder{
        crate::operation::batch_write_item_input_transform::builders::BatchWriteItemInputTransformOutputBuilder::default()
    }
}

/// A builder for [`BatchWriteItemInputTransformOutput`](crate::operation::operation::BatchWriteItemInputTransformOutput).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct BatchWriteItemInputTransformOutputBuilder {
    pub(crate) transformed_input:
        ::std::option::Option<aws_sdk_dynamodb::operation::batch_write_item::BatchWriteItemInput>,
}
impl BatchWriteItemInputTransformOutputBuilder {
    #[allow(missing_docs)] // documentation missing in model
    pub fn transformed_input(
        mut self,
        input: impl ::std::convert::Into<
            aws_sdk_dynamodb::operation::batch_write_item::BatchWriteItemInput,
        >,
    ) -> Self {
        self.transformed_input = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn set_transformed_input(
        mut self,
        input: ::std::option::Option<
            aws_sdk_dynamodb::operation::batch_write_item::BatchWriteItemInput,
        >,
    ) -> Self {
        self.transformed_input = input;
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn get_transformed_input(
        &self,
    ) -> &::std::option::Option<aws_sdk_dynamodb::operation::batch_write_item::BatchWriteItemInput>
    {
        &self.transformed_input
    }
    /// Consumes the builder and constructs a [`BatchWriteItemInputTransformOutput`](crate::operation::operation::BatchWriteItemInputTransformOutput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::operation::batch_write_item_input_transform::BatchWriteItemInputTransformOutput,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(crate::operation::batch_write_item_input_transform::BatchWriteItemInputTransformOutput {
            transformed_input: self.transformed_input,
        })
    }
}
