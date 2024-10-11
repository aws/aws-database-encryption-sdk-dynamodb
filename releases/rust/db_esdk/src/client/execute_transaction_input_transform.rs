// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
impl crate::client::Client {
    /// Constructs a fluent builder for the [`ExecuteTransactionInputTransform`](crate::operation::execute_transaction_input_transform::builders::ExecuteTransactionInputTransformFluentBuilder) operation.
    ///
    /// - The fluent builder is configurable:
    ///   - [`sdk_input(impl Into<Option<aws_sdk_dynamodb::operation::execute_transaction::ExecuteTransactionInput>>)`](crate::operation::execute_transaction_input_transform::builders::ExecuteTransactionInputTransformFluentBuilder::sdk_input) / [`set_sdk_input(Option<aws_sdk_dynamodb::operation::execute_transaction::ExecuteTransactionInput>)`](crate::operation::execute_transaction_input_transform::builders::ExecuteTransactionInputTransformFluentBuilder::set_sdk_input): (undocumented)<br>
    /// - On success, responds with [`ExecuteTransactionInputTransformOutput`](crate::operation::execute_transaction_input_transform::ExecuteTransactionInputTransformOutput) with field(s):
    ///   - [`transformed_input(Option<aws_sdk_dynamodb::operation::execute_transaction::ExecuteTransactionInput>)`](crate::operation::execute_transaction_input_transform::ExecuteTransactionInputTransformOutput::transformed_input): (undocumented)
    /// - On failure, responds with [`SdkError<ExecuteTransactionInputTransformError>`](crate::operation::execute_transaction_input_transform::ExecuteTransactionInputTransformError)
    pub fn execute_transaction_input_transform(&self) -> crate::operation::execute_transaction_input_transform::builders::ExecuteTransactionInputTransformFluentBuilder{
        crate::operation::execute_transaction_input_transform::builders::ExecuteTransactionInputTransformFluentBuilder::new(self.clone())
    }
}
