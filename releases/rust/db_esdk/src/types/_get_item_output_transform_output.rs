// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
#[allow(missing_docs)]
pub struct GetItemOutputTransformOutput {
    #[allow(missing_docs)]
    pub transformed_output:
        ::std::option::Option<aws_sdk_dynamodb::operation::get_item::GetItemOutput>,
}
impl GetItemOutputTransformOutput {
    #[allow(missing_docs)]
    pub fn transformed_output(
        &self,
    ) -> &::std::option::Option<aws_sdk_dynamodb::operation::get_item::GetItemOutput> {
        &self.transformed_output
    }
}
impl GetItemOutputTransformOutput {
    /// Creates a new builder-style object to manufacture [`GetItemOutputTransformOutput`](crate::types::GetItemOutputTransformOutput).
    pub fn builder() -> crate::types::builders::GetItemOutputTransformOutputBuilder {
        crate::types::builders::GetItemOutputTransformOutputBuilder::default()
    }
}

/// A builder for [`GetItemOutputTransformOutput`](crate::types::GetItemOutputTransformOutput).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct GetItemOutputTransformOutputBuilder {
    pub(crate) transformed_output:
        ::std::option::Option<aws_sdk_dynamodb::operation::get_item::GetItemOutput>,
}
impl GetItemOutputTransformOutputBuilder {
    #[allow(missing_docs)]
    pub fn transformed_output(
        mut self,
        input: impl ::std::convert::Into<aws_sdk_dynamodb::operation::get_item::GetItemOutput>,
    ) -> Self {
        self.transformed_output = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_transformed_output(
        mut self,
        input: ::std::option::Option<aws_sdk_dynamodb::operation::get_item::GetItemOutput>,
    ) -> Self {
        self.transformed_output = input;
        self
    }
    #[allow(missing_docs)]
    pub fn get_transformed_output(
        &self,
    ) -> &::std::option::Option<aws_sdk_dynamodb::operation::get_item::GetItemOutput> {
        &self.transformed_output
    }
    /// Consumes the builder and constructs a [`GetItemOutputTransformOutput`](crate::types::GetItemOutputTransformOutput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::types::GetItemOutputTransformOutput,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(crate::types::GetItemOutputTransformOutput {
            transformed_output: self.transformed_output,
        })
    }
}
