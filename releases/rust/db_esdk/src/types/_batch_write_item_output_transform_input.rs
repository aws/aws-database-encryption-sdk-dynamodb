// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(missing_docs)] // documentation missing in model
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
pub struct BatchWriteItemOutputTransformInput {
    #[allow(missing_docs)] // documentation missing in model
    pub original_input:
        ::std::option::Option<aws_sdk_dynamodb::operation::batch_write_item::BatchWriteItemInput>,
    #[allow(missing_docs)] // documentation missing in model
    pub sdk_output:
        ::std::option::Option<aws_sdk_dynamodb::operation::batch_write_item::BatchWriteItemOutput>,
}
impl BatchWriteItemOutputTransformInput {
    #[allow(missing_docs)] // documentation missing in model
    pub fn original_input(
        &self,
    ) -> &::std::option::Option<aws_sdk_dynamodb::operation::batch_write_item::BatchWriteItemInput>
    {
        &self.original_input
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn sdk_output(
        &self,
    ) -> &::std::option::Option<aws_sdk_dynamodb::operation::batch_write_item::BatchWriteItemOutput>
    {
        &self.sdk_output
    }
}
impl BatchWriteItemOutputTransformInput {
    /// Creates a new builder-style object to manufacture [`BatchWriteItemOutputTransformInput`](crate::types::BatchWriteItemOutputTransformInput).
    pub fn builder() -> crate::types::builders::BatchWriteItemOutputTransformInputBuilder {
        crate::types::builders::BatchWriteItemOutputTransformInputBuilder::default()
    }
}

/// A builder for [`BatchWriteItemOutputTransformInput`](crate::types::BatchWriteItemOutputTransformInput).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct BatchWriteItemOutputTransformInputBuilder {
    pub(crate) original_input:
        ::std::option::Option<aws_sdk_dynamodb::operation::batch_write_item::BatchWriteItemInput>,
    pub(crate) sdk_output:
        ::std::option::Option<aws_sdk_dynamodb::operation::batch_write_item::BatchWriteItemOutput>,
}
impl BatchWriteItemOutputTransformInputBuilder {
    #[allow(missing_docs)] // documentation missing in model
    pub fn original_input(
        mut self,
        input: impl ::std::convert::Into<
            aws_sdk_dynamodb::operation::batch_write_item::BatchWriteItemInput,
        >,
    ) -> Self {
        self.original_input = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn set_original_input(
        mut self,
        input: ::std::option::Option<
            aws_sdk_dynamodb::operation::batch_write_item::BatchWriteItemInput,
        >,
    ) -> Self {
        self.original_input = input;
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn get_original_input(
        &self,
    ) -> &::std::option::Option<aws_sdk_dynamodb::operation::batch_write_item::BatchWriteItemInput>
    {
        &self.original_input
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn sdk_output(
        mut self,
        input: impl ::std::convert::Into<
            aws_sdk_dynamodb::operation::batch_write_item::BatchWriteItemOutput,
        >,
    ) -> Self {
        self.sdk_output = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn set_sdk_output(
        mut self,
        input: ::std::option::Option<
            aws_sdk_dynamodb::operation::batch_write_item::BatchWriteItemOutput,
        >,
    ) -> Self {
        self.sdk_output = input;
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn get_sdk_output(
        &self,
    ) -> &::std::option::Option<aws_sdk_dynamodb::operation::batch_write_item::BatchWriteItemOutput>
    {
        &self.sdk_output
    }
    /// Consumes the builder and constructs a [`BatchWriteItemOutputTransformInput`](crate::types::BatchWriteItemOutputTransformInput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::types::BatchWriteItemOutputTransformInput,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(crate::types::BatchWriteItemOutputTransformInput {
            original_input: self.original_input,
            sdk_output: self.sdk_output,
        })
    }
}
