// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
#[allow(missing_docs)]
pub struct DeleteItemInputTransformInput {
    #[allow(missing_docs)]
    pub sdk_input: ::std::option::Option<aws_sdk_dynamodb::operation::delete_item::DeleteItemInput>,
}
impl DeleteItemInputTransformInput {
    #[allow(missing_docs)]
    pub fn sdk_input(
        &self,
    ) -> &::std::option::Option<aws_sdk_dynamodb::operation::delete_item::DeleteItemInput> {
        &self.sdk_input
    }
}
impl DeleteItemInputTransformInput {
    /// Creates a new builder-style object to manufacture [`DeleteItemInputTransformInput`](crate::operation::delete_item_input_transform::builders::DeleteItemInputTransformInput).
    pub fn builder(
    ) -> crate::operation::delete_item_input_transform::builders::DeleteItemInputTransformInputBuilder
    {
        crate::operation::delete_item_input_transform::builders::DeleteItemInputTransformInputBuilder::default()
    }
}

/// A builder for [`DeleteItemInputTransformInput`](crate::operation::operation::DeleteItemInputTransformInput).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct DeleteItemInputTransformInputBuilder {
    pub(crate) sdk_input:
        ::std::option::Option<aws_sdk_dynamodb::operation::delete_item::DeleteItemInput>,
}
impl DeleteItemInputTransformInputBuilder {
    #[allow(missing_docs)]
    pub fn sdk_input(
        mut self,
        input: impl ::std::convert::Into<aws_sdk_dynamodb::operation::delete_item::DeleteItemInput>,
    ) -> Self {
        self.sdk_input = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_sdk_input(
        mut self,
        input: ::std::option::Option<aws_sdk_dynamodb::operation::delete_item::DeleteItemInput>,
    ) -> Self {
        self.sdk_input = input;
        self
    }
    #[allow(missing_docs)]
    pub fn get_sdk_input(
        &self,
    ) -> &::std::option::Option<aws_sdk_dynamodb::operation::delete_item::DeleteItemInput> {
        &self.sdk_input
    }
    /// Consumes the builder and constructs a [`DeleteItemInputTransformInput`](crate::operation::operation::DeleteItemInputTransformInput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::operation::delete_item_input_transform::DeleteItemInputTransformInput,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(
            crate::operation::delete_item_input_transform::DeleteItemInputTransformInput {
                sdk_input: self.sdk_input,
            },
        )
    }
}
