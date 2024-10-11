// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
impl crate::client::Client {
    /// Constructs a fluent builder for the [`QueryOutputTransform`](crate::operation::query_output_transform::builders::QueryOutputTransformFluentBuilder) operation.
    ///
    /// - The fluent builder is configurable:
    ///   - [`original_input(impl Into<Option<aws_sdk_dynamodb::operation::query::QueryInput>>)`](crate::operation::query_output_transform::builders::QueryOutputTransformFluentBuilder::original_input) / [`set_original_input(Option<aws_sdk_dynamodb::operation::query::QueryInput>)`](crate::operation::query_output_transform::builders::QueryOutputTransformFluentBuilder::set_original_input): (undocumented)<br>
    ///   - [`sdk_output(impl Into<Option<aws_sdk_dynamodb::operation::query::QueryOutput>>)`](crate::operation::query_output_transform::builders::QueryOutputTransformFluentBuilder::sdk_output) / [`set_sdk_output(Option<aws_sdk_dynamodb::operation::query::QueryOutput>)`](crate::operation::query_output_transform::builders::QueryOutputTransformFluentBuilder::set_sdk_output): (undocumented)<br>
    /// - On success, responds with [`QueryOutputTransformOutput`](crate::operation::query_output_transform::QueryOutputTransformOutput) with field(s):
    ///   - [`transformed_output(Option<aws_sdk_dynamodb::operation::query::QueryOutput>)`](crate::operation::query_output_transform::QueryOutputTransformOutput::transformed_output): (undocumented)
    /// - On failure, responds with [`SdkError<QueryOutputTransformError>`](crate::operation::query_output_transform::QueryOutputTransformError)
    pub fn query_output_transform(
        &self,
    ) -> crate::operation::query_output_transform::builders::QueryOutputTransformFluentBuilder {
        crate::operation::query_output_transform::builders::QueryOutputTransformFluentBuilder::new(
            self.clone(),
        )
    }
}
