// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
#[allow(missing_docs)]
pub struct BatchWriteItemInputTransformOutput {
    #[allow(missing_docs)]
    pub transformed_input:
        ::std::option::Option<aws_sdk_dynamodb::operation::batch_write_item::BatchWriteItemInput>,
}
impl BatchWriteItemInputTransformOutput {
    #[allow(missing_docs)]
    pub fn transformed_input(
        &self,
    ) -> &::std::option::Option<aws_sdk_dynamodb::operation::batch_write_item::BatchWriteItemInput>
    {
        &self.transformed_input
    }
}
impl BatchWriteItemInputTransformOutput {
    /// Creates a new builder-style object to manufacture [`BatchWriteItemInputTransformOutput`](crate::types::BatchWriteItemInputTransformOutput).
    pub fn builder() -> crate::types::builders::BatchWriteItemInputTransformOutputBuilder {
        crate::types::builders::BatchWriteItemInputTransformOutputBuilder::default()
    }
}

/// A builder for [`BatchWriteItemInputTransformOutput`](crate::types::BatchWriteItemInputTransformOutput).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct BatchWriteItemInputTransformOutputBuilder {
    pub(crate) transformed_input:
        ::std::option::Option<aws_sdk_dynamodb::operation::batch_write_item::BatchWriteItemInput>,
}
impl BatchWriteItemInputTransformOutputBuilder {
    #[allow(missing_docs)]
    pub fn transformed_input(
        mut self,
        input: impl ::std::convert::Into<
            aws_sdk_dynamodb::operation::batch_write_item::BatchWriteItemInput,
        >,
    ) -> Self {
        self.transformed_input = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_transformed_input(
        mut self,
        input: ::std::option::Option<
            aws_sdk_dynamodb::operation::batch_write_item::BatchWriteItemInput,
        >,
    ) -> Self {
        self.transformed_input = input;
        self
    }
    #[allow(missing_docs)]
    pub fn get_transformed_input(
        &self,
    ) -> &::std::option::Option<aws_sdk_dynamodb::operation::batch_write_item::BatchWriteItemInput>
    {
        &self.transformed_input
    }
    /// Consumes the builder and constructs a [`BatchWriteItemInputTransformOutput`](crate::types::BatchWriteItemInputTransformOutput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::types::BatchWriteItemInputTransformOutput,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(crate::types::BatchWriteItemInputTransformOutput {
            transformed_input: self.transformed_input,
        })
    }
}
