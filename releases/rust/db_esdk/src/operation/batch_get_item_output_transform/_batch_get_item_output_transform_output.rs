// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(missing_docs)] // documentation missing in model
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
pub struct BatchGetItemOutputTransformOutput {
    #[allow(missing_docs)] // documentation missing in model
    pub transformed_output:
        ::std::option::Option<aws_sdk_dynamodb::operation::batch_get_item::BatchGetItemOutput>,
}
impl BatchGetItemOutputTransformOutput {
    #[allow(missing_docs)] // documentation missing in model
    pub fn transformed_output(
        &self,
    ) -> &::std::option::Option<aws_sdk_dynamodb::operation::batch_get_item::BatchGetItemOutput>
    {
        &self.transformed_output
    }
}
impl BatchGetItemOutputTransformOutput {
    /// Creates a new builder-style object to manufacture [`BatchGetItemOutputTransformOutput`](crate::operation::batch_get_item_output_transform::builders::BatchGetItemOutputTransformOutput).
    pub fn builder() -> crate::operation::batch_get_item_output_transform::builders::BatchGetItemOutputTransformOutputBuilder{
        crate::operation::batch_get_item_output_transform::builders::BatchGetItemOutputTransformOutputBuilder::default()
    }
}

/// A builder for [`BatchGetItemOutputTransformOutput`](crate::operation::operation::BatchGetItemOutputTransformOutput).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct BatchGetItemOutputTransformOutputBuilder {
    pub(crate) transformed_output:
        ::std::option::Option<aws_sdk_dynamodb::operation::batch_get_item::BatchGetItemOutput>,
}
impl BatchGetItemOutputTransformOutputBuilder {
    #[allow(missing_docs)] // documentation missing in model
    pub fn transformed_output(
        mut self,
        input: impl ::std::convert::Into<
            aws_sdk_dynamodb::operation::batch_get_item::BatchGetItemOutput,
        >,
    ) -> Self {
        self.transformed_output = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn set_transformed_output(
        mut self,
        input: ::std::option::Option<
            aws_sdk_dynamodb::operation::batch_get_item::BatchGetItemOutput,
        >,
    ) -> Self {
        self.transformed_output = input;
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn get_transformed_output(
        &self,
    ) -> &::std::option::Option<aws_sdk_dynamodb::operation::batch_get_item::BatchGetItemOutput>
    {
        &self.transformed_output
    }
    /// Consumes the builder and constructs a [`BatchGetItemOutputTransformOutput`](crate::operation::operation::BatchGetItemOutputTransformOutput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::operation::batch_get_item_output_transform::BatchGetItemOutputTransformOutput,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(
            crate::operation::batch_get_item_output_transform::BatchGetItemOutputTransformOutput {
                transformed_output: self.transformed_output,
            },
        )
    }
}
