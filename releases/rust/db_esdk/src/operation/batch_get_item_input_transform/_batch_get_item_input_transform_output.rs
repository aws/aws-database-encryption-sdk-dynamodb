// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(missing_docs)] // documentation missing in model
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
pub struct BatchGetItemInputTransformOutput {
    #[allow(missing_docs)] // documentation missing in model
    pub transformed_input:
        ::std::option::Option<aws_sdk_dynamodb::operation::batch_get_item::BatchGetItemInput>,
}
impl BatchGetItemInputTransformOutput {
    #[allow(missing_docs)] // documentation missing in model
    pub fn transformed_input(
        &self,
    ) -> &::std::option::Option<aws_sdk_dynamodb::operation::batch_get_item::BatchGetItemInput>
    {
        &self.transformed_input
    }
}
impl BatchGetItemInputTransformOutput {
    /// Creates a new builder-style object to manufacture [`BatchGetItemInputTransformOutput`](crate::operation::batch_get_item_input_transform::builders::BatchGetItemInputTransformOutput).
    pub fn builder() -> crate::operation::batch_get_item_input_transform::builders::BatchGetItemInputTransformOutputBuilder{
        crate::operation::batch_get_item_input_transform::builders::BatchGetItemInputTransformOutputBuilder::default()
    }
}

/// A builder for [`BatchGetItemInputTransformOutput`](crate::operation::operation::BatchGetItemInputTransformOutput).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct BatchGetItemInputTransformOutputBuilder {
    pub(crate) transformed_input:
        ::std::option::Option<aws_sdk_dynamodb::operation::batch_get_item::BatchGetItemInput>,
}
impl BatchGetItemInputTransformOutputBuilder {
    #[allow(missing_docs)] // documentation missing in model
    pub fn transformed_input(
        mut self,
        input: impl ::std::convert::Into<aws_sdk_dynamodb::operation::batch_get_item::BatchGetItemInput>,
    ) -> Self {
        self.transformed_input = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn set_transformed_input(
        mut self,
        input: ::std::option::Option<
            aws_sdk_dynamodb::operation::batch_get_item::BatchGetItemInput,
        >,
    ) -> Self {
        self.transformed_input = input;
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn get_transformed_input(
        &self,
    ) -> &::std::option::Option<aws_sdk_dynamodb::operation::batch_get_item::BatchGetItemInput>
    {
        &self.transformed_input
    }
    /// Consumes the builder and constructs a [`BatchGetItemInputTransformOutput`](crate::operation::operation::BatchGetItemInputTransformOutput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::operation::batch_get_item_input_transform::BatchGetItemInputTransformOutput,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(
            crate::operation::batch_get_item_input_transform::BatchGetItemInputTransformOutput {
                transformed_input: self.transformed_input,
            },
        )
    }
}
