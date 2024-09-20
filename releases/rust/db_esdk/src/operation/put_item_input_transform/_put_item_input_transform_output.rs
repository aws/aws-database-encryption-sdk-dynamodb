// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(missing_docs)] // documentation missing in model
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
pub struct PutItemInputTransformOutput {
    #[allow(missing_docs)] // documentation missing in model
    pub transformed_input:
        ::std::option::Option<aws_sdk_dynamodb::operation::put_item::PutItemInput>,
}
impl PutItemInputTransformOutput {
    #[allow(missing_docs)] // documentation missing in model
    pub fn transformed_input(
        &self,
    ) -> &::std::option::Option<aws_sdk_dynamodb::operation::put_item::PutItemInput> {
        &self.transformed_input
    }
}
impl PutItemInputTransformOutput {
    /// Creates a new builder-style object to manufacture [`PutItemInputTransformOutput`](crate::operation::put_item_input_transform::builders::PutItemInputTransformOutput).
    pub fn builder(
    ) -> crate::operation::put_item_input_transform::builders::PutItemInputTransformOutputBuilder
    {
        crate::operation::put_item_input_transform::builders::PutItemInputTransformOutputBuilder::default()
    }
}

/// A builder for [`PutItemInputTransformOutput`](crate::operation::operation::PutItemInputTransformOutput).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct PutItemInputTransformOutputBuilder {
    pub(crate) transformed_input:
        ::std::option::Option<aws_sdk_dynamodb::operation::put_item::PutItemInput>,
}
impl PutItemInputTransformOutputBuilder {
    #[allow(missing_docs)] // documentation missing in model
    pub fn transformed_input(
        mut self,
        input: impl ::std::convert::Into<aws_sdk_dynamodb::operation::put_item::PutItemInput>,
    ) -> Self {
        self.transformed_input = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn set_transformed_input(
        mut self,
        input: ::std::option::Option<aws_sdk_dynamodb::operation::put_item::PutItemInput>,
    ) -> Self {
        self.transformed_input = input;
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn get_transformed_input(
        &self,
    ) -> &::std::option::Option<aws_sdk_dynamodb::operation::put_item::PutItemInput> {
        &self.transformed_input
    }
    /// Consumes the builder and constructs a [`PutItemInputTransformOutput`](crate::operation::operation::PutItemInputTransformOutput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::operation::put_item_input_transform::PutItemInputTransformOutput,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(
            crate::operation::put_item_input_transform::PutItemInputTransformOutput {
                transformed_input: self.transformed_input,
            },
        )
    }
}
