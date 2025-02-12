// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
#[allow(missing_docs)]
pub struct PutItemOutputTransformOutput {
    #[allow(missing_docs)]
    pub transformed_output:
        ::std::option::Option<aws_sdk_dynamodb::operation::put_item::PutItemOutput>,
}
impl PutItemOutputTransformOutput {
    #[allow(missing_docs)]
    pub fn transformed_output(
        &self,
    ) -> &::std::option::Option<aws_sdk_dynamodb::operation::put_item::PutItemOutput> {
        &self.transformed_output
    }
}
impl PutItemOutputTransformOutput {
    /// Creates a new builder-style object to manufacture [`PutItemOutputTransformOutput`](crate::operation::put_item_output_transform::builders::PutItemOutputTransformOutput).
    pub fn builder(
    ) -> crate::operation::put_item_output_transform::builders::PutItemOutputTransformOutputBuilder
    {
        crate::operation::put_item_output_transform::builders::PutItemOutputTransformOutputBuilder::default()
    }
}

/// A builder for [`PutItemOutputTransformOutput`](crate::operation::operation::PutItemOutputTransformOutput).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct PutItemOutputTransformOutputBuilder {
    pub(crate) transformed_output:
        ::std::option::Option<aws_sdk_dynamodb::operation::put_item::PutItemOutput>,
}
impl PutItemOutputTransformOutputBuilder {
    #[allow(missing_docs)]
    pub fn transformed_output(
        mut self,
        input: impl ::std::convert::Into<aws_sdk_dynamodb::operation::put_item::PutItemOutput>,
    ) -> Self {
        self.transformed_output = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_transformed_output(
        mut self,
        input: ::std::option::Option<aws_sdk_dynamodb::operation::put_item::PutItemOutput>,
    ) -> Self {
        self.transformed_output = input;
        self
    }
    #[allow(missing_docs)]
    pub fn get_transformed_output(
        &self,
    ) -> &::std::option::Option<aws_sdk_dynamodb::operation::put_item::PutItemOutput> {
        &self.transformed_output
    }
    /// Consumes the builder and constructs a [`PutItemOutputTransformOutput`](crate::operation::operation::PutItemOutputTransformOutput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::operation::put_item_output_transform::PutItemOutputTransformOutput,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(
            crate::operation::put_item_output_transform::PutItemOutputTransformOutput {
                transformed_output: self.transformed_output,
            },
        )
    }
}
