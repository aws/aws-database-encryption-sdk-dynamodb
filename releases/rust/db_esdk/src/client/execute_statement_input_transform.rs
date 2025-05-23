// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
impl crate::client::Client {
    /// Constructs a fluent builder for the [`ExecuteStatementInputTransform`](crate::operation::execute_statement_input_transform::builders::ExecuteStatementInputTransformFluentBuilder) operation.
    ///
    /// - The fluent builder is configurable:
    ///   - [`sdk_input(impl Into<Option<aws_sdk_dynamodb::operation::execute_statement::ExecuteStatementInput>>)`](crate::operation::execute_statement_input_transform::builders::ExecuteStatementInputTransformFluentBuilder::sdk_input) / [`set_sdk_input(Option<aws_sdk_dynamodb::operation::execute_statement::ExecuteStatementInput>)`](crate::operation::execute_statement_input_transform::builders::ExecuteStatementInputTransformFluentBuilder::set_sdk_input): (undocumented)<br>
    /// - On success, responds with [`ExecuteStatementInputTransformOutput`](crate::operation::execute_statement_input_transform::ExecuteStatementInputTransformOutput) with field(s):
    ///   - [`transformed_input(Option<aws_sdk_dynamodb::operation::execute_statement::ExecuteStatementInput>)`](crate::operation::execute_statement_input_transform::ExecuteStatementInputTransformOutput::transformed_input): (undocumented)
    /// - On failure, responds with [`SdkError<ExecuteStatementInputTransformError>`](crate::operation::execute_statement_input_transform::ExecuteStatementInputTransformError)
    pub fn execute_statement_input_transform(&self) -> crate::operation::execute_statement_input_transform::builders::ExecuteStatementInputTransformFluentBuilder{
        crate::operation::execute_statement_input_transform::builders::ExecuteStatementInputTransformFluentBuilder::new(self.clone())
    }
}
