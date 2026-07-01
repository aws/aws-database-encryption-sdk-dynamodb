// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
impl crate::client::Client {
    /// Constructs a fluent builder for the [`GetNumberOfQueries`](crate::operation::get_number_of_queries::builders::GetNumberOfQueriesFluentBuilder) operation.
    ///
    /// - The fluent builder is configurable:
    ///   - [`input(impl Into<Option<aws_sdk_dynamodb::operation::query::QueryInput>>)`](crate::operation::get_number_of_queries::builders::GetNumberOfQueriesFluentBuilder::input) / [`set_input(Option<aws_sdk_dynamodb::operation::query::QueryInput>)`](crate::operation::get_number_of_queries::builders::GetNumberOfQueriesFluentBuilder::set_input): (undocumented)<br>
    /// - On success, responds with [`GetNumberOfQueriesOutput`](crate::operation::get_number_of_queries::GetNumberOfQueriesOutput) with field(s):
    ///   - [`number_of_queries(Option<::std::primitive::i32>)`](crate::operation::get_number_of_queries::GetNumberOfQueriesOutput::number_of_queries): (undocumented)
    /// - On failure, responds with [`SdkError<GetNumberOfQueriesError>`](crate::operation::get_number_of_queries::GetNumberOfQueriesError)
    pub fn get_number_of_queries(
        &self,
    ) -> crate::operation::get_number_of_queries::builders::GetNumberOfQueriesFluentBuilder {
        crate::operation::get_number_of_queries::builders::GetNumberOfQueriesFluentBuilder::new(
            self.clone(),
        )
    }
}
