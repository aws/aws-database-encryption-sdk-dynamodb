// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
impl crate::client::Client {
    /// Constructs a fluent builder for the [`QueryInputTransform`](crate::operation::query_input_transform::builders::QueryInputTransformFluentBuilder) operation.
    ///
    /// - The fluent builder is configurable:
    ///   - [`sdk_input(impl Into<Option<aws_sdk_dynamodb::operation::query::QueryInput>>)`](crate::operation::query_input_transform::builders::QueryInputTransformFluentBuilder::sdk_input) / [`set_sdk_input(Option<aws_sdk_dynamodb::operation::query::QueryInput>)`](crate::operation::query_input_transform::builders::QueryInputTransformFluentBuilder::set_sdk_input): (undocumented)<br>
    /// - On success, responds with [`QueryInputTransformOutput`](crate::operation::query_input_transform::QueryInputTransformOutput) with field(s):
    ///   - [`transformed_input(Option<aws_sdk_dynamodb::operation::query::QueryInput>)`](crate::operation::query_input_transform::QueryInputTransformOutput::transformed_input): (undocumented)
    /// - On failure, responds with [`SdkError<QueryInputTransformError>`](crate::operation::query_input_transform::QueryInputTransformError)
    pub fn query_input_transform(
        &self,
    ) -> crate::operation::query_input_transform::builders::QueryInputTransformFluentBuilder {
        crate::operation::query_input_transform::builders::QueryInputTransformFluentBuilder::new(
            self.clone(),
        )
    }
}
