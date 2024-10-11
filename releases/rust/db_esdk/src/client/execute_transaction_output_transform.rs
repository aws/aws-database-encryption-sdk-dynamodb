// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
impl crate::client::Client {
    /// Constructs a fluent builder for the [`ExecuteTransactionOutputTransform`](crate::operation::execute_transaction_output_transform::builders::ExecuteTransactionOutputTransformFluentBuilder) operation.
    ///
    /// - The fluent builder is configurable:
    ///   - [`original_input(impl Into<Option<aws_sdk_dynamodb::operation::execute_transaction::ExecuteTransactionInput>>)`](crate::operation::execute_transaction_output_transform::builders::ExecuteTransactionOutputTransformFluentBuilder::original_input) / [`set_original_input(Option<aws_sdk_dynamodb::operation::execute_transaction::ExecuteTransactionInput>)`](crate::operation::execute_transaction_output_transform::builders::ExecuteTransactionOutputTransformFluentBuilder::set_original_input): (undocumented)<br>
    ///   - [`sdk_output(impl Into<Option<aws_sdk_dynamodb::operation::execute_transaction::ExecuteTransactionOutput>>)`](crate::operation::execute_transaction_output_transform::builders::ExecuteTransactionOutputTransformFluentBuilder::sdk_output) / [`set_sdk_output(Option<aws_sdk_dynamodb::operation::execute_transaction::ExecuteTransactionOutput>)`](crate::operation::execute_transaction_output_transform::builders::ExecuteTransactionOutputTransformFluentBuilder::set_sdk_output): (undocumented)<br>
    /// - On success, responds with [`ExecuteTransactionOutputTransformOutput`](crate::operation::execute_transaction_output_transform::ExecuteTransactionOutputTransformOutput) with field(s):
    ///   - [`transformed_output(Option<aws_sdk_dynamodb::operation::execute_transaction::ExecuteTransactionOutput>)`](crate::operation::execute_transaction_output_transform::ExecuteTransactionOutputTransformOutput::transformed_output): (undocumented)
    /// - On failure, responds with [`SdkError<ExecuteTransactionOutputTransformError>`](crate::operation::execute_transaction_output_transform::ExecuteTransactionOutputTransformError)
    pub fn execute_transaction_output_transform(&self) -> crate::operation::execute_transaction_output_transform::builders::ExecuteTransactionOutputTransformFluentBuilder{
        crate::operation::execute_transaction_output_transform::builders::ExecuteTransactionOutputTransformFluentBuilder::new(self.clone())
    }
}
