// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
#[allow(missing_docs)]
pub struct BatchGetItemOutputTransformInput {
    #[allow(missing_docs)]
    pub original_input:
        ::std::option::Option<aws_sdk_dynamodb::operation::batch_get_item::BatchGetItemInput>,
    #[allow(missing_docs)]
    pub sdk_output:
        ::std::option::Option<aws_sdk_dynamodb::operation::batch_get_item::BatchGetItemOutput>,
}
impl BatchGetItemOutputTransformInput {
    #[allow(missing_docs)]
    pub fn original_input(
        &self,
    ) -> &::std::option::Option<aws_sdk_dynamodb::operation::batch_get_item::BatchGetItemInput>
    {
        &self.original_input
    }
    #[allow(missing_docs)]
    pub fn sdk_output(
        &self,
    ) -> &::std::option::Option<aws_sdk_dynamodb::operation::batch_get_item::BatchGetItemOutput>
    {
        &self.sdk_output
    }
}
impl BatchGetItemOutputTransformInput {
    /// Creates a new builder-style object to manufacture [`BatchGetItemOutputTransformInput`](crate::operation::batch_get_item_output_transform::builders::BatchGetItemOutputTransformInput).
    pub fn builder() -> crate::operation::batch_get_item_output_transform::builders::BatchGetItemOutputTransformInputBuilder{
        crate::operation::batch_get_item_output_transform::builders::BatchGetItemOutputTransformInputBuilder::default()
    }
}

/// A builder for [`BatchGetItemOutputTransformInput`](crate::operation::operation::BatchGetItemOutputTransformInput).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct BatchGetItemOutputTransformInputBuilder {
    pub(crate) original_input:
        ::std::option::Option<aws_sdk_dynamodb::operation::batch_get_item::BatchGetItemInput>,
    pub(crate) sdk_output:
        ::std::option::Option<aws_sdk_dynamodb::operation::batch_get_item::BatchGetItemOutput>,
}
impl BatchGetItemOutputTransformInputBuilder {
    #[allow(missing_docs)]
    pub fn original_input(
        mut self,
        input: impl ::std::convert::Into<aws_sdk_dynamodb::operation::batch_get_item::BatchGetItemInput>,
    ) -> Self {
        self.original_input = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_original_input(
        mut self,
        input: ::std::option::Option<
            aws_sdk_dynamodb::operation::batch_get_item::BatchGetItemInput,
        >,
    ) -> Self {
        self.original_input = input;
        self
    }
    #[allow(missing_docs)]
    pub fn get_original_input(
        &self,
    ) -> &::std::option::Option<aws_sdk_dynamodb::operation::batch_get_item::BatchGetItemInput>
    {
        &self.original_input
    }
    #[allow(missing_docs)]
    pub fn sdk_output(
        mut self,
        input: impl ::std::convert::Into<
            aws_sdk_dynamodb::operation::batch_get_item::BatchGetItemOutput,
        >,
    ) -> Self {
        self.sdk_output = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_sdk_output(
        mut self,
        input: ::std::option::Option<
            aws_sdk_dynamodb::operation::batch_get_item::BatchGetItemOutput,
        >,
    ) -> Self {
        self.sdk_output = input;
        self
    }
    #[allow(missing_docs)]
    pub fn get_sdk_output(
        &self,
    ) -> &::std::option::Option<aws_sdk_dynamodb::operation::batch_get_item::BatchGetItemOutput>
    {
        &self.sdk_output
    }
    /// Consumes the builder and constructs a [`BatchGetItemOutputTransformInput`](crate::operation::operation::BatchGetItemOutputTransformInput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::operation::batch_get_item_output_transform::BatchGetItemOutputTransformInput,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(
            crate::operation::batch_get_item_output_transform::BatchGetItemOutputTransformInput {
                original_input: self.original_input,
                sdk_output: self.sdk_output,
            },
        )
    }
}
