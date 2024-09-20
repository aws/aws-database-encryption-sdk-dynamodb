// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(missing_docs)] // documentation missing in model
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
pub struct GetItemOutputTransformInput {
    #[allow(missing_docs)] // documentation missing in model
    pub original_input: ::std::option::Option<aws_sdk_dynamodb::operation::get_item::GetItemInput>,
    #[allow(missing_docs)] // documentation missing in model
    pub sdk_output: ::std::option::Option<aws_sdk_dynamodb::operation::get_item::GetItemOutput>,
}
impl GetItemOutputTransformInput {
    #[allow(missing_docs)] // documentation missing in model
    pub fn original_input(
        &self,
    ) -> &::std::option::Option<aws_sdk_dynamodb::operation::get_item::GetItemInput> {
        &self.original_input
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn sdk_output(
        &self,
    ) -> &::std::option::Option<aws_sdk_dynamodb::operation::get_item::GetItemOutput> {
        &self.sdk_output
    }
}
impl GetItemOutputTransformInput {
    /// Creates a new builder-style object to manufacture [`GetItemOutputTransformInput`](crate::operation::get_item_output_transform::builders::GetItemOutputTransformInput).
    pub fn builder(
    ) -> crate::operation::get_item_output_transform::builders::GetItemOutputTransformInputBuilder
    {
        crate::operation::get_item_output_transform::builders::GetItemOutputTransformInputBuilder::default()
    }
}

/// A builder for [`GetItemOutputTransformInput`](crate::operation::operation::GetItemOutputTransformInput).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct GetItemOutputTransformInputBuilder {
    pub(crate) original_input:
        ::std::option::Option<aws_sdk_dynamodb::operation::get_item::GetItemInput>,
    pub(crate) sdk_output:
        ::std::option::Option<aws_sdk_dynamodb::operation::get_item::GetItemOutput>,
}
impl GetItemOutputTransformInputBuilder {
    #[allow(missing_docs)] // documentation missing in model
    pub fn original_input(
        mut self,
        input: impl ::std::convert::Into<aws_sdk_dynamodb::operation::get_item::GetItemInput>,
    ) -> Self {
        self.original_input = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn set_original_input(
        mut self,
        input: ::std::option::Option<aws_sdk_dynamodb::operation::get_item::GetItemInput>,
    ) -> Self {
        self.original_input = input;
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn get_original_input(
        &self,
    ) -> &::std::option::Option<aws_sdk_dynamodb::operation::get_item::GetItemInput> {
        &self.original_input
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn sdk_output(
        mut self,
        input: impl ::std::convert::Into<aws_sdk_dynamodb::operation::get_item::GetItemOutput>,
    ) -> Self {
        self.sdk_output = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn set_sdk_output(
        mut self,
        input: ::std::option::Option<aws_sdk_dynamodb::operation::get_item::GetItemOutput>,
    ) -> Self {
        self.sdk_output = input;
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn get_sdk_output(
        &self,
    ) -> &::std::option::Option<aws_sdk_dynamodb::operation::get_item::GetItemOutput> {
        &self.sdk_output
    }
    /// Consumes the builder and constructs a [`GetItemOutputTransformInput`](crate::operation::operation::GetItemOutputTransformInput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::operation::get_item_output_transform::GetItemOutputTransformInput,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(
            crate::operation::get_item_output_transform::GetItemOutputTransformInput {
                original_input: self.original_input,
                sdk_output: self.sdk_output,
            },
        )
    }
}
