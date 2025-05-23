// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
#[allow(missing_docs)]
pub struct UpdateItemInputTransformInput {
    #[allow(missing_docs)]
    pub sdk_input: ::std::option::Option<aws_sdk_dynamodb::operation::update_item::UpdateItemInput>,
}
impl UpdateItemInputTransformInput {
    #[allow(missing_docs)]
    pub fn sdk_input(
        &self,
    ) -> &::std::option::Option<aws_sdk_dynamodb::operation::update_item::UpdateItemInput> {
        &self.sdk_input
    }
}
impl UpdateItemInputTransformInput {
    /// Creates a new builder-style object to manufacture [`UpdateItemInputTransformInput`](crate::operation::update_item_input_transform::builders::UpdateItemInputTransformInput).
    pub fn builder(
    ) -> crate::operation::update_item_input_transform::builders::UpdateItemInputTransformInputBuilder
    {
        crate::operation::update_item_input_transform::builders::UpdateItemInputTransformInputBuilder::default()
    }
}

/// A builder for [`UpdateItemInputTransformInput`](crate::operation::operation::UpdateItemInputTransformInput).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct UpdateItemInputTransformInputBuilder {
    pub(crate) sdk_input:
        ::std::option::Option<aws_sdk_dynamodb::operation::update_item::UpdateItemInput>,
}
impl UpdateItemInputTransformInputBuilder {
    #[allow(missing_docs)]
    pub fn sdk_input(
        mut self,
        input: impl ::std::convert::Into<aws_sdk_dynamodb::operation::update_item::UpdateItemInput>,
    ) -> Self {
        self.sdk_input = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_sdk_input(
        mut self,
        input: ::std::option::Option<aws_sdk_dynamodb::operation::update_item::UpdateItemInput>,
    ) -> Self {
        self.sdk_input = input;
        self
    }
    #[allow(missing_docs)]
    pub fn get_sdk_input(
        &self,
    ) -> &::std::option::Option<aws_sdk_dynamodb::operation::update_item::UpdateItemInput> {
        &self.sdk_input
    }
    /// Consumes the builder and constructs a [`UpdateItemInputTransformInput`](crate::operation::operation::UpdateItemInputTransformInput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::operation::update_item_input_transform::UpdateItemInputTransformInput,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(
            crate::operation::update_item_input_transform::UpdateItemInputTransformInput {
                sdk_input: self.sdk_input,
            },
        )
    }
}
