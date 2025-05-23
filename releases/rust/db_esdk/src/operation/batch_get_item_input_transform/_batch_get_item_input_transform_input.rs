// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
#[allow(missing_docs)]
pub struct BatchGetItemInputTransformInput {
    #[allow(missing_docs)]
    pub sdk_input:
        ::std::option::Option<aws_sdk_dynamodb::operation::batch_get_item::BatchGetItemInput>,
}
impl BatchGetItemInputTransformInput {
    #[allow(missing_docs)]
    pub fn sdk_input(
        &self,
    ) -> &::std::option::Option<aws_sdk_dynamodb::operation::batch_get_item::BatchGetItemInput>
    {
        &self.sdk_input
    }
}
impl BatchGetItemInputTransformInput {
    /// Creates a new builder-style object to manufacture [`BatchGetItemInputTransformInput`](crate::operation::batch_get_item_input_transform::builders::BatchGetItemInputTransformInput).
    pub fn builder() -> crate::operation::batch_get_item_input_transform::builders::BatchGetItemInputTransformInputBuilder{
        crate::operation::batch_get_item_input_transform::builders::BatchGetItemInputTransformInputBuilder::default()
    }
}

/// A builder for [`BatchGetItemInputTransformInput`](crate::operation::operation::BatchGetItemInputTransformInput).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct BatchGetItemInputTransformInputBuilder {
    pub(crate) sdk_input:
        ::std::option::Option<aws_sdk_dynamodb::operation::batch_get_item::BatchGetItemInput>,
}
impl BatchGetItemInputTransformInputBuilder {
    #[allow(missing_docs)]
    pub fn sdk_input(
        mut self,
        input: impl ::std::convert::Into<aws_sdk_dynamodb::operation::batch_get_item::BatchGetItemInput>,
    ) -> Self {
        self.sdk_input = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_sdk_input(
        mut self,
        input: ::std::option::Option<
            aws_sdk_dynamodb::operation::batch_get_item::BatchGetItemInput,
        >,
    ) -> Self {
        self.sdk_input = input;
        self
    }
    #[allow(missing_docs)]
    pub fn get_sdk_input(
        &self,
    ) -> &::std::option::Option<aws_sdk_dynamodb::operation::batch_get_item::BatchGetItemInput>
    {
        &self.sdk_input
    }
    /// Consumes the builder and constructs a [`BatchGetItemInputTransformInput`](crate::operation::operation::BatchGetItemInputTransformInput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::operation::batch_get_item_input_transform::BatchGetItemInputTransformInput,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(
            crate::operation::batch_get_item_input_transform::BatchGetItemInputTransformInput {
                sdk_input: self.sdk_input,
            },
        )
    }
}
