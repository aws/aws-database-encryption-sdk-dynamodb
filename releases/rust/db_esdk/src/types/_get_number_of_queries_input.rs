// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
#[allow(missing_docs)]
pub struct GetNumberOfQueriesInput {
    #[allow(missing_docs)]
    pub input: ::std::option::Option<aws_sdk_dynamodb::operation::query::QueryInput>,
}
impl GetNumberOfQueriesInput {
    #[allow(missing_docs)]
    pub fn input(&self) -> &::std::option::Option<aws_sdk_dynamodb::operation::query::QueryInput> {
        &self.input
    }
}
impl GetNumberOfQueriesInput {
    /// Creates a new builder-style object to manufacture [`GetNumberOfQueriesInput`](crate::types::GetNumberOfQueriesInput).
    pub fn builder() -> crate::types::builders::GetNumberOfQueriesInputBuilder {
        crate::types::builders::GetNumberOfQueriesInputBuilder::default()
    }
}

/// A builder for [`GetNumberOfQueriesInput`](crate::types::GetNumberOfQueriesInput).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct GetNumberOfQueriesInputBuilder {
    pub(crate) input: ::std::option::Option<aws_sdk_dynamodb::operation::query::QueryInput>,
}
impl GetNumberOfQueriesInputBuilder {
    #[allow(missing_docs)]
    pub fn input(
        mut self,
        input: impl ::std::convert::Into<aws_sdk_dynamodb::operation::query::QueryInput>,
    ) -> Self {
        self.input = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_input(
        mut self,
        input: ::std::option::Option<aws_sdk_dynamodb::operation::query::QueryInput>,
    ) -> Self {
        self.input = input;
        self
    }
    #[allow(missing_docs)]
    pub fn get_input(
        &self,
    ) -> &::std::option::Option<aws_sdk_dynamodb::operation::query::QueryInput> {
        &self.input
    }
    /// Consumes the builder and constructs a [`GetNumberOfQueriesInput`](crate::types::GetNumberOfQueriesInput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::types::GetNumberOfQueriesInput,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(crate::types::GetNumberOfQueriesInput { input: self.input })
    }
}
