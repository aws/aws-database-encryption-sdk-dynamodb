// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
#[allow(missing_docs)]
pub struct GetItemInputTransformOutput {
    #[allow(missing_docs)]
    pub transformed_input:
        ::std::option::Option<aws_sdk_dynamodb::operation::get_item::GetItemInput>,
}
impl GetItemInputTransformOutput {
    #[allow(missing_docs)]
    pub fn transformed_input(
        &self,
    ) -> &::std::option::Option<aws_sdk_dynamodb::operation::get_item::GetItemInput> {
        &self.transformed_input
    }
}
impl GetItemInputTransformOutput {
    /// Creates a new builder-style object to manufacture [`GetItemInputTransformOutput`](crate::operation::get_item_input_transform::builders::GetItemInputTransformOutput).
    pub fn builder(
    ) -> crate::operation::get_item_input_transform::builders::GetItemInputTransformOutputBuilder
    {
        crate::operation::get_item_input_transform::builders::GetItemInputTransformOutputBuilder::default()
    }
}

/// A builder for [`GetItemInputTransformOutput`](crate::operation::operation::GetItemInputTransformOutput).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct GetItemInputTransformOutputBuilder {
    pub(crate) transformed_input:
        ::std::option::Option<aws_sdk_dynamodb::operation::get_item::GetItemInput>,
}
impl GetItemInputTransformOutputBuilder {
    #[allow(missing_docs)]
    pub fn transformed_input(
        mut self,
        input: impl ::std::convert::Into<aws_sdk_dynamodb::operation::get_item::GetItemInput>,
    ) -> Self {
        self.transformed_input = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_transformed_input(
        mut self,
        input: ::std::option::Option<aws_sdk_dynamodb::operation::get_item::GetItemInput>,
    ) -> Self {
        self.transformed_input = input;
        self
    }
    #[allow(missing_docs)]
    pub fn get_transformed_input(
        &self,
    ) -> &::std::option::Option<aws_sdk_dynamodb::operation::get_item::GetItemInput> {
        &self.transformed_input
    }
    /// Consumes the builder and constructs a [`GetItemInputTransformOutput`](crate::operation::operation::GetItemInputTransformOutput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::operation::get_item_input_transform::GetItemInputTransformOutput,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(
            crate::operation::get_item_input_transform::GetItemInputTransformOutput {
                transformed_input: self.transformed_input,
            },
        )
    }
}
