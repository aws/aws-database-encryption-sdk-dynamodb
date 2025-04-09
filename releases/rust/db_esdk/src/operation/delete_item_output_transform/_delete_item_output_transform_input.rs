// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
#[allow(missing_docs)]
pub struct DeleteItemOutputTransformInput {
    #[allow(missing_docs)]
    pub original_input:
        ::std::option::Option<aws_sdk_dynamodb::operation::delete_item::DeleteItemInput>,
    #[allow(missing_docs)]
    pub sdk_output:
        ::std::option::Option<aws_sdk_dynamodb::operation::delete_item::DeleteItemOutput>,
}
impl DeleteItemOutputTransformInput {
    #[allow(missing_docs)]
    pub fn original_input(
        &self,
    ) -> &::std::option::Option<aws_sdk_dynamodb::operation::delete_item::DeleteItemInput> {
        &self.original_input
    }
    #[allow(missing_docs)]
    pub fn sdk_output(
        &self,
    ) -> &::std::option::Option<aws_sdk_dynamodb::operation::delete_item::DeleteItemOutput> {
        &self.sdk_output
    }
}
impl DeleteItemOutputTransformInput {
    /// Creates a new builder-style object to manufacture [`DeleteItemOutputTransformInput`](crate::operation::delete_item_output_transform::builders::DeleteItemOutputTransformInput).
    pub fn builder() -> crate::operation::delete_item_output_transform::builders::DeleteItemOutputTransformInputBuilder{
        crate::operation::delete_item_output_transform::builders::DeleteItemOutputTransformInputBuilder::default()
    }
}

/// A builder for [`DeleteItemOutputTransformInput`](crate::operation::operation::DeleteItemOutputTransformInput).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct DeleteItemOutputTransformInputBuilder {
    pub(crate) original_input:
        ::std::option::Option<aws_sdk_dynamodb::operation::delete_item::DeleteItemInput>,
    pub(crate) sdk_output:
        ::std::option::Option<aws_sdk_dynamodb::operation::delete_item::DeleteItemOutput>,
}
impl DeleteItemOutputTransformInputBuilder {
    #[allow(missing_docs)]
    pub fn original_input(
        mut self,
        input: impl ::std::convert::Into<aws_sdk_dynamodb::operation::delete_item::DeleteItemInput>,
    ) -> Self {
        self.original_input = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_original_input(
        mut self,
        input: ::std::option::Option<aws_sdk_dynamodb::operation::delete_item::DeleteItemInput>,
    ) -> Self {
        self.original_input = input;
        self
    }
    #[allow(missing_docs)]
    pub fn get_original_input(
        &self,
    ) -> &::std::option::Option<aws_sdk_dynamodb::operation::delete_item::DeleteItemInput> {
        &self.original_input
    }
    #[allow(missing_docs)]
    pub fn sdk_output(
        mut self,
        input: impl ::std::convert::Into<aws_sdk_dynamodb::operation::delete_item::DeleteItemOutput>,
    ) -> Self {
        self.sdk_output = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_sdk_output(
        mut self,
        input: ::std::option::Option<aws_sdk_dynamodb::operation::delete_item::DeleteItemOutput>,
    ) -> Self {
        self.sdk_output = input;
        self
    }
    #[allow(missing_docs)]
    pub fn get_sdk_output(
        &self,
    ) -> &::std::option::Option<aws_sdk_dynamodb::operation::delete_item::DeleteItemOutput> {
        &self.sdk_output
    }
    /// Consumes the builder and constructs a [`DeleteItemOutputTransformInput`](crate::operation::operation::DeleteItemOutputTransformInput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::operation::delete_item_output_transform::DeleteItemOutputTransformInput,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(
            crate::operation::delete_item_output_transform::DeleteItemOutputTransformInput {
                original_input: self.original_input,
                sdk_output: self.sdk_output,
            },
        )
    }
}
