// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(missing_docs)] // documentation missing in model
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
pub struct GetItemInputTransformInput {
    #[allow(missing_docs)] // documentation missing in model
    pub sdk_input: ::std::option::Option<aws_sdk_dynamodb::operation::get_item::GetItemInput>,
}
impl GetItemInputTransformInput {
    #[allow(missing_docs)] // documentation missing in model
    pub fn sdk_input(
        &self,
    ) -> &::std::option::Option<aws_sdk_dynamodb::operation::get_item::GetItemInput> {
        &self.sdk_input
    }
}
impl GetItemInputTransformInput {
    /// Creates a new builder-style object to manufacture [`GetItemInputTransformInput`](crate::operation::get_item_input_transform::builders::GetItemInputTransformInput).
    pub fn builder(
    ) -> crate::operation::get_item_input_transform::builders::GetItemInputTransformInputBuilder
    {
        crate::operation::get_item_input_transform::builders::GetItemInputTransformInputBuilder::default()
    }
}

/// A builder for [`GetItemInputTransformInput`](crate::operation::operation::GetItemInputTransformInput).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct GetItemInputTransformInputBuilder {
    pub(crate) sdk_input:
        ::std::option::Option<aws_sdk_dynamodb::operation::get_item::GetItemInput>,
}
impl GetItemInputTransformInputBuilder {
    #[allow(missing_docs)] // documentation missing in model
    pub fn sdk_input(
        mut self,
        input: impl ::std::convert::Into<aws_sdk_dynamodb::operation::get_item::GetItemInput>,
    ) -> Self {
        self.sdk_input = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn set_sdk_input(
        mut self,
        input: ::std::option::Option<aws_sdk_dynamodb::operation::get_item::GetItemInput>,
    ) -> Self {
        self.sdk_input = input;
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn get_sdk_input(
        &self,
    ) -> &::std::option::Option<aws_sdk_dynamodb::operation::get_item::GetItemInput> {
        &self.sdk_input
    }
    /// Consumes the builder and constructs a [`GetItemInputTransformInput`](crate::operation::operation::GetItemInputTransformInput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::operation::get_item_input_transform::GetItemInputTransformInput,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(
            crate::operation::get_item_input_transform::GetItemInputTransformInput {
                sdk_input: self.sdk_input,
            },
        )
    }
}
