// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
#[allow(missing_docs)]
pub struct BatchWriteItemOutputTransformOutput {
    #[allow(missing_docs)]
    pub transformed_output:
        ::std::option::Option<aws_sdk_dynamodb::operation::batch_write_item::BatchWriteItemOutput>,
}
impl BatchWriteItemOutputTransformOutput {
    #[allow(missing_docs)]
    pub fn transformed_output(
        &self,
    ) -> &::std::option::Option<aws_sdk_dynamodb::operation::batch_write_item::BatchWriteItemOutput>
    {
        &self.transformed_output
    }
}
impl BatchWriteItemOutputTransformOutput {
    /// Creates a new builder-style object to manufacture [`BatchWriteItemOutputTransformOutput`](crate::operation::batch_write_item_output_transform::builders::BatchWriteItemOutputTransformOutput).
    pub fn builder() -> crate::operation::batch_write_item_output_transform::builders::BatchWriteItemOutputTransformOutputBuilder{
        crate::operation::batch_write_item_output_transform::builders::BatchWriteItemOutputTransformOutputBuilder::default()
    }
}

/// A builder for [`BatchWriteItemOutputTransformOutput`](crate::operation::operation::BatchWriteItemOutputTransformOutput).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct BatchWriteItemOutputTransformOutputBuilder {
    pub(crate) transformed_output:
        ::std::option::Option<aws_sdk_dynamodb::operation::batch_write_item::BatchWriteItemOutput>,
}
impl BatchWriteItemOutputTransformOutputBuilder {
    #[allow(missing_docs)]
    pub fn transformed_output(
        mut self,
        input: impl ::std::convert::Into<
            aws_sdk_dynamodb::operation::batch_write_item::BatchWriteItemOutput,
        >,
    ) -> Self {
        self.transformed_output = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_transformed_output(
        mut self,
        input: ::std::option::Option<
            aws_sdk_dynamodb::operation::batch_write_item::BatchWriteItemOutput,
        >,
    ) -> Self {
        self.transformed_output = input;
        self
    }
    #[allow(missing_docs)]
    pub fn get_transformed_output(
        &self,
    ) -> &::std::option::Option<aws_sdk_dynamodb::operation::batch_write_item::BatchWriteItemOutput>
    {
        &self.transformed_output
    }
    /// Consumes the builder and constructs a [`BatchWriteItemOutputTransformOutput`](crate::operation::operation::BatchWriteItemOutputTransformOutput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::operation::batch_write_item_output_transform::BatchWriteItemOutputTransformOutput,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(crate::operation::batch_write_item_output_transform::BatchWriteItemOutputTransformOutput {
            transformed_output: self.transformed_output,
        })
    }
}
