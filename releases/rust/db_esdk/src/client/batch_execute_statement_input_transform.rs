// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
impl crate::client::Client {
    /// Constructs a fluent builder for the [`BatchExecuteStatementInputTransform`](crate::operation::batch_execute_statement_input_transform::builders::BatchExecuteStatementInputTransformFluentBuilder) operation.
    ///
    /// - The fluent builder is configurable:
    ///   - [`sdk_input(impl Into<Option<aws_sdk_dynamodb::operation::batch_execute_statement::BatchExecuteStatementInput>>)`](crate::operation::batch_execute_statement_input_transform::builders::BatchExecuteStatementInputTransformFluentBuilder::sdk_input) / [`set_sdk_input(Option<aws_sdk_dynamodb::operation::batch_execute_statement::BatchExecuteStatementInput>)`](crate::operation::batch_execute_statement_input_transform::builders::BatchExecuteStatementInputTransformFluentBuilder::set_sdk_input): (undocumented)<br>
    /// - On success, responds with [`BatchExecuteStatementInputTransformOutput`](crate::operation::batch_execute_statement_input_transform::BatchExecuteStatementInputTransformOutput) with field(s):
    ///   - [`transformed_input(Option<aws_sdk_dynamodb::operation::batch_execute_statement::BatchExecuteStatementInput>)`](crate::operation::batch_execute_statement_input_transform::BatchExecuteStatementInputTransformOutput::transformed_input): (undocumented)
    /// - On failure, responds with [`SdkError<BatchExecuteStatementInputTransformError>`](crate::operation::batch_execute_statement_input_transform::BatchExecuteStatementInputTransformError)
    pub fn batch_execute_statement_input_transform(&self) -> crate::operation::batch_execute_statement_input_transform::builders::BatchExecuteStatementInputTransformFluentBuilder{
        crate::operation::batch_execute_statement_input_transform::builders::BatchExecuteStatementInputTransformFluentBuilder::new(self.clone())
    }
}
