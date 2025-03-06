// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
#[allow(missing_docs)]
pub struct QueryInputTransformInput {
    #[allow(missing_docs)]
    pub sdk_input: ::std::option::Option<aws_sdk_dynamodb::operation::query::QueryInput>,
}
impl QueryInputTransformInput {
    #[allow(missing_docs)]
    pub fn sdk_input(
        &self,
    ) -> &::std::option::Option<aws_sdk_dynamodb::operation::query::QueryInput> {
        &self.sdk_input
    }
}
impl QueryInputTransformInput {
    /// Creates a new builder-style object to manufacture [`QueryInputTransformInput`](crate::operation::query_input_transform::builders::QueryInputTransformInput).
    pub fn builder(
    ) -> crate::operation::query_input_transform::builders::QueryInputTransformInputBuilder {
        crate::operation::query_input_transform::builders::QueryInputTransformInputBuilder::default(
        )
    }
}

/// A builder for [`QueryInputTransformInput`](crate::operation::operation::QueryInputTransformInput).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct QueryInputTransformInputBuilder {
    pub(crate) sdk_input: ::std::option::Option<aws_sdk_dynamodb::operation::query::QueryInput>,
}
impl QueryInputTransformInputBuilder {
    #[allow(missing_docs)]
    pub fn sdk_input(
        mut self,
        input: impl ::std::convert::Into<aws_sdk_dynamodb::operation::query::QueryInput>,
    ) -> Self {
        self.sdk_input = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_sdk_input(
        mut self,
        input: ::std::option::Option<aws_sdk_dynamodb::operation::query::QueryInput>,
    ) -> Self {
        self.sdk_input = input;
        self
    }
    #[allow(missing_docs)]
    pub fn get_sdk_input(
        &self,
    ) -> &::std::option::Option<aws_sdk_dynamodb::operation::query::QueryInput> {
        &self.sdk_input
    }
    /// Consumes the builder and constructs a [`QueryInputTransformInput`](crate::operation::operation::QueryInputTransformInput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::operation::query_input_transform::QueryInputTransformInput,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(
            crate::operation::query_input_transform::QueryInputTransformInput {
                sdk_input: self.sdk_input,
            },
        )
    }
}
