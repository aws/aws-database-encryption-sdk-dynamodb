// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
impl crate::client::Client {
    /// Constructs a fluent builder for the [`ExecuteStatementOutputTransform`](crate::operation::execute_statement_output_transform::builders::ExecuteStatementOutputTransformFluentBuilder) operation.
    ///
    /// - The fluent builder is configurable:
    ///   - [`original_input(impl Into<Option<aws_sdk_dynamodb::operation::execute_statement::ExecuteStatementInput>>)`](crate::operation::execute_statement_output_transform::builders::ExecuteStatementOutputTransformFluentBuilder::original_input) / [`set_original_input(Option<aws_sdk_dynamodb::operation::execute_statement::ExecuteStatementInput>)`](crate::operation::execute_statement_output_transform::builders::ExecuteStatementOutputTransformFluentBuilder::set_original_input): (undocumented)<br>
    ///   - [`sdk_output(impl Into<Option<aws_sdk_dynamodb::operation::execute_statement::ExecuteStatementOutput>>)`](crate::operation::execute_statement_output_transform::builders::ExecuteStatementOutputTransformFluentBuilder::sdk_output) / [`set_sdk_output(Option<aws_sdk_dynamodb::operation::execute_statement::ExecuteStatementOutput>)`](crate::operation::execute_statement_output_transform::builders::ExecuteStatementOutputTransformFluentBuilder::set_sdk_output): (undocumented)<br>
    /// - On success, responds with [`ExecuteStatementOutputTransformOutput`](crate::operation::execute_statement_output_transform::ExecuteStatementOutputTransformOutput) with field(s):
    ///   - [`transformed_output(Option<aws_sdk_dynamodb::operation::execute_statement::ExecuteStatementOutput>)`](crate::operation::execute_statement_output_transform::ExecuteStatementOutputTransformOutput::transformed_output): (undocumented)
    /// - On failure, responds with [`SdkError<ExecuteStatementOutputTransformError>`](crate::operation::execute_statement_output_transform::ExecuteStatementOutputTransformError)
    pub fn execute_statement_output_transform(&self) -> crate::operation::execute_statement_output_transform::builders::ExecuteStatementOutputTransformFluentBuilder{
        crate::operation::execute_statement_output_transform::builders::ExecuteStatementOutputTransformFluentBuilder::new(self.clone())
    }
}
