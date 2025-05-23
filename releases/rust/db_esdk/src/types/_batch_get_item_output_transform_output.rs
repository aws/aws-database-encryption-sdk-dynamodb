// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
#[allow(missing_docs)]
pub struct BatchGetItemOutputTransformOutput {
    #[allow(missing_docs)]
    pub transformed_output:
        ::std::option::Option<aws_sdk_dynamodb::operation::batch_get_item::BatchGetItemOutput>,
}
impl BatchGetItemOutputTransformOutput {
    #[allow(missing_docs)]
    pub fn transformed_output(
        &self,
    ) -> &::std::option::Option<aws_sdk_dynamodb::operation::batch_get_item::BatchGetItemOutput>
    {
        &self.transformed_output
    }
}
impl BatchGetItemOutputTransformOutput {
    /// Creates a new builder-style object to manufacture [`BatchGetItemOutputTransformOutput`](crate::types::BatchGetItemOutputTransformOutput).
    pub fn builder() -> crate::types::builders::BatchGetItemOutputTransformOutputBuilder {
        crate::types::builders::BatchGetItemOutputTransformOutputBuilder::default()
    }
}

/// A builder for [`BatchGetItemOutputTransformOutput`](crate::types::BatchGetItemOutputTransformOutput).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct BatchGetItemOutputTransformOutputBuilder {
    pub(crate) transformed_output:
        ::std::option::Option<aws_sdk_dynamodb::operation::batch_get_item::BatchGetItemOutput>,
}
impl BatchGetItemOutputTransformOutputBuilder {
    #[allow(missing_docs)]
    pub fn transformed_output(
        mut self,
        input: impl ::std::convert::Into<
            aws_sdk_dynamodb::operation::batch_get_item::BatchGetItemOutput,
        >,
    ) -> Self {
        self.transformed_output = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_transformed_output(
        mut self,
        input: ::std::option::Option<
            aws_sdk_dynamodb::operation::batch_get_item::BatchGetItemOutput,
        >,
    ) -> Self {
        self.transformed_output = input;
        self
    }
    #[allow(missing_docs)]
    pub fn get_transformed_output(
        &self,
    ) -> &::std::option::Option<aws_sdk_dynamodb::operation::batch_get_item::BatchGetItemOutput>
    {
        &self.transformed_output
    }
    /// Consumes the builder and constructs a [`BatchGetItemOutputTransformOutput`](crate::types::BatchGetItemOutputTransformOutput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::types::BatchGetItemOutputTransformOutput,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(crate::types::BatchGetItemOutputTransformOutput {
            transformed_output: self.transformed_output,
        })
    }
}
