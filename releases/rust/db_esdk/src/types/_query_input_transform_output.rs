// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
#[allow(missing_docs)]
pub struct QueryInputTransformOutput {
    #[allow(missing_docs)]
    pub transformed_input: ::std::option::Option<aws_sdk_dynamodb::operation::query::QueryInput>,
}
impl QueryInputTransformOutput {
    #[allow(missing_docs)]
    pub fn transformed_input(
        &self,
    ) -> &::std::option::Option<aws_sdk_dynamodb::operation::query::QueryInput> {
        &self.transformed_input
    }
}
impl QueryInputTransformOutput {
    /// Creates a new builder-style object to manufacture [`QueryInputTransformOutput`](crate::types::QueryInputTransformOutput).
    pub fn builder() -> crate::types::builders::QueryInputTransformOutputBuilder {
        crate::types::builders::QueryInputTransformOutputBuilder::default()
    }
}

/// A builder for [`QueryInputTransformOutput`](crate::types::QueryInputTransformOutput).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct QueryInputTransformOutputBuilder {
    pub(crate) transformed_input:
        ::std::option::Option<aws_sdk_dynamodb::operation::query::QueryInput>,
}
impl QueryInputTransformOutputBuilder {
    #[allow(missing_docs)]
    pub fn transformed_input(
        mut self,
        input: impl ::std::convert::Into<aws_sdk_dynamodb::operation::query::QueryInput>,
    ) -> Self {
        self.transformed_input = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_transformed_input(
        mut self,
        input: ::std::option::Option<aws_sdk_dynamodb::operation::query::QueryInput>,
    ) -> Self {
        self.transformed_input = input;
        self
    }
    #[allow(missing_docs)]
    pub fn get_transformed_input(
        &self,
    ) -> &::std::option::Option<aws_sdk_dynamodb::operation::query::QueryInput> {
        &self.transformed_input
    }
    /// Consumes the builder and constructs a [`QueryInputTransformOutput`](crate::types::QueryInputTransformOutput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::types::QueryInputTransformOutput,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(crate::types::QueryInputTransformOutput {
            transformed_input: self.transformed_input,
        })
    }
}
