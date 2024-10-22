// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
#[allow(missing_docs)]
pub struct UpdateItemInputTransformOutput {
    #[allow(missing_docs)]
pub transformed_input: ::std::option::Option<aws_sdk_dynamodb::operation::update_item::UpdateItemInput>,
}
impl UpdateItemInputTransformOutput {
    #[allow(missing_docs)]
pub fn transformed_input(&self) -> &::std::option::Option<aws_sdk_dynamodb::operation::update_item::UpdateItemInput> {
    &self.transformed_input
}
}
impl UpdateItemInputTransformOutput {
    /// Creates a new builder-style object to manufacture [`UpdateItemInputTransformOutput`](crate::types::UpdateItemInputTransformOutput).
    pub fn builder() -> crate::types::builders::UpdateItemInputTransformOutputBuilder {
        crate::types::builders::UpdateItemInputTransformOutputBuilder::default()
    }
}

/// A builder for [`UpdateItemInputTransformOutput`](crate::types::UpdateItemInputTransformOutput).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct UpdateItemInputTransformOutputBuilder {
    pub(crate) transformed_input: ::std::option::Option<aws_sdk_dynamodb::operation::update_item::UpdateItemInput>,
}
impl UpdateItemInputTransformOutputBuilder {
    #[allow(missing_docs)]
pub fn transformed_input(mut self, input: impl ::std::convert::Into<aws_sdk_dynamodb::operation::update_item::UpdateItemInput>) -> Self {
    self.transformed_input = ::std::option::Option::Some(input.into());
    self
}
#[allow(missing_docs)]
pub fn set_transformed_input(mut self, input: ::std::option::Option<aws_sdk_dynamodb::operation::update_item::UpdateItemInput>) -> Self {
    self.transformed_input = input;
    self
}
#[allow(missing_docs)]
pub fn get_transformed_input(&self) -> &::std::option::Option<aws_sdk_dynamodb::operation::update_item::UpdateItemInput> {
    &self.transformed_input
}
    /// Consumes the builder and constructs a [`UpdateItemInputTransformOutput`](crate::types::UpdateItemInputTransformOutput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::types::UpdateItemInputTransformOutput,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(crate::types::UpdateItemInputTransformOutput {
            transformed_input: self.transformed_input,
        })
    }
}
