// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
#[allow(missing_docs)]
pub struct GetNumberOfQueriesOutput {
    #[allow(missing_docs)]
    pub number_of_queries: ::std::option::Option<::std::primitive::i32>,
}
impl GetNumberOfQueriesOutput {
    #[allow(missing_docs)]
    pub fn number_of_queries(&self) -> &::std::option::Option<::std::primitive::i32> {
        &self.number_of_queries
    }
}
impl GetNumberOfQueriesOutput {
    /// Creates a new builder-style object to manufacture [`GetNumberOfQueriesOutput`](crate::operation::get_number_of_queries::builders::GetNumberOfQueriesOutput).
    pub fn builder(
    ) -> crate::operation::get_number_of_queries::builders::GetNumberOfQueriesOutputBuilder {
        crate::operation::get_number_of_queries::builders::GetNumberOfQueriesOutputBuilder::default(
        )
    }
}

/// A builder for [`GetNumberOfQueriesOutput`](crate::operation::operation::GetNumberOfQueriesOutput).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct GetNumberOfQueriesOutputBuilder {
    pub(crate) number_of_queries: ::std::option::Option<::std::primitive::i32>,
}
impl GetNumberOfQueriesOutputBuilder {
    #[allow(missing_docs)]
    pub fn number_of_queries(
        mut self,
        input: impl ::std::convert::Into<::std::primitive::i32>,
    ) -> Self {
        self.number_of_queries = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_number_of_queries(
        mut self,
        input: ::std::option::Option<::std::primitive::i32>,
    ) -> Self {
        self.number_of_queries = input;
        self
    }
    #[allow(missing_docs)]
    pub fn get_number_of_queries(&self) -> &::std::option::Option<::std::primitive::i32> {
        &self.number_of_queries
    }
    /// Consumes the builder and constructs a [`GetNumberOfQueriesOutput`](crate::operation::operation::GetNumberOfQueriesOutput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::operation::get_number_of_queries::GetNumberOfQueriesOutput,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(
            crate::operation::get_number_of_queries::GetNumberOfQueriesOutput {
                number_of_queries: self.number_of_queries,
            },
        )
    }
}
